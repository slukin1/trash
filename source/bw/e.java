package bw;

import java.lang.reflect.Type;
import kotlin.jvm.internal.r;
import kotlinx.serialization.b;
import kotlinx.serialization.g;
import kotlinx.serialization.h;
import kotlinx.serialization.k;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

public abstract class e {

    public static final class a extends e {

        /* renamed from: a  reason: collision with root package name */
        public final k f37412a;

        public a(k kVar) {
            super((r) null);
            this.f37412a = kVar;
        }

        public <T> T a(kotlinx.serialization.a<? extends T> aVar, ResponseBody responseBody) {
            return b().c(aVar, responseBody.string());
        }

        public <T> RequestBody d(MediaType mediaType, g<? super T> gVar, T t11) {
            return RequestBody.create(mediaType, b().b(gVar, t11));
        }

        /* renamed from: e */
        public k b() {
            return this.f37412a;
        }
    }

    public e() {
    }

    public /* synthetic */ e(r rVar) {
        this();
    }

    public abstract <T> T a(kotlinx.serialization.a<? extends T> aVar, ResponseBody responseBody);

    public abstract kotlinx.serialization.e b();

    public final b<Object> c(Type type) {
        return h.c(b().a(), type);
    }

    public abstract <T> RequestBody d(MediaType mediaType, g<? super T> gVar, T t11);
}
