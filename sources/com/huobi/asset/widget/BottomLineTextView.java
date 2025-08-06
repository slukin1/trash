package com.huobi.asset.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.widgets.AutoSizeTextView;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$styleable;

public class BottomLineTextView extends RelativeLayout {

    /* renamed from: b  reason: collision with root package name */
    public final int f42479b;

    /* renamed from: c  reason: collision with root package name */
    public final int f42480c;

    /* renamed from: d  reason: collision with root package name */
    public AutoSizeTextView f42481d;

    /* renamed from: e  reason: collision with root package name */
    public View f42482e;

    /* renamed from: f  reason: collision with root package name */
    public int f42483f;

    public BottomLineTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public final void a() {
        this.f42481d = (AutoSizeTextView) findViewById(R$id.bottom_line_text);
        this.f42482e = findViewById(R$id.bottom_line);
    }

    public AutoSizeTextView getBottomLineText() {
        return this.f42481d;
    }

    public void setBottomLineText(String str) {
        AutoSizeTextView autoSizeTextView;
        if (!TextUtils.isEmpty(str) && (autoSizeTextView = this.f42481d) != null) {
            autoSizeTextView.setText(str);
        }
    }

    public void setTextColor(int i11) {
        int color = ContextCompat.getColor(getContext(), i11);
        AutoSizeTextView autoSizeTextView = this.f42481d;
        if (autoSizeTextView != null && this.f42482e != null) {
            autoSizeTextView.setTextColor(color);
            GradientDrawable gradientDrawable = (GradientDrawable) this.f42482e.getBackground();
            if (this.f42483f == 1) {
                gradientDrawable.setStroke(PixelUtils.a(0.5f), color, (float) PixelUtils.a(2.0f), (float) PixelUtils.a(2.0f));
            } else {
                gradientDrawable.setStroke(PixelUtils.a(0.5f), color, (float) PixelUtils.a(4.0f), (float) PixelUtils.a(4.0f));
            }
        }
    }

    public void setTextMaxWidth(int i11) {
        AutoSizeTextView autoSizeTextView = this.f42481d;
        if (autoSizeTextView != null) {
            autoSizeTextView.setMaxWidth(i11);
        }
    }

    public void setTextSize(int i11) {
        AutoSizeTextView autoSizeTextView = this.f42481d;
        if (autoSizeTextView != null) {
            autoSizeTextView.setTextSize((float) i11);
        }
    }

    public BottomLineTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomLineTextView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f42479b = 0;
        this.f42480c = 1;
        LayoutInflater.from(context).inflate(R$layout.common_bottom_line_text_view, this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.BottomLineTextView);
        String string = obtainStyledAttributes.getString(R$styleable.BottomLineTextView_bottom_line_text);
        int color = obtainStyledAttributes.getColor(R$styleable.BottomLineTextView_bottom_line_text_color, -1);
        this.f42483f = obtainStyledAttributes.getColor(R$styleable.BottomLineTextView_bottom_line_text_dash_style, 0);
        obtainStyledAttributes.recycle();
        a();
        setBottomLineText(string);
        if (color != -1) {
            this.f42481d.setTextColor(color);
            GradientDrawable gradientDrawable = (GradientDrawable) this.f42482e.getBackground();
            if (this.f42483f == 1) {
                gradientDrawable.setStroke(PixelUtils.a(0.5f), color, (float) PixelUtils.a(2.0f), (float) PixelUtils.a(2.0f));
            } else {
                gradientDrawable.setStroke(PixelUtils.a(0.5f), color, (float) PixelUtils.a(4.0f), (float) PixelUtils.a(4.0f));
            }
        }
    }
}
