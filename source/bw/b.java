package bw;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

public final class b extends Converter.Factory {

    /* renamed from: a  reason: collision with root package name */
    public final MediaType f37407a;

    /* renamed from: b  reason: collision with root package name */
    public final e f37408b;

    public b(MediaType mediaType, e eVar) {
        this.f37407a = mediaType;
        this.f37408b = eVar;
    }

    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        return new d(this.f37407a, this.f37408b.c(type), this.f37408b);
    }

    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        return new a(this.f37408b.c(type), this.f37408b);
    }
}
