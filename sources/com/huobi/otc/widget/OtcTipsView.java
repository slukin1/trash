package com.huobi.otc.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$styleable;

public class OtcTipsView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public int f80054b;

    /* renamed from: c  reason: collision with root package name */
    public int f80055c;

    /* renamed from: d  reason: collision with root package name */
    public String f80056d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f80057e;

    public OtcTipsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void a(Context context) {
        FrameLayout.inflate(context, R$layout.view_otc_tips_layout, this);
        TextView textView = (TextView) findViewById(R$id.id_tips_content_tv);
        this.f80057e = textView;
        textView.setText(TextUtils.isEmpty(this.f80056d) ? "" : this.f80056d);
        this.f80057e.getPaint().setTextSize((float) this.f80055c);
        setBackgroundColor(this.f80054b);
    }

    public OtcTipsView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.OtcTipsView, i11, 0);
        this.f80054b = obtainStyledAttributes.getColor(R$styleable.OtcTipsView_bg_color, 0);
        this.f80055c = obtainStyledAttributes.getDimensionPixelSize(R$styleable.OtcTipsView_text_size, PixelUtils.a(12.0f));
        this.f80056d = obtainStyledAttributes.getString(R$styleable.OtcTipsView_content_text);
        obtainStyledAttributes.recycle();
        a(context);
    }
}
