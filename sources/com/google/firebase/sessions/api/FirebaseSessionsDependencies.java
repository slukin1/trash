package com.google.firebase.sessions.api;

import android.util.Log;
import com.google.firebase.sessions.api.SessionSubscriber;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.coroutines.sync.MutexKt;
import kotlinx.coroutines.sync.a;

@Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001fB\t\b\u0002¢\u0006\u0004\b\u001e\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\rH@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0016\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00178\u0002XT¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019RT\u0010\u001c\u001aB\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u00040\u0004 \u001b* \u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\r0\u001a8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"Lcom/google/firebase/sessions/api/FirebaseSessionsDependencies;", "", "Lcom/google/firebase/sessions/api/SessionSubscriber$Name;", "subscriberName", "Lcom/google/firebase/sessions/api/FirebaseSessionsDependencies$Dependency;", "getDependency", "", "addDependency", "Lcom/google/firebase/sessions/api/SessionSubscriber;", "subscriber", "register$com_google_firebase_firebase_sessions", "(Lcom/google/firebase/sessions/api/SessionSubscriber;)V", "register", "", "getRegisteredSubscribers$com_google_firebase_firebase_sessions", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "getRegisteredSubscribers", "getSubscriber$com_google_firebase_firebase_sessions", "(Lcom/google/firebase/sessions/api/SessionSubscriber$Name;)Lcom/google/firebase/sessions/api/SessionSubscriber;", "getSubscriber", "reset$com_google_firebase_firebase_sessions", "()V", "reset", "", "TAG", "Ljava/lang/String;", "", "kotlin.jvm.PlatformType", "dependencies", "Ljava/util/Map;", "<init>", "Dependency", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1})
public final class FirebaseSessionsDependencies {
    public static final FirebaseSessionsDependencies INSTANCE = new FirebaseSessionsDependencies();
    private static final String TAG = "SessionsDependencies";
    private static final Map<SessionSubscriber.Name, Dependency> dependencies = Collections.synchronizedMap(new LinkedHashMap());

    @Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u001f\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\n\u001a\u00020\tHÖ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R$\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/google/firebase/sessions/api/FirebaseSessionsDependencies$Dependency;", "", "Lkotlinx/coroutines/sync/a;", "component1", "Lcom/google/firebase/sessions/api/SessionSubscriber;", "component2", "mutex", "subscriber", "copy", "", "toString", "", "hashCode", "other", "", "equals", "Lkotlinx/coroutines/sync/a;", "getMutex", "()Lkotlinx/coroutines/sync/a;", "Lcom/google/firebase/sessions/api/SessionSubscriber;", "getSubscriber", "()Lcom/google/firebase/sessions/api/SessionSubscriber;", "setSubscriber", "(Lcom/google/firebase/sessions/api/SessionSubscriber;)V", "<init>", "(Lkotlinx/coroutines/sync/a;Lcom/google/firebase/sessions/api/SessionSubscriber;)V", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1})
    public static final class Dependency {
        private final a mutex;
        private SessionSubscriber subscriber;

        public Dependency(a aVar, SessionSubscriber sessionSubscriber) {
            this.mutex = aVar;
            this.subscriber = sessionSubscriber;
        }

        public static /* synthetic */ Dependency copy$default(Dependency dependency, a aVar, SessionSubscriber sessionSubscriber, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                aVar = dependency.mutex;
            }
            if ((i11 & 2) != 0) {
                sessionSubscriber = dependency.subscriber;
            }
            return dependency.copy(aVar, sessionSubscriber);
        }

        public final a component1() {
            return this.mutex;
        }

        public final SessionSubscriber component2() {
            return this.subscriber;
        }

