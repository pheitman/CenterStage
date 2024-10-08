/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode.sample;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.hardware.SampleColorSensor;
import org.firstinspires.ftc.teamcode.hardware.SampleIRSensor;
import org.firstinspires.ftc.teamcode.hardware.SampleMotor;
import org.firstinspires.ftc.teamcode.hardware.SampleServo;
import org.firstinspires.ftc.teamcode.hardware.SampleTouchSensor;
import org.firstinspires.ftc.teamcode.hardware.OpModeIsActive;

/**
 * This particular OpMode demonstrates how to access a variety of motors and sensors
 */

@Autonomous(name="SampleAutonomous", group="Sample")
public class SampleAutonomous extends LinearOpMode implements OpModeIsActive {

    static final double DRIVE_SPEED = 0.6;
    static final double TURN_SPEED = 0.5;

    @Override
    public void runOpMode() {

        /* Initialize the hardware variables.
         * The constructor of the hardware class does all the work here
         */
        SampleMotor motor = new SampleMotor( hardwareMap, "demo motor", true );
        SampleServo servo = new SampleServo( hardwareMap, "demo servo" );
        SampleTouchSensor touchSensor = new SampleTouchSensor( hardwareMap, "demo touch" );
        SampleColorSensor colorSensor = new SampleColorSensor( hardwareMap, "demo touch", telemetry );
        SampleIRSensor irSensor = new SampleIRSensor( hardwareMap, "demo ir");

        /* Declare OpMode members. */
        final double SERVO_SPEED     = 0.02 ;                   // sets rate to move servo

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Say", "Hello Driver");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        motor.drive( DRIVE_SPEED, 12.0, 20.0, this, telemetry );

        sleep(4000 );

        motor.drive( DRIVE_SPEED,-36.0,60.0, this, telemetry );

        sleep(4000 );
    }

    @Override
    public boolean isActive() {
        return opModeIsActive();
    }
}
