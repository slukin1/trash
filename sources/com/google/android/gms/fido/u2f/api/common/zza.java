package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.fido.u2f.api.common.ChannelIdValue;

final class zza implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        try {
            return ChannelIdValue.toChannelIdValueType(parcel.readInt());
        } catch (ChannelIdValue.UnsupportedChannelIdValueTypeException e11) {
            throw new RuntimeException(e11);
        }
    }

    public final /* synthetic */ Object[] newArray(int i11) {
        return new ChannelIdValue.ChannelIdValueType[i11];
    }
}
