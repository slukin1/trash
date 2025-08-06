package com.jumio.core.model;

public interface SubscriberWithUpdate<Update, Result> extends Subscriber<Result> {
    /* synthetic */ void onError(Throwable th2);

    /* synthetic */ void onResult(Result result);

    void onUpdate(Update update);
}
