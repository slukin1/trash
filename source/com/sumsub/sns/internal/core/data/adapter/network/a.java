package com.sumsub.sns.internal.core.data.adapter.network;

import com.sumsub.sns.internal.core.common.x0;
import java.lang.reflect.Type;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Converter;

public final class a<S, E> implements CallAdapter<S, Call<S>> {

    /* renamed from: a  reason: collision with root package name */
    public final Type f32329a;

    /* renamed from: b  reason: collision with root package name */
    public final Converter<ResponseBody, E> f32330b;

    /* renamed from: c  reason: collision with root package name */
    public final x0 f32331c;

    public a(Type type, Converter<ResponseBody, E> converter, x0 x0Var) {
        this.f32329a = type;
        this.f32330b = converter;
        this.f32331c = x0Var;
    }

    /* renamed from: a */
    public Call<S> adapt(Call<S> call) {
        return new c(call, this.f32330b, this.f32331c);
    }

    public Type responseType() {
        return this.f32329a;
    }
}
