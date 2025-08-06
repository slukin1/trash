package com.xiaomi.push;

import java.util.HashMap;
import java.util.Map;

public class at {

    /* renamed from: a  reason: collision with root package name */
    public int f51402a;

    /* renamed from: a  reason: collision with other field name */
    public String f2540a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f2541a = new HashMap();

    public String a() {
        return this.f2540a;
    }

    public String toString() {
        return String.format("resCode = %1$d, headers = %2$s, response = %3$s", new Object[]{Integer.valueOf(this.f51402a), this.f2541a.toString(), this.f2540a});
    }
}
