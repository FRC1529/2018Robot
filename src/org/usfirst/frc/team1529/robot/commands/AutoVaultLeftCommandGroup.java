package org.usfirst.frc.team1529.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoVaultLeftCommandGroup extends CommandGroup {

    public AutoVaultLeftCommandGroup() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	
    	addSequential(new AutoPneumaticsCommand(true));  
    	
    	addSequential(new AutoReverseCommand(-.5, -100, 6));
    	
    	addSequential(new AutoTurnCommand(-25, "left"));
    	
    	addSequential(new AutoDriveCommand(.5, 108, 10));
    	
    	addSequential(new AutoTurnCommand(25, "right"));

    	addSequential(new AutoDriveCommand(.5, 8, 3));
    	
    	addSequential(new IntakeCommand(1,1));
    	
    }
}
