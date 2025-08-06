package com.hbg.lib.common.mvp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huobi.woodpecker.monitor.OpPathMonitor;
import h6.a;
import i6.d;
import i6.r;
import js.b;

public abstract class BaseMVPActivity<P extends ActivityPresenter<V>, V extends a> extends BaseCoreActivity {
    private P presenter;
    public r viewFinder;

    public abstract P createPresenter();

    public SharedPreferences getPreferences(int i11) {
        SharedPreferences c11;
        if (!b.i()) {
            b.f(getApplication(), true);
        }
        if (b.i() && b.f84413j && (c11 = b.c(getApplication(), getLocalClassName())) != null) {
            return c11;
        }
        if (d.k()) {
            Log.e("MmkvSharedPrefs", "Activity.getSharedPreferences() called with: name = [" + getLocalClassName() + "] 还用系统SharedPreferences");
        }
        return getSharedPreferences(getLocalClassName(), i11);
    }

    public P getPresenter() {
        return this.presenter;
    }

    public abstract V getUI();

    public abstract void initContentView();

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        this.presenter.onActivityResult(i11, i12, intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.viewFinder = new r((Activity) this);
        initContentView();
        P createPresenter = createPresenter();
        this.presenter = createPresenter;
        createPresenter.onUIReady((BaseCoreActivity) this, getUI());
    }

    public void onDestroy() {
        super.onDestroy();
        this.presenter.onDestroy();
    }

    public void onPause() {
        super.onPause();
        this.presenter.onPause();
    }

    public void onRequestPermissionsResult(int i11, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i11, strArr, iArr);
        this.presenter.onRequestPermissionsResult(i11, strArr, iArr);
    }

    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.presenter.onRestoreInstanceState(bundle);
    }

    public void onResume() {
        super.onResume();
        this.presenter.onResume();
        String simpleName = getClass().getSimpleName();
        String bundle = getIntent().getExtras() == null ? null : getIntent().getExtras().toString();
        OpPathMonitor.c().a(simpleName, bundle);
        FirebaseCrashlytics instance = FirebaseCrashlytics.getInstance();
        instance.setCustomKey("lastPagePath", simpleName + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + bundle);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.presenter.onSaveInstanceState(bundle);
    }

    public void onStart() {
        super.onStart();
        this.presenter.onStart();
    }

    public void onStop() {
        super.onStop();
        this.presenter.onStop();
    }
}
