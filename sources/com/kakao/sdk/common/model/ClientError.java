package com.kakao.sdk.common.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/kakao/sdk/common/model/ClientError;", "Lcom/kakao/sdk/common/model/KakaoSdkError;", "Landroid/os/Parcelable;", "reason", "Lcom/kakao/sdk/common/model/ClientErrorCause;", "msg", "", "(Lcom/kakao/sdk/common/model/ClientErrorCause;Ljava/lang/String;)V", "getMsg", "()Ljava/lang/String;", "getReason", "()Lcom/kakao/sdk/common/model/ClientErrorCause;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ClientError extends KakaoSdkError implements Parcelable {
    public static final Parcelable.Creator<ClientError> CREATOR = new Creator();
    private final String msg;
    private final ClientErrorCause reason;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ClientError> {
        /* renamed from: a */
        public final ClientError createFromParcel(Parcel parcel) {
            return new ClientError(ClientErrorCause.valueOf(parcel.readString()), parcel.readString());
        }

        /* renamed from: b */
        public final ClientError[] newArray(int i11) {
            return new ClientError[i11];
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ClientError(com.kakao.sdk.common.model.ClientErrorCause r1, java.lang.String r2, int r3, kotlin.jvm.internal.r r4) {
        /*
            r0 = this;
            r3 = r3 & 2
            if (r3 == 0) goto L_0x0025
            java.lang.Class r2 = r1.getClass()
            java.lang.String r3 = r1.name()
            java.lang.reflect.Field r2 = r2.getField(r3)
            java.lang.Class<com.kakao.sdk.common.model.Description> r3 = com.kakao.sdk.common.model.Description.class
            java.lang.annotation.Annotation r2 = r2.getAnnotation(r3)
            com.kakao.sdk.common.model.Description r2 = (com.kakao.sdk.common.model.Description) r2
            java.lang.String r3 = "Client-side error"
            if (r2 != 0) goto L_0x001e
        L_0x001c:
            r2 = r3
            goto L_0x0025
        L_0x001e:
            java.lang.String r2 = r2.value()
            if (r2 != 0) goto L_0x0025
            goto L_0x001c
        L_0x0025:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakao.sdk.common.model.ClientError.<init>(com.kakao.sdk.common.model.ClientErrorCause, java.lang.String, int, kotlin.jvm.internal.r):void");
    }

    public static /* synthetic */ ClientError copy$default(ClientError clientError, ClientErrorCause clientErrorCause, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            clientErrorCause = clientError.reason;
        }
        if ((i11 & 2) != 0) {
            str = clientError.getMsg();
        }
        return clientError.copy(clientErrorCause, str);
    }

    public final ClientErrorCause component1() {
        return this.reason;
    }

    public final String component2() {
        return getMsg();
    }

    public final ClientError copy(ClientErrorCause clientErrorCause, String str) {
        return new ClientError(clientErrorCause, str);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClientError)) {
            return false;
        }
        ClientError clientError = (ClientError) obj;
        return this.reason == clientError.reason && x.b(getMsg(), clientError.getMsg());
    }

    public String getMsg() {
        return this.msg;
    }

    public final ClientErrorCause getReason() {
        return this.reason;
    }

    public int hashCode() {
        return (this.reason.hashCode() * 31) + getMsg().hashCode();
    }

    public String toString() {
        return "ClientError(reason=" + this.reason + ", msg=" + getMsg() + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.reason.name());
        parcel.writeString(this.msg);
    }

    public ClientError(ClientErrorCause clientErrorCause, String str) {
        super(str, (r) null);
        this.reason = clientErrorCause;
        this.msg = str;
    }
}
