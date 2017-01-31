package org.usfirst.frc.team4290.robot.commands;

import org.usfirst.frc.team4290.robot.Robot;
import org.usfirst.frc.team4290.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Turn180DegreesCommand extends Command {
	
	//New fresh angle to start with. Not as fresh as 90.
	double currentAngleNow180 = 0.0;
	

    public Turn180DegreesCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	//This gets the angle of the robot before the robot turns
    	currentAngleNow180 = RobotMap.turningMicroGyro.getAngle() % 360;
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	// Call the turn; Turn as long as this is true; Make sure it is turning when it needs to and not when it's backwards for example
//    	while (currentAngleNow180 - 180 < RobotMap.turningMicroGyro.getAngle()){
    		Robot.driveTrain.turnBotRight();
//    	}
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
