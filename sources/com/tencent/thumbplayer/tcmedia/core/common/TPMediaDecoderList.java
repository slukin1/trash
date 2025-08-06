package com.tencent.thumbplayer.tcmedia.core.common;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.thumbplayer.tcmedia.core.thirdparties.LocalCache;
import java.util.ArrayList;
import java.util.Arrays;

public final class TPMediaDecoderList {
    private static final String MEDIA_DECODER_INFO_KEY = "DecoderInfos_Key";
    private static String MEDIA_DECODER_VERSION = "2.32.0.338.min";
    private static final String MEDIA_DECODER_VERSION_KEY = "Version_Key";
    private static final String TAG = "TPMediaDecoderList";
    private static TPMediaDecoderInfo[] sDecoderInfos;

    private static String buildCacheDecoderVersion() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(MEDIA_DECODER_VERSION);
        stringBuffer.append("_");
        stringBuffer.append(TPSystemInfo.getDeviceName());
        stringBuffer.append("_");
        stringBuffer.append(TPSystemInfo.getProductBoard());
        stringBuffer.append("_");
        stringBuffer.append(TPSystemInfo.getProductDevice());
        stringBuffer.append("_");
        stringBuffer.append(TPSystemInfo.getApiLevel());
        return stringBuffer.toString();
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.tencent.thumbplayer.tcmedia.core.common.TPMediaDecoderInfo[], java.io.Serializable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void cacheDecoderInfos(com.tencent.thumbplayer.tcmedia.core.thirdparties.LocalCache r1, com.tencent.thumbplayer.tcmedia.core.common.TPMediaDecoderInfo[] r2) {
        /*
            java.lang.String r0 = "DecoderInfos_Key"
            r1.put((java.lang.String) r0, (java.io.Serializable) r2)     // Catch:{ all -> 0x0006 }
            return
        L_0x0006:
            r1 = 4
            java.lang.String r2 = "TPMediaDecoderList"
            java.lang.String r0 = "cache decode infos failed"
            com.tencent.thumbplayer.tcmedia.core.common.TPNativeLog.printLog(r1, r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.core.common.TPMediaDecoderList.cacheDecoderInfos(com.tencent.thumbplayer.tcmedia.core.thirdparties.LocalCache, com.tencent.thumbplayer.tcmedia.core.common.TPMediaDecoderInfo[]):void");
    }

    private static void cacheVersion(LocalCache localCache, String str) {
        try {
            localCache.put(MEDIA_DECODER_VERSION_KEY, str);
        } catch (Throwable unused) {
            TPNativeLog.printLog(4, TAG, "cache version failed");
        }
    }

    private static TPMediaDecoderInfo[] getCachedDecoderInfos(LocalCache localCache) {
        try {
            return (TPMediaDecoderInfo[]) localCache.getAsObject(MEDIA_DECODER_INFO_KEY);
        } catch (Throwable unused) {
            TPNativeLog.printLog(4, TAG, "get decoder info failed");
            return null;
        }
    }

    private static String getCachedVersion(LocalCache localCache) {
        try {
            String asString = localCache.getAsString(MEDIA_DECODER_VERSION_KEY);
            TPNativeLog.printLog(2, TAG, "version:".concat(String.valueOf(asString)));
            return asString;
        } catch (Throwable unused) {
            TPNativeLog.printLog(4, TAG, "get version failed");
            return null;
        }
    }

    private static final MediaCodecInfo[] getCodecInfos() {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 16) {
            return null;
        }
        if (i11 < 21) {
            int codecCount = MediaCodecList.getCodecCount();
            ArrayList arrayList = new ArrayList();
            for (int i12 = 0; i12 < codecCount; i12++) {
                arrayList.add(MediaCodecList.getCodecInfoAt(i12));
            }
            return (MediaCodecInfo[]) arrayList.toArray(new MediaCodecInfo[arrayList.size()]);
        }
        try {
            return new MediaCodecList(1).getCodecInfos();
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, "getCodecInfos MediaCodecList " + th2.getMessage());
            return new MediaCodecInfo[0];
        }
    }

    private static final TPMediaDecoderInfo[] getLocalCacheMediaCodecList(LocalCache localCache) {
        TPMediaDecoderInfo[] cachedDecoderInfos;
        TPNativeLog.printLog(2, "getLocalCacheMediaCodecList");
        if (!TextUtils.equals(getCachedVersion(localCache), buildCacheDecoderVersion()) || (cachedDecoderInfos = getCachedDecoderInfos(localCache)) == null) {
            return null;
        }
        TPNativeLog.printLog(2, "getCachedDecoderInfos length " + cachedDecoderInfos.length);
        for (TPMediaDecoderInfo tPMediaDecoderInfo : cachedDecoderInfos) {
            TPNativeLog.printLog(2, "getLocalCacheMediaCodecList MediaCodecList codecName: " + tPMediaDecoderInfo.getDecoderName() + " ,DecoderMimeType: " + tPMediaDecoderInfo.getDecoderMimeType());
        }
        return cachedDecoderInfos;
    }

    private static final TPMediaDecoderInfo[] getSystemMediaCodecList() {
        MediaCodecInfo[] codecInfos;
        TPNativeLog.printLog(2, "getSystemMediaCodecList");
        if (Build.VERSION.SDK_INT < 16 || (codecInfos = getCodecInfos()) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (MediaCodecInfo mediaCodecInfo : codecInfos) {
            if (!mediaCodecInfo.isEncoder()) {
                for (String str : mediaCodecInfo.getSupportedTypes()) {
                    TPMediaDecoderInfo tPMediaDecoderInfo = new TPMediaDecoderInfo(str, mediaCodecInfo.getName(), mediaCodecInfo.getCapabilitiesForType(str));
                    if (tPMediaDecoderInfo.isValidDecoder()) {
                        TPNativeLog.printLog(2, "MediaCodecList codecName " + mediaCodecInfo.getName() + " supportedType " + str);
                        arrayList.add(tPMediaDecoderInfo);
                    }
                }
            }
        }
        return (TPMediaDecoderInfo[]) arrayList.toArray(new TPMediaDecoderInfo[arrayList.size()]);
    }

    public static final synchronized TPMediaDecoderInfo[] getTPMediaDecoderInfos(LocalCache localCache) {
        synchronized (TPMediaDecoderList.class) {
            if (sDecoderInfos == null) {
                sDecoderInfos = initCodecList(localCache);
            }
            TPMediaDecoderInfo[] tPMediaDecoderInfoArr = sDecoderInfos;
            if (tPMediaDecoderInfoArr == null) {
                TPMediaDecoderInfo[] tPMediaDecoderInfoArr2 = new TPMediaDecoderInfo[0];
                return tPMediaDecoderInfoArr2;
            }
            TPMediaDecoderInfo[] tPMediaDecoderInfoArr3 = (TPMediaDecoderInfo[]) Arrays.copyOf(tPMediaDecoderInfoArr, tPMediaDecoderInfoArr.length);
            return tPMediaDecoderInfoArr3;
        }
    }

    private static final TPMediaDecoderInfo[] initCodecList(LocalCache localCache) {
        TPMediaDecoderInfo[] localCacheMediaCodecList = getLocalCacheMediaCodecList(localCache);
        if (localCacheMediaCodecList != null) {
            return localCacheMediaCodecList;
        }
        TPMediaDecoderInfo[] systemMediaCodecList = getSystemMediaCodecList();
        storeLocalCacheMediaCodecList(localCache, systemMediaCodecList);
        return systemMediaCodecList;
    }

    private static final void storeLocalCacheMediaCodecList(LocalCache localCache, TPMediaDecoderInfo[] tPMediaDecoderInfoArr) {
        TPNativeLog.printLog(2, "storeLocalCacheMediaCodecList");
        cacheDecoderInfos(localCache, tPMediaDecoderInfoArr);
        cacheVersion(localCache, buildCacheDecoderVersion());
    }
}
