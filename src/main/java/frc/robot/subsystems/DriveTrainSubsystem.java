/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;

// import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

// import edu.wpi.first.wpilibj.SpeedControllerGroup;
// import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import frc.robot.Constants.driveTrain;
import frc.robot.Constants.DriveTrainConstants;

// import com.kauailabs.navx.frc.AHRS;
// import edu.wpi.first.wpilibj.SerialPort;

public class DriveTrainSubsystem extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */
  // private final AHRS navX = new AHRS(SerialPort.Port.kUSB);
 
  // DifferentialDrive m_driveTrain = new DifferentialDrive(new SpeedControllerGroup(leftMotor1, leftMotor2), new SpeedControllerGroup(rightMotor1, rightMotor2));
  // DifferentialDrive m_driveTrain = new DifferentialDrive(, rightMotor)
  MotorController frontRightGroup = new MotorController() {
    TalonFX rightFrontMotor = new TalonFX(DriveTrainConstants.rightFrontFalconID);
    @Override
    public void set(double speed) {
      rightFrontMotor.set(ControlMode.PercentOutput, speed);
      rightFrontMotor.setNeutralMode(NeutralMode.Coast);
    }

    @Override
    public double get() {
      return rightFrontMotor.getMotorOutputPercent();
    }

    @Override
    public void setInverted(boolean isInverted) {
      rightFrontMotor.setInverted(isInverted);
    }

    @Override
    public boolean getInverted() {
      return rightFrontMotor.getInverted();
    }

    @Override
    public void disable() {
      rightFrontMotor.set(ControlMode.PercentOutput, 0);
      rightFrontMotor.setNeutralMode(NeutralMode.Coast);
    }

    @Override
    public void stopMotor() {
      rightFrontMotor.set(ControlMode.PercentOutput, 0);
      rightFrontMotor.setNeutralMode(NeutralMode.Brake);
    }
    
  };

  MotorController frontLeftGroup = new MotorController() {
    TalonFX leftFrontMotor = new TalonFX(DriveTrainConstants.leftFrontFalconID);
    @Override
    public void set(double speed) {
      leftFrontMotor.set(ControlMode.PercentOutput, speed);
      leftFrontMotor.setNeutralMode(NeutralMode.Coast);
    }

    @Override
    public double get() {
      return leftFrontMotor.getMotorOutputPercent();
    }

    @Override
    public void setInverted(boolean isInverted) {
      leftFrontMotor.setInverted(isInverted);
    }

    @Override
    public boolean getInverted() {
      return leftFrontMotor.getInverted();
    }

    @Override
    public void disable() {
      leftFrontMotor.set(ControlMode.PercentOutput, 0);
      leftFrontMotor.setNeutralMode(NeutralMode.Coast);
    }

    @Override
    public void stopMotor() {
      leftFrontMotor.set(ControlMode.PercentOutput, 0);
      leftFrontMotor.setNeutralMode(NeutralMode.Brake);
    }
    
  };

  MotorController backLeftGroup = new MotorController() {
    TalonFX leftBackMotor = new TalonFX(DriveTrainConstants.leftBackFalconID);
    @Override
    public void set(double speed) {
      leftBackMotor.set(ControlMode.PercentOutput, speed);
      leftBackMotor.setNeutralMode(NeutralMode.Coast);
    }

    @Override
    public double get() {
      return leftBackMotor.getMotorOutputPercent();
    }

    @Override
    public void setInverted(boolean isInverted) {
      leftBackMotor.setInverted(isInverted);
    }

    @Override
    public boolean getInverted() {
      return leftBackMotor.getInverted();
    }

    @Override
    public void disable() {
      leftBackMotor.set(ControlMode.PercentOutput, 0);
      leftBackMotor.setNeutralMode(NeutralMode.Coast);
    }

    @Override
    public void stopMotor() {
      leftBackMotor.set(ControlMode.PercentOutput, 0);
      leftBackMotor.setNeutralMode(NeutralMode.Brake);
    }
    
  };

  MotorController backRightGroup = new MotorController() {
    TalonFX rightBackMotor = new TalonFX(DriveTrainConstants.rightBackFalconID);
    @Override
    public void set(double speed) {
      rightBackMotor.set(ControlMode.PercentOutput, speed);
      rightBackMotor.setNeutralMode(NeutralMode.Coast);
    }

    @Override
    public double get() {
      return rightBackMotor.getMotorOutputPercent();
    }

    @Override
    public void setInverted(boolean isInverted) {
      rightBackMotor.setInverted(isInverted);
    }

    @Override
    public boolean getInverted() {
      return rightBackMotor.getInverted();
    }

    @Override
    public void disable() {
      rightBackMotor.set(ControlMode.PercentOutput, 0);
      rightBackMotor.setNeutralMode(NeutralMode.Coast);
    }

    @Override
    public void stopMotor() {
      rightBackMotor.set(ControlMode.PercentOutput, 0);
      rightBackMotor.setNeutralMode(NeutralMode.Brake);
    }
    
  };

  MecanumDrive m_driveTrain = new MecanumDrive(frontLeftGroup, backLeftGroup, frontRightGroup, backRightGroup);
  
  static DriveTrainSubsystem INSTANCE = new DriveTrainSubsystem();

  // private void DriveTrainSubsystem() {
  // }

  public void cartesianDrive(double fowardSpeed, double sideSpeed, double rotation) {
    m_driveTrain.driveCartesian(fowardSpeed, sideSpeed, rotation);
  }

  public void arcadeDrive(double forwardPower, double currentRotation, double rotationRate) {
    m_driveTrain.drivePolar(forwardPower, currentRotation, rotationRate);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public static DriveTrainSubsystem getInstance() {
    return INSTANCE;
  }
}