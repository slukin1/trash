package com.tencent.ugc.beauty.gpufilters.smooth;

import android.opengl.GLES20;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.ugc.beauty.NativeLoad;
import com.tencent.ugc.videobase.chain.TXCGPUImageFilter;
import com.tencent.ugc.videobase.frame.GLTexturePool;

public class TXCTILSmoothHorizontalFilter extends TXCGPUImageFilter {
    private static final String TAG = "SmoothHorizontal";
    private int mTexelHeightOffsetLocation = -1;
    private int mTexelWidthOffsetLocation = -1;

    public TXCTILSmoothHorizontalFilter() {
        super((String) null, (String) null);
    }

    public int buildProgram() {
        return NativeLoad.nativeLoadGLProgram(13);
    }

    public void onInit(GLTexturePool gLTexturePool) {
        super.onInit(gLTexturePool);
        this.mTexelWidthOffsetLocation = GLES20.glGetUniformLocation(getProgramId(), "texelWidthOffset");
        this.mTexelHeightOffsetLocation = GLES20.glGetUniformLocation(getProgramId(), "texelHeightOffset");
    }

    public void onOutputSizeChanged(int i11, int i12) {
        super.onOutputSizeChanged(i11, i12);
        float f11 = 2.0f;
        if (i11 <= i12 ? i11 >= 540 : i12 >= 540) {
            f11 = 4.0f;
        }
        LiteavLog.i(TAG, "m_textureRation ".concat(String.valueOf(f11)));
        setFloatOnDraw(this.mTexelWidthOffsetLocation, f11 / ((float) i11));
        setFloatOnDraw(this.mTexelHeightOffsetLocation, f11 / ((float) i12));
    }
}
