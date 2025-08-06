package com.hbg.lib.widgets;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

public class CommonCornerTabLayout extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public TextView f71074b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f71075c;

    /* renamed from: d  reason: collision with root package name */
    public a f71076d;

    /* renamed from: e  reason: collision with root package name */
    public int f71077e;

    /* renamed from: f  reason: collision with root package name */
    public final RectF f71078f;

    /* renamed from: g  reason: collision with root package name */
    public final Paint f71079g;

    /* renamed from: h  reason: collision with root package name */
    public int f71080h;

    /* renamed from: i  reason: collision with root package name */
    public float f71081i;

    /* renamed from: j  reason: collision with root package name */
    public int f71082j;

    public interface a {
        void a(int i11);
    }

    public CommonCornerTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void d(View view) {
        this.f71077e = 0;
        a aVar = this.f71076d;
        if (aVar != null) {
            aVar.a(0);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void e(View view) {
        this.f71077e = 1;
        a aVar = this.f71076d;
        if (aVar != null) {
            aVar.a(1);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(ValueAnimator valueAnimator) {
        this.f71081i = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    public void g(String str, String str2) {
        this.f71074b.setText(str);
        this.f71075c.setText(str2);
    }

    public TextView getTextView1() {
        return this.f71074b;
    }

    public TextView getTextView2() {
        return this.f71075c;
    }

    public void onDraw(Canvas canvas) {
        int width = ((getWidth() - getPaddingLeft()) - getPaddingRight()) / 2;
        int paddingLeft = getPaddingLeft() + ((int) (this.f71081i * ((float) width)));
        this.f71078f.set((float) paddingLeft, (float) this.f71082j, (float) (paddingLeft + width), (float) (getHeight() - this.f71082j));
        RectF rectF = this.f71078f;
        int i11 = this.f71080h;
        canvas.drawRoundRect(rectF, (float) i11, (float) i11, this.f71079g);
        super.onDraw(canvas);
    }

    public void setCallback(a aVar) {
        this.f71076d = aVar;
    }

    public void setSelectIndex(int i11) {
        this.f71077e = i11;
        if (i11 == 0) {
            this.f71074b.setTextColor(getResources().getColor(R$color.baseColorPrimaryText));
            this.f71075c.setTextColor(getResources().getColor(R$color.baseColorSecondaryText));
        } else {
            this.f71074b.setTextColor(getResources().getColor(R$color.baseColorSecondaryText));
            this.f71075c.setTextColor(getResources().getColor(R$color.baseColorPrimaryText));
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.f71081i, (float) this.f71077e});
        ofFloat.addUpdateListener(new j(this));
        ofFloat.setDuration(150);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.start();
    }

    public CommonCornerTabLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f71078f = new RectF();
        Paint paint = new Paint();
        this.f71079g = paint;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CommonCornerTabLayout, i11, 0);
        String string = obtainStyledAttributes.getString(R$styleable.CommonCornerTabLayout_cctl_text1);
        String string2 = obtainStyledAttributes.getString(R$styleable.CommonCornerTabLayout_cctl_text2);
        Drawable drawable = obtainStyledAttributes.getDrawable(R$styleable.CommonCornerTabLayout_cctl_text1_drawable_right);
        obtainStyledAttributes.recycle();
        LinearLayout.inflate(context, R$layout.common_corner_tab_layout, this);
        Resources resources = getResources();
        int i12 = R$dimen.dimen_3;
        this.f71082j = resources.getDimensionPixelOffset(i12);
        setPadding(getResources().getDimensionPixelOffset(i12), 0, getResources().getDimensionPixelOffset(i12), 0);
        this.f71074b = (TextView) findViewById(R$id.id_common_corner_tab_tv1);
        this.f71075c = (TextView) findViewById(R$id.id_common_corner_tab_tv2);
        if (drawable != null) {
            this.f71074b.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        }
        setWillNotDraw(false);
        this.f71080h = getResources().getDimensionPixelOffset(i12);
        paint.setColor(getResources().getColor(R$color.grid_trade_subtab_bg_color));
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        findViewById(R$id.id_common_corner_tab_layout1).setOnClickListener(new k(this));
        findViewById(R$id.id_common_corner_tab_layout2).setOnClickListener(new l(this));
        if (!TextUtils.isEmpty(string)) {
            this.f71074b.setText(string);
        }
        if (!TextUtils.isEmpty(string2)) {
            this.f71075c.setText(string2);
        }
    }
}
