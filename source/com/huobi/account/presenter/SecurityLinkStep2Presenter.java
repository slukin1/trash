package com.huobi.account.presenter;

import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.facebook.places.model.PlaceFields;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.huobi.account.ui.BrushSecurityVerifyActivity;
import com.huobi.finance.utils.Security2FADialogHelper;
import com.huobi.login.usercenter.data.source.bean.BrushGaVerifyData;
import com.huobi.login.usercenter.data.source.bean.CodeVerifyData;
import com.huobi.login.usercenter.data.source.bean.TsvTokenWrapper;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.huobi.riskcontrol.bean.SecurityVerifyParam;
import com.tencent.qcloud.tuicore.TUIConstants;
import i6.m;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import rx.Observable;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;
import tq.p;
import u6.g;
import ug.b0;
import ug.c0;
import ug.d0;
import ug.e0;
import ug.f0;
import ug.g0;
import ug.h0;
import ug.i0;
import ug.j0;
import ug.k0;
import ug.l0;
import ug.m0;
import ug.n0;
import ug.o0;
import ug.p0;
import ug.q0;
import ug.r0;
import ug.s0;
import ug.t0;
import ug.u0;

public class SecurityLinkStep2Presenter extends ActivityPresenter<e> {

    /* renamed from: a  reason: collision with root package name */
    public int f41054a = -1;

    /* renamed from: b  reason: collision with root package name */
    public String f41055b;

    /* renamed from: c  reason: collision with root package name */
    public String f41056c;

    /* renamed from: d  reason: collision with root package name */
    public final CompositeSubscription f41057d = new CompositeSubscription();

    /* renamed from: e  reason: collision with root package name */
    public String f41058e;

    /* renamed from: f  reason: collision with root package name */
    public String f41059f;

    /* renamed from: g  reason: collision with root package name */
    public String f41060g;

    /* renamed from: h  reason: collision with root package name */
    public String f41061h;

    /* renamed from: i  reason: collision with root package name */
    public String f41062i;

    /* renamed from: j  reason: collision with root package name */
    public String f41063j;

    /* renamed from: k  reason: collision with root package name */
    public String f41064k;

    public class a extends EasySubscriber<Long> {
        public a() {
        }

        public void onNext(Long l11) {
            if (l11.longValue() <= 0) {
                ((e) SecurityLinkStep2Presenter.this.getUI()).H(true, SecurityLinkStep2Presenter.this.getString(R.string.verify_code_resend));
                if (!isUnsubscribed()) {
                    unsubscribe();
                    return;
                }
                return;
            }
            int k02 = m.k0(l11 + "");
            ((e) SecurityLinkStep2Presenter.this.getUI()).H(false, String.format(SecurityLinkStep2Presenter.this.getString(R.string.security_resend_after), new Object[]{Integer.valueOf(k02)}));
        }
    }

    public class b extends EasySubscriber<Long> {
        public b() {
        }

        public void onNext(Long l11) {
            if (l11.longValue() <= 0) {
                ((e) SecurityLinkStep2Presenter.this.getUI()).H(true, SecurityLinkStep2Presenter.this.getString(R.string.verify_code_resend));
                if (!isUnsubscribed()) {
                    unsubscribe();
                    return;
                }
                return;
            }
            int intValue = Integer.valueOf(l11 + "").intValue();
            ((e) SecurityLinkStep2Presenter.this.getUI()).H(false, String.format(SecurityLinkStep2Presenter.this.getString(R.string.security_resend_after), new Object[]{Integer.valueOf(intValue)}));
        }
    }

    public class c extends EasySubscriber<TsvTokenWrapper> {
        public c() {
        }

        /* renamed from: a */
        public void onNext(TsvTokenWrapper tsvTokenWrapper) {
            super.onNext(tsvTokenWrapper);
            ((e) SecurityLinkStep2Presenter.this.getUI()).y9(SecurityLinkStep2Presenter.this.f41054a);
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            th2.printStackTrace();
            ((e) SecurityLinkStep2Presenter.this.getUI()).Qd(SecurityLinkStep2Presenter.this.f41054a);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            i6.d.j("bindEmail", aPIStatusErrorException.getErrMsg());
            ((e) SecurityLinkStep2Presenter.this.getUI()).Qd(SecurityLinkStep2Presenter.this.f41054a);
            uq.a.a(SecurityLinkStep2Presenter.this.getActivity(), aPIStatusErrorException, SecurityVerifyParam.Scene.RISK_EMAIL, SecurityVerifyParam.RiskOperate.BIND);
        }
    }

    public class d extends EasySubscriber<TsvTokenWrapper> {
        public d() {
        }

