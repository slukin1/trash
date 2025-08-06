package com.huochat.community.activity;

import com.huochat.community.util.KeyboardListener;

public final class CommunityDynamicDetailActivity$refreshMomentInfoView$3 implements KeyboardListener.OnSoftKeyBoardChangeListener {
    public final /* synthetic */ CommunityDynamicDetailActivity this$0;

    public CommunityDynamicDetailActivity$refreshMomentInfoView$3(CommunityDynamicDetailActivity communityDynamicDetailActivity) {
        this.this$0 = communityDynamicDetailActivity;
    }

    public void keyBoardHide(int i11) {
        if (this.this$0.commentDialog != null && this.this$0.commentDialog.isShowing()) {
            this.this$0.commentDialog.dismiss();
        }
    }

    public void keyBoardShow(int i11) {
    }
}
