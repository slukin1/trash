package el;

import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.contract.retrofit.ContractRetrofit;
import com.hbg.lib.network.retrofit.exception.NullResponseException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.module.contract.service.ContractService;
import com.huobi.contract.entity.ContractUserInfo;
import com.huobi.contract.helper.ContractUserInfoProvider;
import com.huobi.coupon.bean.Coupon;
import com.huobi.kyc.bean.PhpLogin;
import com.huobi.kyc.service.KycService;
import com.huobi.login.usercenter.data.source.bean.LoginInfoData;
import com.huobi.login.usercenter.data.source.bean.ProUserToken;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.tencent.android.tpush.common.Constants;
import d7.k;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import rx.Observable;
import tg.r;
import tq.p;
import u6.g;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static volatile i f68141a;

    public class a extends BaseSubscriber<ProUserToken> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f68142b;

        public a(MethodChannel.Result result) {
            this.f68142b = result;
        }

        /* renamed from: a */
        public void onNext(ProUserToken proUserToken) {
            super.onNext(proUserToken);
            r.x().v0(proUserToken.getToken());
            this.f68142b.success(proUserToken.getToken());
        }

        public void onError(Throwable th2) {
            th2.printStackTrace();
            try {
                this.f68142b.error("512", "", "");
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public class b extends BaseSubscriber<ContractUserInfo> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f68144b;

        public b(MethodChannel.Result result) {
            this.f68144b = result;
        }

        /* renamed from: a */
        public void onNext(ContractUserInfo contractUserInfo) {
            super.onNext(contractUserInfo);
            if (contractUserInfo == null || contractUserInfo.getUser() == null) {
                this.f68144b.error("flutter get dm token error 1", "", "");
                return;
            }
            ContractUserInfoProvider.i().z(contractUserInfo.getUser());
            r.x().k0(contractUserInfo.getHbsession());
            this.f68144b.success(contractUserInfo.getHbsession());
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            try {
                this.f68144b.error("flutter get dm token error 2", "", "");
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public class c extends BaseSubscriber<String> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f68146b;

        public c(MethodChannel.Result result) {
            this.f68146b = result;
        }

        /* renamed from: a */
        public void onNext(String str) {
            this.f68146b.success(str);
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            try {
                this.f68146b.error("flutter get php token error", th2.getMessage(), th2.getMessage());
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public class d extends BaseSubscriber<String> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f68148b;

        public d(MethodChannel.Result result) {
            this.f68148b = result;
        }

        /* renamed from: a */
        public void onNext(String str) {
            this.f68148b.success(str);
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            try {
                this.f68148b.error("flutter get otc token error", th2.getMessage(), th2.getMessage());
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public class e extends BaseSubscriber<String> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f68150b;

        public e(MethodChannel.Result result) {
            this.f68150b = result;
        }

        /* renamed from: a */
        public void onNext(String str) {
            r.x().r0(str);
            this.f68150b.success(str);
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            try {
                this.f68150b.error("flutter get kyc token error", th2.getMessage(), th2.getMessage());
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public class f extends BaseSubscriber<String> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f68152b;

        public f(MethodChannel.Result result) {
            this.f68152b = result;
        }

        /* renamed from: a */
        public void onNext(String str) {
            r.x().o0(str);
            this.f68152b.success(str);
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            try {
                this.f68152b.error("flutter get inst token error", th2.getMessage(), th2.getMessage());
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public static i k() {
        if (f68141a == null) {
            synchronized (k.class) {
                f68141a = new i();
            }
        }
        return f68141a;
    }

    public static /* synthetic */ Observable p(LoginInfoData loginInfoData) {
        if (loginInfoData == null || TextUtils.isEmpty(loginInfoData.getTicket())) {
            return Observable.error(new RuntimeException("flutter get dm token error 1"));
        }
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.FLAG_TICKET, loginInfoData.getTicket());
        return ((ContractService) p.p(ContractService.class)).login(hashMap).compose(ContractRetrofit.h());
    }

    public static /* synthetic */ Observable s(LoginInfoData loginInfoData) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("type", "PRO_APP");
        hashMap.put(Constants.FLAG_TICKET, loginInfoData.getTicket());
        return s8.a.a().getTicket(hashMap).b();
    }

    public static /* synthetic */ Observable t(String str) {
        if (TextUtils.isEmpty(str)) {
            return Observable.error(new NullResponseException());
        }
        r.x().t0(str);
        return Observable.just(str);
    }

    public static /* synthetic */ Observable u(LoginInfoData loginInfoData) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("method", FirebaseAnalytics.Event.LOGIN);
        hashMap.put(Constants.FLAG_TICKET, loginInfoData.getTicket());
        return ((KycService) p.V(KycService.class)).ucLogin(hashMap).compose(p.a0());
    }

    public static /* synthetic */ Observable v(PhpLogin phpLogin) {
        if (phpLogin == null || TextUtils.isEmpty(phpLogin.getToken())) {
            return Observable.error(new NullResponseException());
        }
        r.x().u0(phpLogin.getToken());
        return Observable.just(phpLogin.getToken());
    }

    public final void i(MethodChannel.Result result) {
        UserCenterRemoteDataSource.A().P().compose(p.c0()).flatMap(c.f54342b).compose(RxJavaHelper.t((g) null)).subscribe(new b(result));
    }

    public final void j(MethodChannel.Result result) {
        UserCenterRemoteDataSource.A().Q("AbsGlobalFlutterActivity#getInstTicket").compose(p.c0()).flatMap(g.f54346b).retry(3).compose(RxJavaHelper.t((g) null)).subscribe(new f(result));
    }

    public final void l(MethodChannel.Result result) {
        UserCenterRemoteDataSource.A().Q("AbsGlobalFlutterActivity#getKycTicket").compose(p.c0()).flatMap(e.f54344b).retry(3).compose(RxJavaHelper.t((g) null)).subscribe(new e(result));
    }

    public final void m(MethodChannel.Result result) {
        UserCenterRemoteDataSource.A().Q("AbsGlobalFlutterActivity#getOTCTicket").compose(p.c0()).flatMap(b.f54341b).flatMap(h.f54347b).retry(3).compose(RxJavaHelper.t((g) null)).subscribe(new d(result));
    }

    public final void n(MethodChannel.Result result) {
        UserCenterRemoteDataSource.A().Q("AbsGlobalFlutterActivity#getPHPTicket").compose(p.c0()).flatMap(f.f54345b).flatMap(a.f54340b).retry(3).compose(RxJavaHelper.t((g) null)).subscribe(new c(result));
    }

    public void o(MethodChannel.Result result) {
        UserCenterRemoteDataSource.A().P().compose(p.c0()).flatMap(d.f54343b).compose(RxJavaHelper.t((g) null)).subscribe(new a(result));
    }

    public void x(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.arguments();
        if ("PRO".equals(str)) {
            o(result);
        } else if ("CONTRACT".equals(str)) {
            i(result);
        } else if (Coupon.OTC.equals(str)) {
            m(result);
        } else if ("PHP".equals(str)) {
            n(result);
        } else if ("KYC".equals(str)) {
            l(result);
        } else if ("INST".equals(str)) {
            j(result);
        } else {
            result.error("-1", "not found " + str + " get token method", (Object) null);
        }
    }
}
