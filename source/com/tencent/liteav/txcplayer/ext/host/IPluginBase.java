package com.tencent.liteav.txcplayer.ext.host;

import android.content.Context;
import java.util.Map;

public interface IPluginBase {
    PluginInfo getPluginInfo();

    void handleAsyncRequest(int i11, int i12, Map<String, Object> map, PluginCallback pluginCallback);

    void handleSyncRequest(int i11, int i12, Map<String, Object> map, Map<String, Object> map2);

    void onCreate(Context context);

    void onDestroy();
}
