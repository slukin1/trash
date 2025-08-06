package com.huobi.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.ViewPager;

public class WrapContentScrollViewPager extends ViewPager {
    public WrapContentScrollViewPager(Context context) {
        super(context);
    }

    public void onMeasure(int i11, int i12) {
        int i13;
        int i14;
        if (getLayoutParams() == null || getLayoutParams().height <= 0) {
            int i15 = 0;
            for (int i16 = 0; i16 < getChildCount(); i16++) {
                View childAt = getChildAt(i16);
                if (childAt.getLayoutParams() == null || childAt.getLayoutParams().height <= 0) {
                    childAt.measure(i11, View.MeasureSpec.makeMeasureSpec(childAt.getLayoutParams().height, 0));
                    i14 = childAt.getMeasuredHeight();
                } else {
                    i14 = childAt.getLayoutParams().height;
                }
                if (i14 > i15) {
                    i15 = i14;
                }
            }
            i13 = i15;
        } else {
            i13 = getLayoutParams().height;
        }
        super.onMeasure(i11, View.MeasureSpec.makeMeasureSpec(i13, 1073741824));
    }

    public WrapContentScrollViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
