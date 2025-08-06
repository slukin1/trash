package com.tencent.thumbplayer.tcmedia.core.drm;

import android.media.DeniedByServerException;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaDrm;
import android.media.NotProvisionedException;
import android.media.UnsupportedSchemeException;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.sumsub.sns.internal.core.analytics.d;
import com.tencent.thumbplayer.tcmedia.core.common.TPNativeLog;
import com.tencent.thumbplayer.tcmedia.core.drm.ITPMediaDrm;
import com.tencent.thumbplayer.tcmedia.core.utils.TPThreadPool;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ExecutorService;

public class TPMediaDrmProxy {
    private static final long CREATE_MEDIA_DRM_SLICE_WAIT_TIME_MS = 100;
    private static final long CREATE_MEDIA_DRM_TIMEOUT_MS = 5000;
    private static final int ERR_API_LOW_LEVEL = 2;
    private static final int ERR_CREATE_MEDIA_DRM_FAILED = 5;
    private static final int ERR_ILLEGAL_ARGUMENT = 1;
    private static final int ERR_INTERRUPT = 3;
    private static final int ERR_NONE = 0;
    private static final int ERR_UNSUPPORTED_SCHEME = 4;
    private static final int MAX_LICENSE_DURATION_TO_RENEW_SECONDS = 60;
    public static final String PROPERTY_LICENSE_DURATION_REMAINING = "LicenseDurationRemaining";
    public static final String PROPERTY_PLAYBACK_DURATION_REMAINING = "PlaybackDurationRemaining";
    private static final String TAG = "[PlayerCore][TPMediaDrmProxy]";
    /* access modifiers changed from: private */
    public ITPMediaDrm mMediaDrm;
    private long mNativeContext;
    private UUID mUUID;

    public static final class DrmSessionId {
        public byte[] mSessionId;
        public int mStatus;

        public DrmSessionId(int i11, byte[] bArr) {
            this.mStatus = i11;
            this.mSessionId = bArr;
        }
    }

    public static final class KeyRequest {
        public byte[] mData;
        public int mRequestType;
        public int mStatus;

        public KeyRequest(int i11, byte[] bArr, int i12) {
            this.mRequestType = i11;
            this.mData = bArr;
            this.mStatus = i12;
        }
    }

    public static final class MediaDrmProxyCreateResult {
        public int mErrorCode;
        public TPMediaDrmProxy mMediaDrmProxy;

        public MediaDrmProxyCreateResult(TPMediaDrmProxy tPMediaDrmProxy, int i11) {
            this.mMediaDrmProxy = tPMediaDrmProxy;
            this.mErrorCode = i11;
        }
    }

    public static final class ProvisionRequest {
        public byte[] mData;
        public String mDefaultUrl;

        public ProvisionRequest(String str, byte[] bArr) {
            this.mDefaultUrl = str;
            this.mData = bArr;
        }
    }

    private TPMediaDrmProxy(UUID uuid, boolean z11) {
        ITPMediaDrm createTPMediaDrm = z11 ? TPMediaDrmPool.getInstance().createTPMediaDrm(uuid) : TPMediaDrmPool.getInstance().createTPDirectMediaDrm(uuid);
        new ITPMediaDrm.OnEventListener() {
            public void onEvent(ITPMediaDrm iTPMediaDrm, byte[] bArr, int i11, int i12, byte[] bArr2) {
                if (iTPMediaDrm == TPMediaDrmProxy.this.mMediaDrm) {
                    TPMediaDrmProxy.this.native_mediaDrmOnEvent(bArr, i11, i12, bArr2);
                }
            }
        };
        this.mMediaDrm = createTPMediaDrm;
        this.mUUID = uuid;
    }

    private static void checkInterrupt(ITPDrmInterruptCallback iTPDrmInterruptCallback) {
        if (iTPDrmInterruptCallback != null && iTPDrmInterruptCallback.isInterrupted()) {
            throw new InterruptedException();
        }
    }

    private static MediaDrmProxyCreateResult createMediaDrmProxyByUUID(String str, boolean z11, TPDrmInterruptCallbackProxy tPDrmInterruptCallbackProxy) {
        if (str == null) {
            TPNativeLog.printLog(4, "illegal argument.");
            return new MediaDrmProxyCreateResult((TPMediaDrmProxy) null, 1);
        }
        try {
            UUID fromString = UUID.fromString(str);
            if (Build.VERSION.SDK_INT < 18) {
                return new MediaDrmProxyCreateResult((TPMediaDrmProxy) null, 2);
            }
            try {
                TPMediaDrmProxy createMediaDrmProxyWithAsyncTimeout = createMediaDrmProxyWithAsyncTimeout(fromString, z11, tPDrmInterruptCallbackProxy);
                return new MediaDrmProxyCreateResult(createMediaDrmProxyWithAsyncTimeout, createMediaDrmProxyWithAsyncTimeout != null ? 0 : 5);
            } catch (UnsupportedSchemeException e11) {
                TPNativeLog.printLog(4, e11.getMessage());
                return new MediaDrmProxyCreateResult((TPMediaDrmProxy) null, 4);
            } catch (InterruptedException e12) {
                TPNativeLog.printLog(4, e12.getMessage());
                return new MediaDrmProxyCreateResult((TPMediaDrmProxy) null, 3);
            }
        } catch (IllegalArgumentException e13) {
            TPNativeLog.printLog(4, e13.getMessage());
            return new MediaDrmProxyCreateResult((TPMediaDrmProxy) null, 1);
        }
    }

