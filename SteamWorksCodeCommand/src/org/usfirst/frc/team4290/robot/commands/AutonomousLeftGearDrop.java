package org.usfirst.frc.team4290.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousLeftGearDrop extends CommandGroup {
    public AutonomousLeftGearDrop() {   
    	
//    	addSequential(new MoveRobotByXAndYCommand(-0.6, 0.1), 3);
    	addSequential(new MoveRobotByXAndYCommand(-0.6, 0.1), 0.25);
    	addSequential(new MoveRobotByXAndYCommand(-0.8, 0.2), 1);
    	addSequential(new MoveRobotByXAndYCommand(-0.6, 0.1), 0.35);
    	addSequential(new MoveRobotByXAndYCommand(0.0, -0.6), 0.75);
    	addSequential(new MoveRobotByXAndYCommand(-0.6, 0.0), 0.5);
    	addSequential(new MoveRobotByXAndYCommand(0.0, 0.0), 0.25);
//    	addSequential(new TurnXDegrees(-20), 1.5);
//    	addSequential(new DropGearWithCameraCommand());
    	addParallel(new liftGearCommand(), 1.0);
    	addSequential(new MoveRobotByXAndYCommand(-0.4, 0), 2);
    	addSequential(new dropGearCommand(), 0.5);
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
