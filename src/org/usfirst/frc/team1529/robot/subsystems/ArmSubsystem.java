package org.usfirst.frc.team1529.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ArmSubsystem extends Subsystem {
VictorSPX OuterLift = new VictorSPX(5);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
VictorSPX InnerLift = new VictorSPX(6);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void RaiseOuter(){
    	OuterLift.set(ControlMode.PercentOutput, 50);
    }
    public void LowerOuter(){
    	OuterLift.set(ControlMode.PercentOutput, -50);
    }
    public void StopOuter(){
    	OuterLift.set(ControlMode.PercentOutput, 0);
    }
    public void RaiseInner(){
    	InnerLift.set(ControlMode.PercentOutput, 50);
    }
    public void LowerInner(){
    	InnerLift.set(ControlMode.PercentOutput, -50);
    }
    public void StopInner(){
    	InnerLift.set(ControlMode.PercentOutput, 0);
    }
}

