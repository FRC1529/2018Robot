/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1529.robot;

import org.usfirst.frc.team1529.robot.commands.LowerClimbCommand;
import org.usfirst.frc.team1529.robot.commands.RaiseClimbCommand;
import org.usfirst.frc.team1529.robot.commands.ReverseDriveCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is an	y button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.
	public Joystick leftStick = new Joystick(0);
	public Joystick rightStick = new Joystick(1);
	public Joystick Operator = new Joystick(2);
	// LIFT
	public Button rJoystickDown = new JoystickButton(Operator, 1);
	public Button rJoystickUp = new JoystickButton(Operator, 2);
	// HAND ROTATE
	public Button lJoystickDown = new JoystickButton(rightStick, 3);
	public Button lJoystickUp = new JoystickButton(rightStick, 4);
	// Intakes
	public Button intakeOut = new JoystickButton(Operator, 5);
	public Button intakeIn = new JoystickButton(Operator, 6);
	public Button handClose = new JoystickButton(Operator, 7);
	public Button handOpen = new JoystickButton(Operator, 8);
	public Button scaleUp = new JoystickButton(Operator, 19);
	public Button scaleDown = new JoystickButton(Operator,20);
	public Button Switch = new JoystickButton(Operator, 11);
	public Button SPEED = new JoystickButton(Operator, 15);
	public Button handLimp = new JoystickButton(Operator, 13);
	public Button Vault = new JoystickButton(Operator, 14);
	//public Joystick otherStick = new Joystick(0);
	//Button otherStickButton10 = new JoystickButton(otherStick, 10);
	
	/*public Joystick operatorL = new Joystick(5);
	Button rJoystickDown = new JoystickButton(operatorL, 4);
	Button rJoystickUp = new JoystickButton(operatorL, 5);
	Button lJoystickDown = new JoystickButton(operatorL, 6);
	Button lJoystickUp = new JoystickButton(operatorL, 7);
	Button topRight = new JoystickButton(operatorL, 8);*/
//	Joystick rightStick = new Joystick(1);
//	Button rightStickButton1 = new JoystickButton(rightStick, 1);
//	

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	public void initializeButtons(){
		System.out.println("OPERATING BUTTONS INIT");
		leftStick = new Joystick(0);
		rightStick = new Joystick(1);
		Operator = new Joystick(2);

		
	}
	
}
