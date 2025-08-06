package com.huochat.community.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.huochat.community.eventbus.EventMessage;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;

public abstract class BaseChildFragment extends Fragment implements BaseInterface {
    private boolean isFirstCreate;
    private boolean isViewCreated;
    private Bundle savedInstance;

    public boolean isRegisteredEventBus() {
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.savedInstance = bundle;
        this.isFirstCreate = true;
        if (isRegisteredEventBus()) {
            EventBus.d().p(this);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (getLayoutId() > 0) {
            return layoutInflater.inflate(getLayoutId(), viewGroup, false);
        }
        return null;
    }

    public void onDestroy() {
        super.onDestroy();
        this.isFirstCreate = false;
        if (isRegisteredEventBus()) {
            EventBus.d().r(this);
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.isViewCreated = false;
    }

    @SensorsDataInstrumented
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        FragmentTrackHelper.trackOnHiddenChanged(this, z11);
    }

    @h(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EventMessage<Object> eventMessage) {
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
        this.isViewCreated = true;
        initView(view);
        if (this.isFirstCreate) {
            initData(bundle);
        }
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }
}
