package com.huawei.hms.framework.network.grs.local.model;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private String f38098a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, c> f38099b = new ConcurrentHashMap(16);

    public c a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return this.f38099b.get(str);
        }
        Logger.w("ApplicationBean", "In getServing(String serviceName), the serviceName is Empty or null");
        return null;
    }

    public String a() {
        return this.f38098a;
    }

    public void a(long j11) {
    }

    public void a(String str, c cVar) {
        if (!TextUtils.isEmpty(str) && cVar != null) {
            this.f38099b.put(str, cVar);
        }
    }

    public void b(String str) {
        this.f38098a = str;
    }
}
