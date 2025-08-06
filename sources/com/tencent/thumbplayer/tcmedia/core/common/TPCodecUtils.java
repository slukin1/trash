package com.tencent.thumbplayer.tcmedia.core.common;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.exoplayer2.util.MimeTypes;
import com.tencent.thumbplayer.tcmedia.core.common.TPCodecCapability;
import com.tencent.thumbplayer.tcmedia.core.common.TPMediaDecoderInfo;
import com.tencent.thumbplayer.tcmedia.core.thirdparties.LocalCache;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class TPCodecUtils {
    public static final int CAP_AUDIO_AAC = 8;
    public static final int CAP_AUDIO_DD = 16;
    public static final int CAP_AUDIO_DDP = 32;
    public static final int CAP_AUDIO_DTS = 128;
    public static final int CAP_AUDIO_FLAC = 64;
    public static final int CAP_VIDEO_AVC = 1;
    public static final int CAP_VIDEO_HEVC = 2;
    public static final int CAP_VIDEO_VP8 = 256;
    public static final int CAP_VIDEO_VP9 = 4;
    public static final int PLAYER_LEVEL_0 = 0;
    public static final int PLAYER_LEVEL_1 = 1;
    public static final int PLAYER_LEVEL_11 = 11;
    public static final int PLAYER_LEVEL_16 = 16;
    public static final int PLAYER_LEVEL_21 = 21;
    public static final int PLAYER_LEVEL_26 = 26;
    public static final int PLAYER_LEVEL_28 = 28;
    public static final int PLAYER_LEVEL_33 = 33;
    public static final int PLAYER_LEVEL_6 = 6;
    public static final int PLAYER_LEVEL_UNKNOWN = -1;
    private static final String TAG = "TPCodecUtils";
    private static final String VVC_SHD_HISI_CPU_NAME = "Kirin9000E";
    private static final String VVC_SHD_MTK_CPU_NAME = "MT6893";
    private static final String VVC_SHD_QUALCOMMN_CPU_NAME = "SM8250";
    private static final String VVC_SHD_SAMSUNG_CPU_NAME = "Exynos2100";
    private static int mAACMaxSupportedBitrate = 510000;
    private static int mAACMaxSupportedChannels = 8;
    private static int mAACMaxSupportedSamplerate = 96000;
    private static ArrayList<String> mAMediaCodecBlackListInstance = new ArrayList<>();
    private static ArrayList<String> mAMediaCodecBlackListModel = new ArrayList<>();
    public static ArrayList<String> mAMediaCodecCapList = new ArrayList<>();
    private static TPCodecCapability.TPCodecMaxCapability mAV1SWMaxCapability = new TPCodecCapability.TPCodecMaxCapability(0, 0, 0, 30);
    private static TPCodecCapability.TPCodecMaxCapability mAVCSWMaxCapability = new TPCodecCapability.TPCodecMaxCapability(0, 0, 0, 30);
    private static TPCodecCapability.TPCodecMaxCapability mAVS3WMaxCapability = new TPCodecCapability.TPCodecMaxCapability(0, 0, 0, 30);
    private static HashMap<String, String> mAudioMaxCapCodecInstance = new HashMap<>();
    private static int mAvs3DeviceLevel = -1;
    private static HashMap<String, Integer> mCodecCapBlackList = null;
    private static HashMap<String, Integer> mCodecCapWhiteList = null;
    private static Context mContext = null;
    private static int mDDPMaxSupportedBitrate = 6144000;
    private static int mDDPMaxSupportedChannels = 8;
    private static int mDDPMaxSupportedSamplerate = 48000;
    private static HashMap<DefinitionName, Integer> mDefinitionNameToDecodeLevelTable = new HashMap<>();
    private static HashMap<Integer, ArrayList<String>> mDrmL1BlackList = new HashMap<>();
    private static int mFLACMaxSupportedBitrate = 21000000;
    private static int mFLACMaxSupportedChannels = 8;
    private static int mFLACMaxSupportedSamplerate = 192000;
    private static int mFhdAvs3HisiIndex = 14;
    private static int mFhdAvs3QualcommIndex = 58;
    private static HashMap<Integer, ArrayList<TPCodecCapability.TPHdrSupportVersionRange>> mHDRTypeToHDRHardwareCodecWhiteListMap = new HashMap<>();
    private static HashMap<Integer, ArrayList<TPCodecCapability.TPHdrSupportVersionRange>> mHDRTypeToHDRSoftwareCodecWhiteListMap = new HashMap<>();
    private static HashMap<String, TPCodecCapability.TPHdrSupportVersionRange> mHDRVividSupportVersionMap = new HashMap<>();
    private static TPCodecCapability.TPCodecMaxCapability mHEVCSWMaxCapability = new TPCodecCapability.TPCodecMaxCapability(0, 0, 0, 30);
    private static int mHdHevcHisiIndex = 3;
    private static int mHdHevcMtkIndex = 8;
    private static int mHdHevcQualcommIndex = 20;
    private static int mHdHevcSamsungIndex = 5;
    private static HashMap<Integer, HashMap<String, TPCodecCapability.TPHdrSupportVersionRange>> mHdrBlackMap = new HashMap<>();
    private static HashMap<Integer, HashMap<String, TPCodecCapability.TPHdrSupportVersionRange>> mHdrWhiteMap = new HashMap<>();
    private static int mHevcDeviceLevel = -1;
    private static boolean mIsFFmpegCapGot = false;
    /* access modifiers changed from: private */
    public static boolean mIsInitDone = false;
    private static LocalCache mLocalCache = null;
    private static HashMap<Integer, TPCodecCapability.TPCodecMaxCapability> mMaxACodecHwCapabilityMap = new HashMap<>();
    private static HashMap<Integer, TPCodecCapability.TPCodecMaxCapability> mMaxACodecSwCapabilityMap = new HashMap<>();
    private static HashMap<Integer, TPCodecCapability.TPCodecMaxCapability> mMaxVCodecHwCapabilityMap = new HashMap<>();
    private static HashMap<Integer, TPCodecCapability.TPCodecMaxCapability> mMaxVCodecSwCapabilityMap = new HashMap<>();
    private static boolean mPreferredSoftwareComponent = false;
    private static int mShdAvs3QualcommIndex = 55;
    private static int mShdHevcHisiIndex = 8;
    private static int mShdHevcMtkIndex = 12;
    private static int mShdHevcQualcommIndex = 32;
    private static int mShdHevcSamsungIndex = 8;
    private static ArrayList<String> mSupportedMediaCodec = new ArrayList<>();
    private static ArrayList<String> mVMediaCodecBlackListModel = new ArrayList<>();
    public static ArrayList<String> mVMediaCodecCapList = new ArrayList<>();
    private static TPCodecCapability.TPCodecMaxCapability mVP8SWMaxCapability = new TPCodecCapability.TPCodecMaxCapability(0, 0, 0, 30);
    private static TPCodecCapability.TPCodecMaxCapability mVP9SWMaxCapability = new TPCodecCapability.TPCodecMaxCapability(0, 0, 0, 30);
    private static TPCodecCapability.TPCodecMaxCapability mVVCSWMaxCapability = new TPCodecCapability.TPCodecMaxCapability(0, 0, 0, 30);
    private static SparseArray<VideoSwCapabilityModel> mVideoCodecIdToSwCapabilityModel = new SparseArray<>();
    private static int mVvcDeviceLevel = -1;
    private static ArrayList<String> mWideVineBlackListModel = new ArrayList<>();

    public enum DefinitionName {
        DEFINITION_720P
    }

    public static class VideoSwCapabilityModel {
        public SparseArray<HashMap<DefinitionName, String>> mCpuProducerToAllDefinitionDecTable;

        public static class Builder {
            private SparseArray<HashMap<DefinitionName, String>> mCpuProducerToAllDefinitionDecCapabilities = new SparseArray<>();

            public Builder addVideoDecCap(int i11, DefinitionName definitionName, String str) {
                HashMap hashMap = this.mCpuProducerToAllDefinitionDecCapabilities.get(i11);
                if (hashMap == null) {
                    hashMap = new HashMap();
                    this.mCpuProducerToAllDefinitionDecCapabilities.put(i11, hashMap);
                }
                hashMap.put(definitionName, str);
                return this;
            }

            public VideoSwCapabilityModel build() {
                VideoSwCapabilityModel videoSwCapabilityModel = new VideoSwCapabilityModel();
                videoSwCapabilityModel.mCpuProducerToAllDefinitionDecTable = this.mCpuProducerToAllDefinitionDecCapabilities;
                return videoSwCapabilityModel;
            }
        }

        private VideoSwCapabilityModel() {
            this.mCpuProducerToAllDefinitionDecTable = new SparseArray<>();
        }
    }

    static {
        HashMap<String, Integer> hashMap = new HashMap<>();
        mCodecCapWhiteList = hashMap;
        hashMap.put("NX511J", 11);
        mCodecCapWhiteList.put("Hi3798MV100", 11);
        mCodecCapWhiteList.put("长虹智能电视", 11);
        mCodecCapWhiteList.put("Android TV on Tcl 901", 11);
        mCodecCapWhiteList.put("xt880b", 11);
        TPNativeLog.printLog(2, TAG, "white list init");
        mSupportedMediaCodec.add("video/avc");
        mSupportedMediaCodec.add("video/hevc");
        mSupportedMediaCodec.add("video/x-vnd.on2.vp8");
        mSupportedMediaCodec.add("video/x-vnd.on2.vp9");
        mSupportedMediaCodec.add("video/av01");
        mSupportedMediaCodec.add(MimeTypes.AUDIO_AAC);
        mSupportedMediaCodec.add(MimeTypes.AUDIO_AC3);
        mSupportedMediaCodec.add(MimeTypes.AUDIO_E_AC3);
        mSupportedMediaCodec.add(MimeTypes.AUDIO_E_AC3_JOC);
        mSupportedMediaCodec.add(MimeTypes.AUDIO_FLAC);
        mSupportedMediaCodec.add(MimeTypes.AUDIO_DTS);
        mAMediaCodecBlackListInstance.add("OMX.qti.audio.decoder.flac");
        mVMediaCodecBlackListModel.add("SM-J7008");
        mVMediaCodecBlackListModel.add("SM-J5008");
        mVMediaCodecBlackListModel.add("TCL i806");
        mVMediaCodecBlackListModel.add("NX511J");
        mVMediaCodecBlackListModel.add("vivo Y11i T");
        mVMediaCodecBlackListModel.add("长虹智能电视");
        mVMediaCodecBlackListModel.add("MI 1S");
        mVMediaCodecBlackListModel.add("SP9832A");
        mVMediaCodecBlackListModel.add("SP9830A");
        mVMediaCodecBlackListModel.add("VOTO GT17");
        mVMediaCodecBlackListModel.add("EVA-AL10");
        mHDRVividSupportVersionMap.put("TAS-AL00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100165, 99, 3));
        mHDRVividSupportVersionMap.put("TAS-TL00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100165, 99, 3));
        mHDRVividSupportVersionMap.put("TAS-AN00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100165, 99, 3));
        mHDRVividSupportVersionMap.put("LIO-AN00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100165, 99, 3));
        mHDRVividSupportVersionMap.put("LIO-AN00P", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100165, 99, 3));
        mHDRVividSupportVersionMap.put("LIO-AN00m", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100165, 99, 3));
        mHDRVividSupportVersionMap.put("LIO-TL00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100165, 99, 3));
        mHDRVividSupportVersionMap.put("LIO-AL00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100165, 99, 3));
        mHDRVividSupportVersionMap.put("ANA-AN00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100165, 99, 3));
        mHDRVividSupportVersionMap.put("ANA-TN00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100165, 99, 3));
        mHDRVividSupportVersionMap.put("ELS-AN00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100165, 99, 3));
        mHDRVividSupportVersionMap.put("ELS-TN00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100165, 99, 3));
        mHDRVividSupportVersionMap.put("ELS-AN10", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100166, 99, 3));
        mHDRVividSupportVersionMap.put("MRX-AL09", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100150, 99, 5));
        mHDRVividSupportVersionMap.put("MRX-AL19", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100150, 99, 5));
        mHDRVividSupportVersionMap.put("MRX-W09", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100150, 99, 5));
        mHDRVividSupportVersionMap.put("MRX-W19", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100150, 99, 5));
        mHDRVividSupportVersionMap.put("MRX-AN19", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100150, 99, 5));
        mHDRVividSupportVersionMap.put("MRX-W29", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100150, 99, 5));
        mHDRVividSupportVersionMap.put("MRX-W39", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100150, 99, 5));
        mHDRVividSupportVersionMap.put("OCE-AN00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 0, 99, 0));
        mHDRVividSupportVersionMap.put("OCE-AN10", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 0, 99, 0));
        mHDRVividSupportVersionMap.put("OCE-AL50", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 0, 99, 0));
        mHDRVividSupportVersionMap.put("OCE-AN50", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 0, 99, 0));
        mHDRVividSupportVersionMap.put("NOH-NX9", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 0, 99, 0));
        mHDRVividSupportVersionMap.put("NOH-AN00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 0, 99, 0));
        mHDRVividSupportVersionMap.put("NOH-AN01", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 0, 99, 0));
        mHDRVividSupportVersionMap.put("NOH-AL00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 0, 99, 0));
        mHDRVividSupportVersionMap.put("NOP-AN00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 0, 99, 0));
        mHDRVividSupportVersionMap.put("JAD-AN00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 0, 99, 0));
        mHDRVividSupportVersionMap.put("JAD-AN10", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 0, 99, 0));
        mHDRVividSupportVersionMap.put("JAD-AL50", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 0, 99, 0));
        mHDRVividSupportVersionMap.put("JAD-AL60", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 0, 99, 0));
        mHDRVividSupportVersionMap.put("JAD-N29", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 0, 99, 0));
        mHDRVividSupportVersionMap.put("JAD-N09", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 0, 99, 0));
        mHDRVividSupportVersionMap.put("HEGE-550", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 200187, 99, 0));
        mHDRVividSupportVersionMap.put("HEGE-550B", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 200187, 99, 0));
        mHDRVividSupportVersionMap.put("HEGE-550C", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 200187, 99, 0));
        mHDRVividSupportVersionMap.put("HEGE-550X", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 200187, 99, 0));
        mHDRVividSupportVersionMap.put("HEGE-550AX", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 200187, 99, 0));
        mHDRVividSupportVersionMap.put("HEGE-560", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 200187, 99, 0));
        mHDRVividSupportVersionMap.put("HEGE-560B", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 200187, 99, 0));
        mHDRVividSupportVersionMap.put("HEGE-570", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 200187, 99, 0));
        mHDRVividSupportVersionMap.put("PLAT-760", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 200172, 99, 0));
        mHDRVividSupportVersionMap.put("KANT-350", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 200185, 99, 0));
        mHDRVividSupportVersionMap.put("KANT-350B", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 200185, 99, 0));
        mHDRVividSupportVersionMap.put("KANT-350C", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 200185, 99, 0));
        mHDRVividSupportVersionMap.put("KANT-350S", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 200185, 99, 0));
        mHDRVividSupportVersionMap.put("KANT-360", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 200185, 99, 0));
        mHDRVividSupportVersionMap.put("KANT-360S", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 200185, 99, 0));
        mHDRVividSupportVersionMap.put("KANT-370", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 200185, 99, 0));
        mHDRVividSupportVersionMap.put("KANT-370S", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 200185, 99, 0));
        mHDRVividSupportVersionMap.put("KANT-359", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 200183, 99, 0));
        mHDRVividSupportVersionMap.put("KANT-369", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 200183, 99, 0));
        mHDRVividSupportVersionMap.put("THAL-550", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 0, 99, 0));
        mHDRVividSupportVersionMap.put("THAL-560", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 0, 99, 0));
        mHDRVividSupportVersionMap.put("THAL-570", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 0, 99, 0));
        mHDRVividSupportVersionMap.put("THAL-580", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 0, 99, 0));
        mHDRVividSupportVersionMap.put("FREG-770", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 0, 99, 0));
        mHDRVividSupportVersionMap.put("DESC-220", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 0, 99, 0));
        mHDRVividSupportVersionMap.put("DESC-250SY", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 10200557, 99, 0));
        mHDRVividSupportVersionMap.put("DESC-250S", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 10200557, 99, 0));
        mHDRVividSupportVersionMap.put("DESC-250SZ", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 10200557, 99, 0));
        mHDRVividSupportVersionMap.put("DESC-250", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 10200557, 99, 0));
        mHDRVividSupportVersionMap.put("DESC-260SY", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 10200557, 99, 0));
        mHDRVividSupportVersionMap.put("DESC-260S", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 10200557, 99, 0));
        mHDRVividSupportVersionMap.put("DESC-260SZ", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 10200557, 99, 0));
        mHDRVividSupportVersionMap.put("DESC-260", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 10200557, 99, 0));
        mHDRVividSupportVersionMap.put("DESC-270", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 10200547, 99, 0));
        mHDRVividSupportVersionMap.put("SOKR-790A", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 0, 99, 0));
        mHDRVividSupportVersionMap.put("VOLT-350S", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 0, 99, 0));
        mWideVineBlackListModel.add("RVL-AL09");
        mWideVineBlackListModel.add("CLT-L29");
        mWideVineBlackListModel.add("ASUS_Z00AD");
        mDrmL1BlackList.put(0, mWideVineBlackListModel);
        SparseArray<VideoSwCapabilityModel> sparseArray = mVideoCodecIdToSwCapabilityModel;
        VideoSwCapabilityModel.Builder builder = new VideoSwCapabilityModel.Builder();
        DefinitionName definitionName = DefinitionName.DEFINITION_720P;
        sparseArray.put(193, builder.addVideoDecCap(0, definitionName, VVC_SHD_QUALCOMMN_CPU_NAME).addVideoDecCap(1, definitionName, VVC_SHD_MTK_CPU_NAME).addVideoDecCap(2, definitionName, VVC_SHD_HISI_CPU_NAME).addVideoDecCap(3, definitionName, VVC_SHD_SAMSUNG_CPU_NAME).build());
        mDefinitionNameToDecodeLevelTable.put(definitionName, 21);
    }

    public static boolean addDRMLevel1Blacklist(int i11) {
        if (!mDrmL1BlackList.containsKey(Integer.valueOf(i11))) {
            return true;
        }
        ArrayList arrayList = mDrmL1BlackList.get(Integer.valueOf(i11));
        if (!arrayList.contains(TPSystemInfo.getDeviceName())) {
            arrayList.add(TPSystemInfo.getDeviceName());
        }
        mDrmL1BlackList.remove(Integer.valueOf(i11));
        mDrmL1BlackList.put(Integer.valueOf(i11), arrayList);
        return true;
    }

    public static boolean addHDRBlackList(int i11, String str, TPCodecCapability.TPHdrSupportVersionRange tPHdrSupportVersionRange) {
        HashMap hashMap;
        if (tPHdrSupportVersionRange == null) {
            return false;
        }
        if (mHdrBlackMap.containsKey(Integer.valueOf(i11))) {
            hashMap = mHdrBlackMap.get(Integer.valueOf(i11));
            mHdrBlackMap.remove(Integer.valueOf(i11));
            if (!hashMap.containsKey(str)) {
                hashMap.put(str, tPHdrSupportVersionRange);
            }
            hashMap.remove(str);
        } else {
            hashMap = new HashMap();
        }
        hashMap.put(str, tPHdrSupportVersionRange);
        mHdrBlackMap.put(Integer.valueOf(i11), hashMap);
        return true;
    }

    private static void addHDRVersionRangeToWhiteList(int i11, TPCodecCapability.TPHdrSupportVersionRange tPHdrSupportVersionRange, HashMap<Integer, ArrayList<TPCodecCapability.TPHdrSupportVersionRange>> hashMap) {
        ArrayList arrayList = hashMap.containsKey(Integer.valueOf(i11)) ? hashMap.get(Integer.valueOf(i11)) : new ArrayList();
        int i12 = 0;
        while (i12 < arrayList.size()) {
            if (!isTheSameVersionRange(tPHdrSupportVersionRange, (TPCodecCapability.TPHdrSupportVersionRange) arrayList.get(i12))) {
                i12++;
            } else {
                return;
            }
        }
        arrayList.add(tPHdrSupportVersionRange);
        hashMap.put(Integer.valueOf(i11), arrayList);
    }

    public static boolean addHDRVideoDecoderTypeWhiteList(int i11, int i12, TPCodecCapability.TPHdrSupportVersionRange tPHdrSupportVersionRange) {
        HashMap<Integer, ArrayList<TPCodecCapability.TPHdrSupportVersionRange>> hashMap;
        if (i12 == 101) {
            hashMap = mHDRTypeToHDRSoftwareCodecWhiteListMap;
        } else if (i12 != 102) {
            TPNativeLog.printLog(3, TAG, "addHDRVideoDecoderTypeWhiteList, decoder not support.");
            return false;
        } else {
            hashMap = mHDRTypeToHDRHardwareCodecWhiteListMap;
        }
        addHDRVersionRangeToWhiteList(i11, tPHdrSupportVersionRange, hashMap);
        return true;
    }

    public static boolean addHDRWhiteList(int i11, String str, TPCodecCapability.TPHdrSupportVersionRange tPHdrSupportVersionRange) {
        HashMap hashMap;
        if (tPHdrSupportVersionRange == null) {
            return false;
        }
        if (mHdrWhiteMap.containsKey(Integer.valueOf(i11))) {
            hashMap = mHdrWhiteMap.get(Integer.valueOf(i11));
            mHdrWhiteMap.remove(Integer.valueOf(i11));
            if (!hashMap.containsKey(str)) {
                hashMap.put(str, tPHdrSupportVersionRange);
            }
            hashMap.remove(str);
        } else {
            hashMap = new HashMap();
        }
        hashMap.put(str, tPHdrSupportVersionRange);
        mHdrWhiteMap.put(Integer.valueOf(i11), hashMap);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x012f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean checkHDRVividSupportByVersion(java.lang.String r13, java.lang.String r14, java.lang.String r15) {
        /*
            java.lang.String r0 = "."
            r1 = 4
            int[] r2 = new int[r1]
            r2 = {2, 1, 1, 3} // fill-array
            boolean r3 = android.text.TextUtils.isEmpty(r14)
            r4 = 3
            java.lang.String r5 = "TPCodecUtils"
            r6 = -1
            r7 = 2
            r8 = 1
            r9 = 0
            if (r3 != 0) goto L_0x00c4
            java.lang.String r3 = "\\."
            java.lang.String[] r3 = r14.split(r3)
            int r10 = r3.length
            if (r10 != r1) goto L_0x00c4
            r10 = r3[r9]
            java.lang.String r11 = " "
            java.lang.String[] r10 = r10.split(r11)
            int r11 = r10.length
            if (r11 != r7) goto L_0x0031
            r11 = r10[r8]
            if (r11 == 0) goto L_0x0031
            r10 = r10[r8]
            r3[r9] = r10
        L_0x0031:
            r10 = r3[r4]
            java.lang.String r11 = "\\("
            java.lang.String[] r10 = r10.split(r11)
            int r11 = r10.length
            if (r11 != r7) goto L_0x0044
            r11 = r10[r9]
            if (r11 == 0) goto L_0x0044
            r10 = r10[r9]
            r3[r4] = r10
        L_0x0044:
            r10 = r9
        L_0x0045:
            if (r10 >= r1) goto L_0x005b
            r11 = r3[r10]
            if (r11 == 0) goto L_0x0059
            r11 = r3[r10]
            int r11 = r11.length()
            r12 = r2[r10]
            if (r11 == r12) goto L_0x0056
            goto L_0x0059
        L_0x0056:
            int r10 = r10 + 1
            goto L_0x0045
        L_0x0059:
            r2 = r9
            goto L_0x005c
        L_0x005b:
            r2 = r8
        L_0x005c:
            if (r2 == 0) goto L_0x00c4
            int r2 = r14.indexOf(r0)     // Catch:{ NumberFormatException -> 0x009e }
            if (r2 != r6) goto L_0x0066
            r3 = r9
            goto L_0x006c
        L_0x0066:
            int r3 = r2 + -2
            int r3 = getValueFromSubstring(r14, r3, r2)     // Catch:{ NumberFormatException -> 0x009e }
        L_0x006c:
            int r2 = r2 + r8
            int r2 = r14.indexOf(r0, r2)     // Catch:{ NumberFormatException -> 0x009a }
            if (r2 != r6) goto L_0x0075
            r10 = r9
            goto L_0x007b
        L_0x0075:
            int r10 = r2 + -1
            int r10 = getValueFromSubstring(r14, r10, r2)     // Catch:{ NumberFormatException -> 0x009a }
        L_0x007b:
            int r2 = r2 + r8
            int r0 = r14.indexOf(r0, r2)     // Catch:{ NumberFormatException -> 0x0097 }
            if (r0 != r6) goto L_0x0084
            r2 = r9
            goto L_0x008a
        L_0x0084:
            int r2 = r0 + -1
            int r2 = getValueFromSubstring(r14, r2, r0)     // Catch:{ NumberFormatException -> 0x0097 }
        L_0x008a:
            if (r0 != r6) goto L_0x008d
            goto L_0x00b7
        L_0x008d:
            int r11 = r0 + 1
            int r0 = r0 + r1
            int r14 = getValueFromSubstring(r14, r11, r0)     // Catch:{ NumberFormatException -> 0x0095 }
            goto L_0x00b8
        L_0x0095:
            r14 = move-exception
            goto L_0x00a2
        L_0x0097:
            r14 = move-exception
            r2 = r9
            goto L_0x00a2
        L_0x009a:
            r14 = move-exception
            r2 = r9
            r10 = r2
            goto L_0x00a2
        L_0x009e:
            r14 = move-exception
            r2 = r9
            r3 = r2
            r10 = r3
        L_0x00a2:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r11 = "checkHDRVividSupportByVersion failed(versionValue):"
            r0.<init>(r11)
            java.lang.String r14 = r14.getMessage()
            r0.append(r14)
            java.lang.String r14 = r0.toString()
            com.tencent.thumbplayer.tcmedia.core.common.TPNativeLog.printLog(r1, r5, r14)
        L_0x00b7:
            r14 = r9
        L_0x00b8:
            r0 = 100000(0x186a0, float:1.4013E-40)
            int r3 = r3 * r0
            int r10 = r10 * 10000
            int r3 = r3 + r10
            int r2 = r2 * 1000
            int r3 = r3 + r2
            int r3 = r3 + r14
            goto L_0x00c5
        L_0x00c4:
            r3 = r9
        L_0x00c5:
            boolean r14 = android.text.TextUtils.isEmpty(r15)
            if (r14 != 0) goto L_0x0106
            java.lang.String r14 = "patch"
            java.lang.String[] r0 = r15.split(r14)
            int r2 = r0.length
            if (r2 != r7) goto L_0x0106
            r2 = r0[r8]
            if (r2 == 0) goto L_0x0106
            r0 = r0[r8]
            int r0 = r0.length()
            if (r0 != r4) goto L_0x0106
            int r14 = r15.indexOf(r14)     // Catch:{ NumberFormatException -> 0x00f0 }
            if (r14 != r6) goto L_0x00e7
            goto L_0x0106
        L_0x00e7:
            int r0 = r14 + 5
            int r14 = r14 + 7
            int r14 = getValueFromSubstring(r15, r0, r14)     // Catch:{ NumberFormatException -> 0x00f0 }
            goto L_0x0107
        L_0x00f0:
            r14 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "checkHDRVividSupportByVersion failed(patchValue):"
            r0.<init>(r2)
            java.lang.String r14 = r14.getMessage()
            r0.append(r14)
            java.lang.String r14 = r0.toString()
            com.tencent.thumbplayer.tcmedia.core.common.TPNativeLog.printLog(r1, r5, r14)
        L_0x0106:
            r14 = r9
        L_0x0107:
            boolean r0 = isInHDRVividWhiteList(r13, r3, r14)
            java.lang.String r1 = " patch:"
            java.lang.String r2 = " version:"
            if (r0 == 0) goto L_0x012f
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            java.lang.String r0 = "checkHDRVividSupportByVersion in HDRVivid whitelist, model:"
            r14.<init>(r0)
            r14.append(r13)
            r14.append(r2)
            r14.append(r3)
            r14.append(r1)
            r14.append(r15)
            java.lang.String r13 = r14.toString()
            com.tencent.thumbplayer.tcmedia.core.common.TPNativeLog.printLog(r7, r5, r13)
            return r8
        L_0x012f:
            boolean r0 = isInHDRVividBlackList(r13, r3, r14)
            if (r0 == 0) goto L_0x0153
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            java.lang.String r0 = "checkHDRVividSupportByVersion in HDRVivid blacklist, model:"
            r14.<init>(r0)
            r14.append(r13)
            r14.append(r2)
            r14.append(r3)
            r14.append(r1)
            r14.append(r15)
            java.lang.String r13 = r14.toString()
            com.tencent.thumbplayer.tcmedia.core.common.TPNativeLog.printLog(r7, r5, r13)
            return r9
        L_0x0153:
            java.util.HashMap<java.lang.String, com.tencent.thumbplayer.tcmedia.core.common.TPCodecCapability$TPHdrSupportVersionRange> r15 = mHDRVividSupportVersionMap
            boolean r15 = r15.containsKey(r13)
            if (r15 == 0) goto L_0x0177
            java.util.HashMap<java.lang.String, com.tencent.thumbplayer.tcmedia.core.common.TPCodecCapability$TPHdrSupportVersionRange> r15 = mHDRVividSupportVersionMap
            java.lang.Object r13 = r15.get(r13)
            com.tencent.thumbplayer.tcmedia.core.common.TPCodecCapability$TPHdrSupportVersionRange r13 = (com.tencent.thumbplayer.tcmedia.core.common.TPCodecCapability.TPHdrSupportVersionRange) r13
            int r15 = r13.upperboundSystemVersion
            if (r3 > r15) goto L_0x0177
            int r15 = r13.lowerboundSystemVersion
            if (r3 <= r15) goto L_0x016c
            return r8
        L_0x016c:
            if (r3 != r15) goto L_0x0177
            int r15 = r13.upperboundPatchVersion
            if (r14 > r15) goto L_0x0177
            int r13 = r13.lowerboundPatchVersion
            if (r14 < r13) goto L_0x0177
            return r8
        L_0x0177:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.core.common.TPCodecUtils.checkHDRVividSupportByVersion(java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    private static int convertDefinitionNameToDecodeLevel(DefinitionName definitionName) {
        Integer num = mDefinitionNameToDecodeLevelTable.get(definitionName);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    public static int convertDolbyVisionToOmxLevel(int i11) {
        int i12 = 1 << i11;
        if (i12 <= 0 || i12 > 256) {
            TPNativeLog.printLog(2, TAG, "convertDolbyVisionToOmxLevel Unsupported level".concat(String.valueOf(i11)));
            return i11;
        }
        TPNativeLog.printLog(2, TAG, "convertDolbyVisionToOmxLevel dolbyVisionLevel:" + i11 + " omxLevel:" + i12);
        return i12;
    }

    public static int convertDolbyVisionToOmxProfile(int i11) {
        int i12 = 1 << i11;
        if (i11 <= 0 || i11 > 512) {
            TPNativeLog.printLog(2, TAG, "convertDolbyVisionToOmxProfile Unsupported profile".concat(String.valueOf(i11)));
            return i11;
        }
        TPNativeLog.printLog(2, TAG, "convertDolbyVisionToOmxProfile dolbyVisionProfile:" + i11 + " omxProfile:" + i12);
        return i12;
    }

    public static synchronized HashMap<Integer, TPCodecCapability.TPCodecMaxCapability> getACodecSWMaxCapabilityMap() {
        synchronized (TPCodecUtils.class) {
            TPNativeLog.printLog(2, TAG, "getACodecSWMaxCapabilityMap func in");
            if (!mMaxACodecSwCapabilityMap.isEmpty()) {
                HashMap<Integer, TPCodecCapability.TPCodecMaxCapability> hashMap = mMaxACodecSwCapabilityMap;
                return hashMap;
            }
            try {
                TPCodecCapability.TPCodecMaxCapability tPCodecMaxCapability = new TPCodecCapability.TPCodecMaxCapability(0, 0, mAACMaxSupportedSamplerate, mAACMaxSupportedBitrate, mAACMaxSupportedChannels);
                TPCodecCapability.TPCodecMaxCapability tPCodecMaxCapability2 = new TPCodecCapability.TPCodecMaxCapability(0, 0, mFLACMaxSupportedSamplerate, mFLACMaxSupportedBitrate, mFLACMaxSupportedChannels);
                TPCodecCapability.TPCodecMaxCapability tPCodecMaxCapability3 = new TPCodecCapability.TPCodecMaxCapability(0, 0, mDDPMaxSupportedSamplerate, mDDPMaxSupportedBitrate, mDDPMaxSupportedChannels);
                TPCodecCapability.TPCodecMaxCapability tPCodecMaxCapability4 = new TPCodecCapability.TPCodecMaxCapability(0, 0, mDDPMaxSupportedSamplerate, mDDPMaxSupportedBitrate, mDDPMaxSupportedChannels);
                mMaxACodecSwCapabilityMap.put(5002, tPCodecMaxCapability);
                mMaxACodecSwCapabilityMap.put(5012, tPCodecMaxCapability2);
                mMaxACodecSwCapabilityMap.put(5003, tPCodecMaxCapability3);
                mMaxACodecSwCapabilityMap.put(5040, tPCodecMaxCapability4);
                TPNativeLog.printLog(2, "getACodecSWMaxCapabilityMap success.");
                HashMap<Integer, TPCodecCapability.TPCodecMaxCapability> hashMap2 = mMaxACodecSwCapabilityMap;
                return hashMap2;
            } catch (Exception unused) {
                TPNativeLog.printLog(4, TAG, "getACodecSWMaxCapabilityMap exception");
                return null;
            }
        }
    }

    public static synchronized HashMap<Integer, TPCodecCapability.TPCodecMaxCapability> getAMediaCodecMaxCapabilityMap() {
        synchronized (TPCodecUtils.class) {
            TPNativeLog.printLog(2, TAG, "getAMediaCodecMaxCapabilityMap func in");
            if (!mMaxACodecHwCapabilityMap.isEmpty()) {
                TPNativeLog.printLog(2, TAG, "return memory stored audio max cap map");
                HashMap<Integer, TPCodecCapability.TPCodecMaxCapability> hashMap = mMaxACodecHwCapabilityMap;
                return hashMap;
            }
            try {
                for (TPMediaDecoderInfo tPMediaDecoderInfo : TPMediaDecoderList.getTPMediaDecoderInfos(mLocalCache)) {
                    String decoderMimeType = tPMediaDecoderInfo.getDecoderMimeType();
                    if (tPMediaDecoderInfo.isAudio() && isSupportedMediaCodec(decoderMimeType) && !isInMediaCodecBlackList(decoderMimeType) && !isAMediaCodecBlackListInstance(tPMediaDecoderInfo.getDecoderName())) {
                        TPNativeLog.printLog(2, TAG, "Audio MimeType: " + decoderMimeType + " codecName: " + tPMediaDecoderInfo.getDecoderName());
                        TPMediaDecoderInfo.DecoderProfileLevel maxProfileLevel = tPMediaDecoderInfo.getMaxProfileLevel();
                        TPCodecCapability.TPCodecMaxCapability tPCodecMaxCapability = new TPCodecCapability.TPCodecMaxCapability(maxProfileLevel.profile, maxProfileLevel.level, tPMediaDecoderInfo.getMaxAudioSampleRate(), tPMediaDecoderInfo.getMaxAudioBitRate(), tPMediaDecoderInfo.getMaxAudioChannels());
                        if (!mMaxACodecHwCapabilityMap.containsKey(Integer.valueOf(getSupportedCodecId(decoderMimeType)))) {
                            TPNativeLog.printLog(2, TAG, "audio codecName: " + tPMediaDecoderInfo.getDecoderName() + " maxSamplerate: " + tPMediaDecoderInfo.getMaxAudioSampleRate() + " maxChannels: " + tPMediaDecoderInfo.getMaxAudioChannels());
                            replace(Integer.valueOf(getSupportedCodecId(decoderMimeType)), tPCodecMaxCapability, mMaxACodecHwCapabilityMap);
                            replace(decoderMimeType, tPMediaDecoderInfo.getDecoderName(), mAudioMaxCapCodecInstance);
                            mAMediaCodecCapList.add(decoderMimeType);
                        } else if (tPMediaDecoderInfo.getMaxAudioSampleRate() > mMaxACodecHwCapabilityMap.get(Integer.valueOf(getSupportedCodecId(decoderMimeType))).maxSampleRate || TextUtils.equals(decoderMimeType, MimeTypes.AUDIO_E_AC3_JOC)) {
                            TPNativeLog.printLog(2, TAG, "audio codecName: " + tPMediaDecoderInfo.getDecoderName() + " maxSamplerate: " + tPMediaDecoderInfo.getMaxAudioSampleRate() + " maxChannels: " + tPMediaDecoderInfo.getMaxAudioChannels());
                            replace(Integer.valueOf(getSupportedCodecId(decoderMimeType)), tPCodecMaxCapability, mMaxACodecHwCapabilityMap);
                            replace(decoderMimeType, tPMediaDecoderInfo.getDecoderName(), mAudioMaxCapCodecInstance);
                        }
                    }
                }
            } catch (Exception e11) {
                TPNativeLog.printLog(4, TAG, "getAMediaCodecMaxCapabilityMap failed:" + e11.getMessage());
            }
            HashMap<Integer, TPCodecCapability.TPCodecMaxCapability> hashMap2 = mMaxACodecHwCapabilityMap;
            return hashMap2;
        }
    }

    public static int getAV1SWDecodeLevel() {
        return getDecodeLevelByCoresAndFreq();
    }

    public static boolean getAudioMediaCodecPassThroughCap(int i11, int i12, int i13) {
        if (i11 != 5004) {
            return false;
        }
        int i14 = 1;
        if (i12 == 20) {
            i14 = 7;
        } else if (i12 == 50 || i12 == 60) {
            i14 = 8;
        }
        return TPAudioPassThroughPluginDetector.isAudioPassThroughSupport(i14, i13);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x005d, code lost:
        if (r1 != 3) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0062, code lost:
        if (r2 >= mFhdAvs3HisiIndex) goto L_0x0075;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getAvs3SWDecodeLevel() {
        /*
            java.lang.String r0 = com.tencent.thumbplayer.tcmedia.core.common.TPSystemInfo.getCpuHarewareName()
            int r1 = com.tencent.thumbplayer.tcmedia.core.common.TPSystemInfo.getCpuHWProducter(r0)
            int r2 = com.tencent.thumbplayer.tcmedia.core.common.TPSystemInfo.getCpuHWProductIndex(r0)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "[getAvs3SWDecodeLevel], mCpuHWProducter = "
            r3.<init>(r4)
            r3.append(r1)
            java.lang.String r4 = ", getMaxCpuFreq() = "
            r3.append(r4)
            long r4 = com.tencent.thumbplayer.tcmedia.core.common.TPSystemInfo.getMaxCpuFreq()
            r3.append(r4)
            java.lang.String r4 = ", numCores = "
            r3.append(r4)
            int r4 = com.tencent.thumbplayer.tcmedia.core.common.TPSystemInfo.getNumCores()
            r3.append(r4)
            java.lang.String r4 = ", mCpuHWProductIdx="
            r3.append(r4)
            r3.append(r2)
            java.lang.String r4 = ", hardware="
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r3 = 2
            java.lang.String r4 = "TPCodecUtils"
            com.tencent.thumbplayer.tcmedia.core.common.TPNativeLog.printLog(r3, r4, r0)
            int r0 = mAvs3DeviceLevel
            r4 = -1
            if (r4 == r0) goto L_0x004e
            return r0
        L_0x004e:
            r0 = 0
            mAvs3DeviceLevel = r0
            if (r4 == r1) goto L_0x0071
            r0 = 26
            if (r1 == 0) goto L_0x0065
            r4 = 1
            if (r1 == r4) goto L_0x0071
            if (r1 == r3) goto L_0x0060
            r0 = 3
            if (r1 == r0) goto L_0x0071
            goto L_0x0077
        L_0x0060:
            int r1 = mFhdAvs3HisiIndex
            if (r2 < r1) goto L_0x0071
            goto L_0x0069
        L_0x0065:
            int r1 = mFhdAvs3QualcommIndex
            if (r2 < r1) goto L_0x006a
        L_0x0069:
            goto L_0x0075
        L_0x006a:
            int r0 = mShdAvs3QualcommIndex
            if (r2 < r0) goto L_0x0071
            r0 = 21
            goto L_0x0075
        L_0x0071:
            int r0 = getDecodeLevelByCoresAndFreq()
        L_0x0075:
            mAvs3DeviceLevel = r0
        L_0x0077:
            int r0 = mAvs3DeviceLevel
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.core.common.TPCodecUtils.getAvs3SWDecodeLevel():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0040, code lost:
        if ((com.tencent.thumbplayer.tcmedia.core.common.TPSystemInfo.getMaxCpuFreq() / 1000) >= 1600) goto L_0x001a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        return 16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0018, code lost:
        if ((com.tencent.thumbplayer.tcmedia.core.common.TPSystemInfo.getMaxCpuFreq() / 1000) >= 1200) goto L_0x001a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002d, code lost:
        if ((com.tencent.thumbplayer.tcmedia.core.common.TPSystemInfo.getMaxCpuFreq() / 1000) >= 1400) goto L_0x001a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int getDecodeLevelByCoresAndFreq() {
        /*
            int r0 = com.tencent.thumbplayer.tcmedia.core.common.TPSystemInfo.getNumCores()
            r1 = 6
            r2 = 21
            r3 = 16
            r4 = 1000(0x3e8, double:4.94E-321)
            r6 = 8
            if (r0 < r6) goto L_0x001e
            long r0 = com.tencent.thumbplayer.tcmedia.core.common.TPSystemInfo.getMaxCpuFreq()
            long r0 = r0 / r4
            r4 = 1200(0x4b0, double:5.93E-321)
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 < 0) goto L_0x001c
        L_0x001a:
            r1 = r2
            goto L_0x0043
        L_0x001c:
            r1 = r3
            goto L_0x0043
        L_0x001e:
            int r0 = com.tencent.thumbplayer.tcmedia.core.common.TPSystemInfo.getNumCores()
            if (r0 < r1) goto L_0x0030
            long r0 = com.tencent.thumbplayer.tcmedia.core.common.TPSystemInfo.getMaxCpuFreq()
            long r0 = r0 / r4
            r4 = 1400(0x578, double:6.917E-321)
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 < 0) goto L_0x001c
            goto L_0x001a
        L_0x0030:
            int r0 = com.tencent.thumbplayer.tcmedia.core.common.TPSystemInfo.getNumCores()
            r6 = 4
            if (r0 < r6) goto L_0x0043
            long r0 = com.tencent.thumbplayer.tcmedia.core.common.TPSystemInfo.getMaxCpuFreq()
            long r0 = r0 / r4
            r4 = 1600(0x640, double:7.905E-321)
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 < 0) goto L_0x001c
            goto L_0x001a
        L_0x0043:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.core.common.TPCodecUtils.getDecodeLevelByCoresAndFreq():int");
    }

    public static synchronized void getDecoderMaxCapabilityMapAsync() {
        synchronized (TPCodecUtils.class) {
            if (mIsInitDone) {
                TPNativeLog.printLog(2, TAG, "decoder capability already init,return directly!");
                return;
            }
            TPNativeLog.printLog(2, TAG, "decoder capability not init,acquire async with create thread!");
            Thread thread = new Thread(new Runnable() {
                public final void run() {
                    TPCodecUtils.getVMediaCodecMaxCapabilityMap();
                    TPCodecUtils.getAMediaCodecMaxCapabilityMap();
                    TPCodecUtils.getVCodecSWMaxCapabilityMap();
                    TPCodecUtils.getACodecSWMaxCapabilityMap();
                    boolean unused = TPCodecUtils.mIsInitDone = true;
                    TPNativeLog.printLog(2, TPCodecUtils.TAG, "new thread getDecoderMaxCapabilityMap done");
                }
            });
            thread.setName("TP_codec_init_thread");
            thread.start();
        }
    }

    public static String getDecoderName(String str, boolean z11) {
        if (!str.contains("audio")) {
            ArrayList arrayList = new ArrayList();
            for (TPMediaDecoderInfo tPMediaDecoderInfo : TPMediaDecoderList.getTPMediaDecoderInfos(mLocalCache)) {
                if (TextUtils.equals(str, tPMediaDecoderInfo.getDecoderMimeType()) && tPMediaDecoderInfo.isSecureDecoder() == z11) {
                    TPNativeLog.printLog(2, TAG, "getDecoderName:" + tPMediaDecoderInfo.getDecoderName());
                    arrayList.add(tPMediaDecoderInfo);
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                TPMediaDecoderInfo tPMediaDecoderInfo2 = (TPMediaDecoderInfo) it2.next();
                if ((tPMediaDecoderInfo2.isVideo() && tPMediaDecoderInfo2.isVideoSofwareDecoder() == mPreferredSoftwareComponent) || (tPMediaDecoderInfo2.isAudio() && tPMediaDecoderInfo2.isAudioSofwareDecoder() == mPreferredSoftwareComponent)) {
                    return tPMediaDecoderInfo2.getDecoderName();
                }
            }
            if (!arrayList.isEmpty()) {
                return ((TPMediaDecoderInfo) arrayList.get(0)).getDecoderName();
            }
            return null;
        } else if (TextUtils.equals(str, MimeTypes.AUDIO_E_AC3) && mAudioMaxCapCodecInstance.containsKey(MimeTypes.AUDIO_E_AC3_JOC)) {
            return mAudioMaxCapCodecInstance.get(MimeTypes.AUDIO_E_AC3_JOC);
        } else {
            if (mAudioMaxCapCodecInstance.containsKey(str)) {
                return mAudioMaxCapCodecInstance.get(str);
            }
            return null;
        }
    }

    public static String getDisplayVersion() {
        return null;
    }

    public static String getDolbyVisionDecoderName(String str, int i11, int i12, boolean z11) {
        String str2 = str;
        boolean z12 = z11;
        if (Build.VERSION.SDK_INT >= 21 && TextUtils.equals("video/dolby-vision", str2)) {
            int convertDolbyVisionToOmxProfile = convertDolbyVisionToOmxProfile(i11);
            for (TPMediaDecoderInfo tPMediaDecoderInfo : TPMediaDecoderList.getTPMediaDecoderInfos(mLocalCache)) {
                TPMediaDecoderInfo.DecoderProfileLevel[] profileLevels = tPMediaDecoderInfo.getProfileLevels();
                if (TextUtils.equals(tPMediaDecoderInfo.getDecoderMimeType(), str2)) {
                    for (TPMediaDecoderInfo.DecoderProfileLevel decoderProfileLevel : profileLevels) {
                        if (decoderProfileLevel.profile == convertDolbyVisionToOmxProfile) {
                            TPNativeLog.printLog(2, TAG, "getDolbyVisionDecoderName  profile:" + decoderProfileLevel.profile + " dvProfile:" + i11 + " bSecure:" + z12 + " name:" + tPMediaDecoderInfo.getDecoderName());
                            if (tPMediaDecoderInfo.isSecureDecoder() == z12) {
                                return tPMediaDecoderInfo.getDecoderName();
                            }
                        } else {
                            int i13 = i11;
                        }
                    }
                    continue;
                }
                int i14 = i11;
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0069, code lost:
        if (r2 >= mHdHevcSamsungIndex) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0073, code lost:
        if (r2 >= mHdHevcHisiIndex) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007d, code lost:
        if (r2 >= mHdHevcMtkIndex) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0089, code lost:
        if (r2 >= mHdHevcQualcommIndex) goto L_0x0090;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getHevcSWDecodeLevel() {
        /*
            java.lang.String r0 = com.tencent.thumbplayer.tcmedia.core.common.TPSystemInfo.getCpuHarewareName()
            int r1 = com.tencent.thumbplayer.tcmedia.core.common.TPSystemInfo.getCpuHWProducter(r0)
            int r2 = com.tencent.thumbplayer.tcmedia.core.common.TPSystemInfo.getCpuHWProductIndex(r0)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "[getHevcSWDecodeLevel], mCpuHWProducter = "
            r3.<init>(r4)
            r3.append(r1)
            java.lang.String r4 = ", getMaxCpuFreq() = "
            r3.append(r4)
            long r4 = com.tencent.thumbplayer.tcmedia.core.common.TPSystemInfo.getMaxCpuFreq()
            r3.append(r4)
            java.lang.String r4 = ", numCores = "
            r3.append(r4)
            int r4 = com.tencent.thumbplayer.tcmedia.core.common.TPSystemInfo.getNumCores()
            r3.append(r4)
            java.lang.String r4 = ", mCpuHWProductIdx="
            r3.append(r4)
            r3.append(r2)
            java.lang.String r4 = ", hardware="
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r3 = 2
            java.lang.String r4 = "TPCodecUtils"
            com.tencent.thumbplayer.tcmedia.core.common.TPNativeLog.printLog(r3, r4, r0)
            int r0 = mHevcDeviceLevel
            r4 = -1
            if (r4 == r0) goto L_0x004e
            return r0
        L_0x004e:
            r0 = 0
            mHevcDeviceLevel = r0
            if (r4 == r1) goto L_0x008c
            r0 = 16
            r4 = 21
            if (r1 == 0) goto L_0x0080
            r5 = 1
            if (r1 == r5) goto L_0x0076
            if (r1 == r3) goto L_0x006c
            r3 = 3
            if (r1 == r3) goto L_0x0062
            goto L_0x0092
        L_0x0062:
            int r1 = mShdHevcSamsungIndex
            if (r2 < r1) goto L_0x0067
            goto L_0x0084
        L_0x0067:
            int r1 = mHdHevcSamsungIndex
            if (r2 < r1) goto L_0x008c
            goto L_0x008b
        L_0x006c:
            int r1 = mShdHevcHisiIndex
            if (r2 < r1) goto L_0x0071
            goto L_0x0084
        L_0x0071:
            int r1 = mHdHevcHisiIndex
            if (r2 < r1) goto L_0x008c
            goto L_0x008b
        L_0x0076:
            int r1 = mShdHevcMtkIndex
            if (r2 < r1) goto L_0x007b
            goto L_0x0084
        L_0x007b:
            int r1 = mHdHevcMtkIndex
            if (r2 < r1) goto L_0x008c
            goto L_0x008b
        L_0x0080:
            int r1 = mShdHevcQualcommIndex
            if (r2 < r1) goto L_0x0087
        L_0x0084:
            mHevcDeviceLevel = r4
            goto L_0x0092
        L_0x0087:
            int r1 = mHdHevcQualcommIndex
            if (r2 < r1) goto L_0x008c
        L_0x008b:
            goto L_0x0090
        L_0x008c:
            int r0 = getDecodeLevelByCoresAndFreq()
        L_0x0090:
            mHevcDeviceLevel = r0
        L_0x0092:
            int r0 = mHevcDeviceLevel
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.core.common.TPCodecUtils.getHevcSWDecodeLevel():int");
    }

    public static int getMaxLumaSample(String str, int i11) {
        if (TextUtils.equals(str, "video/avc")) {
            return TPMediaCodecProfileLevel.getAVCMaxLumaSample(i11);
        }
        if (TextUtils.equals(str, "video/hevc")) {
            return TPMediaCodecProfileLevel.getHEVCMaxLumaSample(i11);
        }
        if (TextUtils.equals(str, "video/x-vnd.on2.vp8")) {
            return TPMediaCodecProfileLevel.getVP8MaxLumaSample(i11);
        }
        if (TextUtils.equals(str, "video/x-vnd.on2.vp9")) {
            return TPMediaCodecProfileLevel.getVP9MaxLumaSample(i11);
        }
        if (TextUtils.equals(str, "video/av01")) {
            return TPMediaCodecProfileLevel.getAV1MaxLumaSample(i11);
        }
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0040, code lost:
        r11 = r4.getDecoderMaxWidth();
        r1 = r4.getDecoderMaxHeight();
        r2 = r4.getDecoderLumaWidth();
        r12 = r4.getDecoderLumaHeight();
        r13 = r4.getDecoderMaxFrameRateForMaxLuma();
        r14 = r4.getDecoderMaxFrameRate();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0062, code lost:
        if (isLimitMaxWidthOrMaxHeight(r11, r1, r2, r12, r17, r18) == false) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0065, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r9 = java.lang.Integer.valueOf(java.lang.Math.min(r14, java.lang.Math.max(1, ((int) ((((long) (r11 * r12)) * 1) / java.lang.Math.max(((long) (r6 * r7)) * 1, 1))) * r13)));
        com.tencent.thumbplayer.tcmedia.core.common.TPNativeLog.printLog(2, TAG, "getSupportedFrameRatesFor max width:" + r11 + " max height:" + r12 + " max framerate for max resolution:" + r13 + " current width:" + r6 + " height:" + r7 + " max support framerate:" + r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00e5, code lost:
        return 30;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized int getMaxSupportedFrameRatesFor(int r15, int r16, int r17, int r18) {
        /*
            r0 = r15
            r6 = r17
            r7 = r18
            java.lang.Class<com.tencent.thumbplayer.tcmedia.core.common.TPCodecUtils> r8 = com.tencent.thumbplayer.tcmedia.core.common.TPCodecUtils.class
            monitor-enter(r8)
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x00e6 }
            r2 = 21
            r3 = 30
            if (r1 < r2) goto L_0x00e4
            r1 = 101(0x65, float:1.42E-43)
            if (r0 == r1) goto L_0x00e4
            r1 = -1
            if (r0 != r1) goto L_0x0019
            goto L_0x00e4
        L_0x0019:
            java.lang.String r0 = getSupportedHWMimeType(r16)     // Catch:{ all -> 0x00e6 }
            boolean r1 = r0.isEmpty()     // Catch:{ all -> 0x00e6 }
            if (r1 == 0) goto L_0x0025
            monitor-exit(r8)
            return r3
        L_0x0025:
            java.lang.Integer r9 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x00e6 }
            com.tencent.thumbplayer.tcmedia.core.thirdparties.LocalCache r1 = mLocalCache     // Catch:{ Exception -> 0x00c5 }
            com.tencent.thumbplayer.tcmedia.core.common.TPMediaDecoderInfo[] r1 = com.tencent.thumbplayer.tcmedia.core.common.TPMediaDecoderList.getTPMediaDecoderInfos(r1)     // Catch:{ Exception -> 0x00c5 }
            int r2 = r1.length     // Catch:{ Exception -> 0x00c5 }
            r10 = 0
            r3 = r10
        L_0x0032:
            if (r3 >= r2) goto L_0x00de
            r4 = r1[r3]     // Catch:{ Exception -> 0x00c5 }
            java.lang.String r5 = r4.getDecoderMimeType()     // Catch:{ Exception -> 0x00c5 }
            boolean r5 = r0.equals(r5)     // Catch:{ Exception -> 0x00c5 }
            if (r5 == 0) goto L_0x00c1
            int r11 = r4.getDecoderMaxWidth()     // Catch:{ Exception -> 0x00c5 }
            int r1 = r4.getDecoderMaxHeight()     // Catch:{ Exception -> 0x00c5 }
            int r2 = r4.getDecoderLumaWidth()     // Catch:{ Exception -> 0x00c5 }
            int r12 = r4.getDecoderLumaHeight()     // Catch:{ Exception -> 0x00c5 }
            int r13 = r4.getDecoderMaxFrameRateForMaxLuma()     // Catch:{ Exception -> 0x00c5 }
            int r14 = r4.getDecoderMaxFrameRate()     // Catch:{ Exception -> 0x00c5 }
            r0 = r11
            r3 = r12
            r4 = r17
            r5 = r18
            boolean r0 = isLimitMaxWidthOrMaxHeight(r0, r1, r2, r3, r4, r5)     // Catch:{ Exception -> 0x00c5 }
            if (r0 == 0) goto L_0x0066
            monitor-exit(r8)
            return r10
        L_0x0066:
            int r0 = r11 * r12
            long r0 = (long) r0
            r2 = 1
            long r0 = r0 * r2
            int r4 = r6 * r7
            long r4 = (long) r4
            long r4 = r4 * r2
            long r2 = java.lang.Math.max(r4, r2)     // Catch:{ Exception -> 0x00c5 }
            long r0 = r0 / r2
            int r0 = (int) r0     // Catch:{ Exception -> 0x00c5 }
            int r0 = r0 * r13
            r1 = 1
            int r0 = java.lang.Math.max(r1, r0)     // Catch:{ Exception -> 0x00c5 }
            int r0 = java.lang.Math.min(r14, r0)     // Catch:{ Exception -> 0x00c5 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x00c5 }
            r0 = 2
            java.lang.String r1 = "TPCodecUtils"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c5 }
            java.lang.String r3 = "getSupportedFrameRatesFor max width:"
            r2.<init>(r3)     // Catch:{ Exception -> 0x00c5 }
            r2.append(r11)     // Catch:{ Exception -> 0x00c5 }
            java.lang.String r3 = " max height:"
            r2.append(r3)     // Catch:{ Exception -> 0x00c5 }
            r2.append(r12)     // Catch:{ Exception -> 0x00c5 }
            java.lang.String r3 = " max framerate for max resolution:"
            r2.append(r3)     // Catch:{ Exception -> 0x00c5 }
            r2.append(r13)     // Catch:{ Exception -> 0x00c5 }
            java.lang.String r3 = " current width:"
            r2.append(r3)     // Catch:{ Exception -> 0x00c5 }
            r2.append(r6)     // Catch:{ Exception -> 0x00c5 }
            java.lang.String r3 = " height:"
            r2.append(r3)     // Catch:{ Exception -> 0x00c5 }
            r2.append(r7)     // Catch:{ Exception -> 0x00c5 }
            java.lang.String r3 = " max support framerate:"
            r2.append(r3)     // Catch:{ Exception -> 0x00c5 }
            r2.append(r9)     // Catch:{ Exception -> 0x00c5 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00c5 }
            com.tencent.thumbplayer.tcmedia.core.common.TPNativeLog.printLog(r0, r1, r2)     // Catch:{ Exception -> 0x00c5 }
            goto L_0x00de
        L_0x00c1:
            int r3 = r3 + 1
            goto L_0x0032
        L_0x00c5:
            r0 = move-exception
            r1 = 4
            java.lang.String r2 = "TPCodecUtils"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e6 }
            java.lang.String r4 = "getMaxSupportedFrameRatesFor failed:"
            r3.<init>(r4)     // Catch:{ all -> 0x00e6 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x00e6 }
            r3.append(r0)     // Catch:{ all -> 0x00e6 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x00e6 }
            com.tencent.thumbplayer.tcmedia.core.common.TPNativeLog.printLog(r1, r2, r0)     // Catch:{ all -> 0x00e6 }
        L_0x00de:
            int r0 = r9.intValue()     // Catch:{ all -> 0x00e6 }
            monitor-exit(r8)
            return r0
        L_0x00e4:
            monitor-exit(r8)
            return r3
        L_0x00e6:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.core.common.TPCodecUtils.getMaxSupportedFrameRatesFor(int, int, int, int):int");
    }

    private static int getSoftMaxSamples(int i11) {
        if (i11 == 1) {
            return 129600;
        }
        if (i11 == 6) {
            return 307200;
        }
        if (i11 == 11) {
            return 407040;
        }
        if (i11 == 16) {
            return 480000;
        }
        if (i11 == 21) {
            return 921600;
        }
        if (i11 == 26) {
            return 2073600;
        }
        if (i11 != 28) {
            return i11 != 33 ? 0 : 8847360;
        }
        return 8294400;
    }

    private static int getSupportedCodecId(String str) {
        if (TextUtils.equals(str, "video/avc")) {
            return 26;
        }
        if (TextUtils.equals(str, "video/hevc")) {
            return 172;
        }
        if (TextUtils.equals(str, "video/x-vnd.on2.vp8")) {
            return 138;
        }
        if (TextUtils.equals(str, "video/x-vnd.on2.vp9")) {
            return 166;
        }
        if (TextUtils.equals(str, "video/av01")) {
            return 1029;
        }
        if (TextUtils.equals(str, MimeTypes.AUDIO_AAC)) {
            return 5002;
        }
        if (TextUtils.equals(str, MimeTypes.AUDIO_AC3)) {
            return 5003;
        }
        if (TextUtils.equals(str, MimeTypes.AUDIO_E_AC3) || TextUtils.equals(str, MimeTypes.AUDIO_E_AC3_JOC)) {
            return 5040;
        }
        if (TextUtils.equals(str, MimeTypes.AUDIO_FLAC)) {
            return 5012;
        }
        return TextUtils.equals(str, MimeTypes.AUDIO_DTS) ? 5004 : -1;
    }

    private static String getSupportedHWMimeType(int i11) {
        return i11 != 26 ? i11 != 138 ? i11 != 166 ? i11 != 172 ? i11 != 1029 ? "" : "video/av01" : "video/hevc" : "video/x-vnd.on2.vp9" : "video/x-vnd.on2.vp8" : "video/avc";
    }

    public static String getSystemPatchVersion() {
        return null;
    }

    public static synchronized HashMap<Integer, TPCodecCapability.TPCodecMaxCapability> getVCodecSWMaxCapabilityMap() {
        synchronized (TPCodecUtils.class) {
            TPNativeLog.printLog(2, TAG, "getVCodecSWMaxCapabilityMap func in");
            if (mIsFFmpegCapGot) {
                HashMap<Integer, TPCodecCapability.TPCodecMaxCapability> hashMap = mMaxVCodecSwCapabilityMap;
                return hashMap;
            }
            try {
                int hevcSWDecodeLevel = getHevcSWDecodeLevel();
                int softMaxSamples = getSoftMaxSamples(hevcSWDecodeLevel);
                int avs3SWDecodeLevel = getAvs3SWDecodeLevel();
                int aV1SWDecodeLevel = getAV1SWDecodeLevel();
                int vvcSWDecodeLevel = getVvcSWDecodeLevel();
                int softMaxSamples2 = getSoftMaxSamples(avs3SWDecodeLevel);
                int softMaxSamples3 = getSoftMaxSamples(aV1SWDecodeLevel);
                int softMaxSamples4 = getSoftMaxSamples(vvcSWDecodeLevel);
                TPNativeLog.printLog(2, "getVCodecSWMaxCapabilityMap, hevcDecodeLevel:" + hevcSWDecodeLevel + ", avs3DecodeLevel:" + avs3SWDecodeLevel + ", AV1DecodeLevel:" + aV1SWDecodeLevel + ", vvcDecodeLevel:" + vvcSWDecodeLevel);
                TPCodecCapability.TPCodecMaxCapability tPCodecMaxCapability = mAVCSWMaxCapability;
                tPCodecMaxCapability.maxLumaSamples = softMaxSamples;
                tPCodecMaxCapability.maxProfile = 64;
                tPCodecMaxCapability.maxLevel = 65536;
                mMaxVCodecSwCapabilityMap.put(26, mAVCSWMaxCapability);
                TPCodecCapability.TPCodecMaxCapability tPCodecMaxCapability2 = mHEVCSWMaxCapability;
                tPCodecMaxCapability2.maxLumaSamples = softMaxSamples;
                tPCodecMaxCapability2.maxProfile = 2;
                tPCodecMaxCapability2.maxLevel = TPMediaCodecProfileLevel.HEVCHighTierLevel62;
                mMaxVCodecSwCapabilityMap.put(172, mHEVCSWMaxCapability);
                TPCodecCapability.TPCodecMaxCapability tPCodecMaxCapability3 = mVP9SWMaxCapability;
                tPCodecMaxCapability3.maxLumaSamples = softMaxSamples;
                tPCodecMaxCapability3.maxProfile = 8;
                tPCodecMaxCapability3.maxLevel = 8192;
                mMaxVCodecSwCapabilityMap.put(166, mVP9SWMaxCapability);
                TPCodecCapability.TPCodecMaxCapability tPCodecMaxCapability4 = mVP8SWMaxCapability;
                tPCodecMaxCapability4.maxLumaSamples = softMaxSamples;
                tPCodecMaxCapability4.maxProfile = 1;
                tPCodecMaxCapability4.maxLevel = 8;
                mMaxVCodecSwCapabilityMap.put(138, mVP8SWMaxCapability);
                TPCodecCapability.TPCodecMaxCapability tPCodecMaxCapability5 = mAVS3WMaxCapability;
                tPCodecMaxCapability5.maxLumaSamples = softMaxSamples2;
                tPCodecMaxCapability5.maxProfile = 0;
                tPCodecMaxCapability5.maxLevel = 0;
                mMaxVCodecSwCapabilityMap.put(192, mAVS3WMaxCapability);
                TPCodecCapability.TPCodecMaxCapability tPCodecMaxCapability6 = mAV1SWMaxCapability;
                tPCodecMaxCapability6.maxLumaSamples = softMaxSamples3;
                tPCodecMaxCapability6.maxProfile = 0;
                tPCodecMaxCapability6.maxLevel = 0;
                mMaxVCodecSwCapabilityMap.put(1029, mAV1SWMaxCapability);
                TPCodecCapability.TPCodecMaxCapability tPCodecMaxCapability7 = mVVCSWMaxCapability;
                tPCodecMaxCapability7.maxLumaSamples = softMaxSamples4;
                tPCodecMaxCapability7.maxProfile = 0;
                tPCodecMaxCapability7.maxLevel = 0;
                mMaxVCodecSwCapabilityMap.put(193, mVVCSWMaxCapability);
                TPNativeLog.printLog(2, "getVCodecSWMaxCapabilityMap success, maxHevcLumaSamples:" + softMaxSamples + ", maxAvs3LumaSamples:" + softMaxSamples2 + ", maxAV1LumaSamples:" + softMaxSamples3 + ", maxVvcLumaSamples:" + softMaxSamples4);
                mIsFFmpegCapGot = true;
                HashMap<Integer, TPCodecCapability.TPCodecMaxCapability> hashMap2 = mMaxVCodecSwCapabilityMap;
                return hashMap2;
            } catch (Exception unused) {
                TPNativeLog.printLog(4, TAG, "getVCodecSWMaxCapabilityMap exception");
                return null;
            }
        }
    }

    public static synchronized HashMap<Integer, TPCodecCapability.TPCodecMaxCapability> getVMediaCodecMaxCapabilityMap() {
        synchronized (TPCodecUtils.class) {
            TPNativeLog.printLog(2, TAG, "getVMediaCodecMaxCapabilityMap func in");
            if (!mMaxVCodecHwCapabilityMap.isEmpty()) {
                TPNativeLog.printLog(2, TAG, "return memory stored video max cap map");
                HashMap<Integer, TPCodecCapability.TPCodecMaxCapability> hashMap = mMaxVCodecHwCapabilityMap;
                return hashMap;
            }
            try {
                for (TPMediaDecoderInfo tPMediaDecoderInfo : TPMediaDecoderList.getTPMediaDecoderInfos(mLocalCache)) {
                    String decoderMimeType = tPMediaDecoderInfo.getDecoderMimeType();
                    if (tPMediaDecoderInfo.isVideo()) {
                        mVMediaCodecCapList.add(decoderMimeType);
                        TPNativeLog.printLog(2, TAG, "Video MimeType: " + decoderMimeType + " codecName: " + tPMediaDecoderInfo.getDecoderName());
                        if (isSupportedMediaCodec(decoderMimeType) && !tPMediaDecoderInfo.isSecureDecoder()) {
                            TPMediaDecoderInfo.DecoderProfileLevel maxProfileLevel = tPMediaDecoderInfo.getMaxProfileLevel();
                            TPCodecCapability.TPCodecMaxCapability tPCodecMaxCapability = new TPCodecCapability.TPCodecMaxCapability(getMaxLumaSample(decoderMimeType, maxProfileLevel.level), maxProfileLevel.profile, maxProfileLevel.level, tPMediaDecoderInfo.getDecoderMaxFrameRateForMaxLuma());
                            TPNativeLog.printLog(2, TAG, "video codecName: " + tPMediaDecoderInfo.getDecoderName() + " lumasample: " + getMaxLumaSample(decoderMimeType, maxProfileLevel.level) + " framerate: " + tPMediaDecoderInfo.getDecoderMaxFrameRateForMaxLuma());
                            if (!mMaxVCodecHwCapabilityMap.containsKey(Integer.valueOf(getSupportedCodecId(decoderMimeType))) || maxProfileLevel.level > mMaxVCodecHwCapabilityMap.get(Integer.valueOf(getSupportedCodecId(decoderMimeType))).maxLevel) {
                                replace(Integer.valueOf(getSupportedCodecId(decoderMimeType)), tPCodecMaxCapability, mMaxVCodecHwCapabilityMap);
                            }
                        }
                    }
                }
            } catch (Exception e11) {
                TPNativeLog.printLog(4, TAG, "getVMediaCodecMaxCapabilityMap failed:" + Log.getStackTraceString(e11));
            }
            HashMap<Integer, TPCodecCapability.TPCodecMaxCapability> hashMap2 = mMaxVCodecHwCapabilityMap;
            return hashMap2;
        }
    }

    private static int getValueFromSubstring(String str, int i11, int i12) {
        if (i11 < 0) {
            i11 = 0;
        }
        if (i12 >= str.length()) {
            i12 = str.length() - 1;
        }
        if (i11 > i12) {
            i11 = i12;
        }
        return Integer.parseInt(str.substring(i11, i12));
    }

    private static int getVvcSWDecodeLevel() {
        String valueOf;
        String str;
        int i11 = mVvcDeviceLevel;
        if (i11 != -1) {
            return i11;
        }
        String cpuHarewareName = TPSystemInfo.getCpuHarewareName();
        int cpuHWProducter = TPSystemInfo.getCpuHWProducter(cpuHarewareName);
        int cpuHWProductIndex = TPSystemInfo.getCpuHWProductIndex(cpuHarewareName);
        TPNativeLog.printLog(2, TAG, "[getVvcSWDecodeLevel], mCpuHWProducer = " + cpuHWProducter + ", getMaxCpuFreq() = " + TPSystemInfo.getMaxCpuFreq() + ", numCores = " + TPSystemInfo.getNumCores() + ", mCpuHWProductIdx = " + cpuHWProductIndex + ", hardware = " + cpuHarewareName);
        int i12 = 0;
        if (cpuHWProducter == -1) {
            valueOf = String.valueOf(cpuHWProducter);
            str = "current cpu manufacturer is not listed in the performance list, cpuHwProducer:";
        } else if (cpuHWProductIndex == -1) {
            valueOf = String.valueOf(cpuHWProductIndex);
            str = "current cpu model is not listed in the performance list, cpuHwProductIdx:";
        } else {
            int selectBestDecodeLevelFromCapabilityTable = selectBestDecodeLevelFromCapabilityTable(193, cpuHWProducter, cpuHWProductIndex);
            if (selectBestDecodeLevelFromCapabilityTable != -1) {
                i12 = selectBestDecodeLevelFromCapabilityTable;
            }
            mVvcDeviceLevel = i12;
            return i12;
        }
        TPNativeLog.printLog(3, TAG, str.concat(valueOf));
        mVvcDeviceLevel = 0;
        return 0;
    }

    public static synchronized void init(Context context, boolean z11) {
        synchronized (TPCodecUtils.class) {
            TPNativeLog.printLog(2, TAG, "is local cache enabled:".concat(String.valueOf(z11)));
            Context applicationContext = context.getApplicationContext();
            mContext = applicationContext;
            if (z11) {
                mLocalCache = LocalCache.get(applicationContext);
            }
            getDecoderMaxCapabilityMapAsync();
        }
    }

    public static boolean isAMediaCodecBlackListInstance(String str) {
        return mAMediaCodecBlackListInstance.contains(str);
    }

    public static boolean isAMediaCodecBlackListModel() {
        return mAMediaCodecBlackListModel.contains(TPSystemInfo.getDeviceName());
    }

    public static boolean isBlackListType(String str) {
        return Arrays.asList(new String[]{"PRO 7 Plus", "PRO 7-H", "PRO+7+Plus"}).contains(TPSystemInfo.getDeviceName()) && TextUtils.equals(str, "video/hevc") && Build.VERSION.SDK_INT >= 14;
    }

    private static synchronized boolean isHDR10Support(int i11) {
        synchronized (TPCodecUtils.class) {
            for (TPMediaDecoderInfo tPMediaDecoderInfo : TPMediaDecoderList.getTPMediaDecoderInfos(mLocalCache)) {
                if (TextUtils.equals(tPMediaDecoderInfo.getDecoderMimeType(), "video/hevc")) {
                    for (TPMediaDecoderInfo.DecoderProfileLevel decoderProfileLevel : tPMediaDecoderInfo.getProfileLevels()) {
                        if (decoderProfileLevel.profile == i11) {
                            TPNativeLog.printLog(2, TAG, "support hdr10 ".concat(String.valueOf(i11)));
                            return true;
                        }
                    }
                    continue;
                }
            }
            return false;
        }
    }

    private static synchronized boolean isHDRDVSupport(int i11, int i12) {
        synchronized (TPCodecUtils.class) {
            if (i11 == 0 && i12 == 0) {
                boolean contains = mVMediaCodecCapList.contains("video/dolby-vision");
                return contains;
            }
            for (TPMediaDecoderInfo tPMediaDecoderInfo : TPMediaDecoderList.getTPMediaDecoderInfos(mLocalCache)) {
                if (TextUtils.equals(tPMediaDecoderInfo.getDecoderMimeType(), "video/dolby-vision")) {
                    for (TPMediaDecoderInfo.DecoderProfileLevel decoderProfileLevel : tPMediaDecoderInfo.getProfileLevels()) {
                        if (decoderProfileLevel.profile == i11 && decoderProfileLevel.level == i12) {
                            TPNativeLog.printLog(2, TAG, "support dolbyvision");
                            return true;
                        }
                    }
                    continue;
                }
            }
            return false;
        }
    }

    public static boolean isHDRDecoderTypeSupport(int i11, int i12) {
        String valueOf;
        String str;
        if (i12 == 102 || i12 == 101) {
            HashMap<Integer, ArrayList<TPCodecCapability.TPHdrSupportVersionRange>> hashMap = i12 == 102 ? mHDRTypeToHDRHardwareCodecWhiteListMap : mHDRTypeToHDRSoftwareCodecWhiteListMap;
            if (hashMap.containsKey(Integer.valueOf(i11))) {
                return isInHDRVersionRangeWhiteList(hashMap.get(Integer.valueOf(i11)));
            }
            valueOf = String.valueOf(i11);
            str = "isHDRDecodeTypeSupport, not config hdrType whiteList, hdrType = ";
        } else {
            valueOf = String.valueOf(i12);
            str = "isHDRDecodeTypeSupport, not support decoderType, decoderType = ";
        }
        TPNativeLog.printLog(3, TAG, str.concat(valueOf));
        return false;
    }

    public static boolean isHDRsupport(int i11, int i12, int i13) {
        if (i11 == 2) {
            return isHDRDVSupport(i12, i13);
        }
        if (i11 == 0) {
            return isHDR10Support(4096);
        }
        if (i11 == 1) {
            return isHDR10Support(8192);
        }
        if (i11 != 4) {
            return false;
        }
        String displayVersion = getDisplayVersion();
        String systemPatchVersion = getSystemPatchVersion();
        TPNativeLog.printLog(2, TAG, "isHDRsupport(HDRVivid):display version:".concat(String.valueOf(displayVersion)));
        TPNativeLog.printLog(2, TAG, "isHDRsupport(HDRVivid):patch version:".concat(String.valueOf(systemPatchVersion)));
        return checkHDRVividSupportByVersion(TPSystemInfo.getDeviceName(), displayVersion, systemPatchVersion);
    }

    public static boolean isInDRMLevel1Blacklist(int i11) {
        if (mDrmL1BlackList.containsKey(Integer.valueOf(i11))) {
            return mDrmL1BlackList.get(Integer.valueOf(i11)).contains(TPSystemInfo.getDeviceName());
        }
        return false;
    }

    private static boolean isInHDRVersionRangeWhiteList(ArrayList<TPCodecCapability.TPHdrSupportVersionRange> arrayList) {
        if (arrayList == null) {
            return false;
        }
        int i11 = 0;
        while (i11 < arrayList.size()) {
            TPCodecCapability.TPHdrSupportVersionRange tPHdrSupportVersionRange = arrayList.get(i11);
            int i12 = Build.VERSION.SDK_INT;
            if (i12 > tPHdrSupportVersionRange.upperboundAndroidAPILevel || i12 < tPHdrSupportVersionRange.lowerboundAndroidAPILevel) {
                i11++;
            } else {
                TPNativeLog.printLog(2, TAG, "inHDRVersionRangeWhiteList!");
                return true;
            }
        }
        return false;
    }

    public static boolean isInHDRVividBlackList(String str, int i11, int i12) {
        if (mHdrBlackMap.containsKey(4)) {
            HashMap hashMap = mHdrBlackMap.get(4);
            if (hashMap.containsKey(str)) {
                TPCodecCapability.TPHdrSupportVersionRange tPHdrSupportVersionRange = (TPCodecCapability.TPHdrSupportVersionRange) hashMap.get(str);
                return i11 <= tPHdrSupportVersionRange.upperboundSystemVersion && i11 >= tPHdrSupportVersionRange.lowerboundSystemVersion && i12 <= tPHdrSupportVersionRange.upperboundPatchVersion && i12 >= tPHdrSupportVersionRange.lowerboundPatchVersion;
            }
        }
    }

    public static boolean isInHDRVividWhiteList(String str, int i11, int i12) {
        if (mHdrWhiteMap.containsKey(4)) {
            HashMap hashMap = mHdrWhiteMap.get(4);
            if (hashMap.containsKey(str)) {
                TPCodecCapability.TPHdrSupportVersionRange tPHdrSupportVersionRange = (TPCodecCapability.TPHdrSupportVersionRange) hashMap.get(str);
                return i11 <= tPHdrSupportVersionRange.upperboundSystemVersion && i11 >= tPHdrSupportVersionRange.lowerboundSystemVersion && i12 <= tPHdrSupportVersionRange.upperboundPatchVersion && i12 >= tPHdrSupportVersionRange.lowerboundPatchVersion;
            }
        }
    }

    public static boolean isInMediaCodecBlackList(String str) {
        HashMap<String, Integer> hashMap;
        String deviceName = TPSystemInfo.getDeviceName();
        if (TextUtils.isEmpty(deviceName) || (hashMap = mCodecCapBlackList) == null || !hashMap.containsKey(deviceName)) {
            return false;
        }
        Integer num = mCodecCapBlackList.get(deviceName);
        if (TextUtils.equals(str, "video/avc")) {
            if ((num.intValue() & 1) == 0) {
                return false;
            }
        } else if (TextUtils.equals(str, "video/hevc")) {
            if ((num.intValue() & 2) == 0) {
                return false;
            }
        } else if (TextUtils.equals(str, "video/x-vnd.on2.vp8")) {
            if ((num.intValue() & 256) == 0) {
                return false;
            }
        } else if (TextUtils.equals(str, "video/x-vnd.on2.vp9")) {
            if ((num.intValue() & 4) == 0) {
                return false;
            }
        } else if (TextUtils.equals(str, MimeTypes.AUDIO_AAC)) {
            if ((num.intValue() & 8) == 0) {
                return false;
            }
        } else if (TextUtils.equals(str, MimeTypes.AUDIO_AC3)) {
            if ((num.intValue() & 16) == 0) {
                return false;
            }
        } else if (TextUtils.equals(str, MimeTypes.AUDIO_E_AC3)) {
            if ((num.intValue() & 32) == 0) {
                return false;
            }
        } else if (TextUtils.equals(str, MimeTypes.AUDIO_FLAC)) {
            if ((num.intValue() & 64) == 0) {
                return false;
            }
        } else if (TextUtils.equals(str, MimeTypes.AUDIO_DTS)) {
            if ((num.intValue() & 128) == 0) {
                return false;
            }
        } else if (!TextUtils.equals(str, MimeTypes.AUDIO_E_AC3_JOC) || (num.intValue() & 32) == 0) {
            return false;
        }
        return true;
    }

    public static boolean isInMediaCodecWhiteList(String str) {
        HashMap<String, Integer> hashMap;
        String deviceName = TPSystemInfo.getDeviceName();
        if (TextUtils.isEmpty(deviceName) || (hashMap = mCodecCapWhiteList) == null || !hashMap.containsKey(deviceName)) {
            return false;
        }
        Integer num = mCodecCapWhiteList.get(deviceName);
        if (TextUtils.equals(str, "video/avc")) {
            if ((num.intValue() & 1) == 0) {
                return false;
            }
        } else if (TextUtils.equals(str, "video/hevc")) {
            if ((num.intValue() & 2) == 0) {
                return false;
            }
        } else if (TextUtils.equals(str, "video/x-vnd.on2.vp8")) {
            if ((num.intValue() & 256) == 0) {
                return false;
            }
        } else if (TextUtils.equals(str, "video/x-vnd.on2.vp9")) {
            if ((num.intValue() & 4) == 0) {
                return false;
            }
        } else if (TextUtils.equals(str, MimeTypes.AUDIO_AAC)) {
            if ((num.intValue() & 8) == 0) {
                return false;
            }
        } else if (TextUtils.equals(str, MimeTypes.AUDIO_AC3)) {
            if ((num.intValue() & 16) == 0) {
                return false;
            }
        } else if (TextUtils.equals(str, MimeTypes.AUDIO_E_AC3)) {
            if ((num.intValue() & 32) == 0) {
                return false;
            }
        } else if (TextUtils.equals(str, MimeTypes.AUDIO_FLAC)) {
            if ((num.intValue() & 64) == 0) {
                return false;
            }
        } else if (!TextUtils.equals(str, MimeTypes.AUDIO_DTS) || (num.intValue() & 128) == 0) {
            return false;
        }
        return true;
    }

    private static boolean isLimitMaxWidthOrMaxHeight(int i11, int i12, int i13, int i14, int i15, int i16) {
        if ((i15 <= i16 || (i15 <= i11 && i16 <= i14)) && (i15 >= i16 || (i15 <= i13 && i16 <= i12))) {
            return false;
        }
        int i17 = i15 > i16 ? i14 * i11 : i13 * i12;
        if (i11 < i15 || i12 < i16 || i17 < i15 * i16) {
            TPNativeLog.printLog(4, TAG, "getSupportedFrameRatesFor width:" + i15 + " height:" + i16 + " do not support! maxWidth:" + i11 + " maxHeight:" + i12);
            return true;
        }
        TPNativeLog.printLog(2, TAG, "getSupportedFrameRatesFor width:" + i15 + " height:" + i16 + " limit maxLumaWidth or maxLumaHeight, but not limit maxLumaSamples, do support! maxWidth:" + i11 + " maxHeight:" + i12 + " maxLumaSamples:" + i17);
        return false;
    }

    public static synchronized boolean isMediaCodecDDPlusSupported() {
        synchronized (TPCodecUtils.class) {
            if (isAMediaCodecBlackListModel()) {
                return false;
            }
            return mAMediaCodecCapList.contains(MimeTypes.AUDIO_E_AC3) || mAMediaCodecCapList.contains(MimeTypes.AUDIO_E_AC3_JOC);
        }
    }

    public static synchronized boolean isMediaCodecDolbyDSSupported() {
        synchronized (TPCodecUtils.class) {
            if (isAMediaCodecBlackListModel()) {
                return false;
            }
            boolean contains = mAMediaCodecCapList.contains(MimeTypes.AUDIO_AC3);
            return contains;
        }
    }

    private static boolean isSupportedMediaCodec(String str) {
        return mSupportedMediaCodec.contains(str);
    }

    private static boolean isTheSameVersionRange(TPCodecCapability.TPHdrSupportVersionRange tPHdrSupportVersionRange, TPCodecCapability.TPHdrSupportVersionRange tPHdrSupportVersionRange2) {
        return tPHdrSupportVersionRange.lowerboundPatchVersion == tPHdrSupportVersionRange2.lowerboundPatchVersion && tPHdrSupportVersionRange.lowerboundSystemVersion == tPHdrSupportVersionRange2.lowerboundSystemVersion && tPHdrSupportVersionRange.upperboundPatchVersion == tPHdrSupportVersionRange2.upperboundPatchVersion && tPHdrSupportVersionRange.upperboundSystemVersion == tPHdrSupportVersionRange2.upperboundSystemVersion;
    }

    public static boolean isVMediaCodecBlackListModel() {
        return mVMediaCodecBlackListModel.contains(TPSystemInfo.getDeviceName());
    }

    private static <K, T> void replace(K k11, T t11, HashMap<K, T> hashMap) {
        if (hashMap.containsKey(k11)) {
            hashMap.remove(k11);
            hashMap.put(k11, t11);
            return;
        }
        hashMap.put(k11, t11);
    }

    private static int selectBestDecodeLevelFromCapabilityTable(int i11, int i12, int i13) {
        String valueOf;
        String str;
        VideoSwCapabilityModel videoSwCapabilityModel = mVideoCodecIdToSwCapabilityModel.get(i11);
        if (videoSwCapabilityModel == null) {
            valueOf = String.valueOf(i11);
            str = "No corresponding codec id found, codecId:";
        } else {
            HashMap hashMap = videoSwCapabilityModel.mCpuProducerToAllDefinitionDecTable.get(i12);
            if (hashMap == null || hashMap.isEmpty()) {
                valueOf = String.valueOf(i12);
                str = "No corresponding cpu producer found, cpuHwProducer:";
            } else {
                for (DefinitionName definitionName : DefinitionName.values()) {
                    String str2 = (String) hashMap.get(definitionName);
                    if (!TextUtils.isEmpty(str2) && i13 >= TPSystemInfo.getCpuHWProductIndex(i12, str2)) {
                        return convertDefinitionNameToDecodeLevel(definitionName);
                    }
                }
                return -1;
            }
        }
        TPNativeLog.printLog(3, TAG, str.concat(valueOf));
        return -1;
    }

    public static void setMediaCodecPreferredSoftwareComponent(boolean z11) {
        mPreferredSoftwareComponent = z11;
    }
}
