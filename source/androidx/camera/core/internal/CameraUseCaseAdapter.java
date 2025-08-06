package androidx.camera.core.internal;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.util.Pair;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraEffect;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Logger;
import androidx.camera.core.Preview;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.UseCase;
import androidx.camera.core.ViewPort;
import androidx.camera.core.concurrent.CameraCoordinator;
import androidx.camera.core.impl.AttachedSurfaceInfo;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraConfigs;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.RestrictedCameraControl;
import androidx.camera.core.impl.RestrictedCameraInfo;
import androidx.camera.core.impl.SessionProcessor;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.streamsharing.StreamSharing;
import androidx.core.util.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public final class CameraUseCaseAdapter implements Camera {
    private static final String TAG = "CameraUseCaseAdapter";
    private final List<UseCase> mAppUseCases = new ArrayList();
    private boolean mAttached = true;
    private CameraConfig mCameraConfig = CameraConfigs.emptyConfig();
    private final CameraCoordinator mCameraCoordinator;
    private final CameraDeviceSurfaceManager mCameraDeviceSurfaceManager;
    private final CameraInternal mCameraInternal;
    private final LinkedHashSet<CameraInternal> mCameraInternals;
    private final List<UseCase> mCameraUseCases = new ArrayList();
    private List<CameraEffect> mEffects = Collections.emptyList();
    private final CameraId mId;
    private Config mInteropConfig = null;
    private final Object mLock = new Object();
    private UseCase mPlaceholderForExtensions;
    private final RestrictedCameraControl mRestrictedCameraControl;
    private final RestrictedCameraInfo mRestrictedCameraInfo;
    private StreamSharing mStreamSharing;
    private final UseCaseConfigFactory mUseCaseConfigFactory;
    private ViewPort mViewPort;

    public static final class CameraException extends Exception {
        public CameraException() {
        }

        public CameraException(String str) {
            super(str);
        }

        public CameraException(Throwable th2) {
            super(th2);
        }
    }

    public static final class CameraId {
        private final List<String> mIds = new ArrayList();

        public CameraId(LinkedHashSet<CameraInternal> linkedHashSet) {
            Iterator it2 = linkedHashSet.iterator();
            while (it2.hasNext()) {
                this.mIds.add(((CameraInternal) it2.next()).getCameraInfoInternal().getCameraId());
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof CameraId) {
                return this.mIds.equals(((CameraId) obj).mIds);
            }
            return false;
        }

        public int hashCode() {
            return this.mIds.hashCode() * 53;
        }
    }

    public static class ConfigPair {
        public UseCaseConfig<?> mCameraConfig;
        public UseCaseConfig<?> mExtendedConfig;

        public ConfigPair(UseCaseConfig<?> useCaseConfig, UseCaseConfig<?> useCaseConfig2) {
            this.mExtendedConfig = useCaseConfig;
            this.mCameraConfig = useCaseConfig2;
        }
    }

    public CameraUseCaseAdapter(LinkedHashSet<CameraInternal> linkedHashSet, CameraCoordinator cameraCoordinator, CameraDeviceSurfaceManager cameraDeviceSurfaceManager, UseCaseConfigFactory useCaseConfigFactory) {
        CameraInternal cameraInternal = (CameraInternal) linkedHashSet.iterator().next();
        this.mCameraInternal = cameraInternal;
        LinkedHashSet<CameraInternal> linkedHashSet2 = new LinkedHashSet<>(linkedHashSet);
        this.mCameraInternals = linkedHashSet2;
        this.mId = new CameraId(linkedHashSet2);
        this.mCameraCoordinator = cameraCoordinator;
        this.mCameraDeviceSurfaceManager = cameraDeviceSurfaceManager;
        this.mUseCaseConfigFactory = useCaseConfigFactory;
        RestrictedCameraControl restrictedCameraControl = new RestrictedCameraControl(cameraInternal.getCameraControlInternal());
        this.mRestrictedCameraControl = restrictedCameraControl;
        this.mRestrictedCameraInfo = new RestrictedCameraInfo(cameraInternal.getCameraInfoInternal(), restrictedCameraControl);
    }

    private void cacheInteropConfig() {
        synchronized (this.mLock) {
            CameraControlInternal cameraControlInternal = this.mCameraInternal.getCameraControlInternal();
            this.mInteropConfig = cameraControlInternal.getInteropConfig();
            cameraControlInternal.clearInteropConfig();
        }
    }

    public static Collection<UseCase> calculateCameraUseCases(Collection<UseCase> collection, UseCase useCase, StreamSharing streamSharing) {
        ArrayList arrayList = new ArrayList(collection);
        if (useCase != null) {
            arrayList.add(useCase);
        }
        if (streamSharing != null) {
            arrayList.add(streamSharing);
            arrayList.removeAll(streamSharing.getChildren());
        }
        return arrayList;
    }

    private static Matrix calculateSensorToBufferTransformMatrix(Rect rect, Size size) {
        h.b(rect.width() > 0 && rect.height() > 0, "Cannot compute viewport crop rects zero sized sensor rect.");
        RectF rectF = new RectF(rect);
        Matrix matrix = new Matrix();
        matrix.setRectToRect(new RectF(0.0f, 0.0f, (float) size.getWidth(), (float) size.getHeight()), rectF, Matrix.ScaleToFit.CENTER);
        matrix.invert(matrix);
        return matrix;
    }

    private Map<UseCase, StreamSpec> calculateSuggestedStreamSpecs(int i11, CameraInfoInternal cameraInfoInternal, Collection<UseCase> collection, Collection<UseCase> collection2, Map<UseCase, ConfigPair> map) {
        Size size;
        Rect rect;
        int i12 = i11;
        CameraInfoInternal cameraInfoInternal2 = cameraInfoInternal;
        ArrayList arrayList = new ArrayList();
        String cameraId = cameraInfoInternal.getCameraId();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        Iterator<UseCase> it2 = collection2.iterator();
        while (true) {
            size = null;
            if (!it2.hasNext()) {
                break;
            }
            UseCase next = it2.next();
            AttachedSurfaceInfo create = AttachedSurfaceInfo.create(this.mCameraDeviceSurfaceManager.transformSurfaceConfig(i12, cameraId, next.getImageFormat(), next.getAttachedSurfaceResolution()), next.getImageFormat(), next.getAttachedSurfaceResolution(), ((StreamSpec) h.g(next.getAttachedStreamSpec())).getDynamicRange(), getCaptureTypes(next), next.getAttachedStreamSpec().getImplementationOptions(), next.getCurrentConfig().getTargetFrameRate((Range<Integer>) null));
            arrayList.add(create);
            hashMap2.put(create, next);
            hashMap.put(next, next.getAttachedStreamSpec());
        }
        if (!collection.isEmpty()) {
            HashMap hashMap3 = new HashMap();
            HashMap hashMap4 = new HashMap();
            try {
                rect = this.mCameraInternal.getCameraControlInternal().getSensorRect();
            } catch (NullPointerException unused) {
                rect = null;
            }
            if (rect != null) {
                size = TransformUtils.rectToSize(rect);
            }
            SupportedOutputSizesSorter supportedOutputSizesSorter = new SupportedOutputSizesSorter(cameraInfoInternal2, size);
            for (UseCase next2 : collection) {
                ConfigPair configPair = map.get(next2);
                UseCaseConfig<?> mergeConfigs = next2.mergeConfigs(cameraInfoInternal2, configPair.mExtendedConfig, configPair.mCameraConfig);
                hashMap3.put(mergeConfigs, next2);
                hashMap4.put(mergeConfigs, supportedOutputSizesSorter.getSortedSupportedOutputSizes(mergeConfigs));
            }
            Pair<Map<UseCaseConfig<?>, StreamSpec>, Map<AttachedSurfaceInfo, StreamSpec>> suggestedStreamSpecs = this.mCameraDeviceSurfaceManager.getSuggestedStreamSpecs(i12, cameraId, arrayList, hashMap4);
            for (Map.Entry entry : hashMap3.entrySet()) {
                hashMap.put((UseCase) entry.getValue(), (StreamSpec) ((Map) suggestedStreamSpecs.first).get(entry.getKey()));
            }
            for (Map.Entry entry2 : ((Map) suggestedStreamSpecs.second).entrySet()) {
                if (hashMap2.containsKey(entry2.getKey())) {
                    hashMap.put((UseCase) hashMap2.get(entry2.getKey()), (StreamSpec) entry2.getValue());
                }
            }
        }
        return hashMap;
    }

    private ImageCapture createExtraImageCapture() {
        return new ImageCapture.Builder().setTargetName("ImageCapture-Extra").build();
    }

    private Preview createExtraPreview() {
        Preview build = new Preview.Builder().setTargetName("Preview-Extra").build();
        build.setSurfaceProvider(a.f5599a);
        return build;
    }

    private StreamSharing createOrReuseStreamSharing(Collection<UseCase> collection, boolean z11) {
        synchronized (this.mLock) {
            Set<UseCase> streamSharingChildren = getStreamSharingChildren(collection, z11);
            if (streamSharingChildren.size() < 2) {
                return null;
            }
            StreamSharing streamSharing = this.mStreamSharing;
            if (streamSharing != null && streamSharing.getChildren().equals(streamSharingChildren)) {
                StreamSharing streamSharing2 = this.mStreamSharing;
                Objects.requireNonNull(streamSharing2);
                return streamSharing2;
            } else if (!isStreamSharingChildrenCombinationValid(streamSharingChildren)) {
                return null;
            } else {
                StreamSharing streamSharing3 = new StreamSharing(this.mCameraInternal, streamSharingChildren, this.mUseCaseConfigFactory);
                return streamSharing3;
            }
        }
    }

    public static CameraId generateCameraId(LinkedHashSet<CameraInternal> linkedHashSet) {
        return new CameraId(linkedHashSet);
    }

    private int getCameraMode() {
        synchronized (this.mLock) {
            if (this.mCameraCoordinator.getCameraOperatingMode() == 2) {
                return 1;
            }
            return 0;
        }
    }

    private static List<UseCaseConfigFactory.CaptureType> getCaptureTypes(UseCase useCase) {
        ArrayList arrayList = new ArrayList();
        if (isStreamSharing(useCase)) {
            for (UseCase currentConfig : ((StreamSharing) useCase).getChildren()) {
                arrayList.add(currentConfig.getCurrentConfig().getCaptureType());
            }
        } else {
            arrayList.add(useCase.getCurrentConfig().getCaptureType());
        }
        return arrayList;
    }

    private Map<UseCase, ConfigPair> getConfigs(Collection<UseCase> collection, UseCaseConfigFactory useCaseConfigFactory, UseCaseConfigFactory useCaseConfigFactory2) {
        HashMap hashMap = new HashMap();
        for (UseCase next : collection) {
            hashMap.put(next, new ConfigPair(next.getDefaultConfig(false, useCaseConfigFactory), next.getDefaultConfig(true, useCaseConfigFactory2)));
        }
        return hashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: boolean} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int getSharingTargets(boolean r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.mLock
            monitor-enter(r0)
            r1 = 0
            java.util.List<androidx.camera.core.CameraEffect> r2 = r7.mEffects     // Catch:{ all -> 0x0039 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0039 }
        L_0x000a:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0039 }
            r4 = 0
            if (r3 == 0) goto L_0x002c
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0039 }
            androidx.camera.core.CameraEffect r3 = (androidx.camera.core.CameraEffect) r3     // Catch:{ all -> 0x0039 }
            int r5 = r3.getTargets()     // Catch:{ all -> 0x0039 }
            int r5 = androidx.camera.core.processing.TargetUtils.getNumberOfTargets(r5)     // Catch:{ all -> 0x0039 }
            r6 = 1
            if (r5 <= r6) goto L_0x000a
            if (r1 != 0) goto L_0x0025
            r4 = r6
        L_0x0025:
            java.lang.String r1 = "Can only have one sharing effect."
            androidx.core.util.h.j(r4, r1)     // Catch:{ all -> 0x0039 }
            r1 = r3
            goto L_0x000a
        L_0x002c:
            if (r1 != 0) goto L_0x002f
            goto L_0x0033
        L_0x002f:
            int r4 = r1.getTargets()     // Catch:{ all -> 0x0039 }
        L_0x0033:
            if (r8 == 0) goto L_0x0037
            r4 = r4 | 3
        L_0x0037:
            monitor-exit(r0)     // Catch:{ all -> 0x0039 }
            return r4
        L_0x0039:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0039 }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.internal.CameraUseCaseAdapter.getSharingTargets(boolean):int");
    }

    private Set<UseCase> getStreamSharingChildren(Collection<UseCase> collection, boolean z11) {
        HashSet hashSet = new HashSet();
        int sharingTargets = getSharingTargets(z11);
        for (UseCase next : collection) {
            h.b(!isStreamSharing(next), "Only support one level of sharing for now.");
            if (next.isEffectTargetsSupported(sharingTargets)) {
                hashSet.add(next);
            }
        }
        return hashSet;
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean hasImplementationOptionChanged(androidx.camera.core.impl.StreamSpec r4, androidx.camera.core.impl.SessionConfig r5) {
        /*
            androidx.camera.core.impl.Config r4 = r4.getImplementationOptions()
            androidx.camera.core.impl.Config r0 = r5.getImplementationOptions()
            java.util.Set r1 = r4.listOptions()
            int r1 = r1.size()
            androidx.camera.core.impl.Config r5 = r5.getImplementationOptions()
            java.util.Set r5 = r5.listOptions()
            int r5 = r5.size()
            r2 = 1
            if (r1 == r5) goto L_0x0020
            return r2
        L_0x0020:
            java.util.Set r5 = r4.listOptions()
            java.util.Iterator r5 = r5.iterator()
        L_0x0028:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L_0x0049
            java.lang.Object r1 = r5.next()
            androidx.camera.core.impl.Config$Option r1 = (androidx.camera.core.impl.Config.Option) r1
            boolean r3 = r0.containsOption(r1)
            if (r3 == 0) goto L_0x0048
            java.lang.Object r3 = r0.retrieveOption(r1)
            java.lang.Object r1 = r4.retrieveOption(r1)
            boolean r1 = java.util.Objects.equals(r3, r1)
            if (r1 != 0) goto L_0x0028
        L_0x0048:
            return r2
        L_0x0049:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.internal.CameraUseCaseAdapter.hasImplementationOptionChanged(androidx.camera.core.impl.StreamSpec, androidx.camera.core.impl.SessionConfig):boolean");
    }

    private boolean hasNoExtension() {
        boolean z11;
        synchronized (this.mLock) {
            z11 = this.mCameraConfig == CameraConfigs.emptyConfig();
        }
        return z11;
    }

    private boolean isCoexistingPreviewImageCaptureRequired() {
        boolean z11;
        synchronized (this.mLock) {
            z11 = true;
            if (this.mCameraConfig.getUseCaseCombinationRequiredRule() != 1) {
                z11 = false;
            }
        }
        return z11;
    }

    private boolean isExtraImageCaptureRequired(Collection<UseCase> collection) {
        boolean z11 = false;
        boolean z12 = false;
        for (UseCase next : collection) {
            if (isPreview(next)) {
                z11 = true;
            } else if (isImageCapture(next)) {
                z12 = true;
            }
        }
        if (!z11 || z12) {
            return false;
        }
        return true;
    }

    private boolean isExtraPreviewRequired(Collection<UseCase> collection) {
        boolean z11 = false;
        boolean z12 = false;
        for (UseCase next : collection) {
            if (isPreview(next)) {
                z12 = true;
            } else if (isImageCapture(next)) {
                z11 = true;
            }
        }
        if (!z11 || z12) {
            return false;
        }
        return true;
    }

    private static boolean isImageCapture(UseCase useCase) {
        return useCase instanceof ImageCapture;
    }

    private static boolean isPreview(UseCase useCase) {
        return useCase instanceof Preview;
    }

    private static boolean isStreamSharing(UseCase useCase) {
        return useCase instanceof StreamSharing;
    }

    public static boolean isStreamSharingChildrenCombinationValid(Collection<UseCase> collection) {
        int[] iArr = {1, 2, 4};
        HashSet hashSet = new HashSet();
        for (UseCase next : collection) {
            int i11 = 0;
            while (true) {
                if (i11 < 3) {
                    int i12 = iArr[i11];
                    if (next.isEffectTargetsSupported(i12)) {
                        if (hashSet.contains(Integer.valueOf(i12))) {
                            return false;
                        }
                        hashSet.add(Integer.valueOf(i12));
                    }
                    i11++;
                }
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$createExtraPreview$0(Surface surface, SurfaceTexture surfaceTexture, SurfaceRequest.Result result) {
        surface.release();
        surfaceTexture.release();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$createExtraPreview$1(SurfaceRequest surfaceRequest) {
        SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        surfaceTexture.setDefaultBufferSize(surfaceRequest.getResolution().getWidth(), surfaceRequest.getResolution().getHeight());
        surfaceTexture.detachFromGLContext();
        Surface surface = new Surface(surfaceTexture);
        surfaceRequest.provideSurface(surface, CameraXExecutors.directExecutor(), new b(surface, surfaceTexture));
    }

    private void restoreInteropConfig() {
        synchronized (this.mLock) {
            if (this.mInteropConfig != null) {
                this.mCameraInternal.getCameraControlInternal().addInteropConfig(this.mInteropConfig);
            }
        }
    }

    private static List<CameraEffect> setEffectsOnUseCases(List<CameraEffect> list, Collection<UseCase> collection) {
        ArrayList arrayList = new ArrayList(list);
        for (UseCase next : collection) {
            next.setEffect((CameraEffect) null);
            for (CameraEffect next2 : list) {
                if (next.isEffectTargetsSupported(next2.getTargets())) {
                    boolean z11 = next.getEffect() == null;
                    h.j(z11, next + " already has effect" + next.getEffect());
                    next.setEffect(next2);
                    arrayList.remove(next2);
                }
            }
        }
        return arrayList;
    }

    public static void updateEffects(List<CameraEffect> list, Collection<UseCase> collection, Collection<UseCase> collection2) {
        List<CameraEffect> effectsOnUseCases = setEffectsOnUseCases(list, collection);
        ArrayList arrayList = new ArrayList(collection2);
        arrayList.removeAll(collection);
        List<CameraEffect> effectsOnUseCases2 = setEffectsOnUseCases(effectsOnUseCases, arrayList);
        if (effectsOnUseCases2.size() > 0) {
            Logger.w(TAG, "Unused effects: " + effectsOnUseCases2);
        }
    }

    private void updateViewPort(Map<UseCase, StreamSpec> map, Collection<UseCase> collection) {
        synchronized (this.mLock) {
            if (this.mViewPort != null) {
                Integer valueOf = Integer.valueOf(this.mCameraInternal.getCameraInfoInternal().getLensFacing());
                boolean z11 = true;
                if (valueOf == null) {
                    Logger.w(TAG, "The lens facing is null, probably an external.");
                } else if (valueOf.intValue() != 0) {
                    z11 = false;
                }
                Map<UseCase, Rect> calculateViewPortRects = ViewPorts.calculateViewPortRects(this.mCameraInternal.getCameraControlInternal().getSensorRect(), z11, this.mViewPort.getAspectRatio(), this.mCameraInternal.getCameraInfoInternal().getSensorRotationDegrees(this.mViewPort.getRotation()), this.mViewPort.getScaleType(), this.mViewPort.getLayoutDirection(), map);
                for (UseCase next : collection) {
                    next.setViewPortCropRect((Rect) h.g(calculateViewPortRects.get(next)));
                    next.setSensorToBufferTransformMatrix(calculateSensorToBufferTransformMatrix(this.mCameraInternal.getCameraControlInternal().getSensorRect(), ((StreamSpec) h.g(map.get(next))).getResolution()));
                }
            }
        }
    }

    public void addUseCases(Collection<UseCase> collection) throws CameraException {
        synchronized (this.mLock) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(this.mAppUseCases);
            linkedHashSet.addAll(collection);
            try {
                updateUseCases(linkedHashSet);
            } catch (IllegalArgumentException e11) {
                throw new CameraException(e11.getMessage());
            }
        }
    }

    public void attachUseCases() {
        synchronized (this.mLock) {
            if (!this.mAttached) {
                this.mCameraInternal.attachUseCases(this.mCameraUseCases);
                restoreInteropConfig();
                for (UseCase notifyState : this.mCameraUseCases) {
                    notifyState.notifyState();
                }
                this.mAttached = true;
            }
        }
    }

    public UseCase calculatePlaceholderForExtensions(Collection<UseCase> collection) {
        UseCase useCase;
        synchronized (this.mLock) {
            useCase = null;
            if (isCoexistingPreviewImageCaptureRequired()) {
                if (isExtraPreviewRequired(collection)) {
                    useCase = isPreview(this.mPlaceholderForExtensions) ? this.mPlaceholderForExtensions : createExtraPreview();
                } else if (isExtraImageCaptureRequired(collection)) {
                    useCase = isImageCapture(this.mPlaceholderForExtensions) ? this.mPlaceholderForExtensions : createExtraImageCapture();
                }
            }
        }
        return useCase;
    }

    public void detachUseCases() {
        synchronized (this.mLock) {
            if (this.mAttached) {
                this.mCameraInternal.detachUseCases(new ArrayList(this.mCameraUseCases));
                cacheInteropConfig();
                this.mAttached = false;
            }
        }
    }

    public CameraControl getCameraControl() {
        return this.mRestrictedCameraControl;
    }

    public CameraId getCameraId() {
        return this.mId;
    }

    public CameraInfo getCameraInfo() {
        return this.mRestrictedCameraInfo;
    }

    public LinkedHashSet<CameraInternal> getCameraInternals() {
        return this.mCameraInternals;
    }

    public Collection<UseCase> getCameraUseCases() {
        ArrayList arrayList;
        synchronized (this.mLock) {
            arrayList = new ArrayList(this.mCameraUseCases);
        }
        return arrayList;
    }

    public CameraConfig getExtendedConfig() {
        CameraConfig cameraConfig;
        synchronized (this.mLock) {
            cameraConfig = this.mCameraConfig;
        }
        return cameraConfig;
    }

    public List<UseCase> getUseCases() {
        ArrayList arrayList;
        synchronized (this.mLock) {
            arrayList = new ArrayList(this.mAppUseCases);
        }
        return arrayList;
    }

    public boolean isEquivalent(CameraUseCaseAdapter cameraUseCaseAdapter) {
        return this.mId.equals(cameraUseCaseAdapter.getCameraId());
    }

    public boolean isUseCasesCombinationSupported(UseCase... useCaseArr) {
        synchronized (this.mLock) {
            try {
                calculateSuggestedStreamSpecs(getCameraMode(), this.mCameraInternal.getCameraInfoInternal(), Arrays.asList(useCaseArr), Collections.emptyList(), getConfigs(Arrays.asList(useCaseArr), this.mCameraConfig.getUseCaseConfigFactory(), this.mUseCaseConfigFactory));
            } catch (IllegalArgumentException unused) {
                return false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return true;
    }

    public void removeUseCases(Collection<UseCase> collection) {
        synchronized (this.mLock) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(this.mAppUseCases);
            linkedHashSet.removeAll(collection);
            updateUseCases(linkedHashSet);
        }
    }

    public void setActiveResumingMode(boolean z11) {
        this.mCameraInternal.setActiveResumingMode(z11);
    }

    public void setEffects(List<CameraEffect> list) {
        synchronized (this.mLock) {
            this.mEffects = list;
        }
    }

    public void setExtendedConfig(CameraConfig cameraConfig) {
        synchronized (this.mLock) {
            if (cameraConfig == null) {
                cameraConfig = CameraConfigs.emptyConfig();
            }
            if (!this.mAppUseCases.isEmpty()) {
                if (!this.mCameraConfig.getCompatibilityId().equals(cameraConfig.getCompatibilityId())) {
                    throw new IllegalStateException("Need to unbind all use cases before binding with extension enabled");
                }
            }
            this.mCameraConfig = cameraConfig;
            SessionProcessor sessionProcessor = cameraConfig.getSessionProcessor((SessionProcessor) null);
            if (sessionProcessor != null) {
                this.mRestrictedCameraControl.enableRestrictedOperations(true, sessionProcessor.getSupportedCameraOperations());
            } else {
                this.mRestrictedCameraControl.enableRestrictedOperations(false, (Set<Integer>) null);
            }
            this.mCameraInternal.setExtendedConfig(this.mCameraConfig);
        }
    }

    public void setViewPort(ViewPort viewPort) {
        synchronized (this.mLock) {
            this.mViewPort = viewPort;
        }
    }

    public void updateUseCases(Collection<UseCase> collection) {
        updateUseCases(collection, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x008f, code lost:
        r4 = r1.get(r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateUseCases(java.util.Collection<androidx.camera.core.UseCase> r17, boolean r18) {
        /*
            r16 = this;
            r7 = r16
            r8 = r17
            java.lang.Object r9 = r7.mLock
            monitor-enter(r9)
            androidx.camera.core.UseCase r0 = r16.calculatePlaceholderForExtensions(r17)     // Catch:{ all -> 0x012b }
            androidx.camera.core.streamsharing.StreamSharing r10 = r16.createOrReuseStreamSharing(r17, r18)     // Catch:{ all -> 0x012b }
            java.util.Collection r11 = calculateCameraUseCases(r8, r0, r10)     // Catch:{ all -> 0x012b }
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ all -> 0x012b }
            r12.<init>(r11)     // Catch:{ all -> 0x012b }
            java.util.List<androidx.camera.core.UseCase> r1 = r7.mCameraUseCases     // Catch:{ all -> 0x012b }
            r12.removeAll(r1)     // Catch:{ all -> 0x012b }
            java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ all -> 0x012b }
            r13.<init>(r11)     // Catch:{ all -> 0x012b }
            java.util.List<androidx.camera.core.UseCase> r1 = r7.mCameraUseCases     // Catch:{ all -> 0x012b }
            r13.retainAll(r1)     // Catch:{ all -> 0x012b }
            java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x012b }
            java.util.List<androidx.camera.core.UseCase> r1 = r7.mCameraUseCases     // Catch:{ all -> 0x012b }
            r14.<init>(r1)     // Catch:{ all -> 0x012b }
            r14.removeAll(r11)     // Catch:{ all -> 0x012b }
            androidx.camera.core.impl.CameraConfig r1 = r7.mCameraConfig     // Catch:{ all -> 0x012b }
            androidx.camera.core.impl.UseCaseConfigFactory r1 = r1.getUseCaseConfigFactory()     // Catch:{ all -> 0x012b }
            androidx.camera.core.impl.UseCaseConfigFactory r2 = r7.mUseCaseConfigFactory     // Catch:{ all -> 0x012b }
            java.util.Map r15 = r7.getConfigs(r12, r1, r2)     // Catch:{ all -> 0x012b }
            int r2 = r16.getCameraMode()     // Catch:{ IllegalArgumentException -> 0x0112 }
            androidx.camera.core.impl.CameraInternal r1 = r7.mCameraInternal     // Catch:{ IllegalArgumentException -> 0x0112 }
            androidx.camera.core.impl.CameraInfoInternal r3 = r1.getCameraInfoInternal()     // Catch:{ IllegalArgumentException -> 0x0112 }
            r1 = r16
            r4 = r12
            r5 = r13
            r6 = r15
            java.util.Map r1 = r1.calculateSuggestedStreamSpecs(r2, r3, r4, r5, r6)     // Catch:{ IllegalArgumentException -> 0x0112 }
            r7.updateViewPort(r1, r11)     // Catch:{ all -> 0x012b }
            java.util.List<androidx.camera.core.CameraEffect> r2 = r7.mEffects     // Catch:{ all -> 0x012b }
            updateEffects(r2, r11, r8)     // Catch:{ all -> 0x012b }
            java.util.Iterator r2 = r14.iterator()     // Catch:{ all -> 0x012b }
        L_0x005c:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x012b }
            if (r3 == 0) goto L_0x006e
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x012b }
            androidx.camera.core.UseCase r3 = (androidx.camera.core.UseCase) r3     // Catch:{ all -> 0x012b }
            androidx.camera.core.impl.CameraInternal r4 = r7.mCameraInternal     // Catch:{ all -> 0x012b }
            r3.unbindFromCamera(r4)     // Catch:{ all -> 0x012b }
            goto L_0x005c
        L_0x006e:
            androidx.camera.core.impl.CameraInternal r2 = r7.mCameraInternal     // Catch:{ all -> 0x012b }
            r2.detachUseCases(r14)     // Catch:{ all -> 0x012b }
            boolean r2 = r14.isEmpty()     // Catch:{ all -> 0x012b }
            if (r2 != 0) goto L_0x00a9
            java.util.Iterator r2 = r13.iterator()     // Catch:{ all -> 0x012b }
        L_0x007d:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x012b }
            if (r3 == 0) goto L_0x00a9
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x012b }
            androidx.camera.core.UseCase r3 = (androidx.camera.core.UseCase) r3     // Catch:{ all -> 0x012b }
            boolean r4 = r1.containsKey(r3)     // Catch:{ all -> 0x012b }
            if (r4 == 0) goto L_0x007d
            java.lang.Object r4 = r1.get(r3)     // Catch:{ all -> 0x012b }
            androidx.camera.core.impl.StreamSpec r4 = (androidx.camera.core.impl.StreamSpec) r4     // Catch:{ all -> 0x012b }
            androidx.camera.core.impl.Config r5 = r4.getImplementationOptions()     // Catch:{ all -> 0x012b }
            if (r5 == 0) goto L_0x007d
            androidx.camera.core.impl.SessionConfig r6 = r3.getSessionConfig()     // Catch:{ all -> 0x012b }
            boolean r4 = hasImplementationOptionChanged(r4, r6)     // Catch:{ all -> 0x012b }
            if (r4 == 0) goto L_0x007d
            r3.updateSuggestedStreamSpecImplementationOptions(r5)     // Catch:{ all -> 0x012b }
            goto L_0x007d
        L_0x00a9:
            java.util.Iterator r2 = r12.iterator()     // Catch:{ all -> 0x012b }
        L_0x00ad:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x012b }
            if (r3 == 0) goto L_0x00db
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x012b }
            androidx.camera.core.UseCase r3 = (androidx.camera.core.UseCase) r3     // Catch:{ all -> 0x012b }
            java.lang.Object r4 = r15.get(r3)     // Catch:{ all -> 0x012b }
            androidx.camera.core.internal.CameraUseCaseAdapter$ConfigPair r4 = (androidx.camera.core.internal.CameraUseCaseAdapter.ConfigPair) r4     // Catch:{ all -> 0x012b }
            java.util.Objects.requireNonNull(r4)     // Catch:{ all -> 0x012b }
            androidx.camera.core.impl.CameraInternal r5 = r7.mCameraInternal     // Catch:{ all -> 0x012b }
            androidx.camera.core.impl.UseCaseConfig<?> r6 = r4.mExtendedConfig     // Catch:{ all -> 0x012b }
            androidx.camera.core.impl.UseCaseConfig<?> r4 = r4.mCameraConfig     // Catch:{ all -> 0x012b }
            r3.bindToCamera(r5, r6, r4)     // Catch:{ all -> 0x012b }
            java.lang.Object r4 = r1.get(r3)     // Catch:{ all -> 0x012b }
            androidx.camera.core.impl.StreamSpec r4 = (androidx.camera.core.impl.StreamSpec) r4     // Catch:{ all -> 0x012b }
            java.lang.Object r4 = androidx.core.util.h.g(r4)     // Catch:{ all -> 0x012b }
            androidx.camera.core.impl.StreamSpec r4 = (androidx.camera.core.impl.StreamSpec) r4     // Catch:{ all -> 0x012b }
            r3.updateSuggestedStreamSpec(r4)     // Catch:{ all -> 0x012b }
            goto L_0x00ad
        L_0x00db:
            boolean r1 = r7.mAttached     // Catch:{ all -> 0x012b }
            if (r1 == 0) goto L_0x00e4
            androidx.camera.core.impl.CameraInternal r1 = r7.mCameraInternal     // Catch:{ all -> 0x012b }
            r1.attachUseCases(r12)     // Catch:{ all -> 0x012b }
        L_0x00e4:
            java.util.Iterator r1 = r12.iterator()     // Catch:{ all -> 0x012b }
        L_0x00e8:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x012b }
            if (r2 == 0) goto L_0x00f8
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x012b }
            androidx.camera.core.UseCase r2 = (androidx.camera.core.UseCase) r2     // Catch:{ all -> 0x012b }
            r2.notifyState()     // Catch:{ all -> 0x012b }
            goto L_0x00e8
        L_0x00f8:
            java.util.List<androidx.camera.core.UseCase> r1 = r7.mAppUseCases     // Catch:{ all -> 0x012b }
            r1.clear()     // Catch:{ all -> 0x012b }
            java.util.List<androidx.camera.core.UseCase> r1 = r7.mAppUseCases     // Catch:{ all -> 0x012b }
            r1.addAll(r8)     // Catch:{ all -> 0x012b }
            java.util.List<androidx.camera.core.UseCase> r1 = r7.mCameraUseCases     // Catch:{ all -> 0x012b }
            r1.clear()     // Catch:{ all -> 0x012b }
            java.util.List<androidx.camera.core.UseCase> r1 = r7.mCameraUseCases     // Catch:{ all -> 0x012b }
            r1.addAll(r11)     // Catch:{ all -> 0x012b }
            r7.mPlaceholderForExtensions = r0     // Catch:{ all -> 0x012b }
            r7.mStreamSharing = r10     // Catch:{ all -> 0x012b }
            monitor-exit(r9)     // Catch:{ all -> 0x012b }
            return
        L_0x0112:
            r0 = move-exception
            if (r18 != 0) goto L_0x012a
            boolean r1 = r16.hasNoExtension()     // Catch:{ all -> 0x012b }
            if (r1 == 0) goto L_0x012a
            androidx.camera.core.concurrent.CameraCoordinator r1 = r7.mCameraCoordinator     // Catch:{ all -> 0x012b }
            int r1 = r1.getCameraOperatingMode()     // Catch:{ all -> 0x012b }
            r2 = 2
            if (r1 == r2) goto L_0x012a
            r0 = 1
            r7.updateUseCases(r8, r0)     // Catch:{ all -> 0x012b }
            monitor-exit(r9)     // Catch:{ all -> 0x012b }
            return
        L_0x012a:
            throw r0     // Catch:{ all -> 0x012b }
        L_0x012b:
            r0 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x012b }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.internal.CameraUseCaseAdapter.updateUseCases(java.util.Collection, boolean):void");
    }
}
