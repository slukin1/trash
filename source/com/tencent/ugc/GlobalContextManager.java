package com.tencent.ugc;

import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.os.Looper;
import android.view.Surface;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.egl.EGLCore;
import com.tencent.liteav.videobase.egl.d;
import javax.microedition.khronos.egl.EGL10;

public class GlobalContextManager {
    private static final String TAG = "GlobalContextManager";
    private static volatile GlobalContextManager sInstance;
    private EGLCore mEGLCore;
    private Object mGLContext;

    private GlobalContextManager() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            initGlobalContext();
        } else {
            new CustomHandler(Looper.getMainLooper()).runAndWaitDone(a.a(this));
        }
    }

    private void createContext() {
        EGLCore eGLCore = new EGLCore();
        this.mEGLCore = eGLCore;
        try {
            eGLCore.initialize((Object) null, (Surface) null, 128, 128);
        } catch (d e11) {
            LiteavLog.e(TAG, "initializeEGL failed.", (Throwable) e11);
            this.mEGLCore = null;
        }
        EGLCore eGLCore2 = this.mEGLCore;
        if (eGLCore2 != null) {
            this.mGLContext = eGLCore2.getEglContext();
        }
    }

    public static GlobalContextManager getInstance() {
        if (sInstance == null) {
            synchronized (GlobalContextManager.class) {
                if (sInstance == null) {
                    sInstance = new GlobalContextManager();
                }
            }
        }
        return sInstance;
    }

    /* access modifiers changed from: private */
    public void initGlobalContext() {
        if (this.mGLContext == null) {
            LiteavLog.i(TAG, "context before creating: " + EGL14.eglGetCurrentContext());
            if (LiteavSystemInfo.getSystemOSVersionInt() >= 17) {
                EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
                EGLSurface eglGetCurrentSurface = EGL14.eglGetCurrentSurface(12378);
                EGLSurface eglGetCurrentSurface2 = EGL14.eglGetCurrentSurface(12377);
                EGLContext eglGetCurrentContext = EGL14.eglGetCurrentContext();
                createContext();
                EGL14.eglMakeCurrent(eglGetDisplay, eglGetCurrentSurface2, eglGetCurrentSurface, eglGetCurrentContext);
            } else {
                EGL10 egl10 = (EGL10) javax.microedition.khronos.egl.EGLContext.getEGL();
                javax.microedition.khronos.egl.EGLDisplay eglGetDisplay2 = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
                javax.microedition.khronos.egl.EGLSurface eglGetCurrentSurface3 = egl10.eglGetCurrentSurface(12378);
                javax.microedition.khronos.egl.EGLSurface eglGetCurrentSurface4 = egl10.eglGetCurrentSurface(12377);
                javax.microedition.khronos.egl.EGLContext eglGetCurrentContext2 = egl10.eglGetCurrentContext();
                createContext();
                egl10.eglMakeCurrent(eglGetDisplay2, eglGetCurrentSurface4, eglGetCurrentSurface3, eglGetCurrentContext2);
            }
            LiteavLog.i(TAG, "context after creating: " + EGL14.eglGetCurrentContext() + ", global context: " + this.mGLContext);
        }
    }

    public synchronized Object getGLContext() {
        return this.mGLContext;
    }
}
