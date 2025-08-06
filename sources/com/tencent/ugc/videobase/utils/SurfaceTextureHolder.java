package com.tencent.ugc.videobase.utils;

import android.graphics.SurfaceTexture;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;

@JNINamespace("liteav::ugc")
public class SurfaceTextureHolder implements SurfaceTexture.OnFrameAvailableListener {
    private CustomHandler mCallbackHandler;
    private SurfaceTexture.OnFrameAvailableListener mOnFrameAvailableListener;
    private Surface mSurface;
    private SurfaceTexture mSurfaceTexture;
    private final String mTag = ("SurfaceTextureHolder_" + Integer.toHexString(hashCode()));

    public SurfaceTextureHolder(int i11, boolean z11) {
        this.mSurfaceTexture = new SurfaceTexture(i11);
        if (z11) {
            this.mSurface = new Surface(this.mSurfaceTexture);
        }
    }

    public static /* synthetic */ void lambda$onFrameAvailable$0(SurfaceTextureHolder surfaceTextureHolder, SurfaceTexture surfaceTexture) {
        SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener = surfaceTextureHolder.mOnFrameAvailableListener;
        if (onFrameAvailableListener != null) {
            onFrameAvailableListener.onFrameAvailable(surfaceTexture);
        }
    }

    public Surface getSurface() {
        return this.mSurface;
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.mSurfaceTexture;
    }

    public float[] getTransformMatrix(boolean z11, float f11, float f12, float f13, float f14) {
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture == null) {
            LiteavLog.e(this.mTag, "getTransformMatrix, surface texture is released!");
            return null;
        }
        float[] fArr = new float[16];
        surfaceTexture.getTransformMatrix(fArr);
        if (z11) {
            if (!FloatUtils.isEqual(f11, 0.0f) || !FloatUtils.isEqual(f12, 0.0f)) {
                Matrix.translateM(fArr, 0, f11, f12, 0.0f);
            }
            if (!FloatUtils.isEqual(f13, 1.0f) || !FloatUtils.isEqual(f14, 1.0f)) {
                Matrix.scaleM(fArr, 0, f13, f14, 1.0f);
            }
        }
        return fArr;
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        CustomHandler customHandler = this.mCallbackHandler;
        if (customHandler != null) {
            customHandler.runOrPost(a.a(this, surfaceTexture));
        }
    }

    public void release() {
        Surface surface = this.mSurface;
        if (surface != null) {
            surface.release();
            this.mSurface = null;
        }
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.mSurfaceTexture = null;
        }
    }

    public void setDefaultBufferSize(int i11, int i12) {
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture == null) {
            LiteavLog.e(this.mTag, "setDefaultBufferSize, surface texture is released!");
        } else {
            surfaceTexture.setDefaultBufferSize(i11, i12);
        }
    }

    public void setOnFrameAvailableListener(SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener, Handler handler) {
        if (this.mSurfaceTexture == null) {
            LiteavLog.e(this.mTag, "setOnFrameAvailableListener, surface texture is released!");
            return;
        }
        this.mCallbackHandler = new CustomHandler(handler != null ? handler.getLooper() : Looper.getMainLooper());
        this.mOnFrameAvailableListener = onFrameAvailableListener;
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 21) {
            this.mSurfaceTexture.setOnFrameAvailableListener(this, this.mCallbackHandler);
        } else {
            this.mSurfaceTexture.setOnFrameAvailableListener(this);
        }
    }

    public void updateTexImage() {
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture == null) {
            LiteavLog.e(this.mTag, "updateTexImage, surface texture is released!");
        } else {
            surfaceTexture.updateTexImage();
        }
    }
}
