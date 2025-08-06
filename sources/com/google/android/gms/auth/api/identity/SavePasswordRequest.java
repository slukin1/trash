package com.google.android.gms.auth.api.identity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "SavePasswordRequestCreator")
public class SavePasswordRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SavePasswordRequest> CREATOR = new zbm();
    @SafeParcelable.Field(getter = "getSignInPassword", id = 1)
    private final SignInPassword zba;
    @SafeParcelable.Field(getter = "getSessionId", id = 2)
    private final String zbb;
    @SafeParcelable.Field(getter = "getTheme", id = 3)
    private final int zbc;

    public static final class Builder {
        private SignInPassword zba;
        private String zbb;
        private int zbc;

        public SavePasswordRequest build() {
            return new SavePasswordRequest(this.zba, this.zbb, this.zbc);
        }

        public Builder setSignInPassword(SignInPassword signInPassword) {
            this.zba = signInPassword;
            return this;
        }

        public final Builder zba(String str) {
            this.zbb = str;
            return this;
        }

        public final Builder zbb(int i11) {
            this.zbc = i11;
            return this;
        }
    }

    @SafeParcelable.Constructor
    public SavePasswordRequest(@SafeParcelable.Param(id = 1) SignInPassword signInPassword, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i11) {
        this.zba = (SignInPassword) Preconditions.checkNotNull(signInPassword);
        this.zbb = str;
        this.zbc = i11;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder zba(SavePasswordRequest savePasswordRequest) {
        Preconditions.checkNotNull(savePasswordRequest);
        Builder builder = builder();
        builder.setSignInPassword(savePasswordRequest.getSignInPassword());
        builder.zbb(savePasswordRequest.zbc);
        String str = savePasswordRequest.zbb;
        if (str != null) {
            builder.zba(str);
        }
        return builder;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SavePasswordRequest)) {
            return false;
        }
        SavePasswordRequest savePasswordRequest = (SavePasswordRequest) obj;
        if (!Objects.equal(this.zba, savePasswordRequest.zba) || !Objects.equal(this.zbb, savePasswordRequest.zbb) || this.zbc != savePasswordRequest.zbc) {
            return false;
        }
        return true;
    }

    public SignInPassword getSignInPassword() {
        return this.zba;
    }

    public int hashCode() {
        return Objects.hashCode(this.zba, this.zbb);
    }

    public void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getSignInPassword(), i11, false);
        SafeParcelWriter.writeString(parcel, 2, this.zbb, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zbc);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
