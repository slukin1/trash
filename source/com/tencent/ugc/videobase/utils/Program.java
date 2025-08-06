package com.tencent.ugc.videobase.utils;

import android.opengl.GLES20;
import com.tencent.liteav.base.util.LiteavLog;

public class Program {
    private static final String TAG = "Program";
    private final String mFragmentShader;
    private final String mVertexShader;

    public Program(String str, String str2) {
        this.mVertexShader = str;
        this.mFragmentShader = str2;
    }

    private int loadShader(String str, int i11) {
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

    public int build() {
        int loadShader = loadShader(this.mVertexShader, 35633);
        if (loadShader == 0) {
            LiteavLog.e(TAG, "load vertex shader failed.");
            return -1;
        }
        int loadShader2 = loadShader(this.mFragmentShader, 35632);
        if (loadShader2 == 0) {
            LiteavLog.e(TAG, "load fragment shader failed.");
            GLES20.glDeleteShader(loadShader);
            return -1;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(glCreateProgram, loadShader);
        GLES20.glAttachShader(glCreateProgram, loadShader2);
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] == 0) {
            LiteavLog.e(TAG, "link program failed. status: " + iArr[0]);
            GLES20.glDeleteShader(loadShader);
            GLES20.glDeleteShader(loadShader2);
            GLES20.glDeleteProgram(glCreateProgram);
            return -1;
        }
        GLES20.glDeleteShader(loadShader);
        GLES20.glDeleteShader(loadShader2);
        return glCreateProgram;
    }
}
