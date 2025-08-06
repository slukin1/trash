package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.a;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class MdtaMetadataEntry implements Metadata.Entry {
    public static final Parcelable.Creator<MdtaMetadataEntry> CREATOR = new Parcelable.Creator<MdtaMetadataEntry>() {
        public MdtaMetadataEntry createFromParcel(Parcel parcel) {
            return new MdtaMetadataEntry(parcel);
        }

        public MdtaMetadataEntry[] newArray(int i11) {
            return new MdtaMetadataEntry[i11];
        }
    };
    public static final String KEY_ANDROID_CAPTURE_FPS = "com.android.capture.fps";
    public final String key;
    public final int localeIndicator;
    public final int typeIndicator;
    public final byte[] value;

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MdtaMetadataEntry.class != obj.getClass()) {
            return false;
        }
        MdtaMetadataEntry mdtaMetadataEntry = (MdtaMetadataEntry) obj;
        if (!this.key.equals(mdtaMetadataEntry.key) || !Arrays.equals(this.value, mdtaMetadataEntry.value) || this.localeIndicator != mdtaMetadataEntry.localeIndicator || this.typeIndicator != mdtaMetadataEntry.typeIndicator) {
            return false;
        }
        return true;
    }

    public /* synthetic */ byte[] getWrappedMetadataBytes() {
        return a.a(this);
    }

    public /* synthetic */ Format getWrappedMetadataFormat() {
        return a.b(this);
    }

    public int hashCode() {
        return ((((((527 + this.key.hashCode()) * 31) + Arrays.hashCode(this.value)) * 31) + this.localeIndicator) * 31) + this.typeIndicator;
    }

    public /* synthetic */ void populateMediaMetadata(MediaMetadata.Builder builder) {
        a.c(this, builder);
    }

    public String toString() {
        String valueOf = String.valueOf(this.key);
        return valueOf.length() != 0 ? "mdta: key=".concat(valueOf) : new String("mdta: key=");
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.key);
        parcel.writeByteArray(this.value);
        parcel.writeInt(this.localeIndicator);
        parcel.writeInt(this.typeIndicator);
    }

    public MdtaMetadataEntry(String str, byte[] bArr, int i11, int i12) {
        this.key = str;
        this.value = bArr;
        this.localeIndicator = i11;
        this.typeIndicator = i12;
    }

    private MdtaMetadataEntry(Parcel parcel) {
        this.key = (String) Util.castNonNull(parcel.readString());
        this.value = (byte[]) Util.castNonNull(parcel.createByteArray());
        this.localeIndicator = parcel.readInt();
        this.typeIndicator = parcel.readInt();
    }
}
