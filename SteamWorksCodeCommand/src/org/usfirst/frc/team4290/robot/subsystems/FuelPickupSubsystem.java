package org.usfirst.frc.team4290.robot.subsystems;

import java.time.format.ResolverStyle;

import org.usfirst.frc.team4290.robot.RobotMap;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
    	RobotMap.fuelPickupMotor.set(1);
    }
    
    public void reverseFuel(){
    	RobotMap.fuelPickupMotor.set(-1.0);
    }
    
    public void stop(){
    	RobotMap.fuelPickupMotor.set(0);
    	SmartDashboard.putString("PICKUP", "TURN OFF");

    }
}

