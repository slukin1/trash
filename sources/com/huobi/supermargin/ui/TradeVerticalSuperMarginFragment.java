package com.huobi.supermargin.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.widgets.adapter.ViewHandlerFactory;
import com.huobi.coupon.bean.CouponReturn;
import com.huobi.login.bean.JumpTarget;
import com.huobi.main.helper.MarginUtil;
import com.huobi.main.ui.HuobiMainActivity;
import com.huobi.margin.entity.MarginBalanceQueryData;
import com.huobi.margin.ui.TradeMarginRiskRateViewNew;
import com.huobi.supermargin.bean.MarginOverview;
import com.huobi.supermargin.presenter.TradeVerticalSuperMarginPresenter;
import com.huobi.swap.ui.SuperMarginBalanceDialog;
import com.huobi.trade.handler.TradeOrderOutstandingHandler;
import com.huobi.trade.ui.TradeFragment;
import com.huobi.trade.ui.TradeVerticalBaseFragment;
import com.huobi.trade.ui.coupon.CouponLayout;
import com.huobi.trade.utils.TradeTimeMonitorUtils;
import com.huobi.utils.k0;
import com.huobi.view.TradeAmountEditext;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import dt.i2;
import i6.i;
import ij.j;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import ks.g;
import ms.m;
import ms.n;
import ms.o;
import ms.p;
import ms.q;
import ms.r;
import ms.s;
import ms.t;
import ms.u;
import ms.v;
import ms.w;
import ms.x;
import ms.y;
import pro.huobi.R;
import rn.c;

public class TradeVerticalSuperMarginFragment extends TradeVerticalBaseFragment<TradeVerticalSuperMarginPresenter, y> implements y {

    /* renamed from: o2  reason: collision with root package name */
    public SuperMarginBalanceDialog f81478o2;

    /* renamed from: p2  reason: collision with root package name */
    public CouponLayout f81479p2;

    /* renamed from: q2  reason: collision with root package name */
    public String f81480q2 = "";

    /* renamed from: r2  reason: collision with root package name */
    public TradeOrderOutstandingHandler f81481r2;

