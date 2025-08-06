package com.google.android.exoplayer2.metadata.emsg;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.a;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class EventMessage implements Metadata.Entry {
    public static final Parcelable.Creator<EventMessage> CREATOR = new Parcelable.Creator<EventMessage>() {
        public EventMessage createFromParcel(Parcel parcel) {
            return new EventMessage(parcel);
        }

        public EventMessage[] newArray(int i11) {
            return new EventMessage[i11];
        }
    };
    private static final Format ID3_FORMAT = new Format.Builder().setSampleMimeType(MimeTypes.APPLICATION_ID3).build();
    public static final String ID3_SCHEME_ID_AOM = "https://aomedia.org/emsg/ID3";
    private static final String ID3_SCHEME_ID_APPLE = "https://developer.apple.com/streaming/emsg-id3";
    private static final Format SCTE35_FORMAT = new Format.Builder().setSampleMimeType(MimeTypes.APPLICATION_SCTE35).build();
    public static final String SCTE35_SCHEME_ID = "urn:scte:scte35:2014:bin";
    public final long durationMs;
    private int hashCode;

    /* renamed from: id  reason: collision with root package name */
    public final long f65945id;
    public final byte[] messageData;
    public final String schemeIdUri;
    public final String value;

    public EventMessage(String str, String str2, long j11, long j12, byte[] bArr) {
        this.schemeIdUri = str;
        this.value = str2;
        this.durationMs = j11;
        this.f65945id = j12;
        this.messageData = bArr;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || EventMessage.class != obj.getClass()) {
            return false;
        }
        EventMessage eventMessage = (EventMessage) obj;
        if (this.durationMs != eventMessage.durationMs || this.f65945id != eventMessage.f65945id || !Util.areEqual(this.schemeIdUri, eventMessage.schemeIdUri) || !Util.areEqual(this.value, eventMessage.value) || !Arrays.equals(this.messageData, eventMessage.messageData)) {
            return false;
        }
        return true;
    }

    public byte[] getWrappedMetadataBytes() {
        if (getWrappedMetadataFormat() != null) {
            return this.messageData;
        }
        return null;
    }

    public Format getWrappedMetadataFormat() {
        String str = this.schemeIdUri;
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1468477611:
                if (str.equals(SCTE35_SCHEME_ID)) {
                    c11 = 0;
                    break;
                }
                break;
            case -795945609:
                if (str.equals(ID3_SCHEME_ID_AOM)) {
                    c11 = 1;
                    break;
                }
                break;
            case 1303648457:
                if (str.equals(ID3_SCHEME_ID_APPLE)) {
                    c11 = 2;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return SCTE35_FORMAT;
            case 1:
            case 2:
                return ID3_FORMAT;
            default:
                return null;
        }
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            String str = this.schemeIdUri;
            int i11 = 0;
            int hashCode2 = (527 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.value;
            if (str2 != null) {
                i11 = str2.hashCode();
            }
            long j11 = this.durationMs;
            long j12 = this.f65945id;
            this.hashCode = ((((((hashCode2 + i11) * 31) + ((int) (j11 ^ (j11 >>> 32)))) * 31) + ((int) (j12 ^ (j12 >>> 32)))) * 31) + Arrays.hashCode(this.messageData);
        }
        return this.hashCode;
    }

    public /* synthetic */ void populateMediaMetadata(MediaMetadata.Builder builder) {
        a.c(this, builder);
    }

    public String toString() {
        String str = this.schemeIdUri;
        long j11 = this.f65945id;
        long j12 = this.durationMs;
        String str2 = this.value;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 79 + String.valueOf(str2).length());
        sb2.append("EMSG: scheme=");
        sb2.append(str);
        sb2.append(", id=");
        sb2.append(j11);
        sb2.append(", durationMs=");
        sb2.append(j12);
        sb2.append(", value=");
        sb2.append(str2);
        return sb2.toString();
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.schemeIdUri);
        parcel.writeString(this.value);
        parcel.writeLong(this.durationMs);
        parcel.writeLong(this.f65945id);
        parcel.writeByteArray(this.messageData);
    }

    public EventMessage(Parcel parcel) {
        this.schemeIdUri = (String) Util.castNonNull(parcel.readString());
        this.value = (String) Util.castNonNull(parcel.readString());
        this.durationMs = parcel.readLong();
        this.f65945id = parcel.readLong();
        this.messageData = (byte[]) Util.castNonNull(parcel.createByteArray());
    }
}
