package androidx.camera.core.impl;

import androidx.camera.core.Camera;
import androidx.camera.core.Logger;
import androidx.camera.core.concurrent.CameraCoordinator;
import androidx.camera.core.impl.CameraInternal;
import androidx.core.util.h;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.luck.picture.lib.config.PictureMimeType;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

public final class CameraStateRegistry implements CameraCoordinator.ConcurrentCameraModeListener {
    private static final int MAX_ALLOWED_CONCURRENT_CAMERAS_IN_CONCURRENT_MODE = 2;
    private static final int MAX_ALLOWED_CONCURRENT_CAMERAS_IN_SINGLE_MODE = 1;
    private static final String TAG = "CameraStateRegistry";
    private int mAvailableCameras;
    private final CameraCoordinator mCameraCoordinator;
    private final Map<Camera, CameraRegistration> mCameraStates;
    private final StringBuilder mDebugString = new StringBuilder();
    private final Object mLock;
    private int mMaxAllowedOpenedCameras;

    public static class CameraRegistration {
        private final Executor mNotifyExecutor;
        private final OnConfigureAvailableListener mOnConfigureAvailableListener;
        private final OnOpenAvailableListener mOnOpenAvailableListener;
        private CameraInternal.State mState;

        public CameraRegistration(CameraInternal.State state, Executor executor, OnConfigureAvailableListener onConfigureAvailableListener, OnOpenAvailableListener onOpenAvailableListener) {
            this.mState = state;
            this.mNotifyExecutor = executor;
            this.mOnConfigureAvailableListener = onConfigureAvailableListener;
            this.mOnOpenAvailableListener = onOpenAvailableListener;
        }

        public CameraInternal.State getState() {
            return this.mState;
        }

        public void notifyOnConfigureAvailableListener() {
            try {
                Executor executor = this.mNotifyExecutor;
                OnConfigureAvailableListener onConfigureAvailableListener = this.mOnConfigureAvailableListener;
                Objects.requireNonNull(onConfigureAvailableListener);
                executor.execute(new m(onConfigureAvailableListener));
            } catch (RejectedExecutionException e11) {
                Logger.e(CameraStateRegistry.TAG, "Unable to notify camera to configure.", e11);
            }
        }

        public void notifyOnOpenAvailableListener() {
            try {
                Executor executor = this.mNotifyExecutor;
                OnOpenAvailableListener onOpenAvailableListener = this.mOnOpenAvailableListener;
                Objects.requireNonNull(onOpenAvailableListener);
                executor.execute(new n(onOpenAvailableListener));
            } catch (RejectedExecutionException e11) {
                Logger.e(CameraStateRegistry.TAG, "Unable to notify camera to open.", e11);
            }
        }

        public CameraInternal.State setState(CameraInternal.State state) {
            CameraInternal.State state2 = this.mState;
            this.mState = state;
            return state2;
        }
    }

    public interface OnConfigureAvailableListener {
        void onConfigureAvailable();
    }

    public interface OnOpenAvailableListener {
        void onOpenAvailable();
    }

    public CameraStateRegistry(CameraCoordinator cameraCoordinator, int i11) {
        Object obj = new Object();
        this.mLock = obj;
        this.mCameraStates = new HashMap();
        this.mMaxAllowedOpenedCameras = i11;
        synchronized (obj) {
            this.mCameraCoordinator = cameraCoordinator;
            this.mAvailableCameras = this.mMaxAllowedOpenedCameras;
        }
    }

    private CameraRegistration getCameraRegistration(String str) {
        for (Camera next : this.mCameraStates.keySet()) {
            if (str.equals(((CameraInfoInternal) next.getCameraInfo()).getCameraId())) {
                return this.mCameraStates.get(next);
            }
        }
        return null;
    }

    private static boolean isOpen(CameraInternal.State state) {
        return state != null && state.holdsCameraSlot();
    }

