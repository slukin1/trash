package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;

@Deprecated
public enum ErrorCode implements Parcelable {
    OK(0),
    OTHER_ERROR(1),
    BAD_REQUEST(2),
    CONFIGURATION_UNSUPPORTED(3),
    DEVICE_INELIGIBLE(4),
    TIMEOUT(5);
    
    public static final Parcelable.Creator<ErrorCode> CREATOR = null;
    private static final String zza = null;
    private final int zzc;

    /* access modifiers changed from: public */
    static {
        zza = ErrorCode.class.getSimpleName();
        CREATOR = new zzc();
    }

    private ErrorCode(int i11) {
        this.zzc = i11;
    }

    public static ErrorCode toErrorCode(int i11) {
        for (ErrorCode errorCode : values()) {
            if (i11 == errorCode.zzc) {
                return errorCode;
            }
        }
        return OTHER_ERROR;
    }

    public int describeContents() {
        return 0;
    }

    public int getCode() {
        return this.zzc;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.zzc);
    }
}
