package com.google.android.recaptcha.internal;

import android.content.ContentValues;
import com.twitter.sdk.android.core.identity.AuthHandler;
import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.k;
import kotlinx.coroutines.h0;

final class zzbl extends SuspendLambda implements p {
    public final /* synthetic */ zzbm zza;
    public final /* synthetic */ zzpd zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbl(zzbm zzbm, zzpd zzpd, c cVar) {
        super(2, cVar);
        this.zza = zzbm;
        this.zzb = zzpd;
    }

    public final c create(Object obj, c cVar) {
        return new zzbl(this.zza, this.zzb, cVar);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzbl) create((h0) obj, (c) obj2)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Unit unit;
        Object unused = IntrinsicsKt__IntrinsicsKt.d();
        k.b(obj);
        zzbm zzbm = this.zza;
        zzpd zzpd = this.zzb;
        synchronized (zzbh.class) {
            if (zzbm.zze != null) {
                byte[] zzd = zzpd.zzd();
                zzba zzba = new zzba(zzfy.zzg().zzi(zzd, 0, zzd.length), System.currentTimeMillis(), 0);
                zzaz zzb2 = zzbm.zze;
                ContentValues contentValues = new ContentValues();
                contentValues.put("ss", zzba.zzc());
                contentValues.put(AuthHandler.EXTRA_TOKEN_SECRET, Long.valueOf(zzba.zzb()));
                zzb2.getWritableDatabase().insert("ce", (String) null, contentValues);
                int zzb3 = zzbm.zze.zzb() - 500;
                if (zzb3 > 0) {
                    zzbm.zze.zza(CollectionsKt___CollectionsKt.B0(zzbm.zze.zzd(), zzb3));
                }
                if (zzbm.zze.zzb() >= 20) {
                    zzbm.zzg();
                }
            }
            unit = Unit.f56620a;
        }
        return unit;
    }
}
