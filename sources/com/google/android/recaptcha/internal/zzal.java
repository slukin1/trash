package com.google.android.recaptcha.internal;

import android.app.Application;
import android.os.Build;
import d10.p;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.k;
import kotlinx.coroutines.h0;

final class zzal extends SuspendLambda implements p {
    public final /* synthetic */ Application zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzbd zzc;
    public final /* synthetic */ zzbq zzd;
    public final /* synthetic */ zzab zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzal(Application application, String str, zzbd zzbd, zzbq zzbq, zzab zzab, c cVar) {
        super(2, cVar);
        this.zza = application;
        this.zzb = str;
        this.zzc = zzbd;
        this.zzd = zzbq;
        this.zze = zzab;
    }

    public final c create(Object obj, c cVar) {
        return new zzal(this.zza, this.zzb, this.zzc, this.zzd, this.zze, cVar);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzal) create((h0) obj, (c) obj2)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.d();
        k.b(obj);
        zzaf zzaf = zzaf.zza;
        zzbd zzbd = this.zzc;
        Application application = this.zza;
        String zza2 = zzaf.zza(application);
        String packageName = application.getPackageName();
        String zzd2 = zzbd.zzd();
        zzq zzq = new zzq(application);
        int i11 = Build.VERSION.SDK_INT;
        String zza3 = zzq.zza("_GRECAPTCHA_KC");
        if (zza3 == null) {
            zza3 = "";
        }
        String encode = URLEncoder.encode(this.zzb, "UTF-8");
        String encode2 = URLEncoder.encode(packageName, "UTF-8");
        String encode3 = URLEncoder.encode(zza2, "UTF-8");
        String encode4 = URLEncoder.encode("18.4.0", "UTF-8");
        String encode5 = URLEncoder.encode(zzd2, "UTF-8");
        byte[] bytes = ("k=" + encode + "&pk=" + encode2 + "&mst=" + encode3 + "&msv=" + encode4 + "&msi=" + encode5 + "&mov=" + i11 + "&mkc=" + zza3).getBytes(Charset.forName("UTF-8"));
        zzbq zzbq = this.zzd;
        zzab zzab = this.zze;
        return zzbq.zza(zzab.zzb(), bytes, this.zzc);
    }
}
