package com.sumsub.sns.internal.ml.facedetector.models;

import android.graphics.PointF;
import android.graphics.RectF;
import java.util.List;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final float f35101a;

    /* renamed from: b  reason: collision with root package name */
    public final RectF f35102b;

    /* renamed from: c  reason: collision with root package name */
    public final List<PointF> f35103c;

    public c(float f11, RectF rectF, List<? extends PointF> list) {
        this.f35101a = f11;
        this.f35102b = rectF;
        this.f35103c = list;
    }

    public final RectF a() {
        return this.f35102b;
    }

    public final List<PointF> b() {
        return this.f35103c;
    }

    public final float c() {
        return this.f35101a;
    }
}
