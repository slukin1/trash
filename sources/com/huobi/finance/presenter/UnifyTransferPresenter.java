package com.huobi.finance.presenter;

import al.b0;
import al.s0;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.fragment.app.FragmentManager;
import bj.o0;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.network.response.StringStatusResponse;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.network.rx.SilentSubscriber;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.future.bean.FutureProductInfo;
import com.hbg.lib.data.future.controller.FutureProductInfoController;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.contract.retrofit.ContractRetrofit;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.network.hbg.core.bean.C2CAccountInNetAssetResult;
import com.hbg.lib.network.hbg.core.bean.C2CAccountOutNetAssetInfo;
import com.hbg.lib.network.hbg.core.bean.C2CTransferOutQuotaInfo;
import com.hbg.lib.network.hbg.core.bean.CopyTradingAssetInfo;
import com.hbg.lib.network.hbg.core.bean.MineAccountItem;
import com.hbg.lib.network.hbg.core.util.C2CTransferDirect;
import com.hbg.lib.network.linear.swap.controller.LinearSwapProductInfoController;
import com.hbg.lib.network.linear.swap.core.bean.AccountBalanceInfoV5;
import com.hbg.lib.network.linear.swap.core.bean.AccountInfoV5Item;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapAccountInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapProductInfo;
import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import com.hbg.lib.network.pro.core.bean.SuperMarginTransferLimit;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.pro.core.util.TransferAccountType;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.hbg.lib.network.retrofit.util.SPUtil;
import com.hbg.lib.network.swap.core.bean.ProductInfo;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController;
import com.hbg.lib.network.uc.core.utils.UcHelper;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.contract.service.ContractService;
import com.huobi.account.entity.SubaccountQueryData;
import com.huobi.c2c.util.n;
import com.huobi.c2c.util.o;
import com.huobi.contract.entity.ContractAccountInfo;
import com.huobi.contract.entity.ContractCoinInfo;
import com.huobi.contract.entity.ContractUserInfo;
import com.huobi.contract.entity.LinearSwapBalanceItem;
import com.huobi.contract.entity.OptionBalanceItem;
import com.huobi.contract.entity.SwapBalanceItem;
import com.huobi.contract.helper.ContractCurrencyUtils;
import com.huobi.contract.helper.ContractUserInfoProvider;
import com.huobi.contract.ui.ContractTradeBaseFragment;
import com.huobi.coupon.bean.CouponReturn;
import com.huobi.finance.api.FinanceService;
import com.huobi.finance.bean.BaseAssetInfo;
import com.huobi.finance.bean.ContractDataTotal;
import com.huobi.finance.bean.ContractTransferResult;
import com.huobi.finance.bean.FinanceRecordItem;
import com.huobi.finance.bean.LinearSwapDataTotal;
import com.huobi.finance.bean.OptionDataTotal;
import com.huobi.finance.bean.OtcOptionDataTotal;
import com.huobi.finance.bean.OtcOptionsDetailInfo;
import com.huobi.finance.bean.SwapDataTotal;
import com.huobi.finance.bean.SymbolCurrencyEntity;
import com.huobi.finance.model.AssetDataCacheManager;
import com.huobi.finance.model.subaccount.LinearSwapDataProvider;
import com.huobi.finance.model.subaccount.OptionDataProvider;
import com.huobi.finance.transfer.ui.ContractChooseCurrencyActivity;
import com.huobi.finance.transfer.ui.LinearSwapChooseCurrencyActivity;
import com.huobi.finance.transfer.ui.MineChooseCurrencyActivity;
import com.huobi.finance.transfer.ui.OptionChooseCurrencyActivity;
import com.huobi.finance.transfer.ui.OtcChooseCurrencyActivity;
import com.huobi.finance.transfer.ui.OtcOptionChooseCurrencyActivity;
import com.huobi.finance.transfer.ui.SuperMarginChooseCurrencyActivity;
import com.huobi.finance.transfer.ui.SwapChooseCurrencyActivity;
import com.huobi.finance.ui.AccountChooseActivity;
import com.huobi.finance.ui.CurrencyHistoryActivity;
import com.huobi.finance.ui.ExperienceFundTransferReminderDialog;
import com.huobi.litere.bean.LiteTradeBean;
import com.huobi.litere.helper.LiteReHelper;
import com.huobi.litere.trade.ui.LiteReTradeFlutterActivity;
import com.huobi.login.usercenter.data.source.bean.ProUserToken;
import com.huobi.login.usercenter.data.source.bean.TradeRiskReminder;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.huobi.margin.entity.MarginBalanceQueryData;
import com.huobi.otc.bean.MarketCoin;
import com.huobi.otc.enums.OtcTradeAreaEnum;
import com.huobi.otc.utils.OtcMarketPriceConfigUtil;
import com.huobi.otcoption.util.OtcOptionsEntryHelper;
import com.huobi.supermargin.bean.MarginCurrency;
import com.huobi.supermargin.bean.TransferOutQuota;
import com.huobi.supermargin.service.SuperMarginService;
import com.huobi.swap.ui.SwapTradeBaseFragment;
import com.huobi.utils.k0;
import com.xiaomi.mipush.sdk.Constants;
import d7.a1;
import d7.c0;
import dt.h2;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import jp.d1;
import jp.l;
import m9.z;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import tg.r;
import tq.p;

public class UnifyTransferPresenter extends ActivityPresenter<m> {
    public boolean A = false;
    public boolean B = true;
    public boolean C;
    public TransferOutQuota D;
    public int E;
    public boolean F = false;
    public Map<String, C2CTransferOutQuotaInfo> G = new HashMap();
    public Map<String, String> H = new HashMap();
    public Map<String, String> I = new HashMap();
    public Map<String, String> J = new HashMap();
    public Map<String, String> K = new HashMap();
    public Map<String, String> L = new HashMap();
    public Map<String, String> M = new HashMap();
    public Map<String, String> N = new HashMap();
    public Map<String, String> O = new HashMap();
    public Map<String, String> P = new HashMap();
    public String Q;
    public String R;
    public String S;

    /* renamed from: a  reason: collision with root package name */
    public String f45690a;

    /* renamed from: b  reason: collision with root package name */
    public String f45691b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f45692c;

    /* renamed from: d  reason: collision with root package name */
    public SymbolCurrencyEntity f45693d;

    /* renamed from: e  reason: collision with root package name */
    public SymbolCurrencyEntity f45694e;

    /* renamed from: f  reason: collision with root package name */
    public SymbolCurrencyEntity f45695f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f45696g;

    /* renamed from: h  reason: collision with root package name */
    public List<Observable<Boolean>> f45697h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public Map<String, String> f45698i = new HashMap();

    /* renamed from: j  reason: collision with root package name */
    public List<ContractCoinInfo> f45699j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    public List<ProductInfo> f45700k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    public List<FutureProductInfo> f45701l = new ArrayList();

    /* renamed from: m  reason: collision with root package name */
    public List<String> f45702m = new ArrayList();

    /* renamed from: n  reason: collision with root package name */
    public List<LinearSwapProductInfo> f45703n = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    public List<MineAccountItem> f45704o = new ArrayList();

    /* renamed from: p  reason: collision with root package name */
    public List<MarginCurrency> f45705p = new ArrayList();

    /* renamed from: q  reason: collision with root package name */
    public List<MarketCoin.Coin> f45706q = new ArrayList();

    /* renamed from: r  reason: collision with root package name */
    public List<SymbolBean> f45707r = new ArrayList();

    /* renamed from: s  reason: collision with root package name */
    public Map<String, Map<String, String>> f45708s = new HashMap();

    /* renamed from: t  reason: collision with root package name */
    public Map<String, Map<String, String>> f45709t = new HashMap();

    /* renamed from: u  reason: collision with root package name */
    public String f45710u = "2";

    /* renamed from: v  reason: collision with root package name */
    public String f45711v = "1";

    /* renamed from: w  reason: collision with root package name */
    public Subscription f45712w;

    /* renamed from: x  reason: collision with root package name */
    public boolean f45713x;

    /* renamed from: y  reason: collision with root package name */
    public boolean f45714y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f45715z = SPUtil.j();

    public class a implements l.c {
        public a() {
        }

        public void a() {
            UnifyTransferPresenter.this.getActivity().finish();
        }
    }

    public class b extends RequestCallback1<Boolean> {
        public b() {
        }

        /* renamed from: a */
        public void onRequestSuccess(Boolean bool) {
            boolean unused = UnifyTransferPresenter.this.C = bool.booleanValue();
        }
    }

    public class c extends EasySubscriber<TradeRiskReminder> {
        public c() {
        }

        /* renamed from: a */
        public void onNext(TradeRiskReminder tradeRiskReminder) {
            super.onNext(tradeRiskReminder);
            boolean unused = UnifyTransferPresenter.this.F = "1".equals(tradeRiskReminder.getState());
            ((m) UnifyTransferPresenter.this.getUI()).Ge();
        }

        public void onError2(Throwable th2) {
            boolean unused = UnifyTransferPresenter.this.F = false;
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            boolean unused = UnifyTransferPresenter.this.F = false;
        }
    }

    public class d extends EasySubscriber<Boolean> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f45719b;

        public d(boolean z11) {
            this.f45719b = z11;
        }

        /* renamed from: a */
        public void onNext(Boolean bool) {
            super.onNext(bool);
            ((m) UnifyTransferPresenter.this.getUI()).R8();
            boolean unused = UnifyTransferPresenter.this.B = false;
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            th2.printStackTrace();
            if (this.f45719b) {
                ((m) UnifyTransferPresenter.this.getUI()).W0();
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            aPIStatusErrorException.printStackTrace();
            if (this.f45719b) {
                ((m) UnifyTransferPresenter.this.getUI()).W0();
            }
        }
    }

    public class e implements ExperienceFundTransferReminderDialog.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f45721a;

        public e(String str) {
            this.f45721a = str;
        }

        public void a() {
            UnifyTransferPresenter.this.F1(this.f45721a);
        }

