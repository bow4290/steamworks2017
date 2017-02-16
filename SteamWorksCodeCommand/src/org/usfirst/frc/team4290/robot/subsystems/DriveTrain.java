package org.usfirst.frc.team4290.robot.subsystems;

import org.usfirst.frc.team4290.robot.RobotMap;
import org.usfirst.frc.team4290.robot.commands.DriveWithJoysticks;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand(new DriveWithJoysticks());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void takeJoystickInputs(Joystick right){
    	RobotMap.driveTrain.arcadeDrive(speedBuffer(right.getY(), 0.4), right.getX());
    
    }
    
    private static double oldSpeed = 0.0;

	private static double speedBuffer(double joy, double perc) {
		double addSpeed = Math.abs(oldSpeed) * perc;
		if (Math.abs(joy - oldSpeed) < addSpeed + 0.01) {
			oldSpeed = joy;
		} else if (Math.abs(oldSpeed) <= perc * 10) {
			oldSpeed += 0.01 * Math.signum(joy - oldSpeed);
		} else {
			oldSpeed += addSpeed * Math.signum(joy - oldSpeed);
		}
		return oldSpeed;
	}

    
    public void turnRight(){
    	RobotMap.driveTrain.arcadeDrive(0, 0.8);
    }
    public void turnLeft(){
    	RobotMap.driveTrain.arcadeDrive(0, -0.8);
    }
    public void stop(){
    	RobotMap.driveTrain.arcadeDrive(0, 0);
    }
}

