package frc.robot.commands;
import edu.wpi.first.math.*;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.DriveTrain;

public class DriveXFeet extends PIDCommand{
    private final DriveTrain driveTrain;
    public DriveXFeet (double FeetToDrive, DriveTrain DriveTrain){
        super(new PIDController(
            .2,
            0, 
            0
        ), 
            DriveTrain::distanceTraveledInFeet, 
            FeetToDrive, 
            output->DriveTrain.driveArcade(
                MathUtil.clamp(
                    output, 
                    -.3, 
                    .3
                ),
                0
            ), 
            DriveTrain
        ); 
        this.driveTrain = DriveTrain;
    }
    
    @Override

    public void initialize(){
        driveTrain.ResetEncoders();
    }

    @Override
    public boolean isFinished(){
        return getController().atSetpoint();
    }

    @Override
    public void execute(){
        super.execute();
    }
}
