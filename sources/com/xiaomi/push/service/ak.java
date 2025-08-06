package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.cd;
import com.xiaomi.push.ch;
import com.xiaomi.push.dc;
import com.xiaomi.push.dq;
import com.xiaomi.push.ej;
import com.xiaomi.push.eq;
import com.xiaomi.push.es;
import com.xiaomi.push.fc;
import com.xiaomi.push.fm;
import com.xiaomi.push.fn;
import com.xiaomi.push.fo;
import com.xiaomi.push.fp;
import com.xiaomi.push.ga;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.am;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.util.Date;

public class ak {

    /* renamed from: a  reason: collision with root package name */
    private XMPushService f52461a;

    public ak(XMPushService xMPushService) {
        this.f52461a = xMPushService;
    }

    private void c(es esVar) {
        am.b a11;
        String g11 = esVar.g();
        String num = Integer.toString(esVar.a());
        if (!TextUtils.isEmpty(g11) && !TextUtils.isEmpty(num) && (a11 = am.a().a(num, g11)) != null) {
            ga.a(this.f52461a, a11.f3343a, (long) esVar.c(), true, true, System.currentTimeMillis());
        }
    }

    public void a(fp fpVar) {
        if (!BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_OTC.equals(fpVar.k())) {
            b(fpVar);
        }
        String k11 = fpVar.k();
        if (TextUtils.isEmpty(k11)) {
            k11 = "1";
            fpVar.l(k11);
        }
        if (k11.equals("0")) {
            b.a("Received wrong packet with chid = 0 : " + fpVar.a());
        }
        if (fpVar instanceof fn) {
            fm a11 = fpVar.a("kick");
            if (a11 != null) {
                String l11 = fpVar.l();
                String a12 = a11.a("type");
                String a13 = a11.a(Constants.REASON);
                b.a("kicked by server, chid=" + k11 + " res=" + am.b.a(l11) + " type=" + a12 + " reason=" + a13);
                if ("wait".equals(a12)) {
                    am.b a14 = am.a().a(k11, l11);
                    if (a14 != null) {
                        this.f52461a.a(a14);
                        a14.a(am.c.unbind, 3, 0, a13, a12);
                        return;
                    }
                    return;
                }
                this.f52461a.a(k11, l11, 3, a13, a12);
                am.a().a(k11, l11);
                return;
            }
        } else if (fpVar instanceof fo) {
            fo foVar = (fo) fpVar;
            if ("redir".equals(foVar.b())) {
                fm a15 = foVar.a("hosts");
                if (a15 != null) {
                    a(a15);
                    return;
                }
                return;
            }
        }
        this.f52461a.b().a(this.f52461a, k11, fpVar);
    }

