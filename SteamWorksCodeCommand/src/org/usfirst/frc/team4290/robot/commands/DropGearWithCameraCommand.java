package org.usfirst.frc.team4290.robot.commands;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team4290.robot.Robot;
import org.usfirst.frc.team4290.robot.RobotMap;
import org.usfirst.frc.team4290.robot.subsystems.GearPipeline;
import org.usfirst.frc.team4290.robot.subsystems.VisionPipelineSubystem;

import edu.wpi.cscore.AxisCamera;
import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.VisionThread;

/**
 *
 */
public class DropGearWithCameraCommand extends Command {

	private VisionThread visionThread;
	private double centerX = 0.0;
	private final Object imgLock = new Object();
	UsbCamera camera;
	private boolean isFinished = false;
	
    public DropGearWithCameraCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	isFinished = false;
    	
	    camera = CameraServer.getInstance().startAutomaticCapture();
	    camera.setResolution(640, 480);
	    
    	visionThread = new VisionThread(camera, new GearPipeline(), pipeline -> {
            if (!pipeline.findContoursOutput().isEmpty()) {
	        	if (pipeline.findContoursOutput().size() > 1) {
	                Rect rectOne = Imgproc.boundingRect(pipeline.findContoursOutput().get(0));
	                Rect rectTwo = Imgproc.boundingRect(pipeline.findContoursOutput().get(1));
					synchronized (imgLock) {
						double centerRectOne = rectOne.x + (rectOne.width / 2);
						double centerRectTwo = rectTwo.x + (rectTwo.width / 2);
	                    centerX = (centerRectOne + centerRectTwo) / 2;
	                }
	        	} else {
	                Rect rectOne = Imgproc.boundingRect(pipeline.findContoursOutput().get(0));
	                synchronized (imgLock) {
	                    centerX = rectOne.x + (rectOne.width / 2);
	                }
	        	}
	        }
        });
        visionThread.start();
    	
    	
    	// Vision Code for the camera
//    			visionThread = new Thread(() -> {
//
//    				// Get the Axis camera from CameraServer
////    				AxisCamera camera = CameraServer.getInstance().addAxisCamera("axis-camera.local");
//    			    UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
//    				// set the resolution
//    				camera.setResolution(640, 480);
//
//    				// Get a CvSink. This will capture Mats from the camera
//    				CvSink cvSink = CameraServer.getInstance().getVideo();
//    				// Set up a CvSource. This will send images back to the Dashboard
//    				CvSource outputStream = CameraServer.getInstance().putVideo("Rectangle", 640, 480);
//
//    				// Mats take up a lot of space in memory, so this will be computed
//    				// by a raspberry pie. But to save space, it is important to recycle
//    				// this Mat.
//    				Mat mat = new Mat();
//
//    				// This cannot be 'true'. The program will never exit if it is. THis
//    				// lets the robot stop this thread when restarting robot code or
//    				// deploying.
//    				while (!Thread.interrupted()) {
//    					// Tell the CvSink to grab a frame from the camera and put it in
//    					// the source mat. If there is an error, notify the output.
//    					if (cvSink.grabFrame(mat) == 0) {
//    						// Send the output the error.
//    						outputStream.notifyError(cvSink.getError());
//    						// skip the rest of the current iteration
//    						continue;
//    					}
//    					// Put the rectangle on the image
//    					Imgproc.rectangle(mat, new Point(100, 100), new Point(400, 400), new Scalar(255, 255, 255), 5);
//    					// Give the output stream a new image to display
//    					outputStream.putFrame(mat);
//    					
//    					Robot.visionPipeline.process(mat);
//    				}
//    			});
//    			visionThread.setDaemon(true);
//    			visionThread.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double centerX;
    	synchronized (imgLock) {
    		centerX = this.centerX;
    	}
    	double turn = centerX - (640.0 / 2);
    	
		SmartDashboard.putNumber("Center",centerX);
		SmartDashboard.putNumber("Turn by", turn);

    	
    	if (turn != 0.0) {
//        	Robot.driveTrain.driveTo(turn * 0.005);
		} else {
			SmartDashboard.putString("CENTER FOUND", "DONE");
			isFinished = true;
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	camera = null;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
    
    public void setIsFinished(boolean isFinished) {
    	this.isFinished = isFinished;
    }
}
