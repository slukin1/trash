package com.huobi.finance;

import ad.i;
import al.j;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSONObject;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.controller.FutureContractInfoController;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.imsdk.HbgDialogManager;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.contract.retrofit.ContractRetrofit;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapAccountInfo;
import com.hbg.lib.network.option.core.bean.OptionAccountInfo;
import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.swap.core.bean.SwapAccountInfo;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController;
import com.hbg.lib.router.HbgRouter;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.contract.service.ContractService;
import com.huobi.apm.TimeMonitorManager;
import com.huobi.c2c.ui.C2CLoanOrderActivity;
import com.huobi.c2c.ui.C2CMarginFinancialActivity;
import com.huobi.contract.entity.ContractAccountInfo;
import com.huobi.contract.entity.ContractHeartBeat;
import com.huobi.contract.entity.ContractPriceInfo;
import com.huobi.contract.entity.ContractUserInfo;
import com.huobi.contract.entity.OptionBalanceItem;
import com.huobi.contract.helper.ContractCurrencyUtils;
import com.huobi.contract.helper.ContractOrderHelper;
import com.huobi.contract.helper.ContractUserInfoProvider;
import com.huobi.contract.ui.ContractTradeBaseFragment;
import com.huobi.finance.bean.AssetPositionContractData;
import com.huobi.finance.bean.BalanceDetailInfo;
import com.huobi.finance.bean.C2CLendBalanceDetailInfo;
import com.huobi.finance.bean.C2CMarginBalanceDetailInfo;
import com.huobi.finance.bean.LegalDetailInfo;
import com.huobi.finance.bean.MarginBalanceDetailInfo;
import com.huobi.finance.bean.MineDetailInfo;
import com.huobi.finance.bean.OtcOptionsDetailInfo;
import com.huobi.finance.bean.SavingsDetailInfo;
import com.huobi.finance.bean.SuperMarginDetailInfo;
import com.huobi.finance.controller.DepositWithdrawController;
import com.huobi.finance.ui.AssetSpotCurrencyDetailActivity;
import com.huobi.finance.ui.CcRecordHomeActivity;
import com.huobi.finance.ui.ContractDetailActivity;
import com.huobi.finance.ui.CurrencyDetailActivity;
import com.huobi.finance.ui.CurrencyFromCCDetailActivity;
import com.huobi.finance.ui.CurrencySearchActivity;
import com.huobi.finance.ui.HtExchangeActivity;
import com.huobi.finance.ui.LoanSymbolDetailActivity;
import com.huobi.finance.ui.MineCurrencyDetailActivity;
import com.huobi.finance.ui.OptionDetailActivity;
import com.huobi.finance.ui.OtcCurrencyDetailActivity;
import com.huobi.finance.ui.SavingsCurrencyDetailActivity;
import com.huobi.finance.ui.UnifyDepositActivity;
import com.huobi.finance.ui.UnifyTransferActivity;
import com.huobi.finance.ui.UnifyWithdrawActivity;
import com.huobi.finance.ui.UsdtExchangeActivity;
import com.huobi.kyc.util.KycProxy;
import com.huobi.linearswap.ui.LinearSwapFinancialActivity;
import com.huobi.linearswap.ui.LinearSwapTradeBaseFragment;
import com.huobi.litere.helper.LiteReHelper;
import com.huobi.login.bean.JumpTarget;
import com.huobi.login.usercenter.data.source.bean.KvStore;
import com.huobi.login.usercenter.data.source.bean.UserInfoData;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.huobi.main.helper.MarginUtil;
import com.huobi.otc.enums.OtcTradeAreaEnum;
import com.huobi.otc.flutter.OtcOrderDepositActivity;
import com.huobi.otc.helper.OtcFaitDWJumpHelper;
import com.huobi.otcoption.ui.OtcOptionsDetailActivity;
import com.huobi.otcoption.ui.OtcOptionsIndexActivity;
import com.huobi.savings.mining.ui.MiningDetailActivity;
import com.huobi.search.ui.SearchFlutterActivity;
import com.huobi.setting.ui.BottomCurrencyDialogFragment;
import com.huobi.share.fragment.ImageShareForAssetFragment;
import com.huobi.share.helper.CaptureShareHelper;
import com.huobi.strategy.StrategyDetailActivity;
import com.huobi.supermargin.bean.MarginCurrency;
import com.huobi.supermargin.ui.SymbolAssetSuperMarginActivity;
import com.huobi.swap.ui.SwapFinancialActivity;
import com.huobi.swap.ui.SwapTradeBaseFragment;
import com.huobi.utils.a0;
import com.huobi.utils.k0;
import com.huobi.utils.v;
import com.huobi.utils.v0;
import com.huobi.view.BaseBottomCurrencyDialogFragment;
import d7.k;
import io.flutter.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import ks.d;
import pro.huobi.R;
import qk.m;
import rk.e;
import rn.c;
import rx.Observable;
import sn.f;
import tg.r;
import u6.g;
import us.h;
import yl.o;
import yl.x;

