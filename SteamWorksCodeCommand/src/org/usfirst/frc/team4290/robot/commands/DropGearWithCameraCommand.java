package org.usfirst.frc.team4290.robot.commands;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

import edu.wpi.cscore.AxisCamera;
import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DropGearWithCameraCommand extends Command {

	Thread visionThread;
	
    public DropGearWithCameraCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	// Vision Code for the camera
    			visionThread = new Thread(() -> {

    				// Get the Axis camera from CameraServer
    				AxisCamera camera = CameraServer.getInstance().addAxisCamera("axis-camera.local");
    				// set the resolution
    				camera.setResolution(640, 480);

    				// Get a CvSink. This will capture Mats from the camera
    				CvSink cvSink = CameraServer.getInstance().getVideo();
    				// Set up a CvSource. This will send images back to the Dashboard
    				CvSource outputStream = CameraServer.getInstance().putVideo("Rectangle", 640, 480);

    				// Mats take up a lot of space in memory, so this will be computed
    				// by a raspberry pie. But to save space, it is important to recycle
    				// this Mat.
    				Mat mat = new Mat();

    				// This cannot be 'true'. The program will never exit if it is. THis
    				// lets the robot stop this thread when restarting robot code or
    				// deploying.
    				while (!Thread.interrupted()) {
    					// Tell the CvSink to grab a frame from the camera and put it in
    					// the source mat. If there is an error, notify the output.
    					if (cvSink.grabFrame(mat) == 0) {
    						// Send the output the error.
    						outputStream.notifyError(cvSink.getError());
    						// skip the rest of the current iteration
    						continue;
    					}
    					// Put the rectangle on the image
    					Imgproc.rectangle(mat, new Point(100, 100), new Point(400, 400), new Scalar(255, 255, 255), 5);
    					// Give the output stream a new image to display
    					outputStream.putFrame(mat);
    				}
    			});
    			visionThread.setDaemon(true);
    			visionThread.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
