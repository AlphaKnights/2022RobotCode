package frc.robot.subsystems;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

public class IntakeSubsystem extends SubsystemBase {
  Talon IntakingMotor;
  /**
   * Creates a new IntakeSubsystem.
   */
  public IntakeSubsystem(){
    IntakingMotor=new Talon(IntakeConstants.intakeMotorID);
  }

  public void go(double val){
      IntakingMotor.set(val);
  }
  public void Extend(){

  }

  @Override
  public void periodic() {
  }
}
