// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.Map;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.Joystick;
// import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ClimbingConstants;
import frc.robot.subsystems.ClimbingSubsystem;

public class ClimbUpCommand extends CommandBase {
  private final ClimbingSubsystem c_subsystem;
  private final Joystick c_Joystick;
  private ShuffleboardTab tab = Shuffleboard.getTab("General");
  // private SimpleWidget slider = Shuffleboard.widget
  //  private NetworkTableEntry climber =
  //      tab.add("Enable Climber", false)
  //      .withWidget(BuiltInWidgets.kToggleButton)
  //         .getEntry();
   private NetworkTableEntry climberSens =
       tab.add("Climber Sensitivity", 1.0)
       .withProperties(Map.of("min", 0, "max", 1))
       .getEntry();
  /** Creates a new ClimbCommand. */
  public ClimbUpCommand(ClimbingSubsystem cSubsystem, Joystick cJoystick) {
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
      c_subsystem.moveArms(c_Joystick.getRawAxis(1)*ClimbingConstants.armHeightSensitivity*climberSens.getDouble(1.0));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    c_subsystem.moveArms(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
