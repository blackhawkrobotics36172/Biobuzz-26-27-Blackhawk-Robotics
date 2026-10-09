package org.firstinspires.ftc.teamcode.pedro;

import com.pedropathing.follower.Follower;
import com.pedropathing.algorithm.ForesightConfig;
import com.pedropathing.controllers.Controller;
import com.pedropathing.math.Matrix;
import com.pedropathing.math.Vector2D;
import com.pedropathing.revhub.drivetrains.MecanumConfig;
import com.pedropathing.revhub.localizers.PinpointConfig;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class Constants {
    public static Follower create(HardwareMap h) {
        // return new Follower(Drivetrain, Localizer, Foresight);
        return null;
    }
    public static MecanumConfig drivetrainConfig = new MecanumConfig(c -> {
        c.frontLeftName.set("fl");
        c.frontRightName.set("fr");
        c.backLeftName.set("bl");
        c.backRightName.set("br");
        c.frontLeftDirection.set(DcMotorSimple.Direction.FORWARD);
        c.frontRightDirection.set(DcMotorSimple.Direction.FORWARD);
        c.backLeftDirection.set(DcMotorSimple.Direction.FORWARD);
        c.backRightDirection.set(DcMotorSimple.Direction.FORWARD);
    });
    public static PinpointConfig localizerConfig = new PinpointConfig(c -> {
        c.name.set("pinpoint");
        c.podType.set(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD);
        c.xPodOffset.set(-5.827132698119156);
        c.yPodOffset.set(-0.5133411452526183);
        c.xPodDirection.set(GoBildaPinpointDriver.EncoderDirection.FORWARD);
        c.yPodDirection.set(GoBildaPinpointDriver.EncoderDirection.FORWARD);
        c.globalDistanceUnit.set(DistanceUnit.INCH);
        c.offsetUnits.set(DistanceUnit.INCH);
    });
    public static ForesightConfig foresightConfig = new ForesightConfig(
            c -> {
                Controller primaryTranslationalForward = Controller.proportional(0.1941943112529786);
                Controller secondaryTranslationalForward = Controller.proportional(0.07174960904041233);
                Controller primaryTranslationalLateral = Controller.proportional(0.29649511787694816);
                Controller secondaryTranslationalLateral = Controller.proportional(0.109547023560072);

                c.forwardTranslational.set(Controller.piecewise(secondaryTranslationalForward).put(2.5, primaryTranslationalForward));
                c.strafeTranslational.set(Controller.piecewise(secondaryTranslationalLateral).put(2.5, primaryTranslationalLateral));

                c.coast.set(Controller.proportionalFeedforward(0.01624002627135506));
                c.brake.set(Controller.proportionalFeedforward(0.013804022330651802));

                c.headingFeedback.set(Controller.proportional(3.6266278212528453));
                c.headingBrakeCoefficients.set(Vector2D.cartesian(0.04964848230312772, 0.0035972277384617485));

                c.linearBrakeCoefficients.set(Matrix.diag(0.07576628603652229, 0.05173556805738496));
                c.quadraticBrakeCoefficients.set(Matrix.diag(0.0010645468017183518, 0.0014108235483959594));

                c.maxAchievableForwardVelocity.set(63.1637930931206);
                c.maxAchievableStrafeVelocity.set(52.02287855499442);
                c.naturalForwardDeceleration.set(32.76769214920303);
                c.naturalStrafeDeceleration.set(61.67159966342057);
            }
    );
}