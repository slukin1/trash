package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zaq implements Parcelable.Creator<SafeParcelResponse> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        Parcel parcel2 = null;
        int i11 = 0;
        zan zan = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                i11 = SafeParcelReader.readInt(parcel, readHeader);
            } else if (fieldId == 2) {
                parcel2 = SafeParcelReader.createParcel(parcel, readHeader);
            } else if (fieldId != 3) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                zan = (zan) SafeParcelReader.createParcelable(parcel, readHeader, zan.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new SafeParcelResponse(i11, parcel2, zan);
    }

    public final /* synthetic */ Object[] newArray(int i11) {
        return new SafeParcelResponse[i11];
    }
}
