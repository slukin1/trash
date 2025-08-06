package com.tencent.ugc.videobase.yuv;

import android.opengl.GLES20;
import com.tencent.ugc.videobase.chain.TXCGPUImageFilter;
import com.tencent.ugc.videobase.frame.GLTexture;
import com.tencent.ugc.videobase.frame.GLTexturePool;
import com.tencent.ugc.videobase.utils.OpenGlUtils;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.Arrays;

public abstract class TXCGPUImageYUVInputFilter extends TXCGPUImageFilter {
    private static final int INDEX_FOR_UV = 1;
    private static final int INDEX_FOR_Y = 0;
    private int mTextureHeight = 0;
    private final int[] mTextureIds;
    private int mTextureWidth = 0;
    private int mUniformTextureUv;

    public TXCGPUImageYUVInputFilter(String str, String str2) {
        super(str, str2);
        int[] iArr = new int[2];
        this.mTextureIds = iArr;
        Arrays.fill(iArr, -1);
    }

    private void deleteTextures() {
        int i11 = 0;
        while (true) {
            int[] iArr = this.mTextureIds;
            if (i11 < iArr.length) {
                OpenGlUtils.deleteTexture(iArr[i11]);
                this.mTextureIds[i11] = -1;
                i11++;
            } else {
                return;
            }
        }
    }

    public void beforeDrawArrays(int i11) {
        super.beforeDrawArrays(i11);
        GLES20.glActiveTexture(33985);
        OpenGlUtils.bindTexture(getTarget(), this.mTextureIds[1]);
        GLES20.glUniform1i(this.mUniformTextureUv, 1);
    }

    public abstract int getUvFormat();

    public void loadYuvDataToTexture(ByteBuffer byteBuffer, int i11, int i12) {
        if (!(this.mTextureWidth == i11 && this.mTextureHeight == i12)) {
            deleteTextures();
            this.mTextureWidth = i11;
            this.mTextureHeight = i12;
        }
        OpenGlUtils.loadYuv420DataToTextures(byteBuffer, getUvFormat(), i11, i12, this.mTextureIds);
    }

    public void onDraw(int i11, GLTexture gLTexture, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        super.onDraw(this.mTextureIds[0], gLTexture, floatBuffer, floatBuffer2);
    }

    public void onInit(GLTexturePool gLTexturePool) {
        super.onInit(gLTexturePool);
        this.mUniformTextureUv = GLES20.glGetUniformLocation(getProgramId(), "uvTexture");
    }

    public void onUninit() {
        deleteTextures();
        super.onUninit();
    }
}
