package com.iproov.sdk.p006const;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.RectF;
import android.media.FaceDetector;
import com.iproov.sdk.face.FaceDetector;
import com.iproov.sdk.face.FaceFeatureSmoother;
import com.iproov.sdk.face.a;
import com.iproov.sdk.face.model.FaceFeature;
import com.iproov.sdk.face.model.Pose;
import com.iproov.sdk.logging.IPLog;
import com.xiaomi.mipush.sdk.Constants;

/* renamed from: com.iproov.sdk.const.do  reason: invalid class name and invalid package */
class Cdo implements FaceDetector {

    /* renamed from: for  reason: not valid java name */
    private static final String f217for = ("👱 " + Cdo.class.getSimpleName());

    /* renamed from: do  reason: not valid java name */
    private final FaceFeatureSmoother f218do = new FaceFeatureSmoother(0.2d);

    /* renamed from: if  reason: not valid java name */
    private android.media.FaceDetector f219if;

    public FaceFeature detectFace(Bitmap bitmap) {
        if (this.f219if == null) {
            this.f219if = new android.media.FaceDetector(bitmap.getWidth(), bitmap.getHeight(), 1);
        }
        FaceDetector.Face[] faceArr = new FaceDetector.Face[1];
        Bitmap copy = bitmap.copy(Bitmap.Config.RGB_565, false);
        System.currentTimeMillis();
        this.f219if.findFaces(copy, faceArr);
        System.currentTimeMillis();
        if (faceArr[0] == null) {
            this.f218do.reset();
            return null;
        } else if (faceArr[0].eyesDistance() <= 1.0E-6f) {
            this.f218do.reset();
            return null;
        } else {
            int a11 = a.a(bitmap.getWidth(), bitmap.getHeight());
            double eyesDistance = ((double) (faceArr[0].eyesDistance() / ((float) a11))) * 2.4d;
            if (eyesDistance < 0.0d) {
                String str = f217for;
                IPLog.w(str, "Negative face size (normalisationFactor=" + a11 + ", bitmap size[" + bitmap.getWidth() + Constants.ACCEPT_TIME_SEPARATOR_SP + bitmap.getHeight() + "])");
                this.f218do.reset();
                return null;
            }
            PointF pointF = new PointF();
            faceArr[0].getMidPoint(pointF);
            float f11 = pointF.x;
            float eyesDistance2 = ((float) (((double) faceArr[0].eyesDistance()) * 2.4d)) / 2.0f;
            float f12 = pointF.y;
            return this.f218do.smooth(new FaceFeature(eyesDistance, new RectF(f11 - eyesDistance2, f12 - eyesDistance2, f11 + eyesDistance2, f12 + eyesDistance2), (Pose) null));
        }
    }

    public String getName() {
        return "CLASSIC";
    }

    public void release() {
    }

    public void setOmega(double d11) {
    }
}
