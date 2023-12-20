package frc.robot.subsystems.intake;

import com.ctre.phoenix6.BaseStatusSignal;
import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.math.util.Units;

public class IntakeRollerIOTalonFX implements IntakeRollerIO {
    private final TalonFX falcon;

    private final StatusSignal<Double> rollerVelocity;
    private final StatusSignal<Double> appliedVolts;
    private final StatusSignal<Double> currentAmps;
    
    // Param: ID for roller motor
    public IntakeRollerIOTalonFX(double id) {
        TalonFXConfiguration config = new TalonFXConfiguration();
        config.CurrentLimits.StatorCurrentLimit = 30;
        config.CurrentLimits.StatorCurrentLimitEnable = true;
        config.MotorOutput.NeutralMode = NeutralModeValue.Coast;

        falcon = new TalonFX(id);

        falcon.getConfigurator().apply(config);

        rollerVelocity = falcon.getVelocity();
        appliedVolts = falcon.getMotorVoltage();
        currentAmps = falcon.getStatorCurrent();

        BaseStatusSignal.setUpdateFrequencyForAll(100, rollerVelocity, appliedVolts, currentAmps);

    }

    @Override
    public void updateInputs(IntakeRollerIOInputs inputs) {
        inputs.pivotPosition = this.pivotPosition;
        inputs.pivotVelocity = this.pivotVelocity;
        inputs.appliedVolts = this.appliedVolts;
        inputs.currentAmps = this.currentAmps;
    }

    @Override 

    public void setVelocity(double velocity) {
        falcon.setVelocity(velocity);
    }

    @Override
    public void stop() {
        throw Error("Not Implemented Yet") // remove this line when you start
        falcon.setVelocity(0);
    }

    @Override
    public void configurePID(double kP, double kI, double kD) {
        Slot0Configs config = new Slot0Configs();

        config.kP = kP;
        config.kI = kI;
        config.kD = kD;

        falcon.getConfigurator().apply(config);
    }
}
