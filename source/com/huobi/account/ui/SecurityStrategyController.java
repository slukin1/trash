package com.huobi.account.ui;

import android.app.Activity;
import com.hbg.lib.common.utils.crypt.MD5Utils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.huobi.account.ui.SecurityStrategyBottomMenuFragment;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import i6.m;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import pro.huobi.R;
import rx.Observable;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;
import tq.p;

public abstract class SecurityStrategyController {

    /* renamed from: a  reason: collision with root package name */
    public boolean f41501a = false;

    /* renamed from: b  reason: collision with root package name */
    public final CompositeSubscription f41502b = new CompositeSubscription();

    /* renamed from: c  reason: collision with root package name */
    public EasySubscriber<Long> f41503c;

    /* renamed from: d  reason: collision with root package name */
    public EasySubscriber<Long> f41504d;

    /* renamed from: e  reason: collision with root package name */
    public EasySubscriber<Long> f41505e;

    /* renamed from: f  reason: collision with root package name */
    public EasySubscriber<Long> f41506f;

    public class a extends EasySubscriber<Long> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SecurityStrategyBottomMenuFragment f41507b;

        public a(SecurityStrategyBottomMenuFragment securityStrategyBottomMenuFragment) {
            this.f41507b = securityStrategyBottomMenuFragment;
        }

