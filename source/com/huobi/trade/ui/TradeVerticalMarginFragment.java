package com.huobi.trade.ui;

import android.content.Intent;
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
import com.huobi.finance.ui.UnifyTransferActivity;
import com.huobi.login.bean.JumpTarget;
import com.huobi.main.helper.MarginUtil;
import com.huobi.main.ui.HuobiMainActivity;
import com.huobi.margin.entity.MarginBalanceQueryData;
import com.huobi.margin.ui.TradeMarginBalanceDialog;
import com.huobi.margin.ui.TradeMarginRiskRateViewNew;
import com.huobi.trade.handler.TradeOrderPositionsHandler;
import com.huobi.trade.presenter.TradeVerticalMarginPresenter;
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
import pro.huobi.R;
import rn.c;
import tg.r;

public class TradeVerticalMarginFragment extends TradeVerticalBaseFragment<TradeVerticalMarginPresenter, l4> implements l4 {

    /* renamed from: o2  reason: collision with root package name */
    public TradeMarginBalanceDialog f82551o2;

    /* renamed from: p2  reason: collision with root package name */
    public CouponLayout f82552p2;

    /* renamed from: q2  reason: collision with root package name */
    public String f82553q2 = "";

    /* renamed from: r2  reason: collision with root package name */
    public TradeOrderPositionsHandler f82554r2;

    public class a implements ct.b {
        public a() {
        }

        public void a(String str) {
            String str2;
            if (TradeVerticalMarginFragment.this.getActivity() != null) {
                if (((TradeVerticalMarginPresenter) TradeVerticalMarginFragment.this.yh()).a1()) {
                    str2 = a1.v().E(str, ((TradeVerticalMarginPresenter) TradeVerticalMarginFragment.this.yh()).V0());
                } else {
                    str2 = a1.v().o(str, ((TradeVerticalMarginPresenter) TradeVerticalMarginFragment.this.yh()).V0());
                }
                UnifyTransferActivity.Uh(TradeVerticalMarginFragment.this.getActivity(), str2, "3", false, str, false);
            }
        }

        public void b(String str) {
            if (TradeVerticalMarginFragment.this.getActivity() != null) {
                MarginUtil.c(str);
            }
        }

        public void c(String str) {
            if (TradeVerticalMarginFragment.this.getActivity() != null) {
                MarginUtil.d(str);
            }
        }

        public void d(String str) {
            if (TradeVerticalMarginFragment.this.getActivity() instanceof HuobiMainActivity) {
                HuobiMainActivity huobiMainActivity = (HuobiMainActivity) TradeVerticalMarginFragment.this.getActivity();
                if (huobiMainActivity.Lh() != null) {
                    huobiMainActivity.Lh().K0(str, TradeType.MARGIN);
                }
            }
        }
    }

    public class b implements TradeMarginRiskRateViewNew.a {
        public b() {
        }

        public TradeType D0() {
            return ((TradeVerticalMarginPresenter) TradeVerticalMarginFragment.this.yh()).V0();
        }

