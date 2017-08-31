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
@Autonomous(name="extradry", group="tights")

public class extradry extends LinearOpMode {

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

        arm2.setPosition(1);
        arm1.setPosition(0);

        idle();

        while (getRuntime() - startTime >= 2 && getRuntime() - startTime <= 3 && opModeIsActive()) {

            dryMotorBackLeft.setPower(.35);
            dryMotorBackRight.setPower(-.35);

            idle();
        }
        while (getRuntime() - startTime >= 3 && getRuntime() - startTime <= 3.5 && opModeIsActive())
        {
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
        while (getRuntime() - startTime >= 3.5 && getRuntime() - startTime <= 4.5 && opModeIsActive())
        {
            sleep(250);
            golfPutter.setPower(-.75);
        }
        while (getRuntime() - startTime >= 4.5 && getRuntime() - startTime <= 4.75 && opModeIsActive())
        {
            golfPutter.setPower(0);
            idle();
        }
        while (getRuntime() - startTime >= 4.75 && getRuntime() - startTime <= 6.5 && opModeIsActive())
        {
            dryMotorBackLeft.setPower(.35);
            dryMotorBackRight.setPower(-.35);

            idle();
        }
        while (getRuntime() - startTime >= 6.5 && getRuntime() - startTime <= 10 && opModeIsActive())
        {
            dryMotorBackLeft.setPower(0);
            dryMotorBackRight.setPower(0);
            idle();
        }
    }
}