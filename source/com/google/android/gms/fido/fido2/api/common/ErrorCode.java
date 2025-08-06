package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Locale;

public enum ErrorCode implements Parcelable {
    NOT_SUPPORTED_ERR(9),
    INVALID_STATE_ERR(11),
    SECURITY_ERR(18),
    NETWORK_ERR(19),
    ABORT_ERR(20),
    TIMEOUT_ERR(23),
    ENCODING_ERR(27),
    UNKNOWN_ERR(28),
    CONSTRAINT_ERR(29),
    DATA_ERR(30),
    NOT_ALLOWED_ERR(35),
    ATTESTATION_NOT_PRIVATE_ERR(36);
    
    public static final Parcelable.Creator<ErrorCode> CREATOR = null;
    private final int zzb;

    public static class UnsupportedErrorCodeException extends Exception {
        public UnsupportedErrorCodeException(int i11) {
            super(String.format(Locale.US, "Error code %d is not supported", new Object[]{Integer.valueOf(i11)}));
        }
    }

    /* access modifiers changed from: public */
    static {
        CREATOR = new zzw();
    }

    private ErrorCode(int i11) {
        this.zzb = i11;
    }

    public static ErrorCode toErrorCode(int i11) throws UnsupportedErrorCodeException {
        for (ErrorCode errorCode : values()) {
            if (i11 == errorCode.zzb) {
                return errorCode;
            }
        }
        throw new UnsupportedErrorCodeException(i11);
    }

    public int describeContents() {
        return 0;
    }

    public int getCode() {
        return this.zzb;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.zzb);
    }
}
