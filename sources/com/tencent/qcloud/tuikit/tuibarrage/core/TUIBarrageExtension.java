package com.tencent.qcloud.tuikit.tuibarrage.core;

import android.content.Context;
import android.view.View;
import com.tencent.qcloud.tuicore.interfaces.ITUIExtension;
import com.tencent.qcloud.tuikit.tuibarrage.view.TUIBarrageButton;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import zy.a;

public class TUIBarrageExtension implements ITUIExtension {
    public static final String KEY_DISPLAY_VIEW = "TUIBarrageDisplayView";
    public static final String KEY_SEND_VIEW = "TUIBarrageButton";
    public static final String OBJECT_TUI_BARRAGE = "com.tencent.qcloud.tuikit.tuibarrage.core.TUIBarrageExtension";
    private static final String TAG = "TUIBarrageExtension";

    public /* synthetic */ List onGetExtension(String str, Map map) {
        return a.a(this, str, map);
    }

    public Map<String, Object> onGetExtensionInfo(String str, Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        if (!OBJECT_TUI_BARRAGE.equals(str)) {
            return null;
        }
        hashMap.put(KEY_SEND_VIEW, new TUIBarrageButton((Context) map.get("context"), (String) map.get("groupId")));
        return hashMap;
    }

    public /* synthetic */ void onRaiseExtension(String str, View view, Map map) {
        a.c(this, str, view, map);
    }
}
