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
	public static Relay gearLiftMotor;
	public static Spark shooterMotorOne;
	public static Spark shooterMotorTwo;
	public static Jaguar aimShooterMotor;
	public static VictorSP climberMotor;
	public static Relay fuelPickupMotor;
	public static Jaguar fuelConveyerMotor;

	public static void init() {

		driveTrainLeftMotorOne = new Talon(4);
		driveTrainLeftMotorTwo = new Talon(1);
		driveTrainRightMotorOne = new Talon(2);
		driveTrainRightMotorTwo = new Talon(3);

		driveTrain = new RobotDrive(driveTrainRightMotorTwo, driveTrainRightMotorOne, driveTrainLeftMotorTwo,
				driveTrainLeftMotorOne);
		turningGyro = new ADXRS450_Gyro();
		gearLiftMotor = new Relay(0);
		shooterMotorOne = new Spark(0);
		shooterMotorTwo = new Spark(0);
		aimShooterMotor = new Jaguar(0);
		climberMotor = new VictorSP(0);
		fuelPickupMotor = new Relay(0);
		fuelConveyerMotor = new Jaguar(0);

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
