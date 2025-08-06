package com.huawei.hms.framework.network.grs.local.model;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private String f38102a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, d> f38103b = new ConcurrentHashMap(16);

    /* renamed from: c  reason: collision with root package name */
    private List<b> f38104c = new ArrayList(16);

    public d a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return this.f38103b.get(str);
        }
        Logger.w("Service", "In servings.getServing(String groupId), the groupId is Empty or null");
        return null;
    }

    public List<b> a() {
        return this.f38104c;
    }

    public void a(String str, d dVar) {
        if (!TextUtils.isEmpty(str) && dVar != null) {
            this.f38103b.put(str, dVar);
        }
    }

    public void a(List<b> list) {
        this.f38104c = list;
    }

    public String b() {
        return this.f38102a;
    }

    public void b(String str) {
    }

    public void c(String str) {
        this.f38102a = str;
    }
}
