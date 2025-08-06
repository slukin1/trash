package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.az;
import com.xiaomi.push.service.ba;
import java.util.HashMap;
import java.util.Map;

public class ge {

    /* renamed from: a  reason: collision with root package name */
    private static volatile ge f51895a;

    /* renamed from: a  reason: collision with other field name */
    private final Context f2902a;

    /* renamed from: a  reason: collision with other field name */
    private Map<String, gf> f2903a = new HashMap();

    private ge(Context context) {
        this.f2902a = context;
    }

    public static ge a(Context context) {
        if (context == null) {
            b.d("[TinyDataManager]:mContext is null, TinyDataManager.getInstance(Context) failed.");
            return null;
        }
        if (f51895a == null) {
            synchronized (ge.class) {
                if (f51895a == null) {
                    f51895a = new ge(context);
                }
            }
        }
        return f51895a;
    }

    public void a(gf gfVar, String str) {
        if (gfVar == null) {
            b.d("[TinyDataManager]: please do not add null mUploader to TinyDataManager.");
        } else if (TextUtils.isEmpty(str)) {
            b.d("[TinyDataManager]: can not add a provider from unkown resource.");
        } else {
            a().put(str, gfVar);
        }
    }

    public gf a() {
        gf gfVar = this.f2903a.get("UPLOADER_PUSH_CHANNEL");
        if (gfVar != null) {
            return gfVar;
        }
        gf gfVar2 = this.f2903a.get("UPLOADER_HTTP");
        if (gfVar2 != null) {
            return gfVar2;
        }
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, gf> m2722a() {
        return this.f2903a;
    }

    public boolean a(gk gkVar, String str) {
        if (TextUtils.isEmpty(str)) {
            b.a("pkgName is null or empty, upload ClientUploadDataItem failed.");
            return false;
        } else if (az.a(gkVar, false)) {
            return false;
        } else {
            if (TextUtils.isEmpty(gkVar.d())) {
                gkVar.f(az.a());
            }
            gkVar.g(str);
            ba.a(this.f2902a, gkVar);
            return true;
        }
    }
}
