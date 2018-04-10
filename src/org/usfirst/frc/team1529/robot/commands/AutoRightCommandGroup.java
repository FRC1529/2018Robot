package org.usfirst.frc.team1529.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoRightCommandGroup extends CommandGroup {

    public AutoRightCommandGroup(String switchMode) {
    	addSequential(new AutoPneumaticsCommand(true));
		switch (switchMode){
			case "LEFT":
				addSequential(new AutoDriveCommand(.5,185, 5));
				
				break;
			case "RIGHT":
				addSequential(new AutoHandRotateCommand(.25,.20));
				addSequential(new ArmRaiseCommand(.5,3));
				addSequential(new AutoDriveCommand(.25,136,5));
				
				
				//addSequential(new AutoTurnCommand(90, "right"));
				
				addSequential(new IntakeCommand(.5, 1));
				break;
			default:
				addSequential(new AutoDriveCommand(.5,136, 7));
//				addSequential(new AutoTurnCommand(-60, "left"));
//				addSequential(new AutoTurnCommand(90, "right"));
//				addSequential(new AutoPneumaticsCommand(true));
//				addSequential(new ArmRaiseCommand(.5,67));
//				addSequential(new IntakeCommand(.5, 1));
				break;
			
		}
		
    	}
    }

