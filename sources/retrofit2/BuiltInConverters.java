package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import kotlin.Unit;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.http.Streaming;

final class BuiltInConverters extends Converter.Factory {
    private boolean checkForKotlinUnit = true;

    public static final class BufferingResponseBodyConverter implements Converter<ResponseBody, ResponseBody> {
        public static final BufferingResponseBodyConverter INSTANCE = new BufferingResponseBodyConverter();

        public ResponseBody convert(ResponseBody responseBody) throws IOException {
            try {
                return Utils.buffer(responseBody);
            } finally {
                responseBody.close();
            }
        }
    }

    public static final class RequestBodyConverter implements Converter<RequestBody, RequestBody> {
        public static final RequestBodyConverter INSTANCE = new RequestBodyConverter();

        public RequestBody convert(RequestBody requestBody) {
            return requestBody;
        }
    }

    public static final class StreamingResponseBodyConverter implements Converter<ResponseBody, ResponseBody> {
        public static final StreamingResponseBodyConverter INSTANCE = new StreamingResponseBodyConverter();

        public ResponseBody convert(ResponseBody responseBody) {
            return responseBody;
        }
    }

    public static final class ToStringConverter implements Converter<Object, String> {
        public static final ToStringConverter INSTANCE = new ToStringConverter();

        public String convert(Object obj) {
            return obj.toString();
        }
    }

    public static final class UnitResponseBodyConverter implements Converter<ResponseBody, Unit> {
        public static final UnitResponseBodyConverter INSTANCE = new UnitResponseBodyConverter();

        public Unit convert(ResponseBody responseBody) {
            responseBody.close();
            return Unit.f56620a;
        }
    }

    public static final class VoidResponseBodyConverter implements Converter<ResponseBody, Void> {
        public static final VoidResponseBodyConverter INSTANCE = new VoidResponseBodyConverter();

        public Void convert(ResponseBody responseBody) {
            responseBody.close();
            return null;
        }
    }

    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        if (RequestBody.class.isAssignableFrom(Utils.getRawType(type))) {
            return RequestBodyConverter.INSTANCE;
        }
        return null;
    }

    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (type == ResponseBody.class) {
            if (Utils.isAnnotationPresent(annotationArr, Streaming.class)) {
                return StreamingResponseBodyConverter.INSTANCE;
            }
            return BufferingResponseBodyConverter.INSTANCE;
        } else if (type == Void.class) {
            return VoidResponseBodyConverter.INSTANCE;
        } else {
            if (!this.checkForKotlinUnit || type != Unit.class) {
                return null;
            }
            try {
                return UnitResponseBodyConverter.INSTANCE;
            } catch (NoClassDefFoundError unused) {
                this.checkForKotlinUnit = false;
                return null;
            }
        }
    }
}
