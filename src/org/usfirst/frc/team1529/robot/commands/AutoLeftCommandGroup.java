package org.usfirst.frc.team1529.robot.commands;

import org.usfirst.frc.team1529.robot.Robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoLeftCommandGroup extends CommandGroup {

    public AutoLeftCommandGroup(String switchMode) {
      
		switch (switchMode){
			
			case "LEFT":
				System.out.println("LEFT COMMAND GROUP");
				addSequential(new AutoDriveCommand(.5,136));
				addSequential(new AutoTurnCommand(60, "right"));
//				addSequential(new AutoTurnCommand(90, "right"));
//				addSequential(new AutoPneumaticsCommand(true));
//				addSequential(new ArmRaiseCommand(.5,67));
				addSequential(new IntakeCommand(.5, 1));
				//addSequential(new ChangeNeturalMode(NeutralMode.Brake));
				break;
			case "RIGHT":
				
				addSequential(new AutoDriveCommand(.5,185));
				addSequential(new AutoTurnCommand(70, "right"));
				addSequential(new AutoDriveCommand(.5,150));
				addSequential(new AutoTurnCommand(70, "right"));
				addSequential(new IntakeCommand(.5, 1));
//				addSequential(new AutoDriveCommand(.5,96));
//				addSequential(new AutoTurnCommand(90, "left"));
//				addSequential(new AutoPneumaticsCommand(true));
//				addSequential(new ArmRaiseCommand(.5,67));
//				addSequential(new IntakeCommand(1, 25));
				break;
			
			default:
				
				
				addSequential(new AutoDriveCommand(.5,136));
				addSequential(new AutoTurnCommand(60, "right"));
//				addSequential(new AutoTurnCommand(90, "right"));
//				addSequential(new AutoPneumaticsCommand(true));
//				addSequential(new ArmRaiseCommand(.5,67));
				//addSequential(new IntakeCommand(.5, 1));
				
				break;
			
			
		}
    }
}