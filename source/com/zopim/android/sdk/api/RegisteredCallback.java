package com.zopim.android.sdk.api;

abstract class RegisteredCallback<T> {
    private boolean registered = true;

    public boolean isRegistered() {
        return this.registered;
    }

    public abstract void onError(ErrorResponse errorResponse);

    public void onErrorInternal(ErrorResponse errorResponse) {
        if (this.registered) {
            onError(errorResponse);
        }
    }

    public abstract void onSuccess(T t11);

    public void onSuccessInternal(T t11) {
        if (this.registered) {
            onSuccess(t11);
        }
    }

    public void unregister() {
        this.registered = false;
    }
}
