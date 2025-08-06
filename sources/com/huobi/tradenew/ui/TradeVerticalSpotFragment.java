package com.huobi.tradenew.ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import com.alibaba.fastjson.JSONObject;
import com.google.android.material.appbar.AppBarLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.ability.CurrencyNoticeAbility;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.util.w;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.PrimeInfo;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.AccountRiskInfo;
import com.hbg.lib.network.hbg.core.bean.CurrencyAsset;
import com.hbg.lib.network.hbg.core.bean.EtpRebalInfo;
import com.hbg.lib.network.hbg.core.bean.PrimeKycLimit;
import com.hbg.lib.network.hbg.core.bean.RankScreenBean;
import com.hbg.lib.network.hbg.grid.bean.GridSymbolsConfig;
import com.hbg.lib.network.hbg.record.BizRecordProvider;
import com.hbg.lib.network.newkyc.bean.UserKycInfoNew;
import com.hbg.lib.network.otc.core.bean.UserVO;
import com.hbg.lib.network.pro.core.bean.CallAuction;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.widgets.TopScrollData;
import com.hbg.lib.widgets.TopScrollView;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.kyc.ui.KycProBaseInformationActivity;
import com.huobi.kyc.util.KycProxy;
import com.huobi.login.bean.JumpTarget;
import com.huobi.main.ui.HuobiMainActivity;
import com.huobi.margin.entity.OrderConfirmResponse;
import com.huobi.otc.ui.OtcAliCertificateActivity;
import com.huobi.trade.bean.DepthItem;
import com.huobi.trade.bean.MarketBuySellItem;
import com.huobi.trade.bean.MarketCurrentPriceItem;
import com.huobi.trade.helper.EtpRiskHintUtil;
import com.huobi.trade.helper.f0;
import com.huobi.trade.prime.bean.PrimeAveragePosition;
import com.huobi.trade.prime.ui.PrimeTradeTopLayout;
import com.huobi.trade.ui.SpotAssetsDialogFragment;
import com.huobi.tradenew.guide.TradeVerticalSpotUserGuideDialog;
import com.huobi.tradenew.presenter.TradeBasePresenter;
import com.huobi.tradenew.presenter.TradeVerticalSpotPresenter;
import com.huobi.tradenew.prime.helper.TradeMarginHelper;
import com.huobi.utils.SymbolUtil;
import com.huobi.utils.UserInfoUtil;
import com.huobi.utils.d1;
import com.huobi.utils.k0;
import com.huobi.view.MyNestedScrollView;
import com.huobi.view.seekbar.MultiConfigBuilder;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import d7.y;
import dt.h2;
import i6.m;
import it.k;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import jp.l;
import ot.c;
import pro.huobi.R;
import rt.a0;
import rx.Observable;
import tg.r;
import ut.o;

public class TradeVerticalSpotFragment extends TradeVerticalBaseFragment<TradeVerticalSpotPresenter, a5> implements a5, a0.e, k, TradeVerticalSpotUserGuideDialog.c, c.e {
    public TextView A2;
    public FrameLayout B2;
    public rj.b C2;
    public View D2;
    public it.a E2 = new a();
    public MyNestedScrollView F2;
    public ot.a G2;
    public TradeVerticalSpotUserGuideDialog H2;

    /* renamed from: g2  reason: collision with root package name */
    public k f83313g2;

    /* renamed from: h2  reason: collision with root package name */
    public PrimeTradeTopLayout f83314h2;

    /* renamed from: i2  reason: collision with root package name */
    public TopScrollView f83315i2;

    /* renamed from: j2  reason: collision with root package name */
    public View f83316j2;

    /* renamed from: k2  reason: collision with root package name */
    public View f83317k2;

    /* renamed from: l2  reason: collision with root package name */
    public TextView f83318l2;

    /* renamed from: m2  reason: collision with root package name */
    public TextView f83319m2;

    /* renamed from: n2  reason: collision with root package name */
    public TextView f83320n2;

    /* renamed from: o2  reason: collision with root package name */
    public View f83321o2;

    /* renamed from: p2  reason: collision with root package name */
    public TextView f83322p2;

    /* renamed from: q2  reason: collision with root package name */
    public TextView f83323q2;

    /* renamed from: r2  reason: collision with root package name */
    public TextView f83324r2;

    /* renamed from: s2  reason: collision with root package name */
    public TextView f83325s2;

    /* renamed from: t2  reason: collision with root package name */
    public View f83326t2;

    /* renamed from: u2  reason: collision with root package name */
    public View f83327u2;

    /* renamed from: v2  reason: collision with root package name */
    public boolean f83328v2;

    /* renamed from: w2  reason: collision with root package name */
    public TradeCallAuctionLayout f83329w2;

    /* renamed from: x2  reason: collision with root package name */
    public int f83330x2 = 8;

    /* renamed from: y2  reason: collision with root package name */
    public String f83331y2;

    /* renamed from: z2  reason: collision with root package name */
    public View f83332z2;

    public class a implements it.a {
        public a() {
        }

        public void b(int i11, long j11, long[] jArr) {
        }

        public void c(int i11) {
            TradeVerticalSpotFragment.this.Bb(o.C().G(), o.C().G() != null ? o.C().G().getStatus() : 3, false);
            TradeVerticalSpotFragment.this.f83314h2.d(o.C().G(), ((TradeVerticalSpotPresenter) TradeVerticalSpotFragment.this.yh()).o0());
            TradeVerticalSpotFragment.this.W8();
        }
    }

