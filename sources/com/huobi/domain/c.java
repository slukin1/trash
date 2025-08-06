package com.huobi.domain;

import android.text.TextUtils;
import android.util.Base64;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.reflect.TypeToken;
import com.hbg.lib.common.utils.crypt.rsa.RSAProvider;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.network.hbg.core.bean.SmartDomainData;
import com.huobi.utils.GsonHelper;
import com.huobi.utils.x;
import i6.k;
import java.nio.charset.StandardCharsets;

public final class c {

    public class a extends TypeToken<SmartDomainData> {
    }

    public class b extends TypeToken<SmartDomainData> {
    }

    /* renamed from: com.huobi.domain.c$c  reason: collision with other inner class name */
    public class C0567c extends TypeToken<SmartDomainData> {
    }

    public class d extends TypeToken<SmartDomainData> {
    }

    public class e extends TypeToken<SmartDomainData> {
    }

    public static SmartDomainData a() {
        try {
            if (x.d()) {
                return (SmartDomainData) GsonHelper.a().fromJson(e("smart_domain_cn.json"), new d().getType());
            }
            return (SmartDomainData) GsonHelper.a().fromJson(e("smart_domain_overseas.json"), new e().getType());
        } catch (Exception e11) {
            k.d(ShareConstants.ACTION, "getSmartDomainFromLocalJson " + e11.toString());
            return null;
        }
    }

    public static SmartDomainData b() {
        SmartDomainData smartDomainData;
        Exception e11;
        try {
            if (x.d()) {
                smartDomainData = (SmartDomainData) GsonHelper.a().fromJson(new String(RSAProvider.b(Base64.decode(e("smart_domain_cn_security.json").getBytes(StandardCharsets.UTF_8), 0), "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAImAK6FIF+4UAxQmURJ4yJcnyerbOV7/MEJRg1vZvXWSqubYK/coJiwcn0DL62TZr9JPqR0dGunCYbkaUuNgcuGh0YZU2kuSWYP5hx6MOSVwDzS9McuuADDcKkgBte9u1nIdQZRN/Um3wYGXRtgg/FMZlBExvcgJIZXaVefx2nXTAgMBAAECgYBKoD6NxSP/uerF19nubZFowFaNWbf0gAnAJJ9njXCPTC/nI/IQrUCydkJUl5hFXwRW35dITtCZiD8jiE7uSx1t3oUwe0KiDcvpilm/2LFbw0P3dnnFt6WRM4s98mISbeBHxawrq0hn3YlkNMwVY6ze6D2egSMJSr9+QGHynwES6QJBAL9Dm2/hTclXtHa8RjxY+7N6wE9PF7jHn8G+B/UN6KleaWDzknR/sXw9Q6zQ3JIadFiyX2J6HNy0yUzhAQgdOo0CQQC4CiR/imGdlDU/70w6a0h8cmgL9wMlgz1a2YXfeMGONdQyHgye4fPTUdkub+R05ByKkTHhN7fT8XWTCHmYC4nfAkEApL0WpMbquQFR7vM7i78ZDP4tpiH5zK4kbDvBntDcFQW8vkUNYEqcFOav46oCUdV3YO5COg/zzCXrPMyQluyWAQJAVYAoyrQQe7PyNTzITk+vQlmoav6cEJ5zL7TlFBg23Am4BnydYmcY7vEUlBVZrtCXTez8nmRTW/zOobuLOg8KQwJBALpTq+kdbyPt5IzL/kbA44cgAzg7so8I/P/cf/LbXoblLSzbEx5ryUGhKheTHLROo+xZj5llMbdJgZmF+gBdWbc="), StandardCharsets.UTF_8), new b().getType());
                try {
                    k.d(ShareConstants.ACTION, "get from smart_domain_cn_security");
                } catch (Exception e12) {
                    e11 = e12;
                }
                return smartDomainData;
            }
            smartDomainData = (SmartDomainData) GsonHelper.a().fromJson(new String(RSAProvider.b(Base64.decode(e("smart_domain_overseas_security.json").getBytes(StandardCharsets.UTF_8), 0), "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAImAK6FIF+4UAxQmURJ4yJcnyerbOV7/MEJRg1vZvXWSqubYK/coJiwcn0DL62TZr9JPqR0dGunCYbkaUuNgcuGh0YZU2kuSWYP5hx6MOSVwDzS9McuuADDcKkgBte9u1nIdQZRN/Um3wYGXRtgg/FMZlBExvcgJIZXaVefx2nXTAgMBAAECgYBKoD6NxSP/uerF19nubZFowFaNWbf0gAnAJJ9njXCPTC/nI/IQrUCydkJUl5hFXwRW35dITtCZiD8jiE7uSx1t3oUwe0KiDcvpilm/2LFbw0P3dnnFt6WRM4s98mISbeBHxawrq0hn3YlkNMwVY6ze6D2egSMJSr9+QGHynwES6QJBAL9Dm2/hTclXtHa8RjxY+7N6wE9PF7jHn8G+B/UN6KleaWDzknR/sXw9Q6zQ3JIadFiyX2J6HNy0yUzhAQgdOo0CQQC4CiR/imGdlDU/70w6a0h8cmgL9wMlgz1a2YXfeMGONdQyHgye4fPTUdkub+R05ByKkTHhN7fT8XWTCHmYC4nfAkEApL0WpMbquQFR7vM7i78ZDP4tpiH5zK4kbDvBntDcFQW8vkUNYEqcFOav46oCUdV3YO5COg/zzCXrPMyQluyWAQJAVYAoyrQQe7PyNTzITk+vQlmoav6cEJ5zL7TlFBg23Am4BnydYmcY7vEUlBVZrtCXTez8nmRTW/zOobuLOg8KQwJBALpTq+kdbyPt5IzL/kbA44cgAzg7so8I/P/cf/LbXoblLSzbEx5ryUGhKheTHLROo+xZj5llMbdJgZmF+gBdWbc="), StandardCharsets.UTF_8), new C0567c().getType());
            k.d(ShareConstants.ACTION, "get from smart_domain_overseas_security");
            return smartDomainData;
        } catch (Exception e13) {
            Exception exc = e13;
            smartDomainData = null;
            e11 = exc;
            k.d(ShareConstants.ACTION, "getSmartDomainFromLocalJson " + e11.toString());
            return smartDomainData;
        }
    }

