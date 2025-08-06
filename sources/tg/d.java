package tg;

import al.m0;
import android.app.Activity;
import android.os.Looper;
import android.util.Pair;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.linearswap.ui.GuideBindGADialogFragment;
import com.huobi.login.usercenter.data.source.bean.SecurityStrategySet;
import com.huobi.login.usercenter.data.source.bean.UserSecurityInfoData;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import i6.i;
import i6.k;
import rx.Observable;
import rx.schedulers.Schedulers;
import tq.p;
import u6.g;

public final class d {

    /* renamed from: f  reason: collision with root package name */
    public static final Long f47849f = Long.valueOf(Period.DAY_MILLS);

    /* renamed from: g  reason: collision with root package name */
    public static final Long f47850g = Long.valueOf(Period.WEEK_MILLS);

    /* renamed from: a  reason: collision with root package name */
    public boolean f47851a;

    /* renamed from: b  reason: collision with root package name */
    public int f47852b;

    /* renamed from: c  reason: collision with root package name */
    public int f47853c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f47854d;

    /* renamed from: e  reason: collision with root package name */
    public GuideBindGADialogFragment f47855e;

    public class a extends EasySubscriber<Pair<UserSecurityInfoData, SecurityStrategySet>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Runnable f47856b;

        public a(Runnable runnable) {
            this.f47856b = runnable;
        }

        /* renamed from: a */
        public void onNext(Pair<UserSecurityInfoData, SecurityStrategySet> pair) {
            super.onNext(pair);
            UserSecurityInfoData userSecurityInfoData = (UserSecurityInfoData) pair.first;
            SecurityStrategySet securityStrategySet = (SecurityStrategySet) pair.second;
            k.d("GaHelper_initGaData", userSecurityInfoData.toString());
            int unused = d.this.f47853c = userSecurityInfoData.getAssetGa();
            if (securityStrategySet.getSetting() != null) {
                boolean unused2 = d.this.f47854d = securityStrategySet.getSetting().isVerify_ga();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("isMainThread:");
            sb2.append(Looper.getMainLooper() == Looper.myLooper());
            sb2.append(" runnable:");
            sb2.append(this.f47856b);
            i6.d.e("initGaData", sb2.toString());
            Runnable runnable = this.f47856b;
            if (runnable != null) {
                runnable.run();
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            int unused = d.this.f47853c = -1;
            boolean unused2 = d.this.f47854d = false;
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static d f47858a = new d((a) null);
    }

    public /* synthetic */ d(a aVar) {
        this();
    }

    public static d g() {
        return b.f47858a;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m() {
        if (r.x().F0()) {
            boolean l11 = SP.l("ga_pre_guide_login_show_" + r.x().J(), false);
            long g11 = SP.g("ga_pre_guide_time_key_" + r.x().J(), 0);
            if (!l11 && System.currentTimeMillis() - g11 > f47850g.longValue() && q()) {
                SP.y("ga_pre_guide_login_show_" + r.x().J(), true);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n() {
        this.f47855e = null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o() {
        if (r.x().F0()) {
            if (System.currentTimeMillis() - SP.g("ga_pre_guide_time_key_" + r.x().J(), 0) > f47850g.longValue() && q()) {
                i6.d.d("orderAfterGuide success");
            }
        }
    }

    public void f() {
        j(new c(this));
    }

    public final boolean h(boolean z11) {
        Activity b11;
        GuideBindGADialogFragment guideBindGADialogFragment = this.f47855e;
        if ((guideBindGADialogFragment == null || !guideBindGADialogFragment.isAdded()) && (b11 = oa.a.g().b()) != null && !b11.isFinishing() && (b11 instanceof FragmentActivity)) {
            try {
                GuideBindGADialogFragment guideBindGADialogFragment2 = new GuideBindGADialogFragment();
                this.f47855e = guideBindGADialogFragment2;
                guideBindGADialogFragment2.vh(z11);
                this.f47855e.setDialogDismissListener(new a(this));
                this.f47855e.show(((FragmentActivity) b11).getSupportFragmentManager(), "GuideBindGADialogFragment");
                SP.r("ga_pre_guide_time_key_" + r.x().J(), System.currentTimeMillis());
                return true;
            } catch (Throwable unused) {
                this.f47855e = null;
            }
        }
        return false;
    }

    public void i() {
        j((Runnable) null);
    }

    public void j(Runnable runnable) {
        Observable.zip(UserCenterRemoteDataSource.A().T().subscribeOn(Schedulers.io()).compose(p.c0()), UserCenterRemoteDataSource.A().F().subscribeOn(Schedulers.io()).compose(p.c0()), m0.f3581b).compose(RxJavaHelper.t((g) null)).subscribe(new a(runnable));
    }

    public boolean k() {
        return this.f47853c == 1;
    }

    public boolean l() {
        return k() && this.f47854d;
    }

    public void p() {
        b bVar = new b(this);
        if (this.f47853c == -1) {
            j(bVar);
        } else {
            i.b().f(bVar);
        }
    }

    public final boolean q() {
        k.d("GaHelper_initGaData", "assetGa=：" + this.f47853c + "gaStateIsOpen=：" + this.f47854d);
        if (this.f47853c == -1) {
            return false;
        }
        if (!k()) {
            return h(false);
        }
        if (!l()) {
            return h(true);
        }
        return false;
    }

    public d() {
        this.f47852b = 0;
        this.f47853c = -1;
        this.f47854d = false;
    }
}
