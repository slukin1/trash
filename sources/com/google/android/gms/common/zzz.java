package com.google.android.gms.common;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.common.zzag;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.List;

final class zzz {
    private String zza = null;
    private long zzb = -1;
    private zzag zzc = zzag.zzl();
    private zzag zzd = zzag.zzl();

    @CanIgnoreReturnValue
    public final zzz zza(long j11) {
        this.zzb = j11;
        return this;
    }

    @CanIgnoreReturnValue
    public final zzz zzb(List list) {
        Preconditions.checkNotNull(list);
        this.zzd = zzag.zzk(list);
        return this;
    }

    @CanIgnoreReturnValue
    public final zzz zzc(List list) {
        Preconditions.checkNotNull(list);
        this.zzc = zzag.zzk(list);
        return this;
    }

    @CanIgnoreReturnValue
    public final zzz zzd(String str) {
        this.zza = str;
        return this;
    }

    public final zzab zze() {
        if (this.zza == null) {
            throw new IllegalStateException("packageName must be defined");
        } else if (this.zzb < 0) {
            throw new IllegalStateException("minimumStampedVersionNumber must be greater than or equal to 0");
        } else if (!this.zzc.isEmpty() || !this.zzd.isEmpty()) {
            return new zzab(this.zza, this.zzb, this.zzc, this.zzd, (zzaa) null);
        } else {
            throw new IllegalStateException("Either orderedTestCerts or orderedProdCerts must have at least one cert");
        }
    }
}
