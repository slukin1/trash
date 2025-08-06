package c9;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

public final class d extends Converter.Factory {

    public class a implements Converter<ResponseBody, Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Converter f70562a;

        public a(Converter converter) {
            this.f70562a = converter;
        }

        /* renamed from: a */
        public Object convert(ResponseBody responseBody) throws IOException {
            if (responseBody.contentLength() == 0) {
                return null;
            }
            return this.f70562a.convert(responseBody);
        }
    }

    public static d a() {
        return new d();
    }

    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        return new a(retrofit.nextResponseBodyConverter(this, type, annotationArr));
    }
}
