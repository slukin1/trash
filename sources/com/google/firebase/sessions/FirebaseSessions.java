package com.google.firebase.sessions;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.google.android.datatransport.TransportFactory;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.ktx.Firebase;
import com.google.firebase.ktx.FirebaseKt;
import com.google.firebase.sessions.api.FirebaseSessionsDependencies;
import com.google.firebase.sessions.api.SessionSubscriber;
import com.google.firebase.sessions.settings.SessionsSettings;
import d10.a;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.CoroutineDispatcher;

@Metadata(bv = {}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 +2\u00020\u0001:\u0001+B7\b\u0000\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010%\u001a\u00020#\u0012\f\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&¢\u0006\u0004\b)\u0010*J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\b\u001a\u00020\u0007H\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 \u0002\u0004\n\u0002\b\u0019¨\u0006,"}, d2 = {"Lcom/google/firebase/sessions/FirebaseSessions;", "", "Lcom/google/firebase/sessions/SessionDetails;", "sessionDetails", "", "initiateSessionStart", "(Lcom/google/firebase/sessions/SessionDetails;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "shouldCollectEvents", "Lcom/google/firebase/sessions/api/SessionSubscriber;", "subscriber", "register", "Lcom/google/firebase/FirebaseApp;", "firebaseApp", "Lcom/google/firebase/FirebaseApp;", "Lcom/google/firebase/sessions/ApplicationInfo;", "applicationInfo", "Lcom/google/firebase/sessions/ApplicationInfo;", "Lcom/google/firebase/sessions/settings/SessionsSettings;", "sessionSettings", "Lcom/google/firebase/sessions/settings/SessionsSettings;", "Lcom/google/firebase/sessions/TimeProvider;", "timeProvider", "Lcom/google/firebase/sessions/TimeProvider;", "Lcom/google/firebase/sessions/SessionGenerator;", "sessionGenerator", "Lcom/google/firebase/sessions/SessionGenerator;", "Lcom/google/firebase/sessions/EventGDTLogger;", "eventGDTLogger", "Lcom/google/firebase/sessions/EventGDTLogger;", "Lcom/google/firebase/sessions/SessionCoordinator;", "sessionCoordinator", "Lcom/google/firebase/sessions/SessionCoordinator;", "Lcom/google/firebase/installations/FirebaseInstallationsApi;", "firebaseInstallations", "Lkotlinx/coroutines/CoroutineDispatcher;", "backgroundDispatcher", "blockingDispatcher", "Lcom/google/firebase/inject/Provider;", "Lcom/google/android/datatransport/TransportFactory;", "transportFactoryProvider", "<init>", "(Lcom/google/firebase/FirebaseApp;Lcom/google/firebase/installations/FirebaseInstallationsApi;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Lcom/google/firebase/inject/Provider;)V", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1})
public final class FirebaseSessions {
    public static final Companion Companion = new Companion((r) null);
    private static final String TAG = "FirebaseSessions";
    private final ApplicationInfo applicationInfo;
    private final EventGDTLogger eventGDTLogger;
    private final FirebaseApp firebaseApp;
    private final SessionCoordinator sessionCoordinator;
    private final SessionGenerator sessionGenerator;
    private final SessionsSettings sessionSettings;
    private final TimeProvider timeProvider;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u00068FX\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/google/firebase/sessions/FirebaseSessions$Companion;", "", "()V", "TAG", "", "instance", "Lcom/google/firebase/sessions/FirebaseSessions;", "getInstance$annotations", "getInstance", "()Lcom/google/firebase/sessions/FirebaseSessions;", "app", "Lcom/google/firebase/FirebaseApp;", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public static /* synthetic */ void getInstance$annotations() {
        }

        public final FirebaseSessions getInstance() {
            return getInstance(FirebaseKt.getApp(Firebase.INSTANCE));
        }

        public final FirebaseSessions getInstance(FirebaseApp firebaseApp) {
            return (FirebaseSessions) firebaseApp.get(FirebaseSessions.class);
        }
    }

    public FirebaseSessions(FirebaseApp firebaseApp2, FirebaseInstallationsApi firebaseInstallationsApi, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, Provider<TransportFactory> provider) {
        FirebaseApp firebaseApp3 = firebaseApp2;
        this.firebaseApp = firebaseApp3;
        ApplicationInfo applicationInfo2 = SessionEvents.INSTANCE.getApplicationInfo(firebaseApp3);
        this.applicationInfo = applicationInfo2;
        SessionsSettings sessionsSettings = new SessionsSettings(firebaseApp2.getApplicationContext(), coroutineDispatcher2, coroutineDispatcher, firebaseInstallationsApi, applicationInfo2);
        this.sessionSettings = sessionsSettings;
        Time time = new Time();
        this.timeProvider = time;
        EventGDTLogger eventGDTLogger2 = new EventGDTLogger(provider);
        this.eventGDTLogger = eventGDTLogger2;
        this.sessionCoordinator = new SessionCoordinator(firebaseInstallationsApi, eventGDTLogger2);
        SessionGenerator sessionGenerator2 = new SessionGenerator(shouldCollectEvents(), time, (a) null, 4, (r) null);
        this.sessionGenerator = sessionGenerator2;
        SessionInitiator sessionInitiator = new SessionInitiator(time, coroutineDispatcher, new FirebaseSessions$sessionInitiateListener$1(this), sessionsSettings, sessionGenerator2);
        Context applicationContext = firebaseApp2.getApplicationContext().getApplicationContext();
        if (applicationContext instanceof Application) {
            ((Application) applicationContext).registerActivityLifecycleCallbacks(sessionInitiator.getActivityLifecycleCallbacks$com_google_firebase_firebase_sessions());
            firebaseApp3.addLifecycleEventListener(new c(applicationContext, sessionInitiator));
            return;
        }
        Log.e(TAG, "Failed to register lifecycle callbacks, unexpected context " + applicationContext.getClass() + '.');
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m3247_init_$lambda0(Context context, SessionInitiator sessionInitiator, String str, FirebaseOptions firebaseOptions) {
        Log.w(TAG, "FirebaseApp instance deleted. Sessions library will not collect session data.");
        ((Application) context).unregisterActivityLifecycleCallbacks(sessionInitiator.getActivityLifecycleCallbacks$com_google_firebase_firebase_sessions());
    }

    public static final FirebaseSessions getInstance() {
        return Companion.getInstance();
    }

    public static final FirebaseSessions getInstance(FirebaseApp firebaseApp2) {
        return Companion.getInstance(firebaseApp2);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object initiateSessionStart(com.google.firebase.sessions.SessionDetails r12, kotlin.coroutines.c<? super kotlin.Unit> r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof com.google.firebase.sessions.FirebaseSessions$initiateSessionStart$1
            if (r0 == 0) goto L_0x0013
            r0 = r13
            com.google.firebase.sessions.FirebaseSessions$initiateSessionStart$1 r0 = (com.google.firebase.sessions.FirebaseSessions$initiateSessionStart$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.google.firebase.sessions.FirebaseSessions$initiateSessionStart$1 r0 = new com.google.firebase.sessions.FirebaseSessions$initiateSessionStart$1
            r0.<init>(r11, r13)
        L_0x0018:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            java.lang.String r6 = "FirebaseSessions"
            if (r2 == 0) goto L_0x005a
            if (r2 == r5) goto L_0x004e
            if (r2 == r4) goto L_0x003d
            if (r2 != r3) goto L_0x0035
            kotlin.k.b(r13)     // Catch:{ IllegalStateException -> 0x0032 }
            goto L_0x0128
        L_0x0032:
            r12 = move-exception
            goto L_0x0123
        L_0x0035:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x003d:
            java.lang.Object r12 = r0.L$2
            java.util.Map r12 = (java.util.Map) r12
            java.lang.Object r2 = r0.L$1
            com.google.firebase.sessions.SessionDetails r2 = (com.google.firebase.sessions.SessionDetails) r2
            java.lang.Object r4 = r0.L$0
            com.google.firebase.sessions.FirebaseSessions r4 = (com.google.firebase.sessions.FirebaseSessions) r4
            kotlin.k.b(r13)
            goto L_0x00e7
        L_0x004e:
            java.lang.Object r12 = r0.L$1
            com.google.firebase.sessions.SessionDetails r12 = (com.google.firebase.sessions.SessionDetails) r12
            java.lang.Object r2 = r0.L$0
            com.google.firebase.sessions.FirebaseSessions r2 = (com.google.firebase.sessions.FirebaseSessions) r2
            kotlin.k.b(r13)
            goto L_0x006d
        L_0x005a:
            kotlin.k.b(r13)
            com.google.firebase.sessions.api.FirebaseSessionsDependencies r13 = com.google.firebase.sessions.api.FirebaseSessionsDependencies.INSTANCE
            r0.L$0 = r11
            r0.L$1 = r12
            r0.label = r5
            java.lang.Object r13 = r13.getRegisteredSubscribers$com_google_firebase_firebase_sessions(r0)
            if (r13 != r1) goto L_0x006c
            return r1
        L_0x006c:
            r2 = r11
        L_0x006d:
            java.util.Map r13 = (java.util.Map) r13
            boolean r7 = r13.isEmpty()
            if (r7 == 0) goto L_0x007d
            java.lang.String r12 = "Sessions SDK did not have any dependent SDKs register as dependencies. Events will not be sent."
            android.util.Log.d(r6, r12)
            kotlin.Unit r12 = kotlin.Unit.f56620a
            return r12
        L_0x007d:
            java.util.Collection r7 = r13.values()
            java.util.Iterator r7 = r7.iterator()
        L_0x0085:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x009e
            java.lang.Object r8 = r7.next()
            com.google.firebase.sessions.api.SessionSubscriber r8 = (com.google.firebase.sessions.api.SessionSubscriber) r8
            com.google.firebase.sessions.api.SessionSubscriber$SessionDetails r9 = new com.google.firebase.sessions.api.SessionSubscriber$SessionDetails
            java.lang.String r10 = r12.getSessionId()
            r9.<init>(r10)
            r8.onSessionChanged(r9)
            goto L_0x0085
        L_0x009e:
            java.util.Collection r7 = r13.values()
            boolean r8 = r7 instanceof java.util.Collection
            if (r8 == 0) goto L_0x00ad
            boolean r8 = r7.isEmpty()
            if (r8 == 0) goto L_0x00ad
            goto L_0x00c4
        L_0x00ad:
            java.util.Iterator r7 = r7.iterator()
        L_0x00b1:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x00c4
            java.lang.Object r8 = r7.next()
            com.google.firebase.sessions.api.SessionSubscriber r8 = (com.google.firebase.sessions.api.SessionSubscriber) r8
            boolean r8 = r8.isDataCollectionEnabled()
            if (r8 == 0) goto L_0x00b1
            r5 = 0
        L_0x00c4:
            if (r5 == 0) goto L_0x00ce
            java.lang.String r12 = "Data Collection is disabled for all subscribers. Skipping this Session Event"
            android.util.Log.d(r6, r12)
            kotlin.Unit r12 = kotlin.Unit.f56620a
            return r12
        L_0x00ce:
            java.lang.String r5 = "Data Collection is enabled for at least one Subscriber"
            android.util.Log.d(r6, r5)
            com.google.firebase.sessions.settings.SessionsSettings r5 = r2.sessionSettings
            r0.L$0 = r2
            r0.L$1 = r12
            r0.L$2 = r13
            r0.label = r4
            java.lang.Object r4 = r5.updateSettings(r0)
            if (r4 != r1) goto L_0x00e4
            return r1
        L_0x00e4:
            r4 = r2
            r2 = r12
            r12 = r13
        L_0x00e7:
            com.google.firebase.sessions.settings.SessionsSettings r13 = r4.sessionSettings
            boolean r13 = r13.getSessionsEnabled()
            if (r13 != 0) goto L_0x00f7
            java.lang.String r12 = "Sessions SDK disabled. Events will not be sent."
            android.util.Log.d(r6, r12)
            kotlin.Unit r12 = kotlin.Unit.f56620a
            return r12
        L_0x00f7:
            com.google.firebase.sessions.SessionGenerator r13 = r4.sessionGenerator
            boolean r13 = r13.getCollectEvents()
            if (r13 != 0) goto L_0x0107
            java.lang.String r12 = "Sessions SDK has dropped this session due to sampling."
            android.util.Log.d(r6, r12)
            kotlin.Unit r12 = kotlin.Unit.f56620a
            return r12
        L_0x0107:
            com.google.firebase.sessions.SessionEvents r13 = com.google.firebase.sessions.SessionEvents.INSTANCE     // Catch:{ IllegalStateException -> 0x0032 }
            com.google.firebase.FirebaseApp r5 = r4.firebaseApp     // Catch:{ IllegalStateException -> 0x0032 }
            com.google.firebase.sessions.settings.SessionsSettings r7 = r4.sessionSettings     // Catch:{ IllegalStateException -> 0x0032 }
            com.google.firebase.sessions.SessionEvent r12 = r13.startSession(r5, r2, r7, r12)     // Catch:{ IllegalStateException -> 0x0032 }
            com.google.firebase.sessions.SessionCoordinator r13 = r4.sessionCoordinator     // Catch:{ IllegalStateException -> 0x0032 }
            r2 = 0
            r0.L$0 = r2     // Catch:{ IllegalStateException -> 0x0032 }
            r0.L$1 = r2     // Catch:{ IllegalStateException -> 0x0032 }
            r0.L$2 = r2     // Catch:{ IllegalStateException -> 0x0032 }
            r0.label = r3     // Catch:{ IllegalStateException -> 0x0032 }
            java.lang.Object r12 = r13.attemptLoggingSessionEvent(r12, r0)     // Catch:{ IllegalStateException -> 0x0032 }
            if (r12 != r1) goto L_0x0128
            return r1
        L_0x0123:
            java.lang.String r13 = "FirebaseApp is not initialized. Sessions library will not collect session data."
            android.util.Log.w(r6, r13, r12)
        L_0x0128:
            kotlin.Unit r12 = kotlin.Unit.f56620a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.FirebaseSessions.initiateSessionStart(com.google.firebase.sessions.SessionDetails, kotlin.coroutines.c):java.lang.Object");
    }

    private final boolean shouldCollectEvents() {
        return Math.random() <= this.sessionSettings.getSamplingRate();
    }

    public final void register(SessionSubscriber sessionSubscriber) {
        FirebaseSessionsDependencies.INSTANCE.register$com_google_firebase_firebase_sessions(sessionSubscriber);
        Log.d(TAG, "Registering Sessions SDK subscriber with name: " + sessionSubscriber.getSessionSubscriberName() + ", data collection enabled: " + sessionSubscriber.isDataCollectionEnabled());
        if (this.sessionGenerator.getHasGenerateSession()) {
            sessionSubscriber.onSessionChanged(new SessionSubscriber.SessionDetails(this.sessionGenerator.getCurrentSession().getSessionId()));
        }
    }
}
