package com.xiaomi.push.service;

import android.util.Pair;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.aa;
import com.xiaomi.push.gm;
import com.xiaomi.push.gn;
import com.xiaomi.push.gp;
import com.xiaomi.push.gr;
import com.xiaomi.push.hd;
import com.xiaomi.push.he;
import java.util.ArrayList;
import java.util.List;

public class ai {

    /* renamed from: com.xiaomi.push.service.ai$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f52458a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f52459b;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|(2:1|2)|3|5|6|7|8|(2:9|10)|11|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0028 */
        static {
            /*
                com.xiaomi.push.gn[] r0 = com.xiaomi.push.gn.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f52459b = r0
                r1 = 1
                com.xiaomi.push.gn r2 = com.xiaomi.push.gn.INT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f52459b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.xiaomi.push.gn r3 = com.xiaomi.push.gn.LONG     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r2 = f52459b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.xiaomi.push.gn r3 = com.xiaomi.push.gn.STRING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r4 = 3
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r2 = f52459b     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.xiaomi.push.gn r3 = com.xiaomi.push.gn.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4 = 4
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.xiaomi.push.gm[] r2 = com.xiaomi.push.gm.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f52458a = r2
                com.xiaomi.push.gm r3 = com.xiaomi.push.gm.MISC_CONFIG     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r1 = f52458a     // Catch:{ NoSuchFieldError -> 0x004e }
                com.xiaomi.push.gm r2 = com.xiaomi.push.gm.PLUGIN_CONFIG     // Catch:{ NoSuchFieldError -> 0x004e }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.ai.AnonymousClass1.<clinit>():void");
        }
    }

    public static void a(ah ahVar, he heVar) {
        b.b("OnlineConfigHelper", "-->updateNormalConfigs(): onlineConfig=", ahVar, ", configMessage=", heVar);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (gp next : heVar.a()) {
            arrayList.add(new Pair(next.a(), Integer.valueOf(next.a())));
            List<Pair<Integer, Object>> a11 = a(next.f2940a, false);
            if (!aa.a(a11)) {
                arrayList2.addAll(a11);
            }
        }
        ahVar.a((List<Pair<gm, Integer>>) arrayList, (List<Pair<Integer, Object>>) arrayList2);
        ahVar.b();
    }

    public static void a(ah ahVar, hd hdVar) {
        b.b("OnlineConfigHelper", "-->updateCustomConfigs(): onlineConfig=", ahVar, ", configMessage=", hdVar);
        ahVar.a(a(hdVar.a(), true));
        ahVar.b();
    }

    public static int a(ah ahVar, gm gmVar) {
        int i11 = 1;
        if (AnonymousClass1.f52458a[gmVar.ordinal()] != 1) {
            i11 = 0;
        }
        return ahVar.a(gmVar, i11);
    }

    private static List<Pair<Integer, Object>> a(List<gr> list, boolean z11) {
        Pair pair;
        if (aa.a(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (gr next : list) {
            int a11 = next.a();
            gn a12 = gn.a(next.b());
            if (a12 != null) {
                if (!z11 || !next.f2948a) {
                    int i11 = AnonymousClass1.f52459b[a12.ordinal()];
                    if (i11 == 1) {
                        pair = new Pair(Integer.valueOf(a11), Integer.valueOf(next.c()));
                    } else if (i11 == 2) {
                        pair = new Pair(Integer.valueOf(a11), Long.valueOf(next.a()));
                    } else if (i11 == 3) {
                        pair = new Pair(Integer.valueOf(a11), next.a());
                    } else if (i11 != 4) {
                        pair = null;
                    } else {
                        pair = new Pair(Integer.valueOf(a11), Boolean.valueOf(next.g()));
                    }
                    arrayList.add(pair);
                } else {
                    arrayList.add(new Pair(Integer.valueOf(a11), (Object) null));
                }
            }
        }
        return arrayList;
    }
}
