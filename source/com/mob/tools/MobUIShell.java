package com.mob.tools;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.mob.commons.a.l;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.ReflectHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

public class MobUIShell extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private static HashMap<String, FakeActivity> f27656a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private FakeActivity f27657b;

    static {
        MobLog.getInstance().d("===============================", new Object[0]);
        String replace = "2024-10-16".replace("-0", Constants.ACCEPT_TIME_SEPARATOR_SERVER).replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, InstructionFileId.DOT);
        NLog instance = MobLog.getInstance();
        instance.d(l.a("009Tidelgggdelel;h1gjjg") + replace, new Object[0]);
        MobLog.getInstance().d("===============================", new Object[0]);
    }

    public static String a(Object obj) {
        return a(String.valueOf(System.currentTimeMillis()), obj);
    }

    private boolean b() {
        if (this.f27657b == null) {
            Intent intent = getIntent();
            Uri data = intent.getData();
            if (data != null && l.a("005:egelggehej").equals(data.getScheme())) {
                FakeActivity a11 = a(data.getHost());
                this.f27657b = a11;
                if (a11 != null) {
                    NLog instance = MobLog.getInstance();
                    instance.i("MUIShell found executor: " + this.f27657b.getClass());
                    this.f27657b.setActivity(this);
                    return true;
                }
            }
            try {
                String stringExtra = intent.getStringExtra(l.a("011he<ehPfdi;eiJj_ejeg$g"));
                String stringExtra2 = intent.getStringExtra(l.a("013g(fjXgdCehYj8elekeiCfeHeg9g"));
                FakeActivity remove = f27656a.remove(stringExtra);
                this.f27657b = remove;
                if (remove == null) {
                    FakeActivity remove2 = f27656a.remove(intent.getScheme());
                    this.f27657b = remove2;
                    if (remove2 == null) {
                        FakeActivity a12 = a();
                        this.f27657b = a12;
                        if (a12 == null) {
                            NLog instance2 = MobLog.getInstance();
                            instance2.w((Throwable) new RuntimeException("Executor lost! launchTime = " + stringExtra + ", executorName: " + stringExtra2));
                            return false;
                        }
                    }
                }
                NLog instance3 = MobLog.getInstance();
                instance3.i("MUIShell found executor: " + this.f27657b.getClass());
                this.f27657b.setActivity(this);
            } catch (Throwable th2) {
                MobLog.getInstance().w(th2);
                return false;
            }
        }
        return true;
    }

    private boolean c() {
        if (Build.VERSION.SDK_INT > 27) {
            return false;
        }
        try {
            Field declaredField = Activity.class.getDeclaredField(l.a("013=egge0dj0ejeeejLj*fdffDfVfgel"));
            declaredField.setAccessible(true);
            ((ActivityInfo) declaredField.get(this)).screenOrientation = -1;
            declaredField.setAccessible(false);
            return true;
        } catch (Exception e11) {
            MobLog.getInstance().w(e11, "Fix orientation for 8.0 encountered exception", new Object[0]);
            return false;
        }
    }

    private boolean d() {
        boolean z11;
        Exception e11;
        if (Build.VERSION.SDK_INT > 27) {
            return false;
        }
        try {
            TypedArray obtainStyledAttributes = this.f27657b.activity.obtainStyledAttributes((int[]) Class.forName("com.android.internal.R$styleable").getField("Window").get((Object) null));
            Method method = ActivityInfo.class.getMethod(l.a("023Wejgjgdek6ef7gj[h[eh$dgfjBhiekhdHh el6ejTejOfNfk"), new Class[]{TypedArray.class});
            method.setAccessible(true);
            z11 = ((Boolean) method.invoke((Object) null, new Object[]{obtainStyledAttributes})).booleanValue();
            try {
                method.setAccessible(false);
            } catch (Exception e12) {
                e11 = e12;
            }
        } catch (Exception e13) {
            e11 = e13;
            z11 = false;
            MobLog.getInstance().w((Throwable) e11);
            return z11;
        }
        return z11;
    }

    public void finish() {
        FakeActivity fakeActivity = this.f27657b;
        if (fakeActivity == null || !fakeActivity.onFinish()) {
            super.finish();
        }
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        FakeActivity fakeActivity = this.f27657b;
        if (fakeActivity != null) {
            fakeActivity.onActivityResult(i11, i12, intent);
        }
        super.onActivityResult(i11, i12, intent);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        FakeActivity fakeActivity = this.f27657b;
        if (fakeActivity != null) {
            fakeActivity.onConfigurationChanged(configuration);
        }
    }

    public void onCreate(Bundle bundle) {
        if (b()) {
            NLog instance = MobLog.getInstance();
            instance.d(this.f27657b.getClass().getSimpleName() + " onCreate", new Object[0]);
            int i11 = Build.VERSION.SDK_INT;
            if (i11 == 26 && d()) {
                c();
            }
            if (i11 >= 21) {
                this.f27657b.activity.getWindow().addFlags(Integer.MIN_VALUE);
                this.f27657b.activity.getWindow().setStatusBarColor(0);
            }
            super.onCreate(bundle);
            this.f27657b.onCreate();
            return;
        }
        super.onCreate(bundle);
        finish();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        boolean onCreateOptionsMenu = super.onCreateOptionsMenu(menu);
        FakeActivity fakeActivity = this.f27657b;
        return fakeActivity != null ? fakeActivity.onCreateOptionsMenu(menu) : onCreateOptionsMenu;
    }

    public void onDestroy() {
        FakeActivity fakeActivity = this.f27657b;
        if (fakeActivity != null) {
            fakeActivity.sendResult();
            NLog instance = MobLog.getInstance();
            instance.d(this.f27657b.getClass().getSimpleName() + " onDestroy", new Object[0]);
            this.f27657b.onDestroy();
        }
        super.onDestroy();
    }

    public boolean onKeyDown(int i11, KeyEvent keyEvent) {
        try {
            FakeActivity fakeActivity = this.f27657b;
            if (fakeActivity != null ? fakeActivity.onKeyEvent(i11, keyEvent) : false) {
                return true;
            }
            return super.onKeyDown(i11, keyEvent);
        } catch (Throwable th2) {
            MobLog.getInstance().w(th2);
            return false;
        }
    }

    public boolean onKeyUp(int i11, KeyEvent keyEvent) {
        try {
            FakeActivity fakeActivity = this.f27657b;
            if (fakeActivity != null ? fakeActivity.onKeyEvent(i11, keyEvent) : false) {
                return true;
            }
            return super.onKeyUp(i11, keyEvent);
        } catch (Throwable th2) {
            MobLog.getInstance().w(th2);
            return false;
        }
    }

    public void onNewIntent(Intent intent) {
        PushAutoTrackHelper.onNewIntent(this, intent);
        FakeActivity fakeActivity = this.f27657b;
        if (fakeActivity == null) {
            super.onNewIntent(intent);
        } else {
            fakeActivity.onNewIntent(intent);
        }
    }

    @SensorsDataInstrumented
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        boolean onOptionsItemSelected = super.onOptionsItemSelected(menuItem);
        FakeActivity fakeActivity = this.f27657b;
        if (fakeActivity != null) {
            boolean onOptionsItemSelected2 = fakeActivity.onOptionsItemSelected(menuItem);
            SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
            return onOptionsItemSelected2;
        }
        SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
        return onOptionsItemSelected;
    }

    public void onPause() {
        if (this.f27657b != null) {
            NLog instance = MobLog.getInstance();
            instance.d(this.f27657b.getClass().getSimpleName() + " onPause", new Object[0]);
            this.f27657b.onPause();
        }
        super.onPause();
    }

    public void onRequestPermissionsResult(int i11, String[] strArr, int[] iArr) {
        FakeActivity fakeActivity = this.f27657b;
        if (fakeActivity != null) {
            fakeActivity.onRequestPermissionsResult(i11, strArr, iArr);
        }
    }

    public void onRestart() {
        if (this.f27657b != null) {
            NLog instance = MobLog.getInstance();
            instance.d(this.f27657b.getClass().getSimpleName() + " onRestart", new Object[0]);
            this.f27657b.onRestart();
        }
        super.onRestart();
    }

    public void onResume() {
        if (this.f27657b != null) {
            NLog instance = MobLog.getInstance();
            instance.d(this.f27657b.getClass().getSimpleName() + " onResume", new Object[0]);
            this.f27657b.onResume();
        }
        super.onResume();
    }

    public void onStart() {
        if (this.f27657b != null) {
            NLog instance = MobLog.getInstance();
            instance.d(this.f27657b.getClass().getSimpleName() + " onStart", new Object[0]);
            this.f27657b.onStart();
        }
        super.onStart();
    }

    public void onStop() {
        if (this.f27657b != null) {
            NLog instance = MobLog.getInstance();
            instance.d(this.f27657b.getClass().getSimpleName() + " onStop", new Object[0]);
            this.f27657b.onStop();
        }
        super.onStop();
    }

    public void setContentView(int i11) {
        setContentView(LayoutInflater.from(this).inflate(i11, (ViewGroup) null));
    }

    public void setRequestedOrientation(int i11) {
        if (Build.VERSION.SDK_INT != 26 || !d()) {
            super.setRequestedOrientation(i11);
        }
    }

    public final void setTheme(int i11) {
        if (b()) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            int i12 = 0;
            while (i12 < stackTrace.length) {
                if (!stackTrace[i12].toString().startsWith(l.a("030Qih)e+ee.e2em9hef-fkemgdMi:ekGge(edemfk!gjNfm?jedLfigdek^edg")) || (i12 = i12 + 2) >= stackTrace.length) {
                    i12++;
                } else {
                    int onSetTheme = this.f27657b.onSetTheme(i11, stackTrace[i12].toString().startsWith(l.a("048efBedekelejedem^ekk@emgeLdjFejeeej2j]fdgdUi)ekIgeVedem)kg ekfgelekeggfLeZeh2fdi.ge0djNejeeejNjDfd")));
                    if (onSetTheme > 0) {
                        super.setTheme(onSetTheme);
                        return;
                    }
                    return;
                }
            }
        }
        super.setTheme(i11);
    }

    public void startActivityForResult(Intent intent, int i11) {
        FakeActivity fakeActivity = this.f27657b;
        if (fakeActivity != null) {
            fakeActivity.beforeStartActivityForResult(intent, i11, (Bundle) null);
        }
        super.startActivityForResult(intent, i11);
    }

    public static String a(String str, Object obj) {
        f27656a.put(str, (FakeActivity) obj);
        return str;
    }

    public void setContentView(View view) {
        if (view != null) {
            super.setContentView(view);
            FakeActivity fakeActivity = this.f27657b;
            if (fakeActivity != null) {
                fakeActivity.setContentView(view);
            }
        }
    }

    private FakeActivity a(String str) {
        Object newInstance;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (str.startsWith(InstructionFileId.DOT)) {
                str = getPackageName() + str;
            }
            String importClass = ReflectHelper.importClass(str);
            if (TextUtils.isEmpty(importClass) || (newInstance = ReflectHelper.newInstance(importClass, new Object[0])) == null || !(newInstance instanceof FakeActivity)) {
                return null;
            }
            return (FakeActivity) newInstance;
        } catch (Throwable th2) {
            MobLog.getInstance().w(th2);
            return null;
        }
    }

    public void startActivityForResult(Intent intent, int i11, Bundle bundle) {
        FakeActivity fakeActivity = this.f27657b;
        if (fakeActivity != null) {
            fakeActivity.beforeStartActivityForResult(intent, i11, bundle);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            super.startActivityForResult(intent, i11, bundle);
        } else {
            super.startActivityForResult(intent, i11);
        }
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        if (view != null) {
            if (layoutParams == null) {
                super.setContentView(view);
            } else {
                super.setContentView(view, layoutParams);
            }
            FakeActivity fakeActivity = this.f27657b;
            if (fakeActivity != null) {
                fakeActivity.setContentView(view);
            }
        }
    }

    public FakeActivity a() {
        String str;
        try {
            str = getPackageManager().getActivityInfo(getComponentName(), 128).metaData.getString(l.a("015Ted-gOfgCe1ehFhj:geXdjFejeeejMj4fd"));
        } catch (Throwable th2) {
            MobLog.getInstance().w(th2);
            str = null;
        }
        return a(str);
    }
}
