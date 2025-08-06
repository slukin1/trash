package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.service.Common;
import com.google.android.gms.common.internal.zaj;
import com.google.android.gms.common.internal.zak;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zae;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.sumsub.sns.internal.core.data.source.dynamic.c;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;

public final class zabe extends GoogleApiClient implements zabz {
    @VisibleForTesting
    public final Queue<BaseImplementation.ApiMethodImpl<?, ?>> zaa = new LinkedList();
    @VisibleForTesting
    public zabx zab;
    public final Map<Api.AnyClientKey<?>, Api.Client> zac;
    public Set<Scope> zad;
    public final ClientSettings zae;
    public final Map<Api<?>, Boolean> zaf;
    public final Api.AbstractClientBuilder<? extends zae, SignInOptions> zag;
    public Set<zada> zah;
    public final zadc zai;
    private final Lock zaj;
    private final zak zak;
    private zaca zal = null;
    private final int zam;
    /* access modifiers changed from: private */
    public final Context zan;
    private final Looper zao;
    private volatile boolean zap;
    private long zaq;
    private long zar;
    private final zabc zas;
    private final GoogleApiAvailability zat;
    private final ListenerHolders zau;
    private final ArrayList<zat> zav;
    private Integer zaw;
    private final zaj zax;

    public zabe(Context context, Lock lock, Looper looper, ClientSettings clientSettings, GoogleApiAvailability googleApiAvailability, Api.AbstractClientBuilder<? extends zae, SignInOptions> abstractClientBuilder, Map<Api<?>, Boolean> map, List<GoogleApiClient.ConnectionCallbacks> list, List<GoogleApiClient.OnConnectionFailedListener> list2, Map<Api.AnyClientKey<?>, Api.Client> map2, int i11, int i12, ArrayList<zat> arrayList) {
        Looper looper2 = looper;
        int i13 = i11;
        this.zaq = true != ClientLibraryUtils.isPackageSide() ? c.f33305t : 10000;
        this.zar = 5000;
        this.zad = new HashSet();
        this.zau = new ListenerHolders();
        this.zaw = null;
        this.zah = null;
        zaay zaay = new zaay(this);
        this.zax = zaay;
        this.zan = context;
        this.zaj = lock;
        this.zak = new zak(looper, zaay);
        this.zao = looper2;
        this.zas = new zabc(this, looper);
        this.zat = googleApiAvailability;
        this.zam = i13;
        if (i13 >= 0) {
            this.zaw = Integer.valueOf(i12);
        }
        this.zaf = map;
        this.zac = map2;
        this.zav = arrayList;
        this.zai = new zadc();
        for (GoogleApiClient.ConnectionCallbacks zaf2 : list) {
            this.zak.zaf(zaf2);
        }
        for (GoogleApiClient.OnConnectionFailedListener zag2 : list2) {
            this.zak.zag(zag2);
        }
        this.zae = clientSettings;
        this.zag = abstractClientBuilder;
    }

    public static int zad(Iterable<Api.Client> iterable, boolean z11) {
        boolean z12 = false;
        boolean z13 = false;
        for (Api.Client next : iterable) {
            z12 |= next.requiresSignIn();
            z13 |= next.providesSignIn();
        }
        if (z12) {
            return (!z13 || !z11) ? 1 : 2;
        }
        return 3;
    }

    public static String zag(int i11) {
        return i11 != 1 ? i11 != 2 ? i11 != 3 ? GrsBaseInfo.CountryCodeSource.UNKNOWN : "SIGN_IN_MODE_NONE" : "SIGN_IN_MODE_OPTIONAL" : "SIGN_IN_MODE_REQUIRED";
    }

    public static /* bridge */ /* synthetic */ void zai(zabe zabe) {
        zabe.zaj.lock();
        try {
            if (zabe.zap) {
                zabe.zan();
            }
        } finally {
            zabe.zaj.unlock();
        }
    }

    public static /* bridge */ /* synthetic */ void zaj(zabe zabe) {
        zabe.zaj.lock();
        try {
            if (zabe.zak()) {
                zabe.zan();
            }
        } finally {
            zabe.zaj.unlock();
        }
    }

