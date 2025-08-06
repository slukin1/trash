package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.fido.u2f.api.common.ProtocolVersion;

final class zzf implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        try {
            return ProtocolVersion.fromString(parcel.readString());
        } catch (ProtocolVersion.UnsupportedProtocolException e11) {
            throw new RuntimeException(e11);
        }
    }

    public final /* synthetic */ Object[] newArray(int i11) {
        return new ProtocolVersion[i11];
    }
}
