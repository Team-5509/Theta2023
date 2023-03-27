package frc.robot.commands.autons;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveXFeetold;
import frc.robot.subsystems.DriveTrain;

public class Drive extends SequentialCommandGroup{
    public Drive(DriveTrain drivetrain){
        new DriveXFeetold(-6, drivetrain);
    }
    
}
