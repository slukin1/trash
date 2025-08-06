package com.google.android.gms.auth.api.identity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "SignInPasswordCreator")
public class SignInPassword extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SignInPassword> CREATOR = new zbq();
    @SafeParcelable.Field(getter = "getId", id = 1)
    private final String zba;
    @SafeParcelable.Field(getter = "getPassword", id = 2)
    private final String zbb;

    @SafeParcelable.Constructor
    public SignInPassword(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2) {
        this.zba = Preconditions.checkNotEmpty(((String) Preconditions.checkNotNull(str, "Account identifier cannot be null")).trim(), "Account identifier cannot be empty");
        this.zbb = Preconditions.checkNotEmpty(str2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SignInPassword)) {
            return false;
        }
        SignInPassword signInPassword = (SignInPassword) obj;
        if (!Objects.equal(this.zba, signInPassword.zba) || !Objects.equal(this.zbb, signInPassword.zbb)) {
            return false;
        }
        return true;
    }

    public String getId() {
        return this.zba;
    }

    public String getPassword() {
        return this.zbb;
    }

    public int hashCode() {
        return Objects.hashCode(this.zba, this.zbb);
    }

    public void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getId(), false);
        SafeParcelWriter.writeString(parcel, 2, getPassword(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