        public void b() {
        }
    }

    public class f extends RequestCallback1<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ C2CTransferDirect f45723a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f45724b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f45725c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f45726d;

        public f(C2CTransferDirect c2CTransferDirect, String str, String str2, String str3) {
            this.f45723a = c2CTransferDirect;
            this.f45724b = str;
            this.f45725c = str2;
            this.f45726d = str3;
        }

        /* renamed from: a */
        public void onRequestSuccess(Boolean bool) {
            if (bool.booleanValue()) {
                UnifyTransferPresenter.this.h4(this.f45723a, this.f45724b, this.f45725c, this.f45726d);
            } else {
                n.h(UnifyTransferPresenter.this.getActivity(), (u6.g) UnifyTransferPresenter.this.getUI());
            }
        }

        public void onRequestFailure(Throwable th2) {
            UnifyTransferPresenter.this.h4(this.f45723a, this.f45724b, this.f45725c, this.f45726d);
        }
    }

    public class g extends EasySubscriber<ContractCurrencyInfo> {
        public g() {
        }

        /* renamed from: a */
        public void onNext(ContractCurrencyInfo contractCurrencyInfo) {
            super.onNext(contractCurrencyInfo);
            if (contractCurrencyInfo != null && UnifyTransferPresenter.this.getActivity() != null) {
                ContractTradeBaseFragment.Ri(UnifyTransferPresenter.this.getActivity(), contractCurrencyInfo);
                UnifyTransferPresenter.this.getActivity().finish();
            }
        }
    }

    public class h extends q6.d<Boolean> {
        public h(u6.g gVar) {
            super(gVar);
        }

        /* renamed from: f */
        public void onNext(Boolean bool) {
            super.onNext(bool);
            if (bool.booleanValue()) {
                HuobiToastUtil.s(R.string.transfer_successfully);
                UnifyTransferPresenter.this.L3(false);
            }
        }
    }

    public class i extends q6.d<Boolean> {
        public i(u6.g gVar) {
            super(gVar);
        }

        /* renamed from: f */
        public void onNext(Boolean bool) {
            super.onNext(bool);
            if (bool.booleanValue()) {
                HuobiToastUtil.s(R.string.transfer_successfully);
                UnifyTransferPresenter.this.L3(false);
            }
        }
    }

    public class j extends q6.d<Boolean> {
        public j(u6.g gVar) {
            super(gVar);
        }

        /* renamed from: f */
        public void onNext(Boolean bool) {
            super.onNext(bool);
            if (bool.booleanValue()) {
                HuobiToastUtil.s(R.string.transfer_successfully);
                UnifyTransferPresenter.this.L3(false);
            }
        }
    }

    public class k extends q6.b<Object> {
        public k(u6.g gVar) {
            super(gVar);
        }

        public void onRequestSuccess(Object obj) {
            super.onRequestSuccess(obj);
            HuobiToastUtil.s(R.string.transfer_successfully);
            UnifyTransferPresenter.this.L3(false);
        }
    }

    public class l extends q6.b<Object> {
        public l(u6.g gVar) {
            super(gVar);
        }

        public void onRequestSuccess(Object obj) {
            super.onRequestSuccess(obj);
            UnifyTransferPresenter.this.k4();
            UnifyTransferPresenter.this.L3(false);
        }
    }

    public interface m extends u6.g {
        void Ge();

        void If(String str);

        void R8();

        void W0();

        void b4(String str);

        void b9(String str);

        void gh(String str);

        boolean isAvailable();

        void q2();
    }

    public static /* synthetic */ void A2(Throwable th2) {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void B2(String str, HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        if (BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP.equals(this.f45711v)) {
            q4(str);
        } else if ("1".equals(this.f45711v)) {
            I4(str, 4);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void B3(Object obj) {
        HuobiToastUtil.s(R.string.transfer_successfully);
        k4();
        L3(false);
    }

    public static /* synthetic */ void C3(APIStatusErrorException aPIStatusErrorException) {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void D2(boolean z11, Long l11) {
        Q3(z11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void D3(Long l11) {
        if (l11 != null) {
            k4();
        }
        L3(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean E2(AccountBalanceInfoV5 accountBalanceInfoV5) {
        if (accountBalanceInfoV5 != null) {
            List<AccountInfoV5Item> details = accountBalanceInfoV5.getDetails();
            if (details != null && !details.isEmpty()) {
                for (AccountInfoV5Item next : details) {
                    int d11 = FuturePrecisionUtil.d(this.f45693d.getBaseCurrency());
                    String m11 = i6.m.m(next.getWithdrawAvailable(), d11);
                    Map<String, String> map = this.J;
                    String currency = next.getCurrency();
                    Locale locale = Locale.US;
                    map.put(currency.toLowerCase(locale), m11);
                    this.K.put(next.getCurrency().toLowerCase(locale), i6.m.m(next.getVoucher(), d11));
                }
            }
            dn.a.d().g(accountBalanceInfoV5.getVoucher());
        }
        return Boolean.TRUE;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable E3(StringStatusResponse stringStatusResponse) {
        if (TextUtils.isEmpty(stringStatusResponse.getErrCode()) || !stringStatusResponse.getErrCode().equalsIgnoreCase("account-transfer-need-face")) {
            return Observable.just(stringStatusResponse);
        }
        d1.a(getActivity(), false);
        return Observable.empty();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean F2(List list, List list2) {
        if (list != null && !list.isEmpty()) {
            this.f45709t.clear();
            for (C2CAccountOutNetAssetInfo next : ((C2CAccountInNetAssetResult) list.get(0)).getList()) {
                String baseCurrency = this.f45693d.getBaseCurrency();
                String quoteCurrency = this.f45693d.getQuoteCurrency();
                Map map = this.f45709t.get(this.f45693d.getName());
                if (map == null) {
                    map = new HashMap(2);
                    this.f45709t.put(this.f45693d.getName(), map);
                }
                if (baseCurrency != null && baseCurrency.equals(next.getCurrency()) && "trade".equalsIgnoreCase(next.getType())) {
                    map.put(baseCurrency, m4(next.getBalance(), baseCurrency));
                }
                if (quoteCurrency != null && quoteCurrency.equals(next.getCurrency()) && "trade".equalsIgnoreCase(next.getType())) {
                    map.put(quoteCurrency, m4(next.getBalance(), quoteCurrency));
                }
            }
        }
        if (list2 != null && !list2.isEmpty()) {
            this.G.clear();
            Iterator it2 = list2.iterator();
            while (it2.hasNext()) {
                C2CTransferOutQuotaInfo c2CTransferOutQuotaInfo = (C2CTransferOutQuotaInfo) it2.next();
                this.G.put(c2CTransferOutQuotaInfo.getCurrency(), c2CTransferOutQuotaInfo);
            }
        }
        return Boolean.TRUE;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean G2(ContractDataTotal contractDataTotal) {
        if (!(contractDataTotal == null || contractDataTotal.getDetailInfos() == null || contractDataTotal.getDetailInfos().isEmpty())) {
            for (BaseAssetInfo baseAssetInfo : contractDataTotal.getDetailInfos()) {
                if ((baseAssetInfo instanceof ContractAccountInfo) && baseAssetInfo.getDelegateKey() != null) {
                    this.H.put(baseAssetInfo.getDelegateKey().toLowerCase(Locale.US), n4(((ContractAccountInfo) baseAssetInfo).getAvailableWithdraw(), baseAssetInfo.getDelegateKey()));
                }
            }
        }
        return Boolean.TRUE;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean H2(int i11, CopyTradingAssetInfo copyTradingAssetInfo) {
        if (i11 == 1) {
            this.J.put("USDT", i6.m.m(copyTradingAssetInfo.getWithdrawAvailable(), FuturePrecisionUtil.d("USDT")));
            this.S = copyTradingAssetInfo.getTrailFundBalance();
        } else if (i11 == 2) {
            this.Q = i6.m.m(copyTradingAssetInfo.getWithdrawAvailable(), FuturePrecisionUtil.d("USDT"));
            this.R = copyTradingAssetInfo.getTrailFundBalance();
        } else {
            this.f45698i.put("usdt", L4(copyTradingAssetInfo.getSpotAvailable(), "usdt"));
        }
        return Boolean.TRUE;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void H3(String str, HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        if (this.E == 3) {
            getActivity().finish();
            return;
        }
        k0.O(getActivity(), a1.v().a0(TradeType.PRO, str), true);
        getActivity().finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void I3(String str, String str2) {
        if (LiteReHelper.a().b()) {
            HuobiToastUtil.s(R.string.transfer_successfully);
        } else {
            DialogUtils.c0(getActivity(), getResources().getString(R.string.n_transfer_dialog_tip_succ), (String) null, (String) null, getResources().getString(R.string.otc_dialog_go_trade), ea.f45869a, new ba(this, str));
        }
        L3(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void J3(Long l11) {
        if (l11 != null) {
            k4();
        }
        L3(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean K2(Boolean bool) {
        List<SymbolBean> Z = a1.v().Z(TradeType.MARGIN);
        List<MarketCoin.Coin> e11 = OtcMarketPriceConfigUtil.e();
        List<ContractCoinInfo> d11 = ContractCurrencyUtils.d();
        List<ProductInfo> a11 = qs.a.f84586a.a();
        List<LinearSwapProductInfo> g11 = LinearSwapProductInfoController.o().g();
        List<FutureProductInfo> c11 = FutureProductInfoController.d().c();
        List<String> e12 = c0.e();
        List<MarginCurrency> f11 = ks.d.f();
        List<MineAccountItem> c12 = b0.c();
        if (Z != null && !Z.isEmpty()) {
            this.f45707r.clear();
            this.f45707r.addAll(Z);
        }
        if (e11 != null && !e11.isEmpty()) {
            this.f45706q.clear();
            for (MarketCoin.Coin next : e11) {
                if (next != null && next.isTransfer()) {
                    this.f45706q.add(next);
                }
            }
        }
        if (d11 != null && !d11.isEmpty()) {
            this.f45699j.clear();
            this.f45699j.addAll(d11);
        }
        if (c12 != null && !c12.isEmpty()) {
            this.f45704o.clear();
            this.f45704o.addAll(c12);
        }
        if (a11 != null && !a11.isEmpty()) {
            this.f45700k.clear();
            this.f45700k.addAll(a11);
        }
        if (g11 != null && !g11.isEmpty()) {
            this.f45703n.clear();
            this.f45703n.addAll(g11);
        }
        if (c11 != null && !c11.isEmpty()) {
            this.f45701l.clear();
            this.f45701l.addAll(c11);
        }
        if (!e12.isEmpty()) {
            this.f45702m.clear();
            this.f45702m.addAll(e12);
        }
        if (f11 != null && !f11.isEmpty()) {
            this.f45705p.clear();
            this.f45705p.addAll(f11);
        }
        if (!this.A) {
            this.A = true;
            l2();
            String V1 = V1();
            if ("4".equals(V1) && !SP.l("SP_KEY_TRANSFER_CONTRACT_TIPS", false)) {
                new DialogUtils.b.d(getActivity()).c1(getActivity().getString(R.string.allow_access_dialog_title)).x0(true).C0(getString(R.string.transfer_contract_burrow_risk_dialog_content)).y0(getActivity().getString(R.string.contract_trigger_order_change_not_show)).v0(f8.f45880a).P0(getResources().getString(R.string.contract_trade_i_know)).q0(false).Q0(o0.f12469a).j0().show(getActivity().getSupportFragmentManager(), "");
            } else if (BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_SWAP.equals(V1) && !SP.l("SP_KEY_TRANSFER_SWAP_TIPS", false)) {
                new DialogUtils.b.d(getActivity()).c1(getActivity().getString(R.string.allow_access_dialog_title)).x0(true).C0(getString(R.string.n_balance_swap_risk_tips)).y0(getActivity().getString(R.string.contract_trigger_order_change_not_show)).v0(u7.f46135a).P0(getResources().getString(R.string.contract_trade_i_know)).q0(false).Q0(o0.f12469a).j0().show(getActivity().getSupportFragmentManager(), "");
            }
        }
        K3(true);
        e4();
        return bool;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean L2(Map map) {
        this.f45698i.clear();
        if (map != null && !map.isEmpty()) {
            for (Map.Entry entry : map.entrySet()) {
                if (entry.getKey() != null) {
                    this.f45698i.put(((String) entry.getKey()).toLowerCase(Locale.US), L4((String) map.get(entry.getKey()), (String) entry.getKey()));
                }
            }
        }
        return Boolean.TRUE;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean M2(LinearSwapDataTotal linearSwapDataTotal) {
        if (!(linearSwapDataTotal == null || linearSwapDataTotal.getDetailInfos() == null || linearSwapDataTotal.getDetailInfos().isEmpty())) {
            for (BaseAssetInfo baseAssetInfo : linearSwapDataTotal.getDetailInfos()) {
                if (baseAssetInfo instanceof LinearSwapBalanceItem) {
                    LinearSwapBalanceItem linearSwapBalanceItem = (LinearSwapBalanceItem) baseAssetInfo;
                    LinearSwapAccountInfo mLinearSwapAccountInfo = linearSwapBalanceItem.getMLinearSwapAccountInfo();
                    StringBuilder sb2 = new StringBuilder();
                    String symbol = mLinearSwapAccountInfo.getSymbol();
                    Locale locale = Locale.US;
                    sb2.append(symbol.toLowerCase(locale));
                    sb2.append(mLinearSwapAccountInfo.getTradePartition().toLowerCase(locale));
                    String sb3 = sb2.toString();
                    LinearSwapAccountInfo mLinearSwapAccountInfo2 = linearSwapBalanceItem.getMLinearSwapAccountInfo();
                    int d11 = FuturePrecisionUtil.d(this.f45693d.getBaseCurrency());
                    String m11 = i6.m.m(mLinearSwapAccountInfo2.getAvailableWithdraw(), d11);
                    String m12 = i6.m.m(mLinearSwapAccountInfo2.getTrailFund(), d11);
                    if (mLinearSwapAccountInfo2.getSymbol().equals("USDT")) {
                        dn.a.d().g(m12);
                    }
                    this.J.put(sb3, m11);
                    this.K.put(sb3, m12);
                }
            }
        }
        return Boolean.TRUE;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean N2(List list) {
        if (list != null && !list.isEmpty()) {
            for (SubaccountQueryData next : ((MarginBalanceQueryData) list.get(0)).getList()) {
                if ("transfer-out-available".equals(next.getType())) {
                    if (this.f45708s.get(this.f45693d.getName()) == null) {
                        this.f45708s.put(this.f45693d.getName(), new HashMap());
                    }
                    String baseCurrency = this.f45693d.getBaseCurrency();
                    String quoteCurrency = this.f45693d.getQuoteCurrency();
                    if (baseCurrency != null && baseCurrency.equals(next.getCurrency())) {
                        this.f45708s.get(this.f45693d.getName()).put(baseCurrency, L4(next.getBalance(), baseCurrency));
                    }
                    if (quoteCurrency != null && quoteCurrency.equals(next.getCurrency())) {
                        this.f45708s.get(this.f45693d.getName()).put(quoteCurrency, L4(next.getBalance(), quoteCurrency));
                    }
                }
            }
        }
        return Boolean.TRUE;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean O2(Map map) {
        this.P.clear();
        if (map != null && !map.isEmpty()) {
            for (Map.Entry entry : map.entrySet()) {
                if (entry.getKey() != null) {
                    String lowerCase = ((String) entry.getKey()).toLowerCase(Locale.US);
                    String str = (String) map.get(entry.getKey());
                    if (i6.m.a(str).compareTo(BigDecimal.ZERO) < 0) {
                        str = "0";
                    }
                    this.P.put(lowerCase, L4(str, (String) entry.getKey()));
                }
            }
        }
        return Boolean.TRUE;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean P2(OptionDataTotal optionDataTotal) {
        if (!(optionDataTotal == null || optionDataTotal.getDetailInfos() == null || optionDataTotal.getDetailInfos().isEmpty())) {
            for (BaseAssetInfo baseAssetInfo : optionDataTotal.getDetailInfos()) {
                if ((baseAssetInfo instanceof OptionBalanceItem) && baseAssetInfo.getDelegateKey() != null) {
                    this.L.put(baseAssetInfo.getDelegateKey().toLowerCase(Locale.US), i6.m.m(((OptionBalanceItem) baseAssetInfo).getMAccountInfo().getWithdrawAvailable(), FuturePrecisionUtil.l(this.f45691b)));
                }
            }
        }
        return Boolean.TRUE;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean Q2(Map map, List list) {
        String str;
        if (list != null && !list.isEmpty() && map != null && !map.isEmpty()) {
            for (Map.Entry entry : map.entrySet()) {
                if (entry.getKey() != null) {
                    int intValue = ((Integer) entry.getKey()).intValue();
                    Iterator it2 = list.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            str = "";
                            break;
                        }
                        MarketCoin.Coin coin = (MarketCoin.Coin) it2.next();
                        if (intValue == coin.getCoinId()) {
                            str = coin.getCoinCode();
                            break;
                        }
                    }
                    if (!TextUtils.isEmpty(str)) {
                        this.N.put(str.toLowerCase(Locale.US), K4((String) entry.getValue(), str));
                    }
                }
            }
        }
        return Boolean.TRUE;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean R2(OtcOptionDataTotal otcOptionDataTotal) {
        if (!(otcOptionDataTotal == null || otcOptionDataTotal.getDetailInfos() == null || otcOptionDataTotal.getDetailInfos().isEmpty())) {
            for (BaseAssetInfo baseAssetInfo : otcOptionDataTotal.getDetailInfos()) {
                if ((baseAssetInfo instanceof OtcOptionsDetailInfo) && baseAssetInfo.getDelegateKey() != null) {
                    this.M.put(baseAssetInfo.getDelegateKey().toLowerCase(Locale.US), i6.m.m(((OtcOptionsDetailInfo) baseAssetInfo).getAvaialAble(), PrecisionUtil.b(this.f45691b)));
                }
            }
        }
        return Boolean.TRUE;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean S2(TransferOutQuota transferOutQuota, Map map) {
        N4(map);
        M4(transferOutQuota);
        return Boolean.TRUE;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean T2(SwapDataTotal swapDataTotal) {
        if (!(swapDataTotal == null || swapDataTotal.getDetailInfos() == null || swapDataTotal.getDetailInfos().isEmpty())) {
            for (BaseAssetInfo baseAssetInfo : swapDataTotal.getDetailInfos()) {
                if ((baseAssetInfo instanceof SwapBalanceItem) && baseAssetInfo.getDelegateKey() != null) {
                    this.I.put(baseAssetInfo.getDelegateKey().toLowerCase(Locale.US), n4(((SwapBalanceItem) baseAssetInfo).getMSwapAccountInfo().getAvailableWithdraw(), baseAssetInfo.getDelegateKey()));
                }
            }
        }
        return Boolean.TRUE;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void U2(String str, String str2, Object obj) {
        HuobiToastUtil.s(R.string.transfer_successfully);
        String str3 = r.x().s() + "_" + "config_super_margin_transfer" + str;
        if (!ConfigPreferences.c("user_config", str3, false) && "in".equals(str2)) {
            ((m) getUI()).gh(str);
            ConfigPreferences.n("user_config", str3, true);
        }
        L3(false);
        b4();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void V2(C2CTransferDirect c2CTransferDirect, String str, Object obj) {
        HuobiToastUtil.s(R.string.transfer_successfully);
        if (c2CTransferDirect.equals(C2CTransferDirect.IN)) {
            j4(str);
        }
        L3(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void W2(HBDialogFragment hBDialogFragment) {
        k0.O(getActivity(), a1.v().a0(TradeType.PRO, this.f45691b), true);
        hBDialogFragment.dismiss();
        getActivity().finish();
    }

    public static /* synthetic */ Observable X2(Observable observable, ProUserToken proUserToken) {
        return observable;
    }

    public static /* synthetic */ Observable Y2(Observable observable, Throwable th2) {
        if (!(th2 instanceof APIStatusErrorException) || 1324 != i6.m.k0(((APIStatusErrorException) th2).getErrCode())) {
            return Observable.error(th2);
        }
        return UserCenterRemoteDataSource.q().flatMap(new q9(observable));
    }

    public static /* synthetic */ String Z2(ContractTransferResult contractTransferResult) {
        if (contractTransferResult == null) {
            return null;
        }
        return contractTransferResult.getTransactionId();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a3(String str) {
        if (str != null) {
            k4();
        }
        L3(false);
    }

    public static /* synthetic */ Observable e3(Map map, Throwable th2) {
        if (!(th2 instanceof APIStatusErrorException) || 1324 != i6.m.k0(((APIStatusErrorException) th2).getErrCode())) {
            return Observable.error(th2);
        }
        return UserCenterRemoteDataSource.A().P().compose(p.c0()).flatMap(u9.f46137b).doOnNext(v8.f46150b).flatMap(new o9(map));
    }

    public static /* synthetic */ String f3(ContractTransferResult contractTransferResult) {
        if (contractTransferResult == null) {
            return null;
        }
        return contractTransferResult.getTransactionId();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h3(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        Subscription subscription = this.f45712w;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.f45712w = ContractCurrencyUtils.j(false, N1()).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new g());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i3(String str) {
        if (str != null) {
            DialogUtils.c0(getActivity(), getResources().getString(R.string.transfer_contract_trade_dialog_content), (String) null, (String) null, getResources().getString(R.string.currency_detail_contract_exchange), da.f45855a, new q8(this));
        }
        L3(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j3(String str, Long l11) {
        if (l11 != null) {
            yk.h.c(getActivity(), str, this.E == 2);
        }
        L3(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k3(String str, Object obj) {
        HuobiToastUtil.s(R.string.transfer_successfully);
        if (!ConfigPreferences.c("user_config", r.x().s() + "_" + "config_margin_transfer" + str, false)) {
            ((m) getUI()).If(str);
            ConfigPreferences.n("user_config", r.x().s() + "_" + "config_margin_transfer" + str, true);
        }
        L3(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l3(Object obj) {
        HuobiToastUtil.s(R.string.transfer_successfully);
        L3(false);
    }

    public static /* synthetic */ void m3(APIStatusErrorException aPIStatusErrorException) {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o3(Long l11) {
        HuobiToastUtil.s(R.string.transfer_successfully);
        L3(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable q3(StringStatusResponse stringStatusResponse) {
        if (TextUtils.isEmpty(stringStatusResponse.getErrCode()) || !stringStatusResponse.getErrCode().equalsIgnoreCase("account-transfer-need-face")) {
            return Observable.just(stringStatusResponse);
        }
        d1.a(getActivity(), false);
        return Observable.empty();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t3(String str, HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        va.b.e(str);
        if (LiteReHelper.a().b()) {
            LiteReTradeFlutterActivity.vj(getActivity(), new LiteTradeBean());
        } else if (this.E == 3) {
            getActivity().finish();
        } else {
            jp.k0.o(getActivity(), (OtcTradeAreaEnum) null, str, new a());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void u3(String str, String str2) {
        DialogUtils.c0(getActivity(), getResources().getString(R.string.transfer_legal_trade_dialog_content), (String) null, (String) null, getResources().getString(R.string.balance_exchange_dialog_conform), v7.f46149a, new x9(this, str));
        L3(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void v3(String str, HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        SwapCurrencyInfo h11 = SwapCurrencyInfoController.k().h(str);
        if (getActivity() != null) {
            SwapTradeBaseFragment.Qi(getActivity(), h11);
            getActivity().finish();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void w3(String str, Long l11) {
        if (l11 != null) {
            DialogUtils.c0(getActivity(), getResources().getString(R.string.transfer_contract_trade_dialog_content), (String) null, (String) null, getResources().getString(R.string.currency_detail_contract_exchange), cn.n.f13170a, new ca(this, str));
        }
        L3(false);
    }

    public static /* synthetic */ Object x2(Object obj, Object obj2) {
        return obj;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void x3(Long l11) {
        if (l11 != null) {
            k4();
        }
        L3(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void y2(FragmentManager fragmentManager, String str, Object obj) {
        E1(fragmentManager, str);
        this.F = true;
        ((m) getUI()).Ge();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void y3(String str, Object obj) {
        if (obj != null) {
            yk.h.c(getActivity(), str, this.E == 2);
        }
        L3(false);
    }

    public static /* synthetic */ void z2(APIStatusErrorException aPIStatusErrorException) {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void z3(Object obj) {
        HuobiToastUtil.s(R.string.transfer_successfully);
        L3(false);
    }

    public final void A1() {
        if (BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL.equals(this.f45711v)) {
            String str = null;
            boolean z11 = false;
            int i11 = 1;
            for (MarginCurrency next : this.f45705p) {
                if (TextUtils.isEmpty(str) && 1 == next.getState()) {
                    str = StringUtils.g(next.getCurrency());
                }
                if (!TextUtils.isEmpty(next.getCurrency()) && StringUtils.g(next.getCurrency()).equals(this.f45691b)) {
                    i11 = next.getState();
                    z11 = true;
                }
            }
            if (!z11 || i11 == 0) {
                this.f45691b = StringUtils.g(str);
                ((m) getUI()).R8();
                this.B = true;
                K3(true);
            }
        }
    }

    public final void A4(String str) {
        v7.b.a().U0(str, 1, "USDT").b().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new i((u6.g) getUI()));
    }

    public final void B1() {
        if (!s0.l(this.f45691b) && !this.f45700k.isEmpty()) {
            for (ProductInfo next : this.f45700k) {
                if (next != null && next.getSymbol() != null) {
                    this.f45691b = next.getSymbol();
                    return;
                }
            }
        }
    }

    public final void B4(String str) {
        SymbolCurrencyEntity symbolCurrencyEntity = this.f45693d;
        if (symbolCurrencyEntity != null) {
            x8.a.a().s(TransferAccountType.LINEAR_SWAP, TransferAccountType.SPOT, this.f45693d.getQuoteCurrency(), str, S1(symbolCurrencyEntity)).b().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(q6.d.c((u6.g) getUI(), new a8(this)));
        }
    }

    public boolean C1() {
        return BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_WARRANT.equals(this.f45711v) || BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_WARRANT.equals(this.f45710u);
    }

    public final void C4(String str) {
        String baseCurrency = this.f45695f.getBaseCurrency();
        h8.a.a().M(this.f45694e.getQuoteCurrency(), this.f45694e.getBaseCurrency(), baseCurrency, str).b().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(q6.d.c((u6.g) getUI(), new o8(this, baseCurrency)));
    }

    public boolean D1() {
        return BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP.equals(this.f45711v) || BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP.equals(this.f45710u);
    }

    public void D4(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("symbol", str);
        hashMap.put(FirebaseAnalytics.Param.CURRENCY, str2);
        hashMap.put("amount", str3);
        ((FinanceService) p.W(FinanceService.class)).transferOut(hashMap).compose(p.a0()).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(q6.d.c((u6.g) getUI(), new g8(this)));
    }

    public void E1(FragmentManager fragmentManager, String str) {
        if (this.f45710u != null) {
            if (!dn.a.d().f() || !BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP.equals(this.f45710u)) {
                F1(str);
                return;
            }
            ExperienceFundTransferReminderDialog experienceFundTransferReminderDialog = new ExperienceFundTransferReminderDialog();
            experienceFundTransferReminderDialog.th(a2());
            experienceFundTransferReminderDialog.sh(new e(str));
            experienceFundTransferReminderDialog.show(fragmentManager, "ExperienceFundTransferReminderDialog");
        }
    }

    public final void E4(String str, String str2) {
        x8.a.a().m(str, str2).b().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(q6.d.d((u6.g) getUI(), new e8(this), t8.f46122b, y8.f46193b));
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0202, code lost:
        if (com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_SWAP.equals(r0.f45711v) == false) goto L_0x020b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0204, code lost:
        z4(r0.f45691b, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0211, code lost:
        if (com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP.equals(r0.f45711v) == false) goto L_0x0218;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0213, code lost:
        t4(r19);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x021e, code lost:
        if (com.huobi.coupon.bean.CouponReturn.TYPE_EXPERIENCE.equals(r0.f45711v) == false) goto L_0x0227;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0220, code lost:
        w4(r0.f45691b, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x022d, code lost:
        if ("12".equals(r0.f45711v) == false) goto L_0x0236;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x022f, code lost:
        y4(r0.f45691b, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x023c, code lost:
        if ("2".equals(r0.f45711v) == false) goto L_0x0244;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x023e, code lost:
        x4(r0.f45691b, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x024a, code lost:
        if ("3".equals(r0.f45711v) == false) goto L_0x025d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x024c, code lost:
        r3 = r0.f45693d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x024e, code lost:
        if (r3 != null) goto L_0x0251;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0251, code lost:
        r2 = r3.getName();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0255, code lost:
        if (r2 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0257, code lost:
        u4(r2, r0.f45691b, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0263, code lost:
        if ("8".equals(r0.f45711v) == false) goto L_0x0276;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0265, code lost:
        r3 = r0.f45693d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0267, code lost:
        if (r3 != null) goto L_0x026a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x026a, code lost:
        r2 = r3.getName();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x026e, code lost:
        if (r2 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0270, code lost:
        r4(r2, r0.f45691b, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x027c, code lost:
        if (com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL.equals(r0.f45711v) == false) goto L_0x0286;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x027e, code lost:
        c4("in", r0.f45691b, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x028c, code lost:
        if ("9".equals(r0.f45711v) == false) goto L_0x0294;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x028e, code lost:
        v4(r0.f45691b, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x029a, code lost:
        if (com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_WARRANT.equals(r0.f45711v) == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x029c, code lost:
        I4(r1, 3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0091, code lost:
        r16 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00a7, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00a8, code lost:
        switch(r16) {
            case 0: goto L_0x01ed;
            case 1: goto L_0x01de;
            case 2: goto L_0x01cc;
            case 3: goto L_0x01bd;
            case 4: goto L_0x01ac;
            case 5: goto L_0x019d;
            case 6: goto L_0x018b;
            case 7: goto L_0x017c;
            case 8: goto L_0x016d;
            case 9: goto L_0x0141;
            case 10: goto L_0x0132;
            case 11: goto L_0x00ad;
            default: goto L_0x00ab;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00ad, code lost:
        r2 = i6.m.o0(L1());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00b9, code lost:
        if (android.text.TextUtils.isEmpty(r2) != false) goto L_0x0117;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00c2, code lost:
        if (java.lang.Float.parseFloat(r2) <= 0.0f) goto L_0x0117;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00c4, code lost:
        com.hbg.lib.widgets.dialog.DialogUtils.b0(getActivity(), getResources().getString(pro.huobi.R.string.n_contract_trade_reminder_text), java.lang.String.format(getString(pro.huobi.R.string.n_copy_trading_transfer_trail_tips_1), new java.lang.Object[]{r2}) + "\n\n" + getString(pro.huobi.R.string.n_copy_trading_transfer_trail_tips_2), (java.lang.String) null, (java.lang.String) null, getResources().getString(pro.huobi.R.string.n_experience_fund_optimize_continue_transfer), cn.n.f13170a, new com.huobi.finance.presenter.m9(r0, r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x011d, code lost:
        if (com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP.equals(r0.f45711v) == false) goto L_0x0124;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x011f, code lost:
        q4(r19);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012a, code lost:
        if ("1".equals(r0.f45711v) == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x012c, code lost:
        I4(r1, 4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0138, code lost:
        if ("1".equals(r0.f45711v) == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x013a, code lost:
        G4(r0.f45691b, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0147, code lost:
        if (com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_WARRANT.equals(r0.f45711v) == false) goto L_0x014d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0149, code lost:
        A4(r19);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0153, code lost:
        if ("1".equals(r0.f45711v) == false) goto L_0x0159;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0155, code lost:
        B4(r19);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x015f, code lost:
        if (com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP.equals(r0.f45711v) == false) goto L_0x0164;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0161, code lost:
        C4(r19);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0164, code lost:
        dn.a.d().b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0173, code lost:
        if ("1".equals(r0.f45711v) == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0175, code lost:
        F4(r0.f45691b, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0182, code lost:
        if ("1".equals(r0.f45711v) == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0184, code lost:
        E4(r0.f45691b, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x018b, code lost:
        r3 = r0.f45693d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x018d, code lost:
        if (r3 != null) goto L_0x0190;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0190, code lost:
        r2 = r3.getName();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0194, code lost:
        if (r2 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0196, code lost:
        o4(r2, r0.f45691b, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01a3, code lost:
        if ("1".equals(r0.f45711v) == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01a5, code lost:
        J4(r0.f45691b, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01b2, code lost:
        if ("1".equals(r0.f45711v) == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01b4, code lost:
        c4("out", r0.f45691b, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01c3, code lost:
        if ("1".equals(r0.f45711v) == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01c5, code lost:
        p4(r0.f45691b, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01cc, code lost:
        r3 = r0.f45693d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01ce, code lost:
        if (r3 != null) goto L_0x01d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01d1, code lost:
        r2 = r3.getName();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01d5, code lost:
        if (r2 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01d7, code lost:
        D4(r2, r0.f45691b, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01e4, code lost:
        if ("1".equals(r0.f45711v) == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01e6, code lost:
        H4(r0.f45691b, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01f3, code lost:
        if ("4".equals(r0.f45711v) == false) goto L_0x01fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01f5, code lost:
        s4(r0.f45691b, r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void F1(java.lang.String r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            java.lang.String r2 = r0.f45710u
            if (r2 != 0) goto L_0x0009
            return
        L_0x0009:
            r2.hashCode()
            int r4 = r2.hashCode()
            java.lang.String r5 = "12"
            java.lang.String r6 = "10"
            java.lang.String r7 = "9"
            java.lang.String r8 = "8"
            java.lang.String r9 = "7"
            java.lang.String r11 = "6"
            java.lang.String r13 = "4"
            java.lang.String r14 = "3"
            java.lang.String r3 = "2"
            r17 = 0
            java.lang.String r12 = "13"
            java.lang.String r10 = "11"
            java.lang.String r15 = "1"
            switch(r4) {
                case 49: goto L_0x009e;
                case 50: goto L_0x0094;
                case 51: goto L_0x0089;
                case 52: goto L_0x007f;
                case 54: goto L_0x0075;
                case 55: goto L_0x006c;
                case 56: goto L_0x0063;
                case 57: goto L_0x005a;
                case 1567: goto L_0x0050;
                case 1568: goto L_0x0046;
                case 1569: goto L_0x003c;
                case 1570: goto L_0x0031;
                default: goto L_0x002d;
            }
        L_0x002d:
            r16 = -1
            goto L_0x00a7
        L_0x0031:
            boolean r2 = r2.equals(r12)
            if (r2 != 0) goto L_0x0038
            goto L_0x002d
        L_0x0038:
            r2 = 11
            goto L_0x0091
        L_0x003c:
            boolean r2 = r2.equals(r5)
            if (r2 != 0) goto L_0x0043
            goto L_0x002d
        L_0x0043:
            r2 = 10
            goto L_0x0091
        L_0x0046:
            boolean r2 = r2.equals(r10)
            if (r2 != 0) goto L_0x004d
            goto L_0x002d
        L_0x004d:
            r2 = 9
            goto L_0x0091
        L_0x0050:
            boolean r2 = r2.equals(r6)
            if (r2 != 0) goto L_0x0057
            goto L_0x002d
        L_0x0057:
            r2 = 8
            goto L_0x0091
        L_0x005a:
            boolean r2 = r2.equals(r7)
            if (r2 != 0) goto L_0x0061
            goto L_0x002d
        L_0x0061:
            r2 = 7
            goto L_0x0091
        L_0x0063:
            boolean r2 = r2.equals(r8)
            if (r2 != 0) goto L_0x006a
            goto L_0x002d
        L_0x006a:
            r2 = 6
            goto L_0x0091
        L_0x006c:
            boolean r2 = r2.equals(r9)
            if (r2 != 0) goto L_0x0073
            goto L_0x002d
        L_0x0073:
            r2 = 5
            goto L_0x0091
        L_0x0075:
            boolean r2 = r2.equals(r11)
            if (r2 != 0) goto L_0x007c
            goto L_0x002d
        L_0x007c:
            r16 = 4
            goto L_0x00a7
        L_0x007f:
            boolean r2 = r2.equals(r13)
            if (r2 != 0) goto L_0x0086
            goto L_0x002d
        L_0x0086:
            r16 = 3
            goto L_0x00a7
        L_0x0089:
            boolean r2 = r2.equals(r14)
            if (r2 != 0) goto L_0x0090
            goto L_0x002d
        L_0x0090:
            r2 = 2
        L_0x0091:
            r16 = r2
            goto L_0x00a7
        L_0x0094:
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x009b
            goto L_0x002d
        L_0x009b:
            r16 = 1
            goto L_0x00a7
        L_0x009e:
            boolean r2 = r2.equals(r15)
            if (r2 != 0) goto L_0x00a5
            goto L_0x002d
        L_0x00a5:
            r16 = r17
        L_0x00a7:
            r2 = 0
            switch(r16) {
                case 0: goto L_0x01ed;
                case 1: goto L_0x01de;
                case 2: goto L_0x01cc;
                case 3: goto L_0x01bd;
                case 4: goto L_0x01ac;
                case 5: goto L_0x019d;
                case 6: goto L_0x018b;
                case 7: goto L_0x017c;
                case 8: goto L_0x016d;
                case 9: goto L_0x0141;
                case 10: goto L_0x0132;
                case 11: goto L_0x00ad;
                default: goto L_0x00ab;
            }
        L_0x00ab:
            goto L_0x02a0
        L_0x00ad:
            java.lang.String r2 = r18.L1()
            java.lang.String r2 = i6.m.o0(r2)
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L_0x0117
            float r3 = java.lang.Float.parseFloat(r2)
            r4 = 0
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 <= 0) goto L_0x0117
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r4 = 2132021458(0x7f1410d2, float:1.9681308E38)
            java.lang.String r4 = r0.getString(r4)
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r5[r17] = r2
            java.lang.String r2 = java.lang.String.format(r4, r5)
            r3.append(r2)
            java.lang.String r2 = "\n\n"
            r3.append(r2)
            r2 = 2132021459(0x7f1410d3, float:1.968131E38)
            java.lang.String r2 = r0.getString(r2)
            r3.append(r2)
            java.lang.String r6 = r3.toString()
            com.hbg.lib.common.ui.BaseCoreActivity r4 = r18.getActivity()
            android.content.res.Resources r2 = r18.getResources()
            r3 = 2132021152(0x7f140fa0, float:1.9680687E38)
            java.lang.String r5 = r2.getString(r3)
            r7 = 0
            r8 = 0
            android.content.res.Resources r2 = r18.getResources()
            r3 = 2132022068(0x7f141334, float:1.9682545E38)
            java.lang.String r9 = r2.getString(r3)
            cn.n r10 = cn.n.f13170a
            com.huobi.finance.presenter.m9 r11 = new com.huobi.finance.presenter.m9
            r11.<init>(r0, r1)
            com.hbg.lib.widgets.dialog.DialogUtils.b0(r4, r5, r6, r7, r8, r9, r10, r11)
            goto L_0x02a0
        L_0x0117:
            java.lang.String r2 = r0.f45711v
            boolean r2 = r10.equals(r2)
            if (r2 == 0) goto L_0x0124
            r18.q4(r19)
            goto L_0x02a0
        L_0x0124:
            java.lang.String r2 = r0.f45711v
            boolean r2 = r15.equals(r2)
            if (r2 == 0) goto L_0x02a0
            r2 = 4
            r0.I4(r1, r2)
            goto L_0x02a0
        L_0x0132:
            java.lang.String r2 = r0.f45711v
            boolean r2 = r15.equals(r2)
            if (r2 == 0) goto L_0x02a0
            java.lang.String r2 = r0.f45691b
            r0.G4(r2, r1)
            goto L_0x02a0
        L_0x0141:
            java.lang.String r2 = r0.f45711v
            boolean r2 = r12.equals(r2)
            if (r2 == 0) goto L_0x014d
            r18.A4(r19)
            goto L_0x0164
        L_0x014d:
            java.lang.String r2 = r0.f45711v
            boolean r2 = r15.equals(r2)
            if (r2 == 0) goto L_0x0159
            r18.B4(r19)
            goto L_0x0164
        L_0x0159:
            java.lang.String r2 = r0.f45711v
            boolean r2 = r10.equals(r2)
            if (r2 == 0) goto L_0x0164
            r18.C4(r19)
        L_0x0164:
            dn.a r1 = dn.a.d()
            r1.b()
            goto L_0x02a0
        L_0x016d:
            java.lang.String r2 = r0.f45711v
            boolean r2 = r15.equals(r2)
            if (r2 == 0) goto L_0x02a0
            java.lang.String r2 = r0.f45691b
            r0.F4(r2, r1)
            goto L_0x02a0
        L_0x017c:
            java.lang.String r2 = r0.f45711v
            boolean r2 = r15.equals(r2)
            if (r2 == 0) goto L_0x02a0
            java.lang.String r2 = r0.f45691b
            r0.E4(r2, r1)
            goto L_0x02a0
        L_0x018b:
            com.huobi.finance.bean.SymbolCurrencyEntity r3 = r0.f45693d
            if (r3 != 0) goto L_0x0190
            goto L_0x0194
        L_0x0190:
            java.lang.String r2 = r3.getName()
        L_0x0194:
            if (r2 == 0) goto L_0x02a0
            java.lang.String r3 = r0.f45691b
            r0.o4(r2, r3, r1)
            goto L_0x02a0
        L_0x019d:
            java.lang.String r2 = r0.f45711v
            boolean r2 = r15.equals(r2)
            if (r2 == 0) goto L_0x02a0
            java.lang.String r2 = r0.f45691b
            r0.J4(r2, r1)
            goto L_0x02a0
        L_0x01ac:
            java.lang.String r2 = r0.f45711v
            boolean r2 = r15.equals(r2)
            if (r2 == 0) goto L_0x02a0
            java.lang.String r2 = r0.f45691b
            java.lang.String r3 = "out"
            r0.c4(r3, r2, r1)
            goto L_0x02a0
        L_0x01bd:
            java.lang.String r2 = r0.f45711v
            boolean r2 = r15.equals(r2)
            if (r2 == 0) goto L_0x02a0
            java.lang.String r2 = r0.f45691b
            r0.p4(r2, r1)
            goto L_0x02a0
        L_0x01cc:
            com.huobi.finance.bean.SymbolCurrencyEntity r3 = r0.f45693d
            if (r3 != 0) goto L_0x01d1
            goto L_0x01d5
        L_0x01d1:
            java.lang.String r2 = r3.getName()
        L_0x01d5:
            if (r2 == 0) goto L_0x02a0
            java.lang.String r3 = r0.f45691b
            r0.D4(r2, r3, r1)
            goto L_0x02a0
        L_0x01de:
            java.lang.String r2 = r0.f45711v
            boolean r2 = r15.equals(r2)
            if (r2 == 0) goto L_0x02a0
            java.lang.String r2 = r0.f45691b
            r0.H4(r2, r1)
            goto L_0x02a0
        L_0x01ed:
            java.lang.String r4 = r0.f45711v
            boolean r4 = r13.equals(r4)
            if (r4 == 0) goto L_0x01fc
            java.lang.String r2 = r0.f45691b
            r0.s4(r2, r1)
            goto L_0x02a0
        L_0x01fc:
            java.lang.String r4 = r0.f45711v
            boolean r4 = r9.equals(r4)
            if (r4 == 0) goto L_0x020b
            java.lang.String r2 = r0.f45691b
            r0.z4(r2, r1)
            goto L_0x02a0
        L_0x020b:
            java.lang.String r4 = r0.f45711v
            boolean r4 = r10.equals(r4)
            if (r4 == 0) goto L_0x0218
            r18.t4(r19)
            goto L_0x02a0
        L_0x0218:
            java.lang.String r4 = r0.f45711v
            boolean r4 = r6.equals(r4)
            if (r4 == 0) goto L_0x0227
            java.lang.String r2 = r0.f45691b
            r0.w4(r2, r1)
            goto L_0x02a0
        L_0x0227:
            java.lang.String r4 = r0.f45711v
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x0236
            java.lang.String r2 = r0.f45691b
            r0.y4(r2, r1)
            goto L_0x02a0
        L_0x0236:
            java.lang.String r4 = r0.f45711v
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0244
            java.lang.String r2 = r0.f45691b
            r0.x4(r2, r1)
            goto L_0x02a0
        L_0x0244:
            java.lang.String r3 = r0.f45711v
            boolean r3 = r14.equals(r3)
            if (r3 == 0) goto L_0x025d
            com.huobi.finance.bean.SymbolCurrencyEntity r3 = r0.f45693d
            if (r3 != 0) goto L_0x0251
            goto L_0x0255
        L_0x0251:
            java.lang.String r2 = r3.getName()
        L_0x0255:
            if (r2 == 0) goto L_0x02a0
            java.lang.String r3 = r0.f45691b
            r0.u4(r2, r3, r1)
            goto L_0x02a0
        L_0x025d:
            java.lang.String r3 = r0.f45711v
            boolean r3 = r8.equals(r3)
            if (r3 == 0) goto L_0x0276
            com.huobi.finance.bean.SymbolCurrencyEntity r3 = r0.f45693d
            if (r3 != 0) goto L_0x026a
            goto L_0x026e
        L_0x026a:
            java.lang.String r2 = r3.getName()
        L_0x026e:
            if (r2 == 0) goto L_0x02a0
            java.lang.String r3 = r0.f45691b
            r0.r4(r2, r3, r1)
            goto L_0x02a0
        L_0x0276:
            java.lang.String r2 = r0.f45711v
            boolean r2 = r11.equals(r2)
            if (r2 == 0) goto L_0x0286
            java.lang.String r2 = r0.f45691b
            java.lang.String r3 = "in"
            r0.c4(r3, r2, r1)
            goto L_0x02a0
        L_0x0286:
            java.lang.String r2 = r0.f45711v
            boolean r2 = r7.equals(r2)
            if (r2 == 0) goto L_0x0294
            java.lang.String r2 = r0.f45691b
            r0.v4(r2, r1)
            goto L_0x02a0
        L_0x0294:
            java.lang.String r2 = r0.f45711v
            boolean r2 = r12.equals(r2)
            if (r2 == 0) goto L_0x02a0
            r2 = 3
            r0.I4(r1, r2)
        L_0x02a0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.finance.presenter.UnifyTransferPresenter.F1(java.lang.String):void");
    }

    public void F4(String str, String str2) {
        x8.a.a().n(TransferAccountType.OPTION, TransferAccountType.SPOT, "usdt", str, str2).b().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(q6.d.c((u6.g) getUI(), new x7(this)));
    }

    public final void G1() {
        if (r.x().X()) {
            String str = this.f45690a;
            if (str == null || "2".equals(str)) {
                this.f45690a = "1";
            }
        } else if (this.f45690a == null) {
            this.f45690a = "2";
        }
    }

    public void G4(String str, String str2) {
        v7.b.a().w(ku.b.e().h(getActivity()), UcHelper.b(true), str, str2, false).d(new l((u6.g) getUI()));
    }

    public String H1() {
        Map map;
        String str;
        String str2;
        String str3;
        String str4;
        String str5 = null;
        if (this.f45691b == null) {
            return null;
        }
        String str6 = this.f45710u;
        str6.hashCode();
        char c11 = 65535;
        switch (str6.hashCode()) {
            case 49:
                if (str6.equals("1")) {
                    c11 = 0;
                    break;
                }
                break;
            case 50:
                if (str6.equals("2")) {
                    c11 = 1;
                    break;
                }
                break;
            case 51:
                if (str6.equals("3")) {
                    c11 = 2;
                    break;
                }
                break;
            case 52:
                if (str6.equals("4")) {
                    c11 = 3;
                    break;
                }
                break;
            case 54:
                if (str6.equals(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL)) {
                    c11 = 4;
                    break;
                }
                break;
            case 55:
                if (str6.equals(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_SWAP)) {
                    c11 = 5;
                    break;
                }
                break;
            case 56:
                if (str6.equals("8")) {
                    c11 = 6;
                    break;
                }
                break;
            case 57:
                if (str6.equals("9")) {
                    c11 = 7;
                    break;
                }
                break;
            case 1567:
                if (str6.equals(CouponReturn.TYPE_EXPERIENCE)) {
                    c11 = 8;
                    break;
                }
                break;
            case 1568:
                if (str6.equals(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP)) {
                    c11 = 9;
                    break;
                }
                break;
            case 1569:
                if (str6.equals("12")) {
                    c11 = 10;
                    break;
                }
                break;
            case 1570:
                if (str6.equals(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_WARRANT)) {
                    c11 = 11;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return this.f45698i.get(this.f45691b.toLowerCase(Locale.US));
            case 1:
                return this.N.get(this.f45691b.toLowerCase(Locale.US));
            case 2:
                SymbolCurrencyEntity symbolCurrencyEntity = this.f45693d;
                if (symbolCurrencyEntity == null || symbolCurrencyEntity.getName() == null || (map = this.f45708s.get(this.f45693d.getName())) == null || (str = this.f45691b) == null) {
                    return null;
                }
                return (String) map.get(str);
            case 3:
                return this.H.get(this.f45691b.toLowerCase(Locale.US));
            case 4:
                return this.O.get(this.f45691b.toLowerCase(Locale.US));
            case 5:
                return this.I.get(this.f45691b.toLowerCase(Locale.US));
            case 6:
                return J1();
            case 7:
                return this.P.get(this.f45691b.toLowerCase(Locale.US));
            case 8:
                return this.L.get(this.f45691b.toLowerCase(Locale.US));
            case 9:
                Log.d("UnifyTransferPresenter", "fromFlag:" + this.f45710u + " toFlag:" + this.f45711v);
                if (this.f45694e != null) {
                    str2 = "fromSymbol--baseCurrency:" + this.f45694e.getBaseCurrency() + " quoteCurrency:" + this.f45694e.getQuoteCurrency();
                } else {
                    str2 = "fromSymbol is null";
                }
                Log.d("UnifyTransferPresenter", str2);
                if (this.f45693d != null) {
                    str3 = "symbol--baseCurrency:" + this.f45693d.getBaseCurrency() + " quoteCurrency:" + this.f45693d.getQuoteCurrency();
                } else {
                    str3 = "symbol is null";
                }
                Log.d("UnifyTransferPresenter", str3);
                Log.d("UnifyTransferPresenter", "linearSwapDataMap:" + this.J);
                if (BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_WARRANT.equals(this.f45711v)) {
                    str4 = this.J.get("USDT");
                } else if (s2()) {
                    SymbolCurrencyEntity symbolCurrencyEntity2 = this.f45694e;
                    if (!(symbolCurrencyEntity2 == null || symbolCurrencyEntity2.getBaseCurrency() == null)) {
                        if (SPUtil.j()) {
                            str4 = this.J.get(StringUtils.g(this.f45694e.getBaseCurrency()));
                        } else {
                            str4 = this.J.get(StringUtils.g(this.f45694e.getBaseCurrency() + this.f45694e.getQuoteCurrency()));
                        }
                    }
                    Log.d("UnifyTransferPresenter", "result:" + str5);
                    return str5;
                } else {
                    SymbolCurrencyEntity symbolCurrencyEntity3 = this.f45693d;
                    if (!(symbolCurrencyEntity3 == null || symbolCurrencyEntity3.getBaseCurrency() == null)) {
                        if (SPUtil.j()) {
                            str4 = this.J.get(StringUtils.g(this.f45693d.getBaseCurrency()));
                        } else {
                            str4 = this.J.get(StringUtils.g(this.f45693d.getBaseCurrency() + this.f45693d.getQuoteCurrency()));
                        }
                    }
                    Log.d("UnifyTransferPresenter", "result:" + str5);
                    return str5;
                }
                str5 = str4;
                Log.d("UnifyTransferPresenter", "result:" + str5);
                return str5;
            case 10:
                return this.M.get(this.f45691b.toLowerCase(Locale.US));
            case 11:
                return this.Q;
            default:
                return this.f45698i.get(this.f45691b);
        }
    }

    public void H4(String str, String str2) {
        if (str != null) {
            jp.l.G(MapParamsBuilder.c().a(FirebaseAnalytics.Param.CURRENCY, str.toLowerCase(Locale.US)).a("amount", str2).a("type", FinanceRecordItem.TYPE_OTC_TO_PRO).b()).flatMap(new z8(this)).compose(p.a0()).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(q6.d.c((u6.g) getUI(), new l8(this, str)));
        }
    }

    public List<String> I1() {
        String str;
        String str2;
        ArrayList arrayList = new ArrayList();
        String V1 = V1();
        if (V1 != null) {
            char c11 = 65535;
            switch (V1.hashCode()) {
                case 50:
                    if (V1.equals("2")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case 51:
                    if (V1.equals("3")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 52:
                    if (V1.equals("4")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 55:
                    if (V1.equals(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_SWAP)) {
                        c11 = 3;
                        break;
                    }
                    break;
                case 56:
                    if (V1.equals("8")) {
                        c11 = 4;
                        break;
                    }
                    break;
                case 57:
                    if (V1.equals("9")) {
                        c11 = 5;
                        break;
                    }
                    break;
                case 1567:
                    if (V1.equals(CouponReturn.TYPE_EXPERIENCE)) {
                        c11 = 6;
                        break;
                    }
                    break;
                case 1568:
                    if (V1.equals(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP)) {
                        c11 = 7;
                        break;
                    }
                    break;
                case 1569:
                    if (V1.equals("12")) {
                        c11 = 8;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    if (!this.f45706q.isEmpty()) {
                        for (MarketCoin.Coin next : this.f45706q) {
                            if (next != null && !TextUtils.isEmpty(next.getShortName())) {
                                arrayList.add(next.getShortName());
                            }
                        }
                        break;
                    }
                    break;
                case 1:
                case 4:
                case 7:
                    SymbolCurrencyEntity symbolCurrencyEntity = this.f45693d;
                    if (symbolCurrencyEntity == null) {
                        String a02 = a1.v().a0(TradeType.PRO, this.f45691b);
                        String n11 = a1.v().n(a02);
                        String D2 = a1.v().D(a02);
                        arrayList.add(n11);
                        arrayList.add(D2);
                        break;
                    } else {
                        if (symbolCurrencyEntity.getBaseCurrency() == null) {
                            str = a1.v().n(this.f45693d.getName());
                        } else {
                            str = this.f45693d.getBaseCurrency();
                        }
                        if (this.f45693d.getQuoteCurrency() == null) {
                            str2 = a1.v().D(this.f45693d.getName());
                        } else {
                            str2 = this.f45693d.getQuoteCurrency();
                        }
                        arrayList.add(str);
                        arrayList.add(str2);
                        break;
                    }
                case 2:
                    if (!this.f45699j.isEmpty()) {
                        for (ContractCoinInfo next2 : this.f45699j) {
                            if (next2 != null && !TextUtils.isEmpty(next2.getSymbol())) {
                                arrayList.add(next2.getSymbol());
                            }
                        }
                        break;
                    }
                    break;
                case 3:
                    if (!this.f45700k.isEmpty()) {
                        for (ProductInfo next3 : this.f45700k) {
                            if (next3 != null && !TextUtils.isEmpty(next3.getSymbol())) {
                                arrayList.add(next3.getSymbol());
                            }
                        }
                        break;
                    }
                    break;
                case 5:
                    if (!this.f45704o.isEmpty()) {
                        for (MineAccountItem next4 : this.f45704o) {
                            if (next4 != null && !TextUtils.isEmpty(next4.getCurrency())) {
                                arrayList.add(next4.getCurrency());
                            }
                        }
                        break;
                    }
                    break;
                case 6:
                    if (!this.f45701l.isEmpty()) {
                        for (FutureProductInfo next5 : this.f45701l) {
                            if (next5 != null && !TextUtils.isEmpty(next5.getSymbol())) {
                                arrayList.add(next5.getSymbol());
                            }
                        }
                        break;
                    }
                    break;
                case 8:
                    if (!this.f45702m.isEmpty()) {
                        for (String next6 : this.f45702m) {
                            if (!TextUtils.isEmpty(next6)) {
                                arrayList.add(next6);
                            }
                        }
                        break;
                    }
                    break;
            }
        }
        return arrayList;
    }

    public final void I4(String str, int i11) {
        v7.b.a().U0(str, i11, "USDT").b().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new h((u6.g) getUI()));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String J1() {
        /*
            r4 = this;
            com.huobi.finance.bean.SymbolCurrencyEntity r0 = r4.f45693d
            r1 = 0
            if (r0 == 0) goto L_0x0057
            java.lang.String r0 = r0.getName()
            if (r0 != 0) goto L_0x000c
            goto L_0x0057
        L_0x000c:
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> r0 = r4.f45709t
            com.huobi.finance.bean.SymbolCurrencyEntity r2 = r4.f45693d
            java.lang.String r2 = r2.getName()
            java.lang.Object r0 = r0.get(r2)
            java.util.Map r0 = (java.util.Map) r0
            if (r0 == 0) goto L_0x0027
            java.lang.String r2 = r4.f45691b
            if (r2 == 0) goto L_0x0027
            java.lang.Object r0 = r0.get(r2)
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1
        L_0x0027:
            java.util.Map<java.lang.String, com.hbg.lib.network.hbg.core.bean.C2CTransferOutQuotaInfo> r0 = r4.G
            if (r0 != 0) goto L_0x002c
            return r1
        L_0x002c:
            java.lang.String r2 = r4.f45691b
            java.lang.Object r0 = r0.get(r2)
            com.hbg.lib.network.hbg.core.bean.C2CTransferOutQuotaInfo r0 = (com.hbg.lib.network.hbg.core.bean.C2CTransferOutQuotaInfo) r0
            if (r0 == 0) goto L_0x0057
            java.lang.String r0 = r0.getTransferOutLimit()
            java.lang.String r2 = "-1"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0043
            return r1
        L_0x0043:
            java.math.BigDecimal r2 = i6.m.a(r0)
            java.math.BigDecimal r3 = i6.m.a(r1)
            int r2 = r2.compareTo(r3)
            if (r2 >= 0) goto L_0x0057
            java.lang.String r1 = r4.f45691b
            java.lang.String r1 = r4.m4(r0, r1)
        L_0x0057:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.finance.presenter.UnifyTransferPresenter.J1():java.lang.String");
    }

    public void J4(String str, String str2) {
        x8.a.a().q(TransferAccountType.SWAP, TransferAccountType.SPOT, str, str2).b().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(q6.d.c((u6.g) getUI(), new y7(this)));
    }

    public Map<String, C2CTransferOutQuotaInfo> K1() {
        return this.G;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ab, code lost:
        if (r0.equals("2") == false) goto L_0x003b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void K3(boolean r9) {
        /*
            r8 = this;
            java.util.List<rx.Observable<java.lang.Boolean>> r0 = r8.f45697h
            r0.clear()
            java.lang.String r0 = r8.V1()
            boolean r1 = r8.C1()
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L_0x0030
            java.util.List<rx.Observable<java.lang.Boolean>> r0 = r8.f45697h
            rx.Observable r1 = r8.P3(r5)
            r0.add(r1)
            java.util.List<rx.Observable<java.lang.Boolean>> r0 = r8.f45697h
            rx.Observable r1 = r8.P3(r4)
            r0.add(r1)
            java.util.List<rx.Observable<java.lang.Boolean>> r0 = r8.f45697h
            rx.Observable r1 = r8.P3(r3)
            r0.add(r1)
            goto L_0x00d3
        L_0x0030:
            if (r0 == 0) goto L_0x00d1
            r1 = -1
            int r6 = r0.hashCode()
            r7 = 6
            switch(r6) {
                case 50: goto L_0x00a5;
                case 51: goto L_0x009a;
                case 52: goto L_0x008f;
                case 54: goto L_0x0084;
                case 55: goto L_0x0079;
                case 56: goto L_0x006e;
                case 57: goto L_0x0063;
                case 1567: goto L_0x0058;
                case 1568: goto L_0x004b;
                case 1569: goto L_0x003e;
                default: goto L_0x003b;
            }
        L_0x003b:
            r2 = r1
            goto L_0x00ae
        L_0x003e:
            java.lang.String r2 = "12"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0047
            goto L_0x003b
        L_0x0047:
            r2 = 9
            goto L_0x00ae
        L_0x004b:
            java.lang.String r2 = "11"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0054
            goto L_0x003b
        L_0x0054:
            r2 = 8
            goto L_0x00ae
        L_0x0058:
            java.lang.String r2 = "10"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0061
            goto L_0x003b
        L_0x0061:
            r2 = 7
            goto L_0x00ae
        L_0x0063:
            java.lang.String r2 = "9"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x006c
            goto L_0x003b
        L_0x006c:
            r2 = r7
            goto L_0x00ae
        L_0x006e:
            java.lang.String r2 = "8"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0077
            goto L_0x003b
        L_0x0077:
            r2 = 5
            goto L_0x00ae
        L_0x0079:
            java.lang.String r2 = "7"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0082
            goto L_0x003b
        L_0x0082:
            r2 = 4
            goto L_0x00ae
        L_0x0084:
            java.lang.String r2 = "6"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x008d
            goto L_0x003b
        L_0x008d:
            r2 = r3
            goto L_0x00ae
        L_0x008f:
            java.lang.String r2 = "4"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0098
            goto L_0x003b
        L_0x0098:
            r2 = r4
            goto L_0x00ae
        L_0x009a:
            java.lang.String r2 = "3"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x00a3
            goto L_0x003b
        L_0x00a3:
            r2 = r5
            goto L_0x00ae
        L_0x00a5:
            java.lang.String r4 = "2"
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L_0x00ae
            goto L_0x003b
        L_0x00ae:
            switch(r2) {
                case 0: goto L_0x00cf;
                case 1: goto L_0x00cc;
                case 2: goto L_0x00ca;
                case 3: goto L_0x00c7;
                case 4: goto L_0x00c3;
                case 5: goto L_0x00c0;
                case 6: goto L_0x00bd;
                case 7: goto L_0x00ba;
                case 8: goto L_0x00b7;
                case 9: goto L_0x00b4;
                default: goto L_0x00b1;
            }
        L_0x00b1:
            r0 = 1855(0x73f, float:2.6E-42)
            goto L_0x00c5
        L_0x00b4:
            r0 = 1026(0x402, float:1.438E-42)
            goto L_0x00c5
        L_0x00b7:
            r0 = 514(0x202, float:7.2E-43)
            goto L_0x00c5
        L_0x00ba:
            r0 = 258(0x102, float:3.62E-43)
            goto L_0x00c5
        L_0x00bd:
            r0 = 130(0x82, float:1.82E-43)
            goto L_0x00c5
        L_0x00c0:
            r0 = 66
            goto L_0x00c5
        L_0x00c3:
            r0 = 34
        L_0x00c5:
            r2 = r0
            goto L_0x00d3
        L_0x00c7:
            r0 = 18
            goto L_0x00c5
        L_0x00ca:
            r2 = r7
            goto L_0x00d3
        L_0x00cc:
            r0 = 10
            goto L_0x00c5
        L_0x00cf:
            r2 = r3
            goto L_0x00d3
        L_0x00d1:
            r2 = 1839(0x72f, float:2.577E-42)
        L_0x00d3:
            r0 = r2 & 2
            if (r0 == 0) goto L_0x00e0
            java.util.List<rx.Observable<java.lang.Boolean>> r0 = r8.f45697h
            rx.Observable r1 = r8.R3()
            r0.add(r1)
        L_0x00e0:
            r0 = r2 & 1
            if (r0 == 0) goto L_0x00ed
            java.util.List<rx.Observable<java.lang.Boolean>> r0 = r8.f45697h
            rx.Observable r1 = r8.X3()
            r0.add(r1)
        L_0x00ed:
            r0 = r2 & 4
            if (r0 == 0) goto L_0x0100
            boolean r0 = com.hbg.lib.core.util.o.h()
            if (r0 == 0) goto L_0x0100
            java.util.List<rx.Observable<java.lang.Boolean>> r0 = r8.f45697h
            rx.Observable r1 = r8.O3()
            r0.add(r1)
        L_0x0100:
            r0 = r2 & 32
            if (r0 == 0) goto L_0x0113
            boolean r0 = com.hbg.lib.core.util.o.h()
            if (r0 == 0) goto L_0x0113
            java.util.List<rx.Observable<java.lang.Boolean>> r0 = r8.f45697h
            rx.Observable r1 = r8.a4()
            r0.add(r1)
        L_0x0113:
            r0 = r2 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0136
            boolean r0 = com.hbg.lib.core.util.o.h()
            if (r0 == 0) goto L_0x0136
            boolean r0 = com.hbg.lib.network.retrofit.util.SPUtil.j()
            if (r0 == 0) goto L_0x012d
            java.util.List<rx.Observable<java.lang.Boolean>> r0 = r8.f45697h
            rx.Observable r1 = r8.M3()
            r0.add(r1)
            goto L_0x0136
        L_0x012d:
            java.util.List<rx.Observable<java.lang.Boolean>> r0 = r8.f45697h
            rx.Observable r1 = r8.S3()
            r0.add(r1)
        L_0x0136:
            r0 = r2 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0149
            boolean r0 = com.hbg.lib.core.util.o.h()
            if (r0 == 0) goto L_0x0149
            java.util.List<rx.Observable<java.lang.Boolean>> r0 = r8.f45697h
            rx.Observable r1 = r8.W3()
            r0.add(r1)
        L_0x0149:
            r0 = r2 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0156
            java.util.List<rx.Observable<java.lang.Boolean>> r0 = r8.f45697h
            rx.Observable r1 = r8.Y3()
            r0.add(r1)
        L_0x0156:
            r0 = r2 & 8
            if (r0 == 0) goto L_0x0163
            java.util.List<rx.Observable<java.lang.Boolean>> r0 = r8.f45697h
            rx.Observable r1 = r8.U3()
            r0.add(r1)
        L_0x0163:
            r0 = r2 & 64
            if (r0 == 0) goto L_0x0170
            java.util.List<rx.Observable<java.lang.Boolean>> r0 = r8.f45697h
            rx.Observable r1 = r8.N3()
            r0.add(r1)
        L_0x0170:
            r0 = r2 & 16
            if (r0 == 0) goto L_0x017d
            java.util.List<rx.Observable<java.lang.Boolean>> r0 = r8.f45697h
            rx.Observable r1 = r8.Z3()
            r0.add(r1)
        L_0x017d:
            r0 = r2 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x018a
            java.util.List<rx.Observable<java.lang.Boolean>> r0 = r8.f45697h
            rx.Observable r1 = r8.V3()
            r0.add(r1)
        L_0x018a:
            java.util.List<rx.Observable<java.lang.Boolean>> r0 = r8.f45697h
            com.huobi.finance.presenter.aa r1 = com.huobi.finance.presenter.aa.f45806b
            rx.Observable r0 = rx.Observable.zip((java.lang.Iterable<? extends rx.Observable<?>>) r0, r1)
            com.hbg.lib.core.network.rx.EasySubscriber r9 = r8.O1(r9)
            r0.subscribe(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.finance.presenter.UnifyTransferPresenter.K3(boolean):void");
    }

    public final String K4(String str, String str2) {
        MarketCoin.Coin i11 = OtcMarketPriceConfigUtil.i(str2);
        return i6.m.m(str, (i11 == null || !i11.isFiatCoin()) ? 6 : 2);
    }

    public String L1() {
        return this.R;
    }

    public final void L3(boolean z11) {
        this.B = true;
        Observable.interval(1, 1, TimeUnit.SECONDS).take(3).subscribe(new r8(this, z11));
    }

    public final String L4(String str, String str2) {
        int i11;
        if (d7.k.C().L(str2)) {
            i11 = 2;
        } else {
            i11 = PrecisionUtil.a(TradeType.PRO, str2);
        }
        return i6.m.m(str, i11);
    }

    public String M1() {
        return this.S;
    }

    public final Observable<Boolean> M3() {
        return h8.a.a().queryAccountBalance().b().compose(RxJavaHelper.t((u6.g) getUI())).map(new c9(this)).onErrorResumeNext(Observable.just(null));
    }

    public final void M4(TransferOutQuota transferOutQuota) {
        if (transferOutQuota != null) {
            this.D = transferOutQuota;
            if (!"-1".equals(transferOutQuota.getTransferOutLimit()) && i6.m.a(this.O.get(StringUtils.g(this.f45691b))).compareTo(i6.m.a(transferOutQuota.getTransferOutLimit())) > 0) {
                String g11 = StringUtils.g(this.f45691b);
                this.O.put(g11, L4(transferOutQuota.getTransferOutLimit(), g11));
            }
        }
    }

    public String N1() {
        return this.f45691b;
    }

    public final Observable<Boolean> N3() {
        SymbolCurrencyEntity symbolCurrencyEntity = this.f45693d;
        if (symbolCurrencyEntity == null || TextUtils.isEmpty(symbolCurrencyEntity.getName())) {
            return Observable.just(null);
        }
        return Observable.zip(h2.t1().B3(false, this.f45693d.getName()), v7.b.a().requestC2CTransferOutQuota(this.f45693d.getName()).b(), new w9(this)).compose(RxJavaHelper.t((u6.g) getUI())).onErrorResumeNext(Observable.just(null));
    }

    public final void N4(Map<String, String> map) {
        this.O.clear();
        if (map != null && !map.isEmpty()) {
            for (Map.Entry next : map.entrySet()) {
                if (next.getKey() != null) {
                    String lowerCase = ((String) next.getKey()).toLowerCase(Locale.US);
                    String str = map.get(next.getKey());
                    if (i6.m.a(str).compareTo(BigDecimal.ZERO) < 0) {
                        str = "0";
                    }
                    this.O.put(lowerCase, L4(str, (String) next.getKey()));
                }
            }
        }
    }

    public final EasySubscriber O1(boolean z11) {
        return new d(z11);
    }

    public final Observable<Boolean> O3() {
        return h2.t1().r1(false).compose(RxJavaHelper.t((u6.g) getUI())).map(new d9(this)).onErrorResumeNext(Observable.just(null));
    }

    public final void O4(SuperMarginTransferLimit superMarginTransferLimit) {
        if (superMarginTransferLimit != null && BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL.equals(this.f45711v)) {
            String marginLimitAvailable = superMarginTransferLimit.getMarginLimitAvailable();
            String positionLimitAvailable = superMarginTransferLimit.getPositionLimitAvailable();
            i6.m.a(marginLimitAvailable).compareTo(BigDecimal.ZERO);
            i6.m.a(positionLimitAvailable).compareTo(BigDecimal.ZERO);
            String sb2 = new StringBuilder().toString();
            if (!StringUtils.p(sb2)) {
                ((m) getUI()).b4(sb2);
            } else {
                ((m) getUI()).b4(getString(R.string.n_balance_transfer_tips));
            }
        }
    }

    public String P1() {
        if (this.f45691b != null) {
            String str = this.f45710u;
            str.hashCode();
            if (str.equals(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP)) {
                if (this.f45715z) {
                    return this.K.get(this.f45691b.toLowerCase(Locale.US));
                }
                Map<String, String> map = this.K;
                return map.get(StringUtils.g(this.f45693d.getBaseCurrency() + this.f45693d.getQuoteCurrency()));
            }
        }
        return "";
    }

    public final Observable<Boolean> P3(int i11) {
        return v7.b.a().requestCopyTradingAssetInfo(i11, "USDT").b().compose(RxJavaHelper.t((u6.g) getUI())).map(new n9(this, i11)).onErrorResumeNext(Observable.just(null));
    }

    public String Q1() {
        return this.f45710u;
    }

    public void Q3(boolean z11) {
        if (z11) {
            s0.b((u6.g) getUI(), false).map(new i9(this)).subscribe(new BaseSubscriber());
        } else {
            K3(false);
        }
        n.c().d(new b());
        T3();
    }

    public SymbolCurrencyEntity R1() {
        return this.f45694e;
    }

    public final Observable<Boolean> R3() {
        d7.k.C().U(true, (RequestCallback1<List<CurrencyBean>>) null);
        return h2.t1().z3(TradeType.PRO, false).compose(RxJavaHelper.t((u6.g) getUI())).map(new l9(this)).onErrorResumeNext(Observable.just(null));
    }

    public final String S1(SymbolCurrencyEntity symbolCurrencyEntity) {
        if (dn.d.f().m()) {
            return symbolCurrencyEntity.getBaseCurrency();
        }
        String str = symbolCurrencyEntity.getBaseCurrency() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + symbolCurrencyEntity.getQuoteCurrency();
        if ("usdt".equalsIgnoreCase(symbolCurrencyEntity.getBaseCurrency())) {
            str = "usdt";
        }
        if ("husd".equalsIgnoreCase(symbolCurrencyEntity.getBaseCurrency()) && !"usdt".equalsIgnoreCase(symbolCurrencyEntity.getQuoteCurrency())) {
            str = "husd";
        }
        if ("ht".equalsIgnoreCase(symbolCurrencyEntity.getBaseCurrency())) {
            str = "ht".toUpperCase();
        }
        if ("htx".equalsIgnoreCase(symbolCurrencyEntity.getBaseCurrency())) {
            return "htx".toUpperCase();
        }
        return "trx".equalsIgnoreCase(symbolCurrencyEntity.getBaseCurrency()) ? "trx".toUpperCase() : str;
    }

    public final Observable<Boolean> S3() {
        return new LinearSwapDataProvider().a(false).compose(RxJavaHelper.t((u6.g) getUI())).map(new e9(this)).onErrorResumeNext(Observable.just(null));
    }

    public MarketCoin.Coin T1(String str) {
        if (str == null) {
            return null;
        }
        for (MarketCoin.Coin next : U1()) {
            if (next != null && str.equalsIgnoreCase(next.getCoinCode())) {
                return next;
            }
        }
        return null;
    }

    public final void T3() {
        UserCenterRemoteDataSource.A().requestLicenseState("SUPER_MARGIN", true).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new c());
    }

    public List<MarketCoin.Coin> U1() {
        return this.f45706q;
    }

    public final Observable<Boolean> U3() {
        SymbolCurrencyEntity symbolCurrencyEntity = this.f45693d;
        if (symbolCurrencyEntity == null || TextUtils.isEmpty(symbolCurrencyEntity.getName())) {
            return Observable.just(null);
        }
        return h2.t1().H3(TradeType.MARGIN, false, true, this.f45693d.getName()).compose(RxJavaHelper.t((u6.g) getUI())).map(new j9(this)).onErrorResumeNext(Observable.just(null));
    }

    public String V1() {
        return "1".equals(this.f45710u) ? this.f45711v : this.f45710u;
    }

    public final Observable<Boolean> V3() {
        return h2.t1().y3(TradeType.MINE, false).compose(RxJavaHelper.t((u6.g) getUI())).map(new k9(this)).onErrorResumeNext(Observable.just(null));
    }

    public TransferOutQuota W1() {
        return this.D;
    }

    public final Observable<Boolean> W3() {
        return new OptionDataProvider().a(false).compose(RxJavaHelper.t((u6.g) getUI())).map(new f9(this)).onErrorResumeNext(Observable.just(null));
    }

    public SymbolCurrencyEntity X1() {
        return this.f45693d;
    }

    public final Observable<Boolean> X3() {
        return Observable.zip(h2.t1().F3(false), OtcMarketPriceConfigUtil.f(true).compose(RxJavaHelper.t((u6.g) getUI())), new y9(this)).onErrorResumeNext(Observable.just(null));
    }

    public String Y1() {
        return this.f45711v;
    }

    public final Observable<Boolean> Y3() {
        return AssetDataCacheManager.k0().H0().a(false).compose(RxJavaHelper.t((u6.g) getUI())).map(new g9(this)).onErrorResumeNext(Observable.just(null));
    }

    public SymbolCurrencyEntity Z1() {
        return this.f45695f;
    }

    public final Observable<Boolean> Z3() {
        Observable<R> compose = ((SuperMarginService) p.W(SuperMarginService.class)).transferOutQuota(this.f45691b).compose(p.a0()).compose(RxJavaHelper.t((u6.g) getUI()));
        Observable<R> compose2 = h2.t1().y3(TradeType.SUPERMARGIN, false).compose(RxJavaHelper.t((u6.g) getUI()));
        x8.a.a().o(this.f45691b).b().compose(RxJavaHelper.t((u6.g) getUI()));
        return Observable.zip(compose, compose2, new v9(this)).onErrorResumeNext(Observable.just(null));
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x009b, code lost:
        r10 = 2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a2() {
        /*
            r11 = this;
            java.lang.String r0 = r11.f45710u
            r1 = 2
            if (r0 == 0) goto L_0x0125
            r0.hashCode()
            r2 = -1
            int r3 = r0.hashCode()
            java.lang.String r4 = "12"
            java.lang.String r5 = "11"
            java.lang.String r6 = "10"
            java.lang.String r7 = "7"
            java.lang.String r8 = "4"
            java.lang.String r9 = "2"
            r10 = 6
            switch(r3) {
                case 49: goto L_0x006c;
                case 50: goto L_0x0063;
                case 51: goto L_0x0058;
                case 52: goto L_0x004f;
                case 55: goto L_0x0046;
                case 56: goto L_0x003b;
                case 1567: goto L_0x0032;
                case 1568: goto L_0x0029;
                case 1569: goto L_0x001f;
                default: goto L_0x001d;
            }
        L_0x001d:
            goto L_0x0076
        L_0x001f:
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L_0x0026
            goto L_0x0076
        L_0x0026:
            r2 = 8
            goto L_0x0076
        L_0x0029:
            boolean r0 = r0.equals(r5)
            if (r0 != 0) goto L_0x0030
            goto L_0x0076
        L_0x0030:
            r2 = 7
            goto L_0x0076
        L_0x0032:
            boolean r0 = r0.equals(r6)
            if (r0 != 0) goto L_0x0039
            goto L_0x0076
        L_0x0039:
            r2 = r10
            goto L_0x0076
        L_0x003b:
            java.lang.String r3 = "8"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x0044
            goto L_0x0076
        L_0x0044:
            r2 = 5
            goto L_0x0076
        L_0x0046:
            boolean r0 = r0.equals(r7)
            if (r0 != 0) goto L_0x004d
            goto L_0x0076
        L_0x004d:
            r2 = 4
            goto L_0x0076
        L_0x004f:
            boolean r0 = r0.equals(r8)
            if (r0 != 0) goto L_0x0056
            goto L_0x0076
        L_0x0056:
            r2 = 3
            goto L_0x0076
        L_0x0058:
            java.lang.String r3 = "3"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x0061
            goto L_0x0076
        L_0x0061:
            r2 = r1
            goto L_0x0076
        L_0x0063:
            boolean r0 = r0.equals(r9)
            if (r0 != 0) goto L_0x006a
            goto L_0x0076
        L_0x006a:
            r2 = 1
            goto L_0x0076
        L_0x006c:
            java.lang.String r3 = "1"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x0075
            goto L_0x0076
        L_0x0075:
            r2 = 0
        L_0x0076:
            switch(r2) {
                case 0: goto L_0x00c0;
                case 1: goto L_0x012d;
                case 2: goto L_0x00b6;
                case 3: goto L_0x00ae;
                case 4: goto L_0x00a6;
                case 5: goto L_0x00b6;
                case 6: goto L_0x009e;
                case 7: goto L_0x008d;
                case 8: goto L_0x0083;
                default: goto L_0x0079;
            }
        L_0x0079:
            com.hbg.lib.data.symbol.TradeType r0 = com.hbg.lib.data.symbol.TradeType.MARGIN
            java.lang.String r2 = r11.f45691b
            int r10 = com.hbg.lib.data.symbol.PrecisionUtil.a(r0, r2)
            goto L_0x012d
        L_0x0083:
            com.hbg.lib.data.symbol.TradeType r0 = com.hbg.lib.data.symbol.TradeType.PRO
            java.lang.String r2 = r11.f45691b
            int r10 = com.hbg.lib.data.symbol.PrecisionUtil.a(r0, r2)
            goto L_0x012d
        L_0x008d:
            com.huobi.finance.bean.SymbolCurrencyEntity r0 = r11.f45693d
            if (r0 == 0) goto L_0x009b
            java.lang.String r0 = r0.getBaseCurrency()
            int r10 = com.hbg.lib.data.future.util.FuturePrecisionUtil.d(r0)
            goto L_0x012d
        L_0x009b:
            r10 = r1
            goto L_0x012d
        L_0x009e:
            java.lang.String r0 = r11.f45691b
            int r10 = com.hbg.lib.data.future.util.FuturePrecisionUtil.l(r0)
            goto L_0x012d
        L_0x00a6:
            java.lang.String r0 = r11.f45691b
            int r10 = us.i.x(r0)
            goto L_0x012d
        L_0x00ae:
            java.lang.String r0 = r11.f45691b
            int r10 = ej.f.s(r0)
            goto L_0x012d
        L_0x00b6:
            com.hbg.lib.data.symbol.TradeType r0 = com.hbg.lib.data.symbol.TradeType.MARGIN
            java.lang.String r2 = r11.f45691b
            int r10 = com.hbg.lib.data.symbol.PrecisionUtil.a(r0, r2)
            goto L_0x012d
        L_0x00c0:
            java.lang.String r0 = r11.f45711v
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x00c9
            goto L_0x012d
        L_0x00c9:
            java.lang.String r0 = r11.f45711v
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x00d8
            java.lang.String r0 = r11.f45691b
            int r10 = ej.f.s(r0)
            goto L_0x012d
        L_0x00d8:
            java.lang.String r0 = r11.f45711v
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x00e7
            java.lang.String r0 = r11.f45691b
            int r10 = us.i.x(r0)
            goto L_0x012d
        L_0x00e7:
            java.lang.String r0 = r11.f45711v
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x00fc
            com.huobi.finance.bean.SymbolCurrencyEntity r0 = r11.f45693d
            if (r0 == 0) goto L_0x009b
            java.lang.String r0 = r0.getBaseCurrency()
            int r10 = com.hbg.lib.data.future.util.FuturePrecisionUtil.d(r0)
            goto L_0x012d
        L_0x00fc:
            java.lang.String r0 = r11.f45711v
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x010b
            java.lang.String r0 = r11.f45691b
            int r10 = com.hbg.lib.data.future.util.FuturePrecisionUtil.l(r0)
            goto L_0x012d
        L_0x010b:
            java.lang.String r0 = r11.f45711v
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x011c
            com.hbg.lib.data.symbol.TradeType r0 = com.hbg.lib.data.symbol.TradeType.PRO
            java.lang.String r2 = r11.f45691b
            int r10 = com.hbg.lib.data.symbol.PrecisionUtil.a(r0, r2)
            goto L_0x012d
        L_0x011c:
            com.hbg.lib.data.symbol.TradeType r0 = com.hbg.lib.data.symbol.TradeType.PRO
            java.lang.String r2 = r11.f45691b
            int r10 = com.hbg.lib.data.symbol.PrecisionUtil.a(r0, r2)
            goto L_0x012d
        L_0x0125:
            com.hbg.lib.data.symbol.TradeType r0 = com.hbg.lib.data.symbol.TradeType.MARGIN
            java.lang.String r2 = r11.f45691b
            int r10 = com.hbg.lib.data.symbol.PrecisionUtil.a(r0, r2)
        L_0x012d:
            d7.k r0 = d7.k.C()
            java.lang.String r2 = r11.f45691b
            boolean r0 = r0.L(r2)
            if (r0 == 0) goto L_0x013a
            goto L_0x013b
        L_0x013a:
            r1 = r10
        L_0x013b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.finance.presenter.UnifyTransferPresenter.a2():int");
    }

    public final Observable<Boolean> a4() {
        return h2.t1().J1(false).compose(RxJavaHelper.t((u6.g) getUI())).map(new h9(this)).onErrorResumeNext(Observable.just(null));
    }

    public void b2(boolean z11) {
        if (z11 ? o2() : v2()) {
            this.f45696g = z11;
            Intent intent = new Intent(getActivity(), AccountChooseActivity.class);
            intent.putExtra("IS_FROM", z11);
            intent.putExtra("FROM_ACCOUNT", this.f45710u);
            intent.putExtra("TO_ACCOUNT", this.f45711v);
            intent.putExtra("IS_CROSS_MARGIN", n2());
            getActivity().startActivityForResult(intent, 1001);
        }
    }

    public final void b4() {
        LinearSwapProductInfo s11;
        ((m) getUI()).b4(getString(R.string.n_balance_transfer_tips));
        if (BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL.equals(this.f45711v)) {
            x8.a.a().o(this.f45691b).b().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(SilentSubscriber.a(new w7(this)));
        } else if (d7.k.C().L(this.f45691b)) {
            ((m) getUI()).b4(getString(R.string.n_transfer_hint_fiat));
        }
        if ("4".equals(this.f45710u)) {
            for (ContractCoinInfo next : this.f45699j) {
                if (next != null && next.getSymbol() != null && next.getSymbol().equalsIgnoreCase(this.f45691b)) {
                    if (!next.isRealTimeSettlement()) {
                        ((m) getUI()).b4(getString(R.string.n_transfer_contract_hint));
                        return;
                    }
                    return;
                }
            }
        } else if (BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_SWAP.equals(this.f45710u)) {
            for (ProductInfo next2 : this.f45700k) {
                if (next2 != null && next2.getSymbol() != null && next2.getSymbol().equalsIgnoreCase(this.f45691b)) {
                    if (!next2.isRealTimeSettlement()) {
                        ((m) getUI()).b4(getString(R.string.n_transfer_swap_hint));
                        return;
                    }
                    return;
                }
            }
        } else if (BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP.equals(this.f45710u) && !BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_WARRANT.equals(this.f45711v) && this.f45693d != null && (s11 = LinearSwapProductInfoController.o().s(StringUtils.g(this.f45693d.getBaseCurrency()), true)) != null && !s11.isRealTimeSettlement()) {
            ((m) getUI()).b4(getString(R.string.n_transfer_linear_swap_hint));
        }
    }

    public void c2() {
        String V1 = V1();
        String str = null;
        if (C1()) {
            CurrencyHistoryActivity.ph(getActivity(), this.f45691b, (String) null, BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_WARRANT, "3");
        } else if (D1()) {
            CurrencyHistoryActivity.ph(getActivity(), this.f45691b, (String) null, BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP, "3");
        } else if ("3".equals(V1) || "8".equals(V1)) {
            BaseCoreActivity activity = getActivity();
            String str2 = this.f45691b;
            SymbolCurrencyEntity symbolCurrencyEntity = this.f45693d;
            if (symbolCurrencyEntity != null) {
                str = symbolCurrencyEntity.getName();
            }
            CurrencyHistoryActivity.ph(activity, str2, str, V1, "3");
        } else {
            CurrencyHistoryActivity.ph(getActivity(), this.f45691b, (String) null, V1, "3");
        }
    }

    public void c4(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put(DevicePublicKeyStringDef.DIRECT, str);
        hashMap.put(FirebaseAnalytics.Param.CURRENCY, str2);
        hashMap.put("amount", str3);
        ((SuperMarginService) p.W(SuperMarginService.class)).marginTransfer(hashMap).compose(p.a0()).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(q6.d.c((u6.g) getUI(), new p8(this, str2, str)));
    }

    public boolean d2() {
        if (!"4".equals(this.f45710u) && !"4".equals(this.f45711v)) {
            return false;
        }
        ContractUserInfo.UserBean o11 = ContractUserInfoProvider.i().o();
        if (o11 == null) {
            HuobiToastUtil.j(R.string.contract_account_loading);
        } else if (o11.getActiveState() == 1) {
            ContractChooseCurrencyActivity.yj(getActivity(), this.f45691b, true);
        } else {
            ej.c.c(getActivity());
        }
        return true;
    }

    public final void d4() {
        b4();
    }

    public boolean e2() {
        if (!BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP.equals(this.f45710u) && !BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP.equals(this.f45711v)) {
            return false;
        }
        if (!uh.i.d().e() || C1()) {
            return true;
        }
        LinearSwapChooseCurrencyActivity.yj(getActivity(), StringUtils.i(N1()));
        return true;
    }

    public final void e4() {
        b4();
    }

    public boolean f2() {
        if (!"9".equals(this.f45710u) && !"9".equals(this.f45711v)) {
            return false;
        }
        MineChooseCurrencyActivity.yj(getActivity(), this.f45691b);
        return true;
    }

    /* renamed from: f4 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, m mVar) {
        super.onUIReady(baseCoreActivity, mVar);
        if (((m) getUI()).isAvailable()) {
            g4();
            EventBus.d().p(this);
            Intent intent = getActivity().getIntent();
            this.f45691b = intent.getStringExtra("coin");
            this.f45690a = intent.getStringExtra(com.tencent.android.tpush.common.Constants.FLAG_ACCOUNT);
            this.f45713x = intent.getBooleanExtra("JUMP_ACCOUNT_REVERSE", false);
            this.f45714y = intent.getBooleanExtra("JUMP_SHOWTIP", false);
            this.E = intent.getIntExtra("KEY_JUMP_FROM", -1);
            String stringExtra = intent.getStringExtra("symbol");
            String stringExtra2 = intent.getStringExtra("newb");
            if (com.hbg.module.libkt.base.ext.b.x(stringExtra)) {
                Serializable serializableExtra = intent.getSerializableExtra("JUMP_SYMBOL_PAIR");
                if (serializableExtra instanceof SymbolCurrencyEntity) {
                    this.f45693d = (SymbolCurrencyEntity) serializableExtra;
                }
            } else {
                String D2 = a1.v().D(stringExtra);
                String n11 = a1.v().n(stringExtra);
                SymbolCurrencyEntity symbolCurrencyEntity = new SymbolCurrencyEntity();
                this.f45693d = symbolCurrencyEntity;
                symbolCurrencyEntity.setName(stringExtra);
                this.f45693d.setQuoteCurrency(D2);
                this.f45693d.setBaseCurrency(n11);
            }
            if (BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP.equalsIgnoreCase(this.f45690a)) {
                this.f45693d = new SymbolCurrencyEntity();
                if (this.f45691b.equalsIgnoreCase("husd") || (!TextUtils.isEmpty(stringExtra2) && stringExtra2.equalsIgnoreCase("husd"))) {
                    SymbolCurrencyEntity symbolCurrencyEntity2 = this.f45693d;
                    symbolCurrencyEntity2.setName(StringUtils.i(this.f45691b + Constants.ACCEPT_TIME_SEPARATOR_SERVER + "husd"));
                    this.f45693d.setBaseCurrency(StringUtils.i(this.f45691b));
                    this.f45693d.setQuoteCurrency(StringUtils.i("husd"));
                    this.f45691b = "husd";
                } else if (this.f45691b.equalsIgnoreCase("ht") || (!TextUtils.isEmpty(stringExtra2) && stringExtra2.equalsIgnoreCase("ht"))) {
                    SymbolCurrencyEntity symbolCurrencyEntity3 = this.f45693d;
                    symbolCurrencyEntity3.setName(StringUtils.i(this.f45691b + Constants.ACCEPT_TIME_SEPARATOR_SERVER + "ht"));
                    this.f45693d.setBaseCurrency(StringUtils.i(this.f45691b));
                    this.f45693d.setQuoteCurrency(StringUtils.i("ht"));
                    this.f45691b = "ht";
                } else {
                    SymbolCurrencyEntity symbolCurrencyEntity4 = this.f45693d;
                    symbolCurrencyEntity4.setName(StringUtils.i(this.f45691b + Constants.ACCEPT_TIME_SEPARATOR_SERVER + "usdt"));
                    this.f45693d.setBaseCurrency(StringUtils.i(this.f45691b));
                    this.f45693d.setQuoteCurrency(StringUtils.i("usdt"));
                    this.f45691b = "usdt";
                }
            }
            ((m) getUI()).q2();
        }
    }

    public boolean g2() {
        if (!CouponReturn.TYPE_EXPERIENCE.equals(this.f45710u) && !CouponReturn.TYPE_EXPERIENCE.equals(this.f45711v)) {
            return false;
        }
        if (z6.l.c().f() == null) {
            HuobiToastUtil.j(R.string.contract_account_loading);
        } else if (z6.l.c().h()) {
            OptionChooseCurrencyActivity.yj(getActivity(), this.f45691b, true);
        } else {
            qk.m.c(getActivity(), TradeType.OPTION);
        }
        return true;
    }

    public void g4() {
        OtcOptionsEntryHelper.g().o();
    }

    public boolean h2() {
        if (!"2".equals(this.f45710u) && !"2".equals(this.f45711v)) {
            return false;
        }
        OtcChooseCurrencyActivity.zj(getActivity(), this.f45691b);
        return true;
    }

    public final void h4(C2CTransferDirect c2CTransferDirect, String str, String str2, String str3) {
        v7.b.a().g(c2CTransferDirect, str, str2, str3).b().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(q6.d.c((u6.g) getUI(), new i8(this, c2CTransferDirect, str)));
    }

    public boolean i2() {
        if (!"12".equals(this.f45710u) && !"12".equals(this.f45711v)) {
            return false;
        }
        OtcOptionChooseCurrencyActivity.Aj(getActivity(), this.f45691b, true);
        return true;
    }

    public void i4(String str) {
        String str2 = this.f45691b;
        this.f45691b = str;
        if ("2".equals(V1()) && !this.f45706q.isEmpty()) {
            Iterator<MarketCoin.Coin> it2 = this.f45706q.iterator();
            while (true) {
                if (it2.hasNext()) {
                    MarketCoin.Coin next = it2.next();
                    if (next != null && !TextUtils.isEmpty(next.getShortName()) && next.getShortName().equalsIgnoreCase(str)) {
                        this.f45691b = next.getCoinCode();
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (str2 == null || !str2.equalsIgnoreCase(str)) {
            this.B = true;
        } else {
            this.B = false;
        }
        d4();
    }

    public boolean j2() {
        if (BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL.equals(this.f45710u)) {
            SuperMarginChooseCurrencyActivity.Cj(getActivity(), true, 1001, this.f45691b);
            return true;
        } else if (!BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL.equals(this.f45711v)) {
            return false;
        } else {
            SuperMarginChooseCurrencyActivity.Cj(getActivity(), false, 1001, this.f45691b);
            return true;
        }
    }

    public final void j4(String str) {
        if (!ConfigPreferences.c("user_config", r.x().s() + "_" + "config_c2c_margin_transfer" + str, false)) {
            ((m) getUI()).b9(str);
            ConfigPreferences.n("user_config", r.x().s() + "_" + "config_c2c_margin_transfer" + str, true);
        }
    }

    public boolean k2() {
        if (!BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_SWAP.equals(this.f45710u) && !BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_SWAP.equals(this.f45711v)) {
            return false;
        }
        if (z.f().h() == null) {
            HuobiToastUtil.j(R.string.contract_account_loading);
        } else if (z.f().k()) {
            SwapChooseCurrencyActivity.Aj(getActivity(), this.f45691b, true);
        } else {
            us.h.c(getActivity());
        }
        return true;
    }

    public final void k4() {
        DialogUtils.c0(getActivity(), getResources().getString(R.string.n_transfer_dialog_tip_succ), (String) null, (String) null, getResources().getString(R.string.otc_dialog_go_trade), cn.n.f13170a, new b9(this));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00b2, code lost:
        r16 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00b5, code lost:
        switch(r16) {
            case 0: goto L_0x0159;
            case 1: goto L_0x0150;
            case 2: goto L_0x0147;
            case 3: goto L_0x013e;
            case 4: goto L_0x0135;
            case 5: goto L_0x012c;
            case 6: goto L_0x0123;
            case 7: goto L_0x011a;
            case 8: goto L_0x0111;
            case 9: goto L_0x0108;
            case 10: goto L_0x00ff;
            case 11: goto L_0x00ba;
            default: goto L_0x00b8;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ba, code lost:
        r0.f45710u = com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP;
        r0.f45711v = com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_WARRANT;
        r1 = new com.huobi.finance.bean.SymbolCurrencyEntity();
        r0.f45693d = r1;
        r1.setName(com.hbg.lib.common.utils.StringUtils.i(r0.f45691b + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + "usdt"));
        r0.f45693d.setBaseCurrency(com.hbg.lib.common.utils.StringUtils.i(r0.f45691b));
        r0.f45693d.setQuoteCurrency(com.hbg.lib.common.utils.StringUtils.i("usdt"));
        r0.f45691b = "usdt";
        u1();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00ff, code lost:
        r0.f45710u = "1";
        r0.f45711v = "12";
        z1();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0108, code lost:
        r0.f45710u = "1";
        r0.f45711v = com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP;
        u1();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0111, code lost:
        r0.f45710u = "1";
        r0.f45711v = com.huobi.coupon.bean.CouponReturn.TYPE_EXPERIENCE;
        x1();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x011a, code lost:
        r0.f45710u = "1";
        r0.f45711v = "9";
        w1();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0123, code lost:
        r0.f45710u = "1";
        r0.f45711v = "8";
        s1((java.lang.String) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x012c, code lost:
        r0.f45710u = "1";
        r0.f45711v = com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_SWAP;
        B1();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0135, code lost:
        r0.f45710u = "1";
        r0.f45711v = com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL;
        A1();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x013e, code lost:
        r0.f45710u = "1";
        r0.f45711v = r14;
        t1();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0147, code lost:
        r0.f45710u = "1";
        r0.f45711v = "3";
        v1((java.lang.String) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0150, code lost:
        r0.f45710u = "2";
        r0.f45711v = "1";
        y1();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0159, code lost:
        if (r1 != false) goto L_0x0169;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0161, code lost:
        if (al.s0.k(r0.f45691b) == false) goto L_0x0169;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0163, code lost:
        r0.f45710u = "1";
        r0.f45711v = "2";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x016f, code lost:
        if (al.s0.e(r0.f45691b) == false) goto L_0x0177;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0171, code lost:
        r0.f45710u = "1";
        r0.f45711v = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x017d, code lost:
        if (al.s0.l(r0.f45691b) == false) goto L_0x0185;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x017f, code lost:
        r0.f45710u = "1";
        r0.f45711v = com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_SWAP;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x018b, code lost:
        if (al.s0.f(r0.f45693d) == false) goto L_0x0195;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x018d, code lost:
        r0.f45710u = "1";
        r0.f45711v = com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP;
        u1();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x019b, code lost:
        if (al.s0.i(r0.f45691b) == false) goto L_0x01a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x019d, code lost:
        r0.f45710u = "1";
        r0.f45711v = com.huobi.coupon.bean.CouponReturn.TYPE_EXPERIENCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01a8, code lost:
        if (al.s0.j(r0.f45691b) == false) goto L_0x01af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01aa, code lost:
        r0.f45710u = "1";
        r0.f45711v = "12";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01b5, code lost:
        if (al.s0.g(r0.f45691b) == false) goto L_0x01c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01b7, code lost:
        r0.f45710u = "1";
        r0.f45711v = "3";
        v1(r0.f45691b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x003d, code lost:
        r16 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01c1, code lost:
        if (r1 != false) goto L_0x01d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01c9, code lost:
        if (al.s0.d(r0.f45691b) == false) goto L_0x01d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01cb, code lost:
        r0.f45710u = "1";
        r0.f45711v = "8";
        s1(r0.f45691b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01d5, code lost:
        if (r1 != false) goto L_0x01e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01dd, code lost:
        if (al.s0.h(r0.f45691b) == false) goto L_0x01e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01df, code lost:
        r0.f45710u = "1";
        r0.f45711v = "9";
        w1();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01e7, code lost:
        r0.f45710u = "1";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01e9, code lost:
        if (r1 == false) goto L_0x01ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01ec, code lost:
        r14 = "2";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01ed, code lost:
        r0.f45711v = r14;
        v1(r0.f45691b);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void l2() {
        /*
            r17 = this;
            r0 = r17
            java.lang.String r1 = r0.f45691b
            if (r1 != 0) goto L_0x000a
            java.lang.String r1 = "btc"
            r0.f45691b = r1
        L_0x000a:
            r17.G1()
            java.lang.String r1 = r0.f45690a
            if (r1 == 0) goto L_0x01f4
            tg.r r1 = tg.r.x()
            boolean r1 = r1.X()
            java.lang.String r2 = r0.f45690a
            r2.hashCode()
            int r4 = r2.hashCode()
            java.lang.String r5 = "13"
            java.lang.String r6 = "6"
            java.lang.String r7 = "12"
            java.lang.String r8 = "10"
            java.lang.String r9 = "9"
            java.lang.String r10 = "8"
            java.lang.String r11 = "7"
            java.lang.String r12 = "3"
            java.lang.String r13 = "11"
            java.lang.String r14 = "4"
            java.lang.String r15 = "2"
            java.lang.String r3 = "1"
            switch(r4) {
                case 49: goto L_0x00aa;
                case 50: goto L_0x00a1;
                case 51: goto L_0x0098;
                case 52: goto L_0x008f;
                case 54: goto L_0x0086;
                case 55: goto L_0x007d;
                case 56: goto L_0x0074;
                case 57: goto L_0x006b;
                case 1567: goto L_0x0061;
                case 1568: goto L_0x0057;
                case 1569: goto L_0x004c;
                case 1570: goto L_0x0041;
                default: goto L_0x003d;
            }
        L_0x003d:
            r16 = -1
            goto L_0x00b4
        L_0x0041:
            boolean r2 = r2.equals(r5)
            if (r2 != 0) goto L_0x0048
            goto L_0x003d
        L_0x0048:
            r2 = 11
            goto L_0x00b2
        L_0x004c:
            boolean r2 = r2.equals(r7)
            if (r2 != 0) goto L_0x0053
            goto L_0x003d
        L_0x0053:
            r2 = 10
            goto L_0x00b2
        L_0x0057:
            boolean r2 = r2.equals(r13)
            if (r2 != 0) goto L_0x005e
            goto L_0x003d
        L_0x005e:
            r2 = 9
            goto L_0x00b2
        L_0x0061:
            boolean r2 = r2.equals(r8)
            if (r2 != 0) goto L_0x0068
            goto L_0x003d
        L_0x0068:
            r2 = 8
            goto L_0x00b2
        L_0x006b:
            boolean r2 = r2.equals(r9)
            if (r2 != 0) goto L_0x0072
            goto L_0x003d
        L_0x0072:
            r2 = 7
            goto L_0x00b2
        L_0x0074:
            boolean r2 = r2.equals(r10)
            if (r2 != 0) goto L_0x007b
            goto L_0x003d
        L_0x007b:
            r2 = 6
            goto L_0x00b2
        L_0x007d:
            boolean r2 = r2.equals(r11)
            if (r2 != 0) goto L_0x0084
            goto L_0x003d
        L_0x0084:
            r2 = 5
            goto L_0x00b2
        L_0x0086:
            boolean r2 = r2.equals(r6)
            if (r2 != 0) goto L_0x008d
            goto L_0x003d
        L_0x008d:
            r2 = 4
            goto L_0x00b2
        L_0x008f:
            boolean r2 = r2.equals(r14)
            if (r2 != 0) goto L_0x0096
            goto L_0x003d
        L_0x0096:
            r2 = 3
            goto L_0x00b2
        L_0x0098:
            boolean r2 = r2.equals(r12)
            if (r2 != 0) goto L_0x009f
            goto L_0x003d
        L_0x009f:
            r2 = 2
            goto L_0x00b2
        L_0x00a1:
            boolean r2 = r2.equals(r15)
            if (r2 != 0) goto L_0x00a8
            goto L_0x003d
        L_0x00a8:
            r2 = 1
            goto L_0x00b2
        L_0x00aa:
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x00b1
            goto L_0x003d
        L_0x00b1:
            r2 = 0
        L_0x00b2:
            r16 = r2
        L_0x00b4:
            r2 = 0
            switch(r16) {
                case 0: goto L_0x0159;
                case 1: goto L_0x0150;
                case 2: goto L_0x0147;
                case 3: goto L_0x013e;
                case 4: goto L_0x0135;
                case 5: goto L_0x012c;
                case 6: goto L_0x0123;
                case 7: goto L_0x011a;
                case 8: goto L_0x0111;
                case 9: goto L_0x0108;
                case 10: goto L_0x00ff;
                case 11: goto L_0x00ba;
                default: goto L_0x00b8;
            }
        L_0x00b8:
            goto L_0x01f4
        L_0x00ba:
            r0.f45710u = r13
            r0.f45711v = r5
            com.huobi.finance.bean.SymbolCurrencyEntity r1 = new com.huobi.finance.bean.SymbolCurrencyEntity
            r1.<init>()
            r0.f45693d = r1
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r0.f45691b
            r2.append(r3)
            java.lang.String r3 = "-"
            r2.append(r3)
            java.lang.String r3 = "usdt"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r2 = com.hbg.lib.common.utils.StringUtils.i(r2)
            r1.setName(r2)
            com.huobi.finance.bean.SymbolCurrencyEntity r1 = r0.f45693d
            java.lang.String r2 = r0.f45691b
            java.lang.String r2 = com.hbg.lib.common.utils.StringUtils.i(r2)
            r1.setBaseCurrency(r2)
            com.huobi.finance.bean.SymbolCurrencyEntity r1 = r0.f45693d
            java.lang.String r2 = com.hbg.lib.common.utils.StringUtils.i(r3)
            r1.setQuoteCurrency(r2)
            r0.f45691b = r3
            r17.u1()
            goto L_0x01f4
        L_0x00ff:
            r0.f45710u = r3
            r0.f45711v = r7
            r17.z1()
            goto L_0x01f4
        L_0x0108:
            r0.f45710u = r3
            r0.f45711v = r13
            r17.u1()
            goto L_0x01f4
        L_0x0111:
            r0.f45710u = r3
            r0.f45711v = r8
            r17.x1()
            goto L_0x01f4
        L_0x011a:
            r0.f45710u = r3
            r0.f45711v = r9
            r17.w1()
            goto L_0x01f4
        L_0x0123:
            r0.f45710u = r3
            r0.f45711v = r10
            r0.s1(r2)
            goto L_0x01f4
        L_0x012c:
            r0.f45710u = r3
            r0.f45711v = r11
            r17.B1()
            goto L_0x01f4
        L_0x0135:
            r0.f45710u = r3
            r0.f45711v = r6
            r17.A1()
            goto L_0x01f4
        L_0x013e:
            r0.f45710u = r3
            r0.f45711v = r14
            r17.t1()
            goto L_0x01f4
        L_0x0147:
            r0.f45710u = r3
            r0.f45711v = r12
            r0.v1(r2)
            goto L_0x01f4
        L_0x0150:
            r0.f45710u = r15
            r0.f45711v = r3
            r17.y1()
            goto L_0x01f4
        L_0x0159:
            if (r1 != 0) goto L_0x0169
            java.lang.String r2 = r0.f45691b
            boolean r2 = al.s0.k(r2)
            if (r2 == 0) goto L_0x0169
            r0.f45710u = r3
            r0.f45711v = r15
            goto L_0x01f4
        L_0x0169:
            java.lang.String r2 = r0.f45691b
            boolean r2 = al.s0.e(r2)
            if (r2 == 0) goto L_0x0177
            r0.f45710u = r3
            r0.f45711v = r14
            goto L_0x01f4
        L_0x0177:
            java.lang.String r2 = r0.f45691b
            boolean r2 = al.s0.l(r2)
            if (r2 == 0) goto L_0x0185
            r0.f45710u = r3
            r0.f45711v = r11
            goto L_0x01f4
        L_0x0185:
            com.huobi.finance.bean.SymbolCurrencyEntity r2 = r0.f45693d
            boolean r2 = al.s0.f(r2)
            if (r2 == 0) goto L_0x0195
            r0.f45710u = r3
            r0.f45711v = r13
            r17.u1()
            goto L_0x01f4
        L_0x0195:
            java.lang.String r2 = r0.f45691b
            boolean r2 = al.s0.i(r2)
            if (r2 == 0) goto L_0x01a2
            r0.f45710u = r3
            r0.f45711v = r8
            goto L_0x01f4
        L_0x01a2:
            java.lang.String r2 = r0.f45691b
            boolean r2 = al.s0.j(r2)
            if (r2 == 0) goto L_0x01af
            r0.f45710u = r3
            r0.f45711v = r7
            goto L_0x01f4
        L_0x01af:
            java.lang.String r2 = r0.f45691b
            boolean r2 = al.s0.g(r2)
            if (r2 == 0) goto L_0x01c1
            r0.f45710u = r3
            r0.f45711v = r12
            java.lang.String r1 = r0.f45691b
            r0.v1(r1)
            goto L_0x01f4
        L_0x01c1:
            if (r1 != 0) goto L_0x01d5
            java.lang.String r2 = r0.f45691b
            boolean r2 = al.s0.d(r2)
            if (r2 == 0) goto L_0x01d5
            r0.f45710u = r3
            r0.f45711v = r10
            java.lang.String r1 = r0.f45691b
            r0.s1(r1)
            goto L_0x01f4
        L_0x01d5:
            if (r1 != 0) goto L_0x01e7
            java.lang.String r2 = r0.f45691b
            boolean r2 = al.s0.h(r2)
            if (r2 == 0) goto L_0x01e7
            r0.f45710u = r3
            r0.f45711v = r9
            r17.w1()
            goto L_0x01f4
        L_0x01e7:
            r0.f45710u = r3
            if (r1 == 0) goto L_0x01ec
            goto L_0x01ed
        L_0x01ec:
            r14 = r15
        L_0x01ed:
            r0.f45711v = r14
            java.lang.String r1 = r0.f45691b
            r0.v1(r1)
        L_0x01f4:
            boolean r1 = r0.f45713x
            if (r1 == 0) goto L_0x0200
            java.lang.String r1 = r0.f45710u
            java.lang.String r2 = r0.f45711v
            r0.f45710u = r2
            r0.f45711v = r1
        L_0x0200:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.finance.presenter.UnifyTransferPresenter.l2():void");
    }

    public void l4(C2CTransferDirect c2CTransferDirect, String str, String str2, String str3) {
        if (this.C) {
            h4(c2CTransferDirect, str, str2, str3);
        } else {
            n.c().d(new f(c2CTransferDirect, str, str2, str3));
        }
    }

    public boolean m2() {
        return this.B;
    }

    public final String m4(String str, String str2) {
        return i6.m.m(str, o.d(str2));
    }

    public final boolean n2() {
        if (X1() != null && !"usdt".equalsIgnoreCase(X1().getBaseCurrency()) && !"husd".equalsIgnoreCase(X1().getBaseCurrency())) {
            return false;
        }
        return true;
    }

    public final String n4(String str, String str2) {
        return i6.m.m(str, ej.f.s(str2));
    }

    public void o1(FragmentManager fragmentManager, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", "MARGIN");
        hashMap.put("version", 1);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("type", "SUPER_MARGIN");
        hashMap2.put("version", 1);
        Observable.zip(UserCenterRemoteDataSource.A().requestLicenseAgree(hashMap).compose(p.c0()).subscribeOn(Schedulers.io()), UserCenterRemoteDataSource.A().requestLicenseAgree(hashMap2).compose(p.c0()).subscribeOn(Schedulers.io()), z9.f46207b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(q6.d.d((u6.g) getUI(), new h8(this, fragmentManager, str), u8.f46136b, w8.f46164b));
    }

    public boolean o2() {
        if (!BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_WARRANT.equals(this.f45711v) && !BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP.equals(this.f45711v) && "1".equals(this.f45710u)) {
            return false;
        }
        return true;
    }

    public void o4(String str, String str2, String str3) {
        l4(C2CTransferDirect.OUT, str, str2, str3);
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        String str;
        super.onActivityResult(i11, i12, intent);
        if (intent != null) {
            char c11 = 65535;
            if (i12 == -1 && i11 == 1001) {
                String stringExtra = intent.getStringExtra(com.tencent.android.tpush.common.Constants.FLAG_ACCOUNT);
                boolean booleanExtra = intent.getBooleanExtra("JUST_SELECT_CURRENCY", false);
                Serializable serializableExtra = intent.getSerializableExtra("coin");
                boolean booleanExtra2 = intent.getBooleanExtra("IS_FROM", false);
                boolean booleanExtra3 = intent.getBooleanExtra("from_choose_currency", false);
                boolean s22 = s2();
                if (!o2() || !v2()) {
                    if ("1".equals(this.f45710u)) {
                        this.f45711v = stringExtra;
                    } else {
                        this.f45710u = stringExtra;
                    }
                } else if (!booleanExtra3) {
                    if (this.f45696g) {
                        this.f45710u = stringExtra;
                    } else {
                        this.f45711v = stringExtra;
                    }
                }
                stringExtra.hashCode();
                switch (stringExtra.hashCode()) {
                    case 50:
                        if (stringExtra.equals("2")) {
                            c11 = 0;
                            break;
                        }
                        break;
                    case 51:
                        if (stringExtra.equals("3")) {
                            c11 = 1;
                            break;
                        }
                        break;
                    case 52:
                        if (stringExtra.equals("4")) {
                            c11 = 2;
                            break;
                        }
                        break;
                    case 54:
                        if (stringExtra.equals(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL)) {
                            c11 = 3;
                            break;
                        }
                        break;
                    case 55:
                        if (stringExtra.equals(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_SWAP)) {
                            c11 = 4;
                            break;
                        }
                        break;
                    case 56:
                        if (stringExtra.equals("8")) {
                            c11 = 5;
                            break;
                        }
                        break;
                    case 57:
                        if (stringExtra.equals("9")) {
                            c11 = 6;
                            break;
                        }
                        break;
                    case 1567:
                        if (stringExtra.equals(CouponReturn.TYPE_EXPERIENCE)) {
                            c11 = 7;
                            break;
                        }
                        break;
                    case 1568:
                        if (stringExtra.equals(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP)) {
                            c11 = 8;
                            break;
                        }
                        break;
                    case 1569:
                        if (stringExtra.equals("12")) {
                            c11 = 9;
                            break;
                        }
                        break;
                    case 1570:
                        if (stringExtra.equals(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_WARRANT)) {
                            c11 = 10;
                            break;
                        }
                        break;
                }
                switch (c11) {
                    case 0:
                        if (!(serializableExtra instanceof MarketCoin.Coin)) {
                            this.f45691b = "btc";
                            break;
                        } else {
                            this.f45691b = ((MarketCoin.Coin) serializableExtra).getCoinCode();
                            break;
                        }
                    case 1:
                    case 5:
                        if (serializableExtra instanceof SymbolCurrencyEntity) {
                            SymbolCurrencyEntity symbolCurrencyEntity = (SymbolCurrencyEntity) serializableExtra;
                            this.f45693d = symbolCurrencyEntity;
                            if (symbolCurrencyEntity.getQuoteCurrency() == null) {
                                str = a1.v().D(this.f45693d.getName());
                            } else {
                                str = this.f45693d.getQuoteCurrency();
                            }
                            this.f45691b = str;
                            break;
                        }
                        break;
                    case 2:
                        if (serializableExtra instanceof ContractCoinInfo) {
                            this.f45691b = ((ContractCoinInfo) serializableExtra).getSymbol();
                        }
                        if (!booleanExtra) {
                            DialogUtils.Y(getActivity(), getString(R.string.transfer_contract_risk_dialog_content), (String) null, getString(R.string.contract_trade_i_know), o0.f12469a);
                            break;
                        }
                        break;
                    case 3:
                        if (serializableExtra instanceof MarginCurrency) {
                            this.f45691b = StringUtils.g(((MarginCurrency) serializableExtra).getCurrency());
                            this.D = null;
                            break;
                        }
                        break;
                    case 4:
                        if (serializableExtra instanceof ProductInfo) {
                            this.f45691b = ((ProductInfo) serializableExtra).getSymbol();
                        }
                        if (!booleanExtra) {
                            DialogUtils.Y(getActivity(), getString(R.string.n_balance_swap_transfer_risk_tips), (String) null, getString(R.string.contract_trade_i_know), o0.f12469a);
                            break;
                        }
                        break;
                    case 6:
                        if (serializableExtra instanceof String) {
                            this.f45691b = (String) serializableExtra;
                            break;
                        }
                        break;
                    case 7:
                        if (serializableExtra instanceof FutureProductInfo) {
                            this.f45691b = ((FutureProductInfo) serializableExtra).getSymbol();
                            break;
                        }
                        break;
                    case 8:
                        if (serializableExtra instanceof SymbolCurrencyEntity) {
                            if (!s22) {
                                SymbolCurrencyEntity symbolCurrencyEntity2 = this.f45693d;
                                this.f45694e = symbolCurrencyEntity2;
                                this.f45695f = symbolCurrencyEntity2;
                            }
                            SymbolCurrencyEntity symbolCurrencyEntity3 = (SymbolCurrencyEntity) serializableExtra;
                            this.f45693d = symbolCurrencyEntity3;
                            if (booleanExtra2) {
                                this.f45694e = symbolCurrencyEntity3;
                            } else {
                                this.f45695f = symbolCurrencyEntity3;
                            }
                            if (!uh.i.d().e()) {
                                if (!dn.d.f().m()) {
                                    if (!this.f45693d.getQuoteCurrency().equalsIgnoreCase("husd")) {
                                        this.f45691b = "usdt";
                                        break;
                                    } else {
                                        this.f45691b = "husd";
                                        break;
                                    }
                                } else {
                                    this.f45691b = "usdt";
                                    break;
                                }
                            } else {
                                this.f45691b = symbolCurrencyEntity3.getBaseCurrency();
                                break;
                            }
                        }
                        break;
                    case 9:
                        this.f45691b = intent.getStringExtra("coin");
                        break;
                    case 10:
                        if (serializableExtra instanceof SymbolCurrencyEntity) {
                            SymbolCurrencyEntity symbolCurrencyEntity4 = (SymbolCurrencyEntity) serializableExtra;
                            this.f45693d = symbolCurrencyEntity4;
                            this.f45691b = symbolCurrencyEntity4.getBaseCurrency();
                            break;
                        }
                        break;
                }
                q1();
                r1();
                this.B = true;
                ((m) getUI()).R8();
                K3(true);
                e4();
            }
        }
    }

    public void onDestroy() {
        if (((m) getUI()).isAvailable()) {
            EventBus.d().r(this);
        }
        super.onDestroy();
    }

    public void onStart() {
        super.onStart();
        if (((m) getUI()).isAvailable()) {
            this.B = false;
            if (r.x().F0()) {
                dn.d.f().o(false);
                Q3(true);
            }
        }
    }

    public void onStop() {
        Subscription subscription;
        super.onStop();
        if (((m) getUI()).isAvailable() && (subscription = this.f45712w) != null) {
            subscription.unsubscribe();
        }
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        s1.a.b(getActivity()).d(new Intent("ACTION_TOKEN_ERROR_UNIFY_TRANSFER"));
        rn.c.i().m(getActivity(), (kn.a) null);
        getActivity().finish();
    }

    public void p1() {
        if (!BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_OTC.equals(this.f45711v) && !BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_OTC.equals(this.f45710u)) {
            String str = this.f45710u;
            this.f45710u = this.f45711v;
            this.f45711v = str;
            this.B = true;
            if (s2()) {
                SymbolCurrencyEntity symbolCurrencyEntity = this.f45694e;
                this.f45694e = this.f45695f;
                this.f45695f = symbolCurrencyEntity;
            }
            A1();
            e4();
            q1();
        }
    }

    public boolean p2() {
        return this.f45710u.equals(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_WARRANT);
    }

    public void p4(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("symbol", str.toUpperCase(Locale.US));
        hashMap.put("type", 2);
        hashMap.put("amount", str2);
        Observable<R> compose = ((ContractService) ContractRetrofit.request(ContractService.class)).transferCurrency(r.x().H(), hashMap).compose(ContractRetrofit.h());
        compose.onErrorResumeNext((Func1<? super Throwable, ? extends Observable<? extends R>>) new r9(compose)).map(s9.f46108b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(q6.d.c((u6.g) getUI(), new b8(this)));
    }

    public final void q1() {
        this.f45692c = this.f45711v.equals("1") && this.f45710u.equals("9");
    }

    public boolean q2() {
        return this.f45710u.equals(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP) && this.f45711v.equals(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_WARRANT);
    }

    public final void q4(String str) {
        v7.b.a().U0(str, 2, "USDT").b().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new j((u6.g) getUI()));
    }

    public final void r1() {
        String V1 = V1();
        if (V1 != null) {
            char c11 = 65535;
            switch (V1.hashCode()) {
                case 50:
                    if (V1.equals("2")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case 51:
                    if (V1.equals("3")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 52:
                    if (V1.equals("4")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 54:
                    if (V1.equals(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL)) {
                        c11 = 3;
                        break;
                    }
                    break;
                case 55:
                    if (V1.equals(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_SWAP)) {
                        c11 = 4;
                        break;
                    }
                    break;
                case 56:
                    if (V1.equals("8")) {
                        c11 = 5;
                        break;
                    }
                    break;
                case 1567:
                    if (V1.equals(CouponReturn.TYPE_EXPERIENCE)) {
                        c11 = 6;
                        break;
                    }
                    break;
                case 1568:
                    if (V1.equals(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP)) {
                        c11 = 7;
                        break;
                    }
                    break;
                case 1569:
                    if (V1.equals("12")) {
                        c11 = 8;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    y1();
                    return;
                case 1:
                    v1((String) null);
                    return;
                case 2:
                    t1();
                    return;
                case 3:
                    A1();
                    return;
                case 4:
                    B1();
                    return;
                case 5:
                    s1((String) null);
                    return;
                case 6:
                    x1();
                    return;
                case 7:
                    u1();
                    return;
                case 8:
                    z1();
                    return;
                default:
                    return;
            }
        }
    }

    public boolean r2() {
        if (Q1() == BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP) {
            SymbolCurrencyEntity symbolCurrencyEntity = this.f45693d;
            if (symbolCurrencyEntity == null || TextUtils.isEmpty(symbolCurrencyEntity.getBaseCurrency())) {
                return false;
            }
            if (this.f45715z) {
                return true;
            }
            return "usdt".equalsIgnoreCase(this.f45693d.getBaseCurrency());
        }
        SymbolCurrencyEntity symbolCurrencyEntity2 = this.f45694e;
        if (symbolCurrencyEntity2 == null) {
            return false;
        }
        String baseCurrency = symbolCurrencyEntity2.getBaseCurrency();
        if (!this.f45710u.equals(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP) || TextUtils.isEmpty(baseCurrency)) {
            return false;
        }
        if (this.f45715z) {
            return true;
        }
        return "usdt".equalsIgnoreCase(baseCurrency);
    }

    public void r4(String str, String str2, String str3) {
        l4(C2CTransferDirect.IN, str, str2, str3);
    }

    public final void s1(String str) {
        SymbolCurrencyEntity symbolCurrencyEntity = this.f45693d;
        if (symbolCurrencyEntity != null && symbolCurrencyEntity.getQuoteCurrency() != null && this.f45693d.getBaseCurrency() != null && s0.d(this.f45693d.getName())) {
            this.f45691b = (str == null || str.equals(this.f45693d.getQuoteCurrency())) ? this.f45693d.getQuoteCurrency() : this.f45693d.getBaseCurrency();
        }
    }

    public boolean s2() {
        return BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP.equals(this.f45711v) && BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP.equals(this.f45710u);
    }

    public void s4(String str, String str2) {
        gs.g.i("App_contract_transfer_click", (HashMap) null);
        HashMap hashMap = new HashMap();
        hashMap.put("symbol", str.toUpperCase(Locale.US));
        hashMap.put("type", 1);
        hashMap.put("amount", str2);
        ((ContractService) ContractRetrofit.request(ContractService.class)).transferCurrency(r.x().H(), hashMap).compose(ContractRetrofit.h()).onErrorResumeNext(new p9(hashMap)).map(t9.f46123b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(q6.d.c((u6.g) getUI(), new c8(this)));
    }

    public final void t1() {
        if (!s0.e(this.f45691b) && !this.f45699j.isEmpty()) {
            for (ContractCoinInfo next : this.f45699j) {
                if (next != null && next.getSymbol() != null) {
                    this.f45691b = next.getSymbol();
                    return;
                }
            }
        }
    }

    public boolean t2() {
        return !this.F && u2();
    }

    public void t4(String str) {
        gs.g.i("App_linear_swap_transfer_click", (HashMap) null);
        SymbolCurrencyEntity symbolCurrencyEntity = this.f45693d;
        if (symbolCurrencyEntity != null) {
            String S1 = S1(symbolCurrencyEntity);
            x8.a.a().s(TransferAccountType.SPOT, TransferAccountType.LINEAR_SWAP, this.f45693d.getQuoteCurrency(), str, S1).b().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(q6.d.c((u6.g) getUI(), new j8(this, S1)));
        }
    }

    public final void u1() {
        if (!s2() && !s0.f(this.f45693d) && !this.f45703n.isEmpty()) {
            for (LinearSwapProductInfo next : this.f45703n) {
                if (next != null && next.getUnderlyingCurrency() != null && next.getCurrency() != null) {
                    SymbolCurrencyEntity symbolCurrencyEntity = new SymbolCurrencyEntity();
                    this.f45693d = symbolCurrencyEntity;
                    symbolCurrencyEntity.setBaseCurrency(next.getUnderlyingCurrency());
                    this.f45693d.setQuoteCurrency(next.getCurrency());
                    SymbolCurrencyEntity symbolCurrencyEntity2 = this.f45693d;
                    symbolCurrencyEntity2.setName(next.getUnderlyingCurrency() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + next.getCurrency());
                    return;
                }
            }
        }
    }

    public boolean u2() {
        return (this.f45711v.equals("1") && this.f45710u.equals("3")) || (this.f45711v.equals("1") && this.f45710u.equals(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL)) || ((this.f45710u.equals("1") && this.f45711v.equals("3")) || (this.f45710u.equals("1") && this.f45711v.equals(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL)));
    }

    public void u4(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("symbol", str);
        hashMap.put(FirebaseAnalytics.Param.CURRENCY, str2);
        hashMap.put("amount", str3);
        ((FinanceService) p.W(FinanceService.class)).transferIn(hashMap).compose(p.a0()).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(q6.d.c((u6.g) getUI(), new n8(this, str)));
    }

    public final void v1(String str) {
        SymbolCurrencyEntity symbolCurrencyEntity = this.f45693d;
        if (symbolCurrencyEntity == null || symbolCurrencyEntity.getQuoteCurrency() == null || this.f45693d.getBaseCurrency() == null || !s0.g(this.f45693d.getName())) {
            List<SymbolBean> list = this.f45707r;
            SymbolBean symbolBean = null;
            if (list != null && !list.isEmpty()) {
                SymbolBean symbolBean2 = null;
                SymbolBean symbolBean3 = null;
                SymbolBean symbolBean4 = null;
                SymbolBean symbolBean5 = null;
                for (SymbolBean next : this.f45707r) {
                    if (next != null && (this.f45691b.equalsIgnoreCase(next.getQuoteCurrency()) || this.f45691b.equalsIgnoreCase(next.getBaseCurrency()))) {
                        if (symbolBean5 == null) {
                            symbolBean5 = next;
                        }
                        if (this.f45691b.equalsIgnoreCase(next.getBaseCurrency())) {
                            if ("usdt".equalsIgnoreCase(next.getQuoteCurrency())) {
                                symbolBean2 = next;
                            }
                            if ("btc".equalsIgnoreCase(next.getQuoteCurrency())) {
                                symbolBean3 = next;
                                symbolBean4 = symbolBean3;
                            } else {
                                symbolBean4 = next;
                            }
                        }
                    }
                }
                if (symbolBean2 != null) {
                    symbolBean = symbolBean2;
                } else if (symbolBean3 != null) {
                    symbolBean = symbolBean3;
                } else if (symbolBean4 != null) {
                    symbolBean = symbolBean4;
                } else if (symbolBean5 != null) {
                    symbolBean = symbolBean5;
                }
            }
            SymbolCurrencyEntity symbolCurrencyEntity2 = new SymbolCurrencyEntity();
            this.f45693d = symbolCurrencyEntity2;
            if (symbolBean != null) {
                symbolCurrencyEntity2.setName(symbolBean.getSymbol());
                this.f45693d.setBaseCurrency(symbolBean.getBaseCurrency());
                this.f45693d.setQuoteCurrency(symbolBean.getQuoteCurrency());
                this.f45691b = (str == null || str.equals(symbolBean.getQuoteCurrency())) ? symbolBean.getQuoteCurrency() : symbolBean.getBaseCurrency();
                return;
            }
            symbolCurrencyEntity2.setName("btcusdt");
            this.f45693d.setBaseCurrency("btc");
            this.f45693d.setQuoteCurrency("usdt");
            this.f45691b = "usdt";
        }
    }

    public boolean v2() {
        if (!BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_WARRANT.equals(this.f45710u) && !BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP.equals(this.f45710u) && "1".equals(this.f45711v)) {
            return false;
        }
        return true;
    }

    public final void v4(String str, String str2) {
        x8.a.a().E(str, str2).b().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(q6.d.d((u6.g) getUI(), new d8(this), s8.f46107b, x8.f46178b));
    }

    public final void w1() {
        if (!s0.h(this.f45691b) && !this.f45704o.isEmpty()) {
            for (MineAccountItem next : this.f45704o) {
                if (next != null && next.getCurrency() != null) {
                    this.f45691b = next.getCurrency();
                    return;
                }
            }
        }
    }

    public boolean w2() {
        q1();
        if (this.f45692c) {
            HuobiToastUtil.m(getString(R.string.n_transfer_mining_pool_unable_tips));
        }
        return !this.f45692c;
    }

    public void w4(String str, String str2) {
        x8.a.a().n(TransferAccountType.SPOT, TransferAccountType.OPTION, "usdt", str, str2).b().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(q6.d.c((u6.g) getUI(), new z7(this)));
    }

    public final void x1() {
        if (!s0.i(this.f45691b) && !this.f45701l.isEmpty()) {
            for (FutureProductInfo next : this.f45701l) {
                if (next != null && next.getSymbol() != null) {
                    this.f45691b = next.getSymbol();
                    return;
                }
            }
        }
    }

    public void x4(String str, String str2) {
        if (str != null) {
            jp.l.G(MapParamsBuilder.c().a(FirebaseAnalytics.Param.CURRENCY, str.toLowerCase(Locale.US)).a("amount", str2).a("type", FinanceRecordItem.TYPE_PRO_TO_OTC).b()).flatMap(new a9(this)).compose(p.a0()).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(q6.d.c((u6.g) getUI(), new m8(this, str)));
        }
    }

    public final void y1() {
        if (!s0.k(this.f45691b) && !this.f45706q.isEmpty()) {
            for (MarketCoin.Coin next : this.f45706q) {
                if (next != null && next.getCoinCode() != null) {
                    this.f45691b = next.getCoinCode();
                    return;
                }
            }
        }
    }

    public void y4(String str, String str2) {
        v7.b.a().w(ku.b.e().h(getActivity()), UcHelper.b(true), str, str2, true).d(new k((u6.g) getUI()));
    }

    public final void z1() {
        if (!s0.j(this.f45691b) && !this.f45702m.isEmpty()) {
            for (String next : this.f45702m) {
                if (!TextUtils.isEmpty(next)) {
                    this.f45691b = next;
                    return;
                }
            }
        }
    }

    public void z4(String str, String str2) {
        gs.g.i("App_swap_transfer_click", (HashMap) null);
        x8.a.a().q(TransferAccountType.SPOT, TransferAccountType.SWAP, str, str2).b().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(q6.d.c((u6.g) getUI(), new k8(this, str)));
    }
}
