package androidx.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.contextaware.ContextAwareHelper;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.util.Consumer;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuProvider;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ReportFragment;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.h0;
import androidx.lifecycle.o;
import androidx.lifecycle.q0;
import androidx.lifecycle.r;
import androidx.lifecycle.r0;
import androidx.lifecycle.s0;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import p0.n;
import p0.p;

public class ComponentActivity extends androidx.core.app.ComponentActivity implements b.a, q0, o, androidx.savedstate.c, q, androidx.activity.result.c, androidx.activity.result.a, q0.c, q0.d, n, p0.o, androidx.core.view.j, m {
    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private final ActivityResultRegistry mActivityResultRegistry;
    private int mContentLayoutId;
    public final ContextAwareHelper mContextAwareHelper;
    private ViewModelProvider.Factory mDefaultFactory;
    private boolean mDispatchingOnMultiWindowModeChanged;
    private boolean mDispatchingOnPictureInPictureModeChanged;
    public final FullyDrawnReporter mFullyDrawnReporter;
    private final LifecycleRegistry mLifecycleRegistry;
    private final MenuHostHelper mMenuHostHelper;
    private final AtomicInteger mNextLocalRequestCode;
    /* access modifiers changed from: private */
    public OnBackPressedDispatcher mOnBackPressedDispatcher;
    private final CopyOnWriteArrayList<Consumer<Configuration>> mOnConfigurationChangedListeners;
    private final CopyOnWriteArrayList<Consumer<p0.i>> mOnMultiWindowModeChangedListeners;
    private final CopyOnWriteArrayList<Consumer<Intent>> mOnNewIntentListeners;
    private final CopyOnWriteArrayList<Consumer<p>> mOnPictureInPictureModeChangedListeners;
    private final CopyOnWriteArrayList<Consumer<Integer>> mOnTrimMemoryListeners;
    public final ReportFullyDrawnExecutor mReportFullyDrawnExecutor;
    public final SavedStateRegistryController mSavedStateRegistryController;
    private ViewModelStore mViewModelStore;

    public interface ReportFullyDrawnExecutor extends Executor {
        void m(View view);

        void s();
    }

    public class a extends ActivityResultRegistry {

        /* renamed from: androidx.activity.ComponentActivity$a$a  reason: collision with other inner class name */
        public class C0001a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ int f3614b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ ActivityResultContract.a f3615c;

            public C0001a(int i11, ActivityResultContract.a aVar) {
                this.f3614b = i11;
                this.f3615c = aVar;
            }

            public void run() {
                a.this.c(this.f3614b, this.f3615c.a());
            }
        }

        public class b implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ int f3617b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ IntentSender.SendIntentException f3618c;

            public b(int i11, IntentSender.SendIntentException sendIntentException) {
                this.f3617b = i11;
                this.f3618c = sendIntentException;
            }

            public void run() {
                a.this.b(this.f3617b, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", this.f3618c));
            }
        }

        public a() {
        }

