// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.intake;

import org.littletonrobotics.junction.Logger;
import org.littletonrobotics.junction.inputs.LoggableInputs;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  private final IntakePivotIO pivot;
  private final IntakeRollerIO roller;
  private final IntakePivotIOInputsAutoLogged pInputs = new IntakePivotIOInputsAutoLogged();
  private final IntakeRollerIOInputsAutoLogged rInputs = new IntakeRollerIOInputsAutoLogged();
  
<<<<<<< Updated upstream

  public Intake(IntakePivotIOInputs pivot, IntakeRollerIOInputs roller) {
=======
  /** Creates a new Intake. */
  // TODO: implement this constructor to instantiate the pivot and roller objects
  // Params: fill in the function parameters as needed by the implementation above
  public Intake(IntakePivotIO pivot, IntakeRollerIO roller) {
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
   
=======
>>>>>>> Stashed changes
    roller.setVelocity(velocity);
  }

  public void stopRollers() {
<<<<<<< Updated upstream
    rollers.setVelocity(0);
=======
    roller.setVelocity(0);
>>>>>>> Stashed changes
  }

  public void stopPivot() {
<<<<<<< Updated upstream

    pivot.setVelocity(0);
  }

  public void setPosition(double position) {
    pivot.setPosition(position);
    Logger.processInputs("Pivot Position: ", position);
=======
    pivot.setVelocity(0);
  
  }

  // TODO: implement this function to set the position of the pivot motor to a given position value then Log the target
  //       position value (see periodic function for hint on how to log)
  // Param: the position the pivot will be set to
  // Return: this function returns void
  public void setPosition(LoggableInputs position) {
    pivot.setPosition(position);
    Logger.processInputs("PivotPosition", position);
>>>>>>> Stashed changes
  }
}
