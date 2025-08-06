package com.tencent.ugc.videoprocessor.videoeffect.filter;

import android.opengl.GLES20;
import com.tencent.ugc.videobase.filter.TXCGPUTwoInputFilter;
import com.tencent.ugc.videobase.frame.GLTexturePool;

public class TXCGPUDissolveBlendFilter extends TXCGPUTwoInputFilter {
    private static final String DISSOLVE_BLEND_FRAG = "precision mediump float;\nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform float mixturePercent;\n\nvoid main()\n{\n   vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n   vec4 textureColor2 = texture2D(inputImageTexture2, textureCoordinate2);\n   \n   gl_FragColor = mix(textureColor, textureColor2, mixturePercent);\n}\n";
    private int mMixturePercentUniform = -1;

    public TXCGPUDissolveBlendFilter() {
        super(DISSOLVE_BLEND_FRAG);
    }

    public void onInit(GLTexturePool gLTexturePool) {
        super.onInit(gLTexturePool);
        this.mMixturePercentUniform = GLES20.glGetUniformLocation(getProgramId(), "mixturePercent");
        setMixLevel(0.5f);
    }

    public void setMixLevel(float f11) {
        setFloatOnDraw(this.mMixturePercentUniform, f11);
    }
}
