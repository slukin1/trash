package com.jumio.core.model;

public interface Subscriber<Result> {
    void onError(Throwable th2);

    void onResult(Result result);
}