public class AssetModuleCallbackImp implements bc.a {

    public class a extends EasySubscriber<SwapCurrencyInfo> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f45176b;

        public a(Context context) {
            this.f45176b = context;
        }

        /* renamed from: a */
        public void onNext(SwapCurrencyInfo swapCurrencyInfo) {
            super.onNext(swapCurrencyInfo);
            SwapTradeBaseFragment.Qi(this.f45176b, swapCurrencyInfo);
        }
    }

    public class b extends EasySubscriber<ContractCurrencyInfo> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f45178b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f45179c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f45180d;

        public b(Context context, String str, String str2) {
            this.f45178b = context;
            this.f45179c = str;
            this.f45180d = str2;
        }

        /* renamed from: a */
        public void onNext(ContractCurrencyInfo contractCurrencyInfo) {
            super.onNext(contractCurrencyInfo);
            if (contractCurrencyInfo != null) {
                f.z(this.f45178b, this.f45179c, this.f45180d, contractCurrencyInfo, TradeType.CONTRACT);
            } else {
                HuobiToastUtil.k(this.f45178b, R.string.n_not_support);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void A1(FragmentActivity fragmentActivity, String str, Throwable th2) {
        u1(fragmentActivity, str);
    }

    public static /* synthetic */ Boolean B1(Boolean bool) {
        return bool;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void C1(FragmentActivity fragmentActivity, String str, Boolean bool) {
        v1(fragmentActivity, str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void D1(FragmentActivity fragmentActivity, String str, APIStatusErrorException aPIStatusErrorException) {
        v1(fragmentActivity, str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void E1(FragmentActivity fragmentActivity, String str, Throwable th2) {
        v1(fragmentActivity, str);
    }

    public static /* synthetic */ Observable F1(String str, List list) {
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            SwapCurrencyInfo swapCurrencyInfo = (SwapCurrencyInfo) it2.next();
            if (str.equalsIgnoreCase(swapCurrencyInfo.getSymbol())) {
                return Observable.just(swapCurrencyInfo);
            }
        }
        return Observable.just(null);
    }

    public static /* synthetic */ Boolean x1(Boolean bool) {
        return bool;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void y1(FragmentActivity fragmentActivity, String str, Boolean bool) {
        u1(fragmentActivity, str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void z1(FragmentActivity fragmentActivity, String str, APIStatusErrorException aPIStatusErrorException) {
        u1(fragmentActivity, str);
    }

    public Bitmap A(View view) {
        return CaptureShareHelper.e(view);
    }

    public void A0(Context context, String str, boolean z11, TradeType tradeType) {
        f.F(context, str, z11, false, tradeType);
    }

    public void B(FragmentActivity fragmentActivity, g gVar) {
    }

    public void B0(Context context) {
        HtExchangeActivity.rh(context);
    }

    public void C(Activity activity) {
        o.y(activity, OtcTradeAreaEnum.FAST_AREA);
    }

    public void C0(Context context, boolean z11, String str) {
        Intent intent;
        if (z11) {
            intent = new Intent(context, SymbolAssetSuperMarginActivity.class);
            intent.putExtra(FirebaseAnalytics.Param.CURRENCY, StringUtils.g(str));
        } else {
            intent = new Intent();
            intent.putExtra("symbol", str);
            intent.setClass(context, LoanSymbolDetailActivity.class);
        }
        context.startActivity(intent);
    }

    public void D(Context context, String str, boolean z11) {
        k0.P(context, str, z11);
    }

    public Observable<ContractUserInfo.UserBean> D0(boolean z11) {
        return ContractUserInfoProvider.i().p(z11);
    }

    public void E(Context context, String str) {
        StringBuffer stringBuffer = new StringBuffer(a0.t());
        stringBuffer.append("/create?copyId=");
        stringBuffer.append(str);
        HBBaseWebActivity.showWebView(context, stringBuffer.toString(), "", "", true);
    }

    public void E0(Boolean bool) {
        r.x().w0(bool);
    }

    public Boolean F() {
        return r.x().W();
    }

    public void F0(Context context, MineDetailInfo mineDetailInfo) {
        Intent intent = new Intent();
        intent.setClass(context, MineCurrencyDetailActivity.class);
        intent.putExtra("currency_detail_info", mineDetailInfo);
        context.startActivity(intent);
    }

    public void G(Context context, LinearSwapAccountInfo linearSwapAccountInfo) {
        Intent intent = new Intent();
        intent.putExtra("linear_swap_detail_info", linearSwapAccountInfo);
        intent.setClass(context, LinearSwapFinancialActivity.class);
        context.startActivity(intent);
    }

    public Observable<List<MarginCurrency>> G0(boolean z11) {
        return d.g(z11);
    }

    public void H(Context context, String str, boolean z11) {
        if (context instanceof FragmentActivity) {
            FragmentActivity fragmentActivity = (FragmentActivity) context;
            nq.a.h(fragmentActivity, fragmentActivity.getSupportFragmentManager(), str, z11);
        }
    }

    public void H0(Context context, boolean z11) {
        if (z11) {
            k0.Q(context);
        } else {
            k0.L(context);
        }
    }

    public void I(Context context, String str) {
        AssetSpotCurrencyDetailActivity.bj(context, str, TradeType.PRO);
    }

    public void I0(Activity activity) {
        Intent h11 = k0.h(activity);
        c.i().m(activity, new JumpTarget(h11, h11));
    }

    public BaseBottomCurrencyDialogFragment J() {
        return new BottomCurrencyDialogFragment();
    }

    public void J0(Context context, int i11) {
        Intent intent = new Intent();
        intent.putExtra("currency_detail_coin_id", i11);
        intent.setClass(context, OtcCurrencyDetailActivity.class);
        context.startActivity(intent);
    }

    public void K(Context context, String str) {
        StringBuffer stringBuffer = new StringBuffer(a0.t());
        stringBuffer.append("/details?id=");
        stringBuffer.append(str);
        HBBaseWebActivity.showWebView(context, stringBuffer.toString(), "", "", true);
    }

    public void K0(FragmentActivity fragmentActivity, String str, String str2, int i11) {
        ImageShareForAssetFragment imageShareForAssetFragment = new ImageShareForAssetFragment();
        imageShareForAssetFragment.Xh(str);
        imageShareForAssetFragment.setTitle(str2);
        imageShareForAssetFragment.Yh(i11);
        imageShareForAssetFragment.show(fragmentActivity.getSupportFragmentManager(), "asset_share[15]");
    }

    public long L(int i11) {
        return bj.d.m(i11);
    }

    public void L0(String str, Map<String, Object> map) {
        is.a.i(str, map);
    }

    public void M(Context context) {
        HBBaseWebActivity.showWebView(context, a0.b(), "", "", true);
    }

    public void M0(Context context, SuperMarginDetailInfo superMarginDetailInfo) {
        Intent intent = new Intent(context, SymbolAssetSuperMarginActivity.class);
        intent.putExtra(FirebaseAnalytics.Param.CURRENCY, StringUtils.g(superMarginDetailInfo.getCurrency()));
        context.startActivity(intent);
    }

    public void N(Context context) {
        f.M(context);
    }

    public boolean N0() {
        return ui.d.h();
    }

    public void O(Context context, String str) {
        SwapCurrencyInfoController.k().f(true).flatMap(new rk.g(str)).compose(RxJavaHelper.t((g) null)).subscribe(new a(context));
    }

    public long O0() {
        return r.x().M().g();
    }

    public void P(Context context, String str, boolean z11, String str2) {
        StringBuffer stringBuffer = new StringBuffer(a0.e());
        stringBuffer.append("?orderId=");
        stringBuffer.append(str);
        stringBuffer.append("&isCurrent=");
        stringBuffer.append(z11);
        stringBuffer.append("&projectType=");
        stringBuffer.append(str2);
        HBBaseWebActivity.showWebView(context, stringBuffer.toString(), "", "", true);
    }

    public void P0(Context context, String str, boolean z11) {
        k0.O(context, str, z11);
    }

    public void Q(Context context, SwapAccountInfo swapAccountInfo) {
        Intent intent = new Intent();
        intent.putExtra("swap_detail_info", swapAccountInfo);
        intent.setClass(context, SwapFinancialActivity.class);
        context.startActivity(intent);
    }

    public Observable<ContractHeartBeat> Q0() {
        return ((ContractService) ContractRetrofit.request(ContractService.class)).systemStatus().compose(ContractRetrofit.h());
    }

    public ContractUserInfo.UserBean R() {
        return ContractUserInfoProvider.i().o();
    }

    public void R0(Context context, String str) {
        OtcOptionsIndexActivity.Qi("", "", context);
    }

    public void S(Context context, C2CMarginBalanceDetailInfo c2CMarginBalanceDetailInfo) {
        C2CMarginFinancialActivity.Hi(context, c2CMarginBalanceDetailInfo.getBaseCurrency(), c2CMarginBalanceDetailInfo.getQuoteCurrency());
    }

    public void S0(Context context, String str) {
        StringBuffer stringBuffer = new StringBuffer(a0.i());
        stringBuffer.append("?currency=");
        stringBuffer.append(str);
        HBBaseWebActivity.showWebView(context, stringBuffer.toString(), "", "", false);
    }

    public String T() {
        String str;
        KycProxy l11 = KycProxy.l();
        if (l11.m() == null || l11.m().getBaseInfo() == null) {
            str = "0";
        } else {
            str = String.valueOf(l11.m().getBaseInfo().getCountryId());
        }
        if (!(!"0".equals(str) || l11.o() == null || l11.o().getUser_info() == null || l11.o().getUser_info().getAuth_country() == null)) {
            str = l11.o().getUser_info().getAuth_country().get("2");
        }
        UserInfoData M = r.x().M();
        int i11 = 0;
        if (!(M == null || M.d() == null || M.d().isEmpty())) {
            i11 = M.d().get(0).intValue();
        }
        if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
            return str;
        }
        return i11 + "";
    }

    public void T0(Context context, BalanceDetailInfo balanceDetailInfo) {
        HashMap hashMap = new HashMap();
        hashMap.put(FirebaseAnalytics.Param.CURRENCY, balanceDetailInfo.getCurrency());
        is.a.i("4639", hashMap);
        Intent intent = new Intent();
        intent.putExtra("currency_detail_info", balanceDetailInfo);
        if (k.C().L(balanceDetailInfo.getCurrency())) {
            intent.setClass(context, CurrencyFromCCDetailActivity.class);
        } else {
            intent.setClass(context, CurrencyDetailActivity.class);
        }
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, 0);
        } else {
            context.startActivity(intent);
        }
    }

    public void U(Context context) {
        ej.c.c(context);
    }

    public void U0(Context context) {
        if (LiteReHelper.a().b()) {
            ra.c.b().k(context);
        }
    }

    public void V(Context context) {
        HBBaseWebActivity.showWebView(context, gj.b.j().l(), "", "", false);
    }

    public void V0(Context context, String str, String str2) {
        FutureContractInfo o11 = FutureContractInfoController.n().o(str2);
        if (o11 == null) {
            o11 = FutureContractInfoController.n().m(str);
        }
        if (o11 != null) {
            f.G(context, o11);
        } else {
            HuobiToastUtil.k(context, R.string.n_not_support);
        }
    }

    public void W(Context context, String str) {
        Intent intent = new Intent(context, MiningDetailActivity.class);
        intent.putExtra("orderId", str);
        context.startActivity(intent);
    }

    public void W0(Context context, String str) {
        try {
            s1((FragmentActivity) context, str);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public Observable<ContractHeartBeat> X() {
        return bj.d.p();
    }

    public void X0(Context context, String str) {
        StrategyDetailActivity.start(context, str);
    }

    public void Y(Context context, TradeType tradeType) {
        m.c(context, tradeType);
    }

    public boolean Y0(g gVar) {
        Map<String, String> B = UserCenterRemoteDataSource.A().B();
        return B.get(KvStore.QUICK_WITHDRAW) != null && KvStore.Y.equals(B.get(KvStore.QUICK_WITHDRAW));
    }

    public void Z(Context context, String str) {
        try {
            t1((FragmentActivity) context, str);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void Z0(Context context, OptionAccountInfo optionAccountInfo) {
        Intent intent = new Intent();
        intent.putExtra("currency_detail_info", new OptionBalanceItem(optionAccountInfo));
        intent.setClass(context, OptionDetailActivity.class);
        context.startActivity(intent);
    }

    public void a0(Context context, MarginBalanceDetailInfo marginBalanceDetailInfo) {
        Intent intent = new Intent();
        intent.putExtra("symbol", marginBalanceDetailInfo.getSymbol());
        intent.setClass(context, LoanSymbolDetailActivity.class);
        context.startActivity(intent);
    }

    public void a1(String str) {
        zn.a.d().v(Uri.parse(str));
        zn.a.d().c();
    }

    public boolean b0(int i11) {
        return bj.d.v(i11);
    }

    public void b1(Context context) {
        zn.a.d().v(Uri.parse("holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/edgeengine/container?scene=margin&rootName=leverHistory&navConfig=&tabType=0&modeType=1&symbol=")).c();
    }

    public boolean c() {
        return r.x().X();
    }

    public void c0(Context context) {
        h.c(context);
    }

    public void c1(Context context, String str) {
        try {
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("word", (Object) str);
            bundle.putString("hotWord", jSONObject.toJSONString());
            SearchFlutterActivity.Gi((Activity) context, bundle);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public boolean d() {
        return bj.d.s();
    }

    public void d0(String str) {
        TimeMonitorManager.a().b(str).c();
    }

    public void d1(Context context) {
        f.f0(context);
    }

    public void e(Context context, String str, boolean z11, TradeType tradeType) {
        f.C(context, str, z11, tradeType);
    }

    public void e0(Context context, String str) {
        if (context instanceof FragmentActivity) {
            FragmentActivity fragmentActivity = (FragmentActivity) context;
            nq.a.j(fragmentActivity, fragmentActivity.getSupportFragmentManager(), str);
        }
    }

    public void e1(Context context) {
        UsdtExchangeActivity.sh(context);
    }

    public void f0(Context context, String str) {
        MarginUtil.a(str);
    }

    public void f1(Context context, String str, String str2) {
        ContractCurrencyInfo h11 = ContractCurrencyUtils.h(str2);
        if (h11 != null) {
            ContractTradeBaseFragment.Ri(context, h11);
        }
    }

    public void g(Activity activity) {
        c.i().m(activity, (kn.a) null);
    }

    public void g0(Context context, boolean z11, TradeType tradeType) {
        m.d(context, z11, tradeType);
    }

    public Observable<ContractUserInfo.UserBean> g1(boolean z11) {
        return ContractUserInfoProvider.i().p(z11);
    }

    public String getUid() {
        return r.x().s();
    }

    public ContractUserInfo.UserBean getUserInfo() {
        return ContractUserInfoProvider.i().o();
    }

    public void h0(Context context, String str) {
        v0.e(context, str);
    }

    public void h1(Context context, String str, String str2) {
        if ("usdt".equalsIgnoreCase(str)) {
            j.b(context, "usdt");
        } else {
            LinearSwapTradeBaseFragment.Lj(context, FutureContractInfoController.n().o(StringUtils.i(str2)), 2);
        }
    }

    public void i0(boolean z11) {
        x.n().w(z11);
    }

    public void i1(Context context) {
        context.startActivity(new Intent(context, CcRecordHomeActivity.class));
    }

    public String j() {
        return a0.j();
    }

    public boolean j0() {
        return x.n().q();
    }

    public void j1(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("EXTRA_SYMBOL", str);
        HbgRouter.i(context, "/trade/grid", bundle);
    }

    public Observable<List<ContractAccountInfo>> k(boolean z11) {
        return bj.d.c(z11);
    }

    public Observable<List<AssetPositionContractData>> k0(Context context) {
        return ContractOrderHelper.g(new HashMap()).flatMap(i.f3526b).map(ContractOrderHelper.d(context)).toList();
    }

    public void k1(Activity activity, String str, String str2) {
        UnifyTransferActivity.Th(activity, str, str2);
    }

    public Observable<List<ContractPriceInfo>> l(boolean z11) {
        return bj.d.l(z11);
    }

    public void l0(String str, String str2) {
        is.a.w(str, str2);
    }

    public void l1(Context context) {
        f.d0(context);
    }

    public void m(String str) {
        if (!str.startsWith("http") && !str.startsWith("holigeit")) {
            str = a0.j() + f.s() + str;
        }
        zn.a.d().v(Uri.parse(str));
        zn.a.d().c();
    }

    public void m0(Context context, String str, boolean z11, int i11) {
        if (context instanceof FragmentActivity) {
            FragmentActivity fragmentActivity = (FragmentActivity) context;
            nq.a.g(fragmentActivity, fragmentActivity.getSupportFragmentManager(), str, z11, i11);
        }
    }

    public void m1(Context context) {
        a1("holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/edgeengine/container?scene=earn&rootName=home&navConfig=");
    }

    public void n(String str, String str2, String str3, boolean z11) {
        TimeMonitorManager.a().b(str).a(str2, str3, z11);
    }

    public void n0(Context context) {
        HBBaseWebActivity.showWebView(context, gj.b.j().m(), "", "", false);
    }

    public void n1(String str, String str2) {
        is.a.k(str, str2);
    }

    public void o(Context context, int i11) {
        String str = a0.s() + "?showbar=1&currentTag=terminated";
        if (i11 == 1) {
            str = str + "&currentType=contract";
        }
        Log.d("openTradingBotClose", "url : " + str);
        HBBaseWebActivity.showWebView(context, str, "", "", true);
    }

    public void o0(Context context) {
        context.startActivity(new Intent(context, OtcOrderDepositActivity.class));
    }

    public void p(Context context, String str) {
        HBBaseWebActivity.showWebView(context, a0.t(), "", "", true);
    }

    public void p0(Context context, String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer(a0.u(str));
        stringBuffer.append("?copyId=");
        stringBuffer.append(str2);
        HBBaseWebActivity.showWebView(context, stringBuffer.toString(), "", "", true);
    }

    public void q(Activity activity) {
        UnifyTransferActivity.Th(activity, (String) null, (String) null);
    }

    public void q0(Context context, LegalDetailInfo legalDetailInfo) {
        Intent intent = new Intent();
        intent.putExtra("currency_detail_info", legalDetailInfo);
        intent.setClass(context, OtcCurrencyDetailActivity.class);
        context.startActivity(intent);
    }

    public void r(Context context, SavingsDetailInfo savingsDetailInfo) {
        Intent intent = new Intent();
        intent.setClass(context, SavingsCurrencyDetailActivity.class);
        intent.putExtra("currency_detail_info", savingsDetailInfo);
        context.startActivity(intent);
    }

    public void r0(Context context) {
        HBBaseWebActivity.showWebView(context, a0.i(), "", "", false);
    }

    public void s(Context context, ContractAccountInfo contractAccountInfo) {
        Intent intent = new Intent();
        intent.putExtra("currency_detail_info", contractAccountInfo);
        intent.setClass(context, ContractDetailActivity.class);
        context.startActivity(intent);
    }

    public void s0(Context context, BalanceDetailInfo balanceDetailInfo) {
        String currency = balanceDetailInfo.getCurrency();
        if (k.C().L(currency)) {
            CurrencyFromCCDetailActivity.Uh(context, (g) null, currency, (CurrencyFromCCDetailActivity.a) null);
        } else {
            AssetSpotCurrencyDetailActivity.bj(context, currency, balanceDetailInfo.getTradeType());
        }
    }

    public final void s1(FragmentActivity fragmentActivity, String str) {
        if (w1(str)) {
            new OtcFaitDWJumpHelper(fragmentActivity, str).t(OtcFaitDWJumpHelper.f78855g, str);
        } else {
            DepositWithdrawController.l(fragmentActivity, str).compose(RxJavaHelper.s()).filter(rk.i.f25729b).subscribe(EasySubscriber.create(new rk.c(this, fragmentActivity, str), new rk.a(this, fragmentActivity, str), new e(this, fragmentActivity, str)));
        }
    }

    public void t(Context context, String str, String str2) {
        if (context instanceof Activity) {
            MarginUtil.c(str2 + str);
        }
    }

    public void t0(Context context, String str, String str2) {
        v.a(context, str, str2);
    }

    public final void t1(FragmentActivity fragmentActivity, String str) {
        if (w1(str)) {
            new OtcFaitDWJumpHelper(fragmentActivity, str).t(OtcFaitDWJumpHelper.f78856h, str);
        } else {
            DepositWithdrawController.m(fragmentActivity, str).compose(RxJavaHelper.s()).filter(rk.h.f25728b).subscribe(EasySubscriber.create(new rk.d(this, fragmentActivity, str), new rk.b(this, fragmentActivity, str), new rk.f(this, fragmentActivity, str)));
        }
    }

    public void track(String str, HashMap hashMap) {
        gs.g.i(str, hashMap);
    }

    public void u(boolean z11) {
    }

    public void u0(Context context, String str, String str2) {
        ContractCurrencyInfo h11 = ContractCurrencyUtils.h(str2);
        if (h11 == null) {
            ContractCurrencyUtils.j(false, str).compose(RxJavaHelper.t((g) null)).subscribe(new b(context, str, str2));
        } else {
            f.z(context, str, str2, h11, TradeType.CONTRACT);
        }
    }

    public final void u1(Activity activity, String str) {
        UnifyDepositActivity.wh(activity, str);
    }

    public void v(Context context, String str, String str2) {
        SwapCurrencyInfo h11 = SwapCurrencyInfoController.k().h(str);
        if (h11 != null) {
            f.I(context, str, str2, h11, TradeType.SWAP);
        } else {
            HuobiToastUtil.k(context, R.string.n_not_support);
        }
    }

    public void v0(Activity activity, String str) {
        CurrencySearchActivity.jj(activity, str, 1, false);
    }

    public final void v1(Activity activity, String str) {
        UnifyWithdrawActivity.Di(activity, str, TradeType.PRO);
    }

    public boolean w() {
        return x.n().p();
    }

    public void w0(Context context, String str) {
        f.X(context, str);
    }

    public final boolean w1(String str) {
        CurrencyBean s11 = k.C().s(str);
        return s11 != null && s11.isFiatTag();
    }

    public void x(Context context, OtcOptionsDetailInfo otcOptionsDetailInfo) {
        Intent intent = new Intent();
        intent.putExtra("currency_detail_info", otcOptionsDetailInfo);
        intent.setClass(context, OtcOptionsDetailActivity.class);
        context.startActivity(intent);
    }

    public void x0(Context context) {
        zn.a.d().v(Uri.parse("holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/edgeengine/container?scene=margin&rootName=leverHistory&navConfig=&tabType=0&modeType=2&symbol=")).c();
    }

    public void y(Activity activity, C2CLendBalanceDetailInfo c2CLendBalanceDetailInfo) {
        C2CLoanOrderActivity.Gi(activity, c2CLendBalanceDetailInfo.getCurrency(), 1);
    }

    public void y0(Activity activity, String str) {
        UnifyTransferActivity.Th(activity, str, "12");
    }

    public void z(boolean z11) {
        HbgDialogManager.d0(z11);
    }

    public boolean z0(String str, String str2, String str3) {
        return nq.a.e(str, str2, str3);
    }
}
