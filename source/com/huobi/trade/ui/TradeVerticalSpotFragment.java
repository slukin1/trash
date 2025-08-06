package com.huobi.trade.ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import com.alibaba.fastjson.JSONObject;
import com.google.android.material.appbar.AppBarLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.ability.CurrencyNoticeAbility;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.common.utils.crypt.MD5Utils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.PrimeInfo;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.PrimeKycLimit;
import com.hbg.lib.network.hbg.grid.bean.GridSymbolsConfig;
import com.hbg.lib.network.newkyc.bean.UserKycInfoNew;
import com.hbg.lib.network.otc.core.bean.UserVO;
import com.hbg.lib.network.pro.core.bean.CallAuction;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.kyc.ui.KycProBaseInformationActivity;
import com.huobi.kyc.util.KycProxy;
import com.huobi.login.bean.JumpTarget;
import com.huobi.main.ui.HuobiMainActivity;
import com.huobi.otc.ui.OtcAliCertificateActivity;
import com.huobi.trade.bean.MarketCurrentPriceItem;
import com.huobi.trade.helper.f0;
import com.huobi.trade.presenter.TradeVerticalSpotPresenter;
import com.huobi.trade.prime.bean.PrimeAveragePosition;
import com.huobi.trade.prime.ui.PrimeTradeTopLayout;
import com.huobi.trade.utils.TradeTimeMonitorUtils;
import com.huobi.utils.ReviewManger;
import com.huobi.utils.SymbolUtil;
import com.huobi.utils.UserInfoUtil;
import com.huobi.utils.k0;
import com.huobi.view.TradeAmountEditext;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import d7.y;
import dt.i2;
import gs.g;
import ht.o;
import i6.d;
import i6.m;
import it.k;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.TimeUnit;
import jp.l;
import nb.c;
import pro.huobi.R;
import tg.r;

public class TradeVerticalSpotFragment extends TradeVerticalBaseFragment<TradeVerticalSpotPresenter, z4> implements z4, k {

    /* renamed from: o2  reason: collision with root package name */
    public k f82557o2;

    /* renamed from: p2  reason: collision with root package name */
    public PrimeTradeTopLayout f82558p2;

    /* renamed from: q2  reason: collision with root package name */
    public TradeCallAuctionLayout f82559q2;

    /* renamed from: r2  reason: collision with root package name */
    public FrameLayout f82560r2;

    /* renamed from: s2  reason: collision with root package name */
    public rj.b f82561s2;

    /* renamed from: t2  reason: collision with root package name */
    public View f82562t2;

    /* renamed from: u2  reason: collision with root package name */
    public String f82563u2 = "";

    /* renamed from: v2  reason: collision with root package name */
    public it.a f82564v2 = new a();

    public class a implements it.a {
        public a() {
        }

        public void b(int i11, long j11, long[] jArr) {
        }

        public void c(int i11) {
            TradeVerticalSpotFragment.this.Bb(o.B().F(), o.B().F() != null ? o.B().F().getStatus() : 3, false);
            TradeVerticalSpotFragment.this.f82558p2.d(o.B().F(), ((TradeVerticalSpotPresenter) TradeVerticalSpotFragment.this.yh()).o0());
            TradeVerticalSpotFragment.this.W8();
        }
    }

    public class b implements it.a {
        public b() {
        }

        public void b(int i11, long j11, long[] jArr) {
        }

