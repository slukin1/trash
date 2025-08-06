package com.qihoo.stat;

import android.text.TextUtils;
import com.luck.picture.lib.loader.IBridgeMediaLoader;
import io.flutter.plugins.firebase.crashlytics.Constants;
import org.json.JSONObject;

public class k {

    /* renamed from: g  reason: collision with root package name */
    public static String f28787g = "LevelBean";

    /* renamed from: a  reason: collision with root package name */
    public String f28788a = "";

    /* renamed from: b  reason: collision with root package name */
    public long f28789b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f28790c = 0;

    /* renamed from: d  reason: collision with root package name */
    public long f28791d = -1;

    /* renamed from: e  reason: collision with root package name */
    public int f28792e = 0;

    /* renamed from: f  reason: collision with root package name */
    public String f28793f = "";

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.f28788a);
            jSONObject.put("status", this.f28792e);
            jSONObject.put("begin", this.f28789b);
            long j11 = this.f28790c;
            if (0 != j11) {
                jSONObject.put("end", j11);
                jSONObject.put(IBridgeMediaLoader.COLUMN_DURATION, this.f28791d);
                if (!TextUtils.isEmpty(this.f28793f)) {
                    jSONObject.put(Constants.REASON, this.f28793f);
                }
            }
        } catch (Exception e11) {
            g0.b(f28787g, e11);
        } catch (Error e12) {
            g0.a(f28787g, e12);
        }
        return jSONObject;
    }
}
