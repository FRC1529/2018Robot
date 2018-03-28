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
				addSequential(new AutoPneumaticsCommand(false));
			
				addSequential(new AutoHandRotateCommand(.25, 2));
				
				addSequential(new AutoDriveCommand(.5, 192));
				
				addSequential(new AutoTurnCommand(90, "right"));
				
				addSequential(new AutoDriveCommand(.5, 188));
				
				addSequential(new AutoTurnCommand(90, "left"));
				
				addSequential(new AutoDriveCommand(.5, 52));
				
				addParallel(new ArmRaiseCommand(.5,67));
				
				addSequential(new IntakeCommand(.7, 30));

				addSequential(new AutoTurnCommand(180, "right"));
				
				addSequential(new AutoDriveCommand(.5, 52));	
				
				addSequential(new AutoTurnCommand(90, "right"));
				
				addSequential(new AutoDriveCommand(.5, 12));	
				
				addSequential(new AutoTurnCommand(90, "left"));
				
				addSequential(new AutoDriveCommand(.5, 16));	
				
				addParallel(new AutoPneumaticsCommand(false));
				
				addSequential(new AutoTurnCommand(70, "right"));	
				
				addSequential(new IntakeCommand(1, 25));
				break;
				
			case "RIGHT":
				addSequential(new AutoPneumaticsCommand(false));
				
				addSequential(new AutoHandRotateCommand(.25, 2));
				
				addSequential(new AutoDriveCommand(.5, 192));
				
				addSequential(new AutoTurnCommand(90, "right"));
				
				addSequential(new AutoDriveCommand(.5, 188));
				
				addSequential(new AutoTurnCommand(90, "left"));
				
				addSequential(new AutoDriveCommand(.5, 52));
				
				addParallel(new ArmRaiseCommand(.5,67));
				
				addSequential(new AutoPneumaticsCommand(true));
				
				addSequential(new AutoTurnCommand(180, "right"));
				
				addSequential(new AutoDriveCommand(.5, 52));	
				
				addSequential(new AutoTurnCommand(90, "right"));
				
				addSequential(new AutoDriveCommand(.5, 12));	
				
				addSequential(new AutoTurnCommand(90, "left"));
				
				addSequential(new AutoDriveCommand(.5, 16));	
				
				addParallel(new AutoPneumaticsCommand(false));
				
				addSequential(new IntakeCommand(.3, 25));
				break;
			default:
				addSequential(new AutoDriveCommand(.5, 250));
				break;
			
		}
		
    	}
    }

