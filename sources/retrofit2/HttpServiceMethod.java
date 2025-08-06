package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.coroutines.c;
import okhttp3.Call;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Utils;

abstract class HttpServiceMethod<ResponseT, ReturnT> extends ServiceMethod<ReturnT> {
    private final Call.Factory callFactory;
    private final RequestFactory requestFactory;
    private final Converter<ResponseBody, ResponseT> responseConverter;

    public static final class CallAdapted<ResponseT, ReturnT> extends HttpServiceMethod<ResponseT, ReturnT> {
        private final CallAdapter<ResponseT, ReturnT> callAdapter;

        public CallAdapted(RequestFactory requestFactory, Call.Factory factory, Converter<ResponseBody, ResponseT> converter, CallAdapter<ResponseT, ReturnT> callAdapter2) {
            super(requestFactory, factory, converter);
            this.callAdapter = callAdapter2;
        }

        /* JADX WARNING: type inference failed for: r1v0, types: [retrofit2.Call, retrofit2.Call<ResponseT>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public ReturnT adapt(retrofit2.Call<ResponseT> r1, java.lang.Object[] r2) {
            /*
                r0 = this;
                retrofit2.CallAdapter<ResponseT, ReturnT> r2 = r0.callAdapter
                java.lang.Object r1 = r2.adapt(r1)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: retrofit2.HttpServiceMethod.CallAdapted.adapt(retrofit2.Call, java.lang.Object[]):java.lang.Object");
        }
    }

    public static final class SuspendForBody<ResponseT> extends HttpServiceMethod<ResponseT, Object> {
        private final CallAdapter<ResponseT, Call<ResponseT>> callAdapter;
        private final boolean isNullable;

        public SuspendForBody(RequestFactory requestFactory, Call.Factory factory, Converter<ResponseBody, ResponseT> converter, CallAdapter<ResponseT, Call<ResponseT>> callAdapter2, boolean z11) {
            super(requestFactory, factory, converter);
            this.callAdapter = callAdapter2;
            this.isNullable = z11;
        }

        public Object adapt(Call<ResponseT> call, Object[] objArr) {
            Call call2 = (Call) this.callAdapter.adapt(call);
            c cVar = objArr[objArr.length - 1];
            try {
                if (this.isNullable) {
                    return KotlinExtensions.awaitNullable(call2, cVar);
                }
                return KotlinExtensions.await(call2, cVar);
            } catch (Exception e11) {
                return KotlinExtensions.suspendAndThrow(e11, cVar);
            }
        }
    }

    public static final class SuspendForResponse<ResponseT> extends HttpServiceMethod<ResponseT, Object> {
        private final CallAdapter<ResponseT, Call<ResponseT>> callAdapter;

        public SuspendForResponse(RequestFactory requestFactory, Call.Factory factory, Converter<ResponseBody, ResponseT> converter, CallAdapter<ResponseT, Call<ResponseT>> callAdapter2) {
            super(requestFactory, factory, converter);
            this.callAdapter = callAdapter2;
        }

        public Object adapt(Call<ResponseT> call, Object[] objArr) {
            Call call2 = (Call) this.callAdapter.adapt(call);
            c cVar = objArr[objArr.length - 1];
            try {
                return KotlinExtensions.awaitResponse(call2, cVar);
            } catch (Exception e11) {
                return KotlinExtensions.suspendAndThrow(e11, cVar);
            }
        }
    }

    public HttpServiceMethod(RequestFactory requestFactory2, Call.Factory factory, Converter<ResponseBody, ResponseT> converter) {
        this.requestFactory = requestFactory2;
        this.callFactory = factory;
        this.responseConverter = converter;
    }

    private static <ResponseT, ReturnT> CallAdapter<ResponseT, ReturnT> createCallAdapter(Retrofit retrofit, Method method, Type type, Annotation[] annotationArr) {
        try {
            return retrofit.callAdapter(type, annotationArr);
        } catch (RuntimeException e11) {
            throw Utils.methodError(method, e11, "Unable to create call adapter for %s", type);
        }
    }

    private static <ResponseT> Converter<ResponseBody, ResponseT> createResponseConverter(Retrofit retrofit, Method method, Type type) {
        try {
            return retrofit.responseBodyConverter(type, method.getAnnotations());
        } catch (RuntimeException e11) {
            throw Utils.methodError(method, e11, "Unable to create converter for %s", type);
        }
    }

    public static <ResponseT, ReturnT> HttpServiceMethod<ResponseT, ReturnT> parseAnnotations(Retrofit retrofit, Method method, RequestFactory requestFactory2) {
        Type type;
        boolean z11;
        Class<Response> cls = Response.class;
        boolean z12 = requestFactory2.isKotlinSuspendFunction;
        Annotation[] annotations = method.getAnnotations();
        if (z12) {
            Type[] genericParameterTypes = method.getGenericParameterTypes();
            Type parameterLowerBound = Utils.getParameterLowerBound(0, (ParameterizedType) genericParameterTypes[genericParameterTypes.length - 1]);
            if (Utils.getRawType(parameterLowerBound) != cls || !(parameterLowerBound instanceof ParameterizedType)) {
                z11 = false;
            } else {
                parameterLowerBound = Utils.getParameterUpperBound(0, (ParameterizedType) parameterLowerBound);
                z11 = true;
            }
            type = new Utils.ParameterizedTypeImpl((Type) null, Call.class, parameterLowerBound);
            annotations = SkipCallbackExecutorImpl.ensurePresent(annotations);
        } else {
            type = method.getGenericReturnType();
            z11 = false;
        }
        CallAdapter createCallAdapter = createCallAdapter(retrofit, method, type, annotations);
        Type responseType = createCallAdapter.responseType();
        if (responseType == Response.class) {
            throw Utils.methodError(method, "'" + Utils.getRawType(responseType).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
        } else if (responseType == cls) {
            throw Utils.methodError(method, "Response must include generic type (e.g., Response<String>)", new Object[0]);
        } else if (!requestFactory2.httpMethod.equals("HEAD") || Void.class.equals(responseType)) {
            Converter createResponseConverter = createResponseConverter(retrofit, method, responseType);
            Call.Factory factory = retrofit.callFactory;
            if (!z12) {
                return new CallAdapted(requestFactory2, factory, createResponseConverter, createCallAdapter);
            }
            if (z11) {
                return new SuspendForResponse(requestFactory2, factory, createResponseConverter, createCallAdapter);
            }
            return new SuspendForBody(requestFactory2, factory, createResponseConverter, createCallAdapter, false);
        } else {
            throw Utils.methodError(method, "HEAD method must use Void as response type.", new Object[0]);
        }
    }

    public abstract ReturnT adapt(Call<ResponseT> call, Object[] objArr);

    public final ReturnT invoke(Object[] objArr) {
        return adapt(new OkHttpCall(this.requestFactory, objArr, this.callFactory, this.responseConverter), objArr);
    }
}
