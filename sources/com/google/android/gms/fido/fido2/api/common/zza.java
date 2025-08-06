package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.fido.fido2.api.common.Attachment;

final class zza implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        try {
            return Attachment.fromString(parcel.readString());
        } catch (Attachment.UnsupportedAttachmentException e11) {
            throw new RuntimeException(e11);
        }
    }

    public final /* synthetic */ Object[] newArray(int i11) {
        return new Attachment[i11];
    }
}
