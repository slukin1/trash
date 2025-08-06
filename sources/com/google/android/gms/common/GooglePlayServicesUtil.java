package com.google.android.gms.common;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.HideFirstParty;
import com.google.android.gms.common.internal.zag;
import com.google.android.gms.common.util.VisibleForTesting;

public final class GooglePlayServicesUtil extends GooglePlayServicesUtilLight {
    public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";

    private GooglePlayServicesUtil() {
    }

    @Deprecated
    public static Dialog getErrorDialog(int i11, Activity activity, int i12) {
        return getErrorDialog(i11, activity, i12, (DialogInterface.OnCancelListener) null);
    }

    @Deprecated
    public static PendingIntent getErrorPendingIntent(int i11, Context context, int i12) {
        return GooglePlayServicesUtilLight.getErrorPendingIntent(i11, context, i12);
    }

    @Deprecated
    @VisibleForTesting
    public static String getErrorString(int i11) {
        return GooglePlayServicesUtilLight.getErrorString(i11);
    }

    public static Context getRemoteContext(Context context) {
        return GooglePlayServicesUtilLight.getRemoteContext(context);
    }

    public static Resources getRemoteResource(Context context) {
        return GooglePlayServicesUtilLight.getRemoteResource(context);
    }

    @Deprecated
    @HideFirstParty
    public static int isGooglePlayServicesAvailable(Context context) {
        return GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(context);
    }

    @Deprecated
    public static boolean isUserRecoverableError(int i11) {
        return GooglePlayServicesUtilLight.isUserRecoverableError(i11);
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int i11, Activity activity, int i12) {
        return showErrorDialogFragment(i11, activity, i12, (DialogInterface.OnCancelListener) null);
    }

    @Deprecated
    public static void showErrorNotification(int i11, Context context) {
        GoogleApiAvailability instance = GoogleApiAvailability.getInstance();
        if (GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(context, i11) || GooglePlayServicesUtilLight.isPlayStorePossiblyUpdating(context, i11)) {
            instance.zaf(context);
        } else {
            instance.showErrorNotification(context, i11);
        }
    }

    @Deprecated
    public static Dialog getErrorDialog(int i11, Activity activity, int i12, DialogInterface.OnCancelListener onCancelListener) {
        if (true == GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(activity, i11)) {
            i11 = 18;
        }
        return GoogleApiAvailability.getInstance().getErrorDialog(activity, i11, i12, onCancelListener);
    }

    @KeepForSdk
    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context, int i11) {
        return GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(context, i11);
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int i11, Activity activity, int i12, DialogInterface.OnCancelListener onCancelListener) {
        return showErrorDialogFragment(i11, activity, (Fragment) null, i12, onCancelListener);
    }

    public static boolean showErrorDialogFragment(int i11, Activity activity, Fragment fragment, int i12, DialogInterface.OnCancelListener onCancelListener) {
        if (true == GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(activity, i11)) {
            i11 = 18;
        }
        GoogleApiAvailability instance = GoogleApiAvailability.getInstance();
        if (fragment == null) {
            return instance.showErrorDialogFragment(activity, i11, i12, onCancelListener);
        }
        Dialog zaa = instance.zaa(activity, i11, zag.zac(fragment, GoogleApiAvailability.getInstance().getErrorResolutionIntent(activity, i11, GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG), i12), onCancelListener);
        if (zaa == null) {
            return false;
        }
        instance.zad(activity, zaa, GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }
}
