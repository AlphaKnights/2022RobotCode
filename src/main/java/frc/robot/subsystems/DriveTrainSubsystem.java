/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;

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

  Falcon500 frontRightFalcon = new Falcon500(DriveTrainConstants.rightFrontFalconID,DriveTrainConstants.rightBackFalconID);
  // Falcon500 backRightFalcon = new Falcon500();
  Falcon500 frontLeftFalcon = new Falcon500(DriveTrainConstants.leftFrontFalconID,DriveTrainConstants.leftBackFalconID);
  // Falcon500 backLeftFalcon = new Falcon500();

  DifferentialDrive m_driveTrain = new DifferentialDrive(frontLeftFalcon, frontRightFalcon);
  
  private final Gyro m_gyro = new Gyro() {

    @Override
    public void close() throws Exception {
      // TODO Auto-generated method stub
      
    }

    @Override
    public void calibrate() {
      // TODO Auto-generated method stub
      
    }

    @Override
    public void reset() {
      // TODO Auto-generated method stub
      
    }

    @Override
    public double getAngle() {
      // TODO Auto-generated method stub
      return 0;
    }

    @Override
    public double getRate() {
      // TODO Auto-generated method stub
      return 0;
    }
    
  };
  static DriveTrainSubsystem INSTANCE = new DriveTrainSubsystem();

  private final DifferentialDriveOdometry m_odometry;
  public DriveTrainSubsystem() {
    // frontRightFalcon.setInverted(true);
    // backLeftFalcon.setInverted(true);
    m_odometry = new DifferentialDriveOdometry(m_gyro.getRotation2d());
  }

  public void cartesianDrive(double fowardSpeed, double sideSpeed, double rotation) {
    frontRightFalcon.setInverted(true);
    // backLeftFalcon.setInverted(false);
    frontLeftFalcon.setInverted(false);
    // backRightFalcon.setInverted(true);\
    m_driveTrain.tankDrive(fowardSpeed*.6, sideSpeed*(-.8));
  }

  // public void polarDrive(double forwardPower, double currentRotation, double rotationRate) {
  //   m_driveTrain.drivePolar(forwardPower, currentRotation, rotationRate);
  // }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public static DriveTrainSubsystem getInstance() {
    return INSTANCE;
  }

public void resetOdometry(Pose2d initialPose) {
}
public Pose2d getPose(){
  return m_odometry.getPoseMeters();} 
}