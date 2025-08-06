package com.google.android.gms.cloudmessaging;

import android.os.Parcel;
import android.os.Parcelable;

final class zzb implements Parcelable.Creator<zzd> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new zzd(parcel.readStrongBinder());
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i11) {
        return new zzd[i11];
    }
}
