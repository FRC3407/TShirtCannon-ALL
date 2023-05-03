
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import java.util.function.DoubleSupplier;

import frc.robot.subsystems.SubsystemCannons;

public class FireHorn extends CommandBase {

    private final SubsystemCannons m_subsystemCannons;
    private int m_time;
    private boolean m_run;
    public FireHorn(int time, SubsystemCannons subsystem, boolean run) {
        m_run = run;
        m_time = time;
        m_subsystemCannons = subsystem;
        addRequirements(m_subsystemCannons);
    }

    @Override
    public void initialize() {
        withTimeout(m_time);
        if(m_run){m_subsystemCannons.fireHorn(m_time);};
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
