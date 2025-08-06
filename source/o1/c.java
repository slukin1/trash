package o1;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.util.Log;
import java.nio.FloatBuffer;

public class c {

    /* renamed from: h  reason: collision with root package name */
    public static final float[] f16239h;

    /* renamed from: i  reason: collision with root package name */
    public static final float[] f16240i;

    /* renamed from: a  reason: collision with root package name */
    public int f16241a;

    /* renamed from: b  reason: collision with root package name */
    public int f16242b;

    /* renamed from: c  reason: collision with root package name */
    public int f16243c;

    /* renamed from: d  reason: collision with root package name */
    public int f16244d;

    /* renamed from: e  reason: collision with root package name */
    public int f16245e;

    /* renamed from: f  reason: collision with root package name */
    public int f16246f;

    /* renamed from: g  reason: collision with root package name */
    public int f16247g;

    static {
        float[] fArr = new float[16];
        f16239h = fArr;
        Matrix.setIdentityM(fArr, 0);
        float[] fArr2 = new float[16];
        f16240i = fArr2;
        Matrix.setIdentityM(fArr2, 0);
        Matrix.translateM(fArr2, 0, 0.0f, 1.0f, 0.0f);
        Matrix.scaleM(fArr2, 0, 1.0f, -1.0f, 1.0f);
    }

    public c(int i11) {
        this.f16241a = i11;
        if (i11 == 0) {
            this.f16247g = 3553;
            this.f16242b = c("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
        } else if (i11 == 1) {
            this.f16247g = 36197;
            this.f16242b = c("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
        } else {
            throw new RuntimeException("Unhandled type " + i11);
        }
        int i12 = this.f16242b;
        if (i12 != 0) {
            int glGetAttribLocation = GLES20.glGetAttribLocation(i12, "aPosition");
            this.f16245e = glGetAttribLocation;
            b(glGetAttribLocation, "aPosition");
            int glGetAttribLocation2 = GLES20.glGetAttribLocation(this.f16242b, "aTextureCoord");
            this.f16246f = glGetAttribLocation2;
            b(glGetAttribLocation2, "aTextureCoord");
            int glGetUniformLocation = GLES20.glGetUniformLocation(this.f16242b, "uMVPMatrix");
            this.f16243c = glGetUniformLocation;
            b(glGetUniformLocation, "uMVPMatrix");
            int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.f16242b, "uTexMatrix");
            this.f16244d = glGetUniformLocation2;
            b(glGetUniformLocation2, "uTexMatrix");
            return;
        }
        throw new RuntimeException("Unable to create program");
    }

    public static void a(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            String str2 = str + ": glError 0x" + Integer.toHexString(glGetError);
            Log.e("Texture2dProgram", str2);
            throw new RuntimeException(str2);
        }
    }

    public static void b(int i11, String str) {
        if (i11 < 0) {
            throw new RuntimeException("Unable to locate '" + str + "' in program");
        }
    }

    public static int c(String str, String str2) {
        int f11;
        int f12 = f(35633, str);
        if (f12 == 0 || (f11 = f(35632, str2)) == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        a("glCreateProgram");
        if (glCreateProgram == 0) {
            Log.e("Texture2dProgram", "Could not create program");
        }
        GLES20.glAttachShader(glCreateProgram, f12);
        a("glAttachShader");
        GLES20.glAttachShader(glCreateProgram, f11);
        a("glAttachShader");
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] == 1) {
            return glCreateProgram;
        }
        Log.e("Texture2dProgram", "Could not link program: ");
        Log.e("Texture2dProgram", GLES20.glGetProgramInfoLog(glCreateProgram));
        GLES20.glDeleteProgram(glCreateProgram);
        return 0;
    }

    public static int f(int i11, String str) {
        int glCreateShader = GLES20.glCreateShader(i11);
        a("glCreateShader type=" + i11);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        Log.e("Texture2dProgram", "Could not compile shader " + i11 + ":");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(" ");
        sb2.append(GLES20.glGetShaderInfoLog(glCreateShader));
        Log.e("Texture2dProgram", sb2.toString());
        GLES20.glDeleteShader(glCreateShader);
        return 0;
    }

    public int d() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        a("glGenTextures");
        int i11 = iArr[0];
        GLES20.glBindTexture(this.f16247g, i11);
        a("glBindTexture " + i11);
        float f11 = 9728.0f;
        GLES20.glTexParameterf(this.f16247g, 10241, 9728.0f);
        int i12 = this.f16247g;
        if (i12 != 3553) {
            f11 = 9729.0f;
        }
        GLES20.glTexParameterf(i12, 10240, f11);
        GLES20.glTexParameteri(this.f16247g, 10242, 33071);
        GLES20.glTexParameteri(this.f16247g, 10243, 33071);
        a("glTexParameter");
        return i11;
    }

    public void e(float[] fArr, FloatBuffer floatBuffer, int i11, int i12, int i13, int i14, float[] fArr2, FloatBuffer floatBuffer2, int i15, int i16) {
        a("draw start");
        GLES20.glUseProgram(this.f16242b);
        a("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.f16247g, i15);
        float[] fArr3 = fArr;
        GLES20.glUniformMatrix4fv(this.f16243c, 1, false, fArr, 0);
        a("glUniformMatrix4fv");
        GLES20.glUniformMatrix4fv(this.f16244d, 1, false, fArr2, 0);
        a("glUniformMatrix4fv");
        GLES20.glEnableVertexAttribArray(this.f16245e);
        a("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.f16245e, i13, 5126, false, i14, floatBuffer);
        a("glVertexAttribPointer");
        GLES20.glEnableVertexAttribArray(this.f16246f);
        a("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.f16246f, 2, 5126, false, i16, floatBuffer2);
        a("glVertexAttribPointer");
        int i17 = i11;
        int i18 = i12;
        GLES20.glDrawArrays(5, i11, i12);
        a("glDrawArrays");
        GLES20.glDisableVertexAttribArray(this.f16245e);
        GLES20.glDisableVertexAttribArray(this.f16246f);
        GLES20.glBindTexture(this.f16247g, 0);
        GLES20.glUseProgram(0);
    }

    public void g(int i11, Bitmap bitmap) {
        GLES20.glBindTexture(this.f16247g, i11);
        GLUtils.texImage2D(this.f16247g, 0, bitmap, 0);
    }

    public void h() {
        Log.d("Texture2dProgram", "deleting program " + this.f16242b);
        GLES20.glDeleteProgram(this.f16242b);
        this.f16242b = -1;
    }
}