    private void recalculateAvailableCameras() {
        if (Logger.isDebugEnabled(TAG)) {
            this.mDebugString.setLength(0);
            this.mDebugString.append("Recalculating open cameras:\n");
            this.mDebugString.append(String.format(Locale.US, "%-45s%-22s\n", new Object[]{PictureMimeType.CAMERA, "State"}));
            this.mDebugString.append("-------------------------------------------------------------------\n");
        }
        int i11 = 0;
        for (Map.Entry next : this.mCameraStates.entrySet()) {
            if (Logger.isDebugEnabled(TAG)) {
                this.mDebugString.append(String.format(Locale.US, "%-45s%-22s\n", new Object[]{((Camera) next.getKey()).toString(), ((CameraRegistration) next.getValue()).getState() != null ? ((CameraRegistration) next.getValue()).getState().toString() : GrsBaseInfo.CountryCodeSource.UNKNOWN}));
            }
            if (isOpen(((CameraRegistration) next.getValue()).getState())) {
                i11++;
            }
        }
        if (Logger.isDebugEnabled(TAG)) {
            this.mDebugString.append("-------------------------------------------------------------------\n");
            this.mDebugString.append(String.format(Locale.US, "Open count: %d (Max allowed: %d)", new Object[]{Integer.valueOf(i11), Integer.valueOf(this.mMaxAllowedOpenedCameras)}));
            Logger.d(TAG, this.mDebugString.toString());
        }
        this.mAvailableCameras = Math.max(this.mMaxAllowedOpenedCameras - i11, 0);
    }

    private CameraInternal.State unregisterCamera(Camera camera) {
        CameraRegistration remove = this.mCameraStates.remove(camera);
        if (remove == null) {
            return null;
        }
        recalculateAvailableCameras();
        return remove.getState();
    }

    private CameraInternal.State updateAndVerifyState(Camera camera, CameraInternal.State state) {
        CameraInternal.State state2 = ((CameraRegistration) h.h(this.mCameraStates.get(camera), "Cannot update state of camera which has not yet been registered. Register with CameraStateRegistry.registerCamera()")).setState(state);
        CameraInternal.State state3 = CameraInternal.State.OPENING;
        if (state == state3) {
            h.j(isOpen(state) || state2 == state3, "Cannot mark camera as opening until camera was successful at calling CameraStateRegistry.tryOpenCamera()");
        }
        if (state2 != state) {
            recalculateAvailableCameras();
        }
        return state2;
    }

    public boolean isCameraClosing() {
        synchronized (this.mLock) {
            for (Map.Entry<Camera, CameraRegistration> value : this.mCameraStates.entrySet()) {
                if (((CameraRegistration) value.getValue()).getState() == CameraInternal.State.CLOSING) {
                    return true;
                }
            }
            return false;
        }
    }

    public void markCameraState(Camera camera, CameraInternal.State state) {
        markCameraState(camera, state, true);
    }

    public void onCameraOperatingModeUpdated(int i11, int i12) {
        synchronized (this.mLock) {
            boolean z11 = true;
            this.mMaxAllowedOpenedCameras = i12 == 2 ? 2 : 1;
            boolean z12 = i11 != 2 && i12 == 2;
            if (i11 != 2 || i12 == 2) {
                z11 = false;
            }
            if (z12 || z11) {
                recalculateAvailableCameras();
            }
        }
    }

