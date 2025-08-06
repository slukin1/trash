package com.tencent.ugc.decoder;

import android.media.MediaCodec;
import android.text.TextUtils;
import com.tencent.liteav.base.storage.PersistStorage;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.l;
import com.tencent.ugc.videobase.base.VideoPersistStorageKey;

public class DecodeAbilityProvider {
    private static final String TAG = "DecodeAbilityProvider";
    private final l mAsyncRunner;

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final DecodeAbilityProvider f50325a = new DecodeAbilityProvider();
    }

    public static DecodeAbilityProvider getInstance() {
        return a.f50325a;
    }

    private int getMediaCodecSupportColorFormat(String str) {
        int i11;
        int i12 = 0;
        try {
            int[] iArr = MediaCodec.createDecoderByType(str).getCodecInfo().getCapabilitiesForType(str).colorFormats;
            int length = iArr.length;
            int i13 = 0;
            while (true) {
                i11 = 21;
                if (i13 >= length) {
                    i11 = 0;
                    break;
                }
                int i14 = iArr[i13];
                if (i14 == 19) {
                    i11 = 19;
                    break;
                } else if (i14 == 21) {
                    break;
                } else {
                    i13++;
                }
            }
            try {
                LiteavLog.i(TAG, "decoder(%s) support color format %d ", str, Integer.valueOf(i11));
                return i11;
            } catch (Throwable th2) {
                th = th2;
                i12 = i11;
            }
        } catch (Throwable th3) {
            th = th3;
            LiteavLog.e(TAG, "get support color format error ", th);
            return i12;
        }
    }

    /* access modifiers changed from: private */
    public void updateDecoderAbility() {
        PersistStorage persistStorage = new PersistStorage(PersistStorage.GLOBAL_DOMAIN);
        int mediaCodecSupportColorFormat = getMediaCodecSupportColorFormat("video/avc");
        if (mediaCodecSupportColorFormat > 0) {
            persistStorage.put(VideoPersistStorageKey.CONFIG_KEY_LOCAL_DECODER_AVC_COLOR_FORMAT, mediaCodecSupportColorFormat);
        }
        int mediaCodecSupportColorFormat2 = getMediaCodecSupportColorFormat("video/hevc");
        if (mediaCodecSupportColorFormat2 > 0) {
            persistStorage.put(VideoPersistStorageKey.CONFIG_KEY_LOCAL_DECODER_HEVC_COLOR_FORMAT, mediaCodecSupportColorFormat2);
        }
        persistStorage.commit();
    }

    public int getSupportColorFormat(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        PersistStorage persistStorage = new PersistStorage(PersistStorage.GLOBAL_DOMAIN);
        Integer num = null;
        if (str.equals("video/avc")) {
            num = persistStorage.getInt(VideoPersistStorageKey.CONFIG_KEY_LOCAL_DECODER_AVC_COLOR_FORMAT);
        } else if (str.equals("video/hevc")) {
            num = persistStorage.getInt(VideoPersistStorageKey.CONFIG_KEY_LOCAL_DECODER_HEVC_COLOR_FORMAT);
        }
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    private DecodeAbilityProvider() {
        l lVar = new l();
        this.mAsyncRunner = lVar;
        lVar.a(a.a(this));
    }
}
