package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.sumsub.sentry.a;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class zziz extends zzf {
    public zzir zza;
    private volatile zzir zzb;
    private volatile zzir zzc;
    private final Map zzd = new ConcurrentHashMap();
    private Activity zze;
    private volatile boolean zzf;
    private volatile zzir zzg;
    /* access modifiers changed from: private */
    public zzir zzh;
    private boolean zzi;
    private final Object zzj = new Object();

    public zziz(zzgd zzgd) {
        super(zzgd);
    }

    /* access modifiers changed from: private */
    public final void zzA(zzir zzir, zzir zzir2, long j11, boolean z11, Bundle bundle) {
        Bundle bundle2;
        long j12;
        long j13;
        zzir zzir3 = zzir;
        zzir zzir4 = zzir2;
        long j14 = j11;
        Bundle bundle3 = bundle;
        zzg();
        boolean z12 = false;
        boolean z13 = zzir4 == null || zzir4.zzc != zzir3.zzc || !zzis.zza(zzir4.zzb, zzir3.zzb) || !zzis.zza(zzir4.zza, zzir3.zza);
        if (z11 && this.zza != null) {
            z12 = true;
        }
        if (z13) {
            if (bundle3 != null) {
                bundle2 = new Bundle(bundle3);
            } else {
                bundle2 = new Bundle();
            }
            Bundle bundle4 = bundle2;
            zzlp.zzK(zzir3, bundle4, true);
            if (zzir4 != null) {
                String str = zzir4.zza;
                if (str != null) {
                    bundle4.putString("_pn", str);
                }
                String str2 = zzir4.zzb;
                if (str2 != null) {
                    bundle4.putString("_pc", str2);
                }
                bundle4.putLong("_pi", zzir4.zzc);
            }
            if (z12) {
                zzkn zzkn = this.zzt.zzu().zzb;
                long j15 = j14 - zzkn.zzb;
                zzkn.zzb = j14;
                if (j15 > 0) {
                    this.zzt.zzv().zzI(bundle4, j15);
                }
            }
            if (!this.zzt.zzf().zzu()) {
                bundle4.putLong("_mst", 1);
            }
            String str3 = true != zzir3.zze ? TtmlNode.TEXT_EMPHASIS_AUTO : a.f30241h;
            long currentTimeMillis = this.zzt.zzax().currentTimeMillis();
            if (zzir3.zze) {
                j13 = currentTimeMillis;
                long j16 = zzir3.zzf;
                if (j16 != 0) {
                    j12 = j16;
                    this.zzt.zzq().zzH(str3, "_vs", j12, bundle4);
                }
            } else {
                j13 = currentTimeMillis;
            }
            j12 = j13;
            this.zzt.zzq().zzH(str3, "_vs", j12, bundle4);
        }
        if (z12) {
            zzB(this.zza, true, j14);
        }
        this.zza = zzir3;
        if (zzir3.zze) {
            this.zzh = zzir3;
        }
        this.zzt.zzt().zzG(zzir3);
    }

    /* access modifiers changed from: private */
    public final void zzB(zzir zzir, boolean z11, long j11) {
        this.zzt.zzd().zzf(this.zzt.zzax().elapsedRealtime());
        if (this.zzt.zzu().zzb.zzd(zzir != null && zzir.zzd, z11, j11) && zzir != null) {
            zzir.zzd = false;
        }
    }

    public static /* bridge */ /* synthetic */ void zzp(zziz zziz, Bundle bundle, zzir zzir, zzir zzir2, long j11) {
        bundle.remove("screen_name");
        bundle.remove(FirebaseAnalytics.Param.SCREEN_CLASS);
        zziz.zzA(zzir, zzir2, j11, true, zziz.zzt.zzv().zzu((String) null, FirebaseAnalytics.Event.SCREEN_VIEW, bundle, (List) null, false));
    }

    private final zzir zzy(Activity activity) {
        Preconditions.checkNotNull(activity);
        zzir zzir = (zzir) this.zzd.get(activity);
        if (zzir == null) {
            zzir zzir2 = new zzir((String) null, zzl(activity.getClass(), "Activity"), this.zzt.zzv().zzq());
            this.zzd.put(activity, zzir2);
            zzir = zzir2;
        }
        return this.zzg != null ? this.zzg : zzir;
    }

    private final void zzz(Activity activity, zzir zzir, boolean z11) {
        zzir zzir2;
        zzir zzir3;
        zzir zzir4 = zzir;
        if (this.zzb == null) {
            zzir2 = this.zzc;
        } else {
            zzir2 = this.zzb;
        }
        zzir zzir5 = zzir2;
        if (zzir4.zzb == null) {
            zzir3 = new zzir(zzir4.zza, activity != null ? zzl(activity.getClass(), "Activity") : null, zzir4.zzc, zzir4.zze, zzir4.zzf);
        } else {
            zzir3 = zzir4;
        }
        this.zzc = this.zzb;
        this.zzb = zzir3;
        this.zzt.zzaB().zzp(new zziu(this, zzir3, zzir5, this.zzt.zzax().elapsedRealtime(), z11));
    }

    public final boolean zzf() {
        return false;
    }

    public final zzir zzi() {
        return this.zzb;
    }

    public final zzir zzj(boolean z11) {
        zza();
        zzg();
        if (!z11) {
            return this.zza;
        }
        zzir zzir = this.zza;
        return zzir != null ? zzir : this.zzh;
    }

    public final String zzl(Class cls, String str) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            return "Activity";
        }
        String[] split = canonicalName.split("\\.");
        int length = split.length;
        String str2 = length > 0 ? split[length - 1] : "";
        int length2 = str2.length();
        this.zzt.zzf();
        if (length2 <= 100) {
            return str2;
        }
        this.zzt.zzf();
        return str2.substring(0, 100);
    }

    public final void zzr(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (this.zzt.zzf().zzu() && bundle != null && (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) != null) {
            this.zzd.put(activity, new zzir(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong("id")));
        }
    }

    public final void zzs(Activity activity) {
        synchronized (this.zzj) {
            if (activity == this.zze) {
                this.zze = null;
            }
        }
        if (this.zzt.zzf().zzu()) {
            this.zzd.remove(activity);
        }
    }

    public final void zzt(Activity activity) {
        synchronized (this.zzj) {
            this.zzi = false;
            this.zzf = true;
        }
        long elapsedRealtime = this.zzt.zzax().elapsedRealtime();
        if (!this.zzt.zzf().zzu()) {
            this.zzb = null;
            this.zzt.zzaB().zzp(new zziw(this, elapsedRealtime));
            return;
        }
        zzir zzy = zzy(activity);
        this.zzc = this.zzb;
        this.zzb = null;
        this.zzt.zzaB().zzp(new zzix(this, zzy, elapsedRealtime));
    }

    public final void zzu(Activity activity) {
        synchronized (this.zzj) {
            this.zzi = true;
            if (activity != this.zze) {
                synchronized (this.zzj) {
                    this.zze = activity;
                    this.zzf = false;
                }
                if (this.zzt.zzf().zzu()) {
                    this.zzg = null;
                    this.zzt.zzaB().zzp(new zziy(this));
                }
            }
        }
        if (!this.zzt.zzf().zzu()) {
            this.zzb = this.zzg;
            this.zzt.zzaB().zzp(new zziv(this));
            return;
        }
        zzz(activity, zzy(activity), false);
        zzd zzd2 = this.zzt.zzd();
        zzd2.zzt.zzaB().zzp(new zzc(zzd2, zzd2.zzt.zzax().elapsedRealtime()));
    }

    public final void zzv(Activity activity, Bundle bundle) {
        zzir zzir;
        if (this.zzt.zzf().zzu() && bundle != null && (zzir = (zzir) this.zzd.get(activity)) != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putLong("id", zzir.zzc);
            bundle2.putString("name", zzir.zza);
            bundle2.putString("referrer_name", zzir.zzb);
            bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0088, code lost:
        if (r1 <= 100) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00b4, code lost:
        if (r1 <= 100) goto L_0x00cf;
     */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzw(android.app.Activity r4, java.lang.String r5, java.lang.String r6) {
        /*
            r3 = this;
            com.google.android.gms.measurement.internal.zzgd r0 = r3.zzt
            com.google.android.gms.measurement.internal.zzag r0 = r0.zzf()
            boolean r0 = r0.zzu()
            if (r0 != 0) goto L_0x001c
            com.google.android.gms.measurement.internal.zzgd r4 = r3.zzt
            com.google.android.gms.measurement.internal.zzet r4 = r4.zzaA()
            com.google.android.gms.measurement.internal.zzer r4 = r4.zzl()
            java.lang.String r5 = "setCurrentScreen cannot be called while screen reporting is disabled."
            r4.zza(r5)
            return
        L_0x001c:
            com.google.android.gms.measurement.internal.zzir r0 = r3.zzb
            if (r0 != 0) goto L_0x0030
            com.google.android.gms.measurement.internal.zzgd r4 = r3.zzt
            com.google.android.gms.measurement.internal.zzet r4 = r4.zzaA()
            com.google.android.gms.measurement.internal.zzer r4 = r4.zzl()
            java.lang.String r5 = "setCurrentScreen cannot be called while no activity active"
            r4.zza(r5)
            return
        L_0x0030:
            java.util.Map r1 = r3.zzd
            java.lang.Object r1 = r1.get(r4)
            if (r1 != 0) goto L_0x0048
            com.google.android.gms.measurement.internal.zzgd r4 = r3.zzt
            com.google.android.gms.measurement.internal.zzet r4 = r4.zzaA()
            com.google.android.gms.measurement.internal.zzer r4 = r4.zzl()
            java.lang.String r5 = "setCurrentScreen must be called with an activity in the activity lifecycle"
            r4.zza(r5)
            return
        L_0x0048:
            if (r6 != 0) goto L_0x0054
            java.lang.Class r6 = r4.getClass()
            java.lang.String r1 = "Activity"
            java.lang.String r6 = r3.zzl(r6, r1)
        L_0x0054:
            java.lang.String r1 = r0.zzb
            boolean r1 = com.google.android.gms.measurement.internal.zzis.zza(r1, r6)
            java.lang.String r0 = r0.zza
            boolean r0 = com.google.android.gms.measurement.internal.zzis.zza(r0, r5)
            if (r1 == 0) goto L_0x0075
            if (r0 != 0) goto L_0x0065
            goto L_0x0075
        L_0x0065:
            com.google.android.gms.measurement.internal.zzgd r4 = r3.zzt
            com.google.android.gms.measurement.internal.zzet r4 = r4.zzaA()
            com.google.android.gms.measurement.internal.zzer r4 = r4.zzl()
            java.lang.String r5 = "setCurrentScreen cannot be called with the same class and name"
            r4.zza(r5)
            return
        L_0x0075:
            r0 = 100
            if (r5 == 0) goto L_0x00a3
            int r1 = r5.length()
            if (r1 <= 0) goto L_0x008b
            int r1 = r5.length()
            com.google.android.gms.measurement.internal.zzgd r2 = r3.zzt
            r2.zzf()
            if (r1 > r0) goto L_0x008b
            goto L_0x00a3
        L_0x008b:
            com.google.android.gms.measurement.internal.zzgd r4 = r3.zzt
            com.google.android.gms.measurement.internal.zzet r4 = r4.zzaA()
            com.google.android.gms.measurement.internal.zzer r4 = r4.zzl()
            int r5 = r5.length()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r6 = "Invalid screen name length in setCurrentScreen. Length"
            r4.zzb(r6, r5)
            return
        L_0x00a3:
            if (r6 == 0) goto L_0x00cf
            int r1 = r6.length()
            if (r1 <= 0) goto L_0x00b7
            int r1 = r6.length()
            com.google.android.gms.measurement.internal.zzgd r2 = r3.zzt
            r2.zzf()
            if (r1 > r0) goto L_0x00b7
            goto L_0x00cf
        L_0x00b7:
            com.google.android.gms.measurement.internal.zzgd r4 = r3.zzt
            com.google.android.gms.measurement.internal.zzet r4 = r4.zzaA()
            com.google.android.gms.measurement.internal.zzer r4 = r4.zzl()
            int r5 = r6.length()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r6 = "Invalid class name length in setCurrentScreen. Length"
            r4.zzb(r6, r5)
            return
        L_0x00cf:
            com.google.android.gms.measurement.internal.zzgd r0 = r3.zzt
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzj()
            if (r5 != 0) goto L_0x00de
            java.lang.String r1 = "null"
            goto L_0x00df
        L_0x00de:
            r1 = r5
        L_0x00df:
            java.lang.String r2 = "Setting current screen to name, class"
            r0.zzc(r2, r1, r6)
            com.google.android.gms.measurement.internal.zzir r0 = new com.google.android.gms.measurement.internal.zzir
            com.google.android.gms.measurement.internal.zzgd r1 = r3.zzt
            com.google.android.gms.measurement.internal.zzlp r1 = r1.zzv()
            long r1 = r1.zzq()
            r0.<init>(r5, r6, r1)
            java.util.Map r5 = r3.zzd
            r5.put(r4, r0)
            r5 = 1
            r3.zzz(r4, r0, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zziz.zzw(android.app.Activity, java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
        if (r2 > 100) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0063, code lost:
        if (r4 > 100) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00c1, code lost:
        r0 = r12.zzt.zzaA().zzj();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00cb, code lost:
        if (r3 != null) goto L_0x00d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00cd, code lost:
        r1 = com.iproov.sdk.bridge.OptionsBridge.NULL_VALUE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00d0, code lost:
        r1 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d1, code lost:
        if (r4 != null) goto L_0x00d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d3, code lost:
        r2 = com.iproov.sdk.bridge.OptionsBridge.NULL_VALUE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d6, code lost:
        r2 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00d7, code lost:
        r0.zzc("Logging screen view with name, class", r1, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00de, code lost:
        if (r12.zzb != null) goto L_0x00e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e0, code lost:
        r0 = r12.zzc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e3, code lost:
        r0 = r12.zzb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00e5, code lost:
        r2 = new com.google.android.gms.measurement.internal.zzir(r3, r4, r12.zzt.zzv().zzq(), true, r14);
        r12.zzb = r2;
        r12.zzc = r0;
        r12.zzg = r2;
        r12.zzt.zzaB().zzp(new com.google.android.gms.measurement.internal.zzit(r12, r13, r2, r0, r12.zzt.zzax().elapsedRealtime()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x011a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzx(android.os.Bundle r13, long r14) {
        /*
            r12 = this;
            java.lang.Object r0 = r12.zzj
            monitor-enter(r0)
            boolean r1 = r12.zzi     // Catch:{ all -> 0x011b }
            if (r1 != 0) goto L_0x0018
            com.google.android.gms.measurement.internal.zzgd r13 = r12.zzt     // Catch:{ all -> 0x011b }
            com.google.android.gms.measurement.internal.zzet r13 = r13.zzaA()     // Catch:{ all -> 0x011b }
            com.google.android.gms.measurement.internal.zzer r13 = r13.zzl()     // Catch:{ all -> 0x011b }
            java.lang.String r14 = "Cannot log screen view event when the app is in the background."
            r13.zza(r14)     // Catch:{ all -> 0x011b }
            monitor-exit(r0)     // Catch:{ all -> 0x011b }
            return
        L_0x0018:
            java.lang.String r1 = "screen_name"
            java.lang.String r3 = r13.getString(r1)     // Catch:{ all -> 0x011b }
            r1 = 100
            if (r3 == 0) goto L_0x004c
            int r2 = r3.length()     // Catch:{ all -> 0x011b }
            if (r2 <= 0) goto L_0x0033
            int r2 = r3.length()     // Catch:{ all -> 0x011b }
            com.google.android.gms.measurement.internal.zzgd r4 = r12.zzt     // Catch:{ all -> 0x011b }
            r4.zzf()     // Catch:{ all -> 0x011b }
            if (r2 <= r1) goto L_0x004c
        L_0x0033:
            com.google.android.gms.measurement.internal.zzgd r13 = r12.zzt     // Catch:{ all -> 0x011b }
            com.google.android.gms.measurement.internal.zzet r13 = r13.zzaA()     // Catch:{ all -> 0x011b }
            com.google.android.gms.measurement.internal.zzer r13 = r13.zzl()     // Catch:{ all -> 0x011b }
            java.lang.String r14 = "Invalid screen name length for screen view. Length"
            int r15 = r3.length()     // Catch:{ all -> 0x011b }
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)     // Catch:{ all -> 0x011b }
            r13.zzb(r14, r15)     // Catch:{ all -> 0x011b }
            monitor-exit(r0)     // Catch:{ all -> 0x011b }
            return
        L_0x004c:
            java.lang.String r2 = "screen_class"
            java.lang.String r2 = r13.getString(r2)     // Catch:{ all -> 0x011b }
            if (r2 == 0) goto L_0x007e
            int r4 = r2.length()     // Catch:{ all -> 0x011b }
            if (r4 <= 0) goto L_0x0065
            int r4 = r2.length()     // Catch:{ all -> 0x011b }
            com.google.android.gms.measurement.internal.zzgd r5 = r12.zzt     // Catch:{ all -> 0x011b }
            r5.zzf()     // Catch:{ all -> 0x011b }
            if (r4 <= r1) goto L_0x007e
        L_0x0065:
            com.google.android.gms.measurement.internal.zzgd r13 = r12.zzt     // Catch:{ all -> 0x011b }
            com.google.android.gms.measurement.internal.zzet r13 = r13.zzaA()     // Catch:{ all -> 0x011b }
            com.google.android.gms.measurement.internal.zzer r13 = r13.zzl()     // Catch:{ all -> 0x011b }
            java.lang.String r14 = "Invalid screen class length for screen view. Length"
            int r15 = r2.length()     // Catch:{ all -> 0x011b }
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)     // Catch:{ all -> 0x011b }
            r13.zzb(r14, r15)     // Catch:{ all -> 0x011b }
            monitor-exit(r0)     // Catch:{ all -> 0x011b }
            return
        L_0x007e:
            if (r2 != 0) goto L_0x0093
            android.app.Activity r1 = r12.zze     // Catch:{ all -> 0x011b }
            if (r1 == 0) goto L_0x008f
            java.lang.Class r1 = r1.getClass()     // Catch:{ all -> 0x011b }
            java.lang.String r2 = "Activity"
            java.lang.String r1 = r12.zzl(r1, r2)     // Catch:{ all -> 0x011b }
            goto L_0x0091
        L_0x008f:
            java.lang.String r1 = "Activity"
        L_0x0091:
            r4 = r1
            goto L_0x0094
        L_0x0093:
            r4 = r2
        L_0x0094:
            com.google.android.gms.measurement.internal.zzir r1 = r12.zzb     // Catch:{ all -> 0x011b }
            boolean r2 = r12.zzf     // Catch:{ all -> 0x011b }
            if (r2 == 0) goto L_0x00c0
            if (r1 == 0) goto L_0x00c0
            r2 = 0
            r12.zzf = r2     // Catch:{ all -> 0x011b }
            java.lang.String r2 = r1.zzb     // Catch:{ all -> 0x011b }
            boolean r2 = com.google.android.gms.measurement.internal.zzis.zza(r2, r4)     // Catch:{ all -> 0x011b }
            java.lang.String r1 = r1.zza     // Catch:{ all -> 0x011b }
            boolean r1 = com.google.android.gms.measurement.internal.zzis.zza(r1, r3)     // Catch:{ all -> 0x011b }
            if (r2 == 0) goto L_0x00c0
            if (r1 == 0) goto L_0x00c0
            com.google.android.gms.measurement.internal.zzgd r13 = r12.zzt     // Catch:{ all -> 0x011b }
            com.google.android.gms.measurement.internal.zzet r13 = r13.zzaA()     // Catch:{ all -> 0x011b }
            com.google.android.gms.measurement.internal.zzer r13 = r13.zzl()     // Catch:{ all -> 0x011b }
            java.lang.String r14 = "Ignoring call to log screen view event with duplicate parameters."
            r13.zza(r14)     // Catch:{ all -> 0x011b }
            monitor-exit(r0)     // Catch:{ all -> 0x011b }
            return
        L_0x00c0:
            monitor-exit(r0)     // Catch:{ all -> 0x011b }
            com.google.android.gms.measurement.internal.zzgd r0 = r12.zzt
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzj()
            if (r3 != 0) goto L_0x00d0
            java.lang.String r1 = "null"
            goto L_0x00d1
        L_0x00d0:
            r1 = r3
        L_0x00d1:
            if (r4 != 0) goto L_0x00d6
            java.lang.String r2 = "null"
            goto L_0x00d7
        L_0x00d6:
            r2 = r4
        L_0x00d7:
            java.lang.String r5 = "Logging screen view with name, class"
            r0.zzc(r5, r1, r2)
            com.google.android.gms.measurement.internal.zzir r0 = r12.zzb
            if (r0 != 0) goto L_0x00e3
            com.google.android.gms.measurement.internal.zzir r0 = r12.zzc
            goto L_0x00e5
        L_0x00e3:
            com.google.android.gms.measurement.internal.zzir r0 = r12.zzb
        L_0x00e5:
            com.google.android.gms.measurement.internal.zzir r1 = new com.google.android.gms.measurement.internal.zzir
            com.google.android.gms.measurement.internal.zzgd r2 = r12.zzt
            com.google.android.gms.measurement.internal.zzlp r2 = r2.zzv()
            long r5 = r2.zzq()
            r7 = 1
            r2 = r1
            r8 = r14
            r2.<init>(r3, r4, r5, r7, r8)
            r12.zzb = r1
            r12.zzc = r0
            r12.zzg = r1
            com.google.android.gms.measurement.internal.zzgd r14 = r12.zzt
            com.google.android.gms.common.util.Clock r14 = r14.zzax()
            long r10 = r14.elapsedRealtime()
            com.google.android.gms.measurement.internal.zzgd r14 = r12.zzt
            com.google.android.gms.measurement.internal.zzga r14 = r14.zzaB()
            com.google.android.gms.measurement.internal.zzit r15 = new com.google.android.gms.measurement.internal.zzit
            r5 = r15
            r6 = r12
            r7 = r13
            r8 = r1
            r9 = r0
            r5.<init>(r6, r7, r8, r9, r10)
            r14.zzp(r15)
            return
        L_0x011b:
            r13 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x011b }
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zziz.zzx(android.os.Bundle, long):void");
    }
}
