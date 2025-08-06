package com.google.firebase;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.core.os.o;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentDiscovery;
import com.google.firebase.components.ComponentDiscoveryService;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.components.Lazy;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.concurrent.UiExecutor;
import com.google.firebase.events.Publisher;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatController;
import com.google.firebase.inject.Provider;
import com.google.firebase.internal.DataCollectionConfigStorage;
import com.google.firebase.provider.FirebaseInitProvider;
import com.google.firebase.tracing.ComponentMonitor;
import com.google.firebase.tracing.FirebaseTrace;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class FirebaseApp {
    public static final String DEFAULT_APP_NAME = "[DEFAULT]";
    public static final Map<String, FirebaseApp> INSTANCES = new ArrayMap();
    /* access modifiers changed from: private */
    public static final Object LOCK = new Object();
    private static final String LOG_TAG = "FirebaseApp";
    private final Context applicationContext;
    /* access modifiers changed from: private */
    public final AtomicBoolean automaticResourceManagementEnabled = new AtomicBoolean(false);
    private final List<BackgroundStateChangeListener> backgroundStateChangeListeners = new CopyOnWriteArrayList();
    private final ComponentRuntime componentRuntime;
    private final Lazy<DataCollectionConfigStorage> dataCollectionConfigStorage;
    private final Provider<DefaultHeartBeatController> defaultHeartBeatController;
    private final AtomicBoolean deleted = new AtomicBoolean();
    private final List<FirebaseAppLifecycleListener> lifecycleListeners = new CopyOnWriteArrayList();
    private final String name;
    private final FirebaseOptions options;

    @KeepForSdk
    public interface BackgroundStateChangeListener {
        @KeepForSdk
        void onBackgroundStateChanged(boolean z11);
    }

    @TargetApi(14)
    public static class GlobalBackgroundStateListener implements BackgroundDetector.BackgroundStateChangeListener {
        private static AtomicReference<GlobalBackgroundStateListener> INSTANCE = new AtomicReference<>();

        private GlobalBackgroundStateListener() {
        }

        /* access modifiers changed from: private */
        public static void ensureBackgroundStateListenerRegistered(Context context) {
            if (PlatformVersion.isAtLeastIceCreamSandwich() && (context.getApplicationContext() instanceof Application)) {
                Application application = (Application) context.getApplicationContext();
                if (INSTANCE.get() == null) {
                    GlobalBackgroundStateListener globalBackgroundStateListener = new GlobalBackgroundStateListener();
                    if (INSTANCE.compareAndSet((Object) null, globalBackgroundStateListener)) {
                        BackgroundDetector.initialize(application);
                        BackgroundDetector.getInstance().addListener(globalBackgroundStateListener);
                    }
                }
            }
        }

        public void onBackgroundStateChanged(boolean z11) {
            synchronized (FirebaseApp.LOCK) {
                Iterator it2 = new ArrayList(FirebaseApp.INSTANCES.values()).iterator();
                while (it2.hasNext()) {
                    FirebaseApp firebaseApp = (FirebaseApp) it2.next();
                    if (firebaseApp.automaticResourceManagementEnabled.get()) {
                        firebaseApp.notifyBackgroundStateChangeListeners(z11);
                    }
                }
            }
        }
    }

    @TargetApi(24)
    public static class UserUnlockReceiver extends BroadcastReceiver {
        private static AtomicReference<UserUnlockReceiver> INSTANCE = new AtomicReference<>();
        private final Context applicationContext;

        public UserUnlockReceiver(Context context) {
            this.applicationContext = context;
        }

        /* access modifiers changed from: private */
        public static void ensureReceiverRegistered(Context context) {
            if (INSTANCE.get() == null) {
                UserUnlockReceiver userUnlockReceiver = new UserUnlockReceiver(context);
                if (INSTANCE.compareAndSet((Object) null, userUnlockReceiver)) {
                    context.registerReceiver(userUnlockReceiver, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }

        public void onReceive(Context context, Intent intent) {
            PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            synchronized (FirebaseApp.LOCK) {
                for (FirebaseApp access$300 : FirebaseApp.INSTANCES.values()) {
                    access$300.initializeAllApis();
                }
            }
            unregister();
        }

        public void unregister() {
            this.applicationContext.unregisterReceiver(this);
        }
    }

    public FirebaseApp(Context context, String str, FirebaseOptions firebaseOptions) {
        this.applicationContext = (Context) Preconditions.checkNotNull(context);
        this.name = Preconditions.checkNotEmpty(str);
        this.options = (FirebaseOptions) Preconditions.checkNotNull(firebaseOptions);
        StartupTime startupTime = FirebaseInitProvider.getStartupTime();
        FirebaseTrace.pushTrace("Firebase");
        FirebaseTrace.pushTrace(ComponentDiscovery.TAG);
        List<Provider<ComponentRegistrar>> discoverLazy = ComponentDiscovery.forContext(context, ComponentDiscoveryService.class).discoverLazy();
        FirebaseTrace.popTrace();
        FirebaseTrace.pushTrace("Runtime");
        ComponentRuntime.Builder processor = ComponentRuntime.builder(UiExecutor.INSTANCE).addLazyComponentRegistrars(discoverLazy).addComponentRegistrar(new FirebaseCommonRegistrar()).addComponentRegistrar(new ExecutorsRegistrar()).addComponent(Component.of(context, Context.class, (Class<? super T>[]) new Class[0])).addComponent(Component.of(this, FirebaseApp.class, (Class<? super T>[]) new Class[0])).addComponent(Component.of(firebaseOptions, FirebaseOptions.class, (Class<? super T>[]) new Class[0])).setProcessor(new ComponentMonitor());
        if (o.a(context) && FirebaseInitProvider.isCurrentlyInitializing()) {
            processor.addComponent(Component.of(startupTime, StartupTime.class, (Class<? super T>[]) new Class[0]));
        }
        ComponentRuntime build = processor.build();
        this.componentRuntime = build;
        FirebaseTrace.popTrace();
        this.dataCollectionConfigStorage = new Lazy<>(new b(this, context));
        this.defaultHeartBeatController = build.getProvider(DefaultHeartBeatController.class);
        addBackgroundStateChangeListener(new a(this));
        FirebaseTrace.popTrace();
    }

    private void checkNotDeleted() {
        Preconditions.checkState(!this.deleted.get(), "FirebaseApp was deleted");
    }

    public static void clearInstancesForTest() {
        synchronized (LOCK) {
            INSTANCES.clear();
        }
    }

    private static List<String> getAllAppNames() {
        ArrayList arrayList = new ArrayList();
        synchronized (LOCK) {
            for (FirebaseApp name2 : INSTANCES.values()) {
                arrayList.add(name2.getName());
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static List<FirebaseApp> getApps(Context context) {
        ArrayList arrayList;
        synchronized (LOCK) {
            arrayList = new ArrayList(INSTANCES.values());
        }
        return arrayList;
    }

    public static FirebaseApp getInstance() {
        FirebaseApp firebaseApp;
        synchronized (LOCK) {
            firebaseApp = INSTANCES.get(DEFAULT_APP_NAME);
            if (firebaseApp != null) {
                firebaseApp.defaultHeartBeatController.get().registerHeartBeat();
            } else {
                throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + ProcessUtils.getMyProcessName() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
            }
        }
        return firebaseApp;
    }

    /* access modifiers changed from: private */
    public void initializeAllApis() {
        if (!o.a(this.applicationContext)) {
            Log.i(LOG_TAG, "Device in Direct Boot Mode: postponing initialization of Firebase APIs for app " + getName());
            UserUnlockReceiver.ensureReceiverRegistered(this.applicationContext);
            return;
        }
        Log.i(LOG_TAG, "Device unlocked: initializing all Firebase APIs for app " + getName());
        this.componentRuntime.initializeEagerComponents(isDefaultApp());
        this.defaultHeartBeatController.get().registerHeartBeat();
    }

    public static FirebaseApp initializeApp(Context context) {
        synchronized (LOCK) {
            if (INSTANCES.containsKey(DEFAULT_APP_NAME)) {
                FirebaseApp instance = getInstance();
                return instance;
            }
            FirebaseOptions fromResource = FirebaseOptions.fromResource(context);
            if (fromResource == null) {
                Log.w(LOG_TAG, "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
                return null;
            }
            FirebaseApp initializeApp = initializeApp(context, fromResource);
            return initializeApp;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DataCollectionConfigStorage lambda$new$0(Context context) {
        return new DataCollectionConfigStorage(context, getPersistenceKey(), (Publisher) this.componentRuntime.get(Publisher.class));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(boolean z11) {
        if (!z11) {
            this.defaultHeartBeatController.get().registerHeartBeat();
        }
    }

    private static String normalize(String str) {
        return str.trim();
    }

    /* access modifiers changed from: private */
    public void notifyBackgroundStateChangeListeners(boolean z11) {
        Log.d(LOG_TAG, "Notifying background state change listeners.");
        for (BackgroundStateChangeListener onBackgroundStateChanged : this.backgroundStateChangeListeners) {
            onBackgroundStateChanged.onBackgroundStateChanged(z11);
        }
    }

    private void notifyOnAppDeleted() {
        for (FirebaseAppLifecycleListener onDeleted : this.lifecycleListeners) {
            onDeleted.onDeleted(this.name, this.options);
        }
    }

    @KeepForSdk
    public void addBackgroundStateChangeListener(BackgroundStateChangeListener backgroundStateChangeListener) {
        checkNotDeleted();
        if (this.automaticResourceManagementEnabled.get() && BackgroundDetector.getInstance().isInBackground()) {
            backgroundStateChangeListener.onBackgroundStateChanged(true);
        }
        this.backgroundStateChangeListeners.add(backgroundStateChangeListener);
    }

    @KeepForSdk
    public void addLifecycleEventListener(FirebaseAppLifecycleListener firebaseAppLifecycleListener) {
        checkNotDeleted();
        Preconditions.checkNotNull(firebaseAppLifecycleListener);
        this.lifecycleListeners.add(firebaseAppLifecycleListener);
    }

    public void delete() {
        if (this.deleted.compareAndSet(false, true)) {
            synchronized (LOCK) {
                INSTANCES.remove(this.name);
            }
            notifyOnAppDeleted();
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FirebaseApp)) {
            return false;
        }
        return this.name.equals(((FirebaseApp) obj).getName());
    }

    @KeepForSdk
    public <T> T get(Class<T> cls) {
        checkNotDeleted();
        return this.componentRuntime.get((Class) cls);
    }

    public Context getApplicationContext() {
        checkNotDeleted();
        return this.applicationContext;
    }

    public String getName() {
        checkNotDeleted();
        return this.name;
    }

    public FirebaseOptions getOptions() {
        checkNotDeleted();
        return this.options;
    }

    @KeepForSdk
    public String getPersistenceKey() {
        return Base64Utils.encodeUrlSafeNoPadding(getName().getBytes(Charset.defaultCharset())) + "+" + Base64Utils.encodeUrlSafeNoPadding(getOptions().getApplicationId().getBytes(Charset.defaultCharset()));
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public void initializeAllComponents() {
        this.componentRuntime.initializeAllComponentsForTests();
    }

    @KeepForSdk
    public boolean isDataCollectionDefaultEnabled() {
        checkNotDeleted();
        return this.dataCollectionConfigStorage.get().isEnabled();
    }

    @KeepForSdk
    public boolean isDefaultApp() {
        return DEFAULT_APP_NAME.equals(getName());
    }

    @KeepForSdk
    public void removeBackgroundStateChangeListener(BackgroundStateChangeListener backgroundStateChangeListener) {
        checkNotDeleted();
        this.backgroundStateChangeListeners.remove(backgroundStateChangeListener);
    }

    @KeepForSdk
    public void removeLifecycleEventListener(FirebaseAppLifecycleListener firebaseAppLifecycleListener) {
        checkNotDeleted();
        Preconditions.checkNotNull(firebaseAppLifecycleListener);
        this.lifecycleListeners.remove(firebaseAppLifecycleListener);
    }

    public void setAutomaticResourceManagementEnabled(boolean z11) {
        checkNotDeleted();
        if (this.automaticResourceManagementEnabled.compareAndSet(!z11, z11)) {
            boolean isInBackground = BackgroundDetector.getInstance().isInBackground();
            if (z11 && isInBackground) {
                notifyBackgroundStateChangeListeners(true);
            } else if (!z11 && isInBackground) {
                notifyBackgroundStateChangeListeners(false);
            }
        }
    }

    @KeepForSdk
    public void setDataCollectionDefaultEnabled(Boolean bool) {
        checkNotDeleted();
        this.dataCollectionConfigStorage.get().setEnabled(bool);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("name", this.name).add("options", this.options).toString();
    }

    @KeepForSdk
    @Deprecated
    public void setDataCollectionDefaultEnabled(boolean z11) {
        setDataCollectionDefaultEnabled(Boolean.valueOf(z11));
    }

    @KeepForSdk
    public static String getPersistenceKey(String str, FirebaseOptions firebaseOptions) {
        return Base64Utils.encodeUrlSafeNoPadding(str.getBytes(Charset.defaultCharset())) + "+" + Base64Utils.encodeUrlSafeNoPadding(firebaseOptions.getApplicationId().getBytes(Charset.defaultCharset()));
    }

    public static FirebaseApp getInstance(String str) {
        FirebaseApp firebaseApp;
        String str2;
        synchronized (LOCK) {
            firebaseApp = INSTANCES.get(normalize(str));
            if (firebaseApp != null) {
                firebaseApp.defaultHeartBeatController.get().registerHeartBeat();
            } else {
                List<String> allAppNames = getAllAppNames();
                if (allAppNames.isEmpty()) {
                    str2 = "";
                } else {
                    str2 = "Available app names: " + TextUtils.join(", ", allAppNames);
                }
                throw new IllegalStateException(String.format("FirebaseApp with name %s doesn't exist. %s", new Object[]{str, str2}));
            }
        }
        return firebaseApp;
    }

    public static FirebaseApp initializeApp(Context context, FirebaseOptions firebaseOptions) {
        return initializeApp(context, firebaseOptions, DEFAULT_APP_NAME);
    }

    public static FirebaseApp initializeApp(Context context, FirebaseOptions firebaseOptions, String str) {
        FirebaseApp firebaseApp;
        GlobalBackgroundStateListener.ensureBackgroundStateListenerRegistered(context);
        String normalize = normalize(str);
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (LOCK) {
            Map<String, FirebaseApp> map = INSTANCES;
            boolean z11 = !map.containsKey(normalize);
            Preconditions.checkState(z11, "FirebaseApp name " + normalize + " already exists!");
            Preconditions.checkNotNull(context, "Application context cannot be null.");
            firebaseApp = new FirebaseApp(context, normalize, firebaseOptions);
            map.put(normalize, firebaseApp);
        }
        firebaseApp.initializeAllApis();
        return firebaseApp;
    }
}
