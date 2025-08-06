package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@KeepForSdk
@SafeParcelable.Class(creator = "GetServiceRequestCreator")
@SafeParcelable.Reserved({9})
public class GetServiceRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new zzn();
    public static final Scope[] zza = new Scope[0];
    public static final Feature[] zzb = new Feature[0];
    @SafeParcelable.VersionField(id = 1)
    public final int zzc;
    @SafeParcelable.Field(id = 2)
    public final int zzd;
    @SafeParcelable.Field(id = 3)
    public final int zze;
    @SafeParcelable.Field(id = 4)
    public String zzf;
    @SafeParcelable.Field(id = 5)
    public IBinder zzg;
    @SafeParcelable.Field(defaultValueUnchecked = "GetServiceRequest.EMPTY_SCOPES", id = 6)
    public Scope[] zzh;
    @SafeParcelable.Field(defaultValueUnchecked = "new android.os.Bundle()", id = 7)
    public Bundle zzi;
    @SafeParcelable.Field(id = 8)
    public Account zzj;
    @SafeParcelable.Field(defaultValueUnchecked = "GetServiceRequest.EMPTY_FEATURES", id = 10)
    public Feature[] zzk;
    @SafeParcelable.Field(defaultValueUnchecked = "GetServiceRequest.EMPTY_FEATURES", id = 11)
    public Feature[] zzl;
    @SafeParcelable.Field(id = 12)
    public final boolean zzm;
    @SafeParcelable.Field(defaultValue = "0", id = 13)
    public final int zzn;
    @SafeParcelable.Field(getter = "isRequestingTelemetryConfiguration", id = 14)
    public boolean zzo;
    @SafeParcelable.Field(getter = "getAttributionTag", id = 15)
    private final String zzp;

    @SafeParcelable.Constructor
    public GetServiceRequest(@SafeParcelable.Param(id = 1) int i11, @SafeParcelable.Param(id = 2) int i12, @SafeParcelable.Param(id = 3) int i13, @SafeParcelable.Param(id = 4) String str, @SafeParcelable.Param(id = 5) IBinder iBinder, @SafeParcelable.Param(id = 6) Scope[] scopeArr, @SafeParcelable.Param(id = 7) Bundle bundle, @SafeParcelable.Param(id = 8) Account account, @SafeParcelable.Param(id = 10) Feature[] featureArr, @SafeParcelable.Param(id = 11) Feature[] featureArr2, @SafeParcelable.Param(id = 12) boolean z11, @SafeParcelable.Param(id = 13) int i14, @SafeParcelable.Param(id = 14) boolean z12, @SafeParcelable.Param(id = 15) String str2) {
        scopeArr = scopeArr == null ? zza : scopeArr;
        bundle = bundle == null ? new Bundle() : bundle;
        featureArr = featureArr == null ? zzb : featureArr;
        featureArr2 = featureArr2 == null ? zzb : featureArr2;
        this.zzc = i11;
        this.zzd = i12;
        this.zze = i13;
        if ("com.google.android.gms".equals(str)) {
            this.zzf = "com.google.android.gms";
        } else {
            this.zzf = str;
        }
        if (i11 < 2) {
            this.zzj = iBinder != null ? AccountAccessor.getAccountBinderSafe(IAccountAccessor.Stub.asInterface(iBinder)) : null;
        } else {
            this.zzg = iBinder;
            this.zzj = account;
        }
        this.zzh = scopeArr;
        this.zzi = bundle;
        this.zzk = featureArr;
        this.zzl = featureArr2;
        this.zzm = z11;
        this.zzn = i14;
        this.zzo = z12;
        this.zzp = str2;
    }

    @KeepForSdk
    public Bundle getExtraArgs() {
        return this.zzi;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        zzn.zza(this, parcel, i11);
    }

    public final String zza() {
        return this.zzp;
    }
}
