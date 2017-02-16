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
	public static ADXRS450_Gyro turningGyro;
	public static Jaguar gearLiftMotor;
	public static Jaguar shooterMotorOne;
	public static Spark shooterMotorTwo;
	public static Jaguar aimShooterMotor;
	public static Spark climberMotor;
	public static VictorSP fuelPickupMotor;
	public static Jaguar fuelConveyerMotor;
	public static Jaguar shooterAngleMotor;

	public static void init() {

		driveTrainLeftMotorOne = new Talon(4);
		driveTrainLeftMotorTwo = new Talon(13);
		driveTrainRightMotorOne = new Talon(5);
		driveTrainRightMotorTwo = new Talon(12);

		driveTrain = new RobotDrive(driveTrainRightMotorTwo, driveTrainRightMotorOne, driveTrainLeftMotorTwo,
				driveTrainLeftMotorOne);
		turningGyro = new ADXRS450_Gyro();
		gearLiftMotor = new Jaguar(6);
		shooterMotorOne = new Jaguar(1);
//		shooterMotorTwo = new Spark(0);
		aimShooterMotor = new Jaguar(0);
		climberMotor = new Spark(8);
		fuelPickupMotor = new VictorSP(2);
		fuelConveyerMotor = new Jaguar(7);
		shooterAngleMotor = new Jaguar(3);

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
