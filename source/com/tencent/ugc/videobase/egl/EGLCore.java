package com.tencent.ugc.videobase.egl;

import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.view.Surface;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.base.util.l;
import java.util.concurrent.atomic.AtomicInteger;

@JNINamespace("liteav::ugc")
public class EGLCore {
    private static final long DESTROY_EGL_CORE_DELAY_TIME_MS = 100;
    private static final int MAX_EGL_CORE_COUNT = 50;
    private static final String TAG = "EGLCore";
    private static final AtomicInteger sEGLCoreCount = new AtomicInteger();
    private static final l sSequenceTaskRunner = new l();
    private EGLHelper<?> mEglHelper;
    private boolean mIsOffScreen = false;
    private Object mSharedContext;

    public static EGLCore create(Object obj) {
        EGLCore eGLCore = new EGLCore();
        try {
            eGLCore.initialize(obj, (Surface) null, 128, 128);
            eGLCore.makeCurrent();
            return eGLCore;
        } catch (EGLException e11) {
            LiteavLog.e(TAG, "create EGLCore failed.", (Throwable) e11);
            return null;
        }
    }

    public static void destroy(EGLCore eGLCore) {
        if (eGLCore != null) {
            eGLCore.unmakeCurrent();
            Runnable a11 = c.a(eGLCore);
            if (!eGLCore.mIsOffScreen) {
                a11.run();
            } else {
                sSequenceTaskRunner.b(a11, 100);
            }
        }
    }

    public static /* synthetic */ void lambda$destroy$0(EGLCore eGLCore) {
        try {
            eGLCore.uninitialize();
            LiteavLog.i(TAG, "EGLCore destroy success. ".concat(String.valueOf(eGLCore)));
        } catch (EGLException e11) {
            LiteavLog.e(TAG, "EGLCore destroy failed.", (Throwable) e11);
        }
    }

    private void uninitialize() throws EGLException {
        EGLHelper<?> eGLHelper = this.mEglHelper;
        if (eGLHelper != null) {
            eGLHelper.destroy();
            this.mEglHelper = null;
        }
        this.mSharedContext = null;
        sEGLCoreCount.decrementAndGet();
    }

    public Object getEglContext() {
        EGLHelper<?> eGLHelper = this.mEglHelper;
        if (eGLHelper == null) {
            return null;
        }
        return eGLHelper.getContext();
    }

    public Object getSharedContext() {
        return this.mSharedContext;
    }

    public Size getSurfaceSize() {
        EGLHelper<?> eGLHelper = this.mEglHelper;
        return eGLHelper == null ? new Size(0, 0) : eGLHelper.getSurfaceSize();
    }

    public void initialize(Object obj, Surface surface, int i11, int i12) throws EGLException {
        this.mIsOffScreen = surface == null;
        if (obj == null) {
            if (LiteavSystemInfo.getSystemOSVersionInt() >= 17) {
                this.mEglHelper = EGL14Helper.createEGLSurface((EGLConfig) null, (EGLContext) null, surface, i11, i12);
            } else {
                this.mEglHelper = EGL10Helper.createEGLSurface((javax.microedition.khronos.egl.EGLConfig) null, (javax.microedition.khronos.egl.EGLContext) null, surface, i11, i12);
            }
        } else if (obj instanceof javax.microedition.khronos.egl.EGLContext) {
            this.mEglHelper = EGL10Helper.createEGLSurface((javax.microedition.khronos.egl.EGLConfig) null, (javax.microedition.khronos.egl.EGLContext) obj, surface, i11, i12);
        } else if (LiteavSystemInfo.getSystemOSVersionInt() < 17 || !(obj instanceof EGLContext)) {
            throw new EGLException(0, "sharedContext isn't EGLContext");
        } else {
            this.mEglHelper = EGL14Helper.createEGLSurface((EGLConfig) null, (EGLContext) obj, surface, i11, i12);
        }
        this.mSharedContext = obj;
        int incrementAndGet = sEGLCoreCount.incrementAndGet();
        LiteavLog.i(TAG, "EGLCore created in thread " + Thread.currentThread().getId() + ", sharedContext: " + obj + ", Surface: " + surface + ", width: " + i11 + ", height: " + i12 + ", eglCoreCount: " + incrementAndGet);
    }

    public void makeCurrent() throws EGLException {
        EGLHelper<?> eGLHelper = this.mEglHelper;
        if (eGLHelper != null) {
            eGLHelper.makeCurrent();
        }
    }

    public void setPresentationTime(long j11) {
        EGLHelper<?> eGLHelper = this.mEglHelper;
        if (eGLHelper != null && (eGLHelper instanceof EGL14Helper)) {
            ((EGL14Helper) eGLHelper).setPresentationTime(j11);
        }
    }

    public void swapBuffers() throws EGLException {
        EGLHelper<?> eGLHelper = this.mEglHelper;
        if (eGLHelper != null) {
            eGLHelper.swapBuffers();
        }
    }

    public void unmakeCurrent() {
        EGLHelper<?> eGLHelper = this.mEglHelper;
        if (eGLHelper != null) {
            eGLHelper.unmakeCurrent();
        }
    }
}
