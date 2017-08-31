package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import java.util.Timer;

import static android.os.SystemClock.sleep;

@TeleOp(name="This is cooler(gold)", group="I like turtles")


public class JuicyDrive extends OpMode {

    DcMotor juicyMotorFrontLeft;
    DcMotor juicyMotorFrontRight;
    DcMotor juicyMotorBackLeft;
    DcMotor juicyMotorBackRight;


    double x;
    double y;

    public void init()

    {
        juicyMotorFrontLeft = hardwareMap.dcMotor.get("juicyMotorFrontLeft");
        juicyMotorFrontRight = hardwareMap.dcMotor.get("juicyMotorFrontRight");
        juicyMotorBackLeft = hardwareMap.dcMotor.get("juicyMotorBackLeft");
        juicyMotorBackRight = hardwareMap.dcMotor.get("juicyMotorBackRight");
    }

    public void loop() {

        x = gamepad1.left_stick_x;
        y = gamepad1.left_stick_y;

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
        else if (gamepad1.left_stick_y > 0.25)
        {
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
            juicyMotorFrontLeft.setPower(2*x);
            juicyMotorFrontRight.setPower(2*x);
            juicyMotorBackLeft.setPower(2*-x);
            juicyMotorBackRight.setPower(2*-x);
            telemetry.addData("Thing", 4);

        }

        else if (gamepad1.b) {
            juicyMotorFrontLeft.setPower(1);
            juicyMotorFrontRight.setPower(1);
            juicyMotorBackLeft.setPower(1);
            juicyMotorBackRight.setPower(1);
            telemetry.addData("Thing", 200);
        }

        else if (gamepad1.x)
        {
            juicyMotorFrontLeft.setPower(-1);
            juicyMotorFrontRight.setPower(-1);
            juicyMotorBackLeft.setPower(-1);
            juicyMotorBackRight.setPower(-1);
            telemetry.addData("Thing", 100);
        }

        else if (gamepad1.left_stick_y < 0.25 && gamepad1.left_stick_y > -0.25 && gamepad1.left_stick_x < 0.25 && gamepad1.left_stick_x > -0.25) {
            juicyMotorFrontLeft.setPower(0);
            juicyMotorFrontRight.setPower(0);
            juicyMotorBackLeft.setPower(0);
            juicyMotorBackRight.setPower(0);
            telemetry.addData("Thing", 10);

        } /*else if (gamepad1.left_stick_x < 0.25 && gamepad1.left_stick_x > -0.25) {
            juicyMotorFrontLeft.setPower(0);
            juicyMotorFrontRight.setPower(0);
            juicyMotorBackLeft.setPower(0);
            juicyMotorBackRight.setPower(0);
            telemetry.addData("Thing", 9);
        } */else
            {
            telemetry.addData("Thing", "I hate you");
        }
/*
        if (gamepad1.left_stick_y < 0.25 && gamepad1.left_stick_y > -0.25)
        {
            juicyMotorFrontLeft.setPower(0);
            juicyMotorFrontRight.setPower(0);
            juicyMotorBackLeft.setPower(0);
            juicyMotorBackRight.setPower(0);
            telemetry.addData("Thing", 10);
        }
*/

        telemetry.addData("Are you sure?", "Yup");

        telemetry.addData("juicyMotorFrontLeft", juicyMotorFrontLeft.getPower());
        telemetry.addData("juicyMotorFrontRight", juicyMotorFrontRight.getPower());

    }
}


