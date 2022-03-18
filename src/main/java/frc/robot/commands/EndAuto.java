// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSubsystem;

public class EndAuto extends CommandBase {
  private final DriveTrainSubsystem m_DriveTrainSubsystem;
  private boolean called = false;

  public EndAuto(DriveTrainSubsystem drivetrainsubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_DriveTrainSubsystem = drivetrainsubsystem;
    addRequirements(m_DriveTrainSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  public void execute() {
    //Logitech Joysticks
    //spaghetti code to reduce execution time
    m_DriveTrainSubsystem.cartesianDrive(
      // (Math.pow((AccelCurve.m*(joystick.getRawAxis(DriveTrainConstants.forward_axis))-AccelCurve.sub_amount), AccelCurve.exponent)+AccelCurve.add_amount),
      // (Math.pow((AccelCurve.m*(joystick.getRawAxis(DriveTrainConstants.side_axis))-AccelCurve.sub_amount), AccelCurve.exponent)+AccelCurve.add_amount),
      // (Math.pow((AccelCurve.m*(joystick.getRawAxis(DriveTrainConstants.rotation_axis))-AccelCurve.sub_amount), AccelCurve.exponent)+AccelCurve.add_amount)
      0,
      0,
      0);
    called = true;
  }


  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_DriveTrainSubsystem.cartesianDrive(0, 0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (called) {
      return true;
    }
    return false;
  }
}
