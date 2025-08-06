package com.google.android.exoplayer2.source;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

public final class TrackGroupArray implements Parcelable {
    public static final Parcelable.Creator<TrackGroupArray> CREATOR = new Parcelable.Creator<TrackGroupArray>() {
        public TrackGroupArray createFromParcel(Parcel parcel) {
            return new TrackGroupArray(parcel);
        }

        public TrackGroupArray[] newArray(int i11) {
            return new TrackGroupArray[i11];
        }
    };
    public static final TrackGroupArray EMPTY = new TrackGroupArray(new TrackGroup[0]);
    private int hashCode;
    public final int length;
    private final TrackGroup[] trackGroups;

    public TrackGroupArray(TrackGroup... trackGroupArr) {
        this.trackGroups = trackGroupArr;
        this.length = trackGroupArr.length;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TrackGroupArray.class != obj.getClass()) {
            return false;
        }
        TrackGroupArray trackGroupArray = (TrackGroupArray) obj;
        if (this.length != trackGroupArray.length || !Arrays.equals(this.trackGroups, trackGroupArray.trackGroups)) {
            return false;
        }
        return true;
    }

    public TrackGroup get(int i11) {
        return this.trackGroups[i11];
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = Arrays.hashCode(this.trackGroups);
        }
        return this.hashCode;
    }

    public int indexOf(TrackGroup trackGroup) {
        for (int i11 = 0; i11 < this.length; i11++) {
            if (this.trackGroups[i11] == trackGroup) {
                return i11;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.length);
        for (int i12 = 0; i12 < this.length; i12++) {
            parcel.writeParcelable(this.trackGroups[i12], 0);
        }
    }

    public TrackGroupArray(Parcel parcel) {
        int readInt = parcel.readInt();
        this.length = readInt;
        this.trackGroups = new TrackGroup[readInt];
        for (int i11 = 0; i11 < this.length; i11++) {
            this.trackGroups[i11] = (TrackGroup) parcel.readParcelable(TrackGroup.class.getClassLoader());
        }
    }
}
