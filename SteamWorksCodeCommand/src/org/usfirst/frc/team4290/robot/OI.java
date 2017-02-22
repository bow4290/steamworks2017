package org.usfirst.frc.team4290.robot;

import org.usfirst.frc.team4290.robot.commands.FuelPickupCommand;
import org.usfirst.frc.team4290.robot.commands.RotateShooterByXCommand;
import org.usfirst.frc.team4290.robot.commands.AimShooterAngleByYCommand;
import org.usfirst.frc.team4290.robot.commands.ClimbDownCommand;
import org.usfirst.frc.team4290.robot.commands.ClimbUpCommand;
import org.usfirst.frc.team4290.robot.commands.DropGearWithCameraCommand;
import org.usfirst.frc.team4290.robot.commands.FuelConveyerPickupCommand;
import org.usfirst.frc.team4290.robot.commands.TurnXDegrees;
import org.usfirst.frc.team4290.robot.commands.dropGearCommand;
import org.usfirst.frc.team4290.robot.commands.liftGearCommand;
import org.usfirst.frc.team4290.robot.commands.shootFuelByXCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;


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
	public JoystickButton shooterAngleUpButton;
	public JoystickButton shooterAngleDownButton;
	public JoystickButton climberUpButton;
	public JoystickButton climberDownButton;
	public JoystickButton useGearCameraButton;
	public JoystickButton cancelGearCameraButton;
	public JoystickButton fuelConveyerDownButton;
	
	private DropGearWithCameraCommand dropGearWithCamera;
	
	public OI(){
		//Driver Commands (Driver 1)
		rightJoystick = new Joystick(0);
		leftJoystick = new Joystick(1);
		turnRightButton = new JoystickButton(rightJoystick, 7);
//		turnLeftButton = new JoystickButton(rightJoystick, 6);
		turnRightButton.whileHeld(new TurnXDegrees(90));
		//turnLeftButton.whileHeld(new TurnXDegrees(180));
		climberUpButton = new JoystickButton(rightJoystick, 5);
		climberDownButton = new JoystickButton(rightJoystick, 4);
		climberUpButton.whileHeld(new ClimbUpCommand());
		climberDownButton.whileHeld(new ClimbDownCommand());
		gearUpButton = new JoystickButton(rightJoystick, 3);
		gearDownButton = new JoystickButton(rightJoystick, 2);
		gearUpButton.whileHeld(new liftGearCommand());
		gearDownButton.whileHeld(new dropGearCommand());
		
		useGearCameraButton = new JoystickButton(rightJoystick, 10);
		useGearCameraButton.whenPressed(getDropGearWithCamera());
		cancelGearCameraButton = new JoystickButton(rightJoystick, 11);
		cancelGearCameraButton.cancelWhenPressed(getDropGearWithCamera());
		
		//Shooter Commands (Driver 2)
		shootLowButton = new JoystickButton(leftJoystick, 4);
		shootMidButton = new JoystickButton(leftJoystick, 3);
		shootFullButton = new JoystickButton(leftJoystick, 5);	
		shootLowButton.whileHeld(new shootFuelByXCommand(0.3));
		shootMidButton.whileHeld(new shootFuelByXCommand(0.6));
		shootFullButton.whileHeld(new shootFuelByXCommand(1.0));
		rotateShooterLeftButton = new JoystickButton(leftJoystick, 8);
//		rotateShooterLeftButton.whileHeld(new RotateShooterByXCommand(-0.1));
		rotateShooterRightButton = new JoystickButton(leftJoystick, 9);
//		rotateShooterRightButton.whileHeld(new RotateShooterByXCommand(0.1));
		fuelPickupButton = new JoystickButton(leftJoystick, 1);
		fuelPickupButton.whileHeld(new FuelPickupCommand());
		fuelConveyerOnButton = new JoystickButton(leftJoystick, 2);
		fuelConveyerOnButton.whileHeld(new FuelConveyerPickupCommand(1.0));	
		fuelConveyerDownButton = new JoystickButton(leftJoystick, 7);
		fuelConveyerDownButton.whileHeld(new FuelConveyerPickupCommand(-1.0));
		shooterAngleDownButton = new JoystickButton(leftJoystick, 10);
		shooterAngleDownButton.whileHeld(new AimShooterAngleByYCommand(-1));
		shooterAngleUpButton = new JoystickButton(leftJoystick, 11);
		shooterAngleUpButton.whileHeld(new AimShooterAngleByYCommand(1));
		
	}
	
	private DropGearWithCameraCommand getDropGearWithCamera() {
		if (null == dropGearWithCamera) {
			dropGearWithCamera = new DropGearWithCameraCommand();
		}
		return dropGearWithCamera;
	}
}