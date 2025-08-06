package com.tencent.ugc.videobase.chain;

import android.opengl.GLES20;
import com.tencent.ugc.videobase.utils.OpenGlUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class TXCGPUImageMultipleInputFilter extends TXCGPUImageFilter {
    public static final String SECOND_INPUT_SAMPLE2D_NAME = "inputImageTexture2";
    public static final String THIRD_INPUT_SAMPLE2D_NAME = "inputImageTexture3";
    private final Map<String, Integer> mInputUniforms = new HashMap();
    private final Map<String, Integer> mTexturesOnNextDraw = new HashMap();

    public TXCGPUImageMultipleInputFilter(String str, String str2) {
        super(str, str2);
    }

    public void afterDrawArrays() {
        super.afterDrawArrays();
        int baseInputTextureUnit = getBaseInputTextureUnit();
        Iterator<Map.Entry<String, Integer>> it2 = this.mTexturesOnNextDraw.entrySet().iterator();
        while (it2.hasNext()) {
            it2.next();
            GLES20.glActiveTexture(baseInputTextureUnit);
            OpenGlUtils.bindTexture(getTarget(), 0);
            baseInputTextureUnit++;
        }
        this.mTexturesOnNextDraw.clear();
    }

    public void beforeDrawArrays(int i11) {
        super.beforeDrawArrays(i11);
        int baseInputTextureUnit = getBaseInputTextureUnit();
        for (Map.Entry next : this.mTexturesOnNextDraw.entrySet()) {
            Integer num = this.mInputUniforms.get(next.getKey());
            if (num == null) {
                num = Integer.valueOf(GLES20.glGetUniformLocation(getProgramId(), (String) next.getKey()));
                this.mInputUniforms.put(next.getKey(), num);
            }
            GLES20.glActiveTexture(baseInputTextureUnit);
            OpenGlUtils.bindTexture(getTarget(), ((Integer) next.getValue()).intValue());
            GLES20.glUniform1i(num.intValue(), baseInputTextureUnit - 33984);
            baseInputTextureUnit++;
        }
    }

    public int getBaseInputTextureUnit() {
        return 33985;
    }

    public void setInputTexture(String str, int i11) {
        this.mTexturesOnNextDraw.put(str, Integer.valueOf(i11));
    }
}
