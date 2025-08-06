package com.tencent.ugc.videobase.egl;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.view.Surface;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;

public class EGL14Helper implements EGLHelper<EGLContext> {
    private static final int[] ATTRIBUTE_LIST_FOR_OFFSCREEN_SURFACE = {12339, 1, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, 4, EGL_RECORDABLE_ANDROID, 1, 12344};
    private static final int[] ATTRIBUTE_LIST_FOR_SURFACE = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, 4, EGL_RECORDABLE_ANDROID, 1, 12344};
    private static final int EGL_RECORDABLE_ANDROID = 12610;
    private EGLConfig mEGLConfig = null;
    private EGLContext mEGLContext = EGL14.EGL_NO_CONTEXT;
    private EGLDisplay mEGLDisplay = EGL14.EGL_NO_DISPLAY;
    private EGLSurface mEGLSurface = EGL14.EGL_NO_SURFACE;
    private final int mHeight;
    private final String mTAG;
    private final int mWidth;

    private EGL14Helper(int i11, int i12) {
        this.mWidth = i11;
        this.mHeight = i12;
        this.mTAG = "EGL14Helper@" + hashCode();
    }

    private static EGLContext createEGLContext(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i11, EGLContext eGLContext) throws EGLException {
        int[] iArr = {12440, i11, 12344};
        if (eGLContext == null) {
            eGLContext = EGL14.EGL_NO_CONTEXT;
        }
        EGLContext eglCreateContext = EGL14.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr, 0);
        throwEGLExceptionIfFailed();
        return eglCreateContext;
    }

    public static EGL14Helper createEGLSurface(EGLConfig eGLConfig, EGLContext eGLContext, Surface surface, int i11, int i12) throws EGLException {
        EGL14Helper eGL14Helper = new EGL14Helper(i11, i12);
        try {
            eGL14Helper.initialize(eGLConfig, eGLContext, surface);
            return eGL14Helper;
        } catch (EGLException e11) {
            eGL14Helper.destroy();
            throw e11;
        }
    }

    private void initialize(EGLConfig eGLConfig, EGLContext eGLContext, Surface surface) throws EGLException {
        int i11;
        EGLConfig eGLConfig2 = eGLConfig;
        EGLContext eGLContext2 = eGLContext;
        Surface surface2 = surface;
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        this.mEGLDisplay = eglGetDisplay;
        if (eglGetDisplay != EGL14.EGL_NO_DISPLAY) {
            int[] iArr = new int[2];
            if (EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                if (eGLConfig2 != null) {
                    this.mEGLConfig = eGLConfig2;
                } else {
                    EGLConfig[] eGLConfigArr = new EGLConfig[1];
                    if (EGL14.eglChooseConfig(this.mEGLDisplay, surface2 == null ? ATTRIBUTE_LIST_FOR_OFFSCREEN_SURFACE : ATTRIBUTE_LIST_FOR_SURFACE, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                        this.mEGLConfig = eGLConfigArr[0];
                    } else {
                        throw new EGLException(0);
                    }
                }
                if (LiteavSystemInfo.getSystemOSVersionInt() >= 18) {
                    try {
                        this.mEGLContext = createEGLContext(this.mEGLDisplay, this.mEGLConfig, 2, eGLContext2);
                    } catch (EGLException unused) {
                        LiteavLog.i(this.mTAG, "failed to create EGLContext of OpenGL ES 2.0, try 3.0");
                        this.mEGLContext = createEGLContext(this.mEGLDisplay, this.mEGLConfig, 3, eGLContext2);
                        i11 = 3;
                    }
                } else {
                    this.mEGLContext = createEGLContext(this.mEGLDisplay, this.mEGLConfig, 2, eGLContext2);
                }
                i11 = 2;
                LiteavLog.i(this.mTAG, "create eglContext " + this.mEGLContext + " sharedContext: " + eGLContext2 + " version:" + i11);
                if (surface2 == null) {
                    this.mEGLSurface = EGL14.eglCreatePbufferSurface(this.mEGLDisplay, this.mEGLConfig, new int[]{12375, this.mWidth, 12374, this.mHeight, 12344}, 0);
                } else {
                    try {
                        this.mEGLSurface = EGL14.eglCreateWindowSurface(this.mEGLDisplay, this.mEGLConfig, surface2, new int[]{12344}, 0);
                    } catch (Throwable th2) {
                        throw new EGLException(EGL14.eglGetError(), "", th2);
                    }
                }
                throwEGLExceptionIfFailed();
                EGLDisplay eGLDisplay = this.mEGLDisplay;
                EGLSurface eGLSurface = this.mEGLSurface;
                if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.mEGLContext)) {
                    throwEGLExceptionIfFailed();
                    return;
                }
                return;
            }
            this.mEGLDisplay = null;
            LiteavLog.e(this.mTAG, "unable to initialize EGL14");
            throw new EGLException(0);
        }
        LiteavLog.e(this.mTAG, "unable to get EGL14 display");
        throw new EGLException(0);
    }

    private static void throwEGLExceptionIfFailed() throws EGLException {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError != 12288) {
            throw new EGLException(eglGetError);
        }
    }

    public void destroy() {
        EGLDisplay eGLDisplay = this.mEGLDisplay;
        if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            EGLSurface eGLSurface2 = this.mEGLSurface;
            if (eGLSurface2 != EGL14.EGL_NO_SURFACE) {
                EGL14.eglDestroySurface(this.mEGLDisplay, eGLSurface2);
                this.mEGLSurface = EGL14.EGL_NO_SURFACE;
            }
            if (this.mEGLContext != EGL14.EGL_NO_CONTEXT) {
                String str = this.mTAG;
                LiteavLog.i(str, "destroy eglContext " + this.mEGLContext);
                EGL14.eglDestroyContext(this.mEGLDisplay, this.mEGLContext);
                this.mEGLContext = EGL14.EGL_NO_CONTEXT;
            }
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.mEGLDisplay);
        }
        this.mEGLDisplay = EGL14.EGL_NO_DISPLAY;
    }

    public void destroySurface() {
        if (this.mEGLSurface != EGL14.EGL_NO_SURFACE) {
            unmakeCurrent();
            EGL14.eglDestroySurface(this.mEGLDisplay, this.mEGLSurface);
            this.mEGLSurface = EGL14.EGL_NO_SURFACE;
        }
    }

    public Size getSurfaceSize() {
        int[] iArr = new int[2];
        boolean eglQuerySurface = EGL14.eglQuerySurface(this.mEGLDisplay, this.mEGLSurface, 12375, iArr, 0);
        boolean eglQuerySurface2 = EGL14.eglQuerySurface(this.mEGLDisplay, this.mEGLSurface, 12374, iArr, 1);
        if (!eglQuerySurface || !eglQuerySurface2) {
            return new Size(0, 0);
        }
        return new Size(iArr[0], iArr[1]);
    }

    public void makeCurrent() throws EGLException {
        EGLDisplay eGLDisplay = this.mEGLDisplay;
        EGLSurface eGLSurface = this.mEGLSurface;
        if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.mEGLContext)) {
            throwEGLExceptionIfFailed();
        }
    }

    public void setPresentationTime(long j11) {
        EGLExt.eglPresentationTimeANDROID(this.mEGLDisplay, this.mEGLSurface, j11);
    }

    public void swapBuffers() throws EGLException {
        GLES20.glFinish();
        if (!EGL14.eglSwapBuffers(this.mEGLDisplay, this.mEGLSurface)) {
            throwEGLExceptionIfFailed();
        }
    }

    public void unmakeCurrent() {
        EGLDisplay eGLDisplay = this.mEGLDisplay;
        if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
        }
    }

    public void updateSurface(Object obj) throws EGLException {
        destroySurface();
        this.mEGLSurface = EGL14.eglCreateWindowSurface(this.mEGLDisplay, this.mEGLConfig, obj, new int[]{12344}, 0);
        throwEGLExceptionIfFailed();
    }

    public EGLContext getContext() {
        return this.mEGLContext;
    }
}
