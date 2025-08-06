package com.iproov.sdk.cameray;

import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Range;
import android.util.Size;
import com.iproov.sdk.cameray.Ccase;
import com.iproov.sdk.p021new.Cnew;
import com.iproov.sdk.p021new.Ctry;
import java.util.ArrayList;

/* renamed from: com.iproov.sdk.cameray.for  reason: invalid class name */
public class Cfor implements Cnew {

    /* renamed from: case  reason: not valid java name */
    private final Range<Integer> f91case;

    /* renamed from: do  reason: not valid java name */
    private final String f92do;

    /* renamed from: else  reason: not valid java name */
    private final Rect f93else;

    /* renamed from: for  reason: not valid java name */
    private final Size f94for;

    /* renamed from: if  reason: not valid java name */
    private final Cbreak f95if;

    /* renamed from: new  reason: not valid java name */
    private final Float f96new;

    /* renamed from: try  reason: not valid java name */
    public final Orientation f97try;

    public Cfor(String str, boolean z11, Cbreak breakR, CameraCharacteristics cameraCharacteristics, Float f11, Ctry tryR) throws Ccase {
        this.f92do = str;
        this.f95if = breakR;
        this.f96new = f11;
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION);
        num = z11 ? Integer.valueOf((num.intValue() + 270) % 360) : num;
        this.f93else = (Rect) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        if (streamConfigurationMap == null) {
            throw new Ccase(Ccase.Cdo.CAMERA_ERROR, "StreamConfiguration unavailable");
        } else if (num != null) {
            this.f97try = Orientation.findByDegrees(num.intValue());
            ArrayList arrayList = new ArrayList();
            for (Size size : streamConfigurationMap.getOutputSizes(SurfaceTexture.class)) {
                arrayList.add(new Size(size.getWidth(), size.getHeight()));
            }
            this.f94for = tryR.m1228do(Cconst.CAMERA2, arrayList);
            this.f91case = Csuper.m196do(cameraCharacteristics, 30);
        } else {
            throw new Ccase(Ccase.Cdo.CAMERA_ERROR, "Camera orientation unavailable");
        }
    }

    /* renamed from: case  reason: not valid java name */
    public Size m131case() {
        return new Size(this.f94for.getWidth(), this.f94for.getHeight());
    }

    /* renamed from: do  reason: not valid java name */
    public Rect m132do() {
        return this.f93else;
    }

    /* renamed from: else  reason: not valid java name */
    public Range<Integer> m133else() {
        return this.f91case;
    }

    /* renamed from: for  reason: not valid java name */
    public Float m134for() {
        return this.f96new;
    }

    /* renamed from: goto  reason: not valid java name */
    public Size m135goto() {
        return new Size(this.f94for.getWidth(), this.f94for.getHeight());
    }

    /* renamed from: if  reason: not valid java name */
    public Cbreak m136if() {
        return this.f95if;
    }

    /* renamed from: new  reason: not valid java name */
    public Orientation m137new() {
        return this.f97try;
    }

    /* renamed from: try  reason: not valid java name */
    public String m138try() {
        return this.f92do;
    }
}
