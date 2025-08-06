package com.huobi.account.presenter;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.huobi.finance.utils.Security2FADialogHelper;
import com.huobi.login.usercenter.data.source.bean.CodeVerifyData;
import com.huobi.login.usercenter.data.source.bean.SecurityStrategySet;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.huobi.riskcontrol.bean.SecurityVerifyParam;
import com.tencent.qcloud.tuicore.TUIConstants;
import i6.d;
import java.util.HashMap;
import java.util.Map;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import rn.c;
import rx.Observable;
import rx.subscriptions.CompositeSubscription;
import tq.p;
import u6.g;
import ug.a0;
import ug.w;
import ug.x;
import ug.y;
import ug.z;

public class SecurityLinkStatusPresenter extends ActivityPresenter<b> {

    /* renamed from: a  reason: collision with root package name */
    public String f41046a;

    /* renamed from: b  reason: collision with root package name */
    public String f41047b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f41048c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f41049d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f41050e;

    /* renamed from: f  reason: collision with root package name */
    public final CompositeSubscription f41051f = new CompositeSubscription();

    /* renamed from: g  reason: collision with root package name */
    public int f41052g;

    public class a extends EasySubscriber<CodeVerifyData> {
        public a() {
        }

        /* renamed from: a */
        public void onNext(CodeVerifyData codeVerifyData) {
            super.onNext(codeVerifyData);
            ((b) SecurityLinkStatusPresenter.this.getUI()).P1();
            d.j("StrategyDisable", "success");
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            ((b) SecurityLinkStatusPresenter.this.getUI()).m3();
            th2.printStackTrace();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            ((b) SecurityLinkStatusPresenter.this.getUI()).m3();
            uq.a.a(SecurityLinkStatusPresenter.this.getActivity(), aPIStatusErrorException, SecurityLinkStatusPresenter.this.c0(), SecurityVerifyParam.RiskOperate.DISABLE);
            d.j("StrategyDisable", aPIStatusErrorException.getErrMsg());
        }
    }

    public interface b extends g {
        void Ee();

        void Jf();

        void K7();

        void P0();

        void P1();

