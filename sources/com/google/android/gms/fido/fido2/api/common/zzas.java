package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.fido.fido2.api.common.ResidentKeyRequirement;

final class zzas implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        String readString = parcel.readString();
        if (readString == null) {
            readString = "";
        }
        try {
            return ResidentKeyRequirement.fromString(readString);
        } catch (ResidentKeyRequirement.UnsupportedResidentKeyRequirementException e11) {
            throw new RuntimeException(e11);
        }
    }

    public final /* synthetic */ Object[] newArray(int i11) {
        return new ResidentKeyRequirement[i11];
    }
}
