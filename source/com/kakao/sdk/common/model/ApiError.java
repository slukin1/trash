package com.kakao.sdk.common.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001!B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\""}, d2 = {"Lcom/kakao/sdk/common/model/ApiError;", "Lcom/kakao/sdk/common/model/KakaoSdkError;", "Landroid/os/Parcelable;", "statusCode", "", "reason", "Lcom/kakao/sdk/common/model/ApiErrorCause;", "response", "Lcom/kakao/sdk/common/model/ApiErrorResponse;", "(ILcom/kakao/sdk/common/model/ApiErrorCause;Lcom/kakao/sdk/common/model/ApiErrorResponse;)V", "getReason", "()Lcom/kakao/sdk/common/model/ApiErrorCause;", "getResponse", "()Lcom/kakao/sdk/common/model/ApiErrorResponse;", "getStatusCode", "()I", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ApiError extends KakaoSdkError implements Parcelable {
    public static final Parcelable.Creator<ApiError> CREATOR = new Creator();
    public static final Companion Companion = new Companion((r) null);
    private final ApiErrorCause reason;
    private final ApiErrorResponse response;
    private final int statusCode;

    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/kakao/sdk/common/model/ApiError$Companion;", "", "<init>", "()V", "common_release"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ApiError> {
        /* renamed from: a */
        public final ApiError createFromParcel(Parcel parcel) {
            return new ApiError(parcel.readInt(), ApiErrorCause.valueOf(parcel.readString()), ApiErrorResponse.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final ApiError[] newArray(int i11) {
            return new ApiError[i11];
        }
    }

    public ApiError(int i11, ApiErrorCause apiErrorCause, ApiErrorResponse apiErrorResponse) {
        super(apiErrorResponse.getMsg(), (r) null);
        this.statusCode = i11;
        this.reason = apiErrorCause;
        this.response = apiErrorResponse;
    }

    public static /* synthetic */ ApiError copy$default(ApiError apiError, int i11, ApiErrorCause apiErrorCause, ApiErrorResponse apiErrorResponse, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = apiError.statusCode;
        }
        if ((i12 & 2) != 0) {
            apiErrorCause = apiError.reason;
        }
        if ((i12 & 4) != 0) {
            apiErrorResponse = apiError.response;
        }
        return apiError.copy(i11, apiErrorCause, apiErrorResponse);
    }

    public final int component1() {
        return this.statusCode;
    }

    public final ApiErrorCause component2() {
        return this.reason;
    }

    public final ApiErrorResponse component3() {
        return this.response;
    }

    public final ApiError copy(int i11, ApiErrorCause apiErrorCause, ApiErrorResponse apiErrorResponse) {
        return new ApiError(i11, apiErrorCause, apiErrorResponse);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ApiError)) {
            return false;
        }
        ApiError apiError = (ApiError) obj;
        return this.statusCode == apiError.statusCode && this.reason == apiError.reason && x.b(this.response, apiError.response);
    }

    public final ApiErrorCause getReason() {
        return this.reason;
    }

    public final ApiErrorResponse getResponse() {
        return this.response;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public int hashCode() {
        return (((this.statusCode * 31) + this.reason.hashCode()) * 31) + this.response.hashCode();
    }

    public String toString() {
        return "ApiError(statusCode=" + this.statusCode + ", reason=" + this.reason + ", response=" + this.response + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.statusCode);
        parcel.writeString(this.reason.name());
        this.response.writeToParcel(parcel, i11);
    }
}
