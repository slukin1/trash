package com.huochat.community.widget.shareview;

import com.huochat.community.adapter.CommunityShareImageAdapter;
import com.huochat.community.widget.shareview.CommunityDynamicShareView;

public final class CommunityDynamicShareView$initImageGridView$1$1 implements CommunityShareImageAdapter.OnImageLoadFinishCallback {
    public final /* synthetic */ CommunityDynamicShareView this$0;

    public CommunityDynamicShareView$initImageGridView$1$1(CommunityDynamicShareView communityDynamicShareView) {
        this.this$0 = communityDynamicShareView;
    }

    public void callback(Boolean bool, int i11) {
        CommunityDynamicShareView.OnAfterInitCallback access$getMOnAfterInitCallback$p = this.this$0.mOnAfterInitCallback;
        if (access$getMOnAfterInitCallback$p != null) {
            access$getMOnAfterInitCallback$p.callback(this.this$0, bool != null ? bool.booleanValue() : false);
        }
    }
}