        void m3();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j0(SecurityStrategySet securityStrategySet) {
        this.f41050e = securityStrategySet.getSetting().isVerify_phone();
        this.f41049d = securityStrategySet.getSetting().isVerify_email();
        this.f41048c = securityStrategySet.getSetting().isVerify_ga();
        ((b) getUI()).P0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable k0(CodeVerifyData codeVerifyData) {
        return UserCenterRemoteDataSource.A().B0(codeVerifyData.getToken(), b0()).compose(p.c0());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l0(Object obj) {
        ((b) getUI()).Ee();
        d.j("StrategyEnable", "success");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m0(APIStatusErrorException aPIStatusErrorException) {
        ((b) getUI()).K7();
        d.j("StrategyEnable", aPIStatusErrorException.getErrMsg());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n0(Throwable th2) {
        ((b) getUI()).K7();
        th2.printStackTrace();
    }

    public String X() {
        return this.f41047b;
    }

    public String Y() {
        return this.f41046a;
    }

    public Observable<SecurityStrategySet> Z() {
        return UserCenterRemoteDataSource.A().F().compose(p.c0());
    }

    public Map<String, Object> a0() {
        return MapParamsBuilder.c().a("use_type", "VERIFY_SETTING_POLICY_ENABLE_EMAIL_POLICY").b();
    }

    public String b0() {
        int i11 = this.f41052g;
        if (i11 == 2) {
            return "EMAIL";
        }
        if (i11 == 3) {
            return "GA";
        }
        return i11 == 1 ? "PHONE" : "";
    }

    public final SecurityVerifyParam.Scene c0() {
        int i11 = this.f41052g;
        if (i11 == 2) {
            return SecurityVerifyParam.Scene.RISK_EMAIL;
        }
        if (i11 == 3) {
            return SecurityVerifyParam.Scene.GA;
        }
        if (i11 == 1) {
            return SecurityVerifyParam.Scene.RISK_PHONE;
        }
        return SecurityVerifyParam.Scene.RISK_EMAIL;
    }

    public Map<String, Object> d0() {
        return MapParamsBuilder.c().a("use_type", "VERIFY_SETTING_POLICY_ENABLE_PHONE_POLICY").a("voice", Boolean.FALSE).b();
    }

    public String f0() {
        int i11 = this.f41052g;
        if (i11 == 2) {
            return "VERIFY_SETTING_POLICY_DISABLE_EMAIL_POLICY";
        }
        if (i11 == 3) {
            return "VERIFY_SETTING_POLICY_DISABLE_GA_POLICY";
        }
        return i11 == 1 ? "VERIFY_SETTING_POLICY_DISABLE_PHONE_POLICY" : "";
    }

    public boolean g0() {
        return this.f41049d;
    }

    public boolean h0() {
        return this.f41048c;
    }

    public boolean i0() {
        return this.f41050e;
    }

    public void onDestroy() {
        super.onDestroy();
        EventBus.d().r(this);
    }

    public void p0() {
        this.f41051f.add(Z().compose(RxJavaHelper.t((g) getUI())).subscribe(q6.d.c((g) getUI(), new x(this))));
    }

    public void q0(boolean z11) {
        s0();
        if (z11) {
            p0();
            return;
        }
        int i11 = this.f41052g;
        if (i11 == 2) {
            this.f41049d = true;
        } else if (i11 == 3) {
            this.f41048c = true;
        } else if (i11 == 1) {
            this.f41050e = true;
        }
        ((b) getUI()).P0();
    }

    /* renamed from: r0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, b bVar) {
        super.onUIReady(baseCoreActivity, bVar);
        EventBus.d().p(this);
        bVar.Jf();
    }

    public final void s0() {
        this.f41050e = false;
        this.f41048c = false;
        this.f41049d = false;
    }

    public void t0(String str, String str2) {
        this.f41046a = str;
        this.f41047b = str2;
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void tokenError(mo.a aVar) {
        c.i().f(getActivity());
        getActivity().finish();
    }

    public void u0(int i11) {
        this.f41052g = i11;
    }

    public void v0(String str, String str2, String str3, Security2FADialogHelper.PasskeyAuth passkeyAuth) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("sms_code", str2);
        }
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("email_code", str);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("ga_code", str3);
        }
        if (passkeyAuth != null) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("raw_authenticator_data", passkeyAuth.rawAuthData);
            hashMap2.put(TUIConstants.TUICalling.PARAM_NAME_AUDIO_SIGNATURE, passkeyAuth.signature);
            hashMap2.put("client_data", passkeyAuth.clientData);
            hashMap2.put("credential_id", passkeyAuth.credentialId);
            hashMap2.put("user_handle", passkeyAuth.userHandle);
            hashMap.put("passkey", hashMap2);
        }
        hashMap.put("use_type", f0());
        this.f41051f.add(UserCenterRemoteDataSource.A().getSecurityStrategyVerify(hashMap).compose(p.c0()).flatMap(new a0(this)).compose(RxJavaHelper.t((g) getUI())).subscribe(new a()));
    }

    public void w0(String str, String str2, String str3, Security2FADialogHelper.PasskeyAuth passkeyAuth) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("sms_code", str2);
        }
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("email_code", str);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("ga_code", str3);
        }
        if (passkeyAuth != null) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("raw_authenticator_data", passkeyAuth.rawAuthData);
            hashMap2.put(TUIConstants.TUICalling.PARAM_NAME_AUDIO_SIGNATURE, passkeyAuth.signature);
            hashMap2.put("client_data", passkeyAuth.clientData);
            hashMap2.put("credential_id", passkeyAuth.credentialId);
            hashMap2.put("user_handle", passkeyAuth.userHandle);
            hashMap.put("passkey", hashMap2);
        }
        hashMap.put("strategy_type", "SETTING");
        hashMap.put("item", b0());
        this.f41051f.add(UserCenterRemoteDataSource.A().strategyEnable(hashMap).compose(p.c0()).compose(RxJavaHelper.t((g) getUI())).subscribe(EasySubscriber.create(new z(this), new w(this), new y(this))));
    }
}
