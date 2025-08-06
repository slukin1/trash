package com.huobi.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.widgets.R$font;
import net.lucode.hackware.magicindicator.buildins.ArgbEvaluatorHolder;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import q10.a;

public class PagerScaleTitleIndicatorView extends View implements a {
    private static final double PADDING = 10.0d;
    private static final int PADDING_BOTTOM = 3;
    private static final float SCALE_BIG = 1.55f;
    private static final String TEST_STR = "afgw我的";
    private float baseline;
    private int bigHeight;
    private Rect contentRect = new Rect();
    private boolean firstMeasure = true;
    private float maxTextSize;
    private int normalColor;
    private int normalWidth;
    private float originalTextSize;
    private Paint paint = new Paint();
    private int selectedColor;
    private String text;
    private int textColor;
    private float textSize;

    public PagerScaleTitleIndicatorView(Context context, float f11) {
        super(context);
        init(context);
        float a11 = (float) PixelUtils.a(f11);
        this.originalTextSize = a11;
        this.textSize = a11;
        this.maxTextSize = SCALE_BIG * a11;
        setTextSize(a11);
        this.paint.setTypeface(ResourcesCompat.h(context, R$font.roboto_medium));
    }

    private void init(Context context) {
        int a11 = UIUtil.a(context, 10.0d);
        setPadding(a11, 0, a11, 3);
    }

    private void setTextColor(int i11) {
        this.textColor = i11;
        invalidate();
    }

    public int getContentBottom() {
        return getPaddingBottom();
    }

    public int getContentLeft() {
        return getPaddingLeft();
    }

    public int getContentRight() {
        return getPaddingRight();
    }

    public int getContentTop() {
        return getPaddingTop();
    }

    public Paint getPaint() {
        return this.paint;
    }

    public void onDeselected(int i11, int i12) {
    }

    public void onDraw(Canvas canvas) {
        canvas.save();
        float f11 = this.textSize;
        float f12 = this.originalTextSize;
        float f13 = f11 / f12;
        this.paint.setTextSize(f12);
        this.paint.setColor(this.textColor);
        this.paint.setTextAlign(Paint.Align.CENTER);
        canvas.translate((float) (getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2)), this.baseline);
        canvas.scale(f13, f13);
        canvas.drawText(this.text, 0.0f, 0.0f, this.paint);
        canvas.restore();
    }

    @SuppressLint({"NewApi"})
    public void onEnter(int i11, int i12, float f11, boolean z11) {
        setTextColor(ArgbEvaluatorHolder.a(f11, this.normalColor, this.selectedColor));
        float f12 = this.originalTextSize;
        setTextSize(f12 + ((this.maxTextSize - f12) * f11));
    }

    @SuppressLint({"NewApi"})
    public void onLeave(int i11, int i12, float f11, boolean z11) {
        setTextColor(ArgbEvaluatorHolder.a(f11, this.selectedColor, this.normalColor));
        float f12 = this.maxTextSize;
        setTextSize(f12 - ((f12 - this.originalTextSize) * f11));
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        if (this.text != null) {
            if (this.firstMeasure) {
                this.firstMeasure = false;
                this.paint.setAntiAlias(true);
                this.paint.setDither(true);
                this.paint.setTextSize(this.originalTextSize);
                Paint paint2 = this.paint;
                String str = this.text;
                paint2.getTextBounds(str, 0, str.length(), this.contentRect);
                this.normalWidth = getPaddingLeft() + getPaddingRight() + this.contentRect.width();
                this.paint.setTextSize(this.maxTextSize);
                Paint paint3 = this.paint;
                String str2 = this.text;
                paint3.getTextBounds(str2, 0, str2.length(), this.contentRect);
                int paddingTop = getPaddingTop() + getPaddingBottom() + this.contentRect.height();
                this.bigHeight = paddingTop;
                int abs = paddingTop + Math.abs(this.contentRect.bottom);
                this.bigHeight = abs;
                this.bigHeight = Math.max(abs, getMeasuredHeight());
                this.paint.getTextBounds(TEST_STR, 0, 6, this.contentRect);
                this.baseline = (float) ((this.bigHeight - getPaddingBottom()) - Math.abs(this.contentRect.bottom));
            }
            int paddingRight = getPaddingRight() + getPaddingLeft();
            setMeasuredDimension(paddingRight + ((int) ((((float) (this.normalWidth - paddingRight)) * this.textSize) / this.originalTextSize)), this.bigHeight);
        }
    }

    public void onSelected(int i11, int i12) {
    }

    public void setNormalColor(int i11) {
        this.normalColor = i11;
    }

    public void setSelectedColor(int i11) {
        this.selectedColor = i11;
    }

    public void setText(String str) {
        this.text = str;
        requestLayout();
    }

    public void setTextSize(float f11) {
        if (this.textSize != f11) {
            this.textSize = f11;
            this.paint.setTextSize(f11);
            requestLayout();
        }
    }

    public PagerScaleTitleIndicatorView(Context context, float f11, int i11, int i12, int i13, int i14, float f12) {
        super(context);
        setPadding(i11, i12, i13, i14);
        float a11 = (float) PixelUtils.a(f11);
        this.originalTextSize = a11;
        this.textSize = a11;
        this.maxTextSize = f12 * a11;
        setTextSize(a11);
        this.paint.setTypeface(ResourcesCompat.h(context, R$font.roboto_medium));
    }
}
