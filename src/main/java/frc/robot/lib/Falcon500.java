package frc.robot.lib;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;

public class Falcon500 implements MotorController {
    TalonFX motor;
    
    public Falcon500(int talonFxID){
        motor = new TalonFX(talonFxID);
    }

    @Override
    public void set(double speed) {
        if(speed<0.05&&speed>-0.05){
            motor.set(ControlMode.PercentOutput, 0);
            motor.setNeutralMode(NeutralMode.Coast);
        }
        else{          
            motor.set(ControlMode.PercentOutput, speed);
            motor.setNeutralMode(NeutralMode.Coast);
        }
    }
    
    @Override
    public double get() {
        return motor.getMotorOutputPercent();
    }

    @Override
    public void setInverted(boolean isInverted) {
        motor.setInverted(isInverted);
    }

    @Override
    public boolean getInverted() {
        return motor.getInverted();
    }

    @Override
    public void disable() {
        motor.set(ControlMode.PercentOutput, 0);
        motor.setNeutralMode(NeutralMode.Coast);
    }

    @Override
    public void stopMotor() {
        motor.set(ControlMode.PercentOutput, 0);
        motor.setNeutralMode(NeutralMode.Brake);
    }
}
