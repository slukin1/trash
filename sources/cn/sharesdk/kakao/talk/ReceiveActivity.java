package cn.sharesdk.kakao.talk;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.utils.SSDKLog;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;

public class ReceiveActivity extends Activity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String scheme = getIntent().getScheme();
        Uri data = getIntent().getData();
        if (!TextUtils.isEmpty(scheme) && data != null && scheme.startsWith("kakao") && "kakaolink".equals(data.getHost())) {
            try {
                Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
                Bundle extras = getIntent().getExtras();
                if (extras != null) {
                    launchIntentForPackage.putExtras(extras);
                }
                startActivity(launchIntentForPackage);
            } catch (Throwable th2) {
                SSDKLog.b().a(th2);
            }
        }
        finish();
    }

    @SensorsDataInstrumented
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        PushAutoTrackHelper.onNewIntent(this, intent);
    }
}
