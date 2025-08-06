package com.huochat.community.model;

import java.io.Serializable;
import java.util.List;

public class CommentsResultBean implements Serializable {
    private List<CommentItemBean> commentList;
    private int commentNextIndex;

    public final List<CommentItemBean> getCommentList() {
        return this.commentList;
    }

    public final int getCommentNextIndex() {
        return this.commentNextIndex;
    }

    public final void setCommentList(List<CommentItemBean> list) {
        this.commentList = list;
    }

    public final void setCommentNextIndex(int i11) {
        this.commentNextIndex = i11;
    }
}
