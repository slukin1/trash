package com.tencent.ugc.videoprocessor.transitions;

import android.opengl.GLES20;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.ugc.videobase.frame.GLTexturePool;

public class DirectionalFilter extends TXCGPUTransitionFilterBase {
    private static final String FRAGMENT = "precision mediump float;\nvarying mediump vec2 _uv;\nuniform sampler2D inputImageTexture;\nuniform float progress;\nuniform float ratio;\nuniform vec2 direction; // = vec2(0.0, 1.0)\nvec4 getFromColor(in vec2 uv){\n    vec2 fromTexture = vec2(uv.x,1.0 - uv.y);\n    vec4 fromColor = texture2D(inputImageTexture,fromTexture);\n    return fromColor;\n}\nvec4 getToColor(in vec2 uv){\n    vec2 toTexture = vec2(uv.x,1.0-uv.y);\n    vec4 toColor = texture2D(inputImageTexture,toTexture);\n    return toColor;\n}\nvec4 transition (vec2 uv) {\n    vec2 p = uv + progress * sign(direction);\n    vec2 f = fract(p);\n    return mix(\n    getToColor(f),\n    getFromColor(f),\n    step(0.0, p.y) * step(p.y, 1.0) * step(0.0, p.x) * step(p.x, 1.0)\n    );\n}\nvoid main() {\n    gl_FragColor = transition(_uv);\n}";
    private float[] mDirection;
    private int mDirectionPosition;

    public DirectionalFilter(int i11, float[] fArr) {
        super(TXCGPUTransitionFilterBase.TRANSITION_BASE_VERTEX, FRAGMENT, i11);
        this.mDirection = fArr;
    }

    public void onInit(GLTexturePool gLTexturePool) {
        super.onInit(gLTexturePool);
        int glGetUniformLocation = GLES20.glGetUniformLocation(getProgramId(), HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION);
        this.mDirectionPosition = glGetUniformLocation;
        setFloatVec2OnDraw(glGetUniformLocation, this.mDirection);
    }
}
