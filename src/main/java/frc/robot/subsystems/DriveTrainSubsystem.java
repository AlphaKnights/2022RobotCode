/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.MecanumDrive;

// import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

// import edu.wpi.first.wpilibj.SpeedControllerGroup;
// import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import frc.robot.Constants.driveTrain;
import frc.robot.Constants.DriveTrainConstants;
import frc.robot.lib.Falcon500;

// import com.kauailabs.navx.frc.AHRS;
// import edu.wpi.first.wpilibj.SerialPort;

public class DriveTrainSubsystem extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */
  // private final AHRS navX = new AHRS(SerialPort.Port.kUSB);

  Falcon500 frontRightFalcon = new Falcon500(DriveTrainConstants.rightFrontFalconID);
  Falcon500 backRightFalcon = new Falcon500(DriveTrainConstants.rightBackFalconID);
  Falcon500 frontLeftFalcon = new Falcon500(DriveTrainConstants.leftFrontFalconID);
  Falcon500 backLeftFalcon = new Falcon500(DriveTrainConstants.leftBackFalconID);

  MecanumDrive m_driveTrain = new MecanumDrive(frontLeftFalcon, backLeftFalcon, frontRightFalcon, backRightFalcon);
  
  static DriveTrainSubsystem INSTANCE = new DriveTrainSubsystem();

  // private void DriveTrainSubsystem() {
  // }

  public void cartesianDrive(double fowardSpeed, double sideSpeed, double rotation) {
    m_driveTrain.driveCartesian(fowardSpeed, sideSpeed, rotation);
  }

  public void polarDrive(double forwardPower, double currentRotation, double rotationRate) {
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