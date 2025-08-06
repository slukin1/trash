package com.kakao.sdk.network;

import com.kakao.sdk.common.util.a;
import com.kakao.sdk.common.util.b;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.x;
import retrofit2.Converter;
import retrofit2.Retrofit;
import yw.d;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J9\u0010\u0003\u001a\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/kakao/sdk/network/KakaoRetrofitConverterFactory;", "Lretrofit2/Converter$Factory;", "()V", "stringConverter", "Lretrofit2/Converter;", "", "type", "Ljava/lang/reflect/Type;", "annotations", "", "", "retrofit", "Lretrofit2/Retrofit;", "(Ljava/lang/reflect/Type;[Ljava/lang/annotation/Annotation;Lretrofit2/Retrofit;)Lretrofit2/Converter;", "network_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class KakaoRetrofitConverterFactory extends Converter.Factory {
    public static final String e(Enum enumR) {
        String c11 = a.f25105a.c(enumR);
        return c11.substring(1, c11.length() - 1);
    }

    public static final String f(Date date) {
        return String.valueOf(date.getTime() / ((long) 1000));
    }

    public static final String g(Map map) {
        return b.f25110a.b(map);
    }

    public static final String h(Object obj) {
        return a.f25105a.c(obj);
    }

    public Converter<?, String> stringConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (x.b(type, String.class)) {
            return null;
        }
        if ((type instanceof Class) && ((Class) type).isEnum()) {
            return c.f25123a;
        }
        int i11 = 0;
        if (x.b(type, Date.class)) {
            ArrayList arrayList = new ArrayList();
            int length = annotationArr.length;
            int i12 = 0;
            while (i12 < length) {
                Annotation annotation = annotationArr[i12];
                i12++;
                if (annotation instanceof yw.b) {
                    arrayList.add(annotation);
                }
            }
            if (((yw.b) CollectionsKt___CollectionsKt.c0(arrayList)) != null) {
                return d.f25124a;
            }
        }
        if ((type instanceof ParameterizedType) && x.b(((ParameterizedType) type).getRawType(), Map.class)) {
            ArrayList arrayList2 = new ArrayList();
            int length2 = annotationArr.length;
            while (i11 < length2) {
                Annotation annotation2 = annotationArr[i11];
                i11++;
                if (annotation2 instanceof d) {
                    arrayList2.add(annotation2);
                }
            }
            if (((d) CollectionsKt___CollectionsKt.c0(arrayList2)) != null) {
                return e.f25125a;
            }
        }
        return f.f25126a;
    }
}
