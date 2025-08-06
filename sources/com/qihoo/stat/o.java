package com.qihoo.stat;

import android.text.TextUtils;
import com.luck.picture.lib.loader.IBridgeMediaLoader;
import io.flutter.plugins.firebase.crashlytics.Constants;
import org.json.JSONObject;

public class o {

    /* renamed from: h  reason: collision with root package name */
    public static String f28821h = "TaskBean";

    /* renamed from: a  reason: collision with root package name */
    public String f28822a;

    /* renamed from: b  reason: collision with root package name */
    public String f28823b;

    /* renamed from: c  reason: collision with root package name */
    public String f28824c;

    /* renamed from: d  reason: collision with root package name */
    public int f28825d;

    /* renamed from: e  reason: collision with root package name */
    public long f28826e;

    /* renamed from: f  reason: collision with root package name */
    public long f28827f;

    /* renamed from: g  reason: collision with root package name */
    public long f28828g;

    public o() {
        this.f28822a = "";
        this.f28823b = "";
        this.f28824c = "";
        this.f28825d = 0;
        this.f28826e = 0;
        this.f28827f = 0;
        this.f28828g = -1;
        this.f28826e = u.M();
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.f28822a);
            jSONObject.put("begin", this.f28826e);
            jSONObject.put("status", this.f28825d);
            if (!TextUtils.isEmpty(this.f28823b)) {
                jSONObject.put("type", this.f28823b);
            }
            if (!TextUtils.isEmpty(this.f28824c)) {
                jSONObject.put(Constants.REASON, this.f28824c);
            }
            long j11 = this.f28827f;
            if (0 != j11) {
                jSONObject.put("end", j11);
                jSONObject.put(IBridgeMediaLoader.COLUMN_DURATION, this.f28828g);
            }
        } catch (Exception e11) {
            g0.b(f28821h, e11);
        } catch (Error e12) {
            g0.a(f28821h, e12);
        }
        return jSONObject;
    }
}
