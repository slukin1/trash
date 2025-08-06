package com.tencent.qcloud.tuicore.interfaces;

public abstract class TUICallback {
    public static void onError(TUICallback tUICallback, int i11, String str) {
        if (tUICallback != null) {
            tUICallback.onError(i11, str);
        }
    }

    public static void onSuccess(TUICallback tUICallback) {
        if (tUICallback != null) {
            tUICallback.onSuccess();
        }
    }

    public abstract void onError(int i11, String str);

    public abstract void onSuccess();
}
