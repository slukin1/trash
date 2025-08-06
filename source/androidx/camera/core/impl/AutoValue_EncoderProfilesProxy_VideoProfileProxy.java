package androidx.camera.core.impl;

import androidx.camera.core.impl.EncoderProfilesProxy;
import java.util.Objects;

final class AutoValue_EncoderProfilesProxy_VideoProfileProxy extends EncoderProfilesProxy.VideoProfileProxy {
    private final int bitDepth;
    private final int bitrate;
    private final int chromaSubsampling;
    private final int codec;
    private final int frameRate;
    private final int hdrFormat;
    private final int height;
    private final String mediaType;
    private final int profile;
    private final int width;

    public AutoValue_EncoderProfilesProxy_VideoProfileProxy(int i11, String str, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19) {
        this.codec = i11;
        Objects.requireNonNull(str, "Null mediaType");
        this.mediaType = str;
        this.bitrate = i12;
        this.frameRate = i13;
        this.width = i14;
        this.height = i15;
        this.profile = i16;
        this.bitDepth = i17;
        this.chromaSubsampling = i18;
        this.hdrFormat = i19;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EncoderProfilesProxy.VideoProfileProxy)) {
            return false;
        }
        EncoderProfilesProxy.VideoProfileProxy videoProfileProxy = (EncoderProfilesProxy.VideoProfileProxy) obj;
        if (this.codec == videoProfileProxy.getCodec() && this.mediaType.equals(videoProfileProxy.getMediaType()) && this.bitrate == videoProfileProxy.getBitrate() && this.frameRate == videoProfileProxy.getFrameRate() && this.width == videoProfileProxy.getWidth() && this.height == videoProfileProxy.getHeight() && this.profile == videoProfileProxy.getProfile() && this.bitDepth == videoProfileProxy.getBitDepth() && this.chromaSubsampling == videoProfileProxy.getChromaSubsampling() && this.hdrFormat == videoProfileProxy.getHdrFormat()) {
            return true;
        }
        return false;
    }

    public int getBitDepth() {
        return this.bitDepth;
    }

    public int getBitrate() {
        return this.bitrate;
    }

    public int getChromaSubsampling() {
        return this.chromaSubsampling;
    }

    public int getCodec() {
        return this.codec;
    }

    public int getFrameRate() {
        return this.frameRate;
    }

    public int getHdrFormat() {
        return this.hdrFormat;
    }

    public int getHeight() {
        return this.height;
    }

    public String getMediaType() {
        return this.mediaType;
    }

    public int getProfile() {
        return this.profile;
    }

    public int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return ((((((((((((((((((this.codec ^ 1000003) * 1000003) ^ this.mediaType.hashCode()) * 1000003) ^ this.bitrate) * 1000003) ^ this.frameRate) * 1000003) ^ this.width) * 1000003) ^ this.height) * 1000003) ^ this.profile) * 1000003) ^ this.bitDepth) * 1000003) ^ this.chromaSubsampling) * 1000003) ^ this.hdrFormat;
    }

    public String toString() {
        return "VideoProfileProxy{codec=" + this.codec + ", mediaType=" + this.mediaType + ", bitrate=" + this.bitrate + ", frameRate=" + this.frameRate + ", width=" + this.width + ", height=" + this.height + ", profile=" + this.profile + ", bitDepth=" + this.bitDepth + ", chromaSubsampling=" + this.chromaSubsampling + ", hdrFormat=" + this.hdrFormat + "}";
    }
}
