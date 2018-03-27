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
    	
    	/** 	startPosition = position;
    	
    	addSequential(new AutoDriveCommand(.5, 144));

    	String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		if(gameData.charAt(0) == 'L')
		{
			//Put left auto code here
			addSequential(new AutoTurnCommand(-70, "left"));
		} else {
			//Put right auto code here
			addSequential(new AutoTurnCommand(75, "right"));
		}
    	    	
    	addSequential(new AutoDriveCommand(.5, 144));**/
    	
 	//addSequential(new AutoDriveCommand(.5, 150));

    	/*Timer timer = new Timer();
    	timer.start();
    	while(timer.get() < 5){
    		Robot.kDriveTrainSubsystem.FrontLeft.set(ControlMode.PercentOutput, .5);
			Robot.kDriveTrainSubsystem.RearLeft.set(ControlMode.PercentOutput, .5);
			Robot.kDriveTrainSubsystem.FrontRight.set(ControlMode.PercentOutput, -.5);
			Robot.kDriveTrainSubsystem.RearRight.set(ControlMode.PercentOutput, -.5);
    	}*/
    		//addSequential(new AutoDriveCommand(.5, 96));
    	if (true)
    	{
    	String gameData;
    	try
    	{
    		gameData = DriverStation.getInstance().getGameSpecificMessage();
    		System.out.print(gameData);
    	}
    	catch (Exception e)
    	{
    		gameData = "Blown";
    		System.out.print(gameData);
    	}
		if(gameData.charAt(0) == 'L')
		{
			addSequential(new AutoHandRotateCommand(.45,96));
			//Put left auto code here
			//addSequential(new AutoTurnCommand(-70, "left"));
		} else if(gameData.charAt(0)=='R') {
			//Put right auto code here
			//addSequential(new AutoTurnCommand(75, "right"));
			addSequential(new AutoHandRotateCommand(.45,96));
		}else{
    	    	
    //	addSequential(new AutoDriveCommand(.5, 144));
			addSequential(new AutoHandRotateCommand(.45,96));
		}
    	}
		}
    }


