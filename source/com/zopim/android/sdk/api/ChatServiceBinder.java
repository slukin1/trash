package com.zopim.android.sdk.api;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import com.zendesk.logger.Logger;
import com.zopim.android.sdk.api.ZopimChatApi;

public final class ChatServiceBinder extends Fragment {
    private static final String LOG_TAG = "ChatServiceBinder";
    private boolean bound;
    private ZopimChatApi.ChatServiceConnection externalConnectionListener;

    private void bind() {
        String str;
        String str2;
        if (getActivity() != null) {
            if (getArguments() != null) {
                str2 = getArguments().getString(ChatService.EXTRA_ACCOUNT_KEY);
                str = getArguments().getString(ChatService.EXTRA_MACHINE_ID);
            } else {
                str2 = null;
                str = null;
            }
            this.bound = getActivity().bindService(ChatService.startIntent(getContext(), (String) null, str2, str, (ZopimChatApi.SessionApiConfig) null), this.externalConnectionListener, 1);
            Logger.j(LOG_TAG, "Binding chat service with activity " + getActivity(), new Object[0]);
        }
    }

    private void unbind() {
        if (this.bound && getActivity() != null) {
            getActivity().unbindService(this.externalConnectionListener);
            this.bound = false;
            Logger.j(LOG_TAG, "Unbinding chat service from activity " + getActivity(), new Object[0]);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.externalConnectionListener = new ZopimChatApi.ChatServiceConnection();
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

    public void onStart() {
        super.onStart();
        Logger.j(LOG_TAG, "Host activity start", new Object[0]);
        if (!ZopimChatApi.isInitialized()) {
            Logger.l(LOG_TAG, "Failed to bind to uninitialized chat.", new Object[0]);
        } else {
            bind();
        }
    }

    public void onStop() {
        super.onStop();
        Logger.j(LOG_TAG, "Host activity stop", new Object[0]);
        unbind();
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
