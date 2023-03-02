
package frc.robot;

import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command.InterruptionBehavior;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
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
    SmartDashboard.putData("Solenoid 0", new FireCannons(0, m_subsystemCannons));
    SmartDashboard.putData("Solenoid 1", new FireCannons(1, m_subsystemCannons));
    SmartDashboard.putData("Solenoid 2", new FireCannons(2, m_subsystemCannons));
    SmartDashboard.putData("Solenoid 3", new FireCannons(3, m_subsystemCannons));
    

    configureButtonBindings();

    m_driveTrain.setDefaultCommand(new DriveCommand(m_driveTrain));

    m_chooser.setDefaultOption("Autonomous Command", new AutonomousCommand());

    SmartDashboard.putData("Auto Mode", m_chooser);
  }

  public static RobotContainer getInstance() {
    return m_robotContainer;
  }

  private void configureButtonBindings() {
    final JoystickButton xboxButtonX = new JoystickButton(xboxController, XboxController.Button.kA.value);
    xboxButtonX.onTrue(new FireCannons(3, m_subsystemCannons).withInterruptBehavior(InterruptionBehavior.kCancelSelf));

    final JoystickButton xboxButtonA = new JoystickButton(xboxController, XboxController.Button.kA.value);
    xboxButtonA.onTrue(new FireCannons(2, m_subsystemCannons).withInterruptBehavior(InterruptionBehavior.kCancelSelf));

    final JoystickButton xboxButtonB = new JoystickButton(xboxController, XboxController.Button.kB.value);
    xboxButtonB.onTrue(new FireCannons(1, m_subsystemCannons).withInterruptBehavior(InterruptionBehavior.kCancelSelf));

    final JoystickButton xboxButtonY = new JoystickButton(xboxController, XboxController.Button.kY.value);
    xboxButtonY.onTrue(new FireCannons(0, m_subsystemCannons).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
  }

  public XboxController getXboxController() {
    return xboxController;
  }

  public Command getAutonomousCommand() {
    return m_chooser.getSelected();
  }

}
