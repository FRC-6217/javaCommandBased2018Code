package org.usfirst.frc.team6217.robot.subsystems;

import org.usfirst.frc.team6217.robot.RobotMap;
import org.usfirst.frc.team6217.robot.commands.LiftWithXbox;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Lifts extends Subsystem {
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new LiftWithXbox());	
    }
    //Declaring Variables
	private Spark _acmeScrew1 = new Spark(RobotMap.SPARK_ACMESCREW_1);
	private Spark _acmeScrew2 = new Spark(RobotMap.SPARK_ACMESCREW_2);

    public void OperateLift1(double direction) {
    	//This will change the motor to inverted so there isn't any negative values
    	_acmeScrew1.setInverted(true);
    	
    	//Run the motor if statement
    	if (direction == RobotMap.LIFT_DIRECTION_UP) {
    		_acmeScrew1.set(RobotMap.ACME_SCREW_SPEED_UP);
    	}
    	else if(direction == RobotMap.LIFT_DIRECTION_DOWN) {
    		_acmeScrew1.set(RobotMap.LIFT_DIRECTION_DOWN);
    	}
    	else {
    		_acmeScrew1.stopMotor();
    	}
    }
    	
    public void OperateLift2(double direction) {
        //Run the motor if statement
        if (direction == RobotMap.LIFT_DIRECTION_UP) {
        	_acmeScrew2.set(RobotMap.ACME_SCREW_SPEED_UP);
        }
        else if(direction == RobotMap.LIFT_DIRECTION_DOWN) {
        	_acmeScrew2.set(RobotMap.LIFT_DIRECTION_DOWN);
        }
        else if(direction == RobotMap.LIFT_DIRECTION_FAST) {
        	_acmeScrew2.set(RobotMap.ACME_SCREW_SPEED_FAST);
        }
        else {
        	_acmeScrew2.stopMotor();
    	}
    }
}

