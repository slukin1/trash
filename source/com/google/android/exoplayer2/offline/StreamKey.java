package com.google.android.exoplayer2.offline;

import android.os.Parcel;
import android.os.Parcelable;
import com.amazonaws.services.s3.model.InstructionFileId;

public final class StreamKey implements Comparable<StreamKey>, Parcelable {
    public static final Parcelable.Creator<StreamKey> CREATOR = new Parcelable.Creator<StreamKey>() {
        public StreamKey createFromParcel(Parcel parcel) {
            return new StreamKey(parcel);
        }

        public StreamKey[] newArray(int i11) {
            return new StreamKey[i11];
        }
    };
    public final int groupIndex;
    public final int periodIndex;
    public final int trackIndex;

    public StreamKey(int i11, int i12) {
        this(0, i11, i12);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || StreamKey.class != obj.getClass()) {
            return false;
        }
        StreamKey streamKey = (StreamKey) obj;
        if (this.periodIndex == streamKey.periodIndex && this.groupIndex == streamKey.groupIndex && this.trackIndex == streamKey.trackIndex) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.periodIndex * 31) + this.groupIndex) * 31) + this.trackIndex;
    }

    public String toString() {
        int i11 = this.periodIndex;
        int i12 = this.groupIndex;
        int i13 = this.trackIndex;
        StringBuilder sb2 = new StringBuilder(35);
        sb2.append(i11);
        sb2.append(InstructionFileId.DOT);
        sb2.append(i12);
        sb2.append(InstructionFileId.DOT);
        sb2.append(i13);
        return sb2.toString();
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.periodIndex);
        parcel.writeInt(this.groupIndex);
        parcel.writeInt(this.trackIndex);
    }

    public StreamKey(int i11, int i12, int i13) {
        this.periodIndex = i11;
        this.groupIndex = i12;
        this.trackIndex = i13;
    }

    public int compareTo(StreamKey streamKey) {
        int i11 = this.periodIndex - streamKey.periodIndex;
        if (i11 != 0) {
            return i11;
        }
        int i12 = this.groupIndex - streamKey.groupIndex;
        return i12 == 0 ? this.trackIndex - streamKey.trackIndex : i12;
    }

    public StreamKey(Parcel parcel) {
        this.periodIndex = parcel.readInt();
        this.groupIndex = parcel.readInt();
        this.trackIndex = parcel.readInt();
    }
}
