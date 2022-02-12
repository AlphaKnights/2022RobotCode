// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ClimbingSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ClimbingConstants;

/** An example command that uses an example subsystem. */
public class ArmMovementCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final ClimbingSubsystem c_subsystem;
  private final Joystick joystick;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ArmMovementCommand(ClimbingSubsystem subsystem, Joystick _joystick) {
    c_subsystem = subsystem;
    joystick = _joystick;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    c_subsystem.ArmRotationMotor.set(joystick.getRawAxis(ClimbingConstants.y_axis) * ClimbingConstants.armRotationSensitivity);
    c_subsystem.ArmAltitudeMotor.set(joystick.getRawAxis(ClimbingConstants.x_axis) * ClimbingConstants.armHeightSensitivity);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}