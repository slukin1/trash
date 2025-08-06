package com.google.android.exoplayer2.drm;

import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Map;
import java.util.UUID;

public final class OfflineLicenseHelper {
    private static final Format FORMAT_WITH_EMPTY_DRM_INIT_DATA = new Format.Builder().setDrmInitData(new DrmInitData(new DrmInitData.SchemeData[0])).build();
    /* access modifiers changed from: private */
    public final ConditionVariable conditionVariable;
    private final DefaultDrmSessionManager drmSessionManager;
    private final DrmSessionEventListener.EventDispatcher eventDispatcher;
    private final HandlerThread handlerThread;

    @Deprecated
    public OfflineLicenseHelper(UUID uuid, ExoMediaDrm.Provider provider, MediaDrmCallback mediaDrmCallback, Map<String, String> map, DrmSessionEventListener.EventDispatcher eventDispatcher2) {
        this(new DefaultDrmSessionManager.Builder().setUuidAndExoMediaDrmProvider(uuid, provider).setKeyRequestParameters(map).build(mediaDrmCallback), eventDispatcher2);
    }

    private byte[] blockingKeyRequest(int i11, byte[] bArr, Format format) throws DrmSession.DrmSessionException {
        this.drmSessionManager.prepare();
        DrmSession openBlockingKeyRequest = openBlockingKeyRequest(i11, bArr, format);
        DrmSession.DrmSessionException error = openBlockingKeyRequest.getError();
        byte[] offlineLicenseKeySetId = openBlockingKeyRequest.getOfflineLicenseKeySetId();
        openBlockingKeyRequest.release(this.eventDispatcher);
        this.drmSessionManager.release();
        if (error == null) {
            return (byte[]) Assertions.checkNotNull(offlineLicenseKeySetId);
        }
        throw error;
    }

    public static OfflineLicenseHelper newWidevineInstance(String str, HttpDataSource.Factory factory, DrmSessionEventListener.EventDispatcher eventDispatcher2) {
        return newWidevineInstance(str, false, factory, eventDispatcher2);
    }

    private DrmSession openBlockingKeyRequest(int i11, byte[] bArr, Format format) {
        Assertions.checkNotNull(format.drmInitData);
        this.drmSessionManager.setMode(i11, bArr);
        this.conditionVariable.close();
        DrmSession acquireSession = this.drmSessionManager.acquireSession(this.handlerThread.getLooper(), this.eventDispatcher, format);
        this.conditionVariable.block();
        return (DrmSession) Assertions.checkNotNull(acquireSession);
    }

    public synchronized byte[] downloadLicense(Format format) throws DrmSession.DrmSessionException {
        Assertions.checkArgument(format.drmInitData != null);
        return blockingKeyRequest(2, (byte[]) null, format);
    }

    public synchronized Pair<Long, Long> getLicenseDurationRemainingSec(byte[] bArr) throws DrmSession.DrmSessionException {
        Assertions.checkNotNull(bArr);
        this.drmSessionManager.prepare();
        DrmSession openBlockingKeyRequest = openBlockingKeyRequest(1, bArr, FORMAT_WITH_EMPTY_DRM_INIT_DATA);
        DrmSession.DrmSessionException error = openBlockingKeyRequest.getError();
        Pair<Long, Long> licenseDurationRemainingSec = WidevineUtil.getLicenseDurationRemainingSec(openBlockingKeyRequest);
        openBlockingKeyRequest.release(this.eventDispatcher);
        this.drmSessionManager.release();
        if (error == null) {
            return (Pair) Assertions.checkNotNull(licenseDurationRemainingSec);
        } else if (error.getCause() instanceof KeysExpiredException) {
            return Pair.create(0L, 0L);
        } else {
            throw error;
        }
    }

    public void release() {
        this.handlerThread.quit();
    }

    public synchronized void releaseLicense(byte[] bArr) throws DrmSession.DrmSessionException {
        Assertions.checkNotNull(bArr);
        blockingKeyRequest(3, bArr, FORMAT_WITH_EMPTY_DRM_INIT_DATA);
    }

    public synchronized byte[] renewLicense(byte[] bArr) throws DrmSession.DrmSessionException {
        Assertions.checkNotNull(bArr);
        return blockingKeyRequest(2, bArr, FORMAT_WITH_EMPTY_DRM_INIT_DATA);
    }

    public static OfflineLicenseHelper newWidevineInstance(String str, boolean z11, HttpDataSource.Factory factory, DrmSessionEventListener.EventDispatcher eventDispatcher2) {
        return newWidevineInstance(str, z11, factory, (Map<String, String>) null, eventDispatcher2);
    }

    public static OfflineLicenseHelper newWidevineInstance(String str, boolean z11, HttpDataSource.Factory factory, Map<String, String> map, DrmSessionEventListener.EventDispatcher eventDispatcher2) {
        return new OfflineLicenseHelper(new DefaultDrmSessionManager.Builder().setKeyRequestParameters(map).build(new HttpMediaDrmCallback(str, z11, factory)), eventDispatcher2);
    }

    public OfflineLicenseHelper(DefaultDrmSessionManager defaultDrmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher2) {
        this.drmSessionManager = defaultDrmSessionManager;
        this.eventDispatcher = eventDispatcher2;
        HandlerThread handlerThread2 = new HandlerThread("ExoPlayer:OfflineLicenseHelper");
        this.handlerThread = handlerThread2;
        handlerThread2.start();
        this.conditionVariable = new ConditionVariable();
        eventDispatcher2.addEventListener(new Handler(handlerThread2.getLooper()), new DrmSessionEventListener() {
            public void onDrmKeysLoaded(int i11, MediaSource.MediaPeriodId mediaPeriodId) {
                OfflineLicenseHelper.this.conditionVariable.open();
            }

            public void onDrmKeysRemoved(int i11, MediaSource.MediaPeriodId mediaPeriodId) {
                OfflineLicenseHelper.this.conditionVariable.open();
            }

            public void onDrmKeysRestored(int i11, MediaSource.MediaPeriodId mediaPeriodId) {
                OfflineLicenseHelper.this.conditionVariable.open();
            }

            public /* synthetic */ void onDrmSessionAcquired(int i11, MediaSource.MediaPeriodId mediaPeriodId) {
                j.d(this, i11, mediaPeriodId);
            }

            public /* synthetic */ void onDrmSessionAcquired(int i11, MediaSource.MediaPeriodId mediaPeriodId, int i12) {
                j.e(this, i11, mediaPeriodId, i12);
            }

            public void onDrmSessionManagerError(int i11, MediaSource.MediaPeriodId mediaPeriodId, Exception exc) {
                OfflineLicenseHelper.this.conditionVariable.open();
            }

            public /* synthetic */ void onDrmSessionReleased(int i11, MediaSource.MediaPeriodId mediaPeriodId) {
                j.g(this, i11, mediaPeriodId);
            }
        });
    }
}
