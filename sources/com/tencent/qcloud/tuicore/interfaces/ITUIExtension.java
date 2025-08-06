package com.tencent.qcloud.tuicore.interfaces;

import android.view.View;
import java.util.List;
import java.util.Map;

public interface ITUIExtension {
    List<TUIExtensionInfo> onGetExtension(String str, Map<String, Object> map);

    @Deprecated
    Map<String, Object> onGetExtensionInfo(String str, Map<String, Object> map);

    void onRaiseExtension(String str, View view, Map<String, Object> map);
}
