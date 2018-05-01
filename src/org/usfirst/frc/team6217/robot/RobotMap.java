/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6217.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;
	
	public final double MAXTURNINGSPEED = 0.8;
	public final double PERCENT_ACCEL = 0.01;
	
	public final int VICTOR_SPX_DRIVE_LEFT1	= 40;
	public final int VICTOR_SPX_DRIVE_LEFT2 = 41;
	public final int VICTOR_SPX_DRIVE_RIGHT1 = 42;
	public final int VICTOR_SPX_DRIVE_RIGHT2 = 43;
	public final int VICTOR_SPX_GRABBER_LEFT = 45;
	public final int VICTOR_SPX_GRABBER_RIGHT = 46;
	
	public final int JOYSTICK_DRIVE_PORT = 0;
	public final int JOYSTICK_GAME_PORT = 1;
	public final int GOVERNER_PORT = 3;
	
	public final static int GRABBER_IN = 1;
	public final static int GRABBER_OUT = -1;
	public final static int GRABBER_STOP = 0;

	public final static int GRABBER_IN_BUTTON = 1;//a button In
	public final static int GRABBER_OUT_BUTTON = 2;//b button Out
	public final static int GRABBER_STOP_BUTTON = 3;//x Button Stop
	public final static int GRABBER_SLOW_BUTTON = 4;//y Button Slow In
	public final static int GRABBER_LEFT_SIDE_AXIS = 1;
	public final static int GRABBER_RIGHT_SIDE_AXIS = 5;

	public final static int SPARK_ACMESCREW_1 = 8;
	public final static int SPARK_ACMESCREW_2 = 9;
	public final static int LIFT_DIRECTION_UP = 1;
	public final static int LIFT_DIRECTION_DOWN = -1;
	public final static int LIFT_DIRECTION_FAST = -2;
	public final static int LIFT_DIRECTION_STOP = 0;
	public final static double ACME_SCREW_SPEED_UP = 1;
	public final static double ACME_SCREW_SPEED_DOWN = -0.8;
	public final static double ACME_SCREW_SPEED_FAST = -1;
	

    public final static int LIFT_1_UP = 6; //Right Bumper Button
    public final static int LIFT_1_DOWN = 3; //Right Trigger Button
    public final static int LIFT_1_FAST = 8;//Start button
    public final static int LIFT_2_UP = 5; //Left Bumper Up
    public final static int LIFT_2_DOWN = 2; //Left Trigger Down
    public final static double TRIGGER_PERCENT_PRESS = .25;//trigger have a percent not a one
	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
