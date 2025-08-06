package com.iproov.sdk.p017implements;

import com.iproov.sdk.cameray.Orientation;

/* renamed from: com.iproov.sdk.implements.goto  reason: invalid class name and invalid package */
public class Cgoto {

    /* renamed from: do  reason: not valid java name */
    public static final float[] f936do = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};

    /* renamed from: for  reason: not valid java name */
    public static final float[] f937for = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f};

    /* renamed from: if  reason: not valid java name */
    public static final float[] f938if = {1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f};

    /* renamed from: new  reason: not valid java name */
    public static final float[] f939new = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: com.iproov.sdk.implements.goto$do  reason: invalid class name */
    public static /* synthetic */ class Cdo {

        /* renamed from: do  reason: not valid java name */
        public static final /* synthetic */ int[] f940do;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.iproov.sdk.cameray.Orientation[] r0 = com.iproov.sdk.cameray.Orientation.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f940do = r0
                com.iproov.sdk.cameray.Orientation r1 = com.iproov.sdk.cameray.Orientation.PORTRAIT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f940do     // Catch:{ NoSuchFieldError -> 0x001d }
                com.iproov.sdk.cameray.Orientation r1 = com.iproov.sdk.cameray.Orientation.LANDSCAPE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f940do     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.iproov.sdk.cameray.Orientation r1 = com.iproov.sdk.cameray.Orientation.REVERSE_PORTRAIT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f940do     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.iproov.sdk.cameray.Orientation r1 = com.iproov.sdk.cameray.Orientation.REVERSE_LANDSCAPE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.p017implements.Cgoto.Cdo.<clinit>():void");
        }
    }

    /* renamed from: do  reason: not valid java name */
    public static float[] m1008do(Orientation orientation) {
        int i11 = Cdo.f940do[orientation.ordinal()];
        if (i11 == 1) {
            return f936do;
        }
        if (i11 == 2) {
            return f938if;
        }
        if (i11 == 3) {
            return f937for;
        }
        if (i11 != 4) {
            return f939new;
        }
        return f939new;
    }

    /* renamed from: do  reason: not valid java name */
    public static Orientation m1007do(Orientation orientation, Orientation orientation2) {
        return Orientation.findByDegrees((orientation.angleDegrees + orientation2.angleDegrees) % 360);
    }
}
