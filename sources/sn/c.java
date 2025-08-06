package sn;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import bh.j;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.utils.AppUtil;
import com.hbg.lib.core.util.PhoneUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseEasySubscriber;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import i6.k;
import java.util.HashMap;
import java.util.List;
import tg.r;
import u6.g;

public final class c implements Application.ActivityLifecycleCallbacks {

    /* renamed from: b  reason: collision with root package name */
    public boolean f76547b;

    public class a extends BaseEasySubscriber<Object> {
        public a() {
        }

        public void onError2(Throwable th2) {
            th2.printStackTrace();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            aPIStatusErrorException.printStackTrace();
        }
    }

    public static class b {
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: a  reason: collision with root package name */
        public static c f76549a = new c((a) null);
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    public static c a() {
        return b.f76549a;
    }

    public void b() {
        AppUtil.d();
        AppUtil.a(new b(this));
        j.c().registerActivityLifecycleCallbacks(this);
    }

    public final boolean c() {
        String packageName = j.c().getApplicationContext().getPackageName();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) j.c().getApplicationContext().getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.processName.equals(packageName) && next.importance == 100) {
                return true;
            }
        }
        return false;
    }

    public void d() {
        k.f("HBLifeCycleCallback", "onHotStartUp");
        if (r.x().F0()) {
            f();
        }
    }

    public void e() {
        k.f("HBLifeCycleCallback", "onNewDay");
        if (r.x().F0()) {
            f();
        }
    }

    public final void f() {
        HashMap hashMap = new HashMap();
        String h11 = ku.b.e().h(BaseApplication.b());
        if (!TextUtils.isEmpty(h11)) {
            hashMap.put("vToken", h11);
        }
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_FINGERPRINT, PhoneUtils.s(true));
        hashMap.put("login_ext_data", gs.a.a());
        UserCenterRemoteDataSource.A().E0(hashMap).compose(RxJavaHelper.t((g) null)).subscribe(new a());
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
        if (!this.f76547b) {
            this.f76547b = true;
            d();
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
        if (!c()) {
            this.f76547b = false;
        }
    }

    public c() {
        this.f76547b = false;
    }
}
