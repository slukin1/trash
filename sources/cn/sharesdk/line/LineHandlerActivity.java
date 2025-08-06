package cn.sharesdk.line;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import cn.sharesdk.framework.utils.SSDKLog;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;

public class LineHandlerActivity extends Activity {
    public void onCreate(Bundle bundle) {
        setTheme(16973839);
        super.onCreate(bundle);
        try {
            c.a().a(this, getIntent().getData());
            finish();
        } catch (Throwable th2) {
            SSDKLog.b().a(th2);
        }
    }

    public void onNewIntent(Intent intent) {
        PushAutoTrackHelper.onNewIntent(this, intent);
        super.onNewIntent(intent);
    }
}
