// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.Joystick;


public class Robot extends TimedRobot {
  //INITIALIZE HERE

  private static final double SOLENOID_DURATION = 0.1;  // seconds

  private Joystick Joy;
  private SpeedController left;
  private SpeedController right;
  private DifferentialDrive dDrive;
  private Solenoid Sole;
  private Solenoid Sole2;
  private Solenoid Sole3;
  private Solenoid Sole4;
  private Compressor Compy;

  @Override
  public void robotInit() {
    //VARIABLES GO HERE
    Joy = new Joystick(0);
    left = new PWMVictorSPX(1);
    right = new PWMVictorSPX(0);
    dDrive = new DifferentialDrive(left, right);
    Sole = new Solenoid(0);
    Sole2 = new Solenoid(1);
    Sole3 = new Solenoid(2);
    Sole4 = new Solenoid(3);
    Sole.setPulseDuration(SOLENOID_DURATION);
    Sole2.setPulseDuration(SOLENOID_DURATION);
    Sole3.setPulseDuration(SOLENOID_DURATION);
    Sole4.setPulseDuration(SOLENOID_DURATION);
    Compy = new Compressor();
    //left.setInverted(true);
    //right.setInverted(true);
  }
  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}
  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    Compy.setClosedLoopControl(true);
  }
  @Override
  public void teleopPeriodic() {
    System.out.println("Stick1: " + Joy.getRawAxis(1));
    dDrive.tankDrive(Joy.getRawAxis(1) * -1,Joy.getRawAxis(5) * -1);
    System.out.println("Apparent speed: " + left.get());

    if(Joy.getRawButton(1)){
      //a
      Sole.startPulse();
    }
    if(Joy.getRawButton(2)){
      //b
      Sole2.startPulse();
    }
    if(Joy.getRawButton(3)){
      //x
      Sole3.startPulse();
    }
    if(Joy.getRawButton(4)){
      //y
      Sole4.startPulse();
    }
//a=1 x=3 b=2 y=4

  }

  @Override
  public void disabledInit() {
    Compy.setClosedLoopControl(false);
  }
  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}
  @Override
  public void testPeriodic() {}


}