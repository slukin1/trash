package com.huobi.framework.im.groupchat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.huobi.framework.im.R;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import kotlin.jvm.internal.r;

public final class GroupChatFragment extends Fragment {
    public static final Companion Companion = new Companion((r) null);
    private int appId;
    private String userId;
    private String userSig;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final GroupChatFragment newInstance(int i11, String str, String str2) {
            GroupChatFragment groupChatFragment = new GroupChatFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("arg_app_id", i11);
            bundle.putString("arg_user_id", str);
            bundle.putString("arg_user_sig", str2);
            groupChatFragment.setArguments(bundle);
            return groupChatFragment;
        }
    }

    public static final GroupChatFragment newInstance(int i11, String str, String str2) {
        return Companion.newInstance(i11, str, str2);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.appId = arguments.getInt("arg_app_id");
            this.userId = arguments.getString("arg_user_id");
            this.userSig = arguments.getString("arg_user_sig");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_group_chat, viewGroup, false);
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
}
