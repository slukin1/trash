package com.huawei.hms.framework.network.grs.g.i;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.g.j.d;
import com.huawei.hms.framework.network.grs.h.c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f38079a = "a";

    /* renamed from: b  reason: collision with root package name */
    private static d f38080b;

    /* renamed from: c  reason: collision with root package name */
    private static final Object f38081c = new Object();

    public static synchronized d a(Context context) {
        synchronized (a.class) {
            synchronized (f38081c) {
                d dVar = f38080b;
                if (dVar != null) {
                    return dVar;
                }
                String a11 = c.a(GrsApp.getInstance().getBrand("/") + "grs_sdk_server_config.json", context);
                ArrayList arrayList = null;
                if (TextUtils.isEmpty(a11)) {
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(a11).getJSONObject("grs_server");
                    JSONArray jSONArray = jSONObject.getJSONArray("grs_base_url");
                    if (jSONArray != null && jSONArray.length() > 0) {
                        arrayList = new ArrayList();
                        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                            arrayList.add(jSONArray.get(i11).toString());
                        }
                    }
                    d dVar2 = new d();
                    f38080b = dVar2;
                    dVar2.a((List<String>) arrayList);
                    f38080b.a(jSONObject.getString("grs_query_endpoint_2.0"));
                    f38080b.a(jSONObject.getInt("grs_query_timeout"));
                } catch (JSONException e11) {
                    Logger.w(f38079a, "getGrsServerBean catch JSONException: %s", StringUtils.anonymizeMessage(e11.getMessage()));
                }
                d dVar3 = f38080b;
                return dVar3;
            }
        }
    }
}
