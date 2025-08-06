package com.luck.picture.lib.basic;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.luck.picture.lib.PictureSelectorFragment;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.config.SelectorProviders;
import com.luck.picture.lib.immersive.ImmersiveManager;
import com.luck.picture.lib.language.PictureLanguageUtils;
import com.luck.picture.lib.style.SelectMainStyle;
import com.luck.picture.lib.utils.StyleUtils;

public class PictureSelectorSupporterActivity extends AppCompatActivity {
    private SelectorConfig selectorConfig;

    private void immersive() {
        SelectMainStyle selectMainStyle = this.selectorConfig.selectorStyle.getSelectMainStyle();
        int statusBarColor = selectMainStyle.getStatusBarColor();
        int navigationBarColor = selectMainStyle.getNavigationBarColor();
        boolean isDarkStatusBarBlack = selectMainStyle.isDarkStatusBarBlack();
        if (!StyleUtils.checkStyleValidity(statusBarColor)) {
            statusBarColor = ContextCompat.getColor(this, R.color.ps_color_grey);
        }
        if (!StyleUtils.checkStyleValidity(navigationBarColor)) {
            navigationBarColor = ContextCompat.getColor(this, R.color.ps_color_grey);
        }
        ImmersiveManager.immersiveAboveAPI23(this, statusBarColor, navigationBarColor, isDarkStatusBarBlack);
    }

    private void initSelectorConfig() {
        this.selectorConfig = SelectorProviders.getInstance().getSelectorConfig();
    }

    private void setupFragment() {
        FragmentInjectManager.injectFragment(this, PictureSelectorFragment.TAG, PictureSelectorFragment.newInstance());
    }

    public void attachBaseContext(Context context) {
        SelectorConfig selectorConfig2 = SelectorProviders.getInstance().getSelectorConfig();
        if (selectorConfig2 != null) {
            super.attachBaseContext(PictureContextWrapper.wrap(context, selectorConfig2.language, selectorConfig2.defaultLanguage));
        } else {
            super.attachBaseContext(context);
        }
    }

    public void finish() {
        super.finish();
        SelectorConfig selectorConfig2 = this.selectorConfig;
        if (selectorConfig2 != null) {
            overridePendingTransition(0, selectorConfig2.selectorStyle.getWindowAnimationStyle().activityExitAnimation);
        }
    }

    public void initAppLanguage() {
        int i11;
        SelectorConfig selectorConfig2 = this.selectorConfig;
        if (selectorConfig2 != null && (i11 = selectorConfig2.language) != -2 && !selectorConfig2.isOnlyCamera) {
            PictureLanguageUtils.setAppLanguage(this, i11, selectorConfig2.defaultLanguage);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        initAppLanguage();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initSelectorConfig();
        immersive();
        setContentView(R.layout.ps_activity_container);
        setupFragment();
    }
}
