package com.zopim.android.sdk.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.InstanceCreator;
import java.lang.reflect.Type;

class ChatGson {
    private static Gson defaultGson;
    private static GsonBuilder gsonBuilder;

    public static class ModelInstanceCreator<T> implements InstanceCreator<T> {
        private final T data;

        public ModelInstanceCreator(T t11) {
            this.data = t11;
        }

        public T createInstance(Type type) {
            return this.data;
        }
    }

    static {
        GsonBuilder excludeFieldsWithoutExposeAnnotation = new GsonBuilder().excludeFieldsWithoutExposeAnnotation();
        gsonBuilder = excludeFieldsWithoutExposeAnnotation;
        defaultGson = excludeFieldsWithoutExposeAnnotation.create();
    }

    private ChatGson() {
    }

    public static Gson get() {
        return defaultGson;
    }

    public static <T> T performUpdate(T t11, T t12, Class<T> cls) {
        return withTypeAdapter(t11, cls).fromJson(defaultGson.toJsonTree(t12), cls);
    }

    private static <T> Gson withTypeAdapter(T t11, Class<T> cls) {
        return gsonBuilder.registerTypeAdapter(cls, new ModelInstanceCreator(t11)).create();
    }

    public static <T> T performUpdate(T t11, String str, Class<T> cls) {
        return withTypeAdapter(t11, cls).fromJson(str, cls);
    }
}
