package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.io.UnsupportedEncodingException;

@Deprecated
public enum ProtocolVersion implements Parcelable {
    UNKNOWN(GrsBaseInfo.CountryCodeSource.UNKNOWN),
    V1("U2F_V1"),
    V2("U2F_V2");
    
    public static final Parcelable.Creator<ProtocolVersion> CREATOR = null;
    private final String zzb;

    public static class UnsupportedProtocolException extends Exception {
        public UnsupportedProtocolException(String str) {
            super(String.format("Protocol version %s not supported", new Object[]{str}));
        }
    }

    /* access modifiers changed from: public */
    static {
        CREATOR = new zzf();
    }

    private ProtocolVersion(String str) {
        this.zzb = str;
    }

    public static ProtocolVersion fromBytes(byte[] bArr) throws UnsupportedProtocolException {
        try {
            return fromString(new String(bArr, "UTF-8"));
        } catch (UnsupportedEncodingException e11) {
            throw new RuntimeException(e11);
        }
    }

    public static ProtocolVersion fromString(String str) throws UnsupportedProtocolException {
        if (str == null) {
            return UNKNOWN;
        }
        for (ProtocolVersion protocolVersion : values()) {
            if (str.equals(protocolVersion.zzb)) {
                return protocolVersion;
            }
        }
        throw new UnsupportedProtocolException(str);
    }

    public int describeContents() {
        return 0;
    }

    public boolean isCompatible(ProtocolVersion protocolVersion) {
        ProtocolVersion protocolVersion2 = UNKNOWN;
        if (equals(protocolVersion2) || protocolVersion.equals(protocolVersion2)) {
            return true;
        }
        return equals(protocolVersion);
    }

    public String toString() {
        return this.zzb;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.zzb);
    }
}
