package com.xiaomi.push;

import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.dq;
import com.xiaomi.push.fb;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.am;
import com.xiaomi.push.service.ar;
import com.xiaomi.push.service.aw;
import com.xiaomi.push.service.ax;
import com.xiaomi.push.service.e;

public class ez extends fi {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public eu f51759a;

    /* renamed from: a  reason: collision with other field name */
    private ev f2829a;

    /* renamed from: a  reason: collision with other field name */
    private Thread f2830a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f2831a;

    public ez(XMPushService xMPushService, fc fcVar) {
        super(xMPushService, fcVar);
    }

    private void h() {
        try {
            this.f51759a = new eu(this.f2859a.getInputStream(), this);
            this.f2829a = new ev(this.f2859a.getOutputStream(), this);
            AnonymousClass1 r02 = new Thread("Blob Reader (" + this.f51770b + ")") {
                public void run() {
                    try {
                        ez.this.f51759a.a();
                    } catch (Exception e11) {
                        ez.this.c(9, e11);
                    }
                }
            };
            this.f2830a = r02;
            r02.start();
        } catch (Exception e11) {
            throw new fj("Error to init reader and writer", e11);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2666a() {
        return true;
    }

    public void b(fp fpVar) {
        if (fpVar != null) {
            for (fb.a a11 : this.f2848a.values()) {
                a11.a(fpVar);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized byte[] m2667a() {
        if (this.f2831a == null && !TextUtils.isEmpty(this.f2845a)) {
            String a11 = ax.a();
            StringBuilder sb2 = new StringBuilder();
            String str = this.f2845a;
            sb2.append(str.substring(str.length() / 2));
            sb2.append(a11.substring(a11.length() / 2));
            this.f2831a = ar.a(this.f2845a.getBytes(), sb2.toString().getBytes());
        }
        return this.f2831a;
    }

    public void b(es esVar) {
        ev evVar = this.f2829a;
        if (evVar != null) {
            try {
                int a11 = evVar.a(esVar);
                this.f51772d = SystemClock.elapsedRealtime();
                String f11 = esVar.f();
                if (!TextUtils.isEmpty(f11)) {
                    ga.a(this.f2844a, f11, (long) a11, false, true, System.currentTimeMillis());
                }
                for (fb.a a12 : this.f2851b.values()) {
                    a12.a(esVar);
                }
            } catch (Exception e11) {
                throw new fj((Throwable) e11);
            }
        } else {
            throw new fj("the writer is null.");
        }
    }

    private es a(boolean z11) {
        ey eyVar = new ey();
        if (z11) {
            eyVar.a("1");
        }
        byte[] a11 = eq.a();
        if (a11 != null) {
            dq.j jVar = new dq.j();
            jVar.a(a.a(a11));
            eyVar.a(jVar.a(), (String) null);
        }
        return eyVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2665a(boolean z11) {
        if (this.f2829a != null) {
            es a11 = a(z11);
            b.a("[Slim] SND ping id=" + a11.e());
            b(a11);
            f();
            return;
        }
        throw new fj("The BlobWriter is null.");
    }

    public synchronized void a(am.b bVar) {
        er.a(bVar, c(), (fb) this);
    }

    public synchronized void a(String str, String str2) {
        er.a(str, str2, (fb) this);
    }

    public synchronized void a(int i11, Exception exc) {
        eu euVar = this.f51759a;
        if (euVar != null) {
            euVar.b();
            this.f51759a = null;
        }
        ev evVar = this.f2829a;
        if (evVar != null) {
            try {
                evVar.b();
            } catch (Exception e11) {
                b.d("SlimConnection shutdown cause exception: " + e11);
            }
            this.f2829a = null;
        }
        this.f2831a = null;
        super.a(i11, exc);
    }

    public void a(es[] esVarArr) {
        for (es b11 : esVarArr) {
            b(b11);
        }
    }

    @Deprecated
    public void a(fp fpVar) {
        b(es.a(fpVar, (String) null));
    }

    public synchronized void a() {
        h();
        this.f2829a.a();
    }

    public void a(es esVar) {
        if (esVar != null) {
            if (e.a(esVar)) {
                es esVar2 = new es();
                esVar2.a(esVar.a());
                esVar2.a(GmsRpc.CMD_SYNC, "ACK_RTT");
                esVar2.a(esVar.e());
                esVar2.b(esVar.b());
                esVar2.a(esVar.c());
                XMPushService xMPushService = this.f2844a;
                xMPushService.a((XMPushService.j) new aw(xMPushService, esVar2));
            }
            if (esVar.a()) {
                b.a("[Slim] RCV blob chid=" + esVar.a() + "; id=" + esVar.e() + "; errCode=" + esVar.b() + "; err=" + esVar.c());
            }
            if (esVar.a() == 0) {
                if ("PING".equals(esVar.a())) {
                    b.a("[Slim] RCV ping id=" + esVar.e());
                    g();
                } else if ("CLOSE".equals(esVar.a())) {
                    c(13, (Exception) null);
                }
            }
            for (fb.a a11 : this.f2848a.values()) {
                a11.a(esVar);
            }
        }
    }
}
