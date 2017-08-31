package org.firstinspires.ftc.teamcode;

        import com.qualcomm.robotcore.eventloop.opmode.OpMode;
        import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
        import com.qualcomm.robotcore.hardware.DcMotor;
        import com.qualcomm.robotcore.hardware.DcMotorSimple;
        import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="(green)This is not cool", group="I like turtles")


public class Dry extends OpMode
{
    DcMotor dryMotorBackLeft;
    DcMotor dryMotorBackRight;
    DcMotor golfPutter;
    double x;
    double y;
    Servo arm1;
    Servo arm2;
    Servo pinballRight;
    Servo pinballLeft;
    Servo pusher;

    public void init ()
    {
        dryMotorBackLeft = hardwareMap.dcMotor.get("dryMotorBackLeft");
        dryMotorBackRight = hardwareMap.dcMotor.get("dryMotorBackRight");
        golfPutter = hardwareMap.dcMotor.get("golfPutter");
        arm1 = hardwareMap.servo.get("arm1");
        arm2 = hardwareMap.servo.get("arm2");
        pinballLeft = hardwareMap.servo.get("pinballRight");
        pinballRight = hardwareMap.servo.get("pinballLeft");
        pusher = hardwareMap.servo.get("pusher");

        dryMotorBackLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        pinballRight.setDirection(Servo.Direction.REVERSE);
    }
    public void loop()
    {
        y = gamepad1.left_stick_y;
        y = gamepad1.right_stick_y;

        dryMotorBackLeft.setPower(-gamepad1.left_stick_y);
        dryMotorBackRight.setPower(-gamepad1.right_stick_y);

        if(golfPutter.getPower() < -0.75)
        {
            golfPutter.setPower(-0.75);
        }

        else if(golfPutter.getPower() > 0.75)
        {
            golfPutter.setPower(0.75);
        }

        else
        {
            golfPutter.setPower(-gamepad2.right_stick_y);
        }


        if (gamepad2.x)
         {
             arm1.setPosition(.3);
         }
        else
        {
            arm1.setPosition(0);
        }

        if (gamepad2.y)
        {
            arm2.setPosition(.7);
        }
        else
        {
            arm2.setPosition(1);
        }

        if (gamepad2.a)
        {
            pinballLeft.setPosition(0);
            pinballRight.setPosition(0);
        }
        else
        {
            pinballLeft.setPosition(1);
            pinballRight.setPosition(1);
        }

        if (gamepad2.left_bumper)
        {
            pusher.setPosition(0);
        }
        else
        {
            pusher.setPosition(.5);
        }


        telemetry.addData("right",dryMotorBackRight.getPower());
     telemetry.addData("left",dryMotorBackLeft.getPower());
     telemetry.update();
    }
}