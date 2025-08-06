package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzcl;
import com.google.android.gms.internal.measurement.zzff;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzfx;
import com.google.android.gms.internal.measurement.zzgc;
import com.google.android.gms.internal.measurement.zzgl;
import com.google.android.gms.internal.measurement.zzgm;
import com.google.android.gms.internal.measurement.zzop;
import com.google.android.gms.internal.measurement.zzpz;
import com.google.android.gms.internal.measurement.zzqu;
import com.google.android.gms.internal.measurement.zzrd;
import com.google.common.net.HttpHeaders;
import com.google.firebase.messaging.Constants;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class zzlh implements zzgy {
    private static volatile zzlh zzb;
    private long zzA;
    private final Map zzB;
    private final Map zzC;
    private zzir zzD;
    private String zzE;
    private final zzlo zzF = new zzlc(this);
    public long zza;
    private final zzfu zzc;
    private final zzez zzd;
    private zzak zze;
    private zzfb zzf;
    private zzks zzg;
    private zzaa zzh;
    private final zzlj zzi;
    private zzip zzj;
    private zzkb zzk;
    private final zzkw zzl;
    private zzfl zzm;
    /* access modifiers changed from: private */
    public final zzgd zzn;
    private boolean zzo = false;
    private boolean zzp;
    private List zzq;
    private int zzr;
    private int zzs;
    private boolean zzt;
    private boolean zzu;
    private boolean zzv;
    private FileLock zzw;
    private FileChannel zzx;
    private List zzy;
    private List zzz;

    public zzlh(zzli zzli, zzgd zzgd) {
        Preconditions.checkNotNull(zzli);
        this.zzn = zzgd.zzp(zzli.zza, (zzcl) null, (Long) null);
        this.zzA = -1;
        this.zzl = new zzkw(this);
        zzlj zzlj = new zzlj(this);
        zzlj.zzX();
        this.zzi = zzlj;
        zzez zzez = new zzez(this);
        zzez.zzX();
        this.zzd = zzez;
        zzfu zzfu = new zzfu(this);
        zzfu.zzX();
        this.zzc = zzfu;
        this.zzB = new HashMap();
        this.zzC = new HashMap();
        zzaB().zzp(new zzkx(this, zzli));
    }

    public static final void zzaa(zzfs zzfs, int i11, String str) {
        List zzp2 = zzfs.zzp();
        int i12 = 0;
        while (i12 < zzp2.size()) {
            if (!"_err".equals(((zzfx) zzp2.get(i12)).zzg())) {
                i12++;
            } else {
                return;
            }
        }
        zzfw zze2 = zzfx.zze();
        zze2.zzj("_err");
        zze2.zzi(Long.valueOf((long) i11).longValue());
        zzfw zze3 = zzfx.zze();
        zze3.zzj("_ev");
        zze3.zzk(str);
        zzfs.zzf((zzfx) zze2.zzaD());
        zzfs.zzf((zzfx) zze3.zzaD());
    }

    public static final void zzab(zzfs zzfs, String str) {
        List zzp2 = zzfs.zzp();
        for (int i11 = 0; i11 < zzp2.size(); i11++) {
            if (str.equals(((zzfx) zzp2.get(i11)).zzg())) {
                zzfs.zzh(i11);
                return;
            }
        }
    }

    private final zzq zzac(String str) {
        String str2 = str;
        zzak zzak = this.zze;
        zzal(zzak);
        zzh zzj2 = zzak.zzj(str2);
        if (zzj2 == null || TextUtils.isEmpty(zzj2.zzy())) {
            zzaA().zzc().zzb("No app data available; dropping", str2);
            return null;
        }
        Boolean zzad = zzad(zzj2);
        if (zzad == null || zzad.booleanValue()) {
            zzh zzh2 = zzj2;
            zzh2.zza();
            return new zzq(str, zzj2.zzA(), zzj2.zzy(), zzj2.zzb(), zzj2.zzx(), zzj2.zzm(), zzj2.zzj(), (String) null, zzj2.zzan(), false, zzj2.zzz(), 0, 0, 0, zzh2.zzam(), false, zzh2.zzt(), zzh2.zzs(), zzh2.zzk(), zzh2.zzE(), (String) null, zzq(str).zzi(), "", (String) null, zzh2.zzap(), zzh2.zzr());
        }
        zzaA().zzd().zzb("App version does not match; dropping. appId", zzet.zzn(str));
        return null;
    }

    private final Boolean zzad(zzh zzh2) {
        try {
            if (zzh2.zzb() != -2147483648L) {
                if (zzh2.zzb() == ((long) Wrappers.packageManager(this.zzn.zzaw()).getPackageInfo(zzh2.zzv(), 0).versionCode)) {
                    return Boolean.TRUE;
                }
            } else {
                String str = Wrappers.packageManager(this.zzn.zzaw()).getPackageInfo(zzh2.zzv(), 0).versionName;
                String zzy2 = zzh2.zzy();
                if (zzy2 != null && zzy2.equals(str)) {
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private final void zzae() {
        zzaB().zzg();
        if (this.zzt || this.zzu || this.zzv) {
            zzaA().zzj().zzd("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzt), Boolean.valueOf(this.zzu), Boolean.valueOf(this.zzv));
            return;
        }
        zzaA().zzj().zza("Stopping uploading service(s)");
        List<Runnable> list = this.zzq;
        if (list != null) {
            for (Runnable run : list) {
                run.run();
            }
            ((List) Preconditions.checkNotNull(this.zzq)).clear();
        }
    }

    private final void zzaf(zzgc zzgc, long j11, boolean z11) {
        zzlm zzlm;
        zzak zzak = this.zze;
        zzal(zzak);
        String str = true != z11 ? "_lte" : "_se";
        zzlm zzp2 = zzak.zzp(zzgc.zzaq(), str);
        if (zzp2 == null || zzp2.zze == null) {
            zzlm = new zzlm(zzgc.zzaq(), TtmlNode.TEXT_EMPHASIS_AUTO, str, zzax().currentTimeMillis(), Long.valueOf(j11));
        } else {
            zzlm = new zzlm(zzgc.zzaq(), TtmlNode.TEXT_EMPHASIS_AUTO, str, zzax().currentTimeMillis(), Long.valueOf(((Long) zzp2.zze).longValue() + j11));
        }
        zzgl zzd2 = zzgm.zzd();
        zzd2.zzf(str);
        zzd2.zzg(zzax().currentTimeMillis());
        zzd2.zze(((Long) zzlm.zze).longValue());
        zzgm zzgm = (zzgm) zzd2.zzaD();
        int zza2 = zzlj.zza(zzgc, str);
        if (zza2 >= 0) {
            zzgc.zzan(zza2, zzgm);
        } else {
            zzgc.zzm(zzgm);
        }
        if (j11 > 0) {
            zzak zzak2 = this.zze;
            zzal(zzak2);
            zzak2.zzL(zzlm);
            zzaA().zzj().zzc("Updated engagement user property. scope, value", true != z11 ? "lifetime" : "session-scoped", zzlm.zze);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0238  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzag() {
        /*
            r20 = this;
            r0 = r20
            com.google.android.gms.measurement.internal.zzga r1 = r20.zzaB()
            r1.zzg()
            r20.zzB()
            long r1 = r0.zza
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x004e
            r1 = 3600000(0x36ee80, double:1.7786363E-317)
            com.google.android.gms.common.util.Clock r5 = r20.zzax()
            long r5 = r5.elapsedRealtime()
            long r7 = r0.zza
            long r5 = r5 - r7
            long r5 = java.lang.Math.abs(r5)
            long r1 = r1 - r5
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x004c
            com.google.android.gms.measurement.internal.zzet r3 = r20.zzaA()
            com.google.android.gms.measurement.internal.zzer r3 = r3.zzj()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            java.lang.String r2 = "Upload has been suspended. Will update scheduling later in approximately ms"
            r3.zzb(r2, r1)
            com.google.android.gms.measurement.internal.zzfb r1 = r20.zzl()
            r1.zzc()
            com.google.android.gms.measurement.internal.zzks r1 = r0.zzg
            zzal(r1)
            r1.zza()
            return
        L_0x004c:
            r0.zza = r3
        L_0x004e:
            com.google.android.gms.measurement.internal.zzgd r1 = r0.zzn
            boolean r1 = r1.zzM()
            if (r1 == 0) goto L_0x0255
            boolean r1 = r20.zzai()
            if (r1 != 0) goto L_0x005e
            goto L_0x0255
        L_0x005e:
            com.google.android.gms.common.util.Clock r1 = r20.zzax()
            long r1 = r1.currentTimeMillis()
            r20.zzg()
            com.google.android.gms.measurement.internal.zzef r5 = com.google.android.gms.measurement.internal.zzeg.zzA
            r6 = 0
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r7 = r5.longValue()
            long r7 = java.lang.Math.max(r3, r7)
            com.google.android.gms.measurement.internal.zzak r5 = r0.zze
            zzal(r5)
            boolean r5 = r5.zzH()
            r10 = 1
            if (r5 != 0) goto L_0x0093
            com.google.android.gms.measurement.internal.zzak r5 = r0.zze
            zzal(r5)
            boolean r5 = r5.zzG()
            if (r5 == 0) goto L_0x0092
            goto L_0x0093
        L_0x0092:
            r10 = 0
        L_0x0093:
            if (r10 == 0) goto L_0x00d3
            com.google.android.gms.measurement.internal.zzag r5 = r20.zzg()
            java.lang.String r5 = r5.zzl()
            boolean r11 = android.text.TextUtils.isEmpty(r5)
            if (r11 != 0) goto L_0x00bf
            java.lang.String r11 = ".none."
            boolean r5 = r11.equals(r5)
            if (r5 != 0) goto L_0x00bf
            r20.zzg()
            com.google.android.gms.measurement.internal.zzef r5 = com.google.android.gms.measurement.internal.zzeg.zzv
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r11 = r5.longValue()
            long r11 = java.lang.Math.max(r3, r11)
            goto L_0x00e6
        L_0x00bf:
            r20.zzg()
            com.google.android.gms.measurement.internal.zzef r5 = com.google.android.gms.measurement.internal.zzeg.zzu
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r11 = r5.longValue()
            long r11 = java.lang.Math.max(r3, r11)
            goto L_0x00e6
        L_0x00d3:
            r20.zzg()
            com.google.android.gms.measurement.internal.zzef r5 = com.google.android.gms.measurement.internal.zzeg.zzt
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r11 = r5.longValue()
            long r11 = java.lang.Math.max(r3, r11)
        L_0x00e6:
            com.google.android.gms.measurement.internal.zzkb r5 = r0.zzk
            com.google.android.gms.measurement.internal.zzfe r5 = r5.zzc
            long r13 = r5.zza()
            com.google.android.gms.measurement.internal.zzkb r5 = r0.zzk
            com.google.android.gms.measurement.internal.zzfe r5 = r5.zzd
            long r15 = r5.zza()
            com.google.android.gms.measurement.internal.zzak r5 = r0.zze
            zzal(r5)
            r17 = r10
            long r9 = r5.zzd()
            com.google.android.gms.measurement.internal.zzak r5 = r0.zze
            zzal(r5)
            r18 = r7
            long r6 = r5.zze()
            long r5 = java.lang.Math.max(r9, r6)
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 != 0) goto L_0x0117
        L_0x0114:
            r9 = r3
            goto L_0x018f
        L_0x0117:
            long r5 = r5 - r1
            long r5 = java.lang.Math.abs(r5)
            long r5 = r1 - r5
            long r13 = r13 - r1
            long r7 = java.lang.Math.abs(r13)
            long r7 = r1 - r7
            long r15 = r15 - r1
            long r9 = java.lang.Math.abs(r15)
            long r1 = r1 - r9
            long r9 = r5 + r18
            long r7 = java.lang.Math.max(r7, r1)
            if (r17 == 0) goto L_0x013c
            int r13 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r13 <= 0) goto L_0x013c
            long r9 = java.lang.Math.min(r5, r7)
            long r9 = r9 + r11
        L_0x013c:
            com.google.android.gms.measurement.internal.zzlj r13 = r0.zzi
            zzal(r13)
            boolean r13 = r13.zzx(r7, r11)
            if (r13 != 0) goto L_0x0149
            long r9 = r7 + r11
        L_0x0149:
            int r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r7 == 0) goto L_0x018f
            int r5 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r5 < 0) goto L_0x018f
            r5 = 0
        L_0x0152:
            r20.zzg()
            r6 = 20
            com.google.android.gms.measurement.internal.zzef r7 = com.google.android.gms.measurement.internal.zzeg.zzC
            r8 = 0
            java.lang.Object r7 = r7.zza(r8)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r11 = 0
            int r7 = java.lang.Math.max(r11, r7)
            int r6 = java.lang.Math.min(r6, r7)
            if (r5 >= r6) goto L_0x0114
            r6 = 1
            long r6 = r6 << r5
            r20.zzg()
            com.google.android.gms.measurement.internal.zzef r12 = com.google.android.gms.measurement.internal.zzeg.zzB
            java.lang.Object r12 = r12.zza(r8)
            java.lang.Long r12 = (java.lang.Long) r12
            long r12 = r12.longValue()
            long r12 = java.lang.Math.max(r3, r12)
            long r12 = r12 * r6
            long r9 = r9 + r12
            int r6 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r6 <= 0) goto L_0x018c
            goto L_0x018f
        L_0x018c:
            int r5 = r5 + 1
            goto L_0x0152
        L_0x018f:
            int r1 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x0238
            com.google.android.gms.measurement.internal.zzez r1 = r0.zzd
            zzal(r1)
            boolean r1 = r1.zza()
            if (r1 == 0) goto L_0x021b
            com.google.android.gms.measurement.internal.zzkb r1 = r0.zzk
            com.google.android.gms.measurement.internal.zzfe r1 = r1.zzb
            long r1 = r1.zza()
            r20.zzg()
            com.google.android.gms.measurement.internal.zzef r5 = com.google.android.gms.measurement.internal.zzeg.zzr
            r6 = 0
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            long r5 = java.lang.Math.max(r3, r5)
            com.google.android.gms.measurement.internal.zzlj r7 = r0.zzi
            zzal(r7)
            boolean r7 = r7.zzx(r1, r5)
            if (r7 != 0) goto L_0x01ca
            long r1 = r1 + r5
            long r9 = java.lang.Math.max(r9, r1)
        L_0x01ca:
            com.google.android.gms.measurement.internal.zzfb r1 = r20.zzl()
            r1.zzc()
            com.google.android.gms.common.util.Clock r1 = r20.zzax()
            long r1 = r1.currentTimeMillis()
            long r9 = r9 - r1
            int r1 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x0201
            r20.zzg()
            com.google.android.gms.measurement.internal.zzef r1 = com.google.android.gms.measurement.internal.zzeg.zzw
            r2 = 0
            java.lang.Object r1 = r1.zza(r2)
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            long r9 = java.lang.Math.max(r3, r1)
            com.google.android.gms.measurement.internal.zzkb r1 = r0.zzk
            com.google.android.gms.measurement.internal.zzfe r1 = r1.zzc
            com.google.android.gms.common.util.Clock r2 = r20.zzax()
            long r2 = r2.currentTimeMillis()
            r1.zzb(r2)
        L_0x0201:
            com.google.android.gms.measurement.internal.zzet r1 = r20.zzaA()
            com.google.android.gms.measurement.internal.zzer r1 = r1.zzj()
            java.lang.Long r2 = java.lang.Long.valueOf(r9)
            java.lang.String r3 = "Upload scheduled in approximately ms"
            r1.zzb(r3, r2)
            com.google.android.gms.measurement.internal.zzks r1 = r0.zzg
            zzal(r1)
            r1.zzd(r9)
            return
        L_0x021b:
            com.google.android.gms.measurement.internal.zzet r1 = r20.zzaA()
            com.google.android.gms.measurement.internal.zzer r1 = r1.zzj()
            java.lang.String r2 = "No network"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzfb r1 = r20.zzl()
            r1.zzb()
            com.google.android.gms.measurement.internal.zzks r1 = r0.zzg
            zzal(r1)
            r1.zza()
            return
        L_0x0238:
            com.google.android.gms.measurement.internal.zzet r1 = r20.zzaA()
            com.google.android.gms.measurement.internal.zzer r1 = r1.zzj()
            java.lang.String r2 = "Next upload time is 0"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzfb r1 = r20.zzl()
            r1.zzc()
            com.google.android.gms.measurement.internal.zzks r1 = r0.zzg
            zzal(r1)
            r1.zza()
            return
        L_0x0255:
            com.google.android.gms.measurement.internal.zzet r1 = r20.zzaA()
            com.google.android.gms.measurement.internal.zzer r1 = r1.zzj()
            java.lang.String r2 = "Nothing to upload or uploading impossible"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzfb r1 = r20.zzl()
            r1.zzc()
            com.google.android.gms.measurement.internal.zzks r1 = r0.zzg
            zzal(r1)
            r1.zza()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzlh.zzag():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:360:0x0b34, code lost:
        if (r10 > (com.google.android.gms.measurement.internal.zzag.zzA() + r8)) goto L_0x0b36;
     */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0383 A[Catch:{ NumberFormatException -> 0x079d, all -> 0x0ccd }] */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0448 A[Catch:{ NumberFormatException -> 0x079d, all -> 0x0ccd }] */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x048a A[Catch:{ NumberFormatException -> 0x079d, all -> 0x0ccd }] */
    /* JADX WARNING: Removed duplicated region for block: B:258:0x07d8 A[Catch:{ NumberFormatException -> 0x079d, all -> 0x0ccd }] */
    /* JADX WARNING: Removed duplicated region for block: B:270:0x0821 A[Catch:{ NumberFormatException -> 0x079d, all -> 0x0ccd }] */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x0844 A[Catch:{ NumberFormatException -> 0x079d, all -> 0x0ccd }] */
    /* JADX WARNING: Removed duplicated region for block: B:279:0x08bb A[Catch:{ NumberFormatException -> 0x079d, all -> 0x0ccd }] */
    /* JADX WARNING: Removed duplicated region for block: B:280:0x08bd A[Catch:{ NumberFormatException -> 0x079d, all -> 0x0ccd }] */
    /* JADX WARNING: Removed duplicated region for block: B:283:0x08c5 A[Catch:{ NumberFormatException -> 0x079d, all -> 0x0ccd }] */
    /* JADX WARNING: Removed duplicated region for block: B:293:0x08f1 A[Catch:{ NumberFormatException -> 0x079d, all -> 0x0ccd }] */
    /* JADX WARNING: Removed duplicated region for block: B:359:0x0b24 A[Catch:{ NumberFormatException -> 0x079d, all -> 0x0ccd }] */
    /* JADX WARNING: Removed duplicated region for block: B:368:0x0bab A[Catch:{ NumberFormatException -> 0x079d, all -> 0x0ccd }] */
    /* JADX WARNING: Removed duplicated region for block: B:372:0x0bc7 A[Catch:{ SQLiteException -> 0x0bdf }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:55:0x01c0=Splitter:B:55:0x01c0, B:399:0x0cbb=Splitter:B:399:0x0cbb} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzah(java.lang.String r41, long r42) {
        /*
            r40 = this;
            r1 = r40
            java.lang.String r2 = "_npa"
            java.lang.String r3 = "_ai"
            com.google.android.gms.measurement.internal.zzak r4 = r1.zze
            zzal(r4)
            r4.zzw()
            com.google.android.gms.measurement.internal.zzle r4 = new com.google.android.gms.measurement.internal.zzle     // Catch:{ all -> 0x0ccd }
            r12 = 0
            r4.<init>(r1, r12)     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzak r5 = r1.zze     // Catch:{ all -> 0x0ccd }
            zzal(r5)     // Catch:{ all -> 0x0ccd }
            r6 = 0
            long r9 = r1.zzA     // Catch:{ all -> 0x0ccd }
            r7 = r42
            r11 = r4
            r5.zzU(r6, r7, r9, r11)     // Catch:{ all -> 0x0ccd }
            java.util.List r5 = r4.zzc     // Catch:{ all -> 0x0ccd }
            if (r5 == 0) goto L_0x0cbb
            boolean r5 = r5.isEmpty()     // Catch:{ all -> 0x0ccd }
            if (r5 == 0) goto L_0x002e
            goto L_0x0cbb
        L_0x002e:
            com.google.android.gms.internal.measurement.zzgd r5 = r4.zza     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzkx r5 = r5.zzbB()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzgc r5 = (com.google.android.gms.internal.measurement.zzgc) r5     // Catch:{ all -> 0x0ccd }
            r5.zzr()     // Catch:{ all -> 0x0ccd }
            r11 = r12
            r14 = r11
            r8 = 0
            r9 = 0
            r10 = 0
            r13 = -1
            r15 = -1
        L_0x0040:
            java.util.List r12 = r4.zzc     // Catch:{ all -> 0x0ccd }
            int r12 = r12.size()     // Catch:{ all -> 0x0ccd }
            java.lang.String r6 = "_fr"
            java.lang.String r7 = "_et"
            r16 = r10
            java.lang.String r10 = "_e"
            r17 = r13
            r18 = r14
            if (r8 >= r12) goto L_0x04fa
            java.util.List r12 = r4.zzc     // Catch:{ all -> 0x0ccd }
            java.lang.Object r12 = r12.get(r8)     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzft r12 = (com.google.android.gms.internal.measurement.zzft) r12     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzkx r12 = r12.zzbB()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzfs r12 = (com.google.android.gms.internal.measurement.zzfs) r12     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzfu r14 = r1.zzc     // Catch:{ all -> 0x0ccd }
            zzal(r14)     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzgd r13 = r4.zza     // Catch:{ all -> 0x0ccd }
            java.lang.String r13 = r13.zzy()     // Catch:{ all -> 0x0ccd }
            r19 = r2
            java.lang.String r2 = r12.zzo()     // Catch:{ all -> 0x0ccd }
            boolean r2 = r14.zzr(r13, r2)     // Catch:{ all -> 0x0ccd }
            java.lang.String r13 = "_err"
            if (r2 == 0) goto L_0x00f7
            com.google.android.gms.measurement.internal.zzet r2 = r40.zzaA()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzk()     // Catch:{ all -> 0x0ccd }
            java.lang.String r6 = "Dropping blocked raw event. appId"
            com.google.android.gms.internal.measurement.zzgd r7 = r4.zza     // Catch:{ all -> 0x0ccd }
            java.lang.String r7 = r7.zzy()     // Catch:{ all -> 0x0ccd }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzet.zzn(r7)     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzgd r10 = r1.zzn     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzeo r10 = r10.zzj()     // Catch:{ all -> 0x0ccd }
            java.lang.String r14 = r12.zzo()     // Catch:{ all -> 0x0ccd }
            java.lang.String r10 = r10.zzd(r14)     // Catch:{ all -> 0x0ccd }
            r2.zzc(r6, r7, r10)     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzfu r2 = r1.zzc     // Catch:{ all -> 0x0ccd }
            zzal(r2)     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzgd r6 = r4.zza     // Catch:{ all -> 0x0ccd }
            java.lang.String r6 = r6.zzy()     // Catch:{ all -> 0x0ccd }
            boolean r2 = r2.zzp(r6)     // Catch:{ all -> 0x0ccd }
            if (r2 != 0) goto L_0x00e8
            com.google.android.gms.measurement.internal.zzfu r2 = r1.zzc     // Catch:{ all -> 0x0ccd }
            zzal(r2)     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzgd r6 = r4.zza     // Catch:{ all -> 0x0ccd }
            java.lang.String r6 = r6.zzy()     // Catch:{ all -> 0x0ccd }
            boolean r2 = r2.zzs(r6)     // Catch:{ all -> 0x0ccd }
            if (r2 == 0) goto L_0x00c3
            goto L_0x00e8
        L_0x00c3:
            java.lang.String r2 = r12.zzo()     // Catch:{ all -> 0x0ccd }
            boolean r2 = r13.equals(r2)     // Catch:{ all -> 0x0ccd }
            if (r2 != 0) goto L_0x00e8
            com.google.android.gms.measurement.internal.zzlp r20 = r40.zzv()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzlo r2 = r1.zzF     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzgd r6 = r4.zza     // Catch:{ all -> 0x0ccd }
            java.lang.String r22 = r6.zzy()     // Catch:{ all -> 0x0ccd }
            r23 = 11
            java.lang.String r24 = "_ev"
            java.lang.String r25 = r12.zzo()     // Catch:{ all -> 0x0ccd }
            r26 = 0
            r21 = r2
            r20.zzO(r21, r22, r23, r24, r25, r26)     // Catch:{ all -> 0x0ccd }
        L_0x00e8:
            r21 = r3
            r6 = r8
            r23 = r11
            r10 = r16
            r13 = r17
            r14 = r18
            r11 = r5
            r5 = -1
            goto L_0x04ef
        L_0x00f7:
            java.lang.String r2 = r12.zzo()     // Catch:{ all -> 0x0ccd }
            java.lang.String r14 = com.google.android.gms.measurement.internal.zzhc.zza(r3)     // Catch:{ all -> 0x0ccd }
            boolean r2 = r2.equals(r14)     // Catch:{ all -> 0x0ccd }
            if (r2 == 0) goto L_0x016d
            r12.zzi(r3)     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzet r2 = r40.zzaA()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzj()     // Catch:{ all -> 0x0ccd }
            java.lang.String r14 = "Renaming ad_impression to _ai"
            r2.zza(r14)     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzet r2 = r40.zzaA()     // Catch:{ all -> 0x0ccd }
            java.lang.String r2 = r2.zzr()     // Catch:{ all -> 0x0ccd }
            r14 = 5
            boolean r2 = android.util.Log.isLoggable(r2, r14)     // Catch:{ all -> 0x0ccd }
            if (r2 == 0) goto L_0x016d
            r2 = 0
        L_0x0125:
            int r14 = r12.zza()     // Catch:{ all -> 0x0ccd }
            if (r2 >= r14) goto L_0x016d
            java.lang.String r14 = "ad_platform"
            com.google.android.gms.internal.measurement.zzfx r20 = r12.zzn(r2)     // Catch:{ all -> 0x0ccd }
            r21 = r3
            java.lang.String r3 = r20.zzg()     // Catch:{ all -> 0x0ccd }
            boolean r3 = r14.equals(r3)     // Catch:{ all -> 0x0ccd }
            if (r3 == 0) goto L_0x0168
            com.google.android.gms.internal.measurement.zzfx r3 = r12.zzn(r2)     // Catch:{ all -> 0x0ccd }
            java.lang.String r3 = r3.zzh()     // Catch:{ all -> 0x0ccd }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x0ccd }
            if (r3 != 0) goto L_0x0168
            java.lang.String r3 = "admob"
            com.google.android.gms.internal.measurement.zzfx r14 = r12.zzn(r2)     // Catch:{ all -> 0x0ccd }
            java.lang.String r14 = r14.zzh()     // Catch:{ all -> 0x0ccd }
            boolean r3 = r3.equalsIgnoreCase(r14)     // Catch:{ all -> 0x0ccd }
            if (r3 == 0) goto L_0x0168
            com.google.android.gms.measurement.internal.zzet r3 = r40.zzaA()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzer r3 = r3.zzl()     // Catch:{ all -> 0x0ccd }
            java.lang.String r14 = "AdMob ad impression logged from app. Potentially duplicative."
            r3.zza(r14)     // Catch:{ all -> 0x0ccd }
        L_0x0168:
            int r2 = r2 + 1
            r3 = r21
            goto L_0x0125
        L_0x016d:
            r21 = r3
            com.google.android.gms.measurement.internal.zzfu r2 = r1.zzc     // Catch:{ all -> 0x0ccd }
            zzal(r2)     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzgd r3 = r4.zza     // Catch:{ all -> 0x0ccd }
            java.lang.String r3 = r3.zzy()     // Catch:{ all -> 0x0ccd }
            java.lang.String r14 = r12.zzo()     // Catch:{ all -> 0x0ccd }
            boolean r2 = r2.zzq(r3, r14)     // Catch:{ all -> 0x0ccd }
            java.lang.String r3 = "_c"
            if (r2 != 0) goto L_0x01b7
            com.google.android.gms.measurement.internal.zzlj r14 = r1.zzi     // Catch:{ all -> 0x0ccd }
            zzal(r14)     // Catch:{ all -> 0x0ccd }
            java.lang.String r14 = r12.zzo()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r14)     // Catch:{ all -> 0x0ccd }
            r20 = r9
            int r9 = r14.hashCode()     // Catch:{ all -> 0x0ccd }
            r22 = r8
            r8 = 95027(0x17333, float:1.33161E-40)
            if (r9 == r8) goto L_0x01a0
            goto L_0x01aa
        L_0x01a0:
            java.lang.String r8 = "_ui"
            boolean r8 = r14.equals(r8)
            if (r8 == 0) goto L_0x01aa
            r8 = 0
            goto L_0x01ab
        L_0x01aa:
            r8 = -1
        L_0x01ab:
            if (r8 == 0) goto L_0x01bb
            r25 = r6
            r24 = r7
            r23 = r11
            r2 = 0
            r11 = r5
            goto L_0x0381
        L_0x01b7:
            r22 = r8
            r20 = r9
        L_0x01bb:
            r23 = r11
            r8 = 0
            r9 = 0
            r14 = 0
        L_0x01c0:
            int r11 = r12.zza()     // Catch:{ all -> 0x0ccd }
            r24 = r7
            java.lang.String r7 = "_r"
            if (r8 >= r11) goto L_0x0227
            com.google.android.gms.internal.measurement.zzfx r11 = r12.zzn(r8)     // Catch:{ all -> 0x0ccd }
            java.lang.String r11 = r11.zzg()     // Catch:{ all -> 0x0ccd }
            boolean r11 = r3.equals(r11)     // Catch:{ all -> 0x0ccd }
            if (r11 == 0) goto L_0x01f5
            com.google.android.gms.internal.measurement.zzfx r7 = r12.zzn(r8)     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzkx r7 = r7.zzbB()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzfw r7 = (com.google.android.gms.internal.measurement.zzfw) r7     // Catch:{ all -> 0x0ccd }
            r11 = r5
            r25 = r6
            r5 = 1
            r7.zzi(r5)     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzlb r5 = r7.zzaD()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzfx r5 = (com.google.android.gms.internal.measurement.zzfx) r5     // Catch:{ all -> 0x0ccd }
            r12.zzk(r8, r5)     // Catch:{ all -> 0x0ccd }
            r9 = 1
            goto L_0x021f
        L_0x01f5:
            r11 = r5
            r25 = r6
            com.google.android.gms.internal.measurement.zzfx r5 = r12.zzn(r8)     // Catch:{ all -> 0x0ccd }
            java.lang.String r5 = r5.zzg()     // Catch:{ all -> 0x0ccd }
            boolean r5 = r7.equals(r5)     // Catch:{ all -> 0x0ccd }
            if (r5 == 0) goto L_0x021f
            com.google.android.gms.internal.measurement.zzfx r5 = r12.zzn(r8)     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzkx r5 = r5.zzbB()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzfw r5 = (com.google.android.gms.internal.measurement.zzfw) r5     // Catch:{ all -> 0x0ccd }
            r6 = 1
            r5.zzi(r6)     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzlb r5 = r5.zzaD()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzfx r5 = (com.google.android.gms.internal.measurement.zzfx) r5     // Catch:{ all -> 0x0ccd }
            r12.zzk(r8, r5)     // Catch:{ all -> 0x0ccd }
            r14 = 1
        L_0x021f:
            int r8 = r8 + 1
            r5 = r11
            r7 = r24
            r6 = r25
            goto L_0x01c0
        L_0x0227:
            r11 = r5
            r25 = r6
            if (r9 != 0) goto L_0x0258
            if (r2 == 0) goto L_0x0258
            com.google.android.gms.measurement.internal.zzet r5 = r40.zzaA()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzer r5 = r5.zzj()     // Catch:{ all -> 0x0ccd }
            java.lang.String r6 = "Marking event as conversion"
            com.google.android.gms.measurement.internal.zzgd r8 = r1.zzn     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzeo r8 = r8.zzj()     // Catch:{ all -> 0x0ccd }
            java.lang.String r9 = r12.zzo()     // Catch:{ all -> 0x0ccd }
            java.lang.String r8 = r8.zzd(r9)     // Catch:{ all -> 0x0ccd }
            r5.zzb(r6, r8)     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzfw r5 = com.google.android.gms.internal.measurement.zzfx.zze()     // Catch:{ all -> 0x0ccd }
            r5.zzj(r3)     // Catch:{ all -> 0x0ccd }
            r8 = 1
            r5.zzi(r8)     // Catch:{ all -> 0x0ccd }
            r12.zze(r5)     // Catch:{ all -> 0x0ccd }
        L_0x0258:
            if (r14 != 0) goto L_0x0284
            com.google.android.gms.measurement.internal.zzet r5 = r40.zzaA()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzer r5 = r5.zzj()     // Catch:{ all -> 0x0ccd }
            java.lang.String r6 = "Marking event as real-time"
            com.google.android.gms.measurement.internal.zzgd r8 = r1.zzn     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzeo r8 = r8.zzj()     // Catch:{ all -> 0x0ccd }
            java.lang.String r9 = r12.zzo()     // Catch:{ all -> 0x0ccd }
            java.lang.String r8 = r8.zzd(r9)     // Catch:{ all -> 0x0ccd }
            r5.zzb(r6, r8)     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzfw r5 = com.google.android.gms.internal.measurement.zzfx.zze()     // Catch:{ all -> 0x0ccd }
            r5.zzj(r7)     // Catch:{ all -> 0x0ccd }
            r8 = 1
            r5.zzi(r8)     // Catch:{ all -> 0x0ccd }
            r12.zze(r5)     // Catch:{ all -> 0x0ccd }
        L_0x0284:
            com.google.android.gms.measurement.internal.zzak r5 = r1.zze     // Catch:{ all -> 0x0ccd }
            zzal(r5)     // Catch:{ all -> 0x0ccd }
            long r27 = r40.zza()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzgd r6 = r4.zza     // Catch:{ all -> 0x0ccd }
            java.lang.String r29 = r6.zzy()     // Catch:{ all -> 0x0ccd }
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 1
            r26 = r5
            com.google.android.gms.measurement.internal.zzai r5 = r26.zzl(r27, r29, r30, r31, r32, r33, r34)     // Catch:{ all -> 0x0ccd }
            long r5 = r5.zze     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzag r8 = r40.zzg()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzgd r9 = r4.zza     // Catch:{ all -> 0x0ccd }
            java.lang.String r9 = r9.zzy()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzef r14 = com.google.android.gms.measurement.internal.zzeg.zzo     // Catch:{ all -> 0x0ccd }
            int r8 = r8.zze(r9, r14)     // Catch:{ all -> 0x0ccd }
            long r8 = (long) r8     // Catch:{ all -> 0x0ccd }
            int r5 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r5 <= 0) goto L_0x02be
            zzab(r12, r7)     // Catch:{ all -> 0x0ccd }
            goto L_0x02c0
        L_0x02be:
            r16 = 1
        L_0x02c0:
            java.lang.String r5 = r12.zzo()     // Catch:{ all -> 0x0ccd }
            boolean r5 = com.google.android.gms.measurement.internal.zzlp.zzak(r5)     // Catch:{ all -> 0x0ccd }
            if (r5 == 0) goto L_0x0381
            if (r2 == 0) goto L_0x0381
            com.google.android.gms.measurement.internal.zzak r5 = r1.zze     // Catch:{ all -> 0x0ccd }
            zzal(r5)     // Catch:{ all -> 0x0ccd }
            long r27 = r40.zza()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzgd r6 = r4.zza     // Catch:{ all -> 0x0ccd }
            java.lang.String r29 = r6.zzy()     // Catch:{ all -> 0x0ccd }
            r30 = 0
            r31 = 0
            r32 = 1
            r33 = 0
            r34 = 0
            r26 = r5
            com.google.android.gms.measurement.internal.zzai r5 = r26.zzl(r27, r29, r30, r31, r32, r33, r34)     // Catch:{ all -> 0x0ccd }
            long r5 = r5.zzc     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzag r7 = r40.zzg()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzgd r8 = r4.zza     // Catch:{ all -> 0x0ccd }
            java.lang.String r8 = r8.zzy()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzef r9 = com.google.android.gms.measurement.internal.zzeg.zzn     // Catch:{ all -> 0x0ccd }
            int r7 = r7.zze(r8, r9)     // Catch:{ all -> 0x0ccd }
            long r7 = (long) r7     // Catch:{ all -> 0x0ccd }
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 <= 0) goto L_0x0381
            com.google.android.gms.measurement.internal.zzet r5 = r40.zzaA()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzer r5 = r5.zzk()     // Catch:{ all -> 0x0ccd }
            java.lang.String r6 = "Too many conversions. Not logging as conversion. appId"
            com.google.android.gms.internal.measurement.zzgd r7 = r4.zza     // Catch:{ all -> 0x0ccd }
            java.lang.String r7 = r7.zzy()     // Catch:{ all -> 0x0ccd }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzet.zzn(r7)     // Catch:{ all -> 0x0ccd }
            r5.zzb(r6, r7)     // Catch:{ all -> 0x0ccd }
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = -1
        L_0x031d:
            int r9 = r12.zza()     // Catch:{ all -> 0x0ccd }
            if (r6 >= r9) goto L_0x0347
            com.google.android.gms.internal.measurement.zzfx r9 = r12.zzn(r6)     // Catch:{ all -> 0x0ccd }
            java.lang.String r14 = r9.zzg()     // Catch:{ all -> 0x0ccd }
            boolean r14 = r3.equals(r14)     // Catch:{ all -> 0x0ccd }
            if (r14 == 0) goto L_0x0339
            com.google.android.gms.internal.measurement.zzkx r5 = r9.zzbB()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzfw r5 = (com.google.android.gms.internal.measurement.zzfw) r5     // Catch:{ all -> 0x0ccd }
            r8 = r6
            goto L_0x0344
        L_0x0339:
            java.lang.String r9 = r9.zzg()     // Catch:{ all -> 0x0ccd }
            boolean r9 = r13.equals(r9)     // Catch:{ all -> 0x0ccd }
            if (r9 == 0) goto L_0x0344
            r7 = 1
        L_0x0344:
            int r6 = r6 + 1
            goto L_0x031d
        L_0x0347:
            if (r7 == 0) goto L_0x0350
            if (r5 == 0) goto L_0x034f
            r12.zzh(r8)     // Catch:{ all -> 0x0ccd }
            goto L_0x0381
        L_0x034f:
            r5 = 0
        L_0x0350:
            if (r5 == 0) goto L_0x036a
            com.google.android.gms.internal.measurement.zzkx r5 = r5.zzav()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzfw r5 = (com.google.android.gms.internal.measurement.zzfw) r5     // Catch:{ all -> 0x0ccd }
            r5.zzj(r13)     // Catch:{ all -> 0x0ccd }
            r6 = 10
            r5.zzi(r6)     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzlb r5 = r5.zzaD()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzfx r5 = (com.google.android.gms.internal.measurement.zzfx) r5     // Catch:{ all -> 0x0ccd }
            r12.zzk(r8, r5)     // Catch:{ all -> 0x0ccd }
            goto L_0x0381
        L_0x036a:
            com.google.android.gms.measurement.internal.zzet r5 = r40.zzaA()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzer r5 = r5.zzd()     // Catch:{ all -> 0x0ccd }
            java.lang.String r6 = "Did not find conversion parameter. appId"
            com.google.android.gms.internal.measurement.zzgd r7 = r4.zza     // Catch:{ all -> 0x0ccd }
            java.lang.String r7 = r7.zzy()     // Catch:{ all -> 0x0ccd }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzet.zzn(r7)     // Catch:{ all -> 0x0ccd }
            r5.zzb(r6, r7)     // Catch:{ all -> 0x0ccd }
        L_0x0381:
            if (r2 == 0) goto L_0x043b
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0ccd }
            java.util.List r5 = r12.zzp()     // Catch:{ all -> 0x0ccd }
            r2.<init>(r5)     // Catch:{ all -> 0x0ccd }
            r5 = 0
            r6 = -1
            r7 = -1
        L_0x038f:
            int r8 = r2.size()     // Catch:{ all -> 0x0ccd }
            java.lang.String r9 = "currency"
            java.lang.String r13 = "value"
            if (r5 >= r8) goto L_0x03c0
            java.lang.Object r8 = r2.get(r5)     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzfx r8 = (com.google.android.gms.internal.measurement.zzfx) r8     // Catch:{ all -> 0x0ccd }
            java.lang.String r8 = r8.zzg()     // Catch:{ all -> 0x0ccd }
            boolean r8 = r13.equals(r8)     // Catch:{ all -> 0x0ccd }
            if (r8 == 0) goto L_0x03ac
            r6 = r5
            goto L_0x03bd
        L_0x03ac:
            java.lang.Object r8 = r2.get(r5)     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzfx r8 = (com.google.android.gms.internal.measurement.zzfx) r8     // Catch:{ all -> 0x0ccd }
            java.lang.String r8 = r8.zzg()     // Catch:{ all -> 0x0ccd }
            boolean r8 = r9.equals(r8)     // Catch:{ all -> 0x0ccd }
            if (r8 == 0) goto L_0x03bd
            r7 = r5
        L_0x03bd:
            int r5 = r5 + 1
            goto L_0x038f
        L_0x03c0:
            r5 = -1
            if (r6 != r5) goto L_0x03c5
            goto L_0x043c
        L_0x03c5:
            java.lang.Object r5 = r2.get(r6)     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzfx r5 = (com.google.android.gms.internal.measurement.zzfx) r5     // Catch:{ all -> 0x0ccd }
            boolean r5 = r5.zzw()     // Catch:{ all -> 0x0ccd }
            if (r5 != 0) goto L_0x03f6
            java.lang.Object r5 = r2.get(r6)     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzfx r5 = (com.google.android.gms.internal.measurement.zzfx) r5     // Catch:{ all -> 0x0ccd }
            boolean r5 = r5.zzu()     // Catch:{ all -> 0x0ccd }
            if (r5 != 0) goto L_0x03f6
            com.google.android.gms.measurement.internal.zzet r2 = r40.zzaA()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzl()     // Catch:{ all -> 0x0ccd }
            java.lang.String r5 = "Value must be specified with a numeric type."
            r2.zza(r5)     // Catch:{ all -> 0x0ccd }
            r12.zzh(r6)     // Catch:{ all -> 0x0ccd }
            zzab(r12, r3)     // Catch:{ all -> 0x0ccd }
            r2 = 18
            zzaa(r12, r2, r13)     // Catch:{ all -> 0x0ccd }
            goto L_0x043b
        L_0x03f6:
            r5 = -1
            if (r7 != r5) goto L_0x03fa
            goto L_0x0422
        L_0x03fa:
            java.lang.Object r2 = r2.get(r7)     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzfx r2 = (com.google.android.gms.internal.measurement.zzfx) r2     // Catch:{ all -> 0x0ccd }
            java.lang.String r2 = r2.zzh()     // Catch:{ all -> 0x0ccd }
            int r7 = r2.length()     // Catch:{ all -> 0x0ccd }
            r8 = 3
            if (r7 != r8) goto L_0x0422
            r7 = 0
        L_0x040c:
            int r8 = r2.length()     // Catch:{ all -> 0x0ccd }
            if (r7 >= r8) goto L_0x043c
            int r8 = r2.codePointAt(r7)     // Catch:{ all -> 0x0ccd }
            boolean r13 = java.lang.Character.isLetter(r8)     // Catch:{ all -> 0x0ccd }
            if (r13 == 0) goto L_0x0422
            int r8 = java.lang.Character.charCount(r8)     // Catch:{ all -> 0x0ccd }
            int r7 = r7 + r8
            goto L_0x040c
        L_0x0422:
            com.google.android.gms.measurement.internal.zzet r2 = r40.zzaA()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzl()     // Catch:{ all -> 0x0ccd }
            java.lang.String r7 = "Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter."
            r2.zza(r7)     // Catch:{ all -> 0x0ccd }
            r12.zzh(r6)     // Catch:{ all -> 0x0ccd }
            zzab(r12, r3)     // Catch:{ all -> 0x0ccd }
            r2 = 19
            zzaa(r12, r2, r9)     // Catch:{ all -> 0x0ccd }
            goto L_0x043c
        L_0x043b:
            r5 = -1
        L_0x043c:
            java.lang.String r2 = r12.zzo()     // Catch:{ all -> 0x0ccd }
            boolean r2 = r10.equals(r2)     // Catch:{ all -> 0x0ccd }
            r6 = 1000(0x3e8, double:4.94E-321)
            if (r2 == 0) goto L_0x048a
            com.google.android.gms.measurement.internal.zzlj r2 = r1.zzi     // Catch:{ all -> 0x0ccd }
            zzal(r2)     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzlb r2 = r12.zzaD()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzft r2 = (com.google.android.gms.internal.measurement.zzft) r2     // Catch:{ all -> 0x0ccd }
            r3 = r25
            com.google.android.gms.internal.measurement.zzfx r2 = com.google.android.gms.measurement.internal.zzlj.zzC(r2, r3)     // Catch:{ all -> 0x0ccd }
            if (r2 != 0) goto L_0x04d6
            if (r18 == 0) goto L_0x0483
            long r2 = r18.zzc()     // Catch:{ all -> 0x0ccd }
            long r8 = r12.zzc()     // Catch:{ all -> 0x0ccd }
            long r2 = r2 - r8
            long r2 = java.lang.Math.abs(r2)     // Catch:{ all -> 0x0ccd }
            int r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r2 > 0) goto L_0x0483
            com.google.android.gms.internal.measurement.zzkx r2 = r18.zzav()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzfs r2 = (com.google.android.gms.internal.measurement.zzfs) r2     // Catch:{ all -> 0x0ccd }
            boolean r3 = r1.zzaj(r12, r2)     // Catch:{ all -> 0x0ccd }
            if (r3 == 0) goto L_0x0483
            r11.zzS(r15, r2)     // Catch:{ all -> 0x0ccd }
            r13 = r17
        L_0x047f:
            r14 = 0
            r23 = 0
            goto L_0x04db
        L_0x0483:
            r23 = r12
            r14 = r18
            r13 = r20
            goto L_0x04db
        L_0x048a:
            java.lang.String r2 = "_vs"
            java.lang.String r3 = r12.zzo()     // Catch:{ all -> 0x0ccd }
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0ccd }
            if (r2 == 0) goto L_0x04d6
            com.google.android.gms.measurement.internal.zzlj r2 = r1.zzi     // Catch:{ all -> 0x0ccd }
            zzal(r2)     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzlb r2 = r12.zzaD()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzft r2 = (com.google.android.gms.internal.measurement.zzft) r2     // Catch:{ all -> 0x0ccd }
            r8 = r24
            com.google.android.gms.internal.measurement.zzfx r2 = com.google.android.gms.measurement.internal.zzlj.zzC(r2, r8)     // Catch:{ all -> 0x0ccd }
            if (r2 != 0) goto L_0x04d6
            if (r23 == 0) goto L_0x04cf
            long r2 = r23.zzc()     // Catch:{ all -> 0x0ccd }
            long r8 = r12.zzc()     // Catch:{ all -> 0x0ccd }
            long r2 = r2 - r8
            long r2 = java.lang.Math.abs(r2)     // Catch:{ all -> 0x0ccd }
            int r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r2 > 0) goto L_0x04cf
            com.google.android.gms.internal.measurement.zzkx r2 = r23.zzav()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzfs r2 = (com.google.android.gms.internal.measurement.zzfs) r2     // Catch:{ all -> 0x0ccd }
            boolean r3 = r1.zzaj(r2, r12)     // Catch:{ all -> 0x0ccd }
            if (r3 == 0) goto L_0x04cf
            r7 = r17
            r11.zzS(r7, r2)     // Catch:{ all -> 0x0ccd }
            r13 = r7
            goto L_0x047f
        L_0x04cf:
            r7 = r17
            r13 = r7
            r14 = r12
            r15 = r20
            goto L_0x04db
        L_0x04d6:
            r7 = r17
            r13 = r7
            r14 = r18
        L_0x04db:
            java.util.List r2 = r4.zzc     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzlb r3 = r12.zzaD()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzft r3 = (com.google.android.gms.internal.measurement.zzft) r3     // Catch:{ all -> 0x0ccd }
            r6 = r22
            r2.set(r6, r3)     // Catch:{ all -> 0x0ccd }
            int r9 = r20 + 1
            r11.zzk(r12)     // Catch:{ all -> 0x0ccd }
            r10 = r16
        L_0x04ef:
            int r8 = r6 + 1
            r5 = r11
            r2 = r19
            r3 = r21
            r11 = r23
            goto L_0x0040
        L_0x04fa:
            r19 = r2
            r11 = r5
            r3 = r6
            r8 = r7
            r20 = r9
            r5 = 0
            r12 = r5
            r2 = 0
        L_0x0505:
            if (r2 >= r9) goto L_0x0555
            com.google.android.gms.internal.measurement.zzft r7 = r11.zze(r2)     // Catch:{ all -> 0x0ccd }
            java.lang.String r14 = r7.zzh()     // Catch:{ all -> 0x0ccd }
            boolean r14 = r10.equals(r14)     // Catch:{ all -> 0x0ccd }
            if (r14 == 0) goto L_0x0528
            com.google.android.gms.measurement.internal.zzlj r14 = r1.zzi     // Catch:{ all -> 0x0ccd }
            zzal(r14)     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzfx r14 = com.google.android.gms.measurement.internal.zzlj.zzC(r7, r3)     // Catch:{ all -> 0x0ccd }
            if (r14 == 0) goto L_0x0528
            r11.zzA(r2)     // Catch:{ all -> 0x0ccd }
            int r9 = r9 + -1
            int r2 = r2 + -1
            goto L_0x0552
        L_0x0528:
            com.google.android.gms.measurement.internal.zzlj r14 = r1.zzi     // Catch:{ all -> 0x0ccd }
            zzal(r14)     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzfx r7 = com.google.android.gms.measurement.internal.zzlj.zzC(r7, r8)     // Catch:{ all -> 0x0ccd }
            if (r7 == 0) goto L_0x0552
            boolean r14 = r7.zzw()     // Catch:{ all -> 0x0ccd }
            if (r14 == 0) goto L_0x0542
            long r14 = r7.zzd()     // Catch:{ all -> 0x0ccd }
            java.lang.Long r7 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x0ccd }
            goto L_0x0543
        L_0x0542:
            r7 = 0
        L_0x0543:
            if (r7 == 0) goto L_0x0552
            long r14 = r7.longValue()     // Catch:{ all -> 0x0ccd }
            int r14 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r14 <= 0) goto L_0x0552
            long r14 = r7.longValue()     // Catch:{ all -> 0x0ccd }
            long r12 = r12 + r14
        L_0x0552:
            r7 = 1
            int r2 = r2 + r7
            goto L_0x0505
        L_0x0555:
            r2 = 0
            r1.zzaf(r11, r12, r2)     // Catch:{ all -> 0x0ccd }
            java.util.List r2 = r11.zzat()     // Catch:{ all -> 0x0ccd }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0ccd }
        L_0x0561:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0ccd }
            java.lang.String r7 = "_se"
            if (r3 == 0) goto L_0x0587
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzft r3 = (com.google.android.gms.internal.measurement.zzft) r3     // Catch:{ all -> 0x0ccd }
            java.lang.String r8 = "_s"
            java.lang.String r3 = r3.zzh()     // Catch:{ all -> 0x0ccd }
            boolean r3 = r8.equals(r3)     // Catch:{ all -> 0x0ccd }
            if (r3 == 0) goto L_0x0561
            com.google.android.gms.measurement.internal.zzak r2 = r1.zze     // Catch:{ all -> 0x0ccd }
            zzal(r2)     // Catch:{ all -> 0x0ccd }
            java.lang.String r3 = r11.zzaq()     // Catch:{ all -> 0x0ccd }
            r2.zzA(r3, r7)     // Catch:{ all -> 0x0ccd }
        L_0x0587:
            java.lang.String r2 = "_sid"
            int r2 = com.google.android.gms.measurement.internal.zzlj.zza(r11, r2)     // Catch:{ all -> 0x0ccd }
            if (r2 < 0) goto L_0x0594
            r2 = 1
            r1.zzaf(r11, r12, r2)     // Catch:{ all -> 0x0ccd }
            goto L_0x05b4
        L_0x0594:
            int r2 = com.google.android.gms.measurement.internal.zzlj.zza(r11, r7)     // Catch:{ all -> 0x0ccd }
            if (r2 < 0) goto L_0x05b4
            r11.zzB(r2)     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzet r2 = r40.zzaA()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzd()     // Catch:{ all -> 0x0ccd }
            java.lang.String r3 = "Session engagement user property is in the bundle without session ID. appId"
            com.google.android.gms.internal.measurement.zzgd r7 = r4.zza     // Catch:{ all -> 0x0ccd }
            java.lang.String r7 = r7.zzy()     // Catch:{ all -> 0x0ccd }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzet.zzn(r7)     // Catch:{ all -> 0x0ccd }
            r2.zzb(r3, r7)     // Catch:{ all -> 0x0ccd }
        L_0x05b4:
            com.google.android.gms.measurement.internal.zzlj r2 = r1.zzi     // Catch:{ all -> 0x0ccd }
            zzal(r2)     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzgd r3 = r2.zzt     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzet r3 = r3.zzaA()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzer r3 = r3.zzj()     // Catch:{ all -> 0x0ccd }
            java.lang.String r7 = "Checking account type status for ad personalization signals"
            r3.zza(r7)     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzlh r3 = r2.zzf     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzfu r3 = r3.zzc     // Catch:{ all -> 0x0ccd }
            zzal(r3)     // Catch:{ all -> 0x0ccd }
            java.lang.String r7 = r11.zzaq()     // Catch:{ all -> 0x0ccd }
            boolean r3 = r3.zzn(r7)     // Catch:{ all -> 0x0ccd }
            if (r3 == 0) goto L_0x064b
            com.google.android.gms.measurement.internal.zzlh r3 = r2.zzf     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzak r3 = r3.zze     // Catch:{ all -> 0x0ccd }
            zzal(r3)     // Catch:{ all -> 0x0ccd }
            java.lang.String r7 = r11.zzaq()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzh r3 = r3.zzj(r7)     // Catch:{ all -> 0x0ccd }
            if (r3 == 0) goto L_0x064b
            boolean r3 = r3.zzam()     // Catch:{ all -> 0x0ccd }
            if (r3 == 0) goto L_0x064b
            com.google.android.gms.measurement.internal.zzgd r3 = r2.zzt     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzao r3 = r3.zzg()     // Catch:{ all -> 0x0ccd }
            boolean r3 = r3.zze()     // Catch:{ all -> 0x0ccd }
            if (r3 == 0) goto L_0x064b
            com.google.android.gms.measurement.internal.zzgd r3 = r2.zzt     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzet r3 = r3.zzaA()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzer r3 = r3.zzc()     // Catch:{ all -> 0x0ccd }
            java.lang.String r7 = "Turning off ad personalization due to account type"
            r3.zza(r7)     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzgl r3 = com.google.android.gms.internal.measurement.zzgm.zzd()     // Catch:{ all -> 0x0ccd }
            r7 = r19
            r3.zzf(r7)     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzgd r2 = r2.zzt     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzao r2 = r2.zzg()     // Catch:{ all -> 0x0ccd }
            long r8 = r2.zza()     // Catch:{ all -> 0x0ccd }
            r3.zzg(r8)     // Catch:{ all -> 0x0ccd }
            r8 = 1
            r3.zze(r8)     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzlb r2 = r3.zzaD()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzgm r2 = (com.google.android.gms.internal.measurement.zzgm) r2     // Catch:{ all -> 0x0ccd }
            r3 = 0
        L_0x062d:
            int r8 = r11.zzb()     // Catch:{ all -> 0x0ccd }
            if (r3 >= r8) goto L_0x0648
            com.google.android.gms.internal.measurement.zzgm r8 = r11.zzap(r3)     // Catch:{ all -> 0x0ccd }
            java.lang.String r8 = r8.zzf()     // Catch:{ all -> 0x0ccd }
            boolean r8 = r7.equals(r8)     // Catch:{ all -> 0x0ccd }
            if (r8 == 0) goto L_0x0645
            r11.zzan(r3, r2)     // Catch:{ all -> 0x0ccd }
            goto L_0x064b
        L_0x0645:
            int r3 = r3 + 1
            goto L_0x062d
        L_0x0648:
            r11.zzm(r2)     // Catch:{ all -> 0x0ccd }
        L_0x064b:
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r11.zzai(r2)     // Catch:{ all -> 0x0ccd }
            r2 = -9223372036854775808
            r11.zzQ(r2)     // Catch:{ all -> 0x0ccd }
            r2 = 0
        L_0x0659:
            int r3 = r11.zza()     // Catch:{ all -> 0x0ccd }
            if (r2 >= r3) goto L_0x068c
            com.google.android.gms.internal.measurement.zzft r3 = r11.zze(r2)     // Catch:{ all -> 0x0ccd }
            long r7 = r3.zzd()     // Catch:{ all -> 0x0ccd }
            long r9 = r11.zzd()     // Catch:{ all -> 0x0ccd }
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 >= 0) goto L_0x0676
            long r7 = r3.zzd()     // Catch:{ all -> 0x0ccd }
            r11.zzai(r7)     // Catch:{ all -> 0x0ccd }
        L_0x0676:
            long r7 = r3.zzd()     // Catch:{ all -> 0x0ccd }
            long r9 = r11.zzc()     // Catch:{ all -> 0x0ccd }
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 <= 0) goto L_0x0689
            long r7 = r3.zzd()     // Catch:{ all -> 0x0ccd }
            r11.zzQ(r7)     // Catch:{ all -> 0x0ccd }
        L_0x0689:
            int r2 = r2 + 1
            goto L_0x0659
        L_0x068c:
            r11.zzz()     // Catch:{ all -> 0x0ccd }
            r11.zzo()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzaa r2 = r1.zzh     // Catch:{ all -> 0x0ccd }
            zzal(r2)     // Catch:{ all -> 0x0ccd }
            java.lang.String r20 = r11.zzaq()     // Catch:{ all -> 0x0ccd }
            java.util.List r21 = r11.zzat()     // Catch:{ all -> 0x0ccd }
            java.util.List r22 = r11.zzau()     // Catch:{ all -> 0x0ccd }
            long r7 = r11.zzd()     // Catch:{ all -> 0x0ccd }
            java.lang.Long r23 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0ccd }
            long r7 = r11.zzc()     // Catch:{ all -> 0x0ccd }
            java.lang.Long r24 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0ccd }
            r19 = r2
            java.util.List r2 = r19.zza(r20, r21, r22, r23, r24)     // Catch:{ all -> 0x0ccd }
            r11.zzf(r2)     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzag r2 = r40.zzg()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzgd r3 = r4.zza     // Catch:{ all -> 0x0ccd }
            java.lang.String r3 = r3.zzy()     // Catch:{ all -> 0x0ccd }
            boolean r2 = r2.zzw(r3)     // Catch:{ all -> 0x0ccd }
            if (r2 == 0) goto L_0x0a08
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ all -> 0x0ccd }
            r2.<init>()     // Catch:{ all -> 0x0ccd }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x0ccd }
            r3.<init>()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzlp r7 = r40.zzv()     // Catch:{ all -> 0x0ccd }
            java.security.SecureRandom r7 = r7.zzG()     // Catch:{ all -> 0x0ccd }
            r8 = 0
        L_0x06df:
            int r9 = r11.zza()     // Catch:{ all -> 0x0ccd }
            if (r8 >= r9) goto L_0x09d2
            com.google.android.gms.internal.measurement.zzft r9 = r11.zze(r8)     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzkx r9 = r9.zzbB()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzfs r9 = (com.google.android.gms.internal.measurement.zzfs) r9     // Catch:{ all -> 0x0ccd }
            java.lang.String r10 = r9.zzo()     // Catch:{ all -> 0x0ccd }
            java.lang.String r12 = "_ep"
            boolean r10 = r10.equals(r12)     // Catch:{ all -> 0x0ccd }
            java.lang.String r12 = "_efs"
            java.lang.String r13 = "_sr"
            if (r10 == 0) goto L_0x0781
            com.google.android.gms.measurement.internal.zzlj r10 = r1.zzi     // Catch:{ all -> 0x0ccd }
            zzal(r10)     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzlb r10 = r9.zzaD()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzft r10 = (com.google.android.gms.internal.measurement.zzft) r10     // Catch:{ all -> 0x0ccd }
            java.lang.String r14 = "_en"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzlj.zzD(r10, r14)     // Catch:{ all -> 0x0ccd }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x0ccd }
            java.lang.Object r14 = r2.get(r10)     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzaq r14 = (com.google.android.gms.measurement.internal.zzaq) r14     // Catch:{ all -> 0x0ccd }
            if (r14 != 0) goto L_0x0736
            com.google.android.gms.measurement.internal.zzak r14 = r1.zze     // Catch:{ all -> 0x0ccd }
            zzal(r14)     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzgd r15 = r4.zza     // Catch:{ all -> 0x0ccd }
            java.lang.String r15 = r15.zzy()     // Catch:{ all -> 0x0ccd }
            java.lang.Object r17 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r10)     // Catch:{ all -> 0x0ccd }
            r5 = r17
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzaq r14 = r14.zzn(r15, r5)     // Catch:{ all -> 0x0ccd }
            if (r14 == 0) goto L_0x0736
            r2.put(r10, r14)     // Catch:{ all -> 0x0ccd }
        L_0x0736:
            if (r14 == 0) goto L_0x0775
            java.lang.Long r5 = r14.zzi     // Catch:{ all -> 0x0ccd }
            if (r5 != 0) goto L_0x0775
            java.lang.Long r5 = r14.zzj     // Catch:{ all -> 0x0ccd }
            if (r5 == 0) goto L_0x0754
            long r5 = r5.longValue()     // Catch:{ all -> 0x0ccd }
            r17 = 1
            int r5 = (r5 > r17 ? 1 : (r5 == r17 ? 0 : -1))
            if (r5 <= 0) goto L_0x0754
            com.google.android.gms.measurement.internal.zzlj r5 = r1.zzi     // Catch:{ all -> 0x0ccd }
            zzal(r5)     // Catch:{ all -> 0x0ccd }
            java.lang.Long r5 = r14.zzj     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzlj.zzA(r9, r13, r5)     // Catch:{ all -> 0x0ccd }
        L_0x0754:
            java.lang.Boolean r5 = r14.zzk     // Catch:{ all -> 0x0ccd }
            if (r5 == 0) goto L_0x076c
            boolean r5 = r5.booleanValue()     // Catch:{ all -> 0x0ccd }
            if (r5 == 0) goto L_0x076c
            com.google.android.gms.measurement.internal.zzlj r5 = r1.zzi     // Catch:{ all -> 0x0ccd }
            zzal(r5)     // Catch:{ all -> 0x0ccd }
            r5 = 1
            java.lang.Long r10 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzlj.zzA(r9, r12, r10)     // Catch:{ all -> 0x0ccd }
        L_0x076c:
            com.google.android.gms.internal.measurement.zzlb r5 = r9.zzaD()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzft r5 = (com.google.android.gms.internal.measurement.zzft) r5     // Catch:{ all -> 0x0ccd }
            r3.add(r5)     // Catch:{ all -> 0x0ccd }
        L_0x0775:
            r11.zzS(r8, r9)     // Catch:{ all -> 0x0ccd }
        L_0x0778:
            r10 = r3
            r21 = r7
            r5 = r11
            r7 = r2
            r2 = 1
            goto L_0x09c7
        L_0x0781:
            com.google.android.gms.measurement.internal.zzfu r5 = r1.zzc     // Catch:{ all -> 0x0ccd }
            zzal(r5)     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzgd r6 = r4.zza     // Catch:{ all -> 0x0ccd }
            java.lang.String r6 = r6.zzy()     // Catch:{ all -> 0x0ccd }
            java.lang.String r10 = "measurement.account.time_zone_offset_minutes"
            java.lang.String r10 = r5.zza(r6, r10)     // Catch:{ all -> 0x0ccd }
            boolean r14 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x0ccd }
            if (r14 != 0) goto L_0x07b2
            long r5 = java.lang.Long.parseLong(r10)     // Catch:{ NumberFormatException -> 0x079d }
            goto L_0x07b4
        L_0x079d:
            r0 = move-exception
            r10 = r0
            com.google.android.gms.measurement.internal.zzgd r5 = r5.zzt     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzet r5 = r5.zzaA()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzer r5 = r5.zzk()     // Catch:{ all -> 0x0ccd }
            java.lang.String r14 = "Unable to parse timezone offset. appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzet.zzn(r6)     // Catch:{ all -> 0x0ccd }
            r5.zzc(r14, r6, r10)     // Catch:{ all -> 0x0ccd }
        L_0x07b2:
            r5 = 0
        L_0x07b4:
            com.google.android.gms.measurement.internal.zzlp r10 = r40.zzv()     // Catch:{ all -> 0x0ccd }
            long r14 = r9.zzc()     // Catch:{ all -> 0x0ccd }
            long r14 = r10.zzr(r14, r5)     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzlb r10 = r9.zzaD()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzft r10 = (com.google.android.gms.internal.measurement.zzft) r10     // Catch:{ all -> 0x0ccd }
            r43 = r12
            r17 = 1
            java.lang.Long r12 = java.lang.Long.valueOf(r17)     // Catch:{ all -> 0x0ccd }
            r17 = r5
            java.lang.String r5 = "_dbg"
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0ccd }
            if (r6 != 0) goto L_0x080c
            java.util.List r6 = r10.zzi()     // Catch:{ all -> 0x0ccd }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x0ccd }
        L_0x07e0:
            boolean r10 = r6.hasNext()     // Catch:{ all -> 0x0ccd }
            if (r10 == 0) goto L_0x080c
            java.lang.Object r10 = r6.next()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzfx r10 = (com.google.android.gms.internal.measurement.zzfx) r10     // Catch:{ all -> 0x0ccd }
            r21 = r6
            java.lang.String r6 = r10.zzg()     // Catch:{ all -> 0x0ccd }
            boolean r6 = r5.equals(r6)     // Catch:{ all -> 0x0ccd }
            if (r6 == 0) goto L_0x0809
            long r5 = r10.zzd()     // Catch:{ all -> 0x0ccd }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0ccd }
            boolean r5 = r12.equals(r5)     // Catch:{ all -> 0x0ccd }
            if (r5 != 0) goto L_0x0807
            goto L_0x080c
        L_0x0807:
            r5 = 1
            goto L_0x081f
        L_0x0809:
            r6 = r21
            goto L_0x07e0
        L_0x080c:
            com.google.android.gms.measurement.internal.zzfu r5 = r1.zzc     // Catch:{ all -> 0x0ccd }
            zzal(r5)     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzgd r6 = r4.zza     // Catch:{ all -> 0x0ccd }
            java.lang.String r6 = r6.zzy()     // Catch:{ all -> 0x0ccd }
            java.lang.String r10 = r9.zzo()     // Catch:{ all -> 0x0ccd }
            int r5 = r5.zzc(r6, r10)     // Catch:{ all -> 0x0ccd }
        L_0x081f:
            if (r5 > 0) goto L_0x0844
            com.google.android.gms.measurement.internal.zzet r6 = r40.zzaA()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzer r6 = r6.zzk()     // Catch:{ all -> 0x0ccd }
            java.lang.String r10 = "Sample rate must be positive. event, rate"
            java.lang.String r12 = r9.zzo()     // Catch:{ all -> 0x0ccd }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0ccd }
            r6.zzc(r10, r12, r5)     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzlb r5 = r9.zzaD()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzft r5 = (com.google.android.gms.internal.measurement.zzft) r5     // Catch:{ all -> 0x0ccd }
            r3.add(r5)     // Catch:{ all -> 0x0ccd }
            r11.zzS(r8, r9)     // Catch:{ all -> 0x0ccd }
            goto L_0x0778
        L_0x0844:
            java.lang.String r6 = r9.zzo()     // Catch:{ all -> 0x0ccd }
            java.lang.Object r6 = r2.get(r6)     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzaq r6 = (com.google.android.gms.measurement.internal.zzaq) r6     // Catch:{ all -> 0x0ccd }
            if (r6 != 0) goto L_0x08a4
            com.google.android.gms.measurement.internal.zzak r6 = r1.zze     // Catch:{ all -> 0x0ccd }
            zzal(r6)     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzgd r10 = r4.zza     // Catch:{ all -> 0x0ccd }
            java.lang.String r10 = r10.zzy()     // Catch:{ all -> 0x0ccd }
            java.lang.String r12 = r9.zzo()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzaq r6 = r6.zzn(r10, r12)     // Catch:{ all -> 0x0ccd }
            if (r6 != 0) goto L_0x08a4
            com.google.android.gms.measurement.internal.zzet r6 = r40.zzaA()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzer r6 = r6.zzk()     // Catch:{ all -> 0x0ccd }
            java.lang.String r10 = "Event being bundled has no eventAggregate. appId, eventName"
            com.google.android.gms.internal.measurement.zzgd r12 = r4.zza     // Catch:{ all -> 0x0ccd }
            java.lang.String r12 = r12.zzy()     // Catch:{ all -> 0x0ccd }
            r21 = r14
            java.lang.String r14 = r9.zzo()     // Catch:{ all -> 0x0ccd }
            r6.zzc(r10, r12, r14)     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzaq r6 = new com.google.android.gms.measurement.internal.zzaq     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzgd r10 = r4.zza     // Catch:{ all -> 0x0ccd }
            java.lang.String r24 = r10.zzy()     // Catch:{ all -> 0x0ccd }
            java.lang.String r25 = r9.zzo()     // Catch:{ all -> 0x0ccd }
            r26 = 1
            r28 = 1
            r30 = 1
            long r32 = r9.zzc()     // Catch:{ all -> 0x0ccd }
            r34 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r23 = r6
            r23.<init>(r24, r25, r26, r28, r30, r32, r34, r36, r37, r38, r39)     // Catch:{ all -> 0x0ccd }
            goto L_0x08a6
        L_0x08a4:
            r21 = r14
        L_0x08a6:
            com.google.android.gms.measurement.internal.zzlj r10 = r1.zzi     // Catch:{ all -> 0x0ccd }
            zzal(r10)     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzlb r10 = r9.zzaD()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzft r10 = (com.google.android.gms.internal.measurement.zzft) r10     // Catch:{ all -> 0x0ccd }
            java.lang.String r12 = "_eid"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzlj.zzD(r10, r12)     // Catch:{ all -> 0x0ccd }
            java.lang.Long r10 = (java.lang.Long) r10     // Catch:{ all -> 0x0ccd }
            if (r10 == 0) goto L_0x08bd
            r12 = 1
            goto L_0x08be
        L_0x08bd:
            r12 = 0
        L_0x08be:
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r12)     // Catch:{ all -> 0x0ccd }
            r14 = 1
            if (r5 != r14) goto L_0x08f1
            com.google.android.gms.internal.measurement.zzlb r5 = r9.zzaD()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzft r5 = (com.google.android.gms.internal.measurement.zzft) r5     // Catch:{ all -> 0x0ccd }
            r3.add(r5)     // Catch:{ all -> 0x0ccd }
            boolean r5 = r12.booleanValue()     // Catch:{ all -> 0x0ccd }
            if (r5 == 0) goto L_0x08ec
            java.lang.Long r5 = r6.zzi     // Catch:{ all -> 0x0ccd }
            if (r5 != 0) goto L_0x08e0
            java.lang.Long r5 = r6.zzj     // Catch:{ all -> 0x0ccd }
            if (r5 != 0) goto L_0x08e0
            java.lang.Boolean r5 = r6.zzk     // Catch:{ all -> 0x0ccd }
            if (r5 == 0) goto L_0x08ec
        L_0x08e0:
            r5 = 0
            com.google.android.gms.measurement.internal.zzaq r6 = r6.zza(r5, r5, r5)     // Catch:{ all -> 0x0ccd }
            java.lang.String r5 = r9.zzo()     // Catch:{ all -> 0x0ccd }
            r2.put(r5, r6)     // Catch:{ all -> 0x0ccd }
        L_0x08ec:
            r11.zzS(r8, r9)     // Catch:{ all -> 0x0ccd }
            goto L_0x0778
        L_0x08f1:
            int r14 = r7.nextInt(r5)     // Catch:{ all -> 0x0ccd }
            if (r14 != 0) goto L_0x0932
            com.google.android.gms.measurement.internal.zzlj r10 = r1.zzi     // Catch:{ all -> 0x0ccd }
            zzal(r10)     // Catch:{ all -> 0x0ccd }
            long r14 = (long) r5     // Catch:{ all -> 0x0ccd }
            java.lang.Long r5 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzlj.zzA(r9, r13, r5)     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzlb r10 = r9.zzaD()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzft r10 = (com.google.android.gms.internal.measurement.zzft) r10     // Catch:{ all -> 0x0ccd }
            r3.add(r10)     // Catch:{ all -> 0x0ccd }
            boolean r10 = r12.booleanValue()     // Catch:{ all -> 0x0ccd }
            if (r10 == 0) goto L_0x0918
            r10 = 0
            com.google.android.gms.measurement.internal.zzaq r6 = r6.zza(r10, r5, r10)     // Catch:{ all -> 0x0ccd }
        L_0x0918:
            java.lang.String r5 = r9.zzo()     // Catch:{ all -> 0x0ccd }
            long r12 = r9.zzc()     // Catch:{ all -> 0x0ccd }
            r14 = r21
            com.google.android.gms.measurement.internal.zzaq r6 = r6.zzb(r12, r14)     // Catch:{ all -> 0x0ccd }
            r2.put(r5, r6)     // Catch:{ all -> 0x0ccd }
            r10 = r3
            r21 = r7
            r5 = r11
            r7 = r2
            r2 = 1
            goto L_0x09c4
        L_0x0932:
            r14 = r21
            r21 = r7
            java.lang.Long r7 = r6.zzh     // Catch:{ all -> 0x0ccd }
            if (r7 == 0) goto L_0x0947
            long r17 = r7.longValue()     // Catch:{ all -> 0x0ccd }
            r24 = r2
            r25 = r3
            r23 = r10
            r22 = r11
            goto L_0x095d
        L_0x0947:
            com.google.android.gms.measurement.internal.zzlp r7 = r40.zzv()     // Catch:{ all -> 0x0ccd }
            r23 = r10
            r22 = r11
            long r10 = r9.zzb()     // Catch:{ all -> 0x0ccd }
            r24 = r2
            r25 = r3
            r2 = r17
            long r17 = r7.zzr(r10, r2)     // Catch:{ all -> 0x0ccd }
        L_0x095d:
            int r2 = (r17 > r14 ? 1 : (r17 == r14 ? 0 : -1))
            if (r2 == 0) goto L_0x09a8
            com.google.android.gms.measurement.internal.zzlj r2 = r1.zzi     // Catch:{ all -> 0x0ccd }
            zzal(r2)     // Catch:{ all -> 0x0ccd }
            r2 = 1
            java.lang.Long r7 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x0ccd }
            r10 = r43
            com.google.android.gms.measurement.internal.zzlj.zzA(r9, r10, r7)     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzlj r7 = r1.zzi     // Catch:{ all -> 0x0ccd }
            zzal(r7)     // Catch:{ all -> 0x0ccd }
            long r10 = (long) r5     // Catch:{ all -> 0x0ccd }
            java.lang.Long r5 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzlj.zzA(r9, r13, r5)     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzlb r7 = r9.zzaD()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzft r7 = (com.google.android.gms.internal.measurement.zzft) r7     // Catch:{ all -> 0x0ccd }
            r10 = r25
            r10.add(r7)     // Catch:{ all -> 0x0ccd }
            boolean r7 = r12.booleanValue()     // Catch:{ all -> 0x0ccd }
            if (r7 == 0) goto L_0x0996
            java.lang.Boolean r7 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0ccd }
            r11 = 0
            com.google.android.gms.measurement.internal.zzaq r6 = r6.zza(r11, r5, r7)     // Catch:{ all -> 0x0ccd }
        L_0x0996:
            java.lang.String r5 = r9.zzo()     // Catch:{ all -> 0x0ccd }
            long r11 = r9.zzc()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzaq r6 = r6.zzb(r11, r14)     // Catch:{ all -> 0x0ccd }
            r7 = r24
            r7.put(r5, r6)     // Catch:{ all -> 0x0ccd }
            goto L_0x09c2
        L_0x09a8:
            r7 = r24
            r10 = r25
            r2 = 1
            boolean r5 = r12.booleanValue()     // Catch:{ all -> 0x0ccd }
            if (r5 == 0) goto L_0x09c2
            java.lang.String r5 = r9.zzo()     // Catch:{ all -> 0x0ccd }
            r11 = r23
            r12 = 0
            com.google.android.gms.measurement.internal.zzaq r6 = r6.zza(r11, r12, r12)     // Catch:{ all -> 0x0ccd }
            r7.put(r5, r6)     // Catch:{ all -> 0x0ccd }
        L_0x09c2:
            r5 = r22
        L_0x09c4:
            r5.zzS(r8, r9)     // Catch:{ all -> 0x0ccd }
        L_0x09c7:
            int r8 = r8 + 1
            r11 = r5
            r2 = r7
            r3 = r10
            r7 = r21
            r5 = 0
            goto L_0x06df
        L_0x09d2:
            r7 = r2
            r10 = r3
            r5 = r11
            int r2 = r10.size()     // Catch:{ all -> 0x0ccd }
            int r3 = r5.zza()     // Catch:{ all -> 0x0ccd }
            if (r2 >= r3) goto L_0x09e5
            r5.zzr()     // Catch:{ all -> 0x0ccd }
            r5.zzg(r10)     // Catch:{ all -> 0x0ccd }
        L_0x09e5:
            java.util.Set r2 = r7.entrySet()     // Catch:{ all -> 0x0ccd }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0ccd }
        L_0x09ed:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0ccd }
            if (r3 == 0) goto L_0x0a09
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0ccd }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzak r6 = r1.zze     // Catch:{ all -> 0x0ccd }
            zzal(r6)     // Catch:{ all -> 0x0ccd }
            java.lang.Object r3 = r3.getValue()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzaq r3 = (com.google.android.gms.measurement.internal.zzaq) r3     // Catch:{ all -> 0x0ccd }
            r6.zzE(r3)     // Catch:{ all -> 0x0ccd }
            goto L_0x09ed
        L_0x0a08:
            r5 = r11
        L_0x0a09:
            com.google.android.gms.internal.measurement.zzgd r2 = r4.zza     // Catch:{ all -> 0x0ccd }
            java.lang.String r2 = r2.zzy()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzak r3 = r1.zze     // Catch:{ all -> 0x0ccd }
            zzal(r3)     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzh r3 = r3.zzj(r2)     // Catch:{ all -> 0x0ccd }
            if (r3 != 0) goto L_0x0a32
            com.google.android.gms.measurement.internal.zzet r3 = r40.zzaA()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzer r3 = r3.zzd()     // Catch:{ all -> 0x0ccd }
            java.lang.String r6 = "Bundling raw events w/o app info. appId"
            com.google.android.gms.internal.measurement.zzgd r7 = r4.zza     // Catch:{ all -> 0x0ccd }
            java.lang.String r7 = r7.zzy()     // Catch:{ all -> 0x0ccd }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzet.zzn(r7)     // Catch:{ all -> 0x0ccd }
            r3.zzb(r6, r7)     // Catch:{ all -> 0x0ccd }
            goto L_0x0a8e
        L_0x0a32:
            int r6 = r5.zza()     // Catch:{ all -> 0x0ccd }
            if (r6 <= 0) goto L_0x0a8e
            long r6 = r3.zzn()     // Catch:{ all -> 0x0ccd }
            r8 = 0
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x0a46
            r5.zzab(r6)     // Catch:{ all -> 0x0ccd }
            goto L_0x0a49
        L_0x0a46:
            r5.zzv()     // Catch:{ all -> 0x0ccd }
        L_0x0a49:
            long r8 = r3.zzp()     // Catch:{ all -> 0x0ccd }
            r10 = 0
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 != 0) goto L_0x0a54
            goto L_0x0a55
        L_0x0a54:
            r6 = r8
        L_0x0a55:
            int r8 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r8 == 0) goto L_0x0a5d
            r5.zzac(r6)     // Catch:{ all -> 0x0ccd }
            goto L_0x0a60
        L_0x0a5d:
            r5.zzw()     // Catch:{ all -> 0x0ccd }
        L_0x0a60:
            r3.zzG()     // Catch:{ all -> 0x0ccd }
            long r6 = r3.zzo()     // Catch:{ all -> 0x0ccd }
            int r6 = (int) r6     // Catch:{ all -> 0x0ccd }
            r5.zzI(r6)     // Catch:{ all -> 0x0ccd }
            long r6 = r5.zzd()     // Catch:{ all -> 0x0ccd }
            r3.zzad(r6)     // Catch:{ all -> 0x0ccd }
            long r6 = r5.zzc()     // Catch:{ all -> 0x0ccd }
            r3.zzab(r6)     // Catch:{ all -> 0x0ccd }
            java.lang.String r6 = r3.zzu()     // Catch:{ all -> 0x0ccd }
            if (r6 == 0) goto L_0x0a83
            r5.zzW(r6)     // Catch:{ all -> 0x0ccd }
            goto L_0x0a86
        L_0x0a83:
            r5.zzs()     // Catch:{ all -> 0x0ccd }
        L_0x0a86:
            com.google.android.gms.measurement.internal.zzak r6 = r1.zze     // Catch:{ all -> 0x0ccd }
            zzal(r6)     // Catch:{ all -> 0x0ccd }
            r6.zzD(r3)     // Catch:{ all -> 0x0ccd }
        L_0x0a8e:
            int r3 = r5.zza()     // Catch:{ all -> 0x0ccd }
            if (r3 <= 0) goto L_0x0c12
            com.google.android.gms.measurement.internal.zzgd r3 = r1.zzn     // Catch:{ all -> 0x0ccd }
            r3.zzay()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzfu r3 = r1.zzc     // Catch:{ all -> 0x0ccd }
            zzal(r3)     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzgd r6 = r4.zza     // Catch:{ all -> 0x0ccd }
            java.lang.String r6 = r6.zzy()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzff r3 = r3.zze(r6)     // Catch:{ all -> 0x0ccd }
            r6 = -1
            if (r3 == 0) goto L_0x0abb
            boolean r8 = r3.zzu()     // Catch:{ all -> 0x0ccd }
            if (r8 != 0) goto L_0x0ab3
            goto L_0x0abb
        L_0x0ab3:
            long r8 = r3.zzc()     // Catch:{ all -> 0x0ccd }
            r5.zzK(r8)     // Catch:{ all -> 0x0ccd }
            goto L_0x0ae2
        L_0x0abb:
            com.google.android.gms.internal.measurement.zzgd r3 = r4.zza     // Catch:{ all -> 0x0ccd }
            java.lang.String r3 = r3.zzG()     // Catch:{ all -> 0x0ccd }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x0ccd }
            if (r3 == 0) goto L_0x0acb
            r5.zzK(r6)     // Catch:{ all -> 0x0ccd }
            goto L_0x0ae2
        L_0x0acb:
            com.google.android.gms.measurement.internal.zzet r3 = r40.zzaA()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzer r3 = r3.zzk()     // Catch:{ all -> 0x0ccd }
            java.lang.String r8 = "Did not find measurement config or missing version info. appId"
            com.google.android.gms.internal.measurement.zzgd r9 = r4.zza     // Catch:{ all -> 0x0ccd }
            java.lang.String r9 = r9.zzy()     // Catch:{ all -> 0x0ccd }
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzet.zzn(r9)     // Catch:{ all -> 0x0ccd }
            r3.zzb(r8, r9)     // Catch:{ all -> 0x0ccd }
        L_0x0ae2:
            com.google.android.gms.measurement.internal.zzak r3 = r1.zze     // Catch:{ all -> 0x0ccd }
            zzal(r3)     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzlb r5 = r5.zzaD()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.internal.measurement.zzgd r5 = (com.google.android.gms.internal.measurement.zzgd) r5     // Catch:{ all -> 0x0ccd }
            r3.zzg()     // Catch:{ all -> 0x0ccd }
            r3.zzW()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)     // Catch:{ all -> 0x0ccd }
            java.lang.String r8 = r5.zzy()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)     // Catch:{ all -> 0x0ccd }
            boolean r8 = r5.zzbg()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.common.internal.Preconditions.checkState(r8)     // Catch:{ all -> 0x0ccd }
            r3.zzz()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzgd r8 = r3.zzt     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.common.util.Clock r8 = r8.zzax()     // Catch:{ all -> 0x0ccd }
            long r8 = r8.currentTimeMillis()     // Catch:{ all -> 0x0ccd }
            long r10 = r5.zzk()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzgd r12 = r3.zzt     // Catch:{ all -> 0x0ccd }
            r12.zzf()     // Catch:{ all -> 0x0ccd }
            long r12 = com.google.android.gms.measurement.internal.zzag.zzA()     // Catch:{ all -> 0x0ccd }
            long r12 = r8 - r12
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 < 0) goto L_0x0b36
            long r10 = r5.zzk()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzgd r12 = r3.zzt     // Catch:{ all -> 0x0ccd }
            r12.zzf()     // Catch:{ all -> 0x0ccd }
            long r12 = com.google.android.gms.measurement.internal.zzag.zzA()     // Catch:{ all -> 0x0ccd }
            long r12 = r12 + r8
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 <= 0) goto L_0x0b59
        L_0x0b36:
            com.google.android.gms.measurement.internal.zzgd r10 = r3.zzt     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzet r10 = r10.zzaA()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzer r10 = r10.zzk()     // Catch:{ all -> 0x0ccd }
            java.lang.String r11 = "Storing bundle outside of the max uploading time span. appId, now, timestamp"
            java.lang.String r12 = r5.zzy()     // Catch:{ all -> 0x0ccd }
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzet.zzn(r12)     // Catch:{ all -> 0x0ccd }
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x0ccd }
            long r13 = r5.zzk()     // Catch:{ all -> 0x0ccd }
            java.lang.Long r9 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x0ccd }
            r10.zzd(r11, r12, r8, r9)     // Catch:{ all -> 0x0ccd }
        L_0x0b59:
            byte[] r8 = r5.zzbx()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzlh r9 = r3.zzf     // Catch:{ IOException -> 0x0bf9 }
            com.google.android.gms.measurement.internal.zzlj r9 = r9.zzi     // Catch:{ IOException -> 0x0bf9 }
            zzal(r9)     // Catch:{ IOException -> 0x0bf9 }
            byte[] r8 = r9.zzz(r8)     // Catch:{ IOException -> 0x0bf9 }
            com.google.android.gms.measurement.internal.zzgd r9 = r3.zzt     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzet r9 = r9.zzaA()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzer r9 = r9.zzj()     // Catch:{ all -> 0x0ccd }
            java.lang.String r10 = "Saving bundle, size"
            int r11 = r8.length     // Catch:{ all -> 0x0ccd }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x0ccd }
            r9.zzb(r10, r11)     // Catch:{ all -> 0x0ccd }
            android.content.ContentValues r9 = new android.content.ContentValues     // Catch:{ all -> 0x0ccd }
            r9.<init>()     // Catch:{ all -> 0x0ccd }
            java.lang.String r10 = "app_id"
            java.lang.String r11 = r5.zzy()     // Catch:{ all -> 0x0ccd }
            r9.put(r10, r11)     // Catch:{ all -> 0x0ccd }
            java.lang.String r10 = "bundle_end_timestamp"
            long r11 = r5.zzk()     // Catch:{ all -> 0x0ccd }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0ccd }
            r9.put(r10, r11)     // Catch:{ all -> 0x0ccd }
            java.lang.String r10 = "data"
            r9.put(r10, r8)     // Catch:{ all -> 0x0ccd }
            java.lang.String r8 = "has_realtime"
            java.lang.Integer r10 = java.lang.Integer.valueOf(r16)     // Catch:{ all -> 0x0ccd }
            r9.put(r8, r10)     // Catch:{ all -> 0x0ccd }
            boolean r8 = r5.zzbm()     // Catch:{ all -> 0x0ccd }
            if (r8 == 0) goto L_0x0bb8
            java.lang.String r8 = "retry_count"
            int r10 = r5.zze()     // Catch:{ all -> 0x0ccd }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0ccd }
            r9.put(r8, r10)     // Catch:{ all -> 0x0ccd }
        L_0x0bb8:
            android.database.sqlite.SQLiteDatabase r8 = r3.zzh()     // Catch:{ SQLiteException -> 0x0bdf }
            java.lang.String r10 = "queue"
            r11 = 0
            long r8 = r8.insert(r10, r11, r9)     // Catch:{ SQLiteException -> 0x0bdf }
            int r6 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r6 != 0) goto L_0x0c12
            com.google.android.gms.measurement.internal.zzgd r6 = r3.zzt     // Catch:{ SQLiteException -> 0x0bdf }
            com.google.android.gms.measurement.internal.zzet r6 = r6.zzaA()     // Catch:{ SQLiteException -> 0x0bdf }
            com.google.android.gms.measurement.internal.zzer r6 = r6.zzd()     // Catch:{ SQLiteException -> 0x0bdf }
            java.lang.String r7 = "Failed to insert bundle (got -1). appId"
            java.lang.String r8 = r5.zzy()     // Catch:{ SQLiteException -> 0x0bdf }
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzet.zzn(r8)     // Catch:{ SQLiteException -> 0x0bdf }
            r6.zzb(r7, r8)     // Catch:{ SQLiteException -> 0x0bdf }
            goto L_0x0c12
        L_0x0bdf:
            r0 = move-exception
            r6 = r0
            com.google.android.gms.measurement.internal.zzgd r3 = r3.zzt     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzet r3 = r3.zzaA()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzer r3 = r3.zzd()     // Catch:{ all -> 0x0ccd }
            java.lang.String r7 = "Error storing bundle. appId"
            java.lang.String r5 = r5.zzy()     // Catch:{ all -> 0x0ccd }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzet.zzn(r5)     // Catch:{ all -> 0x0ccd }
            r3.zzc(r7, r5, r6)     // Catch:{ all -> 0x0ccd }
            goto L_0x0c12
        L_0x0bf9:
            r0 = move-exception
            r6 = r0
            com.google.android.gms.measurement.internal.zzgd r3 = r3.zzt     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzet r3 = r3.zzaA()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzer r3 = r3.zzd()     // Catch:{ all -> 0x0ccd }
            java.lang.String r7 = "Data loss. Failed to serialize bundle. appId"
            java.lang.String r5 = r5.zzy()     // Catch:{ all -> 0x0ccd }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzet.zzn(r5)     // Catch:{ all -> 0x0ccd }
            r3.zzc(r7, r5, r6)     // Catch:{ all -> 0x0ccd }
        L_0x0c12:
            com.google.android.gms.measurement.internal.zzak r3 = r1.zze     // Catch:{ all -> 0x0ccd }
            zzal(r3)     // Catch:{ all -> 0x0ccd }
            java.util.List r4 = r4.zzb     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)     // Catch:{ all -> 0x0ccd }
            r3.zzg()     // Catch:{ all -> 0x0ccd }
            r3.zzW()     // Catch:{ all -> 0x0ccd }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0ccd }
            java.lang.String r6 = "rowid in ("
            r5.<init>(r6)     // Catch:{ all -> 0x0ccd }
            r6 = 0
        L_0x0c2a:
            int r7 = r4.size()     // Catch:{ all -> 0x0ccd }
            if (r6 >= r7) goto L_0x0c47
            if (r6 == 0) goto L_0x0c37
            java.lang.String r7 = ","
            r5.append(r7)     // Catch:{ all -> 0x0ccd }
        L_0x0c37:
            java.lang.Object r7 = r4.get(r6)     // Catch:{ all -> 0x0ccd }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ all -> 0x0ccd }
            long r7 = r7.longValue()     // Catch:{ all -> 0x0ccd }
            r5.append(r7)     // Catch:{ all -> 0x0ccd }
            int r6 = r6 + 1
            goto L_0x0c2a
        L_0x0c47:
            java.lang.String r6 = ")"
            r5.append(r6)     // Catch:{ all -> 0x0ccd }
            android.database.sqlite.SQLiteDatabase r6 = r3.zzh()     // Catch:{ all -> 0x0ccd }
            java.lang.String r7 = "raw_events"
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0ccd }
            r8 = 0
            int r5 = r6.delete(r7, r5, r8)     // Catch:{ all -> 0x0ccd }
            int r6 = r4.size()     // Catch:{ all -> 0x0ccd }
            if (r5 == r6) goto L_0x0c7c
            com.google.android.gms.measurement.internal.zzgd r3 = r3.zzt     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzet r3 = r3.zzaA()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzer r3 = r3.zzd()     // Catch:{ all -> 0x0ccd }
            java.lang.String r6 = "Deleted fewer rows from raw events table than expected"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0ccd }
            int r4 = r4.size()     // Catch:{ all -> 0x0ccd }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0ccd }
            r3.zzc(r6, r5, r4)     // Catch:{ all -> 0x0ccd }
        L_0x0c7c:
            com.google.android.gms.measurement.internal.zzak r3 = r1.zze     // Catch:{ all -> 0x0ccd }
            zzal(r3)     // Catch:{ all -> 0x0ccd }
            android.database.sqlite.SQLiteDatabase r4 = r3.zzh()     // Catch:{ all -> 0x0ccd }
            java.lang.String r5 = "delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)"
            r6 = 2
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x0c94 }
            r7 = 0
            r6[r7] = r2     // Catch:{ SQLiteException -> 0x0c94 }
            r7 = 1
            r6[r7] = r2     // Catch:{ SQLiteException -> 0x0c94 }
            r4.execSQL(r5, r6)     // Catch:{ SQLiteException -> 0x0c94 }
            goto L_0x0ca9
        L_0x0c94:
            r0 = move-exception
            r4 = r0
            com.google.android.gms.measurement.internal.zzgd r3 = r3.zzt     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzet r3 = r3.zzaA()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzer r3 = r3.zzd()     // Catch:{ all -> 0x0ccd }
            java.lang.String r5 = "Failed to remove unused event metadata. appId"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzet.zzn(r2)     // Catch:{ all -> 0x0ccd }
            r3.zzc(r5, r2, r4)     // Catch:{ all -> 0x0ccd }
        L_0x0ca9:
            com.google.android.gms.measurement.internal.zzak r2 = r1.zze     // Catch:{ all -> 0x0ccd }
            zzal(r2)     // Catch:{ all -> 0x0ccd }
            r2.zzC()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzak r2 = r1.zze
            zzal(r2)
            r2.zzx()
            r2 = 1
            return r2
        L_0x0cbb:
            com.google.android.gms.measurement.internal.zzak r2 = r1.zze     // Catch:{ all -> 0x0ccd }
            zzal(r2)     // Catch:{ all -> 0x0ccd }
            r2.zzC()     // Catch:{ all -> 0x0ccd }
            com.google.android.gms.measurement.internal.zzak r2 = r1.zze
            zzal(r2)
            r2.zzx()
            r2 = 0
            return r2
        L_0x0ccd:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.zzak r3 = r1.zze
            zzal(r3)
            r3.zzx()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzlh.zzah(java.lang.String, long):boolean");
    }

    private final boolean zzai() {
        zzaB().zzg();
        zzB();
        zzak zzak = this.zze;
        zzal(zzak);
        if (zzak.zzF()) {
            return true;
        }
        zzak zzak2 = this.zze;
        zzal(zzak2);
        return !TextUtils.isEmpty(zzak2.zzr());
    }

    private final boolean zzaj(zzfs zzfs, zzfs zzfs2) {
        String str;
        Preconditions.checkArgument("_e".equals(zzfs.zzo()));
        zzal(this.zzi);
        zzfx zzC2 = zzlj.zzC((zzft) zzfs.zzaD(), "_sc");
        String str2 = null;
        if (zzC2 == null) {
            str = null;
        } else {
            str = zzC2.zzh();
        }
        zzal(this.zzi);
        zzfx zzC3 = zzlj.zzC((zzft) zzfs2.zzaD(), "_pc");
        if (zzC3 != null) {
            str2 = zzC3.zzh();
        }
        if (str2 == null || !str2.equals(str)) {
            return false;
        }
        Preconditions.checkArgument("_e".equals(zzfs.zzo()));
        zzal(this.zzi);
        zzfx zzC4 = zzlj.zzC((zzft) zzfs.zzaD(), "_et");
        if (zzC4 == null || !zzC4.zzw() || zzC4.zzd() <= 0) {
            return true;
        }
        long zzd2 = zzC4.zzd();
        zzal(this.zzi);
        zzfx zzC5 = zzlj.zzC((zzft) zzfs2.zzaD(), "_et");
        if (zzC5 != null && zzC5.zzd() > 0) {
            zzd2 += zzC5.zzd();
        }
        zzal(this.zzi);
        zzlj.zzA(zzfs2, "_et", Long.valueOf(zzd2));
        zzal(this.zzi);
        zzlj.zzA(zzfs, "_fr", 1L);
        return true;
    }

    private static final boolean zzak(zzq zzq2) {
        return !TextUtils.isEmpty(zzq2.zzb) || !TextUtils.isEmpty(zzq2.zzq);
    }

    private static final zzku zzal(zzku zzku) {
        if (zzku == null) {
            throw new IllegalStateException("Upload Component not created");
        } else if (zzku.zzY()) {
            return zzku;
        } else {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(zzku.getClass())));
        }
    }

    public static zzlh zzt(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzb == null) {
            synchronized (zzlh.class) {
                if (zzb == null) {
                    zzb = new zzlh((zzli) Preconditions.checkNotNull(new zzli(context)), (zzgd) null);
                }
            }
        }
        return zzb;
    }

    public static /* bridge */ /* synthetic */ void zzy(zzlh zzlh, zzli zzli) {
        zzlh.zzaB().zzg();
        zzlh.zzm = new zzfl(zzlh);
        zzak zzak = new zzak(zzlh);
        zzak.zzX();
        zzlh.zze = zzak;
        zzlh.zzg().zzq((zzaf) Preconditions.checkNotNull(zzlh.zzc));
        zzkb zzkb = new zzkb(zzlh);
        zzkb.zzX();
        zzlh.zzk = zzkb;
        zzaa zzaa = new zzaa(zzlh);
        zzaa.zzX();
        zzlh.zzh = zzaa;
        zzip zzip = new zzip(zzlh);
        zzip.zzX();
        zzlh.zzj = zzip;
        zzks zzks = new zzks(zzlh);
        zzks.zzX();
        zzlh.zzg = zzks;
        zzlh.zzf = new zzfb(zzlh);
        if (zzlh.zzr != zzlh.zzs) {
            zzlh.zzaA().zzd().zzc("Not all upload components initialized", Integer.valueOf(zzlh.zzr), Integer.valueOf(zzlh.zzs));
        }
        zzlh.zzo = true;
    }

    public final void zzA() {
        zzaB().zzg();
        zzB();
        if (!this.zzp) {
            this.zzp = true;
            if (zzZ()) {
                FileChannel fileChannel = this.zzx;
                zzaB().zzg();
                int i11 = 0;
                if (fileChannel == null || !fileChannel.isOpen()) {
                    zzaA().zzd().zza("Bad channel to read from");
                } else {
                    ByteBuffer allocate = ByteBuffer.allocate(4);
                    try {
                        fileChannel.position(0);
                        int read = fileChannel.read(allocate);
                        if (read == 4) {
                            allocate.flip();
                            i11 = allocate.getInt();
                        } else if (read != -1) {
                            zzaA().zzk().zzb("Unexpected data length. Bytes read", Integer.valueOf(read));
                        }
                    } catch (IOException e11) {
                        zzaA().zzd().zzb("Failed to read from channel", e11);
                    }
                }
                int zzi2 = this.zzn.zzh().zzi();
                zzaB().zzg();
                if (i11 > zzi2) {
                    zzaA().zzd().zzc("Panic: can't downgrade version. Previous, current version", Integer.valueOf(i11), Integer.valueOf(zzi2));
                } else if (i11 < zzi2) {
                    FileChannel fileChannel2 = this.zzx;
                    zzaB().zzg();
                    if (fileChannel2 == null || !fileChannel2.isOpen()) {
                        zzaA().zzd().zza("Bad channel to read from");
                    } else {
                        ByteBuffer allocate2 = ByteBuffer.allocate(4);
                        allocate2.putInt(zzi2);
                        allocate2.flip();
                        try {
                            fileChannel2.truncate(0);
                            fileChannel2.write(allocate2);
                            fileChannel2.force(true);
                            if (fileChannel2.size() != 4) {
                                zzaA().zzd().zzb("Error writing to channel. Bytes written", Long.valueOf(fileChannel2.size()));
                            }
                            zzaA().zzj().zzc("Storage version upgraded. Previous, current version", Integer.valueOf(i11), Integer.valueOf(zzi2));
                            return;
                        } catch (IOException e12) {
                            zzaA().zzd().zzb("Failed to write to channel", e12);
                        }
                    }
                    zzaA().zzd().zzc("Storage version upgrade failed. Previous, current version", Integer.valueOf(i11), Integer.valueOf(zzi2));
                }
            }
        }
    }

    public final void zzB() {
        if (!this.zzo) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    public final void zzC(String str, zzgc zzgc) {
        int zza2;
        int indexOf;
        zzfu zzfu = this.zzc;
        zzal(zzfu);
        Set zzk2 = zzfu.zzk(str);
        if (zzk2 != null) {
            zzgc.zzi(zzk2);
        }
        zzfu zzfu2 = this.zzc;
        zzal(zzfu2);
        if (zzfu2.zzv(str)) {
            zzgc.zzp();
        }
        zzfu zzfu3 = this.zzc;
        zzal(zzfu3);
        if (zzfu3.zzy(str)) {
            if (zzg().zzs(str, zzeg.zzar)) {
                String zzas = zzgc.zzas();
                if (!TextUtils.isEmpty(zzas) && (indexOf = zzas.indexOf(InstructionFileId.DOT)) != -1) {
                    zzgc.zzY(zzas.substring(0, indexOf));
                }
            } else {
                zzgc.zzu();
            }
        }
        zzfu zzfu4 = this.zzc;
        zzal(zzfu4);
        if (zzfu4.zzz(str) && (zza2 = zzlj.zza(zzgc, "_id")) != -1) {
            zzgc.zzB(zza2);
        }
        zzfu zzfu5 = this.zzc;
        zzal(zzfu5);
        if (zzfu5.zzx(str)) {
            zzgc.zzq();
        }
        zzfu zzfu6 = this.zzc;
        zzal(zzfu6);
        if (zzfu6.zzu(str)) {
            zzgc.zzn();
            zzlg zzlg = (zzlg) this.zzC.get(str);
            if (zzlg == null || zzlg.zzb + zzg().zzi(str, zzeg.zzT) < zzax().elapsedRealtime()) {
                zzlg = new zzlg(this);
                this.zzC.put(str, zzlg);
            }
            zzgc.zzR(zzlg.zza);
        }
        zzfu zzfu7 = this.zzc;
        zzal(zzfu7);
        if (zzfu7.zzw(str)) {
            zzgc.zzy();
        }
    }

    public final void zzD(zzh zzh2) {
        zzaB().zzg();
        if (!TextUtils.isEmpty(zzh2.zzA()) || !TextUtils.isEmpty(zzh2.zzt())) {
            zzkw zzkw = this.zzl;
            Uri.Builder builder = new Uri.Builder();
            String zzA2 = zzh2.zzA();
            if (TextUtils.isEmpty(zzA2)) {
                zzA2 = zzh2.zzt();
            }
            ArrayMap arrayMap = null;
            Uri.Builder appendQueryParameter = builder.scheme((String) zzeg.zze.zza((Object) null)).encodedAuthority((String) zzeg.zzf.zza((Object) null)).path("config/app/".concat(String.valueOf(zzA2))).appendQueryParameter("platform", "android");
            zzkw.zzt.zzf().zzh();
            appendQueryParameter.appendQueryParameter("gmp_version", String.valueOf(79000)).appendQueryParameter("runtime_version", "0");
            String uri = builder.build().toString();
            try {
                String str = (String) Preconditions.checkNotNull(zzh2.zzv());
                URL url = new URL(uri);
                zzaA().zzj().zzb("Fetching remote configuration", str);
                zzfu zzfu = this.zzc;
                zzal(zzfu);
                zzff zze2 = zzfu.zze(str);
                zzfu zzfu2 = this.zzc;
                zzal(zzfu2);
                String zzh3 = zzfu2.zzh(str);
                if (zze2 != null) {
                    if (!TextUtils.isEmpty(zzh3)) {
                        ArrayMap arrayMap2 = new ArrayMap();
                        arrayMap2.put(HttpHeaders.IF_MODIFIED_SINCE, zzh3);
                        arrayMap = arrayMap2;
                    }
                    zzfu zzfu3 = this.zzc;
                    zzal(zzfu3);
                    String zzf2 = zzfu3.zzf(str);
                    if (!TextUtils.isEmpty(zzf2)) {
                        if (arrayMap == null) {
                            arrayMap = new ArrayMap();
                        }
                        arrayMap.put(HttpHeaders.IF_NONE_MATCH, zzf2);
                    }
                }
                this.zzt = true;
                zzez zzez = this.zzd;
                zzal(zzez);
                zzkz zzkz = new zzkz(this);
                zzez.zzg();
                zzez.zzW();
                Preconditions.checkNotNull(url);
                Preconditions.checkNotNull(zzkz);
                zzez.zzt.zzaB().zzo(new zzey(zzez, str, url, (byte[]) null, arrayMap, zzkz));
            } catch (MalformedURLException unused) {
                zzaA().zzd().zzc("Failed to parse config URL. Not fetching. appId", zzet.zzn(zzh2.zzv()), uri);
            }
        } else {
            zzI((String) Preconditions.checkNotNull(zzh2.zzv()), 204, (Throwable) null, (byte[]) null, (Map) null);
        }
    }

    public final void zzE(zzau zzau, zzq zzq2) {
        zzau zzau2;
        List<zzac> list;
        List<zzac> list2;
        List<zzac> list3;
        String str;
        zzq zzq3 = zzq2;
        Preconditions.checkNotNull(zzq2);
        Preconditions.checkNotEmpty(zzq3.zza);
        zzaB().zzg();
        zzB();
        String str2 = zzq3.zza;
        long j11 = zzau.zzd;
        zzeu zzb2 = zzeu.zzb(zzau);
        zzaB().zzg();
        zzir zzir = null;
        if (!(this.zzD == null || (str = this.zzE) == null || !str.equals(str2))) {
            zzir = this.zzD;
        }
        zzlp.zzK(zzir, zzb2.zzd, false);
        zzau zza2 = zzb2.zza();
        zzal(this.zzi);
        if (zzlj.zzB(zza2, zzq3)) {
            if (!zzq3.zzh) {
                zzd(zzq3);
                return;
            }
            List list4 = zzq3.zzt;
            if (list4 == null) {
                zzau2 = zza2;
            } else if (list4.contains(zza2.zza)) {
                Bundle zzc2 = zza2.zzb.zzc();
                zzc2.putLong("ga_safelisted", 1);
                zzau2 = new zzau(zza2.zza, new zzas(zzc2), zza2.zzc, zza2.zzd);
            } else {
                zzaA().zzc().zzd("Dropping non-safelisted event. appId, event name, origin", str2, zza2.zza, zza2.zzc);
                return;
            }
            zzak zzak = this.zze;
            zzal(zzak);
            zzak.zzw();
            try {
                zzak zzak2 = this.zze;
                zzal(zzak2);
                Preconditions.checkNotEmpty(str2);
                zzak2.zzg();
                zzak2.zzW();
                int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
                if (i11 < 0) {
                    zzak2.zzt.zzaA().zzk().zzc("Invalid time querying timed out conditional properties", zzet.zzn(str2), Long.valueOf(j11));
                    list = Collections.emptyList();
                } else {
                    list = zzak2.zzt("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str2, String.valueOf(j11)});
                }
                for (zzac zzac : list) {
                    if (zzac != null) {
                        zzaA().zzj().zzd("User property timed out", zzac.zza, this.zzn.zzj().zzf(zzac.zzc.zzb), zzac.zzc.zza());
                        zzau zzau3 = zzac.zzg;
                        if (zzau3 != null) {
                            zzY(new zzau(zzau3, j11), zzq3);
                        }
                        zzak zzak3 = this.zze;
                        zzal(zzak3);
                        zzak3.zza(str2, zzac.zzc.zzb);
                    }
                }
                zzak zzak4 = this.zze;
                zzal(zzak4);
                Preconditions.checkNotEmpty(str2);
                zzak4.zzg();
                zzak4.zzW();
                if (i11 < 0) {
                    zzak4.zzt.zzaA().zzk().zzc("Invalid time querying expired conditional properties", zzet.zzn(str2), Long.valueOf(j11));
                    list2 = Collections.emptyList();
                } else {
                    list2 = zzak4.zzt("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str2, String.valueOf(j11)});
                }
                ArrayList<zzau> arrayList = new ArrayList<>(list2.size());
                for (zzac zzac2 : list2) {
                    if (zzac2 != null) {
                        zzaA().zzj().zzd("User property expired", zzac2.zza, this.zzn.zzj().zzf(zzac2.zzc.zzb), zzac2.zzc.zza());
                        zzak zzak5 = this.zze;
                        zzal(zzak5);
                        zzak5.zzA(str2, zzac2.zzc.zzb);
                        zzau zzau4 = zzac2.zzk;
                        if (zzau4 != null) {
                            arrayList.add(zzau4);
                        }
                        zzak zzak6 = this.zze;
                        zzal(zzak6);
                        zzak6.zza(str2, zzac2.zzc.zzb);
                    }
                }
                for (zzau zzau5 : arrayList) {
                    zzY(new zzau(zzau5, j11), zzq3);
                }
                zzak zzak7 = this.zze;
                zzal(zzak7);
                String str3 = zzau2.zza;
                Preconditions.checkNotEmpty(str2);
                Preconditions.checkNotEmpty(str3);
                zzak7.zzg();
                zzak7.zzW();
                if (i11 < 0) {
                    zzak7.zzt.zzaA().zzk().zzd("Invalid time querying triggered conditional properties", zzet.zzn(str2), zzak7.zzt.zzj().zzd(str3), Long.valueOf(j11));
                    list3 = Collections.emptyList();
                } else {
                    list3 = zzak7.zzt("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str2, str3, String.valueOf(j11)});
                }
                ArrayList<zzau> arrayList2 = new ArrayList<>(list3.size());
                for (zzac zzac3 : list3) {
                    if (zzac3 != null) {
                        zzlk zzlk = zzac3.zzc;
                        zzlm zzlm = new zzlm((String) Preconditions.checkNotNull(zzac3.zza), zzac3.zzb, zzlk.zzb, j11, Preconditions.checkNotNull(zzlk.zza()));
                        zzak zzak8 = this.zze;
                        zzal(zzak8);
                        if (zzak8.zzL(zzlm)) {
                            zzaA().zzj().zzd("User property triggered", zzac3.zza, this.zzn.zzj().zzf(zzlm.zzc), zzlm.zze);
                        } else {
                            zzaA().zzd().zzd("Too many active user properties, ignoring", zzet.zzn(zzac3.zza), this.zzn.zzj().zzf(zzlm.zzc), zzlm.zze);
                        }
                        zzau zzau6 = zzac3.zzi;
                        if (zzau6 != null) {
                            arrayList2.add(zzau6);
                        }
                        zzac3.zzc = new zzlk(zzlm);
                        zzac3.zze = true;
                        zzak zzak9 = this.zze;
                        zzal(zzak9);
                        zzak9.zzK(zzac3);
                    }
                }
                zzY(zzau2, zzq3);
                for (zzau zzau7 : arrayList2) {
                    zzY(new zzau(zzau7, j11), zzq3);
                }
                zzak zzak10 = this.zze;
                zzal(zzak10);
                zzak10.zzC();
            } finally {
                zzak zzak11 = this.zze;
                zzal(zzak11);
                zzak11.zzx();
            }
        }
    }

    public final void zzF(zzau zzau, String str) {
        zzau zzau2 = zzau;
        String str2 = str;
        zzak zzak = this.zze;
        zzal(zzak);
        zzh zzj2 = zzak.zzj(str2);
        if (zzj2 == null || TextUtils.isEmpty(zzj2.zzy())) {
            zzaA().zzc().zzb("No app data available; dropping event", str2);
            return;
        }
        Boolean zzad = zzad(zzj2);
        if (zzad == null) {
            if (!"_ui".equals(zzau2.zza)) {
                zzaA().zzk().zzb("Could not find package. appId", zzet.zzn(str));
            }
        } else if (!zzad.booleanValue()) {
            zzaA().zzd().zzb("App version does not match; dropping event. appId", zzet.zzn(str));
            return;
        }
        String zzA2 = zzj2.zzA();
        String zzy2 = zzj2.zzy();
        long zzb2 = zzj2.zzb();
        String zzx2 = zzj2.zzx();
        long zzm2 = zzj2.zzm();
        long zzj3 = zzj2.zzj();
        zzq zzq2 = r2;
        boolean zzan = zzj2.zzan();
        zzh zzh2 = zzj2;
        String zzz2 = zzh2.zzz();
        zzh2.zza();
        zzq zzq3 = new zzq(str, zzA2, zzy2, zzb2, zzx2, zzm2, zzj3, (String) null, zzan, false, zzz2, 0, 0, 0, zzh2.zzam(), false, zzh2.zzt(), zzh2.zzs(), zzh2.zzk(), zzh2.zzE(), (String) null, zzq(str2).zzi(), "", (String) null, zzh2.zzap(), zzh2.zzr());
        zzG(zzau2, zzq2);
    }

    public final void zzG(zzau zzau, zzq zzq2) {
        Preconditions.checkNotEmpty(zzq2.zza);
        zzeu zzb2 = zzeu.zzb(zzau);
        zzlp zzv2 = zzv();
        Bundle bundle = zzb2.zzd;
        zzak zzak = this.zze;
        zzal(zzak);
        zzv2.zzL(bundle, zzak.zzi(zzq2.zza));
        zzv().zzN(zzb2, zzg().zzd(zzq2.zza));
        zzau zza2 = zzb2.zza();
        if (Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(zza2.zza) && "referrer API v2".equals(zza2.zzb.zzg("_cis"))) {
            String zzg2 = zza2.zzb.zzg("gclid");
            if (!TextUtils.isEmpty(zzg2)) {
                zzW(new zzlk("_lgclid", zza2.zzd, zzg2, TtmlNode.TEXT_EMPHASIS_AUTO), zzq2);
            }
        }
        zzE(zza2, zzq2);
    }

    public final void zzH() {
        this.zzs++;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0049 A[Catch:{ all -> 0x0176, all -> 0x0180 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005c A[Catch:{ all -> 0x0176, all -> 0x0180 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0129 A[Catch:{ all -> 0x0176, all -> 0x0180 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0137 A[Catch:{ all -> 0x0176, all -> 0x0180 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0159 A[Catch:{ all -> 0x0176, all -> 0x0180 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x015d A[Catch:{ all -> 0x0176, all -> 0x0180 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzI(java.lang.String r8, int r9, java.lang.Throwable r10, byte[] r11, java.util.Map r12) {
        /*
            r7 = this;
            com.google.android.gms.measurement.internal.zzga r0 = r7.zzaB()
            r0.zzg()
            r7.zzB()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)
            r0 = 0
            if (r11 != 0) goto L_0x0012
            byte[] r11 = new byte[r0]     // Catch:{ all -> 0x0180 }
        L_0x0012:
            com.google.android.gms.measurement.internal.zzet r1 = r7.zzaA()     // Catch:{ all -> 0x0180 }
            com.google.android.gms.measurement.internal.zzer r1 = r1.zzj()     // Catch:{ all -> 0x0180 }
            java.lang.String r2 = "onConfigFetched. Response size"
            int r3 = r11.length     // Catch:{ all -> 0x0180 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0180 }
            r1.zzb(r2, r3)     // Catch:{ all -> 0x0180 }
            com.google.android.gms.measurement.internal.zzak r1 = r7.zze     // Catch:{ all -> 0x0180 }
            zzal(r1)     // Catch:{ all -> 0x0180 }
            r1.zzw()     // Catch:{ all -> 0x0180 }
            com.google.android.gms.measurement.internal.zzak r1 = r7.zze     // Catch:{ all -> 0x0176 }
            zzal(r1)     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.zzh r1 = r1.zzj(r8)     // Catch:{ all -> 0x0176 }
            r2 = 200(0xc8, float:2.8E-43)
            r4 = 304(0x130, float:4.26E-43)
            if (r9 == r2) goto L_0x0042
            r2 = 204(0xcc, float:2.86E-43)
            if (r9 == r2) goto L_0x0042
            if (r9 != r4) goto L_0x0046
            r9 = r4
        L_0x0042:
            if (r10 != 0) goto L_0x0046
            r2 = 1
            goto L_0x0047
        L_0x0046:
            r2 = r0
        L_0x0047:
            if (r1 != 0) goto L_0x005c
            com.google.android.gms.measurement.internal.zzet r9 = r7.zzaA()     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.zzer r9 = r9.zzk()     // Catch:{ all -> 0x0176 }
            java.lang.String r10 = "App does not exist in onConfigFetched. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzet.zzn(r8)     // Catch:{ all -> 0x0176 }
            r9.zzb(r10, r8)     // Catch:{ all -> 0x0176 }
            goto L_0x0160
        L_0x005c:
            r5 = 404(0x194, float:5.66E-43)
            if (r2 != 0) goto L_0x00ba
            if (r9 != r5) goto L_0x0063
            goto L_0x00ba
        L_0x0063:
            com.google.android.gms.common.util.Clock r11 = r7.zzax()     // Catch:{ all -> 0x0176 }
            long r11 = r11.currentTimeMillis()     // Catch:{ all -> 0x0176 }
            r1.zzW(r11)     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.zzak r11 = r7.zze     // Catch:{ all -> 0x0176 }
            zzal(r11)     // Catch:{ all -> 0x0176 }
            r11.zzD(r1)     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.zzet r11 = r7.zzaA()     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.zzer r11 = r11.zzj()     // Catch:{ all -> 0x0176 }
            java.lang.String r12 = "Fetching config failed. code, error"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0176 }
            r11.zzc(r12, r1, r10)     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.zzfu r10 = r7.zzc     // Catch:{ all -> 0x0176 }
            zzal(r10)     // Catch:{ all -> 0x0176 }
            r10.zzl(r8)     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.zzkb r8 = r7.zzk     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.zzfe r8 = r8.zzd     // Catch:{ all -> 0x0176 }
            com.google.android.gms.common.util.Clock r10 = r7.zzax()     // Catch:{ all -> 0x0176 }
            long r10 = r10.currentTimeMillis()     // Catch:{ all -> 0x0176 }
            r8.zzb(r10)     // Catch:{ all -> 0x0176 }
            r8 = 503(0x1f7, float:7.05E-43)
            if (r9 == r8) goto L_0x00a6
            r8 = 429(0x1ad, float:6.01E-43)
            if (r9 != r8) goto L_0x00b5
        L_0x00a6:
            com.google.android.gms.measurement.internal.zzkb r8 = r7.zzk     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.zzfe r8 = r8.zzb     // Catch:{ all -> 0x0176 }
            com.google.android.gms.common.util.Clock r9 = r7.zzax()     // Catch:{ all -> 0x0176 }
            long r9 = r9.currentTimeMillis()     // Catch:{ all -> 0x0176 }
            r8.zzb(r9)     // Catch:{ all -> 0x0176 }
        L_0x00b5:
            r7.zzag()     // Catch:{ all -> 0x0176 }
            goto L_0x0160
        L_0x00ba:
            r10 = 0
            if (r12 == 0) goto L_0x00c6
            java.lang.String r2 = "Last-Modified"
            java.lang.Object r2 = r12.get(r2)     // Catch:{ all -> 0x0176 }
            java.util.List r2 = (java.util.List) r2     // Catch:{ all -> 0x0176 }
            goto L_0x00c7
        L_0x00c6:
            r2 = r10
        L_0x00c7:
            if (r2 == 0) goto L_0x00d6
            boolean r6 = r2.isEmpty()     // Catch:{ all -> 0x0176 }
            if (r6 != 0) goto L_0x00d6
            java.lang.Object r2 = r2.get(r0)     // Catch:{ all -> 0x0176 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0176 }
            goto L_0x00d7
        L_0x00d6:
            r2 = r10
        L_0x00d7:
            if (r12 == 0) goto L_0x00e2
            java.lang.String r6 = "ETag"
            java.lang.Object r12 = r12.get(r6)     // Catch:{ all -> 0x0176 }
            java.util.List r12 = (java.util.List) r12     // Catch:{ all -> 0x0176 }
            goto L_0x00e3
        L_0x00e2:
            r12 = r10
        L_0x00e3:
            if (r12 == 0) goto L_0x00f2
            boolean r6 = r12.isEmpty()     // Catch:{ all -> 0x0176 }
            if (r6 != 0) goto L_0x00f2
            java.lang.Object r12 = r12.get(r0)     // Catch:{ all -> 0x0176 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x0176 }
            goto L_0x00f3
        L_0x00f2:
            r12 = r10
        L_0x00f3:
            if (r9 == r5) goto L_0x0101
            if (r9 != r4) goto L_0x00f8
            goto L_0x0101
        L_0x00f8:
            com.google.android.gms.measurement.internal.zzfu r10 = r7.zzc     // Catch:{ all -> 0x0176 }
            zzal(r10)     // Catch:{ all -> 0x0176 }
            r10.zzt(r8, r11, r2, r12)     // Catch:{ all -> 0x0176 }
            goto L_0x0114
        L_0x0101:
            com.google.android.gms.measurement.internal.zzfu r11 = r7.zzc     // Catch:{ all -> 0x0176 }
            zzal(r11)     // Catch:{ all -> 0x0176 }
            com.google.android.gms.internal.measurement.zzff r11 = r11.zze(r8)     // Catch:{ all -> 0x0176 }
            if (r11 != 0) goto L_0x0114
            com.google.android.gms.measurement.internal.zzfu r11 = r7.zzc     // Catch:{ all -> 0x0176 }
            zzal(r11)     // Catch:{ all -> 0x0176 }
            r11.zzt(r8, r10, r10, r10)     // Catch:{ all -> 0x0176 }
        L_0x0114:
            com.google.android.gms.common.util.Clock r10 = r7.zzax()     // Catch:{ all -> 0x0176 }
            long r10 = r10.currentTimeMillis()     // Catch:{ all -> 0x0176 }
            r1.zzN(r10)     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.zzak r10 = r7.zze     // Catch:{ all -> 0x0176 }
            zzal(r10)     // Catch:{ all -> 0x0176 }
            r10.zzD(r1)     // Catch:{ all -> 0x0176 }
            if (r9 != r5) goto L_0x0137
            com.google.android.gms.measurement.internal.zzet r9 = r7.zzaA()     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.zzer r9 = r9.zzl()     // Catch:{ all -> 0x0176 }
            java.lang.String r10 = "Config not found. Using empty config. appId"
            r9.zzb(r10, r8)     // Catch:{ all -> 0x0176 }
            goto L_0x0148
        L_0x0137:
            com.google.android.gms.measurement.internal.zzet r8 = r7.zzaA()     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.zzer r8 = r8.zzj()     // Catch:{ all -> 0x0176 }
            java.lang.String r10 = "Successfully fetched config. Got network response. code, size"
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0176 }
            r8.zzc(r10, r9, r3)     // Catch:{ all -> 0x0176 }
        L_0x0148:
            com.google.android.gms.measurement.internal.zzez r8 = r7.zzd     // Catch:{ all -> 0x0176 }
            zzal(r8)     // Catch:{ all -> 0x0176 }
            boolean r8 = r8.zza()     // Catch:{ all -> 0x0176 }
            if (r8 == 0) goto L_0x015d
            boolean r8 = r7.zzai()     // Catch:{ all -> 0x0176 }
            if (r8 == 0) goto L_0x015d
            r7.zzX()     // Catch:{ all -> 0x0176 }
            goto L_0x0160
        L_0x015d:
            r7.zzag()     // Catch:{ all -> 0x0176 }
        L_0x0160:
            com.google.android.gms.measurement.internal.zzak r8 = r7.zze     // Catch:{ all -> 0x0176 }
            zzal(r8)     // Catch:{ all -> 0x0176 }
            r8.zzC()     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.zzak r8 = r7.zze     // Catch:{ all -> 0x0180 }
            zzal(r8)     // Catch:{ all -> 0x0180 }
            r8.zzx()     // Catch:{ all -> 0x0180 }
            r7.zzt = r0
            r7.zzae()
            return
        L_0x0176:
            r8 = move-exception
            com.google.android.gms.measurement.internal.zzak r9 = r7.zze     // Catch:{ all -> 0x0180 }
            zzal(r9)     // Catch:{ all -> 0x0180 }
            r9.zzx()     // Catch:{ all -> 0x0180 }
            throw r8     // Catch:{ all -> 0x0180 }
        L_0x0180:
            r8 = move-exception
            r7.zzt = r0
            r7.zzae()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzlh.zzI(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    public final void zzJ(boolean z11) {
        zzag();
    }

    /* JADX INFO: finally extract failed */
    public final void zzK(int i11, Throwable th2, byte[] bArr, String str) {
        zzak zzak;
        zzaB().zzg();
        zzB();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th3) {
                this.zzu = false;
                zzae();
                throw th3;
            }
        }
        List<Long> list = (List) Preconditions.checkNotNull(this.zzy);
        this.zzy = null;
        if (i11 != 200) {
            if (i11 == 204) {
                i11 = 204;
            }
            zzaA().zzj().zzc("Network upload failed. Will retry later. code, error", Integer.valueOf(i11), th2);
            this.zzk.zzd.zzb(zzax().currentTimeMillis());
            if (i11 == 503 || i11 == 429) {
                this.zzk.zzb.zzb(zzax().currentTimeMillis());
            }
            zzak zzak2 = this.zze;
            zzal(zzak2);
            zzak2.zzy(list);
            zzag();
            this.zzu = false;
            zzae();
        }
        if (th2 == null) {
            try {
                this.zzk.zzc.zzb(zzax().currentTimeMillis());
                this.zzk.zzd.zzb(0);
                zzag();
                zzaA().zzj().zzc("Successful upload. Got network response. code, size", Integer.valueOf(i11), Integer.valueOf(bArr.length));
                zzak zzak3 = this.zze;
                zzal(zzak3);
                zzak3.zzw();
                try {
                    for (Long l11 : list) {
                        try {
                            zzak = this.zze;
                            zzal(zzak);
                            long longValue = l11.longValue();
                            zzak.zzg();
                            zzak.zzW();
                            if (zzak.zzh().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                                throw new SQLiteException("Deleted fewer rows from queue than expected");
                            }
                        } catch (SQLiteException e11) {
                            zzak.zzt.zzaA().zzd().zzb("Failed to delete a bundle in a queue table", e11);
                            throw e11;
                        } catch (SQLiteException e12) {
                            List list2 = this.zzz;
                            if (list2 == null || !list2.contains(l11)) {
                                throw e12;
                            }
                        }
                    }
                    zzak zzak4 = this.zze;
                    zzal(zzak4);
                    zzak4.zzC();
                    zzak zzak5 = this.zze;
                    zzal(zzak5);
                    zzak5.zzx();
                    this.zzz = null;
                    zzez zzez = this.zzd;
                    zzal(zzez);
                    if (!zzez.zza() || !zzai()) {
                        this.zzA = -1;
                        zzag();
                    } else {
                        zzX();
                    }
                    this.zza = 0;
                } catch (Throwable th4) {
                    zzak zzak6 = this.zze;
                    zzal(zzak6);
                    zzak6.zzx();
                    throw th4;
                }
            } catch (SQLiteException e13) {
                zzaA().zzd().zzb("Database error while trying to delete uploaded bundles", e13);
                this.zza = zzax().elapsedRealtime();
                zzaA().zzj().zzb("Disable upload, time", Long.valueOf(this.zza));
            }
            this.zzu = false;
            zzae();
        }
        zzaA().zzj().zzc("Network upload failed. Will retry later. code, error", Integer.valueOf(i11), th2);
        this.zzk.zzd.zzb(zzax().currentTimeMillis());
        this.zzk.zzb.zzb(zzax().currentTimeMillis());
        zzak zzak22 = this.zze;
        zzal(zzak22);
        zzak22.zzy(list);
        zzag();
        this.zzu = false;
        zzae();
    }

    /* JADX WARNING: Removed duplicated region for block: B:132:0x03d8 A[Catch:{ RuntimeException -> 0x0360, all -> 0x0570 }] */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0404 A[Catch:{ RuntimeException -> 0x0360, all -> 0x0570 }] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0419 A[SYNTHETIC, Splitter:B:137:0x0419] */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x04bb A[Catch:{ RuntimeException -> 0x0360, all -> 0x0570 }] */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x04db A[Catch:{ RuntimeException -> 0x0360, all -> 0x0570 }] */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x0540 A[Catch:{ RuntimeException -> 0x0360, all -> 0x0570 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0126 A[Catch:{ RuntimeException -> 0x0360, all -> 0x0570 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01f0 A[Catch:{ RuntimeException -> 0x0360, all -> 0x0570 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01f6 A[Catch:{ RuntimeException -> 0x0360, all -> 0x0570 }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x024f A[Catch:{ RuntimeException -> 0x0360, all -> 0x0570 }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x025e A[Catch:{ RuntimeException -> 0x0360, all -> 0x0570 }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x026e A[Catch:{ RuntimeException -> 0x0360, all -> 0x0570 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzL(com.google.android.gms.measurement.internal.zzq r24) {
        /*
            r23 = this;
            r1 = r23
            r2 = r24
            java.lang.String r3 = "_sysu"
            java.lang.String r4 = "_sys"
            java.lang.String r5 = "com.android.vending"
            java.lang.String r6 = "_pfo"
            java.lang.String r0 = "_npa"
            java.lang.String r7 = "_uwa"
            java.lang.String r8 = "app_id=?"
            com.google.android.gms.measurement.internal.zzga r9 = r23.zzaB()
            r9.zzg()
            r23.zzB()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r24)
            java.lang.String r9 = r2.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)
            boolean r9 = zzak(r24)
            if (r9 == 0) goto L_0x057a
            com.google.android.gms.measurement.internal.zzak r9 = r1.zze
            zzal(r9)
            java.lang.String r10 = r2.zza
            com.google.android.gms.measurement.internal.zzh r9 = r9.zzj(r10)
            r10 = 0
            if (r9 == 0) goto L_0x0060
            java.lang.String r12 = r9.zzA()
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 == 0) goto L_0x0060
            java.lang.String r12 = r2.zzb
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 != 0) goto L_0x0060
            r9.zzN(r10)
            com.google.android.gms.measurement.internal.zzak r12 = r1.zze
            zzal(r12)
            r12.zzD(r9)
            com.google.android.gms.measurement.internal.zzfu r9 = r1.zzc
            zzal(r9)
            java.lang.String r12 = r2.zza
            r9.zzm(r12)
        L_0x0060:
            boolean r9 = r2.zzh
            if (r9 != 0) goto L_0x0068
            r23.zzd(r24)
            return
        L_0x0068:
            long r12 = r2.zzm
            int r9 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r9 != 0) goto L_0x0076
            com.google.android.gms.common.util.Clock r9 = r23.zzax()
            long r12 = r9.currentTimeMillis()
        L_0x0076:
            com.google.android.gms.measurement.internal.zzgd r9 = r1.zzn
            com.google.android.gms.measurement.internal.zzao r9 = r9.zzg()
            r9.zzd()
            int r9 = r2.zzn
            r15 = 1
            if (r9 == 0) goto L_0x009e
            if (r9 == r15) goto L_0x009e
            com.google.android.gms.measurement.internal.zzet r16 = r23.zzaA()
            com.google.android.gms.measurement.internal.zzer r14 = r16.zzk()
            java.lang.String r10 = r2.zza
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzet.zzn(r10)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.String r11 = "Incorrect app type, assuming installed app. appId, appType"
            r14.zzc(r11, r10, r9)
            r9 = 0
        L_0x009e:
            com.google.android.gms.measurement.internal.zzak r10 = r1.zze
            zzal(r10)
            r10.zzw()
            com.google.android.gms.measurement.internal.zzak r10 = r1.zze     // Catch:{ all -> 0x0570 }
            zzal(r10)     // Catch:{ all -> 0x0570 }
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x0570 }
            com.google.android.gms.measurement.internal.zzlm r10 = r10.zzp(r11, r0)     // Catch:{ all -> 0x0570 }
            r11 = r3
            r20 = r4
            if (r10 == 0) goto L_0x00c3
            java.lang.String r14 = "auto"
            java.lang.String r3 = r10.zzb     // Catch:{ all -> 0x0570 }
            boolean r3 = r14.equals(r3)     // Catch:{ all -> 0x0570 }
            if (r3 == 0) goto L_0x00c1
            goto L_0x00c3
        L_0x00c1:
            r4 = r15
            goto L_0x00fd
        L_0x00c3:
            java.lang.Boolean r3 = r2.zzr     // Catch:{ all -> 0x0570 }
            if (r3 == 0) goto L_0x00f7
            com.google.android.gms.measurement.internal.zzlk r0 = new com.google.android.gms.measurement.internal.zzlk     // Catch:{ all -> 0x0570 }
            java.lang.String r3 = "_npa"
            java.lang.Boolean r4 = r2.zzr     // Catch:{ all -> 0x0570 }
            boolean r4 = r4.booleanValue()     // Catch:{ all -> 0x0570 }
            if (r15 == r4) goto L_0x00d6
            r18 = 0
            goto L_0x00d8
        L_0x00d6:
            r18 = 1
        L_0x00d8:
            java.lang.Long r18 = java.lang.Long.valueOf(r18)     // Catch:{ all -> 0x0570 }
            java.lang.String r19 = "auto"
            r4 = 0
            r14 = r0
            r4 = r15
            r15 = r3
            r16 = r12
            r14.<init>(r15, r16, r18, r19)     // Catch:{ all -> 0x0570 }
            if (r10 == 0) goto L_0x00f3
            java.lang.Object r3 = r10.zze     // Catch:{ all -> 0x0570 }
            java.lang.Long r10 = r0.zzd     // Catch:{ all -> 0x0570 }
            boolean r3 = r3.equals(r10)     // Catch:{ all -> 0x0570 }
            if (r3 != 0) goto L_0x00fd
        L_0x00f3:
            r1.zzW(r0, r2)     // Catch:{ all -> 0x0570 }
            goto L_0x00fd
        L_0x00f7:
            r4 = r15
            if (r10 == 0) goto L_0x00fd
            r1.zzP(r0, r2)     // Catch:{ all -> 0x0570 }
        L_0x00fd:
            com.google.android.gms.measurement.internal.zzak r0 = r1.zze     // Catch:{ all -> 0x0570 }
            zzal(r0)     // Catch:{ all -> 0x0570 }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x0570 }
            java.lang.Object r3 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)     // Catch:{ all -> 0x0570 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0570 }
            com.google.android.gms.measurement.internal.zzh r0 = r0.zzj(r3)     // Catch:{ all -> 0x0570 }
            if (r0 == 0) goto L_0x01f0
            com.google.android.gms.measurement.internal.zzlp r10 = r23.zzv()     // Catch:{ all -> 0x0570 }
            java.lang.String r14 = r2.zzb     // Catch:{ all -> 0x0570 }
            java.lang.String r15 = r0.zzA()     // Catch:{ all -> 0x0570 }
            java.lang.String r3 = r2.zzq     // Catch:{ all -> 0x0570 }
            java.lang.String r4 = r0.zzt()     // Catch:{ all -> 0x0570 }
            boolean r3 = r10.zzao(r14, r15, r3, r4)     // Catch:{ all -> 0x0570 }
            if (r3 == 0) goto L_0x01f0
            com.google.android.gms.measurement.internal.zzet r3 = r23.zzaA()     // Catch:{ all -> 0x0570 }
            com.google.android.gms.measurement.internal.zzer r3 = r3.zzk()     // Catch:{ all -> 0x0570 }
            java.lang.String r4 = "New GMP App Id passed in. Removing cached database data. appId"
            java.lang.String r10 = r0.zzv()     // Catch:{ all -> 0x0570 }
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzet.zzn(r10)     // Catch:{ all -> 0x0570 }
            r3.zzb(r4, r10)     // Catch:{ all -> 0x0570 }
            com.google.android.gms.measurement.internal.zzak r3 = r1.zze     // Catch:{ all -> 0x0570 }
            zzal(r3)     // Catch:{ all -> 0x0570 }
            java.lang.String r4 = r0.zzv()     // Catch:{ all -> 0x0570 }
            r3.zzW()     // Catch:{ all -> 0x0570 }
            r3.zzg()     // Catch:{ all -> 0x0570 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r4)     // Catch:{ all -> 0x0570 }
            android.database.sqlite.SQLiteDatabase r0 = r3.zzh()     // Catch:{ SQLiteException -> 0x01d6 }
            r10 = 1
            java.lang.String[] r14 = new java.lang.String[r10]     // Catch:{ SQLiteException -> 0x01d6 }
            r10 = 0
            r14[r10] = r4     // Catch:{ SQLiteException -> 0x01d6 }
            java.lang.String r10 = "events"
            int r10 = r0.delete(r10, r8, r14)     // Catch:{ SQLiteException -> 0x01d6 }
            java.lang.String r15 = "user_attributes"
            int r15 = r0.delete(r15, r8, r14)     // Catch:{ SQLiteException -> 0x01d6 }
            int r10 = r10 + r15
            java.lang.String r15 = "conditional_properties"
            int r15 = r0.delete(r15, r8, r14)     // Catch:{ SQLiteException -> 0x01d6 }
            int r10 = r10 + r15
            java.lang.String r15 = "apps"
            int r15 = r0.delete(r15, r8, r14)     // Catch:{ SQLiteException -> 0x01d6 }
            int r10 = r10 + r15
            java.lang.String r15 = "raw_events"
            int r15 = r0.delete(r15, r8, r14)     // Catch:{ SQLiteException -> 0x01d6 }
            int r10 = r10 + r15
            java.lang.String r15 = "raw_events_metadata"
            int r15 = r0.delete(r15, r8, r14)     // Catch:{ SQLiteException -> 0x01d6 }
            int r10 = r10 + r15
            java.lang.String r15 = "event_filters"
            int r15 = r0.delete(r15, r8, r14)     // Catch:{ SQLiteException -> 0x01d6 }
            int r10 = r10 + r15
            java.lang.String r15 = "property_filters"
            int r15 = r0.delete(r15, r8, r14)     // Catch:{ SQLiteException -> 0x01d6 }
            int r10 = r10 + r15
            java.lang.String r15 = "audience_filter_values"
            int r15 = r0.delete(r15, r8, r14)     // Catch:{ SQLiteException -> 0x01d6 }
            int r10 = r10 + r15
            java.lang.String r15 = "consent_settings"
            int r15 = r0.delete(r15, r8, r14)     // Catch:{ SQLiteException -> 0x01d6 }
            int r10 = r10 + r15
            com.google.android.gms.internal.measurement.zzpk.zzc()     // Catch:{ SQLiteException -> 0x01d6 }
            com.google.android.gms.measurement.internal.zzgd r15 = r3.zzt     // Catch:{ SQLiteException -> 0x01d6 }
            com.google.android.gms.measurement.internal.zzag r15 = r15.zzf()     // Catch:{ SQLiteException -> 0x01d6 }
            r21 = r11
            com.google.android.gms.measurement.internal.zzef r11 = com.google.android.gms.measurement.internal.zzeg.zzat     // Catch:{ SQLiteException -> 0x01d2 }
            r22 = r6
            r6 = 0
            boolean r11 = r15.zzs(r6, r11)     // Catch:{ SQLiteException -> 0x01d0 }
            if (r11 == 0) goto L_0x01ba
            java.lang.String r6 = "default_event_params"
            int r0 = r0.delete(r6, r8, r14)     // Catch:{ SQLiteException -> 0x01d0 }
            int r10 = r10 + r0
        L_0x01ba:
            if (r10 <= 0) goto L_0x01ee
            com.google.android.gms.measurement.internal.zzgd r0 = r3.zzt     // Catch:{ SQLiteException -> 0x01d0 }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()     // Catch:{ SQLiteException -> 0x01d0 }
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzj()     // Catch:{ SQLiteException -> 0x01d0 }
            java.lang.String r6 = "Deleted application data. app, records"
            java.lang.Integer r8 = java.lang.Integer.valueOf(r10)     // Catch:{ SQLiteException -> 0x01d0 }
            r0.zzc(r6, r4, r8)     // Catch:{ SQLiteException -> 0x01d0 }
            goto L_0x01ee
        L_0x01d0:
            r0 = move-exception
            goto L_0x01db
        L_0x01d2:
            r0 = move-exception
            r22 = r6
            goto L_0x01db
        L_0x01d6:
            r0 = move-exception
            r22 = r6
            r21 = r11
        L_0x01db:
            com.google.android.gms.measurement.internal.zzgd r3 = r3.zzt     // Catch:{ all -> 0x0570 }
            com.google.android.gms.measurement.internal.zzet r3 = r3.zzaA()     // Catch:{ all -> 0x0570 }
            com.google.android.gms.measurement.internal.zzer r3 = r3.zzd()     // Catch:{ all -> 0x0570 }
            java.lang.String r6 = "Error deleting application data. appId, error"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzet.zzn(r4)     // Catch:{ all -> 0x0570 }
            r3.zzc(r6, r4, r0)     // Catch:{ all -> 0x0570 }
        L_0x01ee:
            r0 = 0
            goto L_0x01f4
        L_0x01f0:
            r22 = r6
            r21 = r11
        L_0x01f4:
            if (r0 == 0) goto L_0x024a
            long r3 = r0.zzb()     // Catch:{ all -> 0x0570 }
            r10 = -2147483648(0xffffffff80000000, double:NaN)
            int r3 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r3 == 0) goto L_0x020d
            long r3 = r0.zzb()     // Catch:{ all -> 0x0570 }
            long r14 = r2.zzj     // Catch:{ all -> 0x0570 }
            int r3 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            if (r3 == 0) goto L_0x020d
            r15 = 1
            goto L_0x020e
        L_0x020d:
            r15 = 0
        L_0x020e:
            java.lang.String r3 = r0.zzy()     // Catch:{ all -> 0x0570 }
            long r16 = r0.zzb()     // Catch:{ all -> 0x0570 }
            int r0 = (r16 > r10 ? 1 : (r16 == r10 ? 0 : -1))
            if (r0 != 0) goto L_0x0226
            if (r3 == 0) goto L_0x0226
            java.lang.String r0 = r2.zzc     // Catch:{ all -> 0x0570 }
            boolean r0 = r3.equals(r0)     // Catch:{ all -> 0x0570 }
            if (r0 != 0) goto L_0x0226
            r0 = 1
            goto L_0x0227
        L_0x0226:
            r0 = 0
        L_0x0227:
            r0 = r0 | r15
            if (r0 == 0) goto L_0x024a
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x0570 }
            r0.<init>()     // Catch:{ all -> 0x0570 }
            java.lang.String r4 = "_pv"
            r0.putString(r4, r3)     // Catch:{ all -> 0x0570 }
            com.google.android.gms.measurement.internal.zzau r3 = new com.google.android.gms.measurement.internal.zzau     // Catch:{ all -> 0x0570 }
            java.lang.String r15 = "_au"
            com.google.android.gms.measurement.internal.zzas r4 = new com.google.android.gms.measurement.internal.zzas     // Catch:{ all -> 0x0570 }
            r4.<init>(r0)     // Catch:{ all -> 0x0570 }
            java.lang.String r17 = "auto"
            r14 = r3
            r16 = r4
            r18 = r12
            r14.<init>(r15, r16, r17, r18)     // Catch:{ all -> 0x0570 }
            r1.zzE(r3, r2)     // Catch:{ all -> 0x0570 }
        L_0x024a:
            r23.zzd(r24)     // Catch:{ all -> 0x0570 }
            if (r9 != 0) goto L_0x025e
            com.google.android.gms.measurement.internal.zzak r0 = r1.zze     // Catch:{ all -> 0x0570 }
            zzal(r0)     // Catch:{ all -> 0x0570 }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x0570 }
            java.lang.String r4 = "_f"
            com.google.android.gms.measurement.internal.zzaq r0 = r0.zzn(r3, r4)     // Catch:{ all -> 0x0570 }
            r15 = 0
            goto L_0x026c
        L_0x025e:
            com.google.android.gms.measurement.internal.zzak r0 = r1.zze     // Catch:{ all -> 0x0570 }
            zzal(r0)     // Catch:{ all -> 0x0570 }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x0570 }
            java.lang.String r4 = "_v"
            com.google.android.gms.measurement.internal.zzaq r0 = r0.zzn(r3, r4)     // Catch:{ all -> 0x0570 }
            r15 = 1
        L_0x026c:
            if (r0 != 0) goto L_0x0540
            r3 = 3600000(0x36ee80, double:1.7786363E-317)
            long r8 = r12 / r3
            r10 = 1
            long r8 = r8 + r10
            long r8 = r8 * r3
            java.lang.String r3 = "_dac"
            java.lang.String r4 = "_et"
            java.lang.String r6 = "_r"
            java.lang.String r10 = "_c"
            if (r15 != 0) goto L_0x04f5
            com.google.android.gms.measurement.internal.zzlk r0 = new com.google.android.gms.measurement.internal.zzlk     // Catch:{ all -> 0x0570 }
            java.lang.String r15 = "_fot"
            java.lang.Long r18 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x0570 }
            java.lang.String r19 = "auto"
            r14 = r0
            r16 = r12
            r14.<init>(r15, r16, r18, r19)     // Catch:{ all -> 0x0570 }
            r1.zzW(r0, r2)     // Catch:{ all -> 0x0570 }
            com.google.android.gms.measurement.internal.zzga r0 = r23.zzaB()     // Catch:{ all -> 0x0570 }
            r0.zzg()     // Catch:{ all -> 0x0570 }
            com.google.android.gms.measurement.internal.zzfl r0 = r1.zzm     // Catch:{ all -> 0x0570 }
            java.lang.Object r0 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ all -> 0x0570 }
            r8 = r0
            com.google.android.gms.measurement.internal.zzfl r8 = (com.google.android.gms.measurement.internal.zzfl) r8     // Catch:{ all -> 0x0570 }
            java.lang.String r0 = r2.zza     // Catch:{ all -> 0x0570 }
            if (r0 == 0) goto L_0x0395
            boolean r9 = r0.isEmpty()     // Catch:{ all -> 0x0570 }
            if (r9 == 0) goto L_0x02b0
            goto L_0x0395
        L_0x02b0:
            com.google.android.gms.measurement.internal.zzgd r9 = r8.zza     // Catch:{ all -> 0x0570 }
            com.google.android.gms.measurement.internal.zzga r9 = r9.zzaB()     // Catch:{ all -> 0x0570 }
            r9.zzg()     // Catch:{ all -> 0x0570 }
            boolean r9 = r8.zza()     // Catch:{ all -> 0x0570 }
            if (r9 != 0) goto L_0x02d0
            com.google.android.gms.measurement.internal.zzgd r0 = r8.zza     // Catch:{ all -> 0x0570 }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()     // Catch:{ all -> 0x0570 }
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzi()     // Catch:{ all -> 0x0570 }
            java.lang.String r5 = "Install Referrer Reporter is not available"
            r0.zza(r5)     // Catch:{ all -> 0x0570 }
            goto L_0x03a4
        L_0x02d0:
            com.google.android.gms.measurement.internal.zzfk r9 = new com.google.android.gms.measurement.internal.zzfk     // Catch:{ all -> 0x0570 }
            r9.<init>(r8, r0)     // Catch:{ all -> 0x0570 }
            com.google.android.gms.measurement.internal.zzgd r0 = r8.zza     // Catch:{ all -> 0x0570 }
            com.google.android.gms.measurement.internal.zzga r0 = r0.zzaB()     // Catch:{ all -> 0x0570 }
            r0.zzg()     // Catch:{ all -> 0x0570 }
            android.content.Intent r0 = new android.content.Intent     // Catch:{ all -> 0x0570 }
            java.lang.String r11 = "com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE"
            r0.<init>(r11)     // Catch:{ all -> 0x0570 }
            android.content.ComponentName r11 = new android.content.ComponentName     // Catch:{ all -> 0x0570 }
            java.lang.String r14 = "com.google.android.finsky.externalreferrer.GetInstallReferrerService"
            r11.<init>(r5, r14)     // Catch:{ all -> 0x0570 }
            r0.setComponent(r11)     // Catch:{ all -> 0x0570 }
            com.google.android.gms.measurement.internal.zzgd r11 = r8.zza     // Catch:{ all -> 0x0570 }
            android.content.Context r11 = r11.zzaw()     // Catch:{ all -> 0x0570 }
            android.content.pm.PackageManager r11 = r11.getPackageManager()     // Catch:{ all -> 0x0570 }
            if (r11 != 0) goto L_0x030c
            com.google.android.gms.measurement.internal.zzgd r0 = r8.zza     // Catch:{ all -> 0x0570 }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()     // Catch:{ all -> 0x0570 }
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzm()     // Catch:{ all -> 0x0570 }
            java.lang.String r5 = "Failed to obtain Package Manager to verify binding conditions for Install Referrer"
            r0.zza(r5)     // Catch:{ all -> 0x0570 }
            goto L_0x03a4
        L_0x030c:
            r14 = 0
            java.util.List r11 = r11.queryIntentServices(r0, r14)     // Catch:{ all -> 0x0570 }
            if (r11 == 0) goto L_0x0385
            boolean r15 = r11.isEmpty()     // Catch:{ all -> 0x0570 }
            if (r15 != 0) goto L_0x0385
            java.lang.Object r11 = r11.get(r14)     // Catch:{ all -> 0x0570 }
            android.content.pm.ResolveInfo r11 = (android.content.pm.ResolveInfo) r11     // Catch:{ all -> 0x0570 }
            android.content.pm.ServiceInfo r11 = r11.serviceInfo     // Catch:{ all -> 0x0570 }
            if (r11 == 0) goto L_0x03a4
            java.lang.String r14 = r11.packageName     // Catch:{ all -> 0x0570 }
            java.lang.String r11 = r11.name     // Catch:{ all -> 0x0570 }
            if (r11 == 0) goto L_0x0375
            boolean r5 = r5.equals(r14)     // Catch:{ all -> 0x0570 }
            if (r5 == 0) goto L_0x0375
            boolean r5 = r8.zza()     // Catch:{ all -> 0x0570 }
            if (r5 == 0) goto L_0x0375
            android.content.Intent r5 = new android.content.Intent     // Catch:{ all -> 0x0570 }
            r5.<init>(r0)     // Catch:{ all -> 0x0570 }
            com.google.android.gms.common.stats.ConnectionTracker r0 = com.google.android.gms.common.stats.ConnectionTracker.getInstance()     // Catch:{ RuntimeException -> 0x0360 }
            com.google.android.gms.measurement.internal.zzgd r11 = r8.zza     // Catch:{ RuntimeException -> 0x0360 }
            android.content.Context r11 = r11.zzaw()     // Catch:{ RuntimeException -> 0x0360 }
            r14 = 1
            boolean r0 = r0.bindService(r11, r5, r9, r14)     // Catch:{ RuntimeException -> 0x0360 }
            com.google.android.gms.measurement.internal.zzgd r5 = r8.zza     // Catch:{ RuntimeException -> 0x0360 }
            com.google.android.gms.measurement.internal.zzet r5 = r5.zzaA()     // Catch:{ RuntimeException -> 0x0360 }
            com.google.android.gms.measurement.internal.zzer r5 = r5.zzj()     // Catch:{ RuntimeException -> 0x0360 }
            java.lang.String r9 = "Install Referrer Service is"
            if (r0 == 0) goto L_0x035a
            java.lang.String r0 = "available"
            goto L_0x035c
        L_0x035a:
            java.lang.String r0 = "not available"
        L_0x035c:
            r5.zzb(r9, r0)     // Catch:{ RuntimeException -> 0x0360 }
            goto L_0x03a4
        L_0x0360:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgd r5 = r8.zza     // Catch:{ all -> 0x0570 }
            com.google.android.gms.measurement.internal.zzet r5 = r5.zzaA()     // Catch:{ all -> 0x0570 }
            com.google.android.gms.measurement.internal.zzer r5 = r5.zzd()     // Catch:{ all -> 0x0570 }
            java.lang.String r8 = "Exception occurred while binding to Install Referrer Service"
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0570 }
            r5.zzb(r8, r0)     // Catch:{ all -> 0x0570 }
            goto L_0x03a4
        L_0x0375:
            com.google.android.gms.measurement.internal.zzgd r0 = r8.zza     // Catch:{ all -> 0x0570 }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()     // Catch:{ all -> 0x0570 }
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzk()     // Catch:{ all -> 0x0570 }
            java.lang.String r5 = "Play Store version 8.3.73 or higher required for Install Referrer"
            r0.zza(r5)     // Catch:{ all -> 0x0570 }
            goto L_0x03a4
        L_0x0385:
            com.google.android.gms.measurement.internal.zzgd r0 = r8.zza     // Catch:{ all -> 0x0570 }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()     // Catch:{ all -> 0x0570 }
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzi()     // Catch:{ all -> 0x0570 }
            java.lang.String r5 = "Play Service for fetching Install Referrer is unavailable on device"
            r0.zza(r5)     // Catch:{ all -> 0x0570 }
            goto L_0x03a4
        L_0x0395:
            com.google.android.gms.measurement.internal.zzgd r0 = r8.zza     // Catch:{ all -> 0x0570 }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()     // Catch:{ all -> 0x0570 }
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzm()     // Catch:{ all -> 0x0570 }
            java.lang.String r5 = "Install Referrer Reporter was called with invalid app package name"
            r0.zza(r5)     // Catch:{ all -> 0x0570 }
        L_0x03a4:
            com.google.android.gms.measurement.internal.zzga r0 = r23.zzaB()     // Catch:{ all -> 0x0570 }
            r0.zzg()     // Catch:{ all -> 0x0570 }
            r23.zzB()     // Catch:{ all -> 0x0570 }
            android.os.Bundle r5 = new android.os.Bundle     // Catch:{ all -> 0x0570 }
            r5.<init>()     // Catch:{ all -> 0x0570 }
            r8 = 1
            r5.putLong(r10, r8)     // Catch:{ all -> 0x0570 }
            r5.putLong(r6, r8)     // Catch:{ all -> 0x0570 }
            r8 = 0
            r5.putLong(r7, r8)     // Catch:{ all -> 0x0570 }
            r6 = r22
            r5.putLong(r6, r8)     // Catch:{ all -> 0x0570 }
            r10 = r20
            r5.putLong(r10, r8)     // Catch:{ all -> 0x0570 }
            r11 = r21
            r5.putLong(r11, r8)     // Catch:{ all -> 0x0570 }
            r8 = 1
            r5.putLong(r4, r8)     // Catch:{ all -> 0x0570 }
            boolean r0 = r2.zzp     // Catch:{ all -> 0x0570 }
            if (r0 == 0) goto L_0x03db
            r5.putLong(r3, r8)     // Catch:{ all -> 0x0570 }
        L_0x03db:
            java.lang.String r0 = r2.zza     // Catch:{ all -> 0x0570 }
            java.lang.Object r0 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ all -> 0x0570 }
            r3 = r0
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0570 }
            com.google.android.gms.measurement.internal.zzak r0 = r1.zze     // Catch:{ all -> 0x0570 }
            zzal(r0)     // Catch:{ all -> 0x0570 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)     // Catch:{ all -> 0x0570 }
            r0.zzg()     // Catch:{ all -> 0x0570 }
            r0.zzW()     // Catch:{ all -> 0x0570 }
            java.lang.String r4 = "first_open_count"
            long r8 = r0.zzc(r3, r4)     // Catch:{ all -> 0x0570 }
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzn     // Catch:{ all -> 0x0570 }
            android.content.Context r0 = r0.zzaw()     // Catch:{ all -> 0x0570 }
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ all -> 0x0570 }
            if (r0 != 0) goto L_0x0419
            com.google.android.gms.measurement.internal.zzet r0 = r23.zzaA()     // Catch:{ all -> 0x0570 }
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzd()     // Catch:{ all -> 0x0570 }
            java.lang.String r4 = "PackageManager is null, first open report might be inaccurate. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzet.zzn(r3)     // Catch:{ all -> 0x0570 }
            r0.zzb(r4, r3)     // Catch:{ all -> 0x0570 }
        L_0x0415:
            r3 = 0
            goto L_0x04d7
        L_0x0419:
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzn     // Catch:{ NameNotFoundException -> 0x0429 }
            android.content.Context r0 = r0.zzaw()     // Catch:{ NameNotFoundException -> 0x0429 }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x0429 }
            r4 = 0
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r3, r4)     // Catch:{ NameNotFoundException -> 0x0429 }
            goto L_0x043c
        L_0x0429:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzet r4 = r23.zzaA()     // Catch:{ all -> 0x0570 }
            com.google.android.gms.measurement.internal.zzer r4 = r4.zzd()     // Catch:{ all -> 0x0570 }
            java.lang.String r14 = "Package info is null, first open report might be inaccurate. appId"
            java.lang.Object r15 = com.google.android.gms.measurement.internal.zzet.zzn(r3)     // Catch:{ all -> 0x0570 }
            r4.zzc(r14, r15, r0)     // Catch:{ all -> 0x0570 }
            r0 = 0
        L_0x043c:
            if (r0 == 0) goto L_0x0491
            long r14 = r0.firstInstallTime     // Catch:{ all -> 0x0570 }
            r16 = 0
            int r4 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r4 == 0) goto L_0x0491
            r20 = r10
            r21 = r11
            long r10 = r0.lastUpdateTime     // Catch:{ all -> 0x0570 }
            int r0 = (r14 > r10 ? 1 : (r14 == r10 ? 0 : -1))
            if (r0 == 0) goto L_0x0472
            com.google.android.gms.measurement.internal.zzag r0 = r23.zzg()     // Catch:{ all -> 0x0570 }
            com.google.android.gms.measurement.internal.zzef r4 = com.google.android.gms.measurement.internal.zzeg.zzad     // Catch:{ all -> 0x0570 }
            r10 = 0
            boolean r0 = r0.zzs(r10, r4)     // Catch:{ all -> 0x0570 }
            if (r0 == 0) goto L_0x046c
            r14 = 0
            int r0 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r0 != 0) goto L_0x046a
            r14 = 1
            r5.putLong(r7, r14)     // Catch:{ all -> 0x0570 }
            r8 = 0
        L_0x046a:
            r15 = 0
            goto L_0x0474
        L_0x046c:
            r14 = 1
            r5.putLong(r7, r14)     // Catch:{ all -> 0x0570 }
            goto L_0x046a
        L_0x0472:
            r10 = 0
            r15 = 1
        L_0x0474:
            com.google.android.gms.measurement.internal.zzlk r0 = new com.google.android.gms.measurement.internal.zzlk     // Catch:{ all -> 0x0570 }
            java.lang.String r4 = "_fi"
            r7 = 1
            if (r7 == r15) goto L_0x047e
            r14 = 0
            goto L_0x0480
        L_0x047e:
            r14 = 1
        L_0x0480:
            java.lang.Long r18 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x0570 }
            java.lang.String r19 = "auto"
            r14 = r0
            r15 = r4
            r16 = r12
            r14.<init>(r15, r16, r18, r19)     // Catch:{ all -> 0x0570 }
            r1.zzW(r0, r2)     // Catch:{ all -> 0x0570 }
            goto L_0x0496
        L_0x0491:
            r20 = r10
            r21 = r11
            r10 = 0
        L_0x0496:
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzn     // Catch:{ NameNotFoundException -> 0x04a6 }
            android.content.Context r0 = r0.zzaw()     // Catch:{ NameNotFoundException -> 0x04a6 }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x04a6 }
            r4 = 0
            android.content.pm.ApplicationInfo r3 = r0.getApplicationInfo(r3, r4)     // Catch:{ NameNotFoundException -> 0x04a6 }
            goto L_0x04b9
        L_0x04a6:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzet r4 = r23.zzaA()     // Catch:{ all -> 0x0570 }
            com.google.android.gms.measurement.internal.zzer r4 = r4.zzd()     // Catch:{ all -> 0x0570 }
            java.lang.String r7 = "Application info is null, first open report might be inaccurate. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzet.zzn(r3)     // Catch:{ all -> 0x0570 }
            r4.zzc(r7, r3, r0)     // Catch:{ all -> 0x0570 }
            r3 = r10
        L_0x04b9:
            if (r3 == 0) goto L_0x0415
            int r0 = r3.flags     // Catch:{ all -> 0x0570 }
            r4 = 1
            r0 = r0 & r4
            if (r0 == 0) goto L_0x04c8
            r4 = r20
            r10 = 1
            r5.putLong(r4, r10)     // Catch:{ all -> 0x0570 }
        L_0x04c8:
            int r0 = r3.flags     // Catch:{ all -> 0x0570 }
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0415
            r3 = r21
            r10 = 1
            r5.putLong(r3, r10)     // Catch:{ all -> 0x0570 }
            goto L_0x0415
        L_0x04d7:
            int r0 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r0 < 0) goto L_0x04de
            r5.putLong(r6, r8)     // Catch:{ all -> 0x0570 }
        L_0x04de:
            com.google.android.gms.measurement.internal.zzau r0 = new com.google.android.gms.measurement.internal.zzau     // Catch:{ all -> 0x0570 }
            java.lang.String r15 = "_f"
            com.google.android.gms.measurement.internal.zzas r3 = new com.google.android.gms.measurement.internal.zzas     // Catch:{ all -> 0x0570 }
            r3.<init>(r5)     // Catch:{ all -> 0x0570 }
            java.lang.String r17 = "auto"
            r14 = r0
            r16 = r3
            r18 = r12
            r14.<init>(r15, r16, r17, r18)     // Catch:{ all -> 0x0570 }
            r1.zzG(r0, r2)     // Catch:{ all -> 0x0570 }
            goto L_0x055f
        L_0x04f5:
            com.google.android.gms.measurement.internal.zzlk r0 = new com.google.android.gms.measurement.internal.zzlk     // Catch:{ all -> 0x0570 }
            java.lang.String r15 = "_fvt"
            java.lang.Long r18 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x0570 }
            java.lang.String r19 = "auto"
            r14 = r0
            r16 = r12
            r14.<init>(r15, r16, r18, r19)     // Catch:{ all -> 0x0570 }
            r1.zzW(r0, r2)     // Catch:{ all -> 0x0570 }
            com.google.android.gms.measurement.internal.zzga r0 = r23.zzaB()     // Catch:{ all -> 0x0570 }
            r0.zzg()     // Catch:{ all -> 0x0570 }
            r23.zzB()     // Catch:{ all -> 0x0570 }
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x0570 }
            r0.<init>()     // Catch:{ all -> 0x0570 }
            r7 = 1
            r0.putLong(r10, r7)     // Catch:{ all -> 0x0570 }
            r0.putLong(r6, r7)     // Catch:{ all -> 0x0570 }
            r0.putLong(r4, r7)     // Catch:{ all -> 0x0570 }
            boolean r4 = r2.zzp     // Catch:{ all -> 0x0570 }
            if (r4 == 0) goto L_0x0529
            r0.putLong(r3, r7)     // Catch:{ all -> 0x0570 }
        L_0x0529:
            com.google.android.gms.measurement.internal.zzau r3 = new com.google.android.gms.measurement.internal.zzau     // Catch:{ all -> 0x0570 }
            java.lang.String r15 = "_v"
            com.google.android.gms.measurement.internal.zzas r4 = new com.google.android.gms.measurement.internal.zzas     // Catch:{ all -> 0x0570 }
            r4.<init>(r0)     // Catch:{ all -> 0x0570 }
            java.lang.String r17 = "auto"
            r14 = r3
            r16 = r4
            r18 = r12
            r14.<init>(r15, r16, r17, r18)     // Catch:{ all -> 0x0570 }
            r1.zzG(r3, r2)     // Catch:{ all -> 0x0570 }
            goto L_0x055f
        L_0x0540:
            boolean r0 = r2.zzi     // Catch:{ all -> 0x0570 }
            if (r0 == 0) goto L_0x055f
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x0570 }
            r0.<init>()     // Catch:{ all -> 0x0570 }
            com.google.android.gms.measurement.internal.zzau r3 = new com.google.android.gms.measurement.internal.zzau     // Catch:{ all -> 0x0570 }
            java.lang.String r15 = "_cd"
            com.google.android.gms.measurement.internal.zzas r4 = new com.google.android.gms.measurement.internal.zzas     // Catch:{ all -> 0x0570 }
            r4.<init>(r0)     // Catch:{ all -> 0x0570 }
            java.lang.String r17 = "auto"
            r14 = r3
            r16 = r4
            r18 = r12
            r14.<init>(r15, r16, r17, r18)     // Catch:{ all -> 0x0570 }
            r1.zzG(r3, r2)     // Catch:{ all -> 0x0570 }
        L_0x055f:
            com.google.android.gms.measurement.internal.zzak r0 = r1.zze     // Catch:{ all -> 0x0570 }
            zzal(r0)     // Catch:{ all -> 0x0570 }
            r0.zzC()     // Catch:{ all -> 0x0570 }
            com.google.android.gms.measurement.internal.zzak r0 = r1.zze
            zzal(r0)
            r0.zzx()
            return
        L_0x0570:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzak r2 = r1.zze
            zzal(r2)
            r2.zzx()
            throw r0
        L_0x057a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzlh.zzL(com.google.android.gms.measurement.internal.zzq):void");
    }

    public final void zzM() {
        this.zzr++;
    }

    public final void zzN(zzac zzac) {
        zzq zzac2 = zzac((String) Preconditions.checkNotNull(zzac.zza));
        if (zzac2 != null) {
            zzO(zzac, zzac2);
        }
    }

    public final void zzO(zzac zzac, zzq zzq2) {
        Preconditions.checkNotNull(zzac);
        Preconditions.checkNotEmpty(zzac.zza);
        Preconditions.checkNotNull(zzac.zzc);
        Preconditions.checkNotEmpty(zzac.zzc.zzb);
        zzaB().zzg();
        zzB();
        if (zzak(zzq2)) {
            if (zzq2.zzh) {
                zzak zzak = this.zze;
                zzal(zzak);
                zzak.zzw();
                try {
                    zzd(zzq2);
                    String str = (String) Preconditions.checkNotNull(zzac.zza);
                    zzak zzak2 = this.zze;
                    zzal(zzak2);
                    zzac zzk2 = zzak2.zzk(str, zzac.zzc.zzb);
                    if (zzk2 != null) {
                        zzaA().zzc().zzc("Removing conditional user property", zzac.zza, this.zzn.zzj().zzf(zzac.zzc.zzb));
                        zzak zzak3 = this.zze;
                        zzal(zzak3);
                        zzak3.zza(str, zzac.zzc.zzb);
                        if (zzk2.zze) {
                            zzak zzak4 = this.zze;
                            zzal(zzak4);
                            zzak4.zzA(str, zzac.zzc.zzb);
                        }
                        zzau zzau = zzac.zzk;
                        if (zzau != null) {
                            zzas zzas = zzau.zzb;
                            zzY((zzau) Preconditions.checkNotNull(zzv().zzz(str, ((zzau) Preconditions.checkNotNull(zzac.zzk)).zza, zzas != null ? zzas.zzc() : null, zzk2.zzb, zzac.zzk.zzd, true, true)), zzq2);
                        }
                    } else {
                        zzaA().zzk().zzc("Conditional user property doesn't exist", zzet.zzn(zzac.zza), this.zzn.zzj().zzf(zzac.zzc.zzb));
                    }
                    zzak zzak5 = this.zze;
                    zzal(zzak5);
                    zzak5.zzC();
                } finally {
                    zzak zzak6 = this.zze;
                    zzal(zzak6);
                    zzak6.zzx();
                }
            } else {
                zzd(zzq2);
            }
        }
    }

    public final void zzP(String str, zzq zzq2) {
        zzaB().zzg();
        zzB();
        if (zzak(zzq2)) {
            if (!zzq2.zzh) {
                zzd(zzq2);
            } else if (!"_npa".equals(str) || zzq2.zzr == null) {
                zzaA().zzc().zzb("Removing user property", this.zzn.zzj().zzf(str));
                zzak zzak = this.zze;
                zzal(zzak);
                zzak.zzw();
                try {
                    zzd(zzq2);
                    if ("_id".equals(str)) {
                        zzak zzak2 = this.zze;
                        zzal(zzak2);
                        zzak2.zzA((String) Preconditions.checkNotNull(zzq2.zza), "_lair");
                    }
                    zzak zzak3 = this.zze;
                    zzal(zzak3);
                    zzak3.zzA((String) Preconditions.checkNotNull(zzq2.zza), str);
                    zzak zzak4 = this.zze;
                    zzal(zzak4);
                    zzak4.zzC();
                    zzaA().zzc().zzb("User property removed", this.zzn.zzj().zzf(str));
                } finally {
                    zzak zzak5 = this.zze;
                    zzal(zzak5);
                    zzak5.zzx();
                }
            } else {
                zzaA().zzc().zza("Falling back to manifest metadata value for ad personalization");
                zzW(new zzlk("_npa", zzax().currentTimeMillis(), Long.valueOf(true != zzq2.zzr.booleanValue() ? 0 : 1), TtmlNode.TEXT_EMPHASIS_AUTO), zzq2);
            }
        }
    }

    public final void zzQ(zzq zzq2) {
        if (this.zzy != null) {
            ArrayList arrayList = new ArrayList();
            this.zzz = arrayList;
            arrayList.addAll(this.zzy);
        }
        zzak zzak = this.zze;
        zzal(zzak);
        String str = (String) Preconditions.checkNotNull(zzq2.zza);
        Preconditions.checkNotEmpty(str);
        zzak.zzg();
        zzak.zzW();
        try {
            SQLiteDatabase zzh2 = zzak.zzh();
            String[] strArr = {str};
            int delete = zzh2.delete("apps", "app_id=?", strArr) + zzh2.delete(DbParams.TABLE_EVENTS, "app_id=?", strArr) + zzh2.delete("user_attributes", "app_id=?", strArr) + zzh2.delete("conditional_properties", "app_id=?", strArr) + zzh2.delete("raw_events", "app_id=?", strArr) + zzh2.delete("raw_events_metadata", "app_id=?", strArr) + zzh2.delete("queue", "app_id=?", strArr) + zzh2.delete("audience_filter_values", "app_id=?", strArr) + zzh2.delete("main_event_params", "app_id=?", strArr) + zzh2.delete("default_event_params", "app_id=?", strArr);
            if (delete > 0) {
                zzak.zzt.zzaA().zzj().zzc("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e11) {
            zzak.zzt.zzaA().zzd().zzc("Error resetting analytics data. appId, error", zzet.zzn(str), e11);
        }
        if (zzq2.zzh) {
            zzL(zzq2);
        }
    }

    public final void zzR(String str, zzir zzir) {
        zzaB().zzg();
        String str2 = this.zzE;
        if (str2 == null || str2.equals(str) || zzir != null) {
            this.zzE = str;
            this.zzD = zzir;
        }
    }

    public final void zzS() {
        zzaB().zzg();
        zzak zzak = this.zze;
        zzal(zzak);
        zzak.zzz();
        if (this.zzk.zzc.zza() == 0) {
            this.zzk.zzc.zzb(zzax().currentTimeMillis());
        }
        zzag();
    }

    public final void zzT(zzac zzac) {
        zzq zzac2 = zzac((String) Preconditions.checkNotNull(zzac.zza));
        if (zzac2 != null) {
            zzU(zzac, zzac2);
        }
    }

    public final void zzU(zzac zzac, zzq zzq2) {
        Preconditions.checkNotNull(zzac);
        Preconditions.checkNotEmpty(zzac.zza);
        Preconditions.checkNotNull(zzac.zzb);
        Preconditions.checkNotNull(zzac.zzc);
        Preconditions.checkNotEmpty(zzac.zzc.zzb);
        zzaB().zzg();
        zzB();
        if (zzak(zzq2)) {
            if (!zzq2.zzh) {
                zzd(zzq2);
                return;
            }
            zzac zzac2 = new zzac(zzac);
            boolean z11 = false;
            zzac2.zze = false;
            zzak zzak = this.zze;
            zzal(zzak);
            zzak.zzw();
            try {
                zzak zzak2 = this.zze;
                zzal(zzak2);
                zzac zzk2 = zzak2.zzk((String) Preconditions.checkNotNull(zzac2.zza), zzac2.zzc.zzb);
                if (zzk2 != null && !zzk2.zzb.equals(zzac2.zzb)) {
                    zzaA().zzk().zzd("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzn.zzj().zzf(zzac2.zzc.zzb), zzac2.zzb, zzk2.zzb);
                }
                if (zzk2 != null && zzk2.zze) {
                    zzac2.zzb = zzk2.zzb;
                    zzac2.zzd = zzk2.zzd;
                    zzac2.zzh = zzk2.zzh;
                    zzac2.zzf = zzk2.zzf;
                    zzac2.zzi = zzk2.zzi;
                    zzac2.zze = true;
                    zzlk zzlk = zzac2.zzc;
                    zzac2.zzc = new zzlk(zzlk.zzb, zzk2.zzc.zzc, zzlk.zza(), zzk2.zzc.zzf);
                } else if (TextUtils.isEmpty(zzac2.zzf)) {
                    zzlk zzlk2 = zzac2.zzc;
                    zzac2.zzc = new zzlk(zzlk2.zzb, zzac2.zzd, zzlk2.zza(), zzac2.zzc.zzf);
                    zzac2.zze = true;
                    z11 = true;
                }
                if (zzac2.zze) {
                    zzlk zzlk3 = zzac2.zzc;
                    zzlm zzlm = new zzlm((String) Preconditions.checkNotNull(zzac2.zza), zzac2.zzb, zzlk3.zzb, zzlk3.zzc, Preconditions.checkNotNull(zzlk3.zza()));
                    zzak zzak3 = this.zze;
                    zzal(zzak3);
                    if (zzak3.zzL(zzlm)) {
                        zzaA().zzc().zzd("User property updated immediately", zzac2.zza, this.zzn.zzj().zzf(zzlm.zzc), zzlm.zze);
                    } else {
                        zzaA().zzd().zzd("(2)Too many active user properties, ignoring", zzet.zzn(zzac2.zza), this.zzn.zzj().zzf(zzlm.zzc), zzlm.zze);
                    }
                    if (z11 && zzac2.zzi != null) {
                        zzY(new zzau(zzac2.zzi, zzac2.zzd), zzq2);
                    }
                }
                zzak zzak4 = this.zze;
                zzal(zzak4);
                if (zzak4.zzK(zzac2)) {
                    zzaA().zzc().zzd("Conditional property added", zzac2.zza, this.zzn.zzj().zzf(zzac2.zzc.zzb), zzac2.zzc.zza());
                } else {
                    zzaA().zzd().zzd("Too many conditional properties, ignoring", zzet.zzn(zzac2.zza), this.zzn.zzj().zzf(zzac2.zzc.zzb), zzac2.zzc.zza());
                }
                zzak zzak5 = this.zze;
                zzal(zzak5);
                zzak5.zzC();
            } finally {
                zzak zzak6 = this.zze;
                zzal(zzak6);
                zzak6.zzx();
            }
        }
    }

    public final void zzV(String str, zzhb zzhb) {
        zzaB().zzg();
        zzB();
        this.zzB.put(str, zzhb);
        zzak zzak = this.zze;
        zzal(zzak);
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzhb);
        zzak.zzg();
        zzak.zzW();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("consent_state", zzhb.zzi());
        try {
            if (zzak.zzh().insertWithOnConflict("consent_settings", (String) null, contentValues, 5) == -1) {
                zzak.zzt.zzaA().zzd().zzb("Failed to insert/update consent setting (got -1). appId", zzet.zzn(str));
            }
        } catch (SQLiteException e11) {
            zzak.zzt.zzaA().zzd().zzc("Error storing consent setting. appId, error", zzet.zzn(str), e11);
        }
    }

    public final void zzW(zzlk zzlk, zzq zzq2) {
        long j11;
        zzlk zzlk2 = zzlk;
        zzq zzq3 = zzq2;
        zzaB().zzg();
        zzB();
        if (zzak(zzq2)) {
            if (!zzq3.zzh) {
                zzd(zzq3);
                return;
            }
            int zzl2 = zzv().zzl(zzlk2.zzb);
            int i11 = 0;
            if (zzl2 != 0) {
                zzlp zzv2 = zzv();
                String str = zzlk2.zzb;
                zzg();
                String zzD2 = zzv2.zzD(str, 24, true);
                String str2 = zzlk2.zzb;
                zzv().zzO(this.zzF, zzq3.zza, zzl2, "_ev", zzD2, str2 != null ? str2.length() : 0);
                return;
            }
            int zzd2 = zzv().zzd(zzlk2.zzb, zzlk.zza());
            if (zzd2 != 0) {
                zzlp zzv3 = zzv();
                String str3 = zzlk2.zzb;
                zzg();
                String zzD3 = zzv3.zzD(str3, 24, true);
                Object zza2 = zzlk.zza();
                if (zza2 != null && ((zza2 instanceof String) || (zza2 instanceof CharSequence))) {
                    i11 = zza2.toString().length();
                }
                zzv().zzO(this.zzF, zzq3.zza, zzd2, "_ev", zzD3, i11);
                return;
            }
            Object zzB2 = zzv().zzB(zzlk2.zzb, zzlk.zza());
            if (zzB2 != null) {
                if ("_sid".equals(zzlk2.zzb)) {
                    long j12 = zzlk2.zzc;
                    String str4 = zzlk2.zzf;
                    String str5 = (String) Preconditions.checkNotNull(zzq3.zza);
                    zzak zzak = this.zze;
                    zzal(zzak);
                    zzlm zzp2 = zzak.zzp(str5, "_sno");
                    if (zzp2 != null) {
                        Object obj = zzp2.zze;
                        if (obj instanceof Long) {
                            j11 = ((Long) obj).longValue();
                            zzW(new zzlk("_sno", j12, Long.valueOf(j11 + 1), str4), zzq3);
                        }
                    }
                    if (zzp2 != null) {
                        zzaA().zzk().zzb("Retrieved last session number from database does not contain a valid (long) value", zzp2.zze);
                    }
                    zzak zzak2 = this.zze;
                    zzal(zzak2);
                    zzaq zzn2 = zzak2.zzn(str5, "_s");
                    if (zzn2 != null) {
                        j11 = zzn2.zzc;
                        zzaA().zzj().zzb("Backfill the session number. Last used session number", Long.valueOf(j11));
                    } else {
                        j11 = 0;
                    }
                    zzW(new zzlk("_sno", j12, Long.valueOf(j11 + 1), str4), zzq3);
                }
                zzlm zzlm = new zzlm((String) Preconditions.checkNotNull(zzq3.zza), (String) Preconditions.checkNotNull(zzlk2.zzf), zzlk2.zzb, zzlk2.zzc, zzB2);
                zzaA().zzj().zzc("Setting user property", this.zzn.zzj().zzf(zzlm.zzc), zzB2);
                zzak zzak3 = this.zze;
                zzal(zzak3);
                zzak3.zzw();
                try {
                    if ("_id".equals(zzlm.zzc)) {
                        zzak zzak4 = this.zze;
                        zzal(zzak4);
                        zzlm zzp3 = zzak4.zzp(zzq3.zza, "_id");
                        if (zzp3 != null && !zzlm.zze.equals(zzp3.zze)) {
                            zzak zzak5 = this.zze;
                            zzal(zzak5);
                            zzak5.zzA(zzq3.zza, "_lair");
                        }
                    }
                    zzd(zzq3);
                    zzak zzak6 = this.zze;
                    zzal(zzak6);
                    boolean zzL = zzak6.zzL(zzlm);
                    if (zzg().zzs((String) null, zzeg.zzaH) && "_sid".equals(zzlk2.zzb)) {
                        zzlj zzlj = this.zzi;
                        zzal(zzlj);
                        long zzd3 = zzlj.zzd(zzq3.zzx);
                        zzak zzak7 = this.zze;
                        zzal(zzak7);
                        zzh zzj2 = zzak7.zzj(zzq3.zza);
                        if (zzj2 != null) {
                            zzj2.zzaj(zzd3);
                            if (zzj2.zzao()) {
                                zzak zzak8 = this.zze;
                                zzal(zzak8);
                                zzak8.zzD(zzj2);
                            }
                        }
                    }
                    zzak zzak9 = this.zze;
                    zzal(zzak9);
                    zzak9.zzC();
                    if (!zzL) {
                        zzaA().zzd().zzc("Too many unique user properties are set. Ignoring user property", this.zzn.zzj().zzf(zzlm.zzc), zzlm.zze);
                        zzv().zzO(this.zzF, zzq3.zza, 9, (String) null, (String) null, 0);
                    }
                } finally {
                    zzak zzak10 = this.zze;
                    zzal(zzak10);
                    zzak10.zzx();
                }
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:217|218) */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0211, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0212, code lost:
        r8.zzt.zzaA().zzd().zzc("Failed to merge queued bundle. appId", com.google.android.gms.measurement.internal.zzet.zzn(r6), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:?, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x026b, code lost:
        r0 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:?, code lost:
        r0 = r0.subList(0, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x02fb, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x02fc, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:?, code lost:
        zzaA().zzd().zzc("Failed to parse upload URL. Not uploading. appId", com.google.android.gms.measurement.internal.zzet.zzn(r6), r0.zza());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:0x050e, code lost:
        if (r3 != null) goto L_0x04eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:264:0x0538, code lost:
        r1.zzv = r2;
        zzae();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:265:0x053d, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0126, code lost:
        if (r11 != null) goto L_0x0108;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:217:0x048c */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0294 A[SYNTHETIC, Splitter:B:142:0x0294] */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x029d A[Catch:{ all -> 0x03cc, all -> 0x0533 }] */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x04a7 A[Catch:{ all -> 0x03cc, all -> 0x0533 }] */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x0518 A[Catch:{ all -> 0x03cc, all -> 0x0533 }] */
    /* JADX WARNING: Removed duplicated region for block: B:257:0x052f A[SYNTHETIC, Splitter:B:257:0x052f] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0130 A[Catch:{ all -> 0x012c, all -> 0x0536 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:170:0x0302=Splitter:B:170:0x0302, B:247:0x0512=Splitter:B:247:0x0512, B:129:0x0268=Splitter:B:129:0x0268, B:139:0x027b=Splitter:B:139:0x027b, B:231:0x04eb=Splitter:B:231:0x04eb, B:217:0x048c=Splitter:B:217:0x048c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzX() {
        /*
            r22 = this;
            r1 = r22
            com.google.android.gms.measurement.internal.zzga r0 = r22.zzaB()
            r0.zzg()
            r22.zzB()
            r2 = 1
            r1.zzv = r2
            r3 = 0
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzn     // Catch:{ all -> 0x0536 }
            r0.zzay()     // Catch:{ all -> 0x0536 }
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzn     // Catch:{ all -> 0x0536 }
            com.google.android.gms.measurement.internal.zzjz r0 = r0.zzt()     // Catch:{ all -> 0x0536 }
            java.lang.Boolean r0 = r0.zzj()     // Catch:{ all -> 0x0536 }
            if (r0 != 0) goto L_0x0034
            com.google.android.gms.measurement.internal.zzet r0 = r22.zzaA()     // Catch:{ all -> 0x0536 }
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzk()     // Catch:{ all -> 0x0536 }
            java.lang.String r2 = "Upload data called on the client side before use of service was decided"
            r0.zza(r2)     // Catch:{ all -> 0x0536 }
            r1.zzv = r3
        L_0x0030:
            r22.zzae()
            return
        L_0x0034:
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0536 }
            if (r0 == 0) goto L_0x004a
            com.google.android.gms.measurement.internal.zzet r0 = r22.zzaA()     // Catch:{ all -> 0x0536 }
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzd()     // Catch:{ all -> 0x0536 }
            java.lang.String r2 = "Upload called in the client side when service should be used"
            r0.zza(r2)     // Catch:{ all -> 0x0536 }
            r1.zzv = r3
            goto L_0x0030
        L_0x004a:
            long r4 = r1.zza     // Catch:{ all -> 0x0536 }
            r6 = 0
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x0058
            r22.zzag()     // Catch:{ all -> 0x0536 }
            r1.zzv = r3
            goto L_0x0030
        L_0x0058:
            com.google.android.gms.measurement.internal.zzga r0 = r22.zzaB()     // Catch:{ all -> 0x0536 }
            r0.zzg()     // Catch:{ all -> 0x0536 }
            java.util.List r0 = r1.zzy     // Catch:{ all -> 0x0536 }
            if (r0 == 0) goto L_0x0073
            com.google.android.gms.measurement.internal.zzet r0 = r22.zzaA()     // Catch:{ all -> 0x0536 }
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzj()     // Catch:{ all -> 0x0536 }
            java.lang.String r2 = "Uploading requested multiple times"
            r0.zza(r2)     // Catch:{ all -> 0x0536 }
            r1.zzv = r3
            goto L_0x0030
        L_0x0073:
            com.google.android.gms.measurement.internal.zzez r0 = r1.zzd     // Catch:{ all -> 0x0536 }
            zzal(r0)     // Catch:{ all -> 0x0536 }
            boolean r0 = r0.zza()     // Catch:{ all -> 0x0536 }
            if (r0 != 0) goto L_0x0091
            com.google.android.gms.measurement.internal.zzet r0 = r22.zzaA()     // Catch:{ all -> 0x0536 }
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzj()     // Catch:{ all -> 0x0536 }
            java.lang.String r2 = "Network not connected, ignoring upload request"
            r0.zza(r2)     // Catch:{ all -> 0x0536 }
            r22.zzag()     // Catch:{ all -> 0x0536 }
            r1.zzv = r3
            goto L_0x0030
        L_0x0091:
            com.google.android.gms.common.util.Clock r0 = r22.zzax()     // Catch:{ all -> 0x0536 }
            long r4 = r0.currentTimeMillis()     // Catch:{ all -> 0x0536 }
            com.google.android.gms.measurement.internal.zzag r0 = r22.zzg()     // Catch:{ all -> 0x0536 }
            com.google.android.gms.measurement.internal.zzef r8 = com.google.android.gms.measurement.internal.zzeg.zzR     // Catch:{ all -> 0x0536 }
            r9 = 0
            int r0 = r0.zze(r9, r8)     // Catch:{ all -> 0x0536 }
            r22.zzg()     // Catch:{ all -> 0x0536 }
            long r10 = com.google.android.gms.measurement.internal.zzag.zzz()     // Catch:{ all -> 0x0536 }
            long r10 = r4 - r10
            r8 = r3
        L_0x00ae:
            if (r8 >= r0) goto L_0x00b9
            boolean r12 = r1.zzah(r9, r10)     // Catch:{ all -> 0x0536 }
            if (r12 == 0) goto L_0x00b9
            int r8 = r8 + 1
            goto L_0x00ae
        L_0x00b9:
            com.google.android.gms.measurement.internal.zzkb r0 = r1.zzk     // Catch:{ all -> 0x0536 }
            com.google.android.gms.measurement.internal.zzfe r0 = r0.zzc     // Catch:{ all -> 0x0536 }
            long r10 = r0.zza()     // Catch:{ all -> 0x0536 }
            int r0 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x00dc
            com.google.android.gms.measurement.internal.zzet r0 = r22.zzaA()     // Catch:{ all -> 0x0536 }
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzc()     // Catch:{ all -> 0x0536 }
            java.lang.String r6 = "Uploading events. Elapsed time since last upload attempt (ms)"
            long r7 = r4 - r10
            long r7 = java.lang.Math.abs(r7)     // Catch:{ all -> 0x0536 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0536 }
            r0.zzb(r6, r7)     // Catch:{ all -> 0x0536 }
        L_0x00dc:
            com.google.android.gms.measurement.internal.zzak r0 = r1.zze     // Catch:{ all -> 0x0536 }
            zzal(r0)     // Catch:{ all -> 0x0536 }
            java.lang.String r6 = r0.zzr()     // Catch:{ all -> 0x0536 }
            boolean r0 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0536 }
            r7 = -1
            if (r0 != 0) goto L_0x04ab
            long r10 = r1.zzA     // Catch:{ all -> 0x0536 }
            int r0 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r0 != 0) goto L_0x0134
            com.google.android.gms.measurement.internal.zzak r10 = r1.zze     // Catch:{ all -> 0x0536 }
            zzal(r10)     // Catch:{ all -> 0x0536 }
            android.database.sqlite.SQLiteDatabase r0 = r10.zzh()     // Catch:{ SQLiteException -> 0x0115, all -> 0x0113 }
            java.lang.String r11 = "select rowid from raw_events order by rowid desc limit 1;"
            android.database.Cursor r11 = r0.rawQuery(r11, r9)     // Catch:{ SQLiteException -> 0x0115, all -> 0x0113 }
            boolean r0 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x0111 }
            if (r0 != 0) goto L_0x010c
        L_0x0108:
            r11.close()     // Catch:{ all -> 0x0536 }
            goto L_0x0129
        L_0x010c:
            long r7 = r11.getLong(r3)     // Catch:{ SQLiteException -> 0x0111 }
            goto L_0x0108
        L_0x0111:
            r0 = move-exception
            goto L_0x0117
        L_0x0113:
            r0 = move-exception
            goto L_0x012e
        L_0x0115:
            r0 = move-exception
            r11 = r9
        L_0x0117:
            com.google.android.gms.measurement.internal.zzgd r10 = r10.zzt     // Catch:{ all -> 0x012c }
            com.google.android.gms.measurement.internal.zzet r10 = r10.zzaA()     // Catch:{ all -> 0x012c }
            com.google.android.gms.measurement.internal.zzer r10 = r10.zzd()     // Catch:{ all -> 0x012c }
            java.lang.String r12 = "Error querying raw events"
            r10.zzb(r12, r0)     // Catch:{ all -> 0x012c }
            if (r11 == 0) goto L_0x0129
            goto L_0x0108
        L_0x0129:
            r1.zzA = r7     // Catch:{ all -> 0x0536 }
            goto L_0x0134
        L_0x012c:
            r0 = move-exception
            r9 = r11
        L_0x012e:
            if (r9 == 0) goto L_0x0133
            r9.close()     // Catch:{ all -> 0x0536 }
        L_0x0133:
            throw r0     // Catch:{ all -> 0x0536 }
        L_0x0134:
            com.google.android.gms.measurement.internal.zzag r0 = r22.zzg()     // Catch:{ all -> 0x0536 }
            com.google.android.gms.measurement.internal.zzef r7 = com.google.android.gms.measurement.internal.zzeg.zzg     // Catch:{ all -> 0x0536 }
            int r0 = r0.zze(r6, r7)     // Catch:{ all -> 0x0536 }
            com.google.android.gms.measurement.internal.zzag r7 = r22.zzg()     // Catch:{ all -> 0x0536 }
            com.google.android.gms.measurement.internal.zzef r8 = com.google.android.gms.measurement.internal.zzeg.zzh     // Catch:{ all -> 0x0536 }
            int r7 = r7.zze(r6, r8)     // Catch:{ all -> 0x0536 }
            int r7 = java.lang.Math.max(r3, r7)     // Catch:{ all -> 0x0536 }
            com.google.android.gms.measurement.internal.zzak r8 = r1.zze     // Catch:{ all -> 0x0536 }
            zzal(r8)     // Catch:{ all -> 0x0536 }
            r8.zzg()     // Catch:{ all -> 0x0536 }
            r8.zzW()     // Catch:{ all -> 0x0536 }
            if (r0 <= 0) goto L_0x015b
            r10 = r2
            goto L_0x015c
        L_0x015b:
            r10 = r3
        L_0x015c:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r10)     // Catch:{ all -> 0x0536 }
            if (r7 <= 0) goto L_0x0163
            r10 = r2
            goto L_0x0164
        L_0x0163:
            r10 = r3
        L_0x0164:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r10)     // Catch:{ all -> 0x0536 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r6)     // Catch:{ all -> 0x0536 }
            android.database.sqlite.SQLiteDatabase r11 = r8.zzh()     // Catch:{ SQLiteException -> 0x0277, all -> 0x0273 }
            java.lang.String r12 = "queue"
            java.lang.String r13 = "rowid"
            java.lang.String r14 = "data"
            java.lang.String r15 = "retry_count"
            java.lang.String[] r13 = new java.lang.String[]{r13, r14, r15}     // Catch:{ SQLiteException -> 0x0277, all -> 0x0273 }
            java.lang.String r14 = "app_id=?"
            java.lang.String[] r15 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x0277, all -> 0x0273 }
            r15[r3] = r6     // Catch:{ SQLiteException -> 0x0277, all -> 0x0273 }
            r16 = 0
            r17 = 0
            java.lang.String r18 = "rowid"
            java.lang.String r19 = java.lang.String.valueOf(r0)     // Catch:{ SQLiteException -> 0x0277, all -> 0x0273 }
            android.database.Cursor r11 = r11.query(r12, r13, r14, r15, r16, r17, r18, r19)     // Catch:{ SQLiteException -> 0x0277, all -> 0x0273 }
            boolean r0 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x026f }
            if (r0 != 0) goto L_0x019f
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ SQLiteException -> 0x026f }
            r11.close()     // Catch:{ all -> 0x0536 }
            r20 = r4
            goto L_0x0297
        L_0x019f:
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x026f }
            r12.<init>()     // Catch:{ SQLiteException -> 0x026f }
            r13 = r3
        L_0x01a5:
            long r14 = r11.getLong(r3)     // Catch:{ SQLiteException -> 0x026f }
            byte[] r0 = r11.getBlob(r2)     // Catch:{ IOException -> 0x0242 }
            com.google.android.gms.measurement.internal.zzlh r9 = r8.zzf     // Catch:{ IOException -> 0x0242 }
            com.google.android.gms.measurement.internal.zzlj r9 = r9.zzi     // Catch:{ IOException -> 0x0242 }
            zzal(r9)     // Catch:{ IOException -> 0x0242 }
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x022d }
            r2.<init>(r0)     // Catch:{ IOException -> 0x022d }
            java.util.zip.GZIPInputStream r0 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x022d }
            r0.<init>(r2)     // Catch:{ IOException -> 0x022d }
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x022d }
            r3.<init>()     // Catch:{ IOException -> 0x022d }
            r10 = 1024(0x400, float:1.435E-42)
            byte[] r10 = new byte[r10]     // Catch:{ IOException -> 0x022d }
            r20 = r4
        L_0x01c9:
            int r4 = r0.read(r10)     // Catch:{ IOException -> 0x022b }
            if (r4 > 0) goto L_0x0226
            r0.close()     // Catch:{ IOException -> 0x022b }
            r2.close()     // Catch:{ IOException -> 0x022b }
            byte[] r0 = r3.toByteArray()     // Catch:{ IOException -> 0x022b }
            boolean r2 = r12.isEmpty()     // Catch:{ SQLiteException -> 0x026d }
            if (r2 != 0) goto L_0x01e5
            int r2 = r0.length     // Catch:{ SQLiteException -> 0x026d }
            int r2 = r2 + r13
            if (r2 <= r7) goto L_0x01e5
            goto L_0x0268
        L_0x01e5:
            com.google.android.gms.internal.measurement.zzgc r2 = com.google.android.gms.internal.measurement.zzgd.zzu()     // Catch:{ IOException -> 0x0211 }
            com.google.android.gms.internal.measurement.zzmh r2 = com.google.android.gms.measurement.internal.zzlj.zzm(r2, r0)     // Catch:{ IOException -> 0x0211 }
            com.google.android.gms.internal.measurement.zzgc r2 = (com.google.android.gms.internal.measurement.zzgc) r2     // Catch:{ IOException -> 0x0211 }
            r3 = 2
            boolean r4 = r11.isNull(r3)     // Catch:{ SQLiteException -> 0x026d }
            if (r4 != 0) goto L_0x01fd
            int r4 = r11.getInt(r3)     // Catch:{ SQLiteException -> 0x026d }
            r2.zzaf(r4)     // Catch:{ SQLiteException -> 0x026d }
        L_0x01fd:
            int r0 = r0.length     // Catch:{ SQLiteException -> 0x026d }
            int r13 = r13 + r0
            com.google.android.gms.internal.measurement.zzlb r0 = r2.zzaD()     // Catch:{ SQLiteException -> 0x026d }
            com.google.android.gms.internal.measurement.zzgd r0 = (com.google.android.gms.internal.measurement.zzgd) r0     // Catch:{ SQLiteException -> 0x026d }
            java.lang.Long r2 = java.lang.Long.valueOf(r14)     // Catch:{ SQLiteException -> 0x026d }
            android.util.Pair r0 = android.util.Pair.create(r0, r2)     // Catch:{ SQLiteException -> 0x026d }
            r12.add(r0)     // Catch:{ SQLiteException -> 0x026d }
            goto L_0x0258
        L_0x0211:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgd r2 = r8.zzt     // Catch:{ SQLiteException -> 0x026d }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzaA()     // Catch:{ SQLiteException -> 0x026d }
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzd()     // Catch:{ SQLiteException -> 0x026d }
            java.lang.String r3 = "Failed to merge queued bundle. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzet.zzn(r6)     // Catch:{ SQLiteException -> 0x026d }
            r2.zzc(r3, r4, r0)     // Catch:{ SQLiteException -> 0x026d }
            goto L_0x0258
        L_0x0226:
            r5 = 0
            r3.write(r10, r5, r4)     // Catch:{ IOException -> 0x022b }
            goto L_0x01c9
        L_0x022b:
            r0 = move-exception
            goto L_0x0230
        L_0x022d:
            r0 = move-exception
            r20 = r4
        L_0x0230:
            com.google.android.gms.measurement.internal.zzgd r2 = r9.zzt     // Catch:{ IOException -> 0x0240 }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzaA()     // Catch:{ IOException -> 0x0240 }
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzd()     // Catch:{ IOException -> 0x0240 }
            java.lang.String r3 = "Failed to ungzip content"
            r2.zzb(r3, r0)     // Catch:{ IOException -> 0x0240 }
            throw r0     // Catch:{ IOException -> 0x0240 }
        L_0x0240:
            r0 = move-exception
            goto L_0x0245
        L_0x0242:
            r0 = move-exception
            r20 = r4
        L_0x0245:
            com.google.android.gms.measurement.internal.zzgd r2 = r8.zzt     // Catch:{ SQLiteException -> 0x026d }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzaA()     // Catch:{ SQLiteException -> 0x026d }
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzd()     // Catch:{ SQLiteException -> 0x026d }
            java.lang.String r3 = "Failed to unzip queued bundle. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzet.zzn(r6)     // Catch:{ SQLiteException -> 0x026d }
            r2.zzc(r3, r4, r0)     // Catch:{ SQLiteException -> 0x026d }
        L_0x0258:
            boolean r0 = r11.moveToNext()     // Catch:{ SQLiteException -> 0x026d }
            if (r0 == 0) goto L_0x0268
            if (r13 <= r7) goto L_0x0261
            goto L_0x0268
        L_0x0261:
            r4 = r20
            r2 = 1
            r3 = 0
            r9 = 0
            goto L_0x01a5
        L_0x0268:
            r11.close()     // Catch:{ all -> 0x0533 }
            r0 = r12
            goto L_0x0297
        L_0x026d:
            r0 = move-exception
            goto L_0x027b
        L_0x026f:
            r0 = move-exception
            r20 = r4
            goto L_0x027b
        L_0x0273:
            r0 = move-exception
            r9 = 0
            goto L_0x04a5
        L_0x0277:
            r0 = move-exception
            r20 = r4
            r11 = 0
        L_0x027b:
            com.google.android.gms.measurement.internal.zzgd r2 = r8.zzt     // Catch:{ all -> 0x04a3 }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzaA()     // Catch:{ all -> 0x04a3 }
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzd()     // Catch:{ all -> 0x04a3 }
            java.lang.String r3 = "Error querying bundles. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzet.zzn(r6)     // Catch:{ all -> 0x04a3 }
            r2.zzc(r3, r4, r0)     // Catch:{ all -> 0x04a3 }
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ all -> 0x04a3 }
            if (r11 == 0) goto L_0x0297
            r11.close()     // Catch:{ all -> 0x0533 }
        L_0x0297:
            boolean r2 = r0.isEmpty()     // Catch:{ all -> 0x0533 }
            if (r2 != 0) goto L_0x0526
            com.google.android.gms.measurement.internal.zzhb r2 = r1.zzq(r6)     // Catch:{ all -> 0x0533 }
            com.google.android.gms.measurement.internal.zzha r3 = com.google.android.gms.measurement.internal.zzha.AD_STORAGE     // Catch:{ all -> 0x0533 }
            boolean r2 = r2.zzj(r3)     // Catch:{ all -> 0x0533 }
            if (r2 == 0) goto L_0x0302
            java.util.Iterator r2 = r0.iterator()     // Catch:{ all -> 0x0533 }
        L_0x02ad:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0533 }
            if (r3 == 0) goto L_0x02cc
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0533 }
            android.util.Pair r3 = (android.util.Pair) r3     // Catch:{ all -> 0x0533 }
            java.lang.Object r3 = r3.first     // Catch:{ all -> 0x0533 }
            com.google.android.gms.internal.measurement.zzgd r3 = (com.google.android.gms.internal.measurement.zzgd) r3     // Catch:{ all -> 0x0533 }
            java.lang.String r4 = r3.zzK()     // Catch:{ all -> 0x0533 }
            boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x0533 }
            if (r4 != 0) goto L_0x02ad
            java.lang.String r2 = r3.zzK()     // Catch:{ all -> 0x0533 }
            goto L_0x02cd
        L_0x02cc:
            r2 = 0
        L_0x02cd:
            if (r2 == 0) goto L_0x0302
            r3 = 0
        L_0x02d0:
            int r4 = r0.size()     // Catch:{ all -> 0x0533 }
            if (r3 >= r4) goto L_0x0302
            java.lang.Object r4 = r0.get(r3)     // Catch:{ all -> 0x0533 }
            android.util.Pair r4 = (android.util.Pair) r4     // Catch:{ all -> 0x0533 }
            java.lang.Object r4 = r4.first     // Catch:{ all -> 0x0533 }
            com.google.android.gms.internal.measurement.zzgd r4 = (com.google.android.gms.internal.measurement.zzgd) r4     // Catch:{ all -> 0x0533 }
            java.lang.String r5 = r4.zzK()     // Catch:{ all -> 0x0533 }
            boolean r5 = r5.isEmpty()     // Catch:{ all -> 0x0533 }
            if (r5 == 0) goto L_0x02eb
            goto L_0x02ff
        L_0x02eb:
            java.lang.String r4 = r4.zzK()     // Catch:{ all -> 0x0533 }
            boolean r4 = r4.equals(r2)     // Catch:{ all -> 0x0533 }
            if (r4 != 0) goto L_0x02ff
            r4 = 0
            java.util.List r0 = r0.subList(r4, r3)     // Catch:{ all -> 0x02fb }
            goto L_0x0302
        L_0x02fb:
            r0 = move-exception
            r2 = r4
            goto L_0x0538
        L_0x02ff:
            int r3 = r3 + 1
            goto L_0x02d0
        L_0x0302:
            com.google.android.gms.internal.measurement.zzga r2 = com.google.android.gms.internal.measurement.zzgb.zza()     // Catch:{ all -> 0x0533 }
            int r3 = r0.size()     // Catch:{ all -> 0x0533 }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x0533 }
            int r5 = r0.size()     // Catch:{ all -> 0x0533 }
            r4.<init>(r5)     // Catch:{ all -> 0x0533 }
            com.google.android.gms.measurement.internal.zzag r5 = r22.zzg()     // Catch:{ all -> 0x0533 }
            boolean r5 = r5.zzt(r6)     // Catch:{ all -> 0x0533 }
            if (r5 == 0) goto L_0x032b
            com.google.android.gms.measurement.internal.zzhb r5 = r1.zzq(r6)     // Catch:{ all -> 0x0533 }
            com.google.android.gms.measurement.internal.zzha r7 = com.google.android.gms.measurement.internal.zzha.AD_STORAGE     // Catch:{ all -> 0x0533 }
            boolean r5 = r5.zzj(r7)     // Catch:{ all -> 0x0533 }
            if (r5 == 0) goto L_0x032b
            r5 = 1
            goto L_0x032c
        L_0x032b:
            r5 = 0
        L_0x032c:
            com.google.android.gms.measurement.internal.zzhb r7 = r1.zzq(r6)     // Catch:{ all -> 0x0533 }
            com.google.android.gms.measurement.internal.zzha r8 = com.google.android.gms.measurement.internal.zzha.AD_STORAGE     // Catch:{ all -> 0x0533 }
            boolean r7 = r7.zzj(r8)     // Catch:{ all -> 0x0533 }
            com.google.android.gms.measurement.internal.zzhb r8 = r1.zzq(r6)     // Catch:{ all -> 0x0533 }
            com.google.android.gms.measurement.internal.zzha r9 = com.google.android.gms.measurement.internal.zzha.ANALYTICS_STORAGE     // Catch:{ all -> 0x0533 }
            boolean r8 = r8.zzj(r9)     // Catch:{ all -> 0x0533 }
            com.google.android.gms.internal.measurement.zzqu.zzc()     // Catch:{ all -> 0x0533 }
            com.google.android.gms.measurement.internal.zzag r9 = r22.zzg()     // Catch:{ all -> 0x0533 }
            com.google.android.gms.measurement.internal.zzef r10 = com.google.android.gms.measurement.internal.zzeg.zzao     // Catch:{ all -> 0x0533 }
            boolean r9 = r9.zzs(r6, r10)     // Catch:{ all -> 0x0533 }
            r10 = 0
        L_0x034e:
            if (r10 >= r3) goto L_0x03d0
            java.lang.Object r11 = r0.get(r10)     // Catch:{ all -> 0x0533 }
            android.util.Pair r11 = (android.util.Pair) r11     // Catch:{ all -> 0x0533 }
            java.lang.Object r11 = r11.first     // Catch:{ all -> 0x0533 }
            com.google.android.gms.internal.measurement.zzgd r11 = (com.google.android.gms.internal.measurement.zzgd) r11     // Catch:{ all -> 0x0533 }
            com.google.android.gms.internal.measurement.zzkx r11 = r11.zzbB()     // Catch:{ all -> 0x0533 }
            com.google.android.gms.internal.measurement.zzgc r11 = (com.google.android.gms.internal.measurement.zzgc) r11     // Catch:{ all -> 0x0533 }
            java.lang.Object r12 = r0.get(r10)     // Catch:{ all -> 0x0533 }
            android.util.Pair r12 = (android.util.Pair) r12     // Catch:{ all -> 0x0533 }
            java.lang.Object r12 = r12.second     // Catch:{ all -> 0x0533 }
            java.lang.Long r12 = (java.lang.Long) r12     // Catch:{ all -> 0x0533 }
            r4.add(r12)     // Catch:{ all -> 0x0533 }
            com.google.android.gms.measurement.internal.zzag r12 = r22.zzg()     // Catch:{ all -> 0x0533 }
            r12.zzh()     // Catch:{ all -> 0x0533 }
            r12 = 79000(0x13498, double:3.9031E-319)
            r11.zzam(r12)     // Catch:{ all -> 0x0533 }
            r12 = r20
            r11.zzal(r12)     // Catch:{ all -> 0x0533 }
            com.google.android.gms.measurement.internal.zzgd r14 = r1.zzn     // Catch:{ all -> 0x0533 }
            r14.zzay()     // Catch:{ all -> 0x0533 }
            r14 = 0
            r11.zzag(r14)     // Catch:{ all -> 0x03cc }
            if (r5 != 0) goto L_0x038d
            r11.zzq()     // Catch:{ all -> 0x0533 }
        L_0x038d:
            if (r7 != 0) goto L_0x0395
            r11.zzx()     // Catch:{ all -> 0x0533 }
            r11.zzt()     // Catch:{ all -> 0x0533 }
        L_0x0395:
            if (r8 != 0) goto L_0x039a
            r11.zzn()     // Catch:{ all -> 0x0533 }
        L_0x039a:
            r1.zzC(r6, r11)     // Catch:{ all -> 0x0533 }
            if (r9 != 0) goto L_0x03a2
            r11.zzy()     // Catch:{ all -> 0x0533 }
        L_0x03a2:
            com.google.android.gms.measurement.internal.zzag r14 = r22.zzg()     // Catch:{ all -> 0x0533 }
            com.google.android.gms.measurement.internal.zzef r15 = com.google.android.gms.measurement.internal.zzeg.zzV     // Catch:{ all -> 0x0533 }
            boolean r14 = r14.zzs(r6, r15)     // Catch:{ all -> 0x0533 }
            if (r14 == 0) goto L_0x03c4
            com.google.android.gms.internal.measurement.zzlb r14 = r11.zzaD()     // Catch:{ all -> 0x0533 }
            com.google.android.gms.internal.measurement.zzgd r14 = (com.google.android.gms.internal.measurement.zzgd) r14     // Catch:{ all -> 0x0533 }
            byte[] r14 = r14.zzbx()     // Catch:{ all -> 0x0533 }
            com.google.android.gms.measurement.internal.zzlj r15 = r1.zzi     // Catch:{ all -> 0x0533 }
            zzal(r15)     // Catch:{ all -> 0x0533 }
            long r14 = r15.zzf(r14)     // Catch:{ all -> 0x0533 }
            r11.zzJ(r14)     // Catch:{ all -> 0x0533 }
        L_0x03c4:
            r2.zza(r11)     // Catch:{ all -> 0x0533 }
            int r10 = r10 + 1
            r20 = r12
            goto L_0x034e
        L_0x03cc:
            r0 = move-exception
            r2 = r14
            goto L_0x0538
        L_0x03d0:
            r12 = r20
            com.google.android.gms.measurement.internal.zzet r0 = r22.zzaA()     // Catch:{ all -> 0x0533 }
            java.lang.String r0 = r0.zzr()     // Catch:{ all -> 0x0533 }
            r5 = 2
            boolean r0 = android.util.Log.isLoggable(r0, r5)     // Catch:{ all -> 0x0533 }
            if (r0 == 0) goto L_0x03f1
            com.google.android.gms.measurement.internal.zzlj r0 = r1.zzi     // Catch:{ all -> 0x0533 }
            zzal(r0)     // Catch:{ all -> 0x0533 }
            com.google.android.gms.internal.measurement.zzlb r5 = r2.zzaD()     // Catch:{ all -> 0x0533 }
            com.google.android.gms.internal.measurement.zzgb r5 = (com.google.android.gms.internal.measurement.zzgb) r5     // Catch:{ all -> 0x0533 }
            java.lang.String r9 = r0.zzo(r5)     // Catch:{ all -> 0x0533 }
            goto L_0x03f2
        L_0x03f1:
            r9 = 0
        L_0x03f2:
            com.google.android.gms.measurement.internal.zzlj r0 = r1.zzi     // Catch:{ all -> 0x0533 }
            zzal(r0)     // Catch:{ all -> 0x0533 }
            com.google.android.gms.internal.measurement.zzlb r0 = r2.zzaD()     // Catch:{ all -> 0x0533 }
            com.google.android.gms.internal.measurement.zzgb r0 = (com.google.android.gms.internal.measurement.zzgb) r0     // Catch:{ all -> 0x0533 }
            byte[] r14 = r0.zzbx()     // Catch:{ all -> 0x0533 }
            com.google.android.gms.measurement.internal.zzkw r0 = r1.zzl     // Catch:{ all -> 0x0533 }
            com.google.android.gms.measurement.internal.zzkv r0 = r0.zza(r6)     // Catch:{ all -> 0x0533 }
            boolean r5 = r4.isEmpty()     // Catch:{ MalformedURLException -> 0x048c }
            r7 = 1
            r5 = r5 ^ r7
            com.google.android.gms.common.internal.Preconditions.checkArgument(r5)     // Catch:{ MalformedURLException -> 0x048c }
            java.util.List r5 = r1.zzy     // Catch:{ MalformedURLException -> 0x048c }
            if (r5 == 0) goto L_0x0422
            com.google.android.gms.measurement.internal.zzet r4 = r22.zzaA()     // Catch:{ MalformedURLException -> 0x048c }
            com.google.android.gms.measurement.internal.zzer r4 = r4.zzd()     // Catch:{ MalformedURLException -> 0x048c }
            java.lang.String r5 = "Set uploading progress before finishing the previous upload"
            r4.zza(r5)     // Catch:{ MalformedURLException -> 0x048c }
            goto L_0x0429
        L_0x0422:
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ MalformedURLException -> 0x048c }
            r5.<init>(r4)     // Catch:{ MalformedURLException -> 0x048c }
            r1.zzy = r5     // Catch:{ MalformedURLException -> 0x048c }
        L_0x0429:
            com.google.android.gms.measurement.internal.zzkb r4 = r1.zzk     // Catch:{ MalformedURLException -> 0x048c }
            com.google.android.gms.measurement.internal.zzfe r4 = r4.zzd     // Catch:{ MalformedURLException -> 0x048c }
            r4.zzb(r12)     // Catch:{ MalformedURLException -> 0x048c }
            java.lang.String r4 = "?"
            if (r3 <= 0) goto L_0x043d
            r3 = 0
            com.google.android.gms.internal.measurement.zzgd r2 = r2.zzb(r3)     // Catch:{  }
            java.lang.String r4 = r2.zzy()     // Catch:{ MalformedURLException -> 0x048c }
        L_0x043d:
            com.google.android.gms.measurement.internal.zzet r2 = r22.zzaA()     // Catch:{ MalformedURLException -> 0x048c }
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzj()     // Catch:{ MalformedURLException -> 0x048c }
            java.lang.String r3 = "Uploading data. app, uncompressed size, data"
            int r5 = r14.length     // Catch:{ MalformedURLException -> 0x048c }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ MalformedURLException -> 0x048c }
            r2.zzd(r3, r4, r5, r9)     // Catch:{ MalformedURLException -> 0x048c }
            r2 = 1
            r1.zzu = r2     // Catch:{ MalformedURLException -> 0x048c }
            com.google.android.gms.measurement.internal.zzez r11 = r1.zzd     // Catch:{ MalformedURLException -> 0x048c }
            zzal(r11)     // Catch:{ MalformedURLException -> 0x048c }
            java.net.URL r13 = new java.net.URL     // Catch:{ MalformedURLException -> 0x048c }
            java.lang.String r2 = r0.zza()     // Catch:{ MalformedURLException -> 0x048c }
            r13.<init>(r2)     // Catch:{ MalformedURLException -> 0x048c }
            java.util.Map r15 = r0.zzb()     // Catch:{ MalformedURLException -> 0x048c }
            com.google.android.gms.measurement.internal.zzky r2 = new com.google.android.gms.measurement.internal.zzky     // Catch:{ MalformedURLException -> 0x048c }
            r2.<init>(r1, r6)     // Catch:{ MalformedURLException -> 0x048c }
            r11.zzg()     // Catch:{ MalformedURLException -> 0x048c }
            r11.zzW()     // Catch:{ MalformedURLException -> 0x048c }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r13)     // Catch:{ MalformedURLException -> 0x048c }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r14)     // Catch:{ MalformedURLException -> 0x048c }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r2)     // Catch:{ MalformedURLException -> 0x048c }
            com.google.android.gms.measurement.internal.zzgd r3 = r11.zzt     // Catch:{ MalformedURLException -> 0x048c }
            com.google.android.gms.measurement.internal.zzga r3 = r3.zzaB()     // Catch:{ MalformedURLException -> 0x048c }
            com.google.android.gms.measurement.internal.zzey r4 = new com.google.android.gms.measurement.internal.zzey     // Catch:{ MalformedURLException -> 0x048c }
            r10 = r4
            r12 = r6
            r16 = r2
            r10.<init>(r11, r12, r13, r14, r15, r16)     // Catch:{ MalformedURLException -> 0x048c }
            r3.zzo(r4)     // Catch:{ MalformedURLException -> 0x048c }
            goto L_0x0526
        L_0x048c:
            com.google.android.gms.measurement.internal.zzet r2 = r22.zzaA()     // Catch:{ all -> 0x0533 }
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzd()     // Catch:{ all -> 0x0533 }
            java.lang.String r3 = "Failed to parse upload URL. Not uploading. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzet.zzn(r6)     // Catch:{ all -> 0x0533 }
            java.lang.String r0 = r0.zza()     // Catch:{ all -> 0x0533 }
            r2.zzc(r3, r4, r0)     // Catch:{ all -> 0x0533 }
            goto L_0x0526
        L_0x04a3:
            r0 = move-exception
            r9 = r11
        L_0x04a5:
            if (r9 == 0) goto L_0x04aa
            r9.close()     // Catch:{ all -> 0x0533 }
        L_0x04aa:
            throw r0     // Catch:{ all -> 0x0533 }
        L_0x04ab:
            r12 = r4
            r1.zzA = r7     // Catch:{ all -> 0x0533 }
            com.google.android.gms.measurement.internal.zzak r2 = r1.zze     // Catch:{ all -> 0x0533 }
            zzal(r2)     // Catch:{ all -> 0x0533 }
            r22.zzg()     // Catch:{ all -> 0x0533 }
            long r3 = com.google.android.gms.measurement.internal.zzag.zzz()     // Catch:{ all -> 0x0533 }
            long r4 = r12 - r3
            r2.zzg()     // Catch:{ all -> 0x0533 }
            r2.zzW()     // Catch:{ all -> 0x0533 }
            android.database.sqlite.SQLiteDatabase r0 = r2.zzh()     // Catch:{ SQLiteException -> 0x04fd, all -> 0x04fa }
            java.lang.String r3 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            r6 = 1
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x04fd, all -> 0x04fa }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ SQLiteException -> 0x04fd, all -> 0x04fa }
            r5 = 0
            r6[r5] = r4     // Catch:{ SQLiteException -> 0x04fd, all -> 0x04fa }
            android.database.Cursor r3 = r0.rawQuery(r3, r6)     // Catch:{ SQLiteException -> 0x04fd, all -> 0x04fa }
            boolean r0 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x04f8 }
            if (r0 != 0) goto L_0x04ef
            com.google.android.gms.measurement.internal.zzgd r0 = r2.zzt     // Catch:{ SQLiteException -> 0x04f8 }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()     // Catch:{ SQLiteException -> 0x04f8 }
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzj()     // Catch:{ SQLiteException -> 0x04f8 }
            java.lang.String r4 = "No expired configs for apps with pending events"
            r0.zza(r4)     // Catch:{ SQLiteException -> 0x04f8 }
        L_0x04eb:
            r3.close()     // Catch:{ all -> 0x0533 }
            goto L_0x0511
        L_0x04ef:
            r4 = 0
            java.lang.String r9 = r3.getString(r4)     // Catch:{ SQLiteException -> 0x04f8 }
            r3.close()     // Catch:{ all -> 0x0533 }
            goto L_0x0512
        L_0x04f8:
            r0 = move-exception
            goto L_0x04ff
        L_0x04fa:
            r0 = move-exception
            r9 = 0
            goto L_0x052d
        L_0x04fd:
            r0 = move-exception
            r3 = 0
        L_0x04ff:
            com.google.android.gms.measurement.internal.zzgd r2 = r2.zzt     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzaA()     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzd()     // Catch:{ all -> 0x052b }
            java.lang.String r4 = "Error selecting expired configs"
            r2.zzb(r4, r0)     // Catch:{ all -> 0x052b }
            if (r3 == 0) goto L_0x0511
            goto L_0x04eb
        L_0x0511:
            r9 = 0
        L_0x0512:
            boolean r0 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x0533 }
            if (r0 != 0) goto L_0x0526
            com.google.android.gms.measurement.internal.zzak r0 = r1.zze     // Catch:{ all -> 0x0533 }
            zzal(r0)     // Catch:{ all -> 0x0533 }
            com.google.android.gms.measurement.internal.zzh r0 = r0.zzj(r9)     // Catch:{ all -> 0x0533 }
            if (r0 == 0) goto L_0x0526
            r1.zzD(r0)     // Catch:{ all -> 0x0533 }
        L_0x0526:
            r2 = 0
            r1.zzv = r2
            goto L_0x0030
        L_0x052b:
            r0 = move-exception
            r9 = r3
        L_0x052d:
            if (r9 == 0) goto L_0x0532
            r9.close()     // Catch:{ all -> 0x0533 }
        L_0x0532:
            throw r0     // Catch:{ all -> 0x0533 }
        L_0x0533:
            r0 = move-exception
            r2 = 0
            goto L_0x0538
        L_0x0536:
            r0 = move-exception
            r2 = r3
        L_0x0538:
            r1.zzv = r2
            r22.zzae()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzlh.zzX():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:240:0x07d2, code lost:
        if (r14.isEmpty() != false) goto L_0x07d4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0340 A[Catch:{ NumberFormatException -> 0x07bc, all -> 0x0b53 }] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0383 A[Catch:{ NumberFormatException -> 0x07bc, all -> 0x0b53 }] */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0386 A[Catch:{ NumberFormatException -> 0x07bc, all -> 0x0b53 }] */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x03e5 A[Catch:{ NumberFormatException -> 0x07bc, all -> 0x0b53 }] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0413  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0574 A[Catch:{ NumberFormatException -> 0x07bc, all -> 0x0b53 }] */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x05b4 A[Catch:{ NumberFormatException -> 0x07bc, all -> 0x0b53 }] */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x062d A[Catch:{ NumberFormatException -> 0x07bc, all -> 0x0b53 }] */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x0678 A[Catch:{ NumberFormatException -> 0x07bc, all -> 0x0b53 }] */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x0685 A[Catch:{ NumberFormatException -> 0x07bc, all -> 0x0b53 }] */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x0692 A[Catch:{ NumberFormatException -> 0x07bc, all -> 0x0b53 }] */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x06ca A[Catch:{ NumberFormatException -> 0x07bc, all -> 0x0b53 }] */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x06db A[Catch:{ NumberFormatException -> 0x07bc, all -> 0x0b53 }] */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x071e A[Catch:{ NumberFormatException -> 0x07bc, all -> 0x0b53 }] */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x0745 A[Catch:{ NumberFormatException -> 0x07bc, all -> 0x0b53 }] */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x074a A[Catch:{ NumberFormatException -> 0x07bc, all -> 0x0b53 }] */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x0750 A[Catch:{ NumberFormatException -> 0x07bc, all -> 0x0b53 }] */
    /* JADX WARNING: Removed duplicated region for block: B:243:0x07d7 A[Catch:{ NumberFormatException -> 0x07bc, all -> 0x0b53 }] */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x081d A[Catch:{ NumberFormatException -> 0x07bc, all -> 0x0b53 }] */
    /* JADX WARNING: Removed duplicated region for block: B:257:0x086c A[Catch:{ NumberFormatException -> 0x07bc, all -> 0x0b53 }] */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x0879 A[Catch:{ NumberFormatException -> 0x07bc, all -> 0x0b53 }] */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x0892 A[Catch:{ NumberFormatException -> 0x07bc, all -> 0x0b53 }] */
    /* JADX WARNING: Removed duplicated region for block: B:276:0x091e A[Catch:{ NumberFormatException -> 0x07bc, all -> 0x0b53 }] */
    /* JADX WARNING: Removed duplicated region for block: B:280:0x093e A[Catch:{ NumberFormatException -> 0x07bc, all -> 0x0b53 }] */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x0a0c A[Catch:{ NumberFormatException -> 0x07bc, all -> 0x0b53 }] */
    /* JADX WARNING: Removed duplicated region for block: B:311:0x0abc A[Catch:{ SQLiteException -> 0x0ad7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:312:0x0ad2  */
    /* JADX WARNING: Removed duplicated region for block: B:355:0x0a1e A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01ce A[Catch:{ NumberFormatException -> 0x07bc, all -> 0x0b53 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01e8 A[SYNTHETIC, Splitter:B:55:0x01e8] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x024c A[SYNTHETIC, Splitter:B:69:0x024c] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x025c A[Catch:{ NumberFormatException -> 0x07bc, all -> 0x0b53 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzY(com.google.android.gms.measurement.internal.zzau r36, com.google.android.gms.measurement.internal.zzq r37) {
        /*
            r35 = this;
            r1 = r35
            r2 = r36
            r3 = r37
            java.lang.String r4 = "metadata_fingerprint"
            java.lang.String r5 = "app_id"
            java.lang.String r6 = "raw_events"
            java.lang.String r7 = "_sno"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r37)
            java.lang.String r8 = r3.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)
            long r8 = java.lang.System.nanoTime()
            com.google.android.gms.measurement.internal.zzga r10 = r35.zzaB()
            r10.zzg()
            r35.zzB()
            java.lang.String r10 = r3.zza
            com.google.android.gms.measurement.internal.zzlj r11 = r1.zzi
            zzal(r11)
            boolean r11 = com.google.android.gms.measurement.internal.zzlj.zzB(r36, r37)
            if (r11 != 0) goto L_0x0032
            return
        L_0x0032:
            boolean r11 = r3.zzh
            if (r11 == 0) goto L_0x0b5e
            com.google.android.gms.measurement.internal.zzfu r11 = r1.zzc
            zzal(r11)
            java.lang.String r12 = r2.zza
            boolean r11 = r11.zzr(r10, r12)
            java.lang.String r15 = "_err"
            r14 = 0
            if (r11 == 0) goto L_0x00df
            com.google.android.gms.measurement.internal.zzet r3 = r35.zzaA()
            com.google.android.gms.measurement.internal.zzer r3 = r3.zzk()
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzet.zzn(r10)
            com.google.android.gms.measurement.internal.zzgd r5 = r1.zzn
            com.google.android.gms.measurement.internal.zzeo r5 = r5.zzj()
            java.lang.String r6 = r2.zza
            java.lang.String r5 = r5.zzd(r6)
            java.lang.String r6 = "Dropping blocked event. appId"
            r3.zzc(r6, r4, r5)
            com.google.android.gms.measurement.internal.zzfu r3 = r1.zzc
            zzal(r3)
            boolean r3 = r3.zzp(r10)
            if (r3 != 0) goto L_0x0097
            com.google.android.gms.measurement.internal.zzfu r3 = r1.zzc
            zzal(r3)
            boolean r3 = r3.zzs(r10)
            if (r3 == 0) goto L_0x007a
            goto L_0x0097
        L_0x007a:
            java.lang.String r3 = r2.zza
            boolean r3 = r15.equals(r3)
            if (r3 != 0) goto L_0x00de
            com.google.android.gms.measurement.internal.zzlp r11 = r35.zzv()
            com.google.android.gms.measurement.internal.zzlo r12 = r1.zzF
            java.lang.String r2 = r2.zza
            r14 = 11
            r17 = 0
            java.lang.String r15 = "_ev"
            r13 = r10
            r16 = r2
            r11.zzO(r12, r13, r14, r15, r16, r17)
            return
        L_0x0097:
            com.google.android.gms.measurement.internal.zzak r2 = r1.zze
            zzal(r2)
            com.google.android.gms.measurement.internal.zzh r2 = r2.zzj(r10)
            if (r2 == 0) goto L_0x00de
            long r3 = r2.zzl()
            long r5 = r2.zzc()
            long r3 = java.lang.Math.max(r3, r5)
            com.google.android.gms.common.util.Clock r5 = r35.zzax()
            long r5 = r5.currentTimeMillis()
            long r5 = r5 - r3
            long r3 = java.lang.Math.abs(r5)
            r35.zzg()
            com.google.android.gms.measurement.internal.zzef r5 = com.google.android.gms.measurement.internal.zzeg.zzz
            java.lang.Object r5 = r5.zza(r14)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 <= 0) goto L_0x00de
            com.google.android.gms.measurement.internal.zzet r3 = r35.zzaA()
            com.google.android.gms.measurement.internal.zzer r3 = r3.zzc()
            java.lang.String r4 = "Fetching config for blocked app"
            r3.zza(r4)
            r1.zzD(r2)
        L_0x00de:
            return
        L_0x00df:
            com.google.android.gms.measurement.internal.zzeu r2 = com.google.android.gms.measurement.internal.zzeu.zzb(r36)
            com.google.android.gms.measurement.internal.zzlp r11 = r35.zzv()
            com.google.android.gms.measurement.internal.zzag r12 = r35.zzg()
            int r12 = r12.zzd(r10)
            r11.zzN(r2, r12)
            com.google.android.gms.internal.measurement.zzpq.zzc()
            com.google.android.gms.measurement.internal.zzag r11 = r35.zzg()
            com.google.android.gms.measurement.internal.zzef r12 = com.google.android.gms.measurement.internal.zzeg.zzaA
            boolean r11 = r11.zzs(r14, r12)
            if (r11 == 0) goto L_0x0110
            com.google.android.gms.measurement.internal.zzag r11 = r35.zzg()
            com.google.android.gms.measurement.internal.zzef r12 = com.google.android.gms.measurement.internal.zzeg.zzQ
            r13 = 10
            r14 = 35
            int r11 = r11.zzf(r10, r12, r13, r14)
            goto L_0x0111
        L_0x0110:
            r11 = 0
        L_0x0111:
            java.util.TreeSet r12 = new java.util.TreeSet
            android.os.Bundle r13 = r2.zzd
            java.util.Set r13 = r13.keySet()
            r12.<init>(r13)
            java.util.Iterator r12 = r12.iterator()
        L_0x0120:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x015c
            java.lang.Object r13 = r12.next()
            java.lang.String r13 = (java.lang.String) r13
            java.lang.String r14 = "items"
            boolean r14 = r14.equals(r13)
            if (r14 == 0) goto L_0x0120
            com.google.android.gms.measurement.internal.zzlp r14 = r35.zzv()
            r17 = r12
            android.os.Bundle r12 = r2.zzd
            android.os.Parcelable[] r12 = r12.getParcelableArray(r13)
            com.google.android.gms.internal.measurement.zzpq.zzc()
            com.google.android.gms.measurement.internal.zzag r13 = r35.zzg()
            r18 = r15
            com.google.android.gms.measurement.internal.zzef r15 = com.google.android.gms.measurement.internal.zzeg.zzaA
            r28 = r8
            r8 = 0
            boolean r9 = r13.zzs(r8, r15)
            r14.zzM(r12, r11, r9)
            r12 = r17
            r15 = r18
            r8 = r28
            goto L_0x0120
        L_0x015c:
            r28 = r8
            r18 = r15
            com.google.android.gms.measurement.internal.zzau r2 = r2.zza()
            com.google.android.gms.measurement.internal.zzet r8 = r35.zzaA()
            java.lang.String r8 = r8.zzr()
            r9 = 2
            boolean r8 = android.util.Log.isLoggable(r8, r9)
            if (r8 == 0) goto L_0x018a
            com.google.android.gms.measurement.internal.zzet r8 = r35.zzaA()
            com.google.android.gms.measurement.internal.zzer r8 = r8.zzj()
            com.google.android.gms.measurement.internal.zzgd r11 = r1.zzn
            com.google.android.gms.measurement.internal.zzeo r11 = r11.zzj()
            java.lang.String r11 = r11.zzc(r2)
            java.lang.String r12 = "Logging event"
            r8.zzb(r12, r11)
        L_0x018a:
            com.google.android.gms.internal.measurement.zzpn.zzc()
            com.google.android.gms.measurement.internal.zzag r8 = r35.zzg()
            com.google.android.gms.measurement.internal.zzef r11 = com.google.android.gms.measurement.internal.zzeg.zzax
            r14 = 0
            r8.zzs(r14, r11)
            com.google.android.gms.measurement.internal.zzak r8 = r1.zze
            zzal(r8)
            r8.zzw()
            r1.zzd(r3)     // Catch:{ all -> 0x0b53 }
            java.lang.String r8 = "ecommerce_purchase"
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x0b53 }
            boolean r8 = r8.equals(r11)     // Catch:{ all -> 0x0b53 }
            java.lang.String r11 = "refund"
            if (r8 != 0) goto L_0x01c3
            java.lang.String r8 = "purchase"
            java.lang.String r12 = r2.zza     // Catch:{ all -> 0x0b53 }
            boolean r8 = r8.equals(r12)     // Catch:{ all -> 0x0b53 }
            if (r8 != 0) goto L_0x01c3
            java.lang.String r8 = r2.zza     // Catch:{ all -> 0x0b53 }
            boolean r8 = r11.equals(r8)     // Catch:{ all -> 0x0b53 }
            if (r8 == 0) goto L_0x01c1
            goto L_0x01c3
        L_0x01c1:
            r8 = 0
            goto L_0x01c4
        L_0x01c3:
            r8 = 1
        L_0x01c4:
            java.lang.String r12 = "_iap"
            java.lang.String r13 = r2.zza     // Catch:{ all -> 0x0b53 }
            boolean r12 = r12.equals(r13)     // Catch:{ all -> 0x0b53 }
            if (r12 != 0) goto L_0x01db
            if (r8 == 0) goto L_0x01d2
            r8 = 1
            goto L_0x01db
        L_0x01d2:
            r32 = r4
            r33 = r5
            r4 = r18
            r5 = 1
            goto L_0x0370
        L_0x01db:
            com.google.android.gms.measurement.internal.zzas r12 = r2.zzb     // Catch:{ all -> 0x0b53 }
            java.lang.String r13 = "currency"
            java.lang.String r12 = r12.zzg(r13)     // Catch:{ all -> 0x0b53 }
            java.lang.String r13 = "value"
            if (r8 == 0) goto L_0x024c
            com.google.android.gms.measurement.internal.zzas r8 = r2.zzb     // Catch:{ all -> 0x0b53 }
            java.lang.Double r8 = r8.zzd(r13)     // Catch:{ all -> 0x0b53 }
            double r16 = r8.doubleValue()     // Catch:{ all -> 0x0b53 }
            r19 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r16 = r16 * r19
            r21 = 0
            int r8 = (r16 > r21 ? 1 : (r16 == r21 ? 0 : -1))
            if (r8 != 0) goto L_0x020c
            com.google.android.gms.measurement.internal.zzas r8 = r2.zzb     // Catch:{ all -> 0x0b53 }
            java.lang.Long r8 = r8.zze(r13)     // Catch:{ all -> 0x0b53 }
            long r14 = r8.longValue()     // Catch:{ all -> 0x0b53 }
            double r13 = (double) r14     // Catch:{ all -> 0x0b53 }
            double r16 = r13 * r19
        L_0x020c:
            r13 = 4890909195324358656(0x43e0000000000000, double:9.223372036854776E18)
            int r8 = (r16 > r13 ? 1 : (r16 == r13 ? 0 : -1))
            if (r8 > 0) goto L_0x0226
            r13 = -4332462841530417152(0xc3e0000000000000, double:-9.223372036854776E18)
            int r8 = (r16 > r13 ? 1 : (r16 == r13 ? 0 : -1))
            if (r8 < 0) goto L_0x0226
            long r13 = java.lang.Math.round(r16)     // Catch:{ all -> 0x0b53 }
            java.lang.String r8 = r2.zza     // Catch:{ all -> 0x0b53 }
            boolean r8 = r11.equals(r8)     // Catch:{ all -> 0x0b53 }
            if (r8 == 0) goto L_0x0256
            long r13 = -r13
            goto L_0x0256
        L_0x0226:
            com.google.android.gms.measurement.internal.zzet r2 = r35.zzaA()     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzk()     // Catch:{ all -> 0x0b53 }
            java.lang.String r3 = "Data lost. Currency value is too big. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzet.zzn(r10)     // Catch:{ all -> 0x0b53 }
            java.lang.Double r5 = java.lang.Double.valueOf(r16)     // Catch:{ all -> 0x0b53 }
            r2.zzc(r3, r4, r5)     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzak r2 = r1.zze     // Catch:{ all -> 0x0b53 }
            zzal(r2)     // Catch:{ all -> 0x0b53 }
            r2.zzC()     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzak r2 = r1.zze
            zzal(r2)
            r2.zzx()
            return
        L_0x024c:
            com.google.android.gms.measurement.internal.zzas r8 = r2.zzb     // Catch:{ all -> 0x0b53 }
            java.lang.Long r8 = r8.zze(r13)     // Catch:{ all -> 0x0b53 }
            long r13 = r8.longValue()     // Catch:{ all -> 0x0b53 }
        L_0x0256:
            boolean r8 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x0b53 }
            if (r8 != 0) goto L_0x01d2
            java.util.Locale r8 = java.util.Locale.US     // Catch:{ all -> 0x0b53 }
            java.lang.String r8 = r12.toUpperCase(r8)     // Catch:{ all -> 0x0b53 }
            java.lang.String r11 = "[A-Z]{3}"
            boolean r11 = r8.matches(r11)     // Catch:{ all -> 0x0b53 }
            if (r11 == 0) goto L_0x01d2
            java.lang.String r11 = "_ltv_"
            java.lang.String r8 = r11.concat(r8)     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzak r11 = r1.zze     // Catch:{ all -> 0x0b53 }
            zzal(r11)     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzlm r11 = r11.zzp(r10, r8)     // Catch:{ all -> 0x0b53 }
            if (r11 == 0) goto L_0x02b4
            java.lang.Object r11 = r11.zze     // Catch:{ all -> 0x0b53 }
            boolean r12 = r11 instanceof java.lang.Long     // Catch:{ all -> 0x0b53 }
            if (r12 != 0) goto L_0x0282
            goto L_0x02b4
        L_0x0282:
            java.lang.Long r11 = (java.lang.Long) r11     // Catch:{ all -> 0x0b53 }
            long r11 = r11.longValue()     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzlm r19 = new com.google.android.gms.measurement.internal.zzlm     // Catch:{ all -> 0x0b53 }
            java.lang.String r15 = r2.zzc     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.common.util.Clock r16 = r35.zzax()     // Catch:{ all -> 0x0b53 }
            long r16 = r16.currentTimeMillis()     // Catch:{ all -> 0x0b53 }
            long r11 = r11 + r13
            java.lang.Long r20 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0b53 }
            r11 = r19
            r12 = r10
            r14 = 0
            r13 = r15
            r9 = r14
            r15 = 0
            r14 = r8
            r8 = r18
            r15 = r16
            r17 = r20
            r11.<init>(r12, r13, r14, r15, r17)     // Catch:{ all -> 0x0b53 }
            r32 = r4
            r33 = r5
            r4 = r8
            r8 = r19
            r5 = 1
            goto L_0x0335
        L_0x02b4:
            r15 = r18
            r9 = 0
            com.google.android.gms.measurement.internal.zzak r11 = r1.zze     // Catch:{ all -> 0x0b53 }
            zzal(r11)     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzag r12 = r35.zzg()     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzef r9 = com.google.android.gms.measurement.internal.zzeg.zzE     // Catch:{ all -> 0x0b53 }
            int r9 = r12.zze(r10, r9)     // Catch:{ all -> 0x0b53 }
            int r9 = r9 + -1
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)     // Catch:{ all -> 0x0b53 }
            r11.zzg()     // Catch:{ all -> 0x0b53 }
            r11.zzW()     // Catch:{ all -> 0x0b53 }
            android.database.sqlite.SQLiteDatabase r12 = r11.zzh()     // Catch:{ SQLiteException -> 0x02fd }
            r18 = r15
            java.lang.String r15 = "delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);"
            r32 = r4
            r4 = 3
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x02f5 }
            r16 = 0
            r4[r16] = r10     // Catch:{ SQLiteException -> 0x02f5 }
            r33 = r5
            r5 = 1
            r4[r5] = r10     // Catch:{ SQLiteException -> 0x02f3 }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ SQLiteException -> 0x02f3 }
            r16 = 2
            r4[r16] = r9     // Catch:{ SQLiteException -> 0x02f3 }
            r12.execSQL(r15, r4)     // Catch:{ SQLiteException -> 0x02f3 }
            goto L_0x0319
        L_0x02f3:
            r0 = move-exception
            goto L_0x0305
        L_0x02f5:
            r0 = move-exception
            goto L_0x02fa
        L_0x02f7:
            r0 = move-exception
            r32 = r4
        L_0x02fa:
            r33 = r5
            goto L_0x0304
        L_0x02fd:
            r0 = move-exception
            r32 = r4
            r33 = r5
            r18 = r15
        L_0x0304:
            r5 = 1
        L_0x0305:
            r4 = r0
            com.google.android.gms.measurement.internal.zzgd r9 = r11.zzt     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzet r9 = r9.zzaA()     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzer r9 = r9.zzd()     // Catch:{ all -> 0x0b53 }
            java.lang.String r11 = "Error pruning currencies. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzet.zzn(r10)     // Catch:{ all -> 0x0b53 }
            r9.zzc(r11, r12, r4)     // Catch:{ all -> 0x0b53 }
        L_0x0319:
            com.google.android.gms.measurement.internal.zzlm r19 = new com.google.android.gms.measurement.internal.zzlm     // Catch:{ all -> 0x0b53 }
            java.lang.String r4 = r2.zzc     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.common.util.Clock r9 = r35.zzax()     // Catch:{ all -> 0x0b53 }
            long r15 = r9.currentTimeMillis()     // Catch:{ all -> 0x0b53 }
            java.lang.Long r17 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x0b53 }
            r11 = r19
            r12 = r10
            r13 = r4
            r14 = r8
            r4 = r18
            r11.<init>(r12, r13, r14, r15, r17)     // Catch:{ all -> 0x0b53 }
            r8 = r19
        L_0x0335:
            com.google.android.gms.measurement.internal.zzak r9 = r1.zze     // Catch:{ all -> 0x0b53 }
            zzal(r9)     // Catch:{ all -> 0x0b53 }
            boolean r9 = r9.zzL(r8)     // Catch:{ all -> 0x0b53 }
            if (r9 != 0) goto L_0x0370
            com.google.android.gms.measurement.internal.zzet r9 = r35.zzaA()     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzer r9 = r9.zzd()     // Catch:{ all -> 0x0b53 }
            java.lang.String r11 = "Too many unique user properties are set. Ignoring user property. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzet.zzn(r10)     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzgd r13 = r1.zzn     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzeo r13 = r13.zzj()     // Catch:{ all -> 0x0b53 }
            java.lang.String r14 = r8.zzc     // Catch:{ all -> 0x0b53 }
            java.lang.String r13 = r13.zzf(r14)     // Catch:{ all -> 0x0b53 }
            java.lang.Object r8 = r8.zze     // Catch:{ all -> 0x0b53 }
            r9.zzd(r11, r12, r13, r8)     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzlp r11 = r35.zzv()     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzlo r12 = r1.zzF     // Catch:{ all -> 0x0b53 }
            r14 = 9
            r15 = 0
            r16 = 0
            r17 = 0
            r13 = r10
            r11.zzO(r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0b53 }
        L_0x0370:
            java.lang.String r8 = r2.zza     // Catch:{ all -> 0x0b53 }
            boolean r8 = com.google.android.gms.measurement.internal.zzlp.zzak(r8)     // Catch:{ all -> 0x0b53 }
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x0b53 }
            boolean r4 = r4.equals(r9)     // Catch:{ all -> 0x0b53 }
            r35.zzv()     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzas r9 = r2.zzb     // Catch:{ all -> 0x0b53 }
            if (r9 != 0) goto L_0x0386
            r12 = 0
            goto L_0x03a5
        L_0x0386:
            com.google.android.gms.measurement.internal.zzar r11 = new com.google.android.gms.measurement.internal.zzar     // Catch:{ all -> 0x0b53 }
            r11.<init>(r9)     // Catch:{ all -> 0x0b53 }
            r12 = 0
        L_0x038d:
            boolean r16 = r11.hasNext()     // Catch:{ all -> 0x0b53 }
            if (r16 == 0) goto L_0x03a5
            java.lang.String r14 = r11.next()     // Catch:{ all -> 0x0b53 }
            java.lang.Object r14 = r9.zzf(r14)     // Catch:{ all -> 0x0b53 }
            boolean r15 = r14 instanceof android.os.Parcelable[]     // Catch:{ all -> 0x0b53 }
            if (r15 == 0) goto L_0x038d
            android.os.Parcelable[] r14 = (android.os.Parcelable[]) r14     // Catch:{ all -> 0x0b53 }
            int r14 = r14.length     // Catch:{ all -> 0x0b53 }
            long r14 = (long) r14     // Catch:{ all -> 0x0b53 }
            long r12 = r12 + r14
            goto L_0x038d
        L_0x03a5:
            com.google.android.gms.measurement.internal.zzak r11 = r1.zze     // Catch:{ all -> 0x0b53 }
            zzal(r11)     // Catch:{ all -> 0x0b53 }
            long r14 = r35.zza()     // Catch:{ all -> 0x0b53 }
            r22 = 1
            long r18 = r12 + r22
            r9 = 1
            r20 = 0
            r21 = 0
            r12 = r14
            r30 = r6
            r5 = 0
            r14 = r10
            r15 = r18
            r17 = r9
            r18 = r8
            r19 = r20
            r20 = r4
            com.google.android.gms.measurement.internal.zzai r9 = r11.zzm(r12, r14, r15, r17, r18, r19, r20, r21)     // Catch:{ all -> 0x0b53 }
            long r11 = r9.zzb     // Catch:{ all -> 0x0b53 }
            r35.zzg()     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzef r13 = com.google.android.gms.measurement.internal.zzeg.zzk     // Catch:{ all -> 0x0b53 }
            r15 = 0
            java.lang.Object r13 = r13.zza(r15)     // Catch:{ all -> 0x0b53 }
            java.lang.Integer r13 = (java.lang.Integer) r13     // Catch:{ all -> 0x0b53 }
            int r13 = r13.intValue()     // Catch:{ all -> 0x0b53 }
            long r13 = (long) r13     // Catch:{ all -> 0x0b53 }
            long r11 = r11 - r13
            int r13 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            r16 = 1000(0x3e8, double:4.94E-321)
            if (r13 <= 0) goto L_0x0413
            long r11 = r11 % r16
            int r2 = (r11 > r22 ? 1 : (r11 == r22 ? 0 : -1))
            if (r2 != 0) goto L_0x0402
            com.google.android.gms.measurement.internal.zzet r2 = r35.zzaA()     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzd()     // Catch:{ all -> 0x0b53 }
            java.lang.String r3 = "Data loss. Too many events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzet.zzn(r10)     // Catch:{ all -> 0x0b53 }
            long r5 = r9.zzb     // Catch:{ all -> 0x0b53 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0b53 }
            r2.zzc(r3, r4, r5)     // Catch:{ all -> 0x0b53 }
        L_0x0402:
            com.google.android.gms.measurement.internal.zzak r2 = r1.zze     // Catch:{ all -> 0x0b53 }
            zzal(r2)     // Catch:{ all -> 0x0b53 }
            r2.zzC()     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzak r2 = r1.zze
            zzal(r2)
            r2.zzx()
            return
        L_0x0413:
            if (r8 == 0) goto L_0x046e
            long r11 = r9.zza     // Catch:{ all -> 0x0b53 }
            r35.zzg()     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzef r13 = com.google.android.gms.measurement.internal.zzeg.zzm     // Catch:{ all -> 0x0b53 }
            java.lang.Object r13 = r13.zza(r15)     // Catch:{ all -> 0x0b53 }
            java.lang.Integer r13 = (java.lang.Integer) r13     // Catch:{ all -> 0x0b53 }
            int r13 = r13.intValue()     // Catch:{ all -> 0x0b53 }
            long r13 = (long) r13     // Catch:{ all -> 0x0b53 }
            long r11 = r11 - r13
            int r13 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r13 <= 0) goto L_0x046e
            long r11 = r11 % r16
            int r3 = (r11 > r22 ? 1 : (r11 == r22 ? 0 : -1))
            if (r3 != 0) goto L_0x0449
            com.google.android.gms.measurement.internal.zzet r3 = r35.zzaA()     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzer r3 = r3.zzd()     // Catch:{ all -> 0x0b53 }
            java.lang.String r4 = "Data loss. Too many public events logged. appId, count"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzet.zzn(r10)     // Catch:{ all -> 0x0b53 }
            long r6 = r9.zza     // Catch:{ all -> 0x0b53 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0b53 }
            r3.zzc(r4, r5, r6)     // Catch:{ all -> 0x0b53 }
        L_0x0449:
            com.google.android.gms.measurement.internal.zzlp r11 = r35.zzv()     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzlo r12 = r1.zzF     // Catch:{ all -> 0x0b53 }
            r14 = 16
            java.lang.String r15 = "_ev"
            java.lang.String r2 = r2.zza     // Catch:{ all -> 0x0b53 }
            r17 = 0
            r13 = r10
            r16 = r2
            r11.zzO(r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzak r2 = r1.zze     // Catch:{ all -> 0x0b53 }
            zzal(r2)     // Catch:{ all -> 0x0b53 }
            r2.zzC()     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzak r2 = r1.zze
            zzal(r2)
            r2.zzx()
            return
        L_0x046e:
            r11 = 1000000(0xf4240, float:1.401298E-39)
            if (r4 == 0) goto L_0x04bc
            long r12 = r9.zzd     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzag r4 = r35.zzg()     // Catch:{ all -> 0x0b53 }
            java.lang.String r14 = r3.zza     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzef r15 = com.google.android.gms.measurement.internal.zzeg.zzl     // Catch:{ all -> 0x0b53 }
            int r4 = r4.zze(r14, r15)     // Catch:{ all -> 0x0b53 }
            int r4 = java.lang.Math.min(r11, r4)     // Catch:{ all -> 0x0b53 }
            r14 = 0
            int r4 = java.lang.Math.max(r14, r4)     // Catch:{ all -> 0x0b53 }
            long r14 = (long) r4     // Catch:{ all -> 0x0b53 }
            long r12 = r12 - r14
            int r4 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x04bc
            int r2 = (r12 > r22 ? 1 : (r12 == r22 ? 0 : -1))
            if (r2 != 0) goto L_0x04ab
            com.google.android.gms.measurement.internal.zzet r2 = r35.zzaA()     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzd()     // Catch:{ all -> 0x0b53 }
            java.lang.String r3 = "Too many error events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzet.zzn(r10)     // Catch:{ all -> 0x0b53 }
            long r5 = r9.zzd     // Catch:{ all -> 0x0b53 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0b53 }
            r2.zzc(r3, r4, r5)     // Catch:{ all -> 0x0b53 }
        L_0x04ab:
            com.google.android.gms.measurement.internal.zzak r2 = r1.zze     // Catch:{ all -> 0x0b53 }
            zzal(r2)     // Catch:{ all -> 0x0b53 }
            r2.zzC()     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzak r2 = r1.zze
            zzal(r2)
            r2.zzx()
            return
        L_0x04bc:
            com.google.android.gms.measurement.internal.zzas r4 = r2.zzb     // Catch:{ all -> 0x0b53 }
            android.os.Bundle r4 = r4.zzc()     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzlp r9 = r35.zzv()     // Catch:{ all -> 0x0b53 }
            java.lang.String r12 = "_o"
            java.lang.String r13 = r2.zzc     // Catch:{ all -> 0x0b53 }
            r9.zzP(r4, r12, r13)     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzlp r9 = r35.zzv()     // Catch:{ all -> 0x0b53 }
            boolean r9 = r9.zzaf(r10)     // Catch:{ all -> 0x0b53 }
            java.lang.String r15 = "_r"
            if (r9 == 0) goto L_0x04ed
            com.google.android.gms.measurement.internal.zzlp r9 = r35.zzv()     // Catch:{ all -> 0x0b53 }
            java.lang.String r12 = "_dbg"
            java.lang.Long r13 = java.lang.Long.valueOf(r22)     // Catch:{ all -> 0x0b53 }
            r9.zzP(r4, r12, r13)     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzlp r9 = r35.zzv()     // Catch:{ all -> 0x0b53 }
            r9.zzP(r4, r15, r13)     // Catch:{ all -> 0x0b53 }
        L_0x04ed:
            java.lang.String r9 = "_s"
            java.lang.String r12 = r2.zza     // Catch:{ all -> 0x0b53 }
            boolean r9 = r9.equals(r12)     // Catch:{ all -> 0x0b53 }
            if (r9 == 0) goto L_0x0513
            com.google.android.gms.measurement.internal.zzak r9 = r1.zze     // Catch:{ all -> 0x0b53 }
            zzal(r9)     // Catch:{ all -> 0x0b53 }
            java.lang.String r12 = r3.zza     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzlm r9 = r9.zzp(r12, r7)     // Catch:{ all -> 0x0b53 }
            if (r9 == 0) goto L_0x0513
            java.lang.Object r12 = r9.zze     // Catch:{ all -> 0x0b53 }
            boolean r12 = r12 instanceof java.lang.Long     // Catch:{ all -> 0x0b53 }
            if (r12 == 0) goto L_0x0513
            com.google.android.gms.measurement.internal.zzlp r12 = r35.zzv()     // Catch:{ all -> 0x0b53 }
            java.lang.Object r9 = r9.zze     // Catch:{ all -> 0x0b53 }
            r12.zzP(r4, r7, r9)     // Catch:{ all -> 0x0b53 }
        L_0x0513:
            com.google.android.gms.measurement.internal.zzak r7 = r1.zze     // Catch:{ all -> 0x0b53 }
            zzal(r7)     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)     // Catch:{ all -> 0x0b53 }
            r7.zzg()     // Catch:{ all -> 0x0b53 }
            r7.zzW()     // Catch:{ all -> 0x0b53 }
            android.database.sqlite.SQLiteDatabase r9 = r7.zzh()     // Catch:{ SQLiteException -> 0x0557 }
            com.google.android.gms.measurement.internal.zzgd r12 = r7.zzt     // Catch:{ SQLiteException -> 0x0557 }
            com.google.android.gms.measurement.internal.zzag r12 = r12.zzf()     // Catch:{ SQLiteException -> 0x0557 }
            com.google.android.gms.measurement.internal.zzef r13 = com.google.android.gms.measurement.internal.zzeg.zzp     // Catch:{ SQLiteException -> 0x0557 }
            int r12 = r12.zze(r10, r13)     // Catch:{ SQLiteException -> 0x0557 }
            int r11 = java.lang.Math.min(r11, r12)     // Catch:{ SQLiteException -> 0x0557 }
            r14 = 0
            int r11 = java.lang.Math.max(r14, r11)     // Catch:{ SQLiteException -> 0x0553 }
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ SQLiteException -> 0x0553 }
            java.lang.String r12 = "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)"
            r13 = 2
            java.lang.String[] r13 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x0553 }
            r13[r14] = r10     // Catch:{ SQLiteException -> 0x0553 }
            r17 = 1
            r13[r17] = r11     // Catch:{ SQLiteException -> 0x0553 }
            r11 = r30
            int r7 = r9.delete(r11, r12, r13)     // Catch:{ SQLiteException -> 0x0551 }
            long r12 = (long) r7
            goto L_0x0570
        L_0x0551:
            r0 = move-exception
            goto L_0x055b
        L_0x0553:
            r0 = move-exception
            r11 = r30
            goto L_0x055b
        L_0x0557:
            r0 = move-exception
            r11 = r30
            r14 = 0
        L_0x055b:
            r9 = r0
            com.google.android.gms.measurement.internal.zzgd r7 = r7.zzt     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzet r7 = r7.zzaA()     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzer r7 = r7.zzd()     // Catch:{ all -> 0x0b53 }
            java.lang.String r12 = "Error deleting over the limit events. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzet.zzn(r10)     // Catch:{ all -> 0x0b53 }
            r7.zzc(r12, r13, r9)     // Catch:{ all -> 0x0b53 }
            r12 = r5
        L_0x0570:
            int r7 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x0589
            com.google.android.gms.measurement.internal.zzet r7 = r35.zzaA()     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzer r7 = r7.zzk()     // Catch:{ all -> 0x0b53 }
            java.lang.String r9 = "Data lost. Too many events stored on disk, deleted. appId"
            java.lang.Object r14 = com.google.android.gms.measurement.internal.zzet.zzn(r10)     // Catch:{ all -> 0x0b53 }
            java.lang.Long r12 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x0b53 }
            r7.zzc(r9, r14, r12)     // Catch:{ all -> 0x0b53 }
        L_0x0589:
            com.google.android.gms.measurement.internal.zzap r7 = new com.google.android.gms.measurement.internal.zzap     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzgd r12 = r1.zzn     // Catch:{ all -> 0x0b53 }
            java.lang.String r13 = r2.zzc     // Catch:{ all -> 0x0b53 }
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x0b53 }
            long r5 = r2.zzd     // Catch:{ all -> 0x0b53 }
            r18 = 0
            r2 = r11
            r11 = r7
            r31 = 0
            r14 = r10
            r36 = r2
            r34 = r15
            r2 = 0
            r15 = r9
            r16 = r5
            r20 = r4
            r11.<init>((com.google.android.gms.measurement.internal.zzgd) r12, (java.lang.String) r13, (java.lang.String) r14, (java.lang.String) r15, (long) r16, (long) r18, (android.os.Bundle) r20)     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzak r4 = r1.zze     // Catch:{ all -> 0x0b53 }
            zzal(r4)     // Catch:{ all -> 0x0b53 }
            java.lang.String r5 = r7.zzb     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzaq r4 = r4.zzn(r10, r5)     // Catch:{ all -> 0x0b53 }
            if (r4 != 0) goto L_0x062d
            com.google.android.gms.measurement.internal.zzak r4 = r1.zze     // Catch:{ all -> 0x0b53 }
            zzal(r4)     // Catch:{ all -> 0x0b53 }
            long r4 = r4.zzf(r10)     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzag r6 = r35.zzg()     // Catch:{ all -> 0x0b53 }
            int r6 = r6.zzb(r10)     // Catch:{ all -> 0x0b53 }
            long r11 = (long) r6     // Catch:{ all -> 0x0b53 }
            int r4 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r4 < 0) goto L_0x060f
            if (r8 == 0) goto L_0x060f
            com.google.android.gms.measurement.internal.zzet r2 = r35.zzaA()     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzd()     // Catch:{ all -> 0x0b53 }
            java.lang.String r3 = "Too many event names used, ignoring event. appId, name, supported count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzet.zzn(r10)     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzgd r5 = r1.zzn     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzeo r5 = r5.zzj()     // Catch:{ all -> 0x0b53 }
            java.lang.String r6 = r7.zzb     // Catch:{ all -> 0x0b53 }
            java.lang.String r5 = r5.zzd(r6)     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzag r6 = r35.zzg()     // Catch:{ all -> 0x0b53 }
            int r6 = r6.zzb(r10)     // Catch:{ all -> 0x0b53 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0b53 }
            r2.zzd(r3, r4, r5, r6)     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzlp r11 = r35.zzv()     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzlo r12 = r1.zzF     // Catch:{ all -> 0x0b53 }
            r14 = 8
            r15 = 0
            r16 = 0
            r17 = 0
            r13 = r10
            r11.zzO(r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzak r2 = r1.zze
            zzal(r2)
            r2.zzx()
            return
        L_0x060f:
            com.google.android.gms.measurement.internal.zzaq r4 = new com.google.android.gms.measurement.internal.zzaq     // Catch:{ all -> 0x0b53 }
            java.lang.String r13 = r7.zzb     // Catch:{ all -> 0x0b53 }
            long r5 = r7.zzd     // Catch:{ all -> 0x0b53 }
            r14 = 0
            r16 = 0
            r18 = 0
            r22 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r11 = r4
            r12 = r10
            r20 = r5
            r11.<init>(r12, r13, r14, r16, r18, r20, r22, r24, r25, r26, r27)     // Catch:{ all -> 0x0b53 }
            goto L_0x063b
        L_0x062d:
            com.google.android.gms.measurement.internal.zzgd r5 = r1.zzn     // Catch:{ all -> 0x0b53 }
            long r8 = r4.zzf     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzap r7 = r7.zza(r5, r8)     // Catch:{ all -> 0x0b53 }
            long r5 = r7.zzd     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzaq r4 = r4.zzc(r5)     // Catch:{ all -> 0x0b53 }
        L_0x063b:
            com.google.android.gms.measurement.internal.zzak r5 = r1.zze     // Catch:{ all -> 0x0b53 }
            zzal(r5)     // Catch:{ all -> 0x0b53 }
            r5.zzE(r4)     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzga r4 = r35.zzaB()     // Catch:{ all -> 0x0b53 }
            r4.zzg()     // Catch:{ all -> 0x0b53 }
            r35.zzB()     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r37)     // Catch:{ all -> 0x0b53 }
            java.lang.String r4 = r7.zza     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r4)     // Catch:{ all -> 0x0b53 }
            java.lang.String r4 = r7.zza     // Catch:{ all -> 0x0b53 }
            java.lang.String r5 = r3.zza     // Catch:{ all -> 0x0b53 }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.common.internal.Preconditions.checkArgument(r4)     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.internal.measurement.zzgc r4 = com.google.android.gms.internal.measurement.zzgd.zzu()     // Catch:{ all -> 0x0b53 }
            r5 = 1
            r4.zzad(r5)     // Catch:{ all -> 0x0b53 }
            java.lang.String r6 = "android"
            r4.zzZ(r6)     // Catch:{ all -> 0x0b53 }
            java.lang.String r6 = r3.zza     // Catch:{ all -> 0x0b53 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0b53 }
            if (r6 != 0) goto L_0x067d
            java.lang.String r6 = r3.zza     // Catch:{ all -> 0x0b53 }
            r4.zzD(r6)     // Catch:{ all -> 0x0b53 }
        L_0x067d:
            java.lang.String r6 = r3.zzd     // Catch:{ all -> 0x0b53 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0b53 }
            if (r6 != 0) goto L_0x068a
            java.lang.String r6 = r3.zzd     // Catch:{ all -> 0x0b53 }
            r4.zzF(r6)     // Catch:{ all -> 0x0b53 }
        L_0x068a:
            java.lang.String r6 = r3.zzc     // Catch:{ all -> 0x0b53 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0b53 }
            if (r6 != 0) goto L_0x0697
            java.lang.String r6 = r3.zzc     // Catch:{ all -> 0x0b53 }
            r4.zzG(r6)     // Catch:{ all -> 0x0b53 }
        L_0x0697:
            com.google.android.gms.internal.measurement.zzqu.zzc()     // Catch:{ all -> 0x0b53 }
            java.lang.String r6 = r3.zzx     // Catch:{ all -> 0x0b53 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0b53 }
            if (r6 != 0) goto L_0x06c1
            com.google.android.gms.measurement.internal.zzag r6 = r35.zzg()     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzef r8 = com.google.android.gms.measurement.internal.zzeg.zzam     // Catch:{ all -> 0x0b53 }
            boolean r6 = r6.zzs(r2, r8)     // Catch:{ all -> 0x0b53 }
            if (r6 != 0) goto L_0x06bc
            com.google.android.gms.measurement.internal.zzag r6 = r35.zzg()     // Catch:{ all -> 0x0b53 }
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzef r9 = com.google.android.gms.measurement.internal.zzeg.zzao     // Catch:{ all -> 0x0b53 }
            boolean r6 = r6.zzs(r8, r9)     // Catch:{ all -> 0x0b53 }
            if (r6 == 0) goto L_0x06c1
        L_0x06bc:
            java.lang.String r6 = r3.zzx     // Catch:{ all -> 0x0b53 }
            r4.zzah(r6)     // Catch:{ all -> 0x0b53 }
        L_0x06c1:
            long r8 = r3.zzj     // Catch:{ all -> 0x0b53 }
            r10 = -2147483648(0xffffffff80000000, double:NaN)
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x06ce
            int r6 = (int) r8     // Catch:{ all -> 0x0b53 }
            r4.zzH(r6)     // Catch:{ all -> 0x0b53 }
        L_0x06ce:
            long r8 = r3.zze     // Catch:{ all -> 0x0b53 }
            r4.zzV(r8)     // Catch:{ all -> 0x0b53 }
            java.lang.String r6 = r3.zzb     // Catch:{ all -> 0x0b53 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0b53 }
            if (r6 != 0) goto L_0x06e0
            java.lang.String r6 = r3.zzb     // Catch:{ all -> 0x0b53 }
            r4.zzU(r6)     // Catch:{ all -> 0x0b53 }
        L_0x06e0:
            java.lang.String r6 = r3.zza     // Catch:{ all -> 0x0b53 }
            java.lang.Object r6 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r6)     // Catch:{ all -> 0x0b53 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzhb r6 = r1.zzq(r6)     // Catch:{ all -> 0x0b53 }
            java.lang.String r8 = r3.zzv     // Catch:{ all -> 0x0b53 }
            r9 = 100
            com.google.android.gms.measurement.internal.zzhb r8 = com.google.android.gms.measurement.internal.zzhb.zzc(r8, r9)     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzhb r6 = r6.zzd(r8)     // Catch:{ all -> 0x0b53 }
            java.lang.String r6 = r6.zzi()     // Catch:{ all -> 0x0b53 }
            r4.zzL(r6)     // Catch:{ all -> 0x0b53 }
            java.lang.String r6 = r4.zzar()     // Catch:{ all -> 0x0b53 }
            boolean r6 = r6.isEmpty()     // Catch:{ all -> 0x0b53 }
            if (r6 == 0) goto L_0x0716
            java.lang.String r6 = r3.zzq     // Catch:{ all -> 0x0b53 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0b53 }
            if (r6 != 0) goto L_0x0716
            java.lang.String r6 = r3.zzq     // Catch:{ all -> 0x0b53 }
            r4.zzC(r6)     // Catch:{ all -> 0x0b53 }
        L_0x0716:
            long r10 = r3.zzf     // Catch:{ all -> 0x0b53 }
            r12 = 0
            int r6 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r6 == 0) goto L_0x0721
            r4.zzM(r10)     // Catch:{ all -> 0x0b53 }
        L_0x0721:
            long r10 = r3.zzs     // Catch:{ all -> 0x0b53 }
            r4.zzP(r10)     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzlj r6 = r1.zzi     // Catch:{ all -> 0x0b53 }
            zzal(r6)     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzlh r8 = r6.zzf     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzgd r8 = r8.zzn     // Catch:{ all -> 0x0b53 }
            android.content.Context r8 = r8.zzaw()     // Catch:{ all -> 0x0b53 }
            android.content.ContentResolver r8 = r8.getContentResolver()     // Catch:{ all -> 0x0b53 }
            java.lang.String r10 = "com.google.android.gms.measurement"
            android.net.Uri r10 = com.google.android.gms.internal.measurement.zzhq.zza(r10)     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzaw r11 = com.google.android.gms.measurement.internal.zzaw.zza     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.internal.measurement.zzhf r8 = com.google.android.gms.internal.measurement.zzhf.zza(r8, r10, r11)     // Catch:{ all -> 0x0b53 }
            if (r8 != 0) goto L_0x074a
            java.util.Map r8 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x0b53 }
            goto L_0x074e
        L_0x074a:
            java.util.Map r8 = r8.zzc()     // Catch:{ all -> 0x0b53 }
        L_0x074e:
            if (r8 == 0) goto L_0x07d4
            boolean r10 = r8.isEmpty()     // Catch:{ all -> 0x0b53 }
            if (r10 == 0) goto L_0x0758
            goto L_0x07d4
        L_0x0758:
            java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x0b53 }
            r14.<init>()     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzef r10 = com.google.android.gms.measurement.internal.zzeg.zzP     // Catch:{ all -> 0x0b53 }
            java.lang.Object r10 = r10.zza(r2)     // Catch:{ all -> 0x0b53 }
            java.lang.Integer r10 = (java.lang.Integer) r10     // Catch:{ all -> 0x0b53 }
            int r10 = r10.intValue()     // Catch:{ all -> 0x0b53 }
            java.util.Set r8 = r8.entrySet()     // Catch:{ all -> 0x0b53 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x0b53 }
        L_0x0771:
            boolean r11 = r8.hasNext()     // Catch:{ all -> 0x0b53 }
            if (r11 == 0) goto L_0x07ce
            java.lang.Object r11 = r8.next()     // Catch:{ all -> 0x0b53 }
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11     // Catch:{ all -> 0x0b53 }
            java.lang.Object r12 = r11.getKey()     // Catch:{ all -> 0x0b53 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x0b53 }
            java.lang.String r13 = "measurement.id."
            boolean r12 = r12.startsWith(r13)     // Catch:{ all -> 0x0b53 }
            if (r12 == 0) goto L_0x0771
            java.lang.Object r11 = r11.getValue()     // Catch:{ NumberFormatException -> 0x07bc }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ NumberFormatException -> 0x07bc }
            int r11 = java.lang.Integer.parseInt(r11)     // Catch:{ NumberFormatException -> 0x07bc }
            if (r11 == 0) goto L_0x0771
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ NumberFormatException -> 0x07bc }
            r14.add(r11)     // Catch:{ NumberFormatException -> 0x07bc }
            int r11 = r14.size()     // Catch:{ NumberFormatException -> 0x07bc }
            if (r11 < r10) goto L_0x0771
            com.google.android.gms.measurement.internal.zzgd r11 = r6.zzt     // Catch:{ NumberFormatException -> 0x07bc }
            com.google.android.gms.measurement.internal.zzet r11 = r11.zzaA()     // Catch:{ NumberFormatException -> 0x07bc }
            com.google.android.gms.measurement.internal.zzer r11 = r11.zzk()     // Catch:{ NumberFormatException -> 0x07bc }
            java.lang.String r12 = "Too many experiment IDs. Number of IDs"
            int r13 = r14.size()     // Catch:{ NumberFormatException -> 0x07bc }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ NumberFormatException -> 0x07bc }
            r11.zzb(r12, r13)     // Catch:{ NumberFormatException -> 0x07bc }
            goto L_0x07ce
        L_0x07bc:
            r0 = move-exception
            r11 = r0
            com.google.android.gms.measurement.internal.zzgd r12 = r6.zzt     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzet r12 = r12.zzaA()     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzer r12 = r12.zzk()     // Catch:{ all -> 0x0b53 }
            java.lang.String r13 = "Experiment ID NumberFormatException"
            r12.zzb(r13, r11)     // Catch:{ all -> 0x0b53 }
            goto L_0x0771
        L_0x07ce:
            boolean r6 = r14.isEmpty()     // Catch:{ all -> 0x0b53 }
            if (r6 == 0) goto L_0x07d5
        L_0x07d4:
            r14 = r2
        L_0x07d5:
            if (r14 == 0) goto L_0x07da
            r4.zzh(r14)     // Catch:{ all -> 0x0b53 }
        L_0x07da:
            java.lang.String r6 = r3.zza     // Catch:{ all -> 0x0b53 }
            java.lang.Object r6 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r6)     // Catch:{ all -> 0x0b53 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzhb r6 = r1.zzq(r6)     // Catch:{ all -> 0x0b53 }
            java.lang.String r8 = r3.zzv     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzhb r8 = com.google.android.gms.measurement.internal.zzhb.zzc(r8, r9)     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzhb r6 = r6.zzd(r8)     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzha r8 = com.google.android.gms.measurement.internal.zzha.AD_STORAGE     // Catch:{ all -> 0x0b53 }
            boolean r9 = r6.zzj(r8)     // Catch:{ all -> 0x0b53 }
            if (r9 == 0) goto L_0x0826
            boolean r9 = r3.zzo     // Catch:{ all -> 0x0b53 }
            if (r9 == 0) goto L_0x0826
            com.google.android.gms.measurement.internal.zzkb r9 = r1.zzk     // Catch:{ all -> 0x0b53 }
            java.lang.String r10 = r3.zza     // Catch:{ all -> 0x0b53 }
            android.util.Pair r9 = r9.zzd(r10, r6)     // Catch:{ all -> 0x0b53 }
            java.lang.Object r10 = r9.first     // Catch:{ all -> 0x0b53 }
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ all -> 0x0b53 }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x0b53 }
            if (r10 != 0) goto L_0x0826
            boolean r10 = r3.zzo     // Catch:{ all -> 0x0b53 }
            if (r10 == 0) goto L_0x0826
            java.lang.Object r10 = r9.first     // Catch:{ all -> 0x0b53 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x0b53 }
            r4.zzae(r10)     // Catch:{ all -> 0x0b53 }
            java.lang.Object r9 = r9.second     // Catch:{ all -> 0x0b53 }
            if (r9 == 0) goto L_0x0826
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch:{ all -> 0x0b53 }
            boolean r9 = r9.booleanValue()     // Catch:{ all -> 0x0b53 }
            r4.zzX(r9)     // Catch:{ all -> 0x0b53 }
        L_0x0826:
            com.google.android.gms.measurement.internal.zzgd r9 = r1.zzn     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzao r9 = r9.zzg()     // Catch:{ all -> 0x0b53 }
            r9.zzv()     // Catch:{ all -> 0x0b53 }
            java.lang.String r9 = android.os.Build.MODEL     // Catch:{ all -> 0x0b53 }
            r4.zzN(r9)     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzgd r9 = r1.zzn     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzao r9 = r9.zzg()     // Catch:{ all -> 0x0b53 }
            r9.zzv()     // Catch:{ all -> 0x0b53 }
            java.lang.String r9 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x0b53 }
            r4.zzY(r9)     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzgd r9 = r1.zzn     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzao r9 = r9.zzg()     // Catch:{ all -> 0x0b53 }
            long r9 = r9.zzb()     // Catch:{ all -> 0x0b53 }
            int r9 = (int) r9     // Catch:{ all -> 0x0b53 }
            r4.zzak(r9)     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzgd r9 = r1.zzn     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzao r9 = r9.zzg()     // Catch:{ all -> 0x0b53 }
            java.lang.String r9 = r9.zzc()     // Catch:{ all -> 0x0b53 }
            r4.zzao(r9)     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.internal.measurement.zzpz.zzc()     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzag r9 = r35.zzg()     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzef r10 = com.google.android.gms.measurement.internal.zzeg.zzaE     // Catch:{ all -> 0x0b53 }
            boolean r9 = r9.zzs(r2, r10)     // Catch:{ all -> 0x0b53 }
            if (r9 == 0) goto L_0x0871
            long r9 = r3.zzz     // Catch:{ all -> 0x0b53 }
            r4.zzaj(r9)     // Catch:{ all -> 0x0b53 }
        L_0x0871:
            com.google.android.gms.measurement.internal.zzgd r9 = r1.zzn     // Catch:{ all -> 0x0b53 }
            boolean r9 = r9.zzJ()     // Catch:{ all -> 0x0b53 }
            if (r9 == 0) goto L_0x0885
            r4.zzaq()     // Catch:{ all -> 0x0b53 }
            boolean r9 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0b53 }
            if (r9 != 0) goto L_0x0885
            r4.zzO(r2)     // Catch:{ all -> 0x0b53 }
        L_0x0885:
            com.google.android.gms.measurement.internal.zzak r9 = r1.zze     // Catch:{ all -> 0x0b53 }
            zzal(r9)     // Catch:{ all -> 0x0b53 }
            java.lang.String r10 = r3.zza     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzh r9 = r9.zzj(r10)     // Catch:{ all -> 0x0b53 }
            if (r9 != 0) goto L_0x08f5
            com.google.android.gms.measurement.internal.zzh r9 = new com.google.android.gms.measurement.internal.zzh     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzgd r10 = r1.zzn     // Catch:{ all -> 0x0b53 }
            java.lang.String r11 = r3.zza     // Catch:{ all -> 0x0b53 }
            r9.<init>(r10, r11)     // Catch:{ all -> 0x0b53 }
            java.lang.String r10 = r1.zzw(r6)     // Catch:{ all -> 0x0b53 }
            r9.zzJ(r10)     // Catch:{ all -> 0x0b53 }
            java.lang.String r10 = r3.zzk     // Catch:{ all -> 0x0b53 }
            r9.zzX(r10)     // Catch:{ all -> 0x0b53 }
            java.lang.String r10 = r3.zzb     // Catch:{ all -> 0x0b53 }
            r9.zzY(r10)     // Catch:{ all -> 0x0b53 }
            boolean r8 = r6.zzj(r8)     // Catch:{ all -> 0x0b53 }
            if (r8 == 0) goto L_0x08bf
            com.google.android.gms.measurement.internal.zzkb r8 = r1.zzk     // Catch:{ all -> 0x0b53 }
            java.lang.String r10 = r3.zza     // Catch:{ all -> 0x0b53 }
            boolean r11 = r3.zzo     // Catch:{ all -> 0x0b53 }
            java.lang.String r8 = r8.zzf(r10, r11)     // Catch:{ all -> 0x0b53 }
            r9.zzag(r8)     // Catch:{ all -> 0x0b53 }
        L_0x08bf:
            r10 = 0
            r9.zzac(r10)     // Catch:{ all -> 0x0b53 }
            r9.zzad(r10)     // Catch:{ all -> 0x0b53 }
            r9.zzab(r10)     // Catch:{ all -> 0x0b53 }
            java.lang.String r8 = r3.zzc     // Catch:{ all -> 0x0b53 }
            r9.zzL(r8)     // Catch:{ all -> 0x0b53 }
            long r10 = r3.zzj     // Catch:{ all -> 0x0b53 }
            r9.zzM(r10)     // Catch:{ all -> 0x0b53 }
            java.lang.String r8 = r3.zzd     // Catch:{ all -> 0x0b53 }
            r9.zzK(r8)     // Catch:{ all -> 0x0b53 }
            long r10 = r3.zze     // Catch:{ all -> 0x0b53 }
            r9.zzZ(r10)     // Catch:{ all -> 0x0b53 }
            long r10 = r3.zzf     // Catch:{ all -> 0x0b53 }
            r9.zzU(r10)     // Catch:{ all -> 0x0b53 }
            boolean r8 = r3.zzh     // Catch:{ all -> 0x0b53 }
            r9.zzae(r8)     // Catch:{ all -> 0x0b53 }
            long r10 = r3.zzs     // Catch:{ all -> 0x0b53 }
            r9.zzV(r10)     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzak r8 = r1.zze     // Catch:{ all -> 0x0b53 }
            zzal(r8)     // Catch:{ all -> 0x0b53 }
            r8.zzD(r9)     // Catch:{ all -> 0x0b53 }
        L_0x08f5:
            com.google.android.gms.measurement.internal.zzha r8 = com.google.android.gms.measurement.internal.zzha.ANALYTICS_STORAGE     // Catch:{ all -> 0x0b53 }
            boolean r6 = r6.zzj(r8)     // Catch:{ all -> 0x0b53 }
            if (r6 == 0) goto L_0x0914
            java.lang.String r6 = r9.zzw()     // Catch:{ all -> 0x0b53 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0b53 }
            if (r6 != 0) goto L_0x0914
            java.lang.String r6 = r9.zzw()     // Catch:{ all -> 0x0b53 }
            java.lang.Object r6 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r6)     // Catch:{ all -> 0x0b53 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0b53 }
            r4.zzE(r6)     // Catch:{ all -> 0x0b53 }
        L_0x0914:
            java.lang.String r6 = r9.zzz()     // Catch:{ all -> 0x0b53 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0b53 }
            if (r6 != 0) goto L_0x092b
            java.lang.String r6 = r9.zzz()     // Catch:{ all -> 0x0b53 }
            java.lang.Object r6 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r6)     // Catch:{ all -> 0x0b53 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0b53 }
            r4.zzT(r6)     // Catch:{ all -> 0x0b53 }
        L_0x092b:
            com.google.android.gms.measurement.internal.zzak r6 = r1.zze     // Catch:{ all -> 0x0b53 }
            zzal(r6)     // Catch:{ all -> 0x0b53 }
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0b53 }
            java.util.List r6 = r6.zzu(r8)     // Catch:{ all -> 0x0b53 }
            r13 = r31
        L_0x0938:
            int r8 = r6.size()     // Catch:{ all -> 0x0b53 }
            if (r13 >= r8) goto L_0x09aa
            com.google.android.gms.internal.measurement.zzgl r8 = com.google.android.gms.internal.measurement.zzgm.zzd()     // Catch:{ all -> 0x0b53 }
            java.lang.Object r10 = r6.get(r13)     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzlm r10 = (com.google.android.gms.measurement.internal.zzlm) r10     // Catch:{ all -> 0x0b53 }
            java.lang.String r10 = r10.zzc     // Catch:{ all -> 0x0b53 }
            r8.zzf(r10)     // Catch:{ all -> 0x0b53 }
            java.lang.Object r10 = r6.get(r13)     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzlm r10 = (com.google.android.gms.measurement.internal.zzlm) r10     // Catch:{ all -> 0x0b53 }
            long r10 = r10.zzd     // Catch:{ all -> 0x0b53 }
            r8.zzg(r10)     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzlj r10 = r1.zzi     // Catch:{ all -> 0x0b53 }
            zzal(r10)     // Catch:{ all -> 0x0b53 }
            java.lang.Object r11 = r6.get(r13)     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzlm r11 = (com.google.android.gms.measurement.internal.zzlm) r11     // Catch:{ all -> 0x0b53 }
            java.lang.Object r11 = r11.zze     // Catch:{ all -> 0x0b53 }
            r10.zzv(r8, r11)     // Catch:{ all -> 0x0b53 }
            r4.zzl(r8)     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzag r8 = r35.zzg()     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzef r10 = com.google.android.gms.measurement.internal.zzeg.zzaH     // Catch:{ all -> 0x0b53 }
            boolean r8 = r8.zzs(r2, r10)     // Catch:{ all -> 0x0b53 }
            if (r8 == 0) goto L_0x09a7
            java.lang.String r8 = "_sid"
            java.lang.Object r10 = r6.get(r13)     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzlm r10 = (com.google.android.gms.measurement.internal.zzlm) r10     // Catch:{ all -> 0x0b53 }
            java.lang.String r10 = r10.zzc     // Catch:{ all -> 0x0b53 }
            boolean r8 = r8.equals(r10)     // Catch:{ all -> 0x0b53 }
            if (r8 == 0) goto L_0x09a7
            long r10 = r9.zzq()     // Catch:{ all -> 0x0b53 }
            r14 = 0
            int r8 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
            if (r8 == 0) goto L_0x09a7
            com.google.android.gms.measurement.internal.zzlj r8 = r1.zzi     // Catch:{ all -> 0x0b53 }
            zzal(r8)     // Catch:{ all -> 0x0b53 }
            java.lang.String r10 = r3.zzx     // Catch:{ all -> 0x0b53 }
            long r10 = r8.zzd(r10)     // Catch:{ all -> 0x0b53 }
            long r14 = r9.zzq()     // Catch:{ all -> 0x0b53 }
            int r8 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
            if (r8 == 0) goto L_0x09a7
            r4.zzy()     // Catch:{ all -> 0x0b53 }
        L_0x09a7:
            int r13 = r13 + 1
            goto L_0x0938
        L_0x09aa:
            com.google.android.gms.measurement.internal.zzak r3 = r1.zze     // Catch:{ IOException -> 0x0b09 }
            zzal(r3)     // Catch:{ IOException -> 0x0b09 }
            com.google.android.gms.internal.measurement.zzlb r6 = r4.zzaD()     // Catch:{ IOException -> 0x0b09 }
            com.google.android.gms.internal.measurement.zzgd r6 = (com.google.android.gms.internal.measurement.zzgd) r6     // Catch:{ IOException -> 0x0b09 }
            r3.zzg()     // Catch:{ IOException -> 0x0b09 }
            r3.zzW()     // Catch:{ IOException -> 0x0b09 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r6)     // Catch:{ IOException -> 0x0b09 }
            java.lang.String r8 = r6.zzy()     // Catch:{ IOException -> 0x0b09 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)     // Catch:{ IOException -> 0x0b09 }
            byte[] r8 = r6.zzbx()     // Catch:{ IOException -> 0x0b09 }
            com.google.android.gms.measurement.internal.zzlh r9 = r3.zzf     // Catch:{ IOException -> 0x0b09 }
            com.google.android.gms.measurement.internal.zzlj r9 = r9.zzi     // Catch:{ IOException -> 0x0b09 }
            zzal(r9)     // Catch:{ IOException -> 0x0b09 }
            long r9 = r9.zzf(r8)     // Catch:{ IOException -> 0x0b09 }
            android.content.ContentValues r11 = new android.content.ContentValues     // Catch:{ IOException -> 0x0b09 }
            r11.<init>()     // Catch:{ IOException -> 0x0b09 }
            java.lang.String r12 = r6.zzy()     // Catch:{ IOException -> 0x0b09 }
            r13 = r33
            r11.put(r13, r12)     // Catch:{ IOException -> 0x0b09 }
            java.lang.Long r12 = java.lang.Long.valueOf(r9)     // Catch:{ IOException -> 0x0b09 }
            r14 = r32
            r11.put(r14, r12)     // Catch:{ IOException -> 0x0b09 }
            java.lang.String r12 = "metadata"
            r11.put(r12, r8)     // Catch:{ IOException -> 0x0b09 }
            android.database.sqlite.SQLiteDatabase r8 = r3.zzh()     // Catch:{ SQLiteException -> 0x0aef }
            java.lang.String r12 = "raw_events_metadata"
            r15 = 4
            r8.insertWithOnConflict(r12, r2, r11, r15)     // Catch:{ SQLiteException -> 0x0aef }
            com.google.android.gms.measurement.internal.zzak r3 = r1.zze     // Catch:{ all -> 0x0b53 }
            zzal(r3)     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzas r4 = r7.zzf     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzar r6 = new com.google.android.gms.measurement.internal.zzar     // Catch:{ all -> 0x0b53 }
            r6.<init>(r4)     // Catch:{ all -> 0x0b53 }
        L_0x0a06:
            boolean r4 = r6.hasNext()     // Catch:{ all -> 0x0b53 }
            if (r4 == 0) goto L_0x0a1e
            java.lang.String r4 = r6.next()     // Catch:{ all -> 0x0b53 }
            r8 = r34
            boolean r4 = r8.equals(r4)     // Catch:{ all -> 0x0b53 }
            if (r4 == 0) goto L_0x0a1b
            r31 = r5
            goto L_0x0a5d
        L_0x0a1b:
            r34 = r8
            goto L_0x0a06
        L_0x0a1e:
            com.google.android.gms.measurement.internal.zzfu r4 = r1.zzc     // Catch:{ all -> 0x0b53 }
            zzal(r4)     // Catch:{ all -> 0x0b53 }
            java.lang.String r6 = r7.zza     // Catch:{ all -> 0x0b53 }
            java.lang.String r8 = r7.zzb     // Catch:{ all -> 0x0b53 }
            boolean r4 = r4.zzq(r6, r8)     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzak r15 = r1.zze     // Catch:{ all -> 0x0b53 }
            zzal(r15)     // Catch:{ all -> 0x0b53 }
            long r16 = r35.zza()     // Catch:{ all -> 0x0b53 }
            java.lang.String r6 = r7.zza     // Catch:{ all -> 0x0b53 }
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r18 = r6
            com.google.android.gms.measurement.internal.zzai r6 = r15.zzl(r16, r18, r19, r20, r21, r22, r23)     // Catch:{ all -> 0x0b53 }
            if (r4 == 0) goto L_0x0a5d
            long r11 = r6.zze     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzag r4 = r35.zzg()     // Catch:{ all -> 0x0b53 }
            java.lang.String r6 = r7.zza     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzef r8 = com.google.android.gms.measurement.internal.zzeg.zzo     // Catch:{ all -> 0x0b53 }
            int r4 = r4.zze(r6, r8)     // Catch:{ all -> 0x0b53 }
            long r5 = (long) r4     // Catch:{ all -> 0x0b53 }
            int r4 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r4 >= 0) goto L_0x0a5d
            r31 = 1
        L_0x0a5d:
            r3.zzg()     // Catch:{ all -> 0x0b53 }
            r3.zzW()     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)     // Catch:{ all -> 0x0b53 }
            java.lang.String r4 = r7.zza     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r4)     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzlh r4 = r3.zzf     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzlj r4 = r4.zzi     // Catch:{ all -> 0x0b53 }
            zzal(r4)     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.internal.measurement.zzft r4 = r4.zzl(r7)     // Catch:{ all -> 0x0b53 }
            byte[] r4 = r4.zzbx()     // Catch:{ all -> 0x0b53 }
            android.content.ContentValues r5 = new android.content.ContentValues     // Catch:{ all -> 0x0b53 }
            r5.<init>()     // Catch:{ all -> 0x0b53 }
            java.lang.String r6 = r7.zza     // Catch:{ all -> 0x0b53 }
            r5.put(r13, r6)     // Catch:{ all -> 0x0b53 }
            java.lang.String r6 = "name"
            java.lang.String r8 = r7.zzb     // Catch:{ all -> 0x0b53 }
            r5.put(r6, r8)     // Catch:{ all -> 0x0b53 }
            java.lang.String r6 = "timestamp"
            long r11 = r7.zzd     // Catch:{ all -> 0x0b53 }
            java.lang.Long r8 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0b53 }
            r5.put(r6, r8)     // Catch:{ all -> 0x0b53 }
            java.lang.Long r6 = java.lang.Long.valueOf(r9)     // Catch:{ all -> 0x0b53 }
            r5.put(r14, r6)     // Catch:{ all -> 0x0b53 }
            java.lang.String r6 = "data"
            r5.put(r6, r4)     // Catch:{ all -> 0x0b53 }
            java.lang.String r4 = "realtime"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r31)     // Catch:{ all -> 0x0b53 }
            r5.put(r4, r6)     // Catch:{ all -> 0x0b53 }
            android.database.sqlite.SQLiteDatabase r4 = r3.zzh()     // Catch:{ SQLiteException -> 0x0ad7 }
            r6 = r36
            long r4 = r4.insert(r6, r2, r5)     // Catch:{ SQLiteException -> 0x0ad7 }
            r8 = -1
            int r2 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r2 != 0) goto L_0x0ad2
            com.google.android.gms.measurement.internal.zzgd r2 = r3.zzt     // Catch:{ SQLiteException -> 0x0ad7 }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzaA()     // Catch:{ SQLiteException -> 0x0ad7 }
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzd()     // Catch:{ SQLiteException -> 0x0ad7 }
            java.lang.String r4 = "Failed to insert raw event (got -1). appId"
            java.lang.String r5 = r7.zza     // Catch:{ SQLiteException -> 0x0ad7 }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzet.zzn(r5)     // Catch:{ SQLiteException -> 0x0ad7 }
            r2.zzb(r4, r5)     // Catch:{ SQLiteException -> 0x0ad7 }
            goto L_0x0b20
        L_0x0ad2:
            r4 = 0
            r1.zza = r4     // Catch:{ all -> 0x0b53 }
            goto L_0x0b20
        L_0x0ad7:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.zzgd r3 = r3.zzt     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzet r3 = r3.zzaA()     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzer r3 = r3.zzd()     // Catch:{ all -> 0x0b53 }
            java.lang.String r4 = "Error storing raw event. appId"
            java.lang.String r5 = r7.zza     // Catch:{ all -> 0x0b53 }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzet.zzn(r5)     // Catch:{ all -> 0x0b53 }
            r3.zzc(r4, r5, r2)     // Catch:{ all -> 0x0b53 }
            goto L_0x0b20
        L_0x0aef:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.zzgd r3 = r3.zzt     // Catch:{ IOException -> 0x0b09 }
            com.google.android.gms.measurement.internal.zzet r3 = r3.zzaA()     // Catch:{ IOException -> 0x0b09 }
            com.google.android.gms.measurement.internal.zzer r3 = r3.zzd()     // Catch:{ IOException -> 0x0b09 }
            java.lang.String r5 = "Error storing raw event metadata. appId"
            java.lang.String r6 = r6.zzy()     // Catch:{ IOException -> 0x0b09 }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzet.zzn(r6)     // Catch:{ IOException -> 0x0b09 }
            r3.zzc(r5, r6, r2)     // Catch:{ IOException -> 0x0b09 }
            throw r2     // Catch:{ IOException -> 0x0b09 }
        L_0x0b09:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.zzet r3 = r35.zzaA()     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzer r3 = r3.zzd()     // Catch:{ all -> 0x0b53 }
            java.lang.String r5 = "Data loss. Failed to insert raw event metadata. appId"
            java.lang.String r4 = r4.zzaq()     // Catch:{ all -> 0x0b53 }
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzet.zzn(r4)     // Catch:{ all -> 0x0b53 }
            r3.zzc(r5, r4, r2)     // Catch:{ all -> 0x0b53 }
        L_0x0b20:
            com.google.android.gms.measurement.internal.zzak r2 = r1.zze     // Catch:{ all -> 0x0b53 }
            zzal(r2)     // Catch:{ all -> 0x0b53 }
            r2.zzC()     // Catch:{ all -> 0x0b53 }
            com.google.android.gms.measurement.internal.zzak r2 = r1.zze
            zzal(r2)
            r2.zzx()
            r35.zzag()
            com.google.android.gms.measurement.internal.zzet r2 = r35.zzaA()
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzj()
            long r3 = java.lang.System.nanoTime()
            long r3 = r3 - r28
            r5 = 500000(0x7a120, double:2.47033E-318)
            long r3 = r3 + r5
            r5 = 1000000(0xf4240, double:4.940656E-318)
            long r3 = r3 / r5
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.String r4 = "Background event processing time, ms"
            r2.zzb(r4, r3)
            return
        L_0x0b53:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.zzak r3 = r1.zze
            zzal(r3)
            r3.zzx()
            throw r2
        L_0x0b5e:
            r1.zzd(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzlh.zzY(com.google.android.gms.measurement.internal.zzau, com.google.android.gms.measurement.internal.zzq):void");
    }

    public final boolean zzZ() {
        zzaB().zzg();
        FileLock fileLock = this.zzw;
        if (fileLock == null || !fileLock.isValid()) {
            this.zze.zzt.zzf();
            try {
                FileChannel channel = new RandomAccessFile(new File(this.zzn.zzaw().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
                this.zzx = channel;
                FileLock tryLock = channel.tryLock();
                this.zzw = tryLock;
                if (tryLock != null) {
                    zzaA().zzj().zza("Storage concurrent access okay");
                    return true;
                }
                zzaA().zzd().zza("Storage concurrent data access panic");
                return false;
            } catch (FileNotFoundException e11) {
                zzaA().zzd().zzb("Failed to acquire storage lock", e11);
                return false;
            } catch (IOException e12) {
                zzaA().zzd().zzb("Failed to access storage lock file", e12);
                return false;
            } catch (OverlappingFileLockException e13) {
                zzaA().zzk().zzb("Storage lock already acquired", e13);
                return false;
            }
        } else {
            zzaA().zzj().zza("Storage concurrent access okay");
            return true;
        }
    }

    public final long zza() {
        long currentTimeMillis = zzax().currentTimeMillis();
        zzkb zzkb = this.zzk;
        zzkb.zzW();
        zzkb.zzg();
        long zza2 = zzkb.zze.zza();
        if (zza2 == 0) {
            zza2 = ((long) zzkb.zzt.zzv().zzG().nextInt(86400000)) + 1;
            zzkb.zze.zzb(zza2);
        }
        return ((((currentTimeMillis + zza2) / 1000) / 60) / 60) / 24;
    }

    public final zzet zzaA() {
        return ((zzgd) Preconditions.checkNotNull(this.zzn)).zzaA();
    }

    public final zzga zzaB() {
        return ((zzgd) Preconditions.checkNotNull(this.zzn)).zzaB();
    }

    public final Context zzaw() {
        return this.zzn.zzaw();
    }

    public final Clock zzax() {
        return ((zzgd) Preconditions.checkNotNull(this.zzn)).zzax();
    }

    public final zzab zzay() {
        throw null;
    }

    public final zzh zzd(zzq zzq2) {
        zzaB().zzg();
        zzB();
        Preconditions.checkNotNull(zzq2);
        Preconditions.checkNotEmpty(zzq2.zza);
        if (!zzq2.zzw.isEmpty()) {
            this.zzC.put(zzq2.zza, new zzlg(this, zzq2.zzw));
        }
        zzak zzak = this.zze;
        zzal(zzak);
        zzh zzj2 = zzak.zzj(zzq2.zza);
        zzhb zzd2 = zzq(zzq2.zza).zzd(zzhb.zzc(zzq2.zzv, 100));
        zzha zzha = zzha.AD_STORAGE;
        String zzf2 = zzd2.zzj(zzha) ? this.zzk.zzf(zzq2.zza, zzq2.zzo) : "";
        if (zzj2 == null) {
            zzj2 = new zzh(this.zzn, zzq2.zza);
            if (zzd2.zzj(zzha.ANALYTICS_STORAGE)) {
                zzj2.zzJ(zzw(zzd2));
            }
            if (zzd2.zzj(zzha)) {
                zzj2.zzag(zzf2);
            }
        } else if (zzd2.zzj(zzha) && zzf2 != null && !zzf2.equals(zzj2.zzC())) {
            zzj2.zzag(zzf2);
            if (zzq2.zzo && !"00000000-0000-0000-0000-000000000000".equals(this.zzk.zzd(zzq2.zza, zzd2).first)) {
                zzj2.zzJ(zzw(zzd2));
                zzak zzak2 = this.zze;
                zzal(zzak2);
                if (zzak2.zzp(zzq2.zza, "_id") != null) {
                    zzak zzak3 = this.zze;
                    zzal(zzak3);
                    if (zzak3.zzp(zzq2.zza, "_lair") == null) {
                        zzlm zzlm = new zzlm(zzq2.zza, TtmlNode.TEXT_EMPHASIS_AUTO, "_lair", zzax().currentTimeMillis(), 1L);
                        zzak zzak4 = this.zze;
                        zzal(zzak4);
                        zzak4.zzL(zzlm);
                    }
                }
            }
        } else if (TextUtils.isEmpty(zzj2.zzw()) && zzd2.zzj(zzha.ANALYTICS_STORAGE)) {
            zzj2.zzJ(zzw(zzd2));
        }
        zzj2.zzY(zzq2.zzb);
        zzj2.zzH(zzq2.zzq);
        if (!TextUtils.isEmpty(zzq2.zzk)) {
            zzj2.zzX(zzq2.zzk);
        }
        long j11 = zzq2.zze;
        if (j11 != 0) {
            zzj2.zzZ(j11);
        }
        if (!TextUtils.isEmpty(zzq2.zzc)) {
            zzj2.zzL(zzq2.zzc);
        }
        zzj2.zzM(zzq2.zzj);
        String str = zzq2.zzd;
        if (str != null) {
            zzj2.zzK(str);
        }
        zzj2.zzU(zzq2.zzf);
        zzj2.zzae(zzq2.zzh);
        if (!TextUtils.isEmpty(zzq2.zzg)) {
            zzj2.zzaa(zzq2.zzg);
        }
        zzj2.zzI(zzq2.zzo);
        zzj2.zzaf(zzq2.zzr);
        zzj2.zzV(zzq2.zzs);
        zzqu.zzc();
        if (zzg().zzs((String) null, zzeg.zzam) || zzg().zzs(zzq2.zza, zzeg.zzao)) {
            zzj2.zzai(zzq2.zzx);
        }
        zzop.zzc();
        if (zzg().zzs((String) null, zzeg.zzal)) {
            zzj2.zzah(zzq2.zzt);
        } else {
            zzop.zzc();
            if (zzg().zzs((String) null, zzeg.zzak)) {
                zzj2.zzah((List) null);
            }
        }
        zzrd.zzc();
        if (zzg().zzs((String) null, zzeg.zzaq)) {
            zzj2.zzak(zzq2.zzy);
        }
        zzpz.zzc();
        if (zzg().zzs((String) null, zzeg.zzaE)) {
            zzj2.zzal(zzq2.zzz);
        }
        if (zzj2.zzao()) {
            zzak zzak5 = this.zze;
            zzal(zzak5);
            zzak5.zzD(zzj2);
        }
        return zzj2;
    }

    public final zzaa zzf() {
        zzaa zzaa = this.zzh;
        zzal(zzaa);
        return zzaa;
    }

    public final zzag zzg() {
        return ((zzgd) Preconditions.checkNotNull(this.zzn)).zzf();
    }

    public final zzak zzh() {
        zzak zzak = this.zze;
        zzal(zzak);
        return zzak;
    }

    public final zzeo zzi() {
        return this.zzn.zzj();
    }

    public final zzez zzj() {
        zzez zzez = this.zzd;
        zzal(zzez);
        return zzez;
    }

    public final zzfb zzl() {
        zzfb zzfb = this.zzf;
        if (zzfb != null) {
            return zzfb;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public final zzfu zzm() {
        zzfu zzfu = this.zzc;
        zzal(zzfu);
        return zzfu;
    }

    public final zzgd zzp() {
        return this.zzn;
    }

    public final zzhb zzq(String str) {
        String str2;
        zzhb zzhb = zzhb.zza;
        zzaB().zzg();
        zzB();
        zzhb zzhb2 = (zzhb) this.zzB.get(str);
        if (zzhb2 != null) {
            return zzhb2;
        }
        zzak zzak = this.zze;
        zzal(zzak);
        Preconditions.checkNotNull(str);
        zzak.zzg();
        zzak.zzW();
        Cursor cursor = null;
        try {
            Cursor rawQuery = zzak.zzh().rawQuery("select consent_state from consent_settings where app_id=? limit 1;", new String[]{str});
            if (rawQuery.moveToFirst()) {
                str2 = rawQuery.getString(0);
                rawQuery.close();
            } else {
                rawQuery.close();
                str2 = "G1";
            }
            zzhb zzc2 = zzhb.zzc(str2, 100);
            zzV(str, zzc2);
            return zzc2;
        } catch (SQLiteException e11) {
            zzak.zzt.zzaA().zzd().zzc("Database error", "select consent_state from consent_settings where app_id=? limit 1;", e11);
            throw e11;
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    public final zzip zzr() {
        zzip zzip = this.zzj;
        zzal(zzip);
        return zzip;
    }

    public final zzkb zzs() {
        return this.zzk;
    }

    public final zzlj zzu() {
        zzlj zzlj = this.zzi;
        zzal(zzlj);
        return zzlj;
    }

    public final zzlp zzv() {
        return ((zzgd) Preconditions.checkNotNull(this.zzn)).zzv();
    }

    public final String zzw(zzhb zzhb) {
        if (!zzhb.zzj(zzha.ANALYTICS_STORAGE)) {
            return null;
        }
        byte[] bArr = new byte[16];
        zzv().zzG().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
    }

    public final String zzx(zzq zzq2) {
        try {
            return (String) zzaB().zzh(new zzla(this, zzq2)).get(30000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e11) {
            zzaA().zzd().zzc("Failed to get app instance id. appId", zzet.zzn(zzq2.zza), e11);
            return null;
        }
    }

    public final void zzz(Runnable runnable) {
        zzaB().zzg();
        if (this.zzq == null) {
            this.zzq = new ArrayList();
        }
        this.zzq.add(runnable);
    }
}
