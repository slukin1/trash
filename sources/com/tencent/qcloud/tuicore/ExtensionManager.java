package com.tencent.qcloud.tuicore;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.tencent.qcloud.tuicore.interfaces.ITUIExtension;
import com.tencent.qcloud.tuicore.interfaces.TUIExtensionInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

class ExtensionManager {
    private static final String TAG = "ExtensionManager";
    private final Map<String, List<ITUIExtension>> extensionHashMap;

    public static class ExtensionManagerHolder {
        /* access modifiers changed from: private */
        public static final ExtensionManager extensionManager = new ExtensionManager();

        private ExtensionManagerHolder() {
        }
    }

    public static ExtensionManager getInstance() {
        return ExtensionManagerHolder.extensionManager;
    }

    @Deprecated
    public Map<String, Object> getExtensionInfo(String str, Map<String, Object> map) {
        List list;
        String str2 = TAG;
        Log.i(str2, "getExtensionInfo key : " + str);
        if (TextUtils.isEmpty(str) || (list = this.extensionHashMap.get(str)) == null) {
            return null;
        }
        Iterator it2 = list.iterator();
        if (it2.hasNext()) {
            return ((ITUIExtension) it2.next()).onGetExtensionInfo(str, map);
        }
        return null;
    }

    public List<TUIExtensionInfo> getExtensionList(String str, Map<String, Object> map) {
        List<ITUIExtension> list;
        String str2 = TAG;
        Log.i(str2, "getExtensionInfoList extensionID : " + str);
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str) && (list = this.extensionHashMap.get(str)) != null && !list.isEmpty()) {
            for (ITUIExtension onGetExtension : list) {
                List<TUIExtensionInfo> onGetExtension2 = onGetExtension.onGetExtension(str, map);
                if (onGetExtension2 != null) {
                    arrayList.addAll(onGetExtension2);
                }
            }
        }
        return arrayList;
    }

    public void raiseExtension(String str, View view, Map<String, Object> map) {
        List list;
        String str2 = TAG;
        Log.i(str2, "raiseExtension extensionID : " + str);
        if (!TextUtils.isEmpty(str) && (list = this.extensionHashMap.get(str)) != null) {
            Iterator it2 = list.iterator();
            if (it2.hasNext()) {
                ((ITUIExtension) it2.next()).onRaiseExtension(str, view, map);
            }
        }
    }

    public void registerExtension(String str, ITUIExtension iTUIExtension) {
        String str2 = TAG;
        Log.i(str2, "registerExtension extensionID : " + str + ", extension : " + iTUIExtension);
        if (!TextUtils.isEmpty(str) && iTUIExtension != null) {
            List list = this.extensionHashMap.get(str);
            if (list == null) {
                list = new CopyOnWriteArrayList();
                this.extensionHashMap.put(str, list);
            }
            if (!list.contains(iTUIExtension)) {
                list.add(iTUIExtension);
            }
        }
    }

    public void unRegisterExtension(String str, ITUIExtension iTUIExtension) {
        List list;
        String str2 = TAG;
        Log.i(str2, "removeExtension extensionID : " + str + ", extension : " + iTUIExtension);
        if (!TextUtils.isEmpty(str) && iTUIExtension != null && (list = this.extensionHashMap.get(str)) != null) {
            list.remove(iTUIExtension);
        }
    }

    private ExtensionManager() {
        this.extensionHashMap = new ConcurrentHashMap();
    }
}
