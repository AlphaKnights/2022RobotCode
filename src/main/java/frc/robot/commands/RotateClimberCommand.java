// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ClimbingConstants;
import frc.robot.subsystems.ClimbingSubsystem;

public class RotateClimberCommand extends CommandBase {
  private final ClimbingSubsystem c_subsystem;
  private final Joystick c_Joystick;
  /** Creates a new RotateClimberCommand. */
  public RotateClimberCommand(ClimbingSubsystem cSubsystem, Joystick cJoystick) {
    // Use addRequirements() here to declare subsystem dependencies.
    c_subsystem = cSubsystem;
    c_Joystick = cJoystick;
    addRequirements(c_subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      c_subsystem.changeAngle(c_Joystick.getRawAxis(ClimbingConstants.rotateAxis)*ClimbingConstants.armRotationSensitivity);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    c_subsystem.changeAngleStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
