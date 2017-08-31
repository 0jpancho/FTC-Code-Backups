package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by KBowns on 12/1/2016.
 */
@Autonomous(name="toomuchsauce", group="hellajuice")
public class JuicyAuton extends LinearOpMode
{
    DcMotor juicyMotorFrontLeft;
    DcMotor juicyMotorFrontRight;
    DcMotor juicyMotorBackLeft;
    DcMotor juicyMotorBackRight;
    DcMotor juicySpinny;
    //DcMotor juicyLauncherLeft;
    //DcMotor juicyLauncherRight;
    double x;
    double y;
    double startTime;
    Servo baconPusher;
    Servo thresh;


    public void runOpMode() throws InterruptedException
    {
        juicyMotorFrontLeft = hardwareMap.dcMotor.get("juicyMotorFrontLeft");
        juicyMotorFrontRight = hardwareMap.dcMotor.get("juicyMotorFrontRight");
        juicyMotorBackLeft = hardwareMap.dcMotor.get("juicyMotorBackLeft");
        juicyMotorBackRight = hardwareMap.dcMotor.get("juicyMotorBackRight");
        juicySpinny = hardwareMap.dcMotor.get("juicySpinny");
        //juicyLauncherLeft = hardwareMap.dcMotor.get("juicyLauncherLeft");
        //juicyLauncherRight = hardwareMap.dcMotor.get("juicyLauncherRight");
        baconPusher = hardwareMap.servo.get("baconPusher");
        thresh = hardwareMap.servo.get("thresh");

        waitForStart();

        while (getRuntime() - startTime < 11 && opModeIsActive())
        {
            juicyMotorFrontLeft.setPower(0);
            juicyMotorFrontRight.setPower(0);
            juicyMotorBackLeft.setPower(0);
            juicyMotorBackRight.setPower(0);

            idle();
        }

        while (getRuntime() - startTime >= 11 && getRuntime() - startTime <= 13.5 && opModeIsActive())
        {
            juicyMotorFrontLeft.setPower(1);
            juicyMotorFrontRight.setPower(-1);
            juicyMotorBackLeft.setPower(1);
            juicyMotorBackRight.setPower(-1);

            idle();
        }

    }


}
