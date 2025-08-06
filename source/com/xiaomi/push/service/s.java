package com.xiaomi.push.service;

import android.content.Context;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.fj;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.am;
import java.util.Collection;

public class s extends XMPushService.j {

    /* renamed from: a  reason: collision with root package name */
    private XMPushService f52591a;

    /* renamed from: a  reason: collision with other field name */
    private String f3417a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f3418a;

    /* renamed from: b  reason: collision with root package name */
    private String f52592b;

    /* renamed from: c  reason: collision with root package name */
    private String f52593c;

    public s(XMPushService xMPushService, String str, String str2, String str3, byte[] bArr) {
        super(9);
        this.f52591a = xMPushService;
        this.f3417a = str;
        this.f3418a = bArr;
        this.f52592b = str2;
        this.f52593c = str3;
    }

    public String a() {
        return "register app";
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m3045a() {
        am.b bVar;
        p a11 = q.a((Context) this.f52591a);
        if (a11 == null) {
            try {
                a11 = q.a(this.f52591a, this.f3417a, this.f52592b, this.f52593c);
            } catch (Exception e11) {
                b.d("fail to register push account. " + e11);
            }
        }
        if (a11 == null) {
            b.d("no account for registration.");
            t.a(this.f52591a, ErrorCode.ERROR_AUTHERICATION_ERROR, "no account.");
            return;
        }
        b.a("do registration now.");
        Collection a12 = am.a().a(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_OTC);
        if (a12.isEmpty()) {
            bVar = a11.a(this.f52591a);
            w.a(this.f52591a, bVar);
            am.a().a(bVar);
        } else {
            bVar = (am.b) a12.iterator().next();
        }
        if (this.f52591a.c()) {
            try {
                am.c cVar = bVar.f3341a;
                if (cVar == am.c.binded) {
                    w.a(this.f52591a, this.f3417a, this.f3418a);
                } else if (cVar == am.c.unbind) {
                    t.a(this.f3417a, this.f3418a);
                    XMPushService xMPushService = this.f52591a;
                    xMPushService.getClass();
                    xMPushService.a((XMPushService.j) new XMPushService.b(bVar));
                }
            } catch (fj e12) {
                b.d("meet error, disconnect connection. " + e12);
                this.f52591a.a(10, (Exception) e12);
            }
        } else {
            t.a(this.f3417a, this.f3418a);
            this.f52591a.a(true);
        }
    }
}
