package com.mob.commons.b;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.android.SystemUtils;
import com.mob.commons.l;
import com.mob.tools.MobLog;
import com.mob.tools.utils.DH;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private static h f27049a;

    /* renamed from: com.mob.commons.b.e$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f27052a;

        /* JADX WARNING: Can't wrap try/catch for region: R(52:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|52) */
        /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00d8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00e4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00f0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00fc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x0108 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x0114 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x0120 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.mob.commons.b.e$a[] r0 = com.mob.commons.b.e.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f27052a = r0
                com.mob.commons.b.e$a r1 = com.mob.commons.b.e.a.XIAOMI     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f27052a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mob.commons.b.e$a r1 = com.mob.commons.b.e.a.REDMI     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f27052a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.mob.commons.b.e$a r1 = com.mob.commons.b.e.a.MEITU     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f27052a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.mob.commons.b.e$a r1 = com.mob.commons.b.e.a.BLACKSHARK     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f27052a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.mob.commons.b.e$a r1 = com.mob.commons.b.e.a.VIVO     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f27052a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.mob.commons.b.e$a r1 = com.mob.commons.b.e.a.HUA_WEI     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f27052a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.mob.commons.b.e$a r1 = com.mob.commons.b.e.a.HORNOR     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f27052a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.mob.commons.b.e$a r1 = com.mob.commons.b.e.a.OPPO     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f27052a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.mob.commons.b.e$a r1 = com.mob.commons.b.e.a.REALME     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f27052a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.mob.commons.b.e$a r1 = com.mob.commons.b.e.a.ONEPLUS     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f27052a     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.mob.commons.b.e$a r1 = com.mob.commons.b.e.a.MOTO     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f27052a     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.mob.commons.b.e$a r1 = com.mob.commons.b.e.a.ZUK     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f27052a     // Catch:{ NoSuchFieldError -> 0x009c }
                com.mob.commons.b.e$a r1 = com.mob.commons.b.e.a.LENOVO     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f27052a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.mob.commons.b.e$a r1 = com.mob.commons.b.e.a.ASUS     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f27052a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.mob.commons.b.e$a r1 = com.mob.commons.b.e.a.SAMSUNG     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f27052a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.mob.commons.b.e$a r1 = com.mob.commons.b.e.a.MEIZU     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = f27052a     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.mob.commons.b.e$a r1 = com.mob.commons.b.e.a.MBLU     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r0 = f27052a     // Catch:{ NoSuchFieldError -> 0x00d8 }
                com.mob.commons.b.e$a r1 = com.mob.commons.b.e.a.ALPS     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                int[] r0 = f27052a     // Catch:{ NoSuchFieldError -> 0x00e4 }
                com.mob.commons.b.e$a r1 = com.mob.commons.b.e.a.NUBIA     // Catch:{ NoSuchFieldError -> 0x00e4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e4 }
                r2 = 19
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e4 }
            L_0x00e4:
                int[] r0 = f27052a     // Catch:{ NoSuchFieldError -> 0x00f0 }
                com.mob.commons.b.e$a r1 = com.mob.commons.b.e.a.ZTE     // Catch:{ NoSuchFieldError -> 0x00f0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f0 }
                r2 = 20
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f0 }
            L_0x00f0:
                int[] r0 = f27052a     // Catch:{ NoSuchFieldError -> 0x00fc }
                com.mob.commons.b.e$a r1 = com.mob.commons.b.e.a.FERRMEOS     // Catch:{ NoSuchFieldError -> 0x00fc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fc }
                r2 = 21
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00fc }
            L_0x00fc:
                int[] r0 = f27052a     // Catch:{ NoSuchFieldError -> 0x0108 }
                com.mob.commons.b.e$a r1 = com.mob.commons.b.e.a.SSUI     // Catch:{ NoSuchFieldError -> 0x0108 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0108 }
                r2 = 22
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0108 }
            L_0x0108:
                int[] r0 = f27052a     // Catch:{ NoSuchFieldError -> 0x0114 }
                com.mob.commons.b.e$a r1 = com.mob.commons.b.e.a.COOLPAD     // Catch:{ NoSuchFieldError -> 0x0114 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0114 }
                r2 = 23
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0114 }
            L_0x0114:
                int[] r0 = f27052a     // Catch:{ NoSuchFieldError -> 0x0120 }
                com.mob.commons.b.e$a r1 = com.mob.commons.b.e.a.QIKU     // Catch:{ NoSuchFieldError -> 0x0120 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0120 }
                r2 = 24
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0120 }
            L_0x0120:
                int[] r0 = f27052a     // Catch:{ NoSuchFieldError -> 0x012c }
                com.mob.commons.b.e$a r1 = com.mob.commons.b.e.a.COOSEA     // Catch:{ NoSuchFieldError -> 0x012c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x012c }
                r2 = 25
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x012c }
            L_0x012c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.b.e.AnonymousClass2.<clinit>():void");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void a(android.content.Context r3) {
        /*
            java.lang.Class<com.mob.commons.b.e> r0 = com.mob.commons.b.e.class
            monitor-enter(r0)
            com.mob.commons.b.h r1 = f27049a     // Catch:{ all -> 0x009f }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)
            return
        L_0x0009:
            java.lang.String r1 = android.os.Build.MANUFACTURER     // Catch:{ all -> 0x009f }
            java.lang.String r2 = android.os.Build.BRAND     // Catch:{ all -> 0x009f }
            com.mob.commons.b.e$a r1 = a(r3, r1, r2)     // Catch:{ all -> 0x009f }
            com.mob.commons.b.e$a r2 = com.mob.commons.b.e.a.UNSUPPORT     // Catch:{ all -> 0x009f }
            if (r1 != r2) goto L_0x0017
            monitor-exit(r0)
            return
        L_0x0017:
            int[] r2 = com.mob.commons.b.e.AnonymousClass2.f27052a     // Catch:{ all -> 0x009f }
            int r1 = r1.ordinal()     // Catch:{ all -> 0x009f }
            r1 = r2[r1]     // Catch:{ all -> 0x009f }
            switch(r1) {
                case 1: goto L_0x0096;
                case 2: goto L_0x0096;
                case 3: goto L_0x0096;
                case 4: goto L_0x0096;
                case 5: goto L_0x008e;
                case 6: goto L_0x0086;
                case 7: goto L_0x007e;
                case 8: goto L_0x0076;
                case 9: goto L_0x0076;
                case 10: goto L_0x006e;
                case 11: goto L_0x0066;
                case 12: goto L_0x0066;
                case 13: goto L_0x0066;
                case 14: goto L_0x005e;
                case 15: goto L_0x0056;
                case 16: goto L_0x004e;
                case 17: goto L_0x004e;
                case 18: goto L_0x004e;
                case 19: goto L_0x0046;
                case 20: goto L_0x003e;
                case 21: goto L_0x003e;
                case 22: goto L_0x003e;
                case 23: goto L_0x0036;
                case 24: goto L_0x002d;
                case 25: goto L_0x0024;
                default: goto L_0x0022;
            }     // Catch:{ all -> 0x009f }
        L_0x0022:
            goto L_0x009d
        L_0x0024:
            com.mob.commons.b.c r1 = new com.mob.commons.b.c     // Catch:{ all -> 0x009f }
            r1.<init>(r3)     // Catch:{ all -> 0x009f }
            f27049a = r1     // Catch:{ all -> 0x009f }
            goto L_0x009d
        L_0x002d:
            com.mob.commons.b.n r1 = new com.mob.commons.b.n     // Catch:{ all -> 0x009f }
            r1.<init>(r3)     // Catch:{ all -> 0x009f }
            f27049a = r1     // Catch:{ all -> 0x009f }
            goto L_0x009d
        L_0x0036:
            com.mob.commons.b.b r1 = new com.mob.commons.b.b     // Catch:{ all -> 0x009f }
            r1.<init>(r3)     // Catch:{ all -> 0x009f }
            f27049a = r1     // Catch:{ all -> 0x009f }
            goto L_0x009d
        L_0x003e:
            com.mob.commons.b.r r1 = new com.mob.commons.b.r     // Catch:{ all -> 0x009f }
            r1.<init>(r3)     // Catch:{ all -> 0x009f }
            f27049a = r1     // Catch:{ all -> 0x009f }
            goto L_0x009d
        L_0x0046:
            com.mob.commons.b.k r1 = new com.mob.commons.b.k     // Catch:{ all -> 0x009f }
            r1.<init>(r3)     // Catch:{ all -> 0x009f }
            f27049a = r1     // Catch:{ all -> 0x009f }
            goto L_0x009d
        L_0x004e:
            com.mob.commons.b.i r1 = new com.mob.commons.b.i     // Catch:{ all -> 0x009f }
            r1.<init>(r3)     // Catch:{ all -> 0x009f }
            f27049a = r1     // Catch:{ all -> 0x009f }
            goto L_0x009d
        L_0x0056:
            com.mob.commons.b.o r1 = new com.mob.commons.b.o     // Catch:{ all -> 0x009f }
            r1.<init>(r3)     // Catch:{ all -> 0x009f }
            f27049a = r1     // Catch:{ all -> 0x009f }
            goto L_0x009d
        L_0x005e:
            com.mob.commons.b.a r1 = new com.mob.commons.b.a     // Catch:{ all -> 0x009f }
            r1.<init>(r3)     // Catch:{ all -> 0x009f }
            f27049a = r1     // Catch:{ all -> 0x009f }
            goto L_0x009d
        L_0x0066:
            com.mob.commons.b.j r1 = new com.mob.commons.b.j     // Catch:{ all -> 0x009f }
            r1.<init>(r3)     // Catch:{ all -> 0x009f }
            f27049a = r1     // Catch:{ all -> 0x009f }
            goto L_0x009d
        L_0x006e:
            com.mob.commons.b.l r1 = new com.mob.commons.b.l     // Catch:{ all -> 0x009f }
            r1.<init>(r3)     // Catch:{ all -> 0x009f }
            f27049a = r1     // Catch:{ all -> 0x009f }
            goto L_0x009d
        L_0x0076:
            com.mob.commons.b.m r1 = new com.mob.commons.b.m     // Catch:{ all -> 0x009f }
            r1.<init>(r3)     // Catch:{ all -> 0x009f }
            f27049a = r1     // Catch:{ all -> 0x009f }
            goto L_0x009d
        L_0x007e:
            com.mob.commons.b.f r1 = new com.mob.commons.b.f     // Catch:{ all -> 0x009f }
            r1.<init>(r3)     // Catch:{ all -> 0x009f }
            f27049a = r1     // Catch:{ all -> 0x009f }
            goto L_0x009d
        L_0x0086:
            com.mob.commons.b.g r1 = new com.mob.commons.b.g     // Catch:{ all -> 0x009f }
            r1.<init>(r3)     // Catch:{ all -> 0x009f }
            f27049a = r1     // Catch:{ all -> 0x009f }
            goto L_0x009d
        L_0x008e:
            com.mob.commons.b.p r1 = new com.mob.commons.b.p     // Catch:{ all -> 0x009f }
            r1.<init>(r3)     // Catch:{ all -> 0x009f }
            f27049a = r1     // Catch:{ all -> 0x009f }
            goto L_0x009d
        L_0x0096:
            com.mob.commons.b.q r1 = new com.mob.commons.b.q     // Catch:{ all -> 0x009f }
            r1.<init>(r3)     // Catch:{ all -> 0x009f }
            f27049a = r1     // Catch:{ all -> 0x009f }
        L_0x009d:
            monitor-exit(r0)
            return
        L_0x009f:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.b.e.a(android.content.Context):void");
    }

    public static String b(Context context) {
        a(context);
        h hVar = f27049a;
        if (hVar == null) {
            return null;
        }
        if (hVar instanceof f) {
            String d11 = hVar.d();
            if (!TextUtils.isEmpty(d11) && !Pattern.compile("^[0fF\\-]+").matcher(d11).matches()) {
                return d11;
            }
            f27049a = new g(context);
        } else if (hVar instanceof l) {
            String d12 = hVar.d();
            if (!TextUtils.isEmpty(d12) && !Pattern.compile("^[0fF\\-]+").matcher(d12).matches()) {
                return d12;
            }
            f27049a = new m(context);
        }
        return f27049a.d();
    }

    private static boolean c(Context context) {
        try {
            final Object[] objArr = new Object[1];
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            DH.requester(context).getMpfo(l.a("027eMfmfhfnJe0fmfmPilfHfefnfe$h.fffk ehXfkfehkfiMllNfmflXk"), 0).request(new DH.DHResponder() {
                public void onResponse(DH.DHResponse dHResponse) throws Throwable {
                    objArr[0] = dHResponse.getMpfo(new int[0]);
                    countDownLatch.countDown();
                }
            });
            countDownLatch.await(3, TimeUnit.SECONDS);
            if (objArr[0] != null) {
                return true;
            }
            return false;
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return false;
        }
    }

    public enum a {
        UNSUPPORT(-1, l.a("009@fi[g'hkfiJll.fmflPk")),
        HUA_WEI(0, l.a("006'hmgmhfihikgg"), l.a("021Aflfmfnhhfifk4iYfefnff,h!flhkfkfm4gKfnIhAfhfifk")),
        XIAOMI(1, l.a("0064iifkNf4fmfhfk"), l.a("023_flfmfnfhfkfifkfnfifkfnffRh6flhkfkfmJg?fnXgf?fhYh")),
        VIVO(2, l.a("004Rfffkfffm"), l.a("0184flfmfnfffkfffmfnfmhkfnffGh%flhkfkfm:g")),
        OPPO(3, l.a("0042fmZll0fm"), l.a("024Jflfmfnhhfifk_iAfefnffPhHflhkfkfmEg<fnfmVll.fmflfmfh")),
        MOTO(4, l.a("008'fhfm<kDfmflfm'if")),
        LENOVO(5, l.a("006ihgTfmfffm")),
        ASUS(6, l.a("004f'hkfihk")),
        SAMSUNG(7, l.a("007@hkJf<fhhkfiDgJgl")),
        MEIZU(8, l.a("005CfhWh7fkiffi")),
        ALPS(9, l.a("004fil_hk")),
        NUBIA(10, l.a("005g>fihhfkWf")),
        ONEPLUS(11, l.a("007TfmRghliJfihk")),
        BLACKSHARK(12, l.a("010=hhKifeIgjhkFjf_flgj")),
        ZTE(13, l.a("003@ifLkh")),
        FERRMEOS(14, l.a("0087ghflUhh>fh1hPfmhk")),
        SSUI(15, l.a("004Nhkhkfifk")),
        HORNOR(16, SystemUtils.PRODUCT_HONOR),
        REALME(17, "REALME"),
        REDMI(18, "REDMI"),
        MEITU(19, "MEITU"),
        ZUK(20, "ZUK"),
        MBLU(21, "MBLU"),
        COOLPAD(22, "COOLPAD"),
        COOSEA(23, "COOSEA"),
        QIKU(24, "360OS", l.a("018DflfmfnhhfifkZi*fefnfifkffQhFflhkfkfmQg"));
        
        private final int A;
        /* access modifiers changed from: private */
        public String B;
        /* access modifiers changed from: private */
        public String C;

        private a(int i11, String str) {
            this.A = i11;
            this.B = str;
        }

        private a(int i11, String str, String str2) {
            this.A = i11;
            this.B = str;
            this.C = str2;
        }
    }

    private static boolean c() {
        return "PRIZE".equalsIgnoreCase(DH.SyncMtd.getSystemProperties("ro.odm.manufacturer"));
    }

    private static boolean b() {
        String systemProperties = DH.SyncMtd.getSystemProperties(l.a("015.flfmfnhkhkfifkfn_l3flfmfefi9ek"));
        return !TextUtils.isEmpty(systemProperties) && !systemProperties.equalsIgnoreCase(l.a("007GfiGg+gjIgJfmhi,g"));
    }

    public static a a(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            for (a aVar : a.values()) {
                if (aVar.B.equalsIgnoreCase(str) || aVar.B.equalsIgnoreCase(str2) || (!TextUtils.isEmpty(aVar.C) && !TextUtils.isEmpty(DH.SyncMtd.getSystemProperties(aVar.C)))) {
                    return aVar;
                }
            }
        }
        if (a() || b()) {
            return a.ZTE;
        }
        if (c(context)) {
            return a.COOLPAD;
        }
        if (c()) {
            return a.COOSEA;
        }
        return a.UNSUPPORT;
    }

    private static boolean a() {
        String systemProperties = DH.SyncMtd.getSystemProperties(l.a("021OflfmfnhhfifkVi>fefnghflThhTfh hTfnCif$hhAhi"));
        return !TextUtils.isEmpty(systemProperties) && systemProperties.equalsIgnoreCase(l.a("008Sieilikikjeikijgn"));
    }
}
