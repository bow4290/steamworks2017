package org.usfirst.frc.team4290.robot.subsystems;

import org.usfirst.frc.team4290.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ClimbSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void closeClimbDoorAndClimbUp() {
    	while (RobotMap.climberDoorMotor.getAngle() != 0.0) {
			RobotMap.climberDoorMotor.setAngle(0.0);
		}
    	RobotMap.climberMotor.set(0.5);
    }
    public void openClimbDoor() {
    	RobotMap.climberDoorMotor.setAngle(90.0);
    }
    public void climbDown() {
    	RobotMap.climberMotor.set(-0.3);
    }
}

