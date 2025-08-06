package com.huawei.hms.adapter.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.ui.NotInstalledHmsDialogHelper;

public class NotInstalledHmsAdapter implements IBridgeActivityDelegate {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f37744c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static boolean f37745d;

    /* renamed from: a  reason: collision with root package name */
    private Activity f37746a;

    /* renamed from: b  reason: collision with root package name */
    private Dialog f37747b;

    public static class a implements DialogInterface.OnCancelListener {

        /* renamed from: a  reason: collision with root package name */
        private final Activity f37748a;

        public a(Activity activity) {
            this.f37748a = activity;
        }

        public void onCancel(DialogInterface dialogInterface) {
            HMSLog.i("NotInstalledHmsAdapter", "<Dialog onCancel>");
            SystemManager.getInstance().notifyUpdateResult(13);
            this.f37748a.finish();
        }
    }

    public static class b implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        private final Activity f37749a;

        public b(Activity activity) {
            this.f37749a = activity;
        }

        public void onClick(DialogInterface dialogInterface, int i11) {
            HMSLog.i("NotInstalledHmsAdapter", "<Dialog onClick>");
            SystemManager.getInstance().notifyUpdateResult(30);
            this.f37749a.finish();
        }
    }

    private void a(Activity activity) {
        Dialog dialog = this.f37747b;
        if (dialog != null && dialog.isShowing()) {
            this.f37747b.setOnCancelListener((DialogInterface.OnCancelListener) null);
            this.f37747b.cancel();
        }
        this.f37747b = NotInstalledHmsDialogHelper.getDialogBuilder(activity).setPositiveButton(NotInstalledHmsDialogHelper.getConfirmResId(activity), new b(activity)).setOnCancelListener(new a(activity)).show();
    }

    public static boolean getShowLock() {
        synchronized (f37744c) {
            HMSLog.i("NotInstalledHmsAdapter", "<canShowDialog> sIsShowingDialog: " + f37745d);
            if (f37745d) {
                return false;
            }
            f37745d = true;
            return true;
        }
    }

    public int getRequestCode() {
        HMSLog.i("NotInstalledHmsAdapter", "<getRequestCode>");
        return 0;
    }

    public void onBridgeActivityCreate(Activity activity) {
        HMSLog.i("NotInstalledHmsAdapter", "<onBridgeActivityCreate>");
        if (activity == null || activity.isFinishing()) {
            HMSLog.e("NotInstalledHmsAdapter", "<onBridgeActivityCreate> activity is null or finishing");
            return;
        }
        this.f37746a = activity;
        a(activity);
    }

    public void onBridgeActivityDestroy() {
        HMSLog.i("NotInstalledHmsAdapter", "<onBridgeActivityDestroy>");
        synchronized (f37744c) {
            f37745d = false;
        }
    }

    public boolean onBridgeActivityResult(int i11, int i12, Intent intent) {
        HMSLog.i("NotInstalledHmsAdapter", "<onBridgeActivityResult>");
        return false;
    }

    public void onBridgeConfigurationChanged() {
        HMSLog.i("NotInstalledHmsAdapter", "<onBridgeConfigurationChanged>");
        Activity activity = this.f37746a;
        if (activity == null || activity.isFinishing()) {
            HMSLog.e("NotInstalledHmsAdapter", "<onBridgeConfigurationChanged> mActivity is null or finishing");
        } else {
            a(this.f37746a);
        }
    }

    public void onKeyUp(int i11, KeyEvent keyEvent) {
        HMSLog.i("NotInstalledHmsAdapter", "<onKeyUp>");
    }
}
