
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import java.util.function.DoubleSupplier;

import frc.robot.subsystems.SubsystemCannons;

public class FireCannons extends Command {

    private final SubsystemCannons m_subsystemCannons;
    private int cannonNum;

    /**
     * @param cannonNum The cannon to be fired
     * @param subsystem The cannons subsystem utilized
     */
    public FireCannons(int cannonNum, SubsystemCannons subsystem) {
        this.cannonNum = cannonNum;
        m_subsystemCannons = subsystem;
        addRequirements(m_subsystemCannons);
    }

    @Override
    public void initialize() {
        m_subsystemCannons.fireCannons(cannonNum, m_subsystemCannons);
    }

    @Override
    public void execute() {

    }

    @Override
    public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;

    }
}
