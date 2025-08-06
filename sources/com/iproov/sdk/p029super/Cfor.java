package com.iproov.sdk.p029super;

import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.iproov.sdk.super.for  reason: invalid class name and invalid package */
public class Cfor {

    /* renamed from: do  reason: not valid java name */
    private int f1999do = 0;

    /* renamed from: for  reason: not valid java name */
    private int f2000for = 0;

    /* renamed from: if  reason: not valid java name */
    private int f2001if = 0;

    /* renamed from: new  reason: not valid java name */
    private int f2002new;

    /* renamed from: try  reason: not valid java name */
    private int f2003try;

    public Cfor(int i11, int i12, int i13) {
        this.f2002new = i11;
        this.f2003try = i12;
        int[] iArr = new int[1];
        GLES20.glActiveTexture(i13);
        this.f1999do = Cif.m1877do();
        GLES20.glTexImage2D(3553, 0, 6408, i11, i12, 0, 6408, 5121, ByteBuffer.allocateDirect(i11 * i12 * 4).order(ByteOrder.nativeOrder()).asIntBuffer());
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glGenFramebuffers(1, iArr, 0);
        int i14 = iArr[0];
        this.f2000for = i14;
        GLES20.glBindFramebuffer(36160, i14);
        GLES20.glGenRenderbuffers(1, iArr, 0);
        int i15 = iArr[0];
        this.f2001if = i15;
        GLES20.glBindRenderbuffer(36161, i15);
        GLES20.glRenderbufferStorage(36161, 33189, i11, i12);
        m1871case();
    }

    /* renamed from: case  reason: not valid java name */
    public void m1871case() {
        GLES20.glBindFramebuffer(36160, 0);
    }

    /* renamed from: do  reason: not valid java name */
    public void m1872do() {
        m1874if();
        GLES20.glBindFramebuffer(36160, this.f2000for);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.f1999do, 0);
        GLES20.glFramebufferRenderbuffer(36160, 36096, 36161, this.f2001if);
    }

    /* renamed from: for  reason: not valid java name */
    public int m1873for() {
        return this.f2003try;
    }

    /* renamed from: if  reason: not valid java name */
    public void m1874if() {
        GLES20.glViewport(0, 0, this.f2002new, this.f2003try);
    }

    /* renamed from: new  reason: not valid java name */
    public int m1875new() {
        return this.f1999do;
    }

    /* renamed from: try  reason: not valid java name */
    public int m1876try() {
        return this.f2002new;
    }
}
