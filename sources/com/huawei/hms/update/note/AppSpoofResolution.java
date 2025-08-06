package com.huawei.hms.update.note;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.ui.AbstractDialog;
import com.huawei.hms.ui.AbstractPromptDialog;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.ResourceLoaderUtil;

public class AppSpoofResolution implements IBridgeActivityDelegate {

    /* renamed from: a  reason: collision with root package name */
    private Activity f38544a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public b f38545b;

    public class a implements AbstractDialog.Callback {
        public a() {
        }

        public void onCancel(AbstractDialog abstractDialog) {
            com.huawei.hms.availableupdate.a.f37816c.a(true);
            b unused = AppSpoofResolution.this.f38545b = null;
            AppSpoofResolution.this.a();
        }

        public void onDoWork(AbstractDialog abstractDialog) {
            com.huawei.hms.availableupdate.a.f37816c.a(true);
            b unused = AppSpoofResolution.this.f38545b = null;
            AppSpoofResolution.this.a();
        }
    }

    public static class b extends AbstractPromptDialog {
        private b() {
        }

        public String onGetMessageString(Context context) {
            String str = "com.huawei.hwid";
            String applicationName = new PackageManagerHelper(context).getApplicationName(str);
            if (!TextUtils.isEmpty(applicationName)) {
                str = applicationName;
            }
            if (ResourceLoaderUtil.getmContext() == null) {
                ResourceLoaderUtil.setmContext(context);
            }
            return ResourceLoaderUtil.getString("hms_is_spoof", str);
        }

        public String onGetPositiveButtonString(Context context) {
            if (ResourceLoaderUtil.getmContext() == null) {
                ResourceLoaderUtil.setmContext(context);
            }
            return ResourceLoaderUtil.getString("hms_confirm");
        }

        public String onGetTitleString(Context context) {
            if (ResourceLoaderUtil.getmContext() == null) {
                ResourceLoaderUtil.setmContext(context);
            }
            return ResourceLoaderUtil.getString("hms_spoof_hints");
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    private void b() {
        Activity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            b bVar = this.f38545b;
            if (bVar == null) {
                this.f38545b = new b((a) null);
            } else {
                bVar.dismiss();
            }
            HMSLog.i("AppSpoofResolution", "enter AppSpoofResolution showPromptdlg to resolve conn error");
            this.f38545b.show(activity, new a());
        }
    }

    public Activity getActivity() {
        return this.f38544a;
    }

    public int getRequestCode() {
        return 0;
    }

    public void onBridgeActivityCreate(Activity activity) {
        HMSLog.i("AppSpoofResolution", "enter AppSpoofResolution onBridgeActivityCreate");
        if (activity == null || activity.isFinishing()) {
            HMSLog.e("AppSpoofResolution", "activity is null or finishing");
            return;
        }
        this.f38544a = activity;
        com.huawei.hms.availableupdate.a aVar = com.huawei.hms.availableupdate.a.f37816c;
        aVar.a(activity);
        aVar.a(false);
        b();
    }

    public void onBridgeActivityDestroy() {
        HMSLog.i("AppSpoofResolution", "enter AppSpoofResolution onBridgeActivityDestroy");
        com.huawei.hms.availableupdate.a aVar = com.huawei.hms.availableupdate.a.f37816c;
        if (aVar.a().compareAndSet(true, false)) {
            SystemManager.getInstance().notifyNoticeResult(29);
        }
        aVar.b(this.f38544a);
        this.f38544a = null;
    }

    public boolean onBridgeActivityResult(int i11, int i12, Intent intent) {
        if (i11 != getRequestCode()) {
            return false;
        }
        HMSLog.i("AppSpoofResolution", "enter AppSpoofResolution onBridgeActivityResult");
        return true;
    }

    public void onBridgeConfigurationChanged() {
        if (this.f38545b != null) {
            HMSLog.i("AppSpoofResolution", "enter AppSpoofResolution re show prompt dialog");
            b();
        }
    }

    public void onKeyUp(int i11, KeyEvent keyEvent) {
        HMSLog.i("AppSpoofResolution", "enter AppSpoofResolution On key up when resolve spoof error");
    }

    /* access modifiers changed from: private */
    public void a() {
        Activity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            HMSLog.i("AppSpoofResolution", "enter AppSpoofResolution finishBridgeActivity：");
            if (com.huawei.hms.availableupdate.a.f37816c.a().compareAndSet(true, false)) {
                SystemManager.getInstance().notifyNoticeResult(29);
            }
            activity.finish();
        }
    }
}
