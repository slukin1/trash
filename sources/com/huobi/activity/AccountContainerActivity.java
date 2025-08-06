package com.huobi.activity;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.hbg.lib.core.ui.EmptyMVPActivity;
import pro.huobi.R;

public class AccountContainerActivity extends EmptyMVPActivity {
    public int getContentView() {
        return R.layout.activity_container;
    }

    public void initView() {
        hideStatusBar();
        try {
            Bundle extras = getIntent().getExtras();
            String stringExtra = getIntent().getStringExtra("class_name");
            Fragment instanceFragment = instanceFragment(stringExtra, extras, stringExtra);
            FragmentTransaction q11 = getSupportFragmentManager().q();
            if (!instanceFragment.isAdded()) {
                q11.c(R.id.root, instanceFragment, stringExtra);
            }
            q11.A(instanceFragment).k();
        } catch (Throwable unused) {
            finish();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }
}
