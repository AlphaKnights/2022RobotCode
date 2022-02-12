// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.AccelCurve;
import frc.robot.Constants.DriveTrainConstants;
import frc.robot.subsystems.DriveTrainSubsystem;

public class CartesianDriveCommand extends CommandBase {
  /** Creates a new CartesianDrive. */
  private final DriveTrainSubsystem m_DriveTrainSubsystem;
  private final Joystick joystick;
  
  public CartesianDriveCommand(DriveTrainSubsystem drivetrainsubsystem, Joystick _joystick) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_DriveTrainSubsystem = drivetrainsubsystem;
    joystick = _joystick;
    addRequirements(m_DriveTrainSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //Logitech Joysticks
    //spaghetti code to reduce execution time
    m_DriveTrainSubsystem.cartesianDrive(
      (Math.pow((AccelCurve.m*(joystick.getRawAxis(DriveTrainConstants.forward_axis))-AccelCurve.sub_amount), AccelCurve.exponent)+AccelCurve.add_amount),
      (Math.pow((AccelCurve.m*(joystick.getRawAxis(DriveTrainConstants.side_axis))-AccelCurve.sub_amount), AccelCurve.exponent)+AccelCurve.add_amount),
      (Math.pow((AccelCurve.m*(joystick.getRawAxis(DriveTrainConstants.rotation_axis))-AccelCurve.sub_amount), AccelCurve.exponent)+AccelCurve.add_amount)
    );
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
