package com.tencent.ugc.beauty.gpufilters.pitu;

import android.opengl.GLES20;
import com.tencent.ugc.videobase.filter.TXCGPUThreeInputFilter;
import com.tencent.ugc.videobase.frame.GLTexturePool;

public class TXCYTBeautySmoothFilter extends TXCGPUThreeInputFilter {
    private static final String FRAGMENT_SHADER = "precision mediump float;\n varying highp vec2 textureCoordinate;\n varying highp vec2 textureCoordinate2;\n varying highp vec2 textureCoordinate3;\n varying highp vec4 textureShift_1;\n varying highp vec4 textureShift_2;\n varying highp vec4 textureShift_3;\n varying highp vec4 textureShift_4;\n \n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform sampler2D inputImageTexture3;\n uniform highp float blurStrength;\n uniform highp float sharpenStrength;\n uniform highp float whitenStrength;\n uniform highp float ruddyStrength;\n\n \n const mediump vec3 luminanceWeighting = vec3(0.2125, 0.7154, 0.0721);\n  const highp mat3 saturateMatrix = mat3(\n                                        1.1102, -0.0598, -0.061,\n                                        -0.0774, 1.0826, -0.1186,\n                                        -0.0228, -0.0228, 1.1772);\n highp vec3 rgb2hsv(highp vec3 c)\n {\n     highp vec4 K = vec4(0.0, -1.0 / 3.0, 2.0 / 3.0, -1.0);\n     highp vec4 p = mix(vec4(c.bg, K.wz), vec4(c.gb, K.xy), step(c.b, c.g));\n     highp vec4 q = mix(vec4(p.xyw, c.r), vec4(c.r, p.yzx), step(p.x, c.r));\n     \n     highp float d = q.x - min(q.w, q.y);\n     highp float e = 1.0e-10;\n     return vec3(abs(q.z + (q.w - q.y) / (6.0 * d + e)), d / (q.x + e), q.x);\n }\n void main()\n {\n     lowp vec4 iColor = texture2D(inputImageTexture, textureCoordinate);\n     lowp vec4 meanColor = texture2D(inputImageTexture2, textureCoordinate2);\n     lowp vec4 varColor = texture2D(inputImageTexture3, textureCoordinate3);\n     \n     lowp float iSkinR = iColor.r;\n     lowp float mSkinR = meanColor.r;\n     \n     // smooth\n     mediump float p = clamp((min(iSkinR, mSkinR - 0.1) - 0.2) * 4.0, 0.0, 1.0);\n     mediump float meanVar = (varColor.r + varColor.g + varColor.b) / 3.0;\n     mediump float diffFactor = (1.0 - meanVar / (meanVar + 0.1));\n     mediump float kMin = diffFactor * p;\n     lowp vec3 smoothColor = mix(iColor.rgb, meanColor.rgb, kMin * blurStrength);\n     \n     // sharpen\n     mediump vec3 sum = 0.25* iColor.rgb;// 0.25*iColor.rgb;\n     sum += 0.125 *texture2D(inputImageTexture,textureShift_1.xy).rgb;\n     sum += 0.125 *texture2D(inputImageTexture,textureShift_1.zw).rgb;\n     sum += 0.125 *texture2D(inputImageTexture,textureShift_2.xy).rgb;\n     sum += 0.125 *texture2D(inputImageTexture,textureShift_2.zw).rgb;\n     sum += 0.0625*texture2D(inputImageTexture,textureShift_3.xy).rgb;\n     sum += 0.0625*texture2D(inputImageTexture,textureShift_3.zw).rgb;\n     sum += 0.0625*texture2D(inputImageTexture,textureShift_4.xy).rgb;\n     sum += 0.0625*texture2D(inputImageTexture,textureShift_4.zw).rgb;\n     vec3 hPass = iColor.rgb - sum;\n     lowp vec3 sharpenResult =          clamp(smoothColor + hPass.g + hPass.rgb * max(0.0, meanVar - 0.05) / (meanVar + 0.1),               vec3(0.0), vec3(1.0));\n     lowp vec3 sharpenColor =          clamp(mix(smoothColor.rgb, sharpenResult.rgb, sharpenStrength),               vec3(0.0), vec3(1.0));\n     \n     //美白\n     //提升对比度，黑白分明\n     lowp vec4 white =          vec4(((sharpenColor.rgb - vec3(0.5)) * (1.0 + whitenStrength * 0.125) + vec3(0.5)),              iColor.a);\n     //越亮越白，越暗越不白\n     lowp vec3 hsv = rgb2hsv(white.rgb);\n     highp float wDegree = 4.0 * hsv.z * whitenStrength + 0.00001;\n     //log曲线美白\n     white.r = log(1.0 + wDegree * white.r)/log(wDegree + 1.0);\n     white.gb = log(1.0 + wDegree * white.gb)/log(wDegree + 1.0);\n     white = mix(vec4(sharpenColor, iColor.a), white, min(wDegree, 0.8));\n     //饱和度红润\n     lowp vec3 ruddy = white.rgb * saturateMatrix;\n     ruddy = mix(white.rgb, ruddy, ruddyStrength * 0.7);\n     gl_FragColor = vec4(ruddy, 1.0);     // whiten red\n\n }";
    private static final String TAG = "TXCYTBeautySmoothFilter";
    private static final String VERTEX_SHADER = "attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n attribute vec4 inputTextureCoordinate2;\n attribute vec4 inputTextureCoordinate3;\n uniform float texelWidthOffset;\n uniform float texelHeightOffset;\n \n varying vec2 textureCoordinate;\n varying vec2 textureCoordinate2;\n varying vec2 textureCoordinate3;\n varying vec4 textureShift_1;\n varying vec4 textureShift_2;\n varying vec4 textureShift_3;\n varying vec4 textureShift_4;\n \n void main(void)\n {\n     gl_Position = position;\n     textureCoordinate = inputTextureCoordinate.xy;\n     textureCoordinate2 = inputTextureCoordinate2.xy;\n     textureCoordinate3 = inputTextureCoordinate3.xy;\n     textureShift_1 = vec4(textureCoordinate + vec2(-texelWidthOffset, 0.0),                           textureCoordinate + vec2(texelWidthOffset, 0.0));\n     textureShift_2 = vec4(textureCoordinate + vec2(0.0, -texelHeightOffset),                           textureCoordinate + vec2(0.0, texelHeightOffset));\n     textureShift_3 = vec4(textureCoordinate + vec2(texelWidthOffset, texelHeightOffset),                           textureCoordinate + vec2(-texelWidthOffset, -texelHeightOffset));\n     textureShift_4 = vec4(textureCoordinate + vec2(-texelWidthOffset, texelHeightOffset),                           textureCoordinate + vec2(texelWidthOffset, -texelHeightOffset));\n }\n";
    private float mBlurStrength = 0.0f;
    private int mBlurStrengthLocation;
    private float mRuddyStrength = 0.0f;
    private int mRuddyStrengthLocation;
    private float mSharpenStrength = 0.0f;
    private int mSharpenStrengthLocation;
    private int mTexelHeightOffsetLocation;
    private int mTexelWidthOffsetLocation;
    private float mWhitenStrength = 0.0f;
    private int mWhitenStrengthLocation;

