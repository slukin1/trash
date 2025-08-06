package com.huawei.agconnect.config.impl;

import android.content.Context;
import android.util.Log;
import com.huawei.agconnect.AGCRoutePolicy;
import com.huawei.agconnect.JsonProcessingFactory;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.agconnect.config.ConfigReader;
import com.huawei.agconnect.config.LazyInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class c extends AGConnectServicesConfig {

    /* renamed from: a  reason: collision with root package name */
    private final Context f37486a;

    /* renamed from: b  reason: collision with root package name */
    private final String f37487b;

    /* renamed from: c  reason: collision with root package name */
    private LazyInputStream f37488c;

    /* renamed from: d  reason: collision with root package name */
    private volatile ConfigReader f37489d;

    /* renamed from: e  reason: collision with root package name */
    private final Object f37490e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private AGCRoutePolicy f37491f = AGCRoutePolicy.UNKNOWN;

    /* renamed from: g  reason: collision with root package name */
    private final Map<String, String> f37492g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    private volatile e f37493h;

    public c(Context context, String str) {
        this.f37486a = context;
        this.f37487b = str;
    }

    private static LazyInputStream a(Context context, final InputStream inputStream) {
        return new LazyInputStream(context) {
            public InputStream get(Context context) {
                return inputStream;
            }
        };
    }

    private static String a(String str) {
        int i11 = 0;
        if (str.length() > 0) {
            while (str.charAt(i11) == '/') {
                i11++;
            }
        }
        return '/' + str.substring(i11);
    }

    private void a() {
        Log.d("AGC_ConfigImpl", "initConfigReader");
        if (this.f37489d == null) {
            synchronized (this.f37490e) {
                if (this.f37489d == null) {
                    LazyInputStream lazyInputStream = this.f37488c;
                    if (lazyInputStream != null) {
                        this.f37489d = new i(lazyInputStream.loadInputStream(), "UTF-8");
                        this.f37488c.close();
                        this.f37488c = null;
                    } else {
                        this.f37489d = new m(this.f37486a, this.f37487b);
                    }
                    this.f37493h = new e(this.f37489d);
                }
                b();
            }
        }
    }

    private String b(String str) {
        JsonProcessingFactory.JsonProcessor jsonProcessor;
        Map<String, JsonProcessingFactory.JsonProcessor> processors = JsonProcessingFactory.getProcessors();
        if (processors.containsKey(str) && (jsonProcessor = processors.get(str)) != null) {
            return jsonProcessor.processOption(this);
        }
        return null;
    }

    private void b() {
        if (this.f37491f != AGCRoutePolicy.UNKNOWN) {
            return;
        }
        if (this.f37489d != null) {
            this.f37491f = Utils.getRoutePolicyFromJson(this.f37489d.getString("/region", (String) null), this.f37489d.getString("/agcgw/url", (String) null));
        } else {
            Log.w("AGConnectServiceConfig", "get route fail , config not ready");
        }
    }

    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    public boolean getBoolean(String str, boolean z11) {
        return Boolean.parseBoolean(getString(str, String.valueOf(z11)));
    }

    public Context getContext() {
        return this.f37486a;
    }

    public String getIdentifier() {
        return Utils.DEFAULT_NAME;
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
        return this.f37487b;
    }

    public AGCRoutePolicy getRoutePolicy() {
        Log.d("AGC_ConfigImpl", "getRoutePolicy");
        if (this.f37491f == null) {
            this.f37491f = AGCRoutePolicy.UNKNOWN;
        }
        AGCRoutePolicy aGCRoutePolicy = this.f37491f;
        AGCRoutePolicy aGCRoutePolicy2 = AGCRoutePolicy.UNKNOWN;
        if (aGCRoutePolicy == aGCRoutePolicy2 && this.f37489d == null) {
            a();
        }
        AGCRoutePolicy aGCRoutePolicy3 = this.f37491f;
        return aGCRoutePolicy3 == null ? aGCRoutePolicy2 : aGCRoutePolicy3;
    }

    public String getString(String str) {
        return getString(str, (String) null);
    }

    public String getString(String str, String str2) {
        Objects.requireNonNull(str, "path must not be null.");
        if (this.f37489d == null) {
            a();
        }
        String a11 = a(str);
        String str3 = this.f37492g.get(a11);
        if (str3 != null) {
            return str3;
        }
        String b11 = b(a11);
        if (b11 != null) {
            return b11;
        }
        String string = this.f37489d.getString(a11, str2);
        return e.a(string) ? this.f37493h.decrypt(string, str2) : string;
    }

    public void overlayWith(LazyInputStream lazyInputStream) {
        this.f37488c = lazyInputStream;
    }

    public void overlayWith(InputStream inputStream) {
        overlayWith(a(this.f37486a, inputStream));
    }

    public void setParam(String str, String str2) {
        this.f37492g.put(Utils.fixPath(str), str2);
    }

    public void setRoutePolicy(AGCRoutePolicy aGCRoutePolicy) {
        this.f37491f = aGCRoutePolicy;
    }
}
