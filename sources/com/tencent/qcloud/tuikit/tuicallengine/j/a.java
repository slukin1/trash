package com.tencent.qcloud.tuikit.tuicallengine.j;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public final class a implements ExclusionStrategy {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f48515a;

    public a(String str) {
        this.f48515a = str;
    }

    public boolean shouldSkipClass(Class<?> cls) {
        return false;
    }

    public boolean shouldSkipField(FieldAttributes fieldAttributes) {
        return fieldAttributes.getName().contains(this.f48515a);
    }
}
