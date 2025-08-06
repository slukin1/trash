package com.tencent.qcloud.tuikit.timcommon.component.fragments;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;

public class BaseFragment extends Fragment {
    public void backward() {
        if (getFragmentManager() != null) {
            getFragmentManager().j1();
        }
    }

    public void forward(Fragment fragment, boolean z11) {
        forward(getId(), fragment, (String) null, z11);
    }

    @SensorsDataInstrumented
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        FragmentTrackHelper.trackOnHiddenChanged(this, z11);
    }

    @SensorsDataInstrumented
    public void onPause() {
        super.onPause();
        FragmentTrackHelper.trackFragmentPause(this);
    }

    @SensorsDataInstrumented
    public void onResume() {
        super.onResume();
        FragmentTrackHelper.trackFragmentResume(this);
    }

    @SensorsDataInstrumented
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }

    public void forward(int i11, Fragment fragment, String str, boolean z11) {
        if (getFragmentManager() != null) {
            FragmentTransaction q11 = getFragmentManager().q();
            if (z11) {
                q11.q(this);
                q11.b(i11, fragment);
            } else {
                q11.t(i11, fragment);
            }
            q11.h(str);
            q11.k();
        }
    }
}
