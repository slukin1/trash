package com.scwang.smartrefresh.layout.footer.ballpulse;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BallPulseView extends View {

    /* renamed from: b  reason: collision with root package name */
    public Paint f29840b;

    /* renamed from: c  reason: collision with root package name */
    public int f29841c;

    /* renamed from: d  reason: collision with root package name */
    public int f29842d;

    /* renamed from: e  reason: collision with root package name */
    public float f29843e;

    /* renamed from: f  reason: collision with root package name */
    public float[] f29844f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f29845g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<ValueAnimator> f29846h;

    /* renamed from: i  reason: collision with root package name */
    public Map<ValueAnimator, ValueAnimator.AnimatorUpdateListener> f29847i;

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f29848b;

        public a(int i11) {
            this.f29848b = i11;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            BallPulseView.this.f29844f[this.f29848b] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            BallPulseView.this.postInvalidate();
        }
    }

    public BallPulseView(Context context) {
        this(context, (AttributeSet) null);
    }

    public final void b() {
        this.f29846h = new ArrayList<>();
        int[] iArr = {120, 240, 360};
        for (int i11 = 0; i11 < 3; i11++) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.3f, 1.0f});
            ofFloat.setDuration(750);
            ofFloat.setRepeatCount(-1);
            ofFloat.setStartDelay((long) iArr[i11]);
            this.f29847i.put(ofFloat, new a(i11));
            this.f29846h.add(ofFloat);
        }
    }

    public final boolean c() {
        return this.f29845g;
    }

    public void d() {
        if (this.f29846h == null) {
            b();
        }
        if (this.f29846h != null && !c()) {
            for (int i11 = 0; i11 < this.f29846h.size(); i11++) {
                ValueAnimator valueAnimator = this.f29846h.get(i11);
                ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.f29847i.get(valueAnimator);
                if (animatorUpdateListener != null) {
                    valueAnimator.addUpdateListener(animatorUpdateListener);
                }
                valueAnimator.start();
            }
            this.f29845g = true;
            setIndicatorColor(this.f29842d);
        }
    }

    public void e() {
        ArrayList<ValueAnimator> arrayList = this.f29846h;
        if (arrayList != null && this.f29845g) {
            this.f29845g = false;
            Iterator<ValueAnimator> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ValueAnimator next = it2.next();
                if (next != null) {
                    next.removeAllUpdateListeners();
                    next.end();
                }
            }
            this.f29844f = new float[]{1.0f, 1.0f, 1.0f};
        }
        setIndicatorColor(this.f29841c);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f29846h != null) {
            for (int i11 = 0; i11 < this.f29846h.size(); i11++) {
                this.f29846h.get(i11).cancel();
            }
        }
    }

    public void onDraw(Canvas canvas) {
        float min = (((float) Math.min(getWidth(), getHeight())) - (this.f29843e * 2.0f)) / 6.0f;
        float f11 = 2.0f * min;
        float width = ((float) (getWidth() / 2)) - (this.f29843e + f11);
        float height = (float) (getHeight() / 2);
        for (int i11 = 0; i11 < 3; i11++) {
            canvas.save();
            float f12 = (float) i11;
            canvas.translate((f11 * f12) + width + (this.f29843e * f12), height);
            float[] fArr = this.f29844f;
            canvas.scale(fArr[i11], fArr[i11]);
            canvas.drawCircle(0.0f, 0.0f, min, this.f29840b);
            canvas.restore();
        }
    }

    public void onMeasure(int i11, int i12) {
        int b11 = DensityUtil.b(50.0f);
        setMeasuredDimension(View.resolveSize(b11, i11), View.resolveSize(b11, i12));
    }

    public void setAnimatingColor(int i11) {
        this.f29842d = i11;
        if (c()) {
            setIndicatorColor(this.f29842d);
        }
    }

    public void setIndicatorColor(int i11) {
        this.f29840b.setColor(i11);
    }

    public void setNormalColor(int i11) {
        this.f29841c = i11;
        if (!c()) {
            setIndicatorColor(this.f29841c);
        }
    }

    public BallPulseView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BallPulseView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f29841c = -1118482;
        this.f29842d = -1615546;
        this.f29844f = new float[]{1.0f, 1.0f, 1.0f};
        this.f29845g = false;
        this.f29847i = new HashMap();
        this.f29843e = (float) DensityUtil.b(4.0f);
        Paint paint = new Paint();
        this.f29840b = paint;
        paint.setColor(-1);
        this.f29840b.setStyle(Paint.Style.FILL);
        this.f29840b.setAntiAlias(true);
    }
}
