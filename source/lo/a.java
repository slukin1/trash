package lo;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

public final class a extends Converter.Factory {

    /* renamed from: lo.a$a  reason: collision with other inner class name */
    public class C0875a implements Converter<ResponseBody, Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Converter f84440a;

        public C0875a(Converter converter) {
            this.f84440a = converter;
        }

        /* renamed from: a */
        public Object convert(ResponseBody responseBody) throws IOException {
            if (responseBody.contentLength() == 0) {
                return null;
            }
            return this.f84440a.convert(responseBody);
        }
    }

    public static a a() {
        return new a();
    }

    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        return new C0875a(retrofit.nextResponseBodyConverter(this, type, annotationArr));
    }
}
