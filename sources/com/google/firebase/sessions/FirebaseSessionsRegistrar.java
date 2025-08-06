package com.google.firebase.sessions;

import androidx.annotation.Keep;
import com.google.android.datatransport.TransportFactory;
import com.google.firebase.FirebaseApp;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.CoroutineDispatcher;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0001\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0005¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a0\u0012,\u0012*\u0012\u000e\b\u0001\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007*\u0014\u0012\u000e\b\u0001\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00050\u00050\u0004H\u0016¨\u0006\t"}, d2 = {"Lcom/google/firebase/sessions/FirebaseSessionsRegistrar;", "Lcom/google/firebase/components/ComponentRegistrar;", "()V", "getComponents", "", "Lcom/google/firebase/components/Component;", "", "kotlin.jvm.PlatformType", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Keep
public final class FirebaseSessionsRegistrar implements ComponentRegistrar {
    public static final Companion Companion = new Companion((r) null);
    private static final String LIBRARY_NAME = "fire-sessions";
    private static final Qualified<CoroutineDispatcher> backgroundDispatcher;
    private static final Qualified<CoroutineDispatcher> blockingDispatcher;
    private static final Qualified<FirebaseApp> firebaseApp = Qualified.unqualified(FirebaseApp.class);
    private static final Qualified<FirebaseInstallationsApi> firebaseInstallationsApi = Qualified.unqualified(FirebaseInstallationsApi.class);
    private static final Qualified<TransportFactory> transportFactory = Qualified.unqualified(TransportFactory.class);

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R2\u0010\u0005\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007 \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R2\u0010\t\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007 \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R2\u0010\n\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u00010\u000b0\u000b \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u00010\u000b0\u000b\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R2\u0010\f\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u00010\r0\r \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u00010\r0\r\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R2\u0010\u000e\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u00010\u000f0\u000f \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u00010\u000f0\u000f\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/google/firebase/sessions/FirebaseSessionsRegistrar$Companion;", "", "()V", "LIBRARY_NAME", "", "backgroundDispatcher", "Lcom/google/firebase/components/Qualified;", "Lkotlinx/coroutines/CoroutineDispatcher;", "kotlin.jvm.PlatformType", "blockingDispatcher", "firebaseApp", "Lcom/google/firebase/FirebaseApp;", "firebaseInstallationsApi", "Lcom/google/firebase/installations/FirebaseInstallationsApi;", "transportFactory", "Lcom/google/android/datatransport/TransportFactory;", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }
    }

    static {
        Class<CoroutineDispatcher> cls = CoroutineDispatcher.class;
        backgroundDispatcher = Qualified.qualified(Background.class, cls);
        blockingDispatcher = Qualified.qualified(Blocking.class, cls);
    }

    /* access modifiers changed from: private */
    /* renamed from: getComponents$lambda-0  reason: not valid java name */
    public static final FirebaseSessions m3248getComponents$lambda0(ComponentContainer componentContainer) {
        return new FirebaseSessions((FirebaseApp) componentContainer.get(firebaseApp), (FirebaseInstallationsApi) componentContainer.get(firebaseInstallationsApi), (CoroutineDispatcher) componentContainer.get(backgroundDispatcher), (CoroutineDispatcher) componentContainer.get(blockingDispatcher), componentContainer.getProvider(transportFactory));
    }

    public List<Component<? extends Object>> getComponents() {
        return CollectionsKt__CollectionsKt.n(Component.builder(FirebaseSessions.class).name(LIBRARY_NAME).add(Dependency.required((Qualified<?>) firebaseApp)).add(Dependency.required((Qualified<?>) firebaseInstallationsApi)).add(Dependency.required((Qualified<?>) backgroundDispatcher)).add(Dependency.required((Qualified<?>) blockingDispatcher)).add(Dependency.requiredProvider((Qualified<?>) transportFactory)).factory(d.f67164a).build(), LibraryVersionComponent.create(LIBRARY_NAME, BuildConfig.VERSION_NAME));
    }
}
