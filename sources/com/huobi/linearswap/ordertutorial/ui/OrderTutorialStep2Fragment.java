package com.huobi.linearswap.ordertutorial.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.ui.EmptyMVPFragment;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.future.util.FutureUnitUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.LevelAvailableMarginInfo;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.network.linear.swap.controller.LinearSwapAllowLevelController;
import com.hbg.lib.network.linear.swap.core.bean.AccountBalanceInfoV5;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapAccountInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapCrossAccountInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapLeverRate;
import com.hbg.lib.network.pro.socket.listener.MarketDetailListener;
import com.hbg.lib.network.pro.socket.response.MarketDetailResponse;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.retrofit.util.SPUtil;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.feature.ui.LeverSelectDialogFragment;
import com.huobi.finance.ui.UnifyTransferActivity;
import com.huobi.login.bean.JumpTarget;
import com.huobi.webview2.ui.ContractWebActivity;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.zopim.android.sdk.api.ZopimChat;
import i6.m;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import pro.huobi.R;
import rx.Observable;
import rx.Subscriber;
import tg.r;
import u6.g;
import us.i;
import z6.l;
import zm.j;
import zm.k;
import zm.n;
import zm.o;
import zm.p;
import zm.q;
import zm.s;
import zm.t;

public class OrderTutorialStep2Fragment extends EmptyMVPFragment {

    /* renamed from: l  reason: collision with root package name */
    public EditText f75012l;

    /* renamed from: m  reason: collision with root package name */
    public TextView f75013m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f75014n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f75015o;

    /* renamed from: p  reason: collision with root package name */
    public TextView f75016p;

    /* renamed from: q  reason: collision with root package name */
    public TextView f75017q;

    /* renamed from: r  reason: collision with root package name */
    public TextView f75018r;

    /* renamed from: s  reason: collision with root package name */
    public View f75019s;

    /* renamed from: t  reason: collision with root package name */
    public View f75020t;

    /* renamed from: u  reason: collision with root package name */
    public AccountBalanceInfoV5 f75021u;

    /* renamed from: v  reason: collision with root package name */
    public MarketDetailListener f75022v = new b();

    /* renamed from: w  reason: collision with root package name */
    public final LeverSelectDialogFragment f75023w = new LeverSelectDialogFragment();

    /* renamed from: x  reason: collision with root package name */
    public final LeverSelectDialogFragment.h f75024x = new d();

    /* renamed from: y  reason: collision with root package name */
    public final OpenOrderDialogFragment f75025y = new OpenOrderDialogFragment();

    public class a extends EasySubscriber<Boolean> {
        public a() {
        }

        /* renamed from: a */
        public void onNext(Boolean bool) {
            OrderTutorialStep2Fragment.this.Yh();
        }
    }

    public class b extends MarketDetailListener {
        public b() {
        }

        /* renamed from: j */
        public void f(MarketDetailResponse marketDetailResponse) {
            an.a Nh = OrderTutorialStep2Fragment.this.ai();
            String contractShortType = Nh.H().getContractShortType();
            if (marketDetailResponse != null && marketDetailResponse.getSymbol().equals(contractShortType)) {
                double close = marketDetailResponse.getTick().getClose();
                Nh.y(close);
                Nh.s(close);
                Nh.F(close);
                OrderTutorialStep2Fragment orderTutorialStep2Fragment = OrderTutorialStep2Fragment.this;
                orderTutorialStep2Fragment.Uh(orderTutorialStep2Fragment.f75012l.getText().toString());
            }
        }
    }

    public class c extends BaseSubscriber<List<LinearSwapCrossAccountInfo>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f75028b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f75029c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f75030d;

        public c(String str, String str2, String str3) {
            this.f75028b = str;
            this.f75029c = str2;
            this.f75030d = str3;
        }

