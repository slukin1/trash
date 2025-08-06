package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.es;
import com.xiaomi.push.fj;
import com.xiaomi.push.service.XMPushService;

public class aw extends XMPushService.j {

    /* renamed from: a  reason: collision with root package name */
    private es f52529a;

    /* renamed from: a  reason: collision with other field name */
    private XMPushService f3359a = null;

    public aw(XMPushService xMPushService, es esVar) {
        super(4);
        this.f3359a = xMPushService;
        this.f52529a = esVar;
    }

    public String a() {
        return "send a message.";
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m3004a() {
        try {
            es esVar = this.f52529a;
            if (esVar != null) {
                if (e.a(esVar)) {
                    this.f52529a.c(System.currentTimeMillis() - this.f52529a.a());
                }
                this.f3359a.a(this.f52529a);
            }
        } catch (fj e11) {
            b.a((Throwable) e11);
            this.f3359a.a(10, (Exception) e11);
        }
    }
}
