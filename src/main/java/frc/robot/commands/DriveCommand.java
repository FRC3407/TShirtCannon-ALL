
package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import java.util.function.DoubleSupplier;

import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;

public class DriveCommand extends CommandBase {

    private final DriveTrain m_driveTrain;

    public DriveCommand(DriveTrain subsystem) {

        m_driveTrain = subsystem;
        addRequirements(m_driveTrain);

    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        XboxController controller = RobotContainer.getInstance().getXboxController();
        double speed = controller.getRightX();
        double rotation = controller.getRightY();
        m_driveTrain.arcadeDrive(speed, -rotation);
    }

    @Override
    public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;

    }
}
