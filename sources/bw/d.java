package bw;

import kotlinx.serialization.g;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

public final class d<T> implements Converter<T, RequestBody> {

    /* renamed from: a  reason: collision with root package name */
    public final MediaType f37409a;

    /* renamed from: b  reason: collision with root package name */
    public final g<T> f37410b;

    /* renamed from: c  reason: collision with root package name */
    public final e f37411c;

    public d(MediaType mediaType, g<? super T> gVar, e eVar) {
        this.f37409a = mediaType;
        this.f37410b = gVar;
        this.f37411c = eVar;
    }

    /* renamed from: a */
    public RequestBody convert(T t11) {
        return this.f37411c.d(this.f37409a, this.f37410b, t11);
    }
}
