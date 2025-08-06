package com.tencent.liteav.videobase.egl;

import android.opengl.GLES20;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public final class a implements e<EGLContext> {

    /* renamed from: i  reason: collision with root package name */
    private static final int[] f22170i = {12339, 1, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, 4, 12344};

    /* renamed from: j  reason: collision with root package name */
    private static final int[] f22171j = {12339, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, 4, 12610, 1, 12344};

    /* renamed from: a  reason: collision with root package name */
    private final String f22172a;

    /* renamed from: b  reason: collision with root package name */
    private final int f22173b;

    /* renamed from: c  reason: collision with root package name */
    private final int f22174c;

    /* renamed from: d  reason: collision with root package name */
    private EGLDisplay f22175d = EGL10.EGL_NO_DISPLAY;

    /* renamed from: e  reason: collision with root package name */
    private EGLContext f22176e = EGL10.EGL_NO_CONTEXT;

    /* renamed from: f  reason: collision with root package name */
    private EGLSurface f22177f = EGL10.EGL_NO_SURFACE;

    /* renamed from: g  reason: collision with root package name */
    private EGL10 f22178g;

    /* renamed from: h  reason: collision with root package name */
    private EGLConfig f22179h;

    private a(int i11, int i12) {
        this.f22173b = i11;
        this.f22174c = i12;
        this.f22172a = "EGL10Helper@" + hashCode();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(12:9|10|11|12|15|(1:17)(2:18|19)|20|21|(1:23)|24|(1:26)|27) */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00de, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ec, code lost:
        throw new com.tencent.liteav.videobase.egl.d(r0.f22178g.eglGetError(), "", r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00ed, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00ee, code lost:
        r0.c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00f1, code lost:
        throw r8;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x004c */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0091 A[Catch:{ all -> 0x00de, d -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00b6 A[SYNTHETIC, Splitter:B:18:0x00b6] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00c9 A[Catch:{ all -> 0x00de, d -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00da A[Catch:{ all -> 0x00de, d -> 0x00ed }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.liteav.videobase.egl.a a(javax.microedition.khronos.egl.EGLContext r8, android.view.Surface r9, int r10, int r11) throws com.tencent.liteav.videobase.egl.d {
        /*
            com.tencent.liteav.videobase.egl.a r0 = new com.tencent.liteav.videobase.egl.a
            r0.<init>(r10, r11)
            javax.microedition.khronos.egl.EGL r10 = javax.microedition.khronos.egl.EGLContext.getEGL()     // Catch:{ d -> 0x00ed }
            javax.microedition.khronos.egl.EGL10 r10 = (javax.microedition.khronos.egl.EGL10) r10     // Catch:{ d -> 0x00ed }
            r0.f22178g = r10     // Catch:{ d -> 0x00ed }
            java.lang.Object r11 = javax.microedition.khronos.egl.EGL10.EGL_DEFAULT_DISPLAY     // Catch:{ d -> 0x00ed }
            javax.microedition.khronos.egl.EGLDisplay r10 = r10.eglGetDisplay(r11)     // Catch:{ d -> 0x00ed }
            r0.f22175d = r10     // Catch:{ d -> 0x00ed }
            javax.microedition.khronos.egl.EGL10 r11 = r0.f22178g     // Catch:{ d -> 0x00ed }
            r1 = 2
            int[] r2 = new int[r1]     // Catch:{ d -> 0x00ed }
            r11.eglInitialize(r10, r2)     // Catch:{ d -> 0x00ed }
            r10 = 1
            int[] r7 = new int[r10]     // Catch:{ d -> 0x00ed }
            javax.microedition.khronos.egl.EGLConfig[] r11 = new javax.microedition.khronos.egl.EGLConfig[r10]     // Catch:{ d -> 0x00ed }
            if (r9 != 0) goto L_0x0027
            int[] r2 = f22170i     // Catch:{ d -> 0x00ed }
            goto L_0x0029
        L_0x0027:
            int[] r2 = f22171j     // Catch:{ d -> 0x00ed }
        L_0x0029:
            r4 = r2
            javax.microedition.khronos.egl.EGL10 r2 = r0.f22178g     // Catch:{ d -> 0x00ed }
            javax.microedition.khronos.egl.EGLDisplay r3 = r0.f22175d     // Catch:{ d -> 0x00ed }
            r6 = 1
            r5 = r11
            r2.eglChooseConfig(r3, r4, r5, r6, r7)     // Catch:{ d -> 0x00ed }
            r2 = 0
            r11 = r11[r2]     // Catch:{ d -> 0x00ed }
            r0.f22179h = r11     // Catch:{ d -> 0x00ed }
            int r11 = com.tencent.liteav.base.system.LiteavSystemInfo.getSystemOSVersionInt()     // Catch:{ d -> 0x00ed }
            r3 = 18
            r4 = 3
            if (r11 < r3) goto L_0x005f
            javax.microedition.khronos.egl.EGLDisplay r11 = r0.f22175d     // Catch:{ d -> 0x004c }
            javax.microedition.khronos.egl.EGLConfig r3 = r0.f22179h     // Catch:{ d -> 0x004c }
            javax.microedition.khronos.egl.EGLContext r11 = r0.a((javax.microedition.khronos.egl.EGLDisplay) r11, (javax.microedition.khronos.egl.EGLConfig) r3, (int) r1, (javax.microedition.khronos.egl.EGLContext) r8)     // Catch:{ d -> 0x004c }
            r0.f22176e = r11     // Catch:{ d -> 0x004c }
            goto L_0x0069
        L_0x004c:
            java.lang.String r11 = r0.f22172a     // Catch:{ d -> 0x00ed }
            java.lang.String r3 = "failed to create EGLContext of OpenGL ES 2.0, try 3.0"
            com.tencent.liteav.base.util.LiteavLog.i(r11, r3)     // Catch:{ d -> 0x00ed }
            javax.microedition.khronos.egl.EGLDisplay r11 = r0.f22175d     // Catch:{ d -> 0x00ed }
            javax.microedition.khronos.egl.EGLConfig r3 = r0.f22179h     // Catch:{ d -> 0x00ed }
            javax.microedition.khronos.egl.EGLContext r11 = r0.a((javax.microedition.khronos.egl.EGLDisplay) r11, (javax.microedition.khronos.egl.EGLConfig) r3, (int) r4, (javax.microedition.khronos.egl.EGLContext) r8)     // Catch:{ d -> 0x00ed }
            r0.f22176e = r11     // Catch:{ d -> 0x00ed }
            r11 = r4
            goto L_0x006a
        L_0x005f:
            javax.microedition.khronos.egl.EGLDisplay r11 = r0.f22175d     // Catch:{ d -> 0x00ed }
            javax.microedition.khronos.egl.EGLConfig r3 = r0.f22179h     // Catch:{ d -> 0x00ed }
            javax.microedition.khronos.egl.EGLContext r11 = r0.a((javax.microedition.khronos.egl.EGLDisplay) r11, (javax.microedition.khronos.egl.EGLConfig) r3, (int) r1, (javax.microedition.khronos.egl.EGLContext) r8)     // Catch:{ d -> 0x00ed }
            r0.f22176e = r11     // Catch:{ d -> 0x00ed }
        L_0x0069:
            r11 = r1
        L_0x006a:
            java.lang.String r3 = r0.f22172a     // Catch:{ d -> 0x00ed }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ d -> 0x00ed }
            java.lang.String r6 = "create eglContext "
            r5.<init>(r6)     // Catch:{ d -> 0x00ed }
            javax.microedition.khronos.egl.EGLContext r6 = r0.f22176e     // Catch:{ d -> 0x00ed }
            r5.append(r6)     // Catch:{ d -> 0x00ed }
            java.lang.String r6 = " sharedContext: "
            r5.append(r6)     // Catch:{ d -> 0x00ed }
            r5.append(r8)     // Catch:{ d -> 0x00ed }
            java.lang.String r8 = " version:"
            r5.append(r8)     // Catch:{ d -> 0x00ed }
            r5.append(r11)     // Catch:{ d -> 0x00ed }
            java.lang.String r8 = r5.toString()     // Catch:{ d -> 0x00ed }
            com.tencent.liteav.base.util.LiteavLog.i(r3, r8)     // Catch:{ d -> 0x00ed }
            if (r9 != 0) goto L_0x00b6
            r8 = 5
            int[] r8 = new int[r8]     // Catch:{ d -> 0x00ed }
            r9 = 12375(0x3057, float:1.7341E-41)
            r8[r2] = r9     // Catch:{ d -> 0x00ed }
            int r9 = r0.f22173b     // Catch:{ d -> 0x00ed }
            r8[r10] = r9     // Catch:{ d -> 0x00ed }
            r9 = 12374(0x3056, float:1.734E-41)
            r8[r1] = r9     // Catch:{ d -> 0x00ed }
            int r9 = r0.f22174c     // Catch:{ d -> 0x00ed }
            r8[r4] = r9     // Catch:{ d -> 0x00ed }
            r9 = 4
            r10 = 12344(0x3038, float:1.7298E-41)
            r8[r9] = r10     // Catch:{ d -> 0x00ed }
            javax.microedition.khronos.egl.EGL10 r9 = r0.f22178g     // Catch:{ d -> 0x00ed }
            javax.microedition.khronos.egl.EGLDisplay r10 = r0.f22175d     // Catch:{ d -> 0x00ed }
            javax.microedition.khronos.egl.EGLConfig r11 = r0.f22179h     // Catch:{ d -> 0x00ed }
            javax.microedition.khronos.egl.EGLSurface r8 = r9.eglCreatePbufferSurface(r10, r11, r8)     // Catch:{ d -> 0x00ed }
            r0.f22177f = r8     // Catch:{ d -> 0x00ed }
            goto L_0x00c3
        L_0x00b6:
            javax.microedition.khronos.egl.EGL10 r8 = r0.f22178g     // Catch:{ all -> 0x00de }
            javax.microedition.khronos.egl.EGLDisplay r10 = r0.f22175d     // Catch:{ all -> 0x00de }
            javax.microedition.khronos.egl.EGLConfig r11 = r0.f22179h     // Catch:{ all -> 0x00de }
            r1 = 0
            javax.microedition.khronos.egl.EGLSurface r8 = r8.eglCreateWindowSurface(r10, r11, r9, r1)     // Catch:{ all -> 0x00de }
            r0.f22177f = r8     // Catch:{ all -> 0x00de }
        L_0x00c3:
            javax.microedition.khronos.egl.EGLSurface r8 = r0.f22177f     // Catch:{ d -> 0x00ed }
            javax.microedition.khronos.egl.EGLSurface r9 = javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE     // Catch:{ d -> 0x00ed }
            if (r8 != r9) goto L_0x00cc
            r0.h()     // Catch:{ d -> 0x00ed }
        L_0x00cc:
            javax.microedition.khronos.egl.EGL10 r8 = r0.f22178g     // Catch:{ d -> 0x00ed }
            javax.microedition.khronos.egl.EGLDisplay r9 = r0.f22175d     // Catch:{ d -> 0x00ed }
            javax.microedition.khronos.egl.EGLSurface r10 = r0.f22177f     // Catch:{ d -> 0x00ed }
            javax.microedition.khronos.egl.EGLContext r11 = r0.f22176e     // Catch:{ d -> 0x00ed }
            boolean r8 = r8.eglMakeCurrent(r9, r10, r10, r11)     // Catch:{ d -> 0x00ed }
            if (r8 != 0) goto L_0x00dd
            r0.h()     // Catch:{ d -> 0x00ed }
        L_0x00dd:
            return r0
        L_0x00de:
            r8 = move-exception
            javax.microedition.khronos.egl.EGL10 r9 = r0.f22178g     // Catch:{ d -> 0x00ed }
            int r9 = r9.eglGetError()     // Catch:{ d -> 0x00ed }
            com.tencent.liteav.videobase.egl.d r10 = new com.tencent.liteav.videobase.egl.d     // Catch:{ d -> 0x00ed }
            java.lang.String r11 = ""
            r10.<init>(r9, r11, r8)     // Catch:{ d -> 0x00ed }
            throw r10     // Catch:{ d -> 0x00ed }
        L_0x00ed:
            r8 = move-exception
            r0.c()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videobase.egl.a.a(javax.microedition.khronos.egl.EGLContext, android.view.Surface, int, int):com.tencent.liteav.videobase.egl.a");
    }

    private void g() throws d {
        if (this.f22177f != EGL10.EGL_NO_SURFACE) {
            d();
            if (!this.f22178g.eglDestroySurface(this.f22175d, this.f22177f)) {
                h();
            }
            this.f22177f = EGL10.EGL_NO_SURFACE;
        }
    }

    private void h() throws d {
        int eglGetError = this.f22178g.eglGetError();
        if (eglGetError != 12288) {
            throw new d(eglGetError);
        }
    }

    public final void b() throws d {
        EGL10 egl10 = this.f22178g;
        EGLDisplay eGLDisplay = this.f22175d;
        EGLSurface eGLSurface = this.f22177f;
        if (!egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f22176e)) {
            h();
        }
    }

    public final void c() throws d {
        if (this.f22175d != EGL10.EGL_NO_DISPLAY) {
            d();
            g();
            if (this.f22176e != EGL10.EGL_NO_CONTEXT) {
                String str = this.f22172a;
                LiteavLog.i(str, "destroy eglContext " + this.f22176e);
                this.f22178g.eglDestroyContext(this.f22175d, this.f22176e);
                this.f22176e = EGL10.EGL_NO_CONTEXT;
            }
            this.f22178g.eglTerminate(this.f22175d);
        }
        this.f22175d = EGL10.EGL_NO_DISPLAY;
    }

    public final void d() {
        EGLDisplay eGLDisplay = this.f22175d;
        if (eGLDisplay != EGL10.EGL_NO_DISPLAY) {
            EGL10 egl10 = this.f22178g;
            EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
            egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
        }
    }

    public final Size e() {
        int[] iArr = new int[1];
        int[] iArr2 = new int[1];
        boolean eglQuerySurface = this.f22178g.eglQuerySurface(this.f22175d, this.f22177f, 12375, iArr);
        boolean eglQuerySurface2 = this.f22178g.eglQuerySurface(this.f22175d, this.f22177f, 12374, iArr2);
        if (!eglQuerySurface || !eglQuerySurface2) {
            return new Size(0, 0);
        }
        return new Size(iArr[0], iArr2[0]);
    }

    public final /* bridge */ /* synthetic */ Object f() {
        return this.f22176e;
    }

    public final void a() throws d {
        GLES20.glFinish();
        if (!this.f22178g.eglSwapBuffers(this.f22175d, this.f22177f)) {
            h();
        }
    }

    private EGLContext a(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i11, EGLContext eGLContext) throws d {
        int[] iArr = {12440, i11, 12344};
        if (eGLContext == null) {
            eGLContext = EGL10.EGL_NO_CONTEXT;
        }
        EGLContext eglCreateContext = this.f22178g.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        h();
        return eglCreateContext;
    }
}
