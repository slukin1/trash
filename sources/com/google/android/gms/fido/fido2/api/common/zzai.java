package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

@SafeParcelable.Class(creator = "PrfExtensionCreator")
public final class zzai extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzai> CREATOR = new zzaj();
    @SafeParcelable.Field(getter = "getEvaluationPoints", id = 1)
    private final byte[][] zza;

    @SafeParcelable.Constructor
    public zzai(@SafeParcelable.Param(id = 1) byte[][] bArr) {
        Preconditions.checkArgument(bArr != null);
        Preconditions.checkArgument(1 == ((bArr.length & 1) ^ 1));
        int i11 = 0;
        while (i11 < bArr.length) {
            Preconditions.checkArgument(i11 == 0 || bArr[i11] != null);
            int i12 = i11 + 1;
            Preconditions.checkArgument(bArr[i12] != null);
            int length = bArr[i12].length;
            Preconditions.checkArgument(length == 32 || length == 64);
            i11 += 2;
        }
        this.zza = bArr;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzai)) {
            return false;
        }
        return Arrays.deepEquals(this.zza, ((zzai) obj).zza);
    }

    public final int hashCode() {
        Object[] objArr = this.zza;
        int length = objArr.length;
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            i11 ^= Objects.hashCode(objArr[i12]);
        }
        return i11;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArrayArray(parcel, 1, this.zza, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
