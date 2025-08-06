package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.List;
import net.lucode.hackware.magicindicator.FragmentContainerHelper;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.model.PositionData;
import q10.b;

public class WrapPagerIndicator extends View implements b {

    /* renamed from: b  reason: collision with root package name */
    public int f58505b;

    /* renamed from: c  reason: collision with root package name */
    public int f58506c;

    /* renamed from: d  reason: collision with root package name */
    public int f58507d;

    /* renamed from: e  reason: collision with root package name */
    public float f58508e;

    /* renamed from: f  reason: collision with root package name */
    public Interpolator f58509f = new LinearInterpolator();

    /* renamed from: g  reason: collision with root package name */
    public Interpolator f58510g = new LinearInterpolator();

    /* renamed from: h  reason: collision with root package name */
    public List<PositionData> f58511h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f58512i;

    /* renamed from: j  reason: collision with root package name */
    public RectF f58513j = new RectF();

    /* renamed from: k  reason: collision with root package name */
    public boolean f58514k;

    public WrapPagerIndicator(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        Paint paint = new Paint(1);
        this.f58512i = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f58505b = UIUtil.a(context, 6.0d);
        this.f58506c = UIUtil.a(context, 10.0d);
    }

    public Interpolator getEndInterpolator() {
        return this.f58510g;
    }

    public int getFillColor() {
        return this.f58507d;
    }

    public int getHorizontalPadding() {
        return this.f58506c;
    }

    public Paint getPaint() {
        return this.f58512i;
    }

    public float getRoundRadius() {
        return this.f58508e;
    }

    public Interpolator getStartInterpolator() {
        return this.f58509f;
    }

    public int getVerticalPadding() {
        return this.f58505b;
    }

    public void onDraw(Canvas canvas) {
        this.f58512i.setColor(this.f58507d);
        RectF rectF = this.f58513j;
        float f11 = this.f58508e;
        canvas.drawRoundRect(rectF, f11, f11, this.f58512i);
    }

    public void onPageScrollStateChanged(int i11) {
    }

    public void onPageScrolled(int i11, float f11, int i12) {
        List<PositionData> list = this.f58511h;
        if (list != null && !list.isEmpty()) {
            PositionData g11 = FragmentContainerHelper.g(this.f58511h, i11);
            PositionData g12 = FragmentContainerHelper.g(this.f58511h, i11 + 1);
            RectF rectF = this.f58513j;
            int i13 = g11.f58519e;
            rectF.left = ((float) (i13 - this.f58506c)) + (((float) (g12.f58519e - i13)) * this.f58510g.getInterpolation(f11));
            RectF rectF2 = this.f58513j;
            rectF2.top = (float) (g11.f58520f - this.f58505b);
            int i14 = g11.f58521g;
            rectF2.right = ((float) (this.f58506c + i14)) + (((float) (g12.f58521g - i14)) * this.f58509f.getInterpolation(f11));
            RectF rectF3 = this.f58513j;
            rectF3.bottom = (float) (g11.f58522h + this.f58505b);
            if (!this.f58514k) {
                this.f58508e = rectF3.height() / 2.0f;
            }
            invalidate();
        }
    }

    public void onPageSelected(int i11) {
    }

    public void onPositionDataProvide(List<PositionData> list) {
        this.f58511h = list;
    }

    public void setEndInterpolator(Interpolator interpolator) {
        this.f58510g = interpolator;
        if (interpolator == null) {
            this.f58510g = new LinearInterpolator();
        }
    }

    public void setFillColor(int i11) {
        this.f58507d = i11;
    }

    public void setHorizontalPadding(int i11) {
        this.f58506c = i11;
    }

    public void setRoundRadius(float f11) {
        this.f58508e = f11;
        this.f58514k = true;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.f58509f = interpolator;
        if (interpolator == null) {
            this.f58509f = new LinearInterpolator();
        }
    }

    public void setVerticalPadding(int i11) {
        this.f58505b = i11;
    }
}
