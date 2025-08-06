package com.huochat.community.widget.momentdetail;

import android.content.Context;
import android.util.Log;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.huochat.community.adapter.CommentListAdapter;
import com.huochat.community.model.CommentsResultBean;
import com.huochat.community.widget.refresh.ComSmartRefreshFooter;

public final class MomentCommentListView$getCommentList$1 extends RequestCallback1<CommentsResultBean> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ MomentCommentListView this$0;

    public MomentCommentListView$getCommentList$1(MomentCommentListView momentCommentListView, Context context) {
        this.this$0 = momentCommentListView;
        this.$context = context;
    }

    public void onRequestFailure(Throwable th2) {
        String str;
        this.this$0.loadCommentComplate(this.$context, 200);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("## reqError: ");
        if (th2 == null || (str = th2.getMessage()) == null) {
            str = "Request failure!";
        }
        sb2.append(str);
        Log.i("community", sb2.toString());
    }

    public void onRequestSuccess(CommentsResultBean commentsResultBean) {
        CommentListAdapter access$getCommentListAdapter$p;
        boolean z11 = false;
        if (commentsResultBean != null) {
            MomentCommentListView momentCommentListView = this.this$0;
            if (!(commentsResultBean.getCommentList() == null || (access$getCommentListAdapter$p = momentCommentListView.commentListAdapter) == null)) {
                access$getCommentListAdapter$p.addDatas(commentsResultBean.getCommentList(), momentCommentListView.commentStartIndex <= 0);
            }
            momentCommentListView.commentStartIndex = commentsResultBean.getCommentNextIndex();
        }
        if (this.this$0.commentStartIndex != -1) {
            z11 = true;
        }
        this.this$0.hasNextPageData = z11;
        ComSmartRefreshFooter access$getComSmartRefreshFooter$p = this.this$0.comSmartRefreshFooter;
        if (access$getComSmartRefreshFooter$p != null) {
            access$getComSmartRefreshFooter$p.setNoMoreData(!this.this$0.hasNextPageData);
        }
        this.this$0.handlerCommentEmpty();
        this.this$0.loadCommentComplate(this.$context, 200);
    }
}
