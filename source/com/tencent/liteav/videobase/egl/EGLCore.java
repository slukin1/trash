package com.tencent.liteav.videobase.egl;

import android.opengl.EGLContext;
import android.opengl.EGLExt;
import android.view.Surface;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.base.util.l;
import java.util.concurrent.atomic.AtomicInteger;

@JNINamespace("liteav::video")
public class EGLCore {
    private static final long DESTROY_EGL_CORE_DELAY_TIME_MS = 100;
    private static final int MAX_EGL_CORE_COUNT = 50;
    private static final String TAG = "EGLCore";
    private static final AtomicInteger sEGLCoreCount = new AtomicInteger();
    private static final l sSequenceTaskRunner = new l();
    private e<?> mEglHelper;
    private boolean mIsOffScreen = false;
    private Object mSharedContext;

    public static EGLCore create(Object obj) {
        EGLCore eGLCore = new EGLCore();
        try {
            eGLCore.initialize(obj, (Surface) null, 128, 128);
            eGLCore.makeCurrent();
            return eGLCore;
        } catch (d e11) {
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
        } catch (d e11) {
            LiteavLog.e(TAG, "EGLCore destroy failed.", (Throwable) e11);
        }
    }

    private void uninitialize() throws d {
        e<?> eVar = this.mEglHelper;
        if (eVar != null) {
            eVar.c();
            this.mEglHelper = null;
        }
        this.mSharedContext = null;
        sEGLCoreCount.decrementAndGet();
    }

    public Object getEglContext() {
        e<?> eVar = this.mEglHelper;
        if (eVar == null) {
            return null;
        }
        return eVar.f();
    }

    public Object getSharedContext() {
        return this.mSharedContext;
    }

    public Size getSurfaceSize() {
        e<?> eVar = this.mEglHelper;
        return eVar == null ? new Size(0, 0) : eVar.e();
    }

    public void initialize(Object obj, Surface surface, int i11, int i12) throws d {
        this.mIsOffScreen = surface == null;
        if (obj == null) {
            if (LiteavSystemInfo.getSystemOSVersionInt() >= 17) {
                this.mEglHelper = b.a((EGLContext) null, surface, i11, i12);
            } else {
                this.mEglHelper = a.a((javax.microedition.khronos.egl.EGLContext) null, surface, i11, i12);
            }
        } else if (obj instanceof javax.microedition.khronos.egl.EGLContext) {
            this.mEglHelper = a.a((javax.microedition.khronos.egl.EGLContext) obj, surface, i11, i12);
        } else if (LiteavSystemInfo.getSystemOSVersionInt() < 17 || !(obj instanceof EGLContext)) {
            throw new d(0, "sharedContext isn't EGLContext");
        } else {
            this.mEglHelper = b.a((EGLContext) obj, surface, i11, i12);
        }
        this.mSharedContext = obj;
        int incrementAndGet = sEGLCoreCount.incrementAndGet();
        LiteavLog.i(TAG, "EGLCore created in thread " + Thread.currentThread().getId() + ", sharedContext: " + obj + ", Surface: " + surface + ", width: " + i11 + ", height: " + i12 + ", eglCoreCount: " + incrementAndGet);
    }

    public void makeCurrent() throws d {
        e<?> eVar = this.mEglHelper;
        if (eVar != null) {
            eVar.b();
        }
    }

    public void setPresentationTime(long j11) {
        e<?> eVar = this.mEglHelper;
        if (eVar != null && (eVar instanceof b)) {
            b bVar = (b) eVar;
            EGLExt.eglPresentationTimeANDROID(bVar.f22182a, bVar.f22183b, j11);
        }
    }

    public void swapBuffers() throws d {
        e<?> eVar = this.mEglHelper;
        if (eVar != null) {
            eVar.a();
        }
    }

    public void unmakeCurrent() {
        e<?> eVar = this.mEglHelper;
        if (eVar != null) {
            eVar.d();
        }
    }
}
