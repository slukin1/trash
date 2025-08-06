package com.huawei.hmf.tasks.a;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import eg.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

public final class g extends Fragment {

    /* renamed from: c  reason: collision with root package name */
    public static final WeakHashMap<Activity, WeakReference<g>> f37642c = new WeakHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public final List<WeakReference<a<?>>> f37643b = new ArrayList();

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

    public final void onStop() {
        super.onStop();
        synchronized (this.f37643b) {
            for (WeakReference<a<?>> weakReference : this.f37643b) {
                a aVar = (a) weakReference.get();
                if (aVar != null) {
                    aVar.cancel();
                }
            }
            this.f37643b.clear();
        }
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
}
