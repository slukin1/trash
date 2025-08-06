package com.tencent.thumbplayer.tcmedia.g.e.a;

import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f49306a;

    /* renamed from: b  reason: collision with root package name */
    private FloatBuffer f49307b;

    /* renamed from: c  reason: collision with root package name */
    private float[] f49308c = new float[16];

    /* renamed from: d  reason: collision with root package name */
    private float[] f49309d = new float[16];

    /* renamed from: e  reason: collision with root package name */
    private int f49310e;

    /* renamed from: f  reason: collision with root package name */
    private int f49311f = -12345;

    /* renamed from: g  reason: collision with root package name */
    private int f49312g;

    /* renamed from: h  reason: collision with root package name */
    private int f49313h;

    /* renamed from: i  reason: collision with root package name */
    private int f49314i;

    /* renamed from: j  reason: collision with root package name */
    private int f49315j;

    public b() {
        float[] fArr = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
        this.f49306a = fArr;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f49307b = asFloatBuffer;
        asFloatBuffer.put(fArr).position(0);
        Matrix.setIdentityM(this.f49309d, 0);
    }

    private int a(int i11, String str) {
        int glCreateShader = GLES20.glCreateShader(i11);
        a("glCreateShader type=".concat(String.valueOf(i11)));
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        Log.e("TextureRender", "Could not compile shader " + i11 + ":");
        StringBuilder sb2 = new StringBuilder(" ");
        sb2.append(GLES20.glGetShaderInfoLog(glCreateShader));
        Log.e("TextureRender", sb2.toString());
        GLES20.glDeleteShader(glCreateShader);
        return 0;
    }

    private int a(String str, String str2) {
        int a11;
        int a12 = a(35633, str);
        if (a12 == 0 || (a11 = a(35632, str2)) == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        a("glCreateProgram");
        if (glCreateProgram == 0) {
            Log.e("TextureRender", "Could not create program");
        }
        GLES20.glAttachShader(glCreateProgram, a12);
        a("glAttachShader");
        GLES20.glAttachShader(glCreateProgram, a11);
        a("glAttachShader");
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] == 1) {
            return glCreateProgram;
        }
        Log.e("TextureRender", "Could not link program: ");
        Log.e("TextureRender", GLES20.glGetProgramInfoLog(glCreateProgram));
        GLES20.glDeleteProgram(glCreateProgram);
        return 0;
    }

    public int a() {
        return this.f49311f;
    }

    public void a(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            Log.e("TextureRender", str + ": glError " + glGetError);
            throw new RuntimeException(str + ": glError " + glGetError);
        }
    }

    public void b() {
        int a11 = a("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
        this.f49310e = a11;
        if (a11 != 0) {
            this.f49314i = GLES20.glGetAttribLocation(a11, "aPosition");
            a("glGetAttribLocation aPosition");
            if (this.f49314i != -1) {
                this.f49315j = GLES20.glGetAttribLocation(this.f49310e, "aTextureCoord");
                a("glGetAttribLocation aTextureCoord");
                if (this.f49315j != -1) {
                    this.f49312g = GLES20.glGetUniformLocation(this.f49310e, "uMVPMatrix");
                    a("glGetUniformLocation uMVPMatrix");
                    if (this.f49312g != -1) {
                        this.f49313h = GLES20.glGetUniformLocation(this.f49310e, "uSTMatrix");
                        a("glGetUniformLocation uSTMatrix");
                        if (this.f49313h != -1) {
                            int[] iArr = new int[1];
                            GLES20.glGenTextures(1, iArr, 0);
                            int i11 = iArr[0];
                            this.f49311f = i11;
                            GLES20.glBindTexture(36197, i11);
                            a("glBindTexture mTextureID");
                            GLES20.glTexParameterf(36197, 10241, 9728.0f);
                            GLES20.glTexParameterf(36197, 10240, 9729.0f);
                            GLES20.glTexParameteri(36197, 10242, 33071);
                            GLES20.glTexParameteri(36197, 10243, 33071);
                            a("glTexParameter");
                            return;
                        }
                        throw new RuntimeException("Could not get attrib location for uSTMatrix");
                    }
                    throw new RuntimeException("Could not get attrib location for uMVPMatrix");
                }
                throw new RuntimeException("Could not get attrib location for aTextureCoord");
            }
            throw new RuntimeException("Could not get attrib location for aPosition");
        }
        throw new RuntimeException("failed creating program");
    }
}
