package com.huobi.otc.widget;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;

public class StepView extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public TextView f80163b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f80164c;

    public StepView(Context context, String str, String str2) {
        this(context, str, str2, 1.0f);
    }

    public StepView(Context context, String str, String str2, float f11) {
        super(context);
        LinearLayout linearLayout = (LinearLayout) LinearLayout.inflate(context, R$layout.item_otc_step_view, this);
        this.f80163b = (TextView) linearLayout.findViewById(R$id.stepHead);
        this.f80164c = (TextView) linearLayout.findViewById(R$id.stepInfo);
        this.f80163b.setText(str);
        this.f80164c.setText(str2);
        linearLayout.setAlpha(f11);
    }
}
