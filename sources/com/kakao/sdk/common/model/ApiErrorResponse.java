package com.kakao.sdk.common.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bHÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bHÆ\u0003JM\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bHÆ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0003HÖ\u0001R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006%"}, d2 = {"Lcom/kakao/sdk/common/model/ApiErrorResponse;", "Landroid/os/Parcelable;", "code", "", "msg", "", "apiType", "requiredScopes", "", "allowedScopes", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getAllowedScopes", "()Ljava/util/List;", "getApiType", "()Ljava/lang/String;", "getCode", "()I", "getMsg", "getRequiredScopes", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ApiErrorResponse implements Parcelable {
    public static final Parcelable.Creator<ApiErrorResponse> CREATOR = new Creator();
    private final List<String> allowedScopes;
    private final String apiType;
    private final int code;
    private final String msg;
    private final List<String> requiredScopes;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ApiErrorResponse> {
        /* renamed from: a */
        public final ApiErrorResponse createFromParcel(Parcel parcel) {
            return new ApiErrorResponse(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.createStringArrayList(), parcel.createStringArrayList());
        }

        /* renamed from: b */
        public final ApiErrorResponse[] newArray(int i11) {
            return new ApiErrorResponse[i11];
        }
    }

    public ApiErrorResponse(int i11, String str, String str2, List<String> list, List<String> list2) {
        this.code = i11;
        this.msg = str;
        this.apiType = str2;
        this.requiredScopes = list;
        this.allowedScopes = list2;
    }

    public static /* synthetic */ ApiErrorResponse copy$default(ApiErrorResponse apiErrorResponse, int i11, String str, String str2, List<String> list, List<String> list2, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = apiErrorResponse.code;
        }
        if ((i12 & 2) != 0) {
            str = apiErrorResponse.msg;
        }
        String str3 = str;
        if ((i12 & 4) != 0) {
            str2 = apiErrorResponse.apiType;
        }
        String str4 = str2;
        if ((i12 & 8) != 0) {
            list = apiErrorResponse.requiredScopes;
        }
        List<String> list3 = list;
        if ((i12 & 16) != 0) {
            list2 = apiErrorResponse.allowedScopes;
        }
        return apiErrorResponse.copy(i11, str3, str4, list3, list2);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.msg;
    }

    public final String component3() {
        return this.apiType;
    }

    public final List<String> component4() {
        return this.requiredScopes;
    }

    public final List<String> component5() {
        return this.allowedScopes;
    }

    public final ApiErrorResponse copy(int i11, String str, String str2, List<String> list, List<String> list2) {
        return new ApiErrorResponse(i11, str, str2, list, list2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ApiErrorResponse)) {
            return false;
        }
        ApiErrorResponse apiErrorResponse = (ApiErrorResponse) obj;
        return this.code == apiErrorResponse.code && x.b(this.msg, apiErrorResponse.msg) && x.b(this.apiType, apiErrorResponse.apiType) && x.b(this.requiredScopes, apiErrorResponse.requiredScopes) && x.b(this.allowedScopes, apiErrorResponse.allowedScopes);
    }

    public final List<String> getAllowedScopes() {
        return this.allowedScopes;
    }

    public final String getApiType() {
        return this.apiType;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final List<String> getRequiredScopes() {
        return this.requiredScopes;
    }

    public int hashCode() {
        int hashCode = ((this.code * 31) + this.msg.hashCode()) * 31;
        String str = this.apiType;
        int i11 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<String> list = this.requiredScopes;
        int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        List<String> list2 = this.allowedScopes;
        if (list2 != null) {
            i11 = list2.hashCode();
        }
        return hashCode3 + i11;
    }

    public String toString() {
        return "ApiErrorResponse(code=" + this.code + ", msg=" + this.msg + ", apiType=" + this.apiType + ", requiredScopes=" + this.requiredScopes + ", allowedScopes=" + this.allowedScopes + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.code);
        parcel.writeString(this.msg);
        parcel.writeString(this.apiType);
        parcel.writeStringList(this.requiredScopes);
        parcel.writeStringList(this.allowedScopes);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ApiErrorResponse(int i11, String str, String str2, List list, List list2, int i12, r rVar) {
        this(i11, str, (i12 & 4) != 0 ? null : str2, (i12 & 8) != 0 ? null : list, (i12 & 16) != 0 ? null : list2);
    }
}
