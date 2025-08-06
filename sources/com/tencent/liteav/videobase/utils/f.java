package com.tencent.liteav.videobase.utils;

import android.opengl.GLES20;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final String f22271a;

    /* renamed from: b  reason: collision with root package name */
    public final String f22272b;

    public f(String str, String str2) {
        this.f22271a = str;
        this.f22272b = str2;
    }

    public static int a(String str, int i11) {
        int[] iArr = new int[1];
        int glCreateShader = GLES20.glCreateShader(i11);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        OpenGlUtils.checkGlError("glCompileShader");
        GLES20.glDeleteShader(glCreateShader);
        return 0;
    }
}
