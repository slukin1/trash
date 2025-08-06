package com.huobi.homemarket.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.widget.l;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.widgets.SubscriptTextView;
import com.hbg.module.market.R$color;
import com.hbg.module.market.R$font;

public class MarketPriceView extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public SubscriptTextView f73098b;

    /* renamed from: c  reason: collision with root package name */
    public SubscriptTextView f73099c;

    public MarketPriceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public final void a(Context context) {
        Typeface h11 = ResourcesCompat.h(getContext(), R$font.roboto_medium);
        Resources resources = context.getResources();
        setOrientation(1);
        SubscriptTextView subscriptTextView = new SubscriptTextView(context);
        this.f73098b = subscriptTextView;
        subscriptTextView.setGravity(21);
        this.f73098b.setIncludeFontPadding(false);
        this.f73098b.setTextColor(resources.getColor(R$color.global_main_text_color));
        this.f73098b.setTypeface(h11);
        this.f73098b.setTextSize(1, 14.0f);
        this.f73098b.setMaxLines(1);
        l.k(this.f73098b, 1);
        l.j(this.f73098b, 6, 14, 1, 1);
        SubscriptTextView subscriptTextView2 = new SubscriptTextView(context);
        this.f73099c = subscriptTextView2;
        subscriptTextView2.setGravity(5);
        this.f73099c.setIncludeFontPadding(false);
        this.f73099c.setTextColor(resources.getColor(R$color.baseColorSecondaryTextNew));
        this.f73099c.setTypeface(Typeface.create("roboto_regular", 0));
        this.f73099c.setTextSize(1, 11.0f);
        this.f73099c.setMaxLines(1);
        addView(this.f73098b, new ViewGroup.MarginLayoutParams(-1, PixelUtils.a(17.0f)));
        addView(this.f73099c, new ViewGroup.MarginLayoutParams(-1, -2));
    }

    public void setPaintColor(boolean z11) {
        if (z11) {
            SubscriptTextView subscriptTextView = this.f73098b;
            Resources resources = getResources();
            int i11 = R$color.baseColorThreeLevelText;
            subscriptTextView.setTextColor(resources.getColor(i11));
            this.f73099c.setTextColor(getResources().getColor(i11));
            return;
        }
        this.f73098b.setTextColor(getResources().getColor(R$color.global_main_text_color));
        this.f73099c.setTextColor(getResources().getColor(R$color.baseColorSecondaryTextNew));
    }

    public void setPriceString(String str) {
        this.f73098b.setTextSize(1, 14.0f);
        this.f73098b.setText(str);
    }

    public void setPriceStringCny(String str) {
        this.f73099c.setText(str);
    }

    public MarketPriceView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a(context);
    }
}
