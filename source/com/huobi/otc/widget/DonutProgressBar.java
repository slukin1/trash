package com.huobi.otc.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.hbg.module.otc.R$dimen;
import com.hbg.module.otc.R$styleable;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class DonutProgressBar extends View {

    /* renamed from: b  reason: collision with root package name */
    public NumberFormat f79739b;

    /* renamed from: c  reason: collision with root package name */
    public final int f79740c;

    /* renamed from: d  reason: collision with root package name */
    public int f79741d;

    /* renamed from: e  reason: collision with root package name */
    public final int f79742e;

    /* renamed from: f  reason: collision with root package name */
    public final int f79743f;

    /* renamed from: g  reason: collision with root package name */
    public int f79744g;

    /* renamed from: h  reason: collision with root package name */
    public int f79745h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f79746i;

    /* renamed from: j  reason: collision with root package name */
    public Paint f79747j;

    /* renamed from: k  reason: collision with root package name */
    public Paint f79748k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f79749l;

    /* renamed from: m  reason: collision with root package name */
    public RectF f79750m;

    /* renamed from: n  reason: collision with root package name */
    public int f79751n;

    /* renamed from: o  reason: collision with root package name */
    public float f79752o;

    /* renamed from: p  reason: collision with root package name */
    public int f79753p;

    /* renamed from: q  reason: collision with root package name */
    public float f79754q;

    /* renamed from: r  reason: collision with root package name */
    public a f79755r;

    public interface a {
    }

    public DonutProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private float getBackgroundProgressAngle() {
        return (this.f79754q / 5000.0f) * 360.0f;
    }

    private float getProgressAngle() {
        return (getProgress() / ((float) this.f79751n)) * 360.0f;
    }

    private String getProgressText() {
        int i11 = (int) ((((float) this.f79751n) - this.f79752o) / 1000.0f);
        String format = this.f79739b.format((long) (i11 / 60));
        String format2 = this.f79739b.format((long) (i11 % 60));
        return format + ":" + format2;
    }

    public void a(TypedArray typedArray) {
        this.f79745h = typedArray.getColor(R$styleable.DonutProgressBar_donut_bar_background_color, this.f79743f);
        this.f79744g = typedArray.getColor(R$styleable.DonutProgressBar_donut_bar_progress_color, this.f79742e);
        this.f79749l = typedArray.getBoolean(R$styleable.DonutProgressBar_donut_bar_show_text, true);
        this.f79741d = typedArray.getDimensionPixelOffset(R$styleable.DonutProgressBar_donut_bar_stroke_width, getResources().getDimensionPixelSize(R$dimen.dimen_7));
    }

    public final int b(int i11) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        if (mode == 1073741824) {
            return size;
        }
        if (mode == Integer.MIN_VALUE) {
            return Math.min(240, size);
        }
        return 240;
    }

    public int getMax() {
        return this.f79751n;
    }

    public float getProgress() {
        return this.f79752o;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f11 = (float) this.f79741d;
        this.f79750m.set(f11, f11, ((float) getWidth()) - f11, ((float) getHeight()) - f11);
        canvas.drawArc(this.f79750m, (float) (-this.f79753p), getBackgroundProgressAngle(), false, this.f79746i);
        canvas.drawArc(this.f79750m, (float) (-this.f79753p), getProgressAngle(), false, this.f79747j);
        if (this.f79749l) {
            float descent = this.f79748k.descent() + this.f79748k.ascent();
            String progressText = getProgressText();
            canvas.drawText(progressText, (((float) getWidth()) - this.f79748k.measureText(progressText)) / 2.0f, (((float) getWidth()) - descent) / 2.0f, this.f79748k);
        }
    }

    public void onMeasure(int i11, int i12) {
        setMeasuredDimension(b(i11), b(i12));
    }

    public void onVisibilityChanged(View view, int i11) {
        super.onVisibilityChanged(view, i11);
    }

    public void setMax(int i11) {
        if (i11 > 0) {
            this.f79751n = i11;
            invalidate();
        }
    }

    public void setOnCompleteListener(a aVar) {
        this.f79755r = aVar;
    }

    public void setProgress(float f11) {
        this.f79752o = f11;
        if (f11 > ((float) getMax())) {
            this.f79752o %= (float) getMax();
        }
        invalidate();
    }

    public void setProgressColor(int i11) {
        this.f79744g = i11;
        Paint paint = this.f79747j;
        if (paint != null) {
            paint.setColor(i11);
        }
        Paint paint2 = this.f79748k;
        if (paint2 != null) {
            paint2.setColor(i11);
        }
    }

    public DonutProgressBar(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f79739b = new DecimalFormat("00");
        this.f79740c = 240;
        this.f79742e = Color.rgb(66, 145, 241);
        this.f79743f = Color.rgb(204, 204, 204);
        this.f79749l = false;
        this.f79750m = new RectF();
        this.f79751n = 0;
        this.f79752o = 0.0f;
        this.f79753p = 90;
        this.f79754q = 0.0f;
        this.f79755r = null;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.DonutProgressBar, i11, 0);
        a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.f79746i = paint;
        paint.setColor(this.f79745h);
        this.f79746i.setStyle(Paint.Style.STROKE);
        this.f79746i.setAntiAlias(true);
        this.f79746i.setStrokeWidth((float) this.f79741d);
        Paint paint2 = new Paint();
        this.f79747j = paint2;
        paint2.setColor(this.f79744g);
        this.f79747j.setStyle(Paint.Style.STROKE);
        this.f79747j.setAntiAlias(true);
        this.f79747j.setStrokeWidth((float) this.f79741d);
        this.f79747j.setStrokeCap(Paint.Cap.ROUND);
        TextPaint textPaint = new TextPaint();
        this.f79748k = textPaint;
        textPaint.setColor(this.f79744g);
        this.f79748k.setTextSize((float) getResources().getDimensionPixelSize(R$dimen.global_text_size_20));
        this.f79748k.setAntiAlias(true);
        this.f79748k.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/din_medium.otf"));
    }
}
