package com.huobi.c2c.lend.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.hbg.lib.core.util.w;
import pro.huobi.R;

public class DailyProfitTextView extends AppCompatTextView {

    /* renamed from: b  reason: collision with root package name */
    public int f42997b;

    public DailyProfitTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DailyProfitTextView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        setBackgroundResource(R.drawable.c2c_income_bg);
        this.f42997b = getResources().getColor(w.h());
        setTextColor(getResources().getColor(R.color.baseColorSecondaryText));
        setTextSize(1, 11.0f);
        setGravity(17);
    }
}
