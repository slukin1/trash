package com.hbg.lib.common.utils;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import i6.d;

public class UtilGson {

    /* renamed from: a  reason: collision with root package name */
    public static final Gson f67496a = new GsonBuilder().serializeSpecialFloatingPointValues().create();

    /* renamed from: b  reason: collision with root package name */
    public static final Gson f67497b = new GsonBuilder().serializeSpecialFloatingPointValues().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();

    public static String a(Object obj) {
        try {
            return f67496a.toJson(obj);
        } catch (Exception e11) {
            d.g(e11);
            return null;
        }
    }
}