        public final Dependency copy(a aVar, SessionSubscriber sessionSubscriber) {
            return new Dependency(aVar, sessionSubscriber);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Dependency)) {
                return false;
            }
            Dependency dependency = (Dependency) obj;
            return x.b(this.mutex, dependency.mutex) && x.b(this.subscriber, dependency.subscriber);
        }

        public final a getMutex() {
            return this.mutex;
        }

        public final SessionSubscriber getSubscriber() {
            return this.subscriber;
        }

        public int hashCode() {
            int hashCode = this.mutex.hashCode() * 31;
            SessionSubscriber sessionSubscriber = this.subscriber;
            return hashCode + (sessionSubscriber == null ? 0 : sessionSubscriber.hashCode());
        }

        public final void setSubscriber(SessionSubscriber sessionSubscriber) {
            this.subscriber = sessionSubscriber;
        }

        public String toString() {
            return "Dependency(mutex=" + this.mutex + ", subscriber=" + this.subscriber + ')';
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Dependency(a aVar, SessionSubscriber sessionSubscriber, int i11, r rVar) {
            this(aVar, (i11 & 2) != 0 ? null : sessionSubscriber);
        }
    }

    private FirebaseSessionsDependencies() {
    }

    private final Dependency getDependency(SessionSubscriber.Name name) {
        Dependency dependency = dependencies.get(name);
        if (dependency != null) {
            return dependency;
        }
        throw new IllegalStateException("Cannot get dependency " + name + ". Dependencies should be added at class load time.");
    }

    public final void addDependency(SessionSubscriber.Name name) {
        Map<SessionSubscriber.Name, Dependency> map = dependencies;
        if (map.containsKey(name)) {
            Log.d(TAG, "Dependency " + name + " already added.");
            return;
        }
        map.put(name, new Dependency(MutexKt.a(true), (SessionSubscriber) null, 2, (r) null));
    }

    /* JADX INFO: finally extract failed */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: com.google.firebase.sessions.api.SessionSubscriber$Name} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getRegisteredSubscribers$com_google_firebase_firebase_sessions(kotlin.coroutines.c<? super java.util.Map<com.google.firebase.sessions.api.SessionSubscriber.Name, ? extends com.google.firebase.sessions.api.SessionSubscriber>> r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.google.firebase.sessions.api.FirebaseSessionsDependencies$getRegisteredSubscribers$1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            com.google.firebase.sessions.api.FirebaseSessionsDependencies$getRegisteredSubscribers$1 r0 = (com.google.firebase.sessions.api.FirebaseSessionsDependencies$getRegisteredSubscribers$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.google.firebase.sessions.api.FirebaseSessionsDependencies$getRegisteredSubscribers$1 r0 = new com.google.firebase.sessions.api.FirebaseSessionsDependencies$getRegisteredSubscribers$1
            r0.<init>(r10, r11)
        L_0x0018:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0048
            if (r2 != r4) goto L_0x0040
            java.lang.Object r2 = r0.L$5
            java.lang.Object r5 = r0.L$4
            java.util.Map r5 = (java.util.Map) r5
            java.lang.Object r6 = r0.L$3
            kotlinx.coroutines.sync.a r6 = (kotlinx.coroutines.sync.a) r6
            java.lang.Object r7 = r0.L$2
            com.google.firebase.sessions.api.SessionSubscriber$Name r7 = (com.google.firebase.sessions.api.SessionSubscriber.Name) r7
            java.lang.Object r8 = r0.L$1
            java.util.Iterator r8 = (java.util.Iterator) r8
            java.lang.Object r9 = r0.L$0
            java.util.Map r9 = (java.util.Map) r9
            kotlin.k.b(r11)
            goto L_0x009b
        L_0x0040:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x0048:
            kotlin.k.b(r11)
            java.util.Map<com.google.firebase.sessions.api.SessionSubscriber$Name, com.google.firebase.sessions.api.FirebaseSessionsDependencies$Dependency> r11 = dependencies
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            int r5 = r11.size()
            int r5 = kotlin.collections.MapsKt__MapsJVMKt.d(r5)
            r2.<init>(r5)
            java.util.Set r11 = r11.entrySet()
            java.util.Iterator r11 = r11.iterator()
            r8 = r11
            r5 = r2
        L_0x0064:
            boolean r11 = r8.hasNext()
            if (r11 == 0) goto L_0x00ae
            java.lang.Object r11 = r8.next()
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11
            java.lang.Object r2 = r11.getKey()
            java.lang.Object r6 = r11.getKey()
            r7 = r6
            com.google.firebase.sessions.api.SessionSubscriber$Name r7 = (com.google.firebase.sessions.api.SessionSubscriber.Name) r7
            java.lang.Object r11 = r11.getValue()
            com.google.firebase.sessions.api.FirebaseSessionsDependencies$Dependency r11 = (com.google.firebase.sessions.api.FirebaseSessionsDependencies.Dependency) r11
            kotlinx.coroutines.sync.a r6 = r11.getMutex()
            r0.L$0 = r5
            r0.L$1 = r8
            r0.L$2 = r7
            r0.L$3 = r6
            r0.L$4 = r5
            r0.L$5 = r2
            r0.label = r4
            java.lang.Object r11 = r6.d(r3, r0)
            if (r11 != r1) goto L_0x009a
            return r1
        L_0x009a:
            r9 = r5
        L_0x009b:
            com.google.firebase.sessions.api.FirebaseSessionsDependencies r11 = INSTANCE     // Catch:{ all -> 0x00a9 }
            com.google.firebase.sessions.api.SessionSubscriber r11 = r11.getSubscriber$com_google_firebase_firebase_sessions(r7)     // Catch:{ all -> 0x00a9 }
            r6.e(r3)
            r5.put(r2, r11)
            r5 = r9
            goto L_0x0064
        L_0x00a9:
            r11 = move-exception
            r6.e(r3)
            throw r11
        L_0x00ae:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.api.FirebaseSessionsDependencies.getRegisteredSubscribers$com_google_firebase_firebase_sessions(kotlin.coroutines.c):java.lang.Object");
    }

    public final SessionSubscriber getSubscriber$com_google_firebase_firebase_sessions(SessionSubscriber.Name name) {
        SessionSubscriber subscriber = getDependency(name).getSubscriber();
        if (subscriber != null) {
            return subscriber;
        }
        throw new IllegalStateException("Subscriber " + name + " has not been registered.");
    }

    public final void register$com_google_firebase_firebase_sessions(SessionSubscriber sessionSubscriber) {
        SessionSubscriber.Name sessionSubscriberName = sessionSubscriber.getSessionSubscriberName();
        Dependency dependency = getDependency(sessionSubscriberName);
        if (dependency.getSubscriber() != null) {
            Log.d(TAG, "Subscriber " + sessionSubscriberName + " already registered.");
            return;
        }
        dependency.setSubscriber(sessionSubscriber);
        a.C0668a.c(dependency.getMutex(), (Object) null, 1, (Object) null);
    }

    public final void reset$com_google_firebase_firebase_sessions() {
        dependencies.clear();
    }
}
