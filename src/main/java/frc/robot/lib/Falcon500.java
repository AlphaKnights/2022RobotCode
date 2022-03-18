package frc.robot.lib;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;

public class Falcon500 implements MotorController {
    TalonFX motor;
    TalonFX motor2;
    
    public Falcon500(int talonFxID, int talonFxID2){
        motor = new TalonFX(talonFxID);
        motor2 = new TalonFX(talonFxID2);
    }

    @Override
    public void set(double speed) {
            motor.set(ControlMode.PercentOutput, speed);
            motor.setNeutralMode(NeutralMode.Coast);
            motor2.set(ControlMode.PercentOutput, speed);
            motor2.setNeutralMode(NeutralMode.Coast);
    }
    
    @Override
    public double get() {
        return motor.getMotorOutputPercent();
    }

    @Override
    public void setInverted(boolean isInverted) {
        motor.setInverted(isInverted);
        motor2.setInverted(isInverted);
    }

    public void setInverted(boolean isInverted, boolean isInverted2) {
        motor.setInverted(isInverted);
        motor2.setInverted(isInverted2);
    }

    @Override
    public boolean getInverted() {
        return motor.getInverted();
    }

    @Override
    public void disable() {
        motor.set(ControlMode.PercentOutput, 0);
        motor.setNeutralMode(NeutralMode.Coast);
        motor2.set(ControlMode.PercentOutput, 0);
        motor2.setNeutralMode(NeutralMode.Coast);
    }

    @Override
    public void stopMotor() {
        motor.set(ControlMode.PercentOutput, 0);
        motor.setNeutralMode(NeutralMode.Brake);
        motor2.set(ControlMode.PercentOutput, 0);
        motor2.setNeutralMode(NeutralMode.Brake);
    }
}
