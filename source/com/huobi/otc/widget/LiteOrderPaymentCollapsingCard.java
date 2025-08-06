package com.huobi.otc.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.module.otc.R$dimen;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import vp.w;
import vp.x;

public class LiteOrderPaymentCollapsingCard extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f79885b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f79886c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f79887d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f79888e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f79889f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f79890g;

    /* renamed from: h  reason: collision with root package name */
    public View f79891h;

    /* renamed from: i  reason: collision with root package name */
    public ViewGroup f79892i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f79893j = false;

    /* renamed from: k  reason: collision with root package name */
    public boolean f79894k = true;

    /* renamed from: l  reason: collision with root package name */
    public int f79895l = getResources().getDimensionPixelSize(R$dimen.dimen_35);

    /* renamed from: m  reason: collision with root package name */
    public RotateAnimation f79896m;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        public void onAnimationEnd(Animator animator) {
            LiteOrderPaymentCollapsingCard.this.f79892i.setVisibility(8);
        }
    }

    public LiteOrderPaymentCollapsingCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e();
    }

    public static /* synthetic */ void f(View view, int i11, int i12, ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (i11 <= i12 || intValue < i11) {
            layoutParams.height = intValue;
        } else {
            layoutParams.height = -2;
        }
        view.setLayoutParams(layoutParams);
        view.setAlpha(((float) intValue) / ((float) Math.max(i12, i11)));
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void g(View view) {
        ValueAnimator valueAnimator;
        if (this.f79893j) {
            boolean z11 = !(this.f79892i.getVisibility() == 0);
            h();
            int i11 = this.f79895l;
            if (z11) {
                this.f79894k = false;
                this.f79892i.setVisibility(0);
                valueAnimator = d(this.f79892i, 0, i11);
            } else {
                this.f79894k = true;
                valueAnimator = d(this.f79892i, i11, 0);
                valueAnimator.addListener(new a());
            }
            valueAnimator.start();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final ValueAnimator d(View view, int i11, int i12) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i11, i12});
        ofInt.setDuration(270);
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.addUpdateListener(new w(view, i12, i11));
        return ofInt;
    }

    public final void e() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f79885b = linearLayout;
        LinearLayout linearLayout2 = linearLayout;
        linearLayout.setGravity(17);
        ((LinearLayout) this.f79885b).setOrientation(1);
        addView(this.f79885b);
        ViewGroup viewGroup = (ViewGroup) View.inflate(getContext(), R$layout.otc_order_payment_header_view, (ViewGroup) null);
        this.f79886c = viewGroup;
        this.f79887d = (ImageView) viewGroup.findViewById(R$id.iv_icon);
        this.f79888e = (TextView) this.f79886c.findViewById(R$id.tv_payment_method);
        this.f79889f = (TextView) this.f79886c.findViewById(R$id.tv_left);
        this.f79890g = (ImageView) this.f79886c.findViewById(R$id.iv_arrow);
        this.f79891h = this.f79886c.findViewById(R$id.id_color_view);
        this.f79890g.setVisibility(this.f79893j ? 0 : 8);
        LinearLayout linearLayout3 = new LinearLayout(getContext());
        this.f79892i = linearLayout3;
        LinearLayout linearLayout4 = linearLayout3;
        linearLayout3.setGravity(17);
        ((LinearLayout) this.f79892i).setOrientation(1);
        this.f79886c.setOnClickListener(new x(this));
        this.f79885b.addView(this.f79886c);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        this.f79892i.setPadding(0, getResources().getDimensionPixelSize(R$dimen.dimen_15), 0, 0);
        this.f79885b.addView(this.f79892i, layoutParams);
    }

    public final void h() {
        if (this.f79892i.getVisibility() == 0) {
            this.f79896m = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        } else {
            this.f79896m = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
        }
        this.f79896m.setDuration(270);
        this.f79896m.setInterpolator(new LinearInterpolator());
        this.f79896m.setRepeatMode(2);
        this.f79896m.setFillAfter(true);
        this.f79890g.startAnimation(this.f79896m);
    }

    public void setHeaderViewVisible(boolean z11) {
        ViewUtil.m(this.f79886c, z11);
    }
}
