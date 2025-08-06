package com.tencent.liteav.videoproducer.capture;

import android.opengl.GLES20;
import android.view.Surface;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.b.a;
import com.tencent.liteav.base.b.b;
import com.tencent.liteav.base.util.CommonUtil;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.egl.EGLCore;
import com.tencent.liteav.videobase.egl.d;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.frame.e;
import com.tencent.liteav.videobase.frame.i;
import com.tencent.liteav.videobase.utils.OpenGlUtils;

@JNINamespace("liteav::video")
public class CustomFrameToPixelFrameConverter {
    private static final String TAG = "CustomFrameToPixelFrameConverter";
    private EGLCore mEGLCore = null;
    private e mGLTexturePool = null;
    private int mHeight = 0;
    private i mPixelFrameRenderer = null;
    private final Object mSharedContext;
    private final b mThrottlers = new b();
    private int mWidth = 0;

    public CustomFrameToPixelFrameConverter(Object obj) {
        this.mSharedContext = obj;
    }

    private void initializeGLComponents(int i11, int i12, PixelFrame pixelFrame) {
        if (this.mEGLCore != null) {
            LiteavLog.w(this.mThrottlers.a("initGL"), TAG, "egl is initialized!", new Object[0]);
            return;
        }
        Object gLContext = pixelFrame.getGLContext() != null ? pixelFrame.getGLContext() : this.mSharedContext;
        try {
            EGLCore eGLCore = new EGLCore();
            this.mEGLCore = eGLCore;
            eGLCore.initialize(gLContext, (Surface) null, i11, i12);
            this.mEGLCore.makeCurrent();
            a a11 = this.mThrottlers.a("initSuccess");
            LiteavLog.i(a11, TAG, "initialize egl, width: " + i11 + ", height: " + i12 + ", sharedContext: " + gLContext, new Object[0]);
        } catch (d e11) {
            LiteavLog.e(this.mThrottlers.a("initError"), TAG, "initialize egl failed.", (Throwable) e11);
            this.mEGLCore = null;
        }
        if (this.mEGLCore != null) {
            this.mGLTexturePool = new e();
            if (this.mPixelFrameRenderer == null) {
                this.mPixelFrameRenderer = new i(i11, i12);
            }
        }
    }

    private boolean isNeedRecreateEGL(PixelFrame pixelFrame, EGLCore eGLCore) {
        return (pixelFrame.getHeight() == this.mHeight && pixelFrame.getWidth() == this.mWidth && !(pixelFrame.getGLContext() != null && !CommonUtil.equals(pixelFrame.getGLContext(), eGLCore.getSharedContext()))) ? false : true;
    }

    private void uninitializedGLComponents() {
        EGLCore eGLCore = this.mEGLCore;
        if (eGLCore != null) {
            try {
                eGLCore.makeCurrent();
            } catch (d e11) {
                LiteavLog.e(this.mThrottlers.a("make"), TAG, "uninitialize egl, make current error ", (Throwable) e11);
            }
            LiteavLog.i(this.mThrottlers.a("uninitGL"), TAG, "uninitialize egl", new Object[0]);
            i iVar = this.mPixelFrameRenderer;
            if (iVar != null) {
                iVar.a();
                this.mPixelFrameRenderer = null;
            }
            e eVar = this.mGLTexturePool;
            if (eVar != null) {
                eVar.a();
                this.mGLTexturePool.b();
                this.mGLTexturePool = null;
            }
            EGLCore.destroy(this.mEGLCore);
            this.mEGLCore = null;
        }
    }

    public PixelFrame convertFrame(PixelFrame pixelFrame) {
        if (pixelFrame == null) {
            LiteavLog.w(TAG, "convertFrame: pixelFrame is null.");
            return null;
        }
        EGLCore eGLCore = this.mEGLCore;
        if (eGLCore == null || isNeedRecreateEGL(pixelFrame, eGLCore)) {
            this.mWidth = pixelFrame.getWidth();
            this.mHeight = pixelFrame.getHeight();
            uninitializedGLComponents();
            initializeGLComponents(this.mWidth, this.mHeight, pixelFrame);
        }
        EGLCore eGLCore2 = this.mEGLCore;
        if (eGLCore2 == null || this.mGLTexturePool == null || this.mPixelFrameRenderer == null) {
            return null;
        }
        try {
            eGLCore2.makeCurrent();
        } catch (d e11) {
            LiteavLog.e(TAG, "EGL makeCurrent error ", (Throwable) e11);
        }
        OpenGlUtils.glViewport(0, 0, this.mWidth, this.mHeight);
        com.tencent.liteav.videobase.frame.d a11 = this.mGLTexturePool.a(this.mWidth, this.mHeight);
        this.mPixelFrameRenderer.a(pixelFrame, GLConstants.GLScaleType.CENTER_CROP, a11);
        GLES20.glFinish();
        PixelFrame a12 = a11.a(this.mEGLCore.getEglContext());
        a12.setTimestamp(pixelFrame.getTimestamp());
        a11.release();
        return a12;
    }

    public void release() {
        uninitializedGLComponents();
    }

    public void releaseFrame(PixelFrame pixelFrame) {
        if (pixelFrame != null) {
            pixelFrame.release();
        }
    }
}