    public void b(es esVar) {
        String a11 = esVar.a();
        if (esVar.a() != 0) {
            String num = Integer.toString(esVar.a());
            if ("SECMSG".equals(esVar.a())) {
                if (!esVar.a()) {
                    this.f52461a.b().a(this.f52461a, num, esVar);
                    return;
                }
                b.a("Recv SECMSG errCode = " + esVar.b() + " errStr = " + esVar.c());
            } else if ("BIND".equals(a11)) {
                dq.d a12 = dq.d.a(esVar.a());
                String g11 = esVar.g();
                am.b a13 = am.a().a(num, g11);
                if (a13 != null) {
                    if (a12.a()) {
                        b.a("SMACK: channel bind succeeded, chid=" + esVar.a());
                        a13.a(am.c.binded, 1, 0, (String) null, (String) null);
                        return;
                    }
                    String a14 = a12.a();
                    if ("auth".equals(a14)) {
                        if ("invalid-sig".equals(a12.b())) {
                            b.a("SMACK: bind error invalid-sig token = " + a13.f52466c + " sec = " + a13.f52471h);
                            eq.a(0, ej.BIND_INVALID_SIG.a(), 1, (String) null, 0);
                        }
                        a13.a(am.c.unbind, 1, 5, a12.b(), a14);
                        am.a().a(num, g11);
                    } else if ("cancel".equals(a14)) {
                        a13.a(am.c.unbind, 1, 7, a12.b(), a14);
                        am.a().a(num, g11);
                    } else if ("wait".equals(a14)) {
                        this.f52461a.a(a13);
                        a13.a(am.c.unbind, 1, 7, a12.b(), a14);
                    }
                    b.a("SMACK: channel bind failed, chid=" + num + " reason=" + a12.b());
                }
            } else if ("KICK".equals(a11)) {
                dq.g a15 = dq.g.a(esVar.a());
                String g12 = esVar.g();
                String a16 = a15.a();
                String b11 = a15.b();
                b.a("kicked by server, chid=" + num + " res= " + am.b.a(g12) + " type=" + a16 + " reason=" + b11);
                if ("wait".equals(a16)) {
                    am.b a17 = am.a().a(num, g12);
                    if (a17 != null) {
                        this.f52461a.a(a17);
                        a17.a(am.c.unbind, 3, 0, b11, a16);
                        return;
                    }
                    return;
                }
                this.f52461a.a(num, g12, 3, b11, a16);
                am.a().a(num, g12);
            }
        } else if ("PING".equals(a11)) {
            byte[] a18 = esVar.a();
            if (a18 != null && a18.length > 0) {
                dq.j a19 = dq.j.a(a18);
                if (a19.b()) {
                    ax.a().a(a19.a());
                }
            }
            if (!"com.xiaomi.xmsf".equals(this.f52461a.getPackageName())) {
                this.f52461a.a();
            }
            if ("1".equals(esVar.e())) {
                b.a("received a server ping");
            } else {
                eq.b();
            }
            this.f52461a.b();
        } else if (GmsRpc.CMD_SYNC.equals(a11)) {
            if ("CONF".equals(esVar.b())) {
                ax.a().a(dq.b.a(esVar.a()));
            } else if (TextUtils.equals("U", esVar.b())) {
                dq.k a21 = dq.k.a(esVar.a());
                dc.a((Context) this.f52461a).a(a21.a(), a21.b(), new Date(a21.a()), new Date(a21.b()), a21.c() * 1024, a21.e());
                es esVar2 = new es();
                esVar2.a(0);
                esVar2.a(esVar.a(), "UCA");
                esVar2.a(esVar.e());
                XMPushService xMPushService = this.f52461a;
                xMPushService.a((XMPushService.j) new aw(xMPushService, esVar2));
            } else if (TextUtils.equals("P", esVar.b())) {
                dq.i a22 = dq.i.a(esVar.a());
                es esVar3 = new es();
                esVar3.a(0);
                esVar3.a(esVar.a(), "PCA");
                esVar3.a(esVar.e());
                dq.i iVar = new dq.i();
                if (a22.a()) {
                    iVar.a(a22.a());
                }
                esVar3.a(iVar.a(), (String) null);
                XMPushService xMPushService2 = this.f52461a;
                xMPushService2.a((XMPushService.j) new aw(xMPushService2, esVar3));
                b.a("ACK msgP: id = " + esVar.e());
            }
        } else if ("NOTIFY".equals(esVar.a())) {
            dq.h a23 = dq.h.a(esVar.a());
            b.a("notify by server err = " + a23.c() + " desc = " + a23.a());
        }
    }

    public void a(es esVar) {
        if (5 != esVar.a()) {
            c(esVar);
        }
        try {
            b(esVar);
        } catch (Exception e11) {
            b.a("handle Blob chid = " + esVar.a() + " cmd = " + esVar.a() + " packetid = " + esVar.e() + " failure ", (Throwable) e11);
        }
    }

    private void a(fm fmVar) {
        String c11 = fmVar.c();
        if (!TextUtils.isEmpty(c11)) {
            String[] split = c11.split(";");
            cd a11 = ch.a().a(fc.a(), false);
            if (a11 != null && split.length > 0) {
                a11.a(split);
                this.f52461a.a(20, (Exception) null);
                this.f52461a.a(true);
            }
        }
    }

    private void b(fp fpVar) {
        am.b a11;
        String l11 = fpVar.l();
        String k11 = fpVar.k();
        if (!TextUtils.isEmpty(l11) && !TextUtils.isEmpty(k11) && (a11 = am.a().a(k11, l11)) != null) {
            ga.a(this.f52461a, a11.f3343a, (long) ga.a(fpVar.a()), true, true, System.currentTimeMillis());
        }
    }
}
