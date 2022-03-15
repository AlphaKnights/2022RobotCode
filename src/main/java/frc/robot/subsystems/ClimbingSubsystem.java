// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ClimbingConstants;

public class ClimbingSubsystem extends SubsystemBase {
  static ClimbingSubsystem INSTANCE = new ClimbingSubsystem();
  TalonFX rotatorMotor = new TalonFX(ClimbingConstants.armRotationMotor);
  TalonFX climbMotor = new TalonFX(ClimbingConstants.climbMotor);
  TalonSRX leftClimber = new TalonSRX(ClimbingConstants.armElevationMotorLeft);
  TalonSRX rightClimber = new TalonSRX(ClimbingConstants.armElevationMotorRight);
  /** Creates a new ClimbingSubsystem. */
  public ClimbingSubsystem() {
    rotatorMotor.setNeutralMode(NeutralMode.Brake);
  }

  public void changeAngle(double amount){
    rotatorMotor.set(ControlMode.PercentOutput, amount);
  }

  public void prepClimb(double speed){
    climbMotor.set(ControlMode.PercentOutput, speed);
  }

  public void moveArms(double amount){
    leftClimber.set(ControlMode.PercentOutput, amount);
    rightClimber.set(ControlMode.PercentOutput, amount);
  }

  public void fixAdjustAngle(double amount){
    leftClimber.set(ControlMode.PercentOutput, amount*(-1));
    rightClimber.set(ControlMode.PercentOutput, amount);
  }

  public void climb(double amount){
    climbMotor.set(ControlMode.PercentOutput, amount);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  
  public static ClimbingSubsystem getInstance() {
    return INSTANCE;
  }
}
