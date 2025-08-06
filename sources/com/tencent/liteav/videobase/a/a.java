package com.tencent.liteav.videobase.a;

import android.opengl.GLES20;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.videobase.frame.c;
import com.tencent.liteav.videobase.frame.d;
import com.tencent.liteav.videobase.frame.e;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.liteav.videobase.utils.f;
import com.tencent.ugc.videobase.chain.TXCGPUImageFilter;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicInteger;

public class a {

    /* renamed from: h  reason: collision with root package name */
    private static final float[] f22049h = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};

    /* renamed from: i  reason: collision with root package name */
    private static final AtomicInteger f22050i = new AtomicInteger();

    /* renamed from: a  reason: collision with root package name */
    public final Size f22051a;

    /* renamed from: b  reason: collision with root package name */
    public int f22052b;

    /* renamed from: c  reason: collision with root package name */
    public int f22053c;

    /* renamed from: d  reason: collision with root package name */
    public int f22054d;

    /* renamed from: e  reason: collision with root package name */
    public e f22055e;

    /* renamed from: f  reason: collision with root package name */
    public int f22056f;

    /* renamed from: g  reason: collision with root package name */
    public float[] f22057g;

    /* renamed from: j  reason: collision with root package name */
    private final com.tencent.liteav.videobase.utils.a f22058j;

    /* renamed from: k  reason: collision with root package name */
    private final f f22059k;

    /* renamed from: l  reason: collision with root package name */
    private int f22060l;

    /* renamed from: m  reason: collision with root package name */
    private final c f22061m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f22062n;

    public a() {
        this(TXCGPUImageFilter.NO_FILTER_VERTEX_SHADER, TXCGPUImageFilter.NO_FILTER_FRAGMENT_SHADER);
    }

    public int a() {
        return 3553;
    }

    public void a(int i11) {
    }

    public final void a(e eVar) {
        if (!this.f22062n) {
            this.f22061m.a();
            f fVar = this.f22059k;
            int a11 = f.a(fVar.f22271a, 35633);
            int i11 = -1;
            if (a11 == 0) {
                LiteavLog.e("Program", "load vertex shader failed.");
            } else {
                int a12 = f.a(fVar.f22272b, 35632);
                if (a12 == 0) {
                    LiteavLog.e("Program", "load fragment shader failed.");
                    GLES20.glDeleteShader(a11);
                } else {
                    int glCreateProgram = GLES20.glCreateProgram();
                    GLES20.glAttachShader(glCreateProgram, a11);
                    GLES20.glAttachShader(glCreateProgram, a12);
                    GLES20.glLinkProgram(glCreateProgram);
                    int[] iArr = new int[1];
                    GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
                    if (iArr[0] == 0) {
                        LiteavLog.e("Program", "link program failed. status: " + iArr[0]);
                        GLES20.glDeleteShader(a11);
                        GLES20.glDeleteShader(a12);
                        GLES20.glDeleteProgram(glCreateProgram);
                    } else {
                        GLES20.glDeleteShader(a11);
                        GLES20.glDeleteShader(a12);
                        i11 = glCreateProgram;
                    }
                }
            }
            this.f22056f = i11;
            this.f22052b = GLES20.glGetAttribLocation(i11, "position");
            this.f22053c = GLES20.glGetUniformLocation(this.f22056f, "inputImageTexture");
            this.f22054d = GLES20.glGetAttribLocation(this.f22056f, "inputTextureCoordinate");
            this.f22060l = GLES20.glGetUniformLocation(this.f22056f, "textureTransform");
            b(eVar);
            this.f22062n = true;
            LiteavLog.d("TXCGPUImageFilter", "%s initialized, count: %d", this, Integer.valueOf(f22050i.incrementAndGet()));
        }
    }

    public final void b() {
        if (this.f22062n) {
            this.f22058j.a();
            c();
            this.f22062n = false;
            this.f22061m.d();
            int i11 = this.f22056f;
            if (i11 != -1) {
                GLES20.glDeleteProgram(i11);
                this.f22056f = -1;
            }
            LiteavLog.d("TXCGPUImageFilter", "%s uninitialized, count: %d", this, Integer.valueOf(f22050i.decrementAndGet()));
        }
    }

    public void c() {
    }

    public a(String str, String str2) {
        this.f22051a = new Size(-1, -1);
        this.f22056f = -1;
        this.f22061m = new c();
        this.f22058j = new com.tencent.liteav.videobase.utils.a();
        this.f22059k = new f(str, str2);
    }

    public void b(e eVar) {
        this.f22055e = eVar;
    }

    public final void a(Runnable runnable) {
        com.tencent.liteav.videobase.utils.a aVar = this.f22058j;
        synchronized (aVar.f22241a) {
            aVar.f22241a.add(runnable);
        }
    }

    public final void a(int i11, int i12) {
        Size size = this.f22051a;
        size.width = i11;
        size.height = i12;
    }

    public void a(int i11, d dVar, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (this.f22062n) {
            GLES20.glUseProgram(this.f22056f);
            this.f22058j.a();
            floatBuffer.position(0);
            GLES20.glVertexAttribPointer(this.f22052b, 2, 5126, false, 0, floatBuffer);
            GLES20.glEnableVertexAttribArray(this.f22052b);
            floatBuffer2.position(0);
            GLES20.glVertexAttribPointer(this.f22054d, 2, 5126, false, 0, floatBuffer2);
            GLES20.glEnableVertexAttribArray(this.f22054d);
            if (i11 != -1) {
                GLES20.glActiveTexture(33984);
                OpenGlUtils.bindTexture(a(), i11);
                GLES20.glUniform1i(this.f22053c, 0);
            }
            if (dVar != null) {
                this.f22061m.a(dVar.a());
                this.f22061m.b();
            } else {
                OpenGlUtils.bindFramebuffer(36160, 0);
            }
            float[] fArr = this.f22057g;
            if (fArr == null) {
                fArr = f22049h;
            }
            GLES20.glUniformMatrix4fv(this.f22060l, 1, false, fArr, 0);
            a(i11);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(this.f22052b);
            GLES20.glDisableVertexAttribArray(this.f22054d);
            GLES20.glActiveTexture(33984);
            OpenGlUtils.bindTexture(a(), 0);
            if (dVar != null) {
                OpenGlUtils.bindFramebuffer(36160, 0);
                this.f22061m.c();
            }
        }
    }
}
