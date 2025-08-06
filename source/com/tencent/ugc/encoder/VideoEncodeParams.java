package com.tencent.ugc.encoder;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.CommonUtil;
import com.tencent.ugc.encoder.VideoEncoderDef;
import com.tencent.ugc.videobase.base.GLConstants;
import com.tencent.ugc.videobase.common.CodecType;
import java.lang.reflect.Field;
import org.json.JSONArray;
import org.json.JSONException;

@JNINamespace("liteav::ugc")
public final class VideoEncodeParams implements Cloneable {
    public boolean annexb = true;
    public long baseFrameIndex = 0;
    public long baseGopIndex = 0;
    public int bitrate = 0;
    public VideoEncoderDef.BitrateMode bitrateMode = VideoEncoderDef.BitrateMode.CBR;
    public CodecType codecType = CodecType.H264;
    public GLConstants.ColorRange colorRange = GLConstants.ColorRange.UNKNOWN;
    public GLConstants.ColorSpace colorSpace = GLConstants.ColorSpace.UNKNOWN;
    public boolean enableBFrame = false;
    public VideoEncoderDef.EncodeScene encodeScene = VideoEncoderDef.EncodeScene.kCameraRealTime;
    public VideoEncoderDef.EncoderComplexity encoderComplexity = null;
    public VideoEncoderDef.EncoderProfile encoderProfile = null;
    public int fps = 20;
    public boolean fullIFrame = false;
    public int gop = 3;
    public int height = 0;
    public boolean isTranscodingMode = false;
    public JSONArray mediaCodecDeviceRelatedParams = null;
    public VideoEncoderDef.ReferenceStrategy referenceStrategy = VideoEncoderDef.ReferenceStrategy.FIX_GOP;
    public int width = 0;

    public VideoEncodeParams() {
    }

