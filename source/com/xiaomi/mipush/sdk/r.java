package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.az;
import com.xiaomi.push.gg;
import com.xiaomi.push.gv;
import com.xiaomi.push.gw;
import com.xiaomi.push.gx;
import com.xiaomi.push.h;
import com.xiaomi.push.hb;
import com.xiaomi.push.hc;
import com.xiaomi.push.hf;
import com.xiaomi.push.hh;
import com.xiaomi.push.hi;
import com.xiaomi.push.hj;
import com.xiaomi.push.hl;
import com.xiaomi.push.hn;
import com.xiaomi.push.hp;
import com.xiaomi.push.hq;
import com.xiaomi.push.hr;
import java.nio.ByteBuffer;

public class r {

    /* renamed from: com.xiaomi.mipush.sdk.r$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f51334a;

        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|(3:19|20|22)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.xiaomi.push.gg[] r0 = com.xiaomi.push.gg.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f51334a = r0
                com.xiaomi.push.gg r1 = com.xiaomi.push.gg.Registration     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f51334a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.xiaomi.push.gg r1 = com.xiaomi.push.gg.UnRegistration     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f51334a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.xiaomi.push.gg r1 = com.xiaomi.push.gg.Subscription     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f51334a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.xiaomi.push.gg r1 = com.xiaomi.push.gg.UnSubscription     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f51334a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.xiaomi.push.gg r1 = com.xiaomi.push.gg.SendMessage     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f51334a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.xiaomi.push.gg r1 = com.xiaomi.push.gg.AckMessage     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f51334a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.xiaomi.push.gg r1 = com.xiaomi.push.gg.SetConfig     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f51334a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.xiaomi.push.gg r1 = com.xiaomi.push.gg.ReportFeedback     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f51334a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.xiaomi.push.gg r1 = com.xiaomi.push.gg.Notification     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f51334a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.xiaomi.push.gg r1 = com.xiaomi.push.gg.Command     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.r.AnonymousClass1.<clinit>():void");
        }
    }

    public static <T extends hr<T, ?>> hc a(Context context, T t11, gg ggVar) {
        return a(context, t11, ggVar, !ggVar.equals(gg.Registration), context.getPackageName(), b.a(context).a());
    }

    public static <T extends hr<T, ?>> hc b(Context context, T t11, gg ggVar, boolean z11, String str, String str2) {
        return a(context, t11, ggVar, z11, str, str2, false);
    }

    public static <T extends hr<T, ?>> hc a(Context context, T t11, gg ggVar, boolean z11, String str, String str2) {
        return a(context, t11, ggVar, z11, str, str2, true);
    }

    public static <T extends hr<T, ?>> hc a(Context context, T t11, gg ggVar, boolean z11, String str, String str2, boolean z12) {
        byte[] a11 = hq.a(t11);
        if (a11 == null) {
            b.a("invoke convertThriftObjectToBytes method, return null.");
            return null;
        }
        hc hcVar = new hc();
        if (z11) {
            String d11 = b.a(context).d();
            if (TextUtils.isEmpty(d11)) {
                b.a("regSecret is empty, return null");
                return null;
            }
            try {
                a11 = h.b(az.a(d11), a11);
            } catch (Exception unused) {
                b.d("encryption error. ");
            }
        }
        gv gvVar = new gv();
        gvVar.f2990a = 5;
        gvVar.f2991a = "fakeid";
        hcVar.a(gvVar);
        hcVar.a(ByteBuffer.wrap(a11));
        hcVar.a(ggVar);
        hcVar.b(z12);
        hcVar.b(str);
        hcVar.a(z11);
        hcVar.a(str2);
        return hcVar;
    }

    public static hr a(Context context, hc hcVar) {
        byte[] bArr;
        if (hcVar.b()) {
            byte[] a11 = f.a(context, hcVar, d.ASSEMBLE_PUSH_FCM);
            if (a11 == null) {
                a11 = az.a(b.a(context).d());
            }
            try {
                bArr = h.a(a11, hcVar.a());
            } catch (Exception e11) {
                throw new l("the aes decrypt failed.", e11);
            }
        } else {
            bArr = hcVar.a();
        }
        hr a12 = a(hcVar.a(), hcVar.f3070b);
        if (a12 != null) {
            hq.a(a12, bArr);
        }
        return a12;
    }

    private static hr a(gg ggVar, boolean z11) {
        switch (AnonymousClass1.f51334a[ggVar.ordinal()]) {
            case 1:
                return new hh();
            case 2:
                return new hn();
            case 3:
                return new hl();
            case 4:
                return new hp();
            case 5:
                return new hj();
            case 6:
                return new gw();
            case 7:
                return new hb();
            case 8:
                return new hi();
            case 9:
                if (z11) {
                    return new hf();
                }
                gx gxVar = new gx();
                gxVar.a(true);
                return gxVar;
            case 10:
                return new hb();
            default:
                return null;
        }
    }
}
