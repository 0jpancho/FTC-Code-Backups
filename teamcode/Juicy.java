package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import java.util.Timer;

import static android.os.SystemClock.sleep;

@TeleOp(name="This is cool(gold)", group="I like turtles")


public class Juicy extends OpMode
{
    DcMotor juicyMotorFrontLeft;
    DcMotor juicyMotorFrontRight;
    DcMotor juicyMotorBackLeft;
    DcMotor juicyMotorBackRight;

    DcMotor juicySpinny;

    DcMotor juicyLauncherLeft;
    DcMotor juicyLauncherRight;

    double x;
    double y;

    Servo baconPusher;
    Servo thresh;
    DcMotor FIYA;
    double motorTimer = 0;


    //Hai
    int cowSezMoo = 1337;


    public void init()
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
        FIYA = hardwareMap.dcMotor.get("FIYA");
/*
        FIYA.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //juicyLauncherRight.setDirection(DcMotorSimple.Direction.REVERSE);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        FIYA.setMode(DcMotor.RunMode.RUN_TO_POSITION); */
    }

    public void loop() {

        //FIYA.setPower(0.75);

        x = gamepad1.left_stick_x;
        y = gamepad1.left_stick_y;


        if (gamepad2.a)
        {
            juicySpinny.setPower(-1);

        }
        else if (gamepad2.x)
        {
            juicySpinny.setPower(1);
        }

        else
        {
            juicySpinny.setPower(0);
        }

        if (gamepad2.left_stick_y < -0.25) {
            FIYA.setPower(0.75);
        } else if (gamepad2.left_stick_y > 0.25) {
            FIYA.setPower(-0.75);
        } else {
            FIYA.setPower(0);
        }


        telemetry.addData("right", juicyMotorFrontRight.getPower());
        telemetry.addData("left", juicyMotorFrontLeft.getPower());
        telemetry.addData("Are we actually running", "Yes");

        /*forward*/
        if (gamepad1.left_stick_y < -0.25) {
            juicyMotorFrontLeft.setPower(-y);
            juicyMotorFrontRight.setPower(y);
            juicyMotorBackLeft.setPower(-y);
            juicyMotorBackRight.setPower(y);
            telemetry.addData("Thing", 1);
        }

        /*backward*/
        else if (gamepad1.left_stick_y > 0.25) {
            juicyMotorFrontLeft.setPower(-y);
            juicyMotorFrontRight.setPower(y);
            juicyMotorBackLeft.setPower(-y);
            juicyMotorBackRight.setPower(y);
            telemetry.addData("Thing", 2);
        }
        /*right*/

        else if (gamepad1.left_stick_x > 0.25) {
            juicyMotorFrontLeft.setPower(x);
            juicyMotorFrontRight.setPower(x);
            juicyMotorBackLeft.setPower(-x);
            juicyMotorBackRight.setPower(-x);
            telemetry.addData("Thing", 3);
        }
        /*left*/
        else if (gamepad1.left_stick_x < -0.25) {
            juicyMotorFrontLeft.setPower(x);
            juicyMotorFrontRight.setPower(x);
            juicyMotorBackLeft.setPower(-x);
            juicyMotorBackRight.setPower(-x);
            telemetry.addData("Thing", 4);

        } else if (gamepad1.b)
        {
            juicyMotorFrontLeft.setPower(1);
            juicyMotorFrontRight.setPower(1);
            juicyMotorBackLeft.setPower(1);
            juicyMotorBackRight.setPower(1);
            telemetry.addData("Thing", 200);

        } else if (gamepad1.x)
        {
            juicyMotorFrontLeft.setPower(-1);
            juicyMotorFrontRight.setPower(-1);
            juicyMotorBackLeft.setPower(-1);
            juicyMotorBackRight.setPower(-1);
            telemetry.addData("Thing", 100);

        }
        //Diagonal Forward Left
        else if (gamepad1.left_stick_y > 0.25 && gamepad1.left_stick_x > 0.25)
        {
            juicyMotorFrontLeft.setPower(1);
            juicyMotorFrontRight.setPower(0);
            juicyMotorBackLeft.setPower(0);
            juicyMotorBackRight.setPower(1);
        }

        else if (gamepad1.left_stick_y > 0.25 && gamepad1.left_stick_x < 0.25)
        {
            juicyMotorFrontLeft.setPower(0);
            juicyMotorFrontRight.setPower(1);
            juicyMotorBackLeft.setPower(1);
            juicyMotorBackRight.setPower(0);
        }


        else if (gamepad1.left_stick_y < 0.25 && gamepad1.left_stick_y > -0.25 && gamepad1.left_stick_x < 0.25 && gamepad1.left_stick_x > -0.25) {
            juicyMotorFrontLeft.setPower(0);
            juicyMotorFrontRight.setPower(0);
            juicyMotorBackLeft.setPower(0);
            juicyMotorBackRight.setPower(0);
            telemetry.addData("Thing", 10);
        }

        else
        {
            telemetry.addData("Thing", "I hate you");
        }

        /*
        if (gamepad2.left_bumper)
        {
            FIYA.setTargetPosition(-7210);
        }
        else if (gamepad2.right_bumper)
        {
            FIYA.setTargetPosition(0);
        }

        else if(gamepad2.right_trigger > 0)
        {
            FIYA.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            FIYA.setPower(gamepad2.left_stick_y);
        }
        else
        {
            FIYA.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }
        */

        telemetry.addData("Are you sure?", "Yup");

        //juicyLauncherLeft.setPower(-gamepad2.left_trigger);
        //juicyLauncherRight.setPower(-gamepad2.left_trigger);

        if (gamepad2.dpad_down) {
            baconPusher.setPosition(1);

        } else {
            baconPusher.setPosition(0);
        }

        if (gamepad2.dpad_up) {

            thresh.setPosition(1);

        } else {
            thresh.setPosition(0);
        }
        telemetry.addData("juicyMotorFrontLeft", juicyMotorFrontLeft.getPower());
        telemetry.addData("juicyMotorFrontRight", juicyMotorFrontRight.getPower());

    }
}