    private final void zal(int i11) {
        Integer num = this.zaw;
        if (num == null) {
            this.zaw = Integer.valueOf(i11);
        } else if (num.intValue() != i11) {
            String zag2 = zag(i11);
            String zag3 = zag(this.zaw.intValue());
            StringBuilder sb2 = new StringBuilder(zag2.length() + 51 + zag3.length());
            sb2.append("Cannot use sign-in mode: ");
            sb2.append(zag2);
            sb2.append(". Mode was already set to ");
            sb2.append(zag3);
            throw new IllegalStateException(sb2.toString());
        }
        if (this.zal == null) {
            boolean z11 = false;
            boolean z12 = false;
            for (Api.Client next : this.zac.values()) {
                z11 |= next.requiresSignIn();
                z12 |= next.providesSignIn();
            }
            int intValue = this.zaw.intValue();
            if (intValue != 1) {
                if (intValue == 2 && z11) {
                    this.zal = zaaa.zag(this.zan, this, this.zaj, this.zao, this.zat, this.zac, this.zae, this.zaf, this.zag, this.zav);
                    return;
                }
            } else if (!z11) {
                throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
            } else if (z12) {
                throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            this.zal = new zabi(this.zan, this, this.zaj, this.zao, this.zat, this.zac, this.zae, this.zaf, this.zag, this.zav, this);
        }
    }

    /* access modifiers changed from: private */
    public final void zam(GoogleApiClient googleApiClient, StatusPendingResult statusPendingResult, boolean z11) {
        Common.zaa.zaa(googleApiClient).setResultCallback(new zabb(this, statusPendingResult, z11, googleApiClient));
    }

    private final void zan() {
        this.zak.zab();
        ((zaca) Preconditions.checkNotNull(this.zal)).zaq();
    }

    public final ConnectionResult blockingConnect() {
        boolean z11 = true;
        Preconditions.checkState(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.zaj.lock();
        try {
            if (this.zam >= 0) {
                if (this.zaw == null) {
                    z11 = false;
                }
                Preconditions.checkState(z11, "Sign-in mode should have been set explicitly by auto-manage.");
            } else {
                Integer num = this.zaw;
                if (num == null) {
                    this.zaw = Integer.valueOf(zad(this.zac.values(), false));
                } else if (num.intValue() == 2) {
                    throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
            }
            zal(((Integer) Preconditions.checkNotNull(this.zaw)).intValue());
            this.zak.zab();
            return ((zaca) Preconditions.checkNotNull(this.zal)).zab();
        } finally {
            this.zaj.unlock();
        }
    }

    public final PendingResult<Status> clearDefaultAccountAndReconnect() {
        Preconditions.checkState(isConnected(), "GoogleApiClient is not connected yet.");
        Integer num = this.zaw;
        boolean z11 = true;
        if (num != null && num.intValue() == 2) {
            z11 = false;
        }
        Preconditions.checkState(z11, "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
        StatusPendingResult statusPendingResult = new StatusPendingResult((GoogleApiClient) this);
        if (this.zac.containsKey(Common.CLIENT_KEY)) {
            zam(this, statusPendingResult, false);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            zaaz zaaz = new zaaz(this, atomicReference, statusPendingResult);
            zaba zaba = new zaba(this, statusPendingResult);
            GoogleApiClient.Builder builder = new GoogleApiClient.Builder(this.zan);
            builder.addApi(Common.API);
            builder.addConnectionCallbacks(zaaz);
            builder.addOnConnectionFailedListener(zaba);
            builder.setHandler(this.zas);
            GoogleApiClient build = builder.build();
            atomicReference.set(build);
            build.connect();
        }
        return statusPendingResult;
    }

    public final void connect() {
        this.zaj.lock();
        try {
            int i11 = 2;
            boolean z11 = false;
            if (this.zam >= 0) {
                Preconditions.checkState(this.zaw != null, "Sign-in mode should have been set explicitly by auto-manage.");
            } else {
                Integer num = this.zaw;
                if (num == null) {
                    this.zaw = Integer.valueOf(zad(this.zac.values(), false));
                } else if (num.intValue() == 2) {
                    throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
            }
            int intValue = ((Integer) Preconditions.checkNotNull(this.zaw)).intValue();
            this.zaj.lock();
            if (intValue == 3 || intValue == 1) {
                i11 = intValue;
            } else if (intValue != 2) {
                i11 = intValue;
                StringBuilder sb2 = new StringBuilder(33);
                sb2.append("Illegal sign-in mode: ");
                sb2.append(i11);
                Preconditions.checkArgument(z11, sb2.toString());
                zal(i11);
                zan();
            }
            z11 = true;
            StringBuilder sb22 = new StringBuilder(33);
            sb22.append("Illegal sign-in mode: ");
            sb22.append(i11);
            Preconditions.checkArgument(z11, sb22.toString());
            zal(i11);
            zan();
        } catch (Throwable th2) {
            throw th2;
        } finally {
            this.zaj.unlock();
        }
    }

    public final void disconnect() {
        Lock lock;
        this.zaj.lock();
        try {
            this.zai.zab();
            zaca zaca = this.zal;
            if (zaca != null) {
                zaca.zar();
            }
            this.zau.zab();
            for (BaseImplementation.ApiMethodImpl apiMethodImpl : this.zaa) {
                apiMethodImpl.zan((zadb) null);
                apiMethodImpl.cancel();
            }
            this.zaa.clear();
            if (this.zal == null) {
                lock = this.zaj;
            } else {
                zak();
                this.zak.zaa();
                lock = this.zaj;
            }
            lock.unlock();
        } catch (Throwable th2) {
            this.zaj.unlock();
            throw th2;
        }
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("mContext=").println(this.zan);
        printWriter.append(str).append("mResuming=").print(this.zap);
        printWriter.append(" mWorkQueue.size()=").print(this.zaa.size());
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.zai.zab.size());
        zaca zaca = this.zal;
        if (zaca != null) {
            zaca.zas(str, fileDescriptor, printWriter, strArr);
        }
    }

    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T t11) {
        Lock lock;
        Api<?> api = t11.getApi();
        boolean containsKey = this.zac.containsKey(t11.getClientKey());
        String zad2 = api != null ? api.zad() : "the API";
        StringBuilder sb2 = new StringBuilder(String.valueOf(zad2).length() + 65);
        sb2.append("GoogleApiClient is not configured to use ");
        sb2.append(zad2);
        sb2.append(" required for this call.");
        Preconditions.checkArgument(containsKey, sb2.toString());
        this.zaj.lock();
        try {
            zaca zaca = this.zal;
            if (zaca == null) {
                this.zaa.add(t11);
                lock = this.zaj;
            } else {
                t11 = zaca.zae(t11);
                lock = this.zaj;
            }
            lock.unlock();
            return t11;
        } catch (Throwable th2) {
            this.zaj.unlock();
            throw th2;
        }
    }

    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T t11) {
        Lock lock;
        Api<?> api = t11.getApi();
        boolean containsKey = this.zac.containsKey(t11.getClientKey());
        String zad2 = api != null ? api.zad() : "the API";
        StringBuilder sb2 = new StringBuilder(String.valueOf(zad2).length() + 65);
        sb2.append("GoogleApiClient is not configured to use ");
        sb2.append(zad2);
        sb2.append(" required for this call.");
        Preconditions.checkArgument(containsKey, sb2.toString());
        this.zaj.lock();
        try {
            zaca zaca = this.zal;
            if (zaca != null) {
                if (this.zap) {
                    this.zaa.add(t11);
                    while (!this.zaa.isEmpty()) {
                        BaseImplementation.ApiMethodImpl remove = this.zaa.remove();
                        this.zai.zaa(remove);
                        remove.setFailedResult(Status.RESULT_INTERNAL_ERROR);
                    }
                    lock = this.zaj;
                } else {
                    t11 = zaca.zaf(t11);
                    lock = this.zaj;
                }
                lock.unlock();
                return t11;
            }
            throw new IllegalStateException("GoogleApiClient is not connected yet.");
        } catch (Throwable th2) {
            this.zaj.unlock();
            throw th2;
        }
    }

    public final <C extends Api.Client> C getClient(Api.AnyClientKey<C> anyClientKey) {
        C c11 = (Api.Client) this.zac.get(anyClientKey);
        Preconditions.checkNotNull(c11, "Appropriate Api was not requested.");
        return c11;
    }

    public final ConnectionResult getConnectionResult(Api<?> api) {
        ConnectionResult connectionResult;
        Lock lock;
        this.zaj.lock();
        try {
            if (!isConnected()) {
                if (!this.zap) {
                    throw new IllegalStateException("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
                }
            }
            if (this.zac.containsKey(api.zab())) {
                ConnectionResult zad2 = ((zaca) Preconditions.checkNotNull(this.zal)).zad(api);
                if (zad2 != null) {
                    return zad2;
                }
                if (this.zap) {
                    connectionResult = ConnectionResult.RESULT_SUCCESS;
                    lock = this.zaj;
                } else {
                    Log.w("GoogleApiClientImpl", zaf());
                    Log.wtf("GoogleApiClientImpl", String.valueOf(api.zad()).concat(" requested in getConnectionResult is not connected but is not present in the failed  connections map"), new Exception());
                    connectionResult = new ConnectionResult(8, (PendingIntent) null);
                    lock = this.zaj;
                }
                lock.unlock();
                return connectionResult;
            }
            throw new IllegalArgumentException(String.valueOf(api.zad()).concat(" was never registered with GoogleApiClient"));
        } finally {
            this.zaj.unlock();
        }
    }

    public final Context getContext() {
        return this.zan;
    }

    public final Looper getLooper() {
        return this.zao;
    }

    public final boolean hasApi(Api<?> api) {
        return this.zac.containsKey(api.zab());
    }

    public final boolean hasConnectedApi(Api<?> api) {
        Api.Client client;
        if (isConnected() && (client = this.zac.get(api.zab())) != null && client.isConnected()) {
            return true;
        }
        return false;
    }

    public final boolean isConnected() {
        zaca zaca = this.zal;
        return zaca != null && zaca.zaw();
    }

    public final boolean isConnecting() {
        zaca zaca = this.zal;
        return zaca != null && zaca.zax();
    }

    public final boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        return this.zak.zaj(connectionCallbacks);
    }

    public final boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return this.zak.zak(onConnectionFailedListener);
    }

    public final boolean maybeSignIn(SignInConnectionListener signInConnectionListener) {
        zaca zaca = this.zal;
        return zaca != null && zaca.zay(signInConnectionListener);
    }

    public final void maybeSignOut() {
        zaca zaca = this.zal;
        if (zaca != null) {
            zaca.zau();
        }
    }

    public final void reconnect() {
        disconnect();
        connect();
    }

    public final void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.zak.zaf(connectionCallbacks);
    }

