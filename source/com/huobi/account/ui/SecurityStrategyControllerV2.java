package com.huobi.account.ui;

import android.app.Activity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
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

public abstract class SecurityStrategyControllerV2 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f41521a = false;

    /* renamed from: b  reason: collision with root package name */
    public final CompositeSubscription f41522b = new CompositeSubscription();

    /* renamed from: c  reason: collision with root package name */
    public EasySubscriber<Long> f41523c;

    /* renamed from: d  reason: collision with root package name */
    public EasySubscriber<Long> f41524d;

    /* renamed from: e  reason: collision with root package name */
    public EasySubscriber<Long> f41525e;

    /* renamed from: f  reason: collision with root package name */
    public EasySubscriber<Long> f41526f;

    public class a extends EasySubscriber<Long> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SecurityStrategyBottomMenuFragmentV2 f41527b;

        public a(SecurityStrategyBottomMenuFragmentV2 securityStrategyBottomMenuFragmentV2) {
            this.f41527b = securityStrategyBottomMenuFragmentV2;
        }

        public void onNext(Long l11) {
            if (l11.longValue() <= 0) {
                SecurityStrategyBottomMenuFragmentV2 securityStrategyBottomMenuFragmentV2 = this.f41527b;
                securityStrategyBottomMenuFragmentV2.h3(true, securityStrategyBottomMenuFragmentV2.getString(R.string.security_send));
                if (!isUnsubscribed()) {
                    unsubscribe();
                    return;
                }
                return;
            }
            int k02 = m.k0(l11 + "");
            SecurityStrategyBottomMenuFragmentV2 securityStrategyBottomMenuFragmentV22 = this.f41527b;
            securityStrategyBottomMenuFragmentV22.h3(false, String.format(securityStrategyBottomMenuFragmentV22.getString(R.string.security_resend_after), new Object[]{Integer.valueOf(k02)}));
        }
    }

    public class b extends EasySubscriber<Object> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SecurityStrategyBottomMenuFragmentV2 f41529b;

        public b(SecurityStrategyBottomMenuFragmentV2 securityStrategyBottomMenuFragmentV2) {
            this.f41529b = securityStrategyBottomMenuFragmentV2;
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            SecurityStrategyBottomMenuFragmentV2 securityStrategyBottomMenuFragmentV2 = this.f41529b;
            if (securityStrategyBottomMenuFragmentV2 != null) {
                securityStrategyBottomMenuFragmentV2.dismiss();
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            SecurityStrategyBottomMenuFragmentV2 securityStrategyBottomMenuFragmentV2 = this.f41529b;
            if (securityStrategyBottomMenuFragmentV2 != null) {
                securityStrategyBottomMenuFragmentV2.dismiss();
            }
        }

        public void onNext(Object obj) {
            super.onNext(obj);
        }
    }

    public class c extends EasySubscriber<Long> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SecurityStrategyBottomMenuFragmentV2 f41531b;

        public c(SecurityStrategyBottomMenuFragmentV2 securityStrategyBottomMenuFragmentV2) {
            this.f41531b = securityStrategyBottomMenuFragmentV2;
        }

        public void onNext(Long l11) {
            if (l11.longValue() <= 0) {
                SecurityStrategyBottomMenuFragmentV2 securityStrategyBottomMenuFragmentV2 = this.f41531b;
                securityStrategyBottomMenuFragmentV2.e2(true, securityStrategyBottomMenuFragmentV2.getString(R.string.security_send));
                if (!isUnsubscribed()) {
                    unsubscribe();
                    return;
                }
                return;
            }
            int k02 = m.k0(l11 + "");
            SecurityStrategyBottomMenuFragmentV2 securityStrategyBottomMenuFragmentV22 = this.f41531b;
            securityStrategyBottomMenuFragmentV22.e2(false, String.format(securityStrategyBottomMenuFragmentV22.getString(R.string.security_resend_after), new Object[]{Integer.valueOf(k02)}));
        }
    }

    public class d extends EasySubscriber<Object> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SecurityStrategyBottomMenuFragmentV2 f41533b;

        public d(SecurityStrategyBottomMenuFragmentV2 securityStrategyBottomMenuFragmentV2) {
            this.f41533b = securityStrategyBottomMenuFragmentV2;
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            SecurityStrategyBottomMenuFragmentV2 securityStrategyBottomMenuFragmentV2 = this.f41533b;
            if (securityStrategyBottomMenuFragmentV2 != null) {
                securityStrategyBottomMenuFragmentV2.dismiss();
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            SecurityStrategyBottomMenuFragmentV2 securityStrategyBottomMenuFragmentV2 = this.f41533b;
            if (securityStrategyBottomMenuFragmentV2 != null) {
                securityStrategyBottomMenuFragmentV2.dismiss();
            }
        }

        public void onNext(Object obj) {
            super.onNext(obj);
        }
    }

    public class e extends EasySubscriber<Long> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SecurityStrategyBottomMenuFragmentV2 f41535b;

        public e(SecurityStrategyBottomMenuFragmentV2 securityStrategyBottomMenuFragmentV2) {
            this.f41535b = securityStrategyBottomMenuFragmentV2;
        }

        public void onNext(Long l11) {
            if (l11.longValue() <= 0) {
                SecurityStrategyBottomMenuFragmentV2 securityStrategyBottomMenuFragmentV2 = this.f41535b;
                securityStrategyBottomMenuFragmentV2.h3(true, securityStrategyBottomMenuFragmentV2.getString(R.string.security_send));
                if (!isUnsubscribed()) {
                    unsubscribe();
                    return;
                }
                return;
            }
            int k02 = m.k0(l11 + "");
            SecurityStrategyBottomMenuFragmentV2 securityStrategyBottomMenuFragmentV22 = this.f41535b;
            securityStrategyBottomMenuFragmentV22.h3(false, String.format(securityStrategyBottomMenuFragmentV22.getString(R.string.security_resend_after), new Object[]{Integer.valueOf(k02)}));
        }
    }

    public class f extends EasySubscriber<Long> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SecurityStrategyBottomMenuFragmentV2 f41537b;

        public f(SecurityStrategyBottomMenuFragmentV2 securityStrategyBottomMenuFragmentV2) {
            this.f41537b = securityStrategyBottomMenuFragmentV2;
        }

        public void onNext(Long l11) {
            if (l11.longValue() <= 0) {
                SecurityStrategyBottomMenuFragmentV2 securityStrategyBottomMenuFragmentV2 = this.f41537b;
                securityStrategyBottomMenuFragmentV2.e2(true, securityStrategyBottomMenuFragmentV2.getString(R.string.security_send));
                if (!isUnsubscribed()) {
                    unsubscribe();
                    return;
                }
                return;
            }
            int k02 = m.k0(l11 + "");
            SecurityStrategyBottomMenuFragmentV2 securityStrategyBottomMenuFragmentV22 = this.f41537b;
            securityStrategyBottomMenuFragmentV22.e2(false, String.format(securityStrategyBottomMenuFragmentV22.getString(R.string.security_resend_after), new Object[]{Integer.valueOf(k02)}));
        }
    }

    public class g extends EasySubscriber<String> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SecurityStrategyBottomMenuFragmentV2 f41539b;

        public g(SecurityStrategyBottomMenuFragmentV2 securityStrategyBottomMenuFragmentV2) {
            this.f41539b = securityStrategyBottomMenuFragmentV2;
        }

        /* renamed from: a */
        public void onNext(String str) {
            super.onNext(str);
        }

        public void onAfter() {
            super.onAfter();
            SecurityStrategyBottomMenuFragmentV2 securityStrategyBottomMenuFragmentV2 = this.f41539b;
            if (securityStrategyBottomMenuFragmentV2 != null) {
                securityStrategyBottomMenuFragmentV2.ji();
            }
        }
    }

    public void D() {
    }

    public void E() {
    }

    public void F() {
    }

    public void G(SecurityStrategyBottomMenuFragmentV2 securityStrategyBottomMenuFragmentV2, u6.g gVar) {
        EasySubscriber<Long> easySubscriber = this.f41524d;
        if (easySubscriber == null || easySubscriber.isUnsubscribed()) {
            this.f41524d = new c(securityStrategyBottomMenuFragmentV2);
            securityStrategyBottomMenuFragmentV2.e2(false, "");
            this.f41522b.add(Observable.interval(0, 1, TimeUnit.SECONDS).map(h5.f41701b).compose(RxJavaHelper.u(gVar, Schedulers.computation())).subscribe(this.f41524d));
            g(securityStrategyBottomMenuFragmentV2, gVar);
        }
    }

    public void H(SecurityStrategyBottomMenuFragmentV2 securityStrategyBottomMenuFragmentV2, u6.g gVar, boolean z11) {
        EasySubscriber<Long> easySubscriber = this.f41523c;
        if (easySubscriber == null || easySubscriber.isUnsubscribed()) {
            this.f41523c = new a(securityStrategyBottomMenuFragmentV2);
            securityStrategyBottomMenuFragmentV2.h3(false, "");
            this.f41522b.add(Observable.interval(0, 1, TimeUnit.SECONDS).map(i5.f41713b).compose(RxJavaHelper.u(gVar, Schedulers.computation())).subscribe(this.f41523c));
            h(securityStrategyBottomMenuFragmentV2, gVar, z11);
        }
    }

    public void I(SecurityStrategyBottomMenuFragmentV2 securityStrategyBottomMenuFragmentV2, u6.g gVar) {
        EasySubscriber<Long> easySubscriber = this.f41525e;
        if (easySubscriber == null || easySubscriber.isUnsubscribed()) {
            this.f41525e = new e(securityStrategyBottomMenuFragmentV2);
            securityStrategyBottomMenuFragmentV2.h3(false, "");
            this.f41522b.add(Observable.interval(0, 1, TimeUnit.SECONDS).map(f5.f41683b).compose(RxJavaHelper.u(gVar, Schedulers.computation())).subscribe(this.f41525e));
        }
    }

    public void e() {
        this.f41522b.clear();
    }

    public abstract void f(String str, String str2, String str3, String str4);

    public void g(SecurityStrategyBottomMenuFragmentV2 securityStrategyBottomMenuFragmentV2, u6.g gVar) {
        this.f41522b.add(UserCenterRemoteDataSource.A().w(m()).compose(p.c0()).compose(RxJavaHelper.t(gVar)).subscribe(new d(securityStrategyBottomMenuFragmentV2)));
    }

    public void h(SecurityStrategyBottomMenuFragmentV2 securityStrategyBottomMenuFragmentV2, u6.g gVar, boolean z11) {
        Map<String, Object> o11 = o();
        if (o11.containsKey("voice")) {
            o11.put("voice", Boolean.valueOf(z11));
        }
        this.f41522b.add(UserCenterRemoteDataSource.A().I(o11).compose(p.c0()).compose(RxJavaHelper.t(gVar)).subscribe(new b(securityStrategyBottomMenuFragmentV2)));
    }

    public void i(SecurityStrategyBottomMenuFragmentV2 securityStrategyBottomMenuFragmentV2, u6.g gVar) {
        EasySubscriber<Long> easySubscriber = this.f41526f;
        if (easySubscriber == null || easySubscriber.isUnsubscribed()) {
            this.f41526f = new f(securityStrategyBottomMenuFragmentV2);
            securityStrategyBottomMenuFragmentV2.e2(false, "");
            this.f41522b.add(Observable.interval(0, 1, TimeUnit.SECONDS).map(g5.f41691b).compose(RxJavaHelper.u(gVar, Schedulers.computation())).subscribe(this.f41526f));
        }
    }

    public Activity j() {
        return null;
    }

    public abstract String k();

    public abstract String l();

    public abstract Map<String, Object> m();

    public void n(String str, SecurityStrategyBottomMenuFragmentV2 securityStrategyBottomMenuFragmentV2, u6.g gVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("use_type", "LOGIN");
        hashMap.put("email", str);
        UserCenterRemoteDataSource.A().getEmailSendResult(hashMap).compose(RxJavaHelper.t(gVar)).compose(p.c0()).subscribe(new g(securityStrategyBottomMenuFragmentV2));
    }

    public abstract Map<String, Object> o();

    public boolean p() {
        return false;
    }

    public boolean q() {
        return false;
    }

    public abstract boolean r();

    public abstract boolean s();

    public abstract boolean t();

    public boolean u() {
        return true;
    }

    public boolean v() {
        return false;
    }

    public abstract boolean w();

    public boolean x() {
        return false;
    }

    public boolean y() {
        return false;
    }
}
