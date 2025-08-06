package com.huobi.app;

import android.util.Log;
import com.hbg.lib.core.GlobalAppConfig;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.module.kline.KlineReqConfig;
import com.huobi.store.AppConfig;
import com.huobi.store.AppConfigManager;
import ej.d;
import java.util.List;
import jp.s0;
import v7.b;
import yl.m;

public class HbMgtConfigHelper {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f42136a;

    public class a extends RequestCallback1<List<AppConfig>> {
        /* renamed from: a */
        public void onRequestSuccess(List<AppConfig> list) {
            if (GlobalAppConfig.e()) {
                Log.d("AppConfig", "onRequestSuccess() called with: array = " + list);
            }
            NetworkMonitorManager.a().b();
            AppConfigManager.m(list);
            d.a().b(list);
            s0.b().c(list);
            qf.a.b(list);
        }

        public void onRequestFailure(Throwable th2) {
            Log.e("AppConfig", "onRequestFailure: ", th2);
        }
    }

    public static void a() {
        if (b()) {
            KlineReqConfig.d();
            m.b();
        }
    }

    public static boolean b() {
        if (f42136a) {
            return false;
        }
        f42136a = true;
        AppConfigManager.p(false);
        H5CacheServiceHelper.registerOnChangeListener();
        new d9.a(b.a().getAppConfigList().b()).d(new a());
        return true;
    }
}
