package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by KBowns on 12/1/2016.
 */
@Autonomous(name="drydry", group="need some water")

public class DryAuton extends LinearOpMode {
    DcMotor dryMotorBackLeft;
    DcMotor dryMotorBackRight;
    double x;
    double y;
    double startTime;
    Servo arm1;
    Servo arm2;
    Servo pinballRight;
    Servo pinballLeft;
    Servo pusher;

    public void runOpMode() throws InterruptedException
    {

        dryMotorBackLeft = hardwareMap.dcMotor.get("dryMotorBackLeft");
        dryMotorBackRight = hardwareMap.dcMotor.get("dryMotorBackRight");
        arm1 = hardwareMap.servo.get("arm1");
        arm2 = hardwareMap.servo.get("arm2");
        pinballLeft = hardwareMap.servo.get("pinballRight");
        pinballRight = hardwareMap.servo.get("pinballLeft");
        pusher = hardwareMap.servo.get("pusherl");


        dryMotorBackLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        pinballRight.setDirection(Servo.Direction.REVERSE);

        waitForStart();

        startTime = getRuntime();

        while (getRuntime() - startTime < 9 && opModeIsActive())
        {
            dryMotorBackLeft.setPower(0);
            dryMotorBackRight.setPower(0);

            idle();
        }

        while (getRuntime() - startTime >= 9 && getRuntime() - startTime <= 12 && opModeIsActive())
        {
            dryMotorBackLeft.setPower(.35);
            dryMotorBackRight.setPower(.35);

            idle();
        }

    }
}