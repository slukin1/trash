package com.tencent.ugc.videobase.egl;

import android.opengl.GLES20;
import android.view.Surface;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class EGL10Helper implements EGLHelper<EGLContext> {
    private static final int[] ATTRIBUTES_FOR_OFFSCREEN_SURFACE = {12339, 1, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, 4, 12344};
    private static final int[] ATTRIBUTES_FOR_SURFACE = {12339, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, 4, EGL_RECORDABLE_ANDROID, 1, 12344};
    private static final int EGL_CONTEXT_CLIENT_VERSION = 12440;
    private static final int EGL_OPENGL_ES2_BIT = 4;
    private static final int EGL_RECORDABLE_ANDROID = 12610;
    private EGL10 mEGL;
    private EGLConfig mEGLConfig;
    private EGLContext mEGLContext = EGL10.EGL_NO_CONTEXT;
    private EGLDisplay mEGLDisplay = EGL10.EGL_NO_DISPLAY;
    private EGLSurface mEGLSurface = EGL10.EGL_NO_SURFACE;
    private final int mHeight;
    private final String mTag;
    private final int mWidth;

    private EGL10Helper(int i11, int i12) {
        this.mWidth = i11;
        this.mHeight = i12;
        this.mTag = "EGL10Helper@" + hashCode();
    }

    private EGLContext createEGLContext(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i11, EGLContext eGLContext) throws EGLException {
        int[] iArr = {EGL_CONTEXT_CLIENT_VERSION, i11, 12344};
        if (eGLContext == null) {
            eGLContext = EGL10.EGL_NO_CONTEXT;
        }
        EGLContext eglCreateContext = this.mEGL.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        throwEGLExceptionIfFailed();
        return eglCreateContext;
    }

    public static EGL10Helper createEGLSurface(EGLConfig eGLConfig, EGLContext eGLContext, Surface surface, int i11, int i12) throws EGLException {
        EGL10Helper eGL10Helper = new EGL10Helper(i11, i12);
        try {
            eGL10Helper.initialize(eGLConfig, eGLContext, surface);
            return eGL10Helper;
        } catch (EGLException e11) {
            eGL10Helper.destroy();
            throw e11;
        }
    }

    private void initialize(EGLConfig eGLConfig, EGLContext eGLContext, Surface surface) throws EGLException {
        int i11;
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.mEGL = egl10;
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.mEGLDisplay = eglGetDisplay;
        this.mEGL.eglInitialize(eglGetDisplay, new int[2]);
        if (eGLConfig == null) {
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            this.mEGL.eglChooseConfig(this.mEGLDisplay, surface == null ? ATTRIBUTES_FOR_OFFSCREEN_SURFACE : ATTRIBUTES_FOR_SURFACE, eGLConfigArr, 1, new int[1]);
            this.mEGLConfig = eGLConfigArr[0];
        } else {
            this.mEGLConfig = eGLConfig;
        }
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 18) {
            try {
                this.mEGLContext = createEGLContext(this.mEGLDisplay, this.mEGLConfig, 2, eGLContext);
            } catch (EGLException unused) {
                LiteavLog.i(this.mTag, "failed to create EGLContext of OpenGL ES 2.0, try 3.0");
                this.mEGLContext = createEGLContext(this.mEGLDisplay, this.mEGLConfig, 3, eGLContext);
                i11 = 3;
            }
        } else {
            this.mEGLContext = createEGLContext(this.mEGLDisplay, this.mEGLConfig, 2, eGLContext);
        }
        i11 = 2;
        LiteavLog.i(this.mTag, "create eglContext " + this.mEGLContext + " sharedContext: " + eGLContext + " version:" + i11);
        if (surface == null) {
            this.mEGLSurface = this.mEGL.eglCreatePbufferSurface(this.mEGLDisplay, this.mEGLConfig, new int[]{12375, this.mWidth, 12374, this.mHeight, 12344});
        } else {
            try {
                this.mEGLSurface = this.mEGL.eglCreateWindowSurface(this.mEGLDisplay, this.mEGLConfig, surface, (int[]) null);
            } catch (Throwable th2) {
                throw new EGLException(this.mEGL.eglGetError(), "", th2);
            }
        }
        if (this.mEGLSurface == EGL10.EGL_NO_SURFACE) {
            throwEGLExceptionIfFailed();
        }
        EGL10 egl102 = this.mEGL;
        EGLDisplay eGLDisplay = this.mEGLDisplay;
        EGLSurface eGLSurface = this.mEGLSurface;
        if (!egl102.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.mEGLContext)) {
            throwEGLExceptionIfFailed();
        }
    }

    private void throwEGLExceptionIfFailed() throws EGLException {
        int eglGetError = this.mEGL.eglGetError();
        if (eglGetError != 12288) {
            throw new EGLException(eglGetError);
        }
    }

    public void destroy() throws EGLException {
        if (this.mEGLDisplay != EGL10.EGL_NO_DISPLAY) {
            unmakeCurrent();
            destroySurface();
            if (this.mEGLContext != EGL10.EGL_NO_CONTEXT) {
                String str = this.mTag;
                LiteavLog.i(str, "destroy eglContext " + this.mEGLContext);
                this.mEGL.eglDestroyContext(this.mEGLDisplay, this.mEGLContext);
                this.mEGLContext = EGL10.EGL_NO_CONTEXT;
            }
            this.mEGL.eglTerminate(this.mEGLDisplay);
        }
        this.mEGLDisplay = EGL10.EGL_NO_DISPLAY;
    }

    public void destroySurface() throws EGLException {
        if (this.mEGLSurface != EGL10.EGL_NO_SURFACE) {
            unmakeCurrent();
            if (!this.mEGL.eglDestroySurface(this.mEGLDisplay, this.mEGLSurface)) {
                throwEGLExceptionIfFailed();
            }
            this.mEGLSurface = EGL10.EGL_NO_SURFACE;
        }
    }

    public Size getSurfaceSize() {
        int[] iArr = new int[1];
        int[] iArr2 = new int[1];
        boolean eglQuerySurface = this.mEGL.eglQuerySurface(this.mEGLDisplay, this.mEGLSurface, 12375, iArr);
        boolean eglQuerySurface2 = this.mEGL.eglQuerySurface(this.mEGLDisplay, this.mEGLSurface, 12374, iArr2);
        if (!eglQuerySurface || !eglQuerySurface2) {
            return new Size(0, 0);
        }
        return new Size(iArr[0], iArr2[0]);
    }

    public void makeCurrent() throws EGLException {
        EGL10 egl10 = this.mEGL;
        EGLDisplay eGLDisplay = this.mEGLDisplay;
        EGLSurface eGLSurface = this.mEGLSurface;
        if (!egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.mEGLContext)) {
            throwEGLExceptionIfFailed();
        }
    }

    public void swapBuffers() throws EGLException {
        GLES20.glFinish();
        if (!this.mEGL.eglSwapBuffers(this.mEGLDisplay, this.mEGLSurface)) {
            throwEGLExceptionIfFailed();
        }
    }

    public void unmakeCurrent() {
        EGLDisplay eGLDisplay = this.mEGLDisplay;
        if (eGLDisplay != EGL10.EGL_NO_DISPLAY) {
            EGL10 egl10 = this.mEGL;
            EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
            egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
        }
    }

    public void updateSurface(Object obj) throws EGLException {
        destroySurface();
        this.mEGLSurface = this.mEGL.eglCreateWindowSurface(this.mEGLDisplay, this.mEGLConfig, obj, (int[]) null);
        throwEGLExceptionIfFailed();
    }

    public EGLContext getContext() {
        return this.mEGLContext;
    }
}
