package com.tencent.qcloud.tuikit.tuichat;

import com.tencent.qcloud.tuicore.interfaces.ITUINotification;
import com.tencent.qcloud.tuicore.interfaces.ITUIService;
import java.util.Map;

public interface ITUIChatService extends ITUIService, ITUINotification {
    Object onCall(String str, Map<String, Object> map);

    void onNotifyEvent(String str, String str2, Map<String, Object> map);
}
