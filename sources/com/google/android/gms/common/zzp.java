package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzp implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        IBinder iBinder = null;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        boolean z14 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 2:
                    z11 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 3:
                    z12 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 4:
                    iBinder = SafeParcelReader.readIBinder(parcel, readHeader);
                    break;
                case 5:
                    z13 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 6:
                    z14 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzo(str, z11, z12, iBinder, z13, z14);
    }

    public final /* synthetic */ Object[] newArray(int i11) {
        return new zzo[i11];
    }
}
