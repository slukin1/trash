package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzad implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        long j11 = 0;
        long j12 = 0;
        long j13 = 0;
        String str = null;
        String str2 = null;
        zzlk zzlk = null;
        String str3 = null;
        zzau zzau = null;
        zzau zzau2 = null;
        zzau zzau3 = null;
        boolean z11 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 3:
                    str2 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 4:
                    zzlk = (zzlk) SafeParcelReader.createParcelable(parcel2, readHeader, zzlk.CREATOR);
                    break;
                case 5:
                    j11 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 6:
                    z11 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 7:
                    str3 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 8:
                    zzau = (zzau) SafeParcelReader.createParcelable(parcel2, readHeader, zzau.CREATOR);
                    break;
                case 9:
                    j12 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 10:
                    zzau2 = (zzau) SafeParcelReader.createParcelable(parcel2, readHeader, zzau.CREATOR);
                    break;
                case 11:
                    j13 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 12:
                    zzau3 = (zzau) SafeParcelReader.createParcelable(parcel2, readHeader, zzau.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new zzac(str, str2, zzlk, j11, z11, str3, zzau, j12, zzau2, j13, zzau3);
    }

    public final /* synthetic */ Object[] newArray(int i11) {
        return new zzac[i11];
    }
}
