package com.huobi.statistics;

import android.content.Context;
import android.text.TextUtils;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huawei.hms.push.AttributionReporter;
import com.huobi.index.api.IndexService;
import java.util.HashMap;
import tg.r;
import tq.p;

public class AppVersionUidHelper {

    public class a extends BaseSubscriber<String> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f81290b;

        public a(String str) {
            this.f81290b = str;
        }

        /* renamed from: a */
        public void onNext(String str) {
            super.onNext(str);
            ConfigPreferences.k("user_config", this.f81290b + "_" + "send_uid_appversion", 105400);
        }
    }

    public static void a(Context context) {
        String e11 = ConfigPreferences.e("user_config", "config_current_uid", "");
        String J = r.x().J();
        int f11 = ConfigPreferences.f("user_config", e11 + "_" + "send_uid_appversion");
        if ((f11 == 0 || 105400 != f11) && !TextUtils.isEmpty(J)) {
            HashMap hashMap = new HashMap();
            hashMap.put("osType", "1");
            hashMap.put(AttributionReporter.APP_VERSION, 105400);
            hashMap.put("uid", J);
            ((IndexService) p.V(IndexService.class)).sendUid(hashMap).compose(p.E()).compose(RxJavaHelper.s()).subscribe(new a(e11));
        }
    }
}
