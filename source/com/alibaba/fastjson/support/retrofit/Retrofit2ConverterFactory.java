package com.alibaba.fastjson.support.retrofit;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

public class Retrofit2ConverterFactory extends Converter.Factory {

    /* renamed from: f  reason: collision with root package name */
    public static final MediaType f14350f = MediaType.parse("application/json; charset=UTF-8");

    /* renamed from: g  reason: collision with root package name */
    public static final Feature[] f14351g = new Feature[0];

    /* renamed from: a  reason: collision with root package name */
    public ParserConfig f14352a = ParserConfig.m();

    /* renamed from: b  reason: collision with root package name */
    public int f14353b = JSON.DEFAULT_PARSER_FEATURE;

    /* renamed from: c  reason: collision with root package name */
    public Feature[] f14354c;

    /* renamed from: d  reason: collision with root package name */
    public SerializeConfig f14355d;

    /* renamed from: e  reason: collision with root package name */
    public SerializerFeature[] f14356e;

    public final class a<T> implements Converter<T, RequestBody> {
        public a() {
        }

        /* renamed from: a */
        public RequestBody convert(T t11) throws IOException {
            SerializeConfig serializeConfig;
            SerializerFeature[] serializerFeatureArr;
            if (Retrofit2ConverterFactory.this.f14355d == null) {
                serializeConfig = SerializeConfig.f14295g;
            } else {
                serializeConfig = Retrofit2ConverterFactory.this.f14355d;
            }
            if (Retrofit2ConverterFactory.this.f14356e == null) {
                serializerFeatureArr = SerializerFeature.EMPTY;
            } else {
                serializerFeatureArr = Retrofit2ConverterFactory.this.f14356e;
            }
            return RequestBody.create(Retrofit2ConverterFactory.f14350f, JSON.toJSONBytes((Object) t11, serializeConfig, serializerFeatureArr));
        }
    }

    public final class b<T> implements Converter<ResponseBody, T> {

        /* renamed from: a  reason: collision with root package name */
        public Type f14358a;

        public b(Type type) {
            this.f14358a = type;
        }

        /* renamed from: a */
        public T convert(ResponseBody responseBody) throws IOException {
            Feature[] featureArr;
            try {
                String string = responseBody.string();
                Type type = this.f14358a;
                ParserConfig a11 = Retrofit2ConverterFactory.this.f14352a;
                int b11 = Retrofit2ConverterFactory.this.f14353b;
                if (Retrofit2ConverterFactory.this.f14354c != null) {
                    featureArr = Retrofit2ConverterFactory.this.f14354c;
                } else {
                    featureArr = Retrofit2ConverterFactory.f14351g;
                }
                return JSON.parseObject(string, type, a11, b11, featureArr);
            } finally {
                responseBody.close();
            }
        }
    }

    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        return new a();
    }

    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        return new b(type);
    }
}
