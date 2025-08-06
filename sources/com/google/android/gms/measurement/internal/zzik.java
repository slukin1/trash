package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzph;
import com.google.android.gms.internal.measurement.zzqu;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sumsub.sentry.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class zzik extends zzf {
    public zzij zza;
    public final zzs zzb;
    public boolean zzc = true;
    private zzhf zzd;
    private final Set zze = new CopyOnWriteArraySet();
    private boolean zzf;
    private final AtomicReference zzg = new AtomicReference();
    private final Object zzh = new Object();
    private zzhb zzi = zzhb.zza;
    private final AtomicLong zzj = new AtomicLong(0);
    private long zzk = -1;
    private final zzlo zzl = new zzhz(this);

    public zzik(zzgd zzgd) {
        super(zzgd);
        this.zzb = new zzs(zzgd);
    }

    /* access modifiers changed from: private */
    public final void zzaa(Boolean bool, boolean z11) {
        zzg();
        zza();
        this.zzt.zzaA().zzc().zzb("Setting app measurement enabled (FE)", bool);
        this.zzt.zzm().zzh(bool);
        if (z11) {
            zzfi zzm = this.zzt.zzm();
            zzgd zzgd = zzm.zzt;
            zzm.zzg();
            SharedPreferences.Editor edit = zzm.zza().edit();
            if (bool != null) {
                edit.putBoolean("measurement_enabled_from_api", bool.booleanValue());
            } else {
                edit.remove("measurement_enabled_from_api");
            }
            edit.apply();
        }
        if (this.zzt.zzK() || (bool != null && !bool.booleanValue())) {
            zzab();
        }
    }

    /* access modifiers changed from: private */
    public final void zzab() {
        zzg();
        String zza2 = this.zzt.zzm().zzh.zza();
        if (zza2 != null) {
            if ("unset".equals(zza2)) {
                zzY(a.f30241h, "_npa", (Object) null, this.zzt.zzax().currentTimeMillis());
            } else {
                zzY(a.f30241h, "_npa", Long.valueOf(true != "true".equals(zza2) ? 0 : 1), this.zzt.zzax().currentTimeMillis());
            }
        }
        if (!this.zzt.zzJ() || !this.zzc) {
            this.zzt.zzaA().zzc().zza("Updating Scion state (FE)");
            this.zzt.zzt().zzI();
            return;
        }
        this.zzt.zzaA().zzc().zza("Recording app launch after enabling measurement for the first time (FE)");
        zzz();
        zzph.zzc();
        if (this.zzt.zzf().zzs((String) null, zzeg.zzaf)) {
            this.zzt.zzu().zza.zza();
        }
        this.zzt.zzaB().zzp(new zzhn(this));
    }

    public static /* bridge */ /* synthetic */ void zzv(zzik zzik, zzhb zzhb, zzhb zzhb2) {
        boolean z11;
        zzha[] zzhaArr = {zzha.ANALYTICS_STORAGE, zzha.AD_STORAGE};
        int i11 = 0;
        while (true) {
            if (i11 >= 2) {
                z11 = false;
                break;
            }
            zzha zzha = zzhaArr[i11];
            if (!zzhb2.zzj(zzha) && zzhb.zzj(zzha)) {
                z11 = true;
                break;
            }
            i11++;
        }
        boolean zzn = zzhb.zzn(zzhb2, zzha.ANALYTICS_STORAGE, zzha.AD_STORAGE);
        if (z11 || zzn) {
            zzik.zzt.zzh().zzo();
        }
    }

    public static /* synthetic */ void zzw(zzik zzik, zzhb zzhb, long j11, boolean z11, boolean z12) {
        zzik.zzg();
        zzik.zza();
        zzhb zzc2 = zzik.zzt.zzm().zzc();
        if (j11 > zzik.zzk || !zzhb.zzk(zzc2.zza(), zzhb.zza())) {
            zzfi zzm = zzik.zzt.zzm();
            zzgd zzgd = zzm.zzt;
            zzm.zzg();
            int zza2 = zzhb.zza();
            if (zzm.zzl(zza2)) {
                SharedPreferences.Editor edit = zzm.zza().edit();
                edit.putString("consent_settings", zzhb.zzi());
                edit.putInt("consent_source", zza2);
                edit.apply();
                zzik.zzk = j11;
                zzik.zzt.zzt().zzF(z11);
                if (z12) {
                    zzik.zzt.zzt().zzu(new AtomicReference());
                    return;
                }
                return;
            }
            zzik.zzt.zzaA().zzi().zzb("Lower precedence consent source ignored, proposed source", Integer.valueOf(zzhb.zza()));
            return;
        }
        zzik.zzt.zzaA().zzi().zzb("Dropped out-of-date consent setting, proposed settings", zzhb);
    }

    public final void zzA(String str, String str2, Bundle bundle) {
        long currentTimeMillis = this.zzt.zzax().currentTimeMillis();
        Preconditions.checkNotEmpty(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str);
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, currentTimeMillis);
        if (str2 != null) {
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str2);
            bundle2.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle);
        }
        this.zzt.zzaB().zzp(new zzhu(this, bundle2));
    }

    public final void zzB() {
        if ((this.zzt.zzaw().getApplicationContext() instanceof Application) && this.zza != null) {
            ((Application) this.zzt.zzaw().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zza);
        }
    }

    public final /* synthetic */ void zzC(Bundle bundle) {
        if (bundle == null) {
            this.zzt.zzm().zzs.zzb(new Bundle());
            return;
        }
        Bundle zza2 = this.zzt.zzm().zzs.zza();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                if (this.zzt.zzv().zzag(obj)) {
                    this.zzt.zzv().zzO(this.zzl, (String) null, 27, (String) null, (String) null, 0);
                }
                this.zzt.zzaA().zzl().zzc("Invalid default event parameter type. Name, value", str, obj);
            } else if (zzlp.zzaj(str)) {
                this.zzt.zzaA().zzl().zzb("Invalid default event parameter name. Name", str);
            } else if (obj == null) {
                zza2.remove(str);
            } else {
                zzlp zzv = this.zzt.zzv();
                this.zzt.zzf();
                if (zzv.zzab(RemoteMessageConst.MessageBody.PARAM, str, 100, obj)) {
                    this.zzt.zzv().zzP(zza2, str, obj);
                }
            }
        }
        this.zzt.zzv();
        int zzc2 = this.zzt.zzf().zzc();
        if (zza2.size() > zzc2) {
            int i11 = 0;
            for (String str2 : new TreeSet(zza2.keySet())) {
                i11++;
                if (i11 > zzc2) {
                    zza2.remove(str2);
                }
            }
            this.zzt.zzv().zzO(this.zzl, (String) null, 26, (String) null, (String) null, 0);
            this.zzt.zzaA().zzl().zza("Too many default event parameters set. Discarding beyond event parameter limit");
        }
        this.zzt.zzm().zzs.zzb(zza2);
        this.zzt.zzt().zzH(zza2);
    }

    public final void zzD(String str, String str2, Bundle bundle) {
        zzE(str, str2, bundle, true, true, this.zzt.zzax().currentTimeMillis());
    }

    public final void zzE(String str, String str2, Bundle bundle, boolean z11, boolean z12, long j11) {
        String str3 = str2;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        if (str3 == FirebaseAnalytics.Event.SCREEN_VIEW || (str3 != null && str2.equals(FirebaseAnalytics.Event.SCREEN_VIEW))) {
            this.zzt.zzs().zzx(bundle2, j11);
            return;
        }
        boolean z13 = true;
        if (z12 && this.zzd != null && !zzlp.zzaj(str2)) {
            z13 = false;
        }
        zzM(str == null ? a.f30241h : str, str2, j11, bundle2, z12, z13, z11, (String) null);
    }

    public final void zzF(String str, String str2, Bundle bundle, String str3) {
        zzgd.zzO();
        zzM(TtmlNode.TEXT_EMPHASIS_AUTO, str2, this.zzt.zzax().currentTimeMillis(), bundle, false, true, true, str3);
    }

    public final void zzG(String str, String str2, Bundle bundle) {
        zzg();
        zzH(str, str2, this.zzt.zzax().currentTimeMillis(), bundle);
    }

    public final void zzH(String str, String str2, long j11, Bundle bundle) {
        zzg();
        zzI(str, str2, j11, bundle, true, this.zzd == null || zzlp.zzaj(str2), true, (String) null);
    }

    /* JADX WARNING: type inference failed for: r5v10, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r5v12, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzI(java.lang.String r22, java.lang.String r23, long r24, android.os.Bundle r26, boolean r27, boolean r28, boolean r29, java.lang.String r30) {
        /*
            r21 = this;
            r7 = r21
            r8 = r22
            r9 = r23
            r10 = r24
            r12 = r26
            java.lang.String r0 = "com.google.android.gms.tagmanager.TagManagerService"
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r22)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r26)
            r21.zzg()
            r21.zza()
            com.google.android.gms.measurement.internal.zzgd r1 = r7.zzt
            boolean r1 = r1.zzJ()
            if (r1 == 0) goto L_0x0509
            com.google.android.gms.measurement.internal.zzgd r1 = r7.zzt
            com.google.android.gms.measurement.internal.zzek r1 = r1.zzh()
            java.util.List r1 = r1.zzn()
            if (r1 == 0) goto L_0x0043
            boolean r1 = r1.contains(r9)
            if (r1 == 0) goto L_0x0033
            goto L_0x0043
        L_0x0033:
            com.google.android.gms.measurement.internal.zzgd r0 = r7.zzt
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzc()
            java.lang.String r1 = "Dropping non-safelisted event. event name, origin"
            r0.zzc(r1, r9, r8)
            return
        L_0x0043:
            boolean r1 = r7.zzf
            r13 = 0
            r14 = 0
            r15 = 1
            if (r1 != 0) goto L_0x00a1
            r7.zzf = r15
            com.google.android.gms.measurement.internal.zzgd r1 = r7.zzt     // Catch:{ ClassNotFoundException -> 0x0092 }
            boolean r1 = r1.zzN()     // Catch:{ ClassNotFoundException -> 0x0092 }
            if (r1 != 0) goto L_0x0063
            com.google.android.gms.measurement.internal.zzgd r1 = r7.zzt     // Catch:{ ClassNotFoundException -> 0x0092 }
            android.content.Context r1 = r1.zzaw()     // Catch:{ ClassNotFoundException -> 0x0092 }
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x0092 }
            java.lang.Class r0 = java.lang.Class.forName(r0, r15, r1)     // Catch:{ ClassNotFoundException -> 0x0092 }
            goto L_0x0067
        L_0x0063:
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x0092 }
        L_0x0067:
            java.lang.String r1 = "initialize"
            java.lang.Class[] r2 = new java.lang.Class[r15]     // Catch:{ Exception -> 0x0081 }
            java.lang.Class<android.content.Context> r3 = android.content.Context.class
            r2[r14] = r3     // Catch:{ Exception -> 0x0081 }
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r1, r2)     // Catch:{ Exception -> 0x0081 }
            java.lang.Object[] r1 = new java.lang.Object[r15]     // Catch:{ Exception -> 0x0081 }
            com.google.android.gms.measurement.internal.zzgd r2 = r7.zzt     // Catch:{ Exception -> 0x0081 }
            android.content.Context r2 = r2.zzaw()     // Catch:{ Exception -> 0x0081 }
            r1[r14] = r2     // Catch:{ Exception -> 0x0081 }
            r0.invoke(r13, r1)     // Catch:{ Exception -> 0x0081 }
            goto L_0x00a1
        L_0x0081:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgd r1 = r7.zzt     // Catch:{ ClassNotFoundException -> 0x0092 }
            com.google.android.gms.measurement.internal.zzet r1 = r1.zzaA()     // Catch:{ ClassNotFoundException -> 0x0092 }
            com.google.android.gms.measurement.internal.zzer r1 = r1.zzk()     // Catch:{ ClassNotFoundException -> 0x0092 }
            java.lang.String r2 = "Failed to invoke Tag Manager's initialize() method"
            r1.zzb(r2, r0)     // Catch:{ ClassNotFoundException -> 0x0092 }
            goto L_0x00a1
        L_0x0092:
            com.google.android.gms.measurement.internal.zzgd r0 = r7.zzt
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzi()
            java.lang.String r1 = "Tag Manager is not found and thus will not be used"
            r0.zza(r1)
        L_0x00a1:
            java.lang.String r0 = "_cmp"
            boolean r0 = r0.equals(r9)
            if (r0 == 0) goto L_0x00cd
            java.lang.String r0 = "gclid"
            boolean r1 = r12.containsKey(r0)
            if (r1 == 0) goto L_0x00cd
            com.google.android.gms.measurement.internal.zzgd r1 = r7.zzt
            r1.zzay()
            java.lang.String r4 = r12.getString(r0)
            com.google.android.gms.measurement.internal.zzgd r0 = r7.zzt
            com.google.android.gms.common.util.Clock r0 = r0.zzax()
            long r5 = r0.currentTimeMillis()
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_lgclid"
            r1 = r21
            r1.zzY(r2, r3, r4, r5)
        L_0x00cd:
            com.google.android.gms.measurement.internal.zzgd r0 = r7.zzt
            r0.zzay()
            if (r27 == 0) goto L_0x00ef
            boolean r0 = com.google.android.gms.measurement.internal.zzlp.zzan(r23)
            if (r0 == 0) goto L_0x00ef
            com.google.android.gms.measurement.internal.zzgd r0 = r7.zzt
            com.google.android.gms.measurement.internal.zzlp r0 = r0.zzv()
            com.google.android.gms.measurement.internal.zzgd r1 = r7.zzt
            com.google.android.gms.measurement.internal.zzfi r1 = r1.zzm()
            com.google.android.gms.measurement.internal.zzfd r1 = r1.zzs
            android.os.Bundle r1 = r1.zza()
            r0.zzL(r12, r1)
        L_0x00ef:
            r0 = 40
            if (r29 != 0) goto L_0x0177
            com.google.android.gms.measurement.internal.zzgd r1 = r7.zzt
            r1.zzay()
            java.lang.String r1 = "_iap"
            boolean r1 = r1.equals(r9)
            if (r1 != 0) goto L_0x0177
            com.google.android.gms.measurement.internal.zzgd r1 = r7.zzt
            com.google.android.gms.measurement.internal.zzlp r1 = r1.zzv()
            java.lang.String r2 = "event"
            boolean r3 = r1.zzad(r2, r9)
            r4 = 2
            if (r3 != 0) goto L_0x0110
            goto L_0x012a
        L_0x0110:
            java.lang.String[] r3 = com.google.android.gms.measurement.internal.zzhc.zza
            java.lang.String[] r5 = com.google.android.gms.measurement.internal.zzhc.zzb
            boolean r3 = r1.zzaa(r2, r3, r5, r9)
            if (r3 != 0) goto L_0x011d
            r4 = 13
            goto L_0x012a
        L_0x011d:
            com.google.android.gms.measurement.internal.zzgd r3 = r1.zzt
            r3.zzf()
            boolean r1 = r1.zzZ(r2, r0, r9)
            if (r1 != 0) goto L_0x0129
            goto L_0x012a
        L_0x0129:
            r4 = r14
        L_0x012a:
            if (r4 == 0) goto L_0x0177
            com.google.android.gms.measurement.internal.zzgd r1 = r7.zzt
            com.google.android.gms.measurement.internal.zzet r1 = r1.zzaA()
            com.google.android.gms.measurement.internal.zzer r1 = r1.zze()
            com.google.android.gms.measurement.internal.zzgd r2 = r7.zzt
            com.google.android.gms.measurement.internal.zzeo r2 = r2.zzj()
            java.lang.String r2 = r2.zzd(r9)
            java.lang.String r3 = "Invalid public event name. Event will not be logged (FE)"
            r1.zzb(r3, r2)
            com.google.android.gms.measurement.internal.zzgd r1 = r7.zzt
            com.google.android.gms.measurement.internal.zzlp r1 = r1.zzv()
            com.google.android.gms.measurement.internal.zzgd r2 = r7.zzt
            r2.zzf()
            java.lang.String r0 = r1.zzD(r9, r0, r15)
            if (r9 == 0) goto L_0x015a
            int r14 = r23.length()
        L_0x015a:
            com.google.android.gms.measurement.internal.zzgd r1 = r7.zzt
            com.google.android.gms.measurement.internal.zzlp r1 = r1.zzv()
            com.google.android.gms.measurement.internal.zzlo r2 = r7.zzl
            r3 = 0
            java.lang.String r5 = "_ev"
            r22 = r1
            r23 = r2
            r24 = r3
            r25 = r4
            r26 = r5
            r27 = r0
            r28 = r14
            r22.zzO(r23, r24, r25, r26, r27, r28)
            return
        L_0x0177:
            com.google.android.gms.measurement.internal.zzgd r1 = r7.zzt
            r1.zzay()
            com.google.android.gms.measurement.internal.zzgd r1 = r7.zzt
            com.google.android.gms.measurement.internal.zziz r1 = r1.zzs()
            com.google.android.gms.measurement.internal.zzir r1 = r1.zzj(r14)
            java.lang.String r2 = "_sc"
            if (r1 == 0) goto L_0x0192
            boolean r3 = r12.containsKey(r2)
            if (r3 != 0) goto L_0x0192
            r1.zzd = r15
        L_0x0192:
            if (r27 == 0) goto L_0x0198
            if (r29 != 0) goto L_0x0198
            r3 = r15
            goto L_0x0199
        L_0x0198:
            r3 = r14
        L_0x0199:
            com.google.android.gms.measurement.internal.zzlp.zzK(r1, r12, r3)
            java.lang.String r1 = "am"
            boolean r1 = r1.equals(r8)
            boolean r3 = com.google.android.gms.measurement.internal.zzlp.zzaj(r23)
            if (r27 == 0) goto L_0x01e9
            com.google.android.gms.measurement.internal.zzhf r4 = r7.zzd
            if (r4 == 0) goto L_0x01e9
            if (r3 != 0) goto L_0x01e9
            if (r1 == 0) goto L_0x01b3
            r16 = r15
            goto L_0x01eb
        L_0x01b3:
            com.google.android.gms.measurement.internal.zzgd r0 = r7.zzt
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzc()
            com.google.android.gms.measurement.internal.zzgd r1 = r7.zzt
            com.google.android.gms.measurement.internal.zzeo r1 = r1.zzj()
            java.lang.String r1 = r1.zzd(r9)
            com.google.android.gms.measurement.internal.zzgd r2 = r7.zzt
            com.google.android.gms.measurement.internal.zzeo r2 = r2.zzj()
            java.lang.String r2 = r2.zzb(r12)
            java.lang.String r3 = "Passing event to registered event handler (FE)"
            r0.zzc(r3, r1, r2)
            com.google.android.gms.measurement.internal.zzhf r0 = r7.zzd
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)
            com.google.android.gms.measurement.internal.zzhf r1 = r7.zzd
            r2 = r22
            r3 = r23
            r4 = r26
            r5 = r24
            r1.interceptEvent(r2, r3, r4, r5)
            return
        L_0x01e9:
            r16 = r1
        L_0x01eb:
            com.google.android.gms.measurement.internal.zzgd r1 = r7.zzt
            boolean r1 = r1.zzM()
            if (r1 == 0) goto L_0x0508
            com.google.android.gms.measurement.internal.zzgd r1 = r7.zzt
            com.google.android.gms.measurement.internal.zzlp r1 = r1.zzv()
            int r1 = r1.zzh(r9)
            if (r1 == 0) goto L_0x0249
            com.google.android.gms.measurement.internal.zzgd r2 = r7.zzt
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzaA()
            com.google.android.gms.measurement.internal.zzer r2 = r2.zze()
            com.google.android.gms.measurement.internal.zzgd r3 = r7.zzt
            com.google.android.gms.measurement.internal.zzeo r3 = r3.zzj()
            java.lang.String r3 = r3.zzd(r9)
            java.lang.String r4 = "Invalid event name. Event will not be logged (FE)"
            r2.zzb(r4, r3)
            com.google.android.gms.measurement.internal.zzgd r2 = r7.zzt
            com.google.android.gms.measurement.internal.zzlp r2 = r2.zzv()
            com.google.android.gms.measurement.internal.zzgd r3 = r7.zzt
            r3.zzf()
            java.lang.String r0 = r2.zzD(r9, r0, r15)
            if (r9 == 0) goto L_0x022d
            int r14 = r23.length()
        L_0x022d:
            com.google.android.gms.measurement.internal.zzgd r2 = r7.zzt
            com.google.android.gms.measurement.internal.zzlp r2 = r2.zzv()
            com.google.android.gms.measurement.internal.zzlo r3 = r7.zzl
            java.lang.String r4 = "_ev"
            r22 = r2
            r23 = r3
            r24 = r30
            r25 = r1
            r26 = r4
            r27 = r0
            r28 = r14
            r22.zzO(r23, r24, r25, r26, r27, r28)
            return
        L_0x0249:
            java.lang.String r0 = "_o"
            java.lang.String r1 = "_sn"
            java.lang.String r3 = "_si"
            java.lang.String[] r1 = new java.lang.String[]{r0, r1, r2, r3}
            java.util.List r5 = com.google.android.gms.common.util.CollectionUtils.listOf((T[]) r1)
            com.google.android.gms.measurement.internal.zzgd r1 = r7.zzt
            com.google.android.gms.measurement.internal.zzlp r1 = r1.zzv()
            r2 = r30
            r3 = r23
            r4 = r26
            r6 = r29
            android.os.Bundle r12 = r1.zzu(r2, r3, r4, r5, r6)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r12)
            com.google.android.gms.measurement.internal.zzgd r1 = r7.zzt
            r1.zzay()
            com.google.android.gms.measurement.internal.zzgd r1 = r7.zzt
            com.google.android.gms.measurement.internal.zziz r1 = r1.zzs()
            com.google.android.gms.measurement.internal.zzir r1 = r1.zzj(r14)
            java.lang.String r5 = "_ae"
            if (r1 == 0) goto L_0x02ae
            boolean r1 = r5.equals(r9)
            if (r1 == 0) goto L_0x02ae
            com.google.android.gms.measurement.internal.zzgd r1 = r7.zzt
            com.google.android.gms.measurement.internal.zzkp r1 = r1.zzu()
            com.google.android.gms.measurement.internal.zzkn r1 = r1.zzb
            com.google.android.gms.measurement.internal.zzkp r2 = r1.zzc
            com.google.android.gms.measurement.internal.zzgd r2 = r2.zzt
            com.google.android.gms.common.util.Clock r2 = r2.zzax()
            long r14 = r2.elapsedRealtime()
            long r3 = r1.zzb
            long r2 = r14 - r3
            r1.zzb = r14
            r14 = 0
            int r1 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
            if (r1 <= 0) goto L_0x02ae
            com.google.android.gms.measurement.internal.zzgd r1 = r7.zzt
            com.google.android.gms.measurement.internal.zzlp r1 = r1.zzv()
            r1.zzI(r12, r2)
        L_0x02ae:
            com.google.android.gms.internal.measurement.zzos.zzc()
            com.google.android.gms.measurement.internal.zzgd r1 = r7.zzt
            com.google.android.gms.measurement.internal.zzag r1 = r1.zzf()
            com.google.android.gms.measurement.internal.zzef r2 = com.google.android.gms.measurement.internal.zzeg.zzae
            boolean r1 = r1.zzs(r13, r2)
            if (r1 == 0) goto L_0x0338
            java.lang.String r1 = "auto"
            boolean r1 = r1.equals(r8)
            java.lang.String r2 = "_ffr"
            if (r1 != 0) goto L_0x0317
            java.lang.String r1 = "_ssr"
            boolean r1 = r1.equals(r9)
            if (r1 == 0) goto L_0x0317
            com.google.android.gms.measurement.internal.zzgd r1 = r7.zzt
            com.google.android.gms.measurement.internal.zzlp r1 = r1.zzv()
            java.lang.String r2 = r12.getString(r2)
            boolean r3 = com.google.android.gms.common.util.Strings.isEmptyOrWhitespace(r2)
            if (r3 == 0) goto L_0x02e3
            r2 = r13
            goto L_0x02e9
        L_0x02e3:
            if (r2 == 0) goto L_0x02e9
            java.lang.String r2 = r2.trim()
        L_0x02e9:
            com.google.android.gms.measurement.internal.zzgd r3 = r1.zzt
            com.google.android.gms.measurement.internal.zzfi r3 = r3.zzm()
            com.google.android.gms.measurement.internal.zzfh r3 = r3.zzp
            java.lang.String r3 = r3.zza()
            boolean r3 = com.google.android.gms.measurement.internal.zzln.zza(r2, r3)
            if (r3 != 0) goto L_0x0307
            com.google.android.gms.measurement.internal.zzgd r1 = r1.zzt
            com.google.android.gms.measurement.internal.zzfi r1 = r1.zzm()
            com.google.android.gms.measurement.internal.zzfh r1 = r1.zzp
            r1.zzb(r2)
            goto L_0x0338
        L_0x0307:
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzt
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzc()
            java.lang.String r1 = "Not logging duplicate session_start_with_rollout event"
            r0.zza(r1)
            return
        L_0x0317:
            boolean r1 = r5.equals(r9)
            if (r1 == 0) goto L_0x0338
            com.google.android.gms.measurement.internal.zzgd r1 = r7.zzt
            com.google.android.gms.measurement.internal.zzlp r1 = r1.zzv()
            com.google.android.gms.measurement.internal.zzgd r1 = r1.zzt
            com.google.android.gms.measurement.internal.zzfi r1 = r1.zzm()
            com.google.android.gms.measurement.internal.zzfh r1 = r1.zzp
            java.lang.String r1 = r1.zza()
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 != 0) goto L_0x0338
            r12.putString(r2, r1)
        L_0x0338:
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            r14.add(r12)
            com.google.android.gms.measurement.internal.zzgd r1 = r7.zzt
            com.google.android.gms.measurement.internal.zzag r1 = r1.zzf()
            com.google.android.gms.measurement.internal.zzef r2 = com.google.android.gms.measurement.internal.zzeg.zzaG
            boolean r1 = r1.zzs(r13, r2)
            if (r1 == 0) goto L_0x0359
            com.google.android.gms.measurement.internal.zzgd r1 = r7.zzt
            com.google.android.gms.measurement.internal.zzkp r1 = r1.zzu()
            boolean r1 = r1.zzo()
            goto L_0x0365
        L_0x0359:
            com.google.android.gms.measurement.internal.zzgd r1 = r7.zzt
            com.google.android.gms.measurement.internal.zzfi r1 = r1.zzm()
            com.google.android.gms.measurement.internal.zzfc r1 = r1.zzm
            boolean r1 = r1.zzb()
        L_0x0365:
            com.google.android.gms.measurement.internal.zzgd r2 = r7.zzt
            com.google.android.gms.measurement.internal.zzfi r2 = r2.zzm()
            com.google.android.gms.measurement.internal.zzfe r2 = r2.zzj
            long r2 = r2.zza()
            r17 = 0
            int r2 = (r2 > r17 ? 1 : (r2 == r17 ? 0 : -1))
            if (r2 <= 0) goto L_0x03e1
            com.google.android.gms.measurement.internal.zzgd r2 = r7.zzt
            com.google.android.gms.measurement.internal.zzfi r2 = r2.zzm()
            boolean r2 = r2.zzk(r10)
            if (r2 == 0) goto L_0x03e1
            if (r1 == 0) goto L_0x03e1
            com.google.android.gms.measurement.internal.zzgd r1 = r7.zzt
            com.google.android.gms.measurement.internal.zzet r1 = r1.zzaA()
            com.google.android.gms.measurement.internal.zzer r1 = r1.zzj()
            java.lang.String r2 = "Current session is expired, remove the session number, ID, and engagement time"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzgd r1 = r7.zzt
            com.google.android.gms.common.util.Clock r1 = r1.zzax()
            long r19 = r1.currentTimeMillis()
            r4 = 0
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_sid"
            r1 = r21
            r26 = r14
            r13 = r17
            r15 = r5
            r5 = r19
            r1.zzY(r2, r3, r4, r5)
            com.google.android.gms.measurement.internal.zzgd r1 = r7.zzt
            com.google.android.gms.common.util.Clock r1 = r1.zzax()
            long r5 = r1.currentTimeMillis()
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_sno"
            r1 = r21
            r1.zzY(r2, r3, r4, r5)
            com.google.android.gms.measurement.internal.zzgd r1 = r7.zzt
            com.google.android.gms.common.util.Clock r1 = r1.zzax()
            long r5 = r1.currentTimeMillis()
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_se"
            r1 = r21
            r1.zzY(r2, r3, r4, r5)
            com.google.android.gms.measurement.internal.zzgd r1 = r7.zzt
            com.google.android.gms.measurement.internal.zzfi r1 = r1.zzm()
            com.google.android.gms.measurement.internal.zzfe r1 = r1.zzk
            r1.zzb(r13)
            goto L_0x03e6
        L_0x03e1:
            r15 = r5
            r26 = r14
            r13 = r17
        L_0x03e6:
            java.lang.String r1 = "extend_session"
            long r1 = r12.getLong(r1, r13)
            r3 = 1
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x040d
            com.google.android.gms.measurement.internal.zzgd r1 = r7.zzt
            com.google.android.gms.measurement.internal.zzet r1 = r1.zzaA()
            com.google.android.gms.measurement.internal.zzer r1 = r1.zzj()
            java.lang.String r2 = "EXTEND_SESSION param attached: initiate a new session or extend the current active session"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzgd r1 = r7.zzt
            com.google.android.gms.measurement.internal.zzkp r1 = r1.zzu()
            com.google.android.gms.measurement.internal.zzko r1 = r1.zza
            r2 = 1
            r1.zzb(r10, r2)
        L_0x040d:
            java.util.ArrayList r1 = new java.util.ArrayList
            java.util.Set r2 = r12.keySet()
            r1.<init>(r2)
            java.util.Collections.sort(r1)
            int r2 = r1.size()
            r3 = 0
        L_0x041e:
            if (r3 >= r2) goto L_0x046c
            java.lang.Object r4 = r1.get(r3)
            java.lang.String r4 = (java.lang.String) r4
            if (r4 == 0) goto L_0x0469
            com.google.android.gms.measurement.internal.zzgd r5 = r7.zzt
            r5.zzv()
            java.lang.Object r5 = r12.get(r4)
            boolean r6 = r5 instanceof android.os.Bundle
            if (r6 == 0) goto L_0x043e
            r6 = 1
            android.os.Bundle[] r13 = new android.os.Bundle[r6]
            android.os.Bundle r5 = (android.os.Bundle) r5
            r6 = 0
            r13[r6] = r5
            goto L_0x0464
        L_0x043e:
            boolean r6 = r5 instanceof android.os.Parcelable[]
            if (r6 == 0) goto L_0x044f
            android.os.Parcelable[] r5 = (android.os.Parcelable[]) r5
            int r6 = r5.length
            java.lang.Class<android.os.Bundle[]> r13 = android.os.Bundle[].class
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r5, r6, r13)
            r13 = r5
            android.os.Bundle[] r13 = (android.os.Bundle[]) r13
            goto L_0x0464
        L_0x044f:
            boolean r6 = r5 instanceof java.util.ArrayList
            if (r6 == 0) goto L_0x0463
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            int r6 = r5.size()
            android.os.Bundle[] r6 = new android.os.Bundle[r6]
            java.lang.Object[] r5 = r5.toArray(r6)
            r13 = r5
            android.os.Bundle[] r13 = (android.os.Bundle[]) r13
            goto L_0x0464
        L_0x0463:
            r13 = 0
        L_0x0464:
            if (r13 == 0) goto L_0x0469
            r12.putParcelableArray(r4, r13)
        L_0x0469:
            int r3 = r3 + 1
            goto L_0x041e
        L_0x046c:
            r12 = 0
        L_0x046d:
            int r1 = r26.size()
            if (r12 >= r1) goto L_0x04da
            r13 = r26
            java.lang.Object r1 = r13.get(r12)
            android.os.Bundle r1 = (android.os.Bundle) r1
            if (r12 == 0) goto L_0x0480
            java.lang.String r2 = "_ep"
            goto L_0x0481
        L_0x0480:
            r2 = r9
        L_0x0481:
            r1.putString(r0, r8)
            if (r28 == 0) goto L_0x0490
            com.google.android.gms.measurement.internal.zzgd r3 = r7.zzt
            com.google.android.gms.measurement.internal.zzlp r3 = r3.zzv()
            android.os.Bundle r1 = r3.zzt(r1)
        L_0x0490:
            r14 = r1
            com.google.android.gms.measurement.internal.zzau r5 = new com.google.android.gms.measurement.internal.zzau
            com.google.android.gms.measurement.internal.zzas r3 = new com.google.android.gms.measurement.internal.zzas
            r3.<init>(r14)
            r1 = r5
            r4 = r22
            r27 = r0
            r0 = r5
            r5 = r24
            r1.<init>(r2, r3, r4, r5)
            com.google.android.gms.measurement.internal.zzgd r1 = r7.zzt
            com.google.android.gms.measurement.internal.zzjz r1 = r1.zzt()
            r5 = r30
            r1.zzA(r0, r5)
            if (r16 != 0) goto L_0x04d3
            java.util.Set r0 = r7.zze
            java.util.Iterator r0 = r0.iterator()
        L_0x04b6:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x04d3
            java.lang.Object r1 = r0.next()
            com.google.android.gms.measurement.internal.zzhg r1 = (com.google.android.gms.measurement.internal.zzhg) r1
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>(r14)
            r2 = r22
            r3 = r23
            r5 = r24
            r1.onEvent(r2, r3, r4, r5)
            r5 = r30
            goto L_0x04b6
        L_0x04d3:
            int r12 = r12 + 1
            r0 = r27
            r26 = r13
            goto L_0x046d
        L_0x04da:
            com.google.android.gms.measurement.internal.zzgd r0 = r7.zzt
            r0.zzay()
            com.google.android.gms.measurement.internal.zzgd r0 = r7.zzt
            com.google.android.gms.measurement.internal.zziz r0 = r0.zzs()
            r1 = 0
            com.google.android.gms.measurement.internal.zzir r0 = r0.zzj(r1)
            if (r0 == 0) goto L_0x0508
            boolean r0 = r15.equals(r9)
            if (r0 == 0) goto L_0x0508
            com.google.android.gms.measurement.internal.zzgd r0 = r7.zzt
            com.google.android.gms.measurement.internal.zzkp r0 = r0.zzu()
            com.google.android.gms.measurement.internal.zzgd r1 = r7.zzt
            com.google.android.gms.common.util.Clock r1 = r1.zzax()
            long r1 = r1.elapsedRealtime()
            com.google.android.gms.measurement.internal.zzkn r0 = r0.zzb
            r3 = 1
            r0.zzd(r3, r3, r1)
        L_0x0508:
            return
        L_0x0509:
            com.google.android.gms.measurement.internal.zzgd r0 = r7.zzt
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzc()
            java.lang.String r1 = "Event not sent since app measurement is disabled"
            r0.zza(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzik.zzI(java.lang.String, java.lang.String, long, android.os.Bundle, boolean, boolean, boolean, java.lang.String):void");
    }

    public final void zzJ(zzhg zzhg) {
        zza();
        Preconditions.checkNotNull(zzhg);
        if (!this.zze.add(zzhg)) {
            this.zzt.zzaA().zzk().zza("OnEventListener already registered");
        }
    }

    public final void zzK(long j11) {
        this.zzg.set((Object) null);
        this.zzt.zzaB().zzp(new zzhs(this, j11));
    }

    public final void zzL(long j11, boolean z11) {
        zzg();
        zza();
        this.zzt.zzaA().zzc().zza("Resetting analytics data (FE)");
        zzkp zzu = this.zzt.zzu();
        zzu.zzg();
        zzu.zzb.zza();
        zzqu.zzc();
        if (this.zzt.zzf().zzs((String) null, zzeg.zzan)) {
            this.zzt.zzh().zzo();
        }
        boolean zzJ = this.zzt.zzJ();
        zzfi zzm = this.zzt.zzm();
        zzm.zzc.zzb(j11);
        if (!TextUtils.isEmpty(zzm.zzt.zzm().zzp.zza())) {
            zzm.zzp.zzb((String) null);
        }
        zzph.zzc();
        zzag zzf2 = zzm.zzt.zzf();
        zzef zzef = zzeg.zzaf;
        if (zzf2.zzs((String) null, zzef)) {
            zzm.zzj.zzb(0);
        }
        zzm.zzk.zzb(0);
        if (!zzm.zzt.zzf().zzv()) {
            zzm.zzi(!zzJ);
        }
        zzm.zzq.zzb((String) null);
        zzm.zzr.zzb(0);
        zzm.zzs.zzb((Bundle) null);
        if (z11) {
            this.zzt.zzt().zzC();
        }
        zzph.zzc();
        if (this.zzt.zzf().zzs((String) null, zzef)) {
            this.zzt.zzu().zza.zza();
        }
        this.zzc = !zzJ;
    }

    public final void zzM(String str, String str2, long j11, Bundle bundle, boolean z11, boolean z12, boolean z13, String str3) {
        Bundle bundle2 = new Bundle(bundle);
        for (String str4 : bundle2.keySet()) {
            Object obj = bundle2.get(str4);
            if (obj instanceof Bundle) {
                bundle2.putBundle(str4, new Bundle((Bundle) obj));
            } else {
                int i11 = 0;
                if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    while (i11 < parcelableArr.length) {
                        Parcelable parcelable = parcelableArr[i11];
                        if (parcelable instanceof Bundle) {
                            parcelableArr[i11] = new Bundle((Bundle) parcelable);
                        }
                        i11++;
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    while (i11 < list.size()) {
                        Object obj2 = list.get(i11);
                        if (obj2 instanceof Bundle) {
                            list.set(i11, new Bundle((Bundle) obj2));
                        }
                        i11++;
                    }
                }
            }
        }
        this.zzt.zzaB().zzp(new zzhp(this, str, str2, j11, bundle2, z11, z12, z13, str3));
    }

    public final void zzN(String str, String str2, long j11, Object obj) {
        this.zzt.zzaB().zzp(new zzhq(this, str, str2, obj, j11));
    }

    public final void zzO(String str) {
        this.zzg.set(str);
    }

    public final void zzP(Bundle bundle) {
        zzQ(bundle, this.zzt.zzax().currentTimeMillis());
    }

    public final void zzQ(Bundle bundle, long j11) {
        Class<Long> cls = Long.class;
        Class<String> cls2 = String.class;
        Preconditions.checkNotNull(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            this.zzt.zzaA().zzk().zza("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        Preconditions.checkNotNull(bundle2);
        zzgz.zza(bundle2, "app_id", cls2, (Object) null);
        zzgz.zza(bundle2, "origin", cls2, (Object) null);
        zzgz.zza(bundle2, "name", cls2, (Object) null);
        zzgz.zza(bundle2, "value", Object.class, (Object) null);
        zzgz.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, cls2, (Object) null);
        zzgz.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, cls, 0L);
        zzgz.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, cls2, (Object) null);
        zzgz.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, (Object) null);
        zzgz.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, cls2, (Object) null);
        zzgz.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, (Object) null);
        zzgz.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, cls, 0L);
        zzgz.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, cls2, (Object) null);
        zzgz.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, (Object) null);
        Preconditions.checkNotEmpty(bundle2.getString("name"));
        Preconditions.checkNotEmpty(bundle2.getString("origin"));
        Preconditions.checkNotNull(bundle2.get("value"));
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, j11);
        String string = bundle2.getString("name");
        Object obj = bundle2.get("value");
        if (this.zzt.zzv().zzl(string) != 0) {
            this.zzt.zzaA().zzd().zzb("Invalid conditional user property name", this.zzt.zzj().zzf(string));
        } else if (this.zzt.zzv().zzd(string, obj) == 0) {
            Object zzB = this.zzt.zzv().zzB(string, obj);
            if (zzB == null) {
                this.zzt.zzaA().zzd().zzc("Unable to normalize conditional user property value", this.zzt.zzj().zzf(string), obj);
                return;
            }
            zzgz.zzb(bundle2, zzB);
            long j12 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT);
            if (!TextUtils.isEmpty(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME))) {
                this.zzt.zzf();
                if (j12 > 15552000000L || j12 < 1) {
                    this.zzt.zzaA().zzd().zzc("Invalid conditional user property timeout", this.zzt.zzj().zzf(string), Long.valueOf(j12));
                    return;
                }
            }
            long j13 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE);
            this.zzt.zzf();
            if (j13 > 15552000000L || j13 < 1) {
                this.zzt.zzaA().zzd().zzc("Invalid conditional user property time to live", this.zzt.zzj().zzf(string), Long.valueOf(j13));
            } else {
                this.zzt.zzaB().zzp(new zzht(this, bundle2));
            }
        } else {
            this.zzt.zzaA().zzd().zzc("Invalid conditional user property value", this.zzt.zzj().zzf(string), obj);
        }
    }

    public final void zzR(zzhb zzhb, long j11) {
        zzhb zzhb2;
        boolean z11;
        boolean z12;
        boolean z13;
        zza();
        int zza2 = zzhb.zza();
        if (zza2 != -10 && zzhb.zzf() == null && zzhb.zzg() == null) {
            this.zzt.zzaA().zzl().zza("Discarding empty consent settings");
            return;
        }
        synchronized (this.zzh) {
            zzhb2 = this.zzi;
            z11 = true;
            z12 = false;
            if (zzhb.zzk(zza2, zzhb2.zza())) {
                boolean zzm = zzhb.zzm(this.zzi);
                zzha zzha = zzha.ANALYTICS_STORAGE;
                if (zzhb.zzj(zzha) && !this.zzi.zzj(zzha)) {
                    z12 = true;
                }
                zzhb = zzhb.zze(this.zzi);
                this.zzi = zzhb;
                z13 = z12;
                z12 = zzm;
            } else {
                z11 = false;
                z13 = false;
            }
        }
        if (!z11) {
            this.zzt.zzaA().zzi().zzb("Ignoring lower-priority consent settings, proposed settings", zzhb);
            return;
        }
        long andIncrement = this.zzj.getAndIncrement();
        if (z12) {
            this.zzg.set((Object) null);
            this.zzt.zzaB().zzq(new zzif(this, zzhb, j11, andIncrement, z13, zzhb2));
            return;
        }
        zzig zzig = new zzig(this, zzhb, andIncrement, z13, zzhb2);
        if (zza2 == 30 || zza2 == -10) {
            this.zzt.zzaB().zzq(zzig);
        } else {
            this.zzt.zzaB().zzp(zzig);
        }
    }

    public final void zzS(Bundle bundle, int i11, long j11) {
        zza();
        String zzh2 = zzhb.zzh(bundle);
        if (zzh2 != null) {
            this.zzt.zzaA().zzl().zzb("Ignoring invalid consent setting", zzh2);
            this.zzt.zzaA().zzl().zza("Valid consent values are 'granted', 'denied'");
        }
        zzR(zzhb.zzb(bundle, i11), j11);
    }

    public final void zzT(zzhf zzhf) {
        zzhf zzhf2;
        zzg();
        zza();
        if (!(zzhf == null || zzhf == (zzhf2 = this.zzd))) {
            Preconditions.checkState(zzhf2 == null, "EventInterceptor already set.");
        }
        this.zzd = zzhf;
    }

    public final void zzU(Boolean bool) {
        zza();
        this.zzt.zzaB().zzp(new zzie(this, bool));
    }

    public final void zzV(zzhb zzhb) {
        zzg();
        boolean z11 = (zzhb.zzj(zzha.ANALYTICS_STORAGE) && zzhb.zzj(zzha.AD_STORAGE)) || this.zzt.zzt().zzM();
        if (z11 != this.zzt.zzK()) {
            this.zzt.zzG(z11);
            zzfi zzm = this.zzt.zzm();
            zzgd zzgd = zzm.zzt;
            zzm.zzg();
            Boolean valueOf = zzm.zza().contains("measurement_enabled_from_api") ? Boolean.valueOf(zzm.zza().getBoolean("measurement_enabled_from_api", true)) : null;
            if (!z11 || valueOf == null || valueOf.booleanValue()) {
                zzaa(Boolean.valueOf(z11), false);
            }
        }
    }

    public final void zzW(String str, String str2, Object obj, boolean z11) {
        zzX(TtmlNode.TEXT_EMPHASIS_AUTO, "_ldl", obj, true, this.zzt.zzax().currentTimeMillis());
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0068  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzX(java.lang.String r16, java.lang.String r17, java.lang.Object r18, boolean r19, long r20) {
        /*
            r15 = this;
            r6 = r15
            r2 = r17
            r0 = r18
            r1 = 6
            r3 = 0
            r4 = 24
            if (r19 == 0) goto L_0x0017
            com.google.android.gms.measurement.internal.zzgd r1 = r6.zzt
            com.google.android.gms.measurement.internal.zzlp r1 = r1.zzv()
            int r1 = r1.zzl(r2)
        L_0x0015:
            r10 = r1
            goto L_0x0040
        L_0x0017:
            com.google.android.gms.measurement.internal.zzgd r5 = r6.zzt
            com.google.android.gms.measurement.internal.zzlp r5 = r5.zzv()
            java.lang.String r7 = "user property"
            boolean r8 = r5.zzad(r7, r2)
            if (r8 != 0) goto L_0x0027
        L_0x0026:
            goto L_0x0015
        L_0x0027:
            java.lang.String[] r8 = com.google.android.gms.measurement.internal.zzhe.zza
            r9 = 0
            boolean r8 = r5.zzaa(r7, r8, r9, r2)
            if (r8 != 0) goto L_0x0033
            r1 = 15
            goto L_0x0015
        L_0x0033:
            com.google.android.gms.measurement.internal.zzgd r8 = r5.zzt
            r8.zzf()
            boolean r5 = r5.zzZ(r7, r4, r2)
            if (r5 != 0) goto L_0x003f
            goto L_0x0026
        L_0x003f:
            r10 = r3
        L_0x0040:
            r1 = 1
            if (r10 == 0) goto L_0x0068
            com.google.android.gms.measurement.internal.zzgd r0 = r6.zzt
            com.google.android.gms.measurement.internal.zzlp r0 = r0.zzv()
            com.google.android.gms.measurement.internal.zzgd r5 = r6.zzt
            r5.zzf()
            java.lang.String r12 = r0.zzD(r2, r4, r1)
            if (r2 == 0) goto L_0x0058
            int r3 = r17.length()
        L_0x0058:
            r13 = r3
            com.google.android.gms.measurement.internal.zzgd r0 = r6.zzt
            com.google.android.gms.measurement.internal.zzlp r7 = r0.zzv()
            com.google.android.gms.measurement.internal.zzlo r8 = r6.zzl
            r9 = 0
            java.lang.String r11 = "_ev"
            r7.zzO(r8, r9, r10, r11, r12, r13)
            return
        L_0x0068:
            if (r16 != 0) goto L_0x006d
            java.lang.String r5 = "app"
            goto L_0x006f
        L_0x006d:
            r5 = r16
        L_0x006f:
            if (r0 == 0) goto L_0x00c3
            com.google.android.gms.measurement.internal.zzgd r7 = r6.zzt
            com.google.android.gms.measurement.internal.zzlp r7 = r7.zzv()
            int r11 = r7.zzd(r2, r0)
            if (r11 == 0) goto L_0x00ac
            com.google.android.gms.measurement.internal.zzgd r5 = r6.zzt
            com.google.android.gms.measurement.internal.zzlp r5 = r5.zzv()
            com.google.android.gms.measurement.internal.zzgd r7 = r6.zzt
            r7.zzf()
            java.lang.String r13 = r5.zzD(r2, r4, r1)
            boolean r1 = r0 instanceof java.lang.String
            if (r1 != 0) goto L_0x0094
            boolean r1 = r0 instanceof java.lang.CharSequence
            if (r1 == 0) goto L_0x009c
        L_0x0094:
            java.lang.String r0 = r18.toString()
            int r3 = r0.length()
        L_0x009c:
            r14 = r3
            com.google.android.gms.measurement.internal.zzgd r0 = r6.zzt
            com.google.android.gms.measurement.internal.zzlp r8 = r0.zzv()
            com.google.android.gms.measurement.internal.zzlo r9 = r6.zzl
            r10 = 0
            java.lang.String r12 = "_ev"
            r8.zzO(r9, r10, r11, r12, r13, r14)
            return
        L_0x00ac:
            com.google.android.gms.measurement.internal.zzgd r1 = r6.zzt
            com.google.android.gms.measurement.internal.zzlp r1 = r1.zzv()
            java.lang.Object r7 = r1.zzB(r2, r0)
            if (r7 == 0) goto L_0x00c2
            r0 = r15
            r1 = r5
            r2 = r17
            r3 = r20
            r5 = r7
            r0.zzN(r1, r2, r3, r5)
        L_0x00c2:
            return
        L_0x00c3:
            r7 = 0
            r0 = r15
            r1 = r5
            r2 = r17
            r3 = r20
            r5 = r7
            r0.zzN(r1, r2, r3, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzik.zzX(java.lang.String, java.lang.String, java.lang.Object, boolean, long):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0080  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzY(java.lang.String r9, java.lang.String r10, java.lang.Object r11, long r12) {
        /*
            r8 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)
            r8.zzg()
            r8.zza()
            java.lang.String r0 = "allow_personalized_ads"
            boolean r0 = r0.equals(r10)
            java.lang.String r1 = "_npa"
            if (r0 == 0) goto L_0x0066
            boolean r0 = r11 instanceof java.lang.String
            if (r0 == 0) goto L_0x0053
            r0 = r11
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x0053
            java.util.Locale r10 = java.util.Locale.ENGLISH
            java.lang.String r10 = r0.toLowerCase(r10)
            r11 = 1
            java.lang.String r0 = "false"
            boolean r10 = r0.equals(r10)
            r2 = 1
            if (r11 == r10) goto L_0x0037
            r10 = 0
            goto L_0x0038
        L_0x0037:
            r10 = r2
        L_0x0038:
            java.lang.Long r11 = java.lang.Long.valueOf(r10)
            com.google.android.gms.measurement.internal.zzgd r10 = r8.zzt
            com.google.android.gms.measurement.internal.zzfi r10 = r10.zzm()
            com.google.android.gms.measurement.internal.zzfh r10 = r10.zzh
            long r4 = r11.longValue()
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 != 0) goto L_0x004f
            java.lang.String r0 = "true"
        L_0x004f:
            r10.zzb(r0)
            goto L_0x0063
        L_0x0053:
            if (r11 != 0) goto L_0x0066
            com.google.android.gms.measurement.internal.zzgd r10 = r8.zzt
            com.google.android.gms.measurement.internal.zzfi r10 = r10.zzm()
            com.google.android.gms.measurement.internal.zzfh r10 = r10.zzh
            java.lang.String r0 = "unset"
            r10.zzb(r0)
        L_0x0063:
            r6 = r11
            r3 = r1
            goto L_0x0068
        L_0x0066:
            r3 = r10
            r6 = r11
        L_0x0068:
            com.google.android.gms.measurement.internal.zzgd r10 = r8.zzt
            boolean r10 = r10.zzJ()
            if (r10 != 0) goto L_0x0080
            com.google.android.gms.measurement.internal.zzgd r9 = r8.zzt
            com.google.android.gms.measurement.internal.zzet r9 = r9.zzaA()
            com.google.android.gms.measurement.internal.zzer r9 = r9.zzj()
            java.lang.String r10 = "User property not set since app measurement is disabled"
            r9.zza(r10)
            return
        L_0x0080:
            com.google.android.gms.measurement.internal.zzgd r10 = r8.zzt
            boolean r10 = r10.zzM()
            if (r10 != 0) goto L_0x0089
            return
        L_0x0089:
            com.google.android.gms.measurement.internal.zzlk r10 = new com.google.android.gms.measurement.internal.zzlk
            r2 = r10
            r4 = r12
            r7 = r9
            r2.<init>(r3, r4, r6, r7)
            com.google.android.gms.measurement.internal.zzgd r9 = r8.zzt
            com.google.android.gms.measurement.internal.zzjz r9 = r9.zzt()
            r9.zzK(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzik.zzY(java.lang.String, java.lang.String, java.lang.Object, long):void");
    }

    public final void zzZ(zzhg zzhg) {
        zza();
        Preconditions.checkNotNull(zzhg);
        if (!this.zze.remove(zzhg)) {
            this.zzt.zzaA().zzk().zza("OnEventListener had not been registered");
        }
    }

    public final boolean zzf() {
        return false;
    }

    public final int zzh(String str) {
        Preconditions.checkNotEmpty(str);
        this.zzt.zzf();
        return 25;
    }

    public final Boolean zzi() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) this.zzt.zzaB().zzd(atomicReference, 15000, "boolean test flag value", new zzhw(this, atomicReference));
    }

    public final Double zzj() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) this.zzt.zzaB().zzd(atomicReference, 15000, "double test flag value", new zzid(this, atomicReference));
    }

    public final Integer zzl() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) this.zzt.zzaB().zzd(atomicReference, 15000, "int test flag value", new zzic(this, atomicReference));
    }

    public final Long zzm() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) this.zzt.zzaB().zzd(atomicReference, 15000, "long test flag value", new zzib(this, atomicReference));
    }

    public final String zzo() {
        return (String) this.zzg.get();
    }

    public final String zzp() {
        zzir zzi2 = this.zzt.zzs().zzi();
        if (zzi2 != null) {
            return zzi2.zzb;
        }
        return null;
    }

    public final String zzq() {
        zzir zzi2 = this.zzt.zzs().zzi();
        if (zzi2 != null) {
            return zzi2.zza;
        }
        return null;
    }

    public final String zzr() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) this.zzt.zzaB().zzd(atomicReference, 15000, "String test flag value", new zzia(this, atomicReference));
    }

    public final ArrayList zzs(String str, String str2) {
        if (this.zzt.zzaB().zzs()) {
            this.zzt.zzaA().zzd().zza("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList(0);
        }
        this.zzt.zzay();
        if (zzab.zza()) {
            this.zzt.zzaA().zzd().zza("Cannot get conditional user properties from main thread");
            return new ArrayList(0);
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzt.zzaB().zzd(atomicReference, 5000, "get conditional user properties", new zzhv(this, atomicReference, (String) null, str, str2));
        List list = (List) atomicReference.get();
        if (list != null) {
            return zzlp.zzH(list);
        }
        this.zzt.zzaA().zzd().zzb("Timed out waiting for get conditional user properties", (Object) null);
        return new ArrayList();
    }

    public final List zzt(boolean z11) {
        zza();
        this.zzt.zzaA().zzj().zza("Getting user properties (FE)");
        if (!this.zzt.zzaB().zzs()) {
            this.zzt.zzay();
            if (zzab.zza()) {
                this.zzt.zzaA().zzd().zza("Cannot get all user properties from main thread");
                return Collections.emptyList();
            }
            AtomicReference atomicReference = new AtomicReference();
            this.zzt.zzaB().zzd(atomicReference, 5000, "get user properties", new zzhr(this, atomicReference, z11));
            List list = (List) atomicReference.get();
            if (list != null) {
                return list;
            }
            this.zzt.zzaA().zzd().zzb("Timed out waiting for get user properties, includeInternal", Boolean.valueOf(z11));
            return Collections.emptyList();
        }
        this.zzt.zzaA().zzd().zza("Cannot get all user properties from analytics worker thread");
        return Collections.emptyList();
    }

    public final Map zzu(String str, String str2, boolean z11) {
        if (this.zzt.zzaB().zzs()) {
            this.zzt.zzaA().zzd().zza("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        }
        this.zzt.zzay();
        if (zzab.zza()) {
            this.zzt.zzaA().zzd().zza("Cannot get user properties from main thread");
            return Collections.emptyMap();
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzt.zzaB().zzd(atomicReference, 5000, "get user properties", new zzhx(this, atomicReference, (String) null, str, str2, z11));
        List<zzlk> list = (List) atomicReference.get();
        if (list == null) {
            this.zzt.zzaA().zzd().zzb("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z11));
            return Collections.emptyMap();
        }
        ArrayMap arrayMap = new ArrayMap(list.size());
        for (zzlk zzlk : list) {
            Object zza2 = zzlk.zza();
            if (zza2 != null) {
                arrayMap.put(zzlk.zzb, zza2);
            }
        }
        return arrayMap;
    }

    public final void zzz() {
        zzg();
        zza();
        if (this.zzt.zzM()) {
            if (this.zzt.zzf().zzs((String) null, zzeg.zzZ)) {
                zzag zzf2 = this.zzt.zzf();
                zzf2.zzt.zzay();
                Boolean zzk2 = zzf2.zzk("google_analytics_deferred_deep_link_enabled");
                if (zzk2 != null && zzk2.booleanValue()) {
                    this.zzt.zzaA().zzc().zza("Deferred Deep Link feature enabled.");
                    this.zzt.zzaB().zzp(new zzhm(this));
                }
            }
            this.zzt.zzt().zzq();
            this.zzc = false;
            zzfi zzm = this.zzt.zzm();
            zzm.zzg();
            String string = zzm.zza().getString("previous_os_version", (String) null);
            zzm.zzt.zzg().zzv();
            String str = Build.VERSION.RELEASE;
            if (!TextUtils.isEmpty(str) && !str.equals(string)) {
                SharedPreferences.Editor edit = zzm.zza().edit();
                edit.putString("previous_os_version", str);
                edit.apply();
            }
            if (!TextUtils.isEmpty(string)) {
                this.zzt.zzg().zzv();
                if (!string.equals(str)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("_po", string);
                    zzG(TtmlNode.TEXT_EMPHASIS_AUTO, "_ou", bundle);
                }
            }
        }
    }
}
