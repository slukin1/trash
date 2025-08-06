package com.huobi.view;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.res.ResourcesCompat;
import pro.huobi.R;
import q10.a;

public class TradeBuySellView extends AppCompatTextView implements a {
    public int mNormalColor;
    public int mNormalDrawable;
    public int mSelectedColor;
    public int mSelectedDrawable;

    public TradeBuySellView(Context context) {
        super(context, (AttributeSet) null);
        init(context);
    }

    private void init(Context context) {
        setGravity(17);
        setSingleLine();
        setTypeface(ResourcesCompat.h(context, R.font.roboto_medium));
        setEllipsize(TextUtils.TruncateAt.END);
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
        return this.mNormalColor;
    }

    public int getNormalDrawable() {
        return this.mNormalDrawable;
    }

    public int getSelectedColor() {
        return this.mSelectedColor;
    }

    public int getSelectedDrawable() {
        return this.mSelectedDrawable;
    }

    public void onDeselected(int i11, int i12) {
        setBackgroundResource(this.mNormalDrawable);
        setTextColor(this.mNormalColor);
    }

    public void onEnter(int i11, int i12, float f11, boolean z11) {
    }

    public void onLeave(int i11, int i12, float f11, boolean z11) {
    }

    public void onSelected(int i11, int i12) {
        setBackgroundResource(this.mSelectedDrawable);
        setTextColor(this.mSelectedColor);
    }

    public void setNormalColor(int i11) {
        this.mNormalColor = i11;
    }

    public void setNormalDrawable(int i11) {
        this.mNormalDrawable = i11;
    }

    public void setSelectedColor(int i11) {
        this.mSelectedColor = i11;
    }

    public void setSelectedDrawable(int i11) {
        this.mSelectedDrawable = i11;
    }
}
