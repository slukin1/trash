package com.huobi.app.startuptasks;

import android.content.Context;
import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;
import com.hbg.lib.core.util.ChannelUtils;
import i6.d;
import java.util.Map;

public class AppsFlyerInitializer {

    public class a implements AppsFlyerConversionListener {
        public a() {
        }

        public void onAppOpenAttribution(Map<String, String> map) {
            for (String next : map.keySet()) {
                d.c("AppsFlyer", "attribute: " + next + " = " + map.get(next));
            }
        }

        public void onAttributionFailure(String str) {
            d.c("AppsFlyer", "error onAttributionFailure : " + str);
        }

        public void onConversionDataFail(String str) {
            d.c("AppsFlyer", "error getting conversion data: " + str);
        }

        public void onConversionDataSuccess(Map<String, Object> map) {
            for (String next : map.keySet()) {
                d.c("AppsFlyer", "attribute: " + next + " = " + map.get(next));
            }
        }
    }

    public void a(Context context) {
        a aVar = new a();
        AppsFlyerLib.getInstance().setOutOfStore(ChannelUtils.b());
        AppsFlyerLib.getInstance().init("KYk7DmeAsTksWqHv4uA68L", aVar, context);
        AppsFlyerLib.getInstance().start(context);
    }
}
