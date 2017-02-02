package org.usfirst.frc.team4290.robot;

import org.usfirst.frc.team4290.robot.commands.TurnXDegrees;
import org.usfirst.frc.team4290.robot.commands.dropGearCommand;
import org.usfirst.frc.team4290.robot.commands.liftGearCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public Joystick rightJoystick;
	public JoystickButton turnRightButton;
	public JoystickButton turnLeftButton;
	public JoystickButton gearUpButton;
	public JoystickButton gearDownButton;
	
	public OI(){
		rightJoystick = new Joystick(0);
		turnRightButton = new JoystickButton(rightJoystick, 6);
		turnLeftButton = new JoystickButton(rightJoystick, 5);
		turnRightButton.whileHeld(new TurnXDegrees(90));
		turnLeftButton.whileHeld(new TurnXDegrees(180));
		gearUpButton = new JoystickButton(rightJoystick, 0);
		gearDownButton = new JoystickButton(rightJoystick, 0);
		gearUpButton.whileHeld(new liftGearCommand());
		gearDownButton.whileHeld(new dropGearCommand());
	}
	
}