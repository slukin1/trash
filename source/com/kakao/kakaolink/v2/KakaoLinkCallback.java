package com.kakao.kakaolink.v2;

import com.kakao.network.callback.ResponseCallback;
import rw.a;
import uw.c;

public abstract class KakaoLinkCallback extends ResponseCallback<a> {
    /* renamed from: b */
    public void onSuccess(a aVar) {
    }

    /* renamed from: c */
    public void onSuccessForUiThread(a aVar) {
        super.onSuccessForUiThread(aVar);
    }

    public final void onDidEnd() {
        super.onDidEnd();
    }

    public final void onDidStart() {
        super.onDidStart();
    }

    public void onFailure(c cVar) {
    }

    public void onFailureForUiThread(c cVar) {
        super.onFailureForUiThread(cVar);
    }
}
