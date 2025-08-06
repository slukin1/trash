package com.huawei.hms.api;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.activity.EnableServiceActivity;
import com.huawei.hms.activity.ForegroundIntentBuilder;
import com.huawei.hms.activity.internal.BusResponseCallback;
import com.huawei.hms.activity.internal.BusResponseResult;
import com.huawei.hms.adapter.AvailableUtil;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.adapter.ui.UpdateAdapter;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.ErrorDialogFragment;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.api.AvailabilityException;
import com.huawei.hms.common.api.HuaweiApiCallable;
import com.huawei.hms.common.internal.ConnectionErrorMessages;
import com.huawei.hms.common.internal.DialogRedirect;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.note.AppSpoofResolution;
import com.huawei.hms.update.note.DoNothingResolution;
import com.huawei.hms.update.note.NotInstalledHmsResolution;
import com.huawei.hms.update.ui.UpdateBean;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.hms.utils.UIUtil;
import com.huawei.hms.utils.Util;

final class HuaweiApiAvailabilityImpl extends HuaweiApiAvailability {

    /* renamed from: a  reason: collision with root package name */
    private static final HuaweiApiAvailabilityImpl f37768a = new HuaweiApiAvailabilityImpl();

    public class a implements BusResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TaskCompletionSource[] f37769a;

        public a(TaskCompletionSource[] taskCompletionSourceArr) {
            this.f37769a = taskCompletionSourceArr;
        }

        public BusResponseResult innerError(Activity activity, int i11, String str) {
            HMSLog.e("HuaweiApiAvailabilityImpl", "Test foreground bus error: resultCode " + i11 + ", errMessage" + str);
            this.f37769a[0].c(new AvailabilityException());
            return null;
        }

