package com.huawei.agconnect.core.a;

import com.huawei.agconnect.AGCInitFinishManager;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class a extends AGCInitFinishManager {

    /* renamed from: a  reason: collision with root package name */
    private static final List<AGCInitFinishManager.AGCInitFinishCallback> f37530a = new CopyOnWriteArrayList();

    public static void a() {
        for (AGCInitFinishManager.AGCInitFinishCallback onFinish : f37530a) {
            onFinish.onFinish();
        }
    }

    public void addAGCInitFinishCallback(AGCInitFinishManager.AGCInitFinishCallback aGCInitFinishCallback) {
        if (aGCInitFinishCallback != null) {
            f37530a.add(aGCInitFinishCallback);
        }
    }
}