    public final void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.zak.zag(onConnectionFailedListener);
    }

    public final <L> ListenerHolder<L> registerListener(L l11) {
        this.zaj.lock();
        try {
            return this.zau.zaa(l11, this.zao, "NO_TYPE");
        } finally {
            this.zaj.unlock();
        }
    }

    public final void stopAutoManage(FragmentActivity fragmentActivity) {
        LifecycleActivity lifecycleActivity = new LifecycleActivity((Activity) fragmentActivity);
        if (this.zam >= 0) {
            zak.zaa(lifecycleActivity).zae(this.zam);
            return;
        }
        throw new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
    }

    public final void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.zak.zah(connectionCallbacks);
    }

    public final void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.zak.zai(onConnectionFailedListener);
    }

    public final void zaa(ConnectionResult connectionResult) {
        if (!this.zat.isPlayServicesPossiblyUpdating(this.zan, connectionResult.getErrorCode())) {
            zak();
        }
        if (!this.zap) {
            this.zak.zac(connectionResult);
            this.zak.zaa();
        }
    }

    public final void zab(Bundle bundle) {
        while (!this.zaa.isEmpty()) {
            execute(this.zaa.remove());
        }
        this.zak.zad(bundle);
    }

    public final void zac(int i11, boolean z11) {
        if (i11 == 1) {
            if (!z11 && !this.zap) {
                this.zap = true;
                if (this.zab == null && !ClientLibraryUtils.isPackageSide()) {
                    try {
                        this.zab = this.zat.zac(this.zan.getApplicationContext(), new zabd(this));
                    } catch (SecurityException unused) {
                    }
                }
                zabc zabc = this.zas;
                zabc.sendMessageDelayed(zabc.obtainMessage(1), this.zaq);
                zabc zabc2 = this.zas;
                zabc2.sendMessageDelayed(zabc2.obtainMessage(2), this.zar);
            }
            i11 = 1;
        }
        for (BasePendingResult forceFailureUnlessReady : (BasePendingResult[]) this.zai.zab.toArray(new BasePendingResult[0])) {
            forceFailureUnlessReady.forceFailureUnlessReady(zadc.zaa);
        }
        this.zak.zae(i11);
        this.zak.zaa();
        if (i11 == 2) {
            zan();
        }
    }

    public final String zaf() {
        StringWriter stringWriter = new StringWriter();
        dump("", (FileDescriptor) null, new PrintWriter(stringWriter), (String[]) null);
        return stringWriter.toString();
    }

    public final boolean zak() {
        if (!this.zap) {
            return false;
        }
        this.zap = false;
        this.zas.removeMessages(2);
        this.zas.removeMessages(1);
        zabx zabx = this.zab;
        if (zabx != null) {
            zabx.zab();
            this.zab = null;
        }
        return true;
    }

    public final void zao(zada zada) {
        this.zaj.lock();
        try {
            if (this.zah == null) {
                this.zah = new HashSet();
            }
            this.zah.add(zada);
        } finally {
            this.zaj.unlock();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0041, code lost:
        if (r3 == false) goto L_0x0043;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zap(com.google.android.gms.common.api.internal.zada r3) {
        /*
            r2 = this;
            java.util.concurrent.locks.Lock r0 = r2.zaj
            r0.lock()
            java.util.Set<com.google.android.gms.common.api.internal.zada> r0 = r2.zah     // Catch:{ all -> 0x0057 }
            java.lang.String r1 = "GoogleApiClientImpl"
            if (r0 != 0) goto L_0x0016
            java.lang.Exception r3 = new java.lang.Exception     // Catch:{ all -> 0x0057 }
            r3.<init>()     // Catch:{ all -> 0x0057 }
            java.lang.String r0 = "Attempted to remove pending transform when no transforms are registered."
            android.util.Log.wtf(r1, r0, r3)     // Catch:{ all -> 0x0057 }
            goto L_0x004a
        L_0x0016:
            boolean r3 = r0.remove(r3)     // Catch:{ all -> 0x0057 }
            if (r3 != 0) goto L_0x0027
            java.lang.Exception r3 = new java.lang.Exception     // Catch:{ all -> 0x0057 }
            r3.<init>()     // Catch:{ all -> 0x0057 }
            java.lang.String r0 = "Failed to remove pending transform - this may lead to memory leaks!"
            android.util.Log.wtf(r1, r0, r3)     // Catch:{ all -> 0x0057 }
            goto L_0x004a
        L_0x0027:
            java.util.concurrent.locks.Lock r3 = r2.zaj     // Catch:{ all -> 0x0057 }
            r3.lock()     // Catch:{ all -> 0x0057 }
            java.util.Set<com.google.android.gms.common.api.internal.zada> r3 = r2.zah     // Catch:{ all -> 0x0050 }
            if (r3 != 0) goto L_0x0036
            java.util.concurrent.locks.Lock r3 = r2.zaj     // Catch:{ all -> 0x0057 }
            r3.unlock()     // Catch:{ all -> 0x0057 }
            goto L_0x0043
        L_0x0036:
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x0050 }
            r3 = r3 ^ 1
            java.util.concurrent.locks.Lock r0 = r2.zaj     // Catch:{ all -> 0x0057 }
            r0.unlock()     // Catch:{ all -> 0x0057 }
            if (r3 != 0) goto L_0x004a
        L_0x0043:
            com.google.android.gms.common.api.internal.zaca r3 = r2.zal     // Catch:{ all -> 0x0057 }
            if (r3 == 0) goto L_0x004a
            r3.zat()     // Catch:{ all -> 0x0057 }
        L_0x004a:
            java.util.concurrent.locks.Lock r3 = r2.zaj
            r3.unlock()
            return
        L_0x0050:
            r3 = move-exception
            java.util.concurrent.locks.Lock r0 = r2.zaj     // Catch:{ all -> 0x0057 }
            r0.unlock()     // Catch:{ all -> 0x0057 }
            throw r3     // Catch:{ all -> 0x0057 }
        L_0x0057:
            r3 = move-exception
            java.util.concurrent.locks.Lock r0 = r2.zaj
            r0.unlock()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zabe.zap(com.google.android.gms.common.api.internal.zada):void");
    }

    public final ConnectionResult blockingConnect(long j11, TimeUnit timeUnit) {
        Preconditions.checkState(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        Preconditions.checkNotNull(timeUnit, "TimeUnit must not be null");
        this.zaj.lock();
        try {
            Integer num = this.zaw;
            if (num == null) {
                this.zaw = Integer.valueOf(zad(this.zac.values(), false));
            } else if (num.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            zal(((Integer) Preconditions.checkNotNull(this.zaw)).intValue());
            this.zak.zab();
            return ((zaca) Preconditions.checkNotNull(this.zal)).zac(j11, timeUnit);
        } finally {
            this.zaj.unlock();
        }
    }

    public final void connect(int i11) {
        this.zaj.lock();
        boolean z11 = true;
        if (!(i11 == 3 || i11 == 1)) {
            if (i11 == 2) {
                i11 = 2;
            } else {
                z11 = false;
            }
        }
        try {
            StringBuilder sb2 = new StringBuilder(33);
            sb2.append("Illegal sign-in mode: ");
            sb2.append(i11);
            Preconditions.checkArgument(z11, sb2.toString());
            zal(i11);
            zan();
        } finally {
            this.zaj.unlock();
        }
    }
}
