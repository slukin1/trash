package com.kakao.sdk.common.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001!B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\""}, d2 = {"Lcom/kakao/sdk/common/model/AppsError;", "Lcom/kakao/sdk/common/model/KakaoSdkError;", "Landroid/os/Parcelable;", "statusCode", "", "reason", "Lcom/kakao/sdk/common/model/AppsErrorCause;", "response", "Lcom/kakao/sdk/common/model/AppsErrorResponse;", "(ILcom/kakao/sdk/common/model/AppsErrorCause;Lcom/kakao/sdk/common/model/AppsErrorResponse;)V", "getReason", "()Lcom/kakao/sdk/common/model/AppsErrorCause;", "getResponse", "()Lcom/kakao/sdk/common/model/AppsErrorResponse;", "getStatusCode", "()I", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AppsError extends KakaoSdkError implements Parcelable {
    public static final Parcelable.Creator<AppsError> CREATOR = new Creator();
    public static final Companion Companion = new Companion((r) null);
    private final AppsErrorCause reason;
    private final AppsErrorResponse response;
    private final int statusCode;

    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/kakao/sdk/common/model/AppsError$Companion;", "", "<init>", "()V", "common_release"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AppsError> {
        /* renamed from: a */
        public final AppsError createFromParcel(Parcel parcel) {
            return new AppsError(parcel.readInt(), AppsErrorCause.valueOf(parcel.readString()), AppsErrorResponse.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final AppsError[] newArray(int i11) {
            return new AppsError[i11];
        }
    }

    public AppsError(int i11, AppsErrorCause appsErrorCause, AppsErrorResponse appsErrorResponse) {
        super(appsErrorResponse.getErrorMessage(), (r) null);
        this.statusCode = i11;
        this.reason = appsErrorCause;
        this.response = appsErrorResponse;
    }

    public static /* synthetic */ AppsError copy$default(AppsError appsError, int i11, AppsErrorCause appsErrorCause, AppsErrorResponse appsErrorResponse, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = appsError.statusCode;
        }
        if ((i12 & 2) != 0) {
            appsErrorCause = appsError.reason;
        }
        if ((i12 & 4) != 0) {
            appsErrorResponse = appsError.response;
        }
        return appsError.copy(i11, appsErrorCause, appsErrorResponse);
    }

    public final int component1() {
        return this.statusCode;
    }

    public final AppsErrorCause component2() {
        return this.reason;
    }

    public final AppsErrorResponse component3() {
        return this.response;
    }

    public final AppsError copy(int i11, AppsErrorCause appsErrorCause, AppsErrorResponse appsErrorResponse) {
        return new AppsError(i11, appsErrorCause, appsErrorResponse);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppsError)) {
            return false;
        }
        AppsError appsError = (AppsError) obj;
        return this.statusCode == appsError.statusCode && this.reason == appsError.reason && x.b(this.response, appsError.response);
    }

    public final AppsErrorCause getReason() {
        return this.reason;
    }

    public final AppsErrorResponse getResponse() {
        return this.response;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public int hashCode() {
        return (((this.statusCode * 31) + this.reason.hashCode()) * 31) + this.response.hashCode();
    }

    public String toString() {
        return "AppsError(statusCode=" + this.statusCode + ", reason=" + this.reason + ", response=" + this.response + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.statusCode);
        parcel.writeString(this.reason.name());
        this.response.writeToParcel(parcel, i11);
    }
}
