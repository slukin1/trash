package com.huawei.agconnect.config.impl;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.agconnect.AGConnectApp;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.CustomAuthProvider;
import com.huawei.agconnect.CustomCredentialsProvider;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.agconnect.core.a.b;
import java.util.HashMap;
import java.util.Map;

public class a extends AGConnectApp {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, AGConnectApp> f37473a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private static final Object f37474b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static String f37475c;

    /* renamed from: d  reason: collision with root package name */
    private AGConnectServicesConfig f37476d;

    private a(Context context, String str) {
        this.f37476d = AGConnectServicesConfig.fromContext(context, str);
    }

    public static AGConnectApp a() {
        return a(f37475c);
    }

    public static AGConnectApp a(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        String packageName = context.getPackageName();
        f37475c = packageName;
        return a(context, packageName);
    }

    public static AGConnectApp a(Context context, String str) {
        AGConnectApp aGConnectApp;
        if (!TextUtils.isEmpty(str)) {
            synchronized (f37474b) {
                Map<String, AGConnectApp> map = f37473a;
                aGConnectApp = map.get(str);
                if (aGConnectApp == null) {
                    map.put(str, new a(context, str));
                }
            }
            return aGConnectApp;
        }
        throw new IllegalArgumentException("packageName can not be empty");
    }

    public static AGConnectApp a(String str) {
        AGConnectApp aGConnectApp;
        synchronized (f37474b) {
            aGConnectApp = f37473a.get(str);
            if (aGConnectApp == null) {
                throw new IllegalStateException("you should call AGConnectApp.initialize first");
            }
        }
        return aGConnectApp;
    }

    public void setApiKey(String str) {
        this.f37476d.setParam("/client/api_key", str);
    }

    public void setAppId(String str) {
        this.f37476d.setParam("/client/app_id", str);
    }

    public void setClientId(String str) {
        this.f37476d.setParam("/client/client_id", str);
    }

    public void setClientSecret(String str) {
        this.f37476d.setParam("/client/client_secret", str);
    }

    public void setCpId(String str) {
        this.f37476d.setParam("/client/cp_id", str);
    }

    public void setCustomAuthProvider(CustomAuthProvider customAuthProvider) {
        ((b) AGConnectInstance.getInstance()).a(customAuthProvider);
    }

    public void setCustomCredentialsProvider(CustomCredentialsProvider customCredentialsProvider) {
        ((b) AGConnectInstance.getInstance()).a(customCredentialsProvider);
    }

    public void setParam(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.f37476d.setParam(str, str2);
            return;
        }
        throw new IllegalArgumentException("path can not be empty");
    }

    public void setProductId(String str) {
        this.f37476d.setParam("/client/product_id", str);
    }
}