        public void onNext(List<LinearSwapCrossAccountInfo> list) {
            if (list != null && list.size() != 0) {
                LinearSwapCrossAccountInfo linearSwapCrossAccountInfo = null;
                Iterator<LinearSwapCrossAccountInfo> it2 = list.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    LinearSwapCrossAccountInfo next = it2.next();
                    if (this.f75028b.equalsIgnoreCase(next.getMarginAccount())) {
                        linearSwapCrossAccountInfo = next;
                        break;
                    }
                }
                if (linearSwapCrossAccountInfo != null) {
                    List arrayList = new ArrayList();
                    if ("swap".equals(this.f75029c)) {
                        if (linearSwapCrossAccountInfo.getContractDetail() != null) {
                            arrayList = linearSwapCrossAccountInfo.getContractDetail();
                        }
                    } else if ("futures".equals(this.f75029c) && linearSwapCrossAccountInfo.getFuturesContractDetail() != null) {
                        arrayList = linearSwapCrossAccountInfo.getFuturesContractDetail();
                    }
                    Iterator it3 = arrayList.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            break;
                        }
                        LinearSwapAccountInfo linearSwapAccountInfo = (LinearSwapAccountInfo) it3.next();
                        if (linearSwapAccountInfo.getContractCode().equals(this.f75030d)) {
                            linearSwapAccountInfo.setMarginBalance(linearSwapCrossAccountInfo.getMarginBalance());
                            linearSwapAccountInfo.setRiskRate(linearSwapCrossAccountInfo.getRiskRate());
                            linearSwapAccountInfo.setTrailFund(linearSwapCrossAccountInfo.getTrailFund());
                            linearSwapAccountInfo.setMarginStatic(linearSwapCrossAccountInfo.getMarginStatic());
                            linearSwapAccountInfo.setMoneyIn(linearSwapCrossAccountInfo.getMoneyIn());
                            linearSwapAccountInfo.setMoneyOut(linearSwapCrossAccountInfo.getMoneyOut());
                            OrderTutorialStep2Fragment.this.ai().t(linearSwapAccountInfo);
                            break;
                        }
                    }
                    OrderTutorialStep2Fragment.this.Yh();
                }
            }
        }
    }

    public class d implements LeverSelectDialogFragment.h {
        public d() {
        }

        public void N0() {
            String str;
            String str2;
            FutureContractInfo H = OrderTutorialStep2Fragment.this.ai().H();
            if (H != null) {
                TradeType tradeType = TradeType.LINEAR_SWAP;
                if (a7.e.E(tradeType)) {
                    str = "symbol";
                } else {
                    str = a7.e.G(tradeType) ? "usdt" : "sheet";
                }
                String str3 = str;
                if ("cny".equals(LegalCurrencyConfigUtil.y())) {
                    str2 = "cny";
                } else {
                    str2 = "usd";
                }
                ContractWebActivity.ii(OrderTutorialStep2Fragment.this.getActivity(), H.getSymbol(), str3, str2, H.getContractCode(), H.getContractShortType(), FutureContractInfo.MARGIN_CROSS, 4);
            }
        }

        public Observable<List<LevelAvailableMarginInfo>> O0(TradeType tradeType, String str, int i11) {
            return null;
        }

        public void P0(String str) {
            OrderTutorialStep2Fragment.this.ai().C(str);
            OrderTutorialStep2Fragment.this.f75016p.setText(String.format(OrderTutorialStep2Fragment.this.getString(R.string.contract_lever), new Object[]{str}));
            OrderTutorialStep2Fragment orderTutorialStep2Fragment = OrderTutorialStep2Fragment.this;
            orderTutorialStep2Fragment.Uh(orderTutorialStep2Fragment.f75012l.getText().toString());
        }

        public String[] Q0(String str, LevelAvailableMarginInfo levelAvailableMarginInfo) {
            return new String[0];
        }

        public boolean R0(LeverSelectDialogFragment leverSelectDialogFragment, String str) {
            OrderTutorialStep2Fragment.this.ki(leverSelectDialogFragment, str);
            return true;
        }
    }

    public class e extends EasySubscriber<LinearSwapLeverRate> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LeverSelectDialogFragment f75033b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f75034c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f75035d;

        public class a extends EasySubscriber<Object> {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ LeverSelectDialogFragment f75037b;

            public a(LeverSelectDialogFragment leverSelectDialogFragment) {
                this.f75037b = leverSelectDialogFragment;
            }

            public void onError2(Throwable th2) {
                super.onError2(th2);
                this.f75037b.Zh();
            }

            public void onFailed(APIStatusErrorException aPIStatusErrorException) {
                super.onFailed(aPIStatusErrorException);
                this.f75037b.Zh();
            }

            public void onNext(Object obj) {
                super.onNext(obj);
                l.c().d(TradeType.LINEAR_SWAP, false).compose(RxJavaHelper.t((g) null)).subscribe(new BaseSubscriber());
                this.f75037b.oi();
            }
        }

        public e(LeverSelectDialogFragment leverSelectDialogFragment, String str, String str2) {
            this.f75033b = leverSelectDialogFragment;
            this.f75034c = str;
            this.f75035d = str2;
        }

        @SensorsDataInstrumented
        public static /* synthetic */ void d(LeverSelectDialogFragment leverSelectDialogFragment, View view) {
            leverSelectDialogFragment.Zh();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ Observable e(String str, String str2, Object obj) {
            return OrderTutorialStep2Fragment.this.Zh(str, str2);
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void f(String str, String str2, LeverSelectDialogFragment leverSelectDialogFragment, View view) {
            h8.a.a().agreeHighLever().b().flatMap(new t(this, str, str2)).compose(RxJavaHelper.t((g) null)).subscribe(new a(leverSelectDialogFragment));
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        /* renamed from: g */
        public void onNext(LinearSwapLeverRate linearSwapLeverRate) {
            super.onNext(linearSwapLeverRate);
            this.f75033b.oi();
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            this.f75033b.Zh();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            if (!"1233".equals(aPIStatusErrorException.getErrCode()) || r.x().X()) {
                if (BaseModuleConfig.a().c() && aPIStatusErrorException.getErrCode().equals(EasySubscriber.ERROR_CODE_1451)) {
                    this.f75033b.Bi(true);
                } else if (BaseModuleConfig.a().c() || !aPIStatusErrorException.getErrCode().equals(EasySubscriber.ERROR_CODE_1450)) {
                    super.onFailed(aPIStatusErrorException);
                } else {
                    this.f75033b.Bi(false);
                }
                this.f75033b.Zh();
                return;
            }
            us.e.a(this.f75033b.getActivity(), new zm.r(this.f75033b), new s(this, this.f75034c, this.f75035d, this.f75033b));
        }
    }

    public class f implements TextWatcher {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f75039b;

        public f(int i11) {
            this.f75039b = i11;
        }

        public void afterTextChanged(Editable editable) {
            OrderTutorialStep2Fragment.this.Uh(editable.toString());
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            if (charSequence.toString().contains(InstructionFileId.DOT) && (charSequence.length() - 1) - charSequence.toString().indexOf(InstructionFileId.DOT) > this.f75039b) {
                charSequence = charSequence.toString().subSequence(0, charSequence.toString().indexOf(InstructionFileId.DOT) + this.f75039b + 1);
                OrderTutorialStep2Fragment.this.f75012l.setText(charSequence);
                OrderTutorialStep2Fragment.this.f75012l.setSelection(charSequence.length());
            }
            if (charSequence.toString().trim().equals(InstructionFileId.DOT)) {
                String str = "0" + charSequence;
                OrderTutorialStep2Fragment.this.f75012l.setText(str);
                OrderTutorialStep2Fragment.this.f75012l.setSelection(str.length());
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ci(View view, boolean z11) {
        this.f75020t.setSelected(z11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void di(Void voidR) {
        pi();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void fi(HBDialogFragment hBDialogFragment) {
        sn.f.y(getActivity(), (ZopimChat.SessionConfig) null);
        hBDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void gi(Void voidR) {
        if (l.c().i(TradeType.LINEAR_SWAP)) {
            List<String> d11 = LinearSwapAllowLevelController.d(ai().H().getContractCode(), 1);
            if (d11 == null || d11.size() <= 0) {
                DialogUtils.b0(getActivity(), getString(R.string.swap_limit), getString(R.string.swap_limit_hint), "", getString(R.string.global_string_cancel), getString(R.string.account_item_contact), zm.l.f63090a, new k(this));
                return;
            }
            this.f75023w.ui(true);
            this.f75023w.tc(d11);
            oi();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void hi(Void voidR) {
        if (!r.x().F0()) {
            rn.c.i().m(getContext(), new JumpTarget((Intent) null, (Intent) null));
            return;
        }
        String obj = this.f75012l.getText().toString();
        an.a ai2 = ai();
        ai2.J(obj);
        FutureContractInfo H = ai2.H();
        LinearSwapAccountInfo o11 = ai2.o();
        AccountBalanceInfoV5 accountBalanceInfoV5 = this.f75021u;
        try {
            if (Double.parseDouble(obj) > Double.parseDouble(m.u0((accountBalanceInfoV5 == null || accountBalanceInfoV5.getAvailableMargin() == null) ? o11.getMarginAvailable() : this.f75021u.getAvailableMargin(), 12, FuturePrecisionUtil.w(H.getContractCode(), H.getContractShortType(), H.getOptionCode())))) {
                HuobiToastUtil.g(R.string.n_linear_swap_guide_asset_toast);
                return;
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        String symbol = H.getSymbol();
        String plainString = BigDecimal.valueOf(ai2.l()).toPlainString();
        String n11 = ai2.n();
        BigDecimal a11 = m.a(plainString);
        if (!Vh(getContext(), H.getQuoteCurrency(), m.a(FutureUnitUtil.e(m.a(n11).toPlainString(), plainString, H.getContractFace(), TradeType.LINEAR_SWAP, FuturePrecisionUtil.g(symbol))).setScale(FuturePrecisionUtil.B(), 1), H, a11)) {
            ni();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean ji(AccountBalanceInfoV5 accountBalanceInfoV5, LinearSwapLeverRate linearSwapLeverRate) {
        this.f75021u = accountBalanceInfoV5;
        ai().C(linearSwapLeverRate.getLeverRate());
        return Boolean.TRUE;
    }

    public void Ah() {
        super.Ah();
        Th();
    }

    public final void Th() {
        this.f75012l.addTextChangedListener(new f(4));
    }

    public final void Uh(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(InstructionFileId.DOT, str)) {
            this.f75017q.setText("--");
            this.f75019s.setEnabled(false);
            return;
        }
        an.a ai2 = ai();
        String symbol = ai2.H().getSymbol();
        String h11 = ai2.h();
        double l11 = ai2.l();
        if (TextUtils.isEmpty(h11)) {
            this.f75017q.setText("--");
            this.f75019s.setEnabled(false);
        } else if (l11 == 0.0d) {
            this.f75017q.setText("--");
            this.f75019s.setEnabled(false);
        } else {
            double parseDouble = Double.parseDouble(str);
            if (parseDouble == 0.0d) {
                this.f75017q.setText("--");
                this.f75019s.setEnabled(false);
                return;
            }
            int r11 = i.r(symbol);
            String m11 = m.m(((parseDouble * ((double) Integer.parseInt(h11))) / l11) + "", r11);
            ai2.w(m11);
            this.f75017q.setText(m11);
            this.f75019s.setEnabled(true);
        }
    }

    public final boolean Vh(Context context, String str, BigDecimal bigDecimal, FutureContractInfo futureContractInfo, BigDecimal bigDecimal2) {
        if (bigDecimal.compareTo(BigDecimal.ONE) >= 0 || bigDecimal2.compareTo(BigDecimal.ZERO) == 0) {
            return false;
        }
        String C = m.C(Double.parseDouble(futureContractInfo.getContractFace()) * ai().l(), 4);
        HuobiToastUtil.l(context, String.format(context.getString(R.string.contract_trade_lowest_amount), new Object[]{C, str}));
        return true;
    }

    public final Subscriber<List<LinearSwapCrossAccountInfo>> Wh(String str, String str2, String str3) {
        return new c(str2, str3, str);
    }

    public void Xh() {
        this.f75025y.dismiss();
    }

    public final void Yh() {
        an.a ai2 = ai();
        LinearSwapAccountInfo o11 = ai2.o();
        FutureContractInfo H = ai2.H();
        AccountBalanceInfoV5 accountBalanceInfoV5 = this.f75021u;
        String marginAvailable = (accountBalanceInfoV5 == null || accountBalanceInfoV5.getAvailableMargin() == null) ? o11.getMarginAvailable() : this.f75021u.getAvailableMargin();
        String h11 = ai2.h();
        try {
            this.f75014n.setText(m.u0(marginAvailable, 12, FuturePrecisionUtil.w(H.getContractCode(), H.getContractShortType(), H.getOptionCode())));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        this.f75016p.setText(String.format(getString(R.string.contract_lever), new Object[]{h11}));
        Uh(this.f75012l.getText().toString());
    }

    public final Observable<LinearSwapLeverRate> Zh(String str, String str2) {
        boolean z11;
        h8.b a11 = h8.a.a();
        if (SPUtil.j()) {
            z11 = pk.e.a().c();
        } else {
            z11 = pk.e.a().b(true, str);
        }
        return a11.I(str, str2, FutureContractInfo.MARGIN_CROSS, z11).b();
    }

    public final an.a ai() {
        return ((OrderTutorialActivity) getActivity()).ph();
    }

    public final void bi() {
        if (ai().H().getQuoteCurrency().equalsIgnoreCase("husd")) {
            UnifyTransferActivity.Vh(getActivity(), "husd", BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP, false, (String) null, false, 2);
        } else {
            UnifyTransferActivity.Vh(getActivity(), "usdt", BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP, false, (String) null, false, 2);
        }
    }

    public void initViews() {
        super.initViews();
        this.f75012l = (EditText) this.f67460i.b(R.id.et_amount);
        this.f75020t = this.f67460i.b(R.id.et_container);
        this.f75013m = (TextView) this.f67460i.b(R.id.tv_amount_quote_symbol);
        this.f75014n = (TextView) this.f67460i.b(R.id.tv_available);
        this.f75015o = (TextView) this.f67460i.b(R.id.tv_available_quote_symbol);
        this.f75016p = (TextView) this.f67460i.b(R.id.tv_lever);
        this.f75017q = (TextView) this.f67460i.b(R.id.tv_open_order_amount);
        this.f75018r = (TextView) this.f67460i.b(R.id.tv_symbol);
        this.f75019s = this.f67460i.b(R.id.tv_next);
        this.f75012l.setOnFocusChangeListener(new j(this));
        Observable<Void> a11 = dw.a.a(this.f67460i.b(R.id.tv_transfer));
        TimeUnit timeUnit = TimeUnit.SECONDS;
        a11.throttleFirst(1, timeUnit).subscribe(new n(this));
        dw.a.a(this.f75016p).throttleFirst(1, timeUnit).subscribe(new zm.m(this));
        dw.a.a(this.f75019s).throttleFirst(1, timeUnit).subscribe(new o(this));
    }

    public final void ki(LeverSelectDialogFragment leverSelectDialogFragment, String str) {
        String contractCode = ai().H().getContractCode();
        Zh(contractCode, str).compose(RxJavaHelper.t(zh())).subscribe(new e(leverSelectDialogFragment, contractCode, str));
    }

    public final void li(String str) {
        Observable.zip(h8.a.a().queryAccountBalance().b(), h8.a.a().D(str, FutureContractInfo.MARGIN_CROSS).b(), new q(this)).compose(RxJavaHelper.t(zh())).subscribe(new a());
    }

    public void mi() {
        this.f75019s.setEnabled(false);
        this.f75020t.setSelected(false);
        this.f75012l.setText((CharSequence) null);
        this.f75014n.setText("--");
        this.f75016p.setText("--");
        this.f75017q.setText("--");
    }

    public final void ni() {
        this.f75025y.show(getChildFragmentManager(), "OpenOrderDialogFragment");
    }

    public final void oi() {
        an.a ai2 = ai();
        FutureContractInfo H = ai2.H();
        this.f75023w.wi(1);
        this.f75023w.bc(H.getSymbol());
        this.f75023w.xi(a7.e.m(getContext(), H.getSymbol(), ai2.H().getQuoteCurrency(), ai2.H().getContractCode(), ai2.H().getContractType(), 1));
        this.f75023w.vi(this.f75024x);
        this.f75023w.ti(ai2.h());
        this.f75023w.setTradeType(TradeType.LINEAR_SWAP);
        this.f75023w.zi(ContractWebActivity.Eh(4));
        this.f75023w.si(ai2.H().getContractCode());
        this.f75023w.show(getChildFragmentManager(), "LinearSwapLeverSelectDialogFragment");
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_order_tutorial_step2, viewGroup, false);
    }

    public final void pi() {
        if (!rn.c.i().d(getActivity(), new JumpTarget((Intent) null, (Intent) null))) {
            l c11 = l.c();
            TradeType tradeType = TradeType.LINEAR_SWAP;
            if (c11.g(tradeType) == null) {
                HuobiToastUtil.j(R.string.contract_account_loading);
            } else if (l.c().i(tradeType)) {
                bi();
            } else {
                qk.m.c(getActivity(), tradeType);
            }
        }
    }

    public void uh(boolean z11) {
        super.uh(z11);
        if (z11) {
            FutureContractInfo H = ai().H();
            if (H != null) {
                String contractCode = H.getContractCode();
                String quoteCurrency = H.getQuoteCurrency();
                String businessType = H.getBusinessType();
                String contractShortType = H.getContractShortType();
                this.f75018r.setText(H.getSymbol());
                this.f75013m.setText(quoteCurrency);
                this.f75015o.setText(quoteCurrency);
                if (SPUtil.j()) {
                    li(contractCode);
                } else {
                    h8.a.a().J(quoteCurrency, TtmlNode.COMBINE_ALL).b().retryWhen(p.f63094b).compose(RxJavaHelper.t(zh())).subscribe(Wh(contractCode, quoteCurrency, businessType));
                }
                h8.a.a().j(true, contractShortType, this.f75022v);
                return;
            }
            return;
        }
        FutureContractInfo H2 = ai().H();
        if (H2 != null) {
            h8.a.a().j(false, H2.getContractShortType(), this.f75022v);
        }
    }
}
