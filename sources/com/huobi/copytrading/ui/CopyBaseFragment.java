package com.huobi.copytrading.ui;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;

public abstract class CopyBaseFragment extends Fragment {

    /* renamed from: b  reason: collision with root package name */
    public boolean f43602b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f43603c = true;

    /* renamed from: d  reason: collision with root package name */
    public boolean f43604d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f43605e = true;

    @SensorsDataInstrumented
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        if (z11) {
            rh();
        } else {
            sh();
        }
        this.f43602b = z11;
        FragmentTrackHelper.trackOnHiddenChanged(this, z11);
    }

    @SensorsDataInstrumented
    public void onPause() {
        super.onPause();
        if (!this.f43602b && this.f43603c) {
            rh();
        }
        this.f43604d = false;
        FragmentTrackHelper.trackFragmentPause(this);
    }

    @SensorsDataInstrumented
    public void onResume() {
        if (getUserVisibleHint() && !this.f43602b && !this.f43604d) {
            sh();
        }
        if (this.f43604d) {
            this.f43604d = false;
        }
        super.onResume();
        FragmentTrackHelper.trackFragmentResume(this);
    }

    @SensorsDataInstrumented
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    public abstract void ph();

    public abstract void qh();

    public void rh() {
        System.out.println("On Hidden Fragment ---->>> " + getClass().getName() + ", " + this);
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        this.f43603c = z11;
        if (z11) {
            if (!this.f43604d) {
                this.f43604d = true;
            }
            sh();
        } else {
            if (!this.f43605e) {
                rh();
            }
            this.f43605e = false;
        }
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }

    public void sh() {
        System.out.println("On Visible Fragment ---->>> " + getClass().getName() + ", " + this);
    }
}
