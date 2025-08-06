package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class GeobFrame extends Id3Frame {
    public static final Parcelable.Creator<GeobFrame> CREATOR = new Parcelable.Creator<GeobFrame>() {
        public GeobFrame createFromParcel(Parcel parcel) {
            return new GeobFrame(parcel);
        }

        public GeobFrame[] newArray(int i11) {
            return new GeobFrame[i11];
        }
    };
    public static final String ID = "GEOB";
    public final byte[] data;
    public final String description;
    public final String filename;
    public final String mimeType;

    public GeobFrame(String str, String str2, String str3, byte[] bArr) {
        super(ID);
        this.mimeType = str;
        this.filename = str2;
        this.description = str3;
        this.data = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || GeobFrame.class != obj.getClass()) {
            return false;
        }
        GeobFrame geobFrame = (GeobFrame) obj;
        if (!Util.areEqual(this.mimeType, geobFrame.mimeType) || !Util.areEqual(this.filename, geobFrame.filename) || !Util.areEqual(this.description, geobFrame.description) || !Arrays.equals(this.data, geobFrame.data)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.mimeType;
        int i11 = 0;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.filename;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.description;
        if (str3 != null) {
            i11 = str3.hashCode();
        }
        return ((hashCode2 + i11) * 31) + Arrays.hashCode(this.data);
    }

    public String toString() {
        String str = this.f65946id;
        String str2 = this.mimeType;
        String str3 = this.filename;
        String str4 = this.description;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 36 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length());
        sb2.append(str);
        sb2.append(": mimeType=");
        sb2.append(str2);
        sb2.append(", filename=");
        sb2.append(str3);
        sb2.append(", description=");
        sb2.append(str4);
        return sb2.toString();
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.mimeType);
        parcel.writeString(this.filename);
        parcel.writeString(this.description);
        parcel.writeByteArray(this.data);
    }

    public GeobFrame(Parcel parcel) {
        super(ID);
        this.mimeType = (String) Util.castNonNull(parcel.readString());
        this.filename = (String) Util.castNonNull(parcel.readString());
        this.description = (String) Util.castNonNull(parcel.readString());
        this.data = (byte[]) Util.castNonNull(parcel.createByteArray());
    }
}
