package com.huobi.finance.presenter;

import al.m0;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import cn.sharesdk.framework.InnerShareParams;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.common.utils.crypt.MD5Utils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.IntegrationRiskDescriptionInfo;
import com.hbg.lib.network.pro.core.bean.ChainInfo;
import com.hbg.lib.network.pro.core.bean.RiskActionData;
import com.hbg.lib.network.pro.core.bean.WithdrawRiskInfo;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.huobi.account.helper.AuthData;
import com.huobi.finance.api.FinanceService;
import com.huobi.finance.bean.WithdrawAuditCheck;
import com.huobi.finance.bean.WithdrawTypeItem;
import com.huobi.finance.model.WithdrawRequestParams;
import com.huobi.kyc.util.KycProxy;
import com.huobi.login.usercenter.data.source.bean.KvStore;
import com.huobi.login.usercenter.data.source.bean.SecurityStrategy;
import com.huobi.login.usercenter.data.source.bean.SecurityStrategySet;
import com.huobi.login.usercenter.data.source.bean.UserSecurityInfoData;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel;
import java.util.HashMap;
import java.util.Map;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action0;
import tq.p;
import u6.g;

public class WithdrawInfoConfirmPresenter extends ActivityPresenter<d> {

    /* renamed from: a  reason: collision with root package name */
    public SecurityStrategySet f45776a;

    /* renamed from: b  reason: collision with root package name */
    public Subscription f45777b;

    /* renamed from: c  reason: collision with root package name */
    public String f45778c;

    /* renamed from: d  reason: collision with root package name */
    public String f45779d;

    /* renamed from: e  reason: collision with root package name */
    public String f45780e;

    /* renamed from: f  reason: collision with root package name */
    public String f45781f;

    /* renamed from: g  reason: collision with root package name */
    public String f45782g;

    /* renamed from: h  reason: collision with root package name */
    public String f45783h;

    /* renamed from: i  reason: collision with root package name */
    public String f45784i;

    /* renamed from: j  reason: collision with root package name */
    public WithdrawTypeItem.WithdrawType f45785j;

    /* renamed from: k  reason: collision with root package name */
    public ChainInfo f45786k;

    public class a extends q6.b<IntegrationRiskDescriptionInfo> {
        public a(g gVar, boolean z11) {
            super(gVar, z11);
        }

        /* renamed from: a */
        public void onRequestSuccess(IntegrationRiskDescriptionInfo integrationRiskDescriptionInfo) {
            super.onRequestSuccess(integrationRiskDescriptionInfo);
            ((d) WithdrawInfoConfirmPresenter.this.getUI()).Wc(integrationRiskDescriptionInfo);
        }
    }

    public class b extends q6.d<Pair<UserSecurityInfoData, SecurityStrategySet>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45788e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(g gVar, String str) {
            super(gVar);
            this.f45788e = str;
        }

