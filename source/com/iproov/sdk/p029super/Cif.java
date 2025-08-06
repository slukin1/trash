package com.iproov.sdk.p029super;

import android.content.Context;
import android.opengl.GLES20;
import com.iproov.sdk.logging.IPLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.iproov.sdk.super.if  reason: invalid class name and invalid package */
public class Cif {
    /* renamed from: do  reason: not valid java name */
    public static int m1877do() {
        return m1878do(3553);
    }

    /* renamed from: do  reason: not valid java name */
    public static int m1878do(int i11) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(i11, iArr[0]);
        if (i11 == 36197) {
            GLES20.glTexParameterf(36197, 10241, 9729.0f);
            GLES20.glTexParameterf(36197, 10240, 9729.0f);
            GLES20.glTexParameteri(36197, 10242, 33071);
            GLES20.glTexParameteri(36197, 10243, 33071);
        } else {
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameteri(3553, 10242, 10497);
            GLES20.glTexParameteri(3553, 10243, 10497);
        }
        return iArr[0];
    }

    /* renamed from: do  reason: not valid java name */
    public static int m1880do(Context context, int i11, int i12) {
        return m1881do(m1882do(context, i11), m1882do(context, i12));
    }

    /* renamed from: do  reason: not valid java name */
    public static int m1881do(String str, String str2) {
        int i11;
        int glCreateProgram;
        int i12 = m1879do(35633, str);
        if (i12 == 0 || (i11 = m1879do(35632, str2)) == 0 || (glCreateProgram = GLES20.glCreateProgram()) == 0) {
            return 0;
        }
        GLES20.glAttachShader(glCreateProgram, i12);
        GLES20.glAttachShader(glCreateProgram, i11);
        GLES20.glLinkProgram(glCreateProgram);
        return glCreateProgram;
    }

    /* renamed from: do  reason: not valid java name */
    public static int m1879do(int i11, String str) {
        int glCreateShader = GLES20.glCreateShader(i11);
        if (glCreateShader == 0) {
            return 0;
        }
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        IPLog.e("MyGLUtils", GLES20.glGetShaderInfoLog(glCreateShader));
        GLES20.glDeleteShader(glCreateShader);
        return 0;
    }

    /* renamed from: do  reason: not valid java name */
    private static String m1882do(Context context, int i11) {
        try {
            InputStream openRawResource = context.getResources().openRawResource(i11);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            for (int read = openRawResource.read(); read != -1; read = openRawResource.read()) {
                byteArrayOutputStream.write(read);
            }
            String byteArrayOutputStream2 = byteArrayOutputStream.toString();
            openRawResource.close();
            return byteArrayOutputStream2;
        } catch (IOException unused) {
            return "";
        }
    }
}
