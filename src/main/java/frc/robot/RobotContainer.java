
package frc.robot;

import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command.InterruptionBehavior;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.*;

public class RobotContainer {

  private static RobotContainer m_robotContainer = new RobotContainer();

  public final SubsystemCannons m_subsystemCannons = new SubsystemCannons();
  public final DriveTrain m_driveTrain = new DriveTrain();

  private final XboxController xboxController = new XboxController(0);

  SendableChooser<Command> m_chooser = new SendableChooser<>();

  private RobotContainer() {

    SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
    SmartDashboard.putData("Solenoid 0", new FireHorn(0, m_subsystemCannons,true));
    SmartDashboard.putData("Solenoid 1", new FireHorn(1, m_subsystemCannons,true));
    SmartDashboard.putData("Solenoid 2", new FireHorn(2, m_subsystemCannons,true));
    SmartDashboard.putData("Solenoid 3", new FireHorn(3, m_subsystemCannons,true));
    

    configureButtonBindings();

    m_driveTrain.setDefaultCommand(new DriveCommand(m_driveTrain));

    m_chooser.setDefaultOption("Autonomous Command", new AutonomousCommand());

    SmartDashboard.putData("Auto Mode", m_chooser);
  }

  public static RobotContainer getInstance() {
    return m_robotContainer;
  }

  SequentialCommandGroup createCommandGroup(int[] pattern)
  {
    SequentialCommandGroup sequentialCommandGroup = new SequentialCommandGroup();
    for (int index = 0; index < pattern.length; index++) {
      if(index%2!=0){sequentialCommandGroup.addCommands(new FireHorn(pattern[index], m_subsystemCannons,false));}
      if(index%2==0){sequentialCommandGroup.addCommands(new FireHorn(pattern[index], m_subsystemCannons,true));}
    }
    return sequentialCommandGroup;
  }

  private final int[] patternAInit= new int[]{1,1,1,1,1};
  private final SequentialCommandGroup patternA = createCommandGroup(patternAInit);
  private final int[] patternBInit= new int[]{1,1,1,1,1};
  private final SequentialCommandGroup patternB = createCommandGroup(patternBInit);
  private final int[] patternXInit= new int[]{1,1,1,1,1};
  private final SequentialCommandGroup patternX = createCommandGroup(patternXInit);
  private final int[] patternYInit= new int[]{1,1,1,1,1};
  private final SequentialCommandGroup patternY = createCommandGroup(patternYInit);
  private void configureButtonBindings() {
    final JoystickButton xboxButtonX = new JoystickButton(xboxController, XboxController.Button.kX.value);
    xboxButtonX.onTrue(patternX.andThen(new FireCannons(3, m_subsystemCannons).withInterruptBehavior(InterruptionBehavior.kCancelSelf)));

    final JoystickButton xboxButtonA = new JoystickButton(xboxController, XboxController.Button.kA.value);
    xboxButtonA.onTrue(patternA.andThen(new FireCannons(2, m_subsystemCannons).withInterruptBehavior(InterruptionBehavior.kCancelSelf)));

    final JoystickButton xboxButtonB = new JoystickButton(xboxController, XboxController.Button.kB.value);
    xboxButtonB.onTrue(patternB.andThen(new FireCannons(1, m_subsystemCannons).withInterruptBehavior(InterruptionBehavior.kCancelSelf)));

    final JoystickButton xboxButtonY = new JoystickButton(xboxController, XboxController.Button.kY.value);
    xboxButtonY.onTrue(patternY.andThen(new FireCannons(0, m_subsystemCannons).withInterruptBehavior(InterruptionBehavior.kCancelSelf)));
  }

  public XboxController getXboxController() {
    return xboxController;
  }

  public Command getAutonomousCommand() {
    return m_chooser.getSelected();
  }

}