        /* renamed from: a */
        public void onNext(TsvTokenWrapper tsvTokenWrapper) {
            super.onNext(tsvTokenWrapper);
            ((e) SecurityLinkStep2Presenter.this.getUI()).y9(SecurityLinkStep2Presenter.this.f41054a);
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            ((e) SecurityLinkStep2Presenter.this.getUI()).Qd(SecurityLinkStep2Presenter.this.f41054a);
            th2.printStackTrace();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            i6.d.j("bindPhone", aPIStatusErrorException.getErrMsg());
            ((e) SecurityLinkStep2Presenter.this.getUI()).Qd(SecurityLinkStep2Presenter.this.f41054a);
            uq.a.a(SecurityLinkStep2Presenter.this.getActivity(), aPIStatusErrorException, SecurityVerifyParam.Scene.RISK_PHONE, SecurityVerifyParam.RiskOperate.BIND);
        }
    }

    public interface e extends g {
        void Ba();

        void H(boolean z11, String str);

        void P0();

        void Qd(int i11);

        void y9(int i11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void C0(String str, CodeVerifyData codeVerifyData) {
        this.f41060g = str;
        this.f41061h = codeVerifyData.getToken();
        Q0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void D0(APIStatusErrorException aPIStatusErrorException) {
        ((e) getUI()).Ba();
        i6.d.j("bindGa", aPIStatusErrorException.getErrMsg());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void E0(Throwable th2) {
        ((e) getUI()).Ba();
        th2.printStackTrace();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void F0(CodeVerifyData codeVerifyData) {
        this.f41064k = codeVerifyData.getToken();
        Q0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable I0(CodeVerifyData codeVerifyData) {
        return UserCenterRemoteDataSource.A().k(this.f41058e, this.f41059f, codeVerifyData.getToken()).compose(p.c0());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable J0(CodeVerifyData codeVerifyData) {
        return UserCenterRemoteDataSource.A().l(this.f41060g, this.f41061h, codeVerifyData.getToken()).compose(p.c0());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void K0(Object obj) {
        tg.d.g().i();
        ((e) getUI()).y9(this.f41054a);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void L0(APIStatusErrorException aPIStatusErrorException) {
        i6.d.j("bindGa", aPIStatusErrorException.getErrMsg());
        ((e) getUI()).Qd(this.f41054a);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void M0(Throwable th2) {
        th2.printStackTrace();
        ((e) getUI()).Qd(this.f41054a);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable N0(CodeVerifyData codeVerifyData) {
        return UserCenterRemoteDataSource.A().m(this.f41063j, this.f41062i, this.f41064k, codeVerifyData.getToken()).compose(p.c0());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void w0(APIStatusErrorException aPIStatusErrorException) {
        ((e) getUI()).Ba();
        i6.d.j("bindGa", aPIStatusErrorException.getErrMsg());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void x0(Throwable th2) {
        ((e) getUI()).Ba();
        th2.printStackTrace();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void y0(BrushGaVerifyData brushGaVerifyData) {
        String tempGaVerifyPassToken = brushGaVerifyData.getTempGaVerifyPassToken();
        Intent intent = new Intent(getActivity(), BrushSecurityVerifyActivity.class);
        if (!(getActivity().getIntent() == null || getActivity().getIntent().getExtras() == null)) {
            intent.putExtras(getActivity().getIntent().getExtras());
        }
        intent.putExtra("TEMP_GA_VERIFY_PASS_TOKEN", tempGaVerifyPassToken);
        getActivity().startActivity(intent);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void z0(CodeVerifyData codeVerifyData) {
        this.f41059f = codeVerifyData.getToken();
        Q0();
    }

    public void Q0() {
        ((e) getUI()).P0();
    }

    /* renamed from: R0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, e eVar) {
        super.onUIReady(baseCoreActivity, eVar);
        EventBus.d().p(this);
        S0(baseCoreActivity);
    }

    public void S0(BaseCoreActivity baseCoreActivity) {
        int i11 = this.f41054a;
        if (i11 == 1) {
            this.f41063j = baseCoreActivity.getIntent().getStringExtra("COUNTRY_CODE");
            this.f41062i = baseCoreActivity.getIntent().getStringExtra("LINK_PHONE_KEY");
            X0();
        } else if (i11 == 2) {
            this.f41058e = baseCoreActivity.getIntent().getStringExtra("LINK_EMAIL_ADDRESSS_KEY");
            V0();
        }
    }

    public void T0() {
        int i11 = this.f41054a;
        if (i11 == 1) {
            this.f41063j = getActivity().getIntent().getStringExtra("COUNTRY_CODE");
            String stringExtra = getActivity().getIntent().getStringExtra("LINK_PHONE_KEY");
            this.f41062i = stringExtra;
            W0(this.f41063j, stringExtra);
        } else if (i11 == 2) {
            String stringExtra2 = getActivity().getIntent().getStringExtra("LINK_EMAIL_ADDRESSS_KEY");
            this.f41058e = stringExtra2;
            U0(stringExtra2);
        }
    }

    public void U0(String str) {
        V0();
        this.f41057d.add(UserCenterRemoteDataSource.A().w(MapParamsBuilder.c().a("use_type", "BIND_EMAIL").a("email", str).b()).compose(p.c0()).compose(RxJavaHelper.t((g) getUI())).subscribe(EasySubscriber.create((Action1) null)));
    }

    public final void V0() {
        b bVar = new b();
        ((e) getUI()).H(false, "");
        this.f41057d.add(Observable.interval(0, 1, TimeUnit.SECONDS).map(k0.f60612b).compose(RxJavaHelper.u((g) getUI(), Schedulers.computation())).subscribe(bVar));
    }

    public void W0(String str, String str2) {
        X0();
        this.f41057d.add(UserCenterRemoteDataSource.A().I(MapParamsBuilder.c().a("use_type", "BIND_PHONE").a("country_code", str).a(PlaceFields.PHONE, str2).a("voice", Boolean.FALSE).b()).compose(p.c0()).compose(RxJavaHelper.t((g) getUI())).subscribe(EasySubscriber.create((Action1) null)));
    }

    public final void X0() {
        a aVar = new a();
        ((e) getUI()).H(false, "");
        this.f41057d.add(Observable.interval(0, 1, TimeUnit.SECONDS).map(l0.f60615b).compose(RxJavaHelper.u((g) getUI(), Schedulers.computation())).subscribe(aVar));
    }

    public void Y0(String str, String str2) {
        this.f41055b = str;
        this.f41056c = str2;
    }

    public void Z0(int i11) {
        this.f41054a = i11;
    }

    public void onDestroy() {
        super.onDestroy();
        EventBus.d().r(this);
        this.f41057d.clear();
    }

    public void p0(String str) {
        String stringExtra = getActivity().getIntent().getStringExtra("AUTH_TOKEN");
        HashMap hashMap = new HashMap();
        hashMap.put("ga_code", str);
        hashMap.put("auth_token", stringExtra);
        this.f41057d.add(UserCenterRemoteDataSource.A().U(hashMap).compose(p.c0()).compose(RxJavaHelper.t((g) getUI())).subscribe(q6.d.d((g) getUI(), new o0(this), new m0(this), new s0(this))));
    }

    public void q0(String str) {
        this.f41057d.add(UserCenterRemoteDataSource.A().x0(this.f41058e, str).compose(p.c0()).compose(RxJavaHelper.t((g) getUI())).subscribe(q6.d.d((g) getUI(), new q0(this), d0.f60585b, g0.f60598b)));
    }

    public void r0(String str) {
        this.f41057d.add(UserCenterRemoteDataSource.A().V(str).compose(p.c0()).compose(RxJavaHelper.t((g) getUI())).subscribe(q6.d.d((g) getUI(), new c0(this, str), new b0(this), new r0(this))));
    }

    public void s0(String str) {
        this.f41057d.add(UserCenterRemoteDataSource.A().y0(this.f41063j, this.f41062i, str).compose(p.c0()).compose(RxJavaHelper.t((g) getUI())).subscribe(EasySubscriber.create(new p0(this), e0.f60589b, f0.f60593b)));
    }

    public void t0(String str, String str2, Security2FADialogHelper.PasskeyAuth passkeyAuth) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("sms_code", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("ga_code", str2);
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
        hashMap.put("use_type", "VERIFY_SETTING_POLICY_BIND_EMAIL");
        this.f41057d.add(UserCenterRemoteDataSource.A().getSecurityStrategyVerify(hashMap).compose(p.c0()).flatMap(new j0(this)).compose(RxJavaHelper.t((g) getUI())).subscribe(new c()));
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void tokenError(mo.a aVar) {
        getActivity().startActivity(com.huobi.utils.k0.h(getActivity()));
        getActivity().finish();
    }

    public void u0(String str, String str2, Security2FADialogHelper.PasskeyAuth passkeyAuth) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("sms_code", str2);
        }
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("email_code", str);
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
        hashMap.put("use_type", "VERIFY_SETTING_POLICY_BIND_GA");
        this.f41057d.add(UserCenterRemoteDataSource.A().getSecurityStrategyVerify(hashMap).compose(p.c0()).flatMap(new h0(this)).compose(RxJavaHelper.t((g) getUI())).subscribe(EasySubscriber.create(new u0(this), new n0(this), new t0(this))));
    }

    public void v0(String str, String str2, Security2FADialogHelper.PasskeyAuth passkeyAuth) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("email_code", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("ga_code", str2);
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
        hashMap.put("use_type", "VERIFY_SETTING_POLICY_BIND_PHONE");
        this.f41057d.add(UserCenterRemoteDataSource.A().getSecurityStrategyVerify(hashMap).compose(p.c0()).flatMap(new i0(this)).compose(RxJavaHelper.t((g) getUI())).subscribe(new d()));
    }
}
