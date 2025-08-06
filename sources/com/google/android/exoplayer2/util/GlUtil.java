package com.google.android.exoplayer2.util;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLU;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public final class GlUtil {
    private static final String EXTENSION_PROTECTED_CONTENT = "EGL_EXT_protected_content";
    private static final String EXTENSION_SURFACELESS_CONTEXT = "EGL_KHR_surfaceless_context";
    private static final String TAG = "GlUtil";

    public static final class Attribute {
        private Buffer buffer;
        private final int index;
        private final int location;
        public final String name;
        private int size;

        public Attribute(int i11, int i12) {
            int i13 = i11;
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(i13, 35722, iArr, 0);
            byte[] bArr = new byte[iArr[0]];
            int[] iArr2 = new int[1];
            int i14 = iArr[0];
            int i15 = i11;
            int i16 = i12;
            GLES20.glGetActiveAttrib(i15, i16, i14, iArr2, 0, new int[1], 0, new int[1], 0, bArr, 0);
            String str = new String(bArr, 0, GlUtil.strlen(bArr));
            this.name = str;
            this.location = GLES20.glGetAttribLocation(i13, str);
            this.index = i12;
        }

        public void bind() {
            GLES20.glBindBuffer(34962, 0);
            GLES20.glVertexAttribPointer(this.location, this.size, 5126, false, 0, (Buffer) Assertions.checkNotNull(this.buffer, "call setBuffer before bind"));
            GLES20.glEnableVertexAttribArray(this.index);
            GlUtil.checkGlError();
        }

        public void setBuffer(float[] fArr, int i11) {
            this.buffer = GlUtil.createBuffer(fArr);
            this.size = i11;
        }
    }

    public static final class Uniform {
        private final int location;
        public final String name;
        private int texId;
        private final int type;
        private int unit;
        private final float[] value = new float[16];

        public Uniform(int i11, int i12) {
            int i13 = i11;
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(i13, 35719, iArr, 0);
            int[] iArr2 = new int[1];
            byte[] bArr = new byte[iArr[0]];
            int i14 = iArr[0];
            int i15 = i11;
            int i16 = i12;
            GLES20.glGetActiveUniform(i15, i16, i14, new int[1], 0, new int[1], 0, iArr2, 0, bArr, 0);
            String str = new String(bArr, 0, GlUtil.strlen(bArr));
            this.name = str;
            this.location = GLES20.glGetUniformLocation(i13, str);
            this.type = iArr2[0];
        }

        public void bind() {
            int i11 = this.type;
            if (i11 == 5126) {
                GLES20.glUniform1fv(this.location, 1, this.value, 0);
                GlUtil.checkGlError();
            } else if (i11 == 35676) {
                GLES20.glUniformMatrix4fv(this.location, 1, false, this.value, 0);
                GlUtil.checkGlError();
            } else if (this.texId != 0) {
                GLES20.glActiveTexture(this.unit + 33984);
                int i12 = this.type;
                if (i12 == 36198) {
                    GLES20.glBindTexture(36197, this.texId);
                } else if (i12 == 35678) {
                    GLES20.glBindTexture(3553, this.texId);
                } else {
                    int i13 = this.type;
                    StringBuilder sb2 = new StringBuilder(36);
                    sb2.append("unexpected uniform type: ");
                    sb2.append(i13);
                    throw new IllegalStateException(sb2.toString());
                }
                GLES20.glUniform1i(this.location, this.unit);
                GLES20.glTexParameteri(3553, 10240, 9729);
                GLES20.glTexParameteri(3553, 10241, 9729);
                GLES20.glTexParameteri(3553, 10242, 33071);
                GLES20.glTexParameteri(3553, 10243, 33071);
                GlUtil.checkGlError();
            } else {
                throw new IllegalStateException("call setSamplerTexId before bind");
            }
        }

        public void setFloat(float f11) {
            this.value[0] = f11;
        }

        public void setFloats(float[] fArr) {
            System.arraycopy(fArr, 0, this.value, 0, fArr.length);
        }

        public void setSamplerTexId(int i11, int i12) {
            this.texId = i11;
            this.unit = i12;
        }
    }

    private GlUtil() {
    }

    private static void addShader(int i11, String str, int i12) {
        int glCreateShader = GLES20.glCreateShader(i11);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = {0};
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 1) {
            String glGetShaderInfoLog = GLES20.glGetShaderInfoLog(glCreateShader);
            StringBuilder sb2 = new StringBuilder(String.valueOf(glGetShaderInfoLog).length() + 10 + String.valueOf(str).length());
            sb2.append(glGetShaderInfoLog);
            sb2.append(", source: ");
            sb2.append(str);
            throwGlError(sb2.toString());
        }
        GLES20.glAttachShader(i12, glCreateShader);
        GLES20.glDeleteShader(glCreateShader);
        checkGlError();
    }

    public static void checkGlError() {
        while (true) {
            int glGetError = GLES20.glGetError();
            if (glGetError != 0) {
                String valueOf = String.valueOf(GLU.gluErrorString(glGetError));
                Log.e(TAG, valueOf.length() != 0 ? "glError ".concat(valueOf) : new String("glError "));
            } else {
                return;
            }
        }
    }

    public static int compileProgram(String[] strArr, String[] strArr2) {
        return compileProgram(TextUtils.join("\n", strArr), TextUtils.join("\n", strArr2));
    }

    public static FloatBuffer createBuffer(float[] fArr) {
        return (FloatBuffer) createBuffer(fArr.length).put(fArr).flip();
    }

    public static int createExternalTexture() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, IntBuffer.wrap(iArr));
        GLES20.glBindTexture(36197, iArr[0]);
        GLES20.glTexParameteri(36197, 10241, 9729);
        GLES20.glTexParameteri(36197, 10240, 9729);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        checkGlError();
        return iArr[0];
    }

    public static Attribute[] getAttributes(int i11) {
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(i11, 35721, iArr, 0);
        if (iArr[0] == 2) {
            Attribute[] attributeArr = new Attribute[iArr[0]];
            for (int i12 = 0; i12 < iArr[0]; i12++) {
                attributeArr[i12] = new Attribute(i11, i12);
            }
            return attributeArr;
        }
        throw new IllegalStateException("expected two attributes");
    }

    public static Uniform[] getUniforms(int i11) {
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(i11, 35718, iArr, 0);
        Uniform[] uniformArr = new Uniform[iArr[0]];
        for (int i12 = 0; i12 < iArr[0]; i12++) {
            uniformArr[i12] = new Uniform(i11, i12);
        }
        return uniformArr;
    }

    public static boolean isProtectedContentExtensionSupported(Context context) {
        String eglQueryString;
        int i11 = Util.SDK_INT;
        if (i11 < 24) {
            return false;
        }
        if (i11 < 26 && (Constants.REFERRER_API_SAMSUNG.equals(Util.MANUFACTURER) || "XT1650".equals(Util.MODEL))) {
            return false;
        }
        if ((i11 >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) && (eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && eglQueryString.contains(EXTENSION_PROTECTED_CONTENT)) {
            return true;
        }
        return false;
    }

    public static boolean isSurfacelessContextExtensionSupported() {
        String eglQueryString;
        if (Util.SDK_INT >= 17 && (eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && eglQueryString.contains(EXTENSION_SURFACELESS_CONTEXT)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static int strlen(byte[] bArr) {
        for (int i11 = 0; i11 < bArr.length; i11++) {
            if (bArr[i11] == 0) {
                return i11;
            }
        }
        return bArr.length;
    }

    private static void throwGlError(String str) {
        Log.e(TAG, str);
    }

    public static int compileProgram(String str, String str2) {
        int glCreateProgram = GLES20.glCreateProgram();
        checkGlError();
        addShader(35633, str, glCreateProgram);
        addShader(35632, str2, glCreateProgram);
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = {0};
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] != 1) {
            String valueOf = String.valueOf(GLES20.glGetProgramInfoLog(glCreateProgram));
            throwGlError(valueOf.length() != 0 ? "Unable to link shader program: \n".concat(valueOf) : new String("Unable to link shader program: \n"));
        }
        checkGlError();
        return glCreateProgram;
    }

    public static FloatBuffer createBuffer(int i11) {
        return ByteBuffer.allocateDirect(i11 * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    }
}