    private int checkFieldDiffCounts(Object obj, Object obj2) {
        int i11 = 0;
        for (Field field : VideoEncodeParams.class.getDeclaredFields()) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            try {
                if (!CommonUtil.equals(field.get(obj), field.get(obj2))) {
                    i11++;
                }
            } catch (IllegalAccessException e11) {
                e11.printStackTrace();
            }
        }
        return i11;
    }

    public static VideoEncoderDef.EncodeScene createEncodeScene(int i11) {
        return VideoEncoderDef.EncodeScene.fromInteger(i11);
    }

    public static VideoEncoderDef.BitrateMode createEncoderBitrateMode(int i11) {
        return VideoEncoderDef.BitrateMode.fromInteger(i11);
    }

    public static VideoEncoderDef.EncoderComplexity createEncoderComplexity(int i11) {
        return VideoEncoderDef.EncoderComplexity.fromInteger(i11);
    }

    public static VideoEncoderDef.EncoderProfile createEncoderProfileType(int i11) {
        return VideoEncoderDef.EncoderProfile.fromInteger(i11);
    }

    public static CodecType createEncoderVideoCodec(int i11) {
        return CodecType.fromInteger(i11);
    }

    public static VideoEncoderDef.ReferenceStrategy createReferenceStrategy(int i11) {
        return VideoEncoderDef.ReferenceStrategy.fromInteger(i11);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof VideoEncodeParams) || checkFieldDiffCounts(this, obj) != 0) {
            return false;
        }
        return true;
    }

    public final long getBaseFrameIndex() {
        return this.baseFrameIndex;
    }

    public final long getBaseGopIndex() {
        return this.baseGopIndex;
    }

    public final int getBitrate() {
        return this.bitrate;
    }

    public final int getBitrateMode() {
        return this.bitrateMode.getValue();
    }

    public final int getCodecType() {
        return this.codecType.getValue();
    }

    public final int getColorRange() {
        GLConstants.ColorRange colorRange2 = this.colorRange;
        return colorRange2 != null ? colorRange2.getValue() : GLConstants.ColorSpace.UNKNOWN.getValue();
    }

    public final int getColorSpace() {
        GLConstants.ColorSpace colorSpace2 = this.colorSpace;
        return colorSpace2 != null ? colorSpace2.getValue() : GLConstants.ColorRange.UNKNOWN.getValue();
    }

    public final int getEncodeScene() {
        VideoEncoderDef.EncodeScene encodeScene2 = this.encodeScene;
        if (encodeScene2 == null) {
            return VideoEncoderDef.EncodeScene.kCameraRealTime.getValue();
        }
        return encodeScene2.getValue();
    }

    public final int getEncoderComplexity() {
        VideoEncoderDef.EncoderComplexity encoderComplexity2 = this.encoderComplexity;
        if (encoderComplexity2 == null) {
            return VideoEncoderDef.EncoderComplexity.VERY_FAST.getValue();
        }
        return encoderComplexity2.getValue();
    }

    public final int getEncoderProfile() {
        return this.encoderProfile.getValue();
    }

    public final int getFps() {
        return this.fps;
    }

    public final int getGop() {
        return this.gop;
    }

    public final int getHeight() {
        return this.height;
    }

    public final JSONArray getMediaCodecDeviceRelatedParams() {
        return this.mediaCodecDeviceRelatedParams;
    }

    public final VideoEncoderDef.ReferenceStrategy getReferenceStrategy() {
        return this.referenceStrategy;
    }

    public final int getWidth() {
        return this.width;
    }

    public final boolean isAnnexb() {
        return this.annexb;
    }

    public final boolean isEnablesBframe() {
        return this.enableBFrame;
    }

    public final boolean isEnablesRps() {
        return this.referenceStrategy == VideoEncoderDef.ReferenceStrategy.RPS;
    }

    public final boolean isEnablesSvc() {
        return this.referenceStrategy == VideoEncoderDef.ReferenceStrategy.SVC;
    }

    public final boolean isEnablesUnlimitedGop() {
        return this.referenceStrategy == VideoEncoderDef.ReferenceStrategy.UNLIMITED_GOP;
    }

    public final boolean isFullIFrame() {
        return this.fullIFrame;
    }

    public final boolean isTranscodingMode() {
        return this.isTranscodingMode;
    }

    public final void setAnnexb(boolean z11) {
        this.annexb = z11;
    }

    public final void setBFrameEnabled(boolean z11) {
        this.enableBFrame = z11;
    }

    public final void setBaseFrameIndex(long j11) {
        this.baseFrameIndex = j11;
    }

    public final void setBaseGopIndex(long j11) {
        this.baseGopIndex = j11;
    }

    public final void setBitrate(int i11) {
        this.bitrate = i11;
    }

    public final void setBitrateMode(VideoEncoderDef.BitrateMode bitrateMode2) {
        this.bitrateMode = bitrateMode2;
    }

    public final void setCodecType(CodecType codecType2) {
        this.codecType = codecType2;
    }

    public final void setEncodeScene(VideoEncoderDef.EncodeScene encodeScene2) {
        this.encodeScene = encodeScene2;
    }

    public final void setEncoderComplexity(VideoEncoderDef.EncoderComplexity encoderComplexity2) {
        this.encoderComplexity = encoderComplexity2;
    }

    public final void setEncoderProfile(VideoEncoderDef.EncoderProfile encoderProfile2) {
        this.encoderProfile = encoderProfile2;
    }

    public final void setFps(int i11) {
        this.fps = i11;
    }

    public final void setFullIFrame(boolean z11) {
        this.fullIFrame = z11;
    }

    public final void setGop(int i11) {
        this.gop = i11;
    }

    public final void setHeight(int i11) {
        this.height = i11;
    }

    public final void setMediaCodecDeviceRelatedParams(JSONArray jSONArray) {
        this.mediaCodecDeviceRelatedParams = jSONArray;
    }

    public final void setReferenceStrategy(VideoEncoderDef.ReferenceStrategy referenceStrategy2) {
        this.referenceStrategy = referenceStrategy2;
    }

    public final void setTranscodingModeEnabled(boolean z11) {
        this.isTranscodingMode = z11;
    }

    public final void setWidth(int i11) {
        this.width = i11;
    }

    public final String toString() {
        return "width=" + this.width + ", height=" + this.height + ", fps=" + this.fps + ", gop=" + this.gop + ", bitrate=" + this.bitrate + ", annexb=" + this.annexb + ", encoderProfile=" + this.encoderProfile + ", bitrateMode=" + this.bitrateMode + ", baseFrameIndex=" + this.baseFrameIndex + ", baseGopIndex=" + this.baseGopIndex + ", fullIFrame=" + this.fullIFrame + ", enableBFrame=" + this.enableBFrame + ", referenceStrategy=" + this.referenceStrategy + ", codecType=" + this.codecType + ", isTransCodingMode=" + this.isTranscodingMode + ", mediaCodecDeviceRelatedParams=" + this.mediaCodecDeviceRelatedParams + ", encoderComplexity=" + this.encoderComplexity + ", encodeScene=" + this.encodeScene + ", colorRange=" + this.colorRange + ", colorSpace=" + this.colorSpace;
    }

    public VideoEncodeParams(VideoEncodeParams videoEncodeParams) {
        if (videoEncodeParams != null) {
            this.width = videoEncodeParams.width;
            this.height = videoEncodeParams.height;
            this.fps = videoEncodeParams.fps;
            this.gop = videoEncodeParams.gop;
            this.bitrate = videoEncodeParams.bitrate;
            this.annexb = videoEncodeParams.annexb;
            this.encoderProfile = videoEncodeParams.encoderProfile;
            this.bitrateMode = videoEncodeParams.bitrateMode;
            this.baseFrameIndex = videoEncodeParams.baseFrameIndex;
            this.baseGopIndex = videoEncodeParams.baseGopIndex;
            this.fullIFrame = videoEncodeParams.fullIFrame;
            this.enableBFrame = videoEncodeParams.enableBFrame;
            this.codecType = videoEncodeParams.codecType;
            this.referenceStrategy = videoEncodeParams.referenceStrategy;
            this.isTranscodingMode = videoEncodeParams.isTranscodingMode;
            this.encoderComplexity = videoEncodeParams.encoderComplexity;
            this.encodeScene = videoEncodeParams.encodeScene;
            this.colorSpace = videoEncodeParams.colorSpace;
            this.colorRange = videoEncodeParams.colorRange;
            if (videoEncodeParams.mediaCodecDeviceRelatedParams != null) {
                try {
                    this.mediaCodecDeviceRelatedParams = new JSONArray(videoEncodeParams.mediaCodecDeviceRelatedParams.toString());
                } catch (JSONException unused) {
                }
            }
        }
    }
}
