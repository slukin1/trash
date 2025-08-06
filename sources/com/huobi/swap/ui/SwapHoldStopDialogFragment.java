package com.huobi.swap.ui;

import android.app.Activity;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import bh.j;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.future.util.FutureUnitUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.socket.bean.TradeBuySellData;
import com.hbg.lib.network.pro.socket.listener.MarketDepthListener;
import com.hbg.lib.network.pro.socket.response.MarketDepthResponse;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseEasySubscriber;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.network.swap.core.bean.SwapPosition;
import com.hbg.lib.network.swap.core.util.SwapDepthType;
import com.hbg.lib.widgets.LoadingView;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.contract.entity.ContractAssetAndOrderUpdateEvent;
import com.huobi.contract.entity.ContractOrderPlace;
import com.huobi.contract.ui.ContractBaseHoldDialogFragment;
import com.huobi.feature.util.FutureTpSlFuturesHelper;
import com.huobi.feature.util.FutureTpSlHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import i6.r;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.EventBus;
import pro.huobi.R;
import qs.d0;
import ts.l;
import ts.n;
import ts.o;
import u6.g;
import us.i;

public class SwapHoldStopDialogFragment extends ContractBaseHoldDialogFragment {

    /* renamed from: h  reason: collision with root package name */
    public TextView f81623h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f81624i;

    /* renamed from: j  reason: collision with root package name */
    public View f81625j;

    /* renamed from: k  reason: collision with root package name */
    public View f81626k;

    /* renamed from: l  reason: collision with root package name */
    public View f81627l;

    /* renamed from: m  reason: collision with root package name */
    public LoadingView f81628m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f81629n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f81630o;

    /* renamed from: p  reason: collision with root package name */
    public TextView f81631p;

    /* renamed from: q  reason: collision with root package name */
    public SwapCurrencyInfo f81632q;

    /* renamed from: r  reason: collision with root package name */
    public SwapPosition f81633r;

    /* renamed from: s  reason: collision with root package name */
    public String f81634s;

    /* renamed from: t  reason: collision with root package name */
    public d0 f81635t;

    /* renamed from: u  reason: collision with root package name */
    public double f81636u;

    /* renamed from: v  reason: collision with root package name */
    public double f81637v;

    /* renamed from: w  reason: collision with root package name */
    public int f81638w = 2;

    /* renamed from: x  reason: collision with root package name */
    public boolean f81639x = false;

    /* renamed from: y  reason: collision with root package name */
    public final MarketDepthListener f81640y = new c();

    public class a extends BaseEasySubscriber<Object> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Runnable f81641g;

