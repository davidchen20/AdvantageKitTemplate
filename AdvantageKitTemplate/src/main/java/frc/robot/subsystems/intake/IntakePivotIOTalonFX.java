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

public class IntakePivotIOTalonFX implements IntakePivotIO{
    private final TalonFX falcon;

    private final StatusSignal<Double> pivotPosition;
    private final StatusSignal<Double> pivotVelocity;
    private final StatusSignal<Double> appliedVolts;
    private final StatusSignal<Double> currentAmps;

    public IntakePivotIOTalonFX(int id) {
        TalonFXConfiguration config = new TalonFXConfiguration();
        config.CurrentLimits.StatorCurrentLimit = 30;
        config.CurrentLimits.StatorCurrentLimitEnable = true;
        config.MotorOutput.NeutralMode = NeutralModeValue.Brake;
        falcon = new TalonFX(id);

        falcon.getConfigurator().apply(config);

        pivotPosition = falcon.getPosition();
        pivotVelocity = falcon.getVelocity();
        appliedVolts = falcon.getMotorVoltage();
        currentAmps = falcon.getStatorCurrent();

        BaseStatusSignal.setUpdateFrequencyForAll(100, pivotPosition, pivotVelocity, appliedVolts, currentAmps);

    }

    @Override
    // TODO: implement this function the update all the attributes of the IntakePivotIOInputs object passed in
    // Params: object of IntakePivotIOInputs 
    // Return: this function returns void
    public void updateInputs(IntakePivotIOInputs inputs) {
        throw Error("Not Implemented Yet") // remove this line when you start
    }

    @Override
    // TODO: implement this function to set the pivot motor to move to a given positional value
    // Params: fill in the function parameters as need by the implementation above
    // Return: this function returns void
    public void setPosition(<REPLACE_WITH_PARAM>) {
        throw Error("Not Implemented Yet") // remove this line when you start
    }

    @Override 
    // TODO: implement this function to set the pivot motor to move to a given velocity
    // Params: fill in the function parameters as need by the implementation above
    // Return: this function returns void
    public void setVelocity(<REPLACE_WITH_PARAM>) {
        throw Error("Not Implemented Yet") // remove this line when you start
    }

    @Override
    // TODO: implement this function to stop the pivot motor
    // Params: none
    // Return: this function returns void
    public void stop() {
        throw Error("Not Implemented Yet") // remove this line when you start
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
