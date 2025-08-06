package com.mob.guard;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import com.mob.mgs.impl.e;
import com.mob.tools.proguard.ClassKeeper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;

@Deprecated
public class MobTranPullUpActivity extends Activity implements ClassKeeper {
    /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(1:6)(2:7|11)) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0026, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0027, code lost:
        com.mob.mgs.impl.e.a().a(r3);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000a */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0019 A[Catch:{ all -> 0x0026 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x001a A[Catch:{ all -> 0x0026 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r3) {
        /*
            r2 = this;
            super.onCreate(r3)
            android.content.Context r3 = r2.getApplicationContext()     // Catch:{ all -> 0x000a }
            com.mob.MobSDK.init(r3)     // Catch:{ all -> 0x000a }
        L_0x000a:
            com.mob.mgs.impl.e r3 = com.mob.mgs.impl.e.a()     // Catch:{ all -> 0x0026 }
            java.lang.String r0 = "[MobGuard] MobTranPullUpActivity onCreate"
            r3.a((java.lang.String) r0)     // Catch:{ all -> 0x0026 }
            android.content.Intent r3 = r2.getIntent()     // Catch:{ all -> 0x0026 }
            if (r3 != 0) goto L_0x001a
            return
        L_0x001a:
            android.content.Context r0 = r2.getApplicationContext()     // Catch:{ all -> 0x0026 }
            r1 = 1
            com.mob.mgs.impl.g.a(r0, r3, r1)     // Catch:{ all -> 0x0026 }
            r2.finish()     // Catch:{ all -> 0x0026 }
            goto L_0x002e
        L_0x0026:
            r3 = move-exception
            com.mob.mgs.impl.e r0 = com.mob.mgs.impl.e.a()
            r0.a((java.lang.Throwable) r3)
        L_0x002e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.guard.MobTranPullUpActivity.onCreate(android.os.Bundle):void");
    }

    @SensorsDataInstrumented
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        PushAutoTrackHelper.onNewIntent(this, intent);
    }

    public void onResume() {
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                if (!isFinishing()) {
                    finish();
                }
            } catch (Throwable th2) {
                e.a().a(th2);
            }
        }
        super.onResume();
    }
}
