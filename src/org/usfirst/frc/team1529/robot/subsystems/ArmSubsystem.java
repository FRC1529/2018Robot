package org.usfirst.frc.team1529.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ArmSubsystem extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
public VictorSPX ElevatorMotor = new VictorSPX(11);
public VictorSPX ClimbMotor = new VictorSPX(17);
//public VictorSPX SlackMotor = new VictorSPX(10);
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void Raise(double time, double speed){
    	ElevatorMotor.set(ControlMode.PercentOutput, speed);
    	ClimbMotor.set(ControlMode.PercentOutput, speed);
    	//SlackMotor.set(ControlMode.PercentOutput, -speed);
    }
    public void Lower(double time, double speed){
    	ElevatorMotor.set(ControlMode.PercentOutput, -speed);
    	ClimbMotor.set(ControlMode.PercentOutput, -speed);
    	//SlackMotor.set(ControlMode.PercentOutput, speed);

    }
    public void Stop(){
    	ElevatorMotor.set(ControlMode.PercentOutput, 0);
    	ClimbMotor.set(ControlMode.PercentOutput, 0);
    	//SlackMotor.set(ControlMode.PercentOutput, 0);

    }
}

