package org.usfirst.frc.team4290.robot;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	public static VictorSP shooterMotor;
	public static Jaguar climberMotor;
	public static Servo climberDoorMotor;
	public static Talon fuelRollerMotor;
	
	public static void init(){
		shooterMotor = new VictorSP(0);
		climberMotor= new Jaguar(0);
		climberDoorMotor = new Servo(0);
		fuelRollerMotor = new Talon(0);
		
	}
}
