package com.tencent.ugc.videobase.filter;

import com.tencent.ugc.videobase.chain.TXCGPUImageFilter;
import com.tencent.ugc.videobase.frame.GLTexture;
import com.tencent.ugc.videobase.utils.OpenGlUtils;
import java.nio.Buffer;
import java.nio.FloatBuffer;

public class TXCGPUImageRGBAInputFilter extends TXCGPUImageFilter {
    private int mTextureHeight = -1;
    private int mTextureId = -1;
    private int mTextureWidth = -1;

    private void checkTextureSize(int i11, int i12) {
        if (this.mTextureWidth != i11 || this.mTextureHeight != i12) {
            this.mTextureWidth = i11;
            this.mTextureHeight = i12;
            OpenGlUtils.deleteTexture(this.mTextureId);
            this.mTextureId = -1;
        }
    }

    public void loadRgbaData(Buffer buffer, int i11, int i12) {
        checkTextureSize(i11, i12);
        this.mTextureId = OpenGlUtils.loadTexture(6408, buffer, i11, i12, this.mTextureId);
    }

    public void onDraw(int i11, GLTexture gLTexture, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        super.onDraw(this.mTextureId, gLTexture, floatBuffer, floatBuffer2);
    }

    public void onUninit() {
        super.onUninit();
        OpenGlUtils.deleteTexture(this.mTextureId);
        this.mTextureId = -1;
    }
}
