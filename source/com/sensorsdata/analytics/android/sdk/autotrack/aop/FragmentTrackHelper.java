package com.sensorsdata.analytics.android.sdk.autotrack.aop;

import android.os.Bundle;
import android.view.View;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.autotrack.SAFragmentLifecycleCallbacks;
import com.sensorsdata.analytics.android.sdk.util.SAFragmentUtils;
import java.util.HashSet;
import java.util.Set;

public class FragmentTrackHelper {
    private static final Set<SAFragmentLifecycleCallbacks> FRAGMENT_CALLBACKS = new HashSet();

    public static void addFragmentCallbacks(SAFragmentLifecycleCallbacks sAFragmentLifecycleCallbacks) {
        if (sAFragmentLifecycleCallbacks != null) {
            FRAGMENT_CALLBACKS.add(sAFragmentLifecycleCallbacks);
        }
    }

    public static void onFragmentViewCreated(Object obj, View view, Bundle bundle) {
        if (SAFragmentUtils.isFragment(obj)) {
            for (SAFragmentLifecycleCallbacks onViewCreated : FRAGMENT_CALLBACKS) {
                try {
                    onViewCreated.onViewCreated(obj, view, bundle);
                } catch (Exception e11) {
                    SALog.printStackTrace(e11);
                }
            }
        }
    }

    public static void removeFragmentCallbacks(SAFragmentLifecycleCallbacks sAFragmentLifecycleCallbacks) {
        if (sAFragmentLifecycleCallbacks != null) {
            FRAGMENT_CALLBACKS.remove(sAFragmentLifecycleCallbacks);
        }
    }

    public static void trackFragmentPause(Object obj) {
        if (SAFragmentUtils.isFragment(obj)) {
            for (SAFragmentLifecycleCallbacks onPause : FRAGMENT_CALLBACKS) {
                try {
                    onPause.onPause(obj);
                } catch (Exception e11) {
                    SALog.printStackTrace(e11);
                }
            }
        }
    }

    public static void trackFragmentResume(Object obj) {
        if (SAFragmentUtils.isFragment(obj)) {
            for (SAFragmentLifecycleCallbacks onResume : FRAGMENT_CALLBACKS) {
                try {
                    onResume.onResume(obj);
                } catch (Exception e11) {
                    SALog.printStackTrace(e11);
                }
            }
        }
    }

    public static void trackFragmentSetUserVisibleHint(Object obj, boolean z11) {
        if (SAFragmentUtils.isFragment(obj)) {
            for (SAFragmentLifecycleCallbacks userVisibleHint : FRAGMENT_CALLBACKS) {
                try {
                    userVisibleHint.setUserVisibleHint(obj, z11);
                } catch (Exception e11) {
                    SALog.printStackTrace(e11);
                }
            }
        }
    }

    public static void trackOnHiddenChanged(Object obj, boolean z11) {
        if (SAFragmentUtils.isFragment(obj)) {
            for (SAFragmentLifecycleCallbacks onHiddenChanged : FRAGMENT_CALLBACKS) {
                try {
                    onHiddenChanged.onHiddenChanged(obj, z11);
                } catch (Exception e11) {
                    SALog.printStackTrace(e11);
                }
            }
        }
    }
}
