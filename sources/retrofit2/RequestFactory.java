package retrofit2;

import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.coroutines.c;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import retrofit2.ParameterHandler;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.OPTIONS;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.QueryName;
import retrofit2.http.Tag;
import retrofit2.http.Url;

final class RequestFactory {
    private final HttpUrl baseUrl;
    private final MediaType contentType;
    private final boolean hasBody;
    private final Headers headers;
    public final String httpMethod;
    private final boolean isFormEncoded;
    public final boolean isKotlinSuspendFunction;
    private final boolean isMultipart;
    private final Method method;
    private final ParameterHandler<?>[] parameterHandlers;
    private final String relativeUrl;

    public static final class Builder {
        private static final String PARAM = "[a-zA-Z][a-zA-Z0-9_-]*";
        private static final Pattern PARAM_NAME_REGEX = Pattern.compile(PARAM);
        private static final Pattern PARAM_URL_REGEX = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");
        public MediaType contentType;
        public boolean gotBody;
        public boolean gotField;
        public boolean gotPart;
        public boolean gotPath;
        public boolean gotQuery;
        public boolean gotQueryMap;
        public boolean gotQueryName;
        public boolean gotUrl;
        public boolean hasBody;
        public Headers headers;
        public String httpMethod;
        public boolean isFormEncoded;
        public boolean isKotlinSuspendFunction;
        public boolean isMultipart;
        public final Method method;
        public final Annotation[] methodAnnotations;
        public final Annotation[][] parameterAnnotationsArray;
        public ParameterHandler<?>[] parameterHandlers;
        public final Type[] parameterTypes;
        public String relativeUrl;
        public Set<String> relativeUrlParamNames;
        public final Retrofit retrofit;

        public Builder(Retrofit retrofit3, Method method2) {
            this.retrofit = retrofit3;
            this.method = method2;
            this.methodAnnotations = method2.getAnnotations();
            this.parameterTypes = method2.getGenericParameterTypes();
            this.parameterAnnotationsArray = method2.getParameterAnnotations();
        }

        private static Class<?> boxIfPrimitive(Class<?> cls) {
            if (Boolean.TYPE == cls) {
                return Boolean.class;
            }
            if (Byte.TYPE == cls) {
                return Byte.class;
            }
            if (Character.TYPE == cls) {
                return Character.class;
            }
            if (Double.TYPE == cls) {
                return Double.class;
            }
            if (Float.TYPE == cls) {
                return Float.class;
            }
            if (Integer.TYPE == cls) {
                return Integer.class;
            }
            if (Long.TYPE == cls) {
                return Long.class;
            }
            return Short.TYPE == cls ? Short.class : cls;
        }

