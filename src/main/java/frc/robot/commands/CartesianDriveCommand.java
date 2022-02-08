// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.DriveTrainConstants;
import frc.robot.Constants.OI_Constants;
import frc.robot.subsystems.DriveTrainSubsystem;

public class CartesianDriveCommand extends CommandBase {
  /** Creates a new CartesianDrive. */
  DriveTrainSubsystem m_DriveTrainSubsystem;
  Joystick joystick = new Joystick(OI_Constants.m_joystickID);
  
  public CartesianDriveCommand(DriveTrainSubsystem drivetrainsubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_DriveTrainSubsystem = drivetrainsubsystem;
    addRequirements(m_DriveTrainSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_DriveTrainSubsystem.cartesianDrive(joystick.getRawAxis(DriveTrainConstants.x_axis), joystick.getRawAxis(DriveTrainConstants.y_axis), joystick.getTwist());
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