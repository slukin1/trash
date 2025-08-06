package com.iproov.sdk.cameray;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import com.iproov.sdk.bridge.OptionsBridge;
import com.iproov.sdk.cameray.Ccase;
import com.iproov.sdk.cameray.Ctry;
import com.iproov.sdk.p021new.Cif;
import java.util.ArrayList;
import java.util.Objects;

/* renamed from: com.iproov.sdk.cameray.goto  reason: invalid class name */
public class Cgoto implements Celse {

    /* renamed from: com.iproov.sdk.cameray.goto$do  reason: invalid class name */
    public static /* synthetic */ class Cdo {

        /* renamed from: do  reason: not valid java name */
        public static final /* synthetic */ int[] f98do;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.iproov.sdk.cameray.const[] r0 = com.iproov.sdk.cameray.Cconst.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f98do = r0
                com.iproov.sdk.cameray.const r1 = com.iproov.sdk.cameray.Cconst.CAMERA1     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f98do     // Catch:{ NoSuchFieldError -> 0x001d }
                com.iproov.sdk.cameray.const r1 = com.iproov.sdk.cameray.Cconst.CAMERA2     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.cameray.Cgoto.Cdo.<clinit>():void");
        }
    }

    /* renamed from: if  reason: not valid java name */
    private Cfinal m141if(Context context) throws Ccase {
        ArrayList arrayList = new ArrayList();
        try {
            CameraManager cameraManager = (CameraManager) context.getSystemService(OptionsBridge.CAMERA_KEY);
            if (cameraManager != null) {
                for (String str : cameraManager.getCameraIdList()) {
                    Integer num = (Integer) cameraManager.getCameraCharacteristics(str).get(CameraCharacteristics.LENS_FACING);
                    if (num != null) {
                        arrayList.add(new Cif(arrayList.size(), m139do(num.intValue()), str));
                    }
                }
            }
            return new Cfinal(Cconst.CAMERA2, arrayList);
        } catch (CameraAccessException | RuntimeException e11) {
            e11.printStackTrace();
            throw new Ccase(Ccase.Cdo.CAMERA_ERROR, e11.getLocalizedMessage());
        }
    }

    /* renamed from: do  reason: not valid java name */
    public Ctry m144do(Context context, boolean z11, com.iproov.sdk.p021new.Ccase caseR, Ctry.Cdo doVar, com.iproov.sdk.p021new.Ctry tryR, com.iproov.sdk.p021new.Cgoto gotoR) throws Ccase {
        Objects.toString(caseR);
        if (caseR.m1181do() == Cconst.CAMERA2) {
            return new Cif(context, z11, caseR.m1182for(), caseR.m1183if(), doVar, tryR, gotoR);
        }
        return new Cdo(caseR.m1184new(), z11, caseR.m1183if(), doVar, tryR, gotoR);
    }

    /* renamed from: do  reason: not valid java name */
    public Ccatch m142do(Context context) throws Ccase {
        com.iproov.sdk.p021new.Ccase caseR = m141if(context).m128do();
        if (caseR == null) {
            return null;
        }
        CameraManager cameraManager = (CameraManager) context.getSystemService(OptionsBridge.CAMERA_KEY);
        if (cameraManager != null) {
            try {
                Integer num = (Integer) cameraManager.getCameraCharacteristics(caseR.m1182for()).get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
                if (num != null) {
                    int intValue = num.intValue();
                    if (intValue == 0) {
                        return Ccatch.CAMERA2_LIMITED;
                    }
                    if (intValue == 1) {
                        return Ccatch.CAMERA2_FULL;
                    }
                    if (intValue == 2) {
                        return Ccatch.CAMERA2_LEGACY;
                    }
                    if (intValue == 3) {
                        return Ccatch.CAMERA2_LEVEL3;
                    }
                    if (intValue == 4) {
                        return Ccatch.CAMERA2_EXTERNAL;
                    }
                }
            } catch (CameraAccessException | RuntimeException e11) {
                e11.printStackTrace();
                throw new Ccase(Ccase.Cdo.CAMERA_ERROR, e11.getLocalizedMessage());
            }
        }
        return Ccatch.CAMERA1;
    }

    /* renamed from: do  reason: not valid java name */
    public Cfinal m143do(Context context, Cconst constR) throws Ccase {
        if (constR == null) {
            return null;
        }
        int i11 = Cdo.f98do[constR.ordinal()];
        if (i11 == 1) {
            return m140do();
        }
        if (i11 != 2) {
            return null;
        }
        return m141if(context);
    }

    /* renamed from: do  reason: not valid java name */
    private Cfinal m140do() {
        Cbreak breakR;
        ArrayList arrayList = new ArrayList();
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i11 = 0; i11 < numberOfCameras; i11++) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i11, cameraInfo);
            if (cameraInfo.facing == 0) {
                breakR = Cbreak.BACK;
            } else {
                breakR = Cbreak.FRONT;
            }
            arrayList.add(new com.iproov.sdk.p021new.Cdo(i11, breakR));
        }
        return new Cfinal(Cconst.CAMERA1, arrayList);
    }

    /* renamed from: do  reason: not valid java name */
    private Cbreak m139do(int i11) {
        if (i11 == 0) {
            return Cbreak.FRONT;
        }
        if (i11 != 2) {
            return Cbreak.BACK;
        }
        return Cbreak.EXTERNAL;
    }
}
