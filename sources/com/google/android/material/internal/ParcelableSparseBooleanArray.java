package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;

public class ParcelableSparseBooleanArray extends SparseBooleanArray implements Parcelable {
    public static final Parcelable.Creator<ParcelableSparseBooleanArray> CREATOR = new Parcelable.Creator<ParcelableSparseBooleanArray>() {
        public ParcelableSparseBooleanArray createFromParcel(Parcel parcel) {
            int readInt = parcel.readInt();
            ParcelableSparseBooleanArray parcelableSparseBooleanArray = new ParcelableSparseBooleanArray(readInt);
            int[] iArr = new int[readInt];
            boolean[] zArr = new boolean[readInt];
            parcel.readIntArray(iArr);
            parcel.readBooleanArray(zArr);
            for (int i11 = 0; i11 < readInt; i11++) {
                parcelableSparseBooleanArray.put(iArr[i11], zArr[i11]);
            }
            return parcelableSparseBooleanArray;
        }

        public ParcelableSparseBooleanArray[] newArray(int i11) {
            return new ParcelableSparseBooleanArray[i11];
        }
    };

    public ParcelableSparseBooleanArray() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        int[] iArr = new int[size()];
        boolean[] zArr = new boolean[size()];
        for (int i12 = 0; i12 < size(); i12++) {
            iArr[i12] = keyAt(i12);
            zArr[i12] = valueAt(i12);
        }
        parcel.writeInt(size());
        parcel.writeIntArray(iArr);
        parcel.writeBooleanArray(zArr);
    }

    public ParcelableSparseBooleanArray(int i11) {
        super(i11);
    }

    public ParcelableSparseBooleanArray(SparseBooleanArray sparseBooleanArray) {
        super(sparseBooleanArray.size());
        for (int i11 = 0; i11 < sparseBooleanArray.size(); i11++) {
            put(sparseBooleanArray.keyAt(i11), sparseBooleanArray.valueAt(i11));
        }
    }
}
