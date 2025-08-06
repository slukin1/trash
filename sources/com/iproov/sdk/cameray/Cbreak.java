package com.iproov.sdk.cameray;

/* renamed from: com.iproov.sdk.cameray.break  reason: invalid class name */
public enum Cbreak {
    FRONT,
    BACK,
    EXTERNAL;

    /* renamed from: com.iproov.sdk.cameray.break$do  reason: invalid class name */
    public static /* synthetic */ class Cdo {

        /* renamed from: do  reason: not valid java name */
        public static final /* synthetic */ int[] f49do = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.iproov.sdk.cameray.break[] r0 = com.iproov.sdk.cameray.Cbreak.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f49do = r0
                com.iproov.sdk.cameray.break r1 = com.iproov.sdk.cameray.Cbreak.FRONT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f49do     // Catch:{ NoSuchFieldError -> 0x001d }
                com.iproov.sdk.cameray.break r1 = com.iproov.sdk.cameray.Cbreak.BACK     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f49do     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.iproov.sdk.cameray.break r1 = com.iproov.sdk.cameray.Cbreak.EXTERNAL     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.cameray.Cbreak.Cdo.<clinit>():void");
        }
    }

    /* renamed from: do  reason: not valid java name */
    public String m93do() {
        int i11 = Cdo.f49do[ordinal()];
        if (i11 == 1) {
            return "Front";
        }
        if (i11 == 2) {
            return "Back";
        }
        if (i11 == 3) {
            return "External";
        }
        throw new IllegalStateException();
    }
}
