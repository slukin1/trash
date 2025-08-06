package com.huobi.view.seekbar;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.WindowManager;

public class LeverDialogSeekBar extends MultiColorSeekBar {
    public LeverDialogSeekBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public String caculateProgressText() {
        return getProgress() + "X";
    }

    public float caculateSectionValue(float f11, int i11) {
        return (f11 + 1.0f) / ((float) i11);
    }

    public void correctOffsetWhenContainerOnScrolling() {
        locatePositionInWindow(false, 0, 0);
        if (this.mBubbleView.getParent() != null) {
            WindowManager.LayoutParams layoutParams = this.mLayoutParams;
            layoutParams.y = (int) (this.mBubbleCenterRawSolidY + 0.5f);
            this.mWindowManager.updateViewLayout(this.mBubbleView, layoutParams);
        }
    }

    public void initSectionTextArray() {
        int i11 = 0;
        while (true) {
            int i12 = this.mSectionCount;
            if (i11 <= i12) {
                boolean z11 = this.isRtl;
                float f11 = z11 ? this.mMax - (this.mSectionValue * ((float) i11)) : (this.mMin - 1.0f) + (this.mSectionValue * ((float) i11));
                if (i11 == 0 && !z11) {
                    f11 = this.mMin;
                } else if (i11 == i12 && z11) {
                    f11 = this.mMin;
                }
                SparseArray<String> sparseArray = this.mSectionTextArray;
                sparseArray.put(i11, ((int) Math.ceil((double) f11)) + "X");
                i11++;
            } else {
                return;
            }
        }
    }

    public LeverDialogSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LeverDialogSeekBar(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
