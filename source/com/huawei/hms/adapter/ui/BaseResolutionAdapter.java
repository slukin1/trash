package com.huawei.hms.adapter.ui;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.adapter.sysobs.ApkResolutionFailedManager;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.kpms.KpmsConstant;
import com.huawei.hms.utils.IntentUtil;
import com.huawei.hms.utils.RegionUtils;
import com.huawei.hms.utils.ResolutionFlagUtil;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class BaseResolutionAdapter implements IBridgeActivityDelegate {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<Activity> f37741a;

    /* renamed from: b  reason: collision with root package name */
    private String f37742b = "";

    /* renamed from: c  reason: collision with root package name */
    private long f37743c = 0;

    private void a(long j11) {
        if (!RegionUtils.isChinaROM(c())) {
            HMSLog.i("BaseResolutionAdapter", "not ChinaROM");
            return;
        }
        Activity c11 = c();
        if (c11 != null && !c11.isFinishing()) {
            HashMap hashMap = new HashMap();
            hashMap.put("package", c11.getPackageName());
            hashMap.put(CommonCode.MapKey.RESOLUTION_FLAG, this.f37743c + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j11);
            HiAnalyticsUtils.getInstance().onEvent(c11, HiAnalyticsConstant.HMS_SDK_BASE_START_RESOLUTION, hashMap);
            HMSLog.e("BaseResolutionAdapter", "check resolution flag failed, transactionId: " + this.f37742b + ", carriedTimeStamp: " + this.f37743c + ", savedTimeStamp: " + j11);
        }
    }

    private void b() {
        Activity c11 = c();
        if (c11 != null && !c11.isFinishing()) {
            c11.finish();
        }
    }

    private Activity c() {
        WeakReference<Activity> weakReference = this.f37741a;
        if (weakReference == null) {
            return null;
        }
        return (Activity) weakReference.get();
    }

    private void d() {
        SystemManager.getInstance().notifyResolutionResult((Intent) null, this.f37742b);
        b();
    }

    public int getRequestCode() {
        return 1001;
    }

    public void onBridgeActivityCreate(Activity activity) {
        if (activity == null) {
            HMSLog.e("BaseResolutionAdapter", "activity is null");
            d();
        } else if (activity.isFinishing()) {
            HMSLog.e("BaseResolutionAdapter", "activity is finishing");
        } else {
            this.f37741a = new WeakReference<>(activity);
            Intent intent = activity.getIntent();
            if (intent == null) {
                d();
                return;
            }
            Bundle bundle = null;
            try {
                bundle = intent.getExtras();
                this.f37742b = intent.getStringExtra("transaction_id");
                this.f37743c = intent.getLongExtra(CommonCode.MapKey.RESOLUTION_FLAG, 0);
            } catch (Throwable th2) {
                HMSLog.e("BaseResolutionAdapter", "get transaction_id or resolution_flag exception:" + th2.getClass().getSimpleName());
            }
            if (!a()) {
                d();
                return;
            }
            if (this.f37742b != null && Build.VERSION.SDK_INT >= 29) {
                HMSLog.i("BaseResolutionAdapter", "remove apk resolution failed task.");
                ApkResolutionFailedManager.getInstance().removeTask(this.f37742b);
            }
            if (bundle == null) {
                d();
                return;
            }
            Parcelable parcelable = bundle.getParcelable(CommonCode.MapKey.HAS_RESOLUTION);
            if (parcelable == null) {
                d();
            } else if (parcelable instanceof Intent) {
                try {
                    activity.startActivityForResult(IntentUtil.modifyIntentBehaviorsSafe((Intent) parcelable), 1001);
                } catch (Throwable unused) {
                    d();
                    HMSLog.e("BaseResolutionAdapter", "ActivityNotFoundException:exception");
                }
            } else if (parcelable instanceof PendingIntent) {
                try {
                    activity.startIntentSenderForResult(((PendingIntent) parcelable).getIntentSender(), 1001, (Intent) null, 0, 0, 0);
                } catch (IntentSender.SendIntentException unused2) {
                    d();
                    HMSLog.e("BaseResolutionAdapter", "SendIntentException:exception");
                }
            }
        }
    }

    public void onBridgeActivityDestroy() {
        HMSLog.i("BaseResolutionAdapter", "onBridgeActivityDestroy");
        this.f37741a = null;
    }

    public boolean onBridgeActivityResult(int i11, int i12, Intent intent) {
        if (i11 != getRequestCode()) {
            return false;
        }
        HMSLog.i("BaseResolutionAdapter", "onBridgeActivityResult, resultCode: " + i12);
        if (i12 == 1001 || i12 == 1002) {
            if (intent == null) {
                intent = new Intent();
            }
            intent.putExtra(CommonCode.MapKey.PRIVACY_STATEMENT_CONFIRM_RESULT, i12);
        }
        if (i12 == -1 || intent.hasExtra(KpmsConstant.KIT_UPDATE_RESULT) || intent.hasExtra(CommonCode.MapKey.PRIVACY_STATEMENT_CONFIRM_RESULT)) {
            SystemManager.getInstance().notifyResolutionResult(intent, this.f37742b);
        } else {
            SystemManager.getInstance().notifyResolutionResult((Intent) null, this.f37742b);
        }
        b();
        return true;
    }

    public void onBridgeConfigurationChanged() {
        HMSLog.i("BaseResolutionAdapter", "onBridgeConfigurationChanged");
    }

    public void onKeyUp(int i11, KeyEvent keyEvent) {
        HMSLog.i("BaseResolutionAdapter", "On key up when resolve conn error");
    }

    private boolean a() {
        long resolutionFlag = ResolutionFlagUtil.getInstance().getResolutionFlag(this.f37742b);
        ResolutionFlagUtil.getInstance().removeResolutionFlag(this.f37742b);
        if (resolutionFlag != 0 && resolutionFlag == this.f37743c) {
            return true;
        }
        a(resolutionFlag);
        return false;
    }
}