    public class b implements TopScrollView.b {
        public b() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void i(HBDialogFragment hBDialogFragment) {
            HBBaseWebActivity.showWebView(TradeVerticalSpotFragment.this.getActivity(), d1.g(), "", "", false);
            if (!BizRecordProvider.e()) {
                hBDialogFragment.dismiss();
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void k(HBDialogFragment hBDialogFragment) {
            HBBaseWebActivity.showWebView(TradeVerticalSpotFragment.this.getActivity(), d1.g(), "", "", false);
            if (!BizRecordProvider.e()) {
                hBDialogFragment.dismiss();
            }
        }

        public void a(TopScrollData topScrollData) {
        }

        public void b() {
        }

        public void c(TopScrollData topScrollData) {
            EtpRebalInfo b11 = x7.d.b(a1.v().n(((TradeVerticalSpotPresenter) TradeVerticalSpotFragment.this.yh()).o0()));
            if (topScrollData.d() == 0) {
                if (b11 != null) {
                    new DialogUtils.b.d(TradeVerticalSpotFragment.this.getActivity()).c1(TradeVerticalSpotFragment.this.getActivity().getString(R.string.n_trade_etp_carousel_time_title)).C0(String.format(Locale.ENGLISH, TradeVerticalSpotFragment.this.getString(R.string.n_trade_etp_carousel_time_content), new Object[]{DateTimeUtils.A(b11.getRebalTime().longValue()), a1.v().p(((TradeVerticalSpotPresenter) TradeVerticalSpotFragment.this.yh()).o0()), EtpRiskHintUtil.c(a1.v().n(((TradeVerticalSpotPresenter) TradeVerticalSpotFragment.this.yh()).o0())), String.valueOf(b11.getLeverageRatio()), a1.v().p(((TradeVerticalSpotPresenter) TradeVerticalSpotFragment.this.yh()).o0()), EtpRiskHintUtil.c(a1.v().n(((TradeVerticalSpotPresenter) TradeVerticalSpotFragment.this.yh()).o0())), String.valueOf(b11.getLeverageRatio())})).q0(false).Y0(TradeVerticalSpotFragment.this.getString(R.string.n_trade_etp_carousel_time_link_hint)).a1(new r4(this)).P0(TradeVerticalSpotFragment.this.getActivity().getString(R.string.n_known)).Q0(v4.f83545a).k0().show(TradeVerticalSpotFragment.this.getActivity().getSupportFragmentManager(), "");
                }
            } else if (topScrollData.d() == 1) {
                if (b11 != null) {
                    Locale locale = Locale.ENGLISH;
                    String format = String.format(locale, TradeVerticalSpotFragment.this.getString(R.string.n_trade_etp_carousel_untime_hint_content), new Object[]{a1.v().p(((TradeVerticalSpotPresenter) TradeVerticalSpotFragment.this.yh()).o0()), m.m(String.valueOf(b11.getRebalNav()), PrecisionUtil.e(((TradeVerticalSpotPresenter) TradeVerticalSpotFragment.this.yh()).o0())) + " " + StringUtils.i(a1.v().D(((TradeVerticalSpotPresenter) TradeVerticalSpotFragment.this.yh()).o0())), String.valueOf(b11.getRebalThreshold()), a1.v().p(((TradeVerticalSpotPresenter) TradeVerticalSpotFragment.this.yh()).o0()), a1.v().p(((TradeVerticalSpotPresenter) TradeVerticalSpotFragment.this.yh()).o0()), EtpRiskHintUtil.c(a1.v().n(((TradeVerticalSpotPresenter) TradeVerticalSpotFragment.this.yh()).o0())), String.valueOf(b11.getLeverageRatio())});
                    if (Math.abs(b11.getLeverageRatio()) > 1) {
                        format = format + "\n" + String.format(locale, TradeVerticalSpotFragment.this.getString(R.string.n_trade_etp_carousel_untime_height_hint_content), new Object[]{a1.v().p(((TradeVerticalSpotPresenter) TradeVerticalSpotFragment.this.yh()).o0()), qt.e.a(EtpRiskHintUtil.c(a1.v().n(((TradeVerticalSpotPresenter) TradeVerticalSpotFragment.this.yh()).o0())), String.valueOf(b11.getLeverageRatio()))});
                    }
                    new DialogUtils.b.d(TradeVerticalSpotFragment.this.getActivity()).c1(TradeVerticalSpotFragment.this.getActivity().getString(R.string.n_trade_etp_carousel_untime_title)).C0(format).q0(false).Y0(TradeVerticalSpotFragment.this.getString(R.string.n_trade_etp_carousel_time_link_hint)).a1(new s4(this)).P0(TradeVerticalSpotFragment.this.getActivity().getString(R.string.n_known)).Q0(u4.f83538a).k0().show(TradeVerticalSpotFragment.this.getActivity().getSupportFragmentManager(), "");
                }
            } else if (topScrollData.d() == 2 && b11 != null) {
                new DialogUtils.b.d(TradeVerticalSpotFragment.this.getActivity()).c1(TradeVerticalSpotFragment.this.getActivity().getString(R.string.n_trade_etp_chargeFee_hint_title)).C0(String.format(Locale.ENGLISH, TradeVerticalSpotFragment.this.getString(R.string.n_trade_etp_chargeFee_hint_content), new Object[]{DateTimeUtils.A(b11.getChargeFeeTime()), m.a(b11.getChargeFee()).setScale(4, 1).stripTrailingZeros().toPlainString() + "%"})).q0(false).P0(TradeVerticalSpotFragment.this.getActivity().getString(R.string.n_known)).Q0(t4.f83531a).k0().show(TradeVerticalSpotFragment.this.getActivity().getSupportFragmentManager(), "");
            }
        }
    }

    public class c implements it.a {
        public c() {
        }

        public void b(int i11, long j11, long[] jArr) {
        }

        public void c(int i11) {
            if (i11 == 1) {
                if (a1.v().o0(((TradeVerticalSpotPresenter) TradeVerticalSpotFragment.this.yh()).o0(), ((TradeVerticalSpotPresenter) TradeVerticalSpotFragment.this.yh()).Z0())) {
                    ((TradeVerticalSpotPresenter) TradeVerticalSpotFragment.this.yh()).I3();
                    ((TradeVerticalSpotPresenter) TradeVerticalSpotFragment.this.yh()).A3();
                }
            } else if (i11 == 2) {
                ((TradeVerticalSpotPresenter) TradeVerticalSpotFragment.this.yh()).K3();
            }
            i6.d.b("CallAuction onCountDownFinish======:" + i11);
            TradeVerticalSpotFragment.this.z1();
            ((TradeVerticalSpotPresenter) TradeVerticalSpotFragment.this.yh()).B1();
        }
    }

    public class d implements Runnable {
        public d() {
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void f(View view) {
            f0.m(TradeVerticalSpotFragment.this.f83315i2, TradeVerticalSpotFragment.this.getString(R.string.n_trade_etp_nav_time_instructions), "2/2", z4.f83570b, 2);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void h(View view) {
            f0.m(TradeVerticalSpotFragment.this.f83315i2, TradeVerticalSpotFragment.this.getString(R.string.n_trade_etp_nav_time_instructions), "2/2", y4.f83562b, 2);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public void run() {
            if (TradeVerticalSpotFragment.this.zh() != null && TradeVerticalSpotFragment.this.zh().isCanBeSeen() && TradeVerticalSpotFragment.this.f83328v2 && r.x().F0() && BizRecordProvider.e()) {
                TextView indexPriceView = TradeVerticalSpotFragment.this.f83106t.getIndexPriceView();
                if (indexPriceView != null && !TextUtils.isEmpty(indexPriceView.getText()) && !indexPriceView.getText().toString().contains("--")) {
                    String format = String.format(Locale.ENGLISH, TradeVerticalSpotFragment.this.getString(R.string.n_trade_etp_nav_instructions_new), new Object[]{a1.v().p(((TradeVerticalSpotPresenter) TradeVerticalSpotFragment.this.yh()).o0())});
                    f0.m(TradeVerticalSpotFragment.this.f83106t.getIndexPriceView(), format, String.format(Locale.US, TradeVerticalSpotFragment.this.getString(R.string.n_trade_auto_loan_tip_skip), new Object[]{"1/2"}), new w4(this), 1);
                }
                TextView indexPriceView2 = TradeVerticalSpotFragment.this.F.getIndexPriceView();
                if (indexPriceView2 != null && !TextUtils.isEmpty(indexPriceView2.getText()) && !indexPriceView2.getText().toString().contains("--")) {
                    String format2 = String.format(Locale.ENGLISH, TradeVerticalSpotFragment.this.getString(R.string.n_trade_etp_nav_instructions_new), new Object[]{a1.v().p(((TradeVerticalSpotPresenter) TradeVerticalSpotFragment.this.yh()).o0())});
                    f0.m(TradeVerticalSpotFragment.this.F.getIndexPriceView(), format2, String.format(Locale.US, TradeVerticalSpotFragment.this.getString(R.string.n_trade_auto_loan_tip_skip), new Object[]{"1/2"}), new x4(this), 1);
                }
            }
        }
    }

    public class e implements Runnable {
        public e() {
        }

        public void run() {
            TradeVerticalSpotFragment.this.G2.b().a();
        }
    }

    public class f implements Runnable {

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                TradeVerticalSpotFragment.this.Hm();
            }
        }

        public f() {
        }

        public void run() {
            TradeVerticalSpotFragment tradeVerticalSpotFragment = TradeVerticalSpotFragment.this;
            if (tradeVerticalSpotFragment.O1) {
                tradeVerticalSpotFragment.ll();
                TradeVerticalSpotFragment.this.S0.post(new a());
                return;
            }
            tradeVerticalSpotFragment.Hm();
        }
    }

    public class g implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f83340b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f83341c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ot.c f83342d;

        public g(View view, int i11, ot.c cVar) {
            this.f83340b = view;
            this.f83341c = i11;
            this.f83342d = cVar;
        }

        public void run() {
            Rect rect = new Rect();
            this.f83340b.getGlobalVisibleRect(rect);
            int i11 = rect.top;
            int i12 = this.f83341c;
            rect.top = i11 - i12;
            rect.bottom += i12;
            this.f83342d.l(rect);
            this.f83342d.o();
        }
    }

    public class h implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f83344b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f83345c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f83346d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ot.c f83347e;

        public h(View view, int i11, int i12, ot.c cVar) {
            this.f83344b = view;
            this.f83345c = i11;
            this.f83346d = i12;
            this.f83347e = cVar;
        }

        public void run() {
            Rect rect = new Rect();
            this.f83344b.getGlobalVisibleRect(rect);
            int i11 = rect.top;
            int i12 = this.f83345c;
            rect.top = i11 - i12;
            rect.bottom += i12;
            rect.left = 0;
            rect.right = this.f83346d;
            this.f83347e.l(rect);
            this.f83347e.o();
        }
    }

