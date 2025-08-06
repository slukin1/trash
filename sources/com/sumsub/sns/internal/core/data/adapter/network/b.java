package com.sumsub.sns.internal.core.data.adapter.network;

import com.sumsub.sns.internal.core.common.x0;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.jvm.internal.x;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;

public final class b extends CallAdapter.Factory {

    /* renamed from: a  reason: collision with root package name */
    public final x0 f32332a;

    public b(x0 x0Var) {
        this.f32332a = x0Var;
    }

    public CallAdapter<?, ?> get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (!x.b(Call.class, CallAdapter.Factory.getRawType(type))) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            return new a(CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) type), retrofit.nextResponseBodyConverter((Converter.Factory) null, com.sumsub.sns.internal.core.data.model.remote.response.b.class, annotationArr), this.f32332a);
        }
        throw new IllegalStateException("return type must be parameterized as Call<NetworkResponse<<Foo>> or Call<NetworkResponse<out Foo>>".toString());
    }
}
