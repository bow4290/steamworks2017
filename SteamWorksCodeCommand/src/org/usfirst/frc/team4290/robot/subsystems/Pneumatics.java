package org.usfirst.frc.team4290.robot.subsystems;

import org.usfirst.frc.team4290.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pneumatics extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	// This is the compressor for the pneumatics
	private final Compressor compressor = RobotMap.pneumaticsCompressor;

	// These are the solenoids for the robot.
	// As of 1-19-17, there is not enough information about the pneumatics
	// system.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	// Be able to turn the compressor on and off.
	public void startCompressor() {
		compressor.start();
	}

	public void stopCompressor() {
		compressor.stop();
	}

}
