package com.tencent.ugc.videobase.filter;

import android.opengl.GLES20;
import com.tencent.liteav.base.util.k;
import com.tencent.ugc.videobase.chain.TXCGPUImageMultipleInputFilter;
import com.tencent.ugc.videobase.frame.GLTexturePool;
import com.tencent.ugc.videobase.utils.OpenGlUtils;
import java.nio.FloatBuffer;

public class TXCGPUThreeInputFilter extends TXCGPUTwoInputFilter {
    public static final String VERTEX_THREE_INPUT_SHADER = "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nattribute vec4 inputTextureCoordinate2;\nattribute vec4 inputTextureCoordinate3;\n \nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\nvarying vec2 textureCoordinate3;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n    textureCoordinate2 = inputTextureCoordinate2.xy;\n    textureCoordinate3 = inputTextureCoordinate3.xy;\n}";
    private int mGLAttribTextureCoord3;
    private final FloatBuffer mThirdTextureCoordsBuffer;

    public TXCGPUThreeInputFilter(String str) {
        this(VERTEX_THREE_INPUT_SHADER, str);
    }

    public void afterDrawArrays() {
        super.afterDrawArrays();
        int i11 = this.mGLAttribTextureCoord3;
        if (i11 != -1) {
            GLES20.glDisableVertexAttribArray(i11);
        }
    }

    public void beforeDrawArrays(int i11) {
        super.beforeDrawArrays(i11);
        int i12 = this.mGLAttribTextureCoord3;
        if (i12 != -1) {
            GLES20.glVertexAttribPointer(i12, 2, 5126, false, 0, this.mThirdTextureCoordsBuffer);
            GLES20.glEnableVertexAttribArray(this.mGLAttribTextureCoord3);
        }
    }

    public void onInit(GLTexturePool gLTexturePool) {
        super.onInit((GLTexturePool) null);
        this.mGLAttribTextureCoord3 = GLES20.glGetAttribLocation(getProgramId(), "inputTextureCoordinate3");
    }

    public void onOutputSizeChanged(int i11, int i12) {
        super.onOutputSizeChanged(i11, i12);
    }

    public void setThirdInputTexture(int i11) {
        setInputTexture(TXCGPUImageMultipleInputFilter.THIRD_INPUT_SAMPLE2D_NAME, i11);
    }

    public TXCGPUThreeInputFilter(String str, String str2) {
        super(str, str2);
        this.mThirdTextureCoordsBuffer = OpenGlUtils.createTextureCoordsBuffer(k.NORMAL, false, false);
    }
}
