package com.tencent.qcloud.tuikit.tuicallkit;

import android.content.Context;
import com.tencent.qcloud.tuikit.TUICommonDefine;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallObserver;
import java.util.List;

public abstract class TUICallKit {
    public static TUICallKit createInstance(Context context) {
        return TUICallKitImpl.createInstance(context);
    }

    public static TUICallKit getInstance() {
        return TUICallKitImpl.getInstance();
    }

    public void call(String str, TUICallDefine.MediaType mediaType) {
    }

    public void call(String str, TUICallDefine.MediaType mediaType, TUICallDefine.CallParams callParams, TUICommonDefine.Callback callback) {
    }

    public TUICallKit enableFloatWindow(boolean z11) {
        return this;
    }

    public void enableMuteMode(boolean z11) {
    }

    public void groupCall(String str, List<String> list, TUICallDefine.MediaType mediaType) {
    }

    public void groupCall(String str, List<String> list, TUICallDefine.MediaType mediaType, TUICallDefine.CallParams callParams, TUICommonDefine.Callback callback) {
    }

    public void hangup(TUICommonDefine.Callback callback) {
    }

    public void joinInGroupCall(TUICommonDefine.RoomId roomId, String str, TUICallDefine.MediaType mediaType) {
    }

    public void setCallingBell(String str) {
    }

    public void setSelfInfo(String str, String str2, TUICommonDefine.Callback callback) {
    }

    public TUICallKit setTUICallObserverOut(TUICallObserver tUICallObserver) {
        return this;
    }
}
