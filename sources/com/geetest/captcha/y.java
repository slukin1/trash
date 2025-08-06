package com.geetest.captcha;

import android.content.Context;
import com.geetest.core.GeeGuard;
import com.geetest.core.GeeGuardConfiguration;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0002J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\bR\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005R(\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/geetest/captcha/utils/CoreUtils;", "", "()V", "isAvailable", "", "()Z", "map", "", "", "Lorg/json/JSONObject;", "getMap", "()Ljava/util/Map;", "setMap", "(Ljava/util/Map;)V", "getData", "context", "Landroid/content/Context;", "sign", "getDataWithSign", "url", "captcha_release"}, k = 1, mv = {1, 1, 16})
public final class y {

    /* renamed from: a  reason: collision with root package name */
    public static final y f65281a = new y();

    /* renamed from: b  reason: collision with root package name */
    private static Map<String, ? extends JSONObject> f65282b;

    private y() {
    }

    public static void a(Map<String, ? extends JSONObject> map) {
        f65282b = map;
    }

    private static String b(Context context, String str) {
        Class<String> cls = String.class;
        Class<GeeGuard> cls2 = GeeGuard.class;
        Class<GeeGuardConfiguration> cls3 = GeeGuardConfiguration.class;
        Class<GeeGuardConfiguration.Builder> cls4 = GeeGuardConfiguration.Builder.class;
        try {
            GeeGuardConfiguration.Builder newInstance = cls4.newInstance();
            cls4.getMethod("setAppId", new Class[]{cls}).invoke(newInstance, new Object[]{"54847f3301740c85982a1d3d566bd24e"});
            cls4.getMethod("setExtraInfo", new Class[]{HashMap.class}).invoke(newInstance, new Object[]{f65282b});
            Class cls5 = Boolean.TYPE;
            cls4.getMethod("setAlInfo", new Class[]{cls5}).invoke(newInstance, new Object[]{Boolean.FALSE});
            cls4.getMethod("setDevInfo", new Class[]{cls5}).invoke(newInstance, new Object[]{Boolean.TRUE});
            cls4.getMethod("setLevel", new Class[]{Integer.TYPE}).invoke(newInstance, new Object[]{1});
            cls4.getMethod("addSignature", new Class[]{cls}).invoke(newInstance, new Object[]{str});
            Object invoke = cls4.getMethod("build", new Class[0]).invoke(newInstance, new Object[0]);
            Object invoke2 = cls2.getMethod("getData", new Class[]{Context.class, cls3}).invoke((Object) null, new Object[]{context, invoke});
            if (invoke2 != null) {
                return (String) invoke2;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0010, code lost:
        r5 = r5.a().f65175b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r4, java.lang.String r5) {
        /*
            r0 = 0
            if (r4 == 0) goto L_0x0068
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0064 }
            r1.<init>()     // Catch:{ Exception -> 0x0064 }
            com.geetest.captcha.ae$b r2 = com.geetest.captcha.ae.f65171a     // Catch:{ Exception -> 0x0064 }
            com.geetest.captcha.ae r5 = com.geetest.captcha.ae.b.a(r5)     // Catch:{ Exception -> 0x0064 }
            if (r5 == 0) goto L_0x0021
            com.geetest.captcha.ae$a r5 = r5.a()     // Catch:{ Exception -> 0x0064 }
            java.util.Map<java.lang.String, java.lang.String> r5 = r5.f65175b     // Catch:{ Exception -> 0x0064 }
            if (r5 == 0) goto L_0x0021
            java.lang.String r2 = "data"
            java.lang.Object r5 = r5.get(r2)     // Catch:{ Exception -> 0x0064 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0064 }
            goto L_0x0022
        L_0x0021:
            r5 = r0
        L_0x0022:
            java.lang.String r2 = "utf-8"
            java.lang.String r5 = java.net.URLDecoder.decode(r5, r2)     // Catch:{ Exception -> 0x0064 }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x0064 }
            r2.<init>(r5)     // Catch:{ Exception -> 0x0064 }
            java.lang.String r5 = "challenge"
            java.lang.String r5 = r2.getString(r5)     // Catch:{ Exception -> 0x0064 }
            java.lang.String r3 = "captchaId"
            java.lang.String r2 = r2.getString(r3)     // Catch:{ Exception -> 0x0064 }
            r1.append(r2)     // Catch:{ Exception -> 0x0064 }
            r1.append(r5)     // Catch:{ Exception -> 0x0064 }
            java.lang.String r5 = r4.getPackageName()     // Catch:{ Exception -> 0x0064 }
            r1.append(r5)     // Catch:{ Exception -> 0x0064 }
            java.lang.String r5 = "1.8.0"
            r1.append(r5)     // Catch:{ Exception -> 0x0064 }
            com.geetest.captcha.ag r5 = com.geetest.captcha.ag.f65177a     // Catch:{ Exception -> 0x0064 }
            java.lang.String r5 = "Sign content: "
            java.lang.String r2 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x0064 }
            java.lang.String r5 = r5.concat(r2)     // Catch:{ Exception -> 0x0064 }
            com.geetest.captcha.ag.a(r5)     // Catch:{ Exception -> 0x0064 }
            java.lang.String r5 = r1.toString()     // Catch:{ Exception -> 0x0064 }
            java.lang.String r4 = b(r4, r5)     // Catch:{ Exception -> 0x0064 }
            return r4
        L_0x0064:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0068:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.geetest.captcha.y.a(android.content.Context, java.lang.String):java.lang.String");
    }
}
