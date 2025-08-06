package com.xiaomi.push;

import org.json.JSONArray;

public class bg extends JSONArray implements bf {

    /* renamed from: a  reason: collision with root package name */
    private int f51438a = 2;

    public int a() {
        return this.f51438a + (length() - 1);
    }

    public JSONArray put(Object obj) {
        if (obj instanceof bf) {
            this.f51438a += ((bf) obj).a();
        }
        return super.put(obj);
    }
}
