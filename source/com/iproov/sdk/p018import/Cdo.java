package com.iproov.sdk.p018import;

import android.opengl.GLES20;
import java.nio.FloatBuffer;

/* renamed from: com.iproov.sdk.import.do  reason: invalid class name and invalid package */
public abstract class Cdo {

    /* renamed from: do  reason: not valid java name */
    public int f966do;

    /* renamed from: for  reason: not valid java name */
    public static void m1066for(int i11, float[] fArr) {
        GLES20.glUniform3fv(i11, 1, FloatBuffer.wrap(fArr));
    }

    /* renamed from: if  reason: not valid java name */
    public static void m1067if(int i11, float[] fArr) {
        GLES20.glUniform2fv(i11, 1, FloatBuffer.wrap(fArr));
    }

    /* renamed from: new  reason: not valid java name */
    public static void m1068new(int i11, float[] fArr) {
        GLES20.glUniform4fv(i11, 1, FloatBuffer.wrap(fArr));
    }

    /* renamed from: do  reason: not valid java name */
    public int m1069do() {
        return this.f966do;
    }

    /* renamed from: for  reason: not valid java name */
    public abstract void m1071for();

    /* renamed from: if  reason: not valid java name */
    public boolean m1072if() {
        return false;
    }

    /* renamed from: do  reason: not valid java name */
    public static void m1064do(int i11, int i12) {
        GLES20.glUniform1i(i11, i12);
    }

    /* renamed from: do  reason: not valid java name */
    public static void m1063do(int i11, float f11) {
        GLES20.glUniform1f(i11, f11);
    }

    /* renamed from: do  reason: not valid java name */
    public static void m1065do(int i11, float[] fArr) {
        GLES20.glUniform1fv(i11, fArr.length, FloatBuffer.wrap(fArr));
    }

    /* renamed from: do  reason: not valid java name */
    public final int m1070do(String str) {
        return GLES20.glGetUniformLocation(this.f966do, str);
    }
}
