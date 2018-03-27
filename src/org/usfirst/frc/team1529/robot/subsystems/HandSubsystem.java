package org.usfirst.frc.team1529.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class HandSubsystem extends Subsystem {
	public VictorSPX LeftIntake = new VictorSPX(18);
	public VictorSPX RightIntake = new VictorSPX(12);
	public VictorSPX HandRotate = new VictorSPX(10);
	public DoubleSolenoid Solenoid = new DoubleSolenoid(4, 5);
	public Encoder handEnc = new Encoder(4,5,false, Encoder.EncodingType.k4X);

	
	//actuators
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

  //  public void initDefaultCommand() {
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    
    
    public void OpenGrip(boolean air){	
    		Solenoid.set(DoubleSolenoid.Value.kForward);
    }
    public void CloseGrip(boolean air){
		Solenoid.set(DoubleSolenoid.Value.kReverse);
    }
    public void Intake(double speed){
    	LeftIntake.set(ControlMode.PercentOutput, speed);
    	RightIntake.set(ControlMode.PercentOutput, -speed);
    }
    public void OutTake(double speed){
    	LeftIntake.set(ControlMode.PercentOutput, -speed);
    	RightIntake.set(ControlMode.PercentOutput, speed);
    }
    public void DropHand(double speed){
    	HandRotate.set(ControlMode.PercentOutput, speed);
    }
    public void RaiseHand(double speed){
    	HandRotate.set(ControlMode.PercentOutput, -speed);
    }
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		handEnc.setDistancePerPulse(((1.2*3.14159)/360)/36);
	}
}

