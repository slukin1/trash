package com.hbg.lib.network.retrofit.request.callback;

public abstract class RequestCallback1<T> {
    public boolean isAlive() {
        return true;
    }

    public void onRequestFailure(Throwable th2) {
    }

    public void onRequestStart() {
    }

    public abstract void onRequestSuccess(T t11);

    public T onRequestSuccessAsync(T t11) {
        return t11;
    }
}
