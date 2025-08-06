package com.jumio.core.network;

import com.jumio.core.models.ApiCallDataModel;
import jumio.core.i;

public interface ApiBinding extends i {
    Class<? extends ApiCall<?>>[] getBindingClasses();

    /* synthetic */ void onError(ApiCallDataModel<?> apiCallDataModel, Throwable th2);

    /* synthetic */ void onResult(ApiCallDataModel<?> apiCallDataModel, Object obj);
}
