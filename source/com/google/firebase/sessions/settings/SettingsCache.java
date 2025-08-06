package com.google.firebase.sessions.settings;

import androidx.datastore.core.d;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKt;
import androidx.datastore.preferences.core.b;
import d10.p;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.r;
import kotlin.k;
import kotlinx.coroutines.flow.f;
import kotlinx.coroutines.h;
import kotlinx.coroutines.h0;

@Metadata(bv = {}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 22\u00020\u0001:\u00012B\u0015\u0012\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020*¢\u0006\u0004\b0\u00101J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J1\u0010\n\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\b\u0010\t\u001a\u0004\u0018\u00018\u0000H@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u000f\u001a\u00020\fH\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u0019\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\fH@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001c\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u0012H@ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010\u001f\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u0015H@ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010\"\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010\u0015H@ø\u0001\u0000¢\u0006\u0004\b\"\u0010 J\u001d\u0010%\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010#H@ø\u0001\u0000¢\u0006\u0004\b%\u0010&J\u0013\u0010)\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0004\b'\u0010(R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020*8\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010.\u001a\u00020-8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b.\u0010/\u0002\u0004\n\u0002\b\u0019¨\u00063"}, d2 = {"Lcom/google/firebase/sessions/settings/SettingsCache;", "", "Landroidx/datastore/preferences/core/Preferences;", "preferences", "", "updateSessionConfigs", "T", "Landroidx/datastore/preferences/core/Preferences$a;", "key", "value", "updateConfigValue", "(Landroidx/datastore/preferences/core/Preferences$a;Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "hasCacheExpired$com_google_firebase_firebase_sessions", "()Z", "hasCacheExpired", "sessionsEnabled", "()Ljava/lang/Boolean;", "", "sessionSamplingRate", "()Ljava/lang/Double;", "", "sessionRestartTimeout", "()Ljava/lang/Integer;", "enabled", "updateSettingsEnabled", "(Ljava/lang/Boolean;Lkotlin/coroutines/c;)Ljava/lang/Object;", "rate", "updateSamplingRate", "(Ljava/lang/Double;Lkotlin/coroutines/c;)Ljava/lang/Object;", "timeoutInSeconds", "updateSessionRestartTimeout", "(Ljava/lang/Integer;Lkotlin/coroutines/c;)Ljava/lang/Object;", "cacheDurationInSeconds", "updateSessionCacheDuration", "", "cacheUpdatedTime", "updateSessionCacheUpdatedTime", "(Ljava/lang/Long;Lkotlin/coroutines/c;)Ljava/lang/Object;", "removeConfigs$com_google_firebase_firebase_sessions", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "removeConfigs", "Landroidx/datastore/core/d;", "dataStore", "Landroidx/datastore/core/d;", "Lcom/google/firebase/sessions/settings/SessionConfigs;", "sessionConfigs", "Lcom/google/firebase/sessions/settings/SessionConfigs;", "<init>", "(Landroidx/datastore/core/d;)V", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1})
public final class SettingsCache {
    /* access modifiers changed from: private */
    @Deprecated
    public static final Preferences.a<Integer> CACHE_DURATION_SECONDS = b.d("firebase_sessions_cache_duration");
    /* access modifiers changed from: private */
    @Deprecated
    public static final Preferences.a<Long> CACHE_UPDATED_TIME = b.e("firebase_sessions_cache_updated_time");
    private static final Companion Companion = new Companion((r) null);
    /* access modifiers changed from: private */
    @Deprecated
    public static final Preferences.a<Integer> RESTART_TIMEOUT_SECONDS = b.d("firebase_sessions_restart_timeout");
    /* access modifiers changed from: private */
    @Deprecated
    public static final Preferences.a<Double> SAMPLING_RATE = b.b(LocalOverrideSettings.SAMPLING_RATE);
    /* access modifiers changed from: private */
    @Deprecated
    public static final Preferences.a<Boolean> SESSIONS_ENABLED = b.a(LocalOverrideSettings.SESSIONS_ENABLED);
    @Deprecated
    public static final String TAG = "SettingsCache";
    /* access modifiers changed from: private */
    public final d<Preferences> dataStore;
    private SessionConfigs sessionConfigs;

    @kotlin.coroutines.jvm.internal.d(c = "com.google.firebase.sessions.settings.SettingsCache$1", f = "SettingsCache.kt", l = {46}, m = "invokeSuspend")
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/h0;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* renamed from: com.google.firebase.sessions.settings.SettingsCache$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
        public Object L$0;
        public int label;
        public final /* synthetic */ SettingsCache this$0;

        {
            this.this$0 = r1;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(this.this$0, cVar);
        }

        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((AnonymousClass1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            SettingsCache settingsCache;
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.label;
            if (i11 == 0) {
                k.b(obj);
                SettingsCache settingsCache2 = this.this$0;
                kotlinx.coroutines.flow.d data = settingsCache2.dataStore.getData();
                this.L$0 = settingsCache2;
                this.label = 1;
                Object A = f.A(data, this);
                if (A == d11) {
                    return d11;
                }
                settingsCache = settingsCache2;
                obj = A;
            } else if (i11 == 1) {
                settingsCache = (SettingsCache) this.L$0;
                k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            settingsCache.updateSessionConfigs(((Preferences) obj).d());
            return Unit.f56620a;
        }
    }

    @Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007R\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007R\u0014\u0010\u0014\u001a\u00020\u00138\u0006XT¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/google/firebase/sessions/settings/SettingsCache$Companion;", "", "Landroidx/datastore/preferences/core/Preferences$a;", "", "SESSIONS_ENABLED", "Landroidx/datastore/preferences/core/Preferences$a;", "getSESSIONS_ENABLED", "()Landroidx/datastore/preferences/core/Preferences$a;", "", "SAMPLING_RATE", "getSAMPLING_RATE", "", "RESTART_TIMEOUT_SECONDS", "getRESTART_TIMEOUT_SECONDS", "CACHE_DURATION_SECONDS", "getCACHE_DURATION_SECONDS", "", "CACHE_UPDATED_TIME", "getCACHE_UPDATED_TIME", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final Preferences.a<Integer> getCACHE_DURATION_SECONDS() {
            return SettingsCache.CACHE_DURATION_SECONDS;
        }

        public final Preferences.a<Long> getCACHE_UPDATED_TIME() {
            return SettingsCache.CACHE_UPDATED_TIME;
        }

        public final Preferences.a<Integer> getRESTART_TIMEOUT_SECONDS() {
            return SettingsCache.RESTART_TIMEOUT_SECONDS;
        }

        public final Preferences.a<Double> getSAMPLING_RATE() {
            return SettingsCache.SAMPLING_RATE;
        }

        public final Preferences.a<Boolean> getSESSIONS_ENABLED() {
            return SettingsCache.SESSIONS_ENABLED;
        }
    }

    public SettingsCache(d<Preferences> dVar) {
        this.dataStore = dVar;
        Object unused = h.b((CoroutineContext) null, new AnonymousClass1(this, (c<? super AnonymousClass1>) null), 1, (Object) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> java.lang.Object updateConfigValue(androidx.datastore.preferences.core.Preferences.a<T> r6, T r7, kotlin.coroutines.c<? super kotlin.Unit> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$1 r0 = (com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$1 r0 = new com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$1
            r0.<init>(r5, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            kotlin.k.b(r8)     // Catch:{ IOException -> 0x0029 }
            goto L_0x005d
        L_0x0029:
            r6 = move-exception
            goto L_0x0047
        L_0x002b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0033:
            kotlin.k.b(r8)
            androidx.datastore.core.d<androidx.datastore.preferences.core.Preferences> r8 = r5.dataStore     // Catch:{ IOException -> 0x0029 }
            com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$2 r2 = new com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$2     // Catch:{ IOException -> 0x0029 }
            r4 = 0
            r2.<init>(r7, r6, r5, r4)     // Catch:{ IOException -> 0x0029 }
            r0.label = r3     // Catch:{ IOException -> 0x0029 }
            java.lang.Object r6 = androidx.datastore.preferences.core.PreferencesKt.a(r8, r2, r0)     // Catch:{ IOException -> 0x0029 }
            if (r6 != r1) goto L_0x005d
            return r1
        L_0x0047:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Failed to update cache config value: "
            r7.append(r8)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            java.lang.String r7 = "SettingsCache"
            android.util.Log.w(r7, r6)
        L_0x005d:
            kotlin.Unit r6 = kotlin.Unit.f56620a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.SettingsCache.updateConfigValue(androidx.datastore.preferences.core.Preferences$a, java.lang.Object, kotlin.coroutines.c):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void updateSessionConfigs(Preferences preferences) {
        this.sessionConfigs = new SessionConfigs((Boolean) preferences.b(SESSIONS_ENABLED), (Double) preferences.b(SAMPLING_RATE), (Integer) preferences.b(RESTART_TIMEOUT_SECONDS), (Integer) preferences.b(CACHE_DURATION_SECONDS), (Long) preferences.b(CACHE_UPDATED_TIME));
    }

    public final boolean hasCacheExpired$com_google_firebase_firebase_sessions() {
        SessionConfigs sessionConfigs2 = this.sessionConfigs;
        SessionConfigs sessionConfigs3 = null;
        if (sessionConfigs2 == null) {
            sessionConfigs2 = null;
        }
        Long cacheUpdatedTime = sessionConfigs2.getCacheUpdatedTime();
        SessionConfigs sessionConfigs4 = this.sessionConfigs;
        if (sessionConfigs4 != null) {
            sessionConfigs3 = sessionConfigs4;
        }
        Integer cacheDuration = sessionConfigs3.getCacheDuration();
        return cacheUpdatedTime == null || cacheDuration == null || (System.currentTimeMillis() - cacheUpdatedTime.longValue()) / ((long) 1000) >= ((long) cacheDuration.intValue());
    }

    public final Object removeConfigs$com_google_firebase_firebase_sessions(c<? super Unit> cVar) {
        Object a11 = PreferencesKt.a(this.dataStore, new SettingsCache$removeConfigs$2(this, (c<? super SettingsCache$removeConfigs$2>) null), cVar);
        return a11 == IntrinsicsKt__IntrinsicsKt.d() ? a11 : Unit.f56620a;
    }

    public final Integer sessionRestartTimeout() {
        SessionConfigs sessionConfigs2 = this.sessionConfigs;
        if (sessionConfigs2 == null) {
            sessionConfigs2 = null;
        }
        return sessionConfigs2.getSessionRestartTimeout();
    }

    public final Double sessionSamplingRate() {
        SessionConfigs sessionConfigs2 = this.sessionConfigs;
        if (sessionConfigs2 == null) {
            sessionConfigs2 = null;
        }
        return sessionConfigs2.getSessionSamplingRate();
    }

    public final Boolean sessionsEnabled() {
        SessionConfigs sessionConfigs2 = this.sessionConfigs;
        if (sessionConfigs2 == null) {
            sessionConfigs2 = null;
        }
        return sessionConfigs2.getSessionEnabled();
    }

    public final Object updateSamplingRate(Double d11, c<? super Unit> cVar) {
        Object updateConfigValue = updateConfigValue(SAMPLING_RATE, d11, cVar);
        return updateConfigValue == IntrinsicsKt__IntrinsicsKt.d() ? updateConfigValue : Unit.f56620a;
    }

    public final Object updateSessionCacheDuration(Integer num, c<? super Unit> cVar) {
        Object updateConfigValue = updateConfigValue(CACHE_DURATION_SECONDS, num, cVar);
        return updateConfigValue == IntrinsicsKt__IntrinsicsKt.d() ? updateConfigValue : Unit.f56620a;
    }

    public final Object updateSessionCacheUpdatedTime(Long l11, c<? super Unit> cVar) {
        Object updateConfigValue = updateConfigValue(CACHE_UPDATED_TIME, l11, cVar);
        return updateConfigValue == IntrinsicsKt__IntrinsicsKt.d() ? updateConfigValue : Unit.f56620a;
    }

    public final Object updateSessionRestartTimeout(Integer num, c<? super Unit> cVar) {
        Object updateConfigValue = updateConfigValue(RESTART_TIMEOUT_SECONDS, num, cVar);
        return updateConfigValue == IntrinsicsKt__IntrinsicsKt.d() ? updateConfigValue : Unit.f56620a;
    }

    public final Object updateSettingsEnabled(Boolean bool, c<? super Unit> cVar) {
        Object updateConfigValue = updateConfigValue(SESSIONS_ENABLED, bool, cVar);
        return updateConfigValue == IntrinsicsKt__IntrinsicsKt.d() ? updateConfigValue : Unit.f56620a;
    }
}
