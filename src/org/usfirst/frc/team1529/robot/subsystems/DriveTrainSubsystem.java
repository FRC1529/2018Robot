/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1529.robot.subsystems;
import org.usfirst.frc.team1529.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveTrainSubsystem extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	
	
	public static int ENCODER_OFFSET = 12;
	public Encoder enc = new Encoder(0,1,false, Encoder.EncodingType.k4X);
	public Encoder climbEnc = new Encoder(2,3,false, Encoder.EncodingType.k4X);
	public ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	//public int motorFlip = -1;
	
	public double SpeedModifier = 1;
	
	public WPI_VictorSPX FrontLeft = new WPI_VictorSPX(13);
	public WPI_VictorSPX RearLeft  = new WPI_VictorSPX(16);
	public WPI_VictorSPX FrontRight = new WPI_VictorSPX(14);
	public WPI_VictorSPX RearRight = new WPI_VictorSPX(15);
	public Spark LED = new Spark(0);
	
	private SpeedControllerGroup left = new SpeedControllerGroup(FrontLeft, RearLeft), right = new SpeedControllerGroup(FrontRight,RearRight);
	
	private DifferentialDrive chassis = new DifferentialDrive(left, right);
	
	/*public DriveTrainSubsystem()
	{
		FrontLeft.setInverted(true);
		RearLeft.setInverted(true);
	}*/
	
	public void tankDrive(double left, double right)
	{
		chassis.tankDrive(left, right);
	}
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		
		enc.setDistancePerPulse((6*3.14159)/360);
		climbEnc.setDistancePerPulse((((1.25*3.14159)/360)/36)*-4);
		//set pulse for climbEnc
		
	}
	
	public void autoDrive(double speed, double distance) {
		if(enc.getDistance() < distance) {
			
			FrontLeft.set(ControlMode.PercentOutput, speed);
			RearLeft.set(ControlMode.PercentOutput, speed);
			
			FrontRight.set(ControlMode.PercentOutput, -speed);
			RearRight.set(ControlMode.PercentOutput, -speed);
			
        }
	}
	
	public void stop() {
		FrontLeft.set(ControlMode.PercentOutput, 0);
		RearLeft.set(ControlMode.PercentOutput, 0);
		
		FrontRight.set(ControlMode.PercentOutput, 0);
		RearRight.set(ControlMode.PercentOutput, 0);
		
	}
	
	public void flipMotors(){
			//motorFlip = -1 * motorFlip;
		
	}
	public void drive(double left, double right){
		FrontLeft.set(ControlMode.PercentOutput, left *  -SpeedModifier);
		RearLeft.set(ControlMode.PercentOutput, left * -SpeedModifier);
		FrontRight.set(ControlMode.PercentOutput, right * SpeedModifier);
		RearRight.set(ControlMode.PercentOutput, right * SpeedModifier);
	
		
	}
	
	public void setAllMotorMode(NeutralMode mode){
		FrontLeft.setNeutralMode(mode);
		RearLeft.setNeutralMode(mode);
		FrontRight.setNeutralMode(mode);
		RearRight.setNeutralMode(mode);
	}
}
