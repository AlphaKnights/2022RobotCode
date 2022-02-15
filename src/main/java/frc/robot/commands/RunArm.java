package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.OIConstants;
import frc.robot.subsystems.ArmSubsystem;
import edu.wpi.first.wpilibj.Joystick;
public class RunArm extends CommandBase {
  private final ArmSubsystem a_sub;
  private Joystick driveJoystick;
  public RunArm(ArmSubsystem t, Joystick m_driveJoystick) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    this.driveJoystick = m_driveJoystick;
    a_sub=t;
    addRequirements(a_sub);
  }
  

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    a_sub.goArm(driveJoystick.getRawAxis(OIConstants.joyAxiy));
    
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return false;
  }
}
