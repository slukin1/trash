package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;

final class zzh implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new BinderWrapper(parcel, (zzi) null);
    }

    public final /* synthetic */ Object[] newArray(int i11) {
        return new BinderWrapper[i11];
    }
}
