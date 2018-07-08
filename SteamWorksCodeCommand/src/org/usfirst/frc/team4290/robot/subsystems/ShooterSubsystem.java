package org.usfirst.frc.team4290.robot.subsystems;

import org.usfirst.frc.team4290.robot.RobotMap;
import org.usfirst.frc.team4290.robot.commands.AimShooterAngleByYCommand;
import org.usfirst.frc.team4290.robot.commands.RotateShooterByXCommand;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShooterSubsystem extends Subsystem {
	
	public void shootXSpeed(double speed) {
		RobotMap.shooterMotorOne.set(speed);
		RobotMap.shooterMotorTwo.set(speed);
	}
	
	public void rotateShooter(double speed){
		RobotMap.rotateShooterMotor.set(speed);
	}
	

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {

		setDefaultCommand(new RotateShooterByXCommand(0));
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
