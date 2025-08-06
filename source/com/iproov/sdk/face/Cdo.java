package com.iproov.sdk.face;

import android.content.Context;
import com.iproov.sdk.core.exception.FaceDetectorException;
import com.iproov.sdk.p006const.Cif;
import com.iproov.sdk.p026return.Cextends;

/* renamed from: com.iproov.sdk.face.do  reason: invalid class name */
public class Cdo {

    /* renamed from: com.iproov.sdk.face.do$do  reason: invalid class name */
    public static /* synthetic */ class Cdo {

        /* renamed from: do  reason: not valid java name */
        public static final /* synthetic */ int[] f528do;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.iproov.sdk.return.extends$try[] r0 = com.iproov.sdk.p026return.Cextends.Ctry.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f528do = r0
                com.iproov.sdk.return.extends$try r1 = com.iproov.sdk.p026return.Cextends.Ctry.AUTO     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f528do     // Catch:{ NoSuchFieldError -> 0x001d }
                com.iproov.sdk.return.extends$try r1 = com.iproov.sdk.p026return.Cextends.Ctry.CLASSIC     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f528do     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.iproov.sdk.return.extends$try r1 = com.iproov.sdk.p026return.Cextends.Ctry.BLAZEFACE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f528do     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.iproov.sdk.return.extends$try r1 = com.iproov.sdk.p026return.Cextends.Ctry.ML_KIT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.face.Cdo.Cdo.<clinit>():void");
        }
    }

    /* renamed from: do  reason: not valid java name */
    public static FaceDetectorFactory m611do(Context context, Cextends.Cif ifVar) throws FaceDetectorException {
        int i11 = Cdo.f528do[ifVar.m1517if().ordinal()];
        if (i11 == 1) {
            FaceDetectorFactory faceDetectorFactory = m612for();
            if (faceDetectorFactory != null) {
                return faceDetectorFactory;
            }
            FaceDetectorFactory faceDetectorFactory2 = m610do();
            return faceDetectorFactory2 == null ? m613if() : faceDetectorFactory2;
        } else if (i11 == 2) {
            return m613if();
        } else {
            if (i11 == 3) {
                FaceDetectorFactory faceDetectorFactory3 = m610do();
                if (faceDetectorFactory3 != null) {
                    return faceDetectorFactory3;
                }
                throw new FaceDetectorException(context, "BlazeFace module not available");
            } else if (i11 != 4) {
                return null;
            } else {
                FaceDetectorFactory faceDetectorFactory4 = m612for();
                if (faceDetectorFactory4 != null) {
                    return faceDetectorFactory4;
                }
                throw new FaceDetectorException(context, "ML Kit module not available. Please ensure you have added the iproov-mlkit module to your app. Visit https://github.com/iProov/android#-mlkit-support for further details.");
            }
        }
    }

    /* renamed from: for  reason: not valid java name */
    private static FaceDetectorFactory m612for() {
        try {
            return (FaceDetectorFactory) Class.forName("com.iproov.sdk.face.MLKitFaceDetectorFactory").newInstance();
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: if  reason: not valid java name */
    private static FaceDetectorFactory m613if() {
        return new Cif();
    }

    /* renamed from: do  reason: not valid java name */
    private static FaceDetectorFactory m610do() {
        try {
            return (FaceDetectorFactory) Class.forName("com.iproov.sdk.face.BlazeFaceDetectorFactory").newInstance();
        } catch (Exception unused) {
            return null;
        }
    }
}
