package com.adjust.sdk.sig;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;

public class Signer {

    /* renamed from: a  reason: collision with root package name */
    public boolean f13974a = false;

    /* renamed from: b  reason: collision with root package name */
    public d f13975b;

    /* renamed from: c  reason: collision with root package name */
    public a f13976c;

    /* renamed from: d  reason: collision with root package name */
    public c f13977d;

    public static String getVersion() {
        return "3.47.0";
    }

    public final synchronized void a() {
        if (!this.f13974a) {
            this.f13975b = new d();
            this.f13977d = new c(Build.VERSION.SDK_INT);
            this.f13976c = new NativeLibHelper();
            this.f13974a = true;
        }
    }

    public synchronized void onResume() {
        a();
        d dVar = this.f13975b;
        a aVar = this.f13976c;
        dVar.getClass();
        if (!d.f13979a) {
            ((NativeLibHelper) aVar).a();
        }
    }

    public synchronized void sign(Context context, Map<String, String> map, String str, String str2) {
        a();
        d dVar = this.f13975b;
        c cVar = this.f13977d;
        a aVar = this.f13976c;
        dVar.getClass();
        d.a(context, cVar, aVar, map, str, str2);
    }

    public synchronized void sign(Context context, Map<String, String> map, Map<String, String> map2, Map<String, String> map3) {
        a();
        d dVar = this.f13975b;
        c cVar = this.f13977d;
        a aVar = this.f13976c;
        dVar.getClass();
        if (!(map == null || map.size() == 0 || map2 == null)) {
            if (map3 != null) {
                HashMap hashMap = new HashMap();
                d.a(map.keySet(), map, hashMap);
                String str = map2.get("activity_kind");
                String str2 = map2.get("client_sdk");
                if (!"b".equals(map2.get("a"))) {
                    d.a(context, cVar, aVar, hashMap, str, str2);
                    if (hashMap.containsKey(TUIConstants.TUICalling.PARAM_NAME_AUDIO_SIGNATURE) && hashMap.containsKey("adj_signing_id") && hashMap.containsKey("headers_id") && hashMap.containsKey("algorithm")) {
                        if (hashMap.containsKey("native_version")) {
                            Locale locale = Locale.US;
                            String str3 = "algorithm=\"" + ((String) hashMap.get("algorithm")) + "\"";
                            map3.put("authorization", "Signature " + ("signature=\"" + ((String) hashMap.get(TUIConstants.TUICalling.PARAM_NAME_AUDIO_SIGNATURE)) + "\"") + Constants.ACCEPT_TIME_SEPARATOR_SP + ("adj_signing_id=\"" + ((String) hashMap.get("adj_signing_id")) + "\"") + Constants.ACCEPT_TIME_SEPARATOR_SP + str3 + Constants.ACCEPT_TIME_SEPARATOR_SP + ("headers_id=\"" + ((String) hashMap.get("headers_id")) + "\"") + Constants.ACCEPT_TIME_SEPARATOR_SP + ("native_version=\"" + ((String) hashMap.get("native_version")) + "\""));
                        }
                    }
                    Log.e("SignerInstance", "sign: Signature generation failed. Exiting...");
                }
                d.a(map.keySet(), map, map3);
                d.a(new HashSet(Arrays.asList(new String[]{"network_payload", "endpoint"})), map2, map3);
            }
        }
        Log.e("SignerInstance", "sign: One or more parameters are null");
    }
}
