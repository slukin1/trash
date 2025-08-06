package com.huawei.hms.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.adapter.sysobs.SystemObserver;
import com.huawei.hms.adapter.ui.NotInstalledHmsAdapter;
import com.huawei.hms.adapter.ui.UpdateAdapter;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.note.AppSpoofResolution;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSBIInitializer;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.UIUtil;

public class AvailableAdapter {

    /* renamed from: a  reason: collision with root package name */
    private final int f37689a;

    /* renamed from: b  reason: collision with root package name */
    private AvailableCallBack f37690b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f37691c;

    /* renamed from: d  reason: collision with root package name */
    private SystemObserver f37692d = new a();

    public interface AvailableCallBack {
        void onComplete(int i11);
    }

    public class a implements SystemObserver {
        public a() {
        }

        public boolean onNoticeResult(int i11) {
            AvailableCallBack a11 = AvailableAdapter.this.a();
            if (a11 == null) {
                HMSLog.e("AvailableAdapter", "onNoticeResult baseCallBack null");
                return true;
            }
            a11.onComplete(i11);
            return true;
        }

        public boolean onSolutionResult(Intent intent, String str) {
            return false;
        }

        public boolean onUpdateResult(int i11) {
            AvailableCallBack a11 = AvailableAdapter.this.a();
            if (a11 == null) {
                HMSLog.e("AvailableAdapter", "onUpdateResult baseCallBack null");
                return true;
            }
            a11.onComplete(i11);
            return true;
        }
    }

    public AvailableAdapter(int i11) {
        this.f37689a = i11;
        this.f37691c = false;
    }

    private void b(Context context) {
        HMSBIInitializer.getInstance(context).initBI();
    }

    public int checkHuaweiMobileServicesForUpdate(Context context) {
        Checker.checkNonNull(context, "context must not be null.");
        int a11 = a(context);
        if (a11 != 0 || !HMSPackageManager.getInstance(context).isApkNeedUpdate(this.f37689a)) {
            return a11;
        }
        HMSLog.i("AvailableAdapter", "The current version does not meet the target version requirements");
        return 2;
    }

    public int isHuaweiMobileServicesAvailable(Context context) {
        Checker.checkNonNull(context, "context must not be null.");
        int a11 = a(context);
        if (a11 != 0 || !HMSPackageManager.getInstance(context).isApkUpdateNecessary(this.f37689a)) {
            return a11;
        }
        HMSLog.i("AvailableAdapter", "The current version does not meet the minimum version requirements");
        return 2;
    }

    public boolean isUserNoticeError(int i11) {
        return i11 == 29;
    }

    public boolean isUserResolvableError(int i11) {
        return i11 == 1 || i11 == 2;
    }

    public void setCalledBySolutionInstallHms(boolean z11) {
        this.f37691c = z11;
    }

    public void startNotice(Activity activity, AvailableCallBack availableCallBack) {
        if (activity != null && availableCallBack != null) {
            if (UIUtil.isBackground(activity)) {
                HMSLog.i("AvailableAdapter", "current app is in Background");
                availableCallBack.onComplete(28);
                return;
            }
            HMSLog.i("AvailableAdapter", "startNotice");
            this.f37690b = availableCallBack;
            SystemManager.getSystemNotifier().registerObserver(this.f37692d);
            activity.startActivity(BridgeActivity.getIntentStartBridgeActivity(activity, AppSpoofResolution.class.getName()));
        }
    }

    public void startResolution(Activity activity, AvailableCallBack availableCallBack) {
        if (activity != null && availableCallBack != null) {
            b(activity);
            if (UIUtil.isBackground(activity)) {
                HMSLog.i("AvailableAdapter", "current app is in Background");
                availableCallBack.onComplete(28);
                return;
            }
            boolean a11 = a(activity);
            if (AvailableUtil.isInstallerLibExist(activity) || a11) {
                HMSLog.i("AvailableAdapter", "startResolution");
                this.f37690b = availableCallBack;
                SystemManager.getSystemNotifier().registerObserver(this.f37692d);
                Intent intentStartBridgeActivity = BridgeActivity.getIntentStartBridgeActivity(activity, UpdateAdapter.class.getName());
                intentStartBridgeActivity.putExtra(CommonCode.MapKey.UPDATE_VERSION, this.f37689a);
                if (this.f37691c) {
                    intentStartBridgeActivity.putExtra("installHMS", "installHMS");
                }
                intentStartBridgeActivity.putExtra(CommonCode.MapKey.NEW_UPDATE, a11);
                activity.startActivity(intentStartBridgeActivity);
                return;
            }
            a(activity, availableCallBack);
        }
    }

    private int a(Context context) {
        if (Build.VERSION.SDK_INT < 16) {
            HMSLog.i("AvailableAdapter", "HMS can not be supported under android 4.1");
            return 21;
        } else if (HMSPackageManager.getInstance(context).isUseOldCertificate()) {
            HMSLog.e("AvailableAdapter", "The CP uses the old certificate to terminate the connection.");
            return 13;
        } else {
            PackageManagerHelper.PackageStates hMSPackageStatesForMultiService = HMSPackageManager.getInstance(context).getHMSPackageStatesForMultiService();
            if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(hMSPackageStatesForMultiService)) {
                HMSLog.i("AvailableAdapter", "HMS is not installed");
                return 1;
            } else if (PackageManagerHelper.PackageStates.SPOOF.equals(hMSPackageStatesForMultiService)) {
                HMSLog.i("AvailableAdapter", "HMS is spoofed");
                return 29;
            } else if (!PackageManagerHelper.PackageStates.DISABLED.equals(hMSPackageStatesForMultiService)) {
                return 0;
            } else {
                HMSLog.i("AvailableAdapter", "HMS is disabled");
                return 3;
            }
        }
    }

    private void a(Activity activity, AvailableCallBack availableCallBack) {
        HMSLog.i("AvailableAdapter", "<showHmsApkNotInstalledDialog> startResolution");
        if (NotInstalledHmsAdapter.getShowLock()) {
            this.f37690b = availableCallBack;
            SystemManager.getSystemNotifier().registerObserver(this.f37692d);
            activity.startActivity(BridgeActivity.getIntentStartBridgeActivity(activity, NotInstalledHmsAdapter.class.getName()));
            return;
        }
        availableCallBack.onComplete(31);
    }

    private boolean a(Activity activity) {
        if (HMSPackageManager.getInstance(activity).isUpdateHmsForThirdPartyDevice() || HMSPackageManager.getInstance(activity).getHmsVersionCode() < 40000000) {
            return false;
        }
        HMSLog.i("AvailableAdapter", "enter 4.0 HmsCore upgrade process");
        return true;
    }

    /* access modifiers changed from: private */
    public AvailableCallBack a() {
        return this.f37690b;
    }
}
