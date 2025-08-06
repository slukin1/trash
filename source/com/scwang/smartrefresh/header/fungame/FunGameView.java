package com.scwang.smartrefresh.header.fungame;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.huobi.view.roundimg.RoundedDrawable;
import com.scwang.smartrefresh.header.R$styleable;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import iy.a;
import ky.i;
import ky.j;

public abstract class FunGameView extends FunGameHeader {
    public static String H = "游戏结束";
    public static String I = "玩个游戏解解闷";
    public static String J = "刷新完成";
    public static String K = "刷新失败";
    public int A;
    public int B = 0;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G = -10461088;

    /* renamed from: x  reason: collision with root package name */
    public Paint f29676x;

    /* renamed from: y  reason: collision with root package name */
    public TextPaint f29677y;

    /* renamed from: z  reason: collision with root package name */
    public float f29678z;

    public FunGameView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k(context, attributeSet);
    }

    private void k(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FunGameView);
        this.F = obtainStyledAttributes.getColor(R$styleable.FunGameView_fgvBackColor, 0);
        this.C = obtainStyledAttributes.getColor(R$styleable.FunGameView_fgvLeftColor, Color.rgb(0, 0, 0));
        this.E = obtainStyledAttributes.getColor(R$styleable.FunGameView_fgvMiddleColor, RoundedDrawable.DEFAULT_BORDER_COLOR);
        this.D = obtainStyledAttributes.getColor(R$styleable.FunGameView_fgvRightColor, Color.parseColor("#A5A5A5"));
        int i11 = R$styleable.FunGameView_fgvTextGameOver;
        if (obtainStyledAttributes.hasValue(i11)) {
            H = obtainStyledAttributes.getString(i11);
        }
        if (obtainStyledAttributes.hasValue(i11)) {
            I = obtainStyledAttributes.getString(R$styleable.FunGameView_fgvTextLoading);
        }
        if (obtainStyledAttributes.hasValue(i11)) {
            J = obtainStyledAttributes.getString(R$styleable.FunGameView_fgvTextLoadingFinished);
        }
        obtainStyledAttributes.recycle();
        s();
        r();
        t();
    }

    public void b(float f11, int i11, int i12, int i13) {
        u((float) Math.max(i11, 0));
    }

    public void dispatchDraw(Canvas canvas) {
        int width = getWidth();
        int i11 = this.f29654c;
        o(canvas, width, i11);
        q(canvas, width, i11);
        p(canvas, width, i11);
        super.dispatchDraw(canvas);
    }

    public int getCurrStatus() {
        return this.B;
    }

    public String getTextGameOver() {
        return H;
    }

    public String getTextLoading() {
        return I;
    }

    public String getTextLoadingFinished() {
        return J;
    }

    public void l() {
        v(1);
    }

    public final void o(Canvas canvas, int i11, int i12) {
        this.f29676x.setColor(this.F);
        float f11 = (float) i12;
        Canvas canvas2 = canvas;
        float f12 = (float) i11;
        canvas2.drawRect(0.0f, 0.0f, f12, f11, this.f29676x);
        this.f29676x.setColor(this.G);
        canvas2.drawLine(0.0f, 0.0f, f12, 0.0f, this.f29676x);
        float f13 = this.f29664m;
        canvas2.drawLine(0.0f, f11 - f13, f12, f11 - f13, this.f29676x);
    }

    public int onFinish(j jVar, boolean z11) {
        if (this.f29659h) {
            v(z11 ? 3 : 4);
        } else {
            v(0);
        }
        return super.onFinish(jVar, z11);
    }

    public void onInitialized(i iVar, int i11, int i12) {
        super.onInitialized(iVar, i11, i12);
        t();
        v(0);
    }

    public abstract void p(Canvas canvas, int i11, int i12);

    public final void q(Canvas canvas, int i11, int i12) {
        int i13 = this.B;
        if (i13 == 0 || i13 == 1) {
            this.f29677y.setTextSize((float) DensityUtil.b(25.0f));
            w(canvas, I, i11, i12);
        } else if (i13 == 2) {
            this.f29677y.setTextSize((float) DensityUtil.b(25.0f));
            w(canvas, H, i11, i12);
        } else if (i13 == 3) {
            this.f29677y.setTextSize((float) DensityUtil.b(20.0f));
            w(canvas, J, i11, i12);
        } else if (i13 == 4) {
            this.f29677y.setTextSize((float) DensityUtil.b(20.0f));
            w(canvas, K, i11, i12);
        }
    }

    public void r() {
        this.f29678z = this.f29664m;
    }

    public void s() {
        TextPaint textPaint = new TextPaint(1);
        this.f29677y = textPaint;
        textPaint.setColor(Color.parseColor("#C1C2C2"));
        Paint paint = new Paint(1);
        this.f29676x = paint;
        paint.setStrokeWidth(this.f29664m);
    }

    @Deprecated
    public void setPrimaryColors(int... iArr) {
        super.setPrimaryColors(iArr);
        if (iArr.length > 0) {
            int i11 = iArr[0];
            this.F = i11;
            this.G = i11;
            if (i11 == 0 || i11 == -1) {
                this.G = -10461088;
            }
            if (iArr.length > 1) {
                this.E = iArr[1];
                this.C = a.d(iArr[1], HideBottomViewOnScrollBehavior.ENTER_ANIMATION_DURATION);
                this.D = a.d(iArr[1], 200);
                this.f29677y.setColor(a.d(iArr[1], 150));
            }
        }
    }

    public void setTextGameOver(String str) {
        H = str;
    }

    public void setTextLoading(String str) {
        I = str;
    }

    public void setTextLoadingFinished(String str) {
        J = str;
    }

    public abstract void t();

    public void u(float f11) {
        float f12 = (((float) this.f29654c) - (this.f29664m * 2.0f)) - ((float) this.A);
        if (f11 > f12) {
            f11 = f12;
        }
        this.f29678z = f11;
        postInvalidate();
    }

    public void v(int i11) {
        this.B = i11;
        if (i11 == 0) {
            x();
        }
        postInvalidate();
    }

    public final void w(Canvas canvas, String str, int i11, int i12) {
        canvas.drawText(str, (((float) i11) - this.f29677y.measureText(str)) * 0.5f, (((float) i12) * 0.5f) - ((this.f29677y.ascent() + this.f29677y.descent()) * 0.5f), this.f29677y);
    }

    public abstract void x();

    public FunGameView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        k(context, attributeSet);
    }
}