        public <I, O> void f(int i11, ActivityResultContract<I, O> activityResultContract, I i12, p0.c cVar) {
            ComponentActivity componentActivity = ComponentActivity.this;
            ActivityResultContract.a<O> synchronousResult = activityResultContract.getSynchronousResult(componentActivity, i12);
            if (synchronousResult != null) {
                new Handler(Looper.getMainLooper()).post(new C0001a(i11, synchronousResult));
                return;
            }
            Intent createIntent = activityResultContract.createIntent(componentActivity, i12);
            Bundle bundle = null;
            if (createIntent.getExtras() != null && createIntent.getExtras().getClassLoader() == null) {
                createIntent.setExtrasClassLoader(componentActivity.getClassLoader());
            }
            if (createIntent.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
                bundle = createIntent.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                createIntent.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            } else if (cVar != null) {
                bundle = cVar.b();
            }
            Bundle bundle2 = bundle;
            if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(createIntent.getAction())) {
                String[] stringArrayExtra = createIntent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                if (stringArrayExtra == null) {
                    stringArrayExtra = new String[0];
                }
                ActivityCompat.requestPermissions(componentActivity, stringArrayExtra, i11);
            } else if ("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(createIntent.getAction())) {
                IntentSenderRequest intentSenderRequest = (IntentSenderRequest) createIntent.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
                try {
                    ActivityCompat.startIntentSenderForResult(componentActivity, intentSenderRequest.getIntentSender(), i11, intentSenderRequest.getFillInIntent(), intentSenderRequest.getFlagsMask(), intentSenderRequest.getFlagsValues(), 0, bundle2);
                } catch (IntentSender.SendIntentException e11) {
                    new Handler(Looper.getMainLooper()).post(new b(i11, e11));
                }
            } else {
                ActivityCompat.startActivityForResult(componentActivity, createIntent, i11, bundle2);
            }
        }
    }

    public class b implements r {
        public b() {
        }

        public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            if (event == Lifecycle.Event.ON_STOP) {
                Window window = ComponentActivity.this.getWindow();
                View peekDecorView = window != null ? window.peekDecorView() : null;
                if (peekDecorView != null) {
                    g.a(peekDecorView);
                }
            }
        }
    }

    public class c implements r {
        public c() {
        }

        public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            if (event == Lifecycle.Event.ON_DESTROY) {
                ComponentActivity.this.mContextAwareHelper.b();
                if (!ComponentActivity.this.isChangingConfigurations()) {
                    ComponentActivity.this.getViewModelStore().a();
                }
                ComponentActivity.this.mReportFullyDrawnExecutor.s();
            }
        }
    }

    public class d implements r {
        public d() {
        }

        public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            ComponentActivity.this.ensureViewModelStore();
            ComponentActivity.this.getLifecycle().d(this);
        }
    }

    public class e implements Runnable {
        public e() {
        }

        public void run() {
            try {
                ComponentActivity.super.onBackPressed();
            } catch (IllegalStateException e11) {
                if (!TextUtils.equals(e11.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                    throw e11;
                }
            } catch (NullPointerException e12) {
                if (!TextUtils.equals(e12.getMessage(), "Attempt to invoke virtual method 'android.os.Handler android.app.FragmentHostCallback.getHandler()' on a null object reference")) {
                    throw e12;
                }
            }
        }
    }

    public class f implements r {
        public f() {
        }

        public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            if (event == Lifecycle.Event.ON_CREATE && Build.VERSION.SDK_INT >= 33) {
                ComponentActivity.this.mOnBackPressedDispatcher.o(h.a((ComponentActivity) lifecycleOwner));
            }
        }
    }

    public static class g {
        public static void a(View view) {
            view.cancelPendingInputEvents();
        }
    }

    public static class h {
        public static OnBackInvokedDispatcher a(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }
    }

    public static final class i {

        /* renamed from: a  reason: collision with root package name */
        public Object f3625a;

        /* renamed from: b  reason: collision with root package name */
        public ViewModelStore f3626b;
    }

    public class j implements ReportFullyDrawnExecutor, ViewTreeObserver.OnDrawListener, Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final long f3627b = (SystemClock.uptimeMillis() + 10000);

        /* renamed from: c  reason: collision with root package name */
        public Runnable f3628c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f3629d = false;

        public j() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b() {
            Runnable runnable = this.f3628c;
            if (runnable != null) {
                runnable.run();
                this.f3628c = null;
            }
        }

        public void execute(Runnable runnable) {
            this.f3628c = runnable;
            View decorView = ComponentActivity.this.getWindow().getDecorView();
            if (!this.f3629d) {
                decorView.postOnAnimation(new i(this));
            } else if (Looper.myLooper() == Looper.getMainLooper()) {
                decorView.invalidate();
            } else {
                decorView.postInvalidate();
            }
        }

        public void m(View view) {
            if (!this.f3629d) {
                this.f3629d = true;
                view.getViewTreeObserver().addOnDrawListener(this);
            }
        }

        public void onDraw() {
            Runnable runnable = this.f3628c;
            if (runnable != null) {
                runnable.run();
                this.f3628c = null;
                if (ComponentActivity.this.mFullyDrawnReporter.d()) {
                    this.f3629d = false;
                    ComponentActivity.this.getWindow().getDecorView().post(this);
                }
            } else if (SystemClock.uptimeMillis() > this.f3627b) {
                this.f3629d = false;
                ComponentActivity.this.getWindow().getDecorView().post(this);
            }
        }

        public void run() {
            ComponentActivity.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }

        public void s() {
            ComponentActivity.this.getWindow().getDecorView().removeCallbacks(this);
            ComponentActivity.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }
    }

    public static class k implements ReportFullyDrawnExecutor {

        /* renamed from: b  reason: collision with root package name */
        public final Handler f3631b = a();

        public final Handler a() {
            Looper myLooper = Looper.myLooper();
            if (myLooper == null) {
                myLooper = Looper.getMainLooper();
            }
            return new Handler(myLooper);
        }

        public void execute(Runnable runnable) {
            this.f3631b.postAtFrontOfQueue(runnable);
        }

        public void m(View view) {
        }

        public void s() {
        }
    }

    public ComponentActivity() {
        this.mContextAwareHelper = new ContextAwareHelper();
        this.mMenuHostHelper = new MenuHostHelper(new h(this));
        this.mLifecycleRegistry = new LifecycleRegistry(this);
        SavedStateRegistryController a11 = SavedStateRegistryController.a(this);
        this.mSavedStateRegistryController = a11;
        this.mOnBackPressedDispatcher = null;
        ReportFullyDrawnExecutor createFullyDrawnExecutor = createFullyDrawnExecutor();
        this.mReportFullyDrawnExecutor = createFullyDrawnExecutor;
        this.mFullyDrawnReporter = new FullyDrawnReporter(createFullyDrawnExecutor, new g(this));
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mActivityResultRegistry = new a();
        this.mOnConfigurationChangedListeners = new CopyOnWriteArrayList<>();
        this.mOnTrimMemoryListeners = new CopyOnWriteArrayList<>();
        this.mOnNewIntentListeners = new CopyOnWriteArrayList<>();
        this.mOnMultiWindowModeChangedListeners = new CopyOnWriteArrayList<>();
        this.mOnPictureInPictureModeChangedListeners = new CopyOnWriteArrayList<>();
        this.mDispatchingOnMultiWindowModeChanged = false;
        this.mDispatchingOnPictureInPictureModeChanged = false;
        if (getLifecycle() != null) {
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 19) {
                getLifecycle().a(new b());
            }
            getLifecycle().a(new c());
            getLifecycle().a(new d());
            a11.c();
            h0.c(this);
            if (19 <= i11 && i11 <= 23) {
                getLifecycle().a(new n(this));
            }
            getSavedStateRegistry().h(ACTIVITY_RESULT_TAG, new f(this));
            addOnContextAvailableListener(new e(this));
            return;
        }
        throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
    }

    private ReportFullyDrawnExecutor createFullyDrawnExecutor() {
        if (Build.VERSION.SDK_INT < 16) {
            return new k();
        }
        return new j();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit lambda$new$0() {
        reportFullyDrawn();
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Bundle lambda$new$1() {
        Bundle bundle = new Bundle();
        this.mActivityResultRegistry.h(bundle);
        return bundle;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2(Context context) {
        Bundle b11 = getSavedStateRegistry().b(ACTIVITY_RESULT_TAG);
        if (b11 != null) {
            this.mActivityResultRegistry.g(b11);
        }
    }

    public void addContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.m(getWindow().getDecorView());
        super.addContentView(view, layoutParams);
    }

    public void addMenuProvider(MenuProvider menuProvider) {
        this.mMenuHostHelper.c(menuProvider);
    }

    public final void addOnConfigurationChangedListener(Consumer<Configuration> consumer) {
        this.mOnConfigurationChangedListeners.add(consumer);
    }

    public final void addOnContextAvailableListener(OnContextAvailableListener onContextAvailableListener) {
        this.mContextAwareHelper.a(onContextAvailableListener);
    }

    public final void addOnMultiWindowModeChangedListener(Consumer<p0.i> consumer) {
        this.mOnMultiWindowModeChangedListeners.add(consumer);
    }

    public final void addOnNewIntentListener(Consumer<Intent> consumer) {
        this.mOnNewIntentListeners.add(consumer);
    }

    public final void addOnPictureInPictureModeChangedListener(Consumer<p> consumer) {
        this.mOnPictureInPictureModeChangedListeners.add(consumer);
    }

    public final void addOnTrimMemoryListener(Consumer<Integer> consumer) {
        this.mOnTrimMemoryListeners.add(consumer);
    }

    public void ensureViewModelStore() {
        if (this.mViewModelStore == null) {
            i iVar = (i) getLastNonConfigurationInstance();
            if (iVar != null) {
                this.mViewModelStore = iVar.f3626b;
            }
            if (this.mViewModelStore == null) {
                this.mViewModelStore = new ViewModelStore();
            }
        }
    }

    public final ActivityResultRegistry getActivityResultRegistry() {
        return this.mActivityResultRegistry;
    }

    public CreationExtras getDefaultViewModelCreationExtras() {
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras();
        if (getApplication() != null) {
            mutableCreationExtras.c(ViewModelProvider.AndroidViewModelFactory.f9964h, getApplication());
        }
        mutableCreationExtras.c(h0.f10007a, this);
        mutableCreationExtras.c(h0.f10008b, this);
        if (!(getIntent() == null || getIntent().getExtras() == null)) {
            mutableCreationExtras.c(h0.f10009c, getIntent().getExtras());
        }
        return mutableCreationExtras;
    }

    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        if (this.mDefaultFactory == null) {
            this.mDefaultFactory = new SavedStateViewModelFactory(getApplication(), this, getIntent() != null ? getIntent().getExtras() : null);
        }
        return this.mDefaultFactory;
    }

    public FullyDrawnReporter getFullyDrawnReporter() {
        return this.mFullyDrawnReporter;
    }

    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        i iVar = (i) getLastNonConfigurationInstance();
        if (iVar != null) {
            return iVar.f3625a;
        }
        return null;
    }

    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        if (this.mOnBackPressedDispatcher == null) {
            this.mOnBackPressedDispatcher = new OnBackPressedDispatcher(new e());
            getLifecycle().a(new f());
        }
        return this.mOnBackPressedDispatcher;
    }

    public final SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.b();
    }

    public ViewModelStore getViewModelStore() {
        if (getApplication() != null) {
            ensureViewModelStore();
            return this.mViewModelStore;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    public void initializeViewTreeOwners() {
        r0.a(getWindow().getDecorView(), this);
        s0.a(getWindow().getDecorView(), this);
        androidx.savedstate.d.a(getWindow().getDecorView(), this);
        w.a(getWindow().getDecorView(), this);
        v.a(getWindow().getDecorView(), this);
    }

    public void invalidateMenu() {
        invalidateOptionsMenu();
    }

    @Deprecated
    public void onActivityResult(int i11, int i12, Intent intent) {
        if (!this.mActivityResultRegistry.b(i11, i12, intent)) {
            super.onActivityResult(i11, i12, intent);
        }
    }

    @Deprecated
    public void onBackPressed() {
        getOnBackPressedDispatcher().l();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Iterator<Consumer<Configuration>> it2 = this.mOnConfigurationChangedListeners.iterator();
        while (it2.hasNext()) {
            it2.next().accept(configuration);
        }
    }

    public void onCreate(Bundle bundle) {
        this.mSavedStateRegistryController.d(bundle);
        this.mContextAwareHelper.c(this);
        super.onCreate(bundle);
        ReportFragment.e(this);
        int i11 = this.mContentLayoutId;
        if (i11 != 0) {
            setContentView(i11);
        }
    }

    public boolean onCreatePanelMenu(int i11, Menu menu) {
        if (i11 != 0) {
            return true;
        }
        super.onCreatePanelMenu(i11, menu);
        this.mMenuHostHelper.h(menu, getMenuInflater());
        return true;
    }

    public boolean onMenuItemSelected(int i11, MenuItem menuItem) {
        if (super.onMenuItemSelected(i11, menuItem)) {
            return true;
        }
        if (i11 == 0) {
            return this.mMenuHostHelper.j(menuItem);
        }
        return false;
    }

    public void onMultiWindowModeChanged(boolean z11) {
        if (!this.mDispatchingOnMultiWindowModeChanged) {
            Iterator<Consumer<p0.i>> it2 = this.mOnMultiWindowModeChangedListeners.iterator();
            while (it2.hasNext()) {
                it2.next().accept(new p0.i(z11));
            }
        }
    }

    public void onNewIntent(@SuppressLint({"UnknownNullness", "MissingNullability"}) Intent intent) {
        super.onNewIntent(intent);
        Iterator<Consumer<Intent>> it2 = this.mOnNewIntentListeners.iterator();
        while (it2.hasNext()) {
            it2.next().accept(intent);
        }
    }

    public void onPanelClosed(int i11, Menu menu) {
        this.mMenuHostHelper.i(menu);
        super.onPanelClosed(i11, menu);
    }

    public void onPictureInPictureModeChanged(boolean z11) {
        if (!this.mDispatchingOnPictureInPictureModeChanged) {
            Iterator<Consumer<p>> it2 = this.mOnPictureInPictureModeChangedListeners.iterator();
            while (it2.hasNext()) {
                it2.next().accept(new p(z11));
            }
        }
    }

    public boolean onPreparePanel(int i11, View view, Menu menu) {
        if (i11 != 0) {
            return true;
        }
        super.onPreparePanel(i11, view, menu);
        this.mMenuHostHelper.k(menu);
        return true;
    }

    @Deprecated
    public void onRequestPermissionsResult(int i11, String[] strArr, int[] iArr) {
        if (!this.mActivityResultRegistry.b(i11, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr)) && Build.VERSION.SDK_INT >= 23) {
            super.onRequestPermissionsResult(i11, strArr, iArr);
        }
    }

    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    public final Object onRetainNonConfigurationInstance() {
        i iVar;
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        ViewModelStore viewModelStore = this.mViewModelStore;
        if (viewModelStore == null && (iVar = (i) getLastNonConfigurationInstance()) != null) {
            viewModelStore = iVar.f3626b;
        }
        if (viewModelStore == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        i iVar2 = new i();
        iVar2.f3625a = onRetainCustomNonConfigurationInstance;
        iVar2.f3626b = viewModelStore;
        return iVar2;
    }

    public void onSaveInstanceState(Bundle bundle) {
        Lifecycle lifecycle = getLifecycle();
        if (lifecycle instanceof LifecycleRegistry) {
            ((LifecycleRegistry) lifecycle).o(Lifecycle.State.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.e(bundle);
    }

    public void onTrimMemory(int i11) {
        super.onTrimMemory(i11);
        Iterator<Consumer<Integer>> it2 = this.mOnTrimMemoryListeners.iterator();
        while (it2.hasNext()) {
            it2.next().accept(Integer.valueOf(i11));
        }
    }

    public Context peekAvailableContext() {
        return this.mContextAwareHelper.d();
    }

    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(ActivityResultContract<I, O> activityResultContract, ActivityResultRegistry activityResultRegistry, ActivityResultCallback<O> activityResultCallback) {
        return activityResultRegistry.j("activity_rq#" + this.mNextLocalRequestCode.getAndIncrement(), this, activityResultContract, activityResultCallback);
    }

    public void removeMenuProvider(MenuProvider menuProvider) {
        this.mMenuHostHelper.l(menuProvider);
    }

    public final void removeOnConfigurationChangedListener(Consumer<Configuration> consumer) {
        this.mOnConfigurationChangedListeners.remove(consumer);
    }

    public final void removeOnContextAvailableListener(OnContextAvailableListener onContextAvailableListener) {
        this.mContextAwareHelper.e(onContextAvailableListener);
    }

    public final void removeOnMultiWindowModeChangedListener(Consumer<p0.i> consumer) {
        this.mOnMultiWindowModeChangedListeners.remove(consumer);
    }

    public final void removeOnNewIntentListener(Consumer<Intent> consumer) {
        this.mOnNewIntentListeners.remove(consumer);
    }

    public final void removeOnPictureInPictureModeChangedListener(Consumer<p> consumer) {
        this.mOnPictureInPictureModeChangedListeners.remove(consumer);
    }

    public final void removeOnTrimMemoryListener(Consumer<Integer> consumer) {
        this.mOnTrimMemoryListeners.remove(consumer);
    }

    public void reportFullyDrawn() {
        try {
            if (u1.a.h()) {
                u1.a.c("reportFullyDrawn() for ComponentActivity");
            }
            int i11 = Build.VERSION.SDK_INT;
            if (i11 > 19) {
                super.reportFullyDrawn();
            } else if (i11 == 19 && ContextCompat.checkSelfPermission(this, "android.permission.UPDATE_DEVICE_STATS") == 0) {
                super.reportFullyDrawn();
            }
            this.mFullyDrawnReporter.c();
        } finally {
            u1.a.f();
        }
    }

    public void setContentView(int i11) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.m(getWindow().getDecorView());
        super.setContentView(i11);
    }

    @Deprecated
    public void startActivityForResult(Intent intent, int i11) {
        super.startActivityForResult(intent, i11);
    }

    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i11, Intent intent, int i12, int i13, int i14) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i11, intent, i12, i13, i14);
    }

    public void addMenuProvider(MenuProvider menuProvider, LifecycleOwner lifecycleOwner) {
        this.mMenuHostHelper.d(menuProvider, lifecycleOwner);
    }

    @Deprecated
    public void startActivityForResult(Intent intent, int i11, Bundle bundle) {
        super.startActivityForResult(intent, i11, bundle);
    }

    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i11, Intent intent, int i12, int i13, int i14, Bundle bundle) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i11, intent, i12, i13, i14, bundle);
    }

    @SuppressLint({"LambdaLast"})
    public void addMenuProvider(MenuProvider menuProvider, LifecycleOwner lifecycleOwner, Lifecycle.State state) {
        this.mMenuHostHelper.e(menuProvider, lifecycleOwner, state);
    }

    /* JADX INFO: finally extract failed */
    public void onMultiWindowModeChanged(boolean z11, Configuration configuration) {
        this.mDispatchingOnMultiWindowModeChanged = true;
        try {
            super.onMultiWindowModeChanged(z11, configuration);
            this.mDispatchingOnMultiWindowModeChanged = false;
            Iterator<Consumer<p0.i>> it2 = this.mOnMultiWindowModeChangedListeners.iterator();
            while (it2.hasNext()) {
                it2.next().accept(new p0.i(z11, configuration));
            }
        } catch (Throwable th2) {
            this.mDispatchingOnMultiWindowModeChanged = false;
            throw th2;
        }
    }

    /* JADX INFO: finally extract failed */
    public void onPictureInPictureModeChanged(boolean z11, Configuration configuration) {
        this.mDispatchingOnPictureInPictureModeChanged = true;
        try {
            super.onPictureInPictureModeChanged(z11, configuration);
            this.mDispatchingOnPictureInPictureModeChanged = false;
            Iterator<Consumer<p>> it2 = this.mOnPictureInPictureModeChangedListeners.iterator();
            while (it2.hasNext()) {
                it2.next().accept(new p(z11, configuration));
            }
        } catch (Throwable th2) {
            this.mDispatchingOnPictureInPictureModeChanged = false;
            throw th2;
        }
    }

    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(ActivityResultContract<I, O> activityResultContract, ActivityResultCallback<O> activityResultCallback) {
        return registerForActivityResult(activityResultContract, this.mActivityResultRegistry, activityResultCallback);
    }

    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.m(getWindow().getDecorView());
        super.setContentView(view);
    }

    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.m(getWindow().getDecorView());
        super.setContentView(view, layoutParams);
    }

    public ComponentActivity(int i11) {
        this();
        this.mContentLayoutId = i11;
    }
}
