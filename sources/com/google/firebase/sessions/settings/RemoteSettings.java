package com.google.firebase.sessions.settings;

import androidx.datastore.core.d;
import androidx.datastore.preferences.core.Preferences;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.ApplicationInfo;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.internal.r;
import kotlin.text.Regex;
import kotlin.time.DurationUnit;
import kotlin.time.b;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.sync.MutexKt;
import kotlinx.coroutines.sync.a;

@Metadata(bv = {}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 /2\u00020\u0001:\u0001/B5\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\f\u0010,\u001a\b\u0012\u0004\u0012\u00020+0*¢\u0006\u0004\b-\u0010.J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0013\u0010\u0006\u001a\u00020\u0005H@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\t\u001a\u00020\bH\u0016J\u000f\u0010\f\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u0004\u0018\u00010\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001f\u0010%\u001a\u0004\u0018\u00010\"8VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0016\u0010)\u001a\u0004\u0018\u00010&8VX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00060"}, d2 = {"Lcom/google/firebase/sessions/settings/RemoteSettings;", "Lcom/google/firebase/sessions/settings/SettingsProvider;", "", "s", "removeForwardSlashesIn", "", "updateSettings", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "isSettingsStale", "clearCachedSettings$com_google_firebase_firebase_sessions", "()V", "clearCachedSettings", "Lkotlin/coroutines/CoroutineContext;", "backgroundDispatcher", "Lkotlin/coroutines/CoroutineContext;", "Lcom/google/firebase/installations/FirebaseInstallationsApi;", "firebaseInstallationsApi", "Lcom/google/firebase/installations/FirebaseInstallationsApi;", "Lcom/google/firebase/sessions/ApplicationInfo;", "appInfo", "Lcom/google/firebase/sessions/ApplicationInfo;", "Lcom/google/firebase/sessions/settings/CrashlyticsSettingsFetcher;", "configsFetcher", "Lcom/google/firebase/sessions/settings/CrashlyticsSettingsFetcher;", "Lcom/google/firebase/sessions/settings/SettingsCache;", "settingsCache", "Lcom/google/firebase/sessions/settings/SettingsCache;", "Lkotlinx/coroutines/sync/a;", "fetchInProgress", "Lkotlinx/coroutines/sync/a;", "getSessionEnabled", "()Ljava/lang/Boolean;", "sessionEnabled", "Lkotlin/time/b;", "getSessionRestartTimeout-FghU774", "()Lkotlin/time/b;", "sessionRestartTimeout", "", "getSamplingRate", "()Ljava/lang/Double;", "samplingRate", "Landroidx/datastore/core/d;", "Landroidx/datastore/preferences/core/Preferences;", "dataStore", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lcom/google/firebase/installations/FirebaseInstallationsApi;Lcom/google/firebase/sessions/ApplicationInfo;Lcom/google/firebase/sessions/settings/CrashlyticsSettingsFetcher;Landroidx/datastore/core/d;)V", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1})
public final class RemoteSettings implements SettingsProvider {
    private static final Companion Companion = new Companion((r) null);
    @Deprecated
    public static final String FORWARD_SLASH_STRING = "/";
    @Deprecated
    public static final String TAG = "SessionConfigFetcher";
    private final ApplicationInfo appInfo;
    private final CoroutineContext backgroundDispatcher;
    private final CrashlyticsSettingsFetcher configsFetcher;
    private final a fetchInProgress = MutexKt.b(false, 1, (Object) null);
    private final FirebaseInstallationsApi firebaseInstallationsApi;
    /* access modifiers changed from: private */
    public final SettingsCache settingsCache;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/google/firebase/sessions/settings/RemoteSettings$Companion;", "", "()V", "FORWARD_SLASH_STRING", "", "TAG", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }
    }

    public RemoteSettings(CoroutineContext coroutineContext, FirebaseInstallationsApi firebaseInstallationsApi2, ApplicationInfo applicationInfo, CrashlyticsSettingsFetcher crashlyticsSettingsFetcher, d<Preferences> dVar) {
        this.backgroundDispatcher = coroutineContext;
        this.firebaseInstallationsApi = firebaseInstallationsApi2;
        this.appInfo = applicationInfo;
        this.configsFetcher = crashlyticsSettingsFetcher;
        this.settingsCache = new SettingsCache(dVar);
    }

    private final String removeForwardSlashesIn(String str) {
        return new Regex("/").replace((CharSequence) str, "");
    }

    public final void clearCachedSettings$com_google_firebase_firebase_sessions() {
        n1 unused = i.d(i0.a(this.backgroundDispatcher), (CoroutineContext) null, (CoroutineStart) null, new RemoteSettings$clearCachedSettings$1(this, (c<? super RemoteSettings$clearCachedSettings$1>) null), 3, (Object) null);
    }

    public Double getSamplingRate() {
        return this.settingsCache.sessionSamplingRate();
    }

    public Boolean getSessionEnabled() {
        return this.settingsCache.sessionsEnabled();
    }

    /* renamed from: getSessionRestartTimeout-FghU774  reason: not valid java name */
    public b m3252getSessionRestartTimeoutFghU774() {
        Integer sessionRestartTimeout = this.settingsCache.sessionRestartTimeout();
        if (sessionRestartTimeout == null) {
            return null;
        }
        b.a aVar = b.f56931c;
        return b.f(kotlin.time.d.s(sessionRestartTimeout.intValue(), DurationUnit.SECONDS));
    }

    public boolean isSettingsStale() {
        return this.settingsCache.hasCacheExpired$com_google_firebase_firebase_sessions();
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008b A[Catch:{ all -> 0x0135 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0091 A[SYNTHETIC, Splitter:B:39:0x0091] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ab A[Catch:{ all -> 0x004c }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object updateSettings(kotlin.coroutines.c<? super kotlin.Unit> r15) {
        /*
            r14 = this;
            boolean r0 = r15 instanceof com.google.firebase.sessions.settings.RemoteSettings$updateSettings$1
            if (r0 == 0) goto L_0x0013
            r0 = r15
            com.google.firebase.sessions.settings.RemoteSettings$updateSettings$1 r0 = (com.google.firebase.sessions.settings.RemoteSettings$updateSettings$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.google.firebase.sessions.settings.RemoteSettings$updateSettings$1 r0 = new com.google.firebase.sessions.settings.RemoteSettings$updateSettings$1
            r0.<init>(r14, r15)
        L_0x0018:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x005d
            if (r2 == r5) goto L_0x0050
            if (r2 == r4) goto L_0x0040
            if (r2 != r3) goto L_0x0038
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.sync.a r0 = (kotlinx.coroutines.sync.a) r0
            kotlin.k.b(r15)     // Catch:{ all -> 0x0035 }
            goto L_0x012f
        L_0x0035:
            r15 = move-exception
            goto L_0x0139
        L_0x0038:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L_0x0040:
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.sync.a r2 = (kotlinx.coroutines.sync.a) r2
            java.lang.Object r7 = r0.L$0
            com.google.firebase.sessions.settings.RemoteSettings r7 = (com.google.firebase.sessions.settings.RemoteSettings) r7
            kotlin.k.b(r15)     // Catch:{ all -> 0x004c }
            goto L_0x00a7
        L_0x004c:
            r15 = move-exception
            r0 = r2
            goto L_0x0139
        L_0x0050:
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.sync.a r2 = (kotlinx.coroutines.sync.a) r2
            java.lang.Object r7 = r0.L$0
            com.google.firebase.sessions.settings.RemoteSettings r7 = (com.google.firebase.sessions.settings.RemoteSettings) r7
            kotlin.k.b(r15)
            r15 = r2
            goto L_0x0083
        L_0x005d:
            kotlin.k.b(r15)
            kotlinx.coroutines.sync.a r15 = r14.fetchInProgress
            boolean r15 = r15.b()
            if (r15 != 0) goto L_0x0073
            com.google.firebase.sessions.settings.SettingsCache r15 = r14.settingsCache
            boolean r15 = r15.hasCacheExpired$com_google_firebase_firebase_sessions()
            if (r15 != 0) goto L_0x0073
            kotlin.Unit r15 = kotlin.Unit.f56620a
            return r15
        L_0x0073:
            kotlinx.coroutines.sync.a r15 = r14.fetchInProgress
            r0.L$0 = r14
            r0.L$1 = r15
            r0.label = r5
            java.lang.Object r2 = r15.d(r6, r0)
            if (r2 != r1) goto L_0x0082
            return r1
        L_0x0082:
            r7 = r14
        L_0x0083:
            com.google.firebase.sessions.settings.SettingsCache r2 = r7.settingsCache     // Catch:{ all -> 0x0135 }
            boolean r2 = r2.hasCacheExpired$com_google_firebase_firebase_sessions()     // Catch:{ all -> 0x0135 }
            if (r2 != 0) goto L_0x0091
            kotlin.Unit r0 = kotlin.Unit.f56620a     // Catch:{ all -> 0x0135 }
            r15.e(r6)
            return r0
        L_0x0091:
            com.google.firebase.installations.FirebaseInstallationsApi r2 = r7.firebaseInstallationsApi     // Catch:{ all -> 0x0135 }
            com.google.android.gms.tasks.Task r2 = r2.getId()     // Catch:{ all -> 0x0135 }
            r0.L$0 = r7     // Catch:{ all -> 0x0135 }
            r0.L$1 = r15     // Catch:{ all -> 0x0135 }
            r0.label = r4     // Catch:{ all -> 0x0135 }
            java.lang.Object r2 = kotlinx.coroutines.tasks.TasksKt.a(r2, r0)     // Catch:{ all -> 0x0135 }
            if (r2 != r1) goto L_0x00a4
            return r1
        L_0x00a4:
            r13 = r2
            r2 = r15
            r15 = r13
        L_0x00a7:
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ all -> 0x004c }
            if (r15 != 0) goto L_0x00b8
            java.lang.String r15 = "SessionConfigFetcher"
            java.lang.String r0 = "Error getting Firebase Installation ID. Skipping this Session Event."
            android.util.Log.w(r15, r0)     // Catch:{ all -> 0x004c }
            kotlin.Unit r15 = kotlin.Unit.f56620a     // Catch:{ all -> 0x004c }
            r2.e(r6)
            return r15
        L_0x00b8:
            r8 = 5
            kotlin.Pair[] r8 = new kotlin.Pair[r8]     // Catch:{ all -> 0x004c }
            java.lang.String r9 = "X-Crashlytics-Installation-ID"
            kotlin.Pair r15 = kotlin.l.a(r9, r15)     // Catch:{ all -> 0x004c }
            r9 = 0
            r8[r9] = r15     // Catch:{ all -> 0x004c }
            java.lang.String r15 = "X-Crashlytics-Device-Model"
            kotlin.jvm.internal.d0 r10 = kotlin.jvm.internal.d0.f56774a     // Catch:{ all -> 0x004c }
            java.lang.String r10 = "%s/%s"
            java.lang.Object[] r11 = new java.lang.Object[r4]     // Catch:{ all -> 0x004c }
            java.lang.String r12 = android.os.Build.MANUFACTURER     // Catch:{ all -> 0x004c }
            r11[r9] = r12     // Catch:{ all -> 0x004c }
            java.lang.String r9 = android.os.Build.MODEL     // Catch:{ all -> 0x004c }
            r11[r5] = r9     // Catch:{ all -> 0x004c }
            java.lang.Object[] r9 = java.util.Arrays.copyOf(r11, r4)     // Catch:{ all -> 0x004c }
            java.lang.String r9 = java.lang.String.format(r10, r9)     // Catch:{ all -> 0x004c }
            java.lang.String r9 = r7.removeForwardSlashesIn(r9)     // Catch:{ all -> 0x004c }
            kotlin.Pair r15 = kotlin.l.a(r15, r9)     // Catch:{ all -> 0x004c }
            r8[r5] = r15     // Catch:{ all -> 0x004c }
            java.lang.String r15 = "X-Crashlytics-OS-Build-Version"
            java.lang.String r5 = android.os.Build.VERSION.INCREMENTAL     // Catch:{ all -> 0x004c }
            java.lang.String r5 = r7.removeForwardSlashesIn(r5)     // Catch:{ all -> 0x004c }
            kotlin.Pair r15 = kotlin.l.a(r15, r5)     // Catch:{ all -> 0x004c }
            r8[r4] = r15     // Catch:{ all -> 0x004c }
            java.lang.String r15 = "X-Crashlytics-OS-Display-Version"
            java.lang.String r4 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x004c }
            java.lang.String r4 = r7.removeForwardSlashesIn(r4)     // Catch:{ all -> 0x004c }
            kotlin.Pair r15 = kotlin.l.a(r15, r4)     // Catch:{ all -> 0x004c }
            r8[r3] = r15     // Catch:{ all -> 0x004c }
            r15 = 4
            java.lang.String r4 = "X-Crashlytics-API-Client-Version"
            com.google.firebase.sessions.ApplicationInfo r5 = r7.appInfo     // Catch:{ all -> 0x004c }
            java.lang.String r5 = r5.getSessionSdkVersion()     // Catch:{ all -> 0x004c }
            kotlin.Pair r4 = kotlin.l.a(r4, r5)     // Catch:{ all -> 0x004c }
            r8[r15] = r4     // Catch:{ all -> 0x004c }
            java.util.Map r15 = kotlin.collections.MapsKt__MapsKt.l(r8)     // Catch:{ all -> 0x004c }
            com.google.firebase.sessions.settings.CrashlyticsSettingsFetcher r4 = r7.configsFetcher     // Catch:{ all -> 0x004c }
            com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$1 r5 = new com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$1     // Catch:{ all -> 0x004c }
            r5.<init>(r7, r6)     // Catch:{ all -> 0x004c }
            com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$2 r7 = new com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$2     // Catch:{ all -> 0x004c }
            r7.<init>(r6)     // Catch:{ all -> 0x004c }
            r0.L$0 = r2     // Catch:{ all -> 0x004c }
            r0.L$1 = r6     // Catch:{ all -> 0x004c }
            r0.label = r3     // Catch:{ all -> 0x004c }
            java.lang.Object r15 = r4.doConfigFetch(r15, r5, r7, r0)     // Catch:{ all -> 0x004c }
            if (r15 != r1) goto L_0x012e
            return r1
        L_0x012e:
            r0 = r2
        L_0x012f:
            kotlin.Unit r15 = kotlin.Unit.f56620a     // Catch:{ all -> 0x0035 }
            r0.e(r6)
            return r15
        L_0x0135:
            r0 = move-exception
            r13 = r0
            r0 = r15
            r15 = r13
        L_0x0139:
            r0.e(r6)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.RemoteSettings.updateSettings(kotlin.coroutines.c):java.lang.Object");
    }
}
