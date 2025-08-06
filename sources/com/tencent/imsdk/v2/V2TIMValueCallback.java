package com.tencent.imsdk.v2;

public interface V2TIMValueCallback<T> {
    void onError(int i11, String str);

    void onSuccess(T t11);
}
