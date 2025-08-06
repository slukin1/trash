package jumio.iproov;

import com.iproov.sdk.IProov;

public final class c {

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f56421a;

        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|27) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0050 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.iproov.sdk.IProov$FailureReason[] r0 = com.iproov.sdk.IProov.FailureReason.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.iproov.sdk.IProov$FailureReason r1 = com.iproov.sdk.IProov.FailureReason.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.iproov.sdk.IProov$FailureReason r1 = com.iproov.sdk.IProov.FailureReason.TOO_MUCH_MOVEMENT     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.iproov.sdk.IProov$FailureReason r1 = com.iproov.sdk.IProov.FailureReason.TOO_BRIGHT     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.iproov.sdk.IProov$FailureReason r1 = com.iproov.sdk.IProov.FailureReason.TOO_DARK     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.iproov.sdk.IProov$FailureReason r1 = com.iproov.sdk.IProov.FailureReason.MISALIGNED_FACE     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.iproov.sdk.IProov$FailureReason r1 = com.iproov.sdk.IProov.FailureReason.EYES_CLOSED     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                com.iproov.sdk.IProov$FailureReason r1 = com.iproov.sdk.IProov.FailureReason.FACE_TOO_FAR     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                com.iproov.sdk.IProov$FailureReason r1 = com.iproov.sdk.IProov.FailureReason.FACE_TOO_CLOSE     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                com.iproov.sdk.IProov$FailureReason r1 = com.iproov.sdk.IProov.FailureReason.SUNGLASSES     // Catch:{ NoSuchFieldError -> 0x005a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                com.iproov.sdk.IProov$FailureReason r1 = com.iproov.sdk.IProov.FailureReason.OBSCURED_FACE     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                com.iproov.sdk.IProov$FailureReason r1 = com.iproov.sdk.IProov.FailureReason.USER_TIMEOUT     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                com.iproov.sdk.IProov$FailureReason r1 = com.iproov.sdk.IProov.FailureReason.NOT_SUPPORTED     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                f56421a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: jumio.iproov.c.a.<clinit>():void");
        }
    }

    public static final int a(IProov.FailureReason failureReason) {
        switch (a.f56421a[failureReason.ordinal()]) {
            case 2:
                return 101;
            case 3:
                return 102;
            case 4:
                return 103;
            case 5:
                return 104;
            case 6:
                return 105;
            case 7:
                return 106;
            case 8:
                return 107;
            case 9:
                return 108;
            case 10:
                return 109;
            case 11:
                return 110;
            case 12:
                return 111;
            default:
                return 100;
        }
    }
}
