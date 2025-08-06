package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.iproov.sdk.bridge.OptionsBridge;
import java.math.BigInteger;
import java.util.List;
import java.util.Locale;

public final class zzek extends zzf {
    private String zza;
    private String zzb;
    private int zzc;
    private String zzd;
    private String zze;
    private long zzf;
    private final long zzg;
    private List zzh;
    private String zzi;
    private int zzj;
    private String zzk;
    private String zzl;
    private String zzm;
    private long zzn = 0;
    private String zzo = null;

    public zzek(zzgd zzgd, long j11) {
        super(zzgd);
        this.zzg = j11;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x018b A[Catch:{ IllegalStateException -> 0x01dc }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x018c A[Catch:{ IllegalStateException -> 0x01dc }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0195 A[Catch:{ IllegalStateException -> 0x01dc }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01bd A[Catch:{ IllegalStateException -> 0x01dc }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0207  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0240  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x024d  */
    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"appId", "appStore", "appName", "gmpAppId", "gaAppId"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd() {
        /*
            r11 = this;
            com.google.android.gms.measurement.internal.zzgd r0 = r11.zzt
            android.content.Context r0 = r0.zzaw()
            java.lang.String r0 = r0.getPackageName()
            com.google.android.gms.measurement.internal.zzgd r1 = r11.zzt
            android.content.Context r1 = r1.zzaw()
            android.content.pm.PackageManager r1 = r1.getPackageManager()
            java.lang.String r2 = "Unknown"
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            java.lang.String r4 = ""
            r5 = 0
            java.lang.String r6 = "unknown"
            if (r1 != 0) goto L_0x0036
            com.google.android.gms.measurement.internal.zzgd r7 = r11.zzt
            com.google.android.gms.measurement.internal.zzet r7 = r7.zzaA()
            com.google.android.gms.measurement.internal.zzer r7 = r7.zzd()
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzet.zzn(r0)
            java.lang.String r9 = "PackageManager is null, app identity information might be inaccurate. appId"
            r7.zzb(r9, r8)
        L_0x0033:
            r8 = r2
            goto L_0x009c
        L_0x0036:
            java.lang.String r6 = r1.getInstallerPackageName(r0)     // Catch:{ IllegalArgumentException -> 0x003b }
            goto L_0x004e
        L_0x003b:
            com.google.android.gms.measurement.internal.zzgd r7 = r11.zzt
            com.google.android.gms.measurement.internal.zzet r7 = r7.zzaA()
            com.google.android.gms.measurement.internal.zzer r7 = r7.zzd()
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzet.zzn(r0)
            java.lang.String r9 = "Error retrieving app installer package name. appId"
            r7.zzb(r9, r8)
        L_0x004e:
            if (r6 != 0) goto L_0x0053
            java.lang.String r6 = "manual_install"
            goto L_0x005c
        L_0x0053:
            java.lang.String r7 = "com.android.vending"
            boolean r7 = r7.equals(r6)
            if (r7 == 0) goto L_0x005c
            r6 = r4
        L_0x005c:
            com.google.android.gms.measurement.internal.zzgd r7 = r11.zzt     // Catch:{ NameNotFoundException -> 0x0086 }
            android.content.Context r7 = r7.zzaw()     // Catch:{ NameNotFoundException -> 0x0086 }
            java.lang.String r7 = r7.getPackageName()     // Catch:{ NameNotFoundException -> 0x0086 }
            android.content.pm.PackageInfo r7 = r1.getPackageInfo(r7, r5)     // Catch:{ NameNotFoundException -> 0x0086 }
            if (r7 == 0) goto L_0x0033
            android.content.pm.ApplicationInfo r8 = r7.applicationInfo     // Catch:{ NameNotFoundException -> 0x0086 }
            java.lang.CharSequence r8 = r1.getApplicationLabel(r8)     // Catch:{ NameNotFoundException -> 0x0086 }
            boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch:{ NameNotFoundException -> 0x0086 }
            if (r9 != 0) goto L_0x007d
            java.lang.String r8 = r8.toString()     // Catch:{ NameNotFoundException -> 0x0086 }
            goto L_0x007e
        L_0x007d:
            r8 = r2
        L_0x007e:
            java.lang.String r2 = r7.versionName     // Catch:{ NameNotFoundException -> 0x0083 }
            int r3 = r7.versionCode     // Catch:{ NameNotFoundException -> 0x0083 }
            goto L_0x009c
        L_0x0083:
            r7 = r2
            r2 = r8
            goto L_0x0087
        L_0x0086:
            r7 = r2
        L_0x0087:
            com.google.android.gms.measurement.internal.zzgd r8 = r11.zzt
            com.google.android.gms.measurement.internal.zzet r8 = r8.zzaA()
            com.google.android.gms.measurement.internal.zzer r8 = r8.zzd()
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzet.zzn(r0)
            java.lang.String r10 = "Error retrieving package info. appId, appName"
            r8.zzc(r10, r9, r2)
            r8 = r2
            r2 = r7
        L_0x009c:
            r11.zza = r0
            r11.zzd = r6
            r11.zzb = r2
            r11.zzc = r3
            r11.zze = r8
            r2 = 0
            r11.zzf = r2
            com.google.android.gms.measurement.internal.zzgd r2 = r11.zzt
            java.lang.String r2 = r2.zzw()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x00c6
            com.google.android.gms.measurement.internal.zzgd r2 = r11.zzt
            java.lang.String r2 = r2.zzx()
            java.lang.String r3 = "am"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x00c6
            r2 = 1
            goto L_0x00c7
        L_0x00c6:
            r2 = r5
        L_0x00c7:
            com.google.android.gms.measurement.internal.zzgd r3 = r11.zzt
            int r3 = r3.zza()
            switch(r3) {
                case 0: goto L_0x0151;
                case 1: goto L_0x0141;
                case 2: goto L_0x0131;
                case 3: goto L_0x0121;
                case 4: goto L_0x0111;
                case 5: goto L_0x0101;
                case 6: goto L_0x00f1;
                case 7: goto L_0x00e1;
                default: goto L_0x00d0;
            }
        L_0x00d0:
            com.google.android.gms.measurement.internal.zzgd r6 = r11.zzt
            com.google.android.gms.measurement.internal.zzet r6 = r6.zzaA()
            com.google.android.gms.measurement.internal.zzer r6 = r6.zzi()
            java.lang.String r7 = "App measurement disabled due to denied storage consent"
            r6.zza(r7)
            goto L_0x0160
        L_0x00e1:
            com.google.android.gms.measurement.internal.zzgd r6 = r11.zzt
            com.google.android.gms.measurement.internal.zzet r6 = r6.zzaA()
            com.google.android.gms.measurement.internal.zzer r6 = r6.zzi()
            java.lang.String r7 = "App measurement disabled via the global data collection setting"
            r6.zza(r7)
            goto L_0x0160
        L_0x00f1:
            com.google.android.gms.measurement.internal.zzgd r6 = r11.zzt
            com.google.android.gms.measurement.internal.zzet r6 = r6.zzaA()
            com.google.android.gms.measurement.internal.zzer r6 = r6.zzl()
            java.lang.String r7 = "App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics"
            r6.zza(r7)
            goto L_0x0160
        L_0x0101:
            com.google.android.gms.measurement.internal.zzgd r6 = r11.zzt
            com.google.android.gms.measurement.internal.zzet r6 = r6.zzaA()
            com.google.android.gms.measurement.internal.zzer r6 = r6.zzj()
            java.lang.String r7 = "App measurement disabled via the init parameters"
            r6.zza(r7)
            goto L_0x0160
        L_0x0111:
            com.google.android.gms.measurement.internal.zzgd r6 = r11.zzt
            com.google.android.gms.measurement.internal.zzet r6 = r6.zzaA()
            com.google.android.gms.measurement.internal.zzer r6 = r6.zzi()
            java.lang.String r7 = "App measurement disabled via the manifest"
            r6.zza(r7)
            goto L_0x0160
        L_0x0121:
            com.google.android.gms.measurement.internal.zzgd r6 = r11.zzt
            com.google.android.gms.measurement.internal.zzet r6 = r6.zzaA()
            com.google.android.gms.measurement.internal.zzer r6 = r6.zzi()
            java.lang.String r7 = "App measurement disabled by setAnalyticsCollectionEnabled(false)"
            r6.zza(r7)
            goto L_0x0160
        L_0x0131:
            com.google.android.gms.measurement.internal.zzgd r6 = r11.zzt
            com.google.android.gms.measurement.internal.zzet r6 = r6.zzaA()
            com.google.android.gms.measurement.internal.zzer r6 = r6.zzj()
            java.lang.String r7 = "App measurement deactivated via the init parameters"
            r6.zza(r7)
            goto L_0x0160
        L_0x0141:
            com.google.android.gms.measurement.internal.zzgd r6 = r11.zzt
            com.google.android.gms.measurement.internal.zzet r6 = r6.zzaA()
            com.google.android.gms.measurement.internal.zzer r6 = r6.zzi()
            java.lang.String r7 = "App measurement deactivated via the manifest"
            r6.zza(r7)
            goto L_0x0160
        L_0x0151:
            com.google.android.gms.measurement.internal.zzgd r6 = r11.zzt
            com.google.android.gms.measurement.internal.zzet r6 = r6.zzaA()
            com.google.android.gms.measurement.internal.zzer r6 = r6.zzj()
            java.lang.String r7 = "App measurement collection enabled"
            r6.zza(r7)
        L_0x0160:
            r11.zzk = r4
            r11.zzl = r4
            com.google.android.gms.measurement.internal.zzgd r6 = r11.zzt
            r6.zzay()
            if (r2 == 0) goto L_0x0173
            com.google.android.gms.measurement.internal.zzgd r2 = r11.zzt
            java.lang.String r2 = r2.zzw()
            r11.zzl = r2
        L_0x0173:
            com.google.android.gms.measurement.internal.zzgd r2 = r11.zzt     // Catch:{ IllegalStateException -> 0x01dc }
            android.content.Context r2 = r2.zzaw()     // Catch:{ IllegalStateException -> 0x01dc }
            com.google.android.gms.measurement.internal.zzgd r6 = r11.zzt     // Catch:{ IllegalStateException -> 0x01dc }
            java.lang.String r6 = r6.zzz()     // Catch:{ IllegalStateException -> 0x01dc }
            java.lang.String r7 = "google_app_id"
            java.lang.String r2 = com.google.android.gms.measurement.internal.zziq.zzc(r2, r7, r6)     // Catch:{ IllegalStateException -> 0x01dc }
            boolean r6 = android.text.TextUtils.isEmpty(r2)     // Catch:{ IllegalStateException -> 0x01dc }
            if (r6 == 0) goto L_0x018c
            goto L_0x018d
        L_0x018c:
            r4 = r2
        L_0x018d:
            r11.zzk = r4     // Catch:{ IllegalStateException -> 0x01dc }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ IllegalStateException -> 0x01dc }
            if (r2 != 0) goto L_0x01bb
            com.google.android.gms.measurement.internal.zzgd r2 = r11.zzt     // Catch:{ IllegalStateException -> 0x01dc }
            android.content.Context r2 = r2.zzaw()     // Catch:{ IllegalStateException -> 0x01dc }
            com.google.android.gms.measurement.internal.zzgd r4 = r11.zzt     // Catch:{ IllegalStateException -> 0x01dc }
            java.lang.String r4 = r4.zzz()     // Catch:{ IllegalStateException -> 0x01dc }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r2)     // Catch:{ IllegalStateException -> 0x01dc }
            android.content.res.Resources r6 = r2.getResources()     // Catch:{ IllegalStateException -> 0x01dc }
            boolean r7 = android.text.TextUtils.isEmpty(r4)     // Catch:{ IllegalStateException -> 0x01dc }
            if (r7 != 0) goto L_0x01af
            goto L_0x01b3
        L_0x01af:
            java.lang.String r4 = com.google.android.gms.measurement.internal.zzfv.zza(r2)     // Catch:{ IllegalStateException -> 0x01dc }
        L_0x01b3:
            java.lang.String r2 = "admob_app_id"
            java.lang.String r2 = com.google.android.gms.measurement.internal.zzfv.zzb(r2, r6, r4)     // Catch:{ IllegalStateException -> 0x01dc }
            r11.zzl = r2     // Catch:{ IllegalStateException -> 0x01dc }
        L_0x01bb:
            if (r3 != 0) goto L_0x01f0
            com.google.android.gms.measurement.internal.zzgd r2 = r11.zzt     // Catch:{ IllegalStateException -> 0x01dc }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzaA()     // Catch:{ IllegalStateException -> 0x01dc }
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzj()     // Catch:{ IllegalStateException -> 0x01dc }
            java.lang.String r3 = "App measurement enabled for app package, google app id"
            java.lang.String r4 = r11.zza     // Catch:{ IllegalStateException -> 0x01dc }
            java.lang.String r6 = r11.zzk     // Catch:{ IllegalStateException -> 0x01dc }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ IllegalStateException -> 0x01dc }
            if (r6 == 0) goto L_0x01d6
            java.lang.String r6 = r11.zzl     // Catch:{ IllegalStateException -> 0x01dc }
            goto L_0x01d8
        L_0x01d6:
            java.lang.String r6 = r11.zzk     // Catch:{ IllegalStateException -> 0x01dc }
        L_0x01d8:
            r2.zzc(r3, r4, r6)     // Catch:{ IllegalStateException -> 0x01dc }
            goto L_0x01f0
        L_0x01dc:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzgd r3 = r11.zzt
            com.google.android.gms.measurement.internal.zzet r3 = r3.zzaA()
            com.google.android.gms.measurement.internal.zzer r3 = r3.zzd()
            java.lang.Object r0 = com.google.android.gms.measurement.internal.zzet.zzn(r0)
            java.lang.String r4 = "Fetching Google App Id failed with exception. appId"
            r3.zzc(r4, r0, r2)
        L_0x01f0:
            r0 = 0
            r11.zzh = r0
            com.google.android.gms.measurement.internal.zzgd r0 = r11.zzt
            r0.zzay()
            com.google.android.gms.measurement.internal.zzgd r0 = r11.zzt
            com.google.android.gms.measurement.internal.zzag r0 = r0.zzf()
            java.lang.String r2 = "analytics.safelisted_events"
            java.util.List r0 = r0.zzp(r2)
            if (r0 != 0) goto L_0x0207
            goto L_0x023c
        L_0x0207:
            boolean r2 = r0.isEmpty()
            if (r2 == 0) goto L_0x021d
            com.google.android.gms.measurement.internal.zzgd r0 = r11.zzt
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzl()
            java.lang.String r2 = "Safelisted event list is empty. Ignoring"
            r0.zza(r2)
            goto L_0x023e
        L_0x021d:
            java.util.Iterator r2 = r0.iterator()
        L_0x0221:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x023c
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            com.google.android.gms.measurement.internal.zzgd r4 = r11.zzt
            com.google.android.gms.measurement.internal.zzlp r4 = r4.zzv()
            java.lang.String r6 = "safelisted event"
            boolean r3 = r4.zzac(r6, r3)
            if (r3 != 0) goto L_0x0221
            goto L_0x023e
        L_0x023c:
            r11.zzh = r0
        L_0x023e:
            if (r1 == 0) goto L_0x024d
            com.google.android.gms.measurement.internal.zzgd r0 = r11.zzt
            android.content.Context r0 = r0.zzaw()
            boolean r0 = com.google.android.gms.common.wrappers.InstantApps.isInstantApp(r0)
            r11.zzj = r0
            return
        L_0x024d:
            r11.zzj = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzek.zzd():void");
    }

    public final boolean zzf() {
        return true;
    }

    public final int zzh() {
        zza();
        return this.zzj;
    }

    public final int zzi() {
        zza();
        return this.zzc;
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0190  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01cf  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01d2  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01f6  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x021c  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0253  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0265  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0268  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0280  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x02c9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzq zzj(java.lang.String r41) {
        /*
            r40 = this;
            r1 = r40
            r40.zzg()
            com.google.android.gms.measurement.internal.zzq r36 = new com.google.android.gms.measurement.internal.zzq
            java.lang.String r3 = r40.zzl()
            java.lang.String r4 = r40.zzm()
            r40.zza()
            java.lang.String r5 = r1.zzb
            r40.zza()
            int r0 = r1.zzc
            long r6 = (long) r0
            r40.zza()
            java.lang.String r0 = r1.zzd
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)
            java.lang.String r8 = r1.zzd
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzt
            com.google.android.gms.measurement.internal.zzag r0 = r0.zzf()
            r0.zzh()
            r40.zza()
            r40.zzg()
            long r9 = r1.zzf
            r11 = 0
            int r0 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            r2 = 0
            if (r0 != 0) goto L_0x00d0
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzt
            com.google.android.gms.measurement.internal.zzlp r9 = r0.zzv()
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzt
            android.content.Context r0 = r0.zzaw()
            com.google.android.gms.measurement.internal.zzgd r10 = r1.zzt
            android.content.Context r10 = r10.zzaw()
            java.lang.String r10 = r10.getPackageName()
            r9.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)
            android.content.pm.PackageManager r13 = r0.getPackageManager()
            java.security.MessageDigest r14 = com.google.android.gms.measurement.internal.zzlp.zzF()
            r15 = -1
            if (r14 != 0) goto L_0x0078
            com.google.android.gms.measurement.internal.zzgd r0 = r9.zzt
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzd()
            java.lang.String r9 = "Could not get MD5 instance"
            r0.zza(r9)
        L_0x0076:
            r9 = r15
            goto L_0x00ce
        L_0x0078:
            if (r13 == 0) goto L_0x00cd
            boolean r10 = r9.zzah(r0, r10)     // Catch:{ NameNotFoundException -> 0x00bd }
            if (r10 != 0) goto L_0x00bb
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x00bd }
            com.google.android.gms.measurement.internal.zzgd r10 = r9.zzt     // Catch:{ NameNotFoundException -> 0x00bd }
            android.content.Context r10 = r10.zzaw()     // Catch:{ NameNotFoundException -> 0x00bd }
            java.lang.String r10 = r10.getPackageName()     // Catch:{ NameNotFoundException -> 0x00bd }
            r13 = 64
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r10, r13)     // Catch:{ NameNotFoundException -> 0x00bd }
            android.content.pm.Signature[] r0 = r0.signatures     // Catch:{ NameNotFoundException -> 0x00bd }
            if (r0 == 0) goto L_0x00ab
            int r10 = r0.length     // Catch:{ NameNotFoundException -> 0x00bd }
            if (r10 <= 0) goto L_0x00ab
            r0 = r0[r2]     // Catch:{ NameNotFoundException -> 0x00bd }
            byte[] r0 = r0.toByteArray()     // Catch:{ NameNotFoundException -> 0x00bd }
            byte[] r0 = r14.digest(r0)     // Catch:{ NameNotFoundException -> 0x00bd }
            long r9 = com.google.android.gms.measurement.internal.zzlp.zzp(r0)     // Catch:{ NameNotFoundException -> 0x00bd }
            r15 = r9
            goto L_0x0076
        L_0x00ab:
            com.google.android.gms.measurement.internal.zzgd r0 = r9.zzt     // Catch:{ NameNotFoundException -> 0x00bd }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()     // Catch:{ NameNotFoundException -> 0x00bd }
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzk()     // Catch:{ NameNotFoundException -> 0x00bd }
            java.lang.String r10 = "Could not get signatures"
            r0.zza(r10)     // Catch:{ NameNotFoundException -> 0x00bd }
            goto L_0x0076
        L_0x00bb:
            r15 = r11
            goto L_0x0076
        L_0x00bd:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgd r9 = r9.zzt
            com.google.android.gms.measurement.internal.zzet r9 = r9.zzaA()
            com.google.android.gms.measurement.internal.zzer r9 = r9.zzd()
            java.lang.String r10 = "Package name not found"
            r9.zzb(r10, r0)
        L_0x00cd:
            r9 = r11
        L_0x00ce:
            r1.zzf = r9
        L_0x00d0:
            r13 = r9
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzt
            boolean r0 = r0.zzJ()
            com.google.android.gms.measurement.internal.zzgd r9 = r1.zzt
            com.google.android.gms.measurement.internal.zzfi r9 = r9.zzm()
            boolean r9 = r9.zzl
            r10 = 1
            r15 = r9 ^ 1
            r40.zzg()
            com.google.android.gms.measurement.internal.zzgd r9 = r1.zzt
            boolean r9 = r9.zzJ()
            r11 = 0
            if (r9 != 0) goto L_0x00f2
        L_0x00ee:
            r20 = r11
            goto L_0x0178
        L_0x00f2:
            com.google.android.gms.internal.measurement.zzrj.zzc()
            com.google.android.gms.measurement.internal.zzgd r9 = r1.zzt
            com.google.android.gms.measurement.internal.zzag r9 = r9.zzf()
            com.google.android.gms.measurement.internal.zzef r12 = com.google.android.gms.measurement.internal.zzeg.zzac
            boolean r9 = r9.zzs(r11, r12)
            if (r9 == 0) goto L_0x0113
            com.google.android.gms.measurement.internal.zzgd r9 = r1.zzt
            com.google.android.gms.measurement.internal.zzet r9 = r9.zzaA()
            com.google.android.gms.measurement.internal.zzer r9 = r9.zzj()
            java.lang.String r12 = "Disabled IID for tests."
            r9.zza(r12)
            goto L_0x00ee
        L_0x0113:
            com.google.android.gms.measurement.internal.zzgd r9 = r1.zzt     // Catch:{ ClassNotFoundException -> 0x0176 }
            android.content.Context r9 = r9.zzaw()     // Catch:{ ClassNotFoundException -> 0x0176 }
            java.lang.ClassLoader r9 = r9.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x0176 }
            java.lang.String r12 = "com.google.firebase.analytics.FirebaseAnalytics"
            java.lang.Class r9 = r9.loadClass(r12)     // Catch:{ ClassNotFoundException -> 0x0176 }
            if (r9 != 0) goto L_0x0126
            goto L_0x00ee
        L_0x0126:
            java.lang.String r12 = "getInstance"
            java.lang.Class[] r11 = new java.lang.Class[r10]     // Catch:{ Exception -> 0x0167 }
            java.lang.Class<android.content.Context> r19 = android.content.Context.class
            r11[r2] = r19     // Catch:{ Exception -> 0x0167 }
            java.lang.reflect.Method r11 = r9.getDeclaredMethod(r12, r11)     // Catch:{ Exception -> 0x0167 }
            java.lang.Object[] r12 = new java.lang.Object[r10]     // Catch:{ Exception -> 0x0167 }
            com.google.android.gms.measurement.internal.zzgd r10 = r1.zzt     // Catch:{ Exception -> 0x0167 }
            android.content.Context r10 = r10.zzaw()     // Catch:{ Exception -> 0x0167 }
            r12[r2] = r10     // Catch:{ Exception -> 0x0167 }
            r10 = 0
            java.lang.Object r11 = r11.invoke(r10, r12)     // Catch:{ Exception -> 0x0167 }
            if (r11 != 0) goto L_0x0144
            goto L_0x0176
        L_0x0144:
            java.lang.String r10 = "getFirebaseInstanceId"
            java.lang.Class[] r12 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x0157 }
            java.lang.reflect.Method r9 = r9.getDeclaredMethod(r10, r12)     // Catch:{ Exception -> 0x0157 }
            java.lang.Object[] r10 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0157 }
            java.lang.Object r9 = r9.invoke(r11, r10)     // Catch:{ Exception -> 0x0157 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x0157 }
            r20 = r9
            goto L_0x0178
        L_0x0157:
            com.google.android.gms.measurement.internal.zzgd r9 = r1.zzt
            com.google.android.gms.measurement.internal.zzet r9 = r9.zzaA()
            com.google.android.gms.measurement.internal.zzer r9 = r9.zzl()
            java.lang.String r10 = "Failed to retrieve Firebase Instance Id"
            r9.zza(r10)
            goto L_0x0176
        L_0x0167:
            com.google.android.gms.measurement.internal.zzgd r9 = r1.zzt
            com.google.android.gms.measurement.internal.zzet r9 = r9.zzaA()
            com.google.android.gms.measurement.internal.zzer r9 = r9.zzm()
            java.lang.String r10 = "Failed to obtain Firebase Analytics instance"
            r9.zza(r10)
        L_0x0176:
            r20 = 0
        L_0x0178:
            com.google.android.gms.measurement.internal.zzgd r9 = r1.zzt
            com.google.android.gms.measurement.internal.zzfi r10 = r9.zzm()
            com.google.android.gms.measurement.internal.zzfe r10 = r10.zzc
            long r10 = r10.zza()
            r16 = 0
            int r12 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r12 != 0) goto L_0x0190
            long r9 = r9.zzc
            r12 = r3
            r22 = r9
            goto L_0x0199
        L_0x0190:
            r12 = r3
            long r2 = r9.zzc
            long r2 = java.lang.Math.min(r2, r10)
            r22 = r2
        L_0x0199:
            r40.zza()
            int r11 = r1.zzj
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzt
            com.google.android.gms.measurement.internal.zzag r2 = r2.zzf()
            boolean r24 = r2.zzr()
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzt
            com.google.android.gms.measurement.internal.zzfi r2 = r2.zzm()
            r2.zzg()
            android.content.SharedPreferences r2 = r2.zza()
            java.lang.String r3 = "deferred_analytics_collection"
            r9 = 0
            boolean r25 = r2.getBoolean(r3, r9)
            r40.zza()
            java.lang.String r3 = r1.zzl
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzt
            com.google.android.gms.measurement.internal.zzag r2 = r2.zzf()
            java.lang.String r9 = "google_analytics_default_allow_ad_personalization_signals"
            java.lang.Boolean r2 = r2.zzk(r9)
            if (r2 != 0) goto L_0x01d2
            r26 = 0
            goto L_0x01de
        L_0x01d2:
            boolean r2 = r2.booleanValue()
            r9 = 1
            r2 = r2 ^ r9
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r26 = r2
        L_0x01de:
            long r9 = r1.zzg
            java.util.List r2 = r1.zzh
            r19 = r2
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzt
            com.google.android.gms.measurement.internal.zzfi r2 = r2.zzm()
            com.google.android.gms.measurement.internal.zzhb r2 = r2.zzc()
            java.lang.String r30 = r2.zzi()
            java.lang.String r2 = r1.zzi
            if (r2 != 0) goto L_0x0202
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzt
            com.google.android.gms.measurement.internal.zzlp r2 = r2.zzv()
            java.lang.String r2 = r2.zzC()
            r1.zzi = r2
        L_0x0202:
            java.lang.String r2 = r1.zzi
            com.google.android.gms.internal.measurement.zzqu.zzc()
            r27 = r2
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzt
            com.google.android.gms.measurement.internal.zzag r2 = r2.zzf()
            r28 = r3
            com.google.android.gms.measurement.internal.zzef r3 = com.google.android.gms.measurement.internal.zzeg.zzan
            r31 = r9
            r9 = 0
            boolean r2 = r2.zzs(r9, r3)
            if (r2 == 0) goto L_0x0253
            r40.zzg()
            long r2 = r1.zzn
            r9 = 0
            int r2 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r2 != 0) goto L_0x0228
            goto L_0x0247
        L_0x0228:
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzt
            com.google.android.gms.common.util.Clock r2 = r2.zzax()
            long r2 = r2.currentTimeMillis()
            long r9 = r1.zzn
            long r2 = r2 - r9
            java.lang.String r9 = r1.zzm
            if (r9 == 0) goto L_0x0247
            r9 = 86400000(0x5265c00, double:4.2687272E-316)
            int r2 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r2 <= 0) goto L_0x0247
            java.lang.String r2 = r1.zzo
            if (r2 != 0) goto L_0x0247
            r40.zzo()
        L_0x0247:
            java.lang.String r2 = r1.zzm
            if (r2 != 0) goto L_0x024e
            r40.zzo()
        L_0x024e:
            java.lang.String r2 = r1.zzm
            r33 = r2
            goto L_0x0255
        L_0x0253:
            r33 = 0
        L_0x0255:
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzt
            com.google.android.gms.measurement.internal.zzag r2 = r2.zzf()
            com.google.android.gms.measurement.internal.zzgd r3 = r2.zzt
            java.lang.String r3 = "google_analytics_sgtm_upload_enabled"
            java.lang.Boolean r2 = r2.zzk(r3)
            if (r2 != 0) goto L_0x0268
            r34 = 0
            goto L_0x026e
        L_0x0268:
            boolean r2 = r2.booleanValue()
            r34 = r2
        L_0x026e:
            com.google.android.gms.internal.measurement.zzpz.zzc()
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzt
            com.google.android.gms.measurement.internal.zzag r2 = r2.zzf()
            com.google.android.gms.measurement.internal.zzef r3 = com.google.android.gms.measurement.internal.zzeg.zzaD
            r9 = 0
            boolean r2 = r2.zzs(r9, r3)
            if (r2 == 0) goto L_0x02c9
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzt
            com.google.android.gms.measurement.internal.zzlp r2 = r2.zzv()
            java.lang.String r3 = r40.zzl()
            com.google.android.gms.measurement.internal.zzgd r9 = r2.zzt
            android.content.Context r9 = r9.zzaw()
            android.content.pm.PackageManager r9 = r9.getPackageManager()
            if (r9 != 0) goto L_0x0299
            r16 = 0
            goto L_0x02c6
        L_0x0299:
            com.google.android.gms.measurement.internal.zzgd r9 = r2.zzt     // Catch:{ NameNotFoundException -> 0x02ad }
            android.content.Context r9 = r9.zzaw()     // Catch:{ NameNotFoundException -> 0x02ad }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r9 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r9)     // Catch:{ NameNotFoundException -> 0x02ad }
            r10 = 0
            android.content.pm.ApplicationInfo r9 = r9.getApplicationInfo(r3, r10)     // Catch:{ NameNotFoundException -> 0x02ae }
            if (r9 == 0) goto L_0x02c2
            int r2 = r9.targetSdkVersion     // Catch:{ NameNotFoundException -> 0x02ae }
            goto L_0x02c3
        L_0x02ad:
            r10 = 0
        L_0x02ae:
            com.google.android.gms.measurement.internal.zzgd r9 = r2.zzt
            r9.zzay()
            com.google.android.gms.measurement.internal.zzgd r2 = r2.zzt
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzaA()
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzi()
            java.lang.String r9 = "PackageManager failed to find running app: app_id"
            r2.zzb(r9, r3)
        L_0x02c2:
            r2 = r10
        L_0x02c3:
            long r2 = (long) r2
            r16 = r2
        L_0x02c6:
            r37 = r16
            goto L_0x02cb
        L_0x02c9:
            r37 = 0
        L_0x02cb:
            r9 = 79000(0x13498, double:3.9031E-319)
            r17 = 0
            r29 = 0
            r35 = r19
            r39 = r27
            r2 = r36
            r27 = r28
            r3 = r12
            r21 = r11
            r11 = r13
            r13 = r41
            r14 = r0
            r16 = r20
            r19 = r22
            r22 = r24
            r23 = r25
            r24 = r27
            r25 = r26
            r26 = r31
            r28 = r35
            r31 = r39
            r32 = r33
            r33 = r34
            r34 = r37
            r2.<init>((java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5, (long) r6, (java.lang.String) r8, (long) r9, (long) r11, (java.lang.String) r13, (boolean) r14, (boolean) r15, (java.lang.String) r16, (long) r17, (long) r19, (int) r21, (boolean) r22, (boolean) r23, (java.lang.String) r24, (java.lang.Boolean) r25, (long) r26, (java.util.List) r28, (java.lang.String) r29, (java.lang.String) r30, (java.lang.String) r31, (java.lang.String) r32, (boolean) r33, (long) r34)
            return r36
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzek.zzj(java.lang.String):com.google.android.gms.measurement.internal.zzq");
    }

    public final String zzk() {
        zza();
        return this.zzl;
    }

    public final String zzl() {
        zza();
        Preconditions.checkNotNull(this.zza);
        return this.zza;
    }

    public final String zzm() {
        zzg();
        zza();
        Preconditions.checkNotNull(this.zzk);
        return this.zzk;
    }

    public final List zzn() {
        return this.zzh;
    }

    public final void zzo() {
        String str;
        zzg();
        if (!this.zzt.zzm().zzc().zzj(zzha.ANALYTICS_STORAGE)) {
            this.zzt.zzaA().zzc().zza("Analytics Storage consent is not granted");
            str = null;
        } else {
            byte[] bArr = new byte[16];
            this.zzt.zzv().zzG().nextBytes(bArr);
            str = String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
        }
        zzer zzc2 = this.zzt.zzaA().zzc();
        Object[] objArr = new Object[1];
        objArr[0] = str == null ? OptionsBridge.NULL_VALUE : "not null";
        zzc2.zza(String.format("Resetting session stitching token to %s", objArr));
        this.zzm = str;
        this.zzn = this.zzt.zzax().currentTimeMillis();
    }

    public final boolean zzp(String str) {
        String str2 = this.zzo;
        boolean z11 = false;
        if (str2 != null && !str2.equals(str)) {
            z11 = true;
        }
        this.zzo = str;
        return z11;
    }
}
