package com.google.android.recaptcha.internal;

import android.content.Context;
import com.sumsub.sns.internal.core.data.source.dynamic.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;

public final class zzbm implements zzbh {
    public static final zzbi zza = new zzbi((r) null);
    /* access modifiers changed from: private */
    public static Timer zzb;
    private final zzbn zzc;
    /* access modifiers changed from: private */
    public final h0 zzd;
    /* access modifiers changed from: private */
    public final zzaz zze;

    public zzbm(Context context, zzbn zzbn, h0 h0Var) {
        this.zzc = zzbn;
        this.zzd = h0Var;
        zzax zzax = zzaz.zza;
        zzaz zzaz = null;
        try {
            zzaz zzc2 = zzaz.zzc;
            zzc2 = zzc2 == null ? new zzaz(context, (r) null) : zzc2;
            zzaz.zzc = zzc2;
            zzaz = zzc2;
        } catch (Exception unused) {
        }
        this.zze = zzaz;
        zzh();
    }

    /* access modifiers changed from: private */
    public final void zzg() {
        zzaz zzaz;
        zzaz zzaz2 = this.zze;
        if (zzaz2 != null) {
            for (List<zzba> it2 : CollectionsKt___CollectionsKt.O0(zzaz2.zzd(), 20, 20, true)) {
                zznh zzi = zzni.zzi();
                ArrayList arrayList = new ArrayList();
                for (zzba zzba : it2) {
                    try {
                        zzpd zzk = zzpd.zzk(zzfy.zzg().zzj(zzba.zzc()));
                        int zzJ = zzk.zzJ();
                        int i11 = zzJ - 1;
                        if (zzJ != 0) {
                            if (i11 == 0) {
                                zzi.zzp(zzk.zzf());
                            } else if (i11 == 1) {
                                zzi.zzq(zzk.zzg());
                            }
                            arrayList.add(zzba);
                        } else {
                            throw null;
                        }
                    } catch (Exception unused) {
                        zzaz zzaz3 = this.zze;
                        if (zzaz3 != null) {
                            zzaz3.zzf(zzba);
                        }
                    }
                }
                if (zzi.zzd() + zzi.zze() != 0) {
                    if (this.zzc.zza(((zzni) zzi.zzj()).zzd()) && (zzaz = this.zze) != null) {
                        zzaz.zza(arrayList);
                    }
                }
            }
        }
    }

    private final void zzh() {
        if (zzb == null) {
            Timer timer = new Timer();
            zzb = timer;
            timer.schedule(new zzbj(this), c.f33305t, c.f33305t);
        }
    }

    public final void zza(zzpd zzpd) {
        n1 unused = i.d(this.zzd, (CoroutineContext) null, (CoroutineStart) null, new zzbl(this, zzpd, (kotlin.coroutines.c) null), 3, (Object) null);
        zzh();
    }
}
