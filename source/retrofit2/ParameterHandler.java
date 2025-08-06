package retrofit2;

import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

abstract class ParameterHandler<T> {

    public static final class Body<T> extends ParameterHandler<T> {
        private final Converter<T, RequestBody> converter;
        private final Method method;

        /* renamed from: p  reason: collision with root package name */
        private final int f25626p;

        public Body(Method method2, int i11, Converter<T, RequestBody> converter2) {
            this.method = method2;
            this.f25626p = i11;
            this.converter = converter2;
        }

        public void apply(RequestBuilder requestBuilder, T t11) {
            if (t11 != null) {
                try {
                    requestBuilder.setBody(this.converter.convert(t11));
                } catch (IOException e11) {
                    Method method2 = this.method;
                    int i11 = this.f25626p;
                    throw Utils.parameterError(method2, e11, i11, "Unable to convert " + t11 + " to RequestBody", new Object[0]);
                }
            } else {
                throw Utils.parameterError(this.method, this.f25626p, "Body parameter value must not be null.", new Object[0]);
            }
        }
    }

    public static final class Field<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final String name;
        private final Converter<T, String> valueConverter;

        public Field(String str, Converter<T, String> converter, boolean z11) {
            Objects.requireNonNull(str, "name == null");
            this.name = str;
            this.valueConverter = converter;
            this.encoded = z11;
        }

