// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import frc.robot.Constants.ClimbingConstants;

public class ClimbingSubsystem extends SubsystemBase {

    public Joystick joystick;
    static ClimbingSubsystem INSTANCE = new ClimbingSubsystem();

    public MotorController ArmRotationGroup = new MotorController() {
        TalonFX leftArmMotor = new TalonFX(ClimbingConstants.leftArmTalonID); //TODO make sure this constant exists
        TalonFX rightArmMotor = new TalonFX(ClimbingConstants.rightArmTalonID);
        @Override
        public void set(double speed) {
            leftArmMotor.set(ControlMode.PercentOutput, speed * ClimbingConstants.leftTalonRotation);
            leftArmMotor.setNeutralMode(NeutralMode.Coast);
            rightArmMotor.set(ControlMode.PercentOutput, speed * ClimbingConstants.rightTalonRotation);
            rightArmMotor.setNeutralMode(NeutralMode.Coast);
        }

        @Override
        public double get() { // if this consistently return -1, rewrite a get function for each motor
            if (leftArmMotor.getMotorOutputPercent() == rightArmMotor.getMotorOutputPercent())
                return leftArmMotor.getMotorOutputPercent();
            else 
                return -1;
        }

        @Override
        public void setInverted(boolean isInverted) {
            leftArmMotor.setInverted(isInverted);
            rightArmMotor.setInverted(isInverted);
        }

        @Override
        public boolean getInverted() {
            return leftArmMotor.getInverted() && rightArmMotor.getInverted();
        }

        @Override
        public void disable() {
            leftArmMotor.set(ControlMode.PercentOutput, 0);
            leftArmMotor.setNeutralMode(NeutralMode.Coast);
            rightArmMotor.set(ControlMode.PercentOutput, 0);
            rightArmMotor.setNeutralMode(NeutralMode.Coast);
        }

        @Override
        public void stopMotor() {
            leftArmMotor.set(ControlMode.PercentOutput, 0);
            leftArmMotor.setNeutralMode(NeutralMode.Brake);
            rightArmMotor.set(ControlMode.PercentOutput, 0);
            rightArmMotor.setNeutralMode(NeutralMode.Brake);
        }
        
    };
  /** Creates a new ExampleSubsystem. */
  public ClimbingSubsystem() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public static ClimbingSubsystem getInstance(Joystick js) {
    INSTANCE.joystick = js;
    return INSTANCE;
  }
}
