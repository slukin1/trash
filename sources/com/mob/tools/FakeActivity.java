package com.mob.tools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.mob.commons.a.l;
import com.mob.tools.proguard.EverythingKeeper;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ResHelper;
import com.mob.tools.utils.UIHandler;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.lang.reflect.Method;
import java.util.HashMap;

public class FakeActivity implements EverythingKeeper {
    private static Class<? extends Activity> shellClass;
    public Activity activity;
    private View contentView;
    private HashMap<String, Object> result;
    private FakeActivity resultReceiver;

    public static void registerExecutor(String str, Object obj) {
        Class<? extends Activity> cls = shellClass;
        if (cls != null) {
            try {
                Method method = cls.getMethod(l.a("0167ek?gFfkejgjNjgAekhjfjEgdNeh3j(elek"), new Class[]{String.class, Object.class});
                method.setAccessible(true);
                method.invoke((Object) null, new Object[]{str, obj});
            } catch (Throwable th2) {
                MobLog.getInstance().w(th2);
            }
        } else {
            MobUIShell.a(str, obj);
        }
    }

    public static void setShell(Class<? extends Activity> cls) {
        shellClass = cls;
    }

    /* access modifiers changed from: private */
    public void showActivity(final Context context, final Intent intent) {
        if (!(context instanceof Activity)) {
            DH.requester(context).getTopActivity().request(new DH.DHResponder() {
                public void onResponse(DH.DHResponse dHResponse) {
                    Activity topActivity = dHResponse.getTopActivity();
                    if (topActivity == null) {
                        intent.addFlags(268435456);
                        context.startActivity(intent);
                        return;
                    }
                    topActivity.startActivity(intent);
                }
            });
        } else {
            context.startActivity(intent);
        }
    }

    public void beforeStartActivityForResult(Intent intent, int i11, Bundle bundle) {
    }

    public boolean disableScreenCapture() {
        Activity activity2 = this.activity;
        if (activity2 == null || Build.VERSION.SDK_INT < 11) {
            return false;
        }
        activity2.getWindow().setFlags(8192, 8192);
        return true;
    }

    public <T extends View> T findViewById(int i11) {
        Activity activity2 = this.activity;
        if (activity2 == null) {
            return null;
        }
        return activity2.findViewById(i11);
    }

    public <T extends View> T findViewByResName(View view, String str) {
        int idRes;
        Activity activity2 = this.activity;
        if (activity2 != null && (idRes = ResHelper.getIdRes(activity2, str)) > 0) {
            return view.findViewById(idRes);
        }
        return null;
    }

    public final void finish() {
        Activity activity2 = this.activity;
        if (activity2 != null) {
            activity2.finish();
        }
    }

    public View getContentView() {
        return this.contentView;
    }

    public Context getContext() {
        return this.activity;
    }

    public int getOrientation() {
        return this.activity.getResources().getConfiguration().orientation;
    }

