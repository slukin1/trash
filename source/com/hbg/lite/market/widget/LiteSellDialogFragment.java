package com.hbg.lite.market.widget;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lite.R$color;
import com.hbg.lite.R$id;
import com.hbg.lite.R$layout;
import com.hbg.lite.R$string;
import i6.r;
import sa.a;
import va.b;

public class LiteSellDialogFragment extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f77282b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f77283c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f77284d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f77285e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f77286f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f77287g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f77288h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f77289i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f77290j;

    /* renamed from: k  reason: collision with root package name */
    public View.OnClickListener f77291k;

    /* renamed from: l  reason: collision with root package name */
    public String f77292l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f77293m = true;

    /* renamed from: n  reason: collision with root package name */
    public boolean f77294n = true;

    public void addEvent(r rVar) {
        View.OnClickListener onClickListener = this.f77290j;
        if (onClickListener != null && this.f77294n) {
            this.f77282b.setOnClickListener(onClickListener);
        }
        View.OnClickListener onClickListener2 = this.f77291k;
        if (onClickListener2 != null && this.f77293m) {
            this.f77283c.setOnClickListener(onClickListener2);
        }
    }

    public void afterInit() {
    }

    public int getContentViewResId() {
        return R$layout.lite_fragment_market_sell;
    }

    public int getGravity() {
        return 80;
    }

    public void initView(r rVar) {
        this.f77282b = (RelativeLayout) rVar.b(R$id.rl_sell_usdt);
        this.f77283c = (RelativeLayout) rVar.b(R$id.rl_sell_cny);
        this.f77284d = (ImageView) rVar.b(R$id.iv_sell_usdt);
        this.f77285e = (ImageView) rVar.b(R$id.iv_sell_cny);
        this.f77286f = (TextView) rVar.b(R$id.tv_sell_cny_title);
        this.f77287g = (TextView) rVar.b(R$id.tv_sell_cny_hint);
        this.f77288h = (TextView) rVar.b(R$id.tv_sell_usdt_title);
        this.f77289i = (TextView) rVar.b(R$id.tv_sell_usdt_hint);
        this.f77292l = a.c();
        this.f77286f.setText(String.format(getString(R$string.lite_market_currency_sell_title), new Object[]{b.l(a.c()).toUpperCase()}));
        if (this.f77293m) {
            this.f77286f.setTextColor(getResources().getColor(R$color.baseColorPrimaryText));
            this.f77287g.setText(R$string.lite_market_cny_sell_hint_available);
        } else {
            this.f77286f.setTextColor(getResources().getColor(R$color.baseColorThreeLevelText));
            this.f77287g.setText(R$string.lite_market_cny_sell_hint);
        }
        if (!this.f77294n) {
            this.f77288h.setTextColor(getResources().getColor(R$color.baseColorThreeLevelText));
            this.f77289i.setTextColor(getResources().getColor(R$color.baseColorSecondaryText));
            this.f77289i.setText(getResources().getString(R$string.lite_market_cny_sell_hint));
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

    public void sh(View.OnClickListener onClickListener) {
        this.f77290j = onClickListener;
    }

    public void th(View.OnClickListener onClickListener) {
        this.f77291k = onClickListener;
    }
}
