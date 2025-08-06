package yl;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.newkyc.bean.UnifyKycInfo;
import com.hbg.lib.network.newkyc.bean.UserKycInfoNew;
import com.hbg.lib.network.pro.core.util.Period;
import com.huobi.kyc.util.KycProxy;
import i6.d;
import java.util.List;
import rx.Observable;
import tg.r;

public final class g {

    /* renamed from: f  reason: collision with root package name */
    public static Handler f76832f = new Handler(Looper.getMainLooper());

    /* renamed from: a  reason: collision with root package name */
    public final String f76833a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f76834b;

    /* renamed from: c  reason: collision with root package name */
    public UserKycInfoNew f76835c;

    /* renamed from: d  reason: collision with root package name */
    public long f76836d;

    /* renamed from: e  reason: collision with root package name */
    public final long f76837e;

    public static class b {
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: a  reason: collision with root package name */
        public static g f76838a = new g();
    }

    public static g h() {
        return b.f76838a;
    }

    public static /* synthetic */ Boolean k(UserKycInfoNew userKycInfoNew) {
        return Boolean.valueOf(userKycInfoNew != null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l() {
        this.f76834b = true;
    }

    public static /* synthetic */ void m(UserKycInfoNew userKycInfoNew) {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n(UserKycInfoNew userKycInfoNew) {
        d.j("IndexTAGCountryIdHelper", "setKycInfo info:" + userKycInfoNew);
        this.f76834b = false;
        this.f76835c = userKycInfoNew;
    }

    public void e() {
        d.j("IndexTAGCountryIdHelper", "clear");
        this.f76834b = true;
        this.f76836d = 0;
        this.f76835c = null;
    }

    public final Observable<UserKycInfoNew> f(boolean z11) {
        Observable<R> doOnNext = n8.a.a().getAuthInfo().b().compose(RxJavaHelper.t((u6.g) null)).doOnNext(new d(this));
        return z11 ? Observable.concat(Observable.just(this.f76835c), doOnNext).takeFirst(f.f61798b) : doOnNext;
    }

    public int g() {
        d.j("IndexTAGCountryIdHelper", "getCountryId");
        int i11 = -1;
        if (!r.x().F0()) {
            return -1;
        }
        try {
            List<Integer> r11 = r.x().r();
            if (r11 != null && !r11.isEmpty()) {
                i11 = r11.get(0).intValue();
                d.j("IndexTAGCountryIdHelper", "getCountryId 注册国籍:" + i11);
            }
            UserKycInfoNew userKycInfoNew = this.f76835c;
            if (!(userKycInfoNew == null || userKycInfoNew.getUser_info() == null || this.f76835c.getUser_info().getAuth_country() == null)) {
                i11 = Integer.parseInt(this.f76835c.getUser_info().getAuth_country().get("2"));
                d.j("IndexTAGCountryIdHelper", "getCountryId kyc国籍:" + i11);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            d.j("IndexTAGCountryIdHelper", "getCountryId:" + e11.getMessage());
        }
        d.j("IndexTAGCountryIdHelper", "getCountryId result:" + i11);
        return i11;
    }

    public UserKycInfoNew i() {
        return this.f76835c;
    }

    public Observable<UnifyKycInfo> j() {
        if (!r.x().F0()) {
            return Observable.just(null);
        }
        return KycProxy.l().n(true);
    }

    public void o() {
        d.j("IndexTAGCountryIdHelper", "onLoginSuccess");
        f76832f.post(new b(this));
    }

    public void p() {
        if (r.x().F0()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f76836d >= Period.MIN15_MILLS) {
                d.j("IndexTAGCountryIdHelper", "refreshAuthInfo");
                this.f76836d = currentTimeMillis;
                f(false).compose(RxJavaHelper.t((u6.g) null)).subscribe(EasySubscriber.create(e.f61797b));
            }
        }
    }

    public Observable<UserKycInfoNew> q() {
        d.j("IndexTAGCountryIdHelper", "requestAuthInfo needRequest:" + this.f76834b);
        if (!r.x().F0()) {
            return Observable.just(null);
        }
        return f(!this.f76834b);
    }

    public void r(UserKycInfoNew userKycInfoNew) {
        f76832f.post(new c(this, userKycInfoNew));
    }

    public g() {
        this.f76833a = "IndexTAGCountryIdHelper";
        this.f76834b = true;
        this.f76835c = null;
        this.f76836d = 0;
        this.f76837e = Period.MIN15_MILLS;
    }
}
