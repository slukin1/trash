package zendesk.commonui;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import java.util.HashMap;
import java.util.Map;

public class CacheFragment extends Fragment {

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, Object> f62923b = new HashMap();

    public static CacheFragment ph(FragmentActivity fragmentActivity) {
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        Fragment m02 = supportFragmentManager.m0("CacheFragment");
        if (m02 instanceof CacheFragment) {
            return (CacheFragment) m02;
        }
        CacheFragment cacheFragment = new CacheFragment();
        cacheFragment.setRetainInstance(true);
        supportFragmentManager.q().e(cacheFragment, "CacheFragment").j();
        return cacheFragment;
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

    public <T> T qh(String str) {
        try {
            return this.f62923b.get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public <T> void rh(String str, T t11) {
        this.f62923b.put(str, t11);
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }
}
