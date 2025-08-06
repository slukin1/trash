package com.tencent.tpns.baseapi.core.net;

public interface HttpRequestCallback {
    void onFailure(int i11, String str);

    void onSuccess(String str);
}
