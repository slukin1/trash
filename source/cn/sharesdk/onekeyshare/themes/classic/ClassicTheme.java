package cn.sharesdk.onekeyshare.themes.classic;

import android.content.Context;
import android.content.Intent;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.onekeyshare.OnekeyShareThemeImpl;
import cn.sharesdk.onekeyshare.themes.classic.land.EditPageLand;
import cn.sharesdk.onekeyshare.themes.classic.land.PlatformPageLand;
import cn.sharesdk.onekeyshare.themes.classic.port.EditPagePort;
import cn.sharesdk.onekeyshare.themes.classic.port.PlatformPagePort;
import com.mob.tools.FakeActivity;

public class ClassicTheme extends OnekeyShareThemeImpl {
    private static final int MIN_CLICK_DELAY_TIME = 1000;
    private static long lastTime;

    public void showEditPage(Context context, Platform platform, Platform.ShareParams shareParams) {
        EditPage editPage;
        if (context.getResources().getConfiguration().orientation == 1) {
            editPage = new EditPagePort(this);
        } else {
            editPage = new EditPageLand(this);
        }
        editPage.setPlatform(platform);
        editPage.setShareParams(shareParams);
        editPage.show(context, (Intent) null);
    }

    public void showPlatformPage(Context context) {
        FakeActivity fakeActivity;
        if (context.getResources().getConfiguration().orientation == 1) {
            fakeActivity = new PlatformPagePort(this);
        } else {
            fakeActivity = new PlatformPageLand(this);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - lastTime >= 1000) {
            fakeActivity.show(context, (Intent) null);
        }
        lastTime = currentTimeMillis;
    }
}
