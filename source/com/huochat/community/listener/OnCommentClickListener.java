package com.huochat.community.listener;

import android.view.View;
import com.huochat.community.model.CommentItemBean;

public interface OnCommentClickListener {
    void onCommentClick(CommentItemBean commentItemBean, View view);

    void onCommentLongClick(CommentItemBean commentItemBean, View view);
}
