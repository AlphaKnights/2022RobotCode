// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import frc.robot.Constants.ClimbingConstants;

public class ClimbingSubsystem extends SubsystemBase {
    static ClimbingSubsystem INSTANCE = new ClimbingSubsystem();

    public MotorController ArmRotationMotor = new MotorController() {
        TalonFX armRotationMotor = new TalonFX(ClimbingConstants.armRotationMotor);

        @Override
        public void set(double speed) {
            armRotationMotor.set(ControlMode.PercentOutput, speed * ClimbingConstants.armRotationMotor);
            armRotationMotor.setNeutralMode(NeutralMode.Coast);
        }

        @Override
        public double get() { // if this consistently return -1, rewrite a get function for each motor
            return armRotationMotor.getMotorOutputPercent();
        }

        @Override
        public void setInverted(boolean isInverted) {
            armRotationMotor.setInverted(isInverted);
        }

        @Override
        public boolean getInverted() {
            return armRotationMotor.getInverted();
        }

        @Override
        public void disable() {
            armRotationMotor.set(ControlMode.PercentOutput, 0);
            armRotationMotor.setNeutralMode(NeutralMode.Coast);
        }

        @Override
        public void stopMotor() {
            armRotationMotor.set(ControlMode.PercentOutput, 0);
            armRotationMotor.setNeutralMode(NeutralMode.Brake);
        }
        
    };

    public MotorController ArmAltitudeMotor = new MotorController() {
        TalonFX armAltitudeMotor = new TalonFX(ClimbingConstants.armElevationMotor);

        @Override
        public void set(double speed) {
            armAltitudeMotor.set(ControlMode.PercentOutput, speed * ClimbingConstants.armRotationMotor);
            armAltitudeMotor.setNeutralMode(NeutralMode.Coast);
        }

        @Override
        public double get() { // if this consistently return -1, rewrite a get function for each motor
            return armAltitudeMotor.getMotorOutputPercent();
        }

        @Override
        public void setInverted(boolean isInverted) {
            armAltitudeMotor.setInverted(isInverted);
        }

        @Override
        public boolean getInverted() {
            return armAltitudeMotor.getInverted();
        }

        @Override
        public void disable() {
            armAltitudeMotor.set(ControlMode.PercentOutput, 0);
            armAltitudeMotor.setNeutralMode(NeutralMode.Coast);
        }

        @Override
        public void stopMotor() {
            armAltitudeMotor.set(ControlMode.PercentOutput, 0);
            armAltitudeMotor.setNeutralMode(NeutralMode.Brake);
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

  public static ClimbingSubsystem getInstance() {
    return INSTANCE;
  }
}