package com.huobi.contract.ui;

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
import bj.d1;
import cn.n;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.future.util.FutureUnitUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.contract.core.util.ContractDepthType;
import com.hbg.lib.network.contract.retrofit.ContractRetrofit;
import com.hbg.lib.network.pro.socket.bean.TradeBuySellData;
import com.hbg.lib.network.pro.socket.listener.MarketDepthListener;
import com.hbg.lib.network.pro.socket.response.MarketDepthResponse;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseEasySubscriber;
import com.hbg.lib.widgets.LoadingView;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.contract.entity.ContractAssetAndOrderUpdateEvent;
import com.huobi.contract.entity.ContractOrderPlace;
import com.huobi.contract.entity.ContractPosition;
import com.huobi.feature.util.FutureTpSlFuturesHelper;
import com.huobi.feature.util.FutureTpSlHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import dj.p;
import dj.s;
import dj.t;
import ej.f;
import i6.i;
import i6.m;
import i6.r;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.EventBus;
import pro.huobi.R;
import u6.g;

public class ContractHoldStopDialogFragment extends ContractBaseHoldDialogFragment {

    /* renamed from: h  reason: collision with root package name */
    public TextView f43252h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f43253i;

    /* renamed from: j  reason: collision with root package name */
    public View f43254j;

    /* renamed from: k  reason: collision with root package name */
    public View f43255k;

    /* renamed from: l  reason: collision with root package name */
    public View f43256l;

    /* renamed from: m  reason: collision with root package name */
    public LoadingView f43257m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f43258n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f43259o;

    /* renamed from: p  reason: collision with root package name */
    public TextView f43260p;

    /* renamed from: q  reason: collision with root package name */
    public ContractCurrencyInfo f43261q;

    /* renamed from: r  reason: collision with root package name */
    public ContractPosition f43262r;

    /* renamed from: s  reason: collision with root package name */
    public String f43263s;

    /* renamed from: t  reason: collision with root package name */
    public d1 f43264t;

    /* renamed from: u  reason: collision with root package name */
    public double f43265u;

    /* renamed from: v  reason: collision with root package name */
    public double f43266v;

    /* renamed from: w  reason: collision with root package name */
    public int f43267w = 2;

    /* renamed from: x  reason: collision with root package name */
    public boolean f43268x = false;

    /* renamed from: y  reason: collision with root package name */
    public final MarketDepthListener f43269y = new c();

    public class a extends BaseEasySubscriber<Object> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Runnable f43270g;

