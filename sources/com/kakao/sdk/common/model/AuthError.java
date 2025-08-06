package com.kakao.sdk.common.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.x;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006!"}, d2 = {"Lcom/kakao/sdk/common/model/AuthError;", "Lcom/kakao/sdk/common/model/KakaoSdkError;", "Landroid/os/Parcelable;", "statusCode", "", "reason", "Lcom/kakao/sdk/common/model/AuthErrorCause;", "response", "Lcom/kakao/sdk/common/model/AuthErrorResponse;", "(ILcom/kakao/sdk/common/model/AuthErrorCause;Lcom/kakao/sdk/common/model/AuthErrorResponse;)V", "getReason", "()Lcom/kakao/sdk/common/model/AuthErrorCause;", "getResponse", "()Lcom/kakao/sdk/common/model/AuthErrorResponse;", "getStatusCode", "()I", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AuthError extends KakaoSdkError implements Parcelable {
    public static final Parcelable.Creator<AuthError> CREATOR = new Creator();
    private final AuthErrorCause reason;
    private final AuthErrorResponse response;
    private final int statusCode;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AuthError> {
        /* renamed from: a */
        public final AuthError createFromParcel(Parcel parcel) {
            return new AuthError(parcel.readInt(), AuthErrorCause.valueOf(parcel.readString()), AuthErrorResponse.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final AuthError[] newArray(int i11) {
            return new AuthError[i11];
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AuthError(int r3, com.kakao.sdk.common.model.AuthErrorCause r4, com.kakao.sdk.common.model.AuthErrorResponse r5) {
        /*
            r2 = this;
            java.lang.String r0 = r5.getErrorDescription()
            if (r0 != 0) goto L_0x000a
            java.lang.String r0 = r5.getError()
        L_0x000a:
            r1 = 0
            r2.<init>(r0, r1)
            r2.statusCode = r3
            r2.reason = r4
            r2.response = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakao.sdk.common.model.AuthError.<init>(int, com.kakao.sdk.common.model.AuthErrorCause, com.kakao.sdk.common.model.AuthErrorResponse):void");
    }

    public static /* synthetic */ AuthError copy$default(AuthError authError, int i11, AuthErrorCause authErrorCause, AuthErrorResponse authErrorResponse, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = authError.statusCode;
        }
        if ((i12 & 2) != 0) {
            authErrorCause = authError.reason;
        }
        if ((i12 & 4) != 0) {
            authErrorResponse = authError.response;
        }
        return authError.copy(i11, authErrorCause, authErrorResponse);
    }

    public final int component1() {
        return this.statusCode;
    }

    public final AuthErrorCause component2() {
        return this.reason;
    }

    public final AuthErrorResponse component3() {
        return this.response;
    }

    public final AuthError copy(int i11, AuthErrorCause authErrorCause, AuthErrorResponse authErrorResponse) {
        return new AuthError(i11, authErrorCause, authErrorResponse);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthError)) {
            return false;
        }
        AuthError authError = (AuthError) obj;
        return this.statusCode == authError.statusCode && this.reason == authError.reason && x.b(this.response, authError.response);
    }

    public final AuthErrorCause getReason() {
        return this.reason;
    }

    public final AuthErrorResponse getResponse() {
        return this.response;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public int hashCode() {
        return (((this.statusCode * 31) + this.reason.hashCode()) * 31) + this.response.hashCode();
    }

    public String toString() {
        return "AuthError(statusCode=" + this.statusCode + ", reason=" + this.reason + ", response=" + this.response + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.statusCode);
        parcel.writeString(this.reason.name());
        this.response.writeToParcel(parcel, i11);
    }
}
