package com.tencent.qcloud.tuicore;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.qcloud.tuicore.interfaces.ITUIService;
import com.tencent.qcloud.tuicore.interfaces.TUIServiceCallback;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class ServiceManager {
    private static final String TAG = "ServiceManager";
    private final Map<String, ITUIService> serviceMap;

    public static class ServiceManagerHolder {
        /* access modifiers changed from: private */
        public static final ServiceManager serviceManager = new ServiceManager();

        private ServiceManagerHolder() {
        }
    }

    public static ServiceManager getInstance() {
        return ServiceManagerHolder.serviceManager;
    }

    public Object callService(String str, String str2, Map<String, Object> map) {
        String str3 = TAG;
        Log.i(str3, "callService : " + str + " method : " + str2);
        ITUIService iTUIService = this.serviceMap.get(str);
        if (iTUIService != null) {
            return iTUIService.onCall(str2, map);
        }
        Log.w(str3, "can't find service : " + str);
        return null;
    }

    public ITUIService getService(String str) {
        String str2 = TAG;
        Log.i(str2, "getService : " + str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.serviceMap.get(str);
    }

    public void registerService(String str, ITUIService iTUIService) {
        String str2 = TAG;
        Log.i(str2, "registerService : " + str + "  " + iTUIService);
        if (!TextUtils.isEmpty(str) && iTUIService != null) {
            this.serviceMap.put(str, iTUIService);
        }
    }

    public void unregisterService(String str) {
        String str2 = TAG;
        Log.i(str2, "unregisterService : " + str);
        if (!TextUtils.isEmpty(str)) {
            this.serviceMap.remove(str);
        }
    }

    private ServiceManager() {
        this.serviceMap = new ConcurrentHashMap();
    }

    public <T> Object callService(String str, String str2, Map<String, Object> map, TUIServiceCallback tUIServiceCallback) {
        String str3 = TAG;
        Log.i(str3, "callService : " + str + " method : " + str2);
        ITUIService iTUIService = this.serviceMap.get(str);
        if (iTUIService != null) {
            return iTUIService.onCall(str2, map, tUIServiceCallback);
        }
        Log.w(str3, "can't find async service : " + str);
        return null;
    }
}
