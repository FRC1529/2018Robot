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

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * An example command.  You can replace me with your own command.
 */
public class AutoDriveCommand extends Command {

	boolean isFinished = false;
	
	
	public AutoDriveCommand() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.kDriveTrainSubsystem);
		
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.kDriveTrainSubsystem.enc.reset();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	public void execute() {
		//System.out.println("EXCUTING");
		Robot.kDriveTrainSubsystem.drive(-.75, -144.0);
		if (Robot.kDriveTrainSubsystem.enc.getDistance() < -144.0){
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
		Timer.delay(1);
		Robot.kDriveTrainSubsystem.enc.reset();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
