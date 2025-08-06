package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzll implements Parcelable.Creator {
    public static void zza(zzlk zzlk, Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, zzlk.zza);
        SafeParcelWriter.writeString(parcel, 2, zzlk.zzb, false);
        SafeParcelWriter.writeLong(parcel, 3, zzlk.zzc);
        SafeParcelWriter.writeLongObject(parcel, 4, zzlk.zzd, false);
        SafeParcelWriter.writeFloatObject(parcel, 5, (Float) null, false);
        SafeParcelWriter.writeString(parcel, 6, zzlk.zze, false);
        SafeParcelWriter.writeString(parcel, 7, zzlk.zzf, false);
        SafeParcelWriter.writeDoubleObject(parcel, 8, zzlk.zzg, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        Long l11 = null;
        Float f11 = null;
        String str2 = null;
        String str3 = null;
        Double d11 = null;
        long j11 = 0;
        int i11 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i11 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 2:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 3:
                    j11 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 4:
                    l11 = SafeParcelReader.readLongObject(parcel2, readHeader);
                    break;
                case 5:
                    f11 = SafeParcelReader.readFloatObject(parcel2, readHeader);
                    break;
                case 6:
                    str2 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 7:
                    str3 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 8:
                    d11 = SafeParcelReader.readDoubleObject(parcel2, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new zzlk(i11, str, j11, l11, f11, str2, str3, d11);
    }

    public final /* synthetic */ Object[] newArray(int i11) {
        return new zzlk[i11];
    }
}
