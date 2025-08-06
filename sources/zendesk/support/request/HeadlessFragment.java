package zendesk.support.request;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;

public class HeadlessFragment<E> extends Fragment {
    private static final String TAG = "ZendeskHeadlessFragment";
    private E data;

    private E getData() {
        return this.data;
    }

    public static <E> void install(FragmentManager fragmentManager, E e11) {
        HeadlessFragment headlessFragment = new HeadlessFragment();
        headlessFragment.setData(e11);
        fragmentManager.q().e(headlessFragment, TAG).j();
    }

    private void setData(E e11) {
        this.data = e11;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        setRetainInstance(true);
        return null;
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

    public static <E> E getData(FragmentManager fragmentManager) {
        Fragment m02 = fragmentManager.m0(TAG);
        if (m02 instanceof HeadlessFragment) {
            return ((HeadlessFragment) m02).getData();
        }
        return null;
    }
}
