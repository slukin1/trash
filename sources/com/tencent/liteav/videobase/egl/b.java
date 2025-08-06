package com.tencent.liteav.videobase.egl;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;

public final class b implements e<EGLContext> {

    /* renamed from: h  reason: collision with root package name */
    private static final int[] f22180h = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, 4, 12610, 1, 12344};

    /* renamed from: i  reason: collision with root package name */
    private static final int[] f22181i = {12339, 1, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, 4, 12610, 1, 12344};

    /* renamed from: a  reason: collision with root package name */
    public EGLDisplay f22182a = EGL14.EGL_NO_DISPLAY;

    /* renamed from: b  reason: collision with root package name */
    public EGLSurface f22183b = EGL14.EGL_NO_SURFACE;

    /* renamed from: c  reason: collision with root package name */
    private final String f22184c;

    /* renamed from: d  reason: collision with root package name */
    private final int f22185d;

    /* renamed from: e  reason: collision with root package name */
    private final int f22186e;

    /* renamed from: f  reason: collision with root package name */
    private EGLConfig f22187f = null;

    /* renamed from: g  reason: collision with root package name */
    private EGLContext f22188g = EGL14.EGL_NO_CONTEXT;

    private b(int i11, int i12) {
        this.f22185d = i11;
        this.f22186e = i12;
        this.f22184c = "EGL14Helper@" + hashCode();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:15|16|17|18|21|(1:23)(3:24|25|26)|27|28|(1:30)|31) */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00d4, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00e0, code lost:
        throw new com.tencent.liteav.videobase.egl.d(android.opengl.EGL14.eglGetError(), "", r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0104, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0105, code lost:
        r0.c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0108, code lost:
        throw r12;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004b */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0092 A[Catch:{ all -> 0x00d4, d -> 0x0104 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00b3 A[Catch:{ all -> 0x00d4, d -> 0x0104 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00d0 A[Catch:{ all -> 0x00d4, d -> 0x0104 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.liteav.videobase.egl.b a(android.opengl.EGLContext r12, android.view.Surface r13, int r14, int r15) throws com.tencent.liteav.videobase.egl.d {
        /*
            com.tencent.liteav.videobase.egl.b r0 = new com.tencent.liteav.videobase.egl.b
            r0.<init>(r14, r15)
            r14 = 0
            android.opengl.EGLDisplay r15 = android.opengl.EGL14.eglGetDisplay(r14)     // Catch:{ d -> 0x0104 }
            r0.f22182a = r15     // Catch:{ d -> 0x0104 }
            android.opengl.EGLDisplay r1 = android.opengl.EGL14.EGL_NO_DISPLAY     // Catch:{ d -> 0x0104 }
            if (r15 == r1) goto L_0x00f7
            r1 = 2
            int[] r2 = new int[r1]     // Catch:{ d -> 0x0104 }
            r3 = 1
            boolean r15 = android.opengl.EGL14.eglInitialize(r15, r2, r14, r2, r3)     // Catch:{ d -> 0x0104 }
            if (r15 == 0) goto L_0x00e7
            android.opengl.EGLConfig[] r15 = new android.opengl.EGLConfig[r3]     // Catch:{ d -> 0x0104 }
            int[] r10 = new int[r3]     // Catch:{ d -> 0x0104 }
            if (r13 != 0) goto L_0x0023
            int[] r2 = f22181i     // Catch:{ d -> 0x0104 }
            goto L_0x0025
        L_0x0023:
            int[] r2 = f22180h     // Catch:{ d -> 0x0104 }
        L_0x0025:
            r5 = r2
            android.opengl.EGLDisplay r4 = r0.f22182a     // Catch:{ d -> 0x0104 }
            r6 = 0
            r8 = 0
            r9 = 1
            r11 = 0
            r7 = r15
            boolean r2 = android.opengl.EGL14.eglChooseConfig(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ d -> 0x0104 }
            if (r2 == 0) goto L_0x00e1
            r15 = r15[r14]     // Catch:{ d -> 0x0104 }
            r0.f22187f = r15     // Catch:{ d -> 0x0104 }
            int r15 = com.tencent.liteav.base.system.LiteavSystemInfo.getSystemOSVersionInt()     // Catch:{ d -> 0x0104 }
            r2 = 18
            r4 = 3
            if (r15 < r2) goto L_0x005e
            android.opengl.EGLDisplay r15 = r0.f22182a     // Catch:{ d -> 0x004b }
            android.opengl.EGLConfig r2 = r0.f22187f     // Catch:{ d -> 0x004b }
            android.opengl.EGLContext r15 = a((android.opengl.EGLDisplay) r15, (android.opengl.EGLConfig) r2, (int) r1, (android.opengl.EGLContext) r12)     // Catch:{ d -> 0x004b }
            r0.f22188g = r15     // Catch:{ d -> 0x004b }
            goto L_0x0068
        L_0x004b:
            java.lang.String r15 = r0.f22184c     // Catch:{ d -> 0x0104 }
            java.lang.String r2 = "failed to create EGLContext of OpenGL ES 2.0, try 3.0"
            com.tencent.liteav.base.util.LiteavLog.i(r15, r2)     // Catch:{ d -> 0x0104 }
            android.opengl.EGLDisplay r15 = r0.f22182a     // Catch:{ d -> 0x0104 }
            android.opengl.EGLConfig r2 = r0.f22187f     // Catch:{ d -> 0x0104 }
            android.opengl.EGLContext r15 = a((android.opengl.EGLDisplay) r15, (android.opengl.EGLConfig) r2, (int) r4, (android.opengl.EGLContext) r12)     // Catch:{ d -> 0x0104 }
            r0.f22188g = r15     // Catch:{ d -> 0x0104 }
            r15 = r4
            goto L_0x0069
        L_0x005e:
            android.opengl.EGLDisplay r15 = r0.f22182a     // Catch:{ d -> 0x0104 }
            android.opengl.EGLConfig r2 = r0.f22187f     // Catch:{ d -> 0x0104 }
            android.opengl.EGLContext r15 = a((android.opengl.EGLDisplay) r15, (android.opengl.EGLConfig) r2, (int) r1, (android.opengl.EGLContext) r12)     // Catch:{ d -> 0x0104 }
            r0.f22188g = r15     // Catch:{ d -> 0x0104 }
        L_0x0068:
            r15 = r1
        L_0x0069:
            java.lang.String r2 = r0.f22184c     // Catch:{ d -> 0x0104 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ d -> 0x0104 }
            java.lang.String r6 = "create eglContext "
            r5.<init>(r6)     // Catch:{ d -> 0x0104 }
            android.opengl.EGLContext r6 = r0.f22188g     // Catch:{ d -> 0x0104 }
            r5.append(r6)     // Catch:{ d -> 0x0104 }
            java.lang.String r6 = " sharedContext: "
            r5.append(r6)     // Catch:{ d -> 0x0104 }
            r5.append(r12)     // Catch:{ d -> 0x0104 }
            java.lang.String r12 = " version:"
            r5.append(r12)     // Catch:{ d -> 0x0104 }
            r5.append(r15)     // Catch:{ d -> 0x0104 }
            java.lang.String r12 = r5.toString()     // Catch:{ d -> 0x0104 }
            com.tencent.liteav.base.util.LiteavLog.i(r2, r12)     // Catch:{ d -> 0x0104 }
            r12 = 12344(0x3038, float:1.7298E-41)
            if (r13 != 0) goto L_0x00b3
            r13 = 5
            int[] r13 = new int[r13]     // Catch:{ d -> 0x0104 }
            r15 = 12375(0x3057, float:1.7341E-41)
            r13[r14] = r15     // Catch:{ d -> 0x0104 }
            int r15 = r0.f22185d     // Catch:{ d -> 0x0104 }
            r13[r3] = r15     // Catch:{ d -> 0x0104 }
            r15 = 12374(0x3056, float:1.734E-41)
            r13[r1] = r15     // Catch:{ d -> 0x0104 }
            int r15 = r0.f22186e     // Catch:{ d -> 0x0104 }
            r13[r4] = r15     // Catch:{ d -> 0x0104 }
            r15 = 4
            r13[r15] = r12     // Catch:{ d -> 0x0104 }
            android.opengl.EGLDisplay r12 = r0.f22182a     // Catch:{ d -> 0x0104 }
            android.opengl.EGLConfig r15 = r0.f22187f     // Catch:{ d -> 0x0104 }
            android.opengl.EGLSurface r12 = android.opengl.EGL14.eglCreatePbufferSurface(r12, r15, r13, r14)     // Catch:{ d -> 0x0104 }
            r0.f22183b = r12     // Catch:{ d -> 0x0104 }
            goto L_0x00c1
        L_0x00b3:
            int[] r15 = new int[r3]     // Catch:{ d -> 0x0104 }
            r15[r14] = r12     // Catch:{ d -> 0x0104 }
            android.opengl.EGLDisplay r12 = r0.f22182a     // Catch:{ all -> 0x00d4 }
            android.opengl.EGLConfig r1 = r0.f22187f     // Catch:{ all -> 0x00d4 }
            android.opengl.EGLSurface r12 = android.opengl.EGL14.eglCreateWindowSurface(r12, r1, r13, r15, r14)     // Catch:{ all -> 0x00d4 }
            r0.f22183b = r12     // Catch:{ all -> 0x00d4 }
        L_0x00c1:
            g()     // Catch:{ d -> 0x0104 }
            android.opengl.EGLDisplay r12 = r0.f22182a     // Catch:{ d -> 0x0104 }
            android.opengl.EGLSurface r13 = r0.f22183b     // Catch:{ d -> 0x0104 }
            android.opengl.EGLContext r14 = r0.f22188g     // Catch:{ d -> 0x0104 }
            boolean r12 = android.opengl.EGL14.eglMakeCurrent(r12, r13, r13, r14)     // Catch:{ d -> 0x0104 }
            if (r12 != 0) goto L_0x00d3
            g()     // Catch:{ d -> 0x0104 }
        L_0x00d3:
            return r0
        L_0x00d4:
            r12 = move-exception
            int r13 = android.opengl.EGL14.eglGetError()     // Catch:{ d -> 0x0104 }
            com.tencent.liteav.videobase.egl.d r14 = new com.tencent.liteav.videobase.egl.d     // Catch:{ d -> 0x0104 }
            java.lang.String r15 = ""
            r14.<init>(r13, r15, r12)     // Catch:{ d -> 0x0104 }
            throw r14     // Catch:{ d -> 0x0104 }
        L_0x00e1:
            com.tencent.liteav.videobase.egl.d r12 = new com.tencent.liteav.videobase.egl.d     // Catch:{ d -> 0x0104 }
            r12.<init>(r14)     // Catch:{ d -> 0x0104 }
            throw r12     // Catch:{ d -> 0x0104 }
        L_0x00e7:
            r12 = 0
            r0.f22182a = r12     // Catch:{ d -> 0x0104 }
            java.lang.String r12 = r0.f22184c     // Catch:{ d -> 0x0104 }
            java.lang.String r13 = "unable to initialize EGL14"
            com.tencent.liteav.base.util.LiteavLog.e(r12, r13)     // Catch:{ d -> 0x0104 }
            com.tencent.liteav.videobase.egl.d r12 = new com.tencent.liteav.videobase.egl.d     // Catch:{ d -> 0x0104 }
            r12.<init>(r14)     // Catch:{ d -> 0x0104 }
            throw r12     // Catch:{ d -> 0x0104 }
        L_0x00f7:
            java.lang.String r12 = r0.f22184c     // Catch:{ d -> 0x0104 }
            java.lang.String r13 = "unable to get EGL14 display"
            com.tencent.liteav.base.util.LiteavLog.e(r12, r13)     // Catch:{ d -> 0x0104 }
            com.tencent.liteav.videobase.egl.d r12 = new com.tencent.liteav.videobase.egl.d     // Catch:{ d -> 0x0104 }
            r12.<init>(r14)     // Catch:{ d -> 0x0104 }
            throw r12     // Catch:{ d -> 0x0104 }
        L_0x0104:
            r12 = move-exception
            r0.c()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videobase.egl.b.a(android.opengl.EGLContext, android.view.Surface, int, int):com.tencent.liteav.videobase.egl.b");
    }

    private static void g() throws d {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError != 12288) {
            throw new d(eglGetError);
        }
    }

    public final void b() throws d {
        EGLDisplay eGLDisplay = this.f22182a;
        EGLSurface eGLSurface = this.f22183b;
        if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f22188g)) {
            g();
        }
    }

    public final void c() {
        EGLDisplay eGLDisplay = this.f22182a;
        if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            EGLSurface eGLSurface2 = this.f22183b;
            if (eGLSurface2 != EGL14.EGL_NO_SURFACE) {
                EGL14.eglDestroySurface(this.f22182a, eGLSurface2);
                this.f22183b = EGL14.EGL_NO_SURFACE;
            }
            if (this.f22188g != EGL14.EGL_NO_CONTEXT) {
                String str = this.f22184c;
                LiteavLog.i(str, "destroy eglContext " + this.f22188g);
                EGL14.eglDestroyContext(this.f22182a, this.f22188g);
                this.f22188g = EGL14.EGL_NO_CONTEXT;
            }
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.f22182a);
        }
        this.f22182a = EGL14.EGL_NO_DISPLAY;
    }

    public final void d() {
        EGLDisplay eGLDisplay = this.f22182a;
        if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
        }
    }

    public final Size e() {
        int[] iArr = new int[2];
        boolean eglQuerySurface = EGL14.eglQuerySurface(this.f22182a, this.f22183b, 12375, iArr, 0);
        boolean eglQuerySurface2 = EGL14.eglQuerySurface(this.f22182a, this.f22183b, 12374, iArr, 1);
        if (!eglQuerySurface || !eglQuerySurface2) {
            return new Size(0, 0);
        }
        return new Size(iArr[0], iArr[1]);
    }

    public final /* bridge */ /* synthetic */ Object f() {
        return this.f22188g;
    }

    public final void a() throws d {
        GLES20.glFinish();
        if (!EGL14.eglSwapBuffers(this.f22182a, this.f22183b)) {
            g();
        }
    }

    private static EGLContext a(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i11, EGLContext eGLContext) throws d {
        int[] iArr = {12440, i11, 12344};
        if (eGLContext == null) {
            eGLContext = EGL14.EGL_NO_CONTEXT;
        }
        EGLContext eglCreateContext = EGL14.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr, 0);
        g();
        return eglCreateContext;
    }
}
