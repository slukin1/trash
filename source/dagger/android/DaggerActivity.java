package dagger.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import pz.a;
import pz.b;

public abstract class DaggerActivity extends Activity implements b {

    /* renamed from: b  reason: collision with root package name */
    public DispatchingAndroidInjector<Object> f53566b;

    public AndroidInjector<Object> a() {
        return this.f53566b;
    }

    public void onCreate(Bundle bundle) {
        a.b(this);
        super.onCreate(bundle);
    }

    @SensorsDataInstrumented
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        PushAutoTrackHelper.onNewIntent(this, intent);
    }
}
