package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzcb;
import com.google.android.gms.internal.measurement.zzcf;
import com.google.android.gms.internal.measurement.zzci;
import com.google.android.gms.internal.measurement.zzck;
import com.google.android.gms.internal.measurement.zzcl;
import com.sumsub.sentry.a;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

@DynamiteApi
public class AppMeasurementDynamiteService extends zzcb {
    public zzgd zza = null;
    private final Map zzb = new ArrayMap();

    @EnsuresNonNull({"scion"})
    private final void zzb() {
        if (this.zza == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    private final void zzc(zzcf zzcf, String str) {
        zzb();
        this.zza.zzv().zzW(zzcf, str);
    }

    public void beginAdUnitExposure(String str, long j11) throws RemoteException {
        zzb();
        this.zza.zzd().zzd(str, j11);
    }

    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        zzb();
        this.zza.zzq().zzA(str, str2, bundle);
    }

    public void clearMeasurementEnabled(long j11) throws RemoteException {
        zzb();
        this.zza.zzq().zzU((Boolean) null);
    }

    public void endAdUnitExposure(String str, long j11) throws RemoteException {
        zzb();
        this.zza.zzd().zze(str, j11);
    }

    public void generateEventId(zzcf zzcf) throws RemoteException {
        zzb();
        long zzq = this.zza.zzv().zzq();
        zzb();
        this.zza.zzv().zzV(zzcf, zzq);
    }

    public void getAppInstanceId(zzcf zzcf) throws RemoteException {
        zzb();
        this.zza.zzaB().zzp(new zzi(this, zzcf));
    }

    public void getCachedAppInstanceId(zzcf zzcf) throws RemoteException {
        zzb();
        zzc(zzcf, this.zza.zzq().zzo());
    }

    public void getConditionalUserProperties(String str, String str2, zzcf zzcf) throws RemoteException {
        zzb();
        this.zza.zzaB().zzp(new zzm(this, zzcf, str, str2));
    }

    public void getCurrentScreenClass(zzcf zzcf) throws RemoteException {
        zzb();
        zzc(zzcf, this.zza.zzq().zzp());
    }

    public void getCurrentScreenName(zzcf zzcf) throws RemoteException {
        zzb();
        zzc(zzcf, this.zza.zzq().zzq());
    }

    public void getGmpAppId(zzcf zzcf) throws RemoteException {
        String str;
        zzb();
        zzik zzq = this.zza.zzq();
        if (zzq.zzt.zzw() != null) {
            str = zzq.zzt.zzw();
        } else {
            try {
                str = zziq.zzc(zzq.zzt.zzaw(), "google_app_id", zzq.zzt.zzz());
            } catch (IllegalStateException e11) {
                zzq.zzt.zzaA().zzd().zzb("getGoogleAppId failed with exception", e11);
                str = null;
            }
        }
        zzc(zzcf, str);
    }

    public void getMaxUserProperties(String str, zzcf zzcf) throws RemoteException {
        zzb();
        this.zza.zzq().zzh(str);
        zzb();
        this.zza.zzv().zzU(zzcf, 25);
    }

    public void getSessionId(zzcf zzcf) throws RemoteException {
        zzb();
        zzik zzq = this.zza.zzq();
        zzq.zzt.zzaB().zzp(new zzhy(zzq, zzcf));
    }

    public void getTestFlag(zzcf zzcf, int i11) throws RemoteException {
        zzb();
        if (i11 == 0) {
            this.zza.zzv().zzW(zzcf, this.zza.zzq().zzr());
        } else if (i11 == 1) {
            this.zza.zzv().zzV(zzcf, this.zza.zzq().zzm().longValue());
        } else if (i11 == 2) {
            zzlp zzv = this.zza.zzv();
            double doubleValue = this.zza.zzq().zzj().doubleValue();
            Bundle bundle = new Bundle();
            bundle.putDouble("r", doubleValue);
            try {
                zzcf.zze(bundle);
            } catch (RemoteException e11) {
                zzv.zzt.zzaA().zzk().zzb("Error returning double value to wrapper", e11);
            }
        } else if (i11 == 3) {
            this.zza.zzv().zzU(zzcf, this.zza.zzq().zzl().intValue());
        } else if (i11 == 4) {
            this.zza.zzv().zzQ(zzcf, this.zza.zzq().zzi().booleanValue());
        }
    }

    public void getUserProperties(String str, String str2, boolean z11, zzcf zzcf) throws RemoteException {
        zzb();
        this.zza.zzaB().zzp(new zzk(this, zzcf, str, str2, z11));
    }

    public void initForTests(Map map) throws RemoteException {
        zzb();
    }

    public void initialize(IObjectWrapper iObjectWrapper, zzcl zzcl, long j11) throws RemoteException {
        zzgd zzgd = this.zza;
        if (zzgd == null) {
            this.zza = zzgd.zzp((Context) Preconditions.checkNotNull((Context) ObjectWrapper.unwrap(iObjectWrapper)), zzcl, Long.valueOf(j11));
        } else {
            zzgd.zzaA().zzk().zza("Attempting to initialize multiple times");
        }
    }

    public void isDataCollectionEnabled(zzcf zzcf) throws RemoteException {
        zzb();
        this.zza.zzaB().zzp(new zzn(this, zzcf));
    }

    public void logEvent(String str, String str2, Bundle bundle, boolean z11, boolean z12, long j11) throws RemoteException {
        zzb();
        this.zza.zzq().zzE(str, str2, bundle, z11, z12, j11);
    }

    public void logEventAndBundle(String str, String str2, Bundle bundle, zzcf zzcf, long j11) throws RemoteException {
        Bundle bundle2;
        zzb();
        Preconditions.checkNotEmpty(str2);
        if (bundle != null) {
            bundle2 = new Bundle(bundle);
        } else {
            bundle2 = new Bundle();
        }
        bundle2.putString(CrashlyticsAnalyticsListener.EVENT_ORIGIN_KEY, a.f30241h);
        this.zza.zzaB().zzp(new zzj(this, zzcf, new zzau(str2, new zzas(bundle), a.f30241h, j11), str));
    }

    public void logHealthData(int i11, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Object obj;
        Object obj2;
        zzb();
        Object obj3 = null;
        if (iObjectWrapper == null) {
            obj = null;
        } else {
            obj = ObjectWrapper.unwrap(iObjectWrapper);
        }
        if (iObjectWrapper2 == null) {
            obj2 = null;
        } else {
            obj2 = ObjectWrapper.unwrap(iObjectWrapper2);
        }
        if (iObjectWrapper3 != null) {
            obj3 = ObjectWrapper.unwrap(iObjectWrapper3);
        }
        this.zza.zzaA().zzu(i11, true, false, str, obj, obj2, obj3);
    }

    public void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j11) throws RemoteException {
        zzb();
        zzij zzij = this.zza.zzq().zza;
        if (zzij != null) {
            this.zza.zzq().zzB();
            zzij.onActivityCreated((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
    }

    public void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j11) throws RemoteException {
        zzb();
        zzij zzij = this.zza.zzq().zza;
        if (zzij != null) {
            this.zza.zzq().zzB();
            zzij.onActivityDestroyed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivityPaused(IObjectWrapper iObjectWrapper, long j11) throws RemoteException {
        zzb();
        zzij zzij = this.zza.zzq().zza;
        if (zzij != null) {
            this.zza.zzq().zzB();
            zzij.onActivityPaused((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivityResumed(IObjectWrapper iObjectWrapper, long j11) throws RemoteException {
        zzb();
        zzij zzij = this.zza.zzq().zza;
        if (zzij != null) {
            this.zza.zzq().zzB();
            zzij.onActivityResumed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzcf zzcf, long j11) throws RemoteException {
        zzb();
        zzij zzij = this.zza.zzq().zza;
        Bundle bundle = new Bundle();
        if (zzij != null) {
            this.zza.zzq().zzB();
            zzij.onActivitySaveInstanceState((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
        try {
            zzcf.zze(bundle);
        } catch (RemoteException e11) {
            this.zza.zzaA().zzk().zzb("Error returning bundle value to wrapper", e11);
        }
    }

    public void onActivityStarted(IObjectWrapper iObjectWrapper, long j11) throws RemoteException {
        zzb();
        if (this.zza.zzq().zza != null) {
            this.zza.zzq().zzB();
            Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
        }
    }

    public void onActivityStopped(IObjectWrapper iObjectWrapper, long j11) throws RemoteException {
        zzb();
        if (this.zza.zzq().zza != null) {
            this.zza.zzq().zzB();
            Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
        }
    }

    public void performAction(Bundle bundle, zzcf zzcf, long j11) throws RemoteException {
        zzb();
        zzcf.zze((Bundle) null);
    }

    public void registerOnMeasurementEventListener(zzci zzci) throws RemoteException {
        zzhg zzhg;
        zzb();
        synchronized (this.zzb) {
            zzhg = (zzhg) this.zzb.get(Integer.valueOf(zzci.zzd()));
            if (zzhg == null) {
                zzhg = new zzp(this, zzci);
                this.zzb.put(Integer.valueOf(zzci.zzd()), zzhg);
            }
        }
        this.zza.zzq().zzJ(zzhg);
    }

    public void resetAnalyticsData(long j11) throws RemoteException {
        zzb();
        this.zza.zzq().zzK(j11);
    }

    public void setConditionalUserProperty(Bundle bundle, long j11) throws RemoteException {
        zzb();
        if (bundle == null) {
            this.zza.zzaA().zzd().zza("Conditional user property must not be null");
        } else {
            this.zza.zzq().zzQ(bundle, j11);
        }
    }

    public void setConsent(Bundle bundle, long j11) throws RemoteException {
        zzb();
        zzik zzq = this.zza.zzq();
        zzq.zzt.zzaB().zzq(new zzhj(zzq, bundle, j11));
    }

    public void setConsentThirdParty(Bundle bundle, long j11) throws RemoteException {
        zzb();
        this.zza.zzq().zzS(bundle, -20, j11);
    }

    public void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j11) throws RemoteException {
        zzb();
        this.zza.zzs().zzw((Activity) ObjectWrapper.unwrap(iObjectWrapper), str, str2);
    }

    public void setDataCollectionEnabled(boolean z11) throws RemoteException {
        zzb();
        zzik zzq = this.zza.zzq();
        zzq.zza();
        zzq.zzt.zzaB().zzp(new zzih(zzq, z11));
    }

    public void setDefaultEventParameters(Bundle bundle) {
        Bundle bundle2;
        zzb();
        zzik zzq = this.zza.zzq();
        if (bundle == null) {
            bundle2 = null;
        } else {
            bundle2 = new Bundle(bundle);
        }
        zzq.zzt.zzaB().zzp(new zzhk(zzq, bundle2));
    }

    public void setEventInterceptor(zzci zzci) throws RemoteException {
        zzb();
        zzo zzo = new zzo(this, zzci);
        if (this.zza.zzaB().zzs()) {
            this.zza.zzq().zzT(zzo);
        } else {
            this.zza.zzaB().zzp(new zzl(this, zzo));
        }
    }

    public void setInstanceIdProvider(zzck zzck) throws RemoteException {
        zzb();
    }

    public void setMeasurementEnabled(boolean z11, long j11) throws RemoteException {
        zzb();
        this.zza.zzq().zzU(Boolean.valueOf(z11));
    }

    public void setMinimumSessionDuration(long j11) throws RemoteException {
        zzb();
    }

    public void setSessionTimeoutDuration(long j11) throws RemoteException {
        zzb();
        zzik zzq = this.zza.zzq();
        zzq.zzt.zzaB().zzp(new zzho(zzq, j11));
    }

    public void setUserId(String str, long j11) throws RemoteException {
        zzb();
        zzik zzq = this.zza.zzq();
        if (str == null || !TextUtils.isEmpty(str)) {
            zzq.zzt.zzaB().zzp(new zzhl(zzq, str));
            zzq.zzX((String) null, "_id", str, true, j11);
            return;
        }
        zzq.zzt.zzaA().zzk().zza("User ID must be non-empty or null");
    }

    public void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z11, long j11) throws RemoteException {
        zzb();
        this.zza.zzq().zzX(str, str2, ObjectWrapper.unwrap(iObjectWrapper), z11, j11);
    }

    public void unregisterOnMeasurementEventListener(zzci zzci) throws RemoteException {
        zzhg zzhg;
        zzb();
        synchronized (this.zzb) {
            zzhg = (zzhg) this.zzb.remove(Integer.valueOf(zzci.zzd()));
        }
        if (zzhg == null) {
            zzhg = new zzp(this, zzci);
        }
        this.zza.zzq().zzZ(zzhg);
    }
}
