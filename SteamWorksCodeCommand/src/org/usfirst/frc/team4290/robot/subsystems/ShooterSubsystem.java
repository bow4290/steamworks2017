package org.usfirst.frc.team4290.robot.subsystems;

import org.usfirst.frc.team4290.robot.RobotMap;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShooterSubsystem extends Subsystem {
	// public void shootFullSpeed(){
	// RobotMap.shooterMotor.set(1.0);
	// }
	// public void shootMidSpeed(){
	// RobotMap.shooterMotor.set(0.6);
	// }
	// public void shootLowSpeed(){
	// RobotMap.shooterMotor.set(0.3);
	// }
	public void shootXSpeed(double speed) {
		RobotMap.shooterMotorOne.set(speed);
		RobotMap.shooterMotorTwo.set(speed);
	}
	
	public void rotateShooter(double speed){
		RobotMap.aimShooterMotor.set(speed);
	}
	public void changeShooterAngle(int direction){
		if (direction>0){
			RobotMap.shooterAngleMotor.set(0.3);
		} else if (direction<0){
			RobotMap.shooterAngleMotor.set(-0.3);
		} else {
			RobotMap.shooterAngleMotor.set(0);
		}
	}
	

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
