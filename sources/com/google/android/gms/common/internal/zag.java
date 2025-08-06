package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import androidx.fragment.app.Fragment;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.api.internal.LifecycleFragment;

public abstract class zag implements DialogInterface.OnClickListener {
    public static zag zab(Activity activity, Intent intent, int i11) {
        return new zad(intent, activity, i11);
    }

    public static zag zac(Fragment fragment, Intent intent, int i11) {
        return new zae(intent, fragment, i11);
    }

    public static zag zad(LifecycleFragment lifecycleFragment, Intent intent, int i11) {
        return new zaf(intent, lifecycleFragment, 2);
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        try {
            zaa();
        } catch (ActivityNotFoundException e11) {
            String str = "Failed to start resolution intent.";
            if (true == Build.FINGERPRINT.contains(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE)) {
                str = "Failed to start resolution intent. This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store.";
            }
            Log.e("DialogRedirect", str, e11);
        } finally {
            dialogInterface.dismiss();
        }
    }

    public abstract void zaa();
}
