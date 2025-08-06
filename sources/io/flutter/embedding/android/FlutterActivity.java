package io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedCallback;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import io.flutter.Log;
import io.flutter.embedding.android.FlutterActivityAndFragmentDelegate;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.embedding.engine.plugins.util.GeneratedPluginRegister;
import io.flutter.plugin.platform.PlatformPlugin;
import io.flutter.util.ViewUtils;
import java.util.ArrayList;
import java.util.List;

public class FlutterActivity extends Activity implements FlutterActivityAndFragmentDelegate.Host, LifecycleOwner {
    public static final int FLUTTER_VIEW_ID = ViewUtils.generateViewId(61938);
    private static final String TAG = "FlutterActivity";
    public FlutterActivityAndFragmentDelegate delegate;
    private LifecycleRegistry lifecycle;
    private final OnBackInvokedCallback onBackInvokedCallback;

    public static class CachedEngineIntentBuilder {
        private final Class<? extends FlutterActivity> activityClass;
        private String backgroundMode = FlutterActivityLaunchConfigs.DEFAULT_BACKGROUND_MODE;
        private final String cachedEngineId;
        private boolean destroyEngineWithActivity = false;

        public CachedEngineIntentBuilder(Class<? extends FlutterActivity> cls, String str) {
            this.activityClass = cls;
            this.cachedEngineId = str;
        }

        public CachedEngineIntentBuilder backgroundMode(FlutterActivityLaunchConfigs.BackgroundMode backgroundMode2) {
            this.backgroundMode = backgroundMode2.name();
            return this;
        }

        public Intent build(Context context) {
            return new Intent(context, this.activityClass).putExtra("cached_engine_id", this.cachedEngineId).putExtra(FlutterActivityLaunchConfigs.EXTRA_DESTROY_ENGINE_WITH_ACTIVITY, this.destroyEngineWithActivity).putExtra(FlutterActivityLaunchConfigs.EXTRA_BACKGROUND_MODE, this.backgroundMode);
        }

        public CachedEngineIntentBuilder destroyEngineWithActivity(boolean z11) {
            this.destroyEngineWithActivity = z11;
            return this;
        }
    }

    public static class NewEngineIntentBuilder {
        private final Class<? extends FlutterActivity> activityClass;
        private String backgroundMode = FlutterActivityLaunchConfigs.DEFAULT_BACKGROUND_MODE;
        private List<String> dartEntrypointArgs;
        private String initialRoute = "/";

        public NewEngineIntentBuilder(Class<? extends FlutterActivity> cls) {
            this.activityClass = cls;
        }

        public NewEngineIntentBuilder backgroundMode(FlutterActivityLaunchConfigs.BackgroundMode backgroundMode2) {
            this.backgroundMode = backgroundMode2.name();
            return this;
        }

        public Intent build(Context context) {
            Intent putExtra = new Intent(context, this.activityClass).putExtra(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, this.initialRoute).putExtra(FlutterActivityLaunchConfigs.EXTRA_BACKGROUND_MODE, this.backgroundMode).putExtra(FlutterActivityLaunchConfigs.EXTRA_DESTROY_ENGINE_WITH_ACTIVITY, true);
            if (this.dartEntrypointArgs != null) {
                putExtra.putExtra("dart_entrypoint_args", new ArrayList(this.dartEntrypointArgs));
            }
            return putExtra;
        }

        public NewEngineIntentBuilder dartEntrypointArgs(List<String> list) {
            this.dartEntrypointArgs = list;
            return this;
        }

        public NewEngineIntentBuilder initialRoute(String str) {
            this.initialRoute = str;
            return this;
        }
    }

    public FlutterActivity() {
        this.onBackInvokedCallback = Build.VERSION.SDK_INT >= 33 ? new OnBackInvokedCallback() {
            public void onBackInvoked() {
                FlutterActivity.this.onBackPressed();
            }
        } : null;
        this.lifecycle = new LifecycleRegistry(this);
    }

