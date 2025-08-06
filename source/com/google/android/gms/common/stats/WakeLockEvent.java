package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;

@KeepForSdk
@SafeParcelable.Class(creator = "WakeLockEventCreator")
@Deprecated
public final class WakeLockEvent extends StatsEvent {
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new zza();
    @SafeParcelable.VersionField(id = 1)
    public final int zza;
    @SafeParcelable.Field(getter = "getTimeMillis", id = 2)
    private final long zzb;
    @SafeParcelable.Field(getter = "getEventType", id = 11)
    private final int zzc;
    @SafeParcelable.Field(getter = "getWakeLockName", id = 4)
    private final String zzd;
    @SafeParcelable.Field(getter = "getSecondaryWakeLockName", id = 10)
    private final String zze;
    @SafeParcelable.Field(getter = "getCodePackage", id = 17)
    private final String zzf;
    @SafeParcelable.Field(getter = "getWakeLockType", id = 5)
    private final int zzg;
    @SafeParcelable.Field(getter = "getCallingPackages", id = 6)
    private final List zzh;
    @SafeParcelable.Field(getter = "getEventKey", id = 12)
    private final String zzi;
    @SafeParcelable.Field(getter = "getElapsedRealtime", id = 8)
    private final long zzj;
    @SafeParcelable.Field(getter = "getDeviceState", id = 14)
    private final int zzk;
    @SafeParcelable.Field(getter = "getHostPackage", id = 13)
    private final String zzl;
    @SafeParcelable.Field(getter = "getBeginPowerPercentage", id = 15)
    private final float zzm;
    @SafeParcelable.Field(getter = "getTimeout", id = 16)
    private final long zzn;
    @SafeParcelable.Field(getter = "getAcquiredWithTimeout", id = 18)
    private final boolean zzo;

    @SafeParcelable.Constructor
    public WakeLockEvent(@SafeParcelable.Param(id = 1) int i11, @SafeParcelable.Param(id = 2) long j11, @SafeParcelable.Param(id = 11) int i12, @SafeParcelable.Param(id = 4) String str, @SafeParcelable.Param(id = 5) int i13, @SafeParcelable.Param(id = 6) List list, @SafeParcelable.Param(id = 12) String str2, @SafeParcelable.Param(id = 8) long j12, @SafeParcelable.Param(id = 14) int i14, @SafeParcelable.Param(id = 10) String str3, @SafeParcelable.Param(id = 13) String str4, @SafeParcelable.Param(id = 15) float f11, @SafeParcelable.Param(id = 16) long j13, @SafeParcelable.Param(id = 17) String str5, @SafeParcelable.Param(id = 18) boolean z11) {
        this.zza = i11;
        this.zzb = j11;
        this.zzc = i12;
        this.zzd = str;
        this.zze = str3;
        this.zzf = str5;
        this.zzg = i13;
        this.zzh = list;
        this.zzi = str2;
        this.zzj = j12;
        this.zzk = i14;
        this.zzl = str4;
        this.zzm = f11;
        this.zzn = j13;
        this.zzo = z11;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeLong(parcel, 2, this.zzb);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeInt(parcel, 5, this.zzg);
        SafeParcelWriter.writeStringList(parcel, 6, this.zzh, false);
        SafeParcelWriter.writeLong(parcel, 8, this.zzj);
        SafeParcelWriter.writeString(parcel, 10, this.zze, false);
        SafeParcelWriter.writeInt(parcel, 11, this.zzc);
        SafeParcelWriter.writeString(parcel, 12, this.zzi, false);
        SafeParcelWriter.writeString(parcel, 13, this.zzl, false);
        SafeParcelWriter.writeInt(parcel, 14, this.zzk);
        SafeParcelWriter.writeFloat(parcel, 15, this.zzm);
        SafeParcelWriter.writeLong(parcel, 16, this.zzn);
        SafeParcelWriter.writeString(parcel, 17, this.zzf, false);
        SafeParcelWriter.writeBoolean(parcel, 18, this.zzo);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int zza() {
        return this.zzc;
    }

    public final long zzb() {
        return this.zzb;
    }

    public final String zzc() {
        String str;
        List list = this.zzh;
        String str2 = "";
        if (list == null) {
            str = str2;
        } else {
            str = TextUtils.join(Constants.ACCEPT_TIME_SEPARATOR_SP, list);
        }
        int i11 = this.zzk;
        String str3 = this.zze;
        String str4 = this.zzl;
        float f11 = this.zzm;
        String str5 = this.zzf;
        int i12 = this.zzg;
        String str6 = this.zzd;
        boolean z11 = this.zzo;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\t");
        sb2.append(str6);
        sb2.append("\t");
        sb2.append(i12);
        sb2.append("\t");
        sb2.append(str);
        sb2.append("\t");
        sb2.append(i11);
        sb2.append("\t");
        if (str3 == null) {
            str3 = str2;
        }
        sb2.append(str3);
        sb2.append("\t");
        if (str4 == null) {
            str4 = str2;
        }
        sb2.append(str4);
        sb2.append("\t");
        sb2.append(f11);
        sb2.append("\t");
        if (str5 != null) {
            str2 = str5;
        }
        sb2.append(str2);
        sb2.append("\t");
        sb2.append(z11);
        return sb2.toString();
    }
}
