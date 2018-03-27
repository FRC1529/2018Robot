package org.usfirst.frc.team1529.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ClimbSubsystem extends Subsystem {
		VictorSPX Climb = new VictorSPX(3);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void Raise(){
    	Climb.set(ControlMode.PercentOutput,50);
    }
    public void Lower(){
    	Climb.set(ControlMode.PercentOutput,-50);
    	}
    public void Stop(){
    	Climb.set(ControlMode.PercentOutput, 0);
    }
}