    public class i implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f83349b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ot.c f83350c;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                View b11 = TradeVerticalSpotFragment.this.f67460i.b(R.id.rl_trade_order_tab_container);
                Rect rect = new Rect();
                b11.getGlobalVisibleRect(rect);
                View b12 = TradeVerticalSpotFragment.this.f67460i.b(R.id.order_tab_sv);
                Rect rect2 = new Rect();
                b12.getGlobalVisibleRect(rect2);
                i.this.f83350c.l(new Rect(rect.left, rect.top, rect.right, rect2.bottom));
                i.this.f83350c.o();
            }
        }

        public i(int i11, ot.c cVar) {
            this.f83349b = i11;
            this.f83350c = cVar;
        }

        public void run() {
            TradeVerticalSpotFragment.this.F2.scrollTo(0, TradeVerticalSpotFragment.this.f67460i.b(R.id.order_container).getTop() - this.f83349b);
            TradeVerticalSpotFragment.this.F2.postDelayed(new a(), 10);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Am(String str, GridSymbolsConfig gridSymbolsConfig) {
        this.f83111w.setSymbol(str);
        this.f83111w.setGridEntranceVisible(y.e(str));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Bm(Object obj) {
        if (((Boolean) obj).booleanValue()) {
            if (this.D2 == null) {
                View E = this.C2.E("currency_notice.xml", getActivity(), false, (JSONObject) null);
                this.D2 = E;
                this.B2.addView(E);
            }
            this.B2.setVisibility(0);
            return;
        }
        this.B2.setVisibility(8);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Cm(String str, View view) {
        kl(str);
        try {
            gs.g.i("App_trade_available_click", (HashMap) null);
        } catch (Exception e11) {
            i6.k.j("SensorsData", e11);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Dm(String str, View view) {
        kl(str);
        try {
            gs.g.i("App_trade_maxavailable_click", (HashMap) null);
        } catch (Exception e11) {
            i6.k.j("SensorsData", e11);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Lk(View view) {
        gs.g.i("App_trade_deepth_click", (HashMap) null);
        HashMap hashMap = new HashMap(1);
        hashMap.put("trade_firtab_name", RankScreenBean.SCREEN_VALUE_SPOT);
        gs.g.i("App_trade_depth_click", hashMap);
        if (((TradeVerticalSpotPresenter) yh()).M0().w().size() > 0) {
            this.f83287t1.show(getActivity().getFragmentManager(), com.huobi.trade.ui.TradeVerticalSpotFragment.class.getName());
        }
        this.f83108u.hideKeyboardLayout();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Oi(View view) {
        ((TradeVerticalSpotPresenter) yh()).W2();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ok(View view) {
        ((TradeVerticalSpotPresenter) yh()).V2();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void gm(Void voidR) {
        new DialogUtils.b.d(getActivity()).C0(getString(R.string.n_exchange_balance_max_notice_content)).c1(getString(R.string.n_exchange_balance_max_notice_title)).P0(getString(R.string.n_known)).Q0(ad.b.f3517a).k0().show(getActivity().getSupportFragmentManager(), "");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void hm(OrderConfirmResponse orderConfirmResponse) {
        String str;
        if (this.N1 == null) {
            str = "--";
        } else {
            str = m.q(this.N1, PrecisionUtil.A(SymbolUtil.c(((TradeVerticalSpotPresenter) yh()).o0(), !((TradeVerticalSpotPresenter) yh()).e1()))) + SymbolUtil.c(((TradeVerticalSpotPresenter) yh()).o0(), !((TradeVerticalSpotPresenter) yh()).e1());
        }
        new DialogUtils.b.d(getActivity()).C0(String.format(getString(R.string.n_spot_margin_had_loan_risk_alert_hint), new Object[]{str, BigDecimal.valueOf(orderConfirmResponse.b()).multiply(new BigDecimal("100")).stripTrailingZeros().toPlainString() + "%"})).c1(getString(R.string.n_spot_order_risk)).P0(getString(R.string.n_known)).Q0(ad.b.f3517a).k0().show(getActivity().getSupportFragmentManager(), "");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00d5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void im(java.lang.Void r12) {
        /*
            r11 = this;
            dt.h2 r12 = dt.h2.t1()
            com.hbg.lib.common.mvp.BaseFragmentPresenter r0 = r11.yh()
            com.huobi.tradenew.presenter.TradeVerticalSpotPresenter r0 = (com.huobi.tradenew.presenter.TradeVerticalSpotPresenter) r0
            com.hbg.lib.data.symbol.TradeType r0 = r0.Z0()
            com.huobi.account.entity.AccountType r1 = com.huobi.account.entity.AccountType.spot
            java.lang.String r1 = r1.toString()
            long r0 = r12.G1(r0, r1)
            java.lang.String r3 = java.lang.String.valueOf(r0)
            com.hbg.lib.common.mvp.BaseFragmentPresenter r12 = r11.yh()
            com.huobi.tradenew.presenter.TradeVerticalSpotPresenter r12 = (com.huobi.tradenew.presenter.TradeVerticalSpotPresenter) r12
            java.lang.String r12 = r12.o0()
            com.hbg.lib.common.mvp.BaseFragmentPresenter r0 = r11.yh()
            com.huobi.tradenew.presenter.TradeVerticalSpotPresenter r0 = (com.huobi.tradenew.presenter.TradeVerticalSpotPresenter) r0
            rt.i r0 = r0.M0()
            double r0 = r0.z()
            java.math.BigDecimal r0 = java.math.BigDecimal.valueOf(r0)
            java.lang.String r0 = r0.toPlainString()
            com.hbg.lib.common.mvp.BaseFragmentPresenter r1 = r11.yh()
            com.huobi.tradenew.presenter.TradeVerticalSpotPresenter r1 = (com.huobi.tradenew.presenter.TradeVerticalSpotPresenter) r1
            int r1 = r1.a1()
            java.lang.String r2 = "limit"
            java.lang.String r4 = "market"
            r5 = 1
            if (r1 != r5) goto L_0x0050
        L_0x004d:
            r1 = r0
            r0 = r4
            goto L_0x0075
        L_0x0050:
            com.hbg.lib.common.mvp.BaseFragmentPresenter r1 = r11.yh()
            com.huobi.tradenew.presenter.TradeVerticalSpotPresenter r1 = (com.huobi.tradenew.presenter.TradeVerticalSpotPresenter) r1
            int r1 = r1.a1()
            r5 = 3
            if (r1 != r5) goto L_0x006f
            com.hbg.lib.common.mvp.BaseFragmentPresenter r1 = r11.yh()
            com.huobi.tradenew.presenter.TradeVerticalSpotPresenter r1 = (com.huobi.tradenew.presenter.TradeVerticalSpotPresenter) r1
            boolean r1 = r1.n2()
            if (r1 == 0) goto L_0x006a
            goto L_0x004d
        L_0x006a:
            java.lang.String r0 = r11.getInputPriceText()
            goto L_0x0073
        L_0x006f:
            java.lang.String r0 = r11.getInputPriceText()
        L_0x0073:
            r1 = r0
            r0 = r2
        L_0x0075:
            com.hbg.lib.common.mvp.BaseFragmentPresenter r2 = r11.yh()
            com.huobi.tradenew.presenter.TradeVerticalSpotPresenter r2 = (com.huobi.tradenew.presenter.TradeVerticalSpotPresenter) r2
            boolean r2 = r2.e1()
            if (r2 == 0) goto L_0x008a
            com.huobi.tradenew.ui.a5 r2 = r11.zh()
            int r2 = r2.getUiPlanTradeBuyMode()
            goto L_0x0092
        L_0x008a:
            com.huobi.tradenew.ui.a5 r2 = r11.zh()
            int r2 = r2.getUiPlanTradeSellMode()
        L_0x0092:
            r8 = r2
            com.hbg.lib.common.mvp.BaseFragmentPresenter r2 = r11.yh()
            com.huobi.tradenew.presenter.TradeVerticalSpotPresenter r2 = (com.huobi.tradenew.presenter.TradeVerticalSpotPresenter) r2
            rt.z r4 = r2.X0()
            com.hbg.lib.common.mvp.BaseFragmentPresenter r2 = r11.yh()
            com.huobi.tradenew.presenter.TradeVerticalSpotPresenter r2 = (com.huobi.tradenew.presenter.TradeVerticalSpotPresenter) r2
            int r6 = r2.a1()
            com.hbg.lib.common.mvp.BaseFragmentPresenter r2 = r11.yh()
            com.huobi.tradenew.presenter.TradeVerticalSpotPresenter r2 = (com.huobi.tradenew.presenter.TradeVerticalSpotPresenter) r2
            boolean r7 = r2.e1()
            java.lang.String r2 = r11.getInputPriceText()
            java.math.BigDecimal r9 = i6.m.a(r2)
            java.lang.String r2 = r11.getInputAmountText()
            java.math.BigDecimal r10 = i6.m.a(r2)
            r5 = r12
            java.math.BigDecimal r2 = r4.H(r5, r6, r7, r8, r9, r10)
            com.hbg.lib.common.mvp.BaseFragmentPresenter r4 = r11.yh()
            com.huobi.tradenew.presenter.TradeVerticalSpotPresenter r4 = (com.huobi.tradenew.presenter.TradeVerticalSpotPresenter) r4
            boolean r4 = r4.e1()
            if (r4 == 0) goto L_0x00d5
            java.lang.String r4 = "buy"
            goto L_0x00d7
        L_0x00d5:
            java.lang.String r4 = "sell"
        L_0x00d7:
            r6 = r4
            java.lang.String r7 = r11.getInputAmountText()
            com.huobi.tradenew.prime.helper.TradeMarginHelper r4 = com.huobi.tradenew.prime.helper.TradeMarginHelper.b()
            java.lang.String r4 = r4.a()
            java.math.BigDecimal r4 = i6.m.a(r4)
            java.math.BigDecimal r2 = r2.subtract(r4)
            java.lang.String r8 = r2.toPlainString()
            qt.f r2 = qt.f.a()
            com.huobi.tradenew.ui.c4 r10 = new com.huobi.tradenew.ui.c4
            r10.<init>(r11)
            r4 = r12
            r5 = r0
            r9 = r1
            r2.b(r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.tradenew.ui.TradeVerticalSpotFragment.im(java.lang.Void):void");
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void jm(View view) {
        if (this.f67460i.b(R.id.order_container).getVisibility() == 0) {
            this.Q0.setBackgroundResource(R.drawable.trade_order_entrance_enable);
        } else {
            boolean e12 = ((TradeVerticalSpotPresenter) yh()).e1();
            if (w.l()) {
                if (e12) {
                    this.Q0.setBackgroundResource(R.drawable.trade_order_entrance_disable_red);
                } else {
                    this.Q0.setBackgroundResource(R.drawable.trade_order_entrance_disable_green);
                }
            } else if (e12) {
                this.Q0.setBackgroundResource(R.drawable.trade_order_entrance_disable_green);
            } else {
                this.Q0.setBackgroundResource(R.drawable.trade_order_entrance_disable_red);
            }
        }
        ViewUtil.o(this.f67460i.b(R.id.order_container));
        ViewUtil.o(this.f67460i.b(R.id.trade_splitter_2));
        if (this.f67460i.b(R.id.order_container).getVisibility() != 0) {
            this.F.setVisibility(8);
        } else if (this.V != null) {
            int g11 = ((TradeVerticalSpotPresenter) yh()).g();
            Iterator<Map.Entry<Integer, Integer>> it2 = this.V.entrySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Map.Entry next = it2.next();
                if (((Integer) next.getValue()).intValue() == g11) {
                    Aj(((Integer) next.getKey()).intValue(), (Integer) next.getValue(), false);
                    break;
                }
            }
        }
        try {
            gs.g.i("App_trade_orderButton_click", (HashMap) null);
        } catch (Exception e11) {
            i6.k.j("SensorsData", e11);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void km(Void voidR) {
        ti(((TradeVerticalSpotPresenter) yh()).o0());
        Em("App_targe_gocogy_click", "TransPair_current_id", ((TradeVerticalSpotPresenter) yh()).o0());
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$5(View view) {
        o.C().w0(false);
        Bb(o.C().G(), o.C().G() != null ? o.C().G().getStatus() : 3, true);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lm(Void voidR) {
        new DialogUtils.b.d(getActivity()).C0(getString(R.string.n_exchange_balance_notice_content_v2)).c1(getString(R.string.n_exchange_balance_notice_title)).P0(getString(R.string.n_known)).Q0(ad.b.f3517a).k0().show(getActivity().getSupportFragmentManager(), "");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void nm(String str, HBDialogFragment hBDialogFragment) {
        ((ClipboardManager) getActivity().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(str, str));
        HuobiToastUtil.t(getActivity(), R.string.currency_deposit_copied);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void qm(String str) {
        u3(str);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void rm(View view) {
        View view2 = view;
        TradeSpotPopUtil.j(view2, this.F.getNewestPrice(), this.F.getFirstBldPrice(), this.F.getFirstAskPrice(), ((TradeVerticalSpotPresenter) yh()).o0(), new b4(this));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void sm(BigDecimal bigDecimal, BigDecimal bigDecimal2, boolean z11, int i11, boolean z12) {
        int i12;
        BigDecimal divide = BigDecimal.valueOf((long) i11).divide(BigDecimal.valueOf(100));
        BigDecimal bigDecimal3 = null;
        if (z12) {
            if (bigDecimal != null) {
                bigDecimal3 = bigDecimal.multiply(divide);
            }
        } else if (bigDecimal2 != null) {
            bigDecimal3 = bigDecimal2.multiply(divide);
        }
        if (bigDecimal3 != null) {
            if (z11) {
                i12 = PrecisionUtil.y(((TradeVerticalSpotPresenter) yh()).o0());
            } else {
                i12 = PrecisionUtil.C(((TradeVerticalSpotPresenter) yh()).o0());
            }
            String q11 = m.q(bigDecimal3, i12);
            this.E0.setText(q11);
            EditText editText = this.E0;
            editText.setSelection(editText.getText().length());
            ((TradeVerticalSpotPresenter) yh()).d2(this.E0, new SpannableStringBuilder(q11), true);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void tm(boolean z11, View view) {
        String str;
        String str2;
        if (z11) {
            str = getString(R.string.n_exchange_balance_max_notice_title);
            str2 = getString(R.string.n_exchange_balance_max_notice_content);
        } else if (((TradeVerticalSpotPresenter) yh()).e1()) {
            str = getString(R.string.n_exchange_buy_on_margin);
            str2 = getString(R.string.n_spot_max_available_amount_buy_hint);
        } else {
            str = getString(R.string.n_exchange_sell_on_margin);
            str2 = getString(R.string.n_spot_max_available_amount_sell_hint);
        }
        new DialogUtils.b.d(getActivity()).C0(str2).c1(str).P0(getString(R.string.n_known)).Q0(ad.b.f3517a).k0().show(getActivity().getSupportFragmentManager(), "");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void um(View view) {
        boolean i12 = ((TradeVerticalSpotPresenter) yh()).i1();
        BigDecimal a11 = m.a(TradeMarginHelper.b().a());
        BigDecimal a12 = m.a(TradeMarginHelper.b().c());
        boolean z11 = true;
        if (!(((TradeVerticalSpotPresenter) yh()).a1() == 1 || (((TradeVerticalSpotPresenter) yh()).a1() == 3 && this.Z == 2))) {
            z11 = false;
        }
        if (((TradeVerticalSpotPresenter) yh()).e1() && !z11) {
            if (!TextUtils.isEmpty(getInputPriceText())) {
                BigDecimal a13 = m.a(getInputPriceText());
                if (a13.compareTo(BigDecimal.ZERO) > 0) {
                    a11 = a11.divide(a13, RoundingMode.HALF_DOWN);
                    a12 = a12.divide(a13, RoundingMode.HALF_DOWN);
                }
            }
            a11 = null;
            a12 = null;
        }
        TradeSpotPopUtil.h(view, ((TradeVerticalSpotPresenter) yh()).e1(), i12, z11, new z3(this, a12, a11, z11), new q4(this, z11));
        try {
            gs.g.i("App_trade_quanType_click", (HashMap) null);
        } catch (Exception e11) {
            i6.k.j("SensorsData", e11);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void vm(HBDialogFragment hBDialogFragment) {
        rn.c.i().d(getActivity(), new JumpTarget(new Intent(getActivity(), KycProBaseInformationActivity.class), k0.h(getActivity())));
        hBDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void wm(HBDialogFragment hBDialogFragment) {
        OtcAliCertificateActivity.gg(getActivity(), false, false);
        hBDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void xm(HBDialogFragment hBDialogFragment) {
        nb.c.h(getActivity(), l.M(), false);
        hBDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ym(PrimeKycLimit primeKycLimit, String str, Boolean bool, List list, Integer num) {
        if (primeKycLimit.getKyc() == 1) {
            if (KycProxy.l().p() != 2) {
                Zl(new t3(this));
            }
        } else if (primeKycLimit.getKyc() == 2) {
            int p11 = KycProxy.l().p();
            UserVO r11 = l.r();
            UserKycInfoNew o11 = KycProxy.l().o();
            if (p11 != 2 && (o11 == null || o11.getAuth_info() == null || o11.getAuth_info().getPro_auth_type() != 10)) {
                cm(new s3(this));
            } else if (r11 != null && r11.getRealBind() == 2) {
            } else {
                if (r.x().U()) {
                    cm(new r3(this));
                } else {
                    am();
                }
            }
        }
    }

    public void Ah() {
        super.Ah();
        this.f83314h2.setOnClickListener(new a4(this));
        this.f83314h2.setCountDownCallback(this.E2);
        this.f83315i2.setCallback(new b());
        this.f83317k2.setOnClickListener(new m4(this));
        this.f83321o2.setOnClickListener(new l4(this));
        this.f83329w2.setCountDownCallback(new c());
        Observable<Void> a11 = dw.a.a(this.f83326t2);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        a11.throttleFirst(300, timeUnit).subscribe(new e4(this));
        dw.a.a(this.N0).throttleFirst(300, timeUnit).subscribe(new f4(this));
        dw.a.a(this.O0).throttleFirst(300, timeUnit).subscribe(new g4(this));
        dw.a.a(this.P0).throttleFirst(300, timeUnit).subscribe(new d4(this));
        this.F.setDepthOnClickListener(new n4(this));
        this.Q0.setOnClickListener(new p3(this));
    }

    public void Bb(PrimeInfo primeInfo, int i11, boolean z11) {
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f67460i.b(R.id.trade_spot_content_parent);
        CoordinatorLayout.LayoutParams layoutParams = new CoordinatorLayout.LayoutParams(-1, -1);
        layoutParams.o(new AppBarLayout.ScrollingViewBehavior());
        if (i11 == 1) {
            if (o.C().S()) {
                w1();
            } else {
                super.wj(coordinatorLayout, layoutParams, primeInfo);
            }
        } else if (i11 == 2) {
            if (o.C().S()) {
                w1();
            } else if (z11) {
                super.wj(coordinatorLayout, layoutParams, primeInfo);
            } else {
                w1();
            }
        } else if (i11 == 3) {
            super.wj(coordinatorLayout, layoutParams, primeInfo);
        }
    }

    public void Df() {
        this.f83329w2.k();
        this.f83329w2.post(new f());
    }

    public void E(int i11, long j11) {
        this.f83329w2.q(i11, j11);
    }

    public void E8(String str, PrimeAveragePosition primeAveragePosition) {
        super.E8(str, primeAveragePosition);
    }

    public final void Em(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put(str2, str3);
        gs.g.i(str, hashMap);
    }

    public void Fm(MarketCurrentPriceItem marketCurrentPriceItem) {
        if (getContext() != null && marketCurrentPriceItem != null && this.T1 != null) {
            if (marketCurrentPriceItem.g() != null) {
                String str = String.format(getResources().getString(R.string.balance_total_cny), new Object[]{marketCurrentPriceItem.g()}) + BaseModuleConfig.a().M().toUpperCase(Locale.US);
                TextView textView = this.T1;
                if (textView != null) {
                    textView.setText(str);
                    if (this.T1.getVisibility() != 0) {
                        this.T1.setVisibility(0);
                    }
                }
            } else if (this.T1.getVisibility() == 0) {
                this.T1.setVisibility(8);
            }
        }
    }

    public final void Gm() {
        this.f83101o.setPadding(0, 0, 0, 0);
    }

    public void H0(MarketCurrentPriceItem marketCurrentPriceItem) {
        super.H0(marketCurrentPriceItem);
        Im(marketCurrentPriceItem);
        this.F.setNewestPrice(marketCurrentPriceItem);
        Fm(marketCurrentPriceItem);
    }

    public final void Hm() {
        if (this.G2 == null) {
            this.G2 = new ot.a((ViewGroup) getActivity().findViewById(16908290));
            ArrayList arrayList = new ArrayList();
            arrayList.add(new ot.c(this.G2, 0, R.layout.layout_trade_vertical_spot_user_guide_1, this));
            arrayList.add(new ot.c(this.G2, 1, R.layout.layout_trade_vertical_spot_user_guide_2, this));
            arrayList.add(new ot.c(this.G2, 2, R.layout.layout_trade_vertical_spot_user_guide_3, this));
            arrayList.add(new ot.c(this.G2, 3, R.layout.layout_trade_vertical_spot_user_guide_4, this));
            arrayList.add(new ot.c(this.G2, 4, R.layout.layout_trade_vertical_spot_user_guide_5, this));
            arrayList.add(new ot.c(this.G2, 5, R.layout.layout_trade_vertical_spot_user_guide_6, this));
            this.G2.f(arrayList);
        }
        this.G2.h();
    }

    public void I(int i11) {
    }

    public final void Im(MarketCurrentPriceItem marketCurrentPriceItem) {
        if (getActivity() != null && a1.v().p0(((TradeVerticalSpotPresenter) yh()).o0()) && !TextUtils.isEmpty(marketCurrentPriceItem.h()) && !marketCurrentPriceItem.h().contains("--")) {
            i6.i.b().g(new d(), 500);
        }
    }

    public void J(String str) {
        super.J(str);
        o.C().A0(getActivity(), str);
    }

    public void Mg(double d11, int i11, int i12) {
        this.F.q(d11, i11, i12);
    }

    public void O(String str, String str2, String str3, String str4, String str5, String str6, int i11) {
        if (i11 != 8) {
            this.f83318l2.setText(str3);
            this.f83319m2.setBackgroundResource(f0.f(false, true, str));
            this.f83319m2.setTextColor(f0.g(getActivity(), true, str));
            this.f83319m2.setText(str5);
            this.f83320n2.setText("--");
            if (TextUtils.isEmpty(str6)) {
                this.f83321o2.setVisibility(4);
                return;
            }
            this.f83321o2.setVisibility(0);
            this.f83322p2.setText(str4);
            this.f83323q2.setBackgroundResource(f0.f(false, true, str2));
            this.f83323q2.setTextColor(f0.g(getActivity(), true, str2));
            this.f83323q2.setText(str6);
            this.f83324r2.setText("--");
        }
    }

    public void O1(String str, TradeType tradeType) {
        super.O1(str, tradeType);
        if (((TradeVerticalSpotPresenter) yh()).h1() && ((TradeVerticalSpotPresenter) yh()).e1()) {
            this.N0.setText(getResources().getString(R.string.n_trade_observation_available_limit));
        } else if (!a1.v().S(((TradeVerticalSpotPresenter) yh()).o0()) || !((TradeVerticalSpotPresenter) yh()).e1()) {
            this.N0.setText(R.string.trade_asset_available);
        } else {
            this.N0.setText(R.string.trade_prime_asset_available);
        }
        y.h(true).compose(RxJavaHelper.t(zh())).subscribe(EasySubscriber.create(new h4(this, str)));
        this.N0.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0);
        this.N0.setClickable(false);
        this.O0.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.icon_info_grey, 0);
        this.O0.setClickable(true);
        this.P0.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.icon_info_grey, 0);
        this.O0.setClickable(true);
    }

    public void Og(String str, int i11, int i12) {
        this.f83320n2.setText(str);
        this.f83320n2.setTextColor(i11);
    }

    public void R2(String str, String str2) {
        String str3;
        String str4;
        if (((TradeVerticalSpotPresenter) yh()).e1()) {
            str3 = a1.v().E(str, ((TradeVerticalSpotPresenter) yh()).Z0());
        } else {
            str3 = a1.v().o(str, ((TradeVerticalSpotPresenter) yh()).Z0());
        }
        int a11 = PrecisionUtil.a(((TradeVerticalSpotPresenter) yh()).Z0(), str3);
        if (!((TradeVerticalSpotPresenter) yh()).h1() || !((TradeVerticalSpotPresenter) yh()).e1()) {
            if (!a1.v().S(((TradeVerticalSpotPresenter) yh()).o0()) || !((TradeVerticalSpotPresenter) yh()).e1()) {
                this.N0.setText(R.string.trade_asset_available);
            } else {
                this.N0.setText(R.string.trade_prime_asset_available);
            }
            str4 = m.m(str2, a11);
        } else {
            this.N0.setText(getResources().getString(R.string.n_trade_observation_available_limit));
            if (this.f83089f0 != null) {
                BigDecimal a12 = m.a(str2);
                String F0 = ((TradeVerticalSpotPresenter) yh()).F0(this.f83089f0.getCurrency(), this.f83089f0.getRemainingAmount(), ((TradeVerticalSpotPresenter) yh()).S0());
                if (a12.compareTo(m.a(F0)) == 1) {
                    str2 = F0;
                }
                str4 = m.m(str2, a11);
            } else {
                str4 = "--";
            }
        }
        this.f83293x0.setText(str4);
        this.f83290v1.setOnClickListener(new p4(this, str4));
        TradeMarginHelper.b().e(str4);
        this.f83291w0.setText(SymbolUtil.c(str, !((TradeVerticalSpotPresenter) yh()).e1()));
        String a32 = ((TradeVerticalSpotPresenter) yh()).a3(str3);
        this.f83295y0.setText(a32);
        this.S1.setOnClickListener(new o4(this, a32));
        TradeMarginHelper.b().g(a32);
        if (!((TradeVerticalSpotPresenter) yh()).i1()) {
            a32 = str4;
        }
        MultiConfigBuilder configBuilder = this.f83268d1.getConfigBuilder();
        if (!str4.equals(configBuilder.getBalance()) || !a32.equals(configBuilder.getMaxBalance()) || NightHelper.e().g() != configBuilder.isDark() || ((TradeVerticalSpotPresenter) yh()).e1() != configBuilder.isBuy()) {
            configBuilder.colorConfig(getContext(), NightHelper.e().g(), ((TradeVerticalSpotPresenter) yh()).e1()).data(str4, a32).build();
        }
    }

    public void S7(PrimeInfo primeInfo) {
        this.f83314h2.d(primeInfo, ((TradeVerticalSpotPresenter) yh()).o0());
        this.f83314h2.setVisibility(0);
    }

    public void V(List<TopScrollData> list, boolean z11, boolean z12, int i11) {
        this.f83315i2.setVisibility(i11);
        if (i11 == 8) {
            this.f83315i2.h();
        } else {
            this.f83315i2.j(list, z11, z12);
        }
    }

    public void W3() {
        if (r.x().F0()) {
            AccountRiskInfo c12 = h2.t1().c1();
            String str = "--";
            if (c12 != null) {
                String str2 = "0.00";
                String plainString = m.a0(c12.getEffectiveDeposit()) ? new BigDecimal(c12.getEffectiveDeposit()).setScale(2, 1).toPlainString() : str2;
                String plainString2 = m.a0(c12.getUsedDeposit()) ? new BigDecimal(c12.getUsedDeposit()).setScale(2, 1).toPlainString() : str2;
                if (m.a0(c12.getAvailableDeposit())) {
                    str2 = new BigDecimal(c12.getAvailableDeposit()).setScale(2, 1).toPlainString();
                }
                String str3 = str2;
                if (m.a0(c12.getRiskRate())) {
                    if (new BigDecimal(c12.getRiskRate()).compareTo(BigDecimal.valueOf(2)) > 0) {
                        str = ">200%";
                    } else {
                        str = new BigDecimal(c12.getRiskRate()).multiply(BigDecimal.valueOf(100)).setScale(2, 5).toPlainString() + "%";
                    }
                }
                String str4 = str;
                int riskLevel = c12.getRiskLevel();
                if (riskLevel != 0) {
                    switch (riskLevel) {
                        case 2:
                            this.L.setVisibility(0);
                            this.K.setTextColor(getContext().getResources().getColor(R.color.color_00D488));
                            this.K.setText(getString(R.string.n_spot_order_middle_risk) + "(" + str4 + ")");
                            break;
                        case 3:
                            this.L.setVisibility(0);
                            if (NightHelper.e().g()) {
                                this.K.setTextColor(getContext().getResources().getColor(R.color.color_F2BD00));
                            } else {
                                this.K.setTextColor(getContext().getResources().getColor(R.color.color_FFC700));
                            }
                            this.K.setText(getString(R.string.n_spot_order_high_risk) + "(" + str4 + ")");
                            break;
                        case 4:
                            this.L.setVisibility(0);
                            this.K.setTextColor(getContext().getResources().getColor(R.color.color_FF800C));
                            this.K.setText(getString(R.string.n_spot_order_very_high_risk) + "(" + str4 + ")");
                            break;
                        case 5:
                            this.L.setVisibility(8);
                            this.K.setTextColor(getContext().getResources().getColor(R.color.global_secondary_text_color));
                            this.K.setText(getString(R.string.n_asset_ybb_lock));
                            break;
                        case 6:
                            this.L.setVisibility(0);
                            this.K.setTextColor(getContext().getResources().getColor(R.color.color_FD0000));
                            this.K.setText(getString(R.string.n_spot_account_liquidation_risk) + "(" + str4 + ")");
                            break;
                        case 7:
                            this.L.setVisibility(0);
                            this.K.setTextColor(getContext().getResources().getColor(R.color.color_890000));
                            this.K.setText(getString(R.string.n_spot_account_wear_risk) + "(" + str4 + ")");
                            break;
                        default:
                            this.L.setVisibility(0);
                            this.K.setTextColor(getContext().getResources().getColor(R.color.color_00925D));
                            this.K.setText(getString(R.string.n_spot_order_little_risk) + "(" + str4 + ")");
                            break;
                    }
                } else {
                    this.L.setVisibility(8);
                    this.K.setTextColor(getContext().getResources().getColor(R.color.color_12B298));
                    this.K.setText(getString(R.string.n_spot_account_no_risk));
                }
                SpotAssetsDialogFragment spotAssetsDialogFragment = this.f83098m0;
                if (spotAssetsDialogFragment != null && this.f83100n0) {
                    spotAssetsDialogFragment.Ih(str4, c12.getRiskLevel(), plainString, plainString2, str3);
                    return;
                }
                return;
            }
            this.L.setVisibility(8);
            this.K.setTextColor(getContext().getResources().getColor(R.color.global_secondary_text_color));
            this.K.setText(str);
        }
    }

    public void W8() {
        if (o.C().G() != null) {
            if (((TradeVerticalSpotPresenter) yh()).e1()) {
                ViewUtil.n(this.H0, false);
                ViewUtil.m(this.I0, false);
            }
            PrimeInfo G = o.C().G();
            if (o.C().T()) {
                if (((TradeVerticalSpotPresenter) yh()).a1() != 0) {
                    ((TradeVerticalSpotPresenter) yh()).C0(0, false);
                }
                this.D0.setViewVisibilityAndEnable(8, false);
                this.D0.setBackgroundResource(R.drawable.custom_edittext_unenable_bg);
                ((TradeVerticalSpotPresenter) yh()).G1(true);
                if (((TradeVerticalSpotPresenter) yh()).e1()) {
                    this.C0.setText(m.m(G.getCurrentPrice(), PrecisionUtil.e(((TradeVerticalSpotPresenter) yh()).o0())));
                } else if (!TextUtils.isEmpty(G.getRoundLimitOrderPrice())) {
                    this.C0.setText(m.m(G.getRoundLimitOrderPrice(), PrecisionUtil.e(((TradeVerticalSpotPresenter) yh()).o0())));
                } else {
                    this.C0.setText("");
                }
                D1(8);
                W1(8);
            } else if (o.C().b0() && ((TradeVerticalSpotPresenter) yh()).a1() != 1) {
                ((TradeVerticalSpotPresenter) yh()).C0(1, false);
            }
        }
        E3(a1.v().S(((TradeVerticalSpotPresenter) yh()).o0()));
    }

    public void Wb(String str) {
        ((TradeVerticalSpotPresenter) yh()).X3(str);
    }

    public void X8() {
        ((TradeVerticalSpotPresenter) yh()).x1();
    }

    public void Y2(DepthItem depthItem, String str) {
        super.Y2(depthItem, str);
        if (m.a0(str)) {
            str = ((TradeVerticalSpotPresenter) yh()).M0().v(((TradeVerticalSpotPresenter) yh()).o0(), Integer.valueOf(str).intValue() - 1);
            if (TextUtils.isEmpty(str)) {
                str = "--";
            }
        }
        this.F.setDepthText(str);
    }

    public void Ze(ot.c cVar) {
        int d11 = cVar.d();
        int a11 = PixelUtils.a(8.0f);
        int g11 = PixelUtils.g();
        int a12 = PixelUtils.a(175.0f);
        qt.w.g(d11 + 1);
        if (d11 == 0) {
            View b11 = this.f67460i.b(R.id.asset_head_rl);
            Rect rect = new Rect();
            b11.getGlobalVisibleRect(rect);
            cVar.l(rect);
            cVar.o();
        } else if (d11 == 1) {
            View b12 = this.f67460i.b(R.id.trade_head_view);
            Rect rect2 = new Rect();
            b12.getGlobalVisibleRect(rect2);
            rect2.right = (int) (((float) rect2.right) * 0.55f);
            cVar.l(rect2);
            cVar.o();
        } else if (d11 == 2) {
            View b13 = this.f67460i.b(R.id.ll_order_type_container);
            this.F2.scrollTo(0, this.f67460i.b(R.id.left_ll).getTop());
            this.F2.postDelayed(new g(b13, a11, cVar), 10);
        } else if (d11 == 3) {
            View b14 = this.f67460i.b(R.id.limitMarketContainer);
            View b15 = this.f67460i.b(R.id.trade_new_seek_bar);
            Rect rect3 = new Rect();
            b14.getGlobalVisibleRect(rect3);
            Rect rect4 = new Rect();
            b15.getGlobalVisibleRect(rect4);
            Rect rect5 = new Rect(rect3.left, rect3.top, rect3.right, rect4.bottom);
            rect5.top -= a11;
            rect5.bottom += a11;
            cVar.l(rect5);
            cVar.o();
        } else if (d11 == 4) {
            View b16 = this.f67460i.b(R.id.btn_trade_confirm);
            this.F2.scrollTo(0, (this.f67460i.b(R.id.left_ll).getTop() + this.f67460i.b(R.id.ll_trade_confirm_container).getTop()) - a12);
            this.F2.postDelayed(new h(b16, a11, g11, cVar), 10);
        } else if (d11 == 5) {
            this.W.get(2).performClick();
            this.f67460i.b(R.id.order_container).post(new i(a12, cVar));
        }
    }

    public final void Zl(DialogUtils.b.f fVar) {
        if (isCanBeSeen()) {
            new DialogUtils.b.d(getActivity()).c1(getString(R.string.n_kyc_requirements)).C0(getString(R.string.n_kyc_requirements_hint)).P0(getString(R.string.n_kyc_confirm)).s0(getString(R.string.n_cancel)).Q0(fVar).N0(v3.f83544a).k0().show(getActivity().getSupportFragmentManager(), "");
        }
    }

    public final void am() {
        String e11 = com.hbg.lib.core.util.o.e();
        new DialogUtils.b.d(getActivity()).c1(getResources().getString(R.string.advance_identification_to_pc)).C0(e11).D0(Integer.valueOf(ContextCompat.getColor(getActivity(), R.color.global_jump_btn_color))).i1(1).M0(Integer.valueOf(R.drawable.otc_tips_toweb)).P0(getResources().getString(R.string.advance_identification_to_pc_url_copy)).Q0(new u3(this, e11)).N0(x3.f83556a).j0().show(getActivity().getSupportFragmentManager(), "");
    }

    /* renamed from: bm */
    public TradeVerticalSpotPresenter xh() {
        return new TradeVerticalSpotPresenter();
    }

    public final void cm(DialogUtils.b.f fVar) {
        if (isCanBeSeen()) {
            new DialogUtils.b.d(getActivity()).c1(getString(R.string.n_kyc_requirements)).C0(getString(R.string.n_senior_kyc_requirements_hint)).P0(getString(R.string.n_senior_kyc_confirm)).s0(getString(R.string.n_cancel)).Q0(fVar).N0(y3.f83561a).k0().show(getActivity().getSupportFragmentManager(), "");
        }
    }

    public void d(boolean z11) {
        super.d(z11);
        if (!z11) {
            this.f83293x0.setText("--");
            this.f83295y0.setText("--");
        }
    }

    public void dl(List<MarketBuySellItem> list) {
        this.F.setBuyList(list);
    }

    /* renamed from: dm */
    public a5 zh() {
        return this;
    }

    public final void em() {
        this.f83283p1 = (LinearLayout) this.f67460i.b(R.id.stop_trade_ll);
        this.f83284q1 = (ImageView) this.f67460i.b(R.id.trade_mask_iv);
        this.f83285r1 = (TextView) this.f67460i.b(R.id.trade_mask_title_tv);
        this.f83286s1 = (TextView) this.f67460i.b(R.id.trade_suspend_instruction_tv);
    }

    public void f0(CurrencyAsset currencyAsset) {
        String str;
        String o02 = ((TradeVerticalSpotPresenter) yh()).o0();
        if (((TradeVerticalSpotPresenter) yh()).e1()) {
            str = a1.v().E(o02, ((TradeVerticalSpotPresenter) yh()).Z0());
        } else {
            str = a1.v().o(o02, ((TradeVerticalSpotPresenter) yh()).Z0());
        }
        Pair<String, String> O = o.C().O(str);
        if (O == null || TextUtils.isEmpty((CharSequence) O.first)) {
            R2(o02, "0.00");
        } else {
            R2(o02, (String) O.first);
        }
    }

    public void ff(String str) {
        ((TradeVerticalSpotPresenter) yh()).G0(str);
    }

    public void fg(String str, int i11, int i12) {
        this.f83324r2.setText(str);
        this.f83324r2.setTextColor(i11);
    }

    public void fl(int i11, int i12) {
        this.F.o(i11, i12);
    }

    public final void fm() {
        TradeTrendViewNew tradeTrendViewNew = (TradeTrendViewNew) this.f67460i.b(R.id.trade_trend_view_new);
        this.F = tradeTrendViewNew;
        tradeTrendViewNew.setUI(this);
        this.F.setPresenter((TradeBasePresenter) yh());
        this.F.setTradeBaseUI(this);
        this.F.setActivity(getActivity());
        this.F.setShowLegalPrice(false);
    }

    public void h2() {
        super.h2();
        this.F.n();
    }

    public void il(List<MarketBuySellItem> list) {
        this.F.setSellList(list);
    }

    public void initViews() {
        super.initViews();
        this.T1.setVisibility(0);
        TradeType tradeType = TradeType.PRO;
        uj(tradeType);
        this.f83280m1.setVisibility(0);
        this.S.setVisibility(0);
        this.Q0.setBackgroundResource(R.drawable.trade_order_entrance_enable);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.M0.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        layoutParams.leftMargin = 0;
        this.M0.setLayoutParams(layoutParams);
        this.F0.setTradeType(tradeType);
        this.I0.setTradeType(tradeType);
        this.D0.setTradeType(tradeType);
        em();
        this.f83313g2 = this;
        this.f83314h2 = (PrimeTradeTopLayout) this.f67460i.b(R.id.prime_trade_top_view);
        this.f83315i2 = (TopScrollView) this.f67460i.b(R.id.etp_time_layout);
        this.f83316j2 = this.f67460i.b(R.id.etp_symbol_guide_ll);
        this.f83317k2 = this.f67460i.b(R.id.etp_long_ll);
        this.f83318l2 = (TextView) this.f67460i.b(R.id.etp_long_name_tv);
        this.f83319m2 = (TextView) this.f67460i.b(R.id.etp_long_leverage_tv);
        this.f83320n2 = (TextView) this.f67460i.b(R.id.etp_long_percent_tv);
        this.f83321o2 = this.f67460i.b(R.id.etp_short_ll);
        this.f83322p2 = (TextView) this.f67460i.b(R.id.etp_short_name_tv);
        this.f83323q2 = (TextView) this.f67460i.b(R.id.etp_short_leverage_tv);
        this.f83324r2 = (TextView) this.f67460i.b(R.id.etp_short_percent_tv);
        this.K1.setSelected(true);
        this.L1.setSelected(false);
        this.f83329w2 = (TradeCallAuctionLayout) this.f67460i.b(R.id.call_auction_view);
        this.f83325s2 = (TextView) this.f67460i.b(R.id.trade_bot_reminder_detail_tv);
        this.f83326t2 = this.f67460i.b(R.id.trade_bot_reminder_go);
        this.f83327u2 = this.f67460i.b(R.id.trade_bot_reminder_ll);
        this.f83332z2 = this.f67460i.b(R.id.right_ll);
        this.B2 = (FrameLayout) this.f67460i.b(R.id.currency_notice_container);
        fm();
        Gm();
        this.D0.setSelectorVisible(true);
        this.F0.setAddReduceZoneVisible(true);
        this.D0.setPriceSelectListener(new k4(this));
        this.D0.setLabelVisibility(0);
        this.F0.setOnSelectorClickListener(new j4(this));
        this.A2 = (TextView) this.f67460i.b(R.id.tv_order_count);
        this.F2 = (MyNestedScrollView) this.f67460i.b(R.id.trade_scrollview);
    }

    public void k0(String str) {
        this.f83331y2 = str;
        if (this.f83330x2 == 0) {
            this.f83327u2.setVisibility(8);
        } else if (AppLanguageHelper.getInstance().isChineseLanguage() || TextUtils.isEmpty(str)) {
            this.f83327u2.setVisibility(8);
        } else {
            this.f83325s2.setText(String.format(getString(R.string.n_trade_bot_percent), new Object[]{str}));
        }
    }

    public void ld(ws.h hVar) {
        View b11 = this.f67460i.b(R.id.order_container);
        if (!(b11 == null || b11.getVisibility() == 0)) {
            ViewUtil.o(this.f67460i.b(R.id.order_container));
            ViewUtil.o(this.f67460i.b(R.id.trade_splitter_2));
        }
        Map<Integer, Integer> map = this.V;
        if (map != null) {
            Iterator<Map.Entry<Integer, Integer>> it2 = map.entrySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Map.Entry next = it2.next();
                if (next.getValue() == hVar.c()) {
                    Aj(((Integer) next.getKey()).intValue(), (Integer) next.getValue(), false);
                    break;
                }
            }
        }
        if (hVar.b() != null) {
            int intValue = hVar.b().intValue();
            if (intValue == 1) {
                B2(R.id.tp_sl_order_rb);
            } else if (intValue != 2) {
                B2(R.id.open_order_rb);
            } else {
                B2(R.id.plan_order_rb);
            }
        }
    }

    public void o(boolean z11) {
        if (z11) {
            if (this.M0.isEnabled()) {
                this.M0.setEnabled(false);
                this.I1.setBackgroundResource(R.drawable.call_auction_entrust_unenable_bg);
            }
        } else if (!this.M0.isEnabled()) {
            this.M0.setEnabled(true);
            this.I1.setBackgroundResource(R.drawable.custom_edittext_normal_bg_without_corners);
        }
    }

    public void o1() {
        this.f83314h2.setVisibility(8);
    }

    public void o3(int i11, int i12) {
        super.o3(i11, i12);
        this.f83330x2 = i11;
        if (i11 == 0) {
            this.f83327u2.setVisibility(8);
        } else {
            k0(this.f83331y2);
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        PrimeTradeTopLayout primeTradeTopLayout = this.f83314h2;
        if (primeTradeTopLayout != null) {
            primeTradeTopLayout.setCountDownCallback((it.a) null);
        }
        rj.b bVar = this.C2;
        if (bVar != null) {
            bVar.B();
        }
    }

    public void onResume() {
        super.onResume();
        ((TradeVerticalSpotPresenter) yh()).A1();
    }

    public void p1(PrimeKycLimit primeKycLimit) {
        UserInfoUtil.h(zh(), new q3(this, primeKycLimit));
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_vertical_trade_new_spot, viewGroup, false);
    }

    public void pj(NestedScrollView nestedScrollView, int i11, int i12, int i13, int i14) {
        super.pj(nestedScrollView, i11, i12, i13, i14);
        jl(i12 > this.f83263a2);
    }

    public void q3(boolean z11) {
        if (z11) {
            this.f83106t.m(getResources().getDimensionPixelOffset(R.dimen.dimen_24));
            this.F.p(getResources().getDimensionPixelOffset(R.dimen.dimen_24));
            return;
        }
        this.f83106t.m(getResources().getDimensionPixelOffset(R.dimen.dimen_26));
        this.F.p(getResources().getDimensionPixelOffset(R.dimen.dimen_26));
    }

    public void r(CallAuction callAuction, String str) {
        this.f83329w2.r(callAuction, str);
    }

    public k r1() {
        return this.f83313g2;
    }

    public void sk(int i11) {
        super.sk(i11);
        this.F.i(i11);
    }

    public void t(SymbolBean symbolBean) {
        super.t(symbolBean);
        if (this.C2 == null) {
            rj.b bVar = new rj.b(getContext(), FirebaseAnalytics.Param.CURRENCY);
            this.C2 = bVar;
            bVar.t("openNoticeUrl", CurrencyNoticeAbility.class);
            this.C2.H();
            this.C2.v("visibility", new i4(this));
            if (!NightHelper.e().g()) {
                this.C2.I("setDarkMode(0)");
            } else {
                this.C2.I("setDarkMode(1)");
            }
        }
        this.C2.I("currencyNoticeMessage('" + ((TradeVerticalSpotPresenter) yh()).J0() + "','0')");
    }

    public void u1() {
        if (isCanBeSeen()) {
            new DialogUtils.b.d(getActivity()).c1(getString(R.string.n_option_delivery_tip)).C0(getString(R.string.n_not_support_activity_hint)).P0(getString(R.string.n_confirm)).q0(false).Q0(w3.f83549a).k0().show(getActivity().getSupportFragmentManager(), "");
        }
    }

    public void uh(boolean z11) {
        super.uh(z11);
        this.f83328v2 = z11;
        if (z11 && !r.x().X() && getActivity() != null && (getActivity() instanceof HuobiMainActivity)) {
            ((HuobiMainActivity) getActivity()).ni();
        }
        if (z11) {
            this.f83315i2.g();
            try {
                gs.g.b(((TradeVerticalSpotPresenter) yh()).o0(), "Vertical");
            } catch (Exception e11) {
                i6.k.j("SensorsData", e11);
            }
            UserVO r11 = l.r();
            if (r11 != null) {
                if (System.currentTimeMillis() - r11.getGmtRegister() <= 432000000) {
                    if (!ConfigPreferences.c("user_config", "trade_spot_new_user_guide_show", false)) {
                        zj();
                        ConfigPreferences.n("user_config", "trade_spot_new_user_guide_show", true);
                    }
                } else if (!ConfigPreferences.c("user_config", "trade_spot_guide_show", false)) {
                    TradeSpotGuideFragment tradeSpotGuideFragment = new TradeSpotGuideFragment();
                    tradeSpotGuideFragment.setCanceledOnTouchOutside(false);
                    tradeSpotGuideFragment.show(getActivity().getSupportFragmentManager(), "");
                    ConfigPreferences.n("user_config", "trade_spot_guide_show", true);
                }
            } else {
                return;
            }
        } else {
            this.f83315i2.h();
            f0.c(getActivity());
        }
        ot.a aVar = this.G2;
        if (aVar != null && aVar.b() != null) {
            this.f83315i2.postDelayed(new e(), 1000);
        }
    }

    public void uk(boolean z11, int i11, String str) {
        if (getActivity() != null) {
            super.uk(z11, i11, str);
        }
    }

    public void w1() {
        super.w1();
    }

    public void x3(String str) {
        super.x3(str);
    }

    public void yi() {
        this.U.clear();
        this.U.add(getString(R.string.n_spot_asset_buy_or_sell));
        this.V.put(0, -1);
        this.U.add(getString(R.string.n_trade_tab_assets));
        this.V.put(1, 0);
        this.U.add(getString(R.string.n_trade_open_order));
        this.V.put(2, 1);
        this.U.add(getString(R.string.n_exchange_order_history_deals));
        this.V.put(3, 2);
    }

    public void z1() {
        this.f83329w2.s(((TradeVerticalSpotPresenter) yh()).o0());
    }

    public void zj() {
        if (this.H2 == null) {
            this.H2 = new TradeVerticalSpotUserGuideDialog(this);
        }
        if (!this.H2.isVisible() && !this.H2.isAdded()) {
            this.H2.show(getChildFragmentManager(), "TradeVerticalSpotUserGuideDialog");
        }
    }
}
