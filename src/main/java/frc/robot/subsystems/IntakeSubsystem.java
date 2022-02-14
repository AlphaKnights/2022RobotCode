

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

public class IntakeSubsystem extends SubsystemBase {
  WPI_TalonSRX IntakingMotor;
  /**
   * Creates a new IntakeSubsystem.
   */
  public IntakeSubsystem(){
    IntakingMotor=new WPI_TalonSRX(IntakeConstants.intakeMotorID);
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