package com.tencent.thumbplayer.tcmedia.adapter.a.b;

import com.tencent.thumbplayer.tcmedia.adapter.strategy.utils.TPNativeKeyMap;
import com.tencent.thumbplayer.tcmedia.adapter.strategy.utils.TPNativeKeyMapUtil;
import com.tencent.thumbplayer.tcmedia.api.TPAudioAttributes;
import com.tencent.thumbplayer.tcmedia.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.tcmedia.api.TPDashFormat;
import com.tencent.thumbplayer.tcmedia.api.TPDrmInfo;
import com.tencent.thumbplayer.tcmedia.api.TPJitterBufferConfig;
import com.tencent.thumbplayer.tcmedia.api.TPPlayerDetailInfo;
import com.tencent.thumbplayer.tcmedia.api.TPPlayerMsg;
import com.tencent.thumbplayer.tcmedia.api.TPPostProcessFrameBuffer;
import com.tencent.thumbplayer.tcmedia.api.TPRemoteSdpInfo;
import com.tencent.thumbplayer.tcmedia.api.TPSubtitleFrameBuffer;
import com.tencent.thumbplayer.tcmedia.api.TPSubtitleRenderModel;
import com.tencent.thumbplayer.tcmedia.api.TPSurfaceDolbyVisionInfo;
import com.tencent.thumbplayer.tcmedia.api.TPSurfaceRenderInfo;
import com.tencent.thumbplayer.tcmedia.api.TPVideoFrameBuffer;
import com.tencent.thumbplayer.tcmedia.api.TPVideoPacketBuffer;
import com.tencent.thumbplayer.tcmedia.core.common.TPAudioFrame;
import com.tencent.thumbplayer.tcmedia.core.common.TPDetailInfo;
import com.tencent.thumbplayer.tcmedia.core.common.TPMediaTrackDashFormat;
import com.tencent.thumbplayer.tcmedia.core.common.TPNativeAudioAttributes;
import com.tencent.thumbplayer.tcmedia.core.common.TPPostProcessFrame;
import com.tencent.thumbplayer.tcmedia.core.common.TPSubtitleFrame;
import com.tencent.thumbplayer.tcmedia.core.common.TPVideoFrame;
import com.tencent.thumbplayer.tcmedia.core.common.TPVideoPacket;
import com.tencent.thumbplayer.tcmedia.core.demuxer.TPNativeJitterBufferConfig;
import com.tencent.thumbplayer.tcmedia.core.demuxer.TPNativeRemoteSdpInfo;
import com.tencent.thumbplayer.tcmedia.core.player.ITPNativePlayerMessageCallback;
import com.tencent.thumbplayer.tcmedia.core.player.TPGeneralPlayFlowParams;
import com.tencent.thumbplayer.tcmedia.core.player.TPNativePlayerSurfaceDolbyVisionInfo;
import com.tencent.thumbplayer.tcmedia.core.player.TPNativePlayerSurfaceRenderInfo;
import com.tencent.thumbplayer.tcmedia.core.subtitle.TPNativeSubtitleRenderParams;
import java.util.Arrays;
import java.util.Map;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static String f48856a = "TPThumbPlayerUtils";

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final int f48857a;

        /* renamed from: b  reason: collision with root package name */
        private final int f48858b;

        public a() {
            this.f48857a = -1;
            this.f48858b = -1;
        }

        public a(int i11, int i12) {
            this.f48857a = i11;
            this.f48858b = i12;
        }

        public boolean a() {
            return this.f48857a == -1 || this.f48858b == -1;
        }

        public int b() {
            return this.f48857a;
        }

        public int c() {
            return this.f48858b;
        }
    }

    private static long a(long j11) {
        long j12 = 0;
        for (Map.Entry next : TPNativeKeyMapUtil.getEntrySetOfToNativeMap(TPNativeKeyMap.MapSubtitleRenderParams.class)) {
            if ((((Number) next.getKey()).longValue() & j11) > 0) {
                j12 |= ((Number) next.getValue()).longValue();
            }
        }
        return j12;
    }

    public static TPAudioFrameBuffer a(TPAudioFrame tPAudioFrame) {
        if (tPAudioFrame == null) {
            return null;
        }
        TPAudioFrameBuffer tPAudioFrameBuffer = new TPAudioFrameBuffer();
        tPAudioFrameBuffer.format = TPNativeKeyMapUtil.toTPIntValue(TPNativeKeyMap.MapAudioSampleFormat.class, tPAudioFrame.format);
        tPAudioFrameBuffer.data = tPAudioFrame.data;
        tPAudioFrameBuffer.size = tPAudioFrame.linesize;
        tPAudioFrameBuffer.sampleRate = tPAudioFrame.sampleRate;
        tPAudioFrameBuffer.channelLayout = tPAudioFrame.channelLayout;
        tPAudioFrameBuffer.ptsMs = tPAudioFrame.ptsUs / 1000;
        tPAudioFrameBuffer.nbSamples = tPAudioFrame.nbSamples;
        tPAudioFrameBuffer.channels = tPAudioFrame.channels;
        return tPAudioFrameBuffer;
    }

    public static TPDashFormat a(TPMediaTrackDashFormat tPMediaTrackDashFormat) {
        if (tPMediaTrackDashFormat == null) {
            return null;
        }
        TPDashFormat tPDashFormat = new TPDashFormat();
        tPDashFormat.representationId = tPMediaTrackDashFormat.representationId;
        tPDashFormat.codecs = tPMediaTrackDashFormat.codecs;
        tPDashFormat.mimeType = tPMediaTrackDashFormat.mimeType;
        tPDashFormat.language = tPMediaTrackDashFormat.language;
        tPDashFormat.label = tPMediaTrackDashFormat.label;
        tPDashFormat.width = tPMediaTrackDashFormat.width;
        tPDashFormat.height = tPMediaTrackDashFormat.height;
        tPDashFormat.bandwidth = tPMediaTrackDashFormat.bandwidth;
        tPDashFormat.audioChannels = tPMediaTrackDashFormat.audioChannels;
        tPDashFormat.audioSamplingRate = tPMediaTrackDashFormat.audioSamplingRate;
        tPDashFormat.frameRate = tPMediaTrackDashFormat.frameRate;
        return tPDashFormat;
    }

    public static TPDrmInfo a(TPGeneralPlayFlowParams.TPPlayerDrmParams tPPlayerDrmParams) {
        TPDrmInfo tPDrmInfo = new TPDrmInfo();
        tPDrmInfo.drmSecureLevel = tPPlayerDrmParams.mSecureLevel;
        tPDrmInfo.drmSupportSecureDecoder = tPPlayerDrmParams.mSupportSecureDecoder;
        tPDrmInfo.drmSupportSecureDecrypt = tPPlayerDrmParams.mSupportSecureDecrypt;
        tPDrmInfo.drmComponentName = tPPlayerDrmParams.mComponentName;
        tPDrmInfo.drmType = TPNativeKeyMapUtil.toTPIntValue(TPNativeKeyMap.MapReportDrmType.class, tPPlayerDrmParams.mDrmType);
        tPDrmInfo.drmPrepareStartTimeMs = tPPlayerDrmParams.mPrepareSTimeMs;
        tPDrmInfo.drmPrepareEndTimeMs = tPPlayerDrmParams.mPrepareETimeMs;
        tPDrmInfo.drmOpenSessionStartTimeMs = tPPlayerDrmParams.mOpenSessionSTimeMs;
        tPDrmInfo.drmOpenSessionEndTimeMs = tPPlayerDrmParams.mOpenSessionETimeMs;
        tPDrmInfo.drmGetProvisionReqStartTimeMs = tPPlayerDrmParams.mGetProvisionReqSTimeMs;
        tPDrmInfo.drmGetProvisionReqEndTimeMs = tPPlayerDrmParams.mGetProvisionReqETimeMs;
        tPDrmInfo.drmSendProvisionReqTimeMs = tPPlayerDrmParams.mSendProvisionReqTimeMs;
        tPDrmInfo.drmRecvProvisionRespTimeMs = tPPlayerDrmParams.mRecvProvisionRespTimeMs;
        tPDrmInfo.drmProvideProvisionRespStartTimeMs = tPPlayerDrmParams.mProvideProvisionRespSTimeMs;
        tPDrmInfo.drmProvideProvisionRespEndTimeMs = tPPlayerDrmParams.mProvideProvisionRespETimeMs;
        tPDrmInfo.drmGetKeyReqStartTimeMs = tPPlayerDrmParams.mGetKeyReqSTimeMs;
        tPDrmInfo.drmGetKeyReqEndTimeMs = tPPlayerDrmParams.mGetKeyReqETimeMs;
        tPDrmInfo.drmSendKeyReqTimeMs = tPPlayerDrmParams.mSendKeyReqTimeMs;
        tPDrmInfo.drmRecvKeyRespTimeMs = tPPlayerDrmParams.mRecvKeyRespTimeMs;
        tPDrmInfo.drmProvideKeyRespStartTimeMs = tPPlayerDrmParams.mProvideKeyRespSTimeMs;
        tPDrmInfo.drmProvideKeyRespEndTimeMs = tPPlayerDrmParams.mProvideKeyRespETimeMs;
        return tPDrmInfo;
    }

    public static TPPlayerDetailInfo a(TPDetailInfo tPDetailInfo) {
        if (tPDetailInfo == null) {
            return null;
        }
        return new TPPlayerDetailInfo(TPNativeKeyMapUtil.toTPIntValue(TPNativeKeyMap.MapDetailInfoType.class, tPDetailInfo.type), tPDetailInfo.timeSince1970Us / 1000);
    }

    public static TPPlayerMsg.TPMediaCodecInfo a(ITPNativePlayerMessageCallback.MediaCodecInfo mediaCodecInfo) {
        if (mediaCodecInfo == null) {
            return null;
        }
        TPPlayerMsg.TPMediaCodecInfo tPMediaCodecInfo = new TPPlayerMsg.TPMediaCodecInfo();
        int i11 = mediaCodecInfo.mediaType;
        tPMediaCodecInfo.mediaType = i11 != 0 ? i11 != 1 ? TPPlayerMsg.TPMediaCodecInfo.TP_DEC_MEDIA_TYPE_UNKNOWN : TPPlayerMsg.TPMediaCodecInfo.TP_DEC_MEDIA_TYPE_AUDIO : TPPlayerMsg.TPMediaCodecInfo.TP_DEC_MEDIA_TYPE_VIDEO;
        int i12 = mediaCodecInfo.infoType;
        tPMediaCodecInfo.infoType = i12 != 0 ? i12 != 1 ? TPPlayerMsg.TPMediaCodecInfo.TP_INFO_UNKNOWN : TPPlayerMsg.TPMediaCodecInfo.TP_INFO_MEDIA_CODEC_EXCEPTION : TPPlayerMsg.TPMediaCodecInfo.TP_INFO_MEDIA_CODEC_READY;
        tPMediaCodecInfo.msg = mediaCodecInfo.msg;
        return tPMediaCodecInfo;
    }

    public static TPPlayerMsg.TPMediaDrmInfo a(ITPNativePlayerMessageCallback.MediaDrmInfo mediaDrmInfo) {
        if (mediaDrmInfo == null) {
            return null;
        }
        TPPlayerMsg.TPMediaDrmInfo tPMediaDrmInfo = new TPPlayerMsg.TPMediaDrmInfo();
        tPMediaDrmInfo.supportSecureDecoder = mediaDrmInfo.supportSecureDecoder;
        tPMediaDrmInfo.supportSecureDecrypt = mediaDrmInfo.supportSecureDecrypt;
        tPMediaDrmInfo.componentName = mediaDrmInfo.componentName;
        tPMediaDrmInfo.drmType = TPNativeKeyMapUtil.toTPIntValue(TPNativeKeyMap.MapDrmType.class, mediaDrmInfo.drmType);
        return tPMediaDrmInfo;
    }

    public static TPPlayerMsg.TPVideoCropInfo a(ITPNativePlayerMessageCallback.VideoCropInfo videoCropInfo) {
        if (videoCropInfo == null) {
            return null;
        }
        TPPlayerMsg.TPVideoCropInfo tPVideoCropInfo = new TPPlayerMsg.TPVideoCropInfo();
        tPVideoCropInfo.width = videoCropInfo.width;
        tPVideoCropInfo.height = videoCropInfo.height;
        tPVideoCropInfo.cropLeft = videoCropInfo.cropLeft;
        tPVideoCropInfo.cropRight = videoCropInfo.cropRight;
        tPVideoCropInfo.cropTop = videoCropInfo.cropTop;
        tPVideoCropInfo.cropBottom = videoCropInfo.cropBottom;
        return tPVideoCropInfo;
    }

    public static TPPlayerMsg.TPVideoSeiInfo a(ITPNativePlayerMessageCallback.VideoSeiInfo videoSeiInfo) {
        Class cls;
        int tPIntValue;
        if (videoSeiInfo == null) {
            return null;
        }
        TPPlayerMsg.TPVideoSeiInfo tPVideoSeiInfo = new TPPlayerMsg.TPVideoSeiInfo();
        int tPIntValue2 = TPNativeKeyMapUtil.toTPIntValue(TPNativeKeyMap.MapCodecType.class, videoSeiInfo.videoCodecType);
        tPVideoSeiInfo.videoCodecType = tPIntValue2;
        if (videoSeiInfo.isSpecialType) {
            tPIntValue = videoSeiInfo.videoSeiType;
        } else {
            if (tPIntValue2 == 26) {
                cls = TPNativeKeyMap.MapVideoH264SeiType.class;
            } else {
                if (tPIntValue2 == 172) {
                    cls = TPNativeKeyMap.MapVideoHevcSeiType.class;
                }
                int i11 = videoSeiInfo.dataSize;
                tPVideoSeiInfo.seiDataSize = i11;
                tPVideoSeiInfo.seiData = Arrays.copyOf(videoSeiInfo.data, i11);
                return tPVideoSeiInfo;
            }
            tPIntValue = TPNativeKeyMapUtil.toTPIntValue(cls, videoSeiInfo.videoSeiType);
        }
        tPVideoSeiInfo.videoSeiType = tPIntValue;
        int i112 = videoSeiInfo.dataSize;
        tPVideoSeiInfo.seiDataSize = i112;
        tPVideoSeiInfo.seiData = Arrays.copyOf(videoSeiInfo.data, i112);
        return tPVideoSeiInfo;
    }

    public static TPPostProcessFrameBuffer a(TPPostProcessFrame tPPostProcessFrame) {
        Class cls;
        if (tPPostProcessFrame == null) {
            return null;
        }
        TPPostProcessFrameBuffer tPPostProcessFrameBuffer = new TPPostProcessFrameBuffer();
        int tPIntValue = TPNativeKeyMapUtil.toTPIntValue(TPNativeKeyMap.MapMediaType.class, tPPostProcessFrame.mediaType);
        tPPostProcessFrameBuffer.mediaType = tPIntValue;
        if (tPIntValue == 0) {
            cls = TPNativeKeyMap.MapPixelFormat.class;
        } else {
            if (tPIntValue == 1) {
                cls = TPNativeKeyMap.MapAudioSampleFormat.class;
            }
            tPPostProcessFrameBuffer.data = tPPostProcessFrame.data;
            tPPostProcessFrameBuffer.size = tPPostProcessFrame.linesize;
            tPPostProcessFrameBuffer.sampleRate = tPPostProcessFrame.sampleRate;
            tPPostProcessFrameBuffer.channelLayout = tPPostProcessFrame.channelLayout;
            tPPostProcessFrameBuffer.ptsMs = tPPostProcessFrame.ptsUs / 1000;
            tPPostProcessFrameBuffer.nbSamples = tPPostProcessFrame.nbSamples;
            tPPostProcessFrameBuffer.channels = tPPostProcessFrame.channels;
            tPPostProcessFrameBuffer.width = tPPostProcessFrame.width;
            tPPostProcessFrameBuffer.height = tPPostProcessFrame.height;
            tPPostProcessFrameBuffer.sampleAspectRatioNum = tPPostProcessFrame.sampleAspectRatioNum;
            tPPostProcessFrameBuffer.sampleAspectRatioDen = tPPostProcessFrame.sampleAspectRatioDen;
            tPPostProcessFrameBuffer.rotation = tPPostProcessFrame.rotation;
            tPPostProcessFrameBuffer.perfData = tPPostProcessFrame.perfData;
            return tPPostProcessFrameBuffer;
        }
        tPPostProcessFrameBuffer.format = TPNativeKeyMapUtil.toTPIntValue(cls, tPPostProcessFrame.format);
        tPPostProcessFrameBuffer.data = tPPostProcessFrame.data;
        tPPostProcessFrameBuffer.size = tPPostProcessFrame.linesize;
        tPPostProcessFrameBuffer.sampleRate = tPPostProcessFrame.sampleRate;
        tPPostProcessFrameBuffer.channelLayout = tPPostProcessFrame.channelLayout;
        tPPostProcessFrameBuffer.ptsMs = tPPostProcessFrame.ptsUs / 1000;
        tPPostProcessFrameBuffer.nbSamples = tPPostProcessFrame.nbSamples;
        tPPostProcessFrameBuffer.channels = tPPostProcessFrame.channels;
        tPPostProcessFrameBuffer.width = tPPostProcessFrame.width;
        tPPostProcessFrameBuffer.height = tPPostProcessFrame.height;
        tPPostProcessFrameBuffer.sampleAspectRatioNum = tPPostProcessFrame.sampleAspectRatioNum;
        tPPostProcessFrameBuffer.sampleAspectRatioDen = tPPostProcessFrame.sampleAspectRatioDen;
        tPPostProcessFrameBuffer.rotation = tPPostProcessFrame.rotation;
        tPPostProcessFrameBuffer.perfData = tPPostProcessFrame.perfData;
        return tPPostProcessFrameBuffer;
    }

    public static TPSubtitleFrameBuffer a(TPSubtitleFrame tPSubtitleFrame) {
        if (tPSubtitleFrame == null) {
            return null;
        }
        TPSubtitleFrameBuffer tPSubtitleFrameBuffer = new TPSubtitleFrameBuffer();
        tPSubtitleFrameBuffer.data = tPSubtitleFrame.data;
        tPSubtitleFrameBuffer.lineSize = tPSubtitleFrame.linesize;
        tPSubtitleFrameBuffer.format = TPNativeKeyMapUtil.toTPIntValue(TPNativeKeyMap.MapSubtitleFormat.class, tPSubtitleFrame.format);
        int i11 = tPSubtitleFrame.height;
        tPSubtitleFrameBuffer.srcHeight = i11;
        int i12 = tPSubtitleFrame.width;
        tPSubtitleFrameBuffer.srcWidth = i12;
        tPSubtitleFrameBuffer.dstHeight = i11;
        tPSubtitleFrameBuffer.dstWidth = i12;
        tPSubtitleFrameBuffer.rotation = tPSubtitleFrame.rotation;
        tPSubtitleFrameBuffer.ptsMs = tPSubtitleFrame.ptsUs / 1000;
        return tPSubtitleFrameBuffer;
    }

    public static TPSurfaceDolbyVisionInfo a(TPNativePlayerSurfaceDolbyVisionInfo tPNativePlayerSurfaceDolbyVisionInfo) {
        if (tPNativePlayerSurfaceDolbyVisionInfo == null) {
            return null;
        }
        TPSurfaceDolbyVisionInfo tPSurfaceDolbyVisionInfo = new TPSurfaceDolbyVisionInfo();
        tPSurfaceDolbyVisionInfo.mProfile = tPNativePlayerSurfaceDolbyVisionInfo.mProfile;
        tPSurfaceDolbyVisionInfo.mLevel = tPNativePlayerSurfaceDolbyVisionInfo.mLevel;
        tPSurfaceDolbyVisionInfo.mBlSignalCompatibilityId = tPNativePlayerSurfaceDolbyVisionInfo.mBlSignalCompatibilityId;
        return tPSurfaceDolbyVisionInfo;
    }

    private static TPSurfaceRenderInfo.TPVideoCropInfo a(TPNativePlayerSurfaceRenderInfo.TPVideoCropInfo tPVideoCropInfo) {
        if (tPVideoCropInfo == null) {
            return null;
        }
        TPSurfaceRenderInfo.TPVideoCropInfo tPVideoCropInfo2 = new TPSurfaceRenderInfo.TPVideoCropInfo();
        tPVideoCropInfo2.cropLeft = tPVideoCropInfo.cropLeft;
        tPVideoCropInfo2.cropRight = tPVideoCropInfo.cropRight;
        tPVideoCropInfo2.cropTop = tPVideoCropInfo.cropTop;
        tPVideoCropInfo2.cropBottom = tPVideoCropInfo.cropBottom;
        tPVideoCropInfo2.width = tPVideoCropInfo.width;
        tPVideoCropInfo2.height = tPVideoCropInfo.height;
        return tPVideoCropInfo2;
    }

    public static TPSurfaceRenderInfo a(TPNativePlayerSurfaceRenderInfo tPNativePlayerSurfaceRenderInfo) {
        if (tPNativePlayerSurfaceRenderInfo == null) {
            return null;
        }
        TPSurfaceRenderInfo tPSurfaceRenderInfo = new TPSurfaceRenderInfo();
        tPSurfaceRenderInfo.displayWidth = tPNativePlayerSurfaceRenderInfo.displayWidth;
        tPSurfaceRenderInfo.displayHeight = tPNativePlayerSurfaceRenderInfo.displayHeight;
        tPSurfaceRenderInfo.videoCropInfo = a(tPNativePlayerSurfaceRenderInfo.videoCropInfo);
        return tPSurfaceRenderInfo;
    }

    public static TPVideoFrameBuffer a(TPVideoFrame tPVideoFrame) {
        int i11;
        TPVideoFrameBuffer tPVideoFrameBuffer = new TPVideoFrameBuffer();
        tPVideoFrameBuffer.data = tPVideoFrame.data;
        tPVideoFrameBuffer.lineSize = tPVideoFrame.linesize;
        tPVideoFrameBuffer.format = TPNativeKeyMapUtil.toTPIntValue(TPNativeKeyMap.MapPixelFormat.class, tPVideoFrame.format);
        int i12 = tPVideoFrame.height;
        tPVideoFrameBuffer.srcHeight = i12;
        int i13 = tPVideoFrame.width;
        tPVideoFrameBuffer.srcWidth = i13;
        tPVideoFrameBuffer.dstHeight = i12;
        tPVideoFrameBuffer.dstWidth = i13;
        int i14 = tPVideoFrame.sampleAspectRatioDen;
        if (i14 > 0 && (i11 = tPVideoFrame.sampleAspectRatioNum) > 0) {
            tPVideoFrameBuffer.dstWidth = Math.round((((float) i11) / ((float) i14)) * ((float) i13));
        }
        tPVideoFrameBuffer.rotation = tPVideoFrame.rotation;
        tPVideoFrameBuffer.ptsMs = tPVideoFrame.ptsUs / 1000;
        return tPVideoFrameBuffer;
    }

    public static TPVideoPacketBuffer a(TPVideoPacket tPVideoPacket) {
        if (tPVideoPacket == null) {
            return null;
        }
        TPVideoPacketBuffer tPVideoPacketBuffer = new TPVideoPacketBuffer();
        tPVideoPacketBuffer.mData = tPVideoPacket.mData;
        tPVideoPacketBuffer.mSize = tPVideoPacket.mSize;
        tPVideoPacketBuffer.mPtsMs = tPVideoPacket.mPtsUs / 1000;
        tPVideoPacketBuffer.mDtsMs = tPVideoPacket.mDtsUs / 1000;
        tPVideoPacketBuffer.mDolbyVisionInfo = a(tPVideoPacket.mDolbyVisionInfo);
        return tPVideoPacketBuffer;
    }

    public static TPNativeAudioAttributes a(TPAudioAttributes tPAudioAttributes) {
        if (tPAudioAttributes == null) {
            return null;
        }
        int nativeIntValue = TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapTPAudioAttributeUsage.class, tPAudioAttributes.getUsage());
        int nativeIntValue2 = TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapTPAudioAttributeUsage.class, tPAudioAttributes.getContentType());
        int i11 = 0;
        if ((tPAudioAttributes.getFlags() & 1) != 0) {
            i11 = 1;
        }
        if ((tPAudioAttributes.getFlags() & 16) != 0) {
            i11 |= 16;
        }
        if ((tPAudioAttributes.getFlags() & 256) != 0) {
            i11 |= 256;
        }
        return new TPNativeAudioAttributes.Builder().setUsage(nativeIntValue).setContentType(nativeIntValue2).setFlags(i11).build();
    }

    public static TPPostProcessFrame a(TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
        Class cls;
        if (tPPostProcessFrameBuffer == null) {
            return null;
        }
        TPPostProcessFrame tPPostProcessFrame = new TPPostProcessFrame();
        int nativeIntValue = TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapMediaType.class, tPPostProcessFrameBuffer.mediaType);
        tPPostProcessFrame.mediaType = nativeIntValue;
        if (nativeIntValue == 0) {
            cls = TPNativeKeyMap.MapPixelFormat.class;
        } else {
            if (nativeIntValue == 1) {
                cls = TPNativeKeyMap.MapAudioSampleFormat.class;
            }
            tPPostProcessFrame.data = tPPostProcessFrameBuffer.data;
            tPPostProcessFrame.linesize = tPPostProcessFrameBuffer.size;
            tPPostProcessFrame.sampleRate = tPPostProcessFrameBuffer.sampleRate;
            tPPostProcessFrame.channelLayout = tPPostProcessFrameBuffer.channelLayout;
            tPPostProcessFrame.ptsUs = tPPostProcessFrameBuffer.ptsMs * 1000;
            tPPostProcessFrame.nbSamples = tPPostProcessFrameBuffer.nbSamples;
            tPPostProcessFrame.channels = tPPostProcessFrameBuffer.channels;
            tPPostProcessFrame.width = tPPostProcessFrameBuffer.width;
            tPPostProcessFrame.height = tPPostProcessFrameBuffer.height;
            tPPostProcessFrame.sampleAspectRatioNum = tPPostProcessFrameBuffer.sampleAspectRatioNum;
            tPPostProcessFrame.sampleAspectRatioDen = tPPostProcessFrameBuffer.sampleAspectRatioDen;
            tPPostProcessFrame.rotation = tPPostProcessFrameBuffer.rotation;
            tPPostProcessFrame.perfData = tPPostProcessFrameBuffer.perfData;
            return tPPostProcessFrame;
        }
        tPPostProcessFrame.format = TPNativeKeyMapUtil.toNativeIntValue(cls, tPPostProcessFrameBuffer.format);
        tPPostProcessFrame.data = tPPostProcessFrameBuffer.data;
        tPPostProcessFrame.linesize = tPPostProcessFrameBuffer.size;
        tPPostProcessFrame.sampleRate = tPPostProcessFrameBuffer.sampleRate;
        tPPostProcessFrame.channelLayout = tPPostProcessFrameBuffer.channelLayout;
        tPPostProcessFrame.ptsUs = tPPostProcessFrameBuffer.ptsMs * 1000;
        tPPostProcessFrame.nbSamples = tPPostProcessFrameBuffer.nbSamples;
        tPPostProcessFrame.channels = tPPostProcessFrameBuffer.channels;
        tPPostProcessFrame.width = tPPostProcessFrameBuffer.width;
        tPPostProcessFrame.height = tPPostProcessFrameBuffer.height;
        tPPostProcessFrame.sampleAspectRatioNum = tPPostProcessFrameBuffer.sampleAspectRatioNum;
        tPPostProcessFrame.sampleAspectRatioDen = tPPostProcessFrameBuffer.sampleAspectRatioDen;
        tPPostProcessFrame.rotation = tPPostProcessFrameBuffer.rotation;
        tPPostProcessFrame.perfData = tPPostProcessFrameBuffer.perfData;
        return tPPostProcessFrame;
    }

    public static TPNativeJitterBufferConfig a(TPJitterBufferConfig tPJitterBufferConfig) {
        if (tPJitterBufferConfig == null) {
            return null;
        }
        return new TPNativeJitterBufferConfig.Builder().setMinDecreaseDurationMs(tPJitterBufferConfig.getMinDecreaseDurationMs()).setMaxIncreaseDurationMs(tPJitterBufferConfig.getMaxIncreaseDurationMs()).setPerIncreaseDurationMs(tPJitterBufferConfig.getPerIncreaseDurationMs()).setPerDecreaseDurationMs(tPJitterBufferConfig.getPerDecreaseDurationMs()).setAdjustIntervalThresholdMs(tPJitterBufferConfig.getAdjustIntervalThresholdMs()).setFrozenThresholdMs(tPJitterBufferConfig.getFrozenThresholdMs()).build();
    }

    public static TPNativeRemoteSdpInfo a(TPRemoteSdpInfo tPRemoteSdpInfo) {
        if (tPRemoteSdpInfo == null) {
            return null;
        }
        TPNativeRemoteSdpInfo tPNativeRemoteSdpInfo = new TPNativeRemoteSdpInfo();
        tPNativeRemoteSdpInfo.isSuccess = tPRemoteSdpInfo.isSuccess;
        tPNativeRemoteSdpInfo.remoteSdp = tPRemoteSdpInfo.remoteSdp;
        return tPNativeRemoteSdpInfo;
    }

    public static TPNativeSubtitleRenderParams a(TPSubtitleRenderModel tPSubtitleRenderModel) {
        if (tPSubtitleRenderModel == null) {
            return null;
        }
        TPNativeSubtitleRenderParams tPNativeSubtitleRenderParams = new TPNativeSubtitleRenderParams();
        tPNativeSubtitleRenderParams.canvasWidth = tPSubtitleRenderModel.canvasWidth;
        tPNativeSubtitleRenderParams.canvasHeight = tPSubtitleRenderModel.canvasHeight;
        tPNativeSubtitleRenderParams.paramFlags = a(tPSubtitleRenderModel.paramFlags);
        tPNativeSubtitleRenderParams.paramPriorityFlags = a(tPSubtitleRenderModel.paramPriorityFlags);
        tPNativeSubtitleRenderParams.familyName = tPSubtitleRenderModel.familyName;
        tPNativeSubtitleRenderParams.fontSize = tPSubtitleRenderModel.fontSize;
        tPNativeSubtitleRenderParams.fontColor = tPSubtitleRenderModel.fontColor;
        tPNativeSubtitleRenderParams.fontStyleFlags = b((long) tPSubtitleRenderModel.fontStyleFlags);
        tPNativeSubtitleRenderParams.outlineWidth = tPSubtitleRenderModel.outlineWidth;
        tPNativeSubtitleRenderParams.outlineColor = tPSubtitleRenderModel.outlineColor;
        tPNativeSubtitleRenderParams.lineSpace = tPSubtitleRenderModel.lineSpace;
        tPNativeSubtitleRenderParams.startMargin = tPSubtitleRenderModel.startMargin;
        tPNativeSubtitleRenderParams.endMargin = tPSubtitleRenderModel.endMargin;
        tPNativeSubtitleRenderParams.verticalMargin = tPSubtitleRenderModel.verticalMargin;
        tPNativeSubtitleRenderParams.fontScale = tPSubtitleRenderModel.fontScale;
        return tPNativeSubtitleRenderParams;
    }

    private static int b(long j11) {
        int i11 = 0;
        for (Map.Entry next : TPNativeKeyMapUtil.getEntrySetOfToNativeMap(TPNativeKeyMap.MapSubtitleFontStyle.class)) {
            if ((((long) ((Number) next.getKey()).intValue()) & j11) > 0) {
                i11 |= ((Number) next.getValue()).intValue();
            }
        }
        return i11;
    }
}
