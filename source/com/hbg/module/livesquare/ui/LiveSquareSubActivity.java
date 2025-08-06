package com.hbg.module.livesquare.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.module.content.R$color;
import com.hbg.module.content.R$id;
import com.hbg.module.content.R$layout;

@Route(path = "/live/sub")
public class LiveSquareSubActivity extends BaseCoreActivity {
    public void attachBaseContext(Context context) {
        super.attachBaseContext(AppLanguageHelper.getInstance().attachBaseContext(context));
    }

    public Resources getResources() {
        return super.getResources();
    }

    public final void nf(Class cls, Bundle bundle) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction q11 = supportFragmentManager.q();
        if (supportFragmentManager.B0() != null) {
            for (Fragment next : supportFragmentManager.B0()) {
                if (next != null && !(next instanceof DialogFragment)) {
                    q11.q(next);
                }
            }
        }
        String name = cls.getName();
        Fragment instanceFragment = instanceFragment(cls.getName(), bundle, cls.getName());
        if (!instanceFragment.isAdded()) {
            q11.c(R$id.root_view, instanceFragment, name);
        }
        q11.A(instanceFragment).k();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_live_square_sub);
        getWindow().getDecorView().setSystemUiVisibility(8192);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R$color.baseColorDeepestBackground));
        if (getIntent() != null) {
            nf(LiveSquareSubFragment.class, getIntent().getExtras());
        } else {
            nf(LiveSquareSubFragment.class, (Bundle) null);
        }
    }
}
