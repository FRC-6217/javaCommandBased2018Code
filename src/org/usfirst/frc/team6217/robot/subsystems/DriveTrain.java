package org.usfirst.frc.team6217.robot.subsystems;


import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team6217.robot.commands.DrivingWithJoystick;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
/*
 */
public class DriveTrain extends Subsystem {

	// Put methods for controlling this subsystem
    // here. Call these from Commands.
	private org.usfirst.frc.team6217.robot.RobotMap RobotMap;
	private double speedOfY =0;
	private double speedOfZ =0;
	private double speedOfX =0;
	
	private WPI_VictorSPX _SPX_Left1 = new WPI_VictorSPX(RobotMap.VICTOR_SPX_DRIVE_LEFT1);
	private WPI_VictorSPX _SPX_Left2 = new WPI_VictorSPX(RobotMap.VICTOR_SPX_DRIVE_LEFT2);
	private WPI_VictorSPX _SPX_Right1 = new WPI_VictorSPX(RobotMap.VICTOR_SPX_DRIVE_RIGHT1);
	private WPI_VictorSPX _SPX_Right2 = new WPI_VictorSPX(RobotMap.VICTOR_SPX_DRIVE_RIGHT2);
	
	private SpeedControllerGroup _leftSide = new SpeedControllerGroup(_SPX_Left1,_SPX_Left2);
	private SpeedControllerGroup _rightSide = new SpeedControllerGroup(_SPX_Right1, _SPX_Right2);
	private DifferentialDrive _driveTrain = new DifferentialDrive(_leftSide, _rightSide);
	
	private ADXRS450_Gyro _gyro = new ADXRS450_Gyro(); 
	
	public boolean signbit(double xSignbit) {
		if (xSignbit >= 0) {
			return true;
		}
		else {
			return false;
		}
	}
    
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DrivingWithJoystick());
    }
	
    public void resetGyro() {
    	_gyro.reset();
    }
    
    public void calibrateGyro() {
    	_gyro.calibrate();
    }
    
	public double getGyroValue() {
		
		return _gyro.getAngle();
	}
	public void tankDrive(double rPower, double lPower) {
		_rightSide.set(rPower);
		_leftSide.set(lPower);
	}
	
	public void arcadeDrive(double xDir, double yDir ,double zRotation ,double governer , boolean squaredInputs) {
    	double lastSpeedOfY = 0;
    	double lastSpeedOfX = 0;
    	double lastSpeedOfZ = 0;
    	
    	//Dead Zone
    	xDir = (Math.abs(xDir) < 0.10 ? xDir : 0.0);
    	yDir = (Math.abs(yDir) < 0.10 ? yDir : 0.0);
    	zRotation = (Math.abs(zRotation) < 0.15 ? zRotation :0.0);
    	
    	//Changing the speed according to the dial on the Joystick
    	xDir *= (1-governer);
    	yDir *= (1-governer);
    	zRotation *= (1-governer);
	
    	//Limiting the turning speed to 50%
    	if (zRotation > RobotMap.MAXTURNINGSPEED){
    		zRotation = RobotMap.MAXTURNINGSPEED;
    	}
    	else if (zRotation < -(RobotMap.MAXTURNINGSPEED)){
    		zRotation = -(RobotMap.MAXTURNINGSPEED);
    	}

    	if (xDir > RobotMap.MAXTURNINGSPEED){
    		xDir = RobotMap.MAXTURNINGSPEED;
    	}
    	else if (xDir < -RobotMap.MAXTURNINGSPEED){
    		xDir = -(RobotMap.MAXTURNINGSPEED);
    	}
    	
    	//Acceleration of z
    	//Checking if the Sign of last Speed of z is a different sign of request speed or zRotation
    	if (signbit(zRotation) != signbit(lastSpeedOfZ)){
    		lastSpeedOfZ = 0;
    	}
    	//Do the Acceleration of turning
    	if (zRotation == 0){
    		speedOfZ = 0;
    	}
    	else if (Math.abs(zRotation) <= Math.abs(lastSpeedOfZ)){
    		speedOfZ = zRotation;
    	}
    	else if (Math.abs(zRotation) > Math.abs(lastSpeedOfZ)){
    		speedOfZ = lastSpeedOfZ + (zRotation * RobotMap.PERCENT_ACCEL);
    	}
    	
    	//Acceleration of Y
    	//Checking if the Sign of last Speed of Y is a different sign of request speed or ydir
    	if (signbit(yDir) != signbit(lastSpeedOfY)){
    		lastSpeedOfY = 0;
    	}
    	//Do the Acceleration of turning
    	if (yDir == 0){
    		speedOfY = 0;
    	}
    	else if (Math.abs(yDir) <= Math.abs(lastSpeedOfY)){
    		speedOfY = yDir;
    	}
    	else if (Math.abs(yDir) > Math.abs(lastSpeedOfY)){
    		speedOfY =  lastSpeedOfY + (yDir * RobotMap.PERCENT_ACCEL);
    		if (!signbit(speedOfY) && speedOfY < 0.3){
    			speedOfY = 0.3;
    		}

    		else if (signbit(speedOfY) && speedOfY > -0.3){
    			speedOfY = -0.3;
    		}
    	}

    	//Acceleration of x
    	//Checking if the Sign of last Speed of z is a different sign of request speed or zRotation
    	if (signbit(xDir) != signbit(lastSpeedOfX)){
    		lastSpeedOfX = 0;
    	}
    	//Do the Acceleration of turning
    	if (xDir == 0){
    		speedOfX = 0;
    	}
    	else if (Math.abs(xDir) <= Math.abs(lastSpeedOfX)){
    		speedOfX = xDir;
    	}
    	else if (Math.abs(xDir) > Math.abs(lastSpeedOfX)){
    		speedOfX = lastSpeedOfX + (xDir * RobotMap.PERCENT_ACCEL);
    	}
    	
    	//Setting the Speed
    	_driveTrain.arcadeDrive(speedOfY, speedOfZ, squaredInputs);
    	
    	//Setting the lastSpeed
    	lastSpeedOfZ = speedOfZ;
    	lastSpeedOfY = speedOfY;
    	lastSpeedOfX = speedOfX;
	}
}