    private void configureStatusBarForFullscreenFlutterExperience() {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(1073741824);
            window.getDecorView().setSystemUiVisibility(1280);
        }
    }

    private void configureWindowForTransparency() {
        if (getBackgroundMode() == FlutterActivityLaunchConfigs.BackgroundMode.transparent) {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    public static Intent createDefaultIntent(Context context) {
        return withNewEngine().build(context);
    }

    private View createFlutterView() {
        return this.delegate.onCreateView((LayoutInflater) null, (ViewGroup) null, (Bundle) null, FLUTTER_VIEW_ID, getRenderMode() == RenderMode.surface);
    }

    private Drawable getSplashScreenFromManifest() {
        try {
            Bundle metaData = getMetaData();
            int i11 = metaData != null ? metaData.getInt(FlutterActivityLaunchConfigs.SPLASH_SCREEN_META_DATA_KEY) : 0;
            if (i11 != 0) {
                return ResourcesCompat.f(getResources(), i11, getTheme());
            }
            return null;
        } catch (Resources.NotFoundException e11) {
            Log.e(TAG, "Splash screen not found. Ensure the drawable exists and that it's valid.");
            throw e11;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private boolean isDebuggable() {
        return (getApplicationInfo().flags & 2) != 0;
    }

    private boolean stillAttachedForEvent(String str) {
        FlutterActivityAndFragmentDelegate flutterActivityAndFragmentDelegate = this.delegate;
        if (flutterActivityAndFragmentDelegate == null) {
            Log.w(TAG, "FlutterActivity " + hashCode() + " " + str + " called after release.");
            return false;
        } else if (flutterActivityAndFragmentDelegate.isAttached()) {
            return true;
        } else {
            Log.w(TAG, "FlutterActivity " + hashCode() + " " + str + " called after detach.");
            return false;
        }
    }

    private void switchLaunchThemeForNormalTheme() {
        try {
            Bundle metaData = getMetaData();
            if (metaData != null) {
                int i11 = metaData.getInt(FlutterActivityLaunchConfigs.NORMAL_THEME_META_DATA_KEY, -1);
                if (i11 != -1) {
                    setTheme(i11);
                    return;
                }
                return;
            }
            Log.v(TAG, "Using the launch theme as normal theme.");
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e(TAG, "Could not read meta-data for FlutterActivity. Using the launch theme as normal theme.");
        }
    }

    public static CachedEngineIntentBuilder withCachedEngine(String str) {
        return new CachedEngineIntentBuilder(FlutterActivity.class, str);
    }

    public static NewEngineIntentBuilder withNewEngine() {
        return new NewEngineIntentBuilder(FlutterActivity.class);
    }

    public void cleanUpFlutterEngine(FlutterEngine flutterEngine) {
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        if (!this.delegate.isFlutterEngineFromHost()) {
            GeneratedPluginRegister.registerGeneratedPlugins(flutterEngine);
        }
    }

    public void detachFromFlutterEngine() {
        Log.w(TAG, "FlutterActivity " + this + " connection to the engine " + getFlutterEngine() + " evicted by another attaching activity");
        FlutterActivityAndFragmentDelegate flutterActivityAndFragmentDelegate = this.delegate;
        if (flutterActivityAndFragmentDelegate != null) {
            flutterActivityAndFragmentDelegate.onDestroyView();
            this.delegate.onDetach();
        }
    }

    public Activity getActivity() {
        return this;
    }

    public String getAppBundlePath() {
        String dataString;
        if (!isDebuggable() || !"android.intent.action.RUN".equals(getIntent().getAction()) || (dataString = getIntent().getDataString()) == null) {
            return null;
        }
        return dataString;
    }

    public FlutterActivityLaunchConfigs.BackgroundMode getBackgroundMode() {
        if (getIntent().hasExtra(FlutterActivityLaunchConfigs.EXTRA_BACKGROUND_MODE)) {
            return FlutterActivityLaunchConfigs.BackgroundMode.valueOf(getIntent().getStringExtra(FlutterActivityLaunchConfigs.EXTRA_BACKGROUND_MODE));
        }
        return FlutterActivityLaunchConfigs.BackgroundMode.opaque;
    }

    public String getCachedEngineId() {
        return getIntent().getStringExtra("cached_engine_id");
    }

    public Context getContext() {
        return this;
    }

    public List<String> getDartEntrypointArgs() {
        return (List) getIntent().getSerializableExtra("dart_entrypoint_args");
    }

    public String getDartEntrypointFunctionName() {
        try {
            Bundle metaData = getMetaData();
            String string = metaData != null ? metaData.getString(FlutterActivityLaunchConfigs.DART_ENTRYPOINT_META_DATA_KEY) : null;
            if (string != null) {
                return string;
            }
            return FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT;
        } catch (PackageManager.NameNotFoundException unused) {
            return FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT;
        }
    }

    public String getDartEntrypointLibraryUri() {
        try {
            Bundle metaData = getMetaData();
            if (metaData != null) {
                return metaData.getString(FlutterActivityLaunchConfigs.DART_ENTRYPOINT_URI_META_DATA_KEY);
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public ExclusiveAppComponent<Activity> getExclusiveAppComponent() {
        return this.delegate;
    }

    public FlutterEngine getFlutterEngine() {
        return this.delegate.getFlutterEngine();
    }

    public FlutterShellArgs getFlutterShellArgs() {
        return FlutterShellArgs.fromIntent(getIntent());
    }

    public String getInitialRoute() {
        if (getIntent().hasExtra(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE)) {
            return getIntent().getStringExtra(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE);
        }
        try {
            Bundle metaData = getMetaData();
            if (metaData != null) {
                return metaData.getString(FlutterActivityLaunchConfigs.INITIAL_ROUTE_META_DATA_KEY);
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public Lifecycle getLifecycle() {
        return this.lifecycle;
    }

    public Bundle getMetaData() throws PackageManager.NameNotFoundException {
        return getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
    }

    public RenderMode getRenderMode() {
        return getBackgroundMode() == FlutterActivityLaunchConfigs.BackgroundMode.opaque ? RenderMode.surface : RenderMode.texture;
    }

    public TransparencyMode getTransparencyMode() {
        if (getBackgroundMode() == FlutterActivityLaunchConfigs.BackgroundMode.opaque) {
            return TransparencyMode.opaque;
        }
        return TransparencyMode.transparent;
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        if (stillAttachedForEvent("onActivityResult")) {
            this.delegate.onActivityResult(i11, i12, intent);
        }
    }

    public void onBackPressed() {
        if (stillAttachedForEvent("onBackPressed")) {
            this.delegate.onBackPressed();
        }
    }

    public void onCreate(Bundle bundle) {
        switchLaunchThemeForNormalTheme();
        super.onCreate(bundle);
        FlutterActivityAndFragmentDelegate flutterActivityAndFragmentDelegate = new FlutterActivityAndFragmentDelegate(this);
        this.delegate = flutterActivityAndFragmentDelegate;
        flutterActivityAndFragmentDelegate.onAttach(this);
        this.delegate.onRestoreInstanceState(bundle);
        this.lifecycle.i(Lifecycle.Event.ON_CREATE);
        registerOnBackInvokedCallback();
        configureWindowForTransparency();
        setContentView(createFlutterView());
        configureStatusBarForFullscreenFlutterExperience();
    }

    public void onDestroy() {
        super.onDestroy();
        if (stillAttachedForEvent("onDestroy")) {
            this.delegate.onDestroyView();
            this.delegate.onDetach();
        }
        release();
        this.lifecycle.i(Lifecycle.Event.ON_DESTROY);
    }

    public void onFlutterSurfaceViewCreated(FlutterSurfaceView flutterSurfaceView) {
    }

    public void onFlutterTextureViewCreated(FlutterTextureView flutterTextureView) {
    }

    public void onFlutterUiDisplayed() {
        if (Build.VERSION.SDK_INT >= 29) {
            reportFullyDrawn();
        }
    }

    public void onFlutterUiNoLongerDisplayed() {
    }

    public void onNewIntent(Intent intent) {
        PushAutoTrackHelper.onNewIntent(this, intent);
        super.onNewIntent(intent);
        if (stillAttachedForEvent("onNewIntent")) {
            this.delegate.onNewIntent(intent);
        }
    }

    public void onPause() {
        super.onPause();
        if (stillAttachedForEvent("onPause")) {
            this.delegate.onPause();
        }
        this.lifecycle.i(Lifecycle.Event.ON_PAUSE);
    }

    public void onPostResume() {
        super.onPostResume();
        if (stillAttachedForEvent("onPostResume")) {
            this.delegate.onPostResume();
        }
    }

    public void onRequestPermissionsResult(int i11, String[] strArr, int[] iArr) {
        if (stillAttachedForEvent("onRequestPermissionsResult")) {
            this.delegate.onRequestPermissionsResult(i11, strArr, iArr);
        }
    }

    public void onResume() {
        super.onResume();
        this.lifecycle.i(Lifecycle.Event.ON_RESUME);
        if (stillAttachedForEvent("onResume")) {
            this.delegate.onResume();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (stillAttachedForEvent("onSaveInstanceState")) {
            this.delegate.onSaveInstanceState(bundle);
        }
    }

    public void onStart() {
        super.onStart();
        this.lifecycle.i(Lifecycle.Event.ON_START);
        if (stillAttachedForEvent("onStart")) {
            this.delegate.onStart();
        }
    }

    public void onStop() {
        super.onStop();
        if (stillAttachedForEvent("onStop")) {
            this.delegate.onStop();
        }
        this.lifecycle.i(Lifecycle.Event.ON_STOP);
    }

    public void onTrimMemory(int i11) {
        super.onTrimMemory(i11);
        if (stillAttachedForEvent("onTrimMemory")) {
            this.delegate.onTrimMemory(i11);
        }
    }

    public void onUserLeaveHint() {
        if (stillAttachedForEvent("onUserLeaveHint")) {
            this.delegate.onUserLeaveHint();
        }
    }

    public boolean popSystemNavigator() {
        return false;
    }

    public FlutterEngine provideFlutterEngine(Context context) {
        return null;
    }

    public PlatformPlugin providePlatformPlugin(Activity activity, FlutterEngine flutterEngine) {
        return new PlatformPlugin(getActivity(), flutterEngine.getPlatformChannel(), this);
    }

    public SplashScreen provideSplashScreen() {
        Drawable splashScreenFromManifest = getSplashScreenFromManifest();
        if (splashScreenFromManifest != null) {
            return new DrawableSplashScreen(splashScreenFromManifest);
        }
        return null;
    }

    public void registerOnBackInvokedCallback() {
        if (Build.VERSION.SDK_INT >= 33) {
            getOnBackInvokedDispatcher().registerOnBackInvokedCallback(0, this.onBackInvokedCallback);
        }
    }

    public void release() {
        unregisterOnBackInvokedCallback();
        FlutterActivityAndFragmentDelegate flutterActivityAndFragmentDelegate = this.delegate;
        if (flutterActivityAndFragmentDelegate != null) {
            flutterActivityAndFragmentDelegate.release();
            this.delegate = null;
        }
    }

    public void setDelegate(FlutterActivityAndFragmentDelegate flutterActivityAndFragmentDelegate) {
        this.delegate = flutterActivityAndFragmentDelegate;
    }

    public boolean shouldAttachEngineToActivity() {
        return true;
    }

    public boolean shouldDestroyEngineWithHost() {
        boolean booleanExtra = getIntent().getBooleanExtra(FlutterActivityLaunchConfigs.EXTRA_DESTROY_ENGINE_WITH_ACTIVITY, false);
        return (getCachedEngineId() != null || this.delegate.isFlutterEngineFromHost()) ? booleanExtra : getIntent().getBooleanExtra(FlutterActivityLaunchConfigs.EXTRA_DESTROY_ENGINE_WITH_ACTIVITY, true);
    }

    public boolean shouldDispatchAppLifecycleState() {
        return true;
    }

    public boolean shouldHandleDeeplinking() {
        try {
            Bundle metaData = getMetaData();
            if (metaData != null) {
                return metaData.getBoolean(FlutterActivityLaunchConfigs.HANDLE_DEEPLINKING_META_DATA_KEY);
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public boolean shouldRestoreAndSaveState() {
        if (getIntent().hasExtra("enable_state_restoration")) {
            return getIntent().getBooleanExtra("enable_state_restoration", false);
        }
        if (getCachedEngineId() != null) {
            return false;
        }
        return true;
    }

    public void unregisterOnBackInvokedCallback() {
        if (Build.VERSION.SDK_INT >= 33) {
            getOnBackInvokedDispatcher().unregisterOnBackInvokedCallback(this.onBackInvokedCallback);
        }
    }

    public void updateSystemUiOverlays() {
        FlutterActivityAndFragmentDelegate flutterActivityAndFragmentDelegate = this.delegate;
        if (flutterActivityAndFragmentDelegate != null) {
            flutterActivityAndFragmentDelegate.updateSystemUiOverlays();
        }
    }
}
