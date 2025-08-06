package com.huawei.agconnect.config.impl;

import android.content.Context;
import com.huawei.agconnect.config.ConfigReader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class m implements ConfigReader {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, String> f37516a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    private final k f37517b;

    public m(Context context, String str) {
        this.f37517b = new k(context, str);
    }

    public String getString(String str, String str2) {
        String str3 = this.f37516a.get(str);
        if (str3 != null) {
            return str3;
        }
        String a11 = this.f37517b.a(str, str2);
        if (a11 == null) {
            return str2;
        }
        this.f37516a.put(str, a11);
        return a11;
    }

    public String toString() {
        return "SecurityResourcesReader{mKey=, encrypt=true}";
    }
}
