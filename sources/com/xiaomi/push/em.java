package com.xiaomi.push;

import com.xiaomi.push.en;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.am;

class em implements am.b.a {

    /* renamed from: a  reason: collision with root package name */
    private int f51733a;

    /* renamed from: a  reason: collision with other field name */
    private fb f2789a;

    /* renamed from: a  reason: collision with other field name */
    private XMPushService f2790a;

    /* renamed from: a  reason: collision with other field name */
    private am.b f2791a;

    /* renamed from: a  reason: collision with other field name */
    private am.c f2792a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f2793a = false;

    /* renamed from: com.xiaomi.push.em$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f51735a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.xiaomi.push.service.am$c[] r0 = com.xiaomi.push.service.am.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f51735a = r0
                com.xiaomi.push.service.am$c r1 = com.xiaomi.push.service.am.c.unbind     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f51735a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.xiaomi.push.service.am$c r1 = com.xiaomi.push.service.am.c.binding     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f51735a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.xiaomi.push.service.am$c r1 = com.xiaomi.push.service.am.c.binded     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.em.AnonymousClass2.<clinit>():void");
        }
    }

    public em(XMPushService xMPushService, am.b bVar) {
        this.f2790a = xMPushService;
        this.f2792a = am.c.binding;
        this.f2791a = bVar;
    }

    private void b() {
        this.f2791a.b(this);
    }

    /* access modifiers changed from: private */
    public void c() {
        b();
        if (this.f2793a && this.f51733a != 11) {
            ek a11 = ep.a().a();
            int i11 = AnonymousClass2.f51735a[this.f2792a.ordinal()];
            if (i11 == 1) {
                int i12 = this.f51733a;
                if (i12 == 17) {
                    a11.f2775a = ej.BIND_TCP_READ_TIMEOUT.a();
                } else if (i12 == 21) {
                    a11.f2775a = ej.BIND_TIMEOUT.a();
                } else {
                    try {
                        en.a c11 = en.c(ep.a().a());
                        a11.f2775a = c11.f51736a.a();
                        a11.c(c11.f2794a);
                    } catch (NullPointerException unused) {
                        a11 = null;
                    }
                }
            } else if (i11 == 3) {
                a11.f2775a = ej.BIND_SUCCESS.a();
            }
            if (a11 != null) {
                a11.b(this.f2789a.a());
                a11.d(this.f2791a.f3346b);
                a11.f2778b = 1;
                try {
                    a11.a((byte) Integer.parseInt(this.f2791a.f52470g));
                } catch (NumberFormatException unused2) {
                }
                ep.a().a(a11);
            }
        }
    }

    public void a() {
        this.f2791a.a((am.b.a) this);
        this.f2789a = this.f2790a.a();
    }

    public void a(am.c cVar, am.c cVar2, int i11) {
        if (!this.f2793a && cVar == am.c.binding) {
            this.f2792a = cVar2;
            this.f51733a = i11;
            this.f2793a = true;
        }
        this.f2790a.a((XMPushService.j) new XMPushService.j(4) {
            public String a() {
                return "Handling bind stats";
            }

            /* renamed from: a  reason: collision with other method in class */
            public void m2640a() {
                em.this.c();
            }
        });
    }
}
