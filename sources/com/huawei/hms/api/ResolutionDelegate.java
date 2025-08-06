package com.huawei.hms.api;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.activity.internal.BusResponseCallback;
import com.huawei.hms.activity.internal.ForegroundBusResponseMgr;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.IntentUtil;
import java.lang.ref.WeakReference;

public class ResolutionDelegate implements IBridgeActivityDelegate {
    public static final String CALLBACK_METHOD = "CALLBACK_METHOD";
    private static final int REQUEST_CODE = 1002;
    private static final String TAG = "ResolutionDelegate";
    private WeakReference<Activity> mThisWeakRef;

    private void finishBridgeActivity() {
        Activity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            activity.finish();
        }
    }

    private Activity getActivity() {
        WeakReference<Activity> weakReference = this.mThisWeakRef;
        if (weakReference == null) {
            return null;
        }
        return (Activity) weakReference.get();
    }

    private BusResponseCallback getResponseCallback(String str) {
        return ForegroundBusResponseMgr.getInstance().get(str);
    }

    public int getRequestCode() {
        return 1002;
    }

    public void onBridgeActivityCreate(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            HMSLog.e(TAG, "activity is null or finishing");
            return;
        }
        this.mThisWeakRef = new WeakReference<>(activity);
        Bundle bundle = null;
        try {
            bundle = activity.getIntent().getExtras();
        } catch (Exception e11) {
            HMSLog.e(TAG, "getExtras exception:" + e11.getMessage());
        }
        if (bundle != null) {
            activity.startActivityForResult(IntentUtil.modifyIntentBehaviorsSafe((Intent) bundle.getParcelable(CommonCode.MapKey.HAS_RESOLUTION)), 1002);
        }
    }

    public void onBridgeActivityDestroy() {
        this.mThisWeakRef = null;
    }

    public boolean onBridgeActivityResult(int i11, int i12, Intent intent) {
        if (i11 != getRequestCode()) {
            return false;
        }
        BusResponseCallback responseCallback = getResponseCallback(CALLBACK_METHOD);
        int isHuaweiMobileServicesAvailable = HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable((Activity) this.mThisWeakRef.get(), 30000000);
        if (i12 == -1 && isHuaweiMobileServicesAvailable == 0) {
            HMSLog.i(TAG, "Make service available success.");
        } else {
            responseCallback.innerError((Activity) this.mThisWeakRef.get(), i12, "Make service available failed.");
        }
        finishBridgeActivity();
        return true;
    }

    public void onBridgeConfigurationChanged() {
    }

    public void onKeyUp(int i11, KeyEvent keyEvent) {
    }
}
