package com.tencent.ugc.beauty.gpufilters.pitu;

import com.tencent.ugc.videobase.filter.TXCGPUTwoInputFilter;

public class TXCYTBeautyBorderFilter extends TXCGPUTwoInputFilter {
    private static final String FRAGMENT_SHADER = " varying highp vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n \n void main()\n {\n     lowp vec3 iColor = texture2D(inputImageTexture, textureCoordinate).rgb;\n     lowp vec3 meanColor = texture2D(inputImageTexture2, textureCoordinate).rgb;\n     highp vec3 diffColor = (iColor - meanColor) * 7.07;\n     diffColor = min(diffColor * diffColor, 1.0);\n     gl_FragColor = vec4(diffColor, 1.0);\n }\n";
    private static final String VERTEX_SHADER = " attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n \n varying vec2 textureCoordinate;\n \n void main(void)\n {\n     gl_Position = position;\n     textureCoordinate = inputTextureCoordinate.xy;\n }\n";

    public TXCYTBeautyBorderFilter() {
        super(VERTEX_SHADER, FRAGMENT_SHADER);
    }

    public void onOutputSizeChanged(int i11, int i12) {
        float min = Math.min(1.0f, 360.0f / ((float) Math.min(i11, i12)));
        super.onOutputSizeChanged(Math.round(((float) i11) * min), Math.round(((float) i12) * min));
    }
}
