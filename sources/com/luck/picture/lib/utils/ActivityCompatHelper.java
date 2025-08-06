package com.luck.picture.lib.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import androidx.fragment.app.FragmentActivity;

public class ActivityCompatHelper {
    private static final int MIN_FRAGMENT_COUNT = 1;

    public static boolean assertValidRequest(Context context) {
        if (context instanceof Activity) {
            return !isDestroy((Activity) context);
        }
        if (context instanceof ContextWrapper) {
            ContextWrapper contextWrapper = (ContextWrapper) context;
            if (contextWrapper.getBaseContext() instanceof Activity) {
                return !isDestroy((Activity) contextWrapper.getBaseContext());
            }
        }
        return true;
    }

    public static boolean checkFragmentNonExits(FragmentActivity fragmentActivity, String str) {
        if (!isDestroy(fragmentActivity) && fragmentActivity.getSupportFragmentManager().m0(str) == null) {
            return true;
        }
        return false;
    }

    public static boolean checkRootFragment(FragmentActivity fragmentActivity) {
        if (!isDestroy(fragmentActivity) && fragmentActivity.getSupportFragmentManager().u0() == 1) {
            return true;
        }
        return false;
    }

    public static boolean isDestroy(Activity activity) {
        return activity == null || activity.isFinishing() || activity.isDestroyed();
    }
}