        public void a() {
            if (!TradeVerticalMarginFragment.this.f82325p.M()) {
                TradeVerticalMarginFragment.this.tj();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Nl(Object obj) {
        this.f82552p2.g();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        um();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$4(View view) {
        um();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$5(View view) {
        if (((TradeVerticalMarginPresenter) yh()).W0() == 1) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        is.a.j("5974", (Map<String, Object>) null, "1000101");
        ((TradeVerticalMarginPresenter) yh()).a3();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void nm(boolean z11) {
        if (zh().isCanBeSeen() && !z11) {
            wm();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void om(List list, int i11) {
        if (list == null || list.isEmpty() || ((TradeVerticalMarginPresenter) yh()).W0() == 3) {
            Yd(8, "", 0);
            return;
        }
        String string = getContext().getString(R.string.n_exchange_coupon_available_number);
        Yd(0, String.format(string, new Object[]{list.size() + ""}), getResources().getColor(R.color.baseColorPrimaryText));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void pm(CouponReturn couponReturn) {
        ((TradeVerticalMarginPresenter) yh()).y2(couponReturn);
        if (((TradeVerticalMarginPresenter) yh()).a1()) {
            ((TradeVerticalMarginPresenter) yh()).E2(((TradeVerticalMarginPresenter) yh()).G0());
        } else {
            ((TradeVerticalMarginPresenter) yh()).E2(((TradeVerticalMarginPresenter) yh()).P0());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ CouponReturn qm() {
        return ((TradeVerticalMarginPresenter) yh()).s2();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void rm(View view) {
        this.B1.b(true, false);
        this.D1.setVisibility(0);
        i.b().f(new a4(this));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void sm(View view) {
        this.B1.b(false, false);
        this.D1.setVisibility(8);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void tm(View view) {
        xm();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void Ah() {
        super.Ah();
        if (getParentFragment() instanceof TradeFragment) {
            ((TradeFragment) getParentFragment()).Rh(TradeType.MARGIN, new g4(this));
        }
        this.f82526u1.setFlPriceOnClickListener(new z3(this));
        this.f82526u1.setCallback(new b());
        this.F1.setOnClickListener(new c4(this));
        if (this.f82554r2 == null) {
            this.f82554r2 = (TradeOrderPositionsHandler) ViewHandlerFactory.a(TradeOrderPositionsHandler.class.getName());
        }
    }

    public void Aj(String str) {
        super.Aj(str);
        this.f82526u1.setMarginName(g.e(getContext().getString(R.string.n_contract_trade_margin), this.f82321m0));
    }

    public void B1(MarginBalanceQueryData marginBalanceQueryData, String str) {
        this.f82526u1.n(marginBalanceQueryData, str);
    }

    public void L0() {
        TradeMarginBalanceDialog tradeMarginBalanceDialog = this.f82551o2;
        if (tradeMarginBalanceDialog != null) {
            tradeMarginBalanceDialog.dismiss();
        }
    }

    public void M0(boolean z11) {
        this.f82526u1.l(z11);
    }

    public void U1(int i11, boolean z11) {
        super.U1(i11, z11);
        if (i11 == 1) {
            if (!g.i()) {
                i.b().g(new b4(this, z11), 100);
            }
            if (((TradeVerticalMarginPresenter) yh()).a1()) {
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
        Jk(((TradeVerticalMarginPresenter) yh()).o0(), ((TradeVerticalMarginPresenter) yh()).a1());
        ((TradeVerticalMarginPresenter) yh()).V1();
        ((TradeVerticalMarginPresenter) yh()).U1();
        ((TradeVerticalMarginPresenter) yh()).e3();
    }

    public void Yd(int i11, String str, int i12) {
        CouponLayout couponLayout = this.f82552p2;
        if (couponLayout != null) {
            couponLayout.i(i11, str, i12);
        }
    }

    public void h1(String str) {
        if (str.contains("--") || ((TradeVerticalMarginPresenter) yh()).W0() == 1) {
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
        j.g().i(0, "9", new k4(this));
    }

    public void i2(String str, String str2, boolean z11) {
        this.C0.setText(str);
        this.E0.setText(str2);
    }

    public void initViews() {
        super.initViews();
        TradeAmountEditext tradeAmountEditext = this.M0;
        TradeType tradeType = TradeType.MARGIN;
        tradeAmountEditext.setTradeType(tradeType);
        this.N0.setTradeType(tradeType);
        this.K0.setTradeType(tradeType);
        this.f82551o2 = new TradeMarginBalanceDialog();
        this.f82526u1.setMarginName((int) R.string.n_contract_trade_margin);
        this.P1.setSelected(false);
        this.Q1.setSelected(true);
        CouponLayout couponLayout = (CouponLayout) this.f67460i.b(R.id.coupon_layout);
        this.f82552p2 = couponLayout;
        couponLayout.h(FutureContractInfo.MARGIN_ISOLATED, "vertical");
        this.f82552p2.setCallback(new i4(this));
        this.f82552p2.setSelectedCouponCallback(new j4(this));
        we.b.l("tradeCouponPoint", Object.class).observe(this, new h4(this));
    }

    public void k(int i11, String str) {
        if (i11 == 0) {
            this.f82522q1.setTag(R.id.item_data1, MarginBalanceQueryData.STATE_FL_SYS);
        } else {
            this.f82522q1.setTag(R.id.item_data1, "");
        }
        this.f82522q1.setVisibility(i11);
        if (i11 != 0) {
            t(a1.v().J(str, ((TradeVerticalMarginPresenter) yh()).V0()));
            return;
        }
        this.f82523r1.setImageResource(R.drawable.trade_liquidating);
        this.f82524s1.setText(R.string.margin_liquidating);
        this.f82525t1.setText(String.format(getString(R.string.margin_liquidating_instruction), new Object[]{a1.v().X(str, ((TradeVerticalMarginPresenter) yh()).V0())}));
        this.f82525t1.setVisibility(0);
    }

    /* renamed from: km */
    public TradeVerticalMarginPresenter xh() {
        return new TradeVerticalMarginPresenter();
    }

    public final int lm() {
        return 9;
    }

    /* renamed from: mm */
    public l4 zh() {
        return this;
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        TradeTimeMonitorUtils.f();
        this.f82320m = ks.a.a().b();
        this.f82322n = ks.a.a().b();
        return layoutInflater.inflate(R.layout.fragment_vertical_trade_margin, viewGroup, false);
    }

    public int qi() {
        return i2.a().b(ri(), lm());
    }

    public TradeType ri() {
        return TradeType.MARGIN;
    }

    public void t4() {
        CouponLayout couponLayout = this.f82552p2;
        if (couponLayout != null) {
            couponLayout.c();
        }
    }

    public void uh(boolean z11) {
        CouponLayout couponLayout = this.f82552p2;
        if (couponLayout != null && couponLayout.getVisibility() == 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("trade_mode", FutureContractInfo.MARGIN_ISOLATED);
            hashMap.put("version_type", "vertical");
            gs.g.i("app_trade_coupon_view", hashMap);
        }
        super.uh(z11);
        if (z11) {
            qj(1);
            if (this.f82554r2 == null) {
                this.f82554r2 = (TradeOrderPositionsHandler) ViewHandlerFactory.a(TradeOrderPositionsHandler.class.getName());
            }
            this.f82554r2.k(1);
            this.f82554r2.l(new a());
        }
    }

    public final void um() {
        vm();
    }

    public void vf() {
        super.vf();
    }

    public final void vm() {
        if (r.x().F0()) {
            MarginUtil.c(a1.v().J(((TradeVerticalMarginPresenter) yh()).o0(), ((TradeVerticalMarginPresenter) yh()).V0()).getSymbol());
            is.a.j("5977", (Map<String, Object>) null, "1000101");
            return;
        }
        FragmentActivity activity = getActivity();
        boolean z11 = false;
        if (activity != null && (activity instanceof HuobiMainActivity)) {
            z11 = true;
        }
        Intent j11 = k0.j(getActivity(), z11);
        if (!z11) {
            j11.addFlags(67108864);
        }
        c.i().d(getActivity(), new JumpTarget(j11, j11));
    }

    public final void wm() {
        g.v(this.A1, getString(R.string.n_trade_automatic_loan_hint_new), String.format(Locale.US, getString(R.string.n_trade_auto_loan_tip_skip), new Object[]{"1/3"}), false, new e4(this));
    }

    public final void xm() {
        g.v(this.f82339y.getTradeRightPopIv(), getString(R.string.n_trade_menu_hint), "3/3", true, new f4(this));
    }

    public void yi() {
        this.Z.add(getString(R.string.n_trade_hold));
        this.f82307a0.put(0, 9);
        this.Z.add(getString(R.string.n_trade_open_order));
        this.f82307a0.put(1, 1);
    }

    public final void ym() {
        g.v(this.A1, getString(R.string.n_trade_automatic_repay_hint_new), String.format(Locale.US, getString(R.string.n_trade_auto_loan_tip_skip), new Object[]{"2/3"}), false, new d4(this));
    }
}
