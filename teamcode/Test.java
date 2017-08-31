package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDCoefficients;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Joseph on 4/18/2017.
 */

public class Test extends OpMode
{
    DcMotor left;
    DcMotor right;

    PIDCoefficients kP;

    Servo Thingy;

    float driveStuff;

    int y;

public void init()
{
    left = hardwareMap.dcMotor.get("Left");
    right = hardwareMap.dcMotor.get("Right");

    left.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    Thingy = hardwareMap.servo.get("Thingy");

    driveStuff = gamepad1.left_stick_y;


}

public void loop() {

    left.setPower(gamepad1.left_stick_y);
    right.setPower(gamepad1.right_stick_y);



    if (gamepad2.a)
    {
        left.setTargetPosition(3600);
    }

    if(gamepad1.dpad_down)
    {
        Thingy.setPosition(0.45);
    }


}

}

