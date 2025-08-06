package com.hbg.lib.network.retrofit.util;

import java.util.HashMap;
import java.util.Map;

public class MapParamsBuilder {

    /* renamed from: a  reason: collision with root package name */
    public Map<String, Object> f70666a = new HashMap();

    public static MapParamsBuilder c() {
        return new MapParamsBuilder();
    }

    public MapParamsBuilder a(String str, Object obj) {
        if (obj != null) {
            this.f70666a.put(str, obj);
        }
        return this;
    }

    public Map<String, Object> b() {
        return this.f70666a;
    }
}
