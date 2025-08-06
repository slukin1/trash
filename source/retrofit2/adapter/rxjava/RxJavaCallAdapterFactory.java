package retrofit2.adapter.rxjava;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import retrofit2.CallAdapter;
import retrofit2.Response;
import retrofit2.Retrofit;
import rx.Completable;
import rx.Observable;
import rx.Scheduler;
import rx.Single;

public final class RxJavaCallAdapterFactory extends CallAdapter.Factory {
    private final boolean isAsync;
    private final Scheduler scheduler;

    private RxJavaCallAdapterFactory(Scheduler scheduler2, boolean z11) {
        this.scheduler = scheduler2;
        this.isAsync = z11;
    }

    public static RxJavaCallAdapterFactory create() {
        return new RxJavaCallAdapterFactory((Scheduler) null, false);
    }

    public static RxJavaCallAdapterFactory createAsync() {
        return new RxJavaCallAdapterFactory((Scheduler) null, true);
    }

    public static RxJavaCallAdapterFactory createWithScheduler(Scheduler scheduler2) {
        Objects.requireNonNull(scheduler2, "scheduler == null");
        return new RxJavaCallAdapterFactory(scheduler2, false);
    }

    public CallAdapter<?, ?> get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        boolean z11;
        boolean z12;
        Type type2;
        Class<?> rawType = CallAdapter.Factory.getRawType(type);
        boolean z13 = rawType == Single.class;
        boolean z14 = rawType == Completable.class;
        if (rawType != Observable.class && !z13 && !z14) {
            return null;
        }
        if (z14) {
            return new RxJavaCallAdapter(Void.class, this.scheduler, this.isAsync, false, true, false, true);
        }
        if (!(type instanceof ParameterizedType)) {
            String str = z13 ? "Single" : "Observable";
            throw new IllegalStateException(str + " return type must be parameterized as " + str + "<Foo> or " + str + "<? extends Foo>");
        }
        Type parameterUpperBound = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) type);
        Class<?> rawType2 = CallAdapter.Factory.getRawType(parameterUpperBound);
        if (rawType2 == Response.class) {
            if (parameterUpperBound instanceof ParameterizedType) {
                type2 = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) parameterUpperBound);
                z12 = false;
                z11 = false;
            } else {
                throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
            }
        } else if (rawType2 != Result.class) {
            type2 = parameterUpperBound;
            z11 = true;
            z12 = false;
        } else if (parameterUpperBound instanceof ParameterizedType) {
            type2 = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) parameterUpperBound);
            z12 = true;
            z11 = false;
        } else {
            throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
        }
        return new RxJavaCallAdapter(type2, this.scheduler, this.isAsync, z12, z11, z13, false);
    }
}
