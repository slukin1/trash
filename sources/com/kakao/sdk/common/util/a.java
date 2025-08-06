package com.kakao.sdk.common.util;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kakao.sdk.common.json.KakaoTypeAdapterFactory;
import java.lang.reflect.Type;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u00003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001c\u0010\u0013\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\r\u0010\u0017R\u0017\u0010\u001b\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0017¨\u0006\u001e"}, d2 = {"Lcom/kakao/sdk/common/util/a;", "", "T", "model", "", "c", "(Ljava/lang/Object;)Ljava/lang/String;", "string", "Ljava/lang/reflect/Type;", "type1", "a", "(Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;", "com/kakao/sdk/common/util/a$a", "b", "Lcom/kakao/sdk/common/util/a$a;", "kakaoExclusionStrategy", "Lcom/google/gson/GsonBuilder;", "kotlin.jvm.PlatformType", "Lcom/google/gson/GsonBuilder;", "internalBuilder", "Lcom/google/gson/Gson;", "d", "Lcom/google/gson/Gson;", "()Lcom/google/gson/Gson;", "base", "e", "getPretty", "pretty", "<init>", "()V", "common_release"}, k = 1, mv = {1, 6, 0})
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f25105a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static final C0218a f25106b;

    /* renamed from: c  reason: collision with root package name */
    public static final GsonBuilder f25107c;

    /* renamed from: d  reason: collision with root package name */
    public static final Gson f25108d;

    /* renamed from: e  reason: collision with root package name */
    public static final Gson f25109e;

    @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\t"}, d2 = {"com/kakao/sdk/common/util/a$a", "Lcom/google/gson/ExclusionStrategy;", "Ljava/lang/Class;", "clazz", "", "shouldSkipClass", "Lcom/google/gson/FieldAttributes;", "f", "shouldSkipField", "common_release"}, k = 1, mv = {1, 6, 0})
    /* renamed from: com.kakao.sdk.common.util.a$a  reason: collision with other inner class name */
    public static final class C0218a implements ExclusionStrategy {
        public boolean shouldSkipClass(Class<?> cls) {
            return false;
        }

        public boolean shouldSkipField(FieldAttributes fieldAttributes) {
            return ((yw.a) fieldAttributes.getAnnotation(yw.a.class)) != null;
        }
    }

    static {
        C0218a aVar = new C0218a();
        f25106b = aVar;
        GsonBuilder addDeserializationExclusionStrategy = new GsonBuilder().registerTypeAdapterFactory(new KakaoTypeAdapterFactory()).setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).addSerializationExclusionStrategy(aVar).addDeserializationExclusionStrategy(aVar);
        f25107c = addDeserializationExclusionStrategy;
        f25108d = addDeserializationExclusionStrategy.create();
        f25109e = addDeserializationExclusionStrategy.setPrettyPrinting().create();
    }

    public final <T> T a(String str, Type type) {
        return f25108d.fromJson(str, type);
    }

    public final Gson b() {
        return f25108d;
    }

    public final <T> String c(T t11) {
        return f25108d.toJson((Object) t11);
    }
}