        private Headers parseHeaders(String[] strArr) {
            Headers.Builder builder = new Headers.Builder();
            for (String str : strArr) {
                int indexOf = str.indexOf(58);
                if (indexOf == -1 || indexOf == 0 || indexOf == str.length() - 1) {
                    throw Utils.methodError(this.method, "@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str);
                }
                String substring = str.substring(0, indexOf);
                String trim = str.substring(indexOf + 1).trim();
                if ("Content-Type".equalsIgnoreCase(substring)) {
                    try {
                        this.contentType = MediaType.get(trim);
                    } catch (IllegalArgumentException e11) {
                        throw Utils.methodError(this.method, e11, "Malformed content type: %s", trim);
                    }
                } else {
                    builder.add(substring, trim);
                }
            }
            return builder.build();
        }

        private void parseHttpMethodAndPath(String str, String str2, boolean z11) {
            String str3 = this.httpMethod;
            if (str3 == null) {
                this.httpMethod = str;
                this.hasBody = z11;
                if (!str2.isEmpty()) {
                    int indexOf = str2.indexOf(63);
                    if (indexOf != -1 && indexOf < str2.length() - 1) {
                        String substring = str2.substring(indexOf + 1);
                        if (PARAM_URL_REGEX.matcher(substring).find()) {
                            throw Utils.methodError(this.method, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", substring);
                        }
                    }
                    this.relativeUrl = str2;
                    this.relativeUrlParamNames = parsePathParameters(str2);
                    return;
                }
                return;
            }
            throw Utils.methodError(this.method, "Only one HTTP method is allowed. Found: %s and %s.", str3, str);
        }

        private void parseMethodAnnotation(Annotation annotation) {
            if (annotation instanceof DELETE) {
                parseHttpMethodAndPath("DELETE", ((DELETE) annotation).value(), false);
            } else if (annotation instanceof GET) {
                parseHttpMethodAndPath("GET", ((GET) annotation).value(), false);
            } else if (annotation instanceof HEAD) {
                parseHttpMethodAndPath("HEAD", ((HEAD) annotation).value(), false);
            } else if (annotation instanceof PATCH) {
                parseHttpMethodAndPath("PATCH", ((PATCH) annotation).value(), true);
            } else if (annotation instanceof POST) {
                parseHttpMethodAndPath("POST", ((POST) annotation).value(), true);
            } else if (annotation instanceof PUT) {
                parseHttpMethodAndPath("PUT", ((PUT) annotation).value(), true);
            } else if (annotation instanceof OPTIONS) {
                parseHttpMethodAndPath("OPTIONS", ((OPTIONS) annotation).value(), false);
            } else if (annotation instanceof HTTP) {
                HTTP http = (HTTP) annotation;
                parseHttpMethodAndPath(http.method(), http.path(), http.hasBody());
            } else if (annotation instanceof retrofit2.http.Headers) {
                String[] value = ((retrofit2.http.Headers) annotation).value();
                if (value.length != 0) {
                    this.headers = parseHeaders(value);
                    return;
                }
                throw Utils.methodError(this.method, "@Headers annotation is empty.", new Object[0]);
            } else if (annotation instanceof Multipart) {
                if (!this.isFormEncoded) {
                    this.isMultipart = true;
                    return;
                }
                throw Utils.methodError(this.method, "Only one encoding annotation is allowed.", new Object[0]);
            } else if (!(annotation instanceof FormUrlEncoded)) {
            } else {
                if (!this.isMultipart) {
                    this.isFormEncoded = true;
                    return;
                }
                throw Utils.methodError(this.method, "Only one encoding annotation is allowed.", new Object[0]);
            }
        }

        private ParameterHandler<?> parseParameter(int i11, Type type, Annotation[] annotationArr, boolean z11) {
            ParameterHandler<?> parameterHandler;
            if (annotationArr != null) {
                parameterHandler = null;
                for (Annotation parseParameterAnnotation : annotationArr) {
                    ParameterHandler<?> parseParameterAnnotation2 = parseParameterAnnotation(i11, type, annotationArr, parseParameterAnnotation);
                    if (parseParameterAnnotation2 != null) {
                        if (parameterHandler == null) {
                            parameterHandler = parseParameterAnnotation2;
                        } else {
                            throw Utils.parameterError(this.method, i11, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                        }
                    }
                }
            } else {
                parameterHandler = null;
            }
            if (parameterHandler != null) {
                return parameterHandler;
            }
            if (z11) {
                try {
                    if (Utils.getRawType(type) == c.class) {
                        this.isKotlinSuspendFunction = true;
                        return null;
                    }
                } catch (NoClassDefFoundError unused) {
                }
            }
            throw Utils.parameterError(this.method, i11, "No Retrofit annotation found.", new Object[0]);
        }

        private ParameterHandler<?> parseParameterAnnotation(int i11, Type type, Annotation[] annotationArr, Annotation annotation) {
            Class<String> cls = String.class;
            Class<MultipartBody.Part> cls2 = MultipartBody.Part.class;
            if (annotation instanceof Url) {
                validateResolvableType(i11, type);
                if (this.gotUrl) {
                    throw Utils.parameterError(this.method, i11, "Multiple @Url method annotations found.", new Object[0]);
                } else if (this.gotPath) {
                    throw Utils.parameterError(this.method, i11, "@Path parameters may not be used with @Url.", new Object[0]);
                } else if (this.gotQuery) {
                    throw Utils.parameterError(this.method, i11, "A @Url parameter must not come after a @Query.", new Object[0]);
                } else if (this.gotQueryName) {
                    throw Utils.parameterError(this.method, i11, "A @Url parameter must not come after a @QueryName.", new Object[0]);
                } else if (this.gotQueryMap) {
                    throw Utils.parameterError(this.method, i11, "A @Url parameter must not come after a @QueryMap.", new Object[0]);
                } else if (this.relativeUrl == null) {
                    this.gotUrl = true;
                    if (type == HttpUrl.class || type == cls || type == URI.class || ((type instanceof Class) && "android.net.Uri".equals(((Class) type).getName()))) {
                        return new ParameterHandler.RelativeUrl(this.method, i11);
                    }
                    throw Utils.parameterError(this.method, i11, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
                } else {
                    throw Utils.parameterError(this.method, i11, "@Url cannot be used with @%s URL", this.httpMethod);
                }
            } else if (annotation instanceof Path) {
                validateResolvableType(i11, type);
                if (this.gotQuery) {
                    throw Utils.parameterError(this.method, i11, "A @Path parameter must not come after a @Query.", new Object[0]);
                } else if (this.gotQueryName) {
                    throw Utils.parameterError(this.method, i11, "A @Path parameter must not come after a @QueryName.", new Object[0]);
                } else if (this.gotQueryMap) {
                    throw Utils.parameterError(this.method, i11, "A @Path parameter must not come after a @QueryMap.", new Object[0]);
                } else if (this.gotUrl) {
                    throw Utils.parameterError(this.method, i11, "@Path parameters may not be used with @Url.", new Object[0]);
                } else if (this.relativeUrl != null) {
                    this.gotPath = true;
                    Path path = (Path) annotation;
                    String value = path.value();
                    validatePathName(i11, value);
                    return new ParameterHandler.Path(this.method, i11, value, this.retrofit.stringConverter(type, annotationArr), path.encoded());
                } else {
                    throw Utils.parameterError(this.method, i11, "@Path can only be used with relative url on @%s", this.httpMethod);
                }
            } else if (annotation instanceof Query) {
                validateResolvableType(i11, type);
                Query query = (Query) annotation;
                String value2 = query.value();
                boolean encoded = query.encoded();
                Class<?> rawType = Utils.getRawType(type);
                this.gotQuery = true;
                if (Iterable.class.isAssignableFrom(rawType)) {
                    if (type instanceof ParameterizedType) {
                        return new ParameterHandler.Query(value2, this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) type), annotationArr), encoded).iterable();
                    }
                    throw Utils.parameterError(this.method, i11, rawType.getSimpleName() + " must include generic type (e.g., " + rawType.getSimpleName() + "<String>)", new Object[0]);
                } else if (!rawType.isArray()) {
                    return new ParameterHandler.Query(value2, this.retrofit.stringConverter(type, annotationArr), encoded);
                } else {
                    return new ParameterHandler.Query(value2, this.retrofit.stringConverter(boxIfPrimitive(rawType.getComponentType()), annotationArr), encoded).array();
                }
            } else if (annotation instanceof QueryName) {
                validateResolvableType(i11, type);
                boolean encoded2 = ((QueryName) annotation).encoded();
                Class<?> rawType2 = Utils.getRawType(type);
                this.gotQueryName = true;
                if (Iterable.class.isAssignableFrom(rawType2)) {
                    if (type instanceof ParameterizedType) {
                        return new ParameterHandler.QueryName(this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) type), annotationArr), encoded2).iterable();
                    }
                    throw Utils.parameterError(this.method, i11, rawType2.getSimpleName() + " must include generic type (e.g., " + rawType2.getSimpleName() + "<String>)", new Object[0]);
                } else if (!rawType2.isArray()) {
                    return new ParameterHandler.QueryName(this.retrofit.stringConverter(type, annotationArr), encoded2);
                } else {
                    return new ParameterHandler.QueryName(this.retrofit.stringConverter(boxIfPrimitive(rawType2.getComponentType()), annotationArr), encoded2).array();
                }
            } else if (annotation instanceof QueryMap) {
                validateResolvableType(i11, type);
                Class<?> rawType3 = Utils.getRawType(type);
                this.gotQueryMap = true;
                if (Map.class.isAssignableFrom(rawType3)) {
                    Type supertype = Utils.getSupertype(type, rawType3, Map.class);
                    if (supertype instanceof ParameterizedType) {
                        ParameterizedType parameterizedType = (ParameterizedType) supertype;
                        Type parameterUpperBound = Utils.getParameterUpperBound(0, parameterizedType);
                        if (cls == parameterUpperBound) {
                            return new ParameterHandler.QueryMap(this.method, i11, this.retrofit.stringConverter(Utils.getParameterUpperBound(1, parameterizedType), annotationArr), ((QueryMap) annotation).encoded());
                        }
                        throw Utils.parameterError(this.method, i11, "@QueryMap keys must be of type String: " + parameterUpperBound, new Object[0]);
                    }
                    throw Utils.parameterError(this.method, i11, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                throw Utils.parameterError(this.method, i11, "@QueryMap parameter type must be Map.", new Object[0]);
            } else if (annotation instanceof Header) {
                validateResolvableType(i11, type);
                String value3 = ((Header) annotation).value();
                Class<?> rawType4 = Utils.getRawType(type);
                if (Iterable.class.isAssignableFrom(rawType4)) {
                    if (type instanceof ParameterizedType) {
                        return new ParameterHandler.Header(value3, this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) type), annotationArr)).iterable();
                    }
                    throw Utils.parameterError(this.method, i11, rawType4.getSimpleName() + " must include generic type (e.g., " + rawType4.getSimpleName() + "<String>)", new Object[0]);
                } else if (!rawType4.isArray()) {
                    return new ParameterHandler.Header(value3, this.retrofit.stringConverter(type, annotationArr));
                } else {
                    return new ParameterHandler.Header(value3, this.retrofit.stringConverter(boxIfPrimitive(rawType4.getComponentType()), annotationArr)).array();
                }
            } else if (annotation instanceof HeaderMap) {
                if (type == Headers.class) {
                    return new ParameterHandler.Headers(this.method, i11);
                }
                validateResolvableType(i11, type);
                Class<?> rawType5 = Utils.getRawType(type);
                if (Map.class.isAssignableFrom(rawType5)) {
                    Type supertype2 = Utils.getSupertype(type, rawType5, Map.class);
                    if (supertype2 instanceof ParameterizedType) {
                        ParameterizedType parameterizedType2 = (ParameterizedType) supertype2;
                        Type parameterUpperBound2 = Utils.getParameterUpperBound(0, parameterizedType2);
                        if (cls == parameterUpperBound2) {
                            return new ParameterHandler.HeaderMap(this.method, i11, this.retrofit.stringConverter(Utils.getParameterUpperBound(1, parameterizedType2), annotationArr));
                        }
                        throw Utils.parameterError(this.method, i11, "@HeaderMap keys must be of type String: " + parameterUpperBound2, new Object[0]);
                    }
                    throw Utils.parameterError(this.method, i11, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                throw Utils.parameterError(this.method, i11, "@HeaderMap parameter type must be Map.", new Object[0]);
            } else if (annotation instanceof Field) {
                validateResolvableType(i11, type);
                if (this.isFormEncoded) {
                    Field field = (Field) annotation;
                    String value4 = field.value();
                    boolean encoded3 = field.encoded();
                    this.gotField = true;
                    Class<?> rawType6 = Utils.getRawType(type);
                    if (Iterable.class.isAssignableFrom(rawType6)) {
                        if (type instanceof ParameterizedType) {
                            return new ParameterHandler.Field(value4, this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) type), annotationArr), encoded3).iterable();
                        }
                        throw Utils.parameterError(this.method, i11, rawType6.getSimpleName() + " must include generic type (e.g., " + rawType6.getSimpleName() + "<String>)", new Object[0]);
                    } else if (!rawType6.isArray()) {
                        return new ParameterHandler.Field(value4, this.retrofit.stringConverter(type, annotationArr), encoded3);
                    } else {
                        return new ParameterHandler.Field(value4, this.retrofit.stringConverter(boxIfPrimitive(rawType6.getComponentType()), annotationArr), encoded3).array();
                    }
                } else {
                    throw Utils.parameterError(this.method, i11, "@Field parameters can only be used with form encoding.", new Object[0]);
                }
            } else if (annotation instanceof FieldMap) {
                validateResolvableType(i11, type);
                if (this.isFormEncoded) {
                    Class<?> rawType7 = Utils.getRawType(type);
                    if (Map.class.isAssignableFrom(rawType7)) {
                        Type supertype3 = Utils.getSupertype(type, rawType7, Map.class);
                        if (supertype3 instanceof ParameterizedType) {
                            ParameterizedType parameterizedType3 = (ParameterizedType) supertype3;
                            Type parameterUpperBound3 = Utils.getParameterUpperBound(0, parameterizedType3);
                            if (cls == parameterUpperBound3) {
                                Converter stringConverter = this.retrofit.stringConverter(Utils.getParameterUpperBound(1, parameterizedType3), annotationArr);
                                this.gotField = true;
                                return new ParameterHandler.FieldMap(this.method, i11, stringConverter, ((FieldMap) annotation).encoded());
                            }
                            throw Utils.parameterError(this.method, i11, "@FieldMap keys must be of type String: " + parameterUpperBound3, new Object[0]);
                        }
                        throw Utils.parameterError(this.method, i11, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                    }
                    throw Utils.parameterError(this.method, i11, "@FieldMap parameter type must be Map.", new Object[0]);
                }
                throw Utils.parameterError(this.method, i11, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
            } else if (annotation instanceof Part) {
                validateResolvableType(i11, type);
                if (this.isMultipart) {
                    Part part = (Part) annotation;
                    this.gotPart = true;
                    String value5 = part.value();
                    Class<?> rawType8 = Utils.getRawType(type);
                    if (!value5.isEmpty()) {
                        Headers of2 = Headers.of(HttpHeaders.CONTENT_DISPOSITION, "form-data; name=\"" + value5 + "\"", "Content-Transfer-Encoding", part.encoding());
                        if (Iterable.class.isAssignableFrom(rawType8)) {
                            if (type instanceof ParameterizedType) {
                                Type parameterUpperBound4 = Utils.getParameterUpperBound(0, (ParameterizedType) type);
                                if (!cls2.isAssignableFrom(Utils.getRawType(parameterUpperBound4))) {
                                    return new ParameterHandler.Part(this.method, i11, of2, this.retrofit.requestBodyConverter(parameterUpperBound4, annotationArr, this.methodAnnotations)).iterable();
                                }
                                throw Utils.parameterError(this.method, i11, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                            }
                            throw Utils.parameterError(this.method, i11, rawType8.getSimpleName() + " must include generic type (e.g., " + rawType8.getSimpleName() + "<String>)", new Object[0]);
                        } else if (rawType8.isArray()) {
                            Class<?> boxIfPrimitive = boxIfPrimitive(rawType8.getComponentType());
                            if (!cls2.isAssignableFrom(boxIfPrimitive)) {
                                return new ParameterHandler.Part(this.method, i11, of2, this.retrofit.requestBodyConverter(boxIfPrimitive, annotationArr, this.methodAnnotations)).array();
                            }
                            throw Utils.parameterError(this.method, i11, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                        } else if (!cls2.isAssignableFrom(rawType8)) {
                            return new ParameterHandler.Part(this.method, i11, of2, this.retrofit.requestBodyConverter(type, annotationArr, this.methodAnnotations));
                        } else {
                            throw Utils.parameterError(this.method, i11, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                        }
                    } else if (Iterable.class.isAssignableFrom(rawType8)) {
                        if (!(type instanceof ParameterizedType)) {
                            throw Utils.parameterError(this.method, i11, rawType8.getSimpleName() + " must include generic type (e.g., " + rawType8.getSimpleName() + "<String>)", new Object[0]);
                        } else if (cls2.isAssignableFrom(Utils.getRawType(Utils.getParameterUpperBound(0, (ParameterizedType) type)))) {
                            return ParameterHandler.RawPart.INSTANCE.iterable();
                        } else {
                            throw Utils.parameterError(this.method, i11, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                        }
                    } else if (rawType8.isArray()) {
                        if (cls2.isAssignableFrom(rawType8.getComponentType())) {
                            return ParameterHandler.RawPart.INSTANCE.array();
                        }
                        throw Utils.parameterError(this.method, i11, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    } else if (cls2.isAssignableFrom(rawType8)) {
                        return ParameterHandler.RawPart.INSTANCE;
                    } else {
                        throw Utils.parameterError(this.method, i11, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    }
                } else {
                    throw Utils.parameterError(this.method, i11, "@Part parameters can only be used with multipart encoding.", new Object[0]);
                }
            } else if (annotation instanceof PartMap) {
                validateResolvableType(i11, type);
                if (this.isMultipart) {
                    this.gotPart = true;
                    Class<?> rawType9 = Utils.getRawType(type);
                    if (Map.class.isAssignableFrom(rawType9)) {
                        Type supertype4 = Utils.getSupertype(type, rawType9, Map.class);
                        if (supertype4 instanceof ParameterizedType) {
                            ParameterizedType parameterizedType4 = (ParameterizedType) supertype4;
                            Type parameterUpperBound5 = Utils.getParameterUpperBound(0, parameterizedType4);
                            if (cls == parameterUpperBound5) {
                                Type parameterUpperBound6 = Utils.getParameterUpperBound(1, parameterizedType4);
                                if (!cls2.isAssignableFrom(Utils.getRawType(parameterUpperBound6))) {
                                    return new ParameterHandler.PartMap(this.method, i11, this.retrofit.requestBodyConverter(parameterUpperBound6, annotationArr, this.methodAnnotations), ((PartMap) annotation).encoding());
                                }
                                throw Utils.parameterError(this.method, i11, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
                            }
                            throw Utils.parameterError(this.method, i11, "@PartMap keys must be of type String: " + parameterUpperBound5, new Object[0]);
                        }
                        throw Utils.parameterError(this.method, i11, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                    }
                    throw Utils.parameterError(this.method, i11, "@PartMap parameter type must be Map.", new Object[0]);
                }
                throw Utils.parameterError(this.method, i11, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
            } else if (annotation instanceof Body) {
                validateResolvableType(i11, type);
                if (this.isFormEncoded || this.isMultipart) {
                    throw Utils.parameterError(this.method, i11, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
                } else if (!this.gotBody) {
                    try {
                        Converter requestBodyConverter = this.retrofit.requestBodyConverter(type, annotationArr, this.methodAnnotations);
                        this.gotBody = true;
                        return new ParameterHandler.Body(this.method, i11, requestBodyConverter);
                    } catch (RuntimeException e11) {
                        throw Utils.parameterError(this.method, e11, i11, "Unable to create @Body converter for %s", type);
                    }
                } else {
                    throw Utils.parameterError(this.method, i11, "Multiple @Body method annotations found.", new Object[0]);
                }
            } else if (!(annotation instanceof Tag)) {
                return null;
            } else {
                validateResolvableType(i11, type);
                Class<?> rawType10 = Utils.getRawType(type);
                int i12 = i11 - 1;
                while (i12 >= 0) {
                    ParameterHandler<?> parameterHandler = this.parameterHandlers[i12];
                    if (!(parameterHandler instanceof ParameterHandler.Tag) || !((ParameterHandler.Tag) parameterHandler).cls.equals(rawType10)) {
                        i12--;
                    } else {
                        throw Utils.parameterError(this.method, i11, "@Tag type " + rawType10.getName() + " is duplicate of parameter #" + (i12 + 1) + " and would always overwrite its value.", new Object[0]);
                    }
                }
                return new ParameterHandler.Tag(rawType10);
            }
        }

        public static Set<String> parsePathParameters(String str) {
            Matcher matcher = PARAM_URL_REGEX.matcher(str);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            while (matcher.find()) {
                linkedHashSet.add(matcher.group(1));
            }
            return linkedHashSet;
        }

        private void validatePathName(int i11, String str) {
            if (!PARAM_NAME_REGEX.matcher(str).matches()) {
                throw Utils.parameterError(this.method, i11, "@Path parameter name must match %s. Found: %s", PARAM_URL_REGEX.pattern(), str);
            } else if (!this.relativeUrlParamNames.contains(str)) {
                throw Utils.parameterError(this.method, i11, "URL \"%s\" does not contain \"{%s}\".", this.relativeUrl, str);
            }
        }

        private void validateResolvableType(int i11, Type type) {
            if (Utils.hasUnresolvableType(type)) {
                throw Utils.parameterError(this.method, i11, "Parameter type must not include a type variable or wildcard: %s", type);
            }
        }

        public RequestFactory build() {
            for (Annotation parseMethodAnnotation : this.methodAnnotations) {
                parseMethodAnnotation(parseMethodAnnotation);
            }
            if (this.httpMethod != null) {
                if (!this.hasBody) {
                    if (this.isMultipart) {
                        throw Utils.methodError(this.method, "Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                    } else if (this.isFormEncoded) {
                        throw Utils.methodError(this.method, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                    }
                }
                int length = this.parameterAnnotationsArray.length;
                this.parameterHandlers = new ParameterHandler[length];
                int i11 = length - 1;
                int i12 = 0;
                while (true) {
                    boolean z11 = true;
                    if (i12 >= length) {
                        break;
                    }
                    ParameterHandler<?>[] parameterHandlerArr = this.parameterHandlers;
                    Type type = this.parameterTypes[i12];
                    Annotation[] annotationArr = this.parameterAnnotationsArray[i12];
                    if (i12 != i11) {
                        z11 = false;
                    }
                    parameterHandlerArr[i12] = parseParameter(i12, type, annotationArr, z11);
                    i12++;
                }
                if (this.relativeUrl != null || this.gotUrl) {
                    boolean z12 = this.isFormEncoded;
                    if (!z12 && !this.isMultipart && !this.hasBody && this.gotBody) {
                        throw Utils.methodError(this.method, "Non-body HTTP method cannot contain @Body.", new Object[0]);
                    } else if (z12 && !this.gotField) {
                        throw Utils.methodError(this.method, "Form-encoded method must contain at least one @Field.", new Object[0]);
                    } else if (!this.isMultipart || this.gotPart) {
                        return new RequestFactory(this);
                    } else {
                        throw Utils.methodError(this.method, "Multipart method must contain at least one @Part.", new Object[0]);
                    }
                } else {
                    throw Utils.methodError(this.method, "Missing either @%s URL or @Url parameter.", this.httpMethod);
                }
            } else {
                throw Utils.methodError(this.method, "HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
            }
        }
    }

    public RequestFactory(Builder builder) {
        this.method = builder.method;
        this.baseUrl = builder.retrofit.baseUrl;
        this.httpMethod = builder.httpMethod;
        this.relativeUrl = builder.relativeUrl;
        this.headers = builder.headers;
        this.contentType = builder.contentType;
        this.hasBody = builder.hasBody;
        this.isFormEncoded = builder.isFormEncoded;
        this.isMultipart = builder.isMultipart;
        this.parameterHandlers = builder.parameterHandlers;
        this.isKotlinSuspendFunction = builder.isKotlinSuspendFunction;
    }

    public static RequestFactory parseAnnotations(Retrofit retrofit, Method method2) {
        return new Builder(retrofit, method2).build();
    }

    public Request create(Object[] objArr) throws IOException {
        ParameterHandler<?>[] parameterHandlerArr = this.parameterHandlers;
        int length = objArr.length;
        if (length == parameterHandlerArr.length) {
            RequestBuilder requestBuilder = new RequestBuilder(this.httpMethod, this.baseUrl, this.relativeUrl, this.headers, this.contentType, this.hasBody, this.isFormEncoded, this.isMultipart);
            if (this.isKotlinSuspendFunction) {
                length--;
            }
            ArrayList arrayList = new ArrayList(length);
            for (int i11 = 0; i11 < length; i11++) {
                arrayList.add(objArr[i11]);
                parameterHandlerArr[i11].apply(requestBuilder, objArr[i11]);
            }
            return requestBuilder.get().tag(Invocation.class, new Invocation(this.method, arrayList)).build();
        }
        throw new IllegalArgumentException("Argument count (" + length + ") doesn't match expected count (" + parameterHandlerArr.length + ")");
    }
}
