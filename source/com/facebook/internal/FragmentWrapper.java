package com.facebook.internal;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import com.tencent.qcloud.tuicore.TUIConstants;

public class FragmentWrapper {
    private Fragment nativeFragment;
    private androidx.fragment.app.Fragment supportFragment;

    public FragmentWrapper(androidx.fragment.app.Fragment fragment) {
        Validate.notNull(fragment, TUIConstants.TUIChat.FRAGMENT);
        this.supportFragment = fragment;
    }

    public final Activity getActivity() {
        androidx.fragment.app.Fragment fragment = this.supportFragment;
        if (fragment != null) {
            return fragment.getActivity();
        }
        return this.nativeFragment.getActivity();
    }

    public Fragment getNativeFragment() {
        return this.nativeFragment;
    }

    public androidx.fragment.app.Fragment getSupportFragment() {
        return this.supportFragment;
    }

    public void startActivityForResult(Intent intent, int i11) {
        androidx.fragment.app.Fragment fragment = this.supportFragment;
        if (fragment != null) {
            fragment.startActivityForResult(intent, i11);
        } else {
            this.nativeFragment.startActivityForResult(intent, i11);
        }
    }

    public FragmentWrapper(Fragment fragment) {
        Validate.notNull(fragment, TUIConstants.TUIChat.FRAGMENT);
        this.nativeFragment = fragment;
    }
}
