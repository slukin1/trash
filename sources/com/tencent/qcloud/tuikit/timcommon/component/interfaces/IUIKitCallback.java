package com.tencent.qcloud.tuikit.timcommon.component.interfaces;

public abstract class IUIKitCallback<T> {
    public static <O> void callbackOnError(IUIKitCallback<O> iUIKitCallback, int i11, String str, O o11) {
        if (iUIKitCallback != null) {
            iUIKitCallback.onError(i11, str, o11);
        }
    }

    public static <O> void callbackOnSuccess(IUIKitCallback<O> iUIKitCallback, O o11) {
        if (iUIKitCallback != null) {
            iUIKitCallback.onSuccess(o11);
        }
    }

    public void onError(int i11, String str, T t11) {
    }

    public void onError(String str, int i11, String str2) {
    }

    public void onProgress(Object obj) {
    }

    public void onSuccess(T t11) {
    }
}
