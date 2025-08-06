package com.tencent.ugc.common;

import android.media.MediaFormat;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.ugc.AudioEncodeParams;
import com.tencent.ugc.videobase.utils.CollectionUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UGCTranscodeAudioEncodeParamsDecider {
    private static final int DEFAULT_BITRATE = 98304;
    private static final int DEFAULT_BIT_PER_CHANNEL = 16;
    private static final int DEFAULT_CHANNEL_COUNT = 1;
    private static final int DEFAULT_SAMPLE_RATE = 48000;
    private static final String TAG = "UGCTranscodeAudioEncodeParamsDecider";
    private List<MediaFormat> mAudioMediaFormatList;
    private MediaFormat mBGMMediaFormat;
    private int mEncodeBitrate = 0;

    private int getDecidedBitRate() {
        int i11 = this.mEncodeBitrate;
        if (i11 != 0) {
            return i11;
        }
        if (this.mBGMMediaFormat == null) {
            int maxAudioBitRate = getMaxAudioBitRate(this.mAudioMediaFormatList);
            if (maxAudioBitRate != -1) {
                return maxAudioBitRate;
            }
            return DEFAULT_BITRATE;
        } else if (CollectionUtils.isEmpty((Collection<?>) this.mAudioMediaFormatList)) {
            return getIntValueFromFormat(this.mBGMMediaFormat, "bitrate", DEFAULT_BITRATE);
        } else {
            ArrayList arrayList = new ArrayList(this.mAudioMediaFormatList);
            arrayList.add(this.mBGMMediaFormat);
            int maxAudioBitRate2 = getMaxAudioBitRate(arrayList);
            if (maxAudioBitRate2 != -1) {
                return maxAudioBitRate2;
            }
            return DEFAULT_BITRATE;
        }
    }

    private int getDecidedChannels() {
        MediaFormat firstValidMediaFormat = !CollectionUtils.isEmpty((Collection<?>) this.mAudioMediaFormatList) ? getFirstValidMediaFormat() : null;
        MediaFormat mediaFormat = this.mBGMMediaFormat;
        if (mediaFormat == null) {
            int intValueFromFormat = getIntValueFromFormat(firstValidMediaFormat, "channel-count", 1);
            if (intValueFromFormat > 2) {
                return 2;
            }
            return intValueFromFormat;
        } else if (firstValidMediaFormat == null) {
            int intValueFromFormat2 = getIntValueFromFormat(mediaFormat, "channel-count", 1);
            if (intValueFromFormat2 > 2) {
                return 2;
            }
            return intValueFromFormat2;
        } else {
            int max = Math.max(getIntValueFromFormat(firstValidMediaFormat, "channel-count", 1), getIntValueFromFormat(this.mBGMMediaFormat, "channel-count", 1));
            if (max > 2) {
                return 2;
            }
            return max;
        }
    }

    private int getDecidedSampleRate() {
        MediaFormat mediaFormat = this.mBGMMediaFormat;
        if (mediaFormat != null) {
            return getIntValueFromFormat(mediaFormat, "sample-rate", 48000);
        }
        MediaFormat mediaFormat2 = null;
        if (!CollectionUtils.isEmpty((Collection<?>) this.mAudioMediaFormatList)) {
            mediaFormat2 = getFirstValidMediaFormat();
        }
        return getIntValueFromFormat(mediaFormat2, "sample-rate", 48000);
    }

    private MediaFormat getFirstValidMediaFormat() {
        for (MediaFormat next : this.mAudioMediaFormatList) {
            if (next != null) {
                return next;
            }
        }
        return null;
    }

    private int getIntValueFromFormat(MediaFormat mediaFormat, String str, int i11) {
        if (mediaFormat == null) {
            return i11;
        }
        try {
            return mediaFormat.getInteger(str);
        } catch (Exception e11) {
            LiteavLog.w(TAG, String.valueOf(e11));
            return i11;
        }
    }

    private int getMaxAudioBitRate(List<MediaFormat> list) {
        int i11 = -1;
        if (list == null) {
            return -1;
        }
        for (MediaFormat next : list) {
            if (next.containsKey("bitrate")) {
                i11 = Math.max(i11, next.getInteger("bitrate"));
            }
        }
        return i11;
    }

    public AudioEncodeParams getDecidedEncodeParams() {
        AudioEncodeParams audioEncodeParams = new AudioEncodeParams();
        audioEncodeParams.setSampleRate(getDecidedSampleRate());
        audioEncodeParams.setChannels(getDecidedChannels());
        audioEncodeParams.setBitsPerChannel(16);
        audioEncodeParams.setBitrate(getDecidedBitRate());
        return audioEncodeParams;
    }

    public void setBGMMediaFormat(MediaFormat mediaFormat) {
        this.mBGMMediaFormat = mediaFormat;
    }

    public void setEncodeBitrate(int i11) {
        if (this.mEncodeBitrate != i11) {
            LiteavLog.i(TAG, "setAudioBitrate ".concat(String.valueOf(i11)));
            this.mEncodeBitrate = i11;
        }
    }

    public void setInputAudioMediaFormat(List<MediaFormat> list) {
        this.mAudioMediaFormatList = list;
    }
}
