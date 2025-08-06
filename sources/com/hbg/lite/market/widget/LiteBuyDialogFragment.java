package com.hbg.lite.market.widget;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.hbg.lib.network.hbg.core.bean.TeachConfigItem;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lite.R$color;
import com.hbg.lite.R$id;
import com.hbg.lite.R$layout;
import com.hbg.lite.R$string;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import ra.c;
import va.b;

public class LiteBuyDialogFragment extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f77245b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f77246c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f77247d;

    /* renamed from: e  reason: collision with root package name */
    public View.OnClickListener f77248e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f77249f;

    /* renamed from: g  reason: collision with root package name */
    public TeachConfigItem f77250g;

    /* renamed from: h  reason: collision with root package name */
    public String f77251h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f77252i = true;

    /* renamed from: j  reason: collision with root package name */
    public boolean f77253j = true;

    public class a implements View.OnClickListener {
        public a() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            LiteBuyDialogFragment.this.dismiss();
            if (LiteBuyDialogFragment.this.f77250g != null) {
                c.b().c(LiteBuyDialogFragment.this.getActivity(), LiteBuyDialogFragment.this.f77250g.getVideoUrl(), LiteBuyDialogFragment.this.getString(R$string.lite_index_video_tutorial));
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public void addEvent(r rVar) {
        View.OnClickListener onClickListener = this.f77247d;
        if (onClickListener != null && this.f77252i) {
            this.f77245b.setOnClickListener(onClickListener);
        }
        View.OnClickListener onClickListener2 = this.f77248e;
        if (onClickListener2 != null && this.f77253j) {
            this.f77246c.setOnClickListener(onClickListener2);
        }
        this.f77249f.setOnClickListener(new a());
    }

    public void afterInit() {
    }

    public int getContentViewResId() {
        return R$layout.lite_fragment_market_buy;
    }

    public int getGravity() {
        return 80;
    }

    public void initView(r rVar) {
        this.f77245b = (RelativeLayout) rVar.b(R$id.rl_cny_buy);
        this.f77246c = (RelativeLayout) rVar.b(R$id.rl_usdt_buy);
        this.f77249f = (TextView) rVar.b(R$id.tv_video_guide);
        TextView textView = (TextView) rVar.b(R$id.tv_cny_title);
        TextView textView2 = (TextView) rVar.b(R$id.tv_cny_hint);
        TextView textView3 = (TextView) rVar.b(R$id.tv_usdt_title);
        TextView textView4 = (TextView) rVar.b(R$id.tv_usdt_hint);
        TeachConfigItem m11 = c.c().m(5);
        this.f77250g = m11;
        this.f77249f.setVisibility(m11 == null ? 8 : 0);
        this.f77251h = sa.a.c();
        textView.setText(String.format(getString(R$string.lite_market_currency_buy_title), new Object[]{b.l(this.f77251h).toUpperCase()}));
        textView2.setText(getString(R$string.lite_market_currency_buy_hint));
        if (!this.f77252i) {
            textView.setTextColor(getResources().getColor(R$color.baseColorThreeLevelText));
            textView2.setText(getResources().getString(R$string.lite_market_cny_sell_hint));
        }
        if (!this.f77253j) {
            textView3.setTextColor(getResources().getColor(R$color.baseColorThreeLevelText));
            textView4.setText(getResources().getString(R$string.lite_market_cny_sell_hint));
        }
    }

    public boolean isFullScreen() {
        return false;
    }

    public boolean isTransparent() {
        return false;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Window window = getDialog().getWindow();
        if (window != null) {
            window.setLayout(-1, -2);
        }
    }

    public void th(View.OnClickListener onClickListener) {
        this.f77247d = onClickListener;
    }

    public void uh(View.OnClickListener onClickListener) {
        this.f77248e = onClickListener;
    }
}
