package org.usfirst.frc.team4290.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousMiddleGearDrop extends CommandGroup {

    public AutonomousMiddleGearDrop() {
    	//TODO uncomment for COMP
    	addSequential(new MoveRobotByXAndYCommand(-0.6, 0.25), 2.25);
//    	addSequential(new MoveRobotByXAndYCommand(0.5, -0.1), 2);
    	addSequential(new MoveRobotByXAndYCommand(0.0, 0.0), 0.5);
    	addSequential(new DropGearWithCameraCommand());
    	addSequential(new MoveRobotByXAndYCommand(0.0, 0.0), 0.25);
    	addParallel(new liftGearCommand(), 0.3);
//    	addSequential(new liftGearCommand(), 0.3);
    	addSequential(new MoveRobotByXAndYCommand(0.4, 0), 3);
    	addSequential(new dropGearCommand(), 0.3);
    	
    	//TODO comment out for COMP
//    	addSequential(new MoveRobotByXAndYCommand(0.6, 0.25), 2.25);
////    	addSequential(new MoveRobotByXAndYCommand(0.5, -0.1), 2);
//    	addSequential(new MoveRobotByXAndYCommand(0.0, 0.0), 0.5);
//    	addSequential(new DropGearWithCameraCommand());
//    	addSequential(new MoveRobotByXAndYCommand(0.0, 0.0), 0.25);
//    	addParallel(new liftGearCommand(), 0.3);
////    	addSequential(new liftGearCommand(), 0.3);
//    	addSequential(new MoveRobotByXAndYCommand(-0.4, 0), 3);
//    	addSequential(new dropGearCommand(), 0.3);

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
