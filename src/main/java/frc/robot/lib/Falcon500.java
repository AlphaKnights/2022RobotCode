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
        motor2 = new TalonFX(talonFxID);
    }

    @Override
    public void set(double speed) {
        if(speed<0.025&&speed>-0.025){
            motor.set(ControlMode.PercentOutput, 0);
            motor.setNeutralMode(NeutralMode.Coast);
            motor2.set(ControlMode.PercentOutput, 0);
            motor2.setNeutralMode(NeutralMode.Coast);
            // System.out.println("Coast");

        }
        else{
            motor.set(ControlMode.PercentOutput, speed);
            motor.setNeutralMode(NeutralMode.Coast);
            motor2.set(ControlMode.PercentOutput, speed);
            motor2.setNeutralMode(NeutralMode.Coast);
            // System.out.println("Drive");

        }
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
