package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Pair;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.measurement.zzcf;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public final class zzjz extends zzf {
    /* access modifiers changed from: private */
    public final zzjy zza;
    /* access modifiers changed from: private */
    public zzej zzb;
    private volatile Boolean zzc;
    private final zzan zzd;
    private final zzkq zze;
    private final List zzf = new ArrayList();
    private final zzan zzg;

    public zzjz(zzgd zzgd) {
        super(zzgd);
        this.zze = new zzkq(zzgd.zzax());
        this.zza = new zzjy(this);
        this.zzd = new zzjj(this, zzgd);
        this.zzg = new zzjl(this, zzgd);
    }

    private final zzq zzO(boolean z11) {
        Pair zza2;
        this.zzt.zzay();
        zzek zzh = this.zzt.zzh();
        String str = null;
        if (z11) {
            zzet zzaA = this.zzt.zzaA();
            if (!(zzaA.zzt.zzm().zzb == null || (zza2 = zzaA.zzt.zzm().zzb.zza()) == null || zza2 == zzfi.zza)) {
                str = String.valueOf(zza2.second) + ":" + ((String) zza2.first);
            }
        }
        return zzh.zzj(str);
    }

    /* access modifiers changed from: private */
    public final void zzP() {
        zzg();
        this.zzt.zzaA().zzj().zzb("Processing queued up service tasks", Integer.valueOf(this.zzf.size()));
        for (Runnable run : this.zzf) {
            try {
                run.run();
            } catch (RuntimeException e11) {
                this.zzt.zzaA().zzd().zzb("Task exception while flushing queue", e11);
            }
        }
        this.zzf.clear();
        this.zzg.zzb();
    }

    /* access modifiers changed from: private */
    public final void zzQ() {
        zzg();
        this.zze.zzb();
        zzan zzan = this.zzd;
        this.zzt.zzf();
        zzan.zzd(((Long) zzeg.zzJ.zza((Object) null)).longValue());
    }

    private final void zzR(Runnable runnable) throws IllegalStateException {
        zzg();
        if (zzL()) {
            runnable.run();
            return;
        }
        this.zzt.zzf();
        if (((long) this.zzf.size()) >= 1000) {
            this.zzt.zzaA().zzd().zza("Discarding data. Max runnable queue size reached");
            return;
        }
        this.zzf.add(runnable);
        this.zzg.zzd(60000);
        zzr();
    }

    private final boolean zzS() {
        this.zzt.zzay();
        return true;
    }

    public static /* bridge */ /* synthetic */ void zzo(zzjz zzjz, ComponentName componentName) {
        zzjz.zzg();
        if (zzjz.zzb != null) {
            zzjz.zzb = null;
            zzjz.zzt.zzaA().zzj().zzb("Disconnected from device MeasurementService", componentName);
            zzjz.zzg();
            zzjz.zzr();
        }
    }

    public final void zzA(zzau zzau, String str) {
        Preconditions.checkNotNull(zzau);
        zzg();
        zza();
        zzS();
        zzR(new zzjo(this, true, zzO(true), this.zzt.zzi().zzo(zzau), zzau, str));
    }

    public final void zzB(zzcf zzcf, zzau zzau, String str) {
        zzg();
        zza();
        if (this.zzt.zzv().zzo(GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE) != 0) {
            this.zzt.zzaA().zzk().zza("Not bundling data. Service unavailable or out of date");
            this.zzt.zzv().zzT(zzcf, new byte[0]);
            return;
        }
        zzR(new zzjk(this, zzau, str, zzcf));
    }

    public final void zzC() {
        zzg();
        zza();
        zzq zzO = zzO(false);
        zzS();
        this.zzt.zzi().zzj();
        zzR(new zzjd(this, zzO));
    }

    public final void zzD(zzej zzej, AbstractSafeParcelable abstractSafeParcelable, zzq zzq) {
        int i11;
        zzg();
        zza();
        zzS();
        this.zzt.zzf();
        int i12 = 0;
        int i13 = 100;
        while (i12 < 1001 && i13 == 100) {
            ArrayList arrayList = new ArrayList();
            List zzi = this.zzt.zzi().zzi(100);
            if (zzi != null) {
                arrayList.addAll(zzi);
                i11 = zzi.size();
            } else {
                i11 = 0;
            }
            if (abstractSafeParcelable != null && i11 < 100) {
                arrayList.add(abstractSafeParcelable);
            }
            int size = arrayList.size();
            for (int i14 = 0; i14 < size; i14++) {
                AbstractSafeParcelable abstractSafeParcelable2 = (AbstractSafeParcelable) arrayList.get(i14);
                if (abstractSafeParcelable2 instanceof zzau) {
                    try {
                        zzej.zzk((zzau) abstractSafeParcelable2, zzq);
                    } catch (RemoteException e11) {
                        this.zzt.zzaA().zzd().zzb("Failed to send event to the service", e11);
                    }
                } else if (abstractSafeParcelable2 instanceof zzlk) {
                    try {
                        zzej.zzt((zzlk) abstractSafeParcelable2, zzq);
                    } catch (RemoteException e12) {
                        this.zzt.zzaA().zzd().zzb("Failed to send user property to the service", e12);
                    }
                } else if (abstractSafeParcelable2 instanceof zzac) {
                    try {
                        zzej.zzn((zzac) abstractSafeParcelable2, zzq);
                    } catch (RemoteException e13) {
                        this.zzt.zzaA().zzd().zzb("Failed to send conditional user property to the service", e13);
                    }
                } else {
                    this.zzt.zzaA().zzd().zza("Discarding data. Unrecognized parcel type.");
                }
            }
            i12++;
            i13 = i11;
        }
    }

    public final void zzE(zzac zzac) {
        Preconditions.checkNotNull(zzac);
        zzg();
        zza();
        this.zzt.zzay();
        zzR(new zzjp(this, true, zzO(true), this.zzt.zzi().zzn(zzac), new zzac(zzac), zzac));
    }

    public final void zzF(boolean z11) {
        zzg();
        zza();
        if (z11) {
            zzS();
            this.zzt.zzi().zzj();
        }
        if (zzM()) {
            zzR(new zzjn(this, zzO(false)));
        }
    }

    public final void zzG(zzir zzir) {
        zzg();
        zza();
        zzR(new zzjh(this, zzir));
    }

    public final void zzH(Bundle bundle) {
        zzg();
        zza();
        zzR(new zzji(this, zzO(false), bundle));
    }

    public final void zzI() {
        zzg();
        zza();
        zzR(new zzjm(this, zzO(true)));
    }

    public final void zzJ(zzej zzej) {
        zzg();
        Preconditions.checkNotNull(zzej);
        this.zzb = zzej;
        zzQ();
        zzP();
    }

    public final void zzK(zzlk zzlk) {
        zzg();
        zza();
        zzS();
        zzR(new zzjc(this, zzO(true), this.zzt.zzi().zzp(zzlk), zzlk));
    }

    public final boolean zzL() {
        zzg();
        zza();
        return this.zzb != null;
    }

    public final boolean zzM() {
        zzg();
        zza();
        if (!zzN() || this.zzt.zzv().zzm() >= ((Integer) zzeg.zzah.zza((Object) null)).intValue()) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x012c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzN() {
        /*
            r7 = this;
            r7.zzg()
            r7.zza()
            java.lang.Boolean r0 = r7.zzc
            if (r0 != 0) goto L_0x014c
            r7.zzg()
            r7.zza()
            com.google.android.gms.measurement.internal.zzgd r0 = r7.zzt
            com.google.android.gms.measurement.internal.zzfi r0 = r0.zzm()
            r0.zzg()
            android.content.SharedPreferences r1 = r0.zza()
            java.lang.String r2 = "use_service"
            boolean r1 = r1.contains(r2)
            r3 = 0
            if (r1 != 0) goto L_0x0029
            r0 = 0
            goto L_0x0035
        L_0x0029:
            android.content.SharedPreferences r0 = r0.zza()
            boolean r0 = r0.getBoolean(r2, r3)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
        L_0x0035:
            r1 = 1
            if (r0 == 0) goto L_0x0040
            boolean r4 = r0.booleanValue()
            if (r4 == 0) goto L_0x0040
            goto L_0x0146
        L_0x0040:
            com.google.android.gms.measurement.internal.zzgd r4 = r7.zzt
            r4.zzay()
            com.google.android.gms.measurement.internal.zzgd r4 = r7.zzt
            com.google.android.gms.measurement.internal.zzek r4 = r4.zzh()
            int r4 = r4.zzh()
            if (r4 != r1) goto L_0x0054
        L_0x0051:
            r3 = r1
            goto L_0x010e
        L_0x0054:
            com.google.android.gms.measurement.internal.zzgd r4 = r7.zzt
            com.google.android.gms.measurement.internal.zzet r4 = r4.zzaA()
            com.google.android.gms.measurement.internal.zzer r4 = r4.zzj()
            java.lang.String r5 = "Checking service availability"
            r4.zza(r5)
            com.google.android.gms.measurement.internal.zzgd r4 = r7.zzt
            com.google.android.gms.measurement.internal.zzlp r4 = r4.zzv()
            r5 = 12451000(0xbdfcb8, float:1.7447567E-38)
            int r4 = r4.zzo(r5)
            if (r4 == 0) goto L_0x00fd
            if (r4 == r1) goto L_0x00ed
            r5 = 2
            if (r4 == r5) goto L_0x00c7
            r0 = 3
            if (r4 == r0) goto L_0x00b6
            r0 = 9
            if (r4 == r0) goto L_0x00a6
            r0 = 18
            if (r4 == r0) goto L_0x0096
            com.google.android.gms.measurement.internal.zzgd r0 = r7.zzt
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzk()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
            java.lang.String r4 = "Unexpected service status"
            r0.zzb(r4, r1)
            goto L_0x00c5
        L_0x0096:
            com.google.android.gms.measurement.internal.zzgd r0 = r7.zzt
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzk()
            java.lang.String r3 = "Service updating"
            r0.zza(r3)
            goto L_0x0051
        L_0x00a6:
            com.google.android.gms.measurement.internal.zzgd r0 = r7.zzt
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzk()
            java.lang.String r1 = "Service invalid"
            r0.zza(r1)
            goto L_0x00c5
        L_0x00b6:
            com.google.android.gms.measurement.internal.zzgd r0 = r7.zzt
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzk()
            java.lang.String r1 = "Service disabled"
            r0.zza(r1)
        L_0x00c5:
            r1 = r3
            goto L_0x010e
        L_0x00c7:
            com.google.android.gms.measurement.internal.zzgd r4 = r7.zzt
            com.google.android.gms.measurement.internal.zzet r4 = r4.zzaA()
            com.google.android.gms.measurement.internal.zzer r4 = r4.zzc()
            java.lang.String r5 = "Service container out of date"
            r4.zza(r5)
            com.google.android.gms.measurement.internal.zzgd r4 = r7.zzt
            com.google.android.gms.measurement.internal.zzlp r4 = r4.zzv()
            int r4 = r4.zzm()
            r5 = 17443(0x4423, float:2.4443E-41)
            if (r4 >= r5) goto L_0x00e5
            goto L_0x010e
        L_0x00e5:
            if (r0 != 0) goto L_0x00e8
            goto L_0x00e9
        L_0x00e8:
            r1 = r3
        L_0x00e9:
            r6 = r3
            r3 = r1
            r1 = r6
            goto L_0x010e
        L_0x00ed:
            com.google.android.gms.measurement.internal.zzgd r0 = r7.zzt
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzj()
            java.lang.String r4 = "Service missing"
            r0.zza(r4)
            goto L_0x010e
        L_0x00fd:
            com.google.android.gms.measurement.internal.zzgd r0 = r7.zzt
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzj()
            java.lang.String r3 = "Service available"
            r0.zza(r3)
            goto L_0x0051
        L_0x010e:
            if (r3 != 0) goto L_0x012c
            com.google.android.gms.measurement.internal.zzgd r0 = r7.zzt
            com.google.android.gms.measurement.internal.zzag r0 = r0.zzf()
            boolean r0 = r0.zzx()
            if (r0 == 0) goto L_0x012c
            com.google.android.gms.measurement.internal.zzgd r0 = r7.zzt
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzd()
            java.lang.String r1 = "No way to upload. Consider using the full version of Analytics"
            r0.zza(r1)
            goto L_0x0145
        L_0x012c:
            if (r1 == 0) goto L_0x0145
            com.google.android.gms.measurement.internal.zzgd r0 = r7.zzt
            com.google.android.gms.measurement.internal.zzfi r0 = r0.zzm()
            r0.zzg()
            android.content.SharedPreferences r0 = r0.zza()
            android.content.SharedPreferences$Editor r0 = r0.edit()
            r0.putBoolean(r2, r3)
            r0.apply()
        L_0x0145:
            r1 = r3
        L_0x0146:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
            r7.zzc = r0
        L_0x014c:
            java.lang.Boolean r0 = r7.zzc
            boolean r0 = r0.booleanValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjz.zzN():boolean");
    }

    public final boolean zzf() {
        return false;
    }

    public final Boolean zzj() {
        return this.zzc;
    }

    public final void zzq() {
        zzg();
        zza();
        zzq zzO = zzO(true);
        this.zzt.zzi().zzk();
        zzR(new zzjg(this, zzO));
    }

    public final void zzr() {
        zzg();
        zza();
        if (!zzL()) {
            if (zzN()) {
                this.zza.zzc();
            } else if (!this.zzt.zzf().zzx()) {
                this.zzt.zzay();
                List<ResolveInfo> queryIntentServices = this.zzt.zzaw().getPackageManager().queryIntentServices(new Intent().setClassName(this.zzt.zzaw(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
                if (queryIntentServices == null || queryIntentServices.isEmpty()) {
                    this.zzt.zzaA().zzd().zza("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
                    return;
                }
                Intent intent = new Intent("com.google.android.gms.measurement.START");
                Context zzaw = this.zzt.zzaw();
                this.zzt.zzay();
                intent.setComponent(new ComponentName(zzaw, "com.google.android.gms.measurement.AppMeasurementService"));
                this.zza.zzb(intent);
            }
        }
    }

    public final void zzs() {
        zzg();
        zza();
        this.zza.zzd();
        try {
            ConnectionTracker.getInstance().unbindService(this.zzt.zzaw(), this.zza);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.zzb = null;
    }

    public final void zzt(zzcf zzcf) {
        zzg();
        zza();
        zzR(new zzjf(this, zzO(false), zzcf));
    }

    public final void zzu(AtomicReference atomicReference) {
        zzg();
        zza();
        zzR(new zzje(this, atomicReference, zzO(false)));
    }

    public final void zzv(zzcf zzcf, String str, String str2) {
        zzg();
        zza();
        zzR(new zzjr(this, str, str2, zzO(false), zzcf));
    }

    public final void zzw(AtomicReference atomicReference, String str, String str2, String str3) {
        zzg();
        zza();
        zzR(new zzjq(this, atomicReference, (String) null, str2, str3, zzO(false)));
    }

    public final void zzx(AtomicReference atomicReference, boolean z11) {
        zzg();
        zza();
        zzR(new zzjb(this, atomicReference, zzO(false), z11));
    }

    public final void zzy(zzcf zzcf, String str, String str2, boolean z11) {
        zzg();
        zza();
        zzR(new zzja(this, str, str2, zzO(false), z11, zzcf));
    }

    public final void zzz(AtomicReference atomicReference, String str, String str2, String str3, boolean z11) {
        zzg();
        zza();
        zzR(new zzjs(this, atomicReference, (String) null, str2, str3, zzO(false), z11));
    }
}
