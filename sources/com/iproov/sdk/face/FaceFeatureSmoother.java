package com.iproov.sdk.face;

import androidx.annotation.Keep;
import com.iproov.sdk.face.model.FaceFeature;
import com.iproov.sdk.face.model.Pose;
import com.iproov.sdk.p017implements.Cclass;
import com.iproov.sdk.p017implements.Cconst;
import com.iproov.sdk.utils.Cfor;
import java.util.Objects;

@Keep
public class FaceFeatureSmoother {
    private final Cconst faceBounds;
    private final Cclass normalizedSize;
    public final Cclass pitch;
    public final Cclass roll;
    public final Cclass yaw;

    public FaceFeatureSmoother(double d11) {
        this.normalizedSize = new Cclass(d11);
        this.faceBounds = new Cconst(d11);
        this.roll = new Cclass(d11);
        this.yaw = new Cclass(d11);
        this.pitch = new Cclass(d11);
    }

    public void reset() {
        this.normalizedSize.m987if();
        this.faceBounds.m988do();
        this.roll.m987if();
        this.yaw.m987if();
        this.pitch.m987if();
    }

    public FaceFeature smooth(FaceFeature faceFeature) {
        Objects.toString(faceFeature.getFaceBounds());
        this.normalizedSize.m986do(Double.valueOf(faceFeature.getNormalizedSize()));
        if (faceFeature.getFaceBounds() != null) {
            this.faceBounds.m989do(faceFeature.getFaceBounds());
        }
        Pose pose = null;
        if (faceFeature.getPose() != null) {
            this.roll.m986do(Double.valueOf(Cfor.m2231do(faceFeature.getPose().roll)));
            this.yaw.m986do(Double.valueOf(Cfor.m2231do(faceFeature.getPose().yaw)));
            this.pitch.m986do(Double.valueOf(Cfor.m2231do(faceFeature.getPose().pitch)));
            pose = new Pose(Cfor.m2233do(this.roll.m985do().doubleValue()), Cfor.m2233do(this.yaw.m985do().doubleValue()), Cfor.m2233do(this.pitch.m985do().doubleValue()));
        }
        FaceFeature faceFeature2 = new FaceFeature(this.normalizedSize.m985do().doubleValue(), this.faceBounds.m990if(), pose);
        Objects.toString(faceFeature2.getFaceBounds());
        return faceFeature2;
    }
}
