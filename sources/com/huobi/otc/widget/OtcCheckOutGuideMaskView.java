package com.huobi.otc.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import vp.b0;
import vp.c0;

public class OtcCheckOutGuideMaskView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f79948b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f79949c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f79950d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f79951e;

    /* renamed from: f  reason: collision with root package name */
    public a f79952f;

    public interface a {
        void a(OtcCheckOutGuideMaskView otcCheckOutGuideMaskView);
    }

    public OtcCheckOutGuideMaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d(context);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void f(View view) {
        c(true);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void c(boolean z11) {
        setVisibility(8);
        if (z11) {
            ConfigPreferences.n("otc_config", "checkout_mask_fist", false);
        }
        a aVar = this.f79952f;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public final void d(Context context) {
        View inflate = FrameLayout.inflate(context, R$layout.checkout_guide_layout, this);
        inflate.setOnClickListener(c0.f61135b);
        View findViewById = inflate.findViewById(R$id.mask_close_iv);
        this.f79949c = (TextView) inflate.findViewById(R$id.payment_highlight_tv);
        this.f79948b = (LinearLayout) inflate.findViewById(R$id.payment_info_container);
        this.f79950d = (TextView) inflate.findViewById(R$id.mask_desc_step1_tv);
        this.f79951e = (TextView) inflate.findViewById(R$id.bottom_view);
        findViewById.setOnClickListener(new b0(this));
        setVisibility(8);
    }

    public void setBottomViewBgDrawable(int i11) {
        this.f79951e.setBackgroundResource(i11);
    }

    public void setCallback(a aVar) {
        this.f79952f = aVar;
    }

    public void setPaymentHighlightLocation(int[] iArr) {
        TextView textView = this.f79949c;
        if (textView != null && iArr != null && iArr.length > 1) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            marginLayoutParams.topMargin = (iArr[1] - ViewUtil.g()) - PixelUtils.a(12.0f);
            this.f79949c.setLayoutParams(marginLayoutParams);
        }
    }

    public void setPaymentInfoLocation(int[] iArr) {
        LinearLayout linearLayout = this.f79948b;
        if (linearLayout != null && iArr != null && iArr.length > 1) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams();
            marginLayoutParams.topMargin = iArr[1] - ViewUtil.g();
            this.f79948b.setLayoutParams(marginLayoutParams);
        }
    }

    public OtcCheckOutGuideMaskView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        d(context);
    }
}
