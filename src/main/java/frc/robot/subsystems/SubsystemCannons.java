
package frc.robot.subsystems;

import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.ScheduleCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.util.regex.Pattern;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;

import frc.robot.subsystems.*;

public class SubsystemCannons extends SubsystemBase {

    private Compressor airCompressor;
    private Solenoid solenoidY;
    private Solenoid solenoidB;
    private Solenoid solenoidA;
    private Solenoid solenoidX;
    private Solenoid solenoidHorn;

    public SubsystemCannons() {
        airCompressor = new Compressor(0, PneumaticsModuleType.CTREPCM);
        addChild("Air Compressor", airCompressor);

        solenoidY = new Solenoid(0, PneumaticsModuleType.CTREPCM, Constants.PWMChannel.cannonY);
        addChild("Solenoid Y", solenoidY);
        solenoidY.setPulseDuration(.2);

        solenoidB = new Solenoid(0, PneumaticsModuleType.CTREPCM, Constants.PWMChannel.cannonB);
        addChild("Solenoid B", solenoidB);
        solenoidB.setPulseDuration(.2);

        solenoidA = new Solenoid(0, PneumaticsModuleType.CTREPCM, Constants.PWMChannel.cannonA);
        addChild("Solenoid A", solenoidA);
        solenoidA.setPulseDuration(.2);

        solenoidX = new Solenoid(0, PneumaticsModuleType.CTREPCM, Constants.PWMChannel.cannonX);
        addChild("Solenoid X", solenoidX);
        solenoidX.setPulseDuration(.2);

        solenoidHorn = new Solenoid(0, PneumaticsModuleType.CTREPCM, Constants.PWMChannel.horn);
        addChild("Horn", solenoidHorn);
        solenoidHorn.setPulseDuration(.2);

    }

    @Override
    public void periodic() {

    }

    @Override
    public void simulationPeriodic() {

    }

    public void fireCannons(int numCannon, SubsystemCannons m_subsystemCannons) {
        switch (numCannon) {
            case 0:
                solenoidY.startPulse();
                break;
            case 1:
                solenoidB.startPulse();
                break;
            case 2:
                solenoidA.startPulse();
                break;
            case 3:
                solenoidX.startPulse();
                break;
        }
    }

    public void fireHorn(int pulseTime)
    {
        solenoidHorn.setPulseDuration(pulseTime);
        solenoidHorn.startPulse();
    }

}
