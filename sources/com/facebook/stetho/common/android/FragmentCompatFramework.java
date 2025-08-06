package com.facebook.stetho.common.android;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import com.facebook.stetho.common.android.FragmentCompat;

@TargetApi(11)
final class FragmentCompatFramework extends FragmentCompat<Fragment, DialogFragment, FragmentManager, Activity> {
    private static final DialogFragmentAccessorFramework sDialogFragmentAccessor = new DialogFragmentAccessorFramework(sFragmentAccessor);
    private static final FragmentAccessorFrameworkHoneycomb sFragmentAccessor;
    private static final FragmentActivityAccessorFramework sFragmentActivityAccessor = new FragmentActivityAccessorFramework();
    private static final FragmentCompat.FragmentManagerAccessorViaReflection<FragmentManager, Fragment> sFragmentManagerAccessor = new FragmentCompat.FragmentManagerAccessorViaReflection<>();

    public static class DialogFragmentAccessorFramework implements DialogFragmentAccessor<DialogFragment, Fragment, FragmentManager> {
        private final FragmentAccessor<Fragment, FragmentManager> mFragmentAccessor;

        public DialogFragmentAccessorFramework(FragmentAccessor<Fragment, FragmentManager> fragmentAccessor) {
            this.mFragmentAccessor = fragmentAccessor;
        }

        public FragmentManager getChildFragmentManager(Fragment fragment) {
            return this.mFragmentAccessor.getChildFragmentManager(fragment);
        }

        public Dialog getDialog(DialogFragment dialogFragment) {
            return dialogFragment.getDialog();
        }

        public FragmentManager getFragmentManager(Fragment fragment) {
            return this.mFragmentAccessor.getFragmentManager(fragment);
        }

        public int getId(Fragment fragment) {
            return this.mFragmentAccessor.getId(fragment);
        }

        public Resources getResources(Fragment fragment) {
            return this.mFragmentAccessor.getResources(fragment);
        }

        public String getTag(Fragment fragment) {
            return this.mFragmentAccessor.getTag(fragment);
        }

        public View getView(Fragment fragment) {
            return this.mFragmentAccessor.getView(fragment);
        }
    }

    public static class FragmentAccessorFrameworkHoneycomb implements FragmentAccessor<Fragment, FragmentManager> {
        private FragmentAccessorFrameworkHoneycomb() {
        }

        public FragmentManager getChildFragmentManager(Fragment fragment) {
            return null;
        }

        public FragmentManager getFragmentManager(Fragment fragment) {
            return fragment.getFragmentManager();
        }

        public int getId(Fragment fragment) {
            return fragment.getId();
        }

        public Resources getResources(Fragment fragment) {
            return fragment.getResources();
        }

        public String getTag(Fragment fragment) {
            return fragment.getTag();
        }

        public View getView(Fragment fragment) {
            return fragment.getView();
        }
    }

    @TargetApi(17)
    public static class FragmentAccessorFrameworkJellyBean extends FragmentAccessorFrameworkHoneycomb {
        private FragmentAccessorFrameworkJellyBean() {
            super();
        }

        public FragmentManager getChildFragmentManager(Fragment fragment) {
            return fragment.getChildFragmentManager();
        }
    }

    public static class FragmentActivityAccessorFramework implements FragmentActivityAccessor<Activity, FragmentManager> {
        private FragmentActivityAccessorFramework() {
        }

        public FragmentManager getFragmentManager(Activity activity) {
            return activity.getFragmentManager();
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 17) {
            sFragmentAccessor = new FragmentAccessorFrameworkJellyBean();
        } else {
            sFragmentAccessor = new FragmentAccessorFrameworkHoneycomb();
        }
    }

    public Class<DialogFragment> getDialogFragmentClass() {
        return DialogFragment.class;
    }

    public Class<Activity> getFragmentActivityClass() {
        return Activity.class;
    }

    public Class<Fragment> getFragmentClass() {
        return Fragment.class;
    }

    public DialogFragmentAccessorFramework forDialogFragment() {
        return sDialogFragmentAccessor;
    }

    public FragmentAccessorFrameworkHoneycomb forFragment() {
        return sFragmentAccessor;
    }

    public FragmentActivityAccessorFramework forFragmentActivity() {
        return sFragmentActivityAccessor;
    }

    public FragmentCompat.FragmentManagerAccessorViaReflection<FragmentManager, Fragment> forFragmentManager() {
        return sFragmentManagerAccessor;
    }
}
