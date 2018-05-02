package org.usfirst.frc.team6217.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team6217.robot.RobotMap;
import org.usfirst.frc.team6217.robot.commands.GrabbingWithXbox;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

/**
 *
 */
public class Grabber extends Subsystem {
    public void initDefaultCommand() {
        setDefaultCommand(new GrabbingWithXbox());
    }
    
    private WPI_VictorSPX _rightSideGrabber = new WPI_VictorSPX(RobotMap.VICTOR_SPX_GRABBER_RIGHT);
	private WPI_VictorSPX _leftSideGrabber = new WPI_VictorSPX(RobotMap.VICTOR_SPX_GRABBER_LEFT);
	
    public void RunningRightGrabber(int direction, double speed) {
    	_rightSideGrabber.set(Math.abs(speed)*direction);
    	
    }
    public void RunningLeftGrabber(int direction, double speed) {
    	_leftSideGrabber.setInverted(true);
    	_leftSideGrabber.set(Math.abs(speed)*direction);
    }
    public void RunningGrabber(int direction, double speed) {
    	RunningLeftGrabber(direction,speed);
    	RunningRightGrabber(direction,speed);
    }
    
}

