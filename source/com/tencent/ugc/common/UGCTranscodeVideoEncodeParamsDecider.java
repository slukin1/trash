package com.tencent.ugc.common;

import android.media.MediaFormat;
import com.google.android.exoplayer2.DefaultControlDispatcher;
import com.sumsub.sns.internal.ml.autocapture.b;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.base.util.k;
import com.tencent.rtmp.downloader.TXVodDownloadDataSource;
import com.tencent.ugc.beauty.decoder.MediaUtils;
import com.tencent.ugc.common.UGCConstants;
import com.tencent.ugc.encoder.VideoEncodeParams;
import com.tencent.ugc.encoder.VideoEncoderDef;
import java.util.Iterator;
import java.util.List;

public class UGCTranscodeVideoEncodeParamsDecider {
    private static final String TAG = "UGCTranscodeVideoEncodeParamsDecider";
    private int mEncodeBitrate = 0;
    private VideoEncoderDef.EncoderProfile mEncodeProfile = VideoEncoderDef.EncoderProfile.PROFILE_HIGH;
    private k mEncodeRotation = k.NORMAL;
    private final Size mExpectSize = new Size(1080, 1920);
    private boolean mFullIFrame = false;
    private UGCConstants.SourceType mSourceType = UGCConstants.SourceType.VIDEO;
    private int mVideoCompress = 4;
    private List<MediaFormat> mVideoMediaFormatList;

    private Size adjustPictureOutSize(Size size, Size size2) {
        int i11;
        int i12;
        if (((double) ((float) size.aspectRatio())) >= size2.aspectRatio()) {
            i12 = size2.width;
            i11 = (int) (((double) i12) / size.aspectRatio());
        } else {
            i12 = (int) (((double) size2.height) * size.aspectRatio());
            i11 = size2.height;
        }
        Size size3 = new Size();
        size3.width = ((i12 + 1) / 2) * 2;
        size3.height = ((i11 + 1) / 2) * 2;
        LiteavLog.i(TAG, "origin= " + size + ", expectSize= " + size2 + ", outSize= " + size3);
        return size3;
    }

    private Size adjustVideoOutSize(Size size, Size size2) {
        int i11;
        int i12 = size.width;
        int i13 = size2.width;
        if ((i12 <= i13 && size.height <= size2.height) || (i12 <= size2.height && size.height <= i13)) {
            return new Size(size);
        }
        double aspectRatio = size.aspectRatio();
        if (size.width >= size.height) {
            i11 = Math.min((int) (((double) size2.width) * aspectRatio), size2.height);
        } else {
            i11 = Math.min((int) (((double) size2.height) * aspectRatio), size2.width);
        }
        Size size3 = new Size();
        size3.width = ((i11 + 1) / 2) * 2;
        size3.height = ((((int) (((double) i11) / aspectRatio)) + 1) / 2) * 2;
        LiteavLog.i(TAG, "adjustOutSize origin: " + size + ", expectSize: " + size2 + ", outSize: " + size3);
        return size3;
    }

    private int getDecidedGOP() {
        List<MediaFormat> list = this.mVideoMediaFormatList;
        if (list == null || list.size() == 0) {
            return 3;
        }
        return getNumberFromMediaFormat(this.mVideoMediaFormatList.get(0), "i-frame-interval", 3);
    }

    private Size getDecidedOutputSize() {
        Size size = new Size(0, 0);
        List<MediaFormat> list = this.mVideoMediaFormatList;
        if (list == null || list.size() == 0) {
            Size size2 = this.mExpectSize;
            if (size2 != null) {
                size = new Size(size2);
            }
        } else if (this.mVideoMediaFormatList.size() > 1) {
            size = getOutputSizeForMultipleSource(this.mVideoMediaFormatList);
        } else {
            size = getOutputSizeForSingleSource(this.mVideoMediaFormatList.get(0));
        }
        k kVar = this.mEncodeRotation;
        if (kVar == k.ROTATION_90 || kVar == k.ROTATION_270) {
            size.swap();
        }
        size.width = ((size.width + 1) / 2) * 2;
        size.height = ((size.height + 1) / 2) * 2;
        return size;
    }

    private int getDecidedVideoBitrate(Size size) {
        if (!this.mFullIFrame) {
            int i11 = this.mEncodeBitrate;
            if (i11 != 0) {
                return i11;
            }
            int i12 = this.mVideoCompress;
            if (i12 == 0 || i12 == 1) {
                return 2400;
            }
            if (i12 == 2) {
                return 6500;
            }
            if (i12 == 3) {
                return 9600;
            }
            if (i12 != 4) {
                return 5000;
            }
            return 12000;
        } else if (size.width >= 1280 || size.height >= 1280) {
            return 24000;
        } else {
            return DefaultControlDispatcher.DEFAULT_FAST_FORWARD_MS;
        }
    }

    private int getDecidedVideoFPS() {
        List<MediaFormat> list = this.mVideoMediaFormatList;
        if (list != null && list.size() == 1) {
            return getNumberFromMediaFormat(this.mVideoMediaFormatList.get(0), "frame-rate", 30);
        }
        return 30;
    }

    private int getNumberFromMediaFormat(MediaFormat mediaFormat, String str, int i11) {
        if (!mediaFormat.containsKey(str)) {
            return i11;
        }
        try {
            return mediaFormat.getInteger(str);
        } catch (ClassCastException e11) {
            LiteavLog.w(TAG, "getNumberFromMediaFormat integer ClassCastException: ".concat(String.valueOf(e11)));
            try {
                return (int) mediaFormat.getFloat(str);
            } catch (ClassCastException e12) {
                LiteavLog.w(TAG, "getNumberFromMediaFormat float ClassCastException: ".concat(String.valueOf(e12)));
                return i11;
            }
        }
    }

