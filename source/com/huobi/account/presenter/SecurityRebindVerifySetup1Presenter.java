package com.huobi.account.presenter;

import com.facebook.places.model.PlaceFields;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.login.usercenter.data.source.bean.CodeVerifyData;
import com.huobi.login.usercenter.data.source.bean.GaGenerateData;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import i6.m;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import pro.huobi.R;
import rx.Observable;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;
import tq.p;
import u6.g;
import ug.a1;
import ug.b1;
import ug.c1;
import ug.d1;
import ug.e1;
import ug.f1;
import ug.v0;
import ug.w0;
import ug.x0;
import ug.y0;
import ug.z0;

public class SecurityRebindVerifySetup1Presenter extends ActivityPresenter<f> {

    /* renamed from: a  reason: collision with root package name */
    public final CompositeSubscription f41069a = new CompositeSubscription();

    /* renamed from: b  reason: collision with root package name */
    public EasySubscriber<Long> f41070b;

    /* renamed from: c  reason: collision with root package name */
    public EasySubscriber<Long> f41071c;

    public class a extends EasySubscriber<Long> {
        public a() {
        }

        public void onNext(Long l11) {
            if (l11.longValue() <= 0) {
                ((f) SecurityRebindVerifySetup1Presenter.this.getUI()).h3(true, SecurityRebindVerifySetup1Presenter.this.getString(R.string.n_security_input_send));
                if (!isUnsubscribed()) {
                    unsubscribe();
                    return;
                }
                return;
            }
            int k02 = m.k0(l11 + "");
            ((f) SecurityRebindVerifySetup1Presenter.this.getUI()).h3(false, String.format(SecurityRebindVerifySetup1Presenter.this.getString(R.string.security_resend_after), new Object[]{Integer.valueOf(k02)}));
        }
    }

    public class b extends EasySubscriber<Object> {
        public b() {
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
        }

        public void onNext(Object obj) {
            super.onNext(obj);
        }
    }

    public class c extends EasySubscriber<Long> {
        public c() {
        }

        public void onNext(Long l11) {
            if (l11.longValue() <= 0) {
                ((f) SecurityRebindVerifySetup1Presenter.this.getUI()).e2(true, SecurityRebindVerifySetup1Presenter.this.getString(R.string.n_security_input_send));
                if (!isUnsubscribed()) {
                    unsubscribe();
                    return;
                }
                return;
            }
            int k02 = m.k0(l11 + "");
            ((f) SecurityRebindVerifySetup1Presenter.this.getUI()).e2(false, String.format(SecurityRebindVerifySetup1Presenter.this.getString(R.string.security_resend_after), new Object[]{Integer.valueOf(k02)}));
        }
    }

    public class d extends EasySubscriber<Object> {
        public d() {
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
        }

        public void onNext(Object obj) {
            super.onNext(obj);
        }
    }

    public class e extends q6.d<GaGenerateData> {
        public e(g gVar) {
            super(gVar);
        }

        /* renamed from: f */
        public void onNext(GaGenerateData gaGenerateData) {
            super.onNext(gaGenerateData);
            ((f) SecurityRebindVerifySetup1Presenter.this.getUI()).w(gaGenerateData);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            ((f) SecurityRebindVerifySetup1Presenter.this.getUI()).w((GaGenerateData) null);
        }
    }

    public interface f extends g {
        void G5(String str);

        void V1();

        void e2(boolean z11, String str);

        void h3(boolean z11, String str);

        void w(GaGenerateData gaGenerateData);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f0(CodeVerifyData codeVerifyData) {
        ((f) getUI()).G5(codeVerifyData.getToken());
    }

    public static /* synthetic */ void g0(APIStatusErrorException aPIStatusErrorException) {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h0(Throwable th2) {
        HuobiToastUtil.m(getString(R.string.n_security_network_fail));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i0(Throwable th2) {
        HuobiToastUtil.m(getString(R.string.n_security_network_fail));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j0(CodeVerifyData codeVerifyData) {
        ((f) getUI()).G5(codeVerifyData.getToken());
    }

    public static /* synthetic */ void k0(APIStatusErrorException aPIStatusErrorException) {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l0(CodeVerifyData codeVerifyData) {
        ((f) getUI()).G5(codeVerifyData.getToken());
    }

    public static /* synthetic */ void m0(APIStatusErrorException aPIStatusErrorException) {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n0(Throwable th2) {
        HuobiToastUtil.m(getString(R.string.n_security_network_fail));
    }

    public void b0(Map<String, Object> map) {
        this.f41069a.add(UserCenterRemoteDataSource.A().w(map).compose(p.c0()).compose(RxJavaHelper.t((g) getUI())).subscribe(new d()));
    }

    public void c0(Map<String, Object> map) {
        this.f41069a.add(UserCenterRemoteDataSource.A().I(map).compose(p.c0()).compose(RxJavaHelper.t((g) getUI())).subscribe(new b()));
    }

    public void d0() {
        UserCenterRemoteDataSource.A().s("ASSET_GA").compose(p.c0()).compose(RxJavaHelper.t((g) getUI())).subscribe(new e((g) getUI()));
    }

    /* renamed from: r0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, f fVar) {
        super.onUIReady(baseCoreActivity, fVar);
    }

    public void s0(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("use_type", "REBIND_EMAIL");
        hashMap.put("email", str);
        hashMap.put("email_code", str2);
        UserCenterRemoteDataSource.A().getVerifyEmailCode(hashMap).compose(p.c0()).compose(RxJavaHelper.t((g) getUI())).subscribe(q6.d.d((g) getUI(), new y0(this), c1.f60582b, new z0(this)));
    }

    public void t0(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("ga_code", str);
        hashMap.put("use_type", "VERIFY_SETTING_POLICY_REBIND_GA");
        UserCenterRemoteDataSource.A().getVerifyGaCode(hashMap).compose(p.c0()).compose(RxJavaHelper.t((g) getUI())).subscribe(q6.d.d((g) getUI(), new x0(this), d1.f60586b, new a1(this)));
    }

    public void u0(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("use_type", "REBIND_PHONE");
        hashMap.put(PlaceFields.PHONE, str);
        hashMap.put("country_code", str3);
        hashMap.put("sms_code", str2);
        UserCenterRemoteDataSource.A().getVerifySmsCode(hashMap).compose(p.c0()).compose(RxJavaHelper.t((g) getUI())).subscribe(q6.d.d((g) getUI(), new v0(this), e1.f60590b, new b1(this)));
    }

    public void v0(Map<String, Object> map) {
        EasySubscriber<Long> easySubscriber = this.f41071c;
        if (easySubscriber == null || easySubscriber.isUnsubscribed()) {
            this.f41071c = new c();
            ((f) getUI()).e2(false, "");
            this.f41069a.add(Observable.interval(0, 1, TimeUnit.SECONDS).map(f1.f60594b).compose(RxJavaHelper.u((g) getUI(), Schedulers.computation())).subscribe(this.f41071c));
            b0(map);
        }
    }

    public void w0(Map<String, Object> map) {
        EasySubscriber<Long> easySubscriber = this.f41070b;
        if (easySubscriber == null || easySubscriber.isUnsubscribed()) {
            this.f41070b = new a();
            ((f) getUI()).h3(false, "");
            this.f41069a.add(Observable.interval(0, 1, TimeUnit.SECONDS).map(w0.f60657b).compose(RxJavaHelper.u((g) getUI(), Schedulers.computation())).subscribe(this.f41070b));
            c0(map);
        }
    }
}
