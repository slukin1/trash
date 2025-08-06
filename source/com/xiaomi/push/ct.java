package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;

public class ct {

    /* renamed from: com.xiaomi.push.ct$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f51533a;

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
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
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.xiaomi.push.gg[] r0 = com.xiaomi.push.gg.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f51533a = r0
                com.xiaomi.push.gg r1 = com.xiaomi.push.gg.Registration     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f51533a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.xiaomi.push.gg r1 = com.xiaomi.push.gg.UnRegistration     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f51533a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.xiaomi.push.gg r1 = com.xiaomi.push.gg.Subscription     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f51533a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.xiaomi.push.gg r1 = com.xiaomi.push.gg.UnSubscription     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f51533a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.xiaomi.push.gg r1 = com.xiaomi.push.gg.SendMessage     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f51533a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.xiaomi.push.gg r1 = com.xiaomi.push.gg.AckMessage     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f51533a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.xiaomi.push.gg r1 = com.xiaomi.push.gg.SetConfig     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f51533a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.xiaomi.push.gg r1 = com.xiaomi.push.gg.ReportFeedback     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f51533a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.xiaomi.push.gg r1 = com.xiaomi.push.gg.MultiConnectionBroadcast     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f51533a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.xiaomi.push.gg r1 = com.xiaomi.push.gg.MultiConnectionResult     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f51533a     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.xiaomi.push.gg r1 = com.xiaomi.push.gg.Notification     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f51533a     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.xiaomi.push.gg r1 = com.xiaomi.push.gg.Command     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.ct.AnonymousClass1.<clinit>():void");
        }
    }

    public static int a(hr hrVar, gg ggVar) {
        int a11;
        switch (AnonymousClass1.f51533a[ggVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                return dt.a(ggVar.a());
            case 11:
                a11 = dt.a(ggVar.a());
                if (hrVar != null) {
                    try {
                        if (hrVar instanceof gx) {
                            String str = ((gx) hrVar).f3027d;
                            if (!TextUtils.isEmpty(str) && dt.a((Enum) dt.a(str)) != -1) {
                                a11 = dt.a((Enum) dt.a(str));
                                break;
                            }
                        } else if (hrVar instanceof hf) {
                            String str2 = ((hf) hrVar).f3086d;
                            if (!TextUtils.isEmpty(str2)) {
                                if (dt.a((Enum) dt.a(str2)) != -1) {
                                    a11 = dt.a((Enum) dt.a(str2));
                                }
                                if (gq.UploadTinyData.equals(dt.a(str2))) {
                                    return -1;
                                }
                            }
                        }
                    } catch (Exception unused) {
                        int i11 = a11;
                        b.d("PERF_ERROR : parse Notification type error");
                        return i11;
                    }
                }
                break;
            case 12:
                a11 = dt.a(ggVar.a());
                if (hrVar != null) {
                    try {
                        if (hrVar instanceof hb) {
                            String b11 = ((hb) hrVar).b();
                            if (!TextUtils.isEmpty(b11) && ee.a(b11) != -1) {
                                a11 = ee.a(b11);
                                break;
                            }
                        } else if (hrVar instanceof ha) {
                            String a12 = ((ha) hrVar).a();
                            if (!TextUtils.isEmpty(a12) && ee.a(a12) != -1) {
                                return ee.a(a12);
                            }
                        }
                    } catch (Exception unused2) {
                        b.d("PERF_ERROR : parse Command type error");
                        break;
                    }
                }
                break;
            default:
                return -1;
        }
        return a11;
    }

    public static int a(Context context, int i11) {
        int a11 = ga.a(context);
        if (-1 == a11) {
            return -1;
        }
        return (i11 * (a11 == 0 ? 13 : 11)) / 10;
    }

    public static int a(gg ggVar) {
        return dt.a(ggVar.a());
    }

    public static void a(String str, Context context, byte[] bArr) {
        if (context != null && bArr != null && bArr.length > 0) {
            hc hcVar = new hc();
            try {
                hq.a(hcVar, bArr);
                a(str, context, hcVar, bArr.length);
            } catch (hv unused) {
                b.a("fail to convert bytes to container");
            }
        }
    }

    public static void a(String str, Context context, hc hcVar, int i11) {
        gg a11;
        if (context != null && hcVar != null && (a11 = hcVar.a()) != null) {
            int a12 = a(a11);
            if (i11 <= 0) {
                byte[] a13 = hq.a(hcVar);
                i11 = a13 != null ? a13.length : 0;
            }
            a(str, context, a12, i11);
        }
    }

    public static void a(String str, Context context, int i11, int i12) {
        if (i11 > 0 && i12 > 0) {
            int a11 = a(context, i12);
            if (i11 != dt.a((Enum) gq.UploadTinyData)) {
                du.a(context.getApplicationContext()).a(str, i11, 1, (long) a11);
            }
        }
    }

    public static void a(String str, Context context, hr hrVar, gg ggVar, int i11) {
        a(str, context, a(hrVar, ggVar), i11);
    }
}
