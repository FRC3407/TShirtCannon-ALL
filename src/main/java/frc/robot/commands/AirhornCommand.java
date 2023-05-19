// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Cannons;

public class AirhornCommand extends CommandBase {
  private final Cannons horn;

  /** Creates a new AirhornCommand. */
  public AirhornCommand(Cannons theCannon) 
  {
    // Use addRequirements() here to declare subsystem dependencies.
    horn = theCannon;
    addRequirements(horn);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
      horn.playHorn(true);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {
      horn.playHorn(false);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
