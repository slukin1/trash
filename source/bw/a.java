package bw;

import okhttp3.ResponseBody;
import retrofit2.Converter;

public final class a<T> implements Converter<ResponseBody, T> {

    /* renamed from: a  reason: collision with root package name */
    public final kotlinx.serialization.a<T> f37405a;

    /* renamed from: b  reason: collision with root package name */
    public final e f37406b;

    public a(kotlinx.serialization.a<? extends T> aVar, e eVar) {
        this.f37405a = aVar;
        this.f37406b = eVar;
    }

    /* renamed from: a */
    public T convert(ResponseBody responseBody) {
        return this.f37406b.a(this.f37405a, responseBody);
    }
}
