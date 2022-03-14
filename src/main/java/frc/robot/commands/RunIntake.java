package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj.Joystick;
public class RunIntake extends CommandBase {
  private final IntakeSubsystem m_sub;
  private Joystick driveJoystick;
  public RunIntake(IntakeSubsystem l, Joystick m_driveJoystick) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    driveJoystick = m_driveJoystick;
    m_sub=l;
    addRequirements(m_sub);
  }
  

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    m_sub.go(driveJoystick.getRawAxis(3)-driveJoystick.getRawAxis(2));
    
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return false;
  }
}