        public a(Runnable runnable) {
            this.f81641g = runnable;
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            HuobiToastUtil.m(aPIStatusErrorException.getErrMsg());
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            this.f81641g.run();
        }
    }

    public class b extends q6.d<Boolean> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ContractOrderPlace f81643e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ContractOrderPlace f81644f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(g gVar, ContractOrderPlace contractOrderPlace, ContractOrderPlace contractOrderPlace2) {
            super(gVar);
            this.f81643e = contractOrderPlace;
            this.f81644f = contractOrderPlace2;
        }

        /* renamed from: f */
        public void onNext(Boolean bool) {
            super.onNext(bool);
            boolean unused = SwapHoldStopDialogFragment.this.f81639x = true;
            if (bool.booleanValue()) {
                SwapHoldStopDialogFragment.this.ii();
            } else {
                SwapHoldStopDialogFragment.this.ci(this.f81643e, this.f81644f);
            }
        }
    }

    public class c extends MarketDepthListener {
        public c() {
        }

        /* renamed from: j */
        public void f(MarketDepthResponse marketDepthResponse) {
            if (marketDepthResponse != null && SwapHoldStopDialogFragment.this.f81632q != null && marketDepthResponse.getSymbol().equals(SwapHoldStopDialogFragment.this.f81632q.getContractShortType())) {
                TradeBuySellData tick = marketDepthResponse.getTick();
                List<Double[]> asks = tick.getAsks();
                List<Double[]> bids = tick.getBids();
                SwapHoldStopDialogFragment.this.li(asks, 1);
                SwapHoldStopDialogFragment.this.li(bids, 0);
                l9.a.a().F(false, SwapHoldStopDialogFragment.this.f81632q.getContractShortType(), SwapDepthType.STEP6, SwapHoldStopDialogFragment.this.f81640y);
            }
        }
    }

    public class d extends FutureTpSlHelper {

        public class a implements FutureTpSlHelper.i {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ SwapHoldStopDialogFragment f81648a;

            public a(SwapHoldStopDialogFragment swapHoldStopDialogFragment) {
                this.f81648a = swapHoldStopDialogFragment;
            }

            public String E0() {
                return SwapHoldStopDialogFragment.this.f81632q.getContractCode();
            }

            public void a() {
                SwapHoldStopDialogFragment.this.th();
            }

            public boolean b(EditText editText, Editable editable) {
                return FutureTpSlFuturesHelper.d(editText, editable, SwapHoldStopDialogFragment.this.f81634s, d.this.U0());
            }

            public BigDecimal c(String str, int i11) {
                return FutureTpSlFuturesHelper.k(str, getTradePricePrecision(), SwapHoldStopDialogFragment.this.f81633r.getCostOpen(), SwapHoldStopDialogFragment.this.Zh(), SwapHoldStopDialogFragment.this.ai());
            }

            public String d(String str, boolean z11, BigDecimal bigDecimal) {
                return FutureTpSlFuturesHelper.e(str, SwapHoldStopDialogFragment.this.f81633r.getAvailable(), SwapHoldStopDialogFragment.this.f81632q.getContractFace(), SwapHoldStopDialogFragment.this.f81633r.getCostOpen(), SwapHoldStopDialogFragment.this.Zh(), SwapHoldStopDialogFragment.this.f81632q.getContractCode(), bigDecimal);
            }

            public FutureTpSlFuturesHelper.a e(int i11, String str, boolean z11) {
                return SwapHoldStopDialogFragment.this.di(i11, str, z11);
            }

            public String f() {
                return SwapHoldStopDialogFragment.this.Vh();
            }

            public BigDecimal g(String str, boolean z11, BigDecimal bigDecimal) {
                if (TextUtils.isEmpty(str)) {
                    return BigDecimal.ZERO;
                }
                BigDecimal a11 = m.a(str);
                BigDecimal h11 = FutureTpSlFuturesHelper.h(m.a(SwapHoldStopDialogFragment.this.f81632q.getContractFace()), bigDecimal.multiply(m.a(SwapHoldStopDialogFragment.this.f81633r.getAvailable())), SwapHoldStopDialogFragment.this.Zh(), m.a(SwapHoldStopDialogFragment.this.f81633r.getCostOpen()), a11, TradeType.SWAP);
                if (h11 == null || h11.compareTo(BigDecimal.ZERO) <= 0) {
                    return BigDecimal.ZERO;
                }
                return h11.setScale(i.m(SwapHoldStopDialogFragment.this.f81634s), 1);
            }

            public Activity getActivity() {
                return SwapHoldStopDialogFragment.this.getActivity();
            }

            public String getQuoteCurrency() {
                return SwapHoldStopDialogFragment.this.getString(R.string.usd_en_uppercase);
            }

            public int getTradePricePrecision() {
                return i.m(SwapHoldStopDialogFragment.this.f81633r.getSymbol());
            }

            public String h(String str, int i11) {
                return FutureTpSlFuturesHelper.j(str, i.m(SwapHoldStopDialogFragment.this.f81634s), SwapHoldStopDialogFragment.this.f81633r.getCostOpen(), SwapHoldStopDialogFragment.this.f81633r.getLeverRate(), SwapHoldStopDialogFragment.this.Zh(), SwapHoldStopDialogFragment.this.ai(), TradeType.SWAP);
            }

            public String o0() {
                return SwapHoldStopDialogFragment.this.o0();
            }
        }

        public d() {
            y1(TradeType.SWAP, new a(SwapHoldStopDialogFragment.this));
        }
    }

    public class e extends EasySubscriber<Object> {

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                SwapHoldStopDialogFragment.this.dismiss();
            }
        }

        public e() {
        }

        public void onAfter() {
            super.onAfter();
            SwapHoldStopDialogFragment.this.f81627l.setVisibility(8);
            SwapHoldStopDialogFragment.this.f81628m.d();
            SwapHoldStopDialogFragment.this.f81625j.setEnabled(true);
        }

        public void onError2(Throwable th2) {
            if (!NetworkStatus.c(BaseApplication.b())) {
                HuobiToastUtil.j(R.string.n_no_network);
            } else {
                HuobiToastUtil.k(BaseApplication.b(), R.string.string_order_op_fail);
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            aPIStatusErrorException.getErrCode().hashCode();
            if (TextUtils.isEmpty(aPIStatusErrorException.getErrMsg())) {
                HuobiToastUtil.k(j.c(), R.string.string_order_op_fail);
            } else {
                HuobiToastUtil.l(j.c(), aPIStatusErrorException.getErrMsg());
            }
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            HuobiToastUtil.t(j.c(), R.string.string_order_op_ok);
            s6.a.b(j.c()).c(R.raw.order_success);
            EventBus.d().k(new ContractAssetAndOrderUpdateEvent());
            i6.i.b().g(new a(), 10);
        }

        public void onStart() {
            super.onStart();
            SwapHoldStopDialogFragment.this.f81627l.setVisibility(0);
            SwapHoldStopDialogFragment.this.f81625j.setEnabled(false);
            SwapHoldStopDialogFragment.this.f81628m.c();
        }

        public /* synthetic */ e(SwapHoldStopDialogFragment swapHoldStopDialogFragment, a aVar) {
            this();
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$1(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        Th(this.f43197g == 0 ? this.f43195e : this.f43196f);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initView$0(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public String R0() {
        SwapPosition swapPosition = this.f81633r;
        if (swapPosition == null) {
            return "";
        }
        return swapPosition.getOrderId();
    }

    public void Rh(String str, Runnable runnable) {
        l9.a.a().y(this.f81633r.getContractCode(), str).b().delay(300, TimeUnit.MILLISECONDS).compose(RxJavaHelper.t((g) null)).compose(RxJavaHelper.t((g) null)).subscribe(new a(runnable));
    }

    /* renamed from: Sh */
    public final void ci(ContractOrderPlace contractOrderPlace, ContractOrderPlace contractOrderPlace2) {
        ContractOrderPlace contractOrderPlace3 = new ContractOrderPlace();
        if (contractOrderPlace != null) {
            contractOrderPlace3.Q0(contractOrderPlace.J());
            contractOrderPlace3.p0(contractOrderPlace.l());
            contractOrderPlace3.c1(contractOrderPlace.W());
            contractOrderPlace3.R0(contractOrderPlace.K());
            contractOrderPlace3.S0(contractOrderPlace.L());
            contractOrderPlace3.O0(contractOrderPlace.H());
            contractOrderPlace3.Q0(contractOrderPlace.J());
        }
        if (contractOrderPlace2 != null) {
            contractOrderPlace3.K0(contractOrderPlace2.D());
            contractOrderPlace3.p0(contractOrderPlace2.l());
            contractOrderPlace3.c1(contractOrderPlace2.W());
            contractOrderPlace3.L0(contractOrderPlace2.E());
            contractOrderPlace3.M0(contractOrderPlace2.F());
            contractOrderPlace3.I0(contractOrderPlace2.B());
            contractOrderPlace3.K0(contractOrderPlace2.D());
        }
        this.f81635t.r(contractOrderPlace3, this.f81632q).subscribe(new e(this, (a) null));
    }

    public final void Th(FutureTpSlHelper futureTpSlHelper) {
        ContractOrderPlace contractOrderPlace;
        ContractOrderPlace contractOrderPlace2;
        String str;
        String str2;
        String str3 = null;
        if (futureTpSlHelper.q0()) {
            is.a.j("5168", (Map<String, Object>) null, is.a.f(TradeType.LINEAR_SWAP));
        }
        if (futureTpSlHelper.p0()) {
            is.a.j("5170", (Map<String, Object>) null, is.a.f(TradeType.LINEAR_SWAP));
        }
        if (this.f81633r != null) {
            String obj = futureTpSlHelper.l0().getText().toString();
            double Wh = Wh();
            if (futureTpSlHelper.g0(this.f81633r.getLastPrice()) && futureTpSlHelper.e0() && futureTpSlHelper.c0(obj)) {
                uh();
                if (BigDecimal.valueOf(Wh).compareTo(BigDecimal.ZERO) == 0) {
                    HuobiToastUtil.j(R.string.string_network_disconnect);
                    return;
                }
                if (futureTpSlHelper.q0()) {
                    contractOrderPlace = ji(futureTpSlHelper, futureTpSlHelper.u0(), obj, 2, futureTpSlHelper.w0(), 0);
                } else {
                    contractOrderPlace = null;
                }
                if (contractOrderPlace == null || contractOrderPlace.Y()) {
                    if (futureTpSlHelper.p0()) {
                        contractOrderPlace2 = ji(futureTpSlHelper, futureTpSlHelper.t0(), obj, 2, futureTpSlHelper.v0(), 1);
                    } else {
                        contractOrderPlace2 = null;
                    }
                    if (contractOrderPlace2 == null || contractOrderPlace2.Y()) {
                        if (futureTpSlHelper.q0()) {
                            if (m.a(contractOrderPlace.W()).compareTo(m.a(this.f81633r.getAvailable())) > 0) {
                                HuobiToastUtil.j(R.string.contract_trade_close_available_not_enough);
                                return;
                            }
                        } else if (m.a(contractOrderPlace2.W()).compareTo(m.a(this.f81633r.getAvailable())) > 0) {
                            HuobiToastUtil.j(R.string.contract_trade_close_available_not_enough);
                            return;
                        }
                        SwapPosition swapPosition = this.f81633r;
                        String sh2 = sh(swapPosition.tpOrderId, swapPosition.slOrderId);
                        if (!TextUtils.isEmpty(sh2)) {
                            Rh(sh2, new n(this, contractOrderPlace, contractOrderPlace2));
                        } else if (!TextUtils.isEmpty(this.f81633r.getTpslOrderType())) {
                            Rh(this.f81633r.getOrderId(), new o(this, contractOrderPlace, contractOrderPlace2));
                        } else if (!this.f81639x) {
                            if (contractOrderPlace != null) {
                                str = contractOrderPlace.W();
                                str2 = contractOrderPlace.S();
                            } else {
                                str = null;
                                str2 = null;
                            }
                            if (contractOrderPlace2 != null) {
                                str = contractOrderPlace2.W();
                                str3 = contractOrderPlace2.S();
                            }
                            ei(str, str2, str3, contractOrderPlace, contractOrderPlace2);
                        } else {
                            ci(contractOrderPlace, contractOrderPlace2);
                        }
                    }
                }
            }
        }
    }

    public String Uh() {
        SwapPosition swapPosition = this.f81633r;
        if (swapPosition == null) {
            return null;
        }
        return swapPosition.getContractCode();
    }

    public String Vh() {
        SwapPosition swapPosition = this.f81633r;
        if (swapPosition == null) {
            return null;
        }
        return swapPosition.getDirection();
    }

    public final double Wh() {
        double d11;
        try {
            d11 = Double.parseDouble(this.f81633r.getLastPrice());
        } catch (Exception unused) {
            d11 = 0.0d;
        }
        if (d11 != 0.0d) {
            return d11;
        }
        if (w2()) {
            double d12 = this.f81637v;
            if (d12 != 0.0d) {
                return d12;
            }
        } else {
            double d13 = this.f81636u;
            if (d13 != 0.0d) {
                return d13;
            }
        }
        return d11;
    }

    public SwapPosition Xh() {
        return this.f81633r;
    }

    public boolean Yh() {
        SwapPosition swapPosition = this.f81633r;
        if (swapPosition == null) {
            return false;
        }
        if (swapPosition.getTpslOrderType().equals("sl") || this.f81633r.getTpslOrderType().equals("tp")) {
            return true;
        }
        return false;
    }

    public final boolean Zh() {
        return this.f81633r == null || "buy".equalsIgnoreCase(Vh());
    }

    public void addEvent(r rVar) {
        this.f81626k.setOnClickListener(new l(this));
        this.f81625j.setOnClickListener(new ts.m(this));
    }

    public void afterInit() {
        fi(this.f81633r);
        if (this.f81632q != null) {
            l9.a.a().F(true, this.f81632q.getContractShortType(), SwapDepthType.STEP6, this.f81640y);
        }
    }

    public final boolean ai() {
        return this.f81638w == 2;
    }

    public final FutureTpSlFuturesHelper.a di(int i11, String str, boolean z11) {
        String available = this.f81633r.getAvailable();
        String lastPrice = this.f81633r.getLastPrice();
        String contractFace = this.f81632q.getContractFace();
        BigDecimal a11 = m.a(available);
        int c11 = i.c(o0());
        BigDecimal valueOf = BigDecimal.valueOf((long) i11);
        if (z11) {
            return FutureTpSlFuturesHelper.g(TradeType.SWAP, this.f81632q.getContractFace(), a11, o0(), valueOf, this.f81633r.getLastPrice(), c11);
        }
        if (TextUtils.isEmpty(str)) {
            valueOf = BigDecimal.ZERO;
        } else {
            TradeType tradeType = TradeType.SWAP;
            if (a7.e.E(tradeType)) {
                BigDecimal bigDecimal = new BigDecimal(FutureUnitUtil.d(available, lastPrice, contractFace, tradeType));
                BigDecimal bigDecimal2 = new BigDecimal(str);
                if (bigDecimal.compareTo(BigDecimal.ZERO) > 0) {
                    valueOf = bigDecimal2.divide(bigDecimal, 32, 0);
                }
            } else {
                BigDecimal bigDecimal3 = new BigDecimal(str);
                BigDecimal bigDecimal4 = new BigDecimal(m.m(available, i.z(this.f81634s)));
                if (bigDecimal4.compareTo(BigDecimal.ZERO) > 0) {
                    valueOf = bigDecimal3.divide(bigDecimal4, 32, 0);
                }
            }
        }
        return new FutureTpSlFuturesHelper.a((String) null, valueOf);
    }

    public final void ei(String str, String str2, String str3, ContractOrderPlace contractOrderPlace, ContractOrderPlace contractOrderPlace2) {
        l9.a.a().o(this.f81632q.getContractCode(), w2() ? "sell" : "buy", str, str2, str3).b().compose(RxJavaHelper.t((g) null)).subscribe(new b((g) null, contractOrderPlace, contractOrderPlace2));
    }

    public final void fi(SwapPosition swapPosition) {
        if (swapPosition != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getActivity(), R.color.global_main_text_color)), 0, spannableStringBuilder.length(), 33);
            this.f81623h.setText(spannableStringBuilder.append(us.j.e(swapPosition.getSymbol(), swapPosition.getDirection(), swapPosition.getLeverRate(), getActivity())));
        }
    }

    public void gi(SwapPosition swapPosition, SwapCurrencyInfo swapCurrencyInfo) {
        this.f81633r = swapPosition;
        this.f81632q = swapCurrencyInfo;
        if (swapPosition != null) {
            this.f81634s = swapPosition.getSymbol();
        }
    }

    public void hi(int i11) {
        this.f81638w = i11;
    }

    public final void ii() {
        new DialogUtils.b.d(getActivity()).f1(false).C0(getContext().getString(R.string.n_contract_tpsl_tips)).q0(false).P0(getContext().getString(R.string.n_known)).Q0(cn.n.f13170a).j0().show(getActivity().getSupportFragmentManager(), "");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x01e1  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x01e4  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x02c4  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x02c7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initView(i6.r r26) {
        /*
            r25 = this;
            r0 = r25
            r1 = r26
            super.initView(r26)
            r2 = 2131429145(0x7f0b0719, float:1.8479954E38)
            android.view.View r2 = r1.b(r2)
            ts.k r3 = new ts.k
            r3.<init>(r0)
            r2.setOnClickListener(r3)
            r2 = 2131429147(0x7f0b071b, float:1.8479959E38)
            android.view.View r2 = r1.b(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r0.f81623h = r2
            r2 = 2131429122(0x7f0b0702, float:1.8479908E38)
            android.view.View r2 = r1.b(r2)
            r0.f81626k = r2
            r2 = 2131429148(0x7f0b071c, float:1.847996E38)
            android.view.View r2 = r1.b(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r0.f81624i = r2
            r2 = 2131429198(0x7f0b074e, float:1.8480062E38)
            android.view.View r2 = r1.b(r2)
            r0.f81625j = r2
            r2.bringToFront()
            r2 = 2131429192(0x7f0b0748, float:1.848005E38)
            android.view.View r2 = r1.b(r2)
            r0.f81627l = r2
            r2 = 2131432548(0x7f0b1464, float:1.8486857E38)
            android.view.View r2 = r1.b(r2)
            com.hbg.lib.widgets.LoadingView r2 = (com.hbg.lib.widgets.LoadingView) r2
            r0.f81628m = r2
            r3 = 2131951711(0x7f13005f, float:1.9539844E38)
            r2.setLottieAnimationRes(r3)
            qs.d0 r2 = new qs.d0
            r3 = 0
            r2.<init>(r3)
            r0.f81635t = r2
            com.hbg.lib.network.swap.core.bean.SwapPosition r3 = r0.f81633r
            if (r3 == 0) goto L_0x0089
            com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo r3 = r0.f81632q
            if (r3 == 0) goto L_0x0089
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo r4 = r0.f81632q
            java.lang.String r4 = r4.getContractCode()
            r3.append(r4)
            java.lang.String r4 = r25.Vh()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.hbg.lib.network.swap.core.bean.SwapPosition r4 = r0.f81633r
            r2.W(r3, r4)
        L_0x0089:
            r2 = 2131433228(0x7f0b170c, float:1.8488236E38)
            android.view.View r2 = r1.b(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r0.f81629n = r2
            r2 = 2131431884(0x7f0b11cc, float:1.848551E38)
            android.view.View r2 = r1.b(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r0.f81630o = r2
            r2 = 2131429306(0x7f0b07ba, float:1.848028E38)
            android.view.View r2 = r1.b(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r0.f81631p = r2
            r2 = 2131431883(0x7f0b11cb, float:1.8485508E38)
            android.view.View r2 = r1.b(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            android.content.res.Resources r3 = r25.getResources()
            r4 = 2132018925(0x7f1406ed, float:1.967617E38)
            r5 = 1
            java.lang.Object[] r6 = new java.lang.Object[r5]
            android.content.res.Resources r7 = r25.getResources()
            r8 = 2132027474(0x7f142852, float:1.969351E38)
            java.lang.String r7 = r7.getString(r8)
            r9 = 0
            r6[r9] = r7
            java.lang.String r3 = r3.getString(r4, r6)
            r2.setText(r3)
            r2 = 2131429305(0x7f0b07b9, float:1.8480279E38)
            android.view.View r2 = r1.b(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            android.content.res.Resources r3 = r25.getResources()
            r4 = 2132022730(0x7f1415ca, float:1.9683888E38)
            java.lang.Object[] r6 = new java.lang.Object[r5]
            android.content.res.Resources r7 = r25.getResources()
            java.lang.String r7 = r7.getString(r8)
            r6[r9] = r7
            java.lang.String r3 = r3.getString(r4, r6)
            r2.setText(r3)
            com.hbg.lib.network.swap.core.bean.SwapPosition r2 = r0.f81633r
            com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo r3 = r0.f81632q
            r0.ni(r2, r3)
            r2 = 2131433691(0x7f0b18db, float:1.8489175E38)
            android.view.View r2 = r1.b(r2)
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            com.hbg.lib.network.swap.core.bean.SwapPosition r3 = r0.f81633r
            java.lang.String r3 = r3.getTpslOrderType()
            java.lang.String r4 = "sl"
            boolean r3 = r4.equals(r3)
            java.lang.String r4 = "_"
            r6 = 2131427594(0x7f0b010a, float:1.8476809E38)
            java.lang.String r7 = "tpsl_position_trigger"
            java.lang.String r8 = "market"
            r10 = 2131432509(0x7f0b143d, float:1.8486777E38)
            java.lang.String r11 = "3"
            java.lang.String r12 = "0"
            r13 = 8
            if (r3 == 0) goto L_0x01fb
            r2.setVisibility(r13)
            com.hbg.lib.widgets.CommonTextListIndicator r2 = r0.f43192b
            r2.setVisibility(r13)
            com.hbg.lib.network.swap.core.bean.SwapPosition r2 = r0.f81633r
            java.lang.String r2 = r2.getTriggerPrice()
            com.hbg.lib.network.swap.core.bean.SwapPosition r3 = r0.f81633r
            java.lang.String r3 = r3.getSymbol()
            int r3 = us.i.m(r3)
            java.lang.String r2 = i6.m.m(r2, r3)
            com.huobi.contract.entity.PriceType r3 = com.huobi.contract.entity.PriceType.LIMIT
            com.hbg.lib.network.swap.core.bean.SwapPosition r14 = r0.f81633r
            java.lang.String r14 = r14.getOrderPriceType()
            boolean r8 = android.text.TextUtils.equals(r14, r8)
            if (r8 == 0) goto L_0x0161
            com.huobi.contract.entity.PriceType r3 = com.huobi.contract.entity.PriceType.MARKET
            r0.wh(r9, r13)
            android.view.View r1 = r1.b(r10)
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            com.huobi.feature.util.FutureTpSlHelper.H0(r1)
        L_0x015d:
            r24 = r3
            goto L_0x01d3
        L_0x0161:
            com.hbg.lib.network.swap.core.bean.SwapPosition r8 = r0.f81633r
            java.lang.String r8 = r8.getOrderPriceType()
            boolean r7 = android.text.TextUtils.equals(r8, r7)
            if (r7 == 0) goto L_0x01a4
            com.huobi.contract.entity.PriceType r3 = com.huobi.contract.entity.PriceType.MARKET
            r0.wh(r5, r13)
            android.view.View r1 = r1.b(r6)
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            com.huobi.feature.util.FutureTpSlHelper.H0(r1)
            com.huobi.feature.util.FutureTpSlHelper r14 = r0.f43196f
            r17 = 0
            r18 = 0
            com.hbg.lib.network.swap.core.bean.SwapPosition r1 = r0.f81633r
            boolean r1 = r1.isMarkPriceType()
            if (r1 == 0) goto L_0x018c
            r20 = r11
            goto L_0x018e
        L_0x018c:
            r20 = r12
        L_0x018e:
            com.hbg.lib.network.swap.core.bean.SwapPosition r1 = r0.f81633r
            java.lang.String r22 = r1.getOrderPrice()
            java.lang.String r15 = ""
            java.lang.String r19 = ""
            java.lang.String r21 = ""
            r16 = r2
            r23 = r3
            r24 = r3
            r14.L0(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            goto L_0x01d3
        L_0x01a4:
            com.hbg.lib.network.swap.core.bean.SwapPosition r5 = r0.f81633r
            java.lang.String r5 = r5.getOrderPriceType()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x015d
            com.hbg.lib.network.swap.core.bean.SwapPosition r5 = r0.f81633r
            java.lang.String r5 = r5.getOrderPriceType()
            boolean r4 = r5.contains(r4)
            if (r4 == 0) goto L_0x015d
            com.hbg.lib.network.swap.core.bean.SwapPosition r3 = r0.f81633r
            java.lang.String r3 = r3.getOrderPriceType()
            com.huobi.contract.entity.PriceType r3 = com.huobi.contract.entity.PriceType.getPriceType(r3)
            r0.wh(r9, r13)
            android.view.View r1 = r1.b(r10)
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            com.huobi.feature.util.FutureTpSlHelper.H0(r1)
            goto L_0x015d
        L_0x01d3:
            com.huobi.feature.util.FutureTpSlHelper r14 = r0.f43195e
            r17 = 0
            r18 = 0
            com.hbg.lib.network.swap.core.bean.SwapPosition r1 = r0.f81633r
            boolean r1 = r1.isMarkPriceType()
            if (r1 == 0) goto L_0x01e4
            r20 = r11
            goto L_0x01e6
        L_0x01e4:
            r20 = r12
        L_0x01e6:
            com.hbg.lib.network.swap.core.bean.SwapPosition r1 = r0.f81633r
            java.lang.String r22 = r1.getOrderPrice()
            java.lang.String r15 = ""
            java.lang.String r19 = ""
            java.lang.String r21 = ""
            r16 = r2
            r23 = r24
            r14.L0(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            goto L_0x031d
        L_0x01fb:
            com.hbg.lib.network.swap.core.bean.SwapPosition r3 = r0.f81633r
            java.lang.String r3 = r3.getTpslOrderType()
            java.lang.String r14 = "tp"
            boolean r3 = r14.equals(r3)
            if (r3 == 0) goto L_0x02dc
            r2.setVisibility(r13)
            com.hbg.lib.widgets.CommonTextListIndicator r2 = r0.f43192b
            r2.setVisibility(r13)
            com.hbg.lib.network.swap.core.bean.SwapPosition r2 = r0.f81633r
            java.lang.String r2 = r2.getTriggerPrice()
            com.hbg.lib.network.swap.core.bean.SwapPosition r3 = r0.f81633r
            java.lang.String r3 = r3.getSymbol()
            int r3 = us.i.m(r3)
            java.lang.String r2 = i6.m.m(r2, r3)
            com.huobi.contract.entity.PriceType r3 = com.huobi.contract.entity.PriceType.LIMIT
            com.hbg.lib.network.swap.core.bean.SwapPosition r14 = r0.f81633r
            java.lang.String r14 = r14.getOrderPriceType()
            boolean r8 = android.text.TextUtils.equals(r14, r8)
            if (r8 == 0) goto L_0x0245
            com.huobi.contract.entity.PriceType r3 = com.huobi.contract.entity.PriceType.MARKET
            r0.wh(r9, r13)
            android.view.View r1 = r1.b(r10)
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            com.huobi.feature.util.FutureTpSlHelper.H0(r1)
        L_0x0241:
            r24 = r3
            goto L_0x02b6
        L_0x0245:
            com.hbg.lib.network.swap.core.bean.SwapPosition r8 = r0.f81633r
            java.lang.String r8 = r8.getOrderPriceType()
            boolean r7 = android.text.TextUtils.equals(r8, r7)
            if (r7 == 0) goto L_0x0287
            com.huobi.contract.entity.PriceType r3 = com.huobi.contract.entity.PriceType.MARKET
            r0.wh(r5, r13)
            android.view.View r1 = r1.b(r6)
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            com.huobi.feature.util.FutureTpSlHelper.H0(r1)
            com.huobi.feature.util.FutureTpSlHelper r14 = r0.f43196f
            r17 = 0
            r18 = 0
            com.hbg.lib.network.swap.core.bean.SwapPosition r1 = r0.f81633r
            boolean r1 = r1.isMarkPriceType()
            if (r1 == 0) goto L_0x0270
            r19 = r11
            goto L_0x0272
        L_0x0270:
            r19 = r12
        L_0x0272:
            com.hbg.lib.network.swap.core.bean.SwapPosition r1 = r0.f81633r
            java.lang.String r21 = r1.getOrderPrice()
            java.lang.String r16 = ""
            java.lang.String r20 = ""
            java.lang.String r22 = ""
            r15 = r2
            r23 = r3
            r24 = r3
            r14.L0(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            goto L_0x02b6
        L_0x0287:
            com.hbg.lib.network.swap.core.bean.SwapPosition r5 = r0.f81633r
            java.lang.String r5 = r5.getOrderPriceType()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x0241
            com.hbg.lib.network.swap.core.bean.SwapPosition r5 = r0.f81633r
            java.lang.String r5 = r5.getOrderPriceType()
            boolean r4 = r5.contains(r4)
            if (r4 == 0) goto L_0x0241
            com.hbg.lib.network.swap.core.bean.SwapPosition r3 = r0.f81633r
            java.lang.String r3 = r3.getOrderPriceType()
            com.huobi.contract.entity.PriceType r3 = com.huobi.contract.entity.PriceType.getPriceType(r3)
            r0.wh(r9, r13)
            android.view.View r1 = r1.b(r10)
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            com.huobi.feature.util.FutureTpSlHelper.H0(r1)
            goto L_0x0241
        L_0x02b6:
            com.huobi.feature.util.FutureTpSlHelper r14 = r0.f43195e
            r17 = 0
            r18 = 0
            com.hbg.lib.network.swap.core.bean.SwapPosition r1 = r0.f81633r
            boolean r1 = r1.isMarkPriceType()
            if (r1 == 0) goto L_0x02c7
            r19 = r11
            goto L_0x02c9
        L_0x02c7:
            r19 = r12
        L_0x02c9:
            com.hbg.lib.network.swap.core.bean.SwapPosition r1 = r0.f81633r
            java.lang.String r21 = r1.getOrderPrice()
            java.lang.String r16 = ""
            java.lang.String r20 = ""
            java.lang.String r22 = ""
            r15 = r2
            r23 = r24
            r14.L0(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            goto L_0x031d
        L_0x02dc:
            r2.setVisibility(r9)
            com.hbg.lib.widgets.CommonTextListIndicator r1 = r0.f43192b
            r1.setVisibility(r9)
            int r1 = r0.f43197g
            r2 = 4
            r0.wh(r1, r2)
            com.huobi.feature.util.FutureTpSlHelper r13 = r0.f43196f
            com.hbg.lib.network.swap.core.bean.SwapPosition r1 = r0.f81633r
            java.lang.String r14 = r1.tpTriggerPrice
            java.lang.String r15 = r1.slTriggerPrice
            r16 = 0
            r17 = 0
            java.lang.String r2 = r1.tpTriggerType
            boolean r1 = r1.isMarkPriceType(r2)
            if (r1 == 0) goto L_0x0301
            r18 = r11
            goto L_0x0303
        L_0x0301:
            r18 = r12
        L_0x0303:
            com.hbg.lib.network.swap.core.bean.SwapPosition r1 = r0.f81633r
            java.lang.String r2 = r1.slTriggerType
            boolean r1 = r1.isMarkPriceType(r2)
            if (r1 == 0) goto L_0x0310
            r19 = r11
            goto L_0x0312
        L_0x0310:
            r19 = r12
        L_0x0312:
            com.huobi.contract.entity.PriceType r23 = com.huobi.contract.entity.PriceType.MARKET
            java.lang.String r20 = ""
            java.lang.String r21 = ""
            r22 = r23
            r13.L0(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
        L_0x031d:
            com.huobi.feature.util.FutureTpSlHelper r1 = r0.f43195e
            r1.K0()
            com.huobi.feature.util.FutureTpSlHelper r1 = r0.f43196f
            r1.K0()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.swap.ui.SwapHoldStopDialogFragment.initView(i6.r):void");
    }

    public ContractOrderPlace ji(FutureTpSlHelper futureTpSlHelper, String str, String str2, int i11, int i12, int i13) {
        if (i12 != 1) {
            if (w2()) {
                str = BigDecimal.valueOf(this.f81637v).toPlainString();
            } else {
                str = BigDecimal.valueOf(this.f81636u).toPlainString();
            }
        }
        ContractOrderPlace contractOrderPlace = new ContractOrderPlace();
        contractOrderPlace.N0(this.f81634s);
        contractOrderPlace.B0(str);
        futureTpSlHelper.F1(i13, contractOrderPlace);
        String E0 = futureTpSlHelper.E0(i13);
        String F0 = futureTpSlHelper.F0(i13);
        String r02 = futureTpSlHelper.r0(i13);
        if (i13 == 0) {
            contractOrderPlace.R0(E0);
            contractOrderPlace.O0(F0);
            contractOrderPlace.Q0(r02);
            if (futureTpSlHelper.X0()) {
                contractOrderPlace.S0("3");
            }
        } else {
            contractOrderPlace.L0(E0);
            contractOrderPlace.I0(F0);
            contractOrderPlace.K0(r02);
            if (futureTpSlHelper.W0()) {
                contractOrderPlace.M0("3");
            }
        }
        contractOrderPlace.y0(1);
        contractOrderPlace.d0(str2);
        contractOrderPlace.h0(w2());
        contractOrderPlace.A0(i11);
        contractOrderPlace.X0(i12);
        contractOrderPlace.g0(5);
        contractOrderPlace.f0(futureTpSlHelper.x0());
        if (w2()) {
            contractOrderPlace.W0(getString(R.string.contract_trade_buy_flat_empty));
        } else {
            contractOrderPlace.W0(getString(R.string.contract_trade_sell_flat_more));
        }
        SwapPosition swapPosition = this.f81633r;
        if (swapPosition != null) {
            contractOrderPlace.s0(swapPosition.getLeverRate());
        }
        futureTpSlHelper.A1(i13, contractOrderPlace);
        return this.f81635t.x(getContext(), contractOrderPlace, this.f81632q);
    }

    public final void ki() {
        if (!a7.e.E(TradeType.SWAP)) {
            String m11 = m.m(this.f81633r.getAvailable(), 0);
            qi(this.f81624i, String.format(getActivity().getString(R.string.n_contract_trade_close_margin_available), new Object[]{m11, getActivity().getString(R.string.contract_market_vol_sheet)}), 0);
        } else if (m.a(this.f81633r.getLastPrice()).compareTo(BigDecimal.ZERO) <= 0) {
            qi(this.f81624i, "", 4);
        } else {
            String plainString = m.a(this.f81633r.getAvailable()).multiply(m.a(this.f81632q.getContractFace())).divide(m.a(this.f81633r.getLastPrice()), i.c(this.f81634s), 1).toPlainString();
            qi(this.f81624i, String.format(getActivity().getString(R.string.n_contract_trade_close_margin_available), new Object[]{plainString, this.f81634s}), 0);
        }
    }

    public final void li(List<Double[]> list, int i11) {
        if (list == null || list.isEmpty()) {
            if (i11 == 0) {
                this.f81636u = 0.0d;
            } else {
                this.f81637v = 0.0d;
            }
        } else if (i11 == 0) {
            this.f81636u = list.get(0)[0].doubleValue();
        } else {
            this.f81637v = list.get(0)[0].doubleValue();
        }
    }

    public void mi() {
        SwapPosition swapPosition = this.f81633r;
        if (swapPosition != null) {
            oi(swapPosition);
            pi(this.f81633r);
        }
        ki();
    }

    public void ni(SwapPosition swapPosition, SwapCurrencyInfo swapCurrencyInfo) {
        gi(swapPosition, swapCurrencyInfo);
        if (swapPosition != null) {
            oi(swapPosition);
            pi(swapPosition);
        }
        ki();
    }

    public final String o0() {
        return this.f81634s;
    }

    public final void oi(SwapPosition swapPosition) {
        int m11 = i.m(swapPosition.getSymbol());
        this.f81629n.setText(m.m(swapPosition.getCostOpen(), m11));
        this.f81630o.setText(m.m(swapPosition.getLastPrice(), m11));
    }

    public final void pi(SwapPosition swapPosition) {
        this.f81631p.setText(m.q(m.a(swapPosition.getLiquidationPrice()), FuturePrecisionUtil.y(swapPosition.getContractCode(), swapPosition.getContractShortType(), (String) null)));
    }

    public final void qi(TextView textView, String str, int i11) {
        if (!TextUtils.isEmpty(str)) {
            textView.setText(str);
        }
        textView.setVisibility(i11);
    }

    public void vh() {
        this.f43195e = new d();
        this.f43196f = new d();
    }

    public final boolean w2() {
        return !Zh();
    }
}
