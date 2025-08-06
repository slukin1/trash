package com.tencent.ugc.videoprocessor.watermark;

import com.tencent.liteav.base.util.Size;
import com.tencent.ugc.TXVideoEditConstants;
import com.tencent.ugc.videoprocessor.data.Resolution;

public class PasterBase {
    public Size mRenderSize;

    public TXVideoEditConstants.TXRect calculateRect(int i11, int i12, int i13, TXVideoEditConstants.TXRect tXRect) {
        Size size = this.mRenderSize;
        if (size == null) {
            return null;
        }
        int i14 = size.width;
        int i15 = size.height;
        Resolution resolution = new Resolution();
        float f11 = (float) i11;
        float f12 = (((float) i14) * 1.0f) / f11;
        float f13 = (float) i12;
        float f14 = (((float) i15) * 1.0f) / f13;
        if (i13 != 2 ? f12 < f14 : f12 > f14) {
            f12 = f14;
        }
        resolution.width = (int) (f11 * f12);
        resolution.height = (int) (f13 * f12);
        TXVideoEditConstants.TXRect tXRect2 = new TXVideoEditConstants.TXRect();
        float f15 = tXRect.f50070x;
        int i16 = resolution.width;
        tXRect2.f50070x = (f15 - ((float) ((i14 - i16) / 2))) / ((float) i16);
        float f16 = tXRect.f50071y;
        int i17 = resolution.height;
        tXRect2.f50071y = (f16 - ((float) ((i15 - i17) / 2))) / ((float) i17);
        tXRect2.width = tXRect.width / ((float) i16);
        return tXRect2;
    }

    public void clear() {
    }

    public void normalized(int i11, int i12, int i13) {
    }
}
