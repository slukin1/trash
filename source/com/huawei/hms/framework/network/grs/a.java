package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.e.c;
import com.huawei.hms.framework.network.grs.g.d;
import com.huawei.hms.framework.network.grs.g.g;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final String f37969e = "a";

    /* renamed from: a  reason: collision with root package name */
    private final GrsBaseInfo f37970a;

    /* renamed from: b  reason: collision with root package name */
    private com.huawei.hms.framework.network.grs.e.a f37971b;

    /* renamed from: c  reason: collision with root package name */
    private g f37972c;

    /* renamed from: d  reason: collision with root package name */
    private c f37973d;

    /* renamed from: com.huawei.hms.framework.network.grs.a$a  reason: collision with other inner class name */
    public static class C0515a implements b {

        /* renamed from: a  reason: collision with root package name */
        public String f37974a;

        /* renamed from: b  reason: collision with root package name */
        public Map<String, String> f37975b;

        /* renamed from: c  reason: collision with root package name */
        public IQueryUrlsCallBack f37976c;

        /* renamed from: d  reason: collision with root package name */
        public Context f37977d;

        /* renamed from: e  reason: collision with root package name */
        public GrsBaseInfo f37978e;

        /* renamed from: f  reason: collision with root package name */
        public com.huawei.hms.framework.network.grs.e.a f37979f;

        public C0515a(String str, Map<String, String> map, IQueryUrlsCallBack iQueryUrlsCallBack, Context context, GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.e.a aVar) {
            this.f37974a = str;
            this.f37975b = map;
            this.f37976c = iQueryUrlsCallBack;
            this.f37977d = context;
            this.f37978e = grsBaseInfo;
            this.f37979f = aVar;
        }

        public void a() {
            Map<String, String> map = this.f37975b;
            if (map != null && !map.isEmpty()) {
                Logger.i(a.f37969e, "GrsClientManager.ayncGetGrsUrls: Return [%s] Urls: %s", this.f37974a, StringUtils.anonymizeMessage(new JSONObject(this.f37975b).toString()));
                this.f37976c.onCallBackSuccess(this.f37975b);
            } else if (this.f37975b == null) {
                Logger.i(a.f37969e, "GrsClientManager.ayncGetGrsUrls: Get URL from Local JSON File");
                Map a11 = com.huawei.hms.framework.network.grs.f.b.a(this.f37977d.getPackageName()).a(this.f37977d, this.f37979f, this.f37978e, this.f37974a, true);
                if (a11 == null || a11.isEmpty()) {
                    Logger.e(a.f37969e, "The serviceName[%s] is not configured in the JSON configuration files to reveal all the details", this.f37974a);
                }
                if (a11 == null) {
                    a11 = new ConcurrentHashMap();
                }
                Logger.i(a.f37969e, "GrsClientManager.ayncGetGrsUrls: Return [%s] Urls: %s", this.f37974a, StringUtils.anonymizeMessage(new JSONObject(a11).toString()));
                this.f37976c.onCallBackSuccess(a11);
            } else {
                Logger.i(a.f37969e, "GrsClientManager.ayncGetGrsUrls：Return [%s] Urls is Empty", this.f37974a);
                this.f37976c.onCallBackFail(-3);
            }
        }

        public void a(d dVar) {
            IQueryUrlsCallBack iQueryUrlsCallBack;
            String j11 = dVar.j();
            Map<String, String> a11 = a.a(j11, this.f37974a);
            if (!a11.isEmpty()) {
                Logger.i(a.f37969e, "GrsClientManager.ayncGetGrsUrls: Get URL from Current Called GRS Server Return [%s] Urls: %s", this.f37974a, StringUtils.anonymizeMessage(new JSONObject(a11).toString()));
                iQueryUrlsCallBack = this.f37976c;
            } else {
                Map<String, String> map = this.f37975b;
                if (map != null && !map.isEmpty()) {
                    Logger.i(a.f37969e, "GrsClientManager.ayncGetGrsUrls: Return [%s][%s] Url: %s", this.f37974a, StringUtils.anonymizeMessage(new JSONObject(this.f37975b).toString()));
                    iQueryUrlsCallBack = this.f37976c;
                    a11 = this.f37975b;
                } else if (this.f37975b == null) {
                    if (!TextUtils.isEmpty(j11)) {
                        Logger.e(a.f37969e, "The serviceName[%s] is not configured on the GRS server.", this.f37974a);
                    }
                    Logger.i(a.f37969e, "GrsClientManager.ayncGetGrsUrls: Get URL from Local JSON File");
                    Map a12 = com.huawei.hms.framework.network.grs.f.b.a(this.f37977d.getPackageName()).a(this.f37977d, this.f37979f, this.f37978e, this.f37974a, true);
                    if (a12 == null || a12.isEmpty()) {
                        Logger.e(a.f37969e, "The serviceName[%s] is not configured in the JSON configuration files to reveal all the details", this.f37974a);
                    }
                    if (a12 == null) {
                        a12 = new ConcurrentHashMap();
                    }
                    Logger.i(a.f37969e, "GrsClientManager.ayncGetGrsUrls: Return [%s] Urls: %s", this.f37974a, StringUtils.anonymizeMessage(new JSONObject(a12).toString()));
                    this.f37976c.onCallBackSuccess(a12);
                    return;
                } else {
                    Logger.i(a.f37969e, "GrsClientManager.ayncGetGrsUrls：Return [%s] Urls is Empty", this.f37974a);
                    this.f37976c.onCallBackFail(-5);
                    return;
                }
            }
            iQueryUrlsCallBack.onCallBackSuccess(a11);
        }
    }

    public static class b implements b {

        /* renamed from: a  reason: collision with root package name */
        public String f37980a;

        /* renamed from: b  reason: collision with root package name */
        public String f37981b;

        /* renamed from: c  reason: collision with root package name */
        public IQueryUrlCallBack f37982c;

        /* renamed from: d  reason: collision with root package name */
        public String f37983d;

        /* renamed from: e  reason: collision with root package name */
        public Context f37984e;

        /* renamed from: f  reason: collision with root package name */
        public GrsBaseInfo f37985f;

        /* renamed from: g  reason: collision with root package name */
        public com.huawei.hms.framework.network.grs.e.a f37986g;

        public b(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack, String str3, Context context, GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.e.a aVar) {
            this.f37980a = str;
            this.f37981b = str2;
            this.f37982c = iQueryUrlCallBack;
            this.f37983d = str3;
            this.f37984e = context;
            this.f37985f = grsBaseInfo;
            this.f37986g = aVar;
        }

        public void a() {
            if (!TextUtils.isEmpty(this.f37983d)) {
                Logger.i(a.f37969e, "GrsClientManager.ayncGetGrsUrl: Return [%s][%s] Url: %s", this.f37980a, this.f37981b, StringUtils.anonymizeMessage(this.f37983d));
                this.f37982c.onCallBackSuccess(this.f37983d);
            } else if (TextUtils.isEmpty(this.f37983d)) {
                Logger.i(a.f37969e, "GrsClientManager.ayncGetGrsUrl: Get URL from Local JSON File");
                String a11 = com.huawei.hms.framework.network.grs.f.b.a(this.f37984e.getPackageName()).a(this.f37984e, this.f37986g, this.f37985f, this.f37980a, this.f37981b, true);
                if (a11 == null || a11.isEmpty()) {
                    Logger.e(a.f37969e, "The serviceName[%s][%s] is not configured in the JSON configuration files to reveal all the details", this.f37980a, this.f37981b);
                }
                Logger.i(a.f37969e, "GrsClientManager.ayncGetGrsUrl: Return [%s][%s] Url: %s", this.f37980a, this.f37981b, StringUtils.anonymizeMessage(a11));
                this.f37982c.onCallBackSuccess(a11);
            } else {
                Logger.i(a.f37969e, "GrsClientManager.ayncGetGrsUrl：Return [%s][%s] Url is Empty", this.f37980a, this.f37981b);
                this.f37982c.onCallBackFail(-3);
            }
        }

        public void a(d dVar) {
            IQueryUrlCallBack iQueryUrlCallBack;
            String str;
            String j11 = dVar.j();
            Map<String, String> a11 = a.a(j11, this.f37980a);
            if (a11.containsKey(this.f37981b)) {
                String a12 = a.f37969e;
                String str2 = this.f37981b;
                Logger.i(a12, "GrsClientManager.ayncGetGrsUrl: Get URL from Current Called GRS Server, Return [%s][%s] Url: %s", this.f37980a, str2, StringUtils.anonymizeMessage(a11.get(str2)));
                iQueryUrlCallBack = this.f37982c;
                str = a11.get(this.f37981b);
            } else if (!TextUtils.isEmpty(this.f37983d)) {
                String a13 = a.f37969e;
                String str3 = this.f37981b;
                Logger.i(a13, "GrsClientManager.ayncGetGrsUrl: Return [%s][%s] Url: %s", this.f37980a, str3, StringUtils.anonymizeMessage(a11.get(str3)));
                iQueryUrlCallBack = this.f37982c;
                str = this.f37983d;
            } else if (TextUtils.isEmpty(this.f37983d)) {
                if (!TextUtils.isEmpty(j11)) {
                    Logger.e(a.f37969e, "The serviceName[%s][%s] is not configured on the GRS server.", this.f37980a, this.f37981b);
                }
                Logger.i(a.f37969e, "GrsClientManager.ayncGetGrsUrl: Get URL from Local JSON File");
                String a14 = com.huawei.hms.framework.network.grs.f.b.a(this.f37984e.getPackageName()).a(this.f37984e, this.f37986g, this.f37985f, this.f37980a, this.f37981b, true);
                if (a14 == null || a14.isEmpty()) {
                    Logger.e(a.f37969e, "The serviceName[%s][%s] is not configured in the JSON configuration files to reveal all the details", this.f37980a, this.f37981b);
                }
                Logger.i(a.f37969e, "GrsClientManager.ayncGetGrsUrl: Return [%s][%s] Url: %s", this.f37980a, this.f37981b, StringUtils.anonymizeMessage(a14));
                this.f37982c.onCallBackSuccess(a14);
                return;
            } else {
                Logger.i(a.f37969e, "GrsClientManager.ayncGetGrsUrl：Return [%s][%s] Url is Empty", this.f37980a, this.f37981b);
                this.f37982c.onCallBackFail(-5);
                return;
            }
            iQueryUrlCallBack.onCallBackSuccess(str);
        }
    }

    public a(GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.e.a aVar, g gVar, c cVar) {
        this.f37970a = grsBaseInfo;
        this.f37971b = aVar;
        this.f37972c = gVar;
        this.f37973d = cVar;
    }

    public static CountryCodeBean a(Context context, boolean z11) {
        return new CountryCodeBean(context, z11);
    }

    public static Map<String, Map<String, String>> a(String str) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
        if (TextUtils.isEmpty(str)) {
            Logger.v(f37969e, "isSpExpire jsonValue is null.");
            return concurrentHashMap;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                if (!TextUtils.isEmpty(next)) {
                    concurrentHashMap.put(next, a(jSONObject2));
                }
            }
            return concurrentHashMap;
        } catch (JSONException e11) {
            Logger.w(f37969e, "getServicesUrlsMap occur a JSONException: %s", StringUtils.anonymizeMessage(e11.getMessage()));
            return concurrentHashMap;
        }
    }

    private Map<String, String> a(String str, com.huawei.hms.framework.network.grs.e.b bVar, Context context) {
        Map<String, String> a11 = this.f37971b.a(this.f37970a, str, bVar, context);
        if (a11 == null || a11.isEmpty()) {
            Map<String, String> a12 = com.huawei.hms.framework.network.grs.f.b.a(context.getPackageName()).a(context, this.f37971b, this.f37970a, str, false);
            Logger.i(f37969e, "GrsClientManager.getUrlsLocal: Get URL from Local JSON File");
            return a12 != null ? a12 : new HashMap();
        }
        Logger.i(f37969e, "GrsClientManager.getUrlsLocal: Get URL from GRS Server Cache");
        return a11;
    }

    public static Map<String, String> a(String str, String str2) {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            Logger.w(f37969e, "isSpExpire jsonValue from server is null.");
            return hashMap;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.has(str2) ? jSONObject.getJSONObject(str2) : null;
            if (jSONObject2 == null) {
                Logger.w(f37969e, "getServiceNameUrls: paser null from server json data by {%s}.", str2);
                return hashMap;
            }
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject2.get(next).toString());
            }
            return hashMap;
        } catch (JSONException e11) {
            Logger.w(f37969e, "Method{getServiceNameUrls} query url from SP occur an JSONException: %s", StringUtils.anonymizeMessage(e11.getMessage()));
            return hashMap;
        }
    }

    public static Map<String, String> a(JSONObject jSONObject) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String obj = jSONObject.get(next).toString();
                if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(obj)) {
                    concurrentHashMap.put(next, obj);
                }
            }
            return concurrentHashMap;
        } catch (JSONException e11) {
            Logger.w(f37969e, "getServiceUrls occur a JSONException: %s", StringUtils.anonymizeMessage(e11.getMessage()));
            return concurrentHashMap;
        }
    }

    public String a(Context context, String str, int i11) {
        d a11 = this.f37972c.a(new com.huawei.hms.framework.network.grs.g.j.c(this.f37970a, context), str, this.f37973d, i11);
        return a11 == null ? "" : a11.m() ? this.f37971b.a().a(this.f37970a.getGrsParasKey(true, true, context), "") : a11.j();
    }

    public String a(String str, String str2, Context context, int i11) {
        String str3 = str;
        String str4 = str2;
        Context context2 = context;
        com.huawei.hms.framework.network.grs.e.b bVar = new com.huawei.hms.framework.network.grs.e.b();
        String str5 = a(str3, bVar, context2).get(str4);
        if (!bVar.a() || TextUtils.isEmpty(str5)) {
            String a11 = a(context2, str3, i11);
            String str6 = a(a11, str3).get(str4);
            if (!TextUtils.isEmpty(str6)) {
                Logger.i(f37969e, "GrsClientManager.synGetGrsUrl: Get URL from Current Called GRS Server, Return [%s][%s] Url: %s", str3, str4, StringUtils.anonymizeMessage(str6));
                return str6;
            }
            if (TextUtils.isEmpty(str5)) {
                if (!TextUtils.isEmpty(a11)) {
                    Logger.e(f37969e, "The serviceName[%s][%s] is not configured on the GRS server.", str3, str4);
                }
                String str7 = f37969e;
                Logger.i(str7, "GrsClientManager.synGetGrsUrl: Get URL from Local JSON File.");
                str5 = com.huawei.hms.framework.network.grs.f.b.a(context.getPackageName()).a(context, this.f37971b, this.f37970a, str, str2, true);
                if (str5 == null || str5.isEmpty()) {
                    Logger.e(str7, "The serviceName[%s][%s] is not configured in the JSON configuration files to reveal all the details", str3, str4);
                }
            }
            Logger.i(f37969e, "GrsClientManager.synGetGrsUrl: Return [%s][%s] Url: %s", str3, str4, StringUtils.anonymizeMessage(str5));
            return str5;
        }
        Logger.i(f37969e, "GrsClientManager.synGetGrsUrl: Return [%s][%s] Url: %s", str3, str4, StringUtils.anonymizeMessage(str5));
        return str5;
    }

    public Map<String, String> a(String str, Context context, int i11) {
        com.huawei.hms.framework.network.grs.e.b bVar = new com.huawei.hms.framework.network.grs.e.b();
        Map<String, String> a11 = a(str, bVar, context);
        if (!bVar.a() || a11.isEmpty()) {
            String a12 = a(context, str, i11);
            Map<String, String> a13 = a(a12, str);
            if (!a13.isEmpty()) {
                Logger.i(f37969e, "GrsClientManager.synGetGrsUrls: Get URL from Current Called GRS Server Return [%s] Urls: %s", str, StringUtils.anonymizeMessage(new JSONObject(a13).toString()));
                return a13;
            }
            if (a11.isEmpty()) {
                if (!TextUtils.isEmpty(a12)) {
                    Logger.e(f37969e, "The serviceName[%s] is not configured on the GRS server.", str);
                }
                String str2 = f37969e;
                Logger.i(str2, "GrsClientManager.synGetGrsUrls: Get URL from Local JSON File.");
                a11 = com.huawei.hms.framework.network.grs.f.b.a(context.getPackageName()).a(context, this.f37971b, this.f37970a, str, true);
                if (a11 == null || a11.isEmpty()) {
                    Logger.e(str2, "The serviceName[%s] is not configured in the JSON configuration files to reveal all the details", str);
                }
            }
            String str3 = f37969e;
            Object[] objArr = new Object[2];
            objArr[0] = str;
            objArr[1] = StringUtils.anonymizeMessage(a11 != null ? new JSONObject(a11).toString() : "");
            Logger.i(str3, "GrsClientManager.synGetGrsUrls: Return [%s] Urls: %s", objArr);
            return a11;
        }
        Logger.i(f37969e, "Return [%s] Urls: %s", str, StringUtils.anonymizeMessage(new JSONObject(a11).toString()));
        return a11;
    }

    public void a(String str, IQueryUrlsCallBack iQueryUrlsCallBack, Context context, int i11) {
        com.huawei.hms.framework.network.grs.e.b bVar = new com.huawei.hms.framework.network.grs.e.b();
        Map<String, String> a11 = a(str, bVar, context);
        if (!bVar.a()) {
            com.huawei.hms.framework.network.grs.g.j.c cVar = new com.huawei.hms.framework.network.grs.g.j.c(this.f37970a, context);
            this.f37972c.a(cVar, new C0515a(str, a11, iQueryUrlsCallBack, context, this.f37970a, this.f37971b), str, this.f37973d, i11);
        } else if (a11.isEmpty()) {
            Logger.i(f37969e, "GrsClientManager.ayncGetGrsUrls：Return [%s] Urls is Empty", str);
            iQueryUrlsCallBack.onCallBackFail(-5);
        } else {
            String str2 = f37969e;
            Logger.i(str2, "GrsClientManager.ayncGetGrsUrls：Return [%s] Urls: %s", str, StringUtils.anonymizeMessage(new JSONObject(a11).toString()));
            Logger.i(str2, "ayncGetGrsUrls: %s", StringUtils.anonymizeMessage(new JSONObject(a11).toString()));
            iQueryUrlsCallBack.onCallBackSuccess(a11);
        }
    }

    public void a(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack, Context context, int i11) {
        String str3 = str;
        String str4 = str2;
        IQueryUrlCallBack iQueryUrlCallBack2 = iQueryUrlCallBack;
        Context context2 = context;
        com.huawei.hms.framework.network.grs.e.b bVar = new com.huawei.hms.framework.network.grs.e.b();
        String str5 = a(str, bVar, context2).get(str2);
        if (!bVar.a()) {
            com.huawei.hms.framework.network.grs.g.j.c cVar = new com.huawei.hms.framework.network.grs.g.j.c(this.f37970a, context2);
            g gVar = this.f37972c;
            b bVar2 = new b(str, str2, iQueryUrlCallBack, str5, context, this.f37970a, this.f37971b);
            gVar.a(cVar, bVar2, str, this.f37973d, i11);
        } else if (TextUtils.isEmpty(str5)) {
            Logger.i(f37969e, "GrsClientManager.ayncGetGrsUrl：Return [%s][%s] Url is Empty", str3, str4);
            iQueryUrlCallBack2.onCallBackFail(-5);
        } else {
            Logger.i(f37969e, "GrsClientManager.ayncGetGrsUrl：Return [%s][%s] Url: %s", str3, str4, StringUtils.anonymizeMessage(str5));
            iQueryUrlCallBack2.onCallBackSuccess(str5);
        }
    }
}
