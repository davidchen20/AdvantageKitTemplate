// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.intake;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  private final IntakePivotIO pivot;
  private final IntakeRollerIO roller;
  private final IntakePivotIOInputsAutoLogged pInputs = new IntakePivotIOInputsAutoLogged();
  private final IntakeRollerIOInputsAutoLogged rInputs = new IntakeRollerIOInputsAutoLogged();
  

  public Intake(IntakePivotIOInputs pivot, IntakeRollerIOInputs roller) {
    this.pivot = pivot;
    this.roller = roller;
  }

  @Override
  public void periodic() {
    pivot.updateInputs(pInputs);
    roller.updateInputs(rInputs);

    Logger.processInputs("Intake Pivot", pInputs);
    Logger.processInputs("Intake Rollers", rInputs);
    // This method will be called once per scheduler run
  }

  
  public void runRollers(double velocity) {
   
    roller.setVelocity(velocity);
  }

  public void stopRollers() {
    rollers.setVelocity(0);
  }

  public void stopPivot() {

    pivot.setVelocity(0);
  }

  public void setPosition(double position) {
    pivot.setPosition(position);
    Logger.processInputs("Pivot Position: ", position);
  }
}
