package cn.sharesdk.loopshare;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import cn.sharesdk.framework.utils.SSDKLog;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;

public class LoopShareActivity extends Activity {
    public void onCreate(Bundle bundle) {
        SSDKLog.b().a("[LoopShare] LoopShareActivity onCreate");
        if (Build.VERSION.SDK_INT <= 28) {
            SSDKLog.b().a("[LoopShare] LoopShareActivity onCreate SDK_INT <= 28 finish() ");
            finish();
        }
        super.onCreate(bundle);
    }

    public void onNewIntent(Intent intent) {
        PushAutoTrackHelper.onNewIntent(this, intent);
        SSDKLog.b().a("[LoopShare] LoopShareActivity onNewIntent");
        super.onNewIntent(intent);
        MobLink.updateNewIntent(intent, this);
    }

    public void onResume() {
        SSDKLog.b().a("[LoopShare] LoopShareActivity onResume");
        if (Build.VERSION.SDK_INT >= 29) {
            SSDKLog.b().a("[LoopShare] LoopShareActivity onResume SDK_INT >= 29 finish() ");
            finish();
        }
        super.onResume();
    }
}
