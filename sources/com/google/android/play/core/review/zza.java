package com.google.android.play.core.review;

import android.app.PendingIntent;
import java.util.Objects;

final class zza extends ReviewInfo {
    private final PendingIntent zza;
    private final boolean zzb;

    public zza(PendingIntent pendingIntent, boolean z11) {
        Objects.requireNonNull(pendingIntent, "Null pendingIntent");
        this.zza = pendingIntent;
        this.zzb = z11;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ReviewInfo) {
            ReviewInfo reviewInfo = (ReviewInfo) obj;
            return this.zza.equals(reviewInfo.zza()) && this.zzb == reviewInfo.zzb();
        }
    }

    public final int hashCode() {
        return ((this.zza.hashCode() ^ 1000003) * 1000003) ^ (true != this.zzb ? 1237 : 1231);
    }

    public final String toString() {
        String obj = this.zza.toString();
        boolean z11 = this.zzb;
        return "ReviewInfo{pendingIntent=" + obj + ", isNoOp=" + z11 + "}";
    }

    public final PendingIntent zza() {
        return this.zza;
    }

    public final boolean zzb() {
        return this.zzb;
    }
}
