package com.hbg.lib.widgets;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import q10.a;

public class TextImageIndicator extends AppCompatTextView implements a {

    /* renamed from: b  reason: collision with root package name */
    public int f71619b;

    /* renamed from: c  reason: collision with root package name */
    public int f71620c;

    /* renamed from: d  reason: collision with root package name */
    public int f71621d;

    /* renamed from: e  reason: collision with root package name */
    public int f71622e;

    public TextImageIndicator(Context context) {
        super(context, (AttributeSet) null);
        init(context);
    }

    public int getContentBottom() {
        Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
        return (int) (((float) (getHeight() / 2)) + ((fontMetrics.bottom - fontMetrics.top) / 2.0f));
    }

    public int getContentLeft() {
        Rect rect = new Rect();
        getPaint().getTextBounds(getText().toString(), 0, getText().length(), rect);
        return (getLeft() + (getWidth() / 2)) - (rect.width() / 2);
    }

    public int getContentRight() {
        Rect rect = new Rect();
        getPaint().getTextBounds(getText().toString(), 0, getText().length(), rect);
        return getLeft() + (getWidth() / 2) + (rect.width() / 2);
    }

    public int getContentTop() {
        Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
        return (int) (((float) (getHeight() / 2)) - ((fontMetrics.bottom - fontMetrics.top) / 2.0f));
    }

    public int getNormalColor() {
        return this.f71622e;
    }

    public int getNormalDrawable() {
        return this.f71620c;
    }

    public int getSelectedColor() {
        return this.f71621d;
    }

    public int getSelectedDrawable() {
        return this.f71619b;
    }

    public final void init(Context context) {
        setGravity(17);
        setSingleLine();
        setEllipsize(TextUtils.TruncateAt.END);
    }

    public void onDeselected(int i11, int i12) {
        setBackgroundResource(this.f71620c);
        setTextColor(this.f71622e);
    }

    public void onEnter(int i11, int i12, float f11, boolean z11) {
    }

    public void onLeave(int i11, int i12, float f11, boolean z11) {
    }

    public void onSelected(int i11, int i12) {
        setBackgroundResource(this.f71619b);
        setTextColor(this.f71621d);
    }

    public void setNormalColor(int i11) {
        this.f71622e = i11;
    }

    public void setNormalDrawable(int i11) {
        this.f71620c = i11;
    }

    public void setSelectedColor(int i11) {
        this.f71621d = i11;
    }

    public void setSelectedDrawable(int i11) {
        this.f71619b = i11;
    }
}