        /* renamed from: f */
        public void onNext(Pair<UserSecurityInfoData, SecurityStrategySet> pair) {
            super.onNext(pair);
            ((d) WithdrawInfoConfirmPresenter.this.getUI()).rc(this.f45788e, pair);
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
        }
    }

    public class c extends q6.d<WithdrawAuditCheck> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45790e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(g gVar, String str) {
            super(gVar);
            this.f45790e = str;
        }

        /* renamed from: f */
        public void onNext(WithdrawAuditCheck withdrawAuditCheck) {
            super.onNext(withdrawAuditCheck);
            if (!withdrawAuditCheck.isNewAddress() || !withdrawAuditCheck.isSelfCertificate()) {
                ((d) WithdrawInfoConfirmPresenter.this.getUI()).X(this.f45790e, false);
            } else {
                ((d) WithdrawInfoConfirmPresenter.this.getUI()).X(this.f45790e, true);
            }
        }
    }

    public interface d extends g {
        void T(long j11);

        void Wc(IntegrationRiskDescriptionInfo integrationRiskDescriptionInfo);

        void X(String str, boolean z11);

        Map<String, Object> Zc();

        void rc(String str, Pair<UserSecurityInfoData, SecurityStrategySet> pair);

        void y(boolean z11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l0(String str, String str2, String str3, WithdrawRiskInfo withdrawRiskInfo) {
        RiskActionData riskActionData = withdrawRiskInfo.getRiskActionData();
        if (riskActionData == null || riskActionData.getActions() == null || riskActionData.getActions().size() <= 0) {
            String valueOf = String.valueOf(withdrawRiskInfo.getOrderid());
            if (KycProxy.l().p() == 2) {
                String str4 = this.f45778c;
                ChainInfo chainInfo = this.f45786k;
                Y(valueOf, str4, chainInfo != null ? chainInfo.getChain() : null, str, str2, str3);
                return;
            }
            ((d) getUI()).X(valueOf, false);
            return;
        }
        ((d) getUI()).T(riskActionData.getOrderid());
        getActivity().finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m0(APIStatusErrorException aPIStatusErrorException) {
        ((d) getUI()).y(true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n0(Throwable th2) {
        ((d) getUI()).y(true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p0() {
        ((d) getUI()).y(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void q0(WithdrawRequestParams withdrawRequestParams, String str) {
        j0(this.f45779d, this.f45782g, this.f45780e, withdrawRequestParams.k(), a0(withdrawRequestParams.j(), withdrawRequestParams.d(), withdrawRequestParams.i(), withdrawRequestParams.f()), str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void r0(APIStatusErrorException aPIStatusErrorException) {
        ((d) getUI()).y(true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void s0(Throwable th2) {
        ((d) getUI()).y(true);
    }

    public void A0(WithdrawRequestParams withdrawRequestParams) {
        if (this.f45785j == WithdrawTypeItem.WithdrawType.HUO_PAY) {
            i0(withdrawRequestParams);
        } else {
            w0(withdrawRequestParams);
        }
    }

    public final void X() {
        Subscription subscription = this.f45777b;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public final void Y(String str, String str2, String str3, String str4, String str5, String str6) {
        MapParamsBuilder a11 = new MapParamsBuilder().a(FirebaseAnalytics.Param.CURRENCY, str2).a("amount", str6).a(InnerShareParams.ADDRESS, str4).a("tag", str5);
        if (str3 != null) {
            a11.a("chain", str3);
        }
        ((FinanceService) p.W(FinanceService.class)).withdrawAuditCheck(a11.b()).compose(p.a0()).compose(RxJavaHelper.t((g) getUI())).subscribe(new c((g) getUI(), str));
    }

    public String Z() {
        return this.f45783h;
    }

    public AuthData a0(SecurityStrategySet securityStrategySet, String str, String str2, String str3) {
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

    public ChainInfo b0() {
        return this.f45786k;
    }

    public String c0() {
        return this.f45782g;
    }

    public final Observable<WithdrawRiskInfo> d0(Map<String, Object> map, Map<String, Object> map2) {
        Object obj = map.get("AuthData");
        if (obj != null) {
            map.put("authData", obj);
            map.remove("AuthData");
        }
        return x8.a.a().z(map, map2).b();
    }

    public String f0() {
        return this.f45784i;
    }

    public WithdrawTypeItem.WithdrawType g0() {
        return this.f45785j;
    }

    public final q6.d<WithdrawRiskInfo> h0(String str, String str2, String str3) {
        return q6.d.d((g) getUI(), new bc(this, str2, str3, str), new wb(this), new yb(this));
    }

    public final void i0(WithdrawRequestParams withdrawRequestParams) {
        X();
        this.f45777b = UserCenterRemoteDataSource.H(withdrawRequestParams.d(), withdrawRequestParams.i(), withdrawRequestParams.f(), withdrawRequestParams.h(), (Map<String, Object>) null, (Map<String, Object>) null, withdrawRequestParams.l(), q6.d.b((g) getUI(), new ub(this), new ac(this, withdrawRequestParams), new vb(this), new zb(this), (Action0) null), (g) getUI());
    }

    public final void j0(String str, String str2, String str3, String str4, AuthData authData, String str5) {
        Map<String, Object> b11 = MapParamsBuilder.c().a("AuthData", authData.toString()).b();
        HashMap hashMap = new HashMap();
        hashMap.put(InnerShareParams.ADDRESS, str3);
        hashMap.put("amount", str);
        hashMap.put("fee", str2);
        hashMap.put(FirebaseAnalytics.Param.CURRENCY, this.f45778c);
        hashMap.put("prefer-fast", k0());
        hashMap.put("token", str5);
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("addr-tag", str4);
        }
        ChainInfo chainInfo = this.f45786k;
        if (!(chainInfo == null || chainInfo.getChain() == null)) {
            hashMap.put("chain", this.f45786k.getChain());
        }
        this.f45777b = d0(b11, hashMap).compose(RxJavaHelper.t((g) getUI())).subscribe(h0(str, str3, str4));
    }

    public String k0() {
        String str = UserCenterRemoteDataSource.A().B().get(KvStore.QUICK_WITHDRAW);
        if (this.f45785j != WithdrawTypeItem.WithdrawType.EOS && !KvStore.Y.equals(str)) {
            return "0";
        }
        return "1";
    }

    public final Observable<UserSecurityInfoData> t0() {
        return UserCenterRemoteDataSource.A().T().compose(p.c0()).compose(RxJavaHelper.t((g) getUI()));
    }

    public final Observable<SecurityStrategySet> u0() {
        SecurityStrategySet securityStrategySet = this.f45776a;
        if (securityStrategySet == null) {
            return UserCenterRemoteDataSource.A().F().compose(p.c0()).compose(RxJavaHelper.t((g) getUI()));
        }
        return Observable.just(securityStrategySet);
    }

    /* renamed from: v0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, d dVar) {
        super.onUIReady(baseCoreActivity, dVar);
        x0();
        Intent intent = baseCoreActivity.getIntent();
        if (intent != null) {
            this.f45778c = intent.getStringExtra("EXTRA_CURRENCY");
            this.f45779d = intent.getStringExtra("EXTRA_AMOUNT");
            this.f45780e = intent.getStringExtra("EXTRA_ADDRESS");
            this.f45781f = intent.getStringExtra("EXTRA_RISK_LEVEL");
            this.f45782g = intent.getStringExtra("EXTRA_FEE");
            this.f45783h = intent.getStringExtra("EXTRA_ADDRESS_TAG");
            this.f45784i = intent.getStringExtra("EXTRA_RECEIVE_AMOUNT");
            this.f45786k = (ChainInfo) intent.getSerializableExtra("EXTRA_CHAIN_INFO");
            this.f45785j = WithdrawTypeItem.WithdrawType.valueOf(intent.getStringExtra(SNSVideoSelfieViewModel.E));
        }
    }

    public final void w0(WithdrawRequestParams withdrawRequestParams) {
        HashMap hashMap = new HashMap();
        hashMap.put("sms-code", withdrawRequestParams.i());
        hashMap.put("email-code", withdrawRequestParams.d());
        hashMap.put("ga-code", withdrawRequestParams.f());
        hashMap.put("login-password", MD5Utils.c(withdrawRequestParams.h()));
        hashMap.put("order-id", withdrawRequestParams.g());
        x8.a.a().placeWithdrawOrderPhase2(hashMap).b().compose(RxJavaHelper.t((g) getUI())).subscribe(h0(withdrawRequestParams.c(), withdrawRequestParams.b(), withdrawRequestParams.k()));
    }

    public final void x0() {
        v7.b.a().getIntegrationRiskDescription().d(new a((g) getUI(), false));
    }

    public void y0() {
        if (this.f45785j == WithdrawTypeItem.WithdrawType.HUO_PAY) {
            z0((String) null);
        } else {
            x8.a.a().createWithdrawOrderPhase1(((d) getUI()).Zc()).b().compose(RxJavaHelper.t((g) getUI())).subscribe(q6.d.c((g) getUI(), new xb(this)));
        }
    }

    public void z0(String str) {
        Observable.zip(t0(), u0(), m0.f3581b).subscribe(new b((g) getUI(), str));
    }
}
