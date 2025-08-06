package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.fido.fido2.api.common.TokenBinding;

final class zzat implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        try {
            return TokenBinding.TokenBindingStatus.fromString(parcel.readString());
        } catch (TokenBinding.UnsupportedTokenBindingStatusException e11) {
            throw new RuntimeException(e11);
        }
    }

    public final /* synthetic */ Object[] newArray(int i11) {
        return new TokenBinding.TokenBindingStatus[i11];
    }
}
