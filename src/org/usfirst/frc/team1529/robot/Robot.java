/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1529.robot;


import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1529.robot.subsystems.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;

import org.usfirst.frc.team1529.robot.commands.AutoDefaultCommandGroup;
import org.usfirst.frc.team1529.robot.commands.AutoDriveCommand;
import org.usfirst.frc.team1529.robot.commands.AutoDriveForward;
import org.usfirst.frc.team1529.robot.commands.AutoLeftCommandGroup;
import org.usfirst.frc.team1529.robot.commands.AutoMiddleCommandGroup;
import org.usfirst.frc.team1529.robot.commands.AutoRightCommandGroup;
import org.usfirst.frc.team1529.robot.commands.LowerClimbCommand;
import org.usfirst.frc.team1529.robot.commands.RaiseClimbCommand;
import org.usfirst.frc.team1529.robot.commands.TeleopDriveCommand;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you6+ must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static OI m_oi;

	public static String switchMode = "UNKNOWN";
	public static String scaleMode = "UNKNOWN";
	public static String opposingSwitch = "UNKNOWN";
	public static String startingPosition = "UNKNOWN";
	public static String selectedAutoMode = "UNKNOWN";
	
	public static DriveTrainSubsystem kDriveTrainSubsystem = new DriveTrainSubsystem();
	public static ClimbSubsystem kClimbSubsystem = new ClimbSubsystem();
	public static ArmSubsystem kArmSubsystem = new ArmSubsystem();
	public static HandSubsystem kHandSubsystem = new HandSubsystem();
	CommandGroup autoDefaultCommand = new AutoDefaultCommandGroup("default");
	//CommandGroup autoLeftCommand = new AutoLeftCommandGroup();
	//CommandGroup autoMiddleCommand = new AutoMiddleCommandGroup();
	//CommandGroup autoRightCommand = new AutoRightCommandGroup();
	
	
	
	
	CommandGroup autoCommand;
	TeleopDriveCommand TeleOPDriveCommmand = new TeleopDriveCommand();
	Command m_autonomousCommand;
	SendableChooser<String> m_chooser = new SendableChooser<>();
	
	SendableChooser<String> positionChooser = new SendableChooser<>();
	
	
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		m_oi = new OI();
		m_oi.initializeButtons();
		m_chooser.addDefault("Default Auto", "DEFAULT");
		m_chooser.addObject("Left Scale", "LEFTSCALE");
		m_chooser.addObject("Right Scale", "RIGHTSCALE");
		SmartDashboard.putData("Auto mode chooser", m_chooser);
		kDriveTrainSubsystem.gyro.calibrate();
		Robot.kDriveTrainSubsystem.enc.reset();
//		Robot.kDriveTrainSubsystem.initDefaultCommand();
		System.out.println(m_chooser.getSelected());
		
		positionChooser.addDefault("Left", "LEFT");
		positionChooser.addObject("Middle", "MIDDLE");
		positionChooser.addObject("Right", "RIGHT");
		SmartDashboard.putData("Starting Position", positionChooser);
		CameraServer.getInstance().startAutomaticCapture();
