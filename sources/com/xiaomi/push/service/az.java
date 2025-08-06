package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.bc;
import com.xiaomi.push.gj;
import com.xiaomi.push.gk;
import com.xiaomi.push.gq;
import com.xiaomi.push.hf;
import com.xiaomi.push.hq;
import com.xiaomi.push.s;
import com.xiaomi.push.x;
import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicLong;

public class az {

    /* renamed from: a  reason: collision with root package name */
    private static String f52535a;

    /* renamed from: a  reason: collision with other field name */
    private static SimpleDateFormat f3371a;

    /* renamed from: a  reason: collision with other field name */
    private static AtomicLong f3372a = new AtomicLong(0);

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        f3371a = simpleDateFormat;
        f52535a = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    }

    public static synchronized String a() {
        String str;
        synchronized (az.class) {
            String format = f3371a.format(Long.valueOf(System.currentTimeMillis()));
            if (!TextUtils.equals(f52535a, format)) {
                f3372a.set(0);
                f52535a = format;
            }
            str = format + Constants.ACCEPT_TIME_SEPARATOR_SERVER + f3372a.incrementAndGet();
        }
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0069  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList<com.xiaomi.push.hf> a(java.util.List<com.xiaomi.push.gk> r11, java.lang.String r12, java.lang.String r13, int r14) {
        /*
            r0 = 0
            if (r11 != 0) goto L_0x0009
            java.lang.String r11 = "requests can not be null in TinyDataHelper.transToThriftObj()."
            com.xiaomi.channel.commonutils.logger.b.d(r11)
            return r0
        L_0x0009:
            int r1 = r11.size()
            if (r1 != 0) goto L_0x0015
            java.lang.String r11 = "requests.length is 0 in TinyDataHelper.transToThriftObj()."
            com.xiaomi.channel.commonutils.logger.b.d(r11)
            return r0
        L_0x0015:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            com.xiaomi.push.gj r2 = new com.xiaomi.push.gj
            r2.<init>()
            r3 = 0
            r4 = r3
            r5 = r4
        L_0x0022:
            int r6 = r11.size()
            if (r4 >= r6) goto L_0x00ad
            java.lang.Object r6 = r11.get(r4)
            com.xiaomi.push.gk r6 = (com.xiaomi.push.gk) r6
            if (r6 != 0) goto L_0x0032
            goto L_0x00a9
        L_0x0032:
            java.util.Map r7 = r6.a()
            if (r7 == 0) goto L_0x0071
            java.util.Map r7 = r6.a()
            java.lang.String r8 = "item_size"
            boolean r7 = r7.containsKey(r8)
            if (r7 == 0) goto L_0x0071
            java.util.Map r7 = r6.a()
            java.lang.Object r7 = r7.get(r8)
            java.lang.String r7 = (java.lang.String) r7
            boolean r9 = android.text.TextUtils.isEmpty(r7)
            if (r9 != 0) goto L_0x0059
            int r7 = java.lang.Integer.parseInt(r7)     // Catch:{ Exception -> 0x0059 }
            goto L_0x005a
        L_0x0059:
            r7 = r3
        L_0x005a:
            java.util.Map r9 = r6.a()
            int r9 = r9.size()
            r10 = 1
            if (r9 != r10) goto L_0x0069
            r6.a((java.util.Map<java.lang.String, java.lang.String>) r0)
            goto L_0x0072
        L_0x0069:
            java.util.Map r9 = r6.a()
            r9.remove(r8)
            goto L_0x0072
        L_0x0071:
            r7 = r3
        L_0x0072:
            if (r7 > 0) goto L_0x0079
            byte[] r7 = com.xiaomi.push.hq.a(r6)
            int r7 = r7.length
        L_0x0079:
            if (r7 <= r14) goto L_0x0094
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "TinyData is too big, ignore upload request item:"
            r7.append(r8)
            java.lang.String r6 = r6.d()
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            com.xiaomi.channel.commonutils.logger.b.d(r6)
            goto L_0x00a9
        L_0x0094:
            int r8 = r5 + r7
            if (r8 <= r14) goto L_0x00a5
            com.xiaomi.push.hf r2 = a(r12, r13, r2)
            r1.add(r2)
            com.xiaomi.push.gj r2 = new com.xiaomi.push.gj
            r2.<init>()
            r5 = r3
        L_0x00a5:
            r2.a((com.xiaomi.push.gk) r6)
            int r5 = r5 + r7
        L_0x00a9:
            int r4 = r4 + 1
            goto L_0x0022
        L_0x00ad:
            int r11 = r2.a()
            if (r11 == 0) goto L_0x00ba
            com.xiaomi.push.hf r11 = a(r12, r13, r2)
            r1.add(r11)
        L_0x00ba:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.az.a(java.util.List, java.lang.String, java.lang.String, int):java.util.ArrayList");
    }

    private static hf a(String str, String str2, gj gjVar) {
        return new hf("-1", false).d(str).b(str2).a(x.a(hq.a(gjVar))).c(gq.UploadTinyData.f2942a);
    }

    public static boolean a(gk gkVar, boolean z11) {
        if (gkVar == null) {
            b.a("item is null, verfiy ClientUploadDataItem failed.");
            return true;
        } else if (!z11 && TextUtils.isEmpty(gkVar.f2914a)) {
            b.a("item.channel is null or empty, verfiy ClientUploadDataItem failed.");
            return true;
        } else if (TextUtils.isEmpty(gkVar.f2921d)) {
            b.a("item.category is null or empty, verfiy ClientUploadDataItem failed.");
            return true;
        } else if (TextUtils.isEmpty(gkVar.f2920c)) {
            b.a("item.name is null or empty, verfiy ClientUploadDataItem failed.");
            return true;
        } else if (!bc.a(gkVar.f2921d)) {
            b.a("item.category can only contain ascii char, verfiy ClientUploadDataItem failed.");
            return true;
        } else if (!bc.a(gkVar.f2920c)) {
            b.a("item.name can only contain ascii char, verfiy ClientUploadDataItem failed.");
            return true;
        } else {
            String str = gkVar.f2919b;
            if (str == null || str.length() <= 30720) {
                return false;
            }
            b.a("item.data is too large(" + gkVar.f2919b.length() + "), max size for data is " + 30720 + " , verfiy ClientUploadDataItem failed.");
            return true;
        }
    }

    public static void a(Context context, String str, String str2, long j11, String str3) {
        gk gkVar = new gk();
        gkVar.d(str);
        gkVar.c(str2);
        gkVar.a(j11);
        gkVar.b(str3);
        gkVar.a("push_sdk_channel");
        gkVar.g(context.getPackageName());
        gkVar.e(context.getPackageName());
        gkVar.a(true);
        gkVar.b(System.currentTimeMillis());
        gkVar.f(a());
        ba.a(context, gkVar);
    }

    public static boolean a(String str) {
        return !s.b() || Constants.HYBRID_PACKAGE_NAME.equals(str);
    }
}
