package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ConditionalUserPropertyParcelCreator")
public final class zzac extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzac> CREATOR = new zzad();
    @SafeParcelable.Field(id = 2)
    public String zza;
    @SafeParcelable.Field(id = 3)
    public String zzb;
    @SafeParcelable.Field(id = 4)
    public zzlk zzc;
    @SafeParcelable.Field(id = 5)
    public long zzd;
    @SafeParcelable.Field(id = 6)
    public boolean zze;
    @SafeParcelable.Field(id = 7)
    public String zzf;
    @SafeParcelable.Field(id = 8)
    public final zzau zzg;
    @SafeParcelable.Field(id = 9)
    public long zzh;
    @SafeParcelable.Field(id = 10)
    public zzau zzi;
    @SafeParcelable.Field(id = 11)
    public final long zzj;
    @SafeParcelable.Field(id = 12)
    public final zzau zzk;

    public zzac(zzac zzac) {
        Preconditions.checkNotNull(zzac);
        this.zza = zzac.zza;
        this.zzb = zzac.zzb;
        this.zzc = zzac.zzc;
        this.zzd = zzac.zzd;
        this.zze = zzac.zze;
        this.zzf = zzac.zzf;
        this.zzg = zzac.zzg;
        this.zzh = zzac.zzh;
        this.zzi = zzac.zzi;
        this.zzj = zzac.zzj;
        this.zzk = zzac.zzk;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzc, i11, false);
        SafeParcelWriter.writeLong(parcel, 5, this.zzd);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zze);
        SafeParcelWriter.writeString(parcel, 7, this.zzf, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzg, i11, false);
        SafeParcelWriter.writeLong(parcel, 9, this.zzh);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzi, i11, false);
        SafeParcelWriter.writeLong(parcel, 11, this.zzj);
        SafeParcelWriter.writeParcelable(parcel, 12, this.zzk, i11, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    public zzac(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) zzlk zzlk, @SafeParcelable.Param(id = 5) long j11, @SafeParcelable.Param(id = 6) boolean z11, @SafeParcelable.Param(id = 7) String str3, @SafeParcelable.Param(id = 8) zzau zzau, @SafeParcelable.Param(id = 9) long j12, @SafeParcelable.Param(id = 10) zzau zzau2, @SafeParcelable.Param(id = 11) long j13, @SafeParcelable.Param(id = 12) zzau zzau3) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzlk;
        this.zzd = j11;
        this.zze = z11;
        this.zzf = str3;
        this.zzg = zzau;
        this.zzh = j12;
        this.zzi = zzau2;
        this.zzj = j13;
        this.zzk = zzau3;
    }
}