    private static TPMediaDrmProxy createMediaDrmProxyWithAsyncTimeout(UUID uuid, boolean z11, ITPDrmInterruptCallback iTPDrmInterruptCallback) {
        TPMediaDrmProxy tPMediaDrmProxy;
        Object obj = new Object();
        TPMediaDrmProxy[] tPMediaDrmProxyArr = {null};
        UnsupportedSchemeException[] unsupportedSchemeExceptionArr = {null};
        boolean[] zArr = {false};
        TPNativeLog.printLog(2, "async create mediaDrm proxy start.");
        ExecutorService obtainThreadExecutor = TPThreadPool.getInstance().obtainThreadExecutor();
        final TPMediaDrmProxy[] tPMediaDrmProxyArr2 = tPMediaDrmProxyArr;
        final UUID uuid2 = uuid;
        final boolean z12 = z11;
        final UnsupportedSchemeException[] unsupportedSchemeExceptionArr2 = unsupportedSchemeExceptionArr;
        final Object obj2 = obj;
        AnonymousClass2 r11 = r1;
        final boolean[] zArr2 = zArr;
        AnonymousClass2 r12 = new Runnable() {
            public final void run() {
                boolean z11;
                TPNativeLog.printLog(2, "create system mediaDrm proxy start.");
                try {
                    tPMediaDrmProxyArr2[0] = new TPMediaDrmProxy(uuid2, z12);
                } catch (UnsupportedSchemeException e11) {
                    unsupportedSchemeExceptionArr2[0] = e11;
                }
                TPNativeLog.printLog(2, "create system mediaDrm proxy end.");
                synchronized (obj2) {
                    z11 = zArr2[0];
                    obj2.notify();
                }
                if (z11) {
                    TPMediaDrmProxy[] tPMediaDrmProxyArr = tPMediaDrmProxyArr2;
                    if (tPMediaDrmProxyArr[0] != null) {
                        tPMediaDrmProxyArr[0].release();
                    }
                }
            }
        };
        obtainThreadExecutor.execute(r11);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        while (tPMediaDrmProxyArr[0] == null) {
            synchronized (obj) {
                try {
                    checkInterrupt(iTPDrmInterruptCallback);
                } catch (InterruptedException e11) {
                    InterruptedException interruptedException = e11;
                    zArr[0] = true;
                    throw interruptedException;
                }
            }
            long elapsedRealtime2 = 5000 - (SystemClock.elapsedRealtime() - elapsedRealtime);
            if (elapsedRealtime2 <= 0) {
                break;
            }
            synchronized (obj) {
                try {
                    obj.wait(Math.min(elapsedRealtime2, 100));
                } catch (InterruptedException e12) {
                    zArr[0] = true;
                    throw e12;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (unsupportedSchemeExceptionArr[0] == null) {
            synchronized (obj) {
                if (tPMediaDrmProxyArr[0] == null) {
                    zArr[0] = true;
                    tPMediaDrmProxy = null;
                } else {
                    tPMediaDrmProxy = tPMediaDrmProxyArr[0];
                }
            }
            TPNativeLog.printLog(2, "async create mediaDrm proxy end.");
            return tPMediaDrmProxy;
        }
        throw unsupportedSchemeExceptionArr[0];
    }

    private long getLicenseDurationRemainingSec(byte[] bArr) {
        try {
            HashMap<String, String> queryKeyStatus = this.mMediaDrm.queryKeyStatus(bArr);
            if (queryKeyStatus != null && queryKeyStatus.size() > 0) {
                String str = queryKeyStatus.get("LicenseDurationRemaining");
                long parseLong = !TextUtils.isEmpty(str) ? Long.parseLong(str) : 0;
                String str2 = queryKeyStatus.get("PlaybackDurationRemaining");
                return Math.min(parseLong, !TextUtils.isEmpty(str2) ? Long.parseLong(str2) : 0);
            }
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, "queryKeyStatus failed, error:" + th2.toString());
        }
        return 0;
    }

    public static boolean isCryptoSchemeSupported(String str) {
        if (str == null) {
            TPNativeLog.printLog(2, "isCryptoSchemeSupported, illegal argument.");
            return false;
        }
        try {
            UUID fromString = UUID.fromString(str);
            TPNativeLog.printLog(2, "isCryptoSchemeSupported, MediaDrm create start.");
            try {
                TPMediaDrmPool.getInstance().createTPMediaDrm(fromString).close();
                TPNativeLog.printLog(2, "isCryptoSchemeSupported, MediaDrm release finished.");
                boolean isCryptoSchemeSupported = MediaDrm.isCryptoSchemeSupported(fromString);
                TPNativeLog.printLog(2, "isCryptoSchemeSupported, supported:".concat(String.valueOf(isCryptoSchemeSupported)));
                return isCryptoSchemeSupported;
            } catch (UnsupportedSchemeException e11) {
                TPNativeLog.printLog(4, e11.getMessage());
                return false;
            }
        } catch (IllegalArgumentException e12) {
            TPNativeLog.printLog(4, e12.getMessage());
            return false;
        }
    }

    /* access modifiers changed from: private */
    public native void native_mediaDrmOnEvent(byte[] bArr, int i11, int i12, byte[] bArr2);

    public static void setMediaDrmReuseEnable(boolean z11) {
        TPMediaDrmPool.getInstance().setMediaDrmReuseEnable(z11);
        StringBuilder sb2 = new StringBuilder("setMediaDrmReuseEnable, reuse:");
        sb2.append(z11 ? "true" : d.f31895b);
        TPNativeLog.printLog(2, TAG, sb2.toString());
    }

    public void closeSession(byte[] bArr) {
        if (bArr != null) {
            this.mMediaDrm.closeSession(bArr);
        }
    }

    public KeyRequest getKeyRequest(byte[] bArr, byte[] bArr2, String str, int i11) {
        try {
            MediaDrm.KeyRequest keyRequest = this.mMediaDrm.getKeyRequest(bArr, bArr2, str, i11, (HashMap<String, String>) null);
            return new KeyRequest(Build.VERSION.SDK_INT >= 23 ? keyRequest.getRequestType() : 0, keyRequest.getData(), 0);
        } catch (NotProvisionedException | TPMediaDrmFatalException unused) {
            return new KeyRequest(-1, (byte[]) null, -1);
        }
    }

    public MediaCrypto getMediaCrypto(byte[] bArr) {
        try {
            return new MediaCrypto(this.mUUID, bArr);
        } catch (MediaCryptoException unused) {
            return null;
        }
    }

    public String getPropertyString(String str) {
        return this.mMediaDrm.getPropertyString(str);
    }

    public ProvisionRequest getProvisionRequest() {
        try {
            MediaDrm.ProvisionRequest provisionRequest = this.mMediaDrm.getProvisionRequest();
            return new ProvisionRequest(provisionRequest.getDefaultUrl(), provisionRequest.getData());
        } catch (TPMediaDrmFatalException unused) {
            return new ProvisionRequest("", new byte[0]);
        }
    }

    public DrmSessionId openSession() {
        int i11;
        byte[] bArr = null;
        try {
            bArr = this.mMediaDrm.openSession();
            i11 = 0;
        } catch (NotProvisionedException unused) {
            i11 = -1;
        } catch (Exception unused2) {
            i11 = -2;
        }
        return new DrmSessionId(i11, bArr);
    }

    public int provideKeyResponse(byte[] bArr, byte[] bArr2) {
        try {
            this.mMediaDrm.provideKeyResponse(bArr, bArr2);
            return 0;
        } catch (NotProvisionedException unused) {
            return -1;
        } catch (DeniedByServerException | TPMediaDrmFatalException unused2) {
            return -2;
        }
    }

    public int provideProvisionResponse(byte[] bArr) {
        try {
            this.mMediaDrm.provideProvisionResponse(bArr);
            return 0;
        } catch (DeniedByServerException unused) {
            return -1;
        }
    }

    public void release() {
        this.mMediaDrm.close();
    }

    public int restoreKeys(byte[] bArr, String str) {
        try {
            this.mMediaDrm.restoreKeys(bArr, Base64.decode(str, 2));
            long licenseDurationRemainingSec = getLicenseDurationRemainingSec(bArr);
            if (licenseDurationRemainingSec > 60) {
                return 0;
            }
            TPNativeLog.printLog(3, "Offline license has expired or will expire soon, Remaining seconds: ".concat(String.valueOf(licenseDurationRemainingSec)));
            this.mMediaDrm.removeKeys(bArr);
            return -1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public void setPropertyString(String str, String str2) {
        this.mMediaDrm.setPropertyString(str, str2);
    }
}
