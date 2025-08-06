package com.huobi.compliance;

import android.app.Activity;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huobi.login.usercenter.data.source.bean.CountryInfo;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import tq.p;
import u6.g;

public class ComplianceUtil {

    public class a extends BaseSubscriber<CountryInfo> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f43035b;

        public a(Activity activity) {
            this.f43035b = activity;
        }

        /* renamed from: a */
        public void onNext(CountryInfo countryInfo) {
            super.onNext(countryInfo);
            if (countryInfo != null && "83".equals(countryInfo.getCountryId())) {
                if (ComplianceUtil.f() && ComplianceUtil.e()) {
                    ComplianceUtil.i(this.f43035b);
                } else if (!ComplianceUtil.f()) {
                    ComplianceUtil.i(this.f43035b);
                }
            }
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            th2.printStackTrace();
        }
    }

    public class b extends BaseSubscriber<CountryInfo> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f43036b;

        public b(c cVar) {
            this.f43036b = cVar;
        }

        /* renamed from: a */
        public void onNext(CountryInfo countryInfo) {
            super.onNext(countryInfo);
            c cVar = this.f43036b;
            if (cVar != null) {
                cVar.onSuccess(countryInfo.getCountryId());
            }
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            th2.printStackTrace();
            c cVar = this.f43036b;
            if (cVar != null) {
                cVar.a();
            }
        }
    }

    public interface c {
        void a();

        void onSuccess(String str);
    }

    public static void d(Activity activity) {
        if (!Locale.JAPAN.toString().equals(AppLanguageHelper.getInstance().getSystemLocale().toString())) {
            UserCenterRemoteDataSource.A().u().compose(p.c0()).compose(RxJavaHelper.t((g) null)).subscribe(new a(activity));
        } else if (f() && e()) {
            i(activity);
        } else if (!f()) {
            i(activity);
        }
    }

    public static boolean e() {
        return TimeUnit.MILLISECONDS.toHours(System.currentTimeMillis() - ConfigPreferences.i("user_config", "SHOW_JAPAN_COMPLIANCE_TIME", -1)) >= 24;
    }

    public static boolean f() {
        return ConfigPreferences.i("user_config", "SHOW_JAPAN_COMPLIANCE_TIME", -1) != -1;
    }

    public static void g(c cVar) {
        UserCenterRemoteDataSource.A().u().compose(p.c0()).compose(RxJavaHelper.t((g) null)).subscribe(new b(cVar));
    }

    public static void h() {
        ConfigPreferences.l("user_config", "SHOW_JAPAN_COMPLIANCE_TIME", System.currentTimeMillis());
    }

    public static void i(Activity activity) {
    }
}
