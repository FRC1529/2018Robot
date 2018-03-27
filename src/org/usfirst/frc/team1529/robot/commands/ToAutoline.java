package org.usfirst.frc.team1529.robot.commands;

import org.usfirst.frc.team1529.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class ToAutoline extends InstantCommand {

    public ToAutoline() {
        super();
        // Use requires() here to declare subsystem dependencies
       requires(Robot.kDriveTrainSubsystem);
    }

    // Called once when the command executes
    protected void initialize() {
    	Timer timer= new Timer();
    	timer.start();
    	while (timer.get()<2) {
			Robot.kDriveTrainSubsystem.FrontLeft.set(ControlMode.PercentOutput, -.5);
			Robot.kDriveTrainSubsystem.RearLeft.set(ControlMode.PercentOutput,-.5);
			Robot.kDriveTrainSubsystem.FrontRight.set(ControlMode.PercentOutput,.5);
			Robot.kDriveTrainSubsystem.RearRight.set(ControlMode.PercentOutput,.5);
			
			
		}
    	
    }

}
