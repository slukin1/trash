package com.huobi.linearswap.ordertutorial.ui;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.ui.EmptyMVPFragment;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.controller.FutureContractInfoController;
import com.hbg.lib.data.symbol.TradeType;
import com.huobi.linearswap.bean.LinearSwapCurrencyInfoDrawerItem;
import com.huobi.main.trade.ui.OrderTutorialTradeDialogFragment;
import com.huobi.main.trade.ui.TradeDialogFragment;
import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.TimeUnit;
import pro.huobi.R;
import rx.Observable;
import zm.f;
import zm.g;
import zm.h;
import zm.i;

public class OrderTutorialStep1Fragment extends EmptyMVPFragment {

    /* renamed from: l  reason: collision with root package name */
    public TextView f75000l;

    /* renamed from: m  reason: collision with root package name */
    public View f75001m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f75002n;

    /* renamed from: o  reason: collision with root package name */
    public ImageView f75003o;

    /* renamed from: p  reason: collision with root package name */
    public TextView f75004p;

    /* renamed from: q  reason: collision with root package name */
    public View f75005q;

    /* renamed from: r  reason: collision with root package name */
    public TextView f75006r;

    /* renamed from: s  reason: collision with root package name */
    public ImageView f75007s;

    /* renamed from: t  reason: collision with root package name */
    public TextView f75008t;

    /* renamed from: u  reason: collision with root package name */
    public View f75009u;

    /* renamed from: v  reason: collision with root package name */
    public final OrderTutorialTradeDialogFragment f75010v = new OrderTutorialTradeDialogFragment();

    public class a implements TradeDialogFragment.e {
        public a() {
        }

        public void a(TradeType tradeType, s9.a aVar) {
            if (aVar instanceof LinearSwapCurrencyInfoDrawerItem) {
                FutureContractInfo e11 = ((LinearSwapCurrencyInfoDrawerItem) aVar).e();
                OrderTutorialStep1Fragment.this.f75000l.setText(e11.getContractCode().replaceAll(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""));
                an.a Jh = OrderTutorialStep1Fragment.this.Kh();
                Jh.f(e11);
                Jh.q(e11);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Nh(Void voidR) {
        Th();
        Kh().k(true);
        this.f75009u.setEnabled(true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Oh(Void voidR) {
        Uh();
        Kh().k(false);
        this.f75009u.setEnabled(true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ph(Void voidR) {
        this.f75010v.Ki(getChildFragmentManager());
        this.f75010v.ri(new a());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Qh(Void voidR) {
        Kh().L();
    }

    public final an.a Kh() {
        return ((OrderTutorialActivity) getActivity()).ph();
    }

    public final void Lh() {
        this.f75001m = this.f67460i.b(R.id.ll_long);
        this.f75002n = (TextView) this.f67460i.b(R.id.tv_long);
        this.f75003o = (ImageView) this.f67460i.b(R.id.iv_long);
        this.f75004p = (TextView) this.f67460i.b(R.id.tv_long_tips);
        this.f75005q = this.f67460i.b(R.id.ll_short);
        this.f75006r = (TextView) this.f67460i.b(R.id.tv_short);
        this.f75007s = (ImageView) this.f67460i.b(R.id.iv_short);
        this.f75008t = (TextView) this.f67460i.b(R.id.tv_short_tips);
        Observable<Void> a11 = dw.a.a(this.f75001m);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        a11.throttleFirst(1, timeUnit).subscribe(new i(this));
        dw.a.a(this.f75005q).throttleFirst(1, timeUnit).subscribe(new f(this));
    }

    public final void Mh() {
        this.f75000l = (TextView) this.f67460i.b(R.id.tv_symbol);
        this.f75010v.setCancelable(false);
        dw.a.a(this.f67460i.b(R.id.ll_symbols)).throttleFirst(1, TimeUnit.SECONDS).subscribe(new g(this));
    }

    public final void Rh() {
        this.f75001m.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_order_tutorial_orientation));
        this.f75003o.setImageResource(R.drawable.order_tutorial_long_gray);
        this.f75002n.setTextColor(getResources().getColor(R.color.baseColorThreeLevelText));
        this.f75004p.setTextColor(getResources().getColor(R.color.baseColorSecondaryText));
        this.f75005q.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_order_tutorial_orientation));
        this.f75007s.setImageResource(R.drawable.order_tutorial_short_gray);
        this.f75006r.setTextColor(getResources().getColor(R.color.baseColorThreeLevelText));
        this.f75008t.setTextColor(getResources().getColor(R.color.baseColorSecondaryText));
    }

    public void Sh() {
        Rh();
        this.f75009u.setEnabled(false);
    }

    public final void Th() {
        Rh();
        if (w.l()) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(getResources().getColor(R.color.red_002));
            gradientDrawable.setCornerRadius((float) PixelUtils.a(4.0f));
            this.f75001m.setBackgroundDrawable(gradientDrawable);
            this.f75003o.setImageResource(R.drawable.order_tutorial_long_red);
            this.f75002n.setTextColor(getResources().getColor(R.color.base_down_color));
            this.f75004p.setTextColor(getResources().getColor(R.color.base_down_color));
            return;
        }
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(getResources().getColor(R.color.green_002));
        gradientDrawable2.setCornerRadius((float) PixelUtils.a(4.0f));
        this.f75001m.setBackgroundDrawable(gradientDrawable2);
        this.f75003o.setImageResource(R.drawable.order_tutorial_long_green);
        this.f75002n.setTextColor(getResources().getColor(R.color.base_up_color));
        this.f75004p.setTextColor(getResources().getColor(R.color.base_up_color));
    }

    public final void Uh() {
        Rh();
        if (w.l()) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(getResources().getColor(R.color.green_002));
            gradientDrawable.setCornerRadius((float) PixelUtils.a(4.0f));
            this.f75005q.setBackgroundDrawable(gradientDrawable);
            this.f75007s.setImageResource(R.drawable.order_tutorial_short_green);
            this.f75006r.setTextColor(getResources().getColor(R.color.base_up_color));
            this.f75008t.setTextColor(getResources().getColor(R.color.base_up_color));
            return;
        }
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(getResources().getColor(R.color.red_002));
        gradientDrawable2.setCornerRadius((float) PixelUtils.a(4.0f));
        this.f75005q.setBackgroundDrawable(gradientDrawable2);
        this.f75007s.setImageResource(R.drawable.order_tutorial_short_red);
        this.f75006r.setTextColor(getResources().getColor(R.color.base_down_color));
        this.f75008t.setTextColor(getResources().getColor(R.color.base_down_color));
    }

    public void afterInit() {
        super.afterInit();
        Kh().f(FutureContractInfoController.n().o("ETH-USDT"));
        OrderTutorialTradeDialogFragment orderTutorialTradeDialogFragment = this.f75010v;
        if (orderTutorialTradeDialogFragment != null) {
            orderTutorialTradeDialogFragment.xi(NightHelper.e().g());
        }
    }

    public void initViews() {
        super.initViews();
        Mh();
        Lh();
        View b11 = this.f67460i.b(R.id.tv_next);
        this.f75009u = b11;
        dw.a.a(b11).throttleFirst(1, TimeUnit.SECONDS).subscribe(new h(this));
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_order_tutorial_step1, viewGroup, false);
    }
}
