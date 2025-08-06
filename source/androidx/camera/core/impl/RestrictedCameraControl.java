package androidx.camera.core.impl;

import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.FocusMeteringResult;
import androidx.camera.core.impl.utils.futures.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Set;

public class RestrictedCameraControl extends ForwardingCameraControl {
    public static final int AE_REGION = 3;
    public static final int AF_REGION = 2;
    public static final int AUTO_FOCUS = 1;
    public static final int AWB_REGION = 4;
    public static final int EXPOSURE_COMPENSATION = 7;
    public static final int FLASH = 5;
    public static final int TORCH = 6;
    public static final int ZOOM = 0;
    private final CameraControlInternal mCameraControl;
    @CameraOperation
    private volatile Set<Integer> mRestrictedCameraOperations;
    private volatile boolean mUseRestrictedCameraOperations = false;

    public @interface CameraOperation {
    }

    public RestrictedCameraControl(CameraControlInternal cameraControlInternal) {
        super(cameraControlInternal);
        this.mCameraControl = cameraControlInternal;
    }

    public ListenableFuture<Void> cancelFocusAndMetering() {
        return this.mCameraControl.cancelFocusAndMetering();
    }

    public void enableRestrictedOperations(boolean z11, @CameraOperation Set<Integer> set) {
        this.mUseRestrictedCameraOperations = z11;
        this.mRestrictedCameraOperations = set;
    }

    public ListenableFuture<Void> enableTorch(boolean z11) {
        if (!isOperationSupported(6)) {
            return Futures.immediateFailedFuture(new IllegalStateException("Torch is not supported"));
        }
        return this.mCameraControl.enableTorch(z11);
    }

    public CameraControlInternal getImplementation() {
        return this.mCameraControl;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0058 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0059  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.camera.core.FocusMeteringAction getModifiedFocusMeteringAction(androidx.camera.core.FocusMeteringAction r8) {
        /*
            r7 = this;
            androidx.camera.core.FocusMeteringAction$Builder r0 = new androidx.camera.core.FocusMeteringAction$Builder
            r0.<init>((androidx.camera.core.FocusMeteringAction) r8)
            java.util.List r1 = r8.getMeteringPointsAf()
            boolean r1 = r1.isEmpty()
            r2 = 2
            r3 = 0
            r4 = 1
            if (r1 != 0) goto L_0x0022
            int[] r1 = new int[r2]
            r1 = {1, 2} // fill-array
            boolean r1 = r7.isOperationSupported(r1)
            if (r1 != 0) goto L_0x0022
            r0.removePoints(r4)
            r1 = r4
            goto L_0x0023
        L_0x0022:
            r1 = r3
        L_0x0023:
            java.util.List r5 = r8.getMeteringPointsAe()
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x003c
            int[] r5 = new int[r4]
            r6 = 3
            r5[r3] = r6
            boolean r5 = r7.isOperationSupported(r5)
            if (r5 != 0) goto L_0x003c
            r0.removePoints(r2)
            r1 = r4
        L_0x003c:
            java.util.List r2 = r8.getMeteringPointsAwb()
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x0055
            int[] r2 = new int[r4]
            r5 = 4
            r2[r3] = r5
            boolean r2 = r7.isOperationSupported(r2)
            if (r2 != 0) goto L_0x0055
            r0.removePoints(r5)
            goto L_0x0056
        L_0x0055:
            r4 = r1
        L_0x0056:
            if (r4 != 0) goto L_0x0059
            return r8
        L_0x0059:
            androidx.camera.core.FocusMeteringAction r8 = r0.build()
            java.util.List r1 = r8.getMeteringPointsAf()
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x007d
            java.util.List r1 = r8.getMeteringPointsAe()
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x007d
            java.util.List r8 = r8.getMeteringPointsAwb()
            boolean r8 = r8.isEmpty()
            if (r8 == 0) goto L_0x007d
            r8 = 0
            return r8
        L_0x007d:
            androidx.camera.core.FocusMeteringAction r8 = r0.build()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.RestrictedCameraControl.getModifiedFocusMeteringAction(androidx.camera.core.FocusMeteringAction):androidx.camera.core.FocusMeteringAction");
    }

    public boolean isOperationSupported(@CameraOperation int... iArr) {
        if (!this.mUseRestrictedCameraOperations || this.mRestrictedCameraOperations == null) {
            return true;
        }
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int valueOf : iArr) {
            arrayList.add(Integer.valueOf(valueOf));
        }
        return this.mRestrictedCameraOperations.containsAll(arrayList);
    }

    public ListenableFuture<Integer> setExposureCompensationIndex(int i11) {
        if (!isOperationSupported(7)) {
            return Futures.immediateFailedFuture(new IllegalStateException("ExposureCompensation is not supported"));
        }
        return this.mCameraControl.setExposureCompensationIndex(i11);
    }

    public ListenableFuture<Void> setLinearZoom(float f11) {
        if (!isOperationSupported(0)) {
            return Futures.immediateFailedFuture(new IllegalStateException("Zoom is not supported"));
        }
        return this.mCameraControl.setLinearZoom(f11);
    }

    public ListenableFuture<Void> setZoomRatio(float f11) {
        if (!isOperationSupported(0)) {
            return Futures.immediateFailedFuture(new IllegalStateException("Zoom is not supported"));
        }
        return this.mCameraControl.setZoomRatio(f11);
    }

    public ListenableFuture<FocusMeteringResult> startFocusAndMetering(FocusMeteringAction focusMeteringAction) {
        FocusMeteringAction modifiedFocusMeteringAction = getModifiedFocusMeteringAction(focusMeteringAction);
        if (modifiedFocusMeteringAction == null) {
            return Futures.immediateFailedFuture(new IllegalStateException("FocusMetering is not supported"));
        }
        return this.mCameraControl.startFocusAndMetering(modifiedFocusMeteringAction);
    }
}
