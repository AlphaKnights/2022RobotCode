// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.shuffleboard.SimpleWidget;

public class SetLEDs extends CommandBase {
  final I2C arduino = new I2C(Port.kOnboard, 4);
  //private ShuffleboardTab tab2 = Shuffleboard.getTab(title);
  private ShuffleboardTab tab = Shuffleboard.getTab("LEDS");
  // private SimpleWidget slider = Shuffleboard.widget
   private NetworkTableEntry led =
       tab.add("Led", "FFFFFF")
          .getEntry();
  private NetworkTableEntry state = tab.add("state", "Strip")
          .getEntry();
  String data = "Strip:FFFFFF";
  /** Creates a new SetLEDs. */
  public SetLEDs() {
    
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // boolean success = arduino.transaction(data.getBytes(), data.getBytes().length, new byte[0], 0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    data = state.getString("Rainbow")+":"+led.getString("FFFFFF");
    boolean success = arduino.transaction(data.getBytes(), data.getBytes().length, new byte[0], 0);}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
