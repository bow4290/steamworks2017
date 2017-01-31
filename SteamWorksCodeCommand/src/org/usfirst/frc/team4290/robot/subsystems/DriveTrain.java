package org.usfirst.frc.team4290.robot.subsystems;

import org.usfirst.frc.team4290.robot.Robot;
import org.usfirst.frc.team4290.robot.RobotMap;
import org.usfirst.frc.team4290.robot.commands.DriveWithJoysticks;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends Subsystem {
	
	private final SpeedController driveRightMotorOne = RobotMap.driveTrainRightMotorOne;
	private final SpeedController driveRightMotorTwo = RobotMap.driveTrainRightMotorTwo;
	private final SpeedController driveLeftMotorOne = RobotMap.driveTrainLeftMotorOne;
	private final SpeedController driveLeftMotorTwo = RobotMap.driveTrainLeftMotorTwo;
	
	
	
	//Joystick Inputs for driving the robot
	
	public void takeJostickInputs(Joystick right){
//		RobotMap.driveTrainRobotDrive4.arcadeDrive(right.getX(), right.getY(), true);
		RobotMap.driveTrainRobotDrive4.arcadeDrive(right, true);
	}
	
	
	//Joystick inputs to call the button for turning 90 degrees
	
	public void takeJoystickInputs(JoystickButton buttonSixforTurn90){
		RobotMap.driveTrainRobotDrive4.drive(1, -.2);
	}
	

	
	public void stop() {
		
		RobotMap.driveTrainRobotDrive4.arcadeDrive(0, 0);
	
	}
	
	//For command that turns the entire robot 90/180/x degrees to the left
	public void turnBotLeft(){
		RobotMap.driveTrainRobotDrive4.arcadeDrive(0, 0.7);
		SmartDashboard.putNumber("turningMicrogyro Angle Values" , RobotMap.turningMicroGyro.getAngle() % 360);

		
	}
	
	public void turnBotRight() {
		RobotMap.driveTrainRobotDrive4.arcadeDrive(0, -0.7);
		SmartDashboard.putNumber("turningMicrogyro Angle Values" , RobotMap.turningMicroGyro.getAngle() % 360);
	}
	

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    	setDefaultCommand(new DriveWithJoysticks());
    }
}

