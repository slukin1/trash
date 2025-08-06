package com.blankj.utilcode.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, Gson> f63542a = new ConcurrentHashMap();

    public static Gson a() {
        return new GsonBuilder().serializeNulls().disableHtmlEscaping().create();
    }

    public static <T> T b(Gson gson, String str, Class<T> cls) {
        Objects.requireNonNull(gson, "Argument 'gson' of type Gson (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'type' of type Class<T> (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return gson.fromJson(str, cls);
    }

    public static <T> T c(String str, Class<T> cls) {
        Objects.requireNonNull(cls, "Argument 'type' of type Class<T> (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return b(d(), str, cls);
    }

    public static Gson d() {
        Map<String, Gson> map = f63542a;
        Gson gson = map.get("delegateGson");
        if (gson != null) {
            return gson;
        }
        Gson gson2 = map.get("defaultGson");
        if (gson2 != null) {
            return gson2;
        }
        Gson a11 = a();
        map.put("defaultGson", a11);
        return a11;
    }

    public static Gson e() {
        Map<String, Gson> map = f63542a;
        Gson gson = map.get("logUtilsGson");
        if (gson != null) {
            return gson;
        }
        Gson create = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
        map.put("logUtilsGson", create);
        return create;
    }

    public static String f(Gson gson, Object obj) {
        Objects.requireNonNull(gson, "Argument 'gson' of type Gson (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return gson.toJson(obj);
    }

    public static String g(Object obj) {
        return f(d(), obj);
    }
}
