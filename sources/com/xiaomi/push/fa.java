package com.xiaomi.push;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.dq;
import com.xiaomi.push.fb;
import com.xiaomi.push.service.aj;
import com.xiaomi.push.service.am;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class fa implements fk {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f51765a = false;

    /* renamed from: a  reason: collision with other field name */
    private a f2832a = null;

    /* renamed from: a  reason: collision with other field name */
    private fb f2833a = null;

    /* renamed from: a  reason: collision with other field name */
    private fe f2834a = null;

    /* renamed from: a  reason: collision with other field name */
    private final String f2835a = "[Slim] ";

    /* renamed from: a  reason: collision with other field name */
    private SimpleDateFormat f2836a = new SimpleDateFormat("hh:mm:ss aaa");

    /* renamed from: b  reason: collision with root package name */
    private a f51766b = null;

    public fa(fb fbVar) {
        this.f2833a = fbVar;
        a();
    }

    private void a() {
        this.f2832a = new a(true);
        this.f51766b = new a(false);
        fb fbVar = this.f2833a;
        a aVar = this.f2832a;
        fbVar.a((fg) aVar, (fl) aVar);
        fb fbVar2 = this.f2833a;
        a aVar2 = this.f51766b;
        fbVar2.b((fg) aVar2, (fl) aVar2);
        this.f2834a = new fe() {
            public void a(fb fbVar, int i11, Exception exc) {
                b.c("[Slim] " + fa.a(fa.this).format(new Date()) + " Connection closed (" + fa.a(fa.this).hashCode() + ")");
            }

            public void b(fb fbVar) {
                b.c("[Slim] " + fa.a(fa.this).format(new Date()) + " Connection reconnected (" + fa.a(fa.this).hashCode() + ")");
            }

            public void a(fb fbVar, Exception exc) {
                b.c("[Slim] " + fa.a(fa.this).format(new Date()) + " Reconnection failed due to an exception (" + fa.a(fa.this).hashCode() + ")");
                exc.printStackTrace();
            }

            public void a(fb fbVar) {
                b.c("[Slim] " + fa.a(fa.this).format(new Date()) + " Connection started (" + fa.a(fa.this).hashCode() + ")");
            }
        };
    }

    public class a implements fg, fl {

        /* renamed from: a  reason: collision with other field name */
        public String f2837a;

        /* renamed from: a  reason: collision with other field name */
        private boolean f2838a = true;

        public a(boolean z11) {
            this.f2838a = z11;
            this.f2837a = z11 ? " RCV " : " Sent ";
        }

        public void a(fp fpVar) {
            if (fa.f51765a) {
                b.c("[Slim] " + fa.a(fa.this).format(new Date()) + this.f2837a + " PKT " + fpVar.a());
                return;
            }
            b.c("[Slim] " + fa.a(fa.this).format(new Date()) + this.f2837a + " PKT [" + fpVar.k() + Constants.ACCEPT_TIME_SEPARATOR_SP + fpVar.j() + "]");
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m2668a(fp fpVar) {
            return true;
        }

        public void a(es esVar) {
            if (fa.f51765a) {
                b.c("[Slim] " + fa.a(fa.this).format(new Date()) + this.f2837a + esVar.toString());
            } else {
                b.c("[Slim] " + fa.a(fa.this).format(new Date()) + this.f2837a + " Blob [" + esVar.a() + Constants.ACCEPT_TIME_SEPARATOR_SP + esVar.a() + Constants.ACCEPT_TIME_SEPARATOR_SP + aj.a(esVar.e()) + "]");
            }
            if (esVar != null && esVar.a() == 99999) {
                String a11 = esVar.a();
                es esVar2 = null;
                if (!this.f2838a) {
                    if ("BIND".equals(a11)) {
                        b.a("build binded result for loopback.");
                        dq.d dVar = new dq.d();
                        dVar.a(true);
                        dVar.c("login success.");
                        dVar.b("success");
                        dVar.a("success");
                        es esVar3 = new es();
                        esVar3.a(dVar.a(), (String) null);
                        esVar3.a(2);
                        esVar3.a(99999);
                        esVar3.a("BIND", (String) null);
                        esVar3.a(esVar.e());
                        esVar3.b((String) null);
                        esVar3.c(esVar.g());
                        esVar2 = esVar3;
                    } else if (!"UBND".equals(a11) && "SECMSG".equals(a11)) {
                        es esVar4 = new es();
                        esVar4.a(99999);
                        esVar4.a("SECMSG", (String) null);
                        esVar4.c(esVar.g());
                        esVar4.a(esVar.e());
                        esVar4.a(esVar.a());
                        esVar4.b(esVar.f());
                        esVar4.a(esVar.a(am.a().a(String.valueOf(99999), esVar.g()).f52471h), (String) null);
                        esVar2 = esVar4;
                    }
                }
                if (esVar2 != null) {
                    for (Map.Entry entry : fa.a(fa.this).a().entrySet()) {
                        if (fa.a(fa.this) != entry.getKey()) {
                            ((fb.a) entry.getValue()).a(esVar2);
                        }
                    }
                }
            }
        }
    }
}
