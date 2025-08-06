package com.huobi.account.presenter;

import android.text.TextUtils;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.PhoneUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huobi.login.usercenter.data.source.bean.SecuritySetData;
import com.huobi.login.usercenter.data.source.bean.SecurityStrategySet;
import com.huobi.login.usercenter.data.source.bean.UserSecurityInfoData;
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
import ug.g1;
import ug.h1;
import ug.i1;
import ug.j1;
import ug.k1;
import ug.l1;
import ug.m1;
import ug.n1;
import ug.o1;
import ug.p1;
import ug.q1;
import ug.r1;

public class SecurityRebindVerifySetup2Presenter extends ActivityPresenter<f> {

    /* renamed from: a  reason: collision with root package name */
    public final CompositeSubscription f41077a = new CompositeSubscription();

    /* renamed from: b  reason: collision with root package name */
    public int f41078b;

    /* renamed from: c  reason: collision with root package name */
    public String f41079c;

    /* renamed from: d  reason: collision with root package name */
    public String f41080d;

    /* renamed from: e  reason: collision with root package name */
    public String f41081e;

    /* renamed from: f  reason: collision with root package name */
    public String f41082f;

    /* renamed from: g  reason: collision with root package name */
    public String f41083g;

    /* renamed from: h  reason: collision with root package name */
    public String f41084h;

    /* renamed from: i  reason: collision with root package name */
    public String f41085i;

    /* renamed from: j  reason: collision with root package name */
    public EasySubscriber<Long> f41086j;

    /* renamed from: k  reason: collision with root package name */
    public EasySubscriber<Long> f41087k;

    public class a extends EasySubscriber<Long> {
        public a() {
        }

        public void onNext(Long l11) {
            if (l11.longValue() <= 0) {
                ((f) SecurityRebindVerifySetup2Presenter.this.getUI()).h3(true, SecurityRebindVerifySetup2Presenter.this.getString(R.string.n_security_input_send));
                if (!isUnsubscribed()) {
                    unsubscribe();
                    return;
                }
                return;
            }
            int k02 = m.k0(l11 + "");
            ((f) SecurityRebindVerifySetup2Presenter.this.getUI()).h3(false, String.format(SecurityRebindVerifySetup2Presenter.this.getString(R.string.security_resend_after), new Object[]{Integer.valueOf(k02)}));
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
                ((f) SecurityRebindVerifySetup2Presenter.this.getUI()).e2(true, SecurityRebindVerifySetup2Presenter.this.getString(R.string.n_security_input_send));
                if (!isUnsubscribed()) {
                    unsubscribe();
                    return;
                }
                return;
            }
            int k02 = m.k0(l11 + "");
            ((f) SecurityRebindVerifySetup2Presenter.this.getUI()).e2(false, String.format(SecurityRebindVerifySetup2Presenter.this.getString(R.string.security_resend_after), new Object[]{Integer.valueOf(k02)}));
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

    public class e extends EasySubscriber<SecuritySetData> {
        public e() {
        }

        /* renamed from: a */
        public void onNext(SecuritySetData securitySetData) {
            super.onNext(securitySetData);
            ((f) SecurityRebindVerifySetup2Presenter.this.getUI()).Y(securitySetData);
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            ((f) SecurityRebindVerifySetup2Presenter.this.getUI()).Y((SecuritySetData) null);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            ((f) SecurityRebindVerifySetup2Presenter.this.getUI()).Y((SecuritySetData) null);
        }
    }

    public interface f extends g {
        void V1();

        void Y(SecuritySetData securitySetData);

        void e2(boolean z11, String str);

        void h3(boolean z11, String str);
    }

