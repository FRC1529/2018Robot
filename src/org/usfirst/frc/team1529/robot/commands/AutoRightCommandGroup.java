package org.usfirst.frc.team1529.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoRightCommandGroup extends CommandGroup {

    public AutoRightCommandGroup(String switchMode) {
		switch (switchMode){
			case "LEFT":
				addSequential(new AutoDriveCommand(.5,185));
				addSequential(new AutoTurnCommand(-70, "left"));
				addSequential(new AutoDriveCommand(.5,150));
				addSequential(new AutoTurnCommand(-70, "left"));
				addSequential(new IntakeCommand(.5, 1));
//				addSequential(new AutoDriveCommand(.5,96));
//				addSequential(new AutoTurnCommand(90, "left"));
//				addSequential(new AutoPneumaticsCommand(true));
//				addSequential(new ArmRaiseCommand(.5,67));
//				addSequential(new IntakeCommand(1, 25));
				break;
			case "RIGHT":
				addSequential(new AutoDriveCommand(.5,136));
				addSequential(new AutoTurnCommand(-60, "left"));
//				addSequential(new AutoTurnCommand(90, "right"));
//				addSequential(new AutoPneumaticsCommand(true));
//				addSequential(new ArmRaiseCommand(.5,67));
				addSequential(new IntakeCommand(.5, 1));
				break;
			default:
				addSequential(new AutoDriveCommand(.5,136));
				addSequential(new AutoTurnCommand(-60, "left"));
//				addSequential(new AutoTurnCommand(90, "right"));
//				addSequential(new AutoPneumaticsCommand(true));
//				addSequential(new ArmRaiseCommand(.5,67));
				//addSequential(new IntakeCommand(.5, 1));
				break;
			
		}
		
    	}
    }