    public void registerCamera(Camera camera, Executor executor, OnConfigureAvailableListener onConfigureAvailableListener, OnOpenAvailableListener onOpenAvailableListener) {
        synchronized (this.mLock) {
            boolean z11 = !this.mCameraStates.containsKey(camera);
            h.j(z11, "Camera is already registered: " + camera);
            this.mCameraStates.put(camera, new CameraRegistration((CameraInternal.State) null, executor, onConfigureAvailableListener, onOpenAvailableListener));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0096  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean tryOpenCamera(androidx.camera.core.Camera r10) {
        /*
            r9 = this;
            java.lang.Object r0 = r9.mLock
            monitor-enter(r0)
            java.util.Map<androidx.camera.core.Camera, androidx.camera.core.impl.CameraStateRegistry$CameraRegistration> r1 = r9.mCameraStates     // Catch:{ all -> 0x009b }
            java.lang.Object r1 = r1.get(r10)     // Catch:{ all -> 0x009b }
            androidx.camera.core.impl.CameraStateRegistry$CameraRegistration r1 = (androidx.camera.core.impl.CameraStateRegistry.CameraRegistration) r1     // Catch:{ all -> 0x009b }
            java.lang.String r2 = "Camera must first be registered with registerCamera()"
            java.lang.Object r1 = androidx.core.util.h.h(r1, r2)     // Catch:{ all -> 0x009b }
            androidx.camera.core.impl.CameraStateRegistry$CameraRegistration r1 = (androidx.camera.core.impl.CameraStateRegistry.CameraRegistration) r1     // Catch:{ all -> 0x009b }
            java.lang.String r2 = "CameraStateRegistry"
            boolean r2 = androidx.camera.core.Logger.isDebugEnabled(r2)     // Catch:{ all -> 0x009b }
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0052
            java.lang.StringBuilder r2 = r9.mDebugString     // Catch:{ all -> 0x009b }
            r2.setLength(r4)     // Catch:{ all -> 0x009b }
            java.lang.StringBuilder r2 = r9.mDebugString     // Catch:{ all -> 0x009b }
            java.util.Locale r5 = java.util.Locale.US     // Catch:{ all -> 0x009b }
            java.lang.String r6 = "tryOpenCamera(%s) [Available Cameras: %d, Already Open: %b (Previous state: %s)]"
            r7 = 4
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ all -> 0x009b }
            r7[r4] = r10     // Catch:{ all -> 0x009b }
            int r10 = r9.mAvailableCameras     // Catch:{ all -> 0x009b }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x009b }
            r7[r3] = r10     // Catch:{ all -> 0x009b }
            r10 = 2
            androidx.camera.core.impl.CameraInternal$State r8 = r1.getState()     // Catch:{ all -> 0x009b }
            boolean r8 = isOpen(r8)     // Catch:{ all -> 0x009b }
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)     // Catch:{ all -> 0x009b }
            r7[r10] = r8     // Catch:{ all -> 0x009b }
            r10 = 3
            androidx.camera.core.impl.CameraInternal$State r8 = r1.getState()     // Catch:{ all -> 0x009b }
            r7[r10] = r8     // Catch:{ all -> 0x009b }
            java.lang.String r10 = java.lang.String.format(r5, r6, r7)     // Catch:{ all -> 0x009b }
            r2.append(r10)     // Catch:{ all -> 0x009b }
        L_0x0052:
            int r10 = r9.mAvailableCameras     // Catch:{ all -> 0x009b }
            if (r10 > 0) goto L_0x0063
            androidx.camera.core.impl.CameraInternal$State r10 = r1.getState()     // Catch:{ all -> 0x009b }
            boolean r10 = isOpen(r10)     // Catch:{ all -> 0x009b }
            if (r10 == 0) goto L_0x0061
            goto L_0x0063
        L_0x0061:
            r10 = r4
            goto L_0x0069
        L_0x0063:
            androidx.camera.core.impl.CameraInternal$State r10 = androidx.camera.core.impl.CameraInternal.State.OPENING     // Catch:{ all -> 0x009b }
            r1.setState(r10)     // Catch:{ all -> 0x009b }
            r10 = r3
        L_0x0069:
            java.lang.String r1 = "CameraStateRegistry"
            boolean r1 = androidx.camera.core.Logger.isDebugEnabled(r1)     // Catch:{ all -> 0x009b }
            if (r1 == 0) goto L_0x0094
            java.lang.StringBuilder r1 = r9.mDebugString     // Catch:{ all -> 0x009b }
            java.util.Locale r2 = java.util.Locale.US     // Catch:{ all -> 0x009b }
            java.lang.String r5 = " --> %s"
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x009b }
            if (r10 == 0) goto L_0x007e
            java.lang.String r6 = "SUCCESS"
            goto L_0x0080
        L_0x007e:
            java.lang.String r6 = "FAIL"
        L_0x0080:
            r3[r4] = r6     // Catch:{ all -> 0x009b }
            java.lang.String r2 = java.lang.String.format(r2, r5, r3)     // Catch:{ all -> 0x009b }
            r1.append(r2)     // Catch:{ all -> 0x009b }
            java.lang.String r1 = "CameraStateRegistry"
            java.lang.StringBuilder r2 = r9.mDebugString     // Catch:{ all -> 0x009b }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x009b }
            androidx.camera.core.Logger.d(r1, r2)     // Catch:{ all -> 0x009b }
        L_0x0094:
            if (r10 == 0) goto L_0x0099
            r9.recalculateAvailableCameras()     // Catch:{ all -> 0x009b }
        L_0x0099:
            monitor-exit(r0)     // Catch:{ all -> 0x009b }
            return r10
        L_0x009b:
            r10 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x009b }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.CameraStateRegistry.tryOpenCamera(androidx.camera.core.Camera):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x005e, code lost:
        return r3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0059 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean tryOpenCaptureSession(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.mLock
            monitor-enter(r0)
            androidx.camera.core.concurrent.CameraCoordinator r1 = r5.mCameraCoordinator     // Catch:{ all -> 0x005f }
            int r1 = r1.getCameraOperatingMode()     // Catch:{ all -> 0x005f }
            r2 = 2
            r3 = 1
            if (r1 == r2) goto L_0x000f
            monitor-exit(r0)     // Catch:{ all -> 0x005f }
            return r3
        L_0x000f:
            androidx.camera.core.impl.CameraStateRegistry$CameraRegistration r1 = r5.getCameraRegistration(r6)     // Catch:{ all -> 0x005f }
            r2 = 0
            if (r1 == 0) goto L_0x001f
            androidx.camera.core.impl.CameraStateRegistry$CameraRegistration r6 = r5.getCameraRegistration(r6)     // Catch:{ all -> 0x005f }
            androidx.camera.core.impl.CameraInternal$State r6 = r6.getState()     // Catch:{ all -> 0x005f }
            goto L_0x0020
        L_0x001f:
            r6 = r2
        L_0x0020:
            if (r7 == 0) goto L_0x0030
            androidx.camera.core.impl.CameraStateRegistry$CameraRegistration r1 = r5.getCameraRegistration(r7)     // Catch:{ all -> 0x005f }
            if (r1 == 0) goto L_0x0030
            androidx.camera.core.impl.CameraStateRegistry$CameraRegistration r7 = r5.getCameraRegistration(r7)     // Catch:{ all -> 0x005f }
            androidx.camera.core.impl.CameraInternal$State r2 = r7.getState()     // Catch:{ all -> 0x005f }
        L_0x0030:
            androidx.camera.core.impl.CameraInternal$State r7 = androidx.camera.core.impl.CameraInternal.State.OPEN     // Catch:{ all -> 0x005f }
            boolean r1 = r7.equals(r6)     // Catch:{ all -> 0x005f }
            r4 = 0
            if (r1 != 0) goto L_0x0044
            androidx.camera.core.impl.CameraInternal$State r1 = androidx.camera.core.impl.CameraInternal.State.CONFIGURED     // Catch:{ all -> 0x005f }
            boolean r6 = r1.equals(r6)     // Catch:{ all -> 0x005f }
            if (r6 == 0) goto L_0x0042
            goto L_0x0044
        L_0x0042:
            r6 = r4
            goto L_0x0045
        L_0x0044:
            r6 = r3
        L_0x0045:
            boolean r7 = r7.equals(r2)     // Catch:{ all -> 0x005f }
            if (r7 != 0) goto L_0x0056
            androidx.camera.core.impl.CameraInternal$State r7 = androidx.camera.core.impl.CameraInternal.State.CONFIGURED     // Catch:{ all -> 0x005f }
            boolean r7 = r7.equals(r2)     // Catch:{ all -> 0x005f }
            if (r7 == 0) goto L_0x0054
            goto L_0x0056
        L_0x0054:
            r7 = r4
            goto L_0x0057
        L_0x0056:
            r7 = r3
        L_0x0057:
            if (r6 == 0) goto L_0x005c
            if (r7 == 0) goto L_0x005c
            goto L_0x005d
        L_0x005c:
            r3 = r4
        L_0x005d:
            monitor-exit(r0)     // Catch:{ all -> 0x005f }
            return r3
        L_0x005f:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x005f }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.CameraStateRegistry.tryOpenCaptureSession(java.lang.String, java.lang.String):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0024, code lost:
        r2 = r6.mCameraCoordinator.getPairedConcurrentCameraId(((androidx.camera.core.impl.CameraInfoInternal) r7.getCameraInfo()).getCameraId());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x009c, code lost:
        if (r4 == null) goto L_0x00b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x009e, code lost:
        r7 = r4.values().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00aa, code lost:
        if (r7.hasNext() == false) goto L_0x00b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ac, code lost:
        ((androidx.camera.core.impl.CameraStateRegistry.CameraRegistration) r7.next()).notifyOnOpenAvailableListener();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00b6, code lost:
        if (r2 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00b8, code lost:
        r2.notifyOnConfigureAvailableListener();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void markCameraState(androidx.camera.core.Camera r7, androidx.camera.core.impl.CameraInternal.State r8, boolean r9) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.mLock
            monitor-enter(r0)
            int r1 = r6.mAvailableCameras     // Catch:{ all -> 0x00bc }
            androidx.camera.core.impl.CameraInternal$State r2 = androidx.camera.core.impl.CameraInternal.State.RELEASED     // Catch:{ all -> 0x00bc }
            if (r8 != r2) goto L_0x000e
            androidx.camera.core.impl.CameraInternal$State r2 = r6.unregisterCamera(r7)     // Catch:{ all -> 0x00bc }
            goto L_0x0012
        L_0x000e:
            androidx.camera.core.impl.CameraInternal$State r2 = r6.updateAndVerifyState(r7, r8)     // Catch:{ all -> 0x00bc }
        L_0x0012:
            if (r2 != r8) goto L_0x0016
            monitor-exit(r0)     // Catch:{ all -> 0x00bc }
            return
        L_0x0016:
            androidx.camera.core.concurrent.CameraCoordinator r2 = r6.mCameraCoordinator     // Catch:{ all -> 0x00bc }
            int r2 = r2.getCameraOperatingMode()     // Catch:{ all -> 0x00bc }
            r3 = 2
            r4 = 0
            if (r2 != r3) goto L_0x003b
            androidx.camera.core.impl.CameraInternal$State r2 = androidx.camera.core.impl.CameraInternal.State.CONFIGURED     // Catch:{ all -> 0x00bc }
            if (r8 != r2) goto L_0x003b
            androidx.camera.core.CameraInfo r2 = r7.getCameraInfo()     // Catch:{ all -> 0x00bc }
            androidx.camera.core.impl.CameraInfoInternal r2 = (androidx.camera.core.impl.CameraInfoInternal) r2     // Catch:{ all -> 0x00bc }
            java.lang.String r2 = r2.getCameraId()     // Catch:{ all -> 0x00bc }
            androidx.camera.core.concurrent.CameraCoordinator r3 = r6.mCameraCoordinator     // Catch:{ all -> 0x00bc }
            java.lang.String r2 = r3.getPairedConcurrentCameraId(r2)     // Catch:{ all -> 0x00bc }
            if (r2 == 0) goto L_0x003b
            androidx.camera.core.impl.CameraStateRegistry$CameraRegistration r2 = r6.getCameraRegistration(r2)     // Catch:{ all -> 0x00bc }
            goto L_0x003c
        L_0x003b:
            r2 = r4
        L_0x003c:
            r3 = 1
            if (r1 >= r3) goto L_0x007c
            int r1 = r6.mAvailableCameras     // Catch:{ all -> 0x00bc }
            if (r1 <= 0) goto L_0x007c
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ all -> 0x00bc }
            r4.<init>()     // Catch:{ all -> 0x00bc }
            java.util.Map<androidx.camera.core.Camera, androidx.camera.core.impl.CameraStateRegistry$CameraRegistration> r8 = r6.mCameraStates     // Catch:{ all -> 0x00bc }
            java.util.Set r8 = r8.entrySet()     // Catch:{ all -> 0x00bc }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x00bc }
        L_0x0052:
            boolean r1 = r8.hasNext()     // Catch:{ all -> 0x00bc }
            if (r1 == 0) goto L_0x0094
            java.lang.Object r1 = r8.next()     // Catch:{ all -> 0x00bc }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ all -> 0x00bc }
            java.lang.Object r3 = r1.getValue()     // Catch:{ all -> 0x00bc }
            androidx.camera.core.impl.CameraStateRegistry$CameraRegistration r3 = (androidx.camera.core.impl.CameraStateRegistry.CameraRegistration) r3     // Catch:{ all -> 0x00bc }
            androidx.camera.core.impl.CameraInternal$State r3 = r3.getState()     // Catch:{ all -> 0x00bc }
            androidx.camera.core.impl.CameraInternal$State r5 = androidx.camera.core.impl.CameraInternal.State.PENDING_OPEN     // Catch:{ all -> 0x00bc }
            if (r3 != r5) goto L_0x0052
            java.lang.Object r3 = r1.getKey()     // Catch:{ all -> 0x00bc }
            androidx.camera.core.Camera r3 = (androidx.camera.core.Camera) r3     // Catch:{ all -> 0x00bc }
            java.lang.Object r1 = r1.getValue()     // Catch:{ all -> 0x00bc }
            androidx.camera.core.impl.CameraStateRegistry$CameraRegistration r1 = (androidx.camera.core.impl.CameraStateRegistry.CameraRegistration) r1     // Catch:{ all -> 0x00bc }
            r4.put(r3, r1)     // Catch:{ all -> 0x00bc }
            goto L_0x0052
        L_0x007c:
            androidx.camera.core.impl.CameraInternal$State r1 = androidx.camera.core.impl.CameraInternal.State.PENDING_OPEN     // Catch:{ all -> 0x00bc }
            if (r8 != r1) goto L_0x0094
            int r8 = r6.mAvailableCameras     // Catch:{ all -> 0x00bc }
            if (r8 <= 0) goto L_0x0094
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ all -> 0x00bc }
            r4.<init>()     // Catch:{ all -> 0x00bc }
            java.util.Map<androidx.camera.core.Camera, androidx.camera.core.impl.CameraStateRegistry$CameraRegistration> r8 = r6.mCameraStates     // Catch:{ all -> 0x00bc }
            java.lang.Object r8 = r8.get(r7)     // Catch:{ all -> 0x00bc }
            androidx.camera.core.impl.CameraStateRegistry$CameraRegistration r8 = (androidx.camera.core.impl.CameraStateRegistry.CameraRegistration) r8     // Catch:{ all -> 0x00bc }
            r4.put(r7, r8)     // Catch:{ all -> 0x00bc }
        L_0x0094:
            if (r4 == 0) goto L_0x009b
            if (r9 != 0) goto L_0x009b
            r4.remove(r7)     // Catch:{ all -> 0x00bc }
        L_0x009b:
            monitor-exit(r0)     // Catch:{ all -> 0x00bc }
            if (r4 == 0) goto L_0x00b6
            java.util.Collection r7 = r4.values()
            java.util.Iterator r7 = r7.iterator()
        L_0x00a6:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x00b6
            java.lang.Object r8 = r7.next()
            androidx.camera.core.impl.CameraStateRegistry$CameraRegistration r8 = (androidx.camera.core.impl.CameraStateRegistry.CameraRegistration) r8
            r8.notifyOnOpenAvailableListener()
            goto L_0x00a6
        L_0x00b6:
            if (r2 == 0) goto L_0x00bb
            r2.notifyOnConfigureAvailableListener()
        L_0x00bb:
            return
        L_0x00bc:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00bc }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.CameraStateRegistry.markCameraState(androidx.camera.core.Camera, androidx.camera.core.impl.CameraInternal$State, boolean):void");
    }
}
