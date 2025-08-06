package com.xiaomi.push;

import android.content.Context;
import android.os.SystemClock;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.m;
import java.io.IOException;
import java.net.Socket;

public abstract class fi extends fb {

    /* renamed from: a  reason: collision with root package name */
    public Exception f51784a = null;

    /* renamed from: a  reason: collision with other field name */
    public Socket f2859a;

    /* renamed from: b  reason: collision with root package name */
    public XMPushService f51785b;

    /* renamed from: c  reason: collision with root package name */
    private int f51786c;

    /* renamed from: c  reason: collision with other field name */
    public String f2860c = null;

    /* renamed from: d  reason: collision with root package name */
    private String f51787d;

    /* renamed from: e  reason: collision with root package name */
    public volatile long f51788e = 0;

    /* renamed from: f  reason: collision with root package name */
    public volatile long f51789f = 0;

    /* renamed from: g  reason: collision with root package name */
    public volatile long f51790g = 0;

    /* renamed from: h  reason: collision with root package name */
    private long f51791h = 0;

    public fi(XMPushService xMPushService, fc fcVar) {
        super(xMPushService, fcVar);
        this.f51785b = xMPushService;
    }

    public Context a() {
        return this.f51785b;
    }

    public abstract void a(boolean z11);

    public void b(boolean z11) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        final long currentTimeMillis = System.currentTimeMillis();
        a(z11);
        m.a((Context) this.f51785b).c();
        if (!z11) {
            this.f51785b.a((XMPushService.j) new XMPushService.j(13) {
                /* renamed from: a  reason: collision with other method in class */
                public void m2687a() {
                    Thread.yield();
                    if (fi.this.c() && !fi.this.a(elapsedRealtime)) {
                        m.a((Context) fi.this.f51785b).b();
                        fi.this.f51785b.a(22, (Exception) null);
                    }
                }

                public String a() {
                    return "check the ping-pong." + currentTimeMillis;
                }
            }, 10000);
        }
    }

    public String c() {
        return this.f2845a;
    }

    public synchronized void e() {
        try {
            if (!c()) {
                if (!b()) {
                    a(0, 0, (Exception) null);
                    a(this.f2842a);
                    return;
                }
            }
            b.a("WARNING: current xmpp has connected");
        } catch (IOException e11) {
            throw new fj((Throwable) e11);
        }
    }

    public void f() {
        this.f51788e = SystemClock.elapsedRealtime();
    }

    public void g() {
        this.f51789f = SystemClock.elapsedRealtime();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m2684a() {
        return this.f51787d;
    }

    public void c(final int i11, final Exception exc) {
        av.b();
        this.f51785b.a((XMPushService.j) new XMPushService.j(2) {
            /* renamed from: a  reason: collision with other method in class */
            public void m2688a() {
                fi.this.f51785b.a(i11, exc);
            }

            public String a() {
                return "shutdown the connection. " + i11 + ", " + exc;
            }
        });
    }

    public synchronized void a(int i11, Exception exc) {
        if (b() != 2) {
            a(2, i11, exc);
            this.f2845a = "";
            try {
                this.f2859a.close();
            } catch (Throwable unused) {
            }
            this.f51788e = 0;
            this.f51789f = 0;
        }
    }

    public void b(int i11, Exception exc) {
        a(i11, exc);
        if ((exc != null || i11 == 18) && this.f51790g != 0) {
            a(exc);
        }
    }

    public void a(Exception exc) {
        if (SystemClock.elapsedRealtime() - this.f51790g >= 300000) {
            this.f51786c = 0;
        } else if (av.a((Context) this.f51785b)) {
            int i11 = this.f51786c + 1;
            this.f51786c = i11;
            if (i11 >= 2) {
                String a11 = a();
                b.a("max short conn time reached, sink down current host:" + a11);
                a(a11, 0, exc);
                this.f51786c = 0;
            }
        }
    }

    public void a(String str, long j11, Exception exc) {
        cd a11 = ch.a().a(fc.a(), false);
        if (a11 != null) {
            a11.b(str, j11, 0, exc);
            ch.a().c();
        }
    }

    public void a(es[] esVarArr) {
        throw new fj("Don't support send Blob");
    }

    private void a(fc fcVar) {
        a(fcVar.c(), fcVar.a());
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x0276 A[EDGE_INSN: B:105:0x0276->B:72:0x0276 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0276 A[EDGE_INSN: B:107:0x0276->B:72:0x0276 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x027a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x01a7  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01c4  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01e6  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0236  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0238  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0251  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0269  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x02c0  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x02c2  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x02db  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x02f0  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x02fd  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0300  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0319  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0351  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r32, int r33) {
        /*
            r31 = this;
            r1 = r31
            r0 = r32
            r2 = r33
            java.lang.String r3 = "|"
            java.lang.String r4 = "\n"
            java.lang.String r5 = " err:"
            java.lang.String r6 = " port:"
            java.lang.String r7 = "SMACK: Could not connect to "
            java.lang.String r8 = "SMACK: Could not connect to:"
            r9 = 0
            r1.f51784a = r9
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "get bucket for host : "
            r10.append(r11)
            r10.append(r0)
            java.lang.String r10 = r10.toString()
            java.lang.Integer r10 = com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r10)
            int r10 = r10.intValue()
            com.xiaomi.push.cd r15 = r31.a((java.lang.String) r32)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.Integer) r10)
            r10 = 1
            if (r15 == 0) goto L_0x0045
            java.util.ArrayList r9 = r15.a((boolean) r10)
        L_0x0045:
            com.xiaomi.push.ch r11 = com.xiaomi.push.ch.a()
            com.xiaomi.push.cd r11 = r11.d(r0)
            if (r11 == 0) goto L_0x006e
            java.util.ArrayList r11 = r11.a((boolean) r10)
            java.util.Iterator r11 = r11.iterator()
        L_0x0057:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L_0x006e
            java.lang.Object r12 = r11.next()
            java.lang.String r12 = (java.lang.String) r12
            int r13 = r9.indexOf(r12)
            r14 = -1
            if (r13 != r14) goto L_0x0057
            r9.add(r12)
            goto L_0x0057
        L_0x006e:
            boolean r11 = r9.isEmpty()
            if (r11 == 0) goto L_0x0077
            r9.add(r0)
        L_0x0077:
            r13 = 0
            r1.f51790g = r13
            long r18 = android.os.SystemClock.elapsedRealtime()
            com.xiaomi.push.service.XMPushService r0 = r1.f51785b
            java.lang.String r12 = com.xiaomi.push.av.a((android.content.Context) r0)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.util.Iterator r9 = r9.iterator()
            java.lang.String r0 = ""
            r32 = r0
            r0 = 0
        L_0x0093:
            boolean r16 = r9.hasNext()
            if (r16 == 0) goto L_0x0301
            java.lang.Object r16 = r9.next()
            r10 = r16
            java.lang.String r10 = (java.lang.String) r10
            long r21 = java.lang.System.currentTimeMillis()
            int r13 = r1.f2840a
            r14 = 1
            int r13 = r13 + r14
            r1.f2840a = r13
            int r23 = r0 + 1
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01f0, all -> 0x0158 }
            r0.<init>()     // Catch:{ Exception -> 0x01f0, all -> 0x0158 }
            java.lang.String r13 = "begin to connect to "
            r0.append(r13)     // Catch:{ Exception -> 0x01f0, all -> 0x0158 }
            r0.append(r10)     // Catch:{ Exception -> 0x01f0, all -> 0x0158 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x01f0, all -> 0x0158 }
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r0)     // Catch:{ Exception -> 0x01f0, all -> 0x0158 }
            java.net.Socket r0 = r31.a()     // Catch:{ Exception -> 0x01f0, all -> 0x0158 }
            r1.f2859a = r0     // Catch:{ Exception -> 0x01f0, all -> 0x0158 }
            java.net.InetSocketAddress r0 = com.xiaomi.push.cf.a((java.lang.String) r10, (int) r2)     // Catch:{ Exception -> 0x01f0, all -> 0x0158 }
            java.net.Socket r13 = r1.f2859a     // Catch:{ Exception -> 0x01f0, all -> 0x0158 }
            r14 = 8000(0x1f40, float:1.121E-41)
            r13.connect(r0, r14)     // Catch:{ Exception -> 0x01f0, all -> 0x0158 }
            java.lang.String r0 = "tcp connected"
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r0)     // Catch:{ Exception -> 0x01f0, all -> 0x0158 }
            java.net.Socket r0 = r1.f2859a     // Catch:{ Exception -> 0x01f0, all -> 0x0158 }
            r13 = 1
            r0.setTcpNoDelay(r13)     // Catch:{ Exception -> 0x014e, all -> 0x0143 }
            r1.f51787d = r10     // Catch:{ Exception -> 0x014e, all -> 0x0143 }
            r31.a()     // Catch:{ Exception -> 0x014e, all -> 0x0143 }
            long r24 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x014e, all -> 0x0143 }
            long r13 = r24 - r21
            r1.f2841a = r13     // Catch:{ Exception -> 0x01f0, all -> 0x0158 }
            r1.f2850b = r12     // Catch:{ Exception -> 0x01f0, all -> 0x0158 }
            if (r15 == 0) goto L_0x0103
            r24 = 0
            r26 = r9
            r9 = r11
            r11 = r15
            r27 = r12
            r12 = r10
            r20 = 1
            r28 = 0
            r30 = r15
            r15 = r24
            r11.b(r12, r13, r15)     // Catch:{ Exception -> 0x013c, all -> 0x013a }
            goto L_0x010e
        L_0x0103:
            r26 = r9
            r9 = r11
            r27 = r12
            r30 = r15
            r20 = 1
            r28 = 0
        L_0x010e:
            long r11 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x013c, all -> 0x013a }
            r1.f51790g = r11     // Catch:{ Exception -> 0x013c, all -> 0x013a }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x013c, all -> 0x013a }
            r0.<init>()     // Catch:{ Exception -> 0x013c, all -> 0x013a }
            java.lang.String r11 = "connected to "
            r0.append(r11)     // Catch:{ Exception -> 0x013c, all -> 0x013a }
            r0.append(r10)     // Catch:{ Exception -> 0x013c, all -> 0x013a }
            java.lang.String r11 = " in "
            r0.append(r11)     // Catch:{ Exception -> 0x013c, all -> 0x013a }
            long r11 = r1.f2841a     // Catch:{ Exception -> 0x013c, all -> 0x013a }
            r0.append(r11)     // Catch:{ Exception -> 0x013c, all -> 0x013a }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x013c, all -> 0x013a }
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r0)     // Catch:{ Exception -> 0x013c, all -> 0x013a }
            r0 = r32
            r10 = r20
            r2 = r23
            goto L_0x0309
        L_0x013a:
            r0 = move-exception
            goto L_0x0164
        L_0x013c:
            r0 = move-exception
            r11 = r32
            r15 = r27
            goto L_0x01fd
        L_0x0143:
            r0 = move-exception
            r26 = r9
            r9 = r11
            r27 = r12
            r20 = r13
            r30 = r15
            goto L_0x0162
        L_0x014e:
            r0 = move-exception
            r26 = r9
            r9 = r11
            r20 = r13
            r30 = r15
            goto L_0x01f8
        L_0x0158:
            r0 = move-exception
            r26 = r9
            r9 = r11
            r27 = r12
            r30 = r15
            r20 = 1
        L_0x0162:
            r28 = 0
        L_0x0164:
            java.lang.Exception r11 = new java.lang.Exception     // Catch:{ all -> 0x01e9 }
            java.lang.String r12 = "abnormal exception"
            r11.<init>(r12, r0)     // Catch:{ all -> 0x01e9 }
            r1.f51784a = r11     // Catch:{ all -> 0x01e9 }
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.Throwable) r0)     // Catch:{ all -> 0x01e9 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r8)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            com.xiaomi.channel.commonutils.logger.b.d(r0)
            r9.append(r7)
            r9.append(r10)
            r9.append(r6)
            r9.append(r2)
            r9.append(r5)
            java.lang.Exception r0 = r1.f51784a
            java.lang.Class r0 = r0.getClass()
            java.lang.String r0 = r0.getSimpleName()
            r9.append(r0)
            r9.append(r4)
            boolean r0 = android.text.TextUtils.isEmpty(r32)
            if (r0 == 0) goto L_0x01a9
            r0 = r10
            goto L_0x01bd
        L_0x01a9:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r11 = r32
            r0.append(r11)
            r0.append(r3)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
        L_0x01bd:
            java.lang.Exception r11 = r1.f51784a
            com.xiaomi.push.eq.a((java.lang.String) r10, (java.lang.Exception) r11)
            if (r30 == 0) goto L_0x01d6
            long r11 = java.lang.System.currentTimeMillis()
            long r13 = r11 - r21
            r15 = 0
            java.lang.Exception r12 = r1.f51784a
            r11 = r30
            r17 = r12
            r12 = r10
            r11.b(r12, r13, r15, r17)
        L_0x01d6:
            com.xiaomi.push.service.XMPushService r10 = r1.f51785b
            java.lang.String r10 = com.xiaomi.push.av.a((android.content.Context) r10)
            r15 = r27
            boolean r10 = android.text.TextUtils.equals(r15, r10)
            if (r10 != 0) goto L_0x01e6
            goto L_0x0276
        L_0x01e6:
            r10 = r15
            goto L_0x027a
        L_0x01e9:
            r0 = move-exception
            r11 = r32
            r15 = r27
            goto L_0x0289
        L_0x01f0:
            r0 = move-exception
            r26 = r9
            r9 = r11
            r30 = r15
            r20 = 1
        L_0x01f8:
            r28 = 0
            r11 = r32
            r15 = r12
        L_0x01fd:
            r1.f51784a = r0     // Catch:{ all -> 0x0288 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r8)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            com.xiaomi.channel.commonutils.logger.b.d(r0)
            r9.append(r7)
            r9.append(r10)
            r9.append(r6)
            r9.append(r2)
            r9.append(r5)
            java.lang.Exception r0 = r1.f51784a
            java.lang.Class r0 = r0.getClass()
            java.lang.String r0 = r0.getSimpleName()
            r9.append(r0)
            r9.append(r4)
            boolean r0 = android.text.TextUtils.isEmpty(r11)
            if (r0 == 0) goto L_0x0238
            r0 = r10
            goto L_0x024a
        L_0x0238:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r11)
            r0.append(r3)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
        L_0x024a:
            java.lang.Exception r11 = r1.f51784a
            com.xiaomi.push.eq.a((java.lang.String) r10, (java.lang.Exception) r11)
            if (r30 == 0) goto L_0x0269
            long r11 = java.lang.System.currentTimeMillis()
            long r13 = r11 - r21
            r16 = 0
            java.lang.Exception r12 = r1.f51784a
            r11 = r30
            r21 = r12
            r12 = r10
            r10 = r15
            r15 = r16
            r17 = r21
            r11.b(r12, r13, r15, r17)
            goto L_0x026a
        L_0x0269:
            r10 = r15
        L_0x026a:
            com.xiaomi.push.service.XMPushService r11 = r1.f51785b
            java.lang.String r11 = com.xiaomi.push.av.a((android.content.Context) r11)
            boolean r11 = android.text.TextUtils.equals(r10, r11)
            if (r11 != 0) goto L_0x027a
        L_0x0276:
            r2 = r23
            goto L_0x0308
        L_0x027a:
            r32 = r0
            r11 = r9
            r12 = r10
            r0 = r23
            r9 = r26
            r13 = r28
            r15 = r30
            goto L_0x0093
        L_0x0288:
            r0 = move-exception
        L_0x0289:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r8)
            r12.append(r10)
            java.lang.String r8 = r12.toString()
            com.xiaomi.channel.commonutils.logger.b.d(r8)
            r9.append(r7)
            r9.append(r10)
            r9.append(r6)
            r9.append(r2)
            r9.append(r5)
            java.lang.Exception r2 = r1.f51784a
            java.lang.Class r2 = r2.getClass()
            java.lang.String r2 = r2.getSimpleName()
            r9.append(r2)
            r9.append(r4)
            boolean r2 = android.text.TextUtils.isEmpty(r11)
            if (r2 == 0) goto L_0x02c2
            r2 = r10
            goto L_0x02d4
        L_0x02c2:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r11)
            r2.append(r3)
            r2.append(r10)
            java.lang.String r2 = r2.toString()
        L_0x02d4:
            java.lang.Exception r3 = r1.f51784a
            com.xiaomi.push.eq.a((java.lang.String) r10, (java.lang.Exception) r3)
            if (r30 == 0) goto L_0x02f0
            long r3 = java.lang.System.currentTimeMillis()
            long r13 = r3 - r21
            r3 = 0
            java.lang.Exception r5 = r1.f51784a
            r11 = r30
            r12 = r10
            r6 = r15
            r15 = r3
            r17 = r5
            r11.b(r12, r13, r15, r17)
            goto L_0x02f1
        L_0x02f0:
            r6 = r15
        L_0x02f1:
            com.xiaomi.push.service.XMPushService r3 = r1.f51785b
            java.lang.String r3 = com.xiaomi.push.av.a((android.content.Context) r3)
            boolean r3 = android.text.TextUtils.equals(r6, r3)
            if (r3 != 0) goto L_0x0300
            r0 = r2
            goto L_0x0276
        L_0x0300:
            throw r0
        L_0x0301:
            r9 = r11
            r28 = r13
            r11 = r32
            r2 = r0
            r0 = r11
        L_0x0308:
            r10 = 0
        L_0x0309:
            com.xiaomi.push.ch r3 = com.xiaomi.push.ch.a()
            r3.c()
            long r3 = android.os.SystemClock.elapsedRealtime()
            long r3 = r3 - r18
            int r3 = (int) r3
            if (r10 != 0) goto L_0x0351
            long r4 = r1.f51791h
            int r2 = (r4 > r28 ? 1 : (r4 == r28 ? 0 : -1))
            if (r2 == 0) goto L_0x032d
            long r4 = android.os.SystemClock.elapsedRealtime()
            long r6 = r1.f51791h
            long r4 = r4 - r6
            r6 = 480000(0x75300, double:2.371515E-318)
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 <= 0) goto L_0x0347
        L_0x032d:
            long r4 = android.os.SystemClock.elapsedRealtime()
            r1.f51791h = r4
            com.xiaomi.push.service.XMPushService r2 = r1.f51785b
            android.content.Context r2 = r2.getApplicationContext()
            boolean r2 = com.xiaomi.push.av.b(r2)
            com.xiaomi.push.ej r4 = com.xiaomi.push.ej.BATCH_TCP_CONN_FAIL
            int r4 = r4.a()
            r5 = 0
            com.xiaomi.push.eq.a(r5, r4, r3, r0, r2)
        L_0x0347:
            com.xiaomi.push.fj r0 = new com.xiaomi.push.fj
            java.lang.String r2 = r9.toString()
            r0.<init>((java.lang.String) r2)
            throw r0
        L_0x0351:
            r5 = 0
            com.xiaomi.push.ej r4 = com.xiaomi.push.ej.BATCH_TCP_CONN_SUCCESS
            int r4 = r4.a()
            com.xiaomi.push.eq.a(r5, r4, r3, r0, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.fi.a(java.lang.String, int):void");
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m2686a() {
    }

    /* renamed from: a  reason: collision with other method in class */
    public Socket m2685a() {
        return new Socket();
    }

    public cd a(final String str) {
        cd a11 = ch.a().a(str, false);
        if (!a11.b()) {
            fz.a((Runnable) new Runnable() {
                public void run() {
                    ch.a().a(str, true);
                }
            });
        }
        return a11;
    }
}
