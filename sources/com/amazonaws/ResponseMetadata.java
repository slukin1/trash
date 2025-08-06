package com.amazonaws;

import java.util.Map;

public class ResponseMetadata {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, String> f14810a;

    public ResponseMetadata(Map<String, String> map) {
        this.f14810a = map;
    }

    public String a() {
        return this.f14810a.get("AWS_REQUEST_ID");
    }

    public String toString() {
        Map<String, String> map = this.f14810a;
        if (map == null) {
            return "{}";
        }
        return map.toString();
    }
}
