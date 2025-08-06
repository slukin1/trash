package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ProgressBar;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.base.R;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.api.internal.zabw;
import com.google.android.gms.common.api.internal.zabx;
import com.google.android.gms.common.api.internal.zacc;
import com.google.android.gms.common.internal.HideFirstParty;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.zac;
import com.google.android.gms.common.internal.zag;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.InstantApps;
import com.google.android.gms.internal.base.zal;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sumsub.sns.internal.core.data.source.dynamic.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class GoogleApiAvailability extends GoogleApiAvailabilityLight {
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    private static final Object zaa = new Object();
    private static final GoogleApiAvailability zab = new GoogleApiAvailability();
    private String zac;

    public static GoogleApiAvailability getInstance() {
        return zab;
    }

    public static final Task<Map<ApiKey<?>, String>> zai(HasApiKey<?> hasApiKey, HasApiKey<?>... hasApiKeyArr) {
        Preconditions.checkNotNull(hasApiKey, "Requested API must not be null.");
        for (HasApiKey<?> checkNotNull : hasApiKeyArr) {
            Preconditions.checkNotNull(checkNotNull, "Requested API must not be null.");
        }
        ArrayList arrayList = new ArrayList(hasApiKeyArr.length + 1);
        arrayList.add(hasApiKey);
        arrayList.addAll(Arrays.asList(hasApiKeyArr));
        return GoogleApiManager.zal().zao(arrayList);
    }

    public Task<Void> checkApiAvailability(GoogleApi<?> googleApi, GoogleApi<?>... googleApiArr) {
        return zai(googleApi, googleApiArr).onSuccessTask(zab.zaa);
    }

    @ShowFirstParty
    @KeepForSdk
    public int getClientVersion(Context context) {
        return super.getClientVersion(context);
    }

    public Dialog getErrorDialog(Activity activity, int i11, int i12) {
        return getErrorDialog(activity, i11, i12, (DialogInterface.OnCancelListener) null);
    }

    @ShowFirstParty
    @KeepForSdk
    public Intent getErrorResolutionIntent(Context context, int i11, String str) {
        return super.getErrorResolutionIntent(context, i11, str);
    }

    public PendingIntent getErrorResolutionPendingIntent(Context context, int i11, int i12) {
        return super.getErrorResolutionPendingIntent(context, i11, i12);
    }

    public final String getErrorString(int i11) {
        return super.getErrorString(i11);
    }

    @HideFirstParty
    public int isGooglePlayServicesAvailable(Context context) {
        return super.isGooglePlayServicesAvailable(context);
    }

    public final boolean isUserResolvableError(int i11) {
        return super.isUserResolvableError(i11);
    }

    public Task<Void> makeGooglePlayServicesAvailable(Activity activity) {
        int i11 = GOOGLE_PLAY_SERVICES_VERSION_CODE;
        Preconditions.checkMainThread("makeGooglePlayServicesAvailable must be called from the main thread");
        int isGooglePlayServicesAvailable = isGooglePlayServicesAvailable(activity, i11);
        if (isGooglePlayServicesAvailable == 0) {
            return Tasks.forResult(null);
        }
        zacc zaa2 = zacc.zaa(activity);
        zaa2.zah(new ConnectionResult(isGooglePlayServicesAvailable, (PendingIntent) null), 0);
        return zaa2.zad();
    }

    @TargetApi(26)
    public void setDefaultNotificationChannelId(Context context, String str) {
        if (PlatformVersion.isAtLeastO()) {
            Preconditions.checkNotNull(((NotificationManager) Preconditions.checkNotNull(context.getSystemService(RemoteMessageConst.NOTIFICATION))).getNotificationChannel(str));
        }
        synchronized (zaa) {
            this.zac = str;
        }
    }

    public boolean showErrorDialogFragment(Activity activity, int i11, int i12) {
        return showErrorDialogFragment(activity, i11, i12, (DialogInterface.OnCancelListener) null);
    }

    public void showErrorNotification(Context context, int i11) {
        zae(context, i11, (String) null, getErrorResolutionPendingIntent(context, i11, 0, GoogleApiAvailabilityLight.TRACKING_SOURCE_NOTIFICATION));
    }

    public final Dialog zaa(Context context, int i11, zag zag, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = null;
        if (i11 == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16843529, typedValue, true);
        if ("Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId))) {
            builder = new AlertDialog.Builder(context, 5);
        }
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(zac.zad(context, i11));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String zac2 = zac.zac(context, i11);
        if (zac2 != null) {
            builder.setPositiveButton(zac2, zag);
        }
        String zag2 = zac.zag(context, i11);
        if (zag2 != null) {
            builder.setTitle(zag2);
        }
        Log.w("GoogleApiAvailability", String.format("Creating dialog for Google Play services availability issue. ConnectionResult=%s", new Object[]{Integer.valueOf(i11)}), new IllegalArgumentException());
        return builder.create();
    }

    public final Dialog zab(Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        ProgressBar progressBar = new ProgressBar(activity, (AttributeSet) null, 16842874);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(zac.zad(activity, 18));
        builder.setPositiveButton("", (DialogInterface.OnClickListener) null);
        AlertDialog create = builder.create();
        zad(activity, create, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return create;
    }

    public final zabx zac(Context context, zabw zabw) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        zabx zabx = new zabx(zabw);
        context.registerReceiver(zabx, intentFilter);
        zabx.zaa(context);
        if (isUninstalledAppPossiblyUpdating(context, "com.google.android.gms")) {
            return zabx;
        }
        zabw.zaa();
        zabx.zab();
        return null;
    }

    public final void zad(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (activity instanceof FragmentActivity) {
                SupportErrorDialogFragment.newInstance(dialog, onCancelListener).show(((FragmentActivity) activity).getSupportFragmentManager(), str);
                return;
            }
        } catch (NoClassDefFoundError unused) {
        }
        ErrorDialogFragment.newInstance(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    @TargetApi(20)
    public final void zae(Context context, int i11, String str, PendingIntent pendingIntent) {
        int i12;
        String str2;
        Log.w("GoogleApiAvailability", String.format("GMS core API Availability. ConnectionResult=%s, tag=%s", new Object[]{Integer.valueOf(i11), null}), new IllegalArgumentException());
        if (i11 == 18) {
            zaf(context);
        } else if (pendingIntent != null) {
            String zaf = zac.zaf(context, i11);
            String zae = zac.zae(context, i11);
            Resources resources = context.getResources();
            NotificationManager notificationManager = (NotificationManager) Preconditions.checkNotNull(context.getSystemService(RemoteMessageConst.NOTIFICATION));
            NotificationCompat.e c02 = new NotificationCompat.e(context).L(true).r(true).C(zaf).c0(new NotificationCompat.BigTextStyle().y(zae));
            if (DeviceProperties.isWearable(context)) {
                Preconditions.checkState(PlatformVersion.isAtLeastKitKatWatch());
                c02.X(context.getApplicationInfo().icon).Q(2);
                if (DeviceProperties.isWearableWithoutPlayStore(context)) {
                    c02.a(R.drawable.common_full_open_on_phone, resources.getString(R.string.common_open_on_phone), pendingIntent);
                } else {
                    c02.A(pendingIntent);
                }
            } else {
                c02.X(17301642).e0(resources.getString(R.string.common_google_play_services_notification_ticker)).j0(System.currentTimeMillis()).A(pendingIntent).B(zae);
            }
            if (PlatformVersion.isAtLeastO()) {
                Preconditions.checkState(PlatformVersion.isAtLeastO());
                synchronized (zaa) {
                    str2 = this.zac;
                }
                if (str2 == null) {
                    str2 = "com.google.android.gms.availability";
                    NotificationChannel notificationChannel = notificationManager.getNotificationChannel(str2);
                    String zab2 = zac.zab(context);
                    if (notificationChannel == null) {
                        notificationManager.createNotificationChannel(new NotificationChannel(str2, zab2, 4));
                    } else if (!zab2.contentEquals(notificationChannel.getName())) {
                        notificationChannel.setName(zab2);
                        notificationManager.createNotificationChannel(notificationChannel);
                    }
                }
                c02.v(str2);
            }
            Notification g11 = c02.g();
            if (i11 == 1 || i11 == 2 || i11 == 3) {
                GooglePlayServicesUtilLight.sCanceledAvailabilityNotification.set(false);
                i12 = GooglePlayServicesUtilLight.GMS_AVAILABILITY_NOTIFICATION_ID;
            } else {
                i12 = GooglePlayServicesUtilLight.GMS_GENERAL_ERROR_NOTIFICATION_ID;
            }
            notificationManager.notify(i12, g11);
        } else if (i11 == 6) {
            Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
        }
    }

    public final void zaf(Context context) {
        new zac(this, context).sendEmptyMessageDelayed(1, c.f33305t);
    }

    public final boolean zag(Activity activity, LifecycleFragment lifecycleFragment, int i11, int i12, DialogInterface.OnCancelListener onCancelListener) {
        Dialog zaa2 = zaa(activity, i11, zag.zad(lifecycleFragment, getErrorResolutionIntent(activity, i11, GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG), 2), onCancelListener);
        if (zaa2 == null) {
            return false;
        }
        zad(activity, zaa2, GooglePlayServicesUtil.GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    public final boolean zah(Context context, ConnectionResult connectionResult, int i11) {
        PendingIntent errorResolutionPendingIntent;
        if (InstantApps.isInstantApp(context) || (errorResolutionPendingIntent = getErrorResolutionPendingIntent(context, connectionResult)) == null) {
            return false;
        }
        zae(context, connectionResult.getErrorCode(), (String) null, zal.zaa(context, 0, GoogleApiActivity.zaa(context, errorResolutionPendingIntent, i11, true), zal.zaa | 134217728));
        return true;
    }

    public Dialog getErrorDialog(Activity activity, int i11, int i12, DialogInterface.OnCancelListener onCancelListener) {
        return zaa(activity, i11, zag.zab(activity, getErrorResolutionIntent(activity, i11, GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG), i12), onCancelListener);
    }

    public PendingIntent getErrorResolutionPendingIntent(Context context, ConnectionResult connectionResult) {
        if (connectionResult.hasResolution()) {
            return connectionResult.getResolution();
        }
        return getErrorResolutionPendingIntent(context, connectionResult.getErrorCode(), 0);
    }

    @ShowFirstParty
    @KeepForSdk
    public int isGooglePlayServicesAvailable(Context context, int i11) {
        return super.isGooglePlayServicesAvailable(context, i11);
    }

    public boolean showErrorDialogFragment(Activity activity, int i11, int i12, DialogInterface.OnCancelListener onCancelListener) {
        Dialog errorDialog = getErrorDialog(activity, i11, i12, onCancelListener);
        if (errorDialog == null) {
            return false;
        }
        zad(activity, errorDialog, GooglePlayServicesUtil.GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    public Task<Void> checkApiAvailability(HasApiKey<?> hasApiKey, HasApiKey<?>... hasApiKeyArr) {
        return zai(hasApiKey, hasApiKeyArr).onSuccessTask(zaa.zaa);
    }

    public void showErrorNotification(Context context, ConnectionResult connectionResult) {
        zae(context, connectionResult.getErrorCode(), (String) null, getErrorResolutionPendingIntent(context, connectionResult));
    }

    public Dialog getErrorDialog(Fragment fragment, int i11, int i12) {
        return getErrorDialog(fragment, i11, i12, (DialogInterface.OnCancelListener) null);
    }

    public Dialog getErrorDialog(Fragment fragment, int i11, int i12, DialogInterface.OnCancelListener onCancelListener) {
        return zaa(fragment.requireContext(), i11, zag.zac(fragment, getErrorResolutionIntent(fragment.requireContext(), i11, GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG), i12), onCancelListener);
    }
}
