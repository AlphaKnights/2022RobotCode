

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

public class ArmSubsystem extends SubsystemBase {
  WPI_TalonSRX IntakingMotor;
  /**
   * Creates a new IntakeSubsystem.
   */
  public ArmSubsystem(){
    IntakingMotor=new WPI_TalonSRX(IntakeConstants.armMotorID);
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