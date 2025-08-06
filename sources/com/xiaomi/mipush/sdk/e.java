package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.gl;
import com.xiaomi.push.service.ah;
import java.util.HashMap;
import java.util.Map;

public class e implements AbstractPushManager {

    /* renamed from: a  reason: collision with root package name */
    private static volatile e f51310a;

    /* renamed from: a  reason: collision with other field name */
    private Context f2463a;

    /* renamed from: a  reason: collision with other field name */
    private PushConfiguration f2464a;

    /* renamed from: a  reason: collision with other field name */
    private Map<d, AbstractPushManager> f2465a = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public boolean f2466a = false;

    /* renamed from: com.xiaomi.mipush.sdk.e$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f51312a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.xiaomi.mipush.sdk.d[] r0 = com.xiaomi.mipush.sdk.d.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f51312a = r0
                com.xiaomi.mipush.sdk.d r1 = com.xiaomi.mipush.sdk.d.ASSEMBLE_PUSH_HUAWEI     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f51312a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.xiaomi.mipush.sdk.d r1 = com.xiaomi.mipush.sdk.d.ASSEMBLE_PUSH_FCM     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f51312a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.xiaomi.mipush.sdk.d r1 = com.xiaomi.mipush.sdk.d.ASSEMBLE_PUSH_COS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f51312a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.xiaomi.mipush.sdk.d r1 = com.xiaomi.mipush.sdk.d.ASSEMBLE_PUSH_FTOS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.e.AnonymousClass2.<clinit>():void");
        }
    }

    private e(Context context) {
        this.f2463a = context.getApplicationContext();
    }

    public boolean b(d dVar) {
        int i11 = AnonymousClass2.f51312a[dVar.ordinal()];
        boolean z11 = false;
        if (i11 == 1) {
            PushConfiguration pushConfiguration = this.f2464a;
            if (pushConfiguration != null) {
                return pushConfiguration.getOpenHmsPush();
            }
            return false;
        } else if (i11 != 2) {
            if (i11 == 3) {
                PushConfiguration pushConfiguration2 = this.f2464a;
                if (pushConfiguration2 != null) {
                    z11 = pushConfiguration2.getOpenCOSPush();
                }
            } else if (i11 != 4) {
                return false;
            }
            PushConfiguration pushConfiguration3 = this.f2464a;
            if (pushConfiguration3 != null) {
                return pushConfiguration3.getOpenFTOSPush();
            }
            return z11;
        } else {
            PushConfiguration pushConfiguration4 = this.f2464a;
            if (pushConfiguration4 != null) {
                return pushConfiguration4.getOpenFCMPush();
            }
            return false;
        }
    }

    public void register() {
        b.a("ASSEMBLE_PUSH : assemble push register");
        if (this.f2465a.size() <= 0) {
            a();
        }
        if (this.f2465a.size() > 0) {
            for (AbstractPushManager next : this.f2465a.values()) {
                if (next != null) {
                    next.register();
                }
            }
            f.a(this.f2463a);
        }
    }

    public void unregister() {
        b.a("ASSEMBLE_PUSH : assemble push unregister");
        for (AbstractPushManager next : this.f2465a.values()) {
            if (next != null) {
                next.unregister();
            }
        }
        this.f2465a.clear();
    }

    public static e a(Context context) {
        if (f51310a == null) {
            synchronized (e.class) {
                if (f51310a == null) {
                    f51310a = new e(context);
                }
            }
        }
        return f51310a;
    }

    public void a(PushConfiguration pushConfiguration) {
        this.f2464a = pushConfiguration;
        this.f2466a = ah.a(this.f2463a).a(gl.AggregatePushSwitch.a(), true);
        if (this.f2464a.getOpenHmsPush() || this.f2464a.getOpenFCMPush() || this.f2464a.getOpenCOSPush() || this.f2464a.getOpenFTOSPush()) {
            ah.a(this.f2463a).a((ah.a) new ah.a(101, "assemblePush") {
                public void onCallback() {
                    boolean a11 = ah.a(e.a(e.this)).a(gl.AggregatePushSwitch.a(), true);
                    if (e.a(e.this) != a11) {
                        boolean unused = e.this.f2466a = a11;
                        f.b(e.a(e.this));
                    }
                }
            });
        }
    }

    public void a(d dVar, AbstractPushManager abstractPushManager) {
        if (abstractPushManager != null) {
            if (this.f2465a.containsKey(dVar)) {
                this.f2465a.remove(dVar);
            }
            this.f2465a.put(dVar, abstractPushManager);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2351a(d dVar) {
        this.f2465a.remove(dVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2352a(d dVar) {
        return this.f2465a.containsKey(dVar);
    }

    public AbstractPushManager a(d dVar) {
        return this.f2465a.get(dVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01e1  */
    /* JADX WARNING: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a() {
        /*
            r4 = this;
            com.xiaomi.mipush.sdk.PushConfiguration r0 = r4.f2464a
            if (r0 == 0) goto L_0x01e7
            boolean r0 = r0.getOpenHmsPush()
            java.lang.String r1 = "ASSEMBLE_PUSH : "
            if (r0 == 0) goto L_0x0053
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = " HW user switch : "
            r0.append(r2)
            com.xiaomi.mipush.sdk.PushConfiguration r2 = r4.f2464a
            boolean r2 = r2.getOpenHmsPush()
            r0.append(r2)
            java.lang.String r2 = " HW online switch : "
            r0.append(r2)
            android.content.Context r2 = r4.f2463a
            com.xiaomi.mipush.sdk.d r3 = com.xiaomi.mipush.sdk.d.ASSEMBLE_PUSH_HUAWEI
            boolean r2 = com.xiaomi.mipush.sdk.f.a((android.content.Context) r2, (com.xiaomi.mipush.sdk.d) r3)
            r0.append(r2)
            java.lang.String r2 = " HW isSupport : "
            r0.append(r2)
            android.content.Context r2 = r4.f2463a
            boolean r2 = com.xiaomi.mipush.sdk.h.a((android.content.Context) r2)
            r0.append(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            java.lang.String r0 = r0.toString()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r0)
        L_0x0053:
            com.xiaomi.mipush.sdk.PushConfiguration r0 = r4.f2464a
            boolean r0 = r0.getOpenHmsPush()
            if (r0 == 0) goto L_0x0082
            android.content.Context r0 = r4.f2463a
            com.xiaomi.mipush.sdk.d r2 = com.xiaomi.mipush.sdk.d.ASSEMBLE_PUSH_HUAWEI
            boolean r0 = com.xiaomi.mipush.sdk.f.a((android.content.Context) r0, (com.xiaomi.mipush.sdk.d) r2)
            if (r0 == 0) goto L_0x0082
            android.content.Context r0 = r4.f2463a
            boolean r0 = com.xiaomi.mipush.sdk.h.a((android.content.Context) r0)
            if (r0 == 0) goto L_0x0082
            boolean r0 = r4.a((com.xiaomi.mipush.sdk.d) r2)
            if (r0 != 0) goto L_0x007c
            android.content.Context r0 = r4.f2463a
            com.xiaomi.mipush.sdk.AbstractPushManager r0 = com.xiaomi.mipush.sdk.s.a(r0, r2)
            r4.a((com.xiaomi.mipush.sdk.d) r2, (com.xiaomi.mipush.sdk.AbstractPushManager) r0)
        L_0x007c:
            java.lang.String r0 = "hw manager add to list"
            com.xiaomi.channel.commonutils.logger.b.c(r0)
            goto L_0x0096
        L_0x0082:
            com.xiaomi.mipush.sdk.d r0 = com.xiaomi.mipush.sdk.d.ASSEMBLE_PUSH_HUAWEI
            boolean r2 = r4.a((com.xiaomi.mipush.sdk.d) r0)
            if (r2 == 0) goto L_0x0096
            com.xiaomi.mipush.sdk.AbstractPushManager r2 = r4.a((com.xiaomi.mipush.sdk.d) r0)
            if (r2 == 0) goto L_0x0096
            r4.a((com.xiaomi.mipush.sdk.d) r0)
            r2.unregister()
        L_0x0096:
            com.xiaomi.mipush.sdk.PushConfiguration r0 = r4.f2464a
            boolean r0 = r0.getOpenFCMPush()
            if (r0 == 0) goto L_0x00e5
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = " FCM user switch : "
            r0.append(r2)
            com.xiaomi.mipush.sdk.PushConfiguration r2 = r4.f2464a
            boolean r2 = r2.getOpenFCMPush()
            r0.append(r2)
            java.lang.String r2 = " FCM online switch : "
            r0.append(r2)
            android.content.Context r2 = r4.f2463a
            com.xiaomi.mipush.sdk.d r3 = com.xiaomi.mipush.sdk.d.ASSEMBLE_PUSH_FCM
            boolean r2 = com.xiaomi.mipush.sdk.f.a((android.content.Context) r2, (com.xiaomi.mipush.sdk.d) r3)
            r0.append(r2)
            java.lang.String r2 = " FCM isSupport : "
            r0.append(r2)
            android.content.Context r2 = r4.f2463a
            boolean r2 = com.xiaomi.mipush.sdk.h.b(r2)
            r0.append(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            java.lang.String r0 = r0.toString()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r0)
        L_0x00e5:
            com.xiaomi.mipush.sdk.PushConfiguration r0 = r4.f2464a
            boolean r0 = r0.getOpenFCMPush()
            if (r0 == 0) goto L_0x0114
            android.content.Context r0 = r4.f2463a
            com.xiaomi.mipush.sdk.d r2 = com.xiaomi.mipush.sdk.d.ASSEMBLE_PUSH_FCM
            boolean r0 = com.xiaomi.mipush.sdk.f.a((android.content.Context) r0, (com.xiaomi.mipush.sdk.d) r2)
            if (r0 == 0) goto L_0x0114
            android.content.Context r0 = r4.f2463a
            boolean r0 = com.xiaomi.mipush.sdk.h.b(r0)
            if (r0 == 0) goto L_0x0114
            boolean r0 = r4.a((com.xiaomi.mipush.sdk.d) r2)
            if (r0 != 0) goto L_0x010e
            android.content.Context r0 = r4.f2463a
            com.xiaomi.mipush.sdk.AbstractPushManager r0 = com.xiaomi.mipush.sdk.s.a(r0, r2)
            r4.a((com.xiaomi.mipush.sdk.d) r2, (com.xiaomi.mipush.sdk.AbstractPushManager) r0)
        L_0x010e:
            java.lang.String r0 = "fcm manager add to list"
            com.xiaomi.channel.commonutils.logger.b.c(r0)
            goto L_0x0128
        L_0x0114:
            com.xiaomi.mipush.sdk.d r0 = com.xiaomi.mipush.sdk.d.ASSEMBLE_PUSH_FCM
            boolean r2 = r4.a((com.xiaomi.mipush.sdk.d) r0)
            if (r2 == 0) goto L_0x0128
            com.xiaomi.mipush.sdk.AbstractPushManager r2 = r4.a((com.xiaomi.mipush.sdk.d) r0)
            if (r2 == 0) goto L_0x0128
            r4.a((com.xiaomi.mipush.sdk.d) r0)
            r2.unregister()
        L_0x0128:
            com.xiaomi.mipush.sdk.PushConfiguration r0 = r4.f2464a
            boolean r0 = r0.getOpenCOSPush()
            if (r0 == 0) goto L_0x0177
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = " COS user switch : "
            r0.append(r2)
            com.xiaomi.mipush.sdk.PushConfiguration r2 = r4.f2464a
            boolean r2 = r2.getOpenCOSPush()
            r0.append(r2)
            java.lang.String r2 = " COS online switch : "
            r0.append(r2)
            android.content.Context r2 = r4.f2463a
            com.xiaomi.mipush.sdk.d r3 = com.xiaomi.mipush.sdk.d.ASSEMBLE_PUSH_COS
            boolean r2 = com.xiaomi.mipush.sdk.f.a((android.content.Context) r2, (com.xiaomi.mipush.sdk.d) r3)
            r0.append(r2)
            java.lang.String r2 = " COS isSupport : "
            r0.append(r2)
            android.content.Context r2 = r4.f2463a
            boolean r2 = com.xiaomi.mipush.sdk.h.c(r2)
            r0.append(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            java.lang.String r0 = r0.toString()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r0)
        L_0x0177:
            com.xiaomi.mipush.sdk.PushConfiguration r0 = r4.f2464a
            boolean r0 = r0.getOpenCOSPush()
            if (r0 == 0) goto L_0x019b
            android.content.Context r0 = r4.f2463a
            com.xiaomi.mipush.sdk.d r1 = com.xiaomi.mipush.sdk.d.ASSEMBLE_PUSH_COS
            boolean r0 = com.xiaomi.mipush.sdk.f.a((android.content.Context) r0, (com.xiaomi.mipush.sdk.d) r1)
            if (r0 == 0) goto L_0x019b
            android.content.Context r0 = r4.f2463a
            boolean r0 = com.xiaomi.mipush.sdk.h.c(r0)
            if (r0 == 0) goto L_0x019b
            android.content.Context r0 = r4.f2463a
            com.xiaomi.mipush.sdk.AbstractPushManager r0 = com.xiaomi.mipush.sdk.s.a(r0, r1)
            r4.a((com.xiaomi.mipush.sdk.d) r1, (com.xiaomi.mipush.sdk.AbstractPushManager) r0)
            goto L_0x01af
        L_0x019b:
            com.xiaomi.mipush.sdk.d r0 = com.xiaomi.mipush.sdk.d.ASSEMBLE_PUSH_COS
            boolean r1 = r4.a((com.xiaomi.mipush.sdk.d) r0)
            if (r1 == 0) goto L_0x01af
            com.xiaomi.mipush.sdk.AbstractPushManager r1 = r4.a((com.xiaomi.mipush.sdk.d) r0)
            if (r1 == 0) goto L_0x01af
            r4.a((com.xiaomi.mipush.sdk.d) r0)
            r1.unregister()
        L_0x01af:
            com.xiaomi.mipush.sdk.PushConfiguration r0 = r4.f2464a
            boolean r0 = r0.getOpenFTOSPush()
            if (r0 == 0) goto L_0x01d3
            android.content.Context r0 = r4.f2463a
            com.xiaomi.mipush.sdk.d r1 = com.xiaomi.mipush.sdk.d.ASSEMBLE_PUSH_FTOS
            boolean r0 = com.xiaomi.mipush.sdk.f.a((android.content.Context) r0, (com.xiaomi.mipush.sdk.d) r1)
            if (r0 == 0) goto L_0x01d3
            android.content.Context r0 = r4.f2463a
            boolean r0 = com.xiaomi.mipush.sdk.h.d(r0)
            if (r0 == 0) goto L_0x01d3
            android.content.Context r0 = r4.f2463a
            com.xiaomi.mipush.sdk.AbstractPushManager r0 = com.xiaomi.mipush.sdk.s.a(r0, r1)
            r4.a((com.xiaomi.mipush.sdk.d) r1, (com.xiaomi.mipush.sdk.AbstractPushManager) r0)
            goto L_0x01e7
        L_0x01d3:
            com.xiaomi.mipush.sdk.d r0 = com.xiaomi.mipush.sdk.d.ASSEMBLE_PUSH_FTOS
            boolean r1 = r4.a((com.xiaomi.mipush.sdk.d) r0)
            if (r1 == 0) goto L_0x01e7
            com.xiaomi.mipush.sdk.AbstractPushManager r1 = r4.a((com.xiaomi.mipush.sdk.d) r0)
            if (r1 == 0) goto L_0x01e7
            r4.a((com.xiaomi.mipush.sdk.d) r0)
            r1.unregister()
        L_0x01e7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.e.a():void");
    }
}