    private Size getOutputSizeForMultipleSource(List<MediaFormat> list) {
        boolean z11;
        Iterator<MediaFormat> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                z11 = true;
                break;
            }
            Size sizeFromMediaFormat = getSizeFromMediaFormat(it2.next());
            if (sizeFromMediaFormat.height > sizeFromMediaFormat.width) {
                z11 = false;
                break;
            }
        }
        Size size = new Size(this.mExpectSize);
        if (z11) {
            size.swap();
        }
        return size;
    }

    private Size getOutputSizeForSingleSource(MediaFormat mediaFormat) {
        if (mediaFormat == null) {
            return new Size(0, 0);
        }
        Size sizeFromMediaFormat = getSizeFromMediaFormat(mediaFormat);
        if (sizeFromMediaFormat.width == 0 || sizeFromMediaFormat.height == 0) {
            LiteavLog.i(TAG, "calculateGenerateSize origin: ".concat(String.valueOf(sizeFromMediaFormat)));
            return sizeFromMediaFormat;
        } else if (this.mSourceType == UGCConstants.SourceType.VIDEO) {
            return adjustVideoOutSize(sizeFromMediaFormat, this.mExpectSize);
        } else {
            return adjustPictureOutSize(sizeFromMediaFormat, this.mExpectSize);
        }
    }

    private Size getSizeFromMediaFormat(MediaFormat mediaFormat) {
        int i11;
        Size size = new Size();
        size.width = mediaFormat.getInteger("width");
        size.height = mediaFormat.getInteger("height");
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 23) {
            try {
                i11 = mediaFormat.getInteger(MediaUtils.KEY_ROTATION);
            } catch (Exception e11) {
                LiteavLog.i(TAG, "get KEY_ROTATION fail, ".concat(String.valueOf(e11)));
            }
            if (i11 == 90 || i11 == 270) {
                size.swap();
            }
            return size;
        }
        i11 = 0;
        size.swap();
        return size;
    }

    public VideoEncodeParams getDecidedEncodeParams() {
        VideoEncodeParams videoEncodeParams = new VideoEncodeParams();
        videoEncodeParams.annexb = true;
        videoEncodeParams.bitrateMode = VideoEncoderDef.BitrateMode.VBR;
        videoEncodeParams.fullIFrame = false;
        videoEncodeParams.isTranscodingMode = true;
        videoEncodeParams.encoderProfile = this.mEncodeProfile;
        Size decidedOutputSize = getDecidedOutputSize();
        videoEncodeParams.width = decidedOutputSize.width;
        videoEncodeParams.height = decidedOutputSize.height;
        videoEncodeParams.setFullIFrame(this.mFullIFrame);
        videoEncodeParams.gop = getDecidedGOP();
        videoEncodeParams.fps = getDecidedVideoFPS();
        videoEncodeParams.bitrate = getDecidedVideoBitrate(decidedOutputSize);
        LiteavLog.i(TAG, "getVideoEncodeParams: ".concat(String.valueOf(videoEncodeParams)));
        return videoEncodeParams;
    }

    public void setEncodeBitrate(int i11) {
        if (this.mEncodeBitrate != i11) {
            LiteavLog.i(TAG, "setVideoBitrate ".concat(String.valueOf(i11)));
            this.mEncodeBitrate = i11;
        }
    }

    public void setEncodeProfile(int i11) {
        LiteavLog.i(TAG, "setEncodeProfile ".concat(String.valueOf(i11)));
        if (i11 == 2) {
            this.mEncodeProfile = VideoEncoderDef.EncoderProfile.PROFILE_MAIN;
        } else if (i11 == 1) {
            this.mEncodeProfile = VideoEncoderDef.EncoderProfile.PROFILE_BASELINE;
        } else {
            this.mEncodeProfile = VideoEncoderDef.EncoderProfile.PROFILE_HIGH;
        }
    }

    public void setEncodeRotation(k kVar) {
        if (this.mEncodeRotation != kVar) {
            LiteavLog.i(TAG, "setRenderRotation ".concat(String.valueOf(kVar)));
            this.mEncodeRotation = kVar;
        }
    }

    public void setFullIFrame(boolean z11) {
        if (z11 != this.mFullIFrame) {
            LiteavLog.i(TAG, "setFullIFrame ".concat(String.valueOf(z11)));
            this.mFullIFrame = z11;
        }
    }

    public void setInputVideoMediaFormat(List<MediaFormat> list) {
        this.mVideoMediaFormatList = list;
    }

    public void setOutputResolution(int i11) {
        if (i11 != this.mVideoCompress) {
            this.mVideoCompress = i11;
            if (i11 == 0) {
                Size size = this.mExpectSize;
                size.width = 360;
                size.height = b.f34944a;
            } else if (i11 == 1) {
                Size size2 = this.mExpectSize;
                size2.width = TXVodDownloadDataSource.QUALITY_480P;
                size2.height = b.f34944a;
            } else if (i11 == 2) {
                Size size3 = this.mExpectSize;
                size3.width = TXVodDownloadDataSource.QUALITY_540P;
                size3.height = 960;
            } else if (i11 == 3) {
                Size size4 = this.mExpectSize;
                size4.width = 720;
                size4.height = 1280;
            } else if (i11 == 4) {
                Size size5 = this.mExpectSize;
                size5.width = 1080;
                size5.height = 1920;
            }
            LiteavLog.i(TAG, "setVideoCompress " + i11 + ", expectSize = " + this.mExpectSize);
        }
    }

    public void setSourceType(UGCConstants.SourceType sourceType) {
        if (this.mSourceType != sourceType) {
            LiteavLog.i(TAG, "setSourceType ".concat(String.valueOf(sourceType)));
            this.mSourceType = sourceType;
        }
    }
}
