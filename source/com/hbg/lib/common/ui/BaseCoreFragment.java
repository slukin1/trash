package com.hbg.lib.common.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import i6.d;
import java.util.List;

public abstract class BaseCoreFragment extends Fragment {

    /* renamed from: b  reason: collision with root package name */
    public View f67478b;

    public BaseCoreFragment() {
        setArguments(new Bundle());
    }

    public View getRootView() {
        return this.f67478b;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        d.i(getClass().getSimpleName() + "------enter------");
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        d.i(getClass().getSimpleName() + "------enter------");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d.i(getClass().getSimpleName() + "------enter------");
        setRetainInstance(true);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        d.i(getClass().getSimpleName() + "------enter------");
        if (this.f67478b == null) {
            rh(ph(layoutInflater, viewGroup, bundle));
            qh();
        }
        if (this.f67478b.getParent() != null) {
            ((ViewGroup) this.f67478b.getParent()).removeView(this.f67478b);
        }
        return this.f67478b;
    }

    public void onDestroy() {
        super.onDestroy();
        d.i(getClass().getSimpleName() + "------enter------");
    }

    public void onDestroyView() {
        super.onDestroyView();
        d.i(getClass().getSimpleName() + "------enter------");
    }

    public void onDetach() {
        super.onDetach();
        d.i(getClass().getSimpleName() + "------enter------");
    }

    @SensorsDataInstrumented
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        List<Fragment> B0 = getChildFragmentManager().B0();
        if (B0 != null) {
            for (Fragment next : B0) {
                if (next != null && next.isAdded()) {
                    next.onHiddenChanged(z11 || next.isHidden());
                }
            }
        }
        d.i(getClass().getSimpleName() + "------enter------ hidden:" + z11);
        FragmentTrackHelper.trackOnHiddenChanged(this, z11);
    }

    @SensorsDataInstrumented
    public void onPause() {
        super.onPause();
        d.i(getClass().getSimpleName() + "------enter------");
        FragmentTrackHelper.trackFragmentPause(this);
    }

    @SensorsDataInstrumented
    public void onResume() {
        super.onResume();
        d.i(getClass().getSimpleName() + "------enter------");
        FragmentTrackHelper.trackFragmentResume(this);
    }

    public void onStart() {
        super.onStart();
        d.i(getClass().getSimpleName() + "------enter------");
    }

    public void onStop() {
        super.onStop();
        d.i(getClass().getSimpleName() + "------enter------");
    }

    @SensorsDataInstrumented
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    public abstract View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    public abstract void qh();

    public void rh(View view) {
        this.f67478b = view;
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        d.i(getClass().getSimpleName() + "------enter------  userVisible:" + z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }
}
