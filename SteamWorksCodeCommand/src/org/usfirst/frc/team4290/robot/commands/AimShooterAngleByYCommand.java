package org.usfirst.frc.team4290.robot.commands;

import org.usfirst.frc.team4290.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AimShooterAngleByYCommand extends Command {

	private double speed;
    public AimShooterAngleByYCommand(double speed) {
    	this.speed = speed;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
//    	requires(Robot.aimShooterSubsystem);    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putNumber("Shoot Angle", speed);
//    	Robot.aimShooterSubsystem.aimShooter(Robot.oi.leftJoystick.getY() * 0.4);
    	Robot.aimShooterSubsystem.aimShooter(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.aimShooterSubsystem.aimShooter(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
