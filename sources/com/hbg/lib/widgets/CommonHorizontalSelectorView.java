package com.hbg.lib.widgets;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonHorizontalSelectorView extends LinearLayout implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final Paint f71128b;

    /* renamed from: c  reason: collision with root package name */
    public final Path f71129c;

    /* renamed from: d  reason: collision with root package name */
    public final RectF f71130d;

    /* renamed from: e  reason: collision with root package name */
    public int f71131e;

    /* renamed from: f  reason: collision with root package name */
    public int f71132f;

    /* renamed from: g  reason: collision with root package name */
    public int f71133g;

    /* renamed from: h  reason: collision with root package name */
    public int f71134h;

    /* renamed from: i  reason: collision with root package name */
    public int f71135i;

    /* renamed from: j  reason: collision with root package name */
    public final List<String> f71136j;

    /* renamed from: k  reason: collision with root package name */
    public int f71137k;

    /* renamed from: l  reason: collision with root package name */
    public float f71138l;

    /* renamed from: m  reason: collision with root package name */
    public int f71139m;

    /* renamed from: n  reason: collision with root package name */
    public int f71140n;

    /* renamed from: o  reason: collision with root package name */
    public int f71141o;

    /* renamed from: p  reason: collision with root package name */
    public a f71142p;

    public interface a {
        void a(int i11, String str);
    }

    public CommonHorizontalSelectorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(ValueAnimator valueAnimator) {
        this.f71138l = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    public void c(int i11, boolean z11) {
        if (this.f71137k != i11) {
            this.f71137k = i11;
            for (int i12 = 0; i12 < getChildCount(); i12++) {
                TextView textView = (TextView) getChildAt(i12);
                if (this.f71137k == i12) {
                    textView.setTextColor(this.f71139m);
                } else {
                    textView.setTextColor(this.f71140n);
                }
            }
            if (z11) {
                ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.f71138l, (float) this.f71137k});
                ofFloat.setDuration(270);
                ofFloat.setInterpolator(new DecelerateInterpolator());
                ofFloat.addUpdateListener(new p(this));
                ofFloat.start();
            } else {
                this.f71138l = (float) this.f71137k;
            }
            if (this.f71142p != null) {
                String str = null;
                int i13 = this.f71137k;
                if (i13 >= 0 && i13 < this.f71136j.size()) {
                    str = this.f71136j.get(this.f71137k);
                }
                this.f71142p.a(this.f71137k, str);
            }
        }
    }

    public void dispatchDraw(Canvas canvas) {
        this.f71130d.set((float) this.f71132f, 0.0f, (float) (getWidth() - this.f71132f), (float) getHeight());
        this.f71128b.setColor(this.f71133g);
        this.f71128b.setStrokeWidth((float) this.f71132f);
        this.f71128b.setStyle(Paint.Style.STROKE);
        RectF rectF = this.f71130d;
        int i11 = this.f71131e;
        canvas.drawRoundRect(rectF, (float) i11, (float) i11, this.f71128b);
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        if (!this.f71136j.isEmpty()) {
            width /= this.f71136j.size();
        }
        if (width > 0) {
            float f11 = (float) width;
            float paddingLeft = ((float) getPaddingLeft()) + (this.f71138l * f11);
            this.f71130d.set(paddingLeft, (float) getPaddingTop(), f11 + paddingLeft, (float) (getHeight() - getPaddingBottom()));
            this.f71128b.setStrokeWidth(0.0f);
            this.f71128b.setColor(this.f71135i);
            this.f71128b.setStyle(Paint.Style.FILL_AND_STROKE);
            RectF rectF2 = this.f71130d;
            int i12 = this.f71134h;
            canvas.drawRoundRect(rectF2, (float) i12, (float) i12, this.f71128b);
        }
        super.dispatchDraw(canvas);
    }

    public int getCurrentPosition() {
        return this.f71137k;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        c(((Integer) view.getTag()).intValue(), true);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void setCallback(a aVar) {
        this.f71142p = aVar;
    }

    public void setStringList(String... strArr) {
        this.f71136j.clear();
        this.f71136j.addAll(Arrays.asList(strArr));
        removeAllViews();
        for (int i11 = 0; i11 < this.f71136j.size(); i11++) {
            String str = this.f71136j.get(i11);
            TextView textView = new TextView(getContext());
            textView.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0f));
            if (this.f71137k == i11) {
                textView.setTextColor(this.f71139m);
            } else {
                textView.setTextColor(this.f71140n);
            }
            textView.setTextSize(0, (float) this.f71141o);
            textView.setGravity(17);
            textView.setText(str);
            textView.setTag(Integer.valueOf(i11));
            textView.setOnClickListener(this);
            addView(textView);
        }
    }

    public CommonHorizontalSelectorView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Paint paint = new Paint();
        this.f71128b = paint;
        this.f71129c = new Path();
        this.f71130d = new RectF();
        this.f71136j = new ArrayList();
        setOrientation(0);
        this.f71131e = 0;
        this.f71134h = 0;
        this.f71132f = getResources().getDimensionPixelOffset(R$dimen.dimen_1);
        this.f71133g = getResources().getColor(R$color.baseColorPrimarySeparator);
        this.f71135i = getResources().getColor(R$color.baseColorMajorTheme100);
        paint.setAntiAlias(true);
        this.f71139m = getResources().getColor(R$color.white);
        this.f71140n = getResources().getColor(R$color.baseColorPrimaryText);
        this.f71141o = getResources().getDimensionPixelOffset(R$dimen.global_text_size_12);
    }
}
