package org.greenrobot.eventbus.util;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import org.greenrobot.eventbus.EventBus;

public class ErrorDialogManager {

    @TargetApi(11)
    public static class HoneycombManagerFragment extends Fragment {

        /* renamed from: b  reason: collision with root package name */
        public EventBus f68288b;

        @SensorsDataInstrumented
        public void onHiddenChanged(boolean z11) {
            super.onHiddenChanged(z11);
            FragmentTrackHelper.trackOnHiddenChanged(this, z11);
        }

        @SensorsDataInstrumented
        public void onPause() {
            this.f68288b.r(this);
            super.onPause();
            FragmentTrackHelper.trackFragmentPause(this);
        }

        @SensorsDataInstrumented
        public void onResume() {
            super.onResume();
            throw null;
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

    public static class SupportManagerFragment extends androidx.fragment.app.Fragment {

        /* renamed from: b  reason: collision with root package name */
        public EventBus f68289b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f68290c;

        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            throw null;
        }

        @SensorsDataInstrumented
        public void onHiddenChanged(boolean z11) {
            super.onHiddenChanged(z11);
            FragmentTrackHelper.trackOnHiddenChanged(this, z11);
        }

        @SensorsDataInstrumented
        public void onPause() {
            this.f68289b.r(this);
            super.onPause();
            FragmentTrackHelper.trackFragmentPause(this);
        }

        @SensorsDataInstrumented
        public void onResume() {
            super.onResume();
            if (this.f68290c) {
                this.f68290c = false;
                FragmentTrackHelper.trackFragmentResume(this);
                return;
            }
            throw null;
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
}
