package org.usfirst.frc.team4290.robot.commands;

import org.usfirst.frc.team4290.robot.Robot;
import org.usfirst.frc.team4290.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TurnXDegrees extends Command {
	double currentRobotAngle=0.0;
	double goToAngle=0.0;

    public TurnXDegrees(double goToAngle) {
    	this.goToAngle = goToAngle;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	currentRobotAngle = RobotMap.turningGyro.getAngle() % 360;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	while (currentRobotAngle + goToAngle > RobotMap.turningGyro.getAngle()){
    		Robot.driveTrain.turnRight();
    		SmartDashboard.putNumber("Real-time Angle", RobotMap.turningGyro.getAngle());
//    	}
    	SmartDashboard.putNumber("FinalAngle",goToAngle);
    	
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
public void setGoToAngle(double goToAngle){
	this.goToAngle = goToAngle;
}
}

