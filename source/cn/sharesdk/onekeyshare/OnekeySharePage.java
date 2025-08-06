package cn.sharesdk.onekeyshare;

import android.os.Build;
import android.view.View;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDKCallback;
import com.mob.tools.FakeActivity;
import com.mob.tools.MobLog;
import java.util.ArrayList;
import java.util.HashMap;

public class OnekeySharePage extends FakeActivity {
    /* access modifiers changed from: private */
    public OnekeyShareThemeImpl impl;

    public OnekeySharePage(OnekeyShareThemeImpl onekeyShareThemeImpl) {
        this.impl = onekeyShareThemeImpl;
    }

    public static void setViewFitsSystemWindows(View view) {
        try {
            if (Build.VERSION.SDK_INT >= 35) {
                view.setFitsSystemWindows(true);
            }
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
        }
    }

    public void formateShareData(final Platform platform, final ShareSDKCallback<Platform.ShareParams> shareSDKCallback) {
        this.impl.formateShareData(platform, new ShareSDKCallback<Boolean>() {
            public void onCallback(Boolean bool) {
                if (bool.booleanValue()) {
                    ShareSDKCallback shareSDKCallback = shareSDKCallback;
                    if (shareSDKCallback != null) {
                        shareSDKCallback.onCallback(OnekeySharePage.this.impl.shareDataToShareParams(platform));
                        return;
                    }
                    return;
                }
                ShareSDKCallback shareSDKCallback2 = shareSDKCallback;
                if (shareSDKCallback2 != null) {
                    shareSDKCallback2.onCallback(null);
                }
            }
        });
    }

    public final PlatformActionListener getCallback() {
        return this.impl.callback;
    }

    public final ArrayList<CustomerLogo> getCustomerLogos() {
        return this.impl.customerLogos;
    }

    public final ShareContentCustomizeCallback getCustomizeCallback() {
        return this.impl.customizeCallback;
    }

    public final HashMap<String, String> getHiddenPlatforms() {
        return this.impl.hiddenPlatforms;
    }

    public final HashMap<String, Object> getShareParamsMap() {
        return this.impl.shareParamsMap;
    }

    public final boolean isDialogMode() {
        return this.impl.dialogMode;
    }

    public final boolean isDisableSSO() {
        return this.impl.disableSSO;
    }

    public final boolean isSilent() {
        return this.impl.silent;
    }

    public void isUseClientToShare(Platform platform, ShareSDKCallback<Boolean> shareSDKCallback) {
        this.impl.isUseClientToShare(platform, shareSDKCallback);
    }

    public final void shareSilently(Platform platform) {
        this.impl.shareSilently(platform);
    }
}
