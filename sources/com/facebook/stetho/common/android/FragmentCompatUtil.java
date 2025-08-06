package com.facebook.stetho.common.android;

import android.app.Activity;
import android.view.View;
import java.util.List;

public final class FragmentCompatUtil {
    private FragmentCompatUtil() {
    }

    public static Object findFragmentForView(View view) {
        Activity tryGetActivity = ViewUtil.tryGetActivity(view);
        if (tryGetActivity == null) {
            return null;
        }
        return findFragmentForViewInActivity(tryGetActivity, view);
    }

    private static Object findFragmentForViewInActivity(Activity activity, View view) {
        Object findFragmentForViewInActivity;
        Object findFragmentForViewInActivity2;
        FragmentCompat supportLibInstance = FragmentCompat.getSupportLibInstance();
        if (supportLibInstance != null && supportLibInstance.getFragmentActivityClass().isInstance(activity) && (findFragmentForViewInActivity2 = findFragmentForViewInActivity(supportLibInstance, activity, view)) != null) {
            return findFragmentForViewInActivity2;
        }
        FragmentCompat frameworkInstance = FragmentCompat.getFrameworkInstance();
        if (frameworkInstance == null || (findFragmentForViewInActivity = findFragmentForViewInActivity(frameworkInstance, activity, view)) == null) {
            return null;
        }
        return findFragmentForViewInActivity;
    }

    private static Object findFragmentForViewInFragment(FragmentCompat fragmentCompat, Object obj, View view) {
        FragmentAccessor forFragment = fragmentCompat.forFragment();
        if (forFragment.getView(obj) == view) {
            return obj;
        }
        Object childFragmentManager = forFragment.getChildFragmentManager(obj);
        if (childFragmentManager != null) {
            return findFragmentForViewInFragmentManager(fragmentCompat, childFragmentManager, view);
        }
        return null;
    }

    private static Object findFragmentForViewInFragmentManager(FragmentCompat fragmentCompat, Object obj, View view) {
        List addedFragments = fragmentCompat.forFragmentManager().getAddedFragments(obj);
        if (addedFragments == null) {
            return null;
        }
        int size = addedFragments.size();
        for (int i11 = 0; i11 < size; i11++) {
            Object findFragmentForViewInFragment = findFragmentForViewInFragment(fragmentCompat, addedFragments.get(i11), view);
            if (findFragmentForViewInFragment != null) {
                return findFragmentForViewInFragment;
            }
        }
        return null;
    }

    public static boolean isDialogFragment(Object obj) {
        FragmentCompat supportLibInstance = FragmentCompat.getSupportLibInstance();
        if (supportLibInstance != null && supportLibInstance.getDialogFragmentClass().isInstance(obj)) {
            return true;
        }
        FragmentCompat frameworkInstance = FragmentCompat.getFrameworkInstance();
        if (frameworkInstance == null || !frameworkInstance.getDialogFragmentClass().isInstance(obj)) {
            return false;
        }
        return true;
    }

    private static Object findFragmentForViewInActivity(FragmentCompat fragmentCompat, Activity activity, View view) {
        Object fragmentManager = fragmentCompat.forFragmentActivity().getFragmentManager(activity);
        if (fragmentManager != null) {
            return findFragmentForViewInFragmentManager(fragmentCompat, fragmentManager, view);
        }
        return null;
    }
}
