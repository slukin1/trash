package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class zza implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        long j11 = 0;
        long j12 = 0;
        long j13 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        boolean z11 = false;
        String str = null;
        ArrayList<String> arrayList = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        float f11 = 0.0f;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i11 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 2:
                    j11 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 4:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 5:
                    i13 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 6:
                    arrayList = SafeParcelReader.createStringList(parcel2, readHeader);
                    break;
                case 8:
                    j12 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 10:
                    str3 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 11:
                    i12 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 12:
                    str2 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 13:
                    str4 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 14:
                    i14 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 15:
                    f11 = SafeParcelReader.readFloat(parcel2, readHeader);
                    break;
                case 16:
                    j13 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 17:
                    str5 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 18:
                    z11 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new WakeLockEvent(i11, j11, i12, str, i13, arrayList, str2, j12, i14, str3, str4, f11, j13, str5, z11);
    }

    public final /* synthetic */ Object[] newArray(int i11) {
        return new WakeLockEvent[i11];
    }
}
