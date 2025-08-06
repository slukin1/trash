package com.huochat.community.fragment;

import androidx.recyclerview.widget.RecyclerView;
import com.huochat.community.listener.OnDisclaimerVisibleChangedListener;

public final class FragmentCommunityList$onDynamicListScrollListener$1 extends RecyclerView.OnScrollListener {
    public final /* synthetic */ FragmentCommunityList this$0;

    public FragmentCommunityList$onDynamicListScrollListener$1(FragmentCommunityList fragmentCommunityList) {
        this.this$0 = fragmentCommunityList;
    }

    public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
        boolean z11;
        super.onScrolled(recyclerView, i11, i12);
        FragmentCommunityList fragmentCommunityList = this.this$0;
        if (!fragmentCommunityList.mIsListScrollToUp && i12 > 10) {
            z11 = true;
        } else if (!this.this$0.mIsListScrollToUp || i12 >= -10) {
            z11 = this.this$0.mIsListScrollToUp;
        } else {
            z11 = false;
        }
        fragmentCommunityList.mIsListScrollToUp = z11;
        OnDisclaimerVisibleChangedListener access$getOnDisclaimerVisibleChangedListener$p = this.this$0.onDisclaimerVisibleChangedListener;
        if (access$getOnDisclaimerVisibleChangedListener$p != null) {
            access$getOnDisclaimerVisibleChangedListener$p.onVisibleChanged(!this.this$0.mIsListScrollToUp, this.this$0.hasCommunityListData());
        }
    }
}
