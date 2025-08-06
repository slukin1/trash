package com.huobi.finance.presenter;

import al.m0;
import al.y;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.EditText;
import androidx.annotation.Keep;
import cn.sharesdk.framework.InnerShareParams;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.zxing.client.android.CaptureActivity;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.common.utils.SoftInputUtils;
import com.hbg.lib.common.utils.SystemUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.network.rx.SilentSubscriber;
import com.hbg.lib.core.permissions.AfterPermissionGranted;
import com.hbg.lib.core.permissions.AppSettingsDialog;
import com.hbg.lib.core.permissions.EasyPermissions;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.BenefitConfig;
import com.hbg.lib.network.hbg.core.bean.BenefitListData;
import com.hbg.lib.network.hbg.core.bean.IntegrationNoticeInfo;
import com.hbg.lib.network.hbg.core.bean.VipBenefitStatus;
import com.hbg.lib.network.hbg.core.bean.VipConfigResult;
import com.hbg.lib.network.pro.core.bean.ChainInfo;
import com.hbg.lib.network.pro.core.bean.ProTokenUpdate;
import com.hbg.lib.network.pro.core.bean.RiskActionData;
import com.hbg.lib.network.pro.core.bean.WithdrawRiskInfo;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.hbg.lib.network.uc.core.utils.LicenseType;
import com.hbg.lib.widgets.utils.PermissionUtils;
import com.huobi.account.entity.BalanceQueryData;
import com.huobi.account.helper.AuthData;
import com.huobi.finance.api.FinanceService;
import com.huobi.finance.bean.ChainItem;
import com.huobi.finance.bean.PreWithdrawData;
import com.huobi.finance.bean.WithdrawAuditCheck;
import com.huobi.finance.bean.WithdrawInfo;
import com.huobi.finance.bean.WithdrawTypeItem;
import com.huobi.finance.controller.DepositWithdrawController;
import com.huobi.finance.utils.DepositWithdrawHelper;
import com.huobi.kyc.util.KycProxy;
import com.huobi.login.usercenter.data.source.bean.KvStore;
import com.huobi.login.usercenter.data.source.bean.SecurityStrategy;
import com.huobi.login.usercenter.data.source.bean.SecurityStrategySet;
import com.huobi.login.usercenter.data.source.bean.TradeRiskReminder;
import com.huobi.login.usercenter.data.source.bean.UserSecurityInfoData;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.luck.picture.lib.permissions.PermissionConfig;
import dt.h2;
import i6.m;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func2;
import tq.p;

public class UnifyWithdrawPresenter extends ActivityPresenter<l> implements EasyPermissions.PermissionCallbacks {

    /* renamed from: o  reason: collision with root package name */
    public static final int f45734o = (SystemUtils.c() ? 9 : 7);

    /* renamed from: b  reason: collision with root package name */
    public final List<ChainItem> f45735b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final List<WithdrawTypeItem> f45736c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public String f45737d;

    /* renamed from: e  reason: collision with root package name */
    public String f45738e = "btc";

    /* renamed from: f  reason: collision with root package name */
    public WithdrawInfo f45739f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f45740g;

    /* renamed from: h  reason: collision with root package name */
    public TradeType f45741h;

    /* renamed from: i  reason: collision with root package name */
    public Subscription f45742i;

    /* renamed from: j  reason: collision with root package name */
    public SecurityStrategySet f45743j;

    /* renamed from: k  reason: collision with root package name */
    public ChainInfo f45744k;

    /* renamed from: l  reason: collision with root package name */
    public WithdrawTypeItem.WithdrawType f45745l;

    /* renamed from: m  reason: collision with root package name */
    public ChainItem.a f45746m = new c();

    /* renamed from: n  reason: collision with root package name */
    public WithdrawTypeItem.a f45747n = new d();

    public class a implements Action1<SecurityStrategySet> {
        public a() {
        }

        /* renamed from: a */
        public void call(SecurityStrategySet securityStrategySet) {
            SecurityStrategySet unused = UnifyWithdrawPresenter.this.f45743j = securityStrategySet;
            UnifyWithdrawPresenter.this.Q1(true);
            UnifyWithdrawPresenter.this.O1();
        }
    }

    public class b implements Action1<String> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Map f45749b;

        public b(Map map) {
            this.f45749b = map;
        }