    public static SmartDomainData c() {
        SmartDomainData b11 = b();
        if (b11 != null) {
            return b11;
        }
        return a();
    }

    public static SmartDomainData d() {
        String d11 = ConfigPreferences.d("user_config", "APP_DOMAIN_SMART_CONFIG");
        if (TextUtils.isEmpty(d11)) {
            return null;
        }
        try {
            return (SmartDomainData) GsonHelper.a().fromJson(d11, new a().getType());
        } catch (Exception e11) {
            k.d(ShareConstants.ACTION, "parseAppConfig FAIL:" + e11.toString());
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0088 A[SYNTHETIC, Splitter:B:26:0x0088] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0090 A[Catch:{ Exception -> 0x008c }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a3 A[SYNTHETIC, Splitter:B:38:0x00a3] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ab A[Catch:{ Exception -> 0x00a7 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String e(java.lang.String r10) {
        /*
            java.lang.String r0 = "--"
            java.lang.String r1 = "getDomainFromLocalJson "
            java.lang.String r2 = "ACTION"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            android.app.Application r4 = bh.j.c()
            android.content.res.AssetManager r4 = r4.getAssets()
            r5 = 0
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0063, all -> 0x0060 }
            java.io.InputStream r4 = r4.open(r10)     // Catch:{ IOException -> 0x0063, all -> 0x0060 }
            java.lang.String r7 = "utf-8"
            r6.<init>(r4, r7)     // Catch:{ IOException -> 0x0063, all -> 0x0060 }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ IOException -> 0x005b, all -> 0x0059 }
            r4.<init>(r6)     // Catch:{ IOException -> 0x005b, all -> 0x0059 }
        L_0x0024:
            java.lang.String r5 = r4.readLine()     // Catch:{ IOException -> 0x0057 }
            if (r5 == 0) goto L_0x002e
            r3.append(r5)     // Catch:{ IOException -> 0x0057 }
            goto L_0x0024
        L_0x002e:
            r4.close()     // Catch:{ IOException -> 0x0057 }
            r4.close()     // Catch:{ Exception -> 0x0039 }
            r6.close()     // Catch:{ Exception -> 0x0039 }
            goto L_0x009a
        L_0x0039:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
        L_0x003f:
            r5.append(r1)
            r5.append(r10)
            r5.append(r0)
            java.lang.String r10 = r4.toString()
            r5.append(r10)
            java.lang.String r10 = r5.toString()
            i6.k.d(r2, r10)
            goto L_0x009a
        L_0x0057:
            r5 = move-exception
            goto L_0x0067
        L_0x0059:
            r3 = move-exception
            goto L_0x00a1
        L_0x005b:
            r4 = move-exception
            r9 = r5
            r5 = r4
            r4 = r9
            goto L_0x0067
        L_0x0060:
            r3 = move-exception
            r6 = r5
            goto L_0x00a1
        L_0x0063:
            r4 = move-exception
            r6 = r5
            r5 = r4
            r4 = r6
        L_0x0067:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x009f }
            r7.<init>()     // Catch:{ all -> 0x009f }
            r7.append(r1)     // Catch:{ all -> 0x009f }
            r7.append(r10)     // Catch:{ all -> 0x009f }
            r7.append(r0)     // Catch:{ all -> 0x009f }
            java.lang.String r8 = r5.toString()     // Catch:{ all -> 0x009f }
            r7.append(r8)     // Catch:{ all -> 0x009f }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x009f }
            i6.k.d(r2, r7)     // Catch:{ all -> 0x009f }
            r5.printStackTrace()     // Catch:{ all -> 0x009f }
            if (r4 == 0) goto L_0x008e
            r4.close()     // Catch:{ Exception -> 0x008c }
            goto L_0x008e
        L_0x008c:
            r4 = move-exception
            goto L_0x0094
        L_0x008e:
            if (r6 == 0) goto L_0x009a
            r6.close()     // Catch:{ Exception -> 0x008c }
            goto L_0x009a
        L_0x0094:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            goto L_0x003f
        L_0x009a:
            java.lang.String r10 = r3.toString()
            return r10
        L_0x009f:
            r3 = move-exception
            r5 = r4
        L_0x00a1:
            if (r5 == 0) goto L_0x00a9
            r5.close()     // Catch:{ Exception -> 0x00a7 }
            goto L_0x00a9
        L_0x00a7:
            r4 = move-exception
            goto L_0x00af
        L_0x00a9:
            if (r6 == 0) goto L_0x00cb
            r6.close()     // Catch:{ Exception -> 0x00a7 }
            goto L_0x00cb
        L_0x00af:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r1)
            r5.append(r10)
            r5.append(r0)
            java.lang.String r10 = r4.toString()
            r5.append(r10)
            java.lang.String r10 = r5.toString()
            i6.k.d(r2, r10)
        L_0x00cb:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.domain.c.e(java.lang.String):java.lang.String");
    }

    public static void f(SmartDomainData smartDomainData) {
        try {
            ConfigPreferences.m("user_config", "APP_DOMAIN_SMART_CONFIG", GsonHelper.a().toJson((Object) smartDomainData));
        } catch (Exception unused) {
            i6.d.c(ShareConstants.ACTION, "saveAppConfigFile Fail");
        }
    }
}
