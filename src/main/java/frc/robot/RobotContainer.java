// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.RamseteController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.constraint.DifferentialDriveVoltageConstraint;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants.AutoConstants;
import frc.robot.Constants.DriveConstants;
import frc.robot.Constants.OI_Constants;
import frc.robot.commands.AutoCommand;
import frc.robot.commands.CartesianDriveCommand;
import frc.robot.commands.ClimbCommand;
import frc.robot.commands.ClimbUpCommand;
import frc.robot.commands.ComplexAuto;
import frc.robot.commands.IntakeArmCommand;
import frc.robot.commands.IntakeHeadRotateCommand;
import frc.robot.commands.PrepareClimbCommand;
import frc.robot.commands.RotateClimberCommand;
import frc.robot.commands.RotateStaticHooks;
import frc.robot.commands.RunIntake;
import frc.robot.commands.SetLEDs;
import frc.robot.subsystems.ClimbingSubsystem;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RamseteCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  
  Joystick m_joystick = new Joystick(OI_Constants.m_joystickID);
  Joystick i_joystick = new Joystick(OI_Constants.i_joystickID);
  Joystick c_joystick = new Joystick(OI_Constants.c_joystickID);
  private final DriveTrainSubsystem m_DriveTrainSubsystem = DriveTrainSubsystem.getInstance();
  private final IntakeSubsystem i_intakeSubsystem = IntakeSubsystem.getInstance();
  private final ClimbingSubsystem c_ClimbingSubsystem = ClimbingSubsystem.getInstance();

  private final CartesianDriveCommand m_CartesianDriveCommand = new CartesianDriveCommand(m_DriveTrainSubsystem, m_joystick);
  private final RotateClimberCommand c_RotateClimberCommand = new RotateClimberCommand(c_ClimbingSubsystem, c_joystick);
  private final IntakeArmCommand i_rotateArmCommand = new IntakeArmCommand(i_intakeSubsystem, i_joystick);
  private final ComplexAuto a_command = new ComplexAuto(m_DriveTrainSubsystem);//Scuffed
  
  private final JoystickButton c_trigger = new JoystickButton(c_joystick, OI_Constants.armClimbButton);
  private final JoystickButton c_thumbButton_climber = new JoystickButton(c_joystick, OI_Constants.climbButton);
  private final JoystickButton c_prepclimber = new JoystickButton(c_joystick, OI_Constants.prepClimbButton);
  private final JoystickButton c_rotateClimber = new JoystickButton(c_joystick, OI_Constants.rotateClimberButton);
  private final JoystickButton c_rotateStatic = new JoystickButton(c_joystick, OI_Constants.rotateStaticHookButton);
  private final JoystickButton i_trigger = new JoystickButton(i_joystick, OI_Constants.runIntakeButton);
  private final JoystickButton i_rotateHead = new JoystickButton(i_joystick, OI_Constants.rotateIntakeHeadButton);
  
  private final JoystickButton i_rotateHead2 = new JoystickButton(i_joystick, 6);
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }
  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    m_DriveTrainSubsystem.setDefaultCommand(m_CartesianDriveCommand);
    c_ClimbingSubsystem.setDefaultCommand(c_RotateClimberCommand);
    i_rotateHead2.whileHeld(i_rotateArmCommand);

    c_trigger.whileHeld(new ClimbUpCommand(c_ClimbingSubsystem, c_joystick));
    c_prepclimber.whileHeld(new PrepareClimbCommand(c_ClimbingSubsystem));
    c_thumbButton_climber.whileHeld(new ClimbCommand(c_ClimbingSubsystem, c_joystick));
    c_rotateClimber.toggleWhenPressed(new RotateClimberCommand(c_ClimbingSubsystem, c_joystick));
    c_rotateStatic.toggleWhenPressed(new RotateStaticHooks(c_ClimbingSubsystem, c_joystick));

    i_trigger.whileHeld(new RunIntake(i_intakeSubsystem, i_joystick));
    i_rotateHead.toggleWhenPressed(new IntakeHeadRotateCommand(i_intakeSubsystem, i_joystick));
    
    SmartDashboard.putData("Run", new SetLEDs());
    // c_ClimbingSubsystem.setDefaultCommand(c_RotateArmsCommand);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand(Trajectory trag) {

// RamseteCommand ramseteCommand =
    // new RamseteCommand(
    //   trag,
    //     m_DriveTrainSubsystem::getPose,
    //     new RamseteController(AutoConstants.kRamseteB, AutoConstants.kRamseteZeta),
    //     new SimpleMotorFeedforward(
    //         DriveConstants.ksVolts,
    //         DriveConstants.kvVoltSecondsPerMeter,
    //         DriveConstants.kaVoltSecondsSquaredPerMeter),
    //     DriveConstants.kDriveKinematics,
    //     m_DriveTrainSubsystem::getWheelSpeeds,
    //     new PIDController(DriveConstants.kPDriveVel, 0, 0),
    //     new PIDController(DriveConstants.kPDriveVel, 0, 0),
    //     // RamseteCommand passes volts to the callback
    //     m_DriveTrainSubsystem::tankDriveVolts,
    //     m_DriveTrainSubsystem);

  // Reset odometry to the starting pose of the trajectory.
  m_DriveTrainSubsystem.resetOdometry(trag.getInitialPose());
  // Run path following command, then stop at the end.
    // An ExampleCommand will run in autonomous
    return a_command;
  }
}
