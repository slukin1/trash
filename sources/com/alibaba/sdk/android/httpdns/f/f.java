package com.alibaba.sdk.android.httpdns.f;

import com.alibaba.sdk.android.httpdns.RequestIpType;
import com.alibaba.sdk.android.httpdns.log.HttpDnsLog;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.huawei.hms.framework.common.ContainerUtils;
import com.xiaomi.mipush.sdk.Constants;
import e7.s;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import q2.e;
import t2.c;

public class f {

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f14589a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.alibaba.sdk.android.httpdns.RequestIpType[] r0 = com.alibaba.sdk.android.httpdns.RequestIpType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f14589a = r0
                com.alibaba.sdk.android.httpdns.RequestIpType r1 = com.alibaba.sdk.android.httpdns.RequestIpType.v6     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f14589a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.alibaba.sdk.android.httpdns.RequestIpType r1 = com.alibaba.sdk.android.httpdns.RequestIpType.both     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.f.f.a.<clinit>():void");
        }
    }

    public static String a(RequestIpType requestIpType) {
        int i11 = a.f14589a[requestIpType.ordinal()];
        return i11 != 1 ? i11 != 2 ? "" : "&query=4,6" : "&query=6";
    }

    public static String b(HashMap<String, String> hashMap) {
        if (hashMap == null || hashMap.size() == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry next : hashMap.entrySet()) {
            sb2.append(ContainerUtils.FIELD_DELIMITER);
            sb2.append((String) next.getKey());
            sb2.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb2.append((String) next.getValue());
        }
        return sb2.toString();
    }

    public static String c(Map<String, String> map) {
        boolean z11;
        boolean z12;
        StringBuilder sb2 = new StringBuilder();
        if (map != null) {
            Iterator<Map.Entry<String, String>> it2 = map.entrySet().iterator();
            while (true) {
                z11 = false;
                z12 = true;
                if (!it2.hasNext()) {
                    z11 = true;
                    break;
                }
                Map.Entry next = it2.next();
                sb2.append("&sdns-");
                sb2.append((String) next.getKey());
                sb2.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb2.append(URLEncoder.encode((String) next.getValue(), "UTF-8"));
                if (g((String) next.getKey())) {
                    if (!i((String) next.getValue())) {
                        HttpDnsLog.c("设置自定义参数失败，自定义value不合法：" + ((String) next.getValue()));
                        z12 = false;
                        z11 = true;
                        break;
                    }
                } else {
                    HttpDnsLog.c("设置自定义参数失败，自定义key不合法：" + ((String) next.getKey()));
                    break;
                }
            }
            if (z11 && z12) {
                String sb3 = sb2.toString();
                if (sb3.getBytes("UTF-8").length <= 1000) {
                    return sb3;
                }
                HttpDnsLog.c("设置自定义参数失败，自定义参数过长");
            }
        }
        return "";
    }

    public static String d(q2.a aVar, String str, RequestIpType requestIpType, Map<String, String> map, HashMap<String, String> hashMap) {
        String str2;
        String a11 = a(requestIpType);
        try {
            str2 = c(map);
        } catch (UnsupportedEncodingException e11) {
            e11.printStackTrace();
            str2 = null;
        }
        String b11 = b(hashMap);
        String str3 = (hashMap == null || !hashMap.keySet().contains(s.f70071a)) ? GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG : "sign_d";
        return "/" + aVar.s() + "/" + str3 + "?host=" + str + "&sdk=android_" + "2.2.2" + a11 + h() + str2 + b11;
    }

    public static c e(q2.a aVar, String str, RequestIpType requestIpType, Map<String, String> map, String str2, Map<String, String> map2, e eVar) {
        HashMap hashMap;
        if (str2 != null) {
            hashMap = new HashMap();
            if (map2 != null) {
                hashMap.putAll(map2);
            }
            if (map != null) {
                hashMap.putAll(map);
            }
        } else {
            hashMap = null;
        }
        return new c(aVar.m(), aVar.e().i(), aVar.e().m(), d(aVar, str, requestIpType, hashMap, eVar.a(str)), aVar.v());
    }

    public static c f(q2.a aVar, ArrayList<String> arrayList, RequestIpType requestIpType, e eVar) {
        String a11 = a(requestIpType);
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            if (i11 != 0) {
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            sb2.append(arrayList.get(i11));
        }
        String sb3 = sb2.toString();
        HashMap<String, String> a12 = eVar.a(sb3);
        String str = (a12 == null || !a12.keySet().contains(s.f70071a)) ? "resolve" : "sign_resolve";
        return new c(aVar.m(), aVar.e().i(), aVar.e().m(), "/" + aVar.s() + "/" + str + "?host=" + sb3 + "&sdk=android_" + "2.2.2" + a11 + h() + b(a12), aVar.v());
    }

    public static boolean g(String str) {
        return str.matches("[a-zA-Z0-9\\-_]+");
    }

    public static String h() {
        String b11 = v2.a.a().b();
        if (b11 == null) {
            return "";
        }
        return "&sid=" + b11;
    }

    public static boolean i(String str) {
        return str.matches("[a-zA-Z0-9\\-_=]+");
    }
}
