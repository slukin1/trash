package com.tencent.qcloud.tuicore.interfaces;

import java.util.Map;

public interface ITUIService {
    Object onCall(String str, Map<String, Object> map);

    Object onCall(String str, Map<String, Object> map, TUIServiceCallback tUIServiceCallback);
}
