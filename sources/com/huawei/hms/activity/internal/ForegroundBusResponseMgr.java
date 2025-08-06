package com.huawei.hms.activity.internal;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class ForegroundBusResponseMgr {

    /* renamed from: b  reason: collision with root package name */
    private static final ForegroundBusResponseMgr f37684b = new ForegroundBusResponseMgr();

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, BusResponseCallback> f37685a = new HashMap();

    public static ForegroundBusResponseMgr getInstance() {
        return f37684b;
    }

    public BusResponseCallback get(String str) {
        BusResponseCallback busResponseCallback;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f37685a) {
            busResponseCallback = this.f37685a.get(str);
        }
        return busResponseCallback;
    }

    public void registerObserver(String str, BusResponseCallback busResponseCallback) {
        if (!TextUtils.isEmpty(str) && busResponseCallback != null) {
            synchronized (this.f37685a) {
                if (!this.f37685a.containsKey(str)) {
                    this.f37685a.put(str, busResponseCallback);
                }
            }
        }
    }

    public void unRegisterObserver(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.f37685a) {
                this.f37685a.remove(str);
            }
        }
    }
}
