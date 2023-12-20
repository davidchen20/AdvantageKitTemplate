package frc.robot.subsystems.intake;

import org.littletonrobotics.junction.AutoLog;

import com.ctre.phoenix6.StatusSignal;

public interface IntakeRollerIO {
    @AutoLog
    public static class IntakeRollerIOInputs {
        public StatusSignal<Double> rollerVelocity = 0.0;
        public StatusSignal<Double> appliedVolts = 0.0;

        public StatusSignal<Double> currentAmps = 0.0;
    }

    public default void updateInputs(IntakeRollerIOInputs inputs) {}

    public default void setVelocity(double veloicty) {}

    public default void stop() {}

    public default void configurePID(double kP, double kI, double kD) {}
}