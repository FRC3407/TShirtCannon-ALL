
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import java.util.function.DoubleSupplier;

import frc.robot.subsystems.SubsystemCannons;

public class FireCannons extends CommandBase {

    private final SubsystemCannons m_subsystemCannons;
    private int m_S;

    public FireCannons(int S, SubsystemCannons subsystem) {
        m_S = S;
        m_subsystemCannons = subsystem;
        addRequirements(m_subsystemCannons);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        m_subsystemCannons.fireCannons(m_S);
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
