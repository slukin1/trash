package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.Arrays;
import java.util.List;
import net.lucode.hackware.magicindicator.FragmentContainerHelper;
import net.lucode.hackware.magicindicator.buildins.ArgbEvaluatorHolder;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.model.PositionData;
import q10.b;

public class LinePagerIndicator extends View implements b {

    /* renamed from: b  reason: collision with root package name */
    public int f58493b;

    /* renamed from: c  reason: collision with root package name */
    public Interpolator f58494c = new LinearInterpolator();

    /* renamed from: d  reason: collision with root package name */
    public Interpolator f58495d = new LinearInterpolator();

    /* renamed from: e  reason: collision with root package name */
    public float f58496e;

    /* renamed from: f  reason: collision with root package name */
    public float f58497f;

    /* renamed from: g  reason: collision with root package name */
    public float f58498g;

    /* renamed from: h  reason: collision with root package name */
    public float f58499h;

    /* renamed from: i  reason: collision with root package name */
    public float f58500i;

    /* renamed from: j  reason: collision with root package name */
    public Paint f58501j;

    /* renamed from: k  reason: collision with root package name */
    public List<PositionData> f58502k;

    /* renamed from: l  reason: collision with root package name */
    public List<Integer> f58503l;

    /* renamed from: m  reason: collision with root package name */
    public RectF f58504m = new RectF();

    public LinePagerIndicator(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        Paint paint = new Paint(1);
        this.f58501j = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f58497f = (float) UIUtil.a(context, 3.0d);
        this.f58499h = (float) UIUtil.a(context, 10.0d);
    }

    public List<Integer> getColors() {
        return this.f58503l;
    }

    public Interpolator getEndInterpolator() {
        return this.f58495d;
    }

    public float getLineHeight() {
        return this.f58497f;
    }

    public float getLineWidth() {
        return this.f58499h;
    }

    public int getMode() {
        return this.f58493b;
    }

    public Paint getPaint() {
        return this.f58501j;
    }

    public float getRoundRadius() {
        return this.f58500i;
    }

    public Interpolator getStartInterpolator() {
        return this.f58494c;
    }

    public float getXOffset() {
        return this.f58498g;
    }

    public float getYOffset() {
        return this.f58496e;
    }

    public void onDraw(Canvas canvas) {
        RectF rectF = this.f58504m;
        float f11 = this.f58500i;
        canvas.drawRoundRect(rectF, f11, f11, this.f58501j);
    }

    public void onPageScrollStateChanged(int i11) {
    }

    public void onPageScrolled(int i11, float f11, int i12) {
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        int i13;
        List<PositionData> list = this.f58502k;
        if (list != null && !list.isEmpty()) {
            List<Integer> list2 = this.f58503l;
            if (list2 != null && list2.size() > 0) {
                this.f58501j.setColor(ArgbEvaluatorHolder.a(f11, this.f58503l.get(Math.abs(i11) % this.f58503l.size()).intValue(), this.f58503l.get(Math.abs(i11 + 1) % this.f58503l.size()).intValue()));
            }
            PositionData g11 = FragmentContainerHelper.g(this.f58502k, i11);
            PositionData g12 = FragmentContainerHelper.g(this.f58502k, i11 + 1);
            int i14 = this.f58493b;
            if (i14 == 0) {
                f16 = this.f58498g;
                f15 = ((float) g11.f58515a) + f16;
                f14 = ((float) g12.f58515a) + f16;
                f12 = ((float) g11.f58517c) - f16;
                i13 = g12.f58517c;
            } else if (i14 == 1) {
                f16 = this.f58498g;
                f15 = ((float) g11.f58519e) + f16;
                f14 = ((float) g12.f58519e) + f16;
                f12 = ((float) g11.f58521g) - f16;
                i13 = g12.f58521g;
            } else {
                f15 = ((float) g11.f58515a) + ((((float) g11.b()) - this.f58499h) / 2.0f);
                float b11 = ((float) g12.f58515a) + ((((float) g12.b()) - this.f58499h) / 2.0f);
                f12 = ((((float) g11.b()) + this.f58499h) / 2.0f) + ((float) g11.f58515a);
                f13 = ((((float) g12.b()) + this.f58499h) / 2.0f) + ((float) g12.f58515a);
                f14 = b11;
                this.f58504m.left = f15 + ((f14 - f15) * this.f58494c.getInterpolation(f11));
                this.f58504m.right = f12 + ((f13 - f12) * this.f58495d.getInterpolation(f11));
                this.f58504m.top = (((float) getHeight()) - this.f58497f) - this.f58496e;
                this.f58504m.bottom = ((float) getHeight()) - this.f58496e;
                invalidate();
            }
            f13 = ((float) i13) - f16;
            this.f58504m.left = f15 + ((f14 - f15) * this.f58494c.getInterpolation(f11));
            this.f58504m.right = f12 + ((f13 - f12) * this.f58495d.getInterpolation(f11));
            this.f58504m.top = (((float) getHeight()) - this.f58497f) - this.f58496e;
            this.f58504m.bottom = ((float) getHeight()) - this.f58496e;
            invalidate();
        }
    }

    public void onPageSelected(int i11) {
    }

    public void onPositionDataProvide(List<PositionData> list) {
        this.f58502k = list;
    }

    public void setColors(Integer... numArr) {
        this.f58503l = Arrays.asList(numArr);
    }

    public void setEndInterpolator(Interpolator interpolator) {
        this.f58495d = interpolator;
        if (interpolator == null) {
            this.f58495d = new LinearInterpolator();
        }
    }

    public void setLineHeight(float f11) {
        this.f58497f = f11;
    }

    public void setLineWidth(float f11) {
        this.f58499h = f11;
    }

    public void setMode(int i11) {
        if (i11 == 2 || i11 == 0 || i11 == 1) {
            this.f58493b = i11;
            return;
        }
        throw new IllegalArgumentException("mode " + i11 + " not supported.");
    }

    public void setRoundRadius(float f11) {
        this.f58500i = f11;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.f58494c = interpolator;
        if (interpolator == null) {
            this.f58494c = new LinearInterpolator();
        }
    }

    public void setXOffset(float f11) {
        this.f58498g = f11;
    }

    public void setYOffset(float f11) {
        this.f58496e = f11;
    }
}
