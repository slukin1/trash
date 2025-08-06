package com.amazonaws.regions;

import java.util.HashMap;
import java.util.Map;

public final class Region {

    /* renamed from: a  reason: collision with root package name */
    public final String f15063a;

    /* renamed from: b  reason: collision with root package name */
    public final String f15064b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, String> f15065c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, Boolean> f15066d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, Boolean> f15067e = new HashMap();

    public Region(String str, String str2) {
        this.f15063a = str;
        if (str2 == null || str2.isEmpty()) {
            this.f15064b = "amazonaws.com";
        } else {
            this.f15064b = str2;
        }
    }

    public static Region e(Regions regions) {
        return RegionUtils.a(regions.getName());
    }

    public static Region f(String str) {
        return RegionUtils.a(str);
    }

    public String a() {
        return this.f15064b;
    }

    public Map<String, Boolean> b() {
        return this.f15066d;
    }

    public Map<String, Boolean> c() {
        return this.f15067e;
    }

    public String d() {
        return this.f15063a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Region)) {
            return false;
        }
        return d().equals(((Region) obj).d());
    }

    public String g(String str) {
        return this.f15065c.get(str);
    }

    public Map<String, String> h() {
        return this.f15065c;
    }

    public int hashCode() {
        return d().hashCode();
    }

    public boolean i(String str) {
        return this.f15065c.containsKey(str);
    }

    public String toString() {
        return d();
    }
}
