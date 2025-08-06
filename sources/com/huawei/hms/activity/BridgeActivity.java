package com.huawei.hms.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.ui.SafeIntent;
import com.huawei.hms.utils.ResolutionFlagUtil;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.hms.utils.UIUtil;
import java.lang.reflect.InvocationTargetException;

public class BridgeActivity extends Activity {
    public static final String EXTRA_DELEGATE_CLASS_NAME = "intent.extra.DELEGATE_CLASS_OBJECT";
    public static final String EXTRA_DELEGATE_UPDATE_INFO = "intent.extra.update.info";
    public static final String EXTRA_INTENT = "intent.extra.intent";
    public static final String EXTRA_IS_FULLSCREEN = "intent.extra.isfullscreen";
    public static final String EXTRA_RESULT = "intent.extra.RESULT";

    /* renamed from: b  reason: collision with root package name */
    private static final int f37665b = a("ro.build.hw_emui_api_level", 0);

    /* renamed from: a  reason: collision with root package name */
    private IBridgeActivityDelegate f37666a;

    public class a implements View.OnApplyWindowInsetsListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f37667a;

        public a(ViewGroup viewGroup) {
            this.f37667a = viewGroup;
        }

        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            try {
                Object invoke = Class.forName("com.huawei.android.view.WindowManagerEx$LayoutParamsEx").getMethod("getDisplaySideRegion", new Class[]{WindowInsets.class}).invoke((Object) null, new Object[]{windowInsets});
                if (invoke == null) {
                    HMSLog.i("BridgeActivity", "sideRegion is null");
                } else {
                    Rect rect = (Rect) Class.forName("com.huawei.android.view.DisplaySideRegionEx").getMethod("getSafeInsets", new Class[0]).invoke(invoke, new Object[0]);
                    ViewGroup viewGroup = this.f37667a;
                    if (viewGroup != null) {
                        viewGroup.setPadding(rect.left, 0, rect.right, 0);
                    }
                }
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e11) {
                HMSLog.e("BridgeActivity", "An exception occurred while reading: onApplyWindowInsets" + e11.getMessage());
            }
            return view.onApplyWindowInsets(windowInsets);
        }
    }

    private static void a(Window window, boolean z11) {
        try {
            window.getClass().getMethod("setHwFloating", new Class[]{Boolean.TYPE}).invoke(window, new Object[]{Boolean.valueOf(z11)});
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException e11) {
            HMSLog.e("BridgeActivity", "In setHwFloating, Failed to call Window.setHwFloating()." + e11.getMessage());
        }
    }

    private boolean b() {
        Intent intent = getIntent();
        if (intent == null) {
            HMSLog.e("BridgeActivity", "In initialize, Must not pass in a null intent.");
            return false;
        }
        if (intent.getBooleanExtra(EXTRA_IS_FULLSCREEN, false)) {
            getWindow().setFlags(1024, 1024);
        }
        try {
            String stringExtra = intent.getStringExtra(EXTRA_DELEGATE_CLASS_NAME);
            if (stringExtra != null) {
                IBridgeActivityDelegate iBridgeActivityDelegate = (IBridgeActivityDelegate) Class.forName(stringExtra).asSubclass(IBridgeActivityDelegate.class).newInstance();
                this.f37666a = iBridgeActivityDelegate;
                try {
                    iBridgeActivityDelegate.onBridgeActivityCreate(this);
                    return true;
                } catch (Throwable th2) {
                    HMSLog.e("BridgeActivity", "onBridgeActivityCreate Exception." + th2.getMessage());
                    return false;
                }
            } else {
                HMSLog.e("BridgeActivity", "In initialize, Must not pass in a null or non class object.");
                return false;
            }
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalStateException | InstantiationException e11) {
            HMSLog.e("BridgeActivity", "In initialize, Failed to create 'IUpdateWizard' instance." + e11.getMessage());
            return false;
        } catch (Throwable unused) {
            HMSLog.e("BridgeActivity", "In initialize, Failed to create 'IUpdateWizard' instance, throwable occur.");
            return false;
        }
    }

    private void c() {
        try {
            requestWindowFeature(1);
        } catch (Exception e11) {
            HMSLog.w("BridgeActivity", "requestWindowFeature " + e11.getMessage());
        }
        Window window = getWindow();
        if (f37665b >= 9) {
            window.addFlags(67108864);
            a(window, true);
        }
        window.getDecorView().setSystemUiVisibility(0);
    }

    public static Intent getIntentStartBridgeActivity(Activity activity, String str) {
        Intent intent = new Intent(activity, BridgeActivity.class);
        intent.putExtra(EXTRA_DELEGATE_CLASS_NAME, str);
        intent.putExtra(EXTRA_IS_FULLSCREEN, UIUtil.isActivityFullscreen(activity));
        return intent;
    }

    public static void setFullScreenWindowLayoutInDisplayCutout(Window window) {
        if (window != null) {
            if (Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                window.setAttributes(attributes);
                window.getDecorView().setSystemUiVisibility(1280);
                return;
            }
            WindowManager.LayoutParams attributes2 = window.getAttributes();
            try {
                Class<?> cls = Class.forName("com.huawei.android.view.LayoutParamsEx");
                Object newInstance = cls.getConstructor(new Class[]{WindowManager.LayoutParams.class}).newInstance(new Object[]{attributes2});
                cls.getMethod("addHwFlags", new Class[]{Integer.TYPE}).invoke(newInstance, new Object[]{65536});
            } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
                HMSLog.e("BridgeActivity", "com.huawei.android.view.LayoutParamsEx fail");
            }
        }
    }

    public void finish() {
        HMSLog.i("BridgeActivity", "Enter finish.");
        super.finish();
    }

    public Intent getIntent() {
        Intent modifyIntentBehaviorsSafe = UIUtil.modifyIntentBehaviorsSafe(super.getIntent());
        if (modifyIntentBehaviorsSafe != null) {
            return new SafeIntent(modifyIntentBehaviorsSafe);
        }
        return null;
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        SafeIntent safeIntent = new SafeIntent(intent);
        super.onActivityResult(i11, i12, safeIntent);
        IBridgeActivityDelegate iBridgeActivityDelegate = this.f37666a;
        if (iBridgeActivityDelegate != null) {
            boolean z11 = false;
            try {
                z11 = iBridgeActivityDelegate.onBridgeActivityResult(i11, i12, safeIntent);
            } catch (Throwable unused) {
                HMSLog.w("BridgeActivity", "onBridgeActivityResult failed, throwable occur.");
            }
            if (!z11 && !isFinishing()) {
                setResult(i12, UIUtil.modifyIntentBehaviorsSafe(safeIntent));
                finish();
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        IBridgeActivityDelegate iBridgeActivityDelegate = this.f37666a;
        if (iBridgeActivityDelegate != null) {
            iBridgeActivityDelegate.onBridgeConfigurationChanged();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        HMSLog.i("BridgeActivity", "BridgeActivity onCreate");
        if (getIntent() == null) {
            setResult(1, (Intent) null);
            finish();
            return;
        }
        getWindow().addFlags(Integer.MIN_VALUE);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(0);
        }
        c();
        a();
        if (ResourceLoaderUtil.getmContext() == null) {
            ResourceLoaderUtil.setmContext(getApplicationContext());
        }
        setFullScreenWindowLayoutInDisplayCutout(getWindow());
        if (!b()) {
            setResult(1, (Intent) null);
            finish();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        try {
            ResolutionFlagUtil.getInstance().removeResolutionFlag(new SafeIntent(getIntent()).getStringExtra("transaction_id"));
        } catch (Throwable th2) {
            HMSLog.w("BridgeActivity", "get transaction_id from intent fail: " + th2.getClass().getSimpleName());
        }
        IBridgeActivityDelegate iBridgeActivityDelegate = this.f37666a;
        if (iBridgeActivityDelegate != null) {
            iBridgeActivityDelegate.onBridgeActivityDestroy();
        }
        HMSLog.i("BridgeActivity", "BridgeActivity onDestroy");
    }

    public boolean onKeyUp(int i11, KeyEvent keyEvent) {
        IBridgeActivityDelegate iBridgeActivityDelegate = this.f37666a;
        if (iBridgeActivityDelegate != null) {
            iBridgeActivityDelegate.onKeyUp(i11, keyEvent);
        }
        return super.onKeyUp(i11, keyEvent);
    }

    private void a() {
        View findViewById = getWindow().findViewById(16908290);
        if (findViewById == null || !(findViewById instanceof ViewGroup)) {
            HMSLog.e("BridgeActivity", "rootView is null or not ViewGroup");
            return;
        }
        ViewGroup viewGroup = (ViewGroup) findViewById;
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        try {
            Class<?> cls = Class.forName("com.huawei.android.view.WindowManagerEx$LayoutParamsEx");
            Object newInstance = cls.getDeclaredConstructor(new Class[]{WindowManager.LayoutParams.class}).newInstance(new Object[]{attributes});
            cls.getMethod("setDisplaySideMode", new Class[]{Integer.TYPE}).invoke(newInstance, new Object[]{1});
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e11) {
            HMSLog.e("BridgeActivity", "An exception occurred while reading: setDisplaySideMode" + e11.getMessage());
        }
        if (Build.VERSION.SDK_INT >= 20) {
            getWindow().getDecorView().setOnApplyWindowInsetsListener(new a(viewGroup));
        }
    }

    public static Intent getIntentStartBridgeActivity(Context context, String str) {
        Intent intent = new Intent(context, BridgeActivity.class);
        intent.putExtra(EXTRA_DELEGATE_CLASS_NAME, str);
        intent.putExtra(EXTRA_IS_FULLSCREEN, false);
        return intent;
    }

    private static int a(String str, int i11) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return ((Integer) cls.getDeclaredMethod("getInt", new Class[]{String.class, Integer.TYPE}).invoke(cls, new Object[]{str, Integer.valueOf(i11)})).intValue();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException unused) {
            HMSLog.e("BridgeActivity", "An exception occurred while reading: EMUI_SDK_INT");
            return i11;
        }
    }
}
