package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Joseph on 4/18/2017.
 */
@TeleOp(name = "OtherTest", group = "hellajuicy")
public class OtherTest extends OpMode
{
    DcMotor test;

    public void init()
    {
        test = hardwareMap.dcMotor.get("test");
    }

    public void loop()
    {
        if (gamepad1.a)
        {
            test.setPower(1);
        }

        test.setPower(gamepad1.left_stick_y);
    }

}

