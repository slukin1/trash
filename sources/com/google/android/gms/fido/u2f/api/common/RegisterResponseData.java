package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fido.u2f.api.common.ProtocolVersion;
import com.google.android.gms.internal.fido.zzaj;
import com.google.android.gms.internal.fido.zzak;
import com.google.android.gms.internal.fido.zzbf;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "RegisterResponseDataCreator")
@SafeParcelable.Reserved({1})
@Deprecated
public class RegisterResponseData extends ResponseData {
    public static final Parcelable.Creator<RegisterResponseData> CREATOR = new zzi();
    @SafeParcelable.Field(getter = "getRegisterData", id = 2)
    private final byte[] zza;
    @SafeParcelable.Field(getter = "getProtocolVersionAsString", id = 3, type = "java.lang.String")
    private final ProtocolVersion zzb;
    @SafeParcelable.Field(getter = "getClientDataString", id = 4)
    private final String zzc;

    public RegisterResponseData(byte[] bArr) {
        this.zza = (byte[]) Preconditions.checkNotNull(bArr);
        this.zzb = ProtocolVersion.V1;
        this.zzc = null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof RegisterResponseData)) {
            return false;
        }
        RegisterResponseData registerResponseData = (RegisterResponseData) obj;
        if (!Objects.equal(this.zzb, registerResponseData.zzb) || !Arrays.equals(this.zza, registerResponseData.zza) || !Objects.equal(this.zzc, registerResponseData.zzc)) {
            return false;
        }
        return true;
    }

    public String getClientDataString() {
        return this.zzc;
    }

    public ProtocolVersion getProtocolVersion() {
        return this.zzb;
    }

    public byte[] getRegisterData() {
        return this.zza;
    }

    public int getVersionCode() {
        ProtocolVersion protocolVersion = ProtocolVersion.UNKNOWN;
        int ordinal = this.zzb.ordinal();
        int i11 = 1;
        if (ordinal != 1) {
            i11 = 2;
            if (ordinal != 2) {
                return -1;
            }
        }
        return i11;
    }

    public int hashCode() {
        return Objects.hashCode(this.zzb, Integer.valueOf(Arrays.hashCode(this.zza)), this.zzc);
    }

    public JSONObject toJsonObject() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("registrationData", Base64.encodeToString(this.zza, 11));
            jSONObject.put("version", this.zzb.toString());
            String str = this.zzc;
            if (str != null) {
                jSONObject.put(SignResponseData.JSON_RESPONSE_DATA_CLIENT_DATA, Base64.encodeToString(str.getBytes(), 11));
            }
            return jSONObject;
        } catch (JSONException e11) {
            throw new RuntimeException(e11);
        }
    }

    public String toString() {
        zzaj zza2 = zzak.zza(this);
        zza2.zzb("protocolVersion", this.zzb);
        zzbf zzd = zzbf.zzd();
        byte[] bArr = this.zza;
        zza2.zzb("registerData", zzd.zze(bArr, 0, bArr.length));
        String str = this.zzc;
        if (str != null) {
            zza2.zzb("clientDataString", str);
        }
        return zza2.toString();
    }

    public void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArray(parcel, 2, getRegisterData(), false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb.toString(), false);
        SafeParcelWriter.writeString(parcel, 4, getClientDataString(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public RegisterResponseData(byte[] bArr, ProtocolVersion protocolVersion, String str) {
        this.zza = (byte[]) Preconditions.checkNotNull(bArr);
        this.zzb = (ProtocolVersion) Preconditions.checkNotNull(protocolVersion);
        boolean z11 = true;
        Preconditions.checkArgument(protocolVersion != ProtocolVersion.UNKNOWN);
        if (protocolVersion == ProtocolVersion.V1) {
            Preconditions.checkArgument(str != null ? false : z11);
            this.zzc = null;
            return;
        }
        this.zzc = (String) Preconditions.checkNotNull(str);
    }

    @SafeParcelable.Constructor
    public RegisterResponseData(@SafeParcelable.Param(id = 2) byte[] bArr, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) String str2) {
        this.zza = bArr;
        try {
            this.zzb = ProtocolVersion.fromString(str);
            this.zzc = str2;
        } catch (ProtocolVersion.UnsupportedProtocolException e11) {
            throw new IllegalArgumentException(e11);
        }
    }
}
