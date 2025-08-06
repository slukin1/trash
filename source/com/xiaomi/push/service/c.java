package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.es;
import com.xiaomi.push.fj;
import com.xiaomi.push.service.XMPushService;

class c extends XMPushService.j {

    /* renamed from: a  reason: collision with root package name */
    private XMPushService f52549a = null;

    /* renamed from: a  reason: collision with other field name */
    private es[] f3383a;

    public c(XMPushService xMPushService, es[] esVarArr) {
        super(4);
        this.f52549a = xMPushService;
        this.f3383a = esVarArr;
    }

    public String a() {
        return "batch send message.";
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m3011a() {
        try {
            es[] esVarArr = this.f3383a;
            if (esVarArr != null) {
                this.f52549a.a(esVarArr);
            }
        } catch (fj e11) {
            b.a((Throwable) e11);
            this.f52549a.a(10, (Exception) e11);
        }
    }
}
