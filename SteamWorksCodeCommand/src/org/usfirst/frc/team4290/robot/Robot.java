
package org.usfirst.frc.team4290.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4290.robot.commands.AutonomousLeftGearDrop;
import org.usfirst.frc.team4290.robot.commands.AutonomousMiddleGearDrop;
import org.usfirst.frc.team4290.robot.commands.AutonomousRightGearDrop;
import org.usfirst.frc.team4290.robot.subsystems.AimShooterSubsystem;
import org.usfirst.frc.team4290.robot.subsystems.ClimberSubsystem;
import org.usfirst.frc.team4290.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4290.robot.subsystems.FuelPickupSubsystem;
import org.usfirst.frc.team4290.robot.subsystems.FuelConveyerSubsystem;
import org.usfirst.frc.team4290.robot.subsystems.GearLift;
import org.usfirst.frc.team4290.robot.subsystems.ShooterSubsystem;
import org.usfirst.frc.team4290.robot.subsystems.VisionPipelineSubystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	public static DriveTrain driveTrain;
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();
	public static GearLift gearLift;
	public static ShooterSubsystem shooterSubsystem;
	public static ClimberSubsystem climberSubsystem;
	public static FuelPickupSubsystem fuelPickupSubsystem;
	public static FuelConveyerSubsystem fuelConveyerSubsystem;
	public static AimShooterSubsystem aimShooterSubsystem;
	public static VisionPipelineSubystem visionPipeline;
	
	private static UsbCamera shooterCamera;
	
	public static SendableChooser autoChooser;
	private static int isMirrored = 1;
	public static SendableChooser redBlueChooser;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		RobotMap.init();
		driveTrain = new DriveTrain();
		oi = new OI();
		shooterSubsystem = new ShooterSubsystem();
		climberSubsystem = new ClimberSubsystem();
		fuelPickupSubsystem = new FuelPickupSubsystem();
		fuelConveyerSubsystem = new FuelConveyerSubsystem();
		visionPipeline = new VisionPipelineSubystem();
		gearLift = new GearLift();
		aimShooterSubsystem = new AimShooterSubsystem();
		SmartDashboard.putData("Auto mode", chooser);
		
		autoChooser = new SendableChooser();
		autoChooser.addObject("Left Gear",new AutonomousLeftGearDrop());
		autoChooser.addObject("Middle Gear",new AutonomousMiddleGearDrop());
		autoChooser.addObject("Right Gear",new AutonomousRightGearDrop());
		SmartDashboard.putData("Autonomous Mode", autoChooser);
		
		redBlueChooser = new SendableChooser();
		redBlueChooser.addObject("Red", isMirrored = 1);
		redBlueChooser.addObject("Blue", isMirrored = -1);
		SmartDashboard.putData("Alliance Color", redBlueChooser);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();

//		autonomousCommand = new AutonomousRightGearDrop(1);
		
		
		autonomousCommand = (Command) autoChooser.getSelected();
		
		SmartDashboard.putString("Chooser", autoChooser.getSelected().toString());
		autonomousCommand.start();
/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
//		shooterCamera = CameraServer.getInstance().startAutomaticCapture();
//		shooterCamera.setResolution(640, 480);
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