//		Robot.kDriveTrainSubsystem.FrontLeft.setNeutralMode(NeutralMode.Coast);
//		Robot.kDriveTrainSubsystem.RearLeft.setNeutralMode(NeutralMode.Coast);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}
	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
	
		getGameData();
		kDriveTrainSubsystem.climbEnc.reset();
		selectedAutoMode = (String) m_chooser.getSelected();
		System.out.println(selectedAutoMode);
		startingPosition = (String) positionChooser.getSelected();
		System.out.println(startingPosition + " " + switchMode);
		//autoCommand = new AutoDriveForward("HI");
		
	switch (startingPosition){
	
			case "LEFT":
					autoCommand = new AutoLeftCommandGroup(switchMode);
			break;
			case "RIGHT":
					autoCommand = new AutoRightCommandGroup(switchMode);
					break;
			case "MIDDLE":
					autoCommand = new AutoMiddleCommandGroup(switchMode);
					break;
			default:
				autoCommand = new AutoDriveForward("Hi Parker");
				break;
	}
		
		Robot.kDriveTrainSubsystem.enc.reset();
		autoCommand.start();
	}

	public void getGameData(){
		String gameData;
    	try
    	{
    		gameData = DriverStation.getInstance().getGameSpecificMessage();
			if (gameData == null){
				return;
			}
			if (!gameData.isEmpty() ) {
				gameData = gameData.toLowerCase();
				
				switchMode = parseGameData(gameData, 0);
				scaleMode = parseGameData(gameData, 1);
				opposingSwitch= parseGameData(gameData,2);
			}
			
    		System.out.print(gameData);
    	}
    	catch (Exception e)
    	{
    		gameData = "ERROR RECIEVING GAME DATA";
    		System.out.print(gameData);
    	}
	}
	
	public String parseGameData(String gameData, int index){
		switch (gameData.charAt(index)){
			case 'l':
				return "LEFT";
			case 'r': 
				return "RIGHT";
			default :
				return "UNKNOWN";
		}
	}
	
	
	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Enc ", kDriveTrainSubsystem.enc.getDistance() );
		SmartDashboard.putNumber("Climb Encoder", kDriveTrainSubsystem.climbEnc.getDistance());
		SmartDashboard.putNumber("Gyro ", kDriveTrainSubsystem.gyro.getAngle());
		//System.out.println("Enczymurgy: " + kDriveTrainSubsystem.enc.getDistance() + " & Gyro: " + kDriveTrainSubsystem.gyro.getAngle());
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autoCommand != null) {
			autoCommand.cancel();
		}
		TeleOPDriveCommmand.start();
		 kDriveTrainSubsystem.climbEnc.reset();
		 kDriveTrainSubsystem.enc.reset();
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Encoder", kDriveTrainSubsystem.enc.getDistance());
		SmartDashboard.putNumber("Climb Encoder", kDriveTrainSubsystem.climbEnc.getDistance());
		SmartDashboard.putNumber("Front Right Motor Voltage", kDriveTrainSubsystem.FrontRight.getMotorOutputVoltage());
		SmartDashboard.putNumber("Front Left Motor Voltage", kDriveTrainSubsystem.FrontLeft.getMotorOutputVoltage());
		SmartDashboard.putNumber("Rear Right Motor Voltage", kDriveTrainSubsystem.RearRight.getMotorOutputVoltage());
		SmartDashboard.putNumber("Rear Left Motor Voltage", kDriveTrainSubsystem.RearLeft.getMotorOutputVoltage());
		SmartDashboard.putNumber("Gyro", kDriveTrainSubsystem.gyro.getAngle());
		//SmartDashboard.putNumber("Arm Encoder", kDr());
		// Camera Server and Settings
		
		//SmartDashboard.putNumber("Climb Speed"	`1, kArmSubsystem.ElevatorMotor.getMotorOutputVoltage());
		System.out.println("ENC: " + kDriveTrainSubsystem.enc.getDistance());
		System.out.println(m_oi.Operator.getRawAxis(1));
		System.out.println(Robot.kDriveTrainSubsystem.gyro.getAngle());
		
		
		//drivetrain
			Robot.kDriveTrainSubsystem.FrontLeft.set(ControlMode.PercentOutput,-m_oi.leftStick.getRawAxis(1));
			Robot.kDriveTrainSubsystem.RearLeft.set(ControlMode.PercentOutput, -m_oi.leftStick.getRawAxis(1));
			Robot.kDriveTrainSubsystem.FrontRight.set(ControlMode.PercentOutput, m_oi.rightStick.getRawAxis(1));
			Robot.kDriveTrainSubsystem.RearRight.set(ControlMode.PercentOutput, m_oi.rightStick.getRawAxis(1));
		
		
		
		//hand rotation
			if(Robot.m_oi.rJoystickDown.get())
			{
				/* this is to lift arms so hooks can engage */
				Robot.kHandSubsystem.HandRotate.set(ControlMode.PercentOutput, .45);
				//this.kHandSubsystem.HandRotate.set(controlmode., arg1);
			}
			else if(Robot.m_oi.rJoystickUp.get())
			{
					/* this is to lower arms into cube pickup/grab position */
					Robot.kHandSubsystem.HandRotate.set(ControlMode.PercentOutput, -.45);
			}
			else
			{
				Robot.kHandSubsystem.HandRotate.set(ControlMode.PercentOutput, 0);
			}
		
			
		//intake wheels	
			if(m_oi.SPEED.get()){
				
				if(m_oi.intakeIn.get()){
					Robot.kHandSubsystem.LeftIntake.set(ControlMode.PercentOutput, 1);
					Robot.kHandSubsystem.RightIntake.set(ControlMode.PercentOutput, -1);
					}
						else if((m_oi.intakeOut.get())){
							Robot.kHandSubsystem.LeftIntake.set(ControlMode.PercentOutput, -1);
							Robot.kHandSubsystem.RightIntake.set(ControlMode.PercentOutput, 1);
						}
								else{
									Robot.kHandSubsystem.LeftIntake.set(ControlMode.PercentOutput, 0);
									Robot.kHandSubsystem.RightIntake.set(ControlMode.PercentOutput, 0);
								}
			}
				else{
					
					if(m_oi.intakeIn.get()){
						Robot.kHandSubsystem.LeftIntake.set(ControlMode.PercentOutput, .6);
						Robot.kHandSubsystem.RightIntake.set(ControlMode.PercentOutput, -.6);
						}
							else if((m_oi.intakeOut.get())){
								Robot.kHandSubsystem.LeftIntake.set(ControlMode.PercentOutput, -.6);
								Robot.kHandSubsystem.RightIntake.set(ControlMode.PercentOutput, .6);
							}
									else{
										Robot.kHandSubsystem.LeftIntake.set(ControlMode.PercentOutput, 0);
										Robot.kHandSubsystem.RightIntake.set(ControlMode.PercentOutput, 0);
									}
				}
			
			
		//intake arms	
			if(m_oi.handOpen.get()){
				Robot.kHandSubsystem.Solenoid.set(DoubleSolenoid.Value.kForward);
				
			}
				else if(m_oi.handClose.get()){
					Robot.kHandSubsystem.Solenoid.set(DoubleSolenoid.Value.kReverse);
				}
					else if(m_oi.handLimp.get()){
						Robot.kHandSubsystem.Solenoid.set(DoubleSolenoid.Value.kOff);
					}

			
		//led junk
			if(Robot.kDriveTrainSubsystem.climbEnc.getDistance() < 5){
				Robot.kDriveTrainSubsystem.LED.set(.69);
			}
				else if(Robot.kDriveTrainSubsystem.climbEnc.getDistance() > 5 && Robot.kDriveTrainSubsystem.climbEnc.getDistance() < 20){
					Robot.kDriveTrainSubsystem.LED.set(.91);
				}
					else if(Robot.kDriveTrainSubsystem.climbEnc.getDistance() > 48 && Robot.kDriveTrainSubsystem.climbEnc.getDistance() < 59){
						Robot.kDriveTrainSubsystem.LED.set(.77);
					}
							else if(Robot.kDriveTrainSubsystem.climbEnc.getDistance() > 60 && Robot.kDriveTrainSubsystem.climbEnc.getDistance() < 72){
								Robot.kDriveTrainSubsystem.LED.set(.65);
							}
									else{
										Robot.kDriveTrainSubsystem.LED.set(.41);
									}
		
			//climb hotkeys
				if(Robot.m_oi.Vault.get()){
					
					if(Robot.kDriveTrainSubsystem.climbEnc.getDistance() > 1){
						Robot.kArmSubsystem.ClimbMotor.set(ControlMode.PercentOutput, -1);
					}
						else{
							Robot.kArmSubsystem.ClimbMotor.set(ControlMode.PercentOutput, 0);
						}
					
				}
					else if(Robot.m_oi.Switch.get()){
						
						if(Robot.kDriveTrainSubsystem.climbEnc.getDistance() > 19){
						Robot.kArmSubsystem.ClimbMotor.set(ControlMode.PercentOutput, -1);
						Robot.kArmSubsystem.ElevatorMotor.set(ControlMode.PercentOutput, -1);
						}
							else if(Robot.kDriveTrainSubsystem.climbEnc.getDistance() < 19){
								Robot.kArmSubsystem.ClimbMotor.set(ControlMode.PercentOutput, 1);
								Robot.kArmSubsystem.ElevatorMotor.set(ControlMode.PercentOutput, 1);
							}
								else{
									Robot.kArmSubsystem.ClimbMotor.set(ControlMode.PercentOutput, 0);
									Robot.kArmSubsystem.ElevatorMotor.set(ControlMode.PercentOutput, 0);
								}
					}
						
						else if(Robot.m_oi.scaleDown.get()){
							
							if(Robot.kDriveTrainSubsystem.climbEnc.getDistance() > 54){
								Robot.kArmSubsystem.ClimbMotor.set(ControlMode.PercentOutput, -1);
								Robot.kArmSubsystem.ElevatorMotor.set(ControlMode.PercentOutput, 1);
							}
								else if(Robot.kDriveTrainSubsystem.climbEnc.getDistance() < 54){
									Robot.kArmSubsystem.ClimbMotor.set(ControlMode.PercentOutput, 1);
									Robot.kArmSubsystem.ElevatorMotor.set(ControlMode.PercentOutput, -1);
								}
									else{
										Robot.kArmSubsystem.ClimbMotor.set(ControlMode.PercentOutput, 0);
										Robot.kArmSubsystem.ElevatorMotor.set(ControlMode.PercentOutput, 0);
									}
						}
							else if(Robot.m_oi.scaleUp.get()){
								
								if(Robot.kDriveTrainSubsystem.climbEnc.getDistance() > 66){
									Robot.kArmSubsystem.ClimbMotor.set(ControlMode.PercentOutput, -1);
									Robot.kArmSubsystem.ElevatorMotor.set(ControlMode.PercentOutput, 1);
								}
								else if(Robot.kDriveTrainSubsystem.climbEnc.getDistance() < 66){
										Robot.kArmSubsystem.ClimbMotor.set(ControlMode.PercentOutput, 1);
										Robot.kArmSubsystem.ElevatorMotor.set(ControlMode.PercentOutput, -1);
									}
										else{
											Robot.kArmSubsystem.ClimbMotor.set(ControlMode.PercentOutput, 0);
											Robot.kArmSubsystem.ElevatorMotor.set(ControlMode.PercentOutput, 0);
										}
							}
								else{
									
									if(m_oi.lJoystickUp.get()){
										Robot.kArmSubsystem.ElevatorMotor.set(ControlMode.PercentOutput, 1);
										Robot.kArmSubsystem.ClimbMotor.set(ControlMode.PercentOutput, -1);
									}
										else if(m_oi.lJoystickDown.get()){
											Robot.kArmSubsystem.ElevatorMotor.set(ControlMode.PercentOutput, -1);
											Robot.kArmSubsystem.ClimbMotor.set(ControlMode.PercentOutput, 1);
										}
											else{
												Robot.kArmSubsystem.ElevatorMotor.set(ControlMode.PercentOutput, 0);
												Robot.kArmSubsystem.ClimbMotor.set(ControlMode.PercentOutput, 0);
											}
								}
							
						}
	

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
