package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Result;

public class Response<T extends Result> {
    private Result zza;

    public Response() {
    }

    public Response(T t11) {
        this.zza = t11;
    }

    public T getResult() {
        return this.zza;
    }

    public void setResult(T t11) {
        this.zza = t11;
    }
}
