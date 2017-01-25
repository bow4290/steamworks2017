package org.usfirst.frc.team4290.robot.subsystems;

import org.usfirst.frc.team4290.robot.RobotMap;
import org.usfirst.frc.team4290.robot.commands.DriveWithJoysticks;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
	
	private final SpeedController driveRightMotorOne = RobotMap.driveTrainRightMotorOne;
	private final SpeedController driveRightMotorTwo = RobotMap.driveTrainRightMotorTwo;
	private final SpeedController driveLeftMotorOne = RobotMap.driveTrainLeftMotorOne;
	private final SpeedController driveLeftMotorTwo = RobotMap.driveTrainLeftMotorTwo;
	
	private final RobotDrive robotDrive4 = RobotMap.driveTrainRobotDrive4;
	
	
	//Joystick Inputs
	
	public void takeJostickInputs(Joystick right){
		robotDrive4.arcadeDrive(0,0, true);
	}
	
	
	
	public void stop() {
		
		robotDrive4.tankDrive(0, 0);
	
	}
	
	
	
	

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    	setDefaultCommand(new DriveWithJoysticks());
    }
}

