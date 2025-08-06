package com.huobi.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.viewpager.widget.ViewPager;

public class NoHorizontalScrollViewPager extends ViewPager {
    public NoHorizontalScrollViewPager(Context context) {
        super(context);
    }

    public boolean canScrollHorizontally(int i11) {
        return false;
    }

    public NoHorizontalScrollViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
