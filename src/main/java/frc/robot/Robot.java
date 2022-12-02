// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;


/**
 * This is a demo program showing the use of the RobotDrive class, specifically
 * it contains the code necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {
  private DifferentialDrive m_myRobot;
  
  private final Solenoid Y = new Solenoid(PneumaticsModuleType.CTREPCM, 0);
  private final Solenoid B = new Solenoid(PneumaticsModuleType.CTREPCM, 1);
  private final Solenoid A = new Solenoid(PneumaticsModuleType.CTREPCM, 2);
  private final Solenoid X = new Solenoid(PneumaticsModuleType.CTREPCM, 3);
  private final Solenoid airHorn = new Solenoid(PneumaticsModuleType.CTREPCM, 4);

  private XboxController controller = new XboxController(0);
   
  private final Compressor c = new Compressor (0, PneumaticsModuleType.CTREPCM);
	
      
  @Override
  public void robotInit() {
    PWMVictorSPX left = new PWMVictorSPX(1);
    PWMVictorSPX right = new PWMVictorSPX(0);
    right.setInverted(true);
    m_myRobot = new DifferentialDrive(left, right);
  }
  //m_myRobot.setSafetyEnabled(true);
  //drive.setSensitivity(0.75);

public void teleopPeriodic() {
    final boolean buttonB = controller.getRawButton(2);
    final boolean buttonA = controller.getRawButton(1);
    final boolean buttonX = controller.getRawButton(3);
    final boolean buttonY = controller.getRawButton(4);
    final boolean buttonAirHorn = controller.getRawButton(5);
    //final boolean buttonR = stick.getRawButton(6);
    //double differential = Math.abs(stick.getX() / 4);
    c.enableDigital();
    //drive.arcadeDrive(stick);
    m_myRobot.arcadeDrive(controller.getRightY()*-0.75, controller.getRightX()*-0.75);
    //if (buttonR == true){fff
        //m_myRobot.arcadeDrive(stick.getRawAxis(1)*-0.75, stick.getX()*-1);

    
    if (buttonAirHorn) {
      airHorn.set(true);
    }
    else {
      airHorn.set(false);
    }
    
    if(buttonA){
      A.set(true);
      Timer.delay(0.1);
      A.set(false);
    }
    if (buttonB){
      B.set(true);
      Timer.delay(0.1);
      B.set(false);
    }
    if (buttonX){
      X.set(true);
      Timer.delay(0.1);
      X.set(false);
    }
    if (buttonY){
      Y.set(true);
      Timer.delay(0.1);
      Y.set(false);
    }
    else {
      A.set(false);
      B.set(false);
      X.set(false);
      Y.set(false);
    }
    }
  
  
  
  

/**
 * This function is called periodically during test mode
 */
public void testPeriodic() {

}

}
