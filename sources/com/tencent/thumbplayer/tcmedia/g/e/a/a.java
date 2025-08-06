package com.tencent.thumbplayer.tcmedia.g.e.a;

import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
import com.tencent.thumbplayer.tcmedia.g.c.b;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class a implements SurfaceTexture.OnFrameAvailableListener {

    /* renamed from: a  reason: collision with root package name */
    public EGL10 f49296a;

    /* renamed from: b  reason: collision with root package name */
    public EGLDisplay f49297b;

    /* renamed from: c  reason: collision with root package name */
    public EGLContext f49298c;

    /* renamed from: d  reason: collision with root package name */
    public EGLSurface f49299d;

    /* renamed from: e  reason: collision with root package name */
    public b f49300e;

    /* renamed from: f  reason: collision with root package name */
    public Surface f49301f;

    /* renamed from: g  reason: collision with root package name */
    public Object f49302g = new Object();

    /* renamed from: h  reason: collision with root package name */
    public boolean f49303h;

    /* renamed from: i  reason: collision with root package name */
    public b f49304i;

    public a() {
        a();
    }

    public a(int i11, int i12) {
        if (i11 <= 0 || i12 <= 0) {
            throw new IllegalArgumentException();
        }
        a(i11, i12);
        c();
        a();
    }

    public void a() {
        b bVar = new b();
        this.f49304i = bVar;
        bVar.b();
        b bVar2 = new b(this.f49304i.a());
        this.f49300e = bVar2;
        bVar2.a(new b.a() {
            public void a() {
                com.tencent.thumbplayer.tcmedia.g.h.b.b("OutputSurface", "mSurfaceTexture:" + a.this.f49300e + " onReleased, release OutputSurface");
                a.this.b();
            }
        });
        this.f49300e.setOnFrameAvailableListener(this);
        this.f49301f = new com.tencent.thumbplayer.tcmedia.g.c.a(this.f49300e);
    }

    public void a(int i11, int i12) {
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.f49296a = egl10;
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.f49297b = eglGetDisplay;
        if (this.f49296a.eglInitialize(eglGetDisplay, (int[]) null)) {
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (this.f49296a.eglChooseConfig(this.f49297b, new int[]{12324, 8, 12323, 8, 12322, 8, 12339, 1, 12352, 4, 12344}, eGLConfigArr, 1, new int[1])) {
                this.f49298c = this.f49296a.eglCreateContext(this.f49297b, eGLConfigArr[0], EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
                a("eglCreateContext");
                if (this.f49298c != null) {
                    this.f49299d = this.f49296a.eglCreatePbufferSurface(this.f49297b, eGLConfigArr[0], new int[]{12375, i11, 12374, i12, 12344});
                    a("eglCreatePbufferSurface");
                    if (this.f49299d == null) {
                        throw new RuntimeException("surface was null");
                    }
                    return;
                }
                throw new RuntimeException("null context");
            }
            throw new RuntimeException("unable to find RGB888+pbuffer EGL config");
        }
        throw new RuntimeException("unable to initialize EGL10");
    }

    public void a(String str) {
        boolean z11 = false;
        while (true) {
            int eglGetError = this.f49296a.eglGetError();
            if (eglGetError == 12288) {
                break;
            }
            Log.e("OutputSurface", str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
            z11 = true;
        }
        if (z11) {
            throw new RuntimeException("EGL error encountered (see log)");
        }
    }

    public void b() {
        EGL10 egl10 = this.f49296a;
        if (egl10 != null) {
            if (egl10.eglGetCurrentContext().equals(this.f49298c)) {
                EGL10 egl102 = this.f49296a;
                EGLDisplay eGLDisplay = this.f49297b;
                EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
                egl102.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            }
            this.f49296a.eglDestroySurface(this.f49297b, this.f49299d);
            this.f49296a.eglDestroyContext(this.f49297b, this.f49298c);
        }
        this.f49301f.release();
        this.f49297b = null;
        this.f49298c = null;
        this.f49299d = null;
        this.f49296a = null;
        this.f49304i = null;
        this.f49301f = null;
        this.f49300e = null;
    }

    public void c() {
        if (this.f49296a != null) {
            a("before makeCurrent");
            EGL10 egl10 = this.f49296a;
            EGLDisplay eGLDisplay = this.f49297b;
            EGLSurface eGLSurface = this.f49299d;
            if (!egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f49298c)) {
                throw new RuntimeException("eglMakeCurrent failed");
            }
            return;
        }
        throw new RuntimeException("not configured for makeCurrent");
    }

    public Surface d() {
        return this.f49301f;
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this.f49302g) {
            if (!this.f49303h) {
                this.f49303h = true;
                this.f49302g.notifyAll();
            } else {
                throw new RuntimeException("mFrameAvailable already set, frame could be dropped");
            }
        }
    }
}
