package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Patterns;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@KeepForSdkWithMembers
@ShowFirstParty
@SafeParcelable.Class(creator = "ProxyRequestCreator")
public class ProxyRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ProxyRequest> CREATOR = new zza();
    public static final int HTTP_METHOD_DELETE = 3;
    public static final int HTTP_METHOD_GET = 0;
    public static final int HTTP_METHOD_HEAD = 4;
    public static final int HTTP_METHOD_OPTIONS = 5;
    public static final int HTTP_METHOD_PATCH = 7;
    public static final int HTTP_METHOD_POST = 1;
    public static final int HTTP_METHOD_PUT = 2;
    public static final int HTTP_METHOD_TRACE = 6;
    public static final int LAST_CODE = 7;
    public static final int VERSION_CODE = 2;
    @SafeParcelable.Field(id = 4)
    public final byte[] body;
    @SafeParcelable.Field(id = 2)
    public final int httpMethod;
    @SafeParcelable.Field(id = 3)
    public final long timeoutMillis;
    @SafeParcelable.Field(id = 1)
    public final String url;
    @SafeParcelable.VersionField(id = 1000)
    public final int zza;
    @SafeParcelable.Field(id = 5)
    public Bundle zzb;

    @KeepForSdkWithMembers
    @ShowFirstParty
    public static class Builder {
        private final String zza;
        private int zzb = ProxyRequest.HTTP_METHOD_GET;
        private long zzc = 3000;
        private byte[] zzd = new byte[0];
        private final Bundle zze = new Bundle();

        public Builder(String str) {
            Preconditions.checkNotEmpty(str);
            if (Patterns.WEB_URL.matcher(str).matches()) {
                this.zza = str;
                return;
            }
            throw new IllegalArgumentException("The supplied url [ " + str + "] is not match Patterns.WEB_URL!");
        }

        public ProxyRequest build() {
            if (this.zzd == null) {
                this.zzd = new byte[0];
            }
            return new ProxyRequest(2, this.zza, this.zzb, this.zzc, this.zzd, this.zze);
        }

        public Builder putHeader(String str, String str2) {
            Preconditions.checkNotEmpty(str, "Header name cannot be null or empty!");
            Bundle bundle = this.zze;
            if (str2 == null) {
                str2 = "";
            }
            bundle.putString(str, str2);
            return this;
        }

        public Builder setBody(byte[] bArr) {
            this.zzd = bArr;
            return this;
        }

        public Builder setHttpMethod(int i11) {
            boolean z11 = false;
            if (i11 >= 0 && i11 <= ProxyRequest.LAST_CODE) {
                z11 = true;
            }
            Preconditions.checkArgument(z11, "Unrecognized http method code.");
            this.zzb = i11;
            return this;
        }

        public Builder setTimeoutMillis(long j11) {
            Preconditions.checkArgument(j11 >= 0, "The specified timeout must be non-negative.");
            this.zzc = j11;
            return this;
        }
    }

    @SafeParcelable.Constructor
    public ProxyRequest(@SafeParcelable.Param(id = 1000) int i11, @SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) int i12, @SafeParcelable.Param(id = 3) long j11, @SafeParcelable.Param(id = 4) byte[] bArr, @SafeParcelable.Param(id = 5) Bundle bundle) {
        this.zza = i11;
        this.url = str;
        this.httpMethod = i12;
        this.timeoutMillis = j11;
        this.body = bArr;
        this.zzb = bundle;
    }

    public Map<String, String> getHeaderMap() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.zzb.size());
        for (String str : this.zzb.keySet()) {
            String string = this.zzb.getString(str);
            if (string == null) {
                string = "";
            }
            linkedHashMap.put(str, string);
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public String toString() {
        String str = this.url;
        int i11 = this.httpMethod;
        return "ProxyRequest[ url: " + str + ", method: " + i11 + " ]";
    }

    public void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.url, false);
        SafeParcelWriter.writeInt(parcel, 2, this.httpMethod);
        SafeParcelWriter.writeLong(parcel, 3, this.timeoutMillis);
        SafeParcelWriter.writeByteArray(parcel, 4, this.body, false);
        SafeParcelWriter.writeBundle(parcel, 5, this.zzb, false);
        SafeParcelWriter.writeInt(parcel, 1000, this.zza);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