    public FakeActivity getParent() {
        return this.resultReceiver;
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onCreate() {
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    public void onDestroy() {
    }

    public boolean onFinish() {
        return false;
    }

    public boolean onKeyEvent(int i11, KeyEvent keyEvent) {
        return false;
    }

    public void onNewIntent(Intent intent) {
    }

    @SensorsDataInstrumented
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
        return false;
    }

    public void onPause() {
    }

    public void onRequestPermissionsResult(int i11, String[] strArr, int[] iArr) {
    }

    public void onRestart() {
    }

    public void onResult(HashMap<String, Object> hashMap) {
    }

    public void onResume() {
    }

    public int onSetTheme(int i11, boolean z11) {
        return i11;
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void requestFullScreen(boolean z11) {
        Activity activity2 = this.activity;
        if (activity2 != null) {
            if (z11) {
                activity2.getWindow().addFlags(1024);
                this.activity.getWindow().clearFlags(2048);
            } else {
                activity2.getWindow().addFlags(2048);
                this.activity.getWindow().clearFlags(1024);
            }
            this.activity.getWindow().getDecorView().requestLayout();
        }
    }

    public void requestLandscapeOrientation() {
        setRequestedOrientation(0);
    }

    public void requestPermissions(String[] strArr, int i11) {
        Activity activity2 = this.activity;
        if (activity2 != null && Build.VERSION.SDK_INT >= 23) {
            ReflectHelper.invokeInstanceMethod(activity2, l.a("0187ek^g'efehJg-gj>j?hmLg7ekegejgjgjejel>f(gj"), new Object[]{strArr, Integer.valueOf(i11)}, new Class[]{String.class, Integer.TYPE}, null);
        }
    }

    public void requestPortraitOrientation() {
        setRequestedOrientation(1);
    }

    public void requestSensorLandscapeOrientation() {
        setRequestedOrientation(6);
    }

    public void requestSensorPortraitOrientation() {
        setRequestedOrientation(7);
    }

    public void runOnUIThread(final Runnable runnable) {
        UIHandler.sendEmptyMessage(0, new Handler.Callback() {
            public boolean handleMessage(Message message) {
                runnable.run();
                return false;
            }
        });
    }

    public void sendResult() {
        FakeActivity fakeActivity = this.resultReceiver;
        if (fakeActivity != null) {
            fakeActivity.onResult(this.result);
        }
    }

    public void setActivity(Activity activity2) {
        this.activity = activity2;
    }

    public void setContentView(View view) {
        this.contentView = view;
    }

    public void setContentViewLayoutResName(String str) {
        int layoutRes;
        Activity activity2 = this.activity;
        if (activity2 != null && (layoutRes = ResHelper.getLayoutRes(activity2, str)) > 0) {
            this.activity.setContentView(layoutRes);
        }
    }

    public void setRequestedOrientation(int i11) {
        if (this.activity != null) {
            if (Build.VERSION.SDK_INT < 26 || getContext().getApplicationInfo().targetSdkVersion < 27) {
                this.activity.setRequestedOrientation(i11);
            }
        }
    }

    public final void setResult(HashMap<String, Object> hashMap) {
        this.result = hashMap;
    }

    public void show(Context context, Intent intent) {
        showForResult(context, intent, (FakeActivity) null);
    }

    public void showForResult(final Context context, Intent intent, FakeActivity fakeActivity) {
        final Intent intent2;
        this.resultReceiver = fakeActivity;
        String str = null;
        if (shellClass != null) {
            intent2 = new Intent(context, shellClass);
            try {
                Method method = shellClass.getMethod(l.a("016GekGg+fkejgjYjgTekhjfjOgdAeh)j=elek"), new Class[]{Object.class});
                method.setAccessible(true);
                str = (String) method.invoke((Object) null, new Object[]{this});
            } catch (Throwable th2) {
                MobLog.getInstance().w(th2);
            }
        } else {
            intent2 = new Intent(context, MobUIShell.class);
            str = MobUIShell.a((Object) this);
        }
        intent2.putExtra(l.a("011he>ehRfdi@ei[j1ejegSg"), str);
        intent2.putExtra(l.a("013gIfjQgdVeh'j-elekeiPfe6eg g"), getClass().getName());
        if (intent != null) {
            intent2.putExtras(intent);
        }
        if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
            showActivity(context, intent2);
        } else {
            UIHandler.sendEmptyMessage(0, new Handler.Callback() {
                public boolean handleMessage(Message message) {
                    FakeActivity.this.showActivity(context, intent2);
                    return false;
                }
            });
        }
    }

    public void startActivity(Intent intent) {
        startActivityForResult(intent, -1);
    }

    public void startActivityForResult(Intent intent, int i11) {
        Activity activity2 = this.activity;
        if (activity2 != null) {
            activity2.startActivityForResult(intent, i11);
        }
    }

    public void runOnUIThread(final Runnable runnable, long j11) {
        UIHandler.sendEmptyMessageDelayed(0, j11, new Handler.Callback() {
            public boolean handleMessage(Message message) {
                runnable.run();
                return false;
            }
        });
    }

    public <T extends View> T findViewByResName(String str) {
        int idRes;
        Activity activity2 = this.activity;
        if (activity2 != null && (idRes = ResHelper.getIdRes(activity2, str)) > 0) {
            return findViewById(idRes);
        }
        return null;
    }
}
