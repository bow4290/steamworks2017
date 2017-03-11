package org.usfirst.frc.team4290.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static RobotDrive driveTrain;

	public static SpeedController driveTrainRightMotorOne;
	public static SpeedController driveTrainRightMotorTwo;
	public static SpeedController driveTrainLeftMotorOne;
	public static SpeedController driveTrainLeftMotorTwo;
	
	//TODO
	//REPLACE BEFORE COMP 
	// test robot motor controllers
//	public static SpeedController testDriveRightMotorOne;
//	public static SpeedController testDriveRightMotorTwo;
//	public static SpeedController testDriveLeftMotorOne;
//	public static SpeedController testDriveLeftMotorTwo;
	
	public static ADXRS450_Gyro turningGyro;
	public static Jaguar gearLiftMotor;
	public static Jaguar shooterMotorOne;
//	public static Spark shooterMotorTwo;
	public static Jaguar rotateShooterMotor;
	public static Jaguar shooterAngleMotor;
	public static Spark climberMotor;
	public static VictorSP fuelPickupMotor;
	public static Spark fuelConveyerMotor;
//	public static Jaguar shooterAngleMotor;

	public static void init() {

		//TODO uncomment for COMP
		driveTrainLeftMotorOne = new Talon(4);
		driveTrainLeftMotorTwo = new Talon(11);
		driveTrainRightMotorOne = new Talon(5);
		driveTrainRightMotorTwo = new Talon(10);
		driveTrain = new RobotDrive(driveTrainRightMotorTwo, driveTrainRightMotorOne, driveTrainLeftMotorTwo,
				driveTrainLeftMotorOne);
		
		// TODO 
		// COMMENT OUT BEFOE COMP
		// use above motors for comp
//		testDriveRightMotorOne = new Jaguar(0);
//		testDriveRightMotorTwo = new Jaguar(1);
//		testDriveLeftMotorOne = new Spark(2);
//		testDriveLeftMotorTwo = new Spark(3);
//		driveTrain = new RobotDrive(testDriveLeftMotorOne, testDriveLeftMotorTwo, 
//				testDriveRightMotorOne, testDriveRightMotorTwo);
		
		turningGyro = new ADXRS450_Gyro();
		gearLiftMotor = new Jaguar(6);
		shooterMotorOne = new Jaguar(1);
//		shooterMotorTwo = new Spark(5);
		rotateShooterMotor = new Jaguar(0);
		shooterAngleMotor = new Jaguar(3);
		climberMotor = new Spark(8);
		fuelPickupMotor = new VictorSP(2);
		fuelConveyerMotor = new Spark(7);
//		shooterAngleMotor = new Jaguar(0);

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
