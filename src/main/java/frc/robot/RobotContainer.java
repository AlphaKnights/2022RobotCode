// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants.OI_Constants;
import frc.robot.commands.AutoCommand;
import frc.robot.commands.CartesianDriveCommand;
import frc.robot.commands.ClimbUpCommand;
import frc.robot.commands.RunIntake;
import frc.robot.commands.SetLEDs;
import frc.robot.subsystems.ClimbingSubsystem;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  
  Joystick c_joystick = new Joystick(OI_Constants.c_joystickID);
  private final DriveTrainSubsystem m_DriveTrainSubsystem = DriveTrainSubsystem.getInstance();
  private final IntakeSubsystem c_intakeSubsystem = IntakeSubsystem.getInstance();
  private final ClimbingSubsystem c_ClimbingSubsystem = ClimbingSubsystem.getInstance();

  private final CartesianDriveCommand m_CartesianDriveCommand = new CartesianDriveCommand(m_DriveTrainSubsystem, c_joystick);
  private final RunIntake c_runIntake = new RunIntake(c_intakeSubsystem, c_joystick);
  // private final ClimbUpCommand c_climb = new ClimbUpCommand(c_ClimbingSubsystem, c_joystick);
  private final AutoCommand a_command = new AutoCommand(m_DriveTrainSubsystem);
  // private final ClimbUpCommand c_armMovementCommand = new ClimbUpCommand(c_ClimbingSubsystem, c_joystick);
  
  private final JoystickButton trigger = new JoystickButton(c_joystick, 1);
  // private final ArmMovementCommand c_RotateArmsCommand = new ArmMovementCommand(c_ClimbingSubsystem, c_joystick);
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
    c_intakeSubsystem.setDefaultCommand(c_runIntake);
    // c_ClimbingSubsystem.setDefaultCommand(c_climb);
    trigger.whileHeld(new ClimbUpCommand(c_ClimbingSubsystem, c_joystick));
    SmartDashboard.putData("Run", new SetLEDs());
    // c_ClimbingSubsystem.setDefaultCommand(c_RotateArmsCommand);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return a_command;
  }
}
