// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeArmCommand extends CommandBase {
  private final IntakeSubsystem i_subsystem;
  private final Joystick i_Joystick;
  /** Creates a new IntakeHeadRotateCommand. */
  public IntakeArmCommand(IntakeSubsystem iSubsystem, Joystick iJoystick) {
    // Use addRequirements() here to declare subsystem dependencies.
    i_subsystem = iSubsystem;
    i_Joystick = iJoystick;
    addRequirements(i_subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      // i_subsystem.RotateToPosition(((i_Joystick.getPOV()/180)-.5)*(-2));
      
      i_subsystem.RotateToPosition(i_Joystick.getRawAxis(1)*Constants.IntakeConstants.armSens);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    i_subsystem.RotateToPosition(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
