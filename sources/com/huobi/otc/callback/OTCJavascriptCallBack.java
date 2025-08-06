package com.huobi.otc.callback;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.google.gson.Gson;
import com.hbg.module.otc.OtcModuleConfig;
import com.huobi.otc.bean.OtcInitInfo;

public class OTCJavascriptCallBack {
    @JavascriptInterface
    public String getDeviceInfoJsonStr() {
        Gson gson = new Gson();
        OtcInitInfo otcInitInfo = new OtcInitInfo();
        otcInitInfo.setClientName("android_pro");
        return gson.toJson((Object) otcInitInfo);
    }

    @JavascriptInterface
    public String getDomainEnvJsonStr() {
        return OtcModuleConfig.a().q();
    }

    @JavascriptInterface
    public String getOtcToken() {
        String c11 = OtcModuleConfig.a().c();
        return TextUtils.isEmpty(c11) ? "" : c11;
    }

    @JavascriptInterface
    public String getUcToken() {
        String f11 = OtcModuleConfig.a().f();
        return TextUtils.isEmpty(f11) ? "" : f11;
    }
}
