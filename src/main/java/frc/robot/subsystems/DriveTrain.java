
package frc.robot.subsystems;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;

public class DriveTrain extends SubsystemBase {

    private PWMVictorSPX motorControllerleft;
    private PWMVictorSPX motorControllerright;
    private DifferentialDrive differentialDrive1;

    public DriveTrain() {
        motorControllerleft = new PWMVictorSPX(1);
        addChild("Motor Controller left", motorControllerleft);
        motorControllerleft.setInverted(true);

        motorControllerright = new PWMVictorSPX(0);
        addChild("Motor Controller right", motorControllerright);
        motorControllerright.setInverted(true);

        differentialDrive1 = new DifferentialDrive(motorControllerleft, motorControllerright);
        addChild("Differential Drive 1", differentialDrive1);
        differentialDrive1.setSafetyEnabled(true);
        differentialDrive1.setExpiration(0.1);
        differentialDrive1.setMaxOutput(1.0);

    }

    @Override
    public void periodic() {

    }

    @Override
    public void simulationPeriodic() {

    }

    public void arcadeDrive(double speed, double rotation) {
        differentialDrive1.arcadeDrive(speed, rotation);
    }
}
