package com.huawei.hms.common.internal;

public class ResolveClientBean {

    /* renamed from: a  reason: collision with root package name */
    private final int f37943a;

    /* renamed from: b  reason: collision with root package name */
    private final AnyClient f37944b;

    /* renamed from: c  reason: collision with root package name */
    private int f37945c;

    public ResolveClientBean(AnyClient anyClient, int i11) {
        this.f37944b = anyClient;
        this.f37943a = Objects.hashCode(anyClient);
        this.f37945c = i11;
    }

    public void clientReconnect() {
        this.f37944b.connect(this.f37945c, true);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ResolveClientBean)) {
            return false;
        }
        return this.f37944b.equals(((ResolveClientBean) obj).f37944b);
    }

    public AnyClient getClient() {
        return this.f37944b;
    }

    public int hashCode() {
        return this.f37943a;
    }
}
