package frc.robot.subsystems;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

public class ArmSubsystem extends SubsystemBase {
  Talon IntakingMotor;
  /**
   * Creates a new IntakeSubsystem.
   */
  public ArmSubsystem(){
    IntakingMotor=new Talon (IntakeConstants.armMotorID);
  }

  public void goArm(double val){
      IntakingMotor.set(val);
  }
  public void Extend(){

  }

  @Override
  public void periodic() {
  }
}
