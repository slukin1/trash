package com.tencent.qcloud.tuicore;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.Pair;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.a;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

class TUIRouter {
    /* access modifiers changed from: private */
    public static final String TAG = "TUIRouter";
    /* access modifiers changed from: private */
    public static final Map<a, ActivityResultLauncher<Pair<Intent, ActivityResultCallback<ActivityResult>>>> activityResultLauncherMap = new WeakHashMap();
    /* access modifiers changed from: private */
    @SuppressLint({"StaticFieldLeak"})
    public static Context context;
    /* access modifiers changed from: private */
    public static boolean initialized = false;
    private static final TUIRouter router = new TUIRouter();
    /* access modifiers changed from: private */
    public static final Map<String, String> routerMap = new HashMap();

    public static class Navigation {
        public String destination;
        public Intent intent = new Intent();
        public Bundle options;

        private void startActivity(Context context, int i11) {
            if (context == null) {
                Log.e(TUIRouter.TAG, "StartActivity failed, context is null.Please init");
                return;
            }
            try {
                if (!(context instanceof Activity) || i11 < 0) {
                    if (!(context instanceof Activity)) {
                        this.intent.addFlags(268435456);
                    }
                    ContextCompat.startActivity(context, this.intent, this.options);
                    return;
                }
                ActivityCompat.startActivityForResult((Activity) context, this.intent, i11, this.options);
            } catch (ActivityNotFoundException e11) {
                e11.printStackTrace();
            }
        }

        public Intent getIntent() {
            return this.intent;
        }

        public void navigate() {
            navigate((Context) null);
        }

        public Navigation putExtra(String str, boolean z11) {
            this.intent.putExtra(str, z11);
            return this;
        }

        public Navigation putExtras(Bundle bundle) {
            if (bundle != null) {
                this.intent.putExtras(bundle);
            }
            return this;
        }

        public Navigation setDestination(String str) {
            String str2 = (String) TUIRouter.routerMap.get(str);
            this.destination = str2;
            if (str2 == null) {
                Log.e(TUIRouter.TAG, "destination is null.");
                return this;
            }
            this.intent.setComponent(new ComponentName(TUIRouter.context, this.destination));
            return this;
        }

        public Navigation setIntent(Intent intent2) {
            this.intent = intent2;
            return this;
        }

        public Navigation setOptions(Bundle bundle) {
            this.options = bundle;
            return this;
        }

        public void navigate(Context context) {
            navigate(context, -1);
        }

        public Navigation putExtra(String str, byte b11) {
            this.intent.putExtra(str, b11);
            return this;
        }

        public Navigation putExtras(Intent intent2) {
            if (intent2 != null) {
                this.intent.putExtras(intent2);
            }
            return this;
        }

        public void navigate(Fragment fragment) {
            navigate(fragment, -1);
        }

        public Navigation putExtra(String str, char c11) {
            this.intent.putExtra(str, c11);
            return this;
        }

        @Deprecated
        public void navigate(Fragment fragment, int i11) {
            if (!TUIRouter.initialized) {
                Log.e(TUIRouter.TAG, "have not initialized.");
                return;
            }
            Intent intent2 = this.intent;
            if (intent2 == null) {
                Log.e(TUIRouter.TAG, "intent is null.");
            } else if (fragment == null) {
                startActivity((Context) null, i11);
            } else if (i11 >= 0) {
                try {
                    fragment.startActivityForResult(intent2, i11);
                } catch (ActivityNotFoundException e11) {
                    e11.printStackTrace();
                }
            } else {
                fragment.startActivity(intent2, this.options);
            }
        }

        public Navigation putExtra(String str, short s11) {
            this.intent.putExtra(str, s11);
            return this;
        }

        public Navigation setDestination(Class<? extends Activity> cls) {
            this.intent.setComponent(new ComponentName(TUIRouter.context, cls));
            return this;
        }

        public Navigation putExtra(String str, int i11) {
            this.intent.putExtra(str, i11);
            return this;
        }

        public Navigation putExtra(String str, long j11) {
            this.intent.putExtra(str, j11);
            return this;
        }

        public Navigation putExtra(String str, float f11) {
            this.intent.putExtra(str, f11);
            return this;
        }

        public Navigation putExtra(String str, double d11) {
            this.intent.putExtra(str, d11);
            return this;
        }

        public Navigation putExtra(String str, String str2) {
            if (str2 != null) {
                this.intent.putExtra(str, str2);
            }
            return this;
        }

