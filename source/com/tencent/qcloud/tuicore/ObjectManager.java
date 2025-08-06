package com.tencent.qcloud.tuicore;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.qcloud.tuicore.interfaces.ITUIObjectFactory;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class ObjectManager {
    private static final String TAG = "ObjectManager";
    private final Map<String, ITUIObjectFactory> objectFactoryMap;

    public static class ObjectManagerHolder {
        /* access modifiers changed from: private */
        public static final ObjectManager serviceManager = new ObjectManager();

        private ObjectManagerHolder() {
        }
    }

    public static ObjectManager getInstance() {
        return ObjectManagerHolder.serviceManager;
    }

    public Object createObject(String str, String str2, Map<String, Object> map) {
        String str3 = TAG;
        Log.i(str3, "createObject : " + str + " objectName : " + str2);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ITUIObjectFactory iTUIObjectFactory = this.objectFactoryMap.get(str);
        if (iTUIObjectFactory != null) {
            return iTUIObjectFactory.onCreateObject(str2, map);
        }
        Log.w(str3, "can't find objectFactory : " + str);
        return null;
    }

    public void registerObjectFactory(String str, ITUIObjectFactory iTUIObjectFactory) {
        String str2 = TAG;
        Log.i(str2, "registerObjectFactory : " + str + "  " + iTUIObjectFactory);
        if (!TextUtils.isEmpty(str) && iTUIObjectFactory != null) {
            this.objectFactoryMap.put(str, iTUIObjectFactory);
        }
    }

    public void unregisterObjectFactory(String str) {
        String str2 = TAG;
        Log.i(str2, "unregisterObjectFactory : " + str);
        if (!TextUtils.isEmpty(str)) {
            this.objectFactoryMap.remove(str);
        }
    }

    private ObjectManager() {
        this.objectFactoryMap = new ConcurrentHashMap();
    }
}
