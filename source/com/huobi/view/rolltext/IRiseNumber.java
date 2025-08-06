package com.huobi.view.rolltext;

import com.huobi.view.rolltext.NumberScrollTextView;

public interface IRiseNumber {
    void setDuration(long j11);

    void setFromAndEndNumber(float f11, float f12);

    void setFromAndEndNumber(int i11, int i12);

    void setOnEndListener(NumberScrollTextView.EndListener endListener);

    void start();

    void withNumber(float f11);

    void withNumber(int i11);
}
