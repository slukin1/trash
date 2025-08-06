package com.tencent.ugc.videobase.utils;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HardwareDecoderMediaFormatBuilder {
    private static final String TAG = "HardwareDecoderMediaFormatBuilder";
    private ChipBrand mChipBrand;
    private int mHeight;
    private boolean mIsLowLatencyDecodeEnabled;
    private JSONArray mMediaCodecDeviceRelatedParams;
    private MediaFormat mMediaFormat;
    private String mMimeType;
    private int mWidth;

    /* renamed from: com.tencent.ugc.videobase.utils.HardwareDecoderMediaFormatBuilder$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f50862a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.tencent.ugc.videobase.utils.HardwareDecoderMediaFormatBuilder$ChipBrand[] r0 = com.tencent.ugc.videobase.utils.HardwareDecoderMediaFormatBuilder.ChipBrand.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f50862a = r0
                com.tencent.ugc.videobase.utils.HardwareDecoderMediaFormatBuilder$ChipBrand r1 = com.tencent.ugc.videobase.utils.HardwareDecoderMediaFormatBuilder.ChipBrand.kQcom     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f50862a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.tencent.ugc.videobase.utils.HardwareDecoderMediaFormatBuilder$ChipBrand r1 = com.tencent.ugc.videobase.utils.HardwareDecoderMediaFormatBuilder.ChipBrand.kHisi     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f50862a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.tencent.ugc.videobase.utils.HardwareDecoderMediaFormatBuilder$ChipBrand r1 = com.tencent.ugc.videobase.utils.HardwareDecoderMediaFormatBuilder.ChipBrand.kExynos     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f50862a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.tencent.ugc.videobase.utils.HardwareDecoderMediaFormatBuilder$ChipBrand r1 = com.tencent.ugc.videobase.utils.HardwareDecoderMediaFormatBuilder.ChipBrand.kAmlogic     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.ugc.videobase.utils.HardwareDecoderMediaFormatBuilder.AnonymousClass1.<clinit>():void");
        }
    }

    public enum ChipBrand {
        kUnKnown,
        kQcom,
        kHisi,
        kExynos,
        kAmlogic
    }

    public HardwareDecoderMediaFormatBuilder() {
        ChipBrand chipBrand = ChipBrand.kUnKnown;
        this.mChipBrand = chipBrand;
        ChipBrand chipBrandBySupportedCodecs = getChipBrandBySupportedCodecs();
        this.mChipBrand = chipBrandBySupportedCodecs == chipBrand ? getChipBrandBySystemInfo() : chipBrandBySupportedCodecs;
        LiteavLog.i(TAG, "hardware name:" + LiteavSystemInfo.getHardware().toLowerCase() + " chip brand:" + this.mChipBrand);
    }

    private void configLowLatency(MediaFormat mediaFormat) {
        int systemOSVersionInt = LiteavSystemInfo.getSystemOSVersionInt();
        if (systemOSVersionInt >= 30 && this.mChipBrand != ChipBrand.kHisi) {
            mediaFormat.setInteger("low-latency", 1);
        }
        if (systemOSVersionInt > 23 || !LiteavSystemInfo.getManufacturer().toLowerCase().contains("xiaomi")) {
            mediaFormat.setInteger("vdec-lowlatency", 1);
        }
        if (systemOSVersionInt >= 26) {
            configVendorLowLatencyAfterApi26(mediaFormat);
        }
    }

    private void configVendorLowLatencyAfterApi26(MediaFormat mediaFormat) {
        int i11 = AnonymousClass1.f50862a[this.mChipBrand.ordinal()];
        if (i11 == 1) {
            mediaFormat.setInteger("vendor.qti-ext-dec-low-latency.enable", 1);
            mediaFormat.setInteger("vendor.qti-ext-dec-picture-order.enable", 1);
        } else if (i11 == 2) {
            mediaFormat.setInteger("vendor.hisi-ext-low-latency-video-dec.video-scene-for-low-latency-req", 1);
            mediaFormat.setInteger("vendor.hisi-ext-low-latency-video-dec.video-scene-for-low-latency-rdy", -1);
        } else if (i11 == 3) {
            mediaFormat.setInteger("vendor.rtc-ext-dec-low-latency.enable", 1);
        } else if (i11 == 4) {
            mediaFormat.setInteger("vendor.low-latency.enable", 1);
        }
    }

    private static void fillDeviceRelatedDecodeParams(MediaFormat mediaFormat, JSONArray jSONArray) {
        if (jSONArray != null) {
            int i11 = 0;
            while (i11 < jSONArray.length()) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i11);
                    mediaFormat.setInteger(jSONObject.optString("key"), jSONObject.optInt("value"));
                    i11++;
                } catch (JSONException e11) {
                    LiteavLog.e(TAG, "set MediaCodec device related params failed.", (Throwable) e11);
                    return;
                }
            }
        }
    }

    private ChipBrand getChipBrandBySupportedCodecs() {
        if (LiteavSystemInfo.getSystemOSVersionInt() < 21) {
            return ChipBrand.kUnKnown;
        }
        try {
            int i11 = 0;
            MediaCodecInfo[] codecInfos = new MediaCodecList(0).getCodecInfos();
            int length = codecInfos.length;
            while (i11 < length) {
                String lowerCase = codecInfos[i11].getName().toLowerCase();
                if (lowerCase.contains("hisi")) {
                    return ChipBrand.kHisi;
                }
                if (lowerCase.contains("amlogic")) {
                    return ChipBrand.kAmlogic;
                }
                if (!lowerCase.contains("qcom")) {
                    if (!lowerCase.contains("qti")) {
                        i11++;
                    }
                }
                return ChipBrand.kQcom;
            }
        } catch (Throwable th2) {
            LiteavLog.e(TAG, "get mediacode info error:" + th2.getMessage());
        }
        return ChipBrand.kUnKnown;
    }

    private ChipBrand getChipBrandBySystemInfo() {
        String lowerCase = LiteavSystemInfo.getHardware().toLowerCase();
        if (lowerCase.contains("qcom")) {
            return ChipBrand.kQcom;
        }
        if (lowerCase.contains("kirin")) {
            return ChipBrand.kHisi;
        }
        if (lowerCase.contains("exynos")) {
            return ChipBrand.kExynos;
        }
        return ChipBrand.kUnKnown;
    }

    private MediaFormat getMediaFormatForConfigure() {
        MediaFormat mediaFormat = this.mMediaFormat;
        return mediaFormat == null ? MediaFormat.createVideoFormat(this.mMimeType, this.mWidth, this.mHeight) : mediaFormat;
    }

    public MediaFormat build() {
        MediaFormat mediaFormatForConfigure = getMediaFormatForConfigure();
        if (this.mIsLowLatencyDecodeEnabled) {
            configLowLatency(mediaFormatForConfigure);
        }
        fillDeviceRelatedDecodeParams(mediaFormatForConfigure, this.mMediaCodecDeviceRelatedParams);
        return mediaFormatForConfigure;
    }

    public HardwareDecoderMediaFormatBuilder setHeight(int i11) {
        this.mHeight = i11;
        return this;
    }

    public HardwareDecoderMediaFormatBuilder setIsLowLatencyDecodeEnabled(boolean z11) {
        this.mIsLowLatencyDecodeEnabled = z11;
        return this;
    }

    public HardwareDecoderMediaFormatBuilder setMediaCodecDeviceRelatedParams(JSONArray jSONArray) {
        this.mMediaCodecDeviceRelatedParams = jSONArray;
        return this;
    }

    public HardwareDecoderMediaFormatBuilder setMediaFormat(MediaFormat mediaFormat) {
        this.mMediaFormat = mediaFormat;
        return this;
    }

    public HardwareDecoderMediaFormatBuilder setMimeType(String str) {
        this.mMimeType = str;
        return this;
    }

    public HardwareDecoderMediaFormatBuilder setWidth(int i11) {
        this.mWidth = i11;
        return this;
    }
}
