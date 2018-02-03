package org.usfirst.frc.team1529.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class HandSubsystem extends Subsystem {
	VictorSPX LeftIntake = new VictorSPX(7);
	VictorSPX RightIntake = new VictorSPX(8);
	VictorSPX HandRotate = new VictorSPX(9);
	//actuators
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void OpenGrip(){
    	//actuators
    }
    public void CloseGrip(){
    	//actuators
    }
    public void Intake(){
    	LeftIntake.set(ControlMode.PercentOutput, 75);
    	RightIntake.set(ControlMode.PercentOutput, -75);
    }
    public void OutTake(){
    	LeftIntake.set(ControlMode.PercentOutput, -75);
    	RightIntake.set(ControlMode.PercentOutput, 75);
    }
    public void DropHand(){
    	HandRotate.set(ControlMode.PercentOutput, 50);
    }
    public void RaiseHand(){
    	HandRotate.set(ControlMode.PercentOutput, -50);
    }
}

