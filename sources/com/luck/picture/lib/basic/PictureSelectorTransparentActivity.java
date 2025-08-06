package com.luck.picture.lib.basic;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.luck.picture.lib.PictureOnlyCameraFragment;
import com.luck.picture.lib.PictureSelectorPreviewFragment;
import com.luck.picture.lib.PictureSelectorSystemFragment;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.config.SelectorProviders;
import com.luck.picture.lib.immersive.ImmersiveManager;
import com.luck.picture.lib.interfaces.OnInjectActivityPreviewListener;
import com.luck.picture.lib.style.SelectMainStyle;
import com.luck.picture.lib.utils.StyleUtils;
import java.util.ArrayList;

public class PictureSelectorTransparentActivity extends AppCompatActivity {
    private SelectorConfig selectorConfig;

    private void immersive() {
        if (this.selectorConfig.selectorStyle == null) {
            SelectorProviders.getInstance().getSelectorConfig();
        }
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

    private boolean isExternalPreview() {
        return getIntent().getIntExtra(PictureConfig.EXTRA_MODE_TYPE_SOURCE, 0) == 2;
    }

    @SuppressLint({"RtlHardcoded"})
    private void setActivitySize() {
        Window window = getWindow();
        window.setGravity(51);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = 0;
        attributes.y = 0;
        attributes.height = 1;
        attributes.width = 1;
        window.setAttributes(attributes);
    }

    private void setupFragment() {
        PictureSelectorSystemFragment pictureSelectorSystemFragment;
        String str;
        PictureSelectorPreviewFragment pictureSelectorPreviewFragment;
        int intExtra = getIntent().getIntExtra(PictureConfig.EXTRA_MODE_TYPE_SOURCE, 0);
        if (intExtra == 1) {
            str = PictureSelectorSystemFragment.TAG;
            pictureSelectorSystemFragment = PictureSelectorSystemFragment.newInstance();
        } else if (intExtra == 2) {
            OnInjectActivityPreviewListener onInjectActivityPreviewListener = this.selectorConfig.onInjectActivityPreviewListener;
            PictureSelectorPreviewFragment onInjectPreviewFragment = onInjectActivityPreviewListener != null ? onInjectActivityPreviewListener.onInjectPreviewFragment() : null;
            if (onInjectPreviewFragment != null) {
                pictureSelectorPreviewFragment = onInjectPreviewFragment;
                str = onInjectPreviewFragment.getFragmentTag();
            } else {
                str = PictureSelectorPreviewFragment.TAG;
                pictureSelectorPreviewFragment = PictureSelectorPreviewFragment.newInstance();
            }
            int intExtra2 = getIntent().getIntExtra(PictureConfig.EXTRA_PREVIEW_CURRENT_POSITION, 0);
            ArrayList arrayList = new ArrayList(this.selectorConfig.selectedPreviewResult);
            pictureSelectorPreviewFragment.setExternalPreviewData(intExtra2, arrayList.size(), arrayList, getIntent().getBooleanExtra(PictureConfig.EXTRA_EXTERNAL_PREVIEW_DISPLAY_DELETE, false));
            pictureSelectorSystemFragment = pictureSelectorPreviewFragment;
        } else {
            str = PictureOnlyCameraFragment.TAG;
            pictureSelectorSystemFragment = PictureOnlyCameraFragment.newInstance();
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Fragment m02 = supportFragmentManager.m0(str);
        if (m02 != null) {
            supportFragmentManager.q().s(m02).k();
        }
        FragmentInjectManager.injectSystemRoomFragment(supportFragmentManager, str, pictureSelectorSystemFragment);
    }

    public void finish() {
        super.finish();
        if (getIntent().getIntExtra(PictureConfig.EXTRA_MODE_TYPE_SOURCE, 0) == 2) {
            SelectorConfig selectorConfig2 = this.selectorConfig;
            if (!selectorConfig2.isPreviewZoomEffect) {
                overridePendingTransition(0, selectorConfig2.selectorStyle.getWindowAnimationStyle().activityExitAnimation);
                return;
            }
        }
        overridePendingTransition(0, R.anim.ps_anim_fade_out);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initSelectorConfig();
        immersive();
        setContentView(R.layout.ps_empty);
        if (!isExternalPreview()) {
            setActivitySize();
        }
        setupFragment();
    }
}
