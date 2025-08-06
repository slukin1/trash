package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;

public class ParcelableSparseArray extends SparseArray<Parcelable> implements Parcelable {
    public static final Parcelable.Creator<ParcelableSparseArray> CREATOR = new Parcelable.ClassLoaderCreator<ParcelableSparseArray>() {
        public ParcelableSparseArray[] newArray(int i11) {
            return new ParcelableSparseArray[i11];
        }

        public ParcelableSparseArray createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new ParcelableSparseArray(parcel, classLoader);
        }

        public ParcelableSparseArray createFromParcel(Parcel parcel) {
            return new ParcelableSparseArray(parcel, (ClassLoader) null);
        }
    };

    public ParcelableSparseArray() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        int size = size();
        int[] iArr = new int[size];
        Parcelable[] parcelableArr = new Parcelable[size];
        for (int i12 = 0; i12 < size; i12++) {
            iArr[i12] = keyAt(i12);
            parcelableArr[i12] = (Parcelable) valueAt(i12);
        }
        parcel.writeInt(size);
        parcel.writeIntArray(iArr);
        parcel.writeParcelableArray(parcelableArr, i11);
    }

    public ParcelableSparseArray(Parcel parcel, ClassLoader classLoader) {
        int readInt = parcel.readInt();
        int[] iArr = new int[readInt];
        parcel.readIntArray(iArr);
        Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
        for (int i11 = 0; i11 < readInt; i11++) {
            put(iArr[i11], readParcelableArray[i11]);
        }
    }
}
