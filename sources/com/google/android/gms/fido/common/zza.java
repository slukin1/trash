package com.google.android.gms.fido.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.fido.common.Transport;

final class zza implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        try {
            return Transport.fromString(parcel.readString());
        } catch (Transport.UnsupportedTransportException e11) {
            throw new RuntimeException(e11);
        }
    }

    public final /* synthetic */ Object[] newArray(int i11) {
        return new Transport[i11];
    }
}