        public void c(int i11) {
            if (i11 == 1) {
                if (a1.v().o0(((TradeVerticalSpotPresenter) TradeVerticalSpotFragment.this.yh()).o0(), ((TradeVerticalSpotPresenter) TradeVerticalSpotFragment.this.yh()).V0())) {
                    ((TradeVerticalSpotPresenter) TradeVerticalSpotFragment.this.yh()).t3();
                    ((TradeVerticalSpotPresenter) TradeVerticalSpotFragment.this.yh()).o3();
                }
            } else if (i11 == 2) {
                ((TradeVerticalSpotPresenter) TradeVerticalSpotFragment.this.yh()).v3();
            }
            d.b("CallAuction onCountDownFinish======:" + i11);
            TradeVerticalSpotFragment.this.f82559q2.j();
            ((TradeVerticalSpotPresenter) TradeVerticalSpotFragment.this.yh()).u1();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Am(HBDialogFragment hBDialogFragment) {
        OtcAliCertificateActivity.gg(getActivity(), false, false);
        hBDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Bm(HBDialogFragment hBDialogFragment) {
        c.h(getActivity(), l.M(), false);
        hBDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Cm(PrimeKycLimit primeKycLimit, String str, Boolean bool, List list, Integer num) {
        if (primeKycLimit.getKyc() == 1) {
            if (KycProxy.l().p() != 2) {
                nm(new r4(this));
            }
        } else if (primeKycLimit.getKyc() == 2) {
            int p11 = KycProxy.l().p();
            UserVO r11 = l.r();
            UserKycInfoNew o11 = KycProxy.l().o();
            if (p11 != 2 && (o11 == null || o11.getAuth_info() == null || o11.getAuth_info().getPro_auth_type() != 10)) {
                qm(new s4(this));
            } else if (r11 != null && r11.getRealBind() == 2) {
            } else {
                if (r.x().U()) {
                    qm(new t4(this));
                } else {
                    om();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Em(String str, GridSymbolsConfig gridSymbolsConfig) {
        this.f82339y.setSymbol(str);
        this.f82339y.setGridEntranceVisible(y.e(str));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Fm(Object obj) {
        if (obj == null ? false : ((Boolean) obj).booleanValue()) {
            if (this.f82562t2 == null) {
                View E = this.f82561s2.E("currency_notice.xml", getActivity(), false, (JSONObject) null);
                this.f82562t2 = E;
                this.f82560r2.addView(E);
            }
            this.f82560r2.setVisibility(0);
            return;
        }
        this.f82560r2.setVisibility(8);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        o.B().r0(false);
        Bb(o.B().F(), o.B().F() != null ? o.B().F().getStatus() : 3, true);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void um(Void voidR) {
        String string = getString(R.string.n_exchange_alert_available_balance_subtitle_fir);
        String j11 = SP.j("exchange", MD5Utils.a("redeemSwitch"), "");
        if (r.x().F0() && j11.equalsIgnoreCase("1")) {
            string = getString(R.string.n_exchange_alert_balance_earn_subtitle);
        }
        new DialogUtils.b.d(getActivity()).C0(string).c1(getString(R.string.n_exchange_balance_notice_title)).P0(getString(R.string.n_known)).Q0(ad.b.f3517a).k0().show(getActivity().getSupportFragmentManager(), "");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void wm(String str, HBDialogFragment hBDialogFragment) {
        ((ClipboardManager) getActivity().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(str, str));
        HuobiToastUtil.t(getActivity(), R.string.currency_deposit_copied);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void zm(HBDialogFragment hBDialogFragment) {
        rn.c.i().d(getActivity(), new JumpTarget(new Intent(getActivity(), KycProBaseInformationActivity.class), k0.h(getActivity())));
        hBDialogFragment.dismiss();
    }

    public void Ah() {
        super.Ah();
        this.f82558p2.setOnClickListener(new m4(this));
        this.f82558p2.setCountDownCallback(this.f82564v2);
        this.f82559q2.setCountDownCallback(new b());
        dw.a.a(this.T0).throttleFirst(300, TimeUnit.MILLISECONDS).subscribe(new n4(this));
    }

    public void Bb(PrimeInfo primeInfo, int i11, boolean z11) {
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f67460i.b(R.id.trade_spot_content_parent);
        CoordinatorLayout.LayoutParams layoutParams = new CoordinatorLayout.LayoutParams(-1, -1);
        layoutParams.o(new AppBarLayout.ScrollingViewBehavior());
        if (i11 == 1) {
            if (o.B().O()) {
                w1();
            } else {
                super.uj(coordinatorLayout, layoutParams, primeInfo);
            }
        } else if (i11 == 2) {
            if (o.B().O()) {
                w1();
            } else if (z11) {
                super.uj(coordinatorLayout, layoutParams, primeInfo);
            } else {
                w1();
            }
        } else if (i11 == 3) {
            super.uj(coordinatorLayout, layoutParams, primeInfo);
        }
    }

    public void E(int i11, long j11) {
        this.f82559q2.o(i11, j11);
    }

    public void E8(String str, PrimeAveragePosition primeAveragePosition) {
        super.E8(str, primeAveragePosition);
    }

    public void Gm(String str) {
        int a11 = PrecisionUtil.a(((TradeVerticalSpotPresenter) yh()).V0(), a1.v().E(str, ((TradeVerticalSpotPresenter) yh()).V0()));
        String E = ((TradeVerticalSpotPresenter) yh()).T0().E(((TradeVerticalSpotPresenter) yh()).V0(), str, true);
        if (!((TradeVerticalSpotPresenter) yh()).d1()) {
            this.f82497c2 = m.m(E, a11);
        } else if (this.f82317k0 != null) {
            BigDecimal a12 = m.a(E);
            String B0 = ((TradeVerticalSpotPresenter) yh()).B0(this.f82317k0.getCurrency(), this.f82317k0.getRemainingAmount(), ((TradeVerticalSpotPresenter) yh()).N0());
            if (a12.compareTo(m.a(B0)) == 1) {
                E = B0;
            }
            this.f82497c2 = m.m(E, a11);
        } else {
            this.f82497c2 = "--";
        }
        String m11 = m.m(((TradeVerticalSpotPresenter) yh()).T0().E(((TradeVerticalSpotPresenter) yh()).V0(), str, false), PrecisionUtil.a(((TradeVerticalSpotPresenter) yh()).V0(), a1.v().o(str, ((TradeVerticalSpotPresenter) yh()).V0())));
        this.f82499d2 = m11;
        Hk(this.f82497c2, m11);
    }

    public void H0(MarketCurrentPriceItem marketCurrentPriceItem) {
        super.H0(marketCurrentPriceItem);
    }

    public void J(String str) {
        super.J(str);
        o.B().u0(getActivity(), str);
    }

    public void O1(String str, TradeType tradeType) {
        super.O1(str, tradeType);
        if (((TradeVerticalSpotPresenter) yh()).d1() && ((TradeVerticalSpotPresenter) yh()).a1()) {
            this.T0.setText(getResources().getString(R.string.n_trade_observation_available_limit));
        } else if (!a1.v().S(((TradeVerticalSpotPresenter) yh()).o0()) || !((TradeVerticalSpotPresenter) yh()).a1()) {
            this.T0.setText(getString(R.string.trade_asset_available));
        } else {
            this.T0.setText(getString(R.string.trade_prime_asset_available));
        }
        y.h(true).compose(RxJavaHelper.t(zh())).subscribe(EasySubscriber.create(new o4(this, str)));
        this.T0.setClickable(true);
    }

    public void R2(String str, String str2) {
        String str3;
        String str4;
        if (((TradeVerticalSpotPresenter) yh()).a1()) {
            str3 = a1.v().E(str, ((TradeVerticalSpotPresenter) yh()).V0());
        } else {
            str3 = a1.v().o(str, ((TradeVerticalSpotPresenter) yh()).V0());
        }
        int a11 = PrecisionUtil.a(((TradeVerticalSpotPresenter) yh()).V0(), str3);
        if (!((TradeVerticalSpotPresenter) yh()).d1() || !((TradeVerticalSpotPresenter) yh()).a1()) {
            if (!a1.v().S(((TradeVerticalSpotPresenter) yh()).o0()) || !((TradeVerticalSpotPresenter) yh()).a1()) {
                this.T0.setText(getString(R.string.trade_asset_available));
            } else {
                this.T0.setText(getString(R.string.trade_prime_asset_available));
            }
            str4 = m.m(str2, a11);
        } else {
            this.T0.setText(getResources().getString(R.string.n_trade_observation_available_limit));
            if (this.f82317k0 != null) {
                BigDecimal a12 = m.a(str2);
                String B0 = ((TradeVerticalSpotPresenter) yh()).B0(this.f82317k0.getCurrency(), this.f82317k0.getRemainingAmount(), ((TradeVerticalSpotPresenter) yh()).N0());
                if (a12.compareTo(m.a(B0)) == 1) {
                    str2 = B0;
                }
                str4 = m.m(str2, a11);
            } else {
                str4 = "--";
            }
        }
        this.C0.setText(str4);
        this.B0.setText(SymbolUtil.c(str, !((TradeVerticalSpotPresenter) yh()).a1()));
        Gm(str);
    }

    public void S7(PrimeInfo primeInfo) {
        this.f82558p2.d(primeInfo, ((TradeVerticalSpotPresenter) yh()).o0());
        this.f82558p2.setVisibility(0);
    }

    public void Sk(boolean z11, int i11, String str) {
        if (getActivity() != null) {
            super.Sk(z11, i11, str);
        }
    }

    public void W8() {
        if (o.B().F() != null) {
            if (((TradeVerticalSpotPresenter) yh()).a1()) {
                ViewUtil.m(this.N0, false);
            }
            PrimeInfo F = o.B().F();
            if (o.B().P()) {
                if (((TradeVerticalSpotPresenter) yh()).W0() != 0) {
                    ((TradeVerticalSpotPresenter) yh()).x0(0, false);
                }
                this.K0.setViewVisibilityAndEnable(8, false);
                this.K0.setBackgroundResource(R.drawable.custom_edittext_unenable_bg);
                ((TradeVerticalSpotPresenter) yh()).z1(true);
                if (((TradeVerticalSpotPresenter) yh()).a1()) {
                    this.F0.setText(m.m(F.getCurrentPrice(), PrecisionUtil.e(((TradeVerticalSpotPresenter) yh()).o0())));
                } else if (!TextUtils.isEmpty(F.getRoundLimitOrderPrice())) {
                    this.F0.setText(m.m(F.getRoundLimitOrderPrice(), PrecisionUtil.e(((TradeVerticalSpotPresenter) yh()).o0())));
                } else {
                    this.F0.setText("");
                }
                D1(8);
                W1(8);
            } else if (o.B().X() && ((TradeVerticalSpotPresenter) yh()).W0() != 1) {
                ((TradeVerticalSpotPresenter) yh()).x0(1, false);
            }
        }
        E3(a1.v().S(((TradeVerticalSpotPresenter) yh()).o0()));
    }

    public void Wb(String str) {
        ((TradeVerticalSpotPresenter) yh()).C3(str);
    }

    public void X8() {
        ((TradeVerticalSpotPresenter) yh()).q1();
    }

    public void d(boolean z11) {
        super.d(z11);
        if (!z11) {
            this.C0.setText("--");
        }
    }

    public void ff(String str) {
        ((TradeVerticalSpotPresenter) yh()).C0(str);
    }

    public void initViews() {
        super.initViews();
        this.f82518n1.setVisibility(0);
        this.Y1.setVisibility(8);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.R0.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        layoutParams.leftMargin = 0;
        this.R0.setLayoutParams(layoutParams);
        TradeAmountEditext tradeAmountEditext = this.M0;
        TradeType tradeType = TradeType.PRO;
        tradeAmountEditext.setTradeType(tradeType);
        this.N0.setTradeType(tradeType);
        this.K0.setTradeType(tradeType);
        tm();
        this.f82557o2 = this;
        this.f82558p2 = (PrimeTradeTopLayout) this.f67460i.b(R.id.prime_trade_top_view);
        this.P1.setSelected(true);
        this.Q1.setSelected(false);
        this.f82559q2 = (TradeCallAuctionLayout) this.f67460i.b(R.id.call_auction_view);
        this.f82560r2 = (FrameLayout) this.f67460i.b(R.id.currency_notice_container);
    }

    public final void nm(DialogUtils.b.f fVar) {
        if (isCanBeSeen()) {
            new DialogUtils.b.d(getActivity()).c1(getString(R.string.n_kyc_requirements)).C0(getString(R.string.n_kyc_requirements_hint)).P0(getString(R.string.n_kyc_confirm)).s0(getString(R.string.n_cancel)).Q0(fVar).N0(y4.f82748a).k0().show(getActivity().getSupportFragmentManager(), "");
        }
    }

    public void o(boolean z11) {
        if (z11) {
            if (this.R0.isEnabled()) {
                this.R0.setEnabled(false);
                this.N1.setBackgroundResource(R.drawable.call_auction_entrust_unenable_bg);
            }
        } else if (!this.R0.isEnabled()) {
            this.R0.setEnabled(true);
            this.N1.setBackgroundResource(R.drawable.custom_edittext_normal_bg);
        }
    }

    public void o1() {
        this.f82558p2.setVisibility(8);
    }

    public final void om() {
        String e11 = com.hbg.lib.core.util.o.e();
        new DialogUtils.b.d(getActivity()).c1(getResources().getString(R.string.advance_identification_to_pc)).C0(e11).D0(Integer.valueOf(ContextCompat.getColor(getActivity(), R.color.global_jump_btn_color))).i1(1).M0(Integer.valueOf(R.drawable.otc_tips_toweb)).P0(getResources().getString(R.string.advance_identification_to_pc_url_copy)).Q0(new u4(this, e11)).N0(v4.f82728a).j0().show(getActivity().getSupportFragmentManager(), "");
    }

    public void onDestroy() {
        super.onDestroy();
        rj.b bVar = this.f82561s2;
        if (bVar != null) {
            bVar.B();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        PrimeTradeTopLayout primeTradeTopLayout = this.f82558p2;
        if (primeTradeTopLayout != null) {
            primeTradeTopLayout.setCountDownCallback((it.a) null);
        }
    }

    public void p1(PrimeKycLimit primeKycLimit) {
        UserInfoUtil.h(zh(), new q4(this, primeKycLimit));
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        TradeTimeMonitorUtils.e();
        return layoutInflater.inflate(R.layout.fragment_vertical_trade_spot, viewGroup, false);
    }

    /* renamed from: pm */
    public TradeVerticalSpotPresenter xh() {
        return new TradeVerticalSpotPresenter();
    }

    public void q3(boolean z11) {
    }

    public int qi() {
        return i2.a().b(ri(), rm());
    }

    public final void qm(DialogUtils.b.f fVar) {
        if (isCanBeSeen()) {
            new DialogUtils.b.d(getActivity()).c1(getString(R.string.n_kyc_requirements)).C0(getString(R.string.n_senior_kyc_requirements_hint)).P0(getString(R.string.n_senior_kyc_confirm)).s0(getString(R.string.n_cancel)).Q0(fVar).N0(x4.f82743a).k0().show(getActivity().getSupportFragmentManager(), "");
        }
    }

    public void r(CallAuction callAuction, String str) {
        this.f82559q2.p(callAuction, str);
    }

    public k r1() {
        return this.f82557o2;
    }

    public TradeType ri() {
        return TradeType.PRO;
    }

    public final int rm() {
        return 0;
    }

    /* renamed from: sm */
    public z4 zh() {
        return this;
    }

    public void t(SymbolBean symbolBean) {
        super.t(symbolBean);
        if (!ReviewManger.a()) {
            if (this.f82561s2 == null) {
                rj.b bVar = new rj.b(getContext(), FirebaseAnalytics.Param.CURRENCY);
                this.f82561s2 = bVar;
                bVar.t("openNoticeUrl", CurrencyNoticeAbility.class);
                this.f82561s2.H();
                this.f82561s2.v("visibility", new p4(this));
                if (!NightHelper.e().g()) {
                    this.f82561s2.I("setDarkMode(0)");
                } else {
                    this.f82561s2.I("setDarkMode(1)");
                }
            }
            this.f82561s2.I("currencyNoticeMessage('" + ((TradeVerticalSpotPresenter) yh()).E0() + "','0')");
        }
    }

    public final void tm() {
        this.f82522q1 = (LinearLayout) this.f67460i.b(R.id.stop_trade_ll);
        this.f82523r1 = (ImageView) this.f67460i.b(R.id.trade_mask_iv);
        this.f82524s1 = (TextView) this.f67460i.b(R.id.trade_mask_title_tv);
        this.f82525t1 = (TextView) this.f67460i.b(R.id.trade_suspend_instruction_tv);
    }

    public void u1() {
        if (isCanBeSeen()) {
            new DialogUtils.b.d(getActivity()).c1(getString(R.string.n_option_delivery_tip)).C0(getString(R.string.n_not_support_activity_hint)).P0(getString(R.string.n_confirm)).q0(false).Q0(w4.f82735a).k0().show(getActivity().getSupportFragmentManager(), "");
        }
    }

    public void uh(boolean z11) {
        if (getActivity() != null) {
            super.uh(z11);
            if (z11 && !r.x().X() && (getActivity() instanceof HuobiMainActivity)) {
                ((HuobiMainActivity) getActivity()).ni();
            }
            if (z11) {
                try {
                    g.b(((TradeVerticalSpotPresenter) yh()).o0(), "Vertical");
                } catch (Exception e11) {
                    i6.k.j("SensorsData", e11);
                }
            } else {
                f0.c(getActivity());
            }
        }
    }

    public void w1() {
        super.w1();
    }

    public void x3(String str) {
        super.x3(str);
    }

    public void yi() {
        this.Z.add(getString(R.string.n_trade_tab_assets));
        this.f82307a0.put(0, 0);
        this.Z.add(getString(R.string.n_trade_open_order));
        this.f82307a0.put(1, 1);
        this.Z.add(getString(R.string.n_exchange_order_history_deals));
        this.f82307a0.put(2, 2);
    }

    public void z1() {
        this.f82559q2.q(((TradeVerticalSpotPresenter) yh()).o0());
    }
}