        public Navigation putExtra(String str, CharSequence charSequence) {
            if (charSequence != null) {
                this.intent.putExtra(str, charSequence);
            }
            return this;
        }

        public Navigation putExtra(String str, Parcelable parcelable) {
            if (parcelable != null) {
                this.intent.putExtra(str, parcelable);
            }
            return this;
        }

        public void navigate(a aVar, ActivityResultCallback<ActivityResult> activityResultCallback) {
            if (!TUIRouter.initialized) {
                Log.e(TUIRouter.TAG, "have not initialized.");
            } else if (this.intent == null) {
                Log.e(TUIRouter.TAG, "intent is null.");
            } else {
                try {
                    ActivityResultLauncher activityResultLauncher = (ActivityResultLauncher) TUIRouter.activityResultLauncherMap.get(aVar);
                    if (activityResultLauncher != null) {
                        activityResultLauncher.a(Pair.create(this.intent, activityResultCallback));
                    }
                } catch (Exception e11) {
                    String access$400 = TUIRouter.TAG;
                    Log.e(access$400, "start activity failed, " + e11.getLocalizedMessage());
                }
            }
        }

        public Navigation putExtra(String str, Parcelable[] parcelableArr) {
            if (parcelableArr != null) {
                this.intent.putExtra(str, parcelableArr);
            }
            return this;
        }

        public Navigation putExtra(String str, Serializable serializable) {
            if (serializable != null) {
                this.intent.putExtra(str, serializable);
            }
            return this;
        }

        public Navigation putExtra(String str, boolean[] zArr) {
            if (zArr != null) {
                this.intent.putExtra(str, zArr);
            }
            return this;
        }

        public Navigation putExtra(String str, byte[] bArr) {
            if (bArr != null) {
                this.intent.putExtra(str, bArr);
            }
            return this;
        }

        public Navigation putExtra(String str, short[] sArr) {
            if (sArr != null) {
                this.intent.putExtra(str, sArr);
            }
            return this;
        }

        public Navigation putExtra(String str, char[] cArr) {
            if (cArr != null) {
                this.intent.putExtra(str, cArr);
            }
            return this;
        }

        public Navigation putExtra(String str, int[] iArr) {
            if (iArr != null) {
                this.intent.putExtra(str, iArr);
            }
            return this;
        }

        @Deprecated
        public void navigate(Context context, int i11) {
            if (!TUIRouter.initialized) {
                Log.e(TUIRouter.TAG, "have not initialized.");
            } else if (this.intent == null) {
                Log.e(TUIRouter.TAG, "intent is null.");
            } else {
                if (context == null) {
                    context = TUIRouter.context;
                }
                startActivity(context, i11);
            }
        }

        public Navigation putExtra(String str, long[] jArr) {
            if (jArr != null) {
                this.intent.putExtra(str, jArr);
            }
            return this;
        }

        public Navigation putExtra(String str, float[] fArr) {
            if (fArr != null) {
                this.intent.putExtra(str, fArr);
            }
            return this;
        }

        public Navigation putExtra(String str, double[] dArr) {
            if (dArr != null) {
                this.intent.putExtra(str, dArr);
            }
            return this;
        }

        public Navigation putExtra(String str, String[] strArr) {
            if (strArr != null) {
                this.intent.putExtra(str, strArr);
            }
            return this;
        }

        public Navigation putExtra(String str, CharSequence[] charSequenceArr) {
            if (charSequenceArr != null) {
                this.intent.putExtra(str, charSequenceArr);
            }
            return this;
        }

        public Navigation putExtra(String str, Bundle bundle) {
            if (bundle != null) {
                this.intent.putExtra(str, bundle);
            }
            return this;
        }
    }

    public static class RouterActivityResultCallback implements ActivityResultCallback<Pair<ActivityResult, ActivityResultCallback<ActivityResult>>> {
        public void onActivityResult(Pair<ActivityResult, ActivityResultCallback<ActivityResult>> pair) {
            Object obj = pair.second;
            if (obj != null) {
                ((ActivityResultCallback) obj).onActivityResult((ActivityResult) pair.first);
            }
        }
    }

    public static class RouterActivityResultContract extends ActivityResultContract<Pair<Intent, ActivityResultCallback<ActivityResult>>, Pair<ActivityResult, ActivityResultCallback<ActivityResult>>> {
        private ActivityResultCallback<ActivityResult> callback;

        public Intent createIntent(Context context, Pair<Intent, ActivityResultCallback<ActivityResult>> pair) {
            this.callback = (ActivityResultCallback) pair.second;
            return (Intent) pair.first;
        }

