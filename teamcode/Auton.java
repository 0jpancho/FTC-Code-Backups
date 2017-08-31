package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.Timer;

/**
 * Created by Joseph on 4/19/2017.
 */

public class Auton extends LinearOpMode {

    DcMotor left;
    DcMotor right;

    final double FEET_PER_SECOND = 2;
    final double SECONDS_PER_FOOT = 1 / FEET_PER_SECOND;
    double currentThingy = 0;
    double nextThingy = 0;
    double power = 0;

    Timer timer = new Timer();


    public void runOpMode(){

        left = hardwareMap.dcMotor.get("left");
        right = hardwareMap.dcMotor.get("right");


        waitForStart();

        driveDistance(4, 1, -1, true);
        stopMotors(1);
        driveDistance(2, -0.5, 0.5, true);


    }
    public void driveDistance(double distance, double leftPower, double rightPower, boolean forward)
    {
        getRuntime();

        currentThingy = getRuntime();
        nextThingy = currentThingy + distance * SECONDS_PER_FOOT / power;

        while (getRuntime() >= currentThingy && getRuntime() < nextThingy)
        {

            if(forward)
            {
                left.setPower(-leftPower);
                right.setPower(rightPower);
            }

            else
            {
                left.setPower(leftPower);
                right.setPower(-rightPower);
            }
        }
        left.setPower(0);
        right.setPower(0);
    }

    public void stopMotors(double seconds)
    {
        getRuntime();

        currentThingy = getRuntime();
        nextThingy = currentThingy + seconds;

        while(getRuntime() >= nextThingy && getRuntime() < nextThingy)
        {
            left.setPower(0);
            right.setPower(0);
        }
    }
}

