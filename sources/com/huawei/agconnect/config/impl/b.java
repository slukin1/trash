package com.huawei.agconnect.config.impl;

import android.content.Context;
import com.huawei.agconnect.AGCRoutePolicy;
import com.huawei.agconnect.AGConnectOptions;
import com.huawei.agconnect.JsonProcessingFactory;
import com.huawei.agconnect.config.ConfigReader;
import com.huawei.agconnect.core.Service;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class b implements AGConnectOptions {

    /* renamed from: a  reason: collision with root package name */
    private final String f37477a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f37478b;

    /* renamed from: c  reason: collision with root package name */
    private final String f37479c;

    /* renamed from: d  reason: collision with root package name */
    private final AGCRoutePolicy f37480d;

    /* renamed from: e  reason: collision with root package name */
    private final ConfigReader f37481e;

    /* renamed from: f  reason: collision with root package name */
    private final e f37482f;

    /* renamed from: g  reason: collision with root package name */
    private final Map<String, String> f37483g;

    /* renamed from: h  reason: collision with root package name */
    private final List<Service> f37484h;

    /* renamed from: i  reason: collision with root package name */
    private final Map<String, String> f37485i = new HashMap();

    public b(Context context, String str, AGCRoutePolicy aGCRoutePolicy, InputStream inputStream, Map<String, String> map, List<Service> list, String str2) {
        context = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.f37478b = context;
        str = str == null ? context.getPackageName() : str;
        this.f37479c = str;
        if (inputStream != null) {
            this.f37481e = new i(inputStream, str);
            Utils.closeQuietly(inputStream);
        } else {
            this.f37481e = new m(context, str);
        }
        this.f37482f = new e(this.f37481e);
        AGCRoutePolicy aGCRoutePolicy2 = AGCRoutePolicy.UNKNOWN;
        if (aGCRoutePolicy == aGCRoutePolicy2 || !"1.0".equals(this.f37481e.getString("/configuration_version", (String) null))) {
            this.f37480d = (aGCRoutePolicy == null || aGCRoutePolicy == aGCRoutePolicy2) ? Utils.getRoutePolicyFromJson(this.f37481e.getString("/region", (String) null), this.f37481e.getString("/agcgw/url", (String) null)) : aGCRoutePolicy;
            this.f37483g = Utils.fixKeyPathMap(map);
            this.f37484h = list;
            this.f37477a = str2 == null ? b() : str2;
            return;
        }
        throw new RuntimeException("The file version does not match,please download the latest agconnect-services.json from the AGC website.");
    }

    private String a(String str) {
        Map<String, JsonProcessingFactory.JsonProcessor> processors = JsonProcessingFactory.getProcessors();
        if (!processors.containsKey(str)) {
            return null;
        }
        if (this.f37485i.containsKey(str)) {
            return this.f37485i.get(str);
        }
        JsonProcessingFactory.JsonProcessor jsonProcessor = processors.get(str);
        if (jsonProcessor == null) {
            return null;
        }
        String processOption = jsonProcessor.processOption(this);
        this.f37485i.put(str, processOption);
        return processOption;
    }

    private String b() {
        return String.valueOf(("{packageName='" + this.f37479c + '\'' + ", routePolicy=" + this.f37480d + ", reader=" + this.f37481e.toString().hashCode() + ", customConfigMap=" + new JSONObject(this.f37483g).toString().hashCode() + '}').hashCode());
    }

    public List<Service> a() {
        return this.f37484h;
    }

    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    public boolean getBoolean(String str, boolean z11) {
        return Boolean.parseBoolean(getString(str, String.valueOf(z11)));
    }

    public Context getContext() {
        return this.f37478b;
    }

    public String getIdentifier() {
        return this.f37477a;
    }

    public int getInt(String str) {
        return getInt(str, 0);
    }

    public int getInt(String str, int i11) {
        try {
            return Integer.parseInt(getString(str, String.valueOf(i11)));
        } catch (NumberFormatException unused) {
            return i11;
        }
    }

    public String getPackageName() {
        return this.f37479c;
    }

    public AGCRoutePolicy getRoutePolicy() {
        AGCRoutePolicy aGCRoutePolicy = this.f37480d;
        return aGCRoutePolicy == null ? AGCRoutePolicy.UNKNOWN : aGCRoutePolicy;
    }

    public String getString(String str) {
        return getString(str, (String) null);
    }

    public String getString(String str, String str2) {
        if (str == null) {
            return str2;
        }
        String fixPath = Utils.fixPath(str);
        String str3 = this.f37483g.get(fixPath);
        if (str3 != null) {
            return str3;
        }
        String a11 = a(fixPath);
        if (a11 != null) {
            return a11;
        }
        String string = this.f37481e.getString(fixPath, str2);
        return e.a(string) ? this.f37482f.decrypt(string, str2) : string;
    }
}
