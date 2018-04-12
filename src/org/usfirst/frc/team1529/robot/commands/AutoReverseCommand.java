/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1529.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1529.robot.Robot;
import org.usfirst.frc.team1529.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * An example command.  You can replace me with your own command.
 */
public class AutoReverseCommand extends Command {
	private Timer timer = new Timer();
	private boolean isFinished;
	private double speed;
	private double distance;
	private int auto_counter;
	private double timeOut = -5;
	
	public AutoReverseCommand(double s, double d) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.kHandSubsystem);
		requires(Robot.kDriveTrainSubsystem);
		speed = s;
		distance = d;
		isFinished = false;
		requires(Robot.kArmSubsystem);

	}
	
	public AutoReverseCommand(double s, double d, double timeOut) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.kHandSubsystem);
		requires(Robot.kDriveTrainSubsystem);
		speed = s;
		distance = d;
		isFinished = false;
		this.timeOut = timeOut;
		requires(Robot.kArmSubsystem);

	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.kDriveTrainSubsystem.enc.reset();
		Robot.kDriveTrainSubsystem.setAllMotorMode(NeutralMode.Brake);
		timer.start();
		
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	public void execute() {
		
		
			Robot.kDriveTrainSubsystem.FrontLeft.set(ControlMode.PercentOutput, speed);
			Robot.kDriveTrainSubsystem.RearLeft.set(ControlMode.PercentOutput, speed	);
			Robot.kDriveTrainSubsystem.FrontRight.set(ControlMode.PercentOutput, -(speed));
			Robot.kDriveTrainSubsystem.RearRight.set(ControlMode.PercentOutput, -(speed));
			if (this.timeOut > 0 && timer.hasPeriodPassed(this.timeOut)){
				isFinished = true;
			}
				
			if(Robot.kDriveTrainSubsystem.enc.getDistance() < distance){
				isFinished = true;
			}

	}
		


	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return isFinished;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.kDriveTrainSubsystem.stop();
		
		Timer.delay(0.1);
		Robot.kDriveTrainSubsystem.enc.reset();
		
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
