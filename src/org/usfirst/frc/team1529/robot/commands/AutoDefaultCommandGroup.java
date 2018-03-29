package org.usfirst.frc.team1529.robot.commands;

import org.usfirst.frc.team1529.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoDefaultCommandGroup extends CommandGroup {

	private String startPosition;
    public AutoDefaultCommandGroup(String position) {
    	addSequential(new AutoDriveCommand(.5, 100));
    	
		
    }
}

	