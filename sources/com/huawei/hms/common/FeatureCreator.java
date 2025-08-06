package com.huawei.hms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.safeparcel.SafeParcelReader;

public final class FeatureCreator implements Parcelable.Creator<Feature> {
    public final Feature createFromParcel(Parcel parcel) {
        String str = null;
        if (parcel == null) {
            return null;
        }
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        long j11 = -1;
        int i11 = 0;
        int i12 = 0;
        while (i11 <= validateObjectHeader && parcel.dataPosition() < validateObjectHeader) {
            i11++;
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                str = SafeParcelReader.createString(parcel, readHeader);
            } else if (fieldId == 2) {
                i12 = SafeParcelReader.readInt(parcel, readHeader);
            } else if (fieldId != 3) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                j11 = SafeParcelReader.readLong(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new Feature(str, i12, j11);
    }

    public final Feature[] newArray(int i11) {
        return new Feature[i11];
    }
}
