package com.huawei.hms.aaid.plugin;

public class ProxyCenter {
    private PushProxy proxy;

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static ProxyCenter f37662a = new ProxyCenter();
    }

    private static ProxyCenter getInstance() {
        return a.f37662a;
    }

    public static PushProxy getProxy() {
        return getInstance().proxy;
    }

    public static void register(PushProxy pushProxy) {
        getInstance().proxy = pushProxy;
    }
}