    public TXCYTBeautySmoothFilter() {
        super(VERTEX_SHADER, FRAGMENT_SHADER);
    }

    public boolean canBeSkipped() {
        return isLessOrEqualZero(this.mBlurStrength) && isLessOrEqualZero(this.mWhitenStrength) && isLessOrEqualZero(this.mRuddyStrength) && isLessOrEqualZero(this.mSharpenStrength);
    }

    public void onInit(GLTexturePool gLTexturePool) {
        super.onInit(gLTexturePool);
        this.mTexelWidthOffsetLocation = GLES20.glGetUniformLocation(getProgramId(), "texelWidthOffset");
        this.mTexelHeightOffsetLocation = GLES20.glGetUniformLocation(getProgramId(), "texelHeightOffset");
        this.mBlurStrengthLocation = GLES20.glGetUniformLocation(getProgramId(), "blurStrength");
        this.mSharpenStrengthLocation = GLES20.glGetUniformLocation(getProgramId(), "sharpenStrength");
        this.mRuddyStrengthLocation = GLES20.glGetUniformLocation(getProgramId(), "ruddyStrength");
        this.mWhitenStrengthLocation = GLES20.glGetUniformLocation(getProgramId(), "whitenStrength");
    }

    public void onOutputSizeChanged(int i11, int i12) {
        super.onOutputSizeChanged(i11, i12);
        setSharpenSize((float) i11, (float) i12);
    }

    public void setBlurStrength(float f11) {
        this.mBlurStrength = f11;
        setFloatOnDraw(this.mBlurStrengthLocation, f11);
        setFloatOnDraw(this.mSharpenStrengthLocation, 0.3f * f11 * f11);
    }

    public void setRuddyStrength(float f11) {
        this.mRuddyStrength = f11;
        setFloatOnDraw(this.mRuddyStrengthLocation, f11);
    }

    public void setSharpenSize(float f11, float f12) {
        setFloatOnDraw(this.mTexelWidthOffsetLocation, 1.0f / f11);
        setFloatOnDraw(this.mTexelHeightOffsetLocation, 1.0f / f12);
    }

    public void setSharpenStrength(float f11) {
        this.mSharpenStrength = f11;
        setFloatOnDraw(this.mSharpenStrengthLocation, f11);
    }

    public void setWhitenStrength(float f11) {
        this.mWhitenStrength = f11;
        setFloatOnDraw(this.mWhitenStrengthLocation, f11);
    }
}
