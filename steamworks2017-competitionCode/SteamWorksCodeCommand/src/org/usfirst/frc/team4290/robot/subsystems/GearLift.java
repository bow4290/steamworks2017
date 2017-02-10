package org.usfirst.frc.team4290.robot.subsystems;

import org.usfirst.frc.team4290.robot.RobotMap;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearLift extends Subsystem {
	public void gearLiftUp(){
		RobotMap.gearLiftMotor.set(Relay.Value.kForward);
	}
	public void gearLiftDown(){
		RobotMap.gearLiftMotor.set(Relay.Value.kReverse);
	}
	public void stop(){
		RobotMap.gearLiftMotor.set(Relay.Value.kOff);
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

