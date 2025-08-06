package com.kakao.sdk.common.json;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import java.util.Date;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.x;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\n\u0012\u0004\u0012\u0002H\u0005\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\tH\u0016¨\u0006\n"}, d2 = {"Lcom/kakao/sdk/common/json/KakaoTypeAdapterFactory;", "Lcom/google/gson/TypeAdapterFactory;", "()V", "create", "Lcom/google/gson/TypeAdapter;", "T", "gson", "Lcom/google/gson/Gson;", "type", "Lcom/google/gson/reflect/TypeToken;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class KakaoTypeAdapterFactory implements TypeAdapterFactory {
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        Objects.requireNonNull(rawType, "null cannot be cast to non-null type java.lang.Class<*>");
        if (x.b(rawType, Date.class)) {
            return new KakaoDateTypeAdapter();
        }
        if (rawType.isEnum()) {
            return new KakaoEnumTypeAdapter(rawType);
        }
        return null;
    }
}
