package frc.robot.subsystems.intake;

import org.littletonrobotics.junction.AutoLog;
import org.littletonrobotics.junction.inputs.LoggableInputs;

import com.ctre.phoenix6.StatusSignal;

public interface IntakePivotIO {
    @AutoLog
    public static class IntakePivotIOInputs {
        public StatusSignal<Double> pivotPosition = 0.0;
        public StatusSignal<Double> pivotVelocity = 0.0;
        public StatusSignal<Double> appliedVolts = 0.0;

        public StatusSignal<Double> currentAmps = 0.0;

        public void setPosition(Double value) {
        }
    }

    public default void updateInputs(IntakePivotIOInputs inputs) {}
    
    public default void setPosition(LoggableInputs position) {}

    public default void setVelocity(double veloicty) {}

    public default void stop() {}

    public default void configurePID(double kP, double kI, double kD) {}
}