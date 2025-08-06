package com.tencent.ugc;

import android.opengl.GLES20;

final /* synthetic */ class fd implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final int f50510a;

    /* renamed from: b  reason: collision with root package name */
    private final float[] f50511b;

    private fd(int i11, float[] fArr) {
        this.f50510a = i11;
        this.f50511b = fArr;
    }

    public static Runnable a(int i11, float[] fArr) {
        return new fd(i11, fArr);
    }

    public final void run() {
        GLES20.glUniformMatrix4fv(this.f50510a, 1, false, this.f50511b, 0);
    }
}
