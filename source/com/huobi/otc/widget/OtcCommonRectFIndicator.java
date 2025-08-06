package com.huobi.otc.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.widgets.R$color;
import net.lucode.hackware.magicindicator.buildins.UIUtil;

public class OtcCommonRectFIndicator extends View {

    /* renamed from: b  reason: collision with root package name */
    public Paint f79953b;

    /* renamed from: c  reason: collision with root package name */
    public final RectF f79954c;

    /* renamed from: d  reason: collision with root package name */
    public float f79955d;

    /* renamed from: e  reason: collision with root package name */
    public float f79956e;

    /* renamed from: f  reason: collision with root package name */
    public float f79957f;

    /* renamed from: g  reason: collision with root package name */
    public float f79958g;

    /* renamed from: h  reason: collision with root package name */
    public int f79959h;

    /* renamed from: i  reason: collision with root package name */
    public int f79960i;

    /* renamed from: j  reason: collision with root package name */
    public int f79961j;

    /* renamed from: k  reason: collision with root package name */
    public int f79962k;

    /* renamed from: l  reason: collision with root package name */
    public int f79963l;

    public OtcCommonRectFIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void a(int i11, int i12) {
        this.f79959h = i11;
        this.f79960i = i12;
        invalidate();
    }

    public void onDraw(Canvas canvas) {
        float f11;
        super.onDraw(canvas);
        float f12 = 0.0f;
        for (int i11 = 0; i11 < this.f79963l; i11++) {
            if (this.f79962k == i11) {
                this.f79954c.set(f12, 0.0f, this.f79955d + f12, (float) getHeight());
                this.f79953b.setColor(this.f79959h);
                RectF rectF = this.f79954c;
                float f13 = this.f79958g;
                canvas.drawRoundRect(rectF, f13, f13, this.f79953b);
                f11 = this.f79955d;
            } else {
                this.f79954c.set(f12, 0.0f, this.f79956e + f12, (float) getHeight());
                this.f79953b.setColor(this.f79960i);
                RectF rectF2 = this.f79954c;
                float f14 = this.f79958g;
                canvas.drawRoundRect(rectF2, f14, f14, this.f79953b);
                f11 = this.f79956e;
            }
            f12 = f12 + f11 + this.f79957f;
        }
    }

    public void setPages(int i11) {
        this.f79963l = i11;
        setPosition(this.f79962k);
        requestLayout();
    }

    public void setPosition(int i11) {
        int i12 = this.f79963l;
        if (i12 > 0 && i11 >= i12) {
            i11 %= i12;
        }
        this.f79962k = i11;
        invalidate();
    }

    public OtcCommonRectFIndicator(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f79953b = new Paint();
        this.f79954c = new RectF();
        this.f79955d = (float) PixelUtils.a(8.0f);
        this.f79956e = (float) PixelUtils.a(2.0f);
        this.f79957f = (float) PixelUtils.a(2.0f);
        this.f79958g = (float) UIUtil.a(context, 2.0d);
        Resources resources = getResources();
        int i12 = R$color.baseColorThreeLevelText;
        this.f79959h = resources.getColor(i12);
        this.f79960i = getResources().getColor(i12);
        this.f79961j = getResources().getColor(R$color.baseColorContentBackground);
        this.f79953b.setAntiAlias(true);
    }
}
