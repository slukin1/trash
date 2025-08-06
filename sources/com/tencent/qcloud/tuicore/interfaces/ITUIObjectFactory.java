package com.tencent.qcloud.tuicore.interfaces;

import java.util.Map;

public interface ITUIObjectFactory {
    Object onCreateObject(String str, Map<String, Object> map);
}
