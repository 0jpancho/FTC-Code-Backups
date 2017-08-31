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
@Autonomous(name="corner", group="tights")

public class corner extends LinearOpMode {
    DcMotor dryMotorBackLeft;
    DcMotor dryMotorBackRight;
    DcMotor golfPutter;
    double x;
    double y;
    double startTime;
    Servo arm1;
    Servo arm2;
    Servo pinballRight;
    Servo pinballLeft;
    Servo pusher;

    public void runOpMode() throws InterruptedException {

        dryMotorBackLeft = hardwareMap.dcMotor.get("dryMotorBackLeft");
        dryMotorBackRight = hardwareMap.dcMotor.get("dryMotorBackRight");
        arm1 = hardwareMap.servo.get("arm1");
        arm2 = hardwareMap.servo.get("arm2");
        pinballLeft = hardwareMap.servo.get("pinballRight");
        pinballRight = hardwareMap.servo.get("pinballLeft");
        pusher = hardwareMap.servo.get("pusher");
        golfPutter = hardwareMap.dcMotor.get("golfPutter");

        pinballRight.setDirection(Servo.Direction.REVERSE);

        waitForStart();

        startTime = getRuntime();
        //backwards
        while (getRuntime() - startTime < 2 && opModeIsActive())
            pusher.setPosition(0);
            sleep(1);
        telemetry.addData("status", "im done 1");

        arm2.setPosition(1);
        arm1.setPosition(0);
        idle();

        while (getRuntime() - startTime >= 2 && getRuntime() - startTime <= 3.5 && opModeIsActive()) {
            dryMotorBackLeft.setPower(.35);
            dryMotorBackRight.setPower(-.35);

            telemetry.addData("status", "im done 2");
            idle();

        }
        while (getRuntime() - startTime >= 3.5 && getRuntime() - startTime <= 4 && opModeIsActive()) {
            dryMotorBackLeft.setPower(0);
            dryMotorBackRight.setPower(0);
            pusher.setPosition(.6);
            sleep(250);
            pusher.setPosition(0);
            sleep(250);
            pusher.setPosition(.6);
            sleep(250);
            pusher.setPosition(0);
            sleep(250);
            pusher.setPosition(.6);
            idle();
        }
        while (getRuntime() - startTime >= 4 && getRuntime() - startTime <= 5 && opModeIsActive()) {
            sleep(250);
            golfPutter.setPower(-.85);
        }
        while (getRuntime() - startTime >= 5 && getRuntime() - startTime <= 5.25 && opModeIsActive()){
            golfPutter.setPower(0);
            idle();
        }

        while (getRuntime() - startTime >= 5.25 && getRuntime() - startTime <= 7.25 && opModeIsActive())
        {
            dryMotorBackLeft.setPower(.35);
            dryMotorBackRight.setPower(-.35);
            telemetry.addData("status","im done 5");

            idle();
        }
        while (getRuntime() - startTime >= 7.25 && getRuntime() - startTime <= 10 && opModeIsActive())
        {
            dryMotorBackLeft.setPower(0);
            dryMotorBackRight.setPower(0);
            telemetry.addData("status","im done 6");
            idle();
        }
    }
}