// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class PitchThing4a extends CommandBase {

    private double power;
    private long start;
    private long time;
    /**
     * Creates a new ExampleCommand.
     *
     */
    public PitchThing4a(double power, long time) {
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(RobotContainer.arm);
        this.power=power;
        this.time = time;
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        start = System.currentTimeMillis();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        RobotContainer.arm.setRawPitchPower(power);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        RobotContainer.arm.setRawPitchPower(0);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return System.currentTimeMillis() - start >= time;
    }
}
