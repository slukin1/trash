package com.youth.banner.indicator;

import android.view.View;
import com.youth.banner.config.IndicatorConfig;
import com.youth.banner.listener.OnPageChangeListener;

public interface Indicator extends OnPageChangeListener {
    IndicatorConfig getIndicatorConfig();

    View getIndicatorView();

    void onPageChanged(int i11, int i12);
}
