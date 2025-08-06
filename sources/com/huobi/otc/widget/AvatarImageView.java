package com.huobi.otc.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.module.otc.R$styleable;

public class AvatarImageView extends View {

    /* renamed from: b  reason: collision with root package name */
    public int f79652b;

    /* renamed from: c  reason: collision with root package name */
    public int f79653c;

    /* renamed from: d  reason: collision with root package name */
    public int f79654d;

    /* renamed from: e  reason: collision with root package name */
    public int f79655e;

    /* renamed from: f  reason: collision with root package name */
    public int f79656f;

    /* renamed from: g  reason: collision with root package name */
    public String f79657g;

    /* renamed from: h  reason: collision with root package name */
    public RectF f79658h;

    /* renamed from: i  reason: collision with root package name */
    public Rect f79659i;

    /* renamed from: j  reason: collision with root package name */
    public Rect f79660j;

    /* renamed from: k  reason: collision with root package name */
    public Paint f79661k;

    /* renamed from: l  reason: collision with root package name */
    public LinearGradient f79662l;

    public AvatarImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public int getBgColor() {
        return this.f79652b;
    }

    public int getEndColor() {
        return this.f79654d;
    }

    public int getStartColor() {
        return this.f79653c;
    }

    public String getText() {
        return this.f79657g;
    }

    public int getTextColor() {
        return this.f79655e;
    }

    public int getTextSize() {
        return this.f79656f;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float min = (float) Math.min(getWidth(), getHeight());
        this.f79658h.set(0.0f, 0.0f, min, min);
        this.f79658h.offset(this.f79659i.exactCenterX() - this.f79658h.centerX(), this.f79659i.exactCenterY() - this.f79658h.centerX());
        this.f79661k.reset();
        int i11 = this.f79652b;
        if (i11 != 0) {
            this.f79661k.setColor(i11);
        } else {
            this.f79661k.setShader(this.f79662l);
        }
        this.f79661k.setAntiAlias(true);
        this.f79661k.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawArc(this.f79658h, 0.0f, 360.0f, true, this.f79661k);
        this.f79661k.reset();
        this.f79661k.setAntiAlias(true);
        this.f79661k.setTextSize((float) this.f79656f);
        this.f79661k.setColor(this.f79655e);
        this.f79661k.setTextAlign(Paint.Align.CENTER);
        if (!TextUtils.isEmpty(this.f79657g)) {
            Paint paint = this.f79661k;
            String str = this.f79657g;
            paint.getTextBounds(str, 0, str.length(), this.f79660j);
            canvas.drawText(this.f79657g, ((float) getWidth()) / 2.0f, this.f79658h.centerY() - this.f79660j.exactCenterY(), this.f79661k);
        }
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        this.f79659i.set(0, 0, i11, i12);
        float f11 = (float) i11;
        this.f79662l = new LinearGradient(0.0f, 0.0f, f11, f11, this.f79653c, this.f79654d, Shader.TileMode.CLAMP);
    }

    public void setBgColor(int i11) {
        this.f79652b = i11;
    }

    public void setEndColor(int i11) {
        this.f79654d = i11;
        this.f79662l = new LinearGradient(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), this.f79653c, this.f79654d, Shader.TileMode.CLAMP);
        invalidate();
    }

    public void setStartColor(int i11) {
        this.f79653c = i11;
        this.f79662l = new LinearGradient(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), this.f79653c, this.f79654d, Shader.TileMode.CLAMP);
        invalidate();
    }

    public void setText(String str) {
        this.f79657g = str;
        invalidate();
    }

    public void setTextColor(int i11) {
        this.f79655e = i11;
    }

    public void setTextSize(int i11) {
        this.f79656f = i11;
    }

    public AvatarImageView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f79658h = new RectF();
        this.f79659i = new Rect();
        this.f79660j = new Rect();
        this.f79661k = new Paint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.AvatarImageView, i11, 0);
        this.f79652b = obtainStyledAttributes.getColor(R$styleable.AvatarImageView_bgColor, 0);
        this.f79653c = obtainStyledAttributes.getColor(R$styleable.AvatarImageView_startColor, 0);
        this.f79654d = obtainStyledAttributes.getColor(R$styleable.AvatarImageView_endColor, 0);
        this.f79655e = obtainStyledAttributes.getColor(R$styleable.AvatarImageView_textColor, -1);
        this.f79656f = obtainStyledAttributes.getDimensionPixelSize(R$styleable.AvatarImageView_textSize, PixelUtils.a(14.0f));
        this.f79657g = obtainStyledAttributes.getString(R$styleable.AvatarImageView_text);
        obtainStyledAttributes.recycle();
    }
}
