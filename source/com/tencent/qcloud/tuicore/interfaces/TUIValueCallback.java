package com.tencent.qcloud.tuicore.interfaces;

public abstract class TUIValueCallback<T> {
    public static <T> void onError(TUIValueCallback<T> tUIValueCallback, int i11, String str) {
        if (tUIValueCallback != null) {
            tUIValueCallback.onError(i11, str);
        }
    }

    public static <T> void onSuccess(TUIValueCallback<T> tUIValueCallback, T t11) {
        if (tUIValueCallback != null) {
            tUIValueCallback.onSuccess(t11);
        }
    }

    public abstract void onError(int i11, String str);

    public abstract void onSuccess(T t11);
}