        public void onNext(Long l11) {
            if (l11.longValue() <= 0) {
                SecurityStrategyBottomMenuFragment securityStrategyBottomMenuFragment = this.f41507b;
                securityStrategyBottomMenuFragment.h3(true, securityStrategyBottomMenuFragment.getString(R.string.security_send));
                if (!isUnsubscribed()) {
                    unsubscribe();
                    return;
                }
                return;
            }
            int k02 = m.k0(l11 + "");
            SecurityStrategyBottomMenuFragment securityStrategyBottomMenuFragment2 = this.f41507b;
            securityStrategyBottomMenuFragment2.h3(false, String.format(securityStrategyBottomMenuFragment2.getString(R.string.security_resend_after), new Object[]{Integer.valueOf(k02)}));
        }
    }

    public class b extends EasySubscriber<Object> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SecurityStrategyBottomMenuFragment f41509b;

        public b(SecurityStrategyBottomMenuFragment securityStrategyBottomMenuFragment) {
            this.f41509b = securityStrategyBottomMenuFragment;
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            SecurityStrategyBottomMenuFragment securityStrategyBottomMenuFragment = this.f41509b;
            if (securityStrategyBottomMenuFragment != null) {
                securityStrategyBottomMenuFragment.dismiss();
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            SecurityStrategyBottomMenuFragment securityStrategyBottomMenuFragment = this.f41509b;
            if (securityStrategyBottomMenuFragment != null) {
                securityStrategyBottomMenuFragment.dismiss();
            }
        }

        public void onNext(Object obj) {
            super.onNext(obj);
        }
    }

    public class c extends EasySubscriber<Long> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SecurityStrategyBottomMenuFragment f41511b;

        public c(SecurityStrategyBottomMenuFragment securityStrategyBottomMenuFragment) {
            this.f41511b = securityStrategyBottomMenuFragment;
        }

        public void onNext(Long l11) {
            if (l11.longValue() <= 0) {
                SecurityStrategyBottomMenuFragment securityStrategyBottomMenuFragment = this.f41511b;
                securityStrategyBottomMenuFragment.e2(true, securityStrategyBottomMenuFragment.getString(R.string.security_send));
                if (!isUnsubscribed()) {
                    unsubscribe();
                    return;
                }
                return;
            }
            int k02 = m.k0(l11 + "");
            SecurityStrategyBottomMenuFragment securityStrategyBottomMenuFragment2 = this.f41511b;
            securityStrategyBottomMenuFragment2.e2(false, String.format(securityStrategyBottomMenuFragment2.getString(R.string.security_resend_after), new Object[]{Integer.valueOf(k02)}));
        }
    }

    public class d extends EasySubscriber<Object> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SecurityStrategyBottomMenuFragment f41513b;

        public d(SecurityStrategyBottomMenuFragment securityStrategyBottomMenuFragment) {
            this.f41513b = securityStrategyBottomMenuFragment;
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            SecurityStrategyBottomMenuFragment securityStrategyBottomMenuFragment = this.f41513b;
            if (securityStrategyBottomMenuFragment != null) {
                securityStrategyBottomMenuFragment.dismiss();
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            SecurityStrategyBottomMenuFragment securityStrategyBottomMenuFragment = this.f41513b;
            if (securityStrategyBottomMenuFragment != null) {
                securityStrategyBottomMenuFragment.dismiss();
            }
        }

        public void onNext(Object obj) {
            super.onNext(obj);
        }
    }

    public class e extends EasySubscriber<Long> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SecurityStrategyBottomMenuFragment f41515b;

        public e(SecurityStrategyBottomMenuFragment securityStrategyBottomMenuFragment) {
            this.f41515b = securityStrategyBottomMenuFragment;
        }

        public void onNext(Long l11) {
            if (l11.longValue() <= 0) {
                SecurityStrategyBottomMenuFragment securityStrategyBottomMenuFragment = this.f41515b;
                securityStrategyBottomMenuFragment.h3(true, securityStrategyBottomMenuFragment.getString(R.string.security_send));
                if (!isUnsubscribed()) {
                    unsubscribe();
                    return;
                }
                return;
            }
            int k02 = m.k0(l11 + "");
            SecurityStrategyBottomMenuFragment securityStrategyBottomMenuFragment2 = this.f41515b;
            securityStrategyBottomMenuFragment2.h3(false, String.format(securityStrategyBottomMenuFragment2.getString(R.string.security_resend_after), new Object[]{Integer.valueOf(k02)}));
        }
    }

    public class f extends EasySubscriber<Long> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SecurityStrategyBottomMenuFragment f41517b;

        public f(SecurityStrategyBottomMenuFragment securityStrategyBottomMenuFragment) {
            this.f41517b = securityStrategyBottomMenuFragment;
        }

        public void onNext(Long l11) {
            if (l11.longValue() <= 0) {
                SecurityStrategyBottomMenuFragment securityStrategyBottomMenuFragment = this.f41517b;
                securityStrategyBottomMenuFragment.e2(true, securityStrategyBottomMenuFragment.getString(R.string.security_send));
                if (!isUnsubscribed()) {
                    unsubscribe();
                    return;
                }
                return;
            }
            int k02 = m.k0(l11 + "");
            SecurityStrategyBottomMenuFragment securityStrategyBottomMenuFragment2 = this.f41517b;
            securityStrategyBottomMenuFragment2.e2(false, String.format(securityStrategyBottomMenuFragment2.getString(R.string.security_resend_after), new Object[]{Integer.valueOf(k02)}));
        }
    }

    public class g extends EasySubscriber<String> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SecurityStrategyBottomMenuFragment f41519b;

        public g(SecurityStrategyBottomMenuFragment securityStrategyBottomMenuFragment) {
            this.f41519b = securityStrategyBottomMenuFragment;
        }

        /* renamed from: a */
        public void onNext(String str) {
            super.onNext(str);
        }

        public void onAfter() {
            super.onAfter();
            SecurityStrategyBottomMenuFragment securityStrategyBottomMenuFragment = this.f41519b;
            if (securityStrategyBottomMenuFragment != null) {
                securityStrategyBottomMenuFragment.wi();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void L(Object obj) {
        X();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void N(Throwable th2) {
        M((APIStatusErrorException) null);
    }

    public boolean A() {
        return true;
    }

    public boolean B() {
        return false;
    }

    public abstract boolean C();

    public boolean D() {
        return false;
    }

    public boolean E() {
        return false;
    }

    public boolean F() {
        return this.f41501a;
    }

    public boolean G() {
        return false;
    }

    public void O() {
    }

    public void P() {
    }

    public void Q() {
    }

    public void R(SecurityStrategyBottomMenuFragment securityStrategyBottomMenuFragment, u6.g gVar) {
        EasySubscriber<Long> easySubscriber = this.f41504d;
        if (easySubscriber == null || easySubscriber.isUnsubscribed()) {
            this.f41504d = new c(securityStrategyBottomMenuFragment);
            securityStrategyBottomMenuFragment.e2(false, "");
            this.f41502b.add(Observable.interval(0, 1, TimeUnit.SECONDS).map(c5.f41659b).compose(RxJavaHelper.u(gVar, Schedulers.computation())).subscribe(this.f41504d));
            j(securityStrategyBottomMenuFragment, gVar);
        }
    }

    public void S(SecurityStrategyBottomMenuFragment securityStrategyBottomMenuFragment, u6.g gVar, boolean z11) {
        EasySubscriber<Long> easySubscriber = this.f41503c;
        if (easySubscriber == null || easySubscriber.isUnsubscribed()) {
            this.f41503c = new a(securityStrategyBottomMenuFragment);
            securityStrategyBottomMenuFragment.h3(false, "");
            this.f41502b.add(Observable.interval(0, 1, TimeUnit.SECONDS).map(d5.f41667b).compose(RxJavaHelper.u(gVar, Schedulers.computation())).subscribe(this.f41503c));
            k(securityStrategyBottomMenuFragment, gVar, z11);
        }
    }

    public void T() {
    }

    public void U(SecurityStrategyBottomMenuFragment securityStrategyBottomMenuFragment, u6.g gVar) {
        EasySubscriber<Long> easySubscriber = this.f41505e;
        if (easySubscriber == null || easySubscriber.isUnsubscribed()) {
            this.f41505e = new e(securityStrategyBottomMenuFragment);
            securityStrategyBottomMenuFragment.h3(false, "");
            this.f41502b.add(Observable.interval(0, 1, TimeUnit.SECONDS).map(b5.f41650b).compose(RxJavaHelper.u(gVar, Schedulers.computation())).subscribe(this.f41505e));
        }
    }

    public void V(u6.g gVar, String str) {
        this.f41502b.add(UserCenterRemoteDataSource.A().loginPasswordVerify(MapParamsBuilder.c().a("login_password", MD5Utils.c(str)).b()).compose(p.c0()).compose(RxJavaHelper.t(gVar)).subscribe(EasySubscriber.create(new a5(this), new y4(this), new z4(this))));
    }

    /* renamed from: W */
    public void M(APIStatusErrorException aPIStatusErrorException) {
    }

    public void X() {
    }

    public void h() {
        this.f41502b.clear();
    }

    public abstract void i(String str, String str2, String str3, String str4);

    public void j(SecurityStrategyBottomMenuFragment securityStrategyBottomMenuFragment, u6.g gVar) {
        this.f41502b.add(UserCenterRemoteDataSource.A().w(p()).compose(p.c0()).compose(RxJavaHelper.t(gVar)).subscribe(new d(securityStrategyBottomMenuFragment)));
    }

    public void k(SecurityStrategyBottomMenuFragment securityStrategyBottomMenuFragment, u6.g gVar, boolean z11) {
        Map<String, Object> s11 = s();
        if (s11.containsKey("voice")) {
            s11.put("voice", Boolean.valueOf(z11));
        }
        this.f41502b.add(UserCenterRemoteDataSource.A().I(s11).compose(p.c0()).compose(RxJavaHelper.t(gVar)).subscribe(new b(securityStrategyBottomMenuFragment)));
    }

    public void l(SecurityStrategyBottomMenuFragment securityStrategyBottomMenuFragment, u6.g gVar) {
        EasySubscriber<Long> easySubscriber = this.f41506f;
        if (easySubscriber == null || easySubscriber.isUnsubscribed()) {
            this.f41506f = new f(securityStrategyBottomMenuFragment);
            securityStrategyBottomMenuFragment.e2(false, "");
            this.f41502b.add(Observable.interval(0, 1, TimeUnit.SECONDS).map(e5.f41675b).compose(RxJavaHelper.u(gVar, Schedulers.computation())).subscribe(this.f41506f));
        }
    }

    public Activity m() {
        return null;
    }

    public abstract String n();

    public abstract String o();

    public abstract Map<String, Object> p();

    public void q(String str, SecurityStrategyBottomMenuFragment securityStrategyBottomMenuFragment, u6.g gVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("use_type", "LOGIN");
        hashMap.put("email", str);
        UserCenterRemoteDataSource.A().getEmailSendResult(hashMap).compose(RxJavaHelper.t(gVar)).compose(p.c0()).subscribe(new g(securityStrategyBottomMenuFragment));
    }

    public String r() {
        return "";
    }

    public abstract Map<String, Object> s();

    public SecurityStrategyBottomMenuFragment.h t() {
        return null;
    }

    public List<String> u() {
        return null;
    }

    public boolean v() {
        return false;
    }

    public boolean w() {
        return false;
    }

    public abstract boolean x();

    public abstract boolean y();

    public abstract boolean z();
}
