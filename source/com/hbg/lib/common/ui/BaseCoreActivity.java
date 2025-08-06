package com.hbg.lib.common.ui;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import e6.k;
import i6.d;
import java.util.List;

public abstract class BaseCoreActivity extends AppCompatActivity {
    private static final String TAG = "BaseCoreActivity";
    private boolean isAlive = true;
    public k proxy;

    public void applyOverrideConfiguration(Configuration configuration) {
        if (configuration != null) {
            int i11 = configuration.uiMode;
            configuration.setTo(getBaseContext().getResources().getConfiguration());
            configuration.uiMode = i11;
        }
        super.applyOverrideConfiguration(configuration);
    }

    public Resources getResources() {
        Resources resources = super.getResources();
        try {
            if (resources instanceof k) {
                return resources;
            }
            k kVar = this.proxy;
            if (kVar != null) {
                return kVar;
            }
            k kVar2 = new k(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration(), resources);
            this.proxy = kVar2;
            return kVar2;
        } catch (Exception e11) {
            e11.printStackTrace();
            Log.e(TAG, "getResources() called : " + resources + "  ,resources=" + resources.getClass().getCanonicalName(), e11);
            return resources;
        }
    }

    public Fragment instanceFragment(String str, Bundle bundle, String str2) {
        Fragment m02 = getSupportFragmentManager().m0(str2);
        if (m02 != null) {
            if (!(m02.getArguments() == null || bundle == null)) {
                m02.getArguments().putAll(bundle);
            }
            return m02;
        }
        List<Fragment> B0 = getSupportFragmentManager().B0();
        if (B0 != null) {
            for (Fragment next : B0) {
                if (next != null && next.getClass().getName().equals(str) && str2.equals(next.getTag())) {
                    if (!(next.getArguments() == null || bundle == null)) {
                        next.getArguments().putAll(bundle);
                    }
                    return next;
                }
            }
        }
        return Fragment.instantiate(this, str, bundle);
    }

    public boolean isAlive() {
        return this.isAlive && !isFinishing();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        d.i(getClass().getSimpleName() + "------enter------");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d.i(getClass().getSimpleName() + "------enter------");
    }

    public void onDestroy() {
        super.onDestroy();
        d.i(getClass().getSimpleName() + "------enter------");
        this.isAlive = false;
    }

    public void onPause() {
        super.onPause();
        d.i(getClass().getSimpleName() + "------enter------");
    }

    public void onRestart() {
        super.onRestart();
        d.i(getClass().getSimpleName() + "------enter------");
    }

    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        d.i(getClass().getSimpleName() + "------enter------");
    }

    public void onResume() {
        super.onResume();
        d.i(getClass().getSimpleName() + "------enter------");
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        d.i(getClass().getSimpleName() + "------enter------");
    }

    public void onStart() {
        super.onStart();
        d.i(getClass().getSimpleName() + "------enter------");
    }

    public void onStop() {
        super.onStop();
        d.i(getClass().getSimpleName() + "------enter------");
    }

    public Fragment instanceFragment(String str, Bundle bundle) {
        return instanceFragment(str, bundle, str);
    }
}
