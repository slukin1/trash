package com.tencent.ugc.videoprocessor.transitions;

public class FadeColorFilter extends TXCGPUTransitionFilterBase {
    private static final String FRAGMENT = "precision mediump float;\nvarying mediump vec2 _uv;\nuniform sampler2D inputImageTexture;\nuniform float progress;\nuniform float ratio;\nconst vec3 color = vec3(0.0);\nconst float colorPhase = 0.4;\nvec4 getFromColor(in vec2 uv){\n    vec2 fromTexture = vec2(uv.x,1.0 - uv.y);\n    vec4 fromColor = texture2D(inputImageTexture,fromTexture);\n    return fromColor;\n}\nvec4 getToColor(in vec2 uv){\n    vec2 toTexture = vec2(uv.x,1.0-uv.y);\n    vec4 toColor = texture2D(inputImageTexture,toTexture);\n    return toColor;\n}\nvec4 transition (vec2 uv) {\n    return mix(\n        mix(vec4(color, 1.0), getFromColor(uv), smoothstep(1.0-colorPhase, 0.0, progress)),\n        mix(vec4(color, 1.0), getToColor(uv), smoothstep(    colorPhase, 1.0, progress)),\n        progress\n    );\n}\nvoid main() {\n    gl_FragColor = transition(_uv);\n}";

    public FadeColorFilter(int i11) {
        super(TXCGPUTransitionFilterBase.TRANSITION_BASE_VERTEX, FRAGMENT, i11);
    }
}
