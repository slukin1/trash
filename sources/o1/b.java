package o1;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.view.Surface;
import java.util.Objects;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public EGLDisplay f16232a = EGL14.EGL_NO_DISPLAY;

    /* renamed from: b  reason: collision with root package name */
    public EGLContext f16233b = EGL14.EGL_NO_CONTEXT;

    /* renamed from: c  reason: collision with root package name */
    public EGLSurface f16234c = EGL14.EGL_NO_SURFACE;

    /* renamed from: d  reason: collision with root package name */
    public EGLConfig[] f16235d = new EGLConfig[1];

    /* renamed from: e  reason: collision with root package name */
    public Surface f16236e;

    /* renamed from: f  reason: collision with root package name */
    public int f16237f;

    /* renamed from: g  reason: collision with root package name */
    public int f16238g;

    public b(Surface surface) {
        Objects.requireNonNull(surface);
        this.f16236e = surface;
        c();
    }

    public final void a(String str) {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError != 12288) {
            throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
        }
    }

    public final void b() {
        this.f16234c = EGL14.eglCreateWindowSurface(this.f16232a, this.f16235d[0], this.f16236e, new int[]{12344}, 0);
        a("eglCreateWindowSurface");
        if (this.f16234c == null) {
            throw new RuntimeException("surface was null");
        }
    }

    public final void c() {
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        this.f16232a = eglGetDisplay;
        if (!Objects.equals(eglGetDisplay, EGL14.EGL_NO_DISPLAY)) {
            int[] iArr = new int[2];
            if (EGL14.eglInitialize(this.f16232a, iArr, 0, iArr, 1)) {
                EGLDisplay eGLDisplay = this.f16232a;
                EGLConfig[] eGLConfigArr = this.f16235d;
                if (EGL14.eglChooseConfig(eGLDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12352, 4, 12610, 1, 12344}, 0, eGLConfigArr, 0, eGLConfigArr.length, new int[1], 0)) {
                    this.f16233b = EGL14.eglCreateContext(this.f16232a, this.f16235d[0], EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
                    a("eglCreateContext");
                    if (this.f16233b != null) {
                        b();
                        this.f16237f = e();
                        this.f16238g = d();
                        return;
                    }
                    throw new RuntimeException("null context");
                }
                throw new RuntimeException("unable to find RGB888+recordable ES2 EGL config");
            }
            this.f16232a = null;
            throw new RuntimeException("unable to initialize EGL14");
        }
        throw new RuntimeException("unable to get EGL14 display");
    }

    public int d() {
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(this.f16232a, this.f16234c, 12374, iArr, 0);
        return iArr[0];
    }

    public int e() {
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(this.f16232a, this.f16234c, 12375, iArr, 0);
        return iArr[0];
    }

    public void f() {
        EGLDisplay eGLDisplay = this.f16232a;
        EGLSurface eGLSurface = this.f16234c;
        if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f16233b)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public void g() {
        EGLDisplay eGLDisplay = this.f16232a;
        EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
        if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public void h() {
        if (!Objects.equals(this.f16232a, EGL14.EGL_NO_DISPLAY)) {
            EGL14.eglDestroySurface(this.f16232a, this.f16234c);
            EGL14.eglDestroyContext(this.f16232a, this.f16233b);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.f16232a);
        }
        this.f16236e.release();
        this.f16232a = EGL14.EGL_NO_DISPLAY;
        this.f16233b = EGL14.EGL_NO_CONTEXT;
        this.f16234c = EGL14.EGL_NO_SURFACE;
        this.f16236e = null;
    }

    public void i(long j11) {
        EGLExt.eglPresentationTimeANDROID(this.f16232a, this.f16234c, j11);
    }

    public boolean j() {
        return EGL14.eglSwapBuffers(this.f16232a, this.f16234c);
    }
}
