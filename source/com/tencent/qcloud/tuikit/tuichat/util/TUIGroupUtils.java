package com.tencent.qcloud.tuikit.tuichat.util;

import com.tencent.qcloud.tuikit.timcommon.component.interfaces.IUIKitCallback;

public class TUIGroupUtils {
    public static <T> void callbackOnError(IUIKitCallback<T> iUIKitCallback, String str, int i11, String str2) {
        if (iUIKitCallback != null) {
            iUIKitCallback.onError(str, i11, str2);
        }
    }

    public static <T> void callbackOnSuccess(IUIKitCallback<T> iUIKitCallback, T t11) {
        if (iUIKitCallback != null) {
            iUIKitCallback.onSuccess(t11);
        }
    }

    public static String getConversationIdByUserId(String str, boolean z11) {
        String str2 = z11 ? "group_" : "c2c_";
        return str2 + str;
    }

    public static <T> void callbackOnError(IUIKitCallback<T> iUIKitCallback, int i11, String str) {
        if (iUIKitCallback != null) {
            iUIKitCallback.onError((String) null, i11, str);
        }
    }
}