        /* renamed from: a */
        public void call(String str) {
            String str2 = (String) this.f45749b.get("amount");
            if ("RISK_INTERCEPT".equals(str)) {
                ((l) UnifyWithdrawPresenter.this.getUI()).T6(str2);
            } else if ("RISK_EXIST".equals(str)) {
                ((l) UnifyWithdrawPresenter.this.getUI()).I5(str2);
            } else {
                ((l) UnifyWithdrawPresenter.this.getUI()).e6(str2);
            }
        }
    }

    public class c implements ChainItem.a {
        public c() {
        }

        public boolean a(int i11, ChainInfo chainInfo) {
            return UnifyWithdrawPresenter.this.f45744k != null && UnifyWithdrawPresenter.this.f45744k.equals(chainInfo);
        }

        public void b(int i11, ChainInfo chainInfo) {
            if (!DepositWithdrawHelper.w(chainInfo)) {
                DepositWithdrawController.z(UnifyWithdrawPresenter.this.getActivity(), chainInfo);
            } else {
                UnifyWithdrawPresenter.this.O0(chainInfo);
            }
        }
    }

    public class d implements WithdrawTypeItem.a {
        public d() {
        }

        public void a(int i11, WithdrawTypeItem withdrawTypeItem) {
            SoftInputUtils.f(UnifyWithdrawPresenter.this.getActivity());
            UnifyWithdrawPresenter.this.P0(withdrawTypeItem);
        }

        public boolean b(int i11, WithdrawTypeItem withdrawTypeItem) {
            return UnifyWithdrawPresenter.this.f45745l == withdrawTypeItem.g();
        }
    }

    public class e extends BaseSubscriber<IntegrationNoticeInfo> {
        public e() {
        }

        /* renamed from: a */
        public void onNext(IntegrationNoticeInfo integrationNoticeInfo) {
            if (integrationNoticeInfo != null) {
                ((l) UnifyWithdrawPresenter.this.getUI()).K6(integrationNoticeInfo);
            }
        }
    }

    public class f implements Func2<ChainInfo, ChainInfo, Integer> {
        public f() {
        }

        /* renamed from: a */
        public Integer call(ChainInfo chainInfo, ChainInfo chainInfo2) {
            if (chainInfo.isDefaultChain() && chainInfo2.isDefaultChain()) {
                return 0;
            }
            if (chainInfo.isDefaultChain()) {
                return -1;
            }
            if (chainInfo2.isDefaultChain()) {
                return 1;
            }
            return 0;
        }
    }

    public class g extends EasySubscriber<WithdrawInfo> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f45755b;

        public g(boolean z11) {
            this.f45755b = z11;
        }

        /* renamed from: a */
        public void onNext(WithdrawInfo withdrawInfo) {
            super.onNext(withdrawInfo);
            WithdrawInfo unused = UnifyWithdrawPresenter.this.f45739f = withdrawInfo;
            List F0 = UnifyWithdrawPresenter.this.T1(withdrawInfo);
            UnifyWithdrawPresenter.this.f45736c.clear();
            UnifyWithdrawPresenter.this.f45736c.addAll(F0);
            ((l) UnifyWithdrawPresenter.this.getUI()).h9(F0);
            ((l) UnifyWithdrawPresenter.this.getUI()).Z9(UnifyWithdrawPresenter.this.f45737d, withdrawInfo);
        }

        public void onAfter() {
            super.onAfter();
            boolean unused = UnifyWithdrawPresenter.this.f45740g = false;
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            th2.printStackTrace();
            if (this.f45755b) {
                ((l) UnifyWithdrawPresenter.this.getUI()).ye(false);
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            aPIStatusErrorException.printStackTrace();
            if (this.f45755b) {
                ((l) UnifyWithdrawPresenter.this.getUI()).ye("base-currency-not-open".equals(aPIStatusErrorException.getErrCode()));
            }
        }

        public void onStart() {
            super.onStart();
            ((l) UnifyWithdrawPresenter.this.getUI()).A(true);
        }
    }

    public class h extends EasySubscriber<WithdrawInfo> {
        public h() {
        }

        /* renamed from: a */
        public void onNext(WithdrawInfo withdrawInfo) {
            super.onNext(withdrawInfo);
            ((l) UnifyWithdrawPresenter.this.getUI()).K3(UnifyWithdrawPresenter.this.f45735b);
            List F0 = UnifyWithdrawPresenter.this.T1(withdrawInfo);
            UnifyWithdrawPresenter.this.f45736c.clear();
            UnifyWithdrawPresenter.this.f45736c.addAll(F0);
            ((l) UnifyWithdrawPresenter.this.getUI()).h9(UnifyWithdrawPresenter.this.f45736c);
            WithdrawInfo unused = UnifyWithdrawPresenter.this.f45739f = withdrawInfo;
            ((l) UnifyWithdrawPresenter.this.getUI()).Z9(UnifyWithdrawPresenter.this.f45737d, withdrawInfo);
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            th2.printStackTrace();
            ((l) UnifyWithdrawPresenter.this.getUI()).ye(false);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            aPIStatusErrorException.printStackTrace();
            ((l) UnifyWithdrawPresenter.this.getUI()).ye("base-currency-not-open".equals(aPIStatusErrorException.getErrCode()));
        }

        public void onStart() {
            super.onStart();
            ((l) UnifyWithdrawPresenter.this.getUI()).A(true);
        }
    }

    public class i extends EasySubscriber<WithdrawInfo> {
        public i() {
        }

        /* renamed from: a */
        public void onNext(WithdrawInfo withdrawInfo) {
            super.onNext(withdrawInfo);
            ((l) UnifyWithdrawPresenter.this.getUI()).K3(UnifyWithdrawPresenter.this.f45735b);
            ((l) UnifyWithdrawPresenter.this.getUI()).h9(UnifyWithdrawPresenter.this.f45736c);
            WithdrawInfo unused = UnifyWithdrawPresenter.this.f45739f = withdrawInfo;
            ((l) UnifyWithdrawPresenter.this.getUI()).Z9(UnifyWithdrawPresenter.this.f45737d, withdrawInfo);
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            th2.printStackTrace();
            ((l) UnifyWithdrawPresenter.this.getUI()).ye(false);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            aPIStatusErrorException.printStackTrace();
            ((l) UnifyWithdrawPresenter.this.getUI()).ye("base-currency-not-open".equals(aPIStatusErrorException.getErrCode()));
        }

        public void onStart() {
            super.onStart();
            ((l) UnifyWithdrawPresenter.this.getUI()).A(true);
        }
    }

    public class j extends q6.d<WithdrawAuditCheck> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45759e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(u6.g gVar, String str) {
            super(gVar);
            this.f45759e = str;
        }

        /* renamed from: f */
        public void onNext(WithdrawAuditCheck withdrawAuditCheck) {
            super.onNext(withdrawAuditCheck);
            if (!withdrawAuditCheck.isNewAddress() || !withdrawAuditCheck.isSelfCertificate()) {
                ((l) UnifyWithdrawPresenter.this.getUI()).X(this.f45759e, false);
            } else {
                ((l) UnifyWithdrawPresenter.this.getUI()).X(this.f45759e, true);
            }
        }
    }

    public class k extends q6.d<Pair<UserSecurityInfoData, SecurityStrategySet>> {
        public k(u6.g gVar) {
            super(gVar);
        }

        /* renamed from: f */
        public void onNext(Pair<UserSecurityInfoData, SecurityStrategySet> pair) {
            super.onNext(pair);
            ((l) UnifyWithdrawPresenter.this.getUI()).C(pair);
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
        }
    }

    public interface l extends u6.g {
        void A(boolean z11);

        void C(Pair<UserSecurityInfoData, SecurityStrategySet> pair);

        void I5(String str);

        void Ie();

        void J5();

        void K3(List<ChainItem> list);

        void K6(IntegrationNoticeInfo integrationNoticeInfo);

        EditText M8();

        void T(long j11);

        void T6(String str);

        void X(String str, boolean z11);

        void Z9(String str, WithdrawInfo withdrawInfo);

        void e6(String str);

        void ea(int i11, boolean z11);

        void f5();

        void h9(List<WithdrawTypeItem> list);

        void s8(String str);

        void u4();

        void y(boolean z11);

        void ye(boolean z11);

        void yf(int i11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void C1(Boolean bool) {
        i6.d.i("[WithdrawAntiFraud]CheckWithdrawBlacklist result = " + bool);
        if (bool.booleanValue()) {
            i6.d.i("[WithdrawAntiFraud] showBlacklistUserDialog");
            ((l) getUI()).J5();
            return;
        }
        N1();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void D1(APIStatusErrorException aPIStatusErrorException) {
        N1();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void E1(Throwable th2) {
        N1();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void F1() {
        ((l) getUI()).y(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void G1(SecurityStrategySet securityStrategySet, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        g2(str4, str5, str6, str7, R0(securityStrategySet, str, str2, str3), str8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void H1(APIStatusErrorException aPIStatusErrorException) {
        ((l) getUI()).y(true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void I1(Throwable th2) {
        ((l) getUI()).y(true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void J1(String[] strArr, int i11) {
        if (i11 == 0) {
            Intent intent = new Intent(getActivity(), CaptureActivity.class);
            intent.putExtra(CaptureActivity.PARAM_HINT_TEXT, getString(R.string.scan_text_hint));
            getActivity().startActivityForResult(intent, 200);
        } else if (i11 == 2) {
            EasyPermissions.requestPermissions(getActivity(), 123, strArr);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void K1(String str, String str2, String str3, WithdrawRiskInfo withdrawRiskInfo) {
        RiskActionData riskActionData = withdrawRiskInfo.getRiskActionData();
        if (riskActionData == null || riskActionData.getActions() == null || riskActionData.getActions().size() <= 0) {
            String valueOf = String.valueOf(withdrawRiskInfo.getOrderid());
            if (KycProxy.l().p() == 2) {
                String str4 = this.f45737d;
                ChainInfo chainInfo = this.f45744k;
                L0(valueOf, str4, chainInfo != null ? chainInfo.getChain() : null, str, str2, str3);
                return;
            }
            ((l) getUI()).X(valueOf, false);
            return;
        }
        ((l) getUI()).T(riskActionData.getOrderid());
        getActivity().finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void L1(APIStatusErrorException aPIStatusErrorException) {
        ((l) getUI()).y(true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void M1(Throwable th2) {
        ((l) getUI()).y(true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l1(String str) {
        ((l) getUI()).u4();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ String m1(BalanceQueryData balanceQueryData) {
        return balanceQueryData.getAvailableBalance(this.f45737d);
    }

    public static /* synthetic */ WithdrawInfo n1(WithdrawInfo withdrawInfo, PreWithdrawData preWithdrawData, UserSecurityInfoData userSecurityInfoData, SecurityStrategySet securityStrategySet) {
        withdrawInfo.m(userSecurityInfoData);
        withdrawInfo.n(securityStrategySet);
        withdrawInfo.l(preWithdrawData);
        return withdrawInfo;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o1(TradeRiskReminder tradeRiskReminder) {
        i6.d.i("[WithdrawAntiFraud] loadAgreementState success." + tradeRiskReminder);
        if (tradeRiskReminder != null && !"1".equals(tradeRiskReminder.getState())) {
            i6.d.i("[WithdrawAntiFraud] showAntiFraudAgreementDialog");
            ((l) getUI()).Ie();
        }
    }

    public static /* synthetic */ List p1(VipConfigResult vipConfigResult) {
        for (BenefitConfig next : vipConfigResult.getBenefits()) {
            if (f45734o == next.getId()) {
                return next.getLevels();
            }
        }
        return new ArrayList();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Integer q1(List list, BenefitListData benefitListData) {
        if (!list.contains(Integer.valueOf(benefitListData.getLevel()))) {
            i6.d.j("applyMoreAmount", "User is VIP but level " + benefitListData.getLevel() + " doesn't match " + list.toString() + ", Hide Btn.");
            return 0;
        } else if (g1(benefitListData)) {
            i6.d.j("applyMoreAmount", "Apply in progress.");
            return 2;
        } else {
            i6.d.j("applyMoreAmount", "##OK##, show Btn.");
            return 1;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void r1(Integer num) {
        ((l) getUI()).yf(num.intValue());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void s1(List list) {
        this.f45744k = DepositWithdrawHelper.m(list);
        this.f45735b.clear();
        boolean y11 = DepositWithdrawHelper.y(list);
        if (list != null) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                ChainInfo chainInfo = (ChainInfo) it2.next();
                if (chainInfo != null) {
                    ChainItem chainItem = new ChainItem();
                    chainItem.f(this.f45746m);
                    chainItem.g(chainInfo);
                    chainItem.h(chainInfo.equals(this.f45744k));
                    if (!y11) {
                        this.f45735b.add(chainItem);
                    } else if (DepositWithdrawHelper.w(chainInfo)) {
                        this.f45735b.add(chainItem);
                    }
                }
            }
        }
        ((l) getUI()).K3(this.f45735b);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ WithdrawInfo u1(boolean z11, List list, String str, List list2) {
        WithdrawInfo withdrawInfo;
        if (z11) {
            withdrawInfo = e1(list, str);
        } else {
            withdrawInfo = f1(str);
        }
        withdrawInfo.h(list2);
        return withdrawInfo;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void w1(SecurityStrategySet securityStrategySet) {
        this.f45743j = securityStrategySet;
        Q1(this.f45740g);
        O1();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void x1(APIStatusErrorException aPIStatusErrorException) {
        ((l) getUI()).ye(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void y1(Throwable th2) {
        ((l) getUI()).ye(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void z1(TradeRiskReminder tradeRiskReminder) {
        if (tradeRiskReminder == null || "1".equals(tradeRiskReminder.getState())) {
            Z1();
        } else {
            ((l) getUI()).f5();
        }
    }

    public void I0() {
        i6.d.i("[WithdrawAntiFraud] agreeAntiFraud");
        UserCenterRemoteDataSource.A().s0(LicenseType.WITHDRAWAL_RISK_NOTIFICATIONS).d((RequestCallback1) null);
    }

    public void J0() {
        v7.b.a().P((long) f45734o).b().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(q6.d.c((u6.g) getUI(), new ha(this)));
    }

    public final void K0() {
        Subscription subscription = this.f45742i;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public final void L0(String str, String str2, String str3, String str4, String str5, String str6) {
        MapParamsBuilder a11 = new MapParamsBuilder().a(FirebaseAnalytics.Param.CURRENCY, str2).a("amount", str6).a(InnerShareParams.ADDRESS, str4).a("tag", str5);
        if (str3 != null) {
            a11.a("chain", str3);
        }
        ((FinanceService) p.W(FinanceService.class)).withdrawAuditCheck(a11.b()).compose(p.a0()).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new j((u6.g) getUI(), str));
    }

    public void M0(Map<String, Object> map) {
        WithdrawTypeItem.WithdrawType withdrawType = this.f45745l;
        if (withdrawType == WithdrawTypeItem.WithdrawType.EOS) {
            Z1();
        } else if (withdrawType == WithdrawTypeItem.WithdrawType.HUO_PAY) {
            Y1();
        } else {
            map.put(FirebaseAnalytics.Param.CURRENCY, T0());
            map.put("prefer-fast", k1());
            map.put("verify-risk-address", 1);
            ChainInfo S0 = S0();
            if (!(S0 == null || S0.getChain() == null)) {
                map.put("chain", S0.getChain());
            }
            x8.a.a().checkWithdrawLimit(map).b().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(q6.d.c((u6.g) getUI(), new b(map)));
        }
    }

    public void N0() {
        this.f45743j = null;
    }

    public final void N1() {
        i6.d.i("[WithdrawAntiFraud] loadAgreementState");
        UserCenterRemoteDataSource.A().requestLicenseState(LicenseType.WITHDRAWAL_RISK_NOTIFICATIONS.type, false).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(SilentSubscriber.a(new eb(this)));
    }

    public final void O0(ChainInfo chainInfo) {
        if (this.f45739f == null) {
            Q1(true);
            return;
        }
        K0();
        this.f45744k = chainInfo;
        this.f45745l = WithdrawTypeItem.WithdrawType.NORMAL;
        this.f45742i = v1(this.f45739f).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new h());
    }

    public final void O1() {
        if (!h1()) {
            i6.d.j("applyMoreAmount", "Auth Fail, Hide Btn.");
            ((l) getUI()).yf(0);
        } else if (!os.c.l()) {
            i6.d.j("applyMoreAmount", "Not VIP, Hide Btn.");
            ((l) getUI()).yf(0);
        } else {
            Observable.zip(v7.b.a().getVipConfig(AppLanguageHelper.getInstance().getCurLanguageHeader(), (String) null).b().map(ua.f46138b), v7.b.a().getVipBenefitList().b(), new wa(this)).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new SilentSubscriber(new ga(this)));
        }
    }

    public final void P0(WithdrawTypeItem withdrawTypeItem) {
        if (this.f45739f == null) {
            Q1(true);
            return;
        }
        K0();
        this.f45745l = withdrawTypeItem.g();
        this.f45742i = v1(this.f45739f).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new i());
    }

    public Observable<List<ChainInfo>> P1() {
        return d7.k.C().r(this.f45737d, false, AppLanguageHelper.getInstance().getCurLanguageHeader(), "1").compose(RxJavaHelper.t((u6.g) getUI()));
    }

    public final Observable<String> Q0(boolean z11) {
        return h2.t1().v3(this.f45741h, z11).map(new sa(this)).compose(RxJavaHelper.t((u6.g) getUI()));
    }

    public void Q1(boolean z11) {
        K0();
        this.f45742i = Observable.zip(P1().flatMap(ad.i.f3526b).toSortedList(new f()).doOnNext(new ma(this)), Q0(false), ((FinanceService) p.W(FinanceService.class)).getInnerWithdrawAddress(this.f45737d).compose(p.a0()).onErrorResumeNext(va.f46152b).compose(RxJavaHelper.t((u6.g) getUI())), new xa(this, z11)).flatMap(new ta(this)).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new g(z11));
    }

    public AuthData R0(SecurityStrategySet securityStrategySet, String str, String str2, String str3) {
        AuthData authData = new AuthData();
        SecurityStrategy setting = securityStrategySet.getSetting();
        if (setting.isVerify_ga()) {
            authData.setGa_code(str3);
        }
        if (setting.isVerify_email()) {
            authData.setEmail_code(str);
        }
        if (setting.isVerify_phone()) {
            authData.setSms_code(str2);
        }
        return authData;
    }

    public final Observable<UserSecurityInfoData> R1() {
        return UserCenterRemoteDataSource.A().T().compose(p.c0()).compose(RxJavaHelper.t((u6.g) getUI()));
    }

    public ChainInfo S0() {
        return this.f45744k;
    }

    public final Observable<SecurityStrategySet> S1() {
        SecurityStrategySet securityStrategySet = this.f45743j;
        if (securityStrategySet == null) {
            return UserCenterRemoteDataSource.A().F().compose(p.c0()).compose(RxJavaHelper.t((u6.g) getUI()));
        }
        return Observable.just(securityStrategySet);
    }

    public String T0() {
        return this.f45737d;
    }

    public final List<WithdrawTypeItem> T1(WithdrawInfo withdrawInfo) {
        boolean z11 = y.b(withdrawInfo.a()) && this.f45744k.isDefaultChain();
        boolean g11 = withdrawInfo.g();
        ArrayList arrayList = new ArrayList();
        if (z11 || g11) {
            WithdrawTypeItem withdrawTypeItem = new WithdrawTypeItem();
            withdrawTypeItem.l(WithdrawTypeItem.WithdrawType.NORMAL);
            withdrawTypeItem.j(getResources().getString(R.string.currency_detail_withdraw_common));
            withdrawTypeItem.k(true);
            withdrawTypeItem.i(this.f45747n);
            arrayList.add(withdrawTypeItem);
        }
        if (g11) {
            WithdrawTypeItem withdrawTypeItem2 = new WithdrawTypeItem();
            withdrawTypeItem2.l(WithdrawTypeItem.WithdrawType.HUO_PAY);
            withdrawTypeItem2.j(getResources().getString(R.string.n_withdraw_huo_pay_title));
            withdrawTypeItem2.k(false);
            withdrawTypeItem2.i(this.f45747n);
            arrayList.add(withdrawTypeItem2);
        }
        if (z11) {
            WithdrawTypeItem withdrawTypeItem3 = new WithdrawTypeItem();
            withdrawTypeItem3.l(WithdrawTypeItem.WithdrawType.EOS);
            withdrawTypeItem3.j(getResources().getString(R.string.n_withdraw_ECO_title));
            withdrawTypeItem3.k(false);
            withdrawTypeItem3.i(this.f45747n);
            arrayList.add(withdrawTypeItem3);
        }
        if (this.f45745l == null) {
            this.f45745l = WithdrawTypeItem.WithdrawType.NORMAL;
        }
        return arrayList;
    }

    public final void U0() {
        v7.b.a().getIntegrationNotice().b().compose(RxJavaHelper.t((u6.g) null)).subscribe(new e());
    }

    public final void U1(int i11, boolean z11) {
        ((l) getUI()).ea(i11, z11);
    }

    public WithdrawTypeItem.WithdrawType V0() {
        return this.f45745l;
    }

    public void V1() {
        if (this.f45743j == null) {
            S1().subscribe(SilentSubscriber.a(new a()));
        }
    }

    public String W0() {
        return this.f45738e;
    }

    public void W1() {
        UserCenterRemoteDataSource.A().s0(LicenseType.HUO_PAY_AUTH).d((RequestCallback1) null);
        Z1();
    }

    public final Observable<PreWithdrawData> X0() {
        MapParamsBuilder a11 = new MapParamsBuilder().a(FirebaseAnalytics.Param.CURRENCY, this.f45737d);
        ChainInfo chainInfo = this.f45744k;
        if (!(chainInfo == null || chainInfo.getChain() == null)) {
            a11.a("chain", this.f45744k.getChain());
        }
        return ((FinanceService) p.W(FinanceService.class)).preWithdrawData(a11.b()).compose(p.a0()).compose(RxJavaHelper.t((u6.g) getUI()));
    }

    /* renamed from: X1 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, l lVar) {
        super.onUIReady(baseCoreActivity, lVar);
        EventBus.d().p(this);
        String stringExtra = getActivity().getIntent().getStringExtra("coin");
        this.f45737d = stringExtra;
        if (stringExtra == null) {
            this.f45737d = "btc";
        }
        this.f45738e = d7.k.C().z(this.f45737d);
        ((l) getUI()).s8(this.f45738e);
        Serializable serializableExtra = getActivity().getIntent().getSerializableExtra("TradeType");
        if (serializableExtra instanceof TradeType) {
            this.f45741h = (TradeType) serializableExtra;
        } else {
            this.f45741h = TradeType.PRO;
        }
        this.f45740g = true;
        ((l) getUI()).K3(this.f45735b);
        ((l) getUI()).A(true);
        S1().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(EasySubscriber.create(new db(this), new ab(this), new ia(this)));
        b2();
        U0();
    }

    public String Y0() {
        return DepositWithdrawHelper.p(this.f45744k);
    }

    public final void Y1() {
        UserCenterRemoteDataSource.A().requestLicenseState(LicenseType.HUO_PAY_AUTH.type, false).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(q6.d.d((u6.g) getUI(), new fb(this), pa.f46062b, ra.f46094b));
    }

    public WithdrawInfo Z0() {
        return this.f45739f;
    }

    public void Z1() {
        Observable.zip(R1(), S1(), m0.f3581b).subscribe(new k((u6.g) getUI()));
    }

    /* renamed from: a1 */
    public final Observable<WithdrawInfo> v1(WithdrawInfo withdrawInfo) {
        return Observable.zip(Observable.just(withdrawInfo), X0(), R1(), S1(), ya.f46195b);
    }

    public int a2() {
        SecurityStrategy setting = this.f45739f.f().getSetting();
        int i11 = (setting.isVerify_phone() ? 1 : 0) + (setting.isVerify_email() ? 1 : 0) + (setting.isVerify_ga() ? 1 : 0);
        if (KycProxy.l().p() == 2) {
            if (i11 < 2) {
                U1(1, true);
                return 1;
            }
            U1(10, true);
            return 10;
        } else if (i11 < 2) {
            U1(3, true);
            return 3;
        } else {
            U1(2, true);
            return 2;
        }
    }

    public String b1() {
        return DepositWithdrawHelper.q(this.f45744k);
    }

    public void b2() {
        i6.d.i("[WithdrawAntiFraud]Start checkWithdrawBlacklist");
        x8.a.a().checkWithdrawBlacklist().b().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(SilentSubscriber.b(new gb(this), new za(this), new ka(this)));
    }

    public final Observable<WithdrawRiskInfo> c1(Map<String, Object> map, Map<String, Object> map2) {
        if (this.f45745l != WithdrawTypeItem.WithdrawType.HUO_PAY) {
            return ((FinanceService) p.W(FinanceService.class)).createWithdrawOrder(map, map2).compose(p.a0());
        }
        Object obj = map.get("AuthData");
        if (obj != null) {
            map.put("authData", obj);
            map.remove("AuthData");
        }
        return x8.a.a().z(map, map2).b();
    }

    public void c2(SecurityStrategySet securityStrategySet, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        K0();
        qa qaVar = new qa(this);
        na naVar = new na(this, securityStrategySet, str2, str3, str4, str6, str9, str7, str8);
        String str10 = str2;
        String str11 = str3;
        String str12 = str4;
        String str13 = str5;
        String str14 = str;
        this.f45742i = UserCenterRemoteDataSource.G(str10, str11, str12, str13, (Map<String, Object>) null, str14, q6.d.b((u6.g) getUI(), qaVar, naVar, new cb(this), new la(this), (Action0) null), (u6.g) getUI());
    }

    public int d1() {
        return DepositWithdrawHelper.r(this.f45744k);
    }

    @AfterPermissionGranted(123)
    public void d2() {
        String[] strArr;
        if (Build.VERSION.SDK_INT >= 33) {
            strArr = new String[]{"android.permission.CAMERA", PermissionConfig.READ_MEDIA_IMAGES};
        } else {
            strArr = new String[]{"android.permission.CAMERA", PermissionConfig.WRITE_EXTERNAL_STORAGE};
        }
        PermissionUtils.g(getActivity(), new fa(this, strArr));
    }

    public final WithdrawInfo e1(List<ChainInfo> list, String str) {
        WithdrawInfo withdrawInfo = new WithdrawInfo();
        withdrawInfo.i(e2(str, this.f45737d));
        withdrawInfo.k(this.f45737d);
        withdrawInfo.j(list);
        return withdrawInfo;
    }

    public final String e2(String str, String str2) {
        return m.m(str, PrecisionUtil.a(this.f45741h, str2));
    }

    public final WithdrawInfo f1(String str) {
        this.f45739f.i(e2(str, this.f45737d));
        this.f45739f.k(this.f45737d);
        return this.f45739f;
    }

    public void f2(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f45737d = str;
            this.f45738e = d7.k.C().z(str);
            this.f45745l = null;
            Q1(true);
        }
    }

    public final boolean g1(BenefitListData benefitListData) {
        for (VipBenefitStatus next : benefitListData.getBenefits()) {
            if (f45734o == next.getBenefitId() && next.getState() == 1) {
                return true;
            }
        }
        return false;
    }

    public final void g2(String str, String str2, String str3, String str4, AuthData authData, String str5) {
        Map<String, Object> b11 = MapParamsBuilder.c().a("AuthData", authData.toString()).b();
        HashMap hashMap = new HashMap();
        hashMap.put(InnerShareParams.ADDRESS, str3);
        hashMap.put("amount", str);
        hashMap.put("fee", str2);
        hashMap.put(FirebaseAnalytics.Param.CURRENCY, this.f45737d);
        hashMap.put("prefer-fast", k1());
        hashMap.put("token", str5);
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("addr-tag", str4);
        }
        ChainInfo chainInfo = this.f45744k;
        if (!(chainInfo == null || chainInfo.getChain() == null)) {
            hashMap.put("chain", this.f45744k.getChain());
        }
        this.f45742i = c1(b11, hashMap).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(q6.d.d((u6.g) getUI(), new oa(this, str3, str4, str), new bb(this), new ja(this)));
    }

    public final boolean h1() {
        SecurityStrategySet securityStrategySet = this.f45743j;
        if (securityStrategySet == null || securityStrategySet.getSetting() == null) {
            return false;
        }
        SecurityStrategy setting = this.f45743j.getSetting();
        int i11 = (setting.isVerify_phone() ? 1 : 0) + (setting.isVerify_email() ? 1 : 0) + (setting.isVerify_ga() ? 1 : 0);
        boolean z11 = KycProxy.l().p() == 2;
        boolean z12 = i11 >= 2;
        if (!z11 || !z12) {
            return false;
        }
        return true;
    }

    public int h2(String str, boolean z11) {
        BigDecimal subtract = new BigDecimal(str).subtract(m.a(((l) getUI()).M8().getText().toString()));
        BigDecimal a11 = m.a(this.f45739f.e().d());
        if (a11.compareTo(new BigDecimal(-1)) == 0) {
            z11 = true;
        }
        if (z11 || subtract.compareTo(a11) <= 0) {
            return 0;
        }
        return a2();
    }

    public boolean i1() {
        return DepositWithdrawHelper.s(this.f45744k);
    }

    public boolean j1() {
        return DepositWithdrawHelper.t(this.f45744k);
    }

    public String k1() {
        String str = UserCenterRemoteDataSource.A().B().get(KvStore.QUICK_WITHDRAW);
        if (this.f45745l != WithdrawTypeItem.WithdrawType.EOS && !KvStore.Y.equals(str)) {
            return "0";
        }
        return "1";
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i12 == -1 && i11 == 1001 && intent != null) {
            f2(intent.getStringExtra("coin"));
        }
    }

    public void onDestroy() {
        EventBus.d().r(this);
        super.onDestroy();
    }

    public void onPermissionsDenied(int i11, List<String> list) {
        if (EasyPermissions.somePermissionPermanentlyDenied(getActivity(), list)) {
            new AppSettingsDialog.Builder((Activity) getActivity(), getString(R.string.permission_camera_write_external_storage_apply)).setTitle(getString(R.string.permission_apply)).setPositiveButton(getString(R.string.go_to_settings)).setNegativeButton(getString(R.string.global_string_cancel), (DialogInterface.OnClickListener) null).setRequestCode(125).build().show();
        }
    }

    public void onPermissionsGranted(int i11, List<String> list) {
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onProTokenUpdate(ProTokenUpdate proTokenUpdate) {
        if (TextUtils.isEmpty(proTokenUpdate.getProToken()) && getUI() != null && ((l) getUI()).isAlive()) {
            getActivity().finish();
        }
    }

    public void onStop() {
        K0();
        super.onStop();
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        rn.c.i().m(getActivity(), (kn.a) null);
        getActivity().finish();
    }
}
