package com.huochat.community.fragment;

import android.util.Log;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.huochat.community.fragment.FragmentCommunityList;
import com.huochat.community.model.CommunityResultBean;

public final class FragmentCommunityList$loadData$1 extends RequestCallback1<CommunityResultBean> {
    public final /* synthetic */ boolean $isShowProgress;
    public final /* synthetic */ FragmentCommunityList this$0;

    public FragmentCommunityList$loadData$1(boolean z11, FragmentCommunityList fragmentCommunityList) {
        this.$isShowProgress = z11;
        this.this$0 = fragmentCommunityList;
    }

    public void onRequestFailure(Throwable th2) {
        String str;
        this.this$0.finishRefreshOrLoadMore(false, 0);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("## reqError: ");
        if (th2 == null || (str = th2.getMessage()) == null) {
            str = "Request failure!";
        }
        sb2.append(str);
        Log.i("community", sb2.toString());
        FragmentCommunityList.RequestCallback access$getReRequestCallback$p = this.this$0.reRequestCallback;
        if (access$getReRequestCallback$p != null) {
            access$getReRequestCallback$p.complate();
        }
    }

    public void onRequestStart() {
        if (this.$isShowProgress) {
            this.this$0.showSkeleton();
        }
    }

    public void onRequestSuccess(CommunityResultBean communityResultBean) {
        this.this$0.updateOrRefreshUI(communityResultBean);
        this.this$0.finishRefreshOrLoadMore(true, 0);
        FragmentCommunityList.RequestCallback access$getReRequestCallback$p = this.this$0.reRequestCallback;
        if (access$getReRequestCallback$p != null) {
            access$getReRequestCallback$p.complate();
        }
    }
}
