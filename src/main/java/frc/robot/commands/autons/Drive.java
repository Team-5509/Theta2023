package frc.robot.commands.autons;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveXFeet;
import frc.robot.subsystems.DriveTrain;

public class Drive extends SequentialCommandGroup{
    public Drive(DriveTrain drivetrain){
        new DriveXFeet(6, drivetrain);
    }
    
}
