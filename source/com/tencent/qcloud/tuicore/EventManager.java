package com.tencent.qcloud.tuicore;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.tencent.qcloud.tuicore.interfaces.ITUINotification;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

class EventManager {
    private static final String TAG = "EventManager";
    private final Map<Pair<String, String>, List<ITUINotification>> eventMap;

    public static class EventManagerHolder {
        /* access modifiers changed from: private */
        public static final EventManager eventManager = new EventManager();

        private EventManagerHolder() {
        }
    }

    public static EventManager getInstance() {
        return EventManagerHolder.eventManager;
    }

    public void notifyEvent(String str, String str2, Map<String, Object> map) {
        List<ITUINotification> list;
        String str3 = TAG;
        Log.i(str3, "notifyEvent : key : " + str + ", subKey : " + str2);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (list = this.eventMap.get(new Pair(str, str2))) != null) {
            for (ITUINotification onNotifyEvent : list) {
                onNotifyEvent.onNotifyEvent(str, str2, map);
            }
        }
    }

    public void registerEvent(String str, String str2, ITUINotification iTUINotification) {
        String str3 = TAG;
        Log.i(str3, "registerEvent : key : " + str + ", subKey : " + str2 + ", notification : " + iTUINotification);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && iTUINotification != null) {
            Pair pair = new Pair(str, str2);
            List list = this.eventMap.get(pair);
            if (list == null) {
                list = new CopyOnWriteArrayList();
                this.eventMap.put(pair, list);
            }
            if (!list.contains(iTUINotification)) {
                list.add(iTUINotification);
            }
        }
    }

    public void unRegisterEvent(String str, String str2, ITUINotification iTUINotification) {
        List list;
        String str3 = TAG;
        Log.i(str3, "removeEvent : key : " + str + ", subKey : " + str2 + " notification : " + iTUINotification);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && iTUINotification != null && (list = this.eventMap.get(new Pair(str, str2))) != null) {
            list.remove(iTUINotification);
        }
    }

    private EventManager() {
        this.eventMap = new ConcurrentHashMap();
    }

    public void unRegisterEvent(ITUINotification iTUINotification) {
        String str = TAG;
        Log.i(str, "removeEvent : notification : " + iTUINotification);
        if (iTUINotification != null) {
            for (Pair<String, String> pair : this.eventMap.keySet()) {
                List list = this.eventMap.get(pair);
                if (list != null) {
                    Iterator it2 = list.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            ITUINotification iTUINotification2 = (ITUINotification) it2.next();
                            if (iTUINotification2 == iTUINotification) {
                                list.remove(iTUINotification2);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        }
    }
}
