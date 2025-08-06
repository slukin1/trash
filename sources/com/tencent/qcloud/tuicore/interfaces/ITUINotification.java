package com.tencent.qcloud.tuicore.interfaces;

import java.util.Map;

public interface ITUINotification {
    void onNotifyEvent(String str, String str2, Map<String, Object> map);
}