    public static /* synthetic */ SecuritySetData j0(SecurityStrategySet securityStrategySet, UserSecurityInfoData userSecurityInfoData) {
        SecuritySetData securitySetData = new SecuritySetData();
        securitySetData.e(securityStrategySet);
        securitySetData.f(userSecurityInfoData);
        return securitySetData;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l0(Throwable th2) {
        HuobiToastUtil.m(getString(R.string.n_security_network_fail));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m0(Object obj) {
        ((f) getUI()).V1();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p0(Throwable th2) {
        HuobiToastUtil.m(getString(R.string.n_security_network_fail));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void q0(Object obj) {
        ((f) getUI()).V1();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void s0(Throwable th2) {
        HuobiToastUtil.m(getString(R.string.n_security_network_fail));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t0(Object obj) {
        ((f) getUI()).V1();
    }

    public void c0(Map<String, Object> map) {
        this.f41077a.add(UserCenterRemoteDataSource.A().w(map).compose(p.c0()).compose(RxJavaHelper.t((g) getUI())).subscribe(new d()));
    }

    public void d0(Map<String, Object> map) {
        this.f41077a.add(UserCenterRemoteDataSource.A().I(map).compose(p.c0()).compose(RxJavaHelper.t((g) getUI())).subscribe(new b()));
    }

    public int f0() {
        return this.f41078b;
    }

    public Observable<SecurityStrategySet> g0() {
        return UserCenterRemoteDataSource.A().F().compose(p.c0());
    }

    public Observable<UserSecurityInfoData> h0() {
        return UserCenterRemoteDataSource.A().T().compose(p.c0()).compose(RxJavaHelper.t((g) getUI()));
    }

    public void i0() {
        Observable.zip(g0(), h0(), i1.f60607b).compose(RxJavaHelper.t((g) getUI())).subscribe(new e());
    }

    /* renamed from: w0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, f fVar) {
        super.onUIReady(baseCoreActivity, fVar);
        if (baseCoreActivity.getIntent() != null) {
            this.f41078b = baseCoreActivity.getIntent().getIntExtra("LINK_TYPE_KEY", 1);
            this.f41079c = baseCoreActivity.getIntent().getStringExtra("NEW_EMAIL");
            this.f41080d = baseCoreActivity.getIntent().getStringExtra("NEW_EMAIL_TOKEN");
            this.f41081e = baseCoreActivity.getIntent().getStringExtra("NEW_COUNTRY_CODE");
            this.f41082f = baseCoreActivity.getIntent().getStringExtra("NEW_PHONE");
            this.f41083g = baseCoreActivity.getIntent().getStringExtra("NEW_PHONE_TOKEN");
            this.f41084h = baseCoreActivity.getIntent().getStringExtra("NEW_GA_CODE");
            this.f41085i = baseCoreActivity.getIntent().getStringExtra("NEW_GA_TOKEN");
        }
        i0();
    }

    public void x0(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_FINGERPRINT, PhoneUtils.s(true));
        int i11 = this.f41078b;
        if (i11 == 1) {
            hashMap.put("new_country_code", this.f41081e);
            hashMap.put("new_phone", this.f41082f);
            hashMap.put("new_phone_token", this.f41083g);
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put("old_sms_code", str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                hashMap.put("ga_code", str3);
            }
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("email_code", str);
            }
            UserCenterRemoteDataSource.A().rebindPhone(hashMap).compose(p.c0()).compose(RxJavaHelper.t((g) getUI())).subscribe(q6.d.d((g) getUI(), new m1(this), p1.f60635b, new g1(this)));
        } else if (i11 == 2) {
            hashMap.put("new_email", this.f41079c);
            hashMap.put("new_email_token", this.f41080d);
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put("sms_code", str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                hashMap.put("ga_code", str3);
            }
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("email_code", str);
            }
            UserCenterRemoteDataSource.A().rebindEmail(hashMap).compose(p.c0()).compose(RxJavaHelper.t((g) getUI())).subscribe(q6.d.d((g) getUI(), new l1(this), o1.f60632b, new k1(this)));
        } else {
            hashMap.put("new_ga_code", this.f41084h);
            hashMap.put("ga_token", this.f41085i);
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put("sms_code", str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                hashMap.put("old_ga_code", str3);
            }
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("email_code", str);
            }
            UserCenterRemoteDataSource.A().rebindGa(hashMap).compose(p.c0()).compose(RxJavaHelper.t((g) getUI())).subscribe(q6.d.d((g) getUI(), new n1(this), q1.f60638b, new j1(this)));
        }
    }

    public void y0(Map<String, Object> map) {
        EasySubscriber<Long> easySubscriber = this.f41087k;
        if (easySubscriber == null || easySubscriber.isUnsubscribed()) {
            this.f41087k = new c();
            ((f) getUI()).e2(false, "");
            this.f41077a.add(Observable.interval(0, 1, TimeUnit.SECONDS).map(r1.f60641b).compose(RxJavaHelper.u((g) getUI(), Schedulers.computation())).subscribe(this.f41087k));
            c0(map);
        }
    }

    public void z0(Map<String, Object> map) {
        EasySubscriber<Long> easySubscriber = this.f41086j;
        if (easySubscriber == null || easySubscriber.isUnsubscribed()) {
            this.f41086j = new a();
            ((f) getUI()).h3(false, "");
            this.f41077a.add(Observable.interval(0, 1, TimeUnit.SECONDS).map(h1.f60603b).compose(RxJavaHelper.u((g) getUI(), Schedulers.computation())).subscribe(this.f41086j));
            d0(map);
        }
    }
}
