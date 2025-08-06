package com.huawei.hms.adapter.ui;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.adapter.AvailableUtil;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.availableupdate.c;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.kpms.KpmsConstant;
import com.huawei.hms.update.ui.UpdateBean;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import java.lang.ref.WeakReference;

public class UpdateAdapter implements IBridgeActivityDelegate {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<Activity> f37750a;

    /* renamed from: b  reason: collision with root package name */
    private Context f37751b;

    /* renamed from: c  reason: collision with root package name */
    private int f37752c;

    /* renamed from: d  reason: collision with root package name */
    private UpdateBean f37753d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f37754e = false;

    private static Object a(String str, String str2, Object[] objArr) throws Throwable {
        if (TextUtils.isEmpty(str)) {
            HMSLog.e("UpdateAdapter", "className is empty.");
            return null;
        } else if (TextUtils.isEmpty(str2)) {
            HMSLog.e("UpdateAdapter", "methodName is empty.");
            return null;
        } else if (objArr == null) {
            HMSLog.e("UpdateAdapter", "args is null.");
            return null;
        } else {
            Class[] clsArr = new Class[objArr.length];
            for (int i11 = 0; i11 < objArr.length; i11++) {
                if (objArr[i11] instanceof Activity) {
                    clsArr[i11] = Activity.class;
                } else if (objArr[i11] instanceof Context) {
                    clsArr[i11] = Context.class;
                } else if (objArr[i11] instanceof UpdateBean) {
                    clsArr[i11] = UpdateBean.class;
                } else if (objArr[i11] instanceof Integer) {
                    clsArr[i11] = Integer.TYPE;
                } else if (objArr[i11] instanceof Boolean) {
                    clsArr[i11] = Boolean.TYPE;
                } else {
                    HMSLog.e("UpdateAdapter", "not set args[" + i11 + "] type");
                }
            }
            Class<?> cls = Class.forName(str);
            return cls.getMethod(str2, clsArr).invoke(cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), objArr);
        }
    }

    private Activity b() {
        WeakReference<Activity> weakReference = this.f37750a;
        if (weakReference == null) {
            return null;
        }
        return (Activity) weakReference.get();
    }

    private void c() {
        SystemManager.getInstance().notifyUpdateResult(8);
        a();
    }

    public static Object invokeMethod(String str, String str2, Object[] objArr) {
        try {
            return a(str, str2, objArr);
        } catch (Throwable th2) {
            HMSLog.e("UpdateAdapter", "invoke " + str + InstructionFileId.DOT + str2 + " fail. " + th2.getMessage());
            return null;
        }
    }

    public int getRequestCode() {
        return 1001;
    }

    public void onBridgeActivityCreate(Activity activity) {
        if (activity == null) {
            HMSLog.i("UpdateAdapter", "activity == null");
            c();
        } else if (activity.isFinishing()) {
            HMSLog.i("UpdateAdapter", "activity is finishing");
            c();
        } else {
            this.f37751b = activity.getApplicationContext();
            this.f37750a = new WeakReference<>(activity);
            if (c.f37823b.a(b())) {
                Intent intent = activity.getIntent();
                if (intent == null) {
                    c();
                    return;
                }
                try {
                    this.f37752c = intent.getIntExtra(CommonCode.MapKey.UPDATE_VERSION, 0);
                } catch (Throwable th2) {
                    HMSLog.e("UpdateAdapter", "get update_version:" + th2.getMessage());
                }
                if (this.f37752c == 0) {
                    c();
                    return;
                }
                if (intent.hasExtra("installHMS")) {
                    this.f37754e = true;
                }
                if (!a(intent, activity)) {
                    try {
                        if (AvailableUtil.isInstallerLibExist(this.f37751b)) {
                            UpdateBean updateBean = (UpdateBean) a("com.huawei.hms.adapter.ui.InstallerAdapter", "setUpdateBean", new Object[]{activity, Integer.valueOf(this.f37752c), Boolean.valueOf(this.f37754e)});
                            this.f37753d = updateBean;
                            a("com.huawei.hms.adapter.ui.InstallerAdapter", "startUpdateHms", new Object[]{activity, updateBean, 1001});
                            this.f37753d = null;
                        }
                    } catch (Throwable th3) {
                        HMSLog.e("UpdateAdapter", "InstallerAdapter.startUpdateHms is failed. message：" + th3.getMessage());
                        c();
                    }
                }
            }
        }
    }

    public void onBridgeActivityDestroy() {
        HMSLog.i("UpdateAdapter", "onBridgeActivityDestroy");
        c.f37823b.b(b());
        this.f37750a = null;
    }

    public boolean onBridgeActivityResult(int i11, int i12, Intent intent) {
        int i13;
        if (i11 != getRequestCode()) {
            this.f37753d = null;
            return false;
        }
        HMSLog.i("UpdateAdapter", "onBridgeActivityResult " + i12);
        if (AvailableUtil.isInstallerLibExist(this.f37751b) && i12 == 1214) {
            HMSLog.i("UpdateAdapter", "Enter update escape route");
            Activity b11 = b();
            if (b11 == null) {
                HMSLog.e("UpdateAdapter", "bridgeActivity is null, update escape failed ");
                this.f37753d = null;
                return true;
            }
            invokeMethod("com.huawei.hms.update.manager.UpdateManager", "startUpdate", new Object[]{b11, 1001, this.f37753d});
            this.f37753d = null;
        }
        if (i12 == -1) {
            if (intent != null) {
                try {
                    i13 = intent.getIntExtra(KpmsConstant.KIT_UPDATE_RESULT, 0);
                } catch (Throwable unused) {
                    HMSLog.w("UpdateAdapter", "get kit_update_result failed, throwable occur.");
                    i13 = 0;
                }
                if (i13 == 1) {
                    HMSLog.i("UpdateAdapter", "new framework update process,Error resolved successfully!");
                    SystemManager.getInstance().notifyUpdateResult(0);
                    this.f37753d = null;
                    a();
                    return true;
                }
                a(intent);
            }
        } else if (i12 == 0) {
            HMSLog.i("UpdateAdapter", "Activity.RESULT_CANCELED");
            this.f37753d = null;
            Activity b12 = b();
            if (b12 == null) {
                return true;
            }
            String hMSPackageName = HMSPackageManager.getInstance(b12.getApplicationContext()).getHMSPackageName();
            if (TextUtils.isEmpty(hMSPackageName)) {
                hMSPackageName = "com.huawei.hwid";
            }
            if (this.f37754e || a((Context) b12, hMSPackageName, this.f37752c)) {
                HMSLog.i("UpdateAdapter", "Resolve error, process canceled by user clicking back button!");
                SystemManager.getInstance().notifyUpdateResult(13);
            } else {
                SystemManager.getInstance().notifyUpdateResult(0);
            }
        } else if (i12 == 1) {
            SystemManager.getInstance().notifyUpdateResult(28);
        }
        a();
        return true;
    }

    public void onBridgeConfigurationChanged() {
        HMSLog.i("UpdateAdapter", "onBridgeConfigurationChanged");
    }

    public void onKeyUp(int i11, KeyEvent keyEvent) {
        HMSLog.i("UpdateAdapter", "On key up when resolve conn error");
    }

    private boolean a(Intent intent, Activity activity) {
        if (!intent.getBooleanExtra(CommonCode.MapKey.NEW_UPDATE, false)) {
            return false;
        }
        HMSLog.i("UpdateAdapter", "4.0 framework HMSCore upgrade process");
        String hMSPackageName = HMSPackageManager.getInstance(activity.getApplicationContext()).getHMSPackageName();
        if (TextUtils.isEmpty(hMSPackageName)) {
            HMSLog.w("UpdateAdapter", "hmsPackageName is empty, update invalid.");
            c();
            return true;
        }
        ComponentName componentName = new ComponentName(hMSPackageName, "com.huawei.hms.fwksdk.stub.UpdateStubActivity");
        Intent intent2 = new Intent();
        intent2.putExtra(KpmsConstant.CALLER_PACKAGE_NAME, activity.getApplicationContext().getPackageName());
        intent2.putExtra(KpmsConstant.UPDATE_PACKAGE_NAME, hMSPackageName);
        intent2.setComponent(componentName);
        activity.startActivityForResult(intent2, 1001);
        return true;
    }

    private void a(Intent intent) {
        int i11 = -1;
        try {
            i11 = intent.getIntExtra(BridgeActivity.EXTRA_RESULT, -1);
        } catch (Throwable unused) {
            HMSLog.w("UpdateAdapter", "get extra_result failed, throwable occur.");
        }
        if (i11 == 0) {
            HMSLog.i("UpdateAdapter", "Error resolved successfully!");
            SystemManager.getInstance().notifyUpdateResult(0);
        } else if (i11 == 13) {
            HMSLog.i("UpdateAdapter", "Resolve error process canceled by user!");
            SystemManager.getInstance().notifyUpdateResult(13);
        } else if (i11 == 8) {
            HMSLog.i("UpdateAdapter", "Internal error occurred, recommended retry.");
            SystemManager.getInstance().notifyUpdateResult(8);
        } else {
            HMSLog.i("UpdateAdapter", "Other error codes.");
            SystemManager.getInstance().notifyUpdateResult(i11);
        }
    }

    private void a() {
        Activity b11 = b();
        if (b11 != null && !b11.isFinishing()) {
            b11.finish();
        }
    }

    private boolean a(Context context, String str, int i11) {
        if (context == null || TextUtils.isEmpty(str) || i11 == 0) {
            HMSLog.w("UpdateAdapter", "Please check your params, one of params is invalid.");
            return false;
        }
        PackageManagerHelper packageManagerHelper = new PackageManagerHelper(context);
        if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(packageManagerHelper.getPackageStates(str))) {
            return true;
        }
        if (packageManagerHelper.getPackageVersionCode(str) < i11) {
            return true;
        }
        return false;
    }
}