        public void apply(RequestBuilder requestBuilder, T t11) throws IOException {
            String convert;
            if (t11 != null && (convert = this.valueConverter.convert(t11)) != null) {
                requestBuilder.addFormField(this.name, convert, this.encoded);
            }
        }
    }

    public static final class FieldMap<T> extends ParameterHandler<Map<String, T>> {
        private final boolean encoded;
        private final Method method;

        /* renamed from: p  reason: collision with root package name */
        private final int f25627p;
        private final Converter<T, String> valueConverter;

        public FieldMap(Method method2, int i11, Converter<T, String> converter, boolean z11) {
            this.method = method2;
            this.f25627p = i11;
            this.valueConverter = converter;
            this.encoded = z11;
        }

        public void apply(RequestBuilder requestBuilder, Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry next : map.entrySet()) {
                    String str = (String) next.getKey();
                    if (str != null) {
                        Object value = next.getValue();
                        if (value != null) {
                            String convert = this.valueConverter.convert(value);
                            if (convert != null) {
                                requestBuilder.addFormField(str, convert, this.encoded);
                            } else {
                                Method method2 = this.method;
                                int i11 = this.f25627p;
                                throw Utils.parameterError(method2, i11, "Field map value '" + value + "' converted to null by " + this.valueConverter.getClass().getName() + " for key '" + str + "'.", new Object[0]);
                            }
                        } else {
                            Method method3 = this.method;
                            int i12 = this.f25627p;
                            throw Utils.parameterError(method3, i12, "Field map contained null value for key '" + str + "'.", new Object[0]);
                        }
                    } else {
                        throw Utils.parameterError(this.method, this.f25627p, "Field map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw Utils.parameterError(this.method, this.f25627p, "Field map was null.", new Object[0]);
        }
    }

    public static final class Header<T> extends ParameterHandler<T> {
        private final String name;
        private final Converter<T, String> valueConverter;

        public Header(String str, Converter<T, String> converter) {
            Objects.requireNonNull(str, "name == null");
            this.name = str;
            this.valueConverter = converter;
        }

        public void apply(RequestBuilder requestBuilder, T t11) throws IOException {
            String convert;
            if (t11 != null && (convert = this.valueConverter.convert(t11)) != null) {
                requestBuilder.addHeader(this.name, convert);
            }
        }
    }

    public static final class HeaderMap<T> extends ParameterHandler<Map<String, T>> {
        private final Method method;

        /* renamed from: p  reason: collision with root package name */
        private final int f25628p;
        private final Converter<T, String> valueConverter;

        public HeaderMap(Method method2, int i11, Converter<T, String> converter) {
            this.method = method2;
            this.f25628p = i11;
            this.valueConverter = converter;
        }

        public void apply(RequestBuilder requestBuilder, Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry next : map.entrySet()) {
                    String str = (String) next.getKey();
                    if (str != null) {
                        Object value = next.getValue();
                        if (value != null) {
                            requestBuilder.addHeader(str, this.valueConverter.convert(value));
                        } else {
                            Method method2 = this.method;
                            int i11 = this.f25628p;
                            throw Utils.parameterError(method2, i11, "Header map contained null value for key '" + str + "'.", new Object[0]);
                        }
                    } else {
                        throw Utils.parameterError(this.method, this.f25628p, "Header map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw Utils.parameterError(this.method, this.f25628p, "Header map was null.", new Object[0]);
        }
    }

    public static final class Headers extends ParameterHandler<okhttp3.Headers> {
        private final Method method;

        /* renamed from: p  reason: collision with root package name */
        private final int f25629p;

        public Headers(Method method2, int i11) {
            this.method = method2;
            this.f25629p = i11;
        }

        public void apply(RequestBuilder requestBuilder, okhttp3.Headers headers) {
            if (headers != null) {
                requestBuilder.addHeaders(headers);
                return;
            }
            throw Utils.parameterError(this.method, this.f25629p, "Headers parameter must not be null.", new Object[0]);
        }
    }

    public static final class Part<T> extends ParameterHandler<T> {
        private final Converter<T, RequestBody> converter;
        private final okhttp3.Headers headers;
        private final Method method;

        /* renamed from: p  reason: collision with root package name */
        private final int f25630p;

        public Part(Method method2, int i11, okhttp3.Headers headers2, Converter<T, RequestBody> converter2) {
            this.method = method2;
            this.f25630p = i11;
            this.headers = headers2;
            this.converter = converter2;
        }

        public void apply(RequestBuilder requestBuilder, T t11) {
            if (t11 != null) {
                try {
                    requestBuilder.addPart(this.headers, this.converter.convert(t11));
                } catch (IOException e11) {
                    Method method2 = this.method;
                    int i11 = this.f25630p;
                    throw Utils.parameterError(method2, i11, "Unable to convert " + t11 + " to RequestBody", e11);
                }
            }
        }
    }

    public static final class PartMap<T> extends ParameterHandler<Map<String, T>> {
        private final Method method;

        /* renamed from: p  reason: collision with root package name */
        private final int f25631p;
        private final String transferEncoding;
        private final Converter<T, RequestBody> valueConverter;

        public PartMap(Method method2, int i11, Converter<T, RequestBody> converter, String str) {
            this.method = method2;
            this.f25631p = i11;
            this.valueConverter = converter;
            this.transferEncoding = str;
        }

        public void apply(RequestBuilder requestBuilder, Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry next : map.entrySet()) {
                    String str = (String) next.getKey();
                    if (str != null) {
                        Object value = next.getValue();
                        if (value != null) {
                            requestBuilder.addPart(okhttp3.Headers.of(HttpHeaders.CONTENT_DISPOSITION, "form-data; name=\"" + str + "\"", "Content-Transfer-Encoding", this.transferEncoding), this.valueConverter.convert(value));
                        } else {
                            Method method2 = this.method;
                            int i11 = this.f25631p;
                            throw Utils.parameterError(method2, i11, "Part map contained null value for key '" + str + "'.", new Object[0]);
                        }
                    } else {
                        throw Utils.parameterError(this.method, this.f25631p, "Part map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw Utils.parameterError(this.method, this.f25631p, "Part map was null.", new Object[0]);
        }
    }

    public static final class Path<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final Method method;
        private final String name;

        /* renamed from: p  reason: collision with root package name */
        private final int f25632p;
        private final Converter<T, String> valueConverter;

        public Path(Method method2, int i11, String str, Converter<T, String> converter, boolean z11) {
            this.method = method2;
            this.f25632p = i11;
            Objects.requireNonNull(str, "name == null");
            this.name = str;
            this.valueConverter = converter;
            this.encoded = z11;
        }

        public void apply(RequestBuilder requestBuilder, T t11) throws IOException {
            if (t11 != null) {
                requestBuilder.addPathParam(this.name, this.valueConverter.convert(t11), this.encoded);
                return;
            }
            Method method2 = this.method;
            int i11 = this.f25632p;
            throw Utils.parameterError(method2, i11, "Path parameter \"" + this.name + "\" value must not be null.", new Object[0]);
        }
    }

    public static final class Query<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final String name;
        private final Converter<T, String> valueConverter;

        public Query(String str, Converter<T, String> converter, boolean z11) {
            Objects.requireNonNull(str, "name == null");
            this.name = str;
            this.valueConverter = converter;
            this.encoded = z11;
        }

        public void apply(RequestBuilder requestBuilder, T t11) throws IOException {
            String convert;
            if (t11 != null && (convert = this.valueConverter.convert(t11)) != null) {
                requestBuilder.addQueryParam(this.name, convert, this.encoded);
            }
        }
    }

    public static final class QueryMap<T> extends ParameterHandler<Map<String, T>> {
        private final boolean encoded;
        private final Method method;

        /* renamed from: p  reason: collision with root package name */
        private final int f25633p;
        private final Converter<T, String> valueConverter;

        public QueryMap(Method method2, int i11, Converter<T, String> converter, boolean z11) {
            this.method = method2;
            this.f25633p = i11;
            this.valueConverter = converter;
            this.encoded = z11;
        }

        public void apply(RequestBuilder requestBuilder, Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry next : map.entrySet()) {
                    String str = (String) next.getKey();
                    if (str != null) {
                        Object value = next.getValue();
                        if (value != null) {
                            String convert = this.valueConverter.convert(value);
                            if (convert != null) {
                                requestBuilder.addQueryParam(str, convert, this.encoded);
                            } else {
                                Method method2 = this.method;
                                int i11 = this.f25633p;
                                throw Utils.parameterError(method2, i11, "Query map value '" + value + "' converted to null by " + this.valueConverter.getClass().getName() + " for key '" + str + "'.", new Object[0]);
                            }
                        } else {
                            Method method3 = this.method;
                            int i12 = this.f25633p;
                            throw Utils.parameterError(method3, i12, "Query map contained null value for key '" + str + "'.", new Object[0]);
                        }
                    } else {
                        throw Utils.parameterError(this.method, this.f25633p, "Query map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw Utils.parameterError(this.method, this.f25633p, "Query map was null", new Object[0]);
        }
    }

    public static final class QueryName<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final Converter<T, String> nameConverter;

        public QueryName(Converter<T, String> converter, boolean z11) {
            this.nameConverter = converter;
            this.encoded = z11;
        }

        public void apply(RequestBuilder requestBuilder, T t11) throws IOException {
            if (t11 != null) {
                requestBuilder.addQueryParam(this.nameConverter.convert(t11), (String) null, this.encoded);
            }
        }
    }

    public static final class RawPart extends ParameterHandler<MultipartBody.Part> {
        public static final RawPart INSTANCE = new RawPart();

        private RawPart() {
        }

        public void apply(RequestBuilder requestBuilder, MultipartBody.Part part) {
            if (part != null) {
                requestBuilder.addPart(part);
            }
        }
    }

    public static final class RelativeUrl extends ParameterHandler<Object> {
        private final Method method;

        /* renamed from: p  reason: collision with root package name */
        private final int f25634p;

        public RelativeUrl(Method method2, int i11) {
            this.method = method2;
            this.f25634p = i11;
        }

        public void apply(RequestBuilder requestBuilder, Object obj) {
            if (obj != null) {
                requestBuilder.setRelativeUrl(obj);
                return;
            }
            throw Utils.parameterError(this.method, this.f25634p, "@Url parameter is null.", new Object[0]);
        }
    }

    public static final class Tag<T> extends ParameterHandler<T> {
        public final Class<T> cls;

        public Tag(Class<T> cls2) {
            this.cls = cls2;
        }

        public void apply(RequestBuilder requestBuilder, T t11) {
            requestBuilder.addTag(this.cls, t11);
        }
    }

    public abstract void apply(RequestBuilder requestBuilder, T t11) throws IOException;

    public final ParameterHandler<Object> array() {
        return new ParameterHandler<Object>() {
            public void apply(RequestBuilder requestBuilder, Object obj) throws IOException {
                if (obj != null) {
                    int length = Array.getLength(obj);
                    for (int i11 = 0; i11 < length; i11++) {
                        ParameterHandler.this.apply(requestBuilder, Array.get(obj, i11));
                    }
                }
            }
        };
    }

    public final ParameterHandler<Iterable<T>> iterable() {
        return new ParameterHandler<Iterable<T>>() {
            public void apply(RequestBuilder requestBuilder, Iterable<T> iterable) throws IOException {
                if (iterable != null) {
                    for (T apply : iterable) {
                        ParameterHandler.this.apply(requestBuilder, apply);
                    }
                }
            }
        };
    }
}
