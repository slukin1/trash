package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;

@SafeParcelable.Class(creator = "StatusCreator")
public final class Status extends AbstractSafeParcelable implements Result, ReflectedParcelable {
    public static final Parcelable.Creator<Status> CREATOR = new zzb();
    @ShowFirstParty
    @KeepForSdk
    public static final Status RESULT_CANCELED = new Status(16);
    @KeepForSdk
    public static final Status RESULT_DEAD_CLIENT = new Status(18);
    @ShowFirstParty
    @KeepForSdk
    public static final Status RESULT_INTERNAL_ERROR = new Status(8);
    @ShowFirstParty
    @KeepForSdk
    public static final Status RESULT_INTERRUPTED = new Status(14);
    @ShowFirstParty
    @KeepForSdk
    public static final Status RESULT_SUCCESS = new Status(0);
    @ShowFirstParty
    @KeepForSdk
    public static final Status RESULT_SUCCESS_CACHE = new Status(-1);
    @ShowFirstParty
    @KeepForSdk
    public static final Status RESULT_TIMEOUT = new Status(15);
    @ShowFirstParty
    public static final Status zza = new Status(17);
    @SafeParcelable.Field(getter = "getStatusCode", id = 1)
    private final int zzb;
    @SafeParcelable.Field(getter = "getStatusMessage", id = 2)
    private final String zzc;
    @SafeParcelable.Field(getter = "getPendingIntent", id = 3)
    private final PendingIntent zzd;
    @SafeParcelable.Field(getter = "getConnectionResult", id = 4)
    private final ConnectionResult zze;

    public Status(int i11) {
        this(i11, (String) null);
    }

    @SafeParcelable.Constructor
    public Status(@SafeParcelable.Param(id = 1) int i11, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) PendingIntent pendingIntent, @SafeParcelable.Param(id = 4) ConnectionResult connectionResult) {
        this.zzb = i11;
        this.zzc = str;
        this.zzd = pendingIntent;
        this.zze = connectionResult;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        if (this.zzb != status.zzb || !Objects.equal(this.zzc, status.zzc) || !Objects.equal(this.zzd, status.zzd) || !Objects.equal(this.zze, status.zze)) {
            return false;
        }
        return true;
    }

    public ConnectionResult getConnectionResult() {
        return this.zze;
    }

    public PendingIntent getResolution() {
        return this.zzd;
    }

    @CanIgnoreReturnValue
    public Status getStatus() {
        return this;
    }

    @ResultIgnorabilityUnspecified
    public int getStatusCode() {
        return this.zzb;
    }

    public String getStatusMessage() {
        return this.zzc;
    }

    public boolean hasResolution() {
        return this.zzd != null;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zzb), this.zzc, this.zzd, this.zze);
    }

    public boolean isCanceled() {
        return this.zzb == 16;
    }

    public boolean isInterrupted() {
        return this.zzb == 14;
    }

    @CheckReturnValue
    public boolean isSuccess() {
        return this.zzb <= 0;
    }

    public void startResolutionForResult(Activity activity, int i11) throws IntentSender.SendIntentException {
        if (hasResolution()) {
            PendingIntent pendingIntent = this.zzd;
            Preconditions.checkNotNull(pendingIntent);
            activity.startIntentSenderForResult(pendingIntent.getIntentSender(), i11, (Intent) null, 0, 0, 0);
        }
    }

    public String toString() {
        Objects.ToStringHelper stringHelper = Objects.toStringHelper(this);
        stringHelper.add(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, zza());
        stringHelper.add(CommonCode.MapKey.HAS_RESOLUTION, this.zzd);
        return stringHelper.toString();
    }

    public void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getStatusCode());
        SafeParcelWriter.writeString(parcel, 2, getStatusMessage(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzd, i11, false);
        SafeParcelWriter.writeParcelable(parcel, 4, getConnectionResult(), i11, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final String zza() {
        String str = this.zzc;
        return str != null ? str : CommonStatusCodes.getStatusCodeString(this.zzb);
    }

    public Status(ConnectionResult connectionResult, String str) {
        this(connectionResult, str, 17);
    }

    public Status(int i11, String str) {
        this(i11, str, (PendingIntent) null);
    }

    public void startResolutionForResult(ActivityResultLauncher<IntentSenderRequest> activityResultLauncher) {
        if (hasResolution()) {
            PendingIntent pendingIntent = this.zzd;
            Preconditions.checkNotNull(pendingIntent);
            activityResultLauncher.a(new IntentSenderRequest.a(pendingIntent.getIntentSender()).a());
        }
    }

    @KeepForSdk
    @Deprecated
    public Status(ConnectionResult connectionResult, String str, int i11) {
        this(i11, str, connectionResult.getResolution(), connectionResult);
    }

    public Status(int i11, String str, PendingIntent pendingIntent) {
        this(i11, str, pendingIntent, (ConnectionResult) null);
    }
}
