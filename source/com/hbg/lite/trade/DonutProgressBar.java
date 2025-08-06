package com.hbg.lite.trade;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.core.content.ContextCompat;
import com.hbg.lite.R$color;
import com.hbg.lite.R$dimen;
import com.hbg.lite.R$styleable;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class DonutProgressBar extends View {

    /* renamed from: b  reason: collision with root package name */
    public NumberFormat f77479b;

    /* renamed from: c  reason: collision with root package name */
    public final int f77480c;

    /* renamed from: d  reason: collision with root package name */
    public int f77481d;

    /* renamed from: e  reason: collision with root package name */
    public final int f77482e;

    /* renamed from: f  reason: collision with root package name */
    public final int f77483f;

    /* renamed from: g  reason: collision with root package name */
    public int f77484g;

    /* renamed from: h  reason: collision with root package name */
    public int f77485h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f77486i;

    /* renamed from: j  reason: collision with root package name */
    public Paint f77487j;

    /* renamed from: k  reason: collision with root package name */
    public Paint f77488k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f77489l;

    /* renamed from: m  reason: collision with root package name */
    public RectF f77490m;

    /* renamed from: n  reason: collision with root package name */
    public long f77491n;

    /* renamed from: o  reason: collision with root package name */
    public float f77492o;

    /* renamed from: p  reason: collision with root package name */
    public float f77493p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f77494q;

    /* renamed from: r  reason: collision with root package name */
    public float f77495r;

    /* renamed from: s  reason: collision with root package name */
    public ValueAnimator f77496s;

    /* renamed from: t  reason: collision with root package name */
    public ValueAnimator f77497t;

    /* renamed from: u  reason: collision with root package name */
    public ValueAnimator f77498u;

    /* renamed from: v  reason: collision with root package name */
    public c f77499v;

    /* renamed from: w  reason: collision with root package name */
    public c f77500w;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float unused = DonutProgressBar.this.f77495r = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            DonutProgressBar.this.invalidate();
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float unused = DonutProgressBar.this.f77492o = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (DonutProgressBar.this.f77492o >= ((float) DonutProgressBar.this.f77491n) && DonutProgressBar.this.f77499v != null) {
                DonutProgressBar.this.f77499v.onComplete();
            }
            DonutProgressBar.this.invalidate();
        }
    }

    public interface c {
        void onComplete();
    }

    public DonutProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private float getBackgroundProgressAngle() {
        return (this.f77495r / 5000.0f) * 360.0f;
    }

    private float getProgressAngle() {
        return (getProgress() / ((float) this.f77491n)) * 360.0f;
    }

    private String getProgressText() {
        float f11 = (((float) this.f77491n) - this.f77492o) / 1000.0f;
        String format = this.f77479b.format((double) (f11 / 60.0f));
        String format2 = this.f77479b.format((double) (f11 % 60.0f));
        return format + ":" + format2;
    }

    private float getReverseProgressAngle() {
        return (getReverseProgress() / ((float) this.f77491n)) * 360.0f;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i(ValueAnimator valueAnimator) {
        c cVar;
        this.f77493p = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
        if (this.f77493p >= this.f77492o && (cVar = this.f77500w) != null) {
            cVar.onComplete();
        }
    }

    public void g() {
        ValueAnimator valueAnimator = this.f77496s;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f77496s = null;
        }
        ValueAnimator valueAnimator2 = this.f77497t;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
            this.f77497t = null;
        }
        ValueAnimator valueAnimator3 = this.f77498u;
        if (valueAnimator3 != null) {
            valueAnimator3.cancel();
            this.f77498u = null;
        }
    }

    public long getMax() {
        return this.f77491n;
    }

    public float getProgress() {
        return this.f77492o;
    }

    public float getReverseProgress() {
        return this.f77493p;
    }

    public void h(TypedArray typedArray) {
        this.f77485h = typedArray.getColor(R$styleable.DonutProgressBar_donut_bar_background_color, this.f77483f);
        this.f77484g = typedArray.getColor(R$styleable.DonutProgressBar_donut_bar_progress_color, this.f77482e);
        this.f77489l = typedArray.getBoolean(R$styleable.DonutProgressBar_donut_bar_show_text, true);
        this.f77481d = typedArray.getDimensionPixelOffset(R$styleable.DonutProgressBar_donut_bar_stroke_width, getResources().getDimensionPixelSize(R$dimen.dimen_7));
    }

    public final int j(int i11) {
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

    public void k() {
        this.f77494q = false;
        ValueAnimator valueAnimator = this.f77496s;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f77496s = null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.f77492o, (float) this.f77491n});
        this.f77496s = ofFloat;
        ofFloat.setDuration((long) (((float) this.f77491n) - this.f77492o));
        this.f77496s.setInterpolator(new LinearInterpolator());
        this.f77496s.addUpdateListener(new b());
        this.f77496s.start();
    }

    public void l() {
        ValueAnimator valueAnimator = this.f77496s;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f77496s = null;
        }
        ValueAnimator valueAnimator2 = this.f77498u;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
            this.f77498u = null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, this.f77492o});
        this.f77498u = ofFloat;
        ofFloat.setDuration(200);
        this.f77498u.setInterpolator(new LinearInterpolator());
        this.f77498u.setRepeatMode(2);
        this.f77498u.addUpdateListener(new nb.a(this));
        this.f77498u.start();
        this.f77494q = true;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f11 = (float) this.f77481d;
        this.f77490m.set(f11, f11, ((float) getWidth()) - f11, ((float) getHeight()) - f11);
        canvas.drawArc(this.f77490m, -90.0f, getBackgroundProgressAngle(), false, this.f77486i);
        if (this.f77494q) {
            Log.e("getProgress", getProgressAngle() + "");
            canvas.drawArc(this.f77490m, getReverseProgressAngle() - 90.0f, getProgressAngle() - getReverseProgressAngle(), false, this.f77487j);
        } else {
            canvas.drawArc(this.f77490m, -90.0f, getProgressAngle(), false, this.f77487j);
        }
        if (this.f77489l) {
            float descent = this.f77488k.descent() + this.f77488k.ascent();
            String progressText = getProgressText();
            canvas.drawText(progressText, (((float) getWidth()) - this.f77488k.measureText(progressText)) / 2.0f, (((float) getWidth()) - descent) / 2.0f, this.f77488k);
        }
    }

    public void onMeasure(int i11, int i12) {
        setMeasuredDimension(j(i11), j(i12));
    }

    public void onVisibilityChanged(View view, int i11) {
        super.onVisibilityChanged(view, i11);
    }

    public void setMax(long j11) {
        if (j11 > 0) {
            this.f77491n = j11;
            invalidate();
        }
    }

    public void setOnCompleteListener(c cVar) {
        this.f77499v = cVar;
    }

    public void setOnResetCompleteListener(c cVar) {
        this.f77500w = cVar;
    }

    public void setProgress(float f11) {
        this.f77492o = f11;
        if (f11 > ((float) getMax())) {
            this.f77492o %= (float) getMax();
        }
        invalidate();
    }

    public DonutProgressBar(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f77479b = new DecimalFormat("00");
        this.f77480c = 240;
        this.f77482e = Color.rgb(66, 145, 241);
        this.f77483f = Color.rgb(204, 204, 204);
        this.f77489l = false;
        this.f77490m = new RectF();
        this.f77491n = 0;
        this.f77492o = 0.0f;
        this.f77493p = 0.0f;
        this.f77494q = false;
        this.f77495r = 0.0f;
        this.f77499v = null;
        this.f77500w = null;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.DonutProgressBar, i11, 0);
        h(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.f77486i = paint;
        paint.setColor(this.f77485h);
        this.f77486i.setStyle(Paint.Style.STROKE);
        this.f77486i.setAntiAlias(true);
        this.f77486i.setStrokeWidth((float) this.f77481d);
        Paint paint2 = new Paint();
        this.f77487j = paint2;
        paint2.setColor(this.f77484g);
        this.f77487j.setStyle(Paint.Style.STROKE);
        this.f77487j.setAntiAlias(true);
        this.f77487j.setStrokeWidth((float) this.f77481d);
        this.f77487j.setStrokeCap(Paint.Cap.ROUND);
        TextPaint textPaint = new TextPaint();
        this.f77488k = textPaint;
        textPaint.setColor(ContextCompat.getColor(getContext(), R$color.baseColorMajorTheme100));
        this.f77488k.setTextSize(48.0f);
        this.f77488k.setAntiAlias(true);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 5000.0f});
        this.f77497t = ofFloat;
        ofFloat.setDuration(1000);
        this.f77497t.addUpdateListener(new a());
        this.f77497t.start();
    }
}
