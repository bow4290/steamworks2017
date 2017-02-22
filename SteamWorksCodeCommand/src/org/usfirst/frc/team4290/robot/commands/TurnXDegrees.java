package org.usfirst.frc.team4290.robot.commands;

import org.usfirst.frc.team4290.robot.Robot;
import org.usfirst.frc.team4290.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *      This may be referenced for autonomous later.
 */

public class TurnXDegrees extends Command {
	double currentRobotAngle=0.0;
	double goToAngle=0.0;
	boolean isFinished = false;

    public TurnXDegrees(double goToAngle) {
    	this.goToAngle = goToAngle;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }
    

    // Called just before this Command runs the first time
    protected void initialize() {
    	currentRobotAngle = RobotMap.turningGyro.getAngle() % 360;
    	
    	//Reset the goto angle to become the ending angle (adding the new angle to the current one from a sensor)
    	//ex. current = 200, new angle = -15, 200 + (-15) = 185 mod 360 = 185.
    	goToAngle = (currentRobotAngle + goToAngle) % 360;
    }
    

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	//This tells the robot to move right or left, depending on the values from the camera.
    	//If the sensor's direction is > the current direction, the robot will move right. Vice versa for moving left.
    	
//    	if (goToAngle > currentRobotAngle){
//    		while (goToAngle > RobotMap.turningGyro.getAngle() % 360){
    			Robot.driveTrain.turnRight(1);
        		SmartDashboard.putNumber("right turn Angle", goToAngle);
        		SmartDashboard.putNumber("Current Angle", RobotMap.turningGyro.getAngle() % 360);


//    		}
//    		isFinished = true;
//    	}else if (goToAngle < currentRobotAngle){
//    		while (goToAngle < RobotMap.turningGyro.getAngle() % 360){
//    			Robot.driveTrain.turnLeft();
//        		SmartDashboard.putNumber("left turn Angle", goToAngle);
//
//    		}
//    		isFinished = true;
//    	}			
    	
    	SmartDashboard.putNumber("FinalAngle",goToAngle);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

