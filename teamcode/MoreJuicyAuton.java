package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by KBowns on 12/1/2016.
 */
@Autonomous(name="muchmoresauce", group="hellajuice")
public class MoreJuicyAuton extends LinearOpMode
{
    DcMotor juicyMotorFrontLeft;
    DcMotor juicyMotorFrontRight;
    DcMotor juicyMotorBackLeft;
    DcMotor juicyMotorBackRight;
    DcMotor juicySpinny;

    double x;
    double y;

    double startTime;
    Servo thresh;
    Servo baconPusher;


    public void runOpMode() throws InterruptedException {
        juicyMotorFrontLeft = hardwareMap.dcMotor.get("juicyMotorFrontLeft");
        juicyMotorFrontRight = hardwareMap.dcMotor.get("juicyMotorFrontRight");
        juicyMotorBackLeft = hardwareMap.dcMotor.get("juicyMotorBackLeft");
        juicyMotorBackRight = hardwareMap.dcMotor.get("juicyMotorBackRight");
        juicySpinny = hardwareMap.dcMotor.get("juicySpinny");

        thresh = hardwareMap.servo.get("thresh");
        baconPusher = hardwareMap.servo.get("baconPusher");

        thresh.setPosition(1);
        baconPusher.setPosition(0.6);


        waitForStart();

        while (getRuntime() - startTime <= 11 && getRuntime() - startTime > 11.5 && opModeIsActive()) {
            juicyMotorFrontLeft.setPower(0);
            juicyMotorFrontRight.setPower(0);
            juicyMotorBackLeft.setPower(0);
            juicyMotorBackRight.setPower(0);

            telemetry.addData("Status", "Doing Nothing");
            System.out.println("Auton Status: This is running");
        }
        System.out.println("Timer: " + getRuntime());

        while (getRuntime() - startTime >= 11.5 && getRuntime() - startTime < 12 && opModeIsActive())
        {
            thresh.setPosition(0);

            telemetry.addData("Status", "Shooting");
            System.out.println("Auton Status: This may also be running");
        }
        System.out.println("Timer: " + getRuntime());

        while (getRuntime() - startTime >= 12 && getRuntime() - startTime < 14.5 && opModeIsActive())
        {
            juicyMotorFrontLeft.setPower(1);
            juicyMotorFrontRight.setPower(-1);
            juicyMotorBackLeft.setPower(1);
            juicyMotorBackRight.setPower(-1);

            telemetry.addData("Status", "Moving");
            System.out.println("Auton Status: This should be running");

            idle();
        }
        System.out.println("Timer: " + getRuntime());
    }
}