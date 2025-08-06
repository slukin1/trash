package com.tencent.thumbplayer.tcmedia.core.downloadproxy.drm;

import android.media.DeniedByServerException;
import android.media.MediaDrm;
import android.media.NotProvisionedException;
import android.media.UnsupportedSchemeException;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.ITPDLProxyLogListener;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.utils.TPDLProxyLog;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class TPDownloadMediaDrm {
    private static final String FILE_NAME = "TPDownloadMediaDrm";
    private static final int MAX_LICENSE_DURATION_TO_RENEW_SECONDS = 60;
    public static final String PROPERTY_LICENSE_DURATION_REMAINING = "LicenseDurationRemaining";
    public static final String PROPERTY_PLAYBACK_DURATION_REMAINING = "PlaybackDurationRemaining";
    private MediaDrm mMediaDrm;
    /* access modifiers changed from: private */
    public OnEventListener mOnEventListener;
    /* access modifiers changed from: private */
    public OnExpirationUpdateListener mOnExpirationUpdateListener;
    /* access modifiers changed from: private */
    public OnKeyStatusChangeListener mOnKeyStatusChangeListener;

    public static final class DownloadDrmSession {
        public byte[] mSessionId;
        public int mStatus;

        public DownloadDrmSession(int i11, byte[] bArr) {
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

    public interface OnEventListener {
        void onEvent(TPDownloadMediaDrm tPDownloadMediaDrm, byte[] bArr, int i11, int i12, byte[] bArr2);
    }

    public interface OnExpirationUpdateListener {
        void onExpirationUpdate(TPDownloadMediaDrm tPDownloadMediaDrm, byte[] bArr, long j11);
    }

    public interface OnKeyStatusChangeListener {
        void onKeyStatusChange(TPDownloadMediaDrm tPDownloadMediaDrm, byte[] bArr, List<MediaDrm.KeyStatus> list, boolean z11);
    }

    public static final class ProvisionRequest {
        public byte[] mData;
        public String mDefaultUrl;

        public ProvisionRequest(String str, byte[] bArr) {
            this.mDefaultUrl = str;
            this.mData = bArr;
        }
    }

    private TPDownloadMediaDrm(UUID uuid) throws UnsupportedSchemeException {
        this.mMediaDrm = new MediaDrm(uuid);
    }

    public static synchronized TPDownloadMediaDrm createDownloadMediaDrm(String str) {
        TPDownloadMediaDrm tPDownloadMediaDrm;
        synchronized (TPDownloadMediaDrm.class) {
            tPDownloadMediaDrm = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (Build.VERSION.SDK_INT < 18) {
                return null;
            }
            try {
                tPDownloadMediaDrm = new TPDownloadMediaDrm(UUID.fromString(str));
            } catch (Exception e11) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "createDownloadMediaDrm exception : " + e11.getMessage());
            }
        }
        return tPDownloadMediaDrm;
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
            TPDLProxyLog.w(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "queryKeyStatus failed, error:" + th2.toString());
        }
        return 0;
    }

    public static synchronized int getSdkIntVersion() {
        int i11;
        synchronized (TPDownloadMediaDrm.class) {
            i11 = Build.VERSION.SDK_INT;
        }
        return i11;
    }

    public static synchronized boolean isCryptoSchemeSupported(String str) {
        boolean isCryptoSchemeSupported;
        synchronized (TPDownloadMediaDrm.class) {
            isCryptoSchemeSupported = MediaDrm.isCryptoSchemeSupported(UUID.fromString(str));
        }
        return isCryptoSchemeSupported;
    }

    public void close() {
        MediaDrm mediaDrm = this.mMediaDrm;
        if (mediaDrm != null) {
            mediaDrm.setOnEventListener((MediaDrm.OnEventListener) null);
            this.mOnEventListener = null;
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 23) {
                this.mMediaDrm.setOnExpirationUpdateListener((MediaDrm.OnExpirationUpdateListener) null, (Handler) null);
            }
            this.mOnExpirationUpdateListener = null;
            if (i11 >= 23) {
                this.mMediaDrm.setOnKeyStatusChangeListener((MediaDrm.OnKeyStatusChangeListener) null, (Handler) null);
            }
            this.mOnKeyStatusChangeListener = null;
            this.mMediaDrm.release();
            this.mMediaDrm = null;
        }
    }

    public void closeSession(byte[] bArr) {
        this.mMediaDrm.closeSession(bArr);
    }

    public KeyRequest getKeyRequest(byte[] bArr, byte[] bArr2, String str, int i11) {
        try {
            MediaDrm.KeyRequest keyRequest = this.mMediaDrm.getKeyRequest(bArr, bArr2, str, i11, (HashMap) null);
            return new KeyRequest(Build.VERSION.SDK_INT >= 23 ? keyRequest.getRequestType() : 0, keyRequest.getData(), 0);
        } catch (NotProvisionedException unused) {
            return new KeyRequest(-1, (byte[]) null, -1);
        }
    }

    public byte[] getPropertyByteArray(String str) {
        return this.mMediaDrm.getPropertyByteArray(str);
    }

    public String getPropertyString(String str) {
        return this.mMediaDrm.getPropertyString(str);
    }

    public ProvisionRequest getProvisionRequest() {
        try {
            MediaDrm.ProvisionRequest provisionRequest = this.mMediaDrm.getProvisionRequest();
            return new ProvisionRequest(provisionRequest.getDefaultUrl(), provisionRequest.getData());
        } catch (Exception unused) {
            return new ProvisionRequest("", new byte[0]);
        }
    }

    public DownloadDrmSession openSession() {
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
        return new DownloadDrmSession(i11, bArr);
    }

    public byte[] provideKeyResponse(byte[] bArr, byte[] bArr2) {
        try {
            return this.mMediaDrm.provideKeyResponse(bArr, bArr2);
        } catch (NotProvisionedException e11) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "provideKeyResponse NotProvisionedException : " + e11.getMessage());
            return new byte[]{-1};
        } catch (DeniedByServerException e12) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "provideKeyResponse DeniedByServerException : " + e12.getMessage());
            return new byte[]{-2};
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

    public int removeKeys(byte[] bArr) {
        try {
            this.mMediaDrm.removeKeys(bArr);
            return 0;
        } catch (Exception unused) {
            return -1;
        }
    }

    public int restoreKeys(byte[] bArr, byte[] bArr2) {
        try {
            this.mMediaDrm.restoreKeys(bArr, bArr2);
            long licenseDurationRemainingSec = getLicenseDurationRemainingSec(bArr);
            if (licenseDurationRemainingSec > 60) {
                return 0;
            }
            TPDLProxyLog.w(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "Offline license has expired or will expire soon, Remaining seconds: ".concat(String.valueOf(licenseDurationRemainingSec)));
            this.mMediaDrm.removeKeys(bArr);
            return -1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public void setOnEventListener(OnEventListener onEventListener) {
        this.mMediaDrm.setOnEventListener(new MediaDrm.OnEventListener() {
            public void onEvent(MediaDrm mediaDrm, byte[] bArr, int i11, int i12, byte[] bArr2) {
                if (TPDownloadMediaDrm.this.mOnEventListener != null) {
                    TPDownloadMediaDrm.this.mOnEventListener.onEvent(TPDownloadMediaDrm.this, bArr, i11, i12, bArr2);
                }
            }
        });
    }

    public void setOnExpirationUpdateListener(OnExpirationUpdateListener onExpirationUpdateListener, Handler handler) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 23) {
            this.mOnExpirationUpdateListener = onExpirationUpdateListener;
            if (i11 >= 23) {
                this.mMediaDrm.setOnExpirationUpdateListener(new MediaDrm.OnExpirationUpdateListener() {
                    public void onExpirationUpdate(MediaDrm mediaDrm, byte[] bArr, long j11) {
                        if (TPDownloadMediaDrm.this.mOnExpirationUpdateListener != null) {
                            TPDownloadMediaDrm.this.mOnExpirationUpdateListener.onExpirationUpdate(TPDownloadMediaDrm.this, bArr, j11);
                        }
                    }
                }, handler);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0018, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void setOnKeyStatusChangeListener(com.tencent.thumbplayer.tcmedia.core.downloadproxy.drm.TPDownloadMediaDrm.OnKeyStatusChangeListener r3, android.os.Handler r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0019 }
            r1 = 23
            if (r0 >= r1) goto L_0x0009
            monitor-exit(r2)
            return
        L_0x0009:
            r2.mOnKeyStatusChangeListener = r3     // Catch:{ all -> 0x0019 }
            if (r0 < r1) goto L_0x0017
            android.media.MediaDrm r3 = r2.mMediaDrm     // Catch:{ all -> 0x0019 }
            com.tencent.thumbplayer.tcmedia.core.downloadproxy.drm.TPDownloadMediaDrm$2 r0 = new com.tencent.thumbplayer.tcmedia.core.downloadproxy.drm.TPDownloadMediaDrm$2     // Catch:{ all -> 0x0019 }
            r0.<init>()     // Catch:{ all -> 0x0019 }
            r3.setOnKeyStatusChangeListener(r0, r4)     // Catch:{ all -> 0x0019 }
        L_0x0017:
            monitor-exit(r2)
            return
        L_0x0019:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.core.downloadproxy.drm.TPDownloadMediaDrm.setOnKeyStatusChangeListener(com.tencent.thumbplayer.tcmedia.core.downloadproxy.drm.TPDownloadMediaDrm$OnKeyStatusChangeListener, android.os.Handler):void");
    }

    public void setPropertyByteArray(String str, byte[] bArr) {
        this.mMediaDrm.setPropertyByteArray(str, bArr);
    }

    public void setPropertyString(String str, String str2) {
        this.mMediaDrm.setPropertyString(str, str2);
    }
}
