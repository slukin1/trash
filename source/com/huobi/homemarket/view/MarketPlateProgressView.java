package com.huobi.homemarket.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.util.w;
import com.hbg.lib.widgets.R$color;

public class MarketPlateProgressView extends View {

    /* renamed from: b  reason: collision with root package name */
    public Paint f73090b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f73091c;

    /* renamed from: d  reason: collision with root package name */
    public int f73092d = -1;

    /* renamed from: e  reason: collision with root package name */
    public int f73093e = -1;

    /* renamed from: f  reason: collision with root package name */
    public Path f73094f = new Path();

    /* renamed from: g  reason: collision with root package name */
    public Path f73095g = new Path();

    /* renamed from: h  reason: collision with root package name */
    public Path f73096h = new Path();

    /* renamed from: i  reason: collision with root package name */
    public int f73097i = PixelUtils.a(4.0f);

    public MarketPlateProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public final void a(Context context) {
        Paint paint = new Paint();
        this.f73090b = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f73090b.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f73091c = paint2;
        paint2.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f73091c.setAntiAlias(true);
    }

    public void b(int i11, int i12) {
        this.f73092d = i11;
        this.f73093e = i12;
        if (i11 == 0 && i12 == 0) {
            this.f73097i = PixelUtils.a(4.0f);
        } else if (i11 == 0 || i12 == 0) {
            this.f73097i = 0;
        } else {
            this.f73097i = PixelUtils.a(4.0f);
        }
        invalidate();
    }

    public void onDraw(Canvas canvas) {
        int i11;
        super.onDraw(canvas);
        this.f73096h.reset();
        this.f73096h.addRoundRect(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), (float) (getHeight() / 2), (float) (getHeight() / 2), Path.Direction.CW);
        canvas.clipPath(this.f73096h);
        this.f73094f.reset();
        this.f73095g.reset();
        this.f73094f.moveTo(0.0f, (float) getHeight());
        this.f73095g.moveTo((float) getWidth(), 0.0f);
        int i12 = this.f73092d;
        if (i12 >= 0 && (i11 = this.f73093e) >= 0) {
            if (i12 == 0 && i11 == 0) {
                Paint paint = this.f73090b;
                Resources resources = getResources();
                int i13 = R$color.baseColorThreeLevelTextNew;
                paint.setColor(resources.getColor(i13));
                this.f73091c.setColor(getResources().getColor(i13));
                this.f73094f.lineTo(((float) getWidth()) * 0.5f, (float) getHeight());
                this.f73094f.lineTo((((float) getWidth()) * 0.5f) - ((float) this.f73097i), 0.0f);
                this.f73095g.lineTo(((float) getWidth()) * 0.5f, 0.0f);
                this.f73095g.lineTo((((float) getWidth()) * 0.5f) + ((float) this.f73097i), (float) getHeight());
            } else {
                this.f73090b.setColor(getResources().getColor(w.h()));
                this.f73091c.setColor(getResources().getColor(w.d()));
                Path path = this.f73094f;
                int width = getWidth();
                int i14 = this.f73092d;
                path.lineTo((float) ((width * i14) / (i14 + this.f73093e)), (float) getHeight());
                Path path2 = this.f73094f;
                int width2 = getWidth();
                int i15 = this.f73092d;
                path2.lineTo((float) (((width2 * i15) / (i15 + this.f73093e)) - this.f73097i), 0.0f);
                Path path3 = this.f73095g;
                int width3 = getWidth();
                int i16 = this.f73092d;
                path3.lineTo((float) ((width3 * i16) / (i16 + this.f73093e)), 0.0f);
                Path path4 = this.f73095g;
                int width4 = getWidth();
                int i17 = this.f73092d;
                path4.lineTo((float) (((width4 * i17) / (i17 + this.f73093e)) + this.f73097i), (float) getHeight());
            }
            this.f73094f.lineTo(0.0f, 0.0f);
            this.f73094f.close();
            canvas.drawPath(this.f73094f, this.f73090b);
            this.f73095g.lineTo((float) getWidth(), (float) getHeight());
            this.f73095g.close();
            canvas.drawPath(this.f73095g, this.f73091c);
        }
    }

    public MarketPlateProgressView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a(context);
    }
}
