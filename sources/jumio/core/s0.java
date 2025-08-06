package jumio.core;

import com.jumio.sdk.enums.JumioDataCenter;
import kotlin.NoWhenBranchMatchedException;

public final class s0 implements j {

    /* renamed from: a  reason: collision with root package name */
    public final l f56317a = new l(k.f56230b, e.f56176b, e.f56179e);

    /* renamed from: b  reason: collision with root package name */
    public final l f56318b = new l(k.f56229a, e.f56175a, e.f56178d);

    /* renamed from: c  reason: collision with root package name */
    public final l f56319c = new l(k.f56231c, e.f56177c, e.f56180f);

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f56320a;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.jumio.sdk.enums.JumioDataCenter[] r0 = com.jumio.sdk.enums.JumioDataCenter.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.jumio.sdk.enums.JumioDataCenter r1 = com.jumio.sdk.enums.JumioDataCenter.EU     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.jumio.sdk.enums.JumioDataCenter r1 = com.jumio.sdk.enums.JumioDataCenter.US     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.jumio.sdk.enums.JumioDataCenter r1 = com.jumio.sdk.enums.JumioDataCenter.SG     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f56320a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: jumio.core.s0.a.<clinit>():void");
        }
    }

    public final l a(JumioDataCenter jumioDataCenter) {
        int i11 = a.f56320a[jumioDataCenter.ordinal()];
        if (i11 == 1) {
            return this.f56317a;
        }
        if (i11 == 2) {
            return this.f56318b;
        }
        if (i11 == 3) {
            return this.f56319c;
        }
        throw new NoWhenBranchMatchedException();
    }
}
