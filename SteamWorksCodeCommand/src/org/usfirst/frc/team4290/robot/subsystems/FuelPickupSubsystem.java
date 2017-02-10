package org.usfirst.frc.team4290.robot.subsystems;

import org.usfirst.frc.team4290.robot.RobotMap;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class FuelPickupSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void pickupFuel(){
    	RobotMap.fuelPickupMotor.set(Relay.Value.kForward);
    }
    
    public void stop(){
    	RobotMap.fuelPickupMotor.set(Relay.Value.kOff);
    }
}

