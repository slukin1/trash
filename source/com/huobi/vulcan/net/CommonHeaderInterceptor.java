package com.huobi.vulcan.net;

import android.os.Build;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.huawei.hms.push.AttributionReporter;
import com.huobi.kalle.Response;
import com.huobi.kalle.k;
import com.huobi.vulcan.utils.SystemUtils;
import hm.d;
import im.c;
import java.io.IOException;
import ku.a;
import org.json.JSONException;
import org.json.JSONObject;

public class CommonHeaderInterceptor implements d {
    public Response a(c cVar) throws IOException {
        k request = cVar.request();
        request.c().a("vulcan-info", b());
        return cVar.a(request);
    }

    public String b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("platformType", 2);
            jSONObject.putOpt("platformVersion", Build.VERSION.RELEASE);
            jSONObject.putOpt(DeviceRequestsHelper.DEVICE_INFO_MODEL, Build.BRAND);
            if (a.b() != null) {
                jSONObject.putOpt(AttributionReporter.APP_VERSION, SystemUtils.x(a.b()));
            }
            jSONObject.putOpt("businessLine", Integer.valueOf(iu.a.f().e()));
            jSONObject.putOpt("sdkVersion", "1.3.1");
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return jSONObject.toString();
    }
}
