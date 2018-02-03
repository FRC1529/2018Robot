/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1529.robot.subsystems;
import org.usfirst.frc.team1529.robot.RobotMap;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
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
	public Encoder enc;
	public ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	public int motorFlip = -1;
	
	Talon FrontLeft = new Talon(7);
	Talon RearLeft  = new Talon(6);
	SpeedControllerGroup left = new SpeedControllerGroup(FrontLeft, RearLeft);
	Talon FrontRight = new Talon(9);
	Talon RearRight = new Talon(8);
	SpeedControllerGroup right = new SpeedControllerGroup(FrontRight, RearRight);
	public DifferentialDrive mydrive =  new DifferentialDrive(left, right);
	
	
	

	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		enc = new Encoder(8,9,false, Encoder.EncodingType.k4X);
		enc.setDistancePerPulse((7.5*3.14159)/360);
		
	}
	
	public void drive(double speed, double distance) {
		if(enc.getDistance() > distance + ENCODER_OFFSET) {
			mydrive.tankDrive(speed * motorFlip, speed * motorFlip, false);
        }
	}
	
	public void stop() {
		mydrive.tankDrive(0, 0, false);
	}
	
	public void flipMotors(){
			motorFlip = -1 * motorFlip;
		
	}
	public void drive(Joystick stick){
		mydrive.tankDrive(stick.getRawAxis(1)* motorFlip, stick.getRawAxis(5)*motorFlip);
	}
}
