package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.adjust.sdk.Constants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzcl;
import com.google.android.gms.internal.measurement.zzib;
import com.google.firebase.messaging.Constants;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.dataflow.qual.Pure;
import org.checkerframework.dataflow.qual.SideEffectFree;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzgd implements zzgy {
    private static volatile zzgd zzd;
    private zzek zzA;
    private boolean zzB = false;
    private Boolean zzC;
    private long zzD;
    private volatile Boolean zzE;
    private volatile boolean zzF;
    private int zzG;
    private final AtomicInteger zzH = new AtomicInteger(0);
    public Boolean zza;
    public Boolean zzb;
    public final long zzc;
    private final Context zze;
    private final String zzf;
    private final String zzg;
    private final String zzh;
    private final boolean zzi;
    private final zzab zzj;
    private final zzag zzk;
    private final zzfi zzl;
    private final zzet zzm;
    private final zzga zzn;
    private final zzkp zzo;
    private final zzlp zzp;
    private final zzeo zzq;
    private final Clock zzr;
    private final zziz zzs;
    private final zzik zzt;
    private final zzd zzu;
    private final zzio zzv;
    private final String zzw;
    private zzem zzx;
    private zzjz zzy;
    private zzao zzz;

    public zzgd(zzhi zzhi) {
        long j11;
        Bundle bundle;
        boolean z11 = false;
        Preconditions.checkNotNull(zzhi);
        Context context = zzhi.zza;
        zzab zzab = new zzab(context);
        this.zzj = zzab;
        zzed.zza = zzab;
        this.zze = context;
        this.zzf = zzhi.zzb;
        this.zzg = zzhi.zzc;
        this.zzh = zzhi.zzd;
        this.zzi = zzhi.zzh;
        this.zzE = zzhi.zze;
        this.zzw = zzhi.zzj;
        this.zzF = true;
        zzcl zzcl = zzhi.zzg;
        if (!(zzcl == null || (bundle = zzcl.zzg) == null)) {
            Object obj = bundle.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.zza = (Boolean) obj;
            }
            Object obj2 = zzcl.zzg.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.zzb = (Boolean) obj2;
            }
        }
        zzib.zzd(context);
        Clock instance = DefaultClock.getInstance();
        this.zzr = instance;
        Long l11 = zzhi.zzi;
        if (l11 != null) {
            j11 = l11.longValue();
        } else {
            j11 = instance.currentTimeMillis();
        }
        this.zzc = j11;
        this.zzk = new zzag(this);
        zzfi zzfi = new zzfi(this);
        zzfi.zzw();
        this.zzl = zzfi;
        zzet zzet = new zzet(this);
        zzet.zzw();
        this.zzm = zzet;
        zzlp zzlp = new zzlp(this);
        zzlp.zzw();
        this.zzp = zzlp;
        this.zzq = new zzeo(new zzhh(zzhi, this));
        this.zzu = new zzd(this);
        zziz zziz = new zziz(this);
        zziz.zzb();
        this.zzs = zziz;
        zzik zzik = new zzik(this);
        zzik.zzb();
        this.zzt = zzik;
        zzkp zzkp = new zzkp(this);
        zzkp.zzb();
        this.zzo = zzkp;
        zzio zzio = new zzio(this);
        zzio.zzw();
        this.zzv = zzio;
        zzga zzga = new zzga(this);
        zzga.zzw();
        this.zzn = zzga;
        zzcl zzcl2 = zzhi.zzg;
        z11 = (zzcl2 == null || zzcl2.zzb == 0) ? true : z11;
        if (context.getApplicationContext() instanceof Application) {
            zzik zzq2 = zzq();
            if (zzq2.zzt.zze.getApplicationContext() instanceof Application) {
                Application application = (Application) zzq2.zzt.zze.getApplicationContext();
                if (zzq2.zza == null) {
                    zzq2.zza = new zzij(zzq2);
                }
                if (z11) {
                    application.unregisterActivityLifecycleCallbacks(zzq2.zza);
                    application.registerActivityLifecycleCallbacks(zzq2.zza);
                    zzq2.zzt.zzaA().zzj().zza("Registered activity lifecycle callback");
                }
            }
        } else {
            zzaA().zzk().zza("Application context is not an Application");
        }
        zzga.zzp(new zzgc(this, zzhi));
    }

    public static /* bridge */ /* synthetic */ void zzA(zzgd zzgd, zzhi zzhi) {
        zzgd.zzaB().zzg();
        zzgd.zzk.zzn();
        zzao zzao = new zzao(zzgd);
        zzao.zzw();
        zzgd.zzz = zzao;
        zzek zzek = new zzek(zzgd, zzhi.zzf);
        zzek.zzb();
        zzgd.zzA = zzek;
        zzem zzem = new zzem(zzgd);
        zzem.zzb();
        zzgd.zzx = zzem;
        zzjz zzjz = new zzjz(zzgd);
        zzjz.zzb();
        zzgd.zzy = zzjz;
        zzgd.zzp.zzx();
        zzgd.zzl.zzx();
        zzgd.zzA.zzc();
        zzer zzi2 = zzgd.zzaA().zzi();
        zzgd.zzk.zzh();
        zzi2.zzb("App measurement initialized, version", 79000L);
        zzgd.zzaA().zzi().zza("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String zzl2 = zzek.zzl();
        if (TextUtils.isEmpty(zzgd.zzf)) {
            if (zzgd.zzv().zzaf(zzl2)) {
                zzgd.zzaA().zzi().zza("Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.");
            } else {
                zzgd.zzaA().zzi().zza("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(String.valueOf(zzl2)));
            }
        }
        zzgd.zzaA().zzc().zza("Debug-level message logging enabled");
        if (zzgd.zzG != zzgd.zzH.get()) {
            zzgd.zzaA().zzd().zzc("Not all components initialized", Integer.valueOf(zzgd.zzG), Integer.valueOf(zzgd.zzH.get()));
        }
        zzgd.zzB = true;
    }

    public static final void zzO() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    private static final void zzP(zzgw zzgw) {
        if (zzgw == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private static final void zzQ(zzf zzf2) {
        if (zzf2 == null) {
            throw new IllegalStateException("Component not created");
        } else if (!zzf2.zze()) {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(zzf2.getClass())));
        }
    }

    private static final void zzR(zzgx zzgx) {
        if (zzgx == null) {
            throw new IllegalStateException("Component not created");
        } else if (!zzgx.zzy()) {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(zzgx.getClass())));
        }
    }

    public static zzgd zzp(Context context, zzcl zzcl, Long l11) {
        Bundle bundle;
        if (zzcl != null && (zzcl.zze == null || zzcl.zzf == null)) {
            zzcl = new zzcl(zzcl.zza, zzcl.zzb, zzcl.zzc, zzcl.zzd, (String) null, (String) null, zzcl.zzg, (String) null);
        }
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzd == null) {
            synchronized (zzgd.class) {
                if (zzd == null) {
                    zzd = new zzgd(new zzhi(context, zzcl, l11));
                }
            }
        } else if (!(zzcl == null || (bundle = zzcl.zzg) == null || !bundle.containsKey("dataCollectionDefaultEnabled"))) {
            Preconditions.checkNotNull(zzd);
            zzd.zzE = Boolean.valueOf(zzcl.zzg.getBoolean("dataCollectionDefaultEnabled"));
        }
        Preconditions.checkNotNull(zzd);
        return zzd;
    }

    public final void zzB() {
        this.zzH.incrementAndGet();
    }

    public final /* synthetic */ void zzC(String str, int i11, Throwable th2, byte[] bArr, Map map) {
        if (!(i11 == 200 || i11 == 204)) {
            if (i11 == 304) {
                i11 = 304;
            }
            zzaA().zzk().zzc("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i11), th2);
        }
        if (th2 == null) {
            zzm().zzn.zza(true);
            if (bArr == null || bArr.length == 0) {
                zzaA().zzc().zza("Deferred Deep Link response empty.");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr));
                String optString = jSONObject.optString(Constants.DEEPLINK, "");
                String optString2 = jSONObject.optString("gclid", "");
                double optDouble = jSONObject.optDouble("timestamp", 0.0d);
                if (TextUtils.isEmpty(optString)) {
                    zzaA().zzc().zza("Deferred Deep Link is empty.");
                    return;
                }
                zzlp zzv2 = zzv();
                zzgd zzgd = zzv2.zzt;
                if (!TextUtils.isEmpty(optString)) {
                    List<ResolveInfo> queryIntentActivities = zzv2.zzt.zze.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(optString)), 0);
                    if (queryIntentActivities != null && !queryIntentActivities.isEmpty()) {
                        Bundle bundle = new Bundle();
                        bundle.putString("gclid", optString2);
                        bundle.putString("_cis", "ddp");
                        this.zzt.zzG(TtmlNode.TEXT_EMPHASIS_AUTO, Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, bundle);
                        zzlp zzv3 = zzv();
                        if (!TextUtils.isEmpty(optString)) {
                            try {
                                SharedPreferences.Editor edit = zzv3.zzt.zze.getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
                                edit.putString(com.adjust.sdk.Constants.DEEPLINK, optString);
                                edit.putLong("timestamp", Double.doubleToRawLongBits(optDouble));
                                if (edit.commit()) {
                                    zzv3.zzt.zze.sendBroadcast(new Intent("android.google.analytics.action.DEEPLINK_ACTION"));
                                    return;
                                }
                                return;
                            } catch (RuntimeException e11) {
                                zzv3.zzt.zzaA().zzd().zzb("Failed to persist Deferred Deep Link. exception", e11);
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                }
                zzaA().zzk().zzc("Deferred Deep Link validation failed. gclid, deep link", optString2, optString);
                return;
            } catch (JSONException e12) {
                zzaA().zzd().zzb("Failed to parse the Deferred Deep Link response. exception", e12);
                return;
            }
        }
        zzaA().zzk().zzc("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i11), th2);
    }

    public final void zzD() {
        this.zzG++;
    }

    public final void zzE() {
        zzaB().zzg();
        zzR(zzr());
        String zzl2 = zzh().zzl();
        Pair zzb2 = zzm().zzb(zzl2);
        if (!this.zzk.zzr() || ((Boolean) zzb2.second).booleanValue() || TextUtils.isEmpty((CharSequence) zzb2.first)) {
            zzaA().zzc().zza("ADID unavailable to retrieve Deferred Deep Link. Skipping");
            return;
        }
        zzio zzr2 = zzr();
        zzr2.zzv();
        ConnectivityManager connectivityManager = (ConnectivityManager) zzr2.zzt.zze.getSystemService("connectivity");
        NetworkInfo networkInfo = null;
        if (connectivityManager != null) {
            try {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (SecurityException unused) {
            }
        }
        if (networkInfo == null || !networkInfo.isConnected()) {
            zzaA().zzk().zza("Network is not available for Deferred Deep Link request. Skipping");
            return;
        }
        zzlp zzv2 = zzv();
        zzh().zzt.zzk.zzh();
        URL zzE2 = zzv2.zzE(79000, zzl2, (String) zzb2.first, zzm().zzo.zza() - 1);
        if (zzE2 != null) {
            zzio zzr3 = zzr();
            zzgb zzgb = new zzgb(this);
            zzr3.zzg();
            zzr3.zzv();
            Preconditions.checkNotNull(zzE2);
            Preconditions.checkNotNull(zzgb);
            zzr3.zzt.zzaB().zzo(new zzin(zzr3, zzl2, zzE2, (byte[]) null, (Map) null, zzgb));
        }
    }

    public final void zzF(boolean z11) {
        this.zzE = Boolean.valueOf(z11);
    }

    public final void zzG(boolean z11) {
        zzaB().zzg();
        this.zzF = z11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0095, code lost:
        if (r8.zzl() == false) goto L_0x0097;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzH(com.google.android.gms.internal.measurement.zzcl r8) {
        /*
            r7 = this;
            com.google.android.gms.measurement.internal.zzga r0 = r7.zzaB()
            r0.zzg()
            com.google.android.gms.measurement.internal.zzfi r0 = r7.zzm()
            com.google.android.gms.measurement.internal.zzhb r0 = r0.zzc()
            int r1 = r0.zza()
            com.google.android.gms.measurement.internal.zzag r2 = r7.zzk
            com.google.android.gms.measurement.internal.zzgd r3 = r2.zzt
            java.lang.String r3 = "google_analytics_default_allow_ad_storage"
            java.lang.Boolean r2 = r2.zzk(r3)
            com.google.android.gms.measurement.internal.zzag r3 = r7.zzk
            com.google.android.gms.measurement.internal.zzgd r4 = r3.zzt
            java.lang.String r4 = "google_analytics_default_allow_analytics_storage"
            java.lang.Boolean r3 = r3.zzk(r4)
            r4 = -10
            r5 = 0
            if (r2 != 0) goto L_0x002e
            if (r3 == 0) goto L_0x003e
        L_0x002e:
            com.google.android.gms.measurement.internal.zzfi r6 = r7.zzm()
            boolean r6 = r6.zzl(r4)
            if (r6 == 0) goto L_0x003e
            com.google.android.gms.measurement.internal.zzhb r8 = new com.google.android.gms.measurement.internal.zzhb
            r8.<init>(r2, r3, r4)
            goto L_0x0098
        L_0x003e:
            com.google.android.gms.measurement.internal.zzek r2 = r7.zzh()
            java.lang.String r2 = r2.zzm()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            r3 = 30
            if (r2 != 0) goto L_0x006d
            if (r1 == 0) goto L_0x005e
            if (r1 == r3) goto L_0x005e
            r2 = 10
            if (r1 == r2) goto L_0x005e
            if (r1 == r3) goto L_0x005e
            if (r1 == r3) goto L_0x005e
            r2 = 40
            if (r1 != r2) goto L_0x006d
        L_0x005e:
            com.google.android.gms.measurement.internal.zzik r8 = r7.zzq()
            com.google.android.gms.measurement.internal.zzhb r1 = new com.google.android.gms.measurement.internal.zzhb
            r1.<init>(r5, r5, r4)
            long r2 = r7.zzc
            r8.zzR(r1, r2)
            goto L_0x0097
        L_0x006d:
            com.google.android.gms.measurement.internal.zzek r1 = r7.zzh()
            java.lang.String r1 = r1.zzm()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x0097
            if (r8 == 0) goto L_0x0097
            android.os.Bundle r1 = r8.zzg
            if (r1 == 0) goto L_0x0097
            com.google.android.gms.measurement.internal.zzfi r1 = r7.zzm()
            boolean r1 = r1.zzl(r3)
            if (r1 == 0) goto L_0x0097
            android.os.Bundle r8 = r8.zzg
            com.google.android.gms.measurement.internal.zzhb r8 = com.google.android.gms.measurement.internal.zzhb.zzb(r8, r3)
            boolean r1 = r8.zzl()
            if (r1 != 0) goto L_0x0098
        L_0x0097:
            r8 = r5
        L_0x0098:
            if (r8 == 0) goto L_0x00a4
            com.google.android.gms.measurement.internal.zzik r0 = r7.zzq()
            long r1 = r7.zzc
            r0.zzR(r8, r1)
            r0 = r8
        L_0x00a4:
            com.google.android.gms.measurement.internal.zzik r8 = r7.zzq()
            r8.zzV(r0)
            com.google.android.gms.measurement.internal.zzfi r8 = r7.zzm()
            com.google.android.gms.measurement.internal.zzfe r8 = r8.zzc
            long r0 = r8.zza()
            r2 = 0
            int r8 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r8 != 0) goto L_0x00d9
            com.google.android.gms.measurement.internal.zzet r8 = r7.zzaA()
            com.google.android.gms.measurement.internal.zzer r8 = r8.zzj()
            long r0 = r7.zzc
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            java.lang.String r1 = "Persisting first open"
            r8.zzb(r1, r0)
            com.google.android.gms.measurement.internal.zzfi r8 = r7.zzm()
            com.google.android.gms.measurement.internal.zzfe r8 = r8.zzc
            long r0 = r7.zzc
            r8.zzb(r0)
        L_0x00d9:
            com.google.android.gms.measurement.internal.zzik r8 = r7.zzq()
            com.google.android.gms.measurement.internal.zzs r8 = r8.zzb
            r8.zzc()
            boolean r8 = r7.zzM()
            if (r8 != 0) goto L_0x016e
            boolean r8 = r7.zzJ()
            if (r8 == 0) goto L_0x0329
            com.google.android.gms.measurement.internal.zzlp r8 = r7.zzv()
            java.lang.String r0 = "android.permission.INTERNET"
            boolean r8 = r8.zzae(r0)
            if (r8 != 0) goto L_0x0107
            com.google.android.gms.measurement.internal.zzet r8 = r7.zzaA()
            com.google.android.gms.measurement.internal.zzer r8 = r8.zzd()
            java.lang.String r0 = "App is missing INTERNET permission"
            r8.zza(r0)
        L_0x0107:
            com.google.android.gms.measurement.internal.zzlp r8 = r7.zzv()
            java.lang.String r0 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r8 = r8.zzae(r0)
            if (r8 != 0) goto L_0x0120
            com.google.android.gms.measurement.internal.zzet r8 = r7.zzaA()
            com.google.android.gms.measurement.internal.zzer r8 = r8.zzd()
            java.lang.String r0 = "App is missing ACCESS_NETWORK_STATE permission"
            r8.zza(r0)
        L_0x0120:
            android.content.Context r8 = r7.zze
            com.google.android.gms.common.wrappers.PackageManagerWrapper r8 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r8)
            boolean r8 = r8.isCallerInstantApp()
            if (r8 != 0) goto L_0x015f
            com.google.android.gms.measurement.internal.zzag r8 = r7.zzk
            boolean r8 = r8.zzx()
            if (r8 != 0) goto L_0x015f
            android.content.Context r8 = r7.zze
            boolean r8 = com.google.android.gms.measurement.internal.zzlp.zzal(r8)
            if (r8 != 0) goto L_0x0149
            com.google.android.gms.measurement.internal.zzet r8 = r7.zzaA()
            com.google.android.gms.measurement.internal.zzer r8 = r8.zzd()
            java.lang.String r0 = "AppMeasurementReceiver not registered/enabled"
            r8.zza(r0)
        L_0x0149:
            android.content.Context r8 = r7.zze
            r0 = 0
            boolean r8 = com.google.android.gms.measurement.internal.zzlp.zzam(r8, r0)
            if (r8 != 0) goto L_0x015f
            com.google.android.gms.measurement.internal.zzet r8 = r7.zzaA()
            com.google.android.gms.measurement.internal.zzer r8 = r8.zzd()
            java.lang.String r0 = "AppMeasurementService not registered/enabled"
            r8.zza(r0)
        L_0x015f:
            com.google.android.gms.measurement.internal.zzet r8 = r7.zzaA()
            com.google.android.gms.measurement.internal.zzer r8 = r8.zzd()
            java.lang.String r0 = "Uploading is not possible. App measurement disabled"
            r8.zza(r0)
            goto L_0x0329
        L_0x016e:
            com.google.android.gms.measurement.internal.zzek r8 = r7.zzh()
            java.lang.String r8 = r8.zzm()
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 == 0) goto L_0x018a
            com.google.android.gms.measurement.internal.zzek r8 = r7.zzh()
            java.lang.String r8 = r8.zzk()
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x0250
        L_0x018a:
            com.google.android.gms.measurement.internal.zzlp r8 = r7.zzv()
            com.google.android.gms.measurement.internal.zzek r0 = r7.zzh()
            java.lang.String r0 = r0.zzm()
            com.google.android.gms.measurement.internal.zzfi r1 = r7.zzm()
            r1.zzg()
            android.content.SharedPreferences r1 = r1.zza()
            java.lang.String r2 = "gmp_app_id"
            java.lang.String r1 = r1.getString(r2, r5)
            com.google.android.gms.measurement.internal.zzek r3 = r7.zzh()
            java.lang.String r3 = r3.zzk()
            com.google.android.gms.measurement.internal.zzfi r4 = r7.zzm()
            r4.zzg()
            android.content.SharedPreferences r4 = r4.zza()
            java.lang.String r6 = "admob_app_id"
            java.lang.String r4 = r4.getString(r6, r5)
            boolean r8 = r8.zzao(r0, r1, r3, r4)
            if (r8 == 0) goto L_0x0216
            com.google.android.gms.measurement.internal.zzet r8 = r7.zzaA()
            com.google.android.gms.measurement.internal.zzer r8 = r8.zzi()
            java.lang.String r0 = "Rechecking which service to use due to a GMP App Id change"
            r8.zza(r0)
            com.google.android.gms.measurement.internal.zzfi r8 = r7.zzm()
            r8.zzg()
            java.lang.Boolean r0 = r8.zzd()
            android.content.SharedPreferences r1 = r8.zza()
            android.content.SharedPreferences$Editor r1 = r1.edit()
            r1.clear()
            r1.apply()
            if (r0 == 0) goto L_0x01f1
            r8.zzh(r0)
        L_0x01f1:
            com.google.android.gms.measurement.internal.zzem r8 = r7.zzi()
            r8.zzj()
            com.google.android.gms.measurement.internal.zzjz r8 = r7.zzy
            r8.zzs()
            com.google.android.gms.measurement.internal.zzjz r8 = r7.zzy
            r8.zzr()
            com.google.android.gms.measurement.internal.zzfi r8 = r7.zzm()
            com.google.android.gms.measurement.internal.zzfe r8 = r8.zzc
            long r0 = r7.zzc
            r8.zzb(r0)
            com.google.android.gms.measurement.internal.zzfi r8 = r7.zzm()
            com.google.android.gms.measurement.internal.zzfh r8 = r8.zze
            r8.zzb(r5)
        L_0x0216:
            com.google.android.gms.measurement.internal.zzfi r8 = r7.zzm()
            com.google.android.gms.measurement.internal.zzek r0 = r7.zzh()
            java.lang.String r0 = r0.zzm()
            r8.zzg()
            android.content.SharedPreferences r8 = r8.zza()
            android.content.SharedPreferences$Editor r8 = r8.edit()
            r8.putString(r2, r0)
            r8.apply()
            com.google.android.gms.measurement.internal.zzfi r8 = r7.zzm()
            com.google.android.gms.measurement.internal.zzek r0 = r7.zzh()
            java.lang.String r0 = r0.zzk()
            r8.zzg()
            android.content.SharedPreferences r8 = r8.zza()
            android.content.SharedPreferences$Editor r8 = r8.edit()
            r8.putString(r6, r0)
            r8.apply()
        L_0x0250:
            com.google.android.gms.measurement.internal.zzfi r8 = r7.zzm()
            com.google.android.gms.measurement.internal.zzhb r8 = r8.zzc()
            com.google.android.gms.measurement.internal.zzha r0 = com.google.android.gms.measurement.internal.zzha.ANALYTICS_STORAGE
            boolean r8 = r8.zzj(r0)
            if (r8 != 0) goto L_0x0269
            com.google.android.gms.measurement.internal.zzfi r8 = r7.zzm()
            com.google.android.gms.measurement.internal.zzfh r8 = r8.zze
            r8.zzb(r5)
        L_0x0269:
            com.google.android.gms.measurement.internal.zzik r8 = r7.zzq()
            com.google.android.gms.measurement.internal.zzfi r0 = r7.zzm()
            com.google.android.gms.measurement.internal.zzfh r0 = r0.zze
            java.lang.String r0 = r0.zza()
            r8.zzO(r0)
            com.google.android.gms.internal.measurement.zzos.zzc()
            com.google.android.gms.measurement.internal.zzag r8 = r7.zzk
            com.google.android.gms.measurement.internal.zzef r0 = com.google.android.gms.measurement.internal.zzeg.zzae
            boolean r8 = r8.zzs(r5, r0)
            if (r8 == 0) goto L_0x02bf
            com.google.android.gms.measurement.internal.zzlp r8 = r7.zzv()
            com.google.android.gms.measurement.internal.zzgd r8 = r8.zzt     // Catch:{ ClassNotFoundException -> 0x0299 }
            android.content.Context r8 = r8.zze     // Catch:{ ClassNotFoundException -> 0x0299 }
            java.lang.ClassLoader r8 = r8.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x0299 }
            java.lang.String r0 = "com.google.firebase.remoteconfig.FirebaseRemoteConfig"
            r8.loadClass(r0)     // Catch:{ ClassNotFoundException -> 0x0299 }
            goto L_0x02bf
        L_0x0299:
            com.google.android.gms.measurement.internal.zzfi r8 = r7.zzm()
            com.google.android.gms.measurement.internal.zzfh r8 = r8.zzp
            java.lang.String r8 = r8.zza()
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x02bf
            com.google.android.gms.measurement.internal.zzet r8 = r7.zzaA()
            com.google.android.gms.measurement.internal.zzer r8 = r8.zzk()
            java.lang.String r0 = "Remote config removed with active feature rollouts"
            r8.zza(r0)
            com.google.android.gms.measurement.internal.zzfi r8 = r7.zzm()
            com.google.android.gms.measurement.internal.zzfh r8 = r8.zzp
            r8.zzb(r5)
        L_0x02bf:
            com.google.android.gms.measurement.internal.zzek r8 = r7.zzh()
            java.lang.String r8 = r8.zzm()
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 == 0) goto L_0x02db
            com.google.android.gms.measurement.internal.zzek r8 = r7.zzh()
            java.lang.String r8 = r8.zzk()
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x0329
        L_0x02db:
            boolean r8 = r7.zzJ()
            com.google.android.gms.measurement.internal.zzfi r0 = r7.zzm()
            boolean r0 = r0.zzj()
            if (r0 != 0) goto L_0x02fa
            com.google.android.gms.measurement.internal.zzag r0 = r7.zzk
            boolean r0 = r0.zzv()
            if (r0 != 0) goto L_0x02fa
            com.google.android.gms.measurement.internal.zzfi r0 = r7.zzm()
            r1 = r8 ^ 1
            r0.zzi(r1)
        L_0x02fa:
            if (r8 == 0) goto L_0x0303
            com.google.android.gms.measurement.internal.zzik r8 = r7.zzq()
            r8.zzz()
        L_0x0303:
            com.google.android.gms.measurement.internal.zzkp r8 = r7.zzu()
            com.google.android.gms.measurement.internal.zzko r8 = r8.zza
            r8.zza()
            com.google.android.gms.measurement.internal.zzjz r8 = r7.zzt()
            java.util.concurrent.atomic.AtomicReference r0 = new java.util.concurrent.atomic.AtomicReference
            r0.<init>()
            r8.zzu(r0)
            com.google.android.gms.measurement.internal.zzjz r8 = r7.zzt()
            com.google.android.gms.measurement.internal.zzfi r0 = r7.zzm()
            com.google.android.gms.measurement.internal.zzfd r0 = r0.zzs
            android.os.Bundle r0 = r0.zza()
            r8.zzH(r0)
        L_0x0329:
            com.google.android.gms.measurement.internal.zzfi r8 = r7.zzm()
            com.google.android.gms.measurement.internal.zzfc r8 = r8.zzi
            r0 = 1
            r8.zza(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgd.zzH(com.google.android.gms.internal.measurement.zzcl):void");
    }

    public final boolean zzI() {
        return this.zzE != null && this.zzE.booleanValue();
    }

    public final boolean zzJ() {
        return zza() == 0;
    }

    public final boolean zzK() {
        zzaB().zzg();
        return this.zzF;
    }

    @Pure
    public final boolean zzL() {
        return TextUtils.isEmpty(this.zzf);
    }

    public final boolean zzM() {
        if (this.zzB) {
            zzaB().zzg();
            Boolean bool = this.zzC;
            if (bool == null || this.zzD == 0 || (!bool.booleanValue() && Math.abs(this.zzr.elapsedRealtime() - this.zzD) > 1000)) {
                this.zzD = this.zzr.elapsedRealtime();
                boolean z11 = true;
                Boolean valueOf = Boolean.valueOf(zzv().zzae("android.permission.INTERNET") && zzv().zzae("android.permission.ACCESS_NETWORK_STATE") && (Wrappers.packageManager(this.zze).isCallerInstantApp() || this.zzk.zzx() || (zzlp.zzal(this.zze) && zzlp.zzam(this.zze, false))));
                this.zzC = valueOf;
                if (valueOf.booleanValue()) {
                    if (!zzv().zzY(zzh().zzm(), zzh().zzk()) && TextUtils.isEmpty(zzh().zzk())) {
                        z11 = false;
                    }
                    this.zzC = Boolean.valueOf(z11);
                }
            }
            return this.zzC.booleanValue();
        }
        throw new IllegalStateException("AppMeasurement is not initialized");
    }

    @Pure
    public final boolean zzN() {
        return this.zzi;
    }

    public final int zza() {
        zzaB().zzg();
        if (this.zzk.zzv()) {
            return 1;
        }
        Boolean bool = this.zzb;
        if (bool != null && bool.booleanValue()) {
            return 2;
        }
        zzaB().zzg();
        if (!this.zzF) {
            return 8;
        }
        Boolean zzd2 = zzm().zzd();
        if (zzd2 == null) {
            zzag zzag = this.zzk;
            zzab zzab = zzag.zzt.zzj;
            Boolean zzk2 = zzag.zzk("firebase_analytics_collection_enabled");
            if (zzk2 == null) {
                Boolean bool2 = this.zza;
                if (bool2 != null) {
                    if (bool2.booleanValue()) {
                        return 0;
                    }
                    return 5;
                } else if (this.zzE == null || this.zzE.booleanValue()) {
                    return 0;
                } else {
                    return 7;
                }
            } else if (zzk2.booleanValue()) {
                return 0;
            } else {
                return 4;
            }
        } else if (zzd2.booleanValue()) {
            return 0;
        } else {
            return 3;
        }
    }

    @Pure
    public final zzet zzaA() {
        zzR(this.zzm);
        return this.zzm;
    }

    @Pure
    public final zzga zzaB() {
        zzR(this.zzn);
        return this.zzn;
    }

    @Pure
    public final Context zzaw() {
        return this.zze;
    }

    @Pure
    public final Clock zzax() {
        return this.zzr;
    }

    @Pure
    public final zzab zzay() {
        return this.zzj;
    }

    @Pure
    public final zzd zzd() {
        zzd zzd2 = this.zzu;
        if (zzd2 != null) {
            return zzd2;
        }
        throw new IllegalStateException("Component not created");
    }

    @Pure
    public final zzag zzf() {
        return this.zzk;
    }

    @Pure
    public final zzao zzg() {
        zzR(this.zzz);
        return this.zzz;
    }

    @Pure
    public final zzek zzh() {
        zzQ(this.zzA);
        return this.zzA;
    }

    @Pure
    public final zzem zzi() {
        zzQ(this.zzx);
        return this.zzx;
    }

    @Pure
    public final zzeo zzj() {
        return this.zzq;
    }

    public final zzet zzl() {
        zzet zzet = this.zzm;
        if (zzet == null || !zzet.zzy()) {
            return null;
        }
        return zzet;
    }

    @Pure
    public final zzfi zzm() {
        zzP(this.zzl);
        return this.zzl;
    }

    @SideEffectFree
    public final zzga zzo() {
        return this.zzn;
    }

    @Pure
    public final zzik zzq() {
        zzQ(this.zzt);
        return this.zzt;
    }

    @Pure
    public final zzio zzr() {
        zzR(this.zzv);
        return this.zzv;
    }

    @Pure
    public final zziz zzs() {
        zzQ(this.zzs);
        return this.zzs;
    }

    @Pure
    public final zzjz zzt() {
        zzQ(this.zzy);
        return this.zzy;
    }

    @Pure
    public final zzkp zzu() {
        zzQ(this.zzo);
        return this.zzo;
    }

    @Pure
    public final zzlp zzv() {
        zzP(this.zzp);
        return this.zzp;
    }

    @Pure
    public final String zzw() {
        return this.zzf;
    }

    @Pure
    public final String zzx() {
        return this.zzg;
    }

    @Pure
    public final String zzy() {
        return this.zzh;
    }

    @Pure
    public final String zzz() {
        return this.zzw;
    }
}
