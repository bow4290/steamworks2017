package org.usfirst.frc.team4290.robot.subsystems;

import org.usfirst.frc.team4290.robot.RobotMap;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearLift extends Subsystem {
	public void gearLiftUp(){
		RobotMap.gearLiftMotor.set(0.4);;
	}
	public void gearLiftDown(){
		RobotMap.gearLiftMotor.set(-0.4);
	}
	public void stop(){
		RobotMap.gearLiftMotor.set(0);
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