        public BusResponseResult succeedReturn(Activity activity, int i11, Intent intent) {
            HMSLog.i("HuaweiApiAvailabilityImpl", "Test foreground bus success: resultCode " + i11 + ", data" + intent);
            return null;
        }
    }

    private HuaweiApiAvailabilityImpl() {
    }

    private static Intent a(Activity activity, String str) {
        return BridgeActivity.getIntentStartBridgeActivity(activity, str);
    }

    public static HuaweiApiAvailabilityImpl getInstance() {
        return f37768a;
    }

    public Task<Void> checkApiAccessible(HuaweiApi<?> huaweiApi, HuaweiApi<?>... huaweiApiArr) {
        Task<Void> b11 = new TaskCompletionSource().b();
        if (huaweiApi != null) {
            try {
                a((Object) huaweiApi);
            } catch (AvailabilityException e11) {
                HMSLog.i("HuaweiApiAvailabilityImpl", "checkApi has AvailabilityException " + e11.getMessage());
            }
        }
        if (huaweiApiArr != null) {
            for (HuaweiApi<?> a11 : huaweiApiArr) {
                a((Object) a11);
            }
        }
        return b11;
    }

    public PendingIntent getErrPendingIntent(Context context, ConnectionResult connectionResult) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(connectionResult);
        return getResolveErrorPendingIntent(context, connectionResult.getErrorCode());
    }

    public Dialog getErrorDialog(Activity activity, int i11, int i12) {
        Checker.checkNonNull(activity, "activity must not be null.");
        HMSLog.i("HuaweiApiAvailabilityImpl", "Enter getErrorDialog, errorCode: " + i11);
        return getErrorDialog(activity, i11, i12, (DialogInterface.OnCancelListener) null);
    }

    public String getErrorString(int i11) {
        HMSLog.i("HuaweiApiAvailabilityImpl", "Enter getErrorString, errorCode: " + i11);
        return ConnectionResult.getErrorString(i11);
    }

    public Task<Void> getHuaweiServicesReady(Activity activity) {
        Preconditions.checkNotNull(activity);
        TaskCompletionSource[] taskCompletionSourceArr = {new TaskCompletionSource()};
        Task<Void> b11 = taskCompletionSourceArr[0].b();
        int isHuaweiMobileServicesAvailable = isHuaweiMobileServicesAvailable(activity.getApplicationContext(), 30000000);
        Intent resolveErrorIntent = getResolveErrorIntent(activity, isHuaweiMobileServicesAvailable);
        Intent intentStartBridgeActivity = BridgeActivity.getIntentStartBridgeActivity(activity, ResolutionDelegate.class.getName());
        if (resolveErrorIntent != null) {
            ForegroundIntentBuilder.registerResponseCallback(ResolutionDelegate.CALLBACK_METHOD, new a(taskCompletionSourceArr));
            Bundle bundle = new Bundle();
            bundle.putParcelable(CommonCode.MapKey.HAS_RESOLUTION, resolveErrorIntent);
            intentStartBridgeActivity.putExtras(bundle);
            activity.startActivity(intentStartBridgeActivity);
        } else if (isHuaweiMobileServicesAvailable == 3) {
            Intent intent = new Intent();
            intent.setClass(activity, EnableServiceActivity.class);
            activity.startActivity(intent);
        } else if (isHuaweiMobileServicesAvailable == 0) {
            HMSLog.i("HuaweiApiAvailabilityImpl", "The HMS service is available.");
        } else {
            HMSLog.e("HuaweiApiAvailabilityImpl", "Framework can not solve the availability problem.");
            taskCompletionSourceArr[0].c(new AvailabilityException());
        }
        return b11;
    }

    public Intent getResolveErrorIntent(Activity activity, int i11) {
        HMSLog.i("HuaweiApiAvailabilityImpl", "Enter getResolveErrorIntent, errorCode: " + i11);
        if (activity == null) {
            return null;
        }
        if (i11 == 1 || i11 == 2) {
            if (!Util.isAvailableLibExist(activity) || !AvailableUtil.isInstallerLibExist(activity)) {
                return a(activity, NotInstalledHmsResolution.class.getName());
            }
            return (Intent) UpdateAdapter.invokeMethod("com.huawei.hms.update.manager.UpdateManager", "getStartUpdateIntent", new Object[]{activity, a(activity.getApplicationContext())});
        } else if (i11 == 6) {
            return a(activity, BindingFailedResolution.class.getName());
        } else {
            if (i11 == 9 && Util.isAvailableLibExist(activity)) {
                return a(activity, AppSpoofResolution.class.getName());
            }
            return null;
        }
    }

    public PendingIntent getResolveErrorPendingIntent(Activity activity, int i11) {
        HMSLog.i("HuaweiApiAvailabilityImpl", "Enter getResolveErrorPendingIntent, errorCode: " + i11);
        Intent resolveErrorIntent = getResolveErrorIntent(activity, i11);
        if (resolveErrorIntent != null) {
            return PendingIntent.getActivity(activity, 0, resolveErrorIntent, 67108864);
        }
        return null;
    }

    public int isHuaweiMobileNoticeAvailable(Context context) {
        Checker.checkNonNull(context, "context must not be null.");
        PackageManagerHelper packageManagerHelper = new PackageManagerHelper(context);
        String hMSPackageNameForMultiService = HMSPackageManager.getInstance(context).getHMSPackageNameForMultiService();
        if (TextUtils.isEmpty(hMSPackageNameForMultiService)) {
            HMSLog.w("HuaweiApiAvailabilityImpl", "hmsPackageName is empty, Service is invalid.");
            return 1;
        }
        if (!PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(packageManagerHelper.getPackageStates(hMSPackageNameForMultiService))) {
            return HMSPackageManager.getInstance(context).isApkUpdateNecessary(20600000) ? 2 : 0;
        }
        HMSLog.w("HuaweiApiAvailabilityImpl", "hmsPackageName is not installed, Service is invalid.");
        return 1;
    }

    public int isHuaweiMobileServicesAvailable(Context context) {
        Checker.checkNonNull(context, "context must not be null.");
        return HuaweiMobileServicesUtil.isHuaweiMobileServicesAvailable(context, HuaweiApiAvailability.getServicesVersionCode());
    }

    public boolean isUserResolvableError(int i11) {
        return isUserResolvableError(i11, (PendingIntent) null);
    }

    public boolean isUserResolvableError(int i11, PendingIntent pendingIntent) {
        if (i11 == 0) {
            return false;
        }
        return pendingIntent != null || i11 == 1 || i11 == 2 || i11 == 6 || i11 == 9;
    }

    public void popupErrNotification(Context context, ConnectionResult connectionResult) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(connectionResult);
        showErrorNotification(context, connectionResult.getErrorCode());
    }

    public void resolveError(Activity activity, int i11, int i12) {
        resolveError(activity, i11, i12, (PendingIntent) null);
    }

    public boolean showErrorDialogFragment(Activity activity, int i11, int i12) {
        return showErrorDialogFragment(activity, i11, i12, (DialogInterface.OnCancelListener) null);
    }

    public void showErrorNotification(Context context, int i11) {
        Checker.checkNonNull(context, "context must not be null.");
        HMSLog.i("HuaweiApiAvailabilityImpl", "Enter showErrorNotification, errorCode: " + i11);
        if (!(context instanceof Activity)) {
            HMSLog.i("HuaweiApiAvailabilityImpl", "context not instanceof Activity");
            return;
        }
        Dialog errorDialog = getErrorDialog((Activity) context, i11, 0);
        if (errorDialog == null) {
            HMSLog.i("HuaweiApiAvailabilityImpl", "showErrorNotification errorDialog can not be null");
        } else {
            errorDialog.show();
        }
    }

    private static Intent a(Context context, String str) {
        return BridgeActivity.getIntentStartBridgeActivity(context, str);
    }

    public void resolveError(Activity activity, int i11, int i12, PendingIntent pendingIntent) {
        Checker.checkNonNull(activity, "activity must not be null.");
        if (pendingIntent != null) {
            HMSLog.i("HuaweiApiAvailabilityImpl", "Enter resolveError, param pendingIntent is not null. and.errorCode: " + i11);
        } else {
            HMSLog.i("HuaweiApiAvailabilityImpl", "Enter resolveError, param pendingIntent is  null. get pendingIntent from error code.and.errorCode: " + i11);
            pendingIntent = getResolveErrorPendingIntent(activity, i11);
        }
        if (pendingIntent != null) {
            HMSLog.i("HuaweiApiAvailabilityImpl", "In resolveError, start pendingIntent.errorCode: " + i11);
            try {
                activity.startIntentSenderForResult(pendingIntent.getIntentSender(), i12, (Intent) null, 0, 0, 0);
            } catch (IntentSender.SendIntentException unused) {
                HMSLog.e("HuaweiApiAvailabilityImpl", "Enter resolveError, start pendingIntent failed.errorCode: " + i11);
            }
        }
    }

    public boolean showErrorDialogFragment(Activity activity, int i11, int i12, DialogInterface.OnCancelListener onCancelListener) {
        Dialog errorDialog = getErrorDialog(activity, i11, i12, onCancelListener);
        if (errorDialog == null) {
            return false;
        }
        a(activity, errorDialog, HuaweiMobileServicesUtil.HMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    private UpdateBean a(Context context) {
        UpdateBean updateBean = new UpdateBean();
        updateBean.setHmsOrApkUpgrade(true);
        updateBean.setClientPackageName(HMSPackageManager.getInstance(context).getHMSPackageName());
        if (TextUtils.isEmpty(updateBean.getClientPackageName())) {
            updateBean.setClientPackageName("com.huawei.hwid");
        }
        updateBean.setClientVersionCode(HuaweiApiAvailability.getServicesVersionCode());
        updateBean.setClientAppId("C10132067");
        if (ResourceLoaderUtil.getmContext() == null) {
            ResourceLoaderUtil.setmContext(context);
        }
        try {
            updateBean.setClientAppName(ResourceLoaderUtil.getString("hms_update_title"));
        } catch (Exception e11) {
            HMSLog.e("HuaweiApiAvailabilityImpl", "getString has Exception:" + e11.getMessage());
        }
        return updateBean;
    }

    public Dialog getErrorDialog(Activity activity, int i11, int i12, DialogInterface.OnCancelListener onCancelListener) {
        Checker.checkNonNull(activity, "activity must not be null.");
        HMSLog.i("HuaweiApiAvailabilityImpl", "Enter getErrorDialog, errorCode: " + i11);
        return a(activity, i11, DialogRedirect.getInstance(activity, a(activity, i11), i12), onCancelListener);
    }

    public PendingIntent getResolveErrorPendingIntent(Context context, int i11) {
        HMSLog.i("HuaweiApiAvailabilityImpl", "Enter getResolveErrorPendingIntent, errorCode: " + i11);
        Intent resolveErrorIntent = getResolveErrorIntent(context, i11);
        if (resolveErrorIntent != null) {
            return PendingIntent.getActivity(context, 0, resolveErrorIntent, 67108864);
        }
        return null;
    }

    public int isHuaweiMobileServicesAvailable(Context context, int i11) {
        Checker.checkNonNull(context, "context must not be null.");
        return HuaweiMobileServicesUtil.isHuaweiMobileServicesAvailable(context, i11);
    }

    public boolean showErrorDialogFragment(Activity activity, int i11, Fragment fragment, int i12, DialogInterface.OnCancelListener onCancelListener) {
        return showErrorDialogFragment(activity, i11, i12, onCancelListener);
    }

    public PendingIntent getErrPendingIntent(Context context, int i11, int i12) {
        HMSLog.i("HuaweiApiAvailabilityImpl", "Enter getResolveErrorPendingIntent, errorCode: " + i11 + " requestCode: " + i12);
        Intent resolveErrorIntent = getResolveErrorIntent(context, i11);
        if (resolveErrorIntent != null) {
            return PendingIntent.getActivity(context, i12, resolveErrorIntent, 67108864);
        }
        return null;
    }

    public Task<Void> checkApiAccessible(HuaweiApiCallable huaweiApiCallable, HuaweiApiCallable... huaweiApiCallableArr) {
        Task<Void> b11 = new TaskCompletionSource().b();
        if (huaweiApiCallable != null) {
            try {
                a((Object) huaweiApiCallable);
            } catch (AvailabilityException e11) {
                HMSLog.i("HuaweiApiAvailabilityImpl", "HuaweiApiCallable checkApi has AvailabilityException " + e11.getMessage());
            }
        }
        if (huaweiApiCallableArr != null) {
            for (HuaweiApiCallable a11 : huaweiApiCallableArr) {
                a((Object) a11);
            }
        }
        return b11;
    }

    public Intent getResolveErrorIntent(Context context, int i11) {
        HMSLog.i("HuaweiApiAvailabilityImpl", "Enter getResolveErrorIntent, errorCode: " + i11);
        if (i11 == 1 || i11 == 2) {
            if (!Util.isAvailableLibExist(context) || !AvailableUtil.isInstallerLibExist(context)) {
                return a(context, NotInstalledHmsResolution.class.getName());
            }
            return (Intent) UpdateAdapter.invokeMethod("com.huawei.hms.update.manager.UpdateManager", "getStartUpdateIntent", new Object[]{context, a(context.getApplicationContext())});
        } else if (i11 == 6) {
            return a(context, BindingFailedResolution.class.getName());
        } else {
            if (i11 == 9 && Util.isAvailableLibExist(context)) {
                return a(context, AppSpoofResolution.class.getName());
            }
            return null;
        }
    }

    private Intent a(Activity activity, int i11) {
        HMSLog.i("HuaweiApiAvailabilityImpl", "getErrorResolutionIntent, errorCode: " + i11);
        if (i11 == 1 || i11 == 2) {
            if (!Util.isAvailableLibExist(activity) || !AvailableUtil.isInstallerLibExist(activity)) {
                return BridgeActivity.getIntentStartBridgeActivity(activity, DoNothingResolution.class.getName());
            }
            return (Intent) UpdateAdapter.invokeMethod("com.huawei.hms.update.manager.UpdateManager", "startUpdateIntent", new Object[]{activity});
        } else if (i11 == 6) {
            return BridgeActivity.getIntentStartBridgeActivity(activity, BindingFailedResolution.class.getName());
        } else {
            if (i11 == 9 && Util.isAvailableLibExist(activity)) {
                return BridgeActivity.getIntentStartBridgeActivity(activity, AppSpoofResolution.class.getName());
            }
            return null;
        }
    }

    private static Dialog a(Activity activity, int i11, DialogRedirect dialogRedirect, DialogInterface.OnCancelListener onCancelListener) {
        if (i11 == 0) {
            return null;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, UIUtil.getDialogThemeId(activity));
        builder.setMessage(ConnectionErrorMessages.getErrorMessage(activity, i11));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        builder.setPositiveButton(ConnectionErrorMessages.getErrorDialogButtonMessage(activity, i11), dialogRedirect);
        if (!Util.isAvailableLibExist(activity) || !AvailableUtil.isInstallerLibExist(activity)) {
            String errorTitle = ConnectionErrorMessages.getErrorTitle(activity, i11);
            if (errorTitle != null) {
                builder.setTitle(errorTitle);
            }
        } else {
            String errorTitle2 = ConnectionErrorMessages.getErrorTitle(activity, i11);
            if (errorTitle2 != null) {
                builder.setTitle(errorTitle2);
            }
        }
        return builder.create();
    }

    private static void a(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        Checker.checkNonNull(activity, "activity must not be null.");
        ErrorDialogFragment.newInstance(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    private void a(Object obj) throws AvailabilityException {
        ConnectionResult connectionResult;
        AvailabilityException availabilityException = new AvailabilityException();
        if (obj instanceof HuaweiApi) {
            connectionResult = availabilityException.getConnectionResult((HuaweiApi<? extends Api.ApiOptions>) (HuaweiApi) obj);
        } else {
            connectionResult = availabilityException.getConnectionResult((HuaweiApiCallable) obj);
        }
        if (connectionResult.getErrorCode() != 0) {
            HMSLog.i("HuaweiApiAvailabilityImpl", "The service is unavailable: " + availabilityException.getMessage());
            throw availabilityException;
        }
    }
}
