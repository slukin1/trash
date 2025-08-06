package com.huobi.linearswap.ui;

import android.app.Activity;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import bh.j;
import bj.o0;
import cn.l;
import cn.n;
import cn.o;
import cn.p;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.future.util.FutureUnitUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapCancelAllResult;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition;
import com.hbg.lib.network.linear.swap.core.util.LinearSwapDepthType;
import com.hbg.lib.network.linear.swap.retrofit.LinearSwapRetrofit;
import com.hbg.lib.network.option.core.util.OptionDirection;
import com.hbg.lib.network.pro.socket.bean.TradeBuySellData;
import com.hbg.lib.network.pro.socket.listener.MarketDepthListener;
import com.hbg.lib.network.pro.socket.response.MarketDepthResponse;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseEasySubscriber;
import com.hbg.lib.widgets.LoadingView;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.contract.entity.ContractAssetAndOrderUpdateEvent;
import com.huobi.contract.entity.ContractOrderPlace;
import com.huobi.contract.ui.ContractBaseHoldDialogFragment;
import com.huobi.feature.util.FutureTpSlFuturesHelper;
import com.huobi.feature.util.FutureTpSlHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.i;
import i6.m;
import i6.r;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.EventBus;
import pro.huobi.R;
import rx.Observable;
import u6.g;
import ym.z;

public class LinearSwapHoldStopDialogFragment extends ContractBaseHoldDialogFragment {

    /* renamed from: h  reason: collision with root package name */
    public TextView f75181h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f75182i;

    /* renamed from: j  reason: collision with root package name */
    public View f75183j;

    /* renamed from: k  reason: collision with root package name */
    public View f75184k;

    /* renamed from: l  reason: collision with root package name */
    public View f75185l;

    /* renamed from: m  reason: collision with root package name */
    public LoadingView f75186m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f75187n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f75188o;

    /* renamed from: p  reason: collision with root package name */
    public TextView f75189p;

    /* renamed from: q  reason: collision with root package name */
    public FutureContractInfo f75190q;

    /* renamed from: r  reason: collision with root package name */
    public LinearSwapPosition f75191r;

    /* renamed from: s  reason: collision with root package name */
    public String f75192s;

    /* renamed from: t  reason: collision with root package name */
    public z f75193t;

    /* renamed from: u  reason: collision with root package name */
    public double f75194u;

    /* renamed from: v  reason: collision with root package name */
    public double f75195v;

    /* renamed from: w  reason: collision with root package name */
    public final TradeType f75196w = TradeType.LINEAR_SWAP;

    /* renamed from: x  reason: collision with root package name */
    public int f75197x;

    /* renamed from: y  reason: collision with root package name */
    public boolean f75198y = false;

    /* renamed from: z  reason: collision with root package name */
    public final MarketDepthListener f75199z = new c();

    public class a extends BaseEasySubscriber<Object> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Runnable f75200g;

