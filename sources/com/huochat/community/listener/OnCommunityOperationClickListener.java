package com.huochat.community.listener;

import com.huochat.community.model.CommentItemBean;
import com.huochat.community.model.CommunityItemBean;
import com.huochat.community.viewholder.CommunityHolder;

public interface OnCommunityOperationClickListener {
    void onBrowerLocationClick(CommunityHolder communityHolder, CommunityItemBean communityItemBean);

    void onCommentClick(CommunityHolder communityHolder, CommentItemBean commentItemBean);

    void onForwordClick(CommunityHolder communityHolder, CommunityItemBean communityItemBean);

    void onMoreBtnClick(CommunityHolder communityHolder, CommunityItemBean communityItemBean);

    void onPariseClick(CommunityHolder communityHolder, CommunityItemBean communityItemBean);
}
