package org.usfirst.frc.team4290.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	//Establish (name) the drive train
	public static RobotDrive driveTrainRobotDrive4;
	//Establish (name) motor variables
	public static SpeedController driveTrainRightMotorOne;
	public static SpeedController driveTrainRightMotorTwo;
	public static SpeedController driveTrainLeftMotorOne;
	public static SpeedController driveTrainLeftMotorTwo;
	
	//Establish (name) for the compressor
	public static Compressor pneumaticsCompressor;
	
	
	public static void init(){
		//Initializing (making them useful) motor variables
		driveTrainRightMotorOne = new Talon(2);
		LiveWindow.addActuator("DriveTrain", "RightWheels1", (LiveWindowSendable) driveTrainRightMotorOne);
		driveTrainRightMotorTwo = new Talon(3);
		LiveWindow.addActuator("DriveTrain", "RightWheels2", (LiveWindowSendable) driveTrainRightMotorTwo);
		driveTrainLeftMotorOne = new Talon(4);
		LiveWindow.addActuator("DriveTrain", "LeftWheels1", (LiveWindowSendable) driveTrainLeftMotorOne);
		driveTrainLeftMotorTwo = new Talon(1);
		LiveWindow.addActuator("DriveTrain", "LeftWheels2", (LiveWindowSendable) driveTrainLeftMotorTwo);
		//Drive Train Motors
		driveTrainRobotDrive4 = new RobotDrive(driveTrainRightMotorOne, driveTrainRightMotorTwo, 
				driveTrainLeftMotorOne, driveTrainLeftMotorTwo);
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