        public a(Runnable runnable) {
            this.f75200g = runnable;
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            HuobiToastUtil.m(aPIStatusErrorException.getErrMsg());
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            this.f75200g.run();
        }
    }

    public class b extends q6.d<Boolean> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ContractOrderPlace f75202e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ContractOrderPlace f75203f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(g gVar, ContractOrderPlace contractOrderPlace, ContractOrderPlace contractOrderPlace2) {
            super(gVar);
            this.f75202e = contractOrderPlace;
            this.f75203f = contractOrderPlace2;
        }

        /* renamed from: f */
        public void onNext(Boolean bool) {
            super.onNext(bool);
            boolean unused = LinearSwapHoldStopDialogFragment.this.f75198y = true;
            if (bool.booleanValue()) {
                LinearSwapHoldStopDialogFragment.this.ki();
            } else {
                LinearSwapHoldStopDialogFragment.this.ei(this.f75202e, this.f75203f);
            }
        }
    }

    public class c extends MarketDepthListener {
        public c() {
        }

        /* renamed from: j */
        public void f(MarketDepthResponse marketDepthResponse) {
            if (marketDepthResponse != null && LinearSwapHoldStopDialogFragment.this.f75190q != null && marketDepthResponse.getSymbol().equals(LinearSwapHoldStopDialogFragment.this.f75190q.getContractShortType())) {
                TradeBuySellData tick = marketDepthResponse.getTick();
                List<Double[]> asks = tick.getAsks();
                List<Double[]> bids = tick.getBids();
                LinearSwapHoldStopDialogFragment.this.ni(asks, 1);
                LinearSwapHoldStopDialogFragment.this.ni(bids, 0);
                h8.a.a().e0(false, LinearSwapHoldStopDialogFragment.this.f75190q.getContractShortType(), LinearSwapDepthType.STEP6, LinearSwapHoldStopDialogFragment.this.f75199z);
            }
        }
    }

    public class d extends FutureTpSlHelper {

        public class a implements FutureTpSlHelper.i {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LinearSwapHoldStopDialogFragment f75207a;

            public a(LinearSwapHoldStopDialogFragment linearSwapHoldStopDialogFragment) {
                this.f75207a = linearSwapHoldStopDialogFragment;
            }

            public String E0() {
                return LinearSwapHoldStopDialogFragment.this.f75190q.getContractCode();
            }

            public void a() {
                LinearSwapHoldStopDialogFragment.this.th();
            }

            public boolean b(EditText editText, Editable editable) {
                return FutureTpSlFuturesHelper.c(editText, editable, LinearSwapHoldStopDialogFragment.this.f75190q.getContractCode(), LinearSwapHoldStopDialogFragment.this.f75190q.getContractShortType(), d.this.U0());
            }

            public BigDecimal c(String str, int i11) {
                return FutureTpSlFuturesHelper.k(str, getTradePricePrecision(), LinearSwapHoldStopDialogFragment.this.f75191r.getAvgCostPrice(), LinearSwapHoldStopDialogFragment.this.Zh(), LinearSwapHoldStopDialogFragment.this.bi(i11));
            }

            public String d(String str, boolean z11, BigDecimal bigDecimal) {
                return FutureTpSlFuturesHelper.f(str, LinearSwapHoldStopDialogFragment.this.f75191r.getAvailable(), LinearSwapHoldStopDialogFragment.this.f75190q.contractFace, LinearSwapHoldStopDialogFragment.this.f75191r.getAvgCostPrice(), LinearSwapHoldStopDialogFragment.this.Zh(), bigDecimal);
            }

            public FutureTpSlFuturesHelper.a e(int i11, String str, boolean z11) {
                return LinearSwapHoldStopDialogFragment.this.fi(i11, str, z11);
            }

            public String f() {
                return LinearSwapHoldStopDialogFragment.this.Vh();
            }

            public BigDecimal g(String str, boolean z11, BigDecimal bigDecimal) {
                if (TextUtils.isEmpty(str)) {
                    return BigDecimal.ZERO;
                }
                BigDecimal a11 = m.a(str);
                BigDecimal h11 = FutureTpSlFuturesHelper.h(m.a(LinearSwapHoldStopDialogFragment.this.f75190q.contractFace), bigDecimal.multiply(m.a(LinearSwapHoldStopDialogFragment.this.f75191r.getAvailable())), LinearSwapHoldStopDialogFragment.this.Zh(), m.a(LinearSwapHoldStopDialogFragment.this.f75191r.getAvgCostPrice()), a11, TradeType.LINEAR_SWAP);
                if (h11 == null || h11.compareTo(BigDecimal.ZERO) <= 0) {
                    return BigDecimal.ZERO;
                }
                return h11.setScale(FuturePrecisionUtil.y(LinearSwapHoldStopDialogFragment.this.f75190q.getContractCode(), LinearSwapHoldStopDialogFragment.this.f75190q.getContractShortType(), LinearSwapHoldStopDialogFragment.this.f75190q.getOptionCode()), 1);
            }

            public Activity getActivity() {
                return LinearSwapHoldStopDialogFragment.this.getActivity();
            }

            public String getQuoteCurrency() {
                return LinearSwapHoldStopDialogFragment.this.f75190q.getQuoteCurrency();
            }

            public int getTradePricePrecision() {
                return FuturePrecisionUtil.y(LinearSwapHoldStopDialogFragment.this.f75190q.getContractCode(), LinearSwapHoldStopDialogFragment.this.f75190q.getContractShortType(), (String) null);
            }

            public String h(String str, int i11) {
                return FutureTpSlFuturesHelper.j(str, FuturePrecisionUtil.y(LinearSwapHoldStopDialogFragment.this.f75190q.getContractCode(), LinearSwapHoldStopDialogFragment.this.f75190q.getContractShortType(), LinearSwapHoldStopDialogFragment.this.f75190q.getOptionCode()), LinearSwapHoldStopDialogFragment.this.f75191r.getAvgCostPrice(), LinearSwapHoldStopDialogFragment.this.f75191r.getLeverRate(), LinearSwapHoldStopDialogFragment.this.Zh(), LinearSwapHoldStopDialogFragment.this.bi(i11), TradeType.LINEAR_SWAP);
            }

            public String o0() {
                return LinearSwapHoldStopDialogFragment.this.f75192s;
            }
        }

        public d() {
            y1(TradeType.LINEAR_SWAP, new a(LinearSwapHoldStopDialogFragment.this));
        }
    }

    public class e extends EasySubscriber<Object> {

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                LinearSwapHoldStopDialogFragment.this.dismiss();
            }
        }

        public e() {
        }

        public void onAfter() {
            super.onAfter();
            LinearSwapHoldStopDialogFragment.this.f75185l.setVisibility(8);
            LinearSwapHoldStopDialogFragment.this.f75186m.d();
            LinearSwapHoldStopDialogFragment.this.f75183j.setEnabled(true);
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
            LinearSwapHoldStopDialogFragment.this.f75185l.setVisibility(0);
            LinearSwapHoldStopDialogFragment.this.f75183j.setEnabled(false);
            LinearSwapHoldStopDialogFragment.this.f75186m.c();
        }

        public /* synthetic */ e(LinearSwapHoldStopDialogFragment linearSwapHoldStopDialogFragment, a aVar) {
            this();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ci(FutureTpSlHelper futureTpSlHelper, HBDialogFragment hBDialogFragment) {
        Th(futureTpSlHelper);
        hBDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$1(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        FutureTpSlHelper futureTpSlHelper = this.f43197g == 0 ? this.f43195e : this.f43196f;
        if (!futureTpSlHelper.g0(this.f75191r.getLastPrice()) || !futureTpSlHelper.e0() || !futureTpSlHelper.c0(futureTpSlHelper.l0().getText().toString())) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        if (ai()) {
            DialogUtils.d0(getActivity(), getResources().getString(R.string.n_spot_order_risk), getResources().getString(R.string.n_liquidation_price_block_tip), getResources().getString(R.string.n_return_to_edit), getResources().getString(R.string.n_exchange_call_auction_order_line_up_confirm), o0.f12469a, new cn.m(this, futureTpSlHelper));
        } else {
            Th(futureTpSlHelper);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initView$0(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public String R0() {
        LinearSwapPosition linearSwapPosition = this.f75191r;
        if (linearSwapPosition == null) {
            return "";
        }
        return linearSwapPosition.getOrderId();
    }

    public void Rh(String str, Runnable runnable) {
        Observable<LinearSwapCancelAllResult> observable;
        if (Xh() == 2) {
            observable = h8.a.a().y(this.f75191r.getContractCode(), str).b();
        } else {
            observable = h8.a.a().S(this.f75191r.getContractCode(), str).b();
        }
        observable.delay(300, TimeUnit.MILLISECONDS).compose(LinearSwapRetrofit.n()).compose(RxJavaHelper.t((g) null)).subscribe(new a(runnable));
    }

    /* renamed from: Sh */
    public final void ei(ContractOrderPlace contractOrderPlace, ContractOrderPlace contractOrderPlace2) {
        ContractOrderPlace contractOrderPlace3 = new ContractOrderPlace();
        if (contractOrderPlace != null) {
            contractOrderPlace3.Q0(contractOrderPlace.J());
            contractOrderPlace3.p0(contractOrderPlace.l());
            contractOrderPlace3.c1(contractOrderPlace.W());
            contractOrderPlace3.v0(contractOrderPlace.q());
            contractOrderPlace3.R0(contractOrderPlace.K());
            contractOrderPlace3.S0(contractOrderPlace.L());
            contractOrderPlace3.O0(contractOrderPlace.H());
            contractOrderPlace3.Q0(contractOrderPlace.J());
        }
        if (contractOrderPlace2 != null) {
            contractOrderPlace3.K0(contractOrderPlace2.D());
            contractOrderPlace3.p0(contractOrderPlace2.l());
            contractOrderPlace3.c1(contractOrderPlace2.W());
            contractOrderPlace3.v0(contractOrderPlace2.q());
            contractOrderPlace3.L0(contractOrderPlace2.E());
            contractOrderPlace3.M0(contractOrderPlace2.F());
            contractOrderPlace3.I0(contractOrderPlace2.B());
            contractOrderPlace3.K0(contractOrderPlace2.D());
        }
        this.f75193t.P(contractOrderPlace3, this.f75190q).compose(RxJavaHelper.t((g) null)).subscribe(new e(this, (a) null));
    }

    public final void Th(FutureTpSlHelper futureTpSlHelper) {
        ContractOrderPlace contractOrderPlace;
        ContractOrderPlace contractOrderPlace2;
        double d11;
        String str;
        String str2;
        String str3 = null;
        if (futureTpSlHelper.q0()) {
            is.a.j("5168", (Map<String, Object>) null, is.a.f(TradeType.LINEAR_SWAP));
        }
        if (futureTpSlHelper.p0()) {
            is.a.j("5170", (Map<String, Object>) null, is.a.f(TradeType.LINEAR_SWAP));
        }
        if (this.f75191r != null) {
            String obj = futureTpSlHelper.l0().getText().toString();
            uh();
            if (futureTpSlHelper.q0()) {
                contractOrderPlace = li(futureTpSlHelper, futureTpSlHelper.u0(), obj, 2, futureTpSlHelper.w0(), 0);
            } else {
                contractOrderPlace = null;
            }
            if (contractOrderPlace == null || contractOrderPlace.Y()) {
                if (futureTpSlHelper.p0()) {
                    contractOrderPlace2 = li(futureTpSlHelper, futureTpSlHelper.t0(), obj, 2, futureTpSlHelper.v0(), 1);
                } else {
                    contractOrderPlace2 = null;
                }
                if (contractOrderPlace2 == null || contractOrderPlace2.Y()) {
                    if (contractOrderPlace != null) {
                        d11 = contractOrderPlace.k();
                    } else {
                        d11 = contractOrderPlace2.k();
                    }
                    if (BigDecimal.valueOf(d11).compareTo(BigDecimal.ZERO) == 0) {
                        HuobiToastUtil.j(R.string.string_network_disconnect);
                        return;
                    }
                    if (futureTpSlHelper.q0()) {
                        if (m.a(contractOrderPlace.W()).compareTo(m.a(this.f75191r.getAvailable())) > 0) {
                            HuobiToastUtil.j(R.string.contract_trade_close_available_not_enough);
                            return;
                        }
                    } else if (m.a(contractOrderPlace2.W()).compareTo(m.a(this.f75191r.getAvailable())) > 0) {
                        HuobiToastUtil.j(R.string.contract_trade_close_available_not_enough);
                        return;
                    }
                    LinearSwapPosition linearSwapPosition = this.f75191r;
                    String sh2 = sh(linearSwapPosition.tpOrderId, linearSwapPosition.slOrderId);
                    if (!TextUtils.isEmpty(sh2)) {
                        Rh(sh2, new o(this, contractOrderPlace, contractOrderPlace2));
                    } else if (!TextUtils.isEmpty(this.f75191r.getTpslOrderType())) {
                        Rh(this.f75191r.getOrderId(), new p(this, contractOrderPlace, contractOrderPlace2));
                    } else if (!this.f75198y) {
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
                        gi(str, str2, str3, contractOrderPlace, contractOrderPlace2);
                        return;
                    } else {
                        ei(contractOrderPlace, contractOrderPlace2);
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("module_name", "hold_list");
                    hashMap.put("margin_type", gs.g.d());
                    gs.g.j("stop_surplus_loss", "usdt_contract", "confirm", hashMap);
                }
            }
        }
    }

    public String Uh() {
        LinearSwapPosition linearSwapPosition = this.f75191r;
        if (linearSwapPosition == null) {
            return null;
        }
        return linearSwapPosition.getContractCode();
    }

    public String Vh() {
        LinearSwapPosition linearSwapPosition = this.f75191r;
        if (linearSwapPosition == null) {
            return null;
        }
        return linearSwapPosition.getDirection();
    }

    public LinearSwapPosition Wh() {
        return this.f75191r;
    }

    public int Xh() {
        return this.f75197x;
    }

    public boolean Yh() {
        LinearSwapPosition linearSwapPosition = this.f75191r;
        if (linearSwapPosition == null) {
            return false;
        }
        if (linearSwapPosition.getTpslOrderType().equals("sl") || this.f75191r.getTpslOrderType().equals("tp")) {
            return true;
        }
        return false;
    }

    public final boolean Zh() {
        return this.f75191r == null || "buy".equalsIgnoreCase(Vh());
    }

    public void addEvent(r rVar) {
        this.f75184k.setOnClickListener(new l(this));
        this.f75183j.setOnClickListener(new cn.j(this));
    }

    public void afterInit() {
        hi(this.f75191r);
        if (this.f75190q != null) {
            h8.a.a().e0(true, this.f75190q.getContractShortType(), LinearSwapDepthType.STEP6, this.f75199z);
        }
    }

    public final boolean ai() {
        boolean z11;
        String str;
        if (this.f43192b.getVisibility() == 8) {
            return false;
        }
        if (this.f43197g == 0) {
            str = this.f43195e.D0(1);
            z11 = this.f43195e.p0();
        } else {
            str = this.f43196f.D0(1);
            z11 = this.f43196f.p0();
        }
        if (StringUtils.p(str) || !z11) {
            return false;
        }
        BigDecimal a11 = m.a(str);
        BigDecimal a12 = m.a(this.f75189p.getText().toString());
        if (OptionDirection.BUY.direction.equalsIgnoreCase(this.f75191r.getDirection())) {
            if (a11.compareTo(a12) <= 0) {
                return true;
            }
            return false;
        } else if (a11.compareTo(a12) >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public final boolean bi(int i11) {
        return i11 == 0;
    }

    public final FutureTpSlFuturesHelper.a fi(int i11, String str, boolean z11) {
        String available = this.f75191r.getAvailable();
        String lastPrice = this.f75191r.getLastPrice();
        String contractFace = this.f75190q.getContractFace();
        BigDecimal a11 = m.a(available);
        int s11 = FuturePrecisionUtil.s(this.f75190q.getContractCode(), this.f75190q.getContractShortType(), (String) null);
        BigDecimal valueOf = BigDecimal.valueOf((long) i11);
        if (z11) {
            return FutureTpSlFuturesHelper.g(TradeType.LINEAR_SWAP, contractFace, a11, o0(), valueOf, lastPrice, s11);
        }
        if (TextUtils.isEmpty(str)) {
            valueOf = BigDecimal.ZERO;
        } else {
            TradeType tradeType = TradeType.LINEAR_SWAP;
            if (a7.e.G(tradeType)) {
                BigDecimal a12 = m.a(FutureUnitUtil.f(false, true, available, lastPrice, contractFace, 4));
                BigDecimal bigDecimal = new BigDecimal(str);
                if (a12.compareTo(BigDecimal.ZERO) > 0) {
                    valueOf = bigDecimal.divide(a12, 32, 0);
                }
            } else {
                BigDecimal a13 = m.a(FutureUnitUtil.d(available, lastPrice, contractFace, tradeType));
                BigDecimal bigDecimal2 = new BigDecimal(str);
                if (a13.compareTo(BigDecimal.ZERO) > 0) {
                    valueOf = bigDecimal2.divide(a13, 32, 0);
                }
            }
        }
        return new FutureTpSlFuturesHelper.a((String) null, valueOf);
    }

    public final void gi(String str, String str2, String str3, ContractOrderPlace contractOrderPlace, ContractOrderPlace contractOrderPlace2) {
        Observable<Boolean> observable;
        String str4 = w2() ? "sell" : "buy";
        String contractCode = this.f75190q.getContractCode();
        if (this.f75197x == 1) {
            observable = h8.a.a().W(contractCode, str4, str, str2, str3).b();
        } else {
            observable = h8.a.a().o(contractCode, str4, str, str2, str3).b();
        }
        observable.compose(RxJavaHelper.t((g) null)).subscribe(new b((g) null, contractOrderPlace, contractOrderPlace2));
    }

    public final void hi(LinearSwapPosition linearSwapPosition) {
        if (linearSwapPosition != null) {
            this.f75181h.setText(a7.e.k(getContext(), linearSwapPosition.getSymbol(), this.f75190q.getQuoteCurrency(), linearSwapPosition.getDirection(), linearSwapPosition.getLeverRate(), ContextCompat.getColor(getContext(), R.color.baseColorPrimaryText), this.f75197x, linearSwapPosition.getContractType()));
        }
    }

    public void ii(LinearSwapPosition linearSwapPosition, FutureContractInfo futureContractInfo) {
        this.f75191r = linearSwapPosition;
        this.f75190q = futureContractInfo;
        if (linearSwapPosition != null) {
            this.f75192s = linearSwapPosition.getSymbol();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0215  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0218  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0306  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0309  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initView(i6.r r29) {
        /*
            r28 = this;
            r0 = r28
            r1 = r29
            super.initView(r29)
            r2 = 2131429145(0x7f0b0719, float:1.8479954E38)
            android.view.View r2 = r1.b(r2)
            cn.k r3 = new cn.k
            r3.<init>(r0)
            r2.setOnClickListener(r3)
            r2 = 2131429147(0x7f0b071b, float:1.8479959E38)
            android.view.View r2 = r1.b(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r0.f75181h = r2
            r2 = 2131429122(0x7f0b0702, float:1.8479908E38)
            android.view.View r2 = r1.b(r2)
            r0.f75184k = r2
            r2 = 2131429148(0x7f0b071c, float:1.847996E38)
            android.view.View r2 = r1.b(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r0.f75182i = r2
            r2 = 2131429198(0x7f0b074e, float:1.8480062E38)
            android.view.View r2 = r1.b(r2)
            r0.f75183j = r2
            r2.bringToFront()
            r2 = 2131429192(0x7f0b0748, float:1.848005E38)
            android.view.View r2 = r1.b(r2)
            r0.f75185l = r2
            r2 = 2131432548(0x7f0b1464, float:1.8486857E38)
            android.view.View r2 = r1.b(r2)
            com.hbg.lib.widgets.LoadingView r2 = (com.hbg.lib.widgets.LoadingView) r2
            r0.f75186m = r2
            r3 = 2131951711(0x7f13005f, float:1.9539844E38)
            r2.setLottieAnimationRes(r3)
            ym.z r2 = new ym.z
            r3 = 0
            r2.<init>(r3)
            r0.f75193t = r2
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition r4 = r0.f75191r
            java.lang.String r5 = "_"
            if (r4 == 0) goto L_0x0097
            com.hbg.lib.data.future.bean.FutureContractInfo r4 = r0.f75190q
            if (r4 == 0) goto L_0x0097
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            com.hbg.lib.data.future.bean.FutureContractInfo r6 = r0.f75190q
            java.lang.String r6 = r6.getContractCode()
            r4.append(r6)
            r4.append(r5)
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition r6 = r0.f75191r
            java.lang.String r6 = r6.getMarginMode()
            r4.append(r6)
            java.lang.String r6 = r28.Vh()
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition r6 = r0.f75191r
            r2.u0(r4, r6)
        L_0x0097:
            r2 = 2131433228(0x7f0b170c, float:1.8488236E38)
            android.view.View r2 = r1.b(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r0.f75187n = r2
            r2 = 2131431884(0x7f0b11cc, float:1.848551E38)
            android.view.View r2 = r1.b(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r0.f75188o = r2
            r2 = 2131429306(0x7f0b07ba, float:1.848028E38)
            android.view.View r2 = r1.b(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r0.f75189p = r2
            r2 = 2131429305(0x7f0b07b9, float:1.8480279E38)
            android.view.View r2 = r1.b(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r4 = 2131431883(0x7f0b11cb, float:1.8485508E38)
            android.view.View r4 = r1.b(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r6 = 2131433227(0x7f0b170b, float:1.8488234E38)
            android.view.View r6 = r1.b(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition r7 = r0.f75191r
            com.hbg.lib.data.future.bean.FutureContractInfo r8 = r0.f75190q
            r0.pi(r7, r8)
            com.hbg.lib.data.future.bean.FutureContractInfo r7 = r0.f75190q
            r8 = 1
            r9 = 0
            if (r7 == 0) goto L_0x0128
            android.content.res.Resources r7 = r28.getResources()
            r10 = 2132018925(0x7f1406ed, float:1.967617E38)
            java.lang.Object[] r11 = new java.lang.Object[r8]
            com.hbg.lib.data.future.bean.FutureContractInfo r12 = r0.f75190q
            java.lang.String r12 = r12.getQuoteCurrency()
            r11[r9] = r12
            java.lang.String r7 = r7.getString(r10, r11)
            r4.setText(r7)
            android.content.res.Resources r4 = r28.getResources()
            r7 = 2132022727(0x7f1415c7, float:1.9683882E38)
            java.lang.Object[] r10 = new java.lang.Object[r8]
            com.hbg.lib.data.future.bean.FutureContractInfo r11 = r0.f75190q
            java.lang.String r11 = r11.getQuoteCurrency()
            r10[r9] = r11
            java.lang.String r4 = r4.getString(r7, r10)
            r6.setText(r4)
            android.content.res.Resources r4 = r28.getResources()
            r6 = 2132022730(0x7f1415ca, float:1.9683888E38)
            java.lang.Object[] r7 = new java.lang.Object[r8]
            com.hbg.lib.data.future.bean.FutureContractInfo r10 = r0.f75190q
            java.lang.String r10 = r10.getQuoteCurrency()
            r7[r9] = r10
            java.lang.String r4 = r4.getString(r6, r7)
            r2.setText(r4)
        L_0x0128:
            r2 = 2131433691(0x7f0b18db, float:1.8489175E38)
            android.view.View r2 = r1.b(r2)
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition r4 = r0.f75191r
            java.lang.String r4 = r4.getTpslOrderType()
            java.lang.String r6 = "sl"
            boolean r4 = r6.equals(r4)
            java.lang.String r7 = "tpsl_position_trigger"
            java.lang.String r10 = "market"
            java.lang.String r11 = "--"
            r12 = 2131432509(0x7f0b143d, float:1.8486777E38)
            java.lang.String r13 = "3"
            java.lang.String r14 = "0"
            r15 = 8
            if (r4 == 0) goto L_0x0231
            com.hbg.lib.widgets.CommonTextListIndicator r4 = r0.f43192b
            r4.setVisibility(r15)
            r2.setVisibility(r15)
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition r2 = r0.f75191r
            java.lang.String r2 = r2.getTriggerPrice()
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition r4 = r0.f75191r
            java.lang.String r4 = r4.getContractCode()
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition r6 = r0.f75191r
            java.lang.String r6 = r6.getContractShortType()
            int r3 = com.hbg.lib.data.future.util.FuturePrecisionUtil.y(r4, r6, r3)
            java.lang.String r2 = i6.m.n(r2, r3, r11)
            com.huobi.contract.entity.PriceType r3 = com.huobi.contract.entity.PriceType.LIMIT
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition r4 = r0.f75191r
            java.lang.String r4 = r4.getOrderPriceType()
            boolean r4 = android.text.TextUtils.equals(r4, r10)
            if (r4 == 0) goto L_0x0190
            com.huobi.contract.entity.PriceType r3 = com.huobi.contract.entity.PriceType.MARKET
            r0.wh(r9, r15)
            android.view.View r1 = r1.b(r12)
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            com.huobi.feature.util.FutureTpSlHelper.H0(r1)
        L_0x018c:
            r27 = r3
            goto L_0x0207
        L_0x0190:
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition r4 = r0.f75191r
            java.lang.String r4 = r4.getOrderPriceType()
            boolean r4 = android.text.TextUtils.equals(r4, r7)
            if (r4 == 0) goto L_0x01d8
            com.huobi.contract.entity.PriceType r3 = com.huobi.contract.entity.PriceType.MARKET
            r0.wh(r8, r15)
            r4 = 2131427594(0x7f0b010a, float:1.8476809E38)
            android.view.View r1 = r1.b(r4)
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            com.huobi.feature.util.FutureTpSlHelper.H0(r1)
            com.huobi.feature.util.FutureTpSlHelper r1 = r0.f43196f
            r20 = 0
            r21 = 0
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition r4 = r0.f75191r
            boolean r4 = r4.isMarkPriceType()
            if (r4 == 0) goto L_0x01be
            r23 = r13
            goto L_0x01c0
        L_0x01be:
            r23 = r14
        L_0x01c0:
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition r4 = r0.f75191r
            java.lang.String r25 = r4.getOrderPrice()
            java.lang.String r18 = ""
            java.lang.String r22 = ""
            java.lang.String r24 = ""
            r17 = r1
            r19 = r2
            r26 = r3
            r27 = r3
            r17.L0(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            goto L_0x0207
        L_0x01d8:
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition r4 = r0.f75191r
            java.lang.String r4 = r4.getOrderPriceType()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x018c
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition r4 = r0.f75191r
            java.lang.String r4 = r4.getOrderPriceType()
            boolean r4 = r4.contains(r5)
            if (r4 == 0) goto L_0x018c
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition r3 = r0.f75191r
            java.lang.String r3 = r3.getOrderPriceType()
            com.huobi.contract.entity.PriceType r3 = com.huobi.contract.entity.PriceType.getPriceType(r3)
            r0.wh(r9, r15)
            android.view.View r1 = r1.b(r12)
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            com.huobi.feature.util.FutureTpSlHelper.H0(r1)
            goto L_0x018c
        L_0x0207:
            com.huobi.feature.util.FutureTpSlHelper r1 = r0.f43195e
            r20 = 0
            r21 = 0
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition r3 = r0.f75191r
            boolean r3 = r3.isMarkPriceType()
            if (r3 == 0) goto L_0x0218
            r23 = r13
            goto L_0x021a
        L_0x0218:
            r23 = r14
        L_0x021a:
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition r3 = r0.f75191r
            java.lang.String r25 = r3.getOrderPrice()
            java.lang.String r18 = ""
            java.lang.String r22 = ""
            java.lang.String r24 = ""
            r17 = r1
            r19 = r2
            r26 = r27
            r17.L0(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            goto L_0x0366
        L_0x0231:
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition r4 = r0.f75191r
            java.lang.String r4 = r4.getTpslOrderType()
            java.lang.String r6 = "tp"
            boolean r4 = r6.equals(r4)
            if (r4 == 0) goto L_0x0321
            com.hbg.lib.widgets.CommonTextListIndicator r4 = r0.f43192b
            r4.setVisibility(r15)
            r2.setVisibility(r15)
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition r2 = r0.f75191r
            java.lang.String r2 = r2.getTriggerPrice()
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition r4 = r0.f75191r
            java.lang.String r4 = r4.getContractCode()
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition r6 = r0.f75191r
            java.lang.String r6 = r6.getContractShortType()
            int r3 = com.hbg.lib.data.future.util.FuturePrecisionUtil.y(r4, r6, r3)
            java.lang.String r2 = i6.m.n(r2, r3, r11)
            com.huobi.contract.entity.PriceType r3 = com.huobi.contract.entity.PriceType.LIMIT
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition r4 = r0.f75191r
            java.lang.String r4 = r4.getOrderPriceType()
            boolean r4 = android.text.TextUtils.equals(r4, r10)
            if (r4 == 0) goto L_0x0281
            com.huobi.contract.entity.PriceType r3 = com.huobi.contract.entity.PriceType.MARKET
            r0.wh(r9, r15)
            android.view.View r1 = r1.b(r12)
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            com.huobi.feature.util.FutureTpSlHelper.H0(r1)
        L_0x027d:
            r27 = r3
            goto L_0x02f8
        L_0x0281:
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition r4 = r0.f75191r
            java.lang.String r4 = r4.getOrderPriceType()
            boolean r4 = android.text.TextUtils.equals(r4, r7)
            if (r4 == 0) goto L_0x02c9
            com.huobi.contract.entity.PriceType r3 = com.huobi.contract.entity.PriceType.MARKET
            r0.wh(r8, r15)
            r4 = 2131427594(0x7f0b010a, float:1.8476809E38)
            android.view.View r1 = r1.b(r4)
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            com.huobi.feature.util.FutureTpSlHelper.H0(r1)
            com.huobi.feature.util.FutureTpSlHelper r1 = r0.f43196f
            r20 = 0
            r21 = 0
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition r4 = r0.f75191r
            boolean r4 = r4.isMarkPriceType()
            if (r4 == 0) goto L_0x02af
            r22 = r13
            goto L_0x02b1
        L_0x02af:
            r22 = r14
        L_0x02b1:
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition r4 = r0.f75191r
            java.lang.String r24 = r4.getOrderPrice()
            java.lang.String r19 = ""
            java.lang.String r23 = ""
            java.lang.String r25 = ""
            r17 = r1
            r18 = r2
            r26 = r3
            r27 = r3
            r17.L0(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            goto L_0x02f8
        L_0x02c9:
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition r4 = r0.f75191r
            java.lang.String r4 = r4.getOrderPriceType()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x027d
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition r4 = r0.f75191r
            java.lang.String r4 = r4.getOrderPriceType()
            boolean r4 = r4.contains(r5)
            if (r4 == 0) goto L_0x027d
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition r3 = r0.f75191r
            java.lang.String r3 = r3.getOrderPriceType()
            com.huobi.contract.entity.PriceType r3 = com.huobi.contract.entity.PriceType.getPriceType(r3)
            r0.wh(r9, r15)
            android.view.View r1 = r1.b(r12)
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            com.huobi.feature.util.FutureTpSlHelper.H0(r1)
            goto L_0x027d
        L_0x02f8:
            com.huobi.feature.util.FutureTpSlHelper r1 = r0.f43195e
            r20 = 0
            r21 = 0
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition r3 = r0.f75191r
            boolean r3 = r3.isMarkPriceType()
            if (r3 == 0) goto L_0x0309
            r22 = r13
            goto L_0x030b
        L_0x0309:
            r22 = r14
        L_0x030b:
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition r3 = r0.f75191r
            java.lang.String r24 = r3.getOrderPrice()
            java.lang.String r19 = ""
            java.lang.String r23 = ""
            java.lang.String r25 = ""
            r17 = r1
            r18 = r2
            r26 = r27
            r17.L0(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            goto L_0x0366
        L_0x0321:
            com.hbg.lib.widgets.CommonTextListIndicator r1 = r0.f43192b
            r1.setVisibility(r9)
            r2.setVisibility(r9)
            int r1 = r0.f43197g
            r2 = 4
            r0.wh(r1, r2)
            com.huobi.feature.util.FutureTpSlHelper r15 = r0.f43196f
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition r1 = r0.f75191r
            java.lang.String r2 = r1.tpTriggerPrice
            java.lang.String r3 = r1.slTriggerPrice
            r18 = 0
            r19 = 0
            java.lang.String r4 = r1.tpTriggerType
            boolean r1 = r1.isMarkPriceType(r4)
            if (r1 == 0) goto L_0x0346
            r20 = r13
            goto L_0x0348
        L_0x0346:
            r20 = r14
        L_0x0348:
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition r1 = r0.f75191r
            java.lang.String r4 = r1.slTriggerType
            boolean r1 = r1.isMarkPriceType(r4)
            if (r1 == 0) goto L_0x0355
            r21 = r13
            goto L_0x0357
        L_0x0355:
            r21 = r14
        L_0x0357:
            com.huobi.contract.entity.PriceType r25 = com.huobi.contract.entity.PriceType.MARKET
            java.lang.String r22 = ""
            java.lang.String r23 = ""
            r16 = r2
            r17 = r3
            r24 = r25
            r15.L0(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
        L_0x0366:
            r28.uh()
            com.huobi.feature.util.FutureTpSlHelper r1 = r0.f43195e
            r1.K0()
            com.huobi.feature.util.FutureTpSlHelper r1 = r0.f43196f
            r1.K0()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.linearswap.ui.LinearSwapHoldStopDialogFragment.initView(i6.r):void");
    }

    public void ji(int i11) {
        this.f75197x = i11;
    }

    public final void ki() {
        new DialogUtils.b.d(getActivity()).f1(false).C0(getContext().getString(R.string.n_contract_tpsl_tips)).q0(false).P0(getContext().getString(R.string.n_known)).Q0(n.f13170a).j0().show(getActivity().getSupportFragmentManager(), "");
    }

    public ContractOrderPlace li(FutureTpSlHelper futureTpSlHelper, String str, String str2, int i11, int i12, int i13) {
        if (i12 != 1) {
            if (w2()) {
                str = BigDecimal.valueOf(this.f75195v).toPlainString();
            } else {
                str = BigDecimal.valueOf(this.f75194u).toPlainString();
            }
        }
        ContractOrderPlace contractOrderPlace = new ContractOrderPlace();
        contractOrderPlace.N0(this.f75192s);
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
        contractOrderPlace.v0(this.f75197x);
        if (w2()) {
            contractOrderPlace.W0(getString(R.string.contract_trade_buy_flat_empty));
        } else {
            contractOrderPlace.W0(getString(R.string.contract_trade_sell_flat_more));
        }
        LinearSwapPosition linearSwapPosition = this.f75191r;
        if (linearSwapPosition != null) {
            contractOrderPlace.s0(linearSwapPosition.getLeverRate());
        }
        futureTpSlHelper.A1(i13, contractOrderPlace);
        contractOrderPlace.r0(m.a(this.f75191r.getLastPrice()).doubleValue());
        contractOrderPlace.i0(this.f75194u);
        contractOrderPlace.G0(this.f75195v);
        return this.f75193t.e(getContext(), contractOrderPlace, this.f75190q);
    }

    public final void mi() {
        String available = this.f75191r.getAvailable();
        if (TextUtils.isEmpty(available)) {
            this.f75182i.setText("");
            return;
        }
        boolean E = a7.e.E(this.f75196w);
        boolean G = a7.e.G(this.f75196w);
        if (E) {
            String m11 = m.m(FutureUnitUtil.a(available, this.f75191r.getLastPrice(), this.f75190q.getContractFace(), TradeType.LINEAR_SWAP), FuturePrecisionUtil.s(this.f75190q.getContractCode(), this.f75190q.getContractShortType(), (String) null));
            this.f75182i.setText(String.format(getContext().getString(R.string.n_contract_trade_close_margin_available), new Object[]{m11, this.f75192s}));
        } else if (G) {
            String b11 = FutureUnitUtil.b(available, this.f75191r.getLastPrice(), this.f75190q.getContractFace(), TradeType.LINEAR_SWAP, FuturePrecisionUtil.g(this.f75191r.getSymbol()));
            this.f75182i.setText(String.format(getContext().getString(R.string.n_contract_trade_close_margin_available), new Object[]{b11, "usdt".toUpperCase(Locale.US)}));
        }
    }

    public final void ni(List<Double[]> list, int i11) {
        if (list == null || list.isEmpty()) {
            if (i11 == 0) {
                this.f75194u = 0.0d;
            } else {
                this.f75195v = 0.0d;
            }
        } else if (i11 == 0) {
            this.f75194u = list.get(0)[0].doubleValue();
        } else {
            this.f75195v = list.get(0)[0].doubleValue();
        }
    }

    public final String o0() {
        return this.f75192s;
    }

    public void oi() {
        LinearSwapPosition linearSwapPosition = this.f75191r;
        if (linearSwapPosition != null) {
            qi(linearSwapPosition);
            ri(this.f75191r, this.f75190q);
        }
        mi();
    }

    public void pi(LinearSwapPosition linearSwapPosition, FutureContractInfo futureContractInfo) {
        ii(linearSwapPosition, futureContractInfo);
        if (linearSwapPosition != null) {
            qi(linearSwapPosition);
            ri(linearSwapPosition, futureContractInfo);
        }
        mi();
    }

    public final void qi(LinearSwapPosition linearSwapPosition) {
        int y11 = FuturePrecisionUtil.y(this.f75190q.getContractCode(), this.f75190q.getContractShortType(), this.f75190q.getOptionCode());
        this.f75187n.setText(m.m(linearSwapPosition.getAvgCostPrice(), y11));
        this.f75188o.setText(m.m(linearSwapPosition.getPositionPrice(), y11));
    }

    public final void ri(LinearSwapPosition linearSwapPosition, FutureContractInfo futureContractInfo) {
        if (futureContractInfo != null) {
            this.f75189p.setText(m.q(m.a(linearSwapPosition.getLiquidationPrice()), FuturePrecisionUtil.y(futureContractInfo.getContractCode(), futureContractInfo.getContractShortType(), (String) null)));
        }
    }

    public void vh() {
        this.f43195e = new d();
        this.f43196f = new d();
    }

    public final boolean w2() {
        return !Zh();
    }
}
