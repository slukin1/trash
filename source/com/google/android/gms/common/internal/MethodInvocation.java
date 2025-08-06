package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@KeepForSdk
@SafeParcelable.Class(creator = "MethodInvocationCreator")
public class MethodInvocation extends AbstractSafeParcelable {
    public static final Parcelable.Creator<MethodInvocation> CREATOR = new zan();
    @SafeParcelable.Field(getter = "getMethodKey", id = 1)
    private final int zaa;
    @SafeParcelable.Field(getter = "getResultStatusCode", id = 2)
    private final int zab;
    @SafeParcelable.Field(getter = "getConnectionResultStatusCode", id = 3)
    private final int zac;
    @SafeParcelable.Field(getter = "getStartTimeMillis", id = 4)
    private final long zad;
    @SafeParcelable.Field(getter = "getEndTimeMillis", id = 5)
    private final long zae;
    @SafeParcelable.Field(getter = "getCallingModuleId", id = 6)
    private final String zaf;
    @SafeParcelable.Field(getter = "getCallingEntryPoint", id = 7)
    private final String zag;
    @SafeParcelable.Field(defaultValue = "0", getter = "getServiceId", id = 8)
    private final int zah;
    @SafeParcelable.Field(defaultValue = "-1", getter = "getLatencyMillis", id = 9)
    private final int zai;

    @KeepForSdk
    @Deprecated
    public MethodInvocation(int i11, int i12, int i13, long j11, long j12, String str, String str2, int i14) {
        this(i11, i12, i13, j11, j12, str, str2, i14, -1);
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zaa);
        SafeParcelWriter.writeInt(parcel, 2, this.zab);
        SafeParcelWriter.writeInt(parcel, 3, this.zac);
        SafeParcelWriter.writeLong(parcel, 4, this.zad);
        SafeParcelWriter.writeLong(parcel, 5, this.zae);
        SafeParcelWriter.writeString(parcel, 6, this.zaf, false);
        SafeParcelWriter.writeString(parcel, 7, this.zag, false);
        SafeParcelWriter.writeInt(parcel, 8, this.zah);
        SafeParcelWriter.writeInt(parcel, 9, this.zai);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    public MethodInvocation(@SafeParcelable.Param(id = 1) int i11, @SafeParcelable.Param(id = 2) int i12, @SafeParcelable.Param(id = 3) int i13, @SafeParcelable.Param(id = 4) long j11, @SafeParcelable.Param(id = 5) long j12, @SafeParcelable.Param(id = 6) String str, @SafeParcelable.Param(id = 7) String str2, @SafeParcelable.Param(id = 8) int i14, @SafeParcelable.Param(id = 9) int i15) {
        this.zaa = i11;
        this.zab = i12;
        this.zac = i13;
        this.zad = j11;
        this.zae = j12;
        this.zaf = str;
        this.zag = str2;
        this.zah = i14;
        this.zai = i15;
    }
}
