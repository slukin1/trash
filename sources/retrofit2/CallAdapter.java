package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public interface CallAdapter<R, T> {

    public static abstract class Factory {
        public static Type getParameterUpperBound(int i11, ParameterizedType parameterizedType) {
            return Utils.getParameterUpperBound(i11, parameterizedType);
        }

        public static Class<?> getRawType(Type type) {
            return Utils.getRawType(type);
        }

        public abstract CallAdapter<?, ?> get(Type type, Annotation[] annotationArr, Retrofit retrofit);
    }

    T adapt(Call<R> call);

    Type responseType();
}
