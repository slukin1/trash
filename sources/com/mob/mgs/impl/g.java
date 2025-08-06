package com.mob.mgs.impl;

import android.content.Context;
import android.content.Intent;
import com.mob.mgs.OnAppActiveListener;

public class g {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static OnAppActiveListener f27625a = null;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static int f27626b = 1;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f27627c = false;

    public static void a(final Context context, final Intent intent, final boolean z11) {
        new h() {
            /* JADX WARNING: Removed duplicated region for block: B:25:0x00d1 A[Catch:{ all -> 0x00f5 }] */
            /* JADX WARNING: Removed duplicated region for block: B:28:0x00df A[Catch:{ all -> 0x00f5 }] */
            /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void a() throws java.lang.Throwable {
                /*
                    r13 = this;
                    java.lang.String r0 = "selfpush000"
                    com.mob.mgs.impl.e r1 = com.mob.mgs.impl.e.a()     // Catch:{ all -> 0x00f5 }
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f5 }
                    r2.<init>()     // Catch:{ all -> 0x00f5 }
                    java.lang.String r3 = "[GD][R]intent: "
                    r2.append(r3)     // Catch:{ all -> 0x00f5 }
                    android.content.Intent r3 = r2     // Catch:{ all -> 0x00f5 }
                    r2.append(r3)     // Catch:{ all -> 0x00f5 }
                    java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00f5 }
                    r1.a((java.lang.String) r2)     // Catch:{ all -> 0x00f5 }
                    android.content.Intent r1 = r2     // Catch:{ all -> 0x00f5 }
                    java.lang.String r2 = "data"
                    java.lang.String r1 = r1.getStringExtra(r2)     // Catch:{ all -> 0x00f5 }
                    android.content.Intent r2 = r2     // Catch:{ all -> 0x00f5 }
                    java.lang.String r3 = "workId"
                    java.lang.String r10 = r2.getStringExtra(r3)     // Catch:{ all -> 0x00f5 }
                    android.content.Intent r2 = r2     // Catch:{ all -> 0x00f5 }
                    java.lang.String r3 = "appkey"
                    java.lang.String r7 = r2.getStringExtra(r3)     // Catch:{ all -> 0x00f5 }
                    android.content.Intent r2 = r2     // Catch:{ all -> 0x00f5 }
                    java.lang.String r3 = "pkg"
                    java.lang.String r8 = r2.getStringExtra(r3)     // Catch:{ all -> 0x00f5 }
                    android.content.Intent r2 = r2     // Catch:{ all -> 0x00f5 }
                    java.lang.String r3 = "duid"
                    java.lang.String r6 = r2.getStringExtra(r3)     // Catch:{ all -> 0x00f5 }
                    android.content.Intent r2 = r2     // Catch:{ all -> 0x00f5 }
                    java.lang.String r3 = "guardId"
                    java.lang.String r9 = r2.getStringExtra(r3)     // Catch:{ all -> 0x00f5 }
                    android.content.Intent r2 = r2     // Catch:{ all -> 0x00f5 }
                    java.lang.String r3 = "acServiceType"
                    r11 = 0
                    int r2 = r2.getIntExtra(r3, r11)     // Catch:{ all -> 0x00f5 }
                    android.content.Intent r3 = r2     // Catch:{ all -> 0x00f5 }
                    java.lang.String r4 = "busType"
                    int r3 = r3.getIntExtra(r4, r11)     // Catch:{ all -> 0x00f5 }
                    com.mob.mgs.impl.e r4 = com.mob.mgs.impl.e.a()     // Catch:{ all -> 0x00f5 }
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f5 }
                    r5.<init>()     // Catch:{ all -> 0x00f5 }
                    java.lang.String r12 = "[GD][R]acSvcType: "
                    r5.append(r12)     // Catch:{ all -> 0x00f5 }
                    r5.append(r2)     // Catch:{ all -> 0x00f5 }
                    java.lang.String r12 = ", busType: "
                    r5.append(r12)     // Catch:{ all -> 0x00f5 }
                    r5.append(r3)     // Catch:{ all -> 0x00f5 }
                    java.lang.String r12 = ", fmAct: "
                    r5.append(r12)     // Catch:{ all -> 0x00f5 }
                    boolean r12 = r3     // Catch:{ all -> 0x00f5 }
                    r5.append(r12)     // Catch:{ all -> 0x00f5 }
                    java.lang.String r12 = ", uld: "
                    r5.append(r12)     // Catch:{ all -> 0x00f5 }
                    boolean r12 = com.mob.mgs.impl.g.f27627c     // Catch:{ all -> 0x00f5 }
                    r5.append(r12)     // Catch:{ all -> 0x00f5 }
                    java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00f5 }
                    r4.a((java.lang.String) r5)     // Catch:{ all -> 0x00f5 }
                    r4 = 2
                    r5 = 1
                    if (r2 == r5) goto L_0x00ba
                    r12 = 2001(0x7d1, float:2.804E-42)
                    if (r3 != r12) goto L_0x009c
                    goto L_0x00ba
                L_0x009c:
                    if (r2 == r4) goto L_0x00b5
                    r2 = 2002(0x7d2, float:2.805E-42)
                    if (r3 != r2) goto L_0x00a3
                    goto L_0x00b5
                L_0x00a3:
                    boolean r2 = r0.equals(r10)     // Catch:{ all -> 0x00f5 }
                    if (r2 == 0) goto L_0x00be
                    boolean r0 = r0.equals(r9)     // Catch:{ all -> 0x00f5 }
                    if (r0 == 0) goto L_0x00be
                    r0 = 100
                    int unused = com.mob.mgs.impl.g.f27626b = r0     // Catch:{ all -> 0x00f5 }
                    goto L_0x00be
                L_0x00b5:
                    r0 = 4
                    int unused = com.mob.mgs.impl.g.f27626b = r0     // Catch:{ all -> 0x00f5 }
                    goto L_0x00be
                L_0x00ba:
                    r0 = 3
                    int unused = com.mob.mgs.impl.g.f27626b = r0     // Catch:{ all -> 0x00f5 }
                L_0x00be:
                    boolean r0 = r3     // Catch:{ all -> 0x00f5 }
                    if (r0 != 0) goto L_0x00cb
                    int r0 = com.mob.mgs.impl.g.f27626b     // Catch:{ all -> 0x00f5 }
                    if (r0 != r5) goto L_0x00cb
                    int unused = com.mob.mgs.impl.g.f27626b = r4     // Catch:{ all -> 0x00f5 }
                L_0x00cb:
                    boolean r0 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x00f5 }
                    if (r0 != 0) goto L_0x00d9
                    com.mob.mgs.impl.g$1$1 r0 = new com.mob.mgs.impl.g$1$1     // Catch:{ all -> 0x00f5 }
                    r0.<init>(r1)     // Catch:{ all -> 0x00f5 }
                    com.mob.tools.utils.UIHandler.sendEmptyMessage(r11, r0)     // Catch:{ all -> 0x00f5 }
                L_0x00d9:
                    boolean r0 = com.mob.mgs.impl.g.f27627c     // Catch:{ all -> 0x00f5 }
                    if (r0 != 0) goto L_0x00fd
                    boolean unused = com.mob.mgs.impl.g.f27627c = r5     // Catch:{ all -> 0x00f5 }
                    com.mob.mgs.impl.g$1$2 r0 = new com.mob.mgs.impl.g$1$2     // Catch:{ all -> 0x00f5 }
                    r4 = r0
                    r5 = r13
                    r4.<init>(r6, r7, r8, r9, r10)     // Catch:{ all -> 0x00f5 }
                    r0.start()     // Catch:{ all -> 0x00f5 }
                    com.mob.mgs.impl.g$1$3 r0 = new com.mob.mgs.impl.g$1$3     // Catch:{ all -> 0x00f5 }
                    r0.<init>()     // Catch:{ all -> 0x00f5 }
                    com.mob.tools.utils.UIHandler.sendEmptyMessage(r11, r0)     // Catch:{ all -> 0x00f5 }
                    goto L_0x00fd
                L_0x00f5:
                    r0 = move-exception
                    com.mob.mgs.impl.e r1 = com.mob.mgs.impl.e.a()
                    r1.a((java.lang.Throwable) r0)
                L_0x00fd:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mob.mgs.impl.g.AnonymousClass1.a():void");
            }
        }.start();
    }

    public static void a(OnAppActiveListener onAppActiveListener) {
        f27625a = onAppActiveListener;
    }
}
