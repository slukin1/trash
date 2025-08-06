package com.huochat.community.fragment;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.huochat.community.enums.CommunityMenuItems;
import com.huochat.community.listener.OnCommunitySortClickListener;

public final class FragmentCommunityList$mOnCommunitySortClickListener$1 implements OnCommunitySortClickListener {
    public final /* synthetic */ FragmentCommunityList this$0;

    public FragmentCommunityList$mOnCommunitySortClickListener$1(FragmentCommunityList fragmentCommunityList) {
        this.this$0 = fragmentCommunityList;
    }

    public FragmentActivity getParentActivity() {
        return this.this$0.getActivity();
    }

    public void onClick(View view, View view2, CommunityMenuItems communityMenuItems) {
        CommunityListMenuDialog access$getMCommunityMenuDialog$p;
        if (this.this$0.getActivity() != null && !this.this$0.getActivity().isFinishing() && (access$getMCommunityMenuDialog$p = this.this$0.mCommunityMenuDialog) != null) {
            access$getMCommunityMenuDialog$p.showAsDropDown(this.this$0.getActivity().getSupportFragmentManager(), view2);
        }
    }
}
