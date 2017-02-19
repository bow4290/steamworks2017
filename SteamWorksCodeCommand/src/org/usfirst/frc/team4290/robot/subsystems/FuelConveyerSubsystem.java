package org.usfirst.frc.team4290.robot.subsystems;

import org.usfirst.frc.team4290.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class FuelConveyerSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	
	public void fuelConveyerPickup(double speed){
		RobotMap.fuelConveyerMotor.set(speed);
	}
	
	public void stop(){
		RobotMap.fuelConveyerMotor.set(0);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

