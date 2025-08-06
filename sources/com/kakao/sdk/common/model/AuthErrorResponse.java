package com.kakao.sdk.common.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.x;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/kakao/sdk/common/model/AuthErrorResponse;", "Landroid/os/Parcelable;", "error", "", "errorDescription", "(Ljava/lang/String;Ljava/lang/String;)V", "getError", "()Ljava/lang/String;", "getErrorDescription", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AuthErrorResponse implements Parcelable {
    public static final Parcelable.Creator<AuthErrorResponse> CREATOR = new Creator();
    private final String error;
    private final String errorDescription;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AuthErrorResponse> {
        /* renamed from: a */
        public final AuthErrorResponse createFromParcel(Parcel parcel) {
            return new AuthErrorResponse(parcel.readString(), parcel.readString());
        }

        /* renamed from: b */
        public final AuthErrorResponse[] newArray(int i11) {
            return new AuthErrorResponse[i11];
        }
    }

    public AuthErrorResponse(String str, String str2) {
        this.error = str;
        this.errorDescription = str2;
    }

    public static /* synthetic */ AuthErrorResponse copy$default(AuthErrorResponse authErrorResponse, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = authErrorResponse.error;
        }
        if ((i11 & 2) != 0) {
            str2 = authErrorResponse.errorDescription;
        }
        return authErrorResponse.copy(str, str2);
    }

    public final String component1() {
        return this.error;
    }

    public final String component2() {
        return this.errorDescription;
    }

    public final AuthErrorResponse copy(String str, String str2) {
        return new AuthErrorResponse(str, str2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthErrorResponse)) {
            return false;
        }
        AuthErrorResponse authErrorResponse = (AuthErrorResponse) obj;
        return x.b(this.error, authErrorResponse.error) && x.b(this.errorDescription, authErrorResponse.errorDescription);
    }

    public final String getError() {
        return this.error;
    }

    public final String getErrorDescription() {
        return this.errorDescription;
    }

    public int hashCode() {
        int hashCode = this.error.hashCode() * 31;
        String str = this.errorDescription;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "AuthErrorResponse(error=" + this.error + ", errorDescription=" + this.errorDescription + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.error);
        parcel.writeString(this.errorDescription);
    }
}
