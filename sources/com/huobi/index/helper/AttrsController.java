package com.huobi.index.helper;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import com.hbg.module.libkt.custom.indicator.view.option.IndicatorOptions;
import com.huobi.R$styleable;
import re.a;

public class AttrsController {
    public static void a(Context context, AttributeSet attributeSet, IndicatorOptions indicatorOptions) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.IndicatorView);
            int i11 = obtainStyledAttributes.getInt(2, 0);
            int i12 = obtainStyledAttributes.getInt(6, 0);
            int color = obtainStyledAttributes.getColor(3, Color.parseColor("#6C6D72"));
            int color2 = obtainStyledAttributes.getColor(4, Color.parseColor("#8C18171C"));
            int i13 = obtainStyledAttributes.getInt(0, 0);
            float dimension = obtainStyledAttributes.getDimension(5, (float) a.a(8.0f));
            indicatorOptions.n(color);
            indicatorOptions.q(color2);
            indicatorOptions.s(i13);
            indicatorOptions.p(i12);
            indicatorOptions.u(i11);
            float f11 = dimension * 2.0f;
            indicatorOptions.z(f11, f11);
            obtainStyledAttributes.recycle();
        }
    }
}
