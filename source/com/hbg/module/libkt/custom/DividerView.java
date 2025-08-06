package com.hbg.module.libkt.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.hbg.module.libkt.R$styleable;
import com.huobi.view.roundimg.RoundedDrawable;
import kotlin.jvm.internal.r;

public final class DividerView extends View {

    /* renamed from: h  reason: collision with root package name */
    public static final a f24658h = new a((r) null);

    /* renamed from: b  reason: collision with root package name */
    public int f24659b;

    /* renamed from: c  reason: collision with root package name */
    public int f24660c;

    /* renamed from: d  reason: collision with root package name */
    public int f24661d;

    /* renamed from: e  reason: collision with root package name */
    public int f24662e;

    /* renamed from: f  reason: collision with root package name */
    public int f24663f;

    /* renamed from: g  reason: collision with root package name */
    public final Paint f24664g;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public DividerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (r) null);
    }

    /* JADX INFO: finally extract failed */
    public DividerView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.DividerView, 0, 0);
        try {
            this.f24659b = obtainStyledAttributes.getDimensionPixelSize(R$styleable.DividerView_dashGap, 5);
            this.f24660c = obtainStyledAttributes.getDimensionPixelSize(R$styleable.DividerView_dashLength, 5);
            this.f24661d = obtainStyledAttributes.getDimensionPixelSize(R$styleable.DividerView_dashThickness, 3);
            this.f24662e = obtainStyledAttributes.getColor(R$styleable.DividerView_dividerLineColor, RoundedDrawable.DEFAULT_BORDER_COLOR);
            this.f24663f = obtainStyledAttributes.getInt(R$styleable.DividerView_dividerOrientation, 0);
            obtainStyledAttributes.recycle();
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(this.f24662e);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth((float) this.f24661d);
            paint.setPathEffect(new DashPathEffect(new float[]{(float) this.f24659b, (float) this.f24660c}, 0.0f));
            this.f24664g = paint;
        } catch (Throwable th2) {
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f24663f == 0) {
            float height = ((float) getHeight()) * 0.5f;
            canvas.drawLine(0.0f, height, (float) getWidth(), height, this.f24664g);
            return;
        }
        float width = ((float) getWidth()) * 0.5f;
        canvas.drawLine(width, 0.0f, width, (float) getHeight(), this.f24664g);
    }

    public final void setDividerLineColor(int i11) {
        this.f24664g.setColor(i11);
        invalidate();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DividerView(Context context, AttributeSet attributeSet, int i11, int i12, r rVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }
}
