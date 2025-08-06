package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ep;
import com.xiaomi.push.service.XMPushService;

class as {

    /* renamed from: d  reason: collision with root package name */
    private static int f52518d = 300000;

    /* renamed from: a  reason: collision with root package name */
    private int f52519a;

    /* renamed from: a  reason: collision with other field name */
    private long f3356a;

    /* renamed from: a  reason: collision with other field name */
    private XMPushService f3357a;

    /* renamed from: b  reason: collision with root package name */
    private int f52520b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f52521c = 0;

    public as(XMPushService xMPushService) {
        this.f3357a = xMPushService;
        this.f52519a = 500;
        this.f3356a = 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m3001a() {
        this.f3356a = System.currentTimeMillis();
        this.f3357a.a(1);
        this.f52520b = 0;
    }

    public void a(boolean z11) {
        if (!this.f3357a.a()) {
            b.c("should not reconnect as no client or network.");
        } else if (z11) {
            if (!this.f3357a.a(1)) {
                this.f52520b++;
            }
            this.f3357a.a(1);
            b.a("ReconnectionManager", "-->tryReconnect(): exec ConnectJob");
            XMPushService xMPushService = this.f3357a;
            xMPushService.getClass();
            xMPushService.a((XMPushService.j) new XMPushService.e());
        } else if (!this.f3357a.a(1)) {
            int a11 = a();
            this.f52520b++;
            b.a("schedule reconnect in " + a11 + "ms");
            XMPushService xMPushService2 = this.f3357a;
            xMPushService2.getClass();
            xMPushService2.a((XMPushService.j) new XMPushService.e(), (long) a11);
            if (this.f52520b == 2 && ep.a().a()) {
                z.b();
            }
            if (this.f52520b == 3) {
                z.a();
            }
        }
    }

    private int a() {
        double d11;
        if (this.f52520b > 8) {
            return 300000;
        }
        double random = (Math.random() * 2.0d) + 1.0d;
        int i11 = this.f52520b;
        if (i11 > 4) {
            d11 = 60000.0d;
        } else if (i11 > 1) {
            d11 = 10000.0d;
        } else if (this.f3356a == 0) {
            return 0;
        } else {
            if (System.currentTimeMillis() - this.f3356a < 310000) {
                int i12 = this.f52519a;
                int i13 = f52518d;
                if (i12 >= i13) {
                    return i12;
                }
                int i14 = this.f52521c + 1;
                this.f52521c = i14;
                if (i14 >= 4) {
                    return i13;
                }
                this.f52519a = (int) (((double) i12) * 1.5d);
                return i12;
            }
            this.f52519a = 1000;
            this.f52521c = 0;
            return 0;
        }
        return (int) (random * d11);
    }
}
