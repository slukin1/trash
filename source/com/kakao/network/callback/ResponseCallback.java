package com.kakao.network.callback;

import uw.c;

public abstract class ResponseCallback<T> {
    public void onDidEnd() {
    }

    public void onDidStart() {
    }

    public abstract void onFailure(c cVar);

    public void onFailureForUiThread(c cVar) {
        onFailure(cVar);
    }

    public abstract void onSuccess(T t11);

    public void onSuccessForUiThread(T t11) {
        onSuccess(t11);
    }
}
