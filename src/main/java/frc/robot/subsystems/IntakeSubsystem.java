package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.IntakeConstants;

public class IntakeSubsystem extends SubsystemBase {
  static IntakeSubsystem INSTANCE = new IntakeSubsystem();
  TalonSRX IntakingMotor = new TalonSRX(IntakeConstants.intakeMotorID);
  TalonSRX IntakeHeadMotor = new TalonSRX(IntakeConstants.intakeHeadMotorID);
  TalonFX rotator = new TalonFX(10);
  // private static double position = 0;
  /**
   * Creates a new IntakeSubsystem.
   */
  public IntakeSubsystem(){
    rotator.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
    rotator.setNeutralMode(NeutralMode.Brake);
  }

  public void go(double val){
      IntakingMotor.set(ControlMode.PercentOutput, val);
  }
  public void RotateToPosition(double d){
    rotator.set(ControlMode.PercentOutput, d);
  }
  public void RotateHead(double d){
    IntakeHeadMotor.set(ControlMode.PercentOutput, d);
  }

  @Override
  public void periodic() {
  }

  public static IntakeSubsystem getInstance() {
    return INSTANCE;
  }
}