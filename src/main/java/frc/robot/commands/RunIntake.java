package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj.Joystick;
public class RunIntake extends CommandBase {
  private final IntakeSubsystem m_sub;
  private Joystick i_joystick;
  public RunIntake(IntakeSubsystem l, Joystick iJoystick) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    i_joystick = iJoystick;
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
    // m_sub.go(i_joystick.getRawAxis(IntakeConstants.)-i_joystick.getRawAxis(2));
    m_sub.go((-2)*(((i_joystick.getPOV()/180))-0.5));
    
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return false;
  }
}
