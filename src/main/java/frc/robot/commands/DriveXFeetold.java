package frc.robot.commands;
import edu.wpi.first.math.*;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.DriveTrain;

public class DriveXFeetold extends PIDCommand{
    private final DriveTrain driveTrain;

    public DriveXFeetold (double FeetToDrive, DriveTrain DriveTrain){
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
                    -.675, 
                    .675
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
        //6.6/0.0110643577=596.51;  
        //6.6=0.0110643577*596.51;
        //1.5/0.0110643577=135.57;
        //90.3803029=1/0.0110643577
        //11ft to move from ends of scoring zone (y axis)

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