        public a(Runnable runnable) {
            this.f43270g = runnable;
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            HuobiToastUtil.m(aPIStatusErrorException.getErrMsg());
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            this.f43270g.run();
        }
    }

    public class b extends q6.d<Boolean> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ContractOrderPlace f43272e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ContractOrderPlace f43273f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(g gVar, ContractOrderPlace contractOrderPlace, ContractOrderPlace contractOrderPlace2) {
            super(gVar);
            this.f43272e = contractOrderPlace;
            this.f43273f = contractOrderPlace2;
        }

        /* renamed from: f */
        public void onNext(Boolean bool) {
            super.onNext(bool);
            boolean unused = ContractHoldStopDialogFragment.this.f43268x = true;
            if (bool.booleanValue()) {
                ContractHoldStopDialogFragment.this.hi();
            } else {
                ContractHoldStopDialogFragment.this.bi(this.f43272e, this.f43273f);
            }
        }
    }

    public class c extends MarketDepthListener {
        public c() {
        }

        /* renamed from: j */
        public void f(MarketDepthResponse marketDepthResponse) {
            if (marketDepthResponse != null && ContractHoldStopDialogFragment.this.f43261q != null && marketDepthResponse.getSymbol().equals(ContractHoldStopDialogFragment.this.f43261q.getContractShortType())) {
                TradeBuySellData tick = marketDepthResponse.getTick();
                List<Double[]> asks = tick.getAsks();
                List<Double[]> bids = tick.getBids();
                ContractHoldStopDialogFragment.this.ki(asks, 1);
                ContractHoldStopDialogFragment.this.ki(bids, 0);
                q7.a.a().B(false, ContractHoldStopDialogFragment.this.f43261q.getContractShortType(), ContractDepthType.STEP6, ContractHoldStopDialogFragment.this.f43269y);
            }
        }
    }

    public class d extends FutureTpSlHelper {

        public class a implements FutureTpSlHelper.i {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ ContractHoldStopDialogFragment f43277a;

            public a(ContractHoldStopDialogFragment contractHoldStopDialogFragment) {
                this.f43277a = contractHoldStopDialogFragment;
            }

            public String E0() {
                return ContractHoldStopDialogFragment.this.f43261q.getContractCode();
            }

            public void a() {
                ContractHoldStopDialogFragment.this.th();
            }

            public boolean b(EditText editText, Editable editable) {
                return FutureTpSlFuturesHelper.b(editText, editable, ContractHoldStopDialogFragment.this.f43261q.getContractCode(), o0(), d.this.U0());
            }

            public BigDecimal c(String str, int i11) {
                return FutureTpSlFuturesHelper.k(str, getTradePricePrecision(), ContractHoldStopDialogFragment.this.f43262r.getCostOpen(), ContractHoldStopDialogFragment.this.Yh(), ContractHoldStopDialogFragment.this.Zh());
            }

            public String d(String str, boolean z11, BigDecimal bigDecimal) {
                return FutureTpSlFuturesHelper.e(str, ContractHoldStopDialogFragment.this.f43262r.getAvailable(), ContractHoldStopDialogFragment.this.f43261q.getContractFace(), ContractHoldStopDialogFragment.this.f43262r.getCostOpen(), ContractHoldStopDialogFragment.this.Yh(), ContractHoldStopDialogFragment.this.f43261q.getContractCode(), bigDecimal);
            }

            public FutureTpSlFuturesHelper.a e(int i11, String str, boolean z11) {
                return ContractHoldStopDialogFragment.this.ci(i11, str, z11);
            }

            public String f() {
                return ContractHoldStopDialogFragment.this.Uh();
            }

            public BigDecimal g(String str, boolean z11, BigDecimal bigDecimal) {
                if (TextUtils.isEmpty(str)) {
                    return BigDecimal.ZERO;
                }
                BigDecimal a11 = m.a(str);
                BigDecimal h11 = FutureTpSlFuturesHelper.h(m.a(ContractHoldStopDialogFragment.this.f43261q.getContractFace()), bigDecimal.multiply(m.a(ContractHoldStopDialogFragment.this.f43262r.getAvailable())), ContractHoldStopDialogFragment.this.Yh(), m.a(ContractHoldStopDialogFragment.this.f43262r.getCostOpen()), a11, TradeType.CONTRACT);
                if (h11 == null || h11.compareTo(BigDecimal.ZERO) <= 0) {
                    return BigDecimal.ZERO;
                }
                return h11.setScale(f.p(E0()), 1);
            }

            public Activity getActivity() {
                return ContractHoldStopDialogFragment.this.getActivity();
            }

            public String getQuoteCurrency() {
                return ContractHoldStopDialogFragment.this.getString(R.string.usd_en_uppercase);
            }

            public int getTradePricePrecision() {
                return f.p(ContractHoldStopDialogFragment.this.Th());
            }

            public String h(String str, int i11) {
                return FutureTpSlFuturesHelper.j(str, f.p(E0()), ContractHoldStopDialogFragment.this.f43262r.getCostOpen(), ContractHoldStopDialogFragment.this.f43262r.getLeverRate(), ContractHoldStopDialogFragment.this.Yh(), ContractHoldStopDialogFragment.this.Zh(), TradeType.CONTRACT);
            }

            public String o0() {
                return ContractHoldStopDialogFragment.this.o0();
            }
        }

        public d() {
            y1(TradeType.CONTRACT, new a(ContractHoldStopDialogFragment.this));
        }
    }

    public class e extends EasySubscriber<Object> {

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                ContractHoldStopDialogFragment.this.dismiss();
            }
        }

        public e() {
        }

        public void onAfter() {
            super.onAfter();
            ContractHoldStopDialogFragment.this.f43256l.setVisibility(8);
            ContractHoldStopDialogFragment.this.f43257m.d();
            ContractHoldStopDialogFragment.this.f43254j.setEnabled(true);
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
            i.b().g(new a(), 10);
        }

        public void onStart() {
            super.onStart();
            ContractHoldStopDialogFragment.this.f43256l.setVisibility(0);
            ContractHoldStopDialogFragment.this.f43254j.setEnabled(false);
            ContractHoldStopDialogFragment.this.f43257m.c();
        }

        public /* synthetic */ e(ContractHoldStopDialogFragment contractHoldStopDialogFragment, a aVar) {
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
        Sh(this.f43197g == 0 ? this.f43195e : this.f43196f);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initView$0(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void Qh(String str, Runnable runnable) {
        q7.a.a().A(this.f43262r.getSymbol(), str).b().compose(ContractRetrofit.g()).delay(300, TimeUnit.MILLISECONDS).compose(RxJavaHelper.t((g) null)).compose(RxJavaHelper.t((g) null)).subscribe(new a(runnable));
    }

    public String R0() {
        ContractPosition contractPosition = this.f43262r;
        if (contractPosition == null) {
            return "";
        }
        return contractPosition.getOrderId();
    }

    /* renamed from: Rh */
    public final void bi(ContractOrderPlace contractOrderPlace, ContractOrderPlace contractOrderPlace2) {
        ContractOrderPlace contractOrderPlace3 = new ContractOrderPlace();
        contractOrderPlace3.N0(o0());
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
        this.f43264t.r(contractOrderPlace3, this.f43261q).subscribe(new e(this, (a) null));
    }

    public final void Sh(FutureTpSlHelper futureTpSlHelper) {
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
        if (this.f43262r != null) {
            String obj = futureTpSlHelper.l0().getText().toString();
            double Wh = Wh();
            if (futureTpSlHelper.g0(this.f43262r.getLastPrice()) && futureTpSlHelper.e0() && futureTpSlHelper.c0(obj)) {
                uh();
                if (BigDecimal.valueOf(Wh).compareTo(BigDecimal.ZERO) == 0) {
                    HuobiToastUtil.j(R.string.string_network_disconnect);
                    return;
                }
                if (futureTpSlHelper.q0()) {
                    contractOrderPlace = ii(futureTpSlHelper, futureTpSlHelper.u0(), obj, 2, futureTpSlHelper.w0(), 0);
                } else {
                    contractOrderPlace = null;
                }
                if (contractOrderPlace == null || contractOrderPlace.Y()) {
                    if (futureTpSlHelper.p0()) {
                        contractOrderPlace2 = ii(futureTpSlHelper, futureTpSlHelper.t0(), obj, 2, futureTpSlHelper.v0(), 1);
                    } else {
                        contractOrderPlace2 = null;
                    }
                    if (contractOrderPlace2 == null || contractOrderPlace2.Y()) {
                        if (futureTpSlHelper.q0()) {
                            if (m.a(contractOrderPlace.W()).compareTo(m.a(this.f43262r.getAvailable())) > 0) {
                                HuobiToastUtil.j(R.string.contract_trade_close_available_not_enough);
                                return;
                            }
                        } else if (m.a(contractOrderPlace2.W()).compareTo(m.a(this.f43262r.getAvailable())) > 0) {
                            HuobiToastUtil.j(R.string.contract_trade_close_available_not_enough);
                            return;
                        }
                        ContractPosition contractPosition = this.f43262r;
                        String sh2 = sh(contractPosition.tpOrderId, contractPosition.slOrderId);
                        if (!TextUtils.isEmpty(sh2)) {
                            Qh(sh2, new s(this, contractOrderPlace, contractOrderPlace2));
                        } else if (!TextUtils.isEmpty(this.f43262r.getTpslOrderType())) {
                            Qh(this.f43262r.getOrderId(), new t(this, contractOrderPlace, contractOrderPlace2));
                        } else if (!this.f43268x) {
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
                            di(str, str2, str3, contractOrderPlace, contractOrderPlace2);
                        } else {
                            bi(contractOrderPlace, contractOrderPlace2);
                        }
                    }
                }
            }
        }
    }

    public String Th() {
        ContractPosition contractPosition = this.f43262r;
        if (contractPosition == null) {
            return null;
        }
        return contractPosition.getContractCode();
    }

    public String Uh() {
        ContractPosition contractPosition = this.f43262r;
        if (contractPosition == null) {
            return null;
        }
        return contractPosition.getDirection();
    }

    public ContractPosition Vh() {
        return this.f43262r;
    }

    public final double Wh() {
        double d11;
        try {
            d11 = Double.parseDouble(this.f43262r.getLastPrice());
        } catch (Exception unused) {
            d11 = 0.0d;
        }
        if (d11 != 0.0d) {
            return d11;
        }
        if (w2()) {
            double d12 = this.f43266v;
            if (d12 != 0.0d) {
                return d12;
            }
        } else {
            double d13 = this.f43265u;
            if (d13 != 0.0d) {
                return d13;
            }
        }
        return d11;
    }

    public boolean Xh() {
        ContractPosition contractPosition = this.f43262r;
        if (contractPosition == null) {
            return false;
        }
        if (contractPosition.getTpslOrderType().equals("sl") || this.f43262r.getTpslOrderType().equals("tp")) {
            return true;
        }
        return false;
    }

    public final boolean Yh() {
        return this.f43262r == null || "buy".equalsIgnoreCase(Uh());
    }

    public final boolean Zh() {
        return this.f43267w == 2;
    }

    public void addEvent(r rVar) {
        this.f43255k.setOnClickListener(new dj.r(this));
        this.f43254j.setOnClickListener(new p(this));
    }

    public void afterInit() {
        ei(this.f43262r);
        if (this.f43261q != null) {
            q7.a.a().B(true, this.f43261q.getContractShortType(), ContractDepthType.STEP6, this.f43269y);
        }
    }

    public final FutureTpSlFuturesHelper.a ci(int i11, String str, boolean z11) {
        String available = this.f43262r.getAvailable();
        String lastPrice = this.f43262r.getLastPrice();
        String contractFace = this.f43261q.getContractFace();
        BigDecimal a11 = m.a(this.f43262r.getAvailable());
        int n11 = f.n(this.f43261q.getContractCode());
        BigDecimal valueOf = BigDecimal.valueOf((long) i11);
        if (z11) {
            return FutureTpSlFuturesHelper.g(TradeType.CONTRACT, this.f43261q.getContractFace(), a11, o0(), valueOf, this.f43262r.getLastPrice(), n11);
        }
        if (TextUtils.isEmpty(str)) {
            valueOf = BigDecimal.ZERO;
        } else {
            TradeType tradeType = TradeType.CONTRACT;
            if (a7.e.E(tradeType)) {
                BigDecimal bigDecimal = new BigDecimal(FutureUnitUtil.d(available, lastPrice, contractFace, tradeType));
                if (bigDecimal.compareTo(BigDecimal.ZERO) > 0) {
                    valueOf = new BigDecimal(str).divide(bigDecimal, 32, 0);
                }
            } else {
                BigDecimal bigDecimal2 = new BigDecimal(str);
                BigDecimal bigDecimal3 = new BigDecimal(m.m(available, us.i.z(this.f43263s)));
                if (bigDecimal3.compareTo(BigDecimal.ZERO) > 0) {
                    valueOf = bigDecimal2.divide(bigDecimal3, 32, 0);
                }
            }
        }
        return new FutureTpSlFuturesHelper.a((String) null, valueOf);
    }

    public final void di(String str, String str2, String str3, ContractOrderPlace contractOrderPlace, ContractOrderPlace contractOrderPlace2) {
        q7.a.a().o(this.f43261q.getContractCode(), w2() ? "sell" : "buy", str, str2, str3).b().compose(RxJavaHelper.t((g) null)).subscribe(new b((g) null, contractOrderPlace, contractOrderPlace2));
    }

    public final void ei(ContractPosition contractPosition) {
        if (contractPosition != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getActivity(), R.color.global_main_text_color)), 0, spannableStringBuilder.length(), 33);
            this.f43252h.setText(spannableStringBuilder.append(ej.g.m(contractPosition.getSymbol(), contractPosition.getDirection(), contractPosition.getContractCode(), contractPosition.getLeverRate(), contractPosition.getContractCurrencyInfo().getContractShortType(), getActivity())));
        }
    }

    public void fi(ContractPosition contractPosition) {
        this.f43262r = contractPosition;
        if (contractPosition != null) {
            this.f43261q = contractPosition.getContractCurrencyInfo();
            this.f43263s = contractPosition.getSymbol();
        }
    }

    public void gi(int i11) {
        this.f43267w = i11;
    }

    public final void hi() {
        new DialogUtils.b.d(getActivity()).f1(false).C0(getContext().getString(R.string.n_contract_tpsl_tips)).q0(false).P0(getContext().getString(R.string.n_known)).Q0(n.f13170a).j0().show(getActivity().getSupportFragmentManager(), "");
    }

    public ContractOrderPlace ii(FutureTpSlHelper futureTpSlHelper, String str, String str2, int i11, int i12, int i13) {
        if (i12 != 1) {
            if (w2()) {
                str = BigDecimal.valueOf(this.f43266v).toPlainString();
            } else {
                str = BigDecimal.valueOf(this.f43265u).toPlainString();
            }
        }
        ContractOrderPlace contractOrderPlace = new ContractOrderPlace();
        contractOrderPlace.N0(o0());
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
        ContractPosition contractPosition = this.f43262r;
        if (contractPosition != null) {
            contractOrderPlace.s0(contractPosition.getLeverRate());
        }
        futureTpSlHelper.A1(i13, contractOrderPlace);
        return this.f43264t.N(getActivity(), contractOrderPlace, this.f43261q);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x01e1  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x01e4  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x02c5  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x02c8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initView(i6.r r27) {
        /*
            r26 = this;
            r0 = r26
            r1 = r27
            super.initView(r27)
            r2 = 2131429145(0x7f0b0719, float:1.8479954E38)
            android.view.View r2 = r1.b(r2)
            dj.q r3 = new dj.q
            r3.<init>(r0)
            r2.setOnClickListener(r3)
            r2 = 2131429147(0x7f0b071b, float:1.8479959E38)
            android.view.View r2 = r1.b(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r0.f43252h = r2
            r2 = 2131429122(0x7f0b0702, float:1.8479908E38)
            android.view.View r2 = r1.b(r2)
            r0.f43255k = r2
            r2 = 2131429148(0x7f0b071c, float:1.847996E38)
            android.view.View r2 = r1.b(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r0.f43253i = r2
            r2 = 2131429198(0x7f0b074e, float:1.8480062E38)
            android.view.View r2 = r1.b(r2)
            r0.f43254j = r2
            r2.bringToFront()
            r2 = 2131429192(0x7f0b0748, float:1.848005E38)
            android.view.View r2 = r1.b(r2)
            r0.f43256l = r2
            r2 = 2131432548(0x7f0b1464, float:1.8486857E38)
            android.view.View r2 = r1.b(r2)
            com.hbg.lib.widgets.LoadingView r2 = (com.hbg.lib.widgets.LoadingView) r2
            r0.f43257m = r2
            r3 = 2131951711(0x7f13005f, float:1.9539844E38)
            r2.setLottieAnimationRes(r3)
            bj.d1 r2 = new bj.d1
            r3 = 0
            r2.<init>(r3)
            r0.f43264t = r2
            com.huobi.contract.entity.ContractPosition r3 = r0.f43262r
            if (r3 == 0) goto L_0x0089
            com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo r3 = r0.f43261q
            if (r3 == 0) goto L_0x0089
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo r4 = r0.f43261q
            java.lang.String r4 = r4.getContractCode()
            r3.append(r4)
            java.lang.String r4 = r26.Uh()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.huobi.contract.entity.ContractPosition r4 = r0.f43262r
            r2.T(r3, r4)
        L_0x0089:
            r2 = 2131433228(0x7f0b170c, float:1.8488236E38)
            android.view.View r2 = r1.b(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r0.f43258n = r2
            r2 = 2131431884(0x7f0b11cc, float:1.848551E38)
            android.view.View r2 = r1.b(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r0.f43259o = r2
            r2 = 2131429306(0x7f0b07ba, float:1.848028E38)
            android.view.View r2 = r1.b(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r0.f43260p = r2
            r2 = 2131431883(0x7f0b11cb, float:1.8485508E38)
            android.view.View r2 = r1.b(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            android.content.res.Resources r3 = r26.getResources()
            r4 = 2132018925(0x7f1406ed, float:1.967617E38)
            r5 = 1
            java.lang.Object[] r6 = new java.lang.Object[r5]
            android.content.res.Resources r7 = r26.getResources()
            r8 = 2132027474(0x7f142852, float:1.969351E38)
            java.lang.String r7 = r7.getString(r8)
            r9 = 0
            r6[r9] = r7
            java.lang.String r3 = r3.getString(r4, r6)
            r2.setText(r3)
            r2 = 2131429305(0x7f0b07b9, float:1.8480279E38)
            android.view.View r2 = r1.b(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            android.content.res.Resources r3 = r26.getResources()
            r4 = 2132022730(0x7f1415ca, float:1.9683888E38)
            java.lang.Object[] r6 = new java.lang.Object[r5]
            android.content.res.Resources r7 = r26.getResources()
            java.lang.String r7 = r7.getString(r8)
            r6[r9] = r7
            java.lang.String r3 = r3.getString(r4, r6)
            r2.setText(r3)
            com.huobi.contract.entity.ContractPosition r2 = r0.f43262r
            r0.mi(r2)
            r2 = 2131433691(0x7f0b18db, float:1.8489175E38)
            android.view.View r2 = r1.b(r2)
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            com.huobi.contract.entity.ContractPosition r3 = r0.f43262r
            java.lang.String r3 = r3.getTpslOrderType()
            java.lang.String r4 = "sl"
            boolean r3 = r4.equals(r3)
            java.lang.String r4 = "_"
            r6 = 2131427594(0x7f0b010a, float:1.8476809E38)
            java.lang.String r7 = "tpsl_position_trigger"
            java.lang.String r8 = "market"
            java.lang.String r10 = "--"
            r11 = 2131432509(0x7f0b143d, float:1.8486777E38)
            java.lang.String r12 = "3"
            java.lang.String r13 = "0"
            r14 = 8
            if (r3 == 0) goto L_0x01fb
            com.hbg.lib.widgets.CommonTextListIndicator r3 = r0.f43192b
            r3.setVisibility(r14)
            r2.setVisibility(r14)
            com.huobi.contract.entity.ContractPosition r2 = r0.f43262r
            java.lang.String r2 = r2.getTriggerPrice()
            com.huobi.contract.entity.ContractPosition r3 = r0.f43262r
            java.lang.String r3 = r3.getContractCode()
            int r3 = ej.f.p(r3)
            java.lang.String r2 = i6.m.n(r2, r3, r10)
            com.huobi.contract.entity.PriceType r3 = com.huobi.contract.entity.PriceType.LIMIT
            com.huobi.contract.entity.ContractPosition r10 = r0.f43262r
            java.lang.String r10 = r10.getOrderPriceType()
            boolean r8 = android.text.TextUtils.equals(r10, r8)
            if (r8 == 0) goto L_0x0161
            com.huobi.contract.entity.PriceType r3 = com.huobi.contract.entity.PriceType.MARKET
            r0.wh(r9, r14)
            android.view.View r1 = r1.b(r11)
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            com.huobi.feature.util.FutureTpSlHelper.H0(r1)
        L_0x015d:
            r25 = r3
            goto L_0x01d3
        L_0x0161:
            com.huobi.contract.entity.ContractPosition r8 = r0.f43262r
            java.lang.String r8 = r8.getOrderPriceType()
            boolean r7 = android.text.TextUtils.equals(r8, r7)
            if (r7 == 0) goto L_0x01a4
            com.huobi.contract.entity.PriceType r3 = com.huobi.contract.entity.PriceType.MARKET
            r0.wh(r5, r14)
            android.view.View r1 = r1.b(r6)
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            com.huobi.feature.util.FutureTpSlHelper.H0(r1)
            com.huobi.feature.util.FutureTpSlHelper r15 = r0.f43196f
            r18 = 0
            r19 = 0
            com.huobi.contract.entity.ContractPosition r1 = r0.f43262r
            boolean r1 = r1.isMarkPriceType()
            if (r1 == 0) goto L_0x018c
            r21 = r12
            goto L_0x018e
        L_0x018c:
            r21 = r13
        L_0x018e:
            com.huobi.contract.entity.ContractPosition r1 = r0.f43262r
            java.lang.String r23 = r1.getOrderPrice()
            java.lang.String r16 = ""
            java.lang.String r20 = ""
            java.lang.String r22 = ""
            r17 = r2
            r24 = r3
            r25 = r3
            r15.L0(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            goto L_0x01d3
        L_0x01a4:
            com.huobi.contract.entity.ContractPosition r5 = r0.f43262r
            java.lang.String r5 = r5.getOrderPriceType()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x015d
            com.huobi.contract.entity.ContractPosition r5 = r0.f43262r
            java.lang.String r5 = r5.getOrderPriceType()
            boolean r4 = r5.contains(r4)
            if (r4 == 0) goto L_0x015d
            com.huobi.contract.entity.ContractPosition r3 = r0.f43262r
            java.lang.String r3 = r3.getOrderPriceType()
            com.huobi.contract.entity.PriceType r3 = com.huobi.contract.entity.PriceType.getPriceType(r3)
            r0.wh(r9, r14)
            android.view.View r1 = r1.b(r11)
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            com.huobi.feature.util.FutureTpSlHelper.H0(r1)
            goto L_0x015d
        L_0x01d3:
            com.huobi.feature.util.FutureTpSlHelper r15 = r0.f43195e
            r18 = 0
            r19 = 0
            com.huobi.contract.entity.ContractPosition r1 = r0.f43262r
            boolean r1 = r1.isMarkPriceType()
            if (r1 == 0) goto L_0x01e4
            r21 = r12
            goto L_0x01e6
        L_0x01e4:
            r21 = r13
        L_0x01e6:
            com.huobi.contract.entity.ContractPosition r1 = r0.f43262r
            java.lang.String r23 = r1.getOrderPrice()
            java.lang.String r16 = ""
            java.lang.String r20 = ""
            java.lang.String r22 = ""
            r17 = r2
            r24 = r25
            r15.L0(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            goto L_0x0321
        L_0x01fb:
            com.huobi.contract.entity.ContractPosition r3 = r0.f43262r
            java.lang.String r3 = r3.getTpslOrderType()
            java.lang.String r15 = "tp"
            boolean r3 = r15.equals(r3)
            if (r3 == 0) goto L_0x02de
            com.hbg.lib.widgets.CommonTextListIndicator r3 = r0.f43192b
            r3.setVisibility(r14)
            r2.setVisibility(r14)
            com.huobi.contract.entity.ContractPosition r2 = r0.f43262r
            java.lang.String r2 = r2.getTriggerPrice()
            com.huobi.contract.entity.ContractPosition r3 = r0.f43262r
            java.lang.String r3 = r3.getContractCode()
            int r3 = ej.f.p(r3)
            java.lang.String r2 = i6.m.n(r2, r3, r10)
            com.huobi.contract.entity.PriceType r3 = com.huobi.contract.entity.PriceType.LIMIT
            com.huobi.contract.entity.ContractPosition r10 = r0.f43262r
            java.lang.String r10 = r10.getOrderPriceType()
            boolean r8 = android.text.TextUtils.equals(r10, r8)
            if (r8 == 0) goto L_0x0245
            com.huobi.contract.entity.PriceType r3 = com.huobi.contract.entity.PriceType.MARKET
            r0.wh(r9, r14)
            android.view.View r1 = r1.b(r11)
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            com.huobi.feature.util.FutureTpSlHelper.H0(r1)
        L_0x0241:
            r25 = r3
            goto L_0x02b7
        L_0x0245:
            com.huobi.contract.entity.ContractPosition r8 = r0.f43262r
            java.lang.String r8 = r8.getOrderPriceType()
            boolean r7 = android.text.TextUtils.equals(r8, r7)
            if (r7 == 0) goto L_0x0288
            com.huobi.contract.entity.PriceType r3 = com.huobi.contract.entity.PriceType.MARKET
            r0.wh(r5, r14)
            android.view.View r1 = r1.b(r6)
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            com.huobi.feature.util.FutureTpSlHelper.H0(r1)
            com.huobi.feature.util.FutureTpSlHelper r15 = r0.f43196f
            r18 = 0
            r19 = 0
            com.huobi.contract.entity.ContractPosition r1 = r0.f43262r
            boolean r1 = r1.isMarkPriceType()
            if (r1 == 0) goto L_0x0270
            r20 = r12
            goto L_0x0272
        L_0x0270:
            r20 = r13
        L_0x0272:
            com.huobi.contract.entity.ContractPosition r1 = r0.f43262r
            java.lang.String r22 = r1.getOrderPrice()
            java.lang.String r17 = ""
            java.lang.String r21 = ""
            java.lang.String r23 = ""
            r16 = r2
            r24 = r3
            r25 = r3
            r15.L0(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            goto L_0x02b7
        L_0x0288:
            com.huobi.contract.entity.ContractPosition r5 = r0.f43262r
            java.lang.String r5 = r5.getOrderPriceType()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x0241
            com.huobi.contract.entity.ContractPosition r5 = r0.f43262r
            java.lang.String r5 = r5.getOrderPriceType()
            boolean r4 = r5.contains(r4)
            if (r4 == 0) goto L_0x0241
            com.huobi.contract.entity.ContractPosition r3 = r0.f43262r
            java.lang.String r3 = r3.getOrderPriceType()
            com.huobi.contract.entity.PriceType r3 = com.huobi.contract.entity.PriceType.getPriceType(r3)
            r0.wh(r9, r14)
            android.view.View r1 = r1.b(r11)
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            com.huobi.feature.util.FutureTpSlHelper.H0(r1)
            goto L_0x0241
        L_0x02b7:
            com.huobi.feature.util.FutureTpSlHelper r15 = r0.f43195e
            r18 = 0
            r19 = 0
            com.huobi.contract.entity.ContractPosition r1 = r0.f43262r
            boolean r1 = r1.isMarkPriceType()
            if (r1 == 0) goto L_0x02c8
            r20 = r12
            goto L_0x02ca
        L_0x02c8:
            r20 = r13
        L_0x02ca:
            com.huobi.contract.entity.ContractPosition r1 = r0.f43262r
            java.lang.String r22 = r1.getOrderPrice()
            java.lang.String r17 = ""
            java.lang.String r21 = ""
            java.lang.String r23 = ""
            r16 = r2
            r24 = r25
            r15.L0(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            goto L_0x0321
        L_0x02de:
            com.hbg.lib.widgets.CommonTextListIndicator r1 = r0.f43192b
            r1.setVisibility(r9)
            r2.setVisibility(r9)
            int r1 = r0.f43197g
            r2 = 4
            r0.wh(r1, r2)
            com.huobi.feature.util.FutureTpSlHelper r14 = r0.f43196f
            com.huobi.contract.entity.ContractPosition r1 = r0.f43262r
            java.lang.String r15 = r1.tpTriggerPrice
            java.lang.String r2 = r1.slTriggerPrice
            r17 = 0
            r18 = 0
            java.lang.String r3 = r1.tpTriggerType
            boolean r1 = r1.isMarkPriceType(r3)
            if (r1 == 0) goto L_0x0303
            r19 = r12
            goto L_0x0305
        L_0x0303:
            r19 = r13
        L_0x0305:
            com.huobi.contract.entity.ContractPosition r1 = r0.f43262r
            java.lang.String r3 = r1.slTriggerType
            boolean r1 = r1.isMarkPriceType(r3)
            if (r1 == 0) goto L_0x0312
            r20 = r12
            goto L_0x0314
        L_0x0312:
            r20 = r13
        L_0x0314:
            com.huobi.contract.entity.PriceType r24 = com.huobi.contract.entity.PriceType.MARKET
            java.lang.String r21 = ""
            java.lang.String r22 = ""
            r16 = r2
            r23 = r24
            r14.L0(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
        L_0x0321:
            com.huobi.feature.util.FutureTpSlHelper r1 = r0.f43195e
            r1.K0()
            com.huobi.feature.util.FutureTpSlHelper r1 = r0.f43196f
            r1.K0()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.contract.ui.ContractHoldStopDialogFragment.initView(i6.r):void");
    }

    public final void ji() {
        if (!a7.e.E(TradeType.CONTRACT)) {
            String m11 = m.m(this.f43262r.getAvailable(), 0);
            pi(this.f43253i, String.format(getActivity().getString(R.string.n_contract_trade_close_margin_available), new Object[]{m11, getActivity().getString(R.string.contract_market_vol_sheet)}), 0);
        } else if (m.a(this.f43262r.getLastPrice()).compareTo(BigDecimal.ZERO) <= 0) {
            pi(this.f43253i, "", 4);
        } else if (m.a(this.f43262r.getLastPrice()).compareTo(BigDecimal.ZERO) > 0) {
            String q11 = m.q(m.a(this.f43262r.getAvailable()).multiply(m.a(this.f43261q.getContractFace())).divide(m.a(this.f43262r.getLastPrice()), f.n(Th()), 1), f.n(this.f43261q.getContractCode()));
            pi(this.f43253i, String.format(getActivity().getString(R.string.n_contract_trade_close_margin_available), new Object[]{q11, o0()}), 0);
        }
    }

    public final void ki(List<Double[]> list, int i11) {
        if (list == null || list.isEmpty()) {
            if (i11 == 0) {
                this.f43265u = 0.0d;
            } else {
                this.f43266v = 0.0d;
            }
        } else if (i11 == 0) {
            this.f43265u = list.get(0)[0].doubleValue();
        } else {
            this.f43266v = list.get(0)[0].doubleValue();
        }
    }

    public void li() {
        ContractPosition contractPosition = this.f43262r;
        if (contractPosition != null) {
            ni(contractPosition);
            oi(this.f43262r);
        }
        ji();
    }

    public void mi(ContractPosition contractPosition) {
        fi(contractPosition);
        if (contractPosition != null) {
            ni(contractPosition);
            oi(contractPosition);
        }
        ji();
    }

    public final void ni(ContractPosition contractPosition) {
        int p11 = f.p(contractPosition.getContractCode());
        this.f43258n.setText(m.m(contractPosition.getCostOpen(), p11));
        this.f43259o.setText(m.m(contractPosition.getLastPrice(), p11));
    }

    public final String o0() {
        return this.f43263s;
    }

    public final void oi(ContractPosition contractPosition) {
        this.f43260p.setText(m.q(m.a(contractPosition.getLiquidationPrice()), FuturePrecisionUtil.y(contractPosition.getContractCode(), contractPosition.getContractShortType(), (String) null)));
    }

    public final void pi(TextView textView, String str, int i11) {
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
        return !Yh();
    }
}
