package com.bbc876219.runtimestatis;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bbc876219.lib.zlog.ZLog;

public class RunTimeStatisFragmentLifecycleCallbacks extends FragmentManager.FragmentLifecycleCallbacks {
    public void onFragmentActivityCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        ZLog.b("FragmentLifecycleCall", "onFragmentActivityCreated() called with: fm = [" + fragmentManager + "], f = [" + fragment + "], savedInstanceState = [" + bundle + "]");
    }

    public void onFragmentAttached(FragmentManager fragmentManager, Fragment fragment, Context context) {
        ZLog.b("FragmentLifecycleCall", "onFragmentAttached() called with: fm = [" + fragmentManager + "], f = [" + fragment + "], context = [" + context + "]");
    }

    public void onFragmentCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        ZLog.b("FragmentLifecycleCall", "onFragmentCreated() called with: fm = [" + fragmentManager + "], f = [" + fragment + "], savedInstanceState = [" + bundle + "]");
    }

    public void onFragmentDestroyed(FragmentManager fragmentManager, Fragment fragment) {
        ZLog.b("FragmentLifecycleCall", "onFragmentDestroyed() called with: fm = [" + fragmentManager + "], f = [" + fragment + "]");
    }

    public void onFragmentDetached(FragmentManager fragmentManager, Fragment fragment) {
        ZLog.b("FragmentLifecycleCall", "onFragmentDetached() called with: fm = [" + fragmentManager + "], f = [" + fragment + "]");
    }

    public void onFragmentPaused(FragmentManager fragmentManager, Fragment fragment) {
        ZLog.b("FragmentLifecycleCall", "onFragmentPaused() called with: fm = [" + fragmentManager + "], f = [" + fragment + "]");
    }

    public void onFragmentPreAttached(FragmentManager fragmentManager, Fragment fragment, Context context) {
        ZLog.b("FragmentLifecycleCall", "onFragmentPreAttached() called with: fm = [" + fragmentManager + "], f = [" + fragment + "], context = [" + context + "]");
    }

    public void onFragmentPreCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        ZLog.b("FragmentLifecycleCall", "onFragmentPreCreated() called with: fm = [" + fragmentManager + "], f = [" + fragment + "], savedInstanceState = [" + bundle + "]");
    }

    public void onFragmentResumed(FragmentManager fragmentManager, Fragment fragment) {
        ZLog.b("FragmentLifecycleCall", "onFragmentResumed() called with: fm = [" + fragmentManager + "], f = [" + fragment + "]");
    }

    public void onFragmentSaveInstanceState(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        ZLog.b("FragmentLifecycleCall", "onFragmentSaveInstanceState() called with: fm = [" + fragmentManager + "], f = [" + fragment + "], outState = [" + bundle + "]");
    }

    public void onFragmentStarted(FragmentManager fragmentManager, Fragment fragment) {
        ZLog.b("FragmentLifecycleCall", "onFragmentStarted() called with: fm = [" + fragmentManager + "], f = [" + fragment + "]");
    }

    public void onFragmentStopped(FragmentManager fragmentManager, Fragment fragment) {
        ZLog.b("FragmentLifecycleCall", "onFragmentStopped() called with: fm = [" + fragmentManager + "], f = [" + fragment + "]");
    }

    public void onFragmentViewCreated(FragmentManager fragmentManager, Fragment fragment, View view, Bundle bundle) {
        ZLog.b("FragmentLifecycleCall", "onFragmentViewCreated() called with: fm = [" + fragmentManager + "], f = [" + fragment + "], v = [" + view + "], savedInstanceState = [" + bundle + "]");
    }

    public void onFragmentViewDestroyed(FragmentManager fragmentManager, Fragment fragment) {
        ZLog.b("FragmentLifecycleCall", "onFragmentViewDestroyed() called with: fm = [" + fragmentManager + "], f = [" + fragment + "]");
    }
}
