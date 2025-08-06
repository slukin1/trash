package com.jumio.core.api;

import com.jumio.core.model.Subscriber;
import com.jumio.core.models.ApiCallDataModel;
import com.jumio.core.network.ApiCall;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import jumio.core.h;
import jumio.core.i;

public final class SingleProcessor implements Subscriber<Object> {

    /* renamed from: a  reason: collision with root package name */
    public final ExecutorService f39053a;

    /* renamed from: b  reason: collision with root package name */
    public final h f39054b;

    /* renamed from: c  reason: collision with root package name */
    public final i f39055c;

    /* renamed from: d  reason: collision with root package name */
    public ApiCall<?> f39056d;

    /* renamed from: e  reason: collision with root package name */
    public Future<ApiCall<?>> f39057e;

    public SingleProcessor(ExecutorService executorService, h hVar, i iVar) {
        this.f39053a = executorService;
        this.f39054b = hVar;
        this.f39055c = iVar;
    }

    public final void a(ApiCallDataModel<?> apiCallDataModel) {
        if (this.f39057e == null) {
            ApiCall<?> apiCall = (ApiCall) apiCallDataModel.getCall().getDeclaredConstructor(new Class[]{h.class, ApiCallDataModel.class}).newInstance(new Object[]{this.f39054b, apiCallDataModel});
            this.f39056d = apiCall;
            apiCall.add(this);
            this.f39057e = this.f39053a.submit(this.f39056d);
            return;
        }
        throw new IllegalArgumentException("Another call is being executed".toString());
    }

    public void onError(Throwable th2) {
        ApiCall<?> apiCall = this.f39056d;
        if (apiCall != null) {
            this.f39055c.onError(apiCall.getApiCallDataModel(), th2);
        }
        this.f39057e = null;
    }

    public void onResult(Object obj) {
        ApiCall<?> apiCall = this.f39056d;
        if (apiCall != null) {
            this.f39055c.onResult(apiCall.getApiCallDataModel(), obj);
        }
        this.f39057e = null;
    }
}
