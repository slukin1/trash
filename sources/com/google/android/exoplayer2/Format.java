package com.google.android.exoplayer2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.ExoMediaCrypto;
import com.google.android.exoplayer2.drm.UnsupportedMediaCrypto;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.ColorInfo;
import com.iproov.sdk.bridge.OptionsBridge;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Format implements Parcelable {
    public static final Parcelable.Creator<Format> CREATOR = new Parcelable.Creator<Format>() {
        public Format createFromParcel(Parcel parcel) {
            return new Format(parcel);
        }

        public Format[] newArray(int i11) {
            return new Format[i11];
        }
    };
    public static final int NO_VALUE = -1;
    public static final long OFFSET_SAMPLE_RELATIVE = Long.MAX_VALUE;
    public final int accessibilityChannel;
    public final int averageBitrate;
    public final int bitrate;
    public final int channelCount;
    public final String codecs;
    public final ColorInfo colorInfo;
    public final String containerMimeType;
    public final DrmInitData drmInitData;
    public final int encoderDelay;
    public final int encoderPadding;
    public final Class<? extends ExoMediaCrypto> exoMediaCryptoType;
    public final float frameRate;
    private int hashCode;
    public final int height;

    /* renamed from: id  reason: collision with root package name */
    public final String f65676id;
    public final List<byte[]> initializationData;
    public final String label;
    public final String language;
    public final int maxInputSize;
    public final Metadata metadata;
    public final int pcmEncoding;
    public final int peakBitrate;
    public final float pixelWidthHeightRatio;
    public final byte[] projectionData;
    public final int roleFlags;
    public final int rotationDegrees;
    public final String sampleMimeType;
    public final int sampleRate;
    public final int selectionFlags;
    public final int stereoMode;
    public final long subsampleOffsetUs;
    public final int width;

    public static final class Builder {
        /* access modifiers changed from: private */
        public int accessibilityChannel;
        /* access modifiers changed from: private */
        public int averageBitrate;
        /* access modifiers changed from: private */
        public int channelCount;
        /* access modifiers changed from: private */
        public String codecs;
        /* access modifiers changed from: private */
        public ColorInfo colorInfo;
        /* access modifiers changed from: private */
        public String containerMimeType;
        /* access modifiers changed from: private */
        public DrmInitData drmInitData;
        /* access modifiers changed from: private */
        public int encoderDelay;
        /* access modifiers changed from: private */
        public int encoderPadding;
        /* access modifiers changed from: private */
        public Class<? extends ExoMediaCrypto> exoMediaCryptoType;
        /* access modifiers changed from: private */
        public float frameRate;
        /* access modifiers changed from: private */
        public int height;
        /* access modifiers changed from: private */

        /* renamed from: id  reason: collision with root package name */
        public String f65677id;
        /* access modifiers changed from: private */
        public List<byte[]> initializationData;
        /* access modifiers changed from: private */
        public String label;
        /* access modifiers changed from: private */
        public String language;
        /* access modifiers changed from: private */
        public int maxInputSize;
        /* access modifiers changed from: private */
        public Metadata metadata;
        /* access modifiers changed from: private */
        public int pcmEncoding;
        /* access modifiers changed from: private */
        public int peakBitrate;
        /* access modifiers changed from: private */
        public float pixelWidthHeightRatio;
        /* access modifiers changed from: private */
        public byte[] projectionData;
        /* access modifiers changed from: private */
        public int roleFlags;
        /* access modifiers changed from: private */
        public int rotationDegrees;
        /* access modifiers changed from: private */
        public String sampleMimeType;
        /* access modifiers changed from: private */
        public int sampleRate;
        /* access modifiers changed from: private */
        public int selectionFlags;
        /* access modifiers changed from: private */
        public int stereoMode;
        /* access modifiers changed from: private */
        public long subsampleOffsetUs;
        /* access modifiers changed from: private */
        public int width;

        public Format build() {
            return new Format(this);
        }

        public Builder setAccessibilityChannel(int i11) {
            this.accessibilityChannel = i11;
            return this;
        }

        public Builder setAverageBitrate(int i11) {
            this.averageBitrate = i11;
            return this;
        }

        public Builder setChannelCount(int i11) {
            this.channelCount = i11;
            return this;
        }

        public Builder setCodecs(String str) {
            this.codecs = str;
            return this;
        }

        public Builder setColorInfo(ColorInfo colorInfo2) {
            this.colorInfo = colorInfo2;
            return this;
        }

        public Builder setContainerMimeType(String str) {
            this.containerMimeType = str;
            return this;
        }

        public Builder setDrmInitData(DrmInitData drmInitData2) {
            this.drmInitData = drmInitData2;
            return this;
        }

        public Builder setEncoderDelay(int i11) {
            this.encoderDelay = i11;
            return this;
        }

        public Builder setEncoderPadding(int i11) {
            this.encoderPadding = i11;
            return this;
        }

        public Builder setExoMediaCryptoType(Class<? extends ExoMediaCrypto> cls) {
            this.exoMediaCryptoType = cls;
            return this;
        }

        public Builder setFrameRate(float f11) {
            this.frameRate = f11;
            return this;
        }

        public Builder setHeight(int i11) {
            this.height = i11;
            return this;
        }

        public Builder setId(String str) {
            this.f65677id = str;
            return this;
        }

        public Builder setInitializationData(List<byte[]> list) {
            this.initializationData = list;
            return this;
        }

        public Builder setLabel(String str) {
            this.label = str;
            return this;
        }

        public Builder setLanguage(String str) {
            this.language = str;
            return this;
        }

        public Builder setMaxInputSize(int i11) {
            this.maxInputSize = i11;
            return this;
        }

        public Builder setMetadata(Metadata metadata2) {
            this.metadata = metadata2;
            return this;
        }

        public Builder setPcmEncoding(int i11) {
            this.pcmEncoding = i11;
            return this;
        }

        public Builder setPeakBitrate(int i11) {
            this.peakBitrate = i11;
            return this;
        }

        public Builder setPixelWidthHeightRatio(float f11) {
            this.pixelWidthHeightRatio = f11;
            return this;
        }

        public Builder setProjectionData(byte[] bArr) {
            this.projectionData = bArr;
            return this;
        }

        public Builder setRoleFlags(int i11) {
            this.roleFlags = i11;
            return this;
        }

        public Builder setRotationDegrees(int i11) {
            this.rotationDegrees = i11;
            return this;
        }

        public Builder setSampleMimeType(String str) {
            this.sampleMimeType = str;
            return this;
        }

        public Builder setSampleRate(int i11) {
            this.sampleRate = i11;
            return this;
        }

        public Builder setSelectionFlags(int i11) {
            this.selectionFlags = i11;
            return this;
        }

        public Builder setStereoMode(int i11) {
            this.stereoMode = i11;
            return this;
        }

        public Builder setSubsampleOffsetUs(long j11) {
            this.subsampleOffsetUs = j11;
            return this;
        }

        public Builder setWidth(int i11) {
            this.width = i11;
            return this;
        }

        public Builder() {
            this.averageBitrate = -1;
            this.peakBitrate = -1;
            this.maxInputSize = -1;
            this.subsampleOffsetUs = Long.MAX_VALUE;
            this.width = -1;
            this.height = -1;
            this.frameRate = -1.0f;
            this.pixelWidthHeightRatio = 1.0f;
            this.stereoMode = -1;
            this.channelCount = -1;
            this.sampleRate = -1;
            this.pcmEncoding = -1;
            this.accessibilityChannel = -1;
        }

        public Builder setId(int i11) {
            this.f65677id = Integer.toString(i11);
            return this;
        }

        private Builder(Format format) {
            this.f65677id = format.f65676id;
            this.label = format.label;
            this.language = format.language;
            this.selectionFlags = format.selectionFlags;
            this.roleFlags = format.roleFlags;
            this.averageBitrate = format.averageBitrate;
            this.peakBitrate = format.peakBitrate;
            this.codecs = format.codecs;
            this.metadata = format.metadata;
            this.containerMimeType = format.containerMimeType;
            this.sampleMimeType = format.sampleMimeType;
            this.maxInputSize = format.maxInputSize;
            this.initializationData = format.initializationData;
            this.drmInitData = format.drmInitData;
            this.subsampleOffsetUs = format.subsampleOffsetUs;
            this.width = format.width;
            this.height = format.height;
            this.frameRate = format.frameRate;
            this.rotationDegrees = format.rotationDegrees;
            this.pixelWidthHeightRatio = format.pixelWidthHeightRatio;
            this.projectionData = format.projectionData;
            this.stereoMode = format.stereoMode;
            this.colorInfo = format.colorInfo;
            this.channelCount = format.channelCount;
            this.sampleRate = format.sampleRate;
            this.pcmEncoding = format.pcmEncoding;
            this.encoderDelay = format.encoderDelay;
            this.encoderPadding = format.encoderPadding;
            this.accessibilityChannel = format.accessibilityChannel;
            this.exoMediaCryptoType = format.exoMediaCryptoType;
        }
    }

    @Deprecated
    public static Format createAudioContainerFormat(String str, String str2, String str3, String str4, String str5, Metadata metadata2, int i11, int i12, int i13, List<byte[]> list, int i14, int i15, String str6) {
        return new Builder().setId(str).setLabel(str2).setLanguage(str6).setSelectionFlags(i14).setRoleFlags(i15).setAverageBitrate(i11).setPeakBitrate(i11).setCodecs(str5).setMetadata(metadata2).setContainerMimeType(str3).setSampleMimeType(str4).setInitializationData(list).setChannelCount(i12).setSampleRate(i13).build();
    }

    @Deprecated
    public static Format createAudioSampleFormat(String str, String str2, String str3, int i11, int i12, int i13, int i14, List<byte[]> list, DrmInitData drmInitData2, int i15, String str4) {
        return new Builder().setId(str).setLanguage(str4).setSelectionFlags(i15).setAverageBitrate(i11).setPeakBitrate(i11).setCodecs(str3).setSampleMimeType(str2).setMaxInputSize(i12).setInitializationData(list).setDrmInitData(drmInitData2).setChannelCount(i13).setSampleRate(i14).build();
    }

    @Deprecated
    public static Format createContainerFormat(String str, String str2, String str3, String str4, String str5, int i11, int i12, int i13, String str6) {
        return new Builder().setId(str).setLabel(str2).setLanguage(str6).setSelectionFlags(i12).setRoleFlags(i13).setAverageBitrate(i11).setPeakBitrate(i11).setCodecs(str5).setContainerMimeType(str3).setSampleMimeType(str4).build();
    }

    @Deprecated
    public static Format createImageSampleFormat(String str, String str2, int i11, List<byte[]> list, String str3) {
        return new Builder().setId(str).setLanguage(str3).setSelectionFlags(i11).setSampleMimeType(str2).setInitializationData(list).build();
    }

    @Deprecated
    public static Format createSampleFormat(String str, String str2) {
        return new Builder().setId(str).setSampleMimeType(str2).build();
    }

    @Deprecated
    public static Format createTextContainerFormat(String str, String str2, String str3, String str4, String str5, int i11, int i12, int i13, String str6) {
        return new Builder().setId(str).setLabel(str2).setLanguage(str6).setSelectionFlags(i12).setRoleFlags(i13).setAverageBitrate(i11).setPeakBitrate(i11).setCodecs(str5).setContainerMimeType(str3).setSampleMimeType(str4).build();
    }

    @Deprecated
    public static Format createTextSampleFormat(String str, String str2, int i11, String str3) {
        return new Builder().setId(str).setLanguage(str3).setSelectionFlags(i11).setSampleMimeType(str2).build();
    }

    @Deprecated
    public static Format createVideoContainerFormat(String str, String str2, String str3, String str4, String str5, Metadata metadata2, int i11, int i12, int i13, float f11, List<byte[]> list, int i14, int i15) {
        return new Builder().setId(str).setLabel(str2).setSelectionFlags(i14).setRoleFlags(i15).setAverageBitrate(i11).setPeakBitrate(i11).setCodecs(str5).setMetadata(metadata2).setContainerMimeType(str3).setSampleMimeType(str4).setInitializationData(list).setWidth(i12).setHeight(i13).setFrameRate(f11).build();
    }

    @Deprecated
    public static Format createVideoSampleFormat(String str, String str2, String str3, int i11, int i12, int i13, int i14, float f11, List<byte[]> list, DrmInitData drmInitData2) {
        return new Builder().setId(str).setAverageBitrate(i11).setPeakBitrate(i11).setCodecs(str3).setSampleMimeType(str2).setMaxInputSize(i12).setInitializationData(list).setDrmInitData(drmInitData2).setWidth(i13).setHeight(i14).setFrameRate(f11).build();
    }

    public static String toLogString(Format format) {
        if (format == null) {
            return OptionsBridge.NULL_VALUE;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("id=");
        sb2.append(format.f65676id);
        sb2.append(", mimeType=");
        sb2.append(format.sampleMimeType);
        if (format.bitrate != -1) {
            sb2.append(", bitrate=");
            sb2.append(format.bitrate);
        }
        if (format.codecs != null) {
            sb2.append(", codecs=");
            sb2.append(format.codecs);
        }
        if (!(format.width == -1 || format.height == -1)) {
            sb2.append(", res=");
            sb2.append(format.width);
            sb2.append("x");
            sb2.append(format.height);
        }
        if (format.frameRate != -1.0f) {
            sb2.append(", fps=");
            sb2.append(format.frameRate);
        }
        if (format.channelCount != -1) {
            sb2.append(", channels=");
            sb2.append(format.channelCount);
        }
        if (format.sampleRate != -1) {
            sb2.append(", sample_rate=");
            sb2.append(format.sampleRate);
        }
        if (format.language != null) {
            sb2.append(", language=");
            sb2.append(format.language);
        }
        if (format.label != null) {
            sb2.append(", label=");
            sb2.append(format.label);
        }
        return sb2.toString();
    }

    public Builder buildUpon() {
        return new Builder();
    }

    @Deprecated
    public Format copyWithBitrate(int i11) {
        return buildUpon().setAverageBitrate(i11).setPeakBitrate(i11).build();
    }

    @Deprecated
    public Format copyWithDrmInitData(DrmInitData drmInitData2) {
        return buildUpon().setDrmInitData(drmInitData2).build();
    }

    public Format copyWithExoMediaCryptoType(Class<? extends ExoMediaCrypto> cls) {
        return buildUpon().setExoMediaCryptoType(cls).build();
    }

    @Deprecated
    public Format copyWithFrameRate(float f11) {
        return buildUpon().setFrameRate(f11).build();
    }

    @Deprecated
    public Format copyWithGaplessInfo(int i11, int i12) {
        return buildUpon().setEncoderDelay(i11).setEncoderPadding(i12).build();
    }

    @Deprecated
    public Format copyWithLabel(String str) {
        return buildUpon().setLabel(str).build();
    }

    @Deprecated
    public Format copyWithManifestFormatInfo(Format format) {
        return withManifestFormatInfo(format);
    }

    @Deprecated
    public Format copyWithMaxInputSize(int i11) {
        return buildUpon().setMaxInputSize(i11).build();
    }

    @Deprecated
    public Format copyWithMetadata(Metadata metadata2) {
        return buildUpon().setMetadata(metadata2).build();
    }

    @Deprecated
    public Format copyWithSubsampleOffsetUs(long j11) {
        return buildUpon().setSubsampleOffsetUs(j11).build();
    }

    @Deprecated
    public Format copyWithVideoSize(int i11, int i12) {
        return buildUpon().setWidth(i11).setHeight(i12).build();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        int i11;
        if (this == obj) {
            return true;
        }
        if (obj == null || Format.class != obj.getClass()) {
            return false;
        }
        Format format = (Format) obj;
        int i12 = this.hashCode;
        if (i12 != 0 && (i11 = format.hashCode) != 0 && i12 != i11) {
            return false;
        }
        if (this.selectionFlags == format.selectionFlags && this.roleFlags == format.roleFlags && this.averageBitrate == format.averageBitrate && this.peakBitrate == format.peakBitrate && this.maxInputSize == format.maxInputSize && this.subsampleOffsetUs == format.subsampleOffsetUs && this.width == format.width && this.height == format.height && this.rotationDegrees == format.rotationDegrees && this.stereoMode == format.stereoMode && this.channelCount == format.channelCount && this.sampleRate == format.sampleRate && this.pcmEncoding == format.pcmEncoding && this.encoderDelay == format.encoderDelay && this.encoderPadding == format.encoderPadding && this.accessibilityChannel == format.accessibilityChannel && Float.compare(this.frameRate, format.frameRate) == 0 && Float.compare(this.pixelWidthHeightRatio, format.pixelWidthHeightRatio) == 0 && Util.areEqual(this.exoMediaCryptoType, format.exoMediaCryptoType) && Util.areEqual(this.f65676id, format.f65676id) && Util.areEqual(this.label, format.label) && Util.areEqual(this.codecs, format.codecs) && Util.areEqual(this.containerMimeType, format.containerMimeType) && Util.areEqual(this.sampleMimeType, format.sampleMimeType) && Util.areEqual(this.language, format.language) && Arrays.equals(this.projectionData, format.projectionData) && Util.areEqual(this.metadata, format.metadata) && Util.areEqual(this.colorInfo, format.colorInfo) && Util.areEqual(this.drmInitData, format.drmInitData) && initializationDataEquals(format)) {
            return true;
        }
        return false;
    }

    public int getPixelCount() {
        int i11;
        int i12 = this.width;
        if (i12 == -1 || (i11 = this.height) == -1) {
            return -1;
        }
        return i12 * i11;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            String str = this.f65676id;
            int i11 = 0;
            int hashCode2 = (527 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.label;
            int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.language;
            int hashCode4 = (((((((((hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.selectionFlags) * 31) + this.roleFlags) * 31) + this.averageBitrate) * 31) + this.peakBitrate) * 31;
            String str4 = this.codecs;
            int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Metadata metadata2 = this.metadata;
            int hashCode6 = (hashCode5 + (metadata2 == null ? 0 : metadata2.hashCode())) * 31;
            String str5 = this.containerMimeType;
            int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.sampleMimeType;
            int hashCode8 = (((((((((((((((((((((((((((((hashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31) + this.maxInputSize) * 31) + ((int) this.subsampleOffsetUs)) * 31) + this.width) * 31) + this.height) * 31) + Float.floatToIntBits(this.frameRate)) * 31) + this.rotationDegrees) * 31) + Float.floatToIntBits(this.pixelWidthHeightRatio)) * 31) + this.stereoMode) * 31) + this.channelCount) * 31) + this.sampleRate) * 31) + this.pcmEncoding) * 31) + this.encoderDelay) * 31) + this.encoderPadding) * 31) + this.accessibilityChannel) * 31;
            Class<? extends ExoMediaCrypto> cls = this.exoMediaCryptoType;
            if (cls != null) {
                i11 = cls.hashCode();
            }
            this.hashCode = hashCode8 + i11;
        }
        return this.hashCode;
    }

    public boolean initializationDataEquals(Format format) {
        if (this.initializationData.size() != format.initializationData.size()) {
            return false;
        }
        for (int i11 = 0; i11 < this.initializationData.size(); i11++) {
            if (!Arrays.equals(this.initializationData.get(i11), format.initializationData.get(i11))) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        String str = this.f65676id;
        String str2 = this.label;
        String str3 = this.containerMimeType;
        String str4 = this.sampleMimeType;
        String str5 = this.codecs;
        int i11 = this.bitrate;
        String str6 = this.language;
        int i12 = this.width;
        int i13 = this.height;
        float f11 = this.frameRate;
        int i14 = this.channelCount;
        int i15 = this.sampleRate;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 104 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length() + String.valueOf(str5).length() + String.valueOf(str6).length());
        sb2.append("Format(");
        sb2.append(str);
        sb2.append(", ");
        sb2.append(str2);
        sb2.append(", ");
        sb2.append(str3);
        sb2.append(", ");
        sb2.append(str4);
        sb2.append(", ");
        sb2.append(str5);
        sb2.append(", ");
        sb2.append(i11);
        sb2.append(", ");
        sb2.append(str6);
        sb2.append(", [");
        sb2.append(i12);
        sb2.append(", ");
        sb2.append(i13);
        sb2.append(", ");
        sb2.append(f11);
        sb2.append("], [");
        sb2.append(i14);
        sb2.append(", ");
        sb2.append(i15);
        sb2.append("])");
        return sb2.toString();
    }

    public Format withManifestFormatInfo(Format format) {
        Metadata metadata2;
        String str;
        if (this == format) {
            return this;
        }
        int trackType = MimeTypes.getTrackType(this.sampleMimeType);
        String str2 = format.f65676id;
        String str3 = format.label;
        if (str3 == null) {
            str3 = this.label;
        }
        String str4 = this.language;
        if ((trackType == 3 || trackType == 1) && (str = format.language) != null) {
            str4 = str;
        }
        int i11 = this.averageBitrate;
        if (i11 == -1) {
            i11 = format.averageBitrate;
        }
        int i12 = this.peakBitrate;
        if (i12 == -1) {
            i12 = format.peakBitrate;
        }
        String str5 = this.codecs;
        if (str5 == null) {
            String codecsOfType = Util.getCodecsOfType(format.codecs, trackType);
            if (Util.splitCodecs(codecsOfType).length == 1) {
                str5 = codecsOfType;
            }
        }
        Metadata metadata3 = this.metadata;
        if (metadata3 == null) {
            metadata2 = format.metadata;
        } else {
            metadata2 = metadata3.copyWithAppendedEntriesFrom(format.metadata);
        }
        float f11 = this.frameRate;
        if (f11 == -1.0f && trackType == 2) {
            f11 = format.frameRate;
        }
        int i13 = this.selectionFlags | format.selectionFlags;
        int i14 = this.roleFlags | format.roleFlags;
        return buildUpon().setId(str2).setLabel(str3).setLanguage(str4).setSelectionFlags(i13).setRoleFlags(i14).setAverageBitrate(i11).setPeakBitrate(i12).setCodecs(str5).setMetadata(metadata2).setDrmInitData(DrmInitData.createSessionCreationData(format.drmInitData, this.drmInitData)).setFrameRate(f11).build();
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f65676id);
        parcel.writeString(this.label);
        parcel.writeString(this.language);
        parcel.writeInt(this.selectionFlags);
        parcel.writeInt(this.roleFlags);
        parcel.writeInt(this.averageBitrate);
        parcel.writeInt(this.peakBitrate);
        parcel.writeString(this.codecs);
        boolean z11 = false;
        parcel.writeParcelable(this.metadata, 0);
        parcel.writeString(this.containerMimeType);
        parcel.writeString(this.sampleMimeType);
        parcel.writeInt(this.maxInputSize);
        int size = this.initializationData.size();
        parcel.writeInt(size);
        for (int i12 = 0; i12 < size; i12++) {
            parcel.writeByteArray(this.initializationData.get(i12));
        }
        parcel.writeParcelable(this.drmInitData, 0);
        parcel.writeLong(this.subsampleOffsetUs);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeFloat(this.frameRate);
        parcel.writeInt(this.rotationDegrees);
        parcel.writeFloat(this.pixelWidthHeightRatio);
        if (this.projectionData != null) {
            z11 = true;
        }
        Util.writeBoolean(parcel, z11);
        byte[] bArr = this.projectionData;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
        parcel.writeInt(this.stereoMode);
        parcel.writeParcelable(this.colorInfo, i11);
        parcel.writeInt(this.channelCount);
        parcel.writeInt(this.sampleRate);
        parcel.writeInt(this.pcmEncoding);
        parcel.writeInt(this.encoderDelay);
        parcel.writeInt(this.encoderPadding);
        parcel.writeInt(this.accessibilityChannel);
    }

    private Format(Builder builder) {
        this.f65676id = builder.f65677id;
        this.label = builder.label;
        this.language = Util.normalizeLanguageCode(builder.language);
        this.selectionFlags = builder.selectionFlags;
        this.roleFlags = builder.roleFlags;
        int access$600 = builder.averageBitrate;
        this.averageBitrate = access$600;
        int access$700 = builder.peakBitrate;
        this.peakBitrate = access$700;
        this.bitrate = access$700 != -1 ? access$700 : access$600;
        this.codecs = builder.codecs;
        this.metadata = builder.metadata;
        this.containerMimeType = builder.containerMimeType;
        this.sampleMimeType = builder.sampleMimeType;
        this.maxInputSize = builder.maxInputSize;
        this.initializationData = builder.initializationData == null ? Collections.emptyList() : builder.initializationData;
        DrmInitData access$1400 = builder.drmInitData;
        this.drmInitData = access$1400;
        this.subsampleOffsetUs = builder.subsampleOffsetUs;
        this.width = builder.width;
        this.height = builder.height;
        this.frameRate = builder.frameRate;
        int i11 = 0;
        this.rotationDegrees = builder.rotationDegrees == -1 ? 0 : builder.rotationDegrees;
        this.pixelWidthHeightRatio = builder.pixelWidthHeightRatio == -1.0f ? 1.0f : builder.pixelWidthHeightRatio;
        this.projectionData = builder.projectionData;
        this.stereoMode = builder.stereoMode;
        this.colorInfo = builder.colorInfo;
        this.channelCount = builder.channelCount;
        this.sampleRate = builder.sampleRate;
        this.pcmEncoding = builder.pcmEncoding;
        this.encoderDelay = builder.encoderDelay == -1 ? 0 : builder.encoderDelay;
        this.encoderPadding = builder.encoderPadding != -1 ? builder.encoderPadding : i11;
        this.accessibilityChannel = builder.accessibilityChannel;
        if (builder.exoMediaCryptoType != null || access$1400 == null) {
            this.exoMediaCryptoType = builder.exoMediaCryptoType;
        } else {
            this.exoMediaCryptoType = UnsupportedMediaCrypto.class;
        }
    }

    @Deprecated
    public static Format createTextSampleFormat(String str, String str2, int i11, String str3, int i12, long j11, List<byte[]> list) {
        return new Builder().setId(str).setLanguage(str3).setSelectionFlags(i11).setSampleMimeType(str2).setInitializationData(list).setSubsampleOffsetUs(j11).setAccessibilityChannel(i12).build();
    }

    @Deprecated
    public static Format createTextContainerFormat(String str, String str2, String str3, String str4, String str5, int i11, int i12, int i13, String str6, int i14) {
        return new Builder().setId(str).setLabel(str2).setLanguage(str6).setSelectionFlags(i12).setRoleFlags(i13).setAverageBitrate(i11).setPeakBitrate(i11).setCodecs(str5).setContainerMimeType(str3).setSampleMimeType(str4).setAccessibilityChannel(i14).build();
    }

    @Deprecated
    public static Format createVideoSampleFormat(String str, String str2, String str3, int i11, int i12, int i13, int i14, float f11, List<byte[]> list, int i15, float f12, DrmInitData drmInitData2) {
        return new Builder().setId(str).setAverageBitrate(i11).setPeakBitrate(i11).setCodecs(str3).setSampleMimeType(str2).setMaxInputSize(i12).setInitializationData(list).setDrmInitData(drmInitData2).setWidth(i13).setHeight(i14).setFrameRate(f11).setRotationDegrees(i15).setPixelWidthHeightRatio(f12).build();
    }

    @Deprecated
    public static Format createAudioSampleFormat(String str, String str2, String str3, int i11, int i12, int i13, int i14, int i15, List<byte[]> list, DrmInitData drmInitData2, int i16, String str4) {
        return new Builder().setId(str).setLanguage(str4).setSelectionFlags(i16).setAverageBitrate(i11).setPeakBitrate(i11).setCodecs(str3).setSampleMimeType(str2).setMaxInputSize(i12).setInitializationData(list).setDrmInitData(drmInitData2).setChannelCount(i13).setSampleRate(i14).setPcmEncoding(i15).build();
    }

    @Deprecated
    public static Format createVideoSampleFormat(String str, String str2, String str3, int i11, int i12, int i13, int i14, float f11, List<byte[]> list, int i15, float f12, byte[] bArr, int i16, ColorInfo colorInfo2, DrmInitData drmInitData2) {
        return new Builder().setId(str).setAverageBitrate(i11).setPeakBitrate(i11).setCodecs(str3).setSampleMimeType(str2).setMaxInputSize(i12).setInitializationData(list).setDrmInitData(drmInitData2).setWidth(i13).setHeight(i14).setFrameRate(f11).setRotationDegrees(i15).setPixelWidthHeightRatio(f12).setProjectionData(bArr).setStereoMode(i16).setColorInfo(colorInfo2).build();
    }

    @Deprecated
    public static Format createAudioSampleFormat(String str, String str2, String str3, int i11, int i12, int i13, int i14, int i15, int i16, int i17, List<byte[]> list, DrmInitData drmInitData2, int i18, String str4, Metadata metadata2) {
        return new Builder().setId(str).setLanguage(str4).setSelectionFlags(i18).setAverageBitrate(i11).setPeakBitrate(i11).setCodecs(str3).setMetadata(metadata2).setSampleMimeType(str2).setMaxInputSize(i12).setInitializationData(list).setDrmInitData(drmInitData2).setChannelCount(i13).setSampleRate(i14).setPcmEncoding(i15).setEncoderDelay(i16).setEncoderPadding(i17).build();
    }

    public Format(Parcel parcel) {
        this.f65676id = parcel.readString();
        this.label = parcel.readString();
        this.language = parcel.readString();
        this.selectionFlags = parcel.readInt();
        this.roleFlags = parcel.readInt();
        int readInt = parcel.readInt();
        this.averageBitrate = readInt;
        int readInt2 = parcel.readInt();
        this.peakBitrate = readInt2;
        this.bitrate = readInt2 != -1 ? readInt2 : readInt;
        this.codecs = parcel.readString();
        this.metadata = (Metadata) parcel.readParcelable(Metadata.class.getClassLoader());
        this.containerMimeType = parcel.readString();
        this.sampleMimeType = parcel.readString();
        this.maxInputSize = parcel.readInt();
        int readInt3 = parcel.readInt();
        this.initializationData = new ArrayList(readInt3);
        for (int i11 = 0; i11 < readInt3; i11++) {
            this.initializationData.add((byte[]) Assertions.checkNotNull(parcel.createByteArray()));
        }
        DrmInitData drmInitData2 = (DrmInitData) parcel.readParcelable(DrmInitData.class.getClassLoader());
        this.drmInitData = drmInitData2;
        this.subsampleOffsetUs = parcel.readLong();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.frameRate = parcel.readFloat();
        this.rotationDegrees = parcel.readInt();
        this.pixelWidthHeightRatio = parcel.readFloat();
        Class cls = null;
        this.projectionData = Util.readBoolean(parcel) ? parcel.createByteArray() : null;
        this.stereoMode = parcel.readInt();
        this.colorInfo = (ColorInfo) parcel.readParcelable(ColorInfo.class.getClassLoader());
        this.channelCount = parcel.readInt();
        this.sampleRate = parcel.readInt();
        this.pcmEncoding = parcel.readInt();
        this.encoderDelay = parcel.readInt();
        this.encoderPadding = parcel.readInt();
        this.accessibilityChannel = parcel.readInt();
        this.exoMediaCryptoType = drmInitData2 != null ? UnsupportedMediaCrypto.class : cls;
    }
}