        public Pair<ActivityResult, ActivityResultCallback<ActivityResult>> parseResult(int i11, Intent intent) {
            Pair<ActivityResult, ActivityResultCallback<ActivityResult>> create = Pair.create(new ActivityResult(i11, intent), this.callback);
            this.callback = null;
            return create;
        }
    }

    private TUIRouter() {
    }

    public static Context getContext() {
        return context;
    }

    public static TUIRouter getInstance() {
        return router;
    }

    public static synchronized void init(Context context2) {
        synchronized (TUIRouter.class) {
            if (!initialized) {
                context = context2;
                if (context2 == null) {
                    Log.e(TAG, "init failed, context is null.");
                    return;
                }
                initRouter(context2);
                initActivityResultLauncher(context2);
                initialized = true;
            }
        }
    }

    private static void initActivityResultLauncher(Context context2) {
        if (context2 instanceof Application) {
            ((Application) context2).registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
                /* access modifiers changed from: private */
                public void clearLauncher(a aVar) {
                    TUIRouter.activityResultLauncherMap.remove(aVar);
                }

                /* access modifiers changed from: private */
                public void registerForActivityResult(a aVar) {
                    TUIRouter.activityResultLauncherMap.put(aVar, aVar.registerForActivityResult(new RouterActivityResultContract(), new RouterActivityResultCallback()));
                }

                public void onActivityCreated(Activity activity, Bundle bundle) {
                    if (activity instanceof a) {
                        registerForActivityResult((a) activity);
                        if (activity instanceof FragmentActivity) {
                            ((FragmentActivity) activity).getSupportFragmentManager().r1(new FragmentManager.FragmentLifecycleCallbacks() {
                                public void onFragmentCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
                                    if (fragment instanceof a) {
                                        AnonymousClass1.this.registerForActivityResult(fragment);
                                    }
                                }

                                public void onFragmentDestroyed(FragmentManager fragmentManager, Fragment fragment) {
                                    if (fragment instanceof a) {
                                        AnonymousClass1.this.clearLauncher(fragment);
                                    }
                                }
                            }, true);
                        }
                    }
                }

                public void onActivityDestroyed(Activity activity) {
                    if (activity instanceof a) {
                        clearLauncher((a) activity);
                    }
                }

                public void onActivityPaused(Activity activity) {
                }

                public void onActivityResumed(Activity activity) {
                }

                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                }

                public void onActivityStarted(Activity activity) {
                }

                public void onActivityStopped(Activity activity) {
                }
            });
        }
    }

    public static void initRouter(Context context2) {
        ActivityInfo[] activityInfoArr;
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            activityInfoArr = context2.getPackageManager().getPackageInfo(context2.getPackageName(), 1).activities;
        } catch (PackageManager.NameNotFoundException e11) {
            e11.printStackTrace();
            activityInfoArr = null;
        }
        if (activityInfoArr != null) {
            for (ActivityInfo activityInfo : activityInfoArr) {
                arrayList.add(activityInfo.name);
            }
        }
        for (String str : arrayList) {
            String[] split = str.split("\\.");
            routerMap.put(split[split.length - 1], str);
        }
    }

    @Deprecated
    public static void startActivity(Object obj, String str, Bundle bundle, int i11) {
        Navigation putExtras = getInstance().setDestination(str).putExtras(bundle);
        if (obj instanceof Fragment) {
            putExtras.navigate((Fragment) obj, i11);
        } else if (obj instanceof Context) {
            putExtras.navigate((Context) obj, i11);
        } else {
            putExtras.navigate((Context) null, i11);
        }
    }

    public static void startActivityForResult(a aVar, String str, Bundle bundle, ActivityResultCallback<ActivityResult> activityResultCallback) {
        getInstance().setDestination(str).putExtras(bundle).navigate(aVar, activityResultCallback);
    }

    public Navigation setDestination(String str) {
        Navigation navigation = new Navigation();
        navigation.setDestination(str);
        return navigation;
    }

    public static void startActivityForResult(a aVar, Class<? extends Activity> cls, Bundle bundle, ActivityResultCallback<ActivityResult> activityResultCallback) {
        getInstance().setDestination(cls).putExtras(bundle).navigate(aVar, activityResultCallback);
    }

    public Navigation setDestination(Class<? extends Activity> cls) {
        Navigation navigation = new Navigation();
        navigation.setDestination(cls);
        return navigation;
    }
}
