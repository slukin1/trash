package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzz;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

@SafeParcelable.Class(creator = "GoogleCertificatesQueryCreator")
public final class zzs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzs> CREATOR = new zzt();
    @SafeParcelable.Field(getter = "getCallingPackage", id = 1)
    private final String zza;
    @SafeParcelable.Field(getter = "getCallingCertificateBinder", id = 2, type = "android.os.IBinder")
    private final zzj zzb;
    @SafeParcelable.Field(getter = "getAllowTestKeys", id = 3)
    private final boolean zzc;
    @SafeParcelable.Field(defaultValue = "false", getter = "getIgnoreTestKeysOverride", id = 4)
    private final boolean zzd;

    @SafeParcelable.Constructor
    public zzs(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) IBinder iBinder, @SafeParcelable.Param(id = 3) boolean z11, @SafeParcelable.Param(id = 4) boolean z12) {
        byte[] bArr;
        this.zza = str;
        zzk zzk = null;
        if (iBinder != null) {
            try {
                IObjectWrapper zzd2 = zzz.zzg(iBinder).zzd();
                if (zzd2 == null) {
                    bArr = null;
                } else {
                    bArr = (byte[]) ObjectWrapper.unwrap(zzd2);
                }
                if (bArr != null) {
                    zzk = new zzk(bArr);
                } else {
                    Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
                }
            } catch (RemoteException e11) {
                Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e11);
            }
        }
        this.zzb = zzk;
        this.zzc = z11;
        this.zzd = z12;
    }

    public zzs(String str, zzj zzj, boolean z11, boolean z12) {
        this.zza = str;
        this.zzb = zzj;
        this.zzc = z11;
        this.zzd = z12;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        String str = this.zza;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, str, false);
        zzj zzj = this.zzb;
        if (zzj == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            zzj = null;
        }
        SafeParcelWriter.writeIBinder(parcel, 2, zzj, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzd);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
