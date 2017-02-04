package org.usfirst.frc.team4290.robot;

import org.usfirst.frc.team4290.robot.commands.FuelPickupCommand;
import org.usfirst.frc.team4290.robot.commands.RotateShooterByXCommand;
import org.usfirst.frc.team4290.robot.commands.FuelConveyerPickupCommand;
import org.usfirst.frc.team4290.robot.commands.TurnXDegrees;
import org.usfirst.frc.team4290.robot.commands.dropGearCommand;
import org.usfirst.frc.team4290.robot.commands.liftGearCommand;
import org.usfirst.frc.team4290.robot.commands.shootFuelByXCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public Joystick rightJoystick;
	public Joystick leftJoystick;
	public JoystickButton turnRightButton;
	public JoystickButton turnLeftButton;
	public JoystickButton gearUpButton;
	public JoystickButton gearDownButton;
	public JoystickButton shootFullButton;
	public JoystickButton shootMidButton;
	public JoystickButton shootLowButton;
	public JoystickButton fuelPickupButton;
	public JoystickButton fuelConveyerOnButton;
	public JoystickButton rotateShooterLeftButton;
	public JoystickButton rotateShooterRightButton;
	
	public OI(){
		//Driver Commands (Driver 1)
		rightJoystick = new Joystick(0);
		leftJoystick = new Joystick(1);
		turnRightButton = new JoystickButton(rightJoystick, 6);
		turnLeftButton = new JoystickButton(rightJoystick, 5);
		turnRightButton.whileHeld(new TurnXDegrees(90));
		turnLeftButton.whileHeld(new TurnXDegrees(180));
		gearUpButton = new JoystickButton(rightJoystick, 3);
		gearDownButton = new JoystickButton(rightJoystick, 2);
		gearUpButton.whileHeld(new liftGearCommand());
		gearDownButton.whileHeld(new dropGearCommand());
		
		//Shooter Commands (Driver 2)
		shootLowButton = new JoystickButton(leftJoystick, 4);
		shootMidButton = new JoystickButton(leftJoystick, 3);
		shootFullButton = new JoystickButton(leftJoystick, 5);	
		shootLowButton.whileHeld(new shootFuelByXCommand(0.3));
		shootMidButton.whileHeld(new shootFuelByXCommand(0.6));
		shootFullButton.whileHeld(new shootFuelByXCommand(1.0));
/*		rotateShooterLeftButton = new JoystickButton(leftJoystick, 0);
		rotateShooterLeftButton.whileHeld(new RotateShooterByXCommand(-0.5));
		rotateShooterRightButton = new JoystickButton(leftJoystick, 0);
		rotateShooterRightButton.whileHeld(new RotateShooterByXCommand(0.5));*/
		fuelPickupButton = new JoystickButton(leftJoystick, 0);
		fuelPickupButton.whileHeld(new FuelPickupCommand());
		fuelConveyerOnButton = new JoystickButton(leftJoystick, 2);
		fuelConveyerOnButton.whileHeld(new FuelConveyerPickupCommand());	
		
	}
}