    public class a implements View.OnClickListener {
        public a() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            TradeVerticalSuperMarginFragment.this.wm();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b implements TradeMarginRiskRateViewNew.a {
        public b() {
        }

        public TradeType D0() {
            return ((TradeVerticalSuperMarginPresenter) TradeVerticalSuperMarginFragment.this.yh()).V0();
        }

        public void a() {
            if (!TradeVerticalSuperMarginFragment.this.f82325p.M()) {
                TradeVerticalSuperMarginFragment.this.tj();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Nl(Object obj) {
        this.f81479p2.g();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$4(View view) {
        wm();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$5(View view) {
        if (((TradeVerticalSuperMarginPresenter) yh()).W0() == 1) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        is.a.j("5974", (Map<String, Object>) null, "1000100");
        ((TradeVerticalSuperMarginPresenter) yh()).v3();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void pm(boolean z11) {
        if (zh().isCanBeSeen() && !z11) {
            ym();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void qm(List list, int i11) {
        if (list == null || list.isEmpty() || ((TradeVerticalSuperMarginPresenter) yh()).W0() == 3) {
            Yd(8, "", 0);
            return;
        }
        String string = getContext().getString(R.string.n_exchange_coupon_available_number);
        Yd(0, String.format(string, new Object[]{i11 + ""}), getResources().getColor(R.color.baseColorPrimaryText));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void rm(CouponReturn couponReturn) {
        ((TradeVerticalSuperMarginPresenter) yh()).y2(couponReturn);
        if (((TradeVerticalSuperMarginPresenter) yh()).a1()) {
            ((TradeVerticalSuperMarginPresenter) yh()).E2(((TradeVerticalSuperMarginPresenter) yh()).G0());
        } else {
            ((TradeVerticalSuperMarginPresenter) yh()).E2(((TradeVerticalSuperMarginPresenter) yh()).P0());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ CouponReturn sm() {
        return ((TradeVerticalSuperMarginPresenter) yh()).s2();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void tm(View view) {
        this.B1.b(true, false);
        this.D1.setVisibility(0);
        i.b().f(new n(this));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void um(View view) {
        this.B1.b(false, false);
        this.D1.setVisibility(8);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void vm(View view) {
        zm();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void Ac(MarginOverview marginOverview) {
        this.f82526u1.m(marginOverview);
    }

    public void Ah() {
        super.Ah();
        if (getParentFragment() instanceof TradeFragment) {
            ((TradeFragment) getParentFragment()).Rh(TradeType.SUPERMARGIN, new p(this));
        }
        this.f82526u1.setFlPriceOnClickListener(new a());
        if (this.f81481r2 == null) {
            this.f81481r2 = (TradeOrderOutstandingHandler) ViewHandlerFactory.a(TradeOrderOutstandingHandler.class.getName());
        }
        this.f82526u1.setCallback(new b());
        this.F1.setOnClickListener(new r(this));
    }

    public void Aj(String str) {
        super.Aj(str);
        this.f82526u1.setMarginName(g.e(getContext().getString(R.string.n_contract_super_margin), this.f82323n0));
    }

    public final void Am() {
        g.v(this.A1, getString(R.string.n_trade_automatic_repay_hint_new), String.format(Locale.US, getString(R.string.n_trade_auto_loan_tip_skip), new Object[]{"2/3"}), false, new m(this));
    }

    public void L0() {
        SuperMarginBalanceDialog superMarginBalanceDialog = this.f81478o2;
        if (superMarginBalanceDialog != null) {
            superMarginBalanceDialog.dismiss();
        }
    }

    public void M0(boolean z11) {
        this.f82526u1.l(z11);
    }

    public void U1(int i11, boolean z11) {
        super.U1(i11, z11);
        if (i11 == 1) {
            if (!g.i()) {
                i.b().g(new o(this, z11), 100);
            }
            if (((TradeVerticalSuperMarginPresenter) yh()).a1()) {
                if (this.f82320m == 1) {
                    if (this.B1.isChecked()) {
                        this.B1.b(false, false);
                        Sl(true);
                    }
                } else if (!this.B1.isChecked()) {
                    this.B1.b(true, false);
                    Sl(true);
                }
            } else if (this.f82322n == 1) {
                if (this.B1.isChecked()) {
                    this.B1.b(false, false);
                    Sl(false);
                }
            } else if (!this.B1.isChecked()) {
                this.B1.b(true, false);
                Sl(false);
            }
        }
        Jk(((TradeVerticalSuperMarginPresenter) yh()).o0(), ((TradeVerticalSuperMarginPresenter) yh()).a1());
        ((TradeVerticalSuperMarginPresenter) yh()).V1();
        ((TradeVerticalSuperMarginPresenter) yh()).U1();
        ((TradeVerticalSuperMarginPresenter) yh()).A3();
    }

    public void Yd(int i11, String str, int i12) {
        CouponLayout couponLayout = this.f81479p2;
        if (couponLayout != null) {
            couponLayout.i(i11, str, i12);
        }
    }

    public void h1(String str) {
        if (str.contains("--") || ((TradeVerticalSuperMarginPresenter) yh()).W0() == 1) {
            TextView textView = this.F1;
            textView.setPaintFlags(textView.getPaintFlags() & -9);
        } else {
            TextView textView2 = this.F1;
            textView2.setPaintFlags(textView2.getPaintFlags() | 8);
        }
        TextView textView3 = this.F1;
        textView3.setText(str + Wk());
    }

    public void i1() {
        j.g().e(new x(this));
    }

    public void i2(String str, String str2, boolean z11) {
        this.C0.setText(str);
        this.E0.setText(str2);
    }

    public void initViews() {
        super.initViews();
        TradeAmountEditext tradeAmountEditext = this.M0;
        TradeType tradeType = TradeType.SUPERMARGIN;
        tradeAmountEditext.setTradeType(tradeType);
        this.N0.setTradeType(tradeType);
        this.K0.setTradeType(tradeType);
        this.f82526u1.setMarginName((int) R.string.n_contract_super_margin);
        this.P1.setSelected(false);
        this.Q1.setSelected(true);
        CouponLayout couponLayout = (CouponLayout) this.f67460i.b(R.id.coupon_layout);
        this.f81479p2 = couponLayout;
        couponLayout.h(FutureContractInfo.MARGIN_CROSS, "vertical");
        this.f81479p2.setCallback(new u(this));
        this.f81479p2.setSelectedCouponCallback(new v(this));
        we.b.l("tradeCouponPoint", Object.class).observe(this, new t(this));
    }

    public void k(int i11, String str) {
        if (i11 == 0) {
            this.f82522q1.setTag(R.id.item_data1, MarginBalanceQueryData.STATE_FL_SYS);
        } else {
            this.f82522q1.setTag(R.id.item_data1, "");
        }
        this.f82522q1.setVisibility(i11);
        if (i11 != 0) {
            t(a1.v().J(str, ((TradeVerticalSuperMarginPresenter) yh()).V0()));
            return;
        }
        this.f82523r1.setImageResource(R.drawable.trade_liquidating);
        this.f82524s1.setText(R.string.margin_liquidating);
        this.f82525t1.setText(R.string.super_margin_liquidating_instruction);
        this.f82525t1.setVisibility(0);
    }

    /* renamed from: mm */
    public TradeVerticalSuperMarginPresenter xh() {
        return new TradeVerticalSuperMarginPresenter();
    }

    public final int nm() {
        return 3;
    }

    /* renamed from: om */
    public y zh() {
        return this;
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        TradeTimeMonitorUtils.f();
        this.f82320m = ks.a.a().b();
        this.f82322n = ks.a.a().b();
        return layoutInflater.inflate(R.layout.fragment_vertical_trade_super_margin, viewGroup, false);
    }

    public int qi() {
        return i2.a().b(ri(), nm());
    }

    public TradeType ri() {
        return TradeType.SUPERMARGIN;
    }

    public void t4() {
        CouponLayout couponLayout = this.f81479p2;
        if (couponLayout != null) {
            couponLayout.c();
        }
    }

    public void uh(boolean z11) {
        CouponLayout couponLayout = this.f81479p2;
        if (couponLayout != null && couponLayout.getVisibility() == 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("trade_mode", FutureContractInfo.MARGIN_CROSS);
            hashMap.put("version_type", "vertical");
            gs.g.i("app_trade_coupon_view", hashMap);
        }
        super.uh(z11);
        if (z11) {
            rj(1);
            if (this.f81481r2 == null) {
                this.f81481r2 = (TradeOrderOutstandingHandler) ViewHandlerFactory.a(TradeOrderOutstandingHandler.class.getName());
            }
            this.f81481r2.e(1);
            this.f81481r2.f(w.f58274a);
        }
    }

    public final void wm() {
        xm();
    }

    public final void xm() {
        if (tg.r.x().F0()) {
            MarginUtil.a(a1.v().J(((TradeVerticalSuperMarginPresenter) yh()).o0(), ((TradeVerticalSuperMarginPresenter) yh()).V0()).getBaseCurrency());
            is.a.j("5977", (Map<String, Object>) null, "1000100");
            return;
        }
        FragmentActivity activity = getActivity();
        boolean z11 = false;
        if (activity != null && (activity instanceof HuobiMainActivity)) {
            z11 = true;
        }
        c.i().d(getActivity(), new JumpTarget(k0.u(getActivity(), z11), k0.u(getActivity(), z11)));
    }

    public void yi() {
        this.Z.add(getString(R.string.n_tab_channel_balances));
        this.f82307a0.put(0, 3);
        this.Z.add(getString(R.string.n_trade_outstanding));
        this.f82307a0.put(1, 4);
        this.Z.add(getString(R.string.n_trade_open_order));
        this.f82307a0.put(2, 1);
    }

    public final void ym() {
        g.v(this.A1, getString(R.string.n_trade_automatic_loan_hint_new), String.format(Locale.US, getString(R.string.n_trade_auto_loan_tip_skip), new Object[]{"1/3"}), false, new s(this));
    }

    public void z7(MarginOverview marginOverview) {
        SuperMarginBalanceDialog superMarginBalanceDialog = this.f81478o2;
        if (superMarginBalanceDialog != null && superMarginBalanceDialog.isVisible()) {
            this.f81478o2.Eh(marginOverview);
            this.f81478o2.Fh(((TradeVerticalSuperMarginPresenter) yh()).o3());
            this.f81478o2.Gh(((TradeVerticalSuperMarginPresenter) yh()).n3());
            this.f81478o2.Kh();
        }
    }

    public final void zm() {
        g.v(this.f82339y.getTradeRightPopIv(), getString(R.string.n_trade_menu_hint), "3/3", true, new q(this));
    }
}
