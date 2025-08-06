package com.huochat.community.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.huochat.community.CommunityManager;
import com.huochat.community.CommunityThemeColor;
import com.huochat.community.R;
import com.huochat.community.holders.CommentFullHolder;
import com.huochat.community.holders.CommentSubHolder;
import com.huochat.community.listener.OnCommentClickListener;
import com.huochat.community.model.CommentItemBean;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class CommentListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements Serializable {
    private CommentType commentType;
    private CommunityThemeColor communityThemeColor;
    private Context mContext;
    private List<CommentItemBean> mDataList;
    private OnCommentClickListener onCommentClickListener;

    public enum CommentType {
        LIST_FULL(1, "全量评论列表"),
        LIST_SUB(2, "部分评论列表");
        
        private String desc;
        private int type;

        private CommentType(int i11, String str) {
            this.type = i11;
            this.desc = str;
        }

        public final String getDesc() {
            return this.desc;
        }

        public final int getType() {
            return this.type;
        }

        public final void setDesc(String str) {
            this.desc = str;
        }

        public final void setType(int i11) {
            this.type = i11;
        }
    }

    public CommentListAdapter(Context context) {
        this.communityThemeColor = CommunityManager.Companion.getInstance().getCommunityThemeColor();
        this.mContext = context;
        this.commentType = CommentType.LIST_FULL;
        this.mDataList = new LinkedList();
    }

    public final void addData(CommentItemBean commentItemBean) {
        if (commentItemBean != null) {
            this.mDataList.add(commentItemBean);
            notifyDataSetChanged();
        }
    }

    public final void addDatas(List<? extends CommentItemBean> list, boolean z11) {
        int size = this.mDataList.size();
        if (size == 0 || z11) {
            resetData(list);
            return;
        }
        this.mDataList.addAll(list);
        notifyItemRangeChanged(size - 1, this.mDataList.size() - 1);
    }

    public final void addDatasFirst(CommentItemBean commentItemBean) {
        if (commentItemBean != null) {
            this.mDataList.add(0, commentItemBean);
            notifyItemInserted(0);
        }
    }

    public final void bindDataForView(CommentFullHolder commentFullHolder, CommentItemBean commentItemBean, int i11) {
        if (commentFullHolder != null) {
            boolean z11 = true;
            int i12 = 0;
            if (i11 != getItemCount() - 1) {
                z11 = false;
            }
            if (z11) {
                i12 = 4;
            }
            commentFullHolder.setBottomLineVisibility(i12);
            commentFullHolder.bindData(commentItemBean, this.onCommentClickListener);
        }
    }

    public int getItemCount() {
        return this.mDataList.size();
    }

    public final String getLastId() {
        List<CommentItemBean> list = this.mDataList;
        boolean z11 = false;
        if (list == null || list.isEmpty()) {
            return "-1";
        }
        List<CommentItemBean> list2 = this.mDataList;
        CommentItemBean commentItemBean = list2.get(list2.size() - 1);
        if (commentItemBean == null) {
            return "-1";
        }
        if (commentItemBean.getReplyType() == 1) {
            String mcid = commentItemBean.getMcid();
            if (mcid == null || mcid.length() == 0) {
                z11 = true;
            }
            if (z11) {
                return "-1";
            }
            return commentItemBean.getMcid();
        }
        String replyId = commentItemBean.getReplyId();
        if (replyId == null || replyId.length() == 0) {
            z11 = true;
        }
        if (z11) {
            return "-1";
        }
        return commentItemBean.getReplyId();
    }

    public final Long getLastPostTime() {
        List<CommentItemBean> list = this.mDataList;
        if (!(list == null || list.isEmpty())) {
            List<CommentItemBean> list2 = this.mDataList;
            CommentItemBean commentItemBean = list2.get(list2.size() - 1);
            if (commentItemBean != null) {
                return commentItemBean.getPostTime();
            }
        }
        return -1L;
    }

    public final List<CommentItemBean> getList() {
        return this.mDataList;
    }

    public final void insertData(CommentItemBean commentItemBean) {
        if (commentItemBean != null) {
            this.mDataList.add(0, commentItemBean);
            notifyItemInserted(0);
        }
    }

    public final void notifyThemeChanged() {
        this.communityThemeColor = CommunityManager.Companion.getInstance().getCommunityThemeColor();
        notifyDataSetChanged();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i11) {
        int layoutPosition = viewHolder.getLayoutPosition();
        CommentItemBean commentItemBean = null;
        if (CommentType.LIST_SUB == this.commentType) {
            CommentSubHolder commentSubHolder = (CommentSubHolder) viewHolder;
            if ((!this.mDataList.isEmpty()) && this.mDataList.size() > layoutPosition) {
                commentItemBean = this.mDataList.get(layoutPosition);
            }
            bindDataForView(commentSubHolder, commentItemBean, layoutPosition);
            return;
        }
        CommentFullHolder commentFullHolder = (CommentFullHolder) viewHolder;
        if ((!this.mDataList.isEmpty()) && this.mDataList.size() > layoutPosition) {
            commentItemBean = this.mDataList.get(layoutPosition);
        }
        bindDataForView(commentFullHolder, commentItemBean, layoutPosition);
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        if (CommentType.LIST_SUB == this.commentType) {
            return new CommentSubHolder(viewGroup.getContext(), LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_moment_comment_sub_view, (ViewGroup) null, false));
        }
        return new CommentFullHolder(this.mContext, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_moment_comment_full_view, (ViewGroup) null, false));
    }

    public final void removeData(CommentItemBean commentItemBean) {
        int f02 = CollectionsKt___CollectionsKt.f0(this.mDataList, commentItemBean);
        if (-1 != f02) {
            this.mDataList.remove(f02);
            notifyItemRemoved(f02);
        }
    }

    public final void resetData(List<? extends CommentItemBean> list) {
        this.mDataList.clear();
        this.mDataList.addAll(list);
        notifyDataSetChanged();
    }

    public final void setOnCommentLongClick(OnCommentClickListener onCommentClickListener2) {
        this.onCommentClickListener = onCommentClickListener2;
    }

    public final void bindDataForView(CommentSubHolder commentSubHolder, CommentItemBean commentItemBean, int i11) {
        if (commentSubHolder != null) {
            commentSubHolder.bindData(commentItemBean, this.onCommentClickListener);
        }
    }

    public CommentListAdapter(Context context, CommentType commentType2) {
        this(context);
        this.commentType = commentType2;
        this.mDataList = new LinkedList();
    }
}
