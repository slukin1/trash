package com.tencent.imsdk.common;

import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMCompleteCallback;
import com.tencent.imsdk.v2.V2TIMValueCallback;

public abstract class IMCallback<T> {
    public V2TIMCallback callback;
    public V2TIMCompleteCallback<T> completeCallback;
    public V2TIMValueCallback<T> valueCallback;

    public IMCallback(V2TIMCallback v2TIMCallback) {
        this.callback = v2TIMCallback;
    }

    public void fail(final int i11, final String str) {
        IMContext.getInstance().runOnMainThread(new Runnable() {
            public void run() {
                IMCallback iMCallback = IMCallback.this;
                V2TIMCallback v2TIMCallback = iMCallback.callback;
                if (v2TIMCallback != null) {
                    v2TIMCallback.onError(i11, str);
                    return;
                }
                V2TIMValueCallback<T> v2TIMValueCallback = iMCallback.valueCallback;
                if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onError(i11, str);
                }
            }
        });
    }

    public void success(final T t11) {
        IMContext.getInstance().runOnMainThread(new Runnable() {
            public void run() {
                IMCallback iMCallback = IMCallback.this;
                V2TIMCallback v2TIMCallback = iMCallback.callback;
                if (v2TIMCallback != null) {
                    v2TIMCallback.onSuccess();
                    return;
                }
                V2TIMValueCallback<T> v2TIMValueCallback = iMCallback.valueCallback;
                if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onSuccess(t11);
                    return;
                }
                V2TIMCompleteCallback<T> v2TIMCompleteCallback = iMCallback.completeCallback;
                if (v2TIMCompleteCallback != null) {
                    v2TIMCompleteCallback.onComplete(0, "", t11);
                }
            }
        });
    }

    public void fail(final int i11, final String str, final T t11) {
        IMContext.getInstance().runOnMainThread(new Runnable() {
            public void run() {
                IMCallback iMCallback = IMCallback.this;
                V2TIMCallback v2TIMCallback = iMCallback.callback;
                if (v2TIMCallback != null) {
                    v2TIMCallback.onError(i11, str);
                    return;
                }
                V2TIMValueCallback<T> v2TIMValueCallback = iMCallback.valueCallback;
                if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onError(i11, str);
                    return;
                }
                V2TIMCompleteCallback<T> v2TIMCompleteCallback = iMCallback.completeCallback;
                if (v2TIMCompleteCallback != null) {
                    v2TIMCompleteCallback.onComplete(i11, str, t11);
                }
            }
        });
    }

    public IMCallback(V2TIMValueCallback<T> v2TIMValueCallback) {
        this.valueCallback = v2TIMValueCallback;
    }

    public IMCallback(V2TIMCompleteCallback<T> v2TIMCompleteCallback) {
        this.completeCallback = v2TIMCompleteCallback;
    }
}
