package com.amazonaws.services.s3.model;

import java.util.HashMap;
import java.util.Map;

public class TagSet {

    /* renamed from: a  reason: collision with root package name */
    public Map<String, String> f15351a;

    public TagSet() {
        this.f15351a = new HashMap(1);
    }

    public Map<String, String> a() {
        return this.f15351a;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{");
        stringBuffer.append("Tags: " + a());
        stringBuffer.append("}");
        return stringBuffer.toString();
    }

    public TagSet(Map<String, String> map) {
        HashMap hashMap = new HashMap(1);
        this.f15351a = hashMap;
        hashMap.putAll(map);
    }
}
