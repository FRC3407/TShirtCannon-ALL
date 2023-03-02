
package frc.robot.subsystems;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;

public class SubsystemCannons extends SubsystemBase {

    private Compressor airCompressor;
    private Solenoid solenoidY;
    private Solenoid solenoidB;
    private Solenoid solenoidA;
    private Solenoid solenoidX;

    public SubsystemCannons() {
        airCompressor = new Compressor(0, PneumaticsModuleType.CTREPCM);
        addChild("Air Compressor", airCompressor);

        solenoidY = new Solenoid(0, PneumaticsModuleType.CTREPCM, 0);
        addChild("Solenoid Y", solenoidY);
        solenoidY.setPulseDuration(.2);

        solenoidB = new Solenoid(0, PneumaticsModuleType.CTREPCM, 1);
        addChild("Solenoid B", solenoidB);
        solenoidB.setPulseDuration(.2);

        solenoidA = new Solenoid(0, PneumaticsModuleType.CTREPCM, 2);
        addChild("Solenoid A", solenoidA);
        solenoidA.setPulseDuration(.2);

        solenoidX = new Solenoid(0, PneumaticsModuleType.CTREPCM, 3);
        addChild("Solenoid X", solenoidX);
        solenoidX.setPulseDuration(.2);

    }

    @Override
    public void periodic() {

    }

    @Override
    public void simulationPeriodic() {

    }

    public void fireCannons(int numCannon) {
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

}
