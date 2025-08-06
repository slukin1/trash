package com.hbg.lib.widgets;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import q10.a;

public class GridTradeDrawableTabView extends FrameLayout implements a {

    /* renamed from: b  reason: collision with root package name */
    public TextView f71393b;

    /* renamed from: c  reason: collision with root package name */
    public int f71394c;

    /* renamed from: d  reason: collision with root package name */
    public int f71395d;

    public GridTradeDrawableTabView(Context context) {
        this(context, (AttributeSet) null);
    }

    public int getContentBottom() {
        Paint.FontMetrics fontMetrics = this.f71393b.getPaint().getFontMetrics();
        return (int) (((float) (getHeight() / 2)) + ((fontMetrics.bottom - fontMetrics.top) / 2.0f));
    }

    public int getContentLeft() {
        Rect rect = new Rect();
        this.f71393b.getPaint().getTextBounds(this.f71393b.getText().toString(), 0, this.f71393b.getText().length(), rect);
        return (getLeft() + (getWidth() / 2)) - (rect.width() / 2);
    }

    public int getContentRight() {
        Rect rect = new Rect();
        this.f71393b.getPaint().getTextBounds(this.f71393b.getText().toString(), 0, this.f71393b.getText().length(), rect);
        return getLeft() + (getWidth() / 2) + (rect.width() / 2);
    }

    public int getContentTop() {
        Paint.FontMetrics fontMetrics = this.f71393b.getPaint().getFontMetrics();
        return (int) (((float) (getHeight() / 2)) - ((fontMetrics.bottom - fontMetrics.top) / 2.0f));
    }

    public TextView getTextView() {
        return this.f71393b;
    }

    public void onDeselected(int i11, int i12) {
        this.f71393b.setTextColor(this.f71395d);
    }

    public void onEnter(int i11, int i12, float f11, boolean z11) {
    }

    public void onLeave(int i11, int i12, float f11, boolean z11) {
    }

    public void onSelected(int i11, int i12) {
        this.f71393b.setTextColor(this.f71394c);
    }

    public void setNormalColor(int i11) {
        this.f71395d = i11;
    }

    public void setSelectedColor(int i11) {
        this.f71394c = i11;
    }

    public void setTextView(TextView textView) {
        this.f71393b = textView;
    }

    public GridTradeDrawableTabView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GridTradeDrawableTabView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f71393b = new TextView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.f71393b.setLayoutParams(layoutParams);
        addView(this.f71393b);
    }
}
