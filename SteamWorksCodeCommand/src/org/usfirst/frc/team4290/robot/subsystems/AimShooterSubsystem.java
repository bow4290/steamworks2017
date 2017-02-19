package org.usfirst.frc.team4290.robot.subsystems;

import org.usfirst.frc.team4290.robot.RobotMap;
import org.usfirst.frc.team4290.robot.commands.AimShooterAngleByYCommand;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class AimShooterSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
//    	setDefaultCommand(new AimShooterAngleByYCommand());
    }
    
    public void aimShooter(double speed){
		RobotMap.shooterAngleMotor.set(speed);
	}
}

