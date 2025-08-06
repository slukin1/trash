package com.huochat.community.widget.momentdetail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huochat.community.CommunityManager;
import com.huochat.community.CommunityThemeColor;
import com.huochat.community.R;
import com.huochat.community.adapter.CommentListAdapter;
import com.huochat.community.listener.OnCommentClickListener;
import com.huochat.community.model.CommentItemBean;
import com.huochat.community.network.CommunityApiManager;
import com.huochat.community.widget.refresh.ComSmartRefreshFooter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.List;
import uv.a;

public final class MomentCommentListView extends FrameLayout {
    /* access modifiers changed from: private */
    public ComSmartRefreshFooter comSmartRefreshFooter;
    private View commentEmptyView;
    /* access modifiers changed from: private */
    public CommentListAdapter commentListAdapter;
    private int commentListPageSize = 20;
    private RecyclerView commentRecycleView;
    private SmartRefreshLayout commentRefreshLayout;
    /* access modifiers changed from: private */
    public int commentStartIndex = -1;
    private CommunityThemeColor communityThemeColor = CommunityManager.Companion.getInstance().getCommunityThemeColor();
    /* access modifiers changed from: private */
    public boolean hasNextPageData = true;
    private boolean isShowCommentList = true;
    private ImageView ivErrorDefIcon;
    private String mid = "";
    private OnCommentClickListener onCommentClickListener;
    private TextView tvEmptyDesc;

    public MomentCommentListView(Context context) {
        super(context);
        init(context);
    }

    private final void getCommentList(Context context, Long l11, String str, int i11) {
        if (!this.hasNextPageData) {
            loadCommentComplate(context, 500);
        } else {
            CommunityApiManager.Companion.getInstance().getCommunityCommentList(str, i11, l11, this.commentListPageSize).d(new MomentCommentListView$getCommentList$1(this, context));
        }
    }

    private final void init(Context context) {
        View.inflate(context, R.layout.view_momment_recycleview_empty, this);
        TextView textView = (TextView) findViewById(R.id.text_view_empty_desc);
        this.tvEmptyDesc = textView;
        if (textView != null) {
            textView.setTextColor(this.communityThemeColor.getErrorDefTipsMomentEmptyTextColor());
        }
        this.commentRecycleView = (RecyclerView) findViewById(R.id.recycler_view);
        this.commentRefreshLayout = (SmartRefreshLayout) findViewById(R.id.smart_refresh_layout);
        View findViewById = findViewById(R.id.view_layout_empty);
        this.commentEmptyView = findViewById;
        RecyclerView recyclerView = null;
        if (findViewById == null) {
            findViewById = null;
        }
        ImageView imageView = (ImageView) findViewById.findViewById(R.id.image_view_empty_logo);
        this.ivErrorDefIcon = imageView;
        if (imageView != null) {
            imageView.setImageResource(this.communityThemeColor.getErrorDefIconMomentCommentEmpty());
        }
        SmartRefreshLayout smartRefreshLayout = this.commentRefreshLayout;
        if (smartRefreshLayout == null) {
            smartRefreshLayout = null;
        }
        smartRefreshLayout.i(false);
        ComSmartRefreshFooter comSmartRefreshFooter2 = new ComSmartRefreshFooter(context);
        this.comSmartRefreshFooter = comSmartRefreshFooter2;
        comSmartRefreshFooter2.setFooterDividerColor(this.communityThemeColor.getListDividingLineColor());
        ComSmartRefreshFooter comSmartRefreshFooter3 = this.comSmartRefreshFooter;
        if (comSmartRefreshFooter3 != null) {
            comSmartRefreshFooter3.setAccentColor(this.communityThemeColor.getCommunityMomentListNoMoreDataTipsTextColor());
        }
        SmartRefreshLayout smartRefreshLayout2 = this.commentRefreshLayout;
        if (smartRefreshLayout2 == null) {
            smartRefreshLayout2 = null;
        }
        smartRefreshLayout2.h0(this.comSmartRefreshFooter);
        SmartRefreshLayout smartRefreshLayout3 = this.commentRefreshLayout;
        if (smartRefreshLayout3 == null) {
            smartRefreshLayout3 = null;
        }
        smartRefreshLayout3.b0(new a(this, context));
        CommentListAdapter commentListAdapter2 = new CommentListAdapter(context);
        this.commentListAdapter = commentListAdapter2;
        commentListAdapter2.setOnCommentLongClick(this.onCommentClickListener);
        RecyclerView recyclerView2 = this.commentRecycleView;
        if (recyclerView2 == null) {
            recyclerView2 = null;
        }
        recyclerView2.setAdapter(this.commentListAdapter);
        RecyclerView recyclerView3 = this.commentRecycleView;
        if (recyclerView3 != null) {
            recyclerView = recyclerView3;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r4 = r4.getLastPostTime();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void init$lambda$0(com.huochat.community.widget.momentdetail.MomentCommentListView r2, android.content.Context r3, ky.j r4) {
        /*
            com.huochat.community.adapter.CommentListAdapter r4 = r2.commentListAdapter
            if (r4 == 0) goto L_0x000f
            java.lang.Long r4 = r4.getLastPostTime()
            if (r4 == 0) goto L_0x000f
            long r0 = r4.longValue()
            goto L_0x0011
        L_0x000f:
            r0 = -1
        L_0x0011:
            java.lang.Long r4 = java.lang.Long.valueOf(r0)
            java.lang.String r0 = r2.mid
            int r1 = r2.commentStartIndex
            r2.getCommentList(r3, r4, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huochat.community.widget.momentdetail.MomentCommentListView.init$lambda$0(com.huochat.community.widget.momentdetail.MomentCommentListView, android.content.Context, ky.j):void");
    }

    /* access modifiers changed from: private */
    public final void loadCommentComplate(Context context, int i11) {
        SmartRefreshLayout smartRefreshLayout = this.commentRefreshLayout;
        if (smartRefreshLayout == null) {
            smartRefreshLayout = null;
        }
        smartRefreshLayout.b(i11);
    }

    public final void addCommentDatas(List<? extends CommentItemBean> list, boolean z11) {
        CommentListAdapter commentListAdapter2 = this.commentListAdapter;
        if (commentListAdapter2 != null) {
            commentListAdapter2.addDatas(list, z11);
        }
    }

    public final void addFirstCommentItem(CommentItemBean commentItemBean) {
        CommentListAdapter commentListAdapter2 = this.commentListAdapter;
        if (commentListAdapter2 != null) {
            commentListAdapter2.addDatasFirst(commentItemBean);
        }
    }

    public final View getDefEmptyView() {
        View view = this.commentEmptyView;
        if (view == null) {
            return null;
        }
        return view;
    }

    public final int getStartIndex() {
        return this.commentStartIndex;
    }

    public final void handlerCommentEmpty() {
        RecyclerView recyclerView = null;
        if (!this.isShowCommentList) {
            View view = this.commentEmptyView;
            if (view == null) {
                view = null;
            }
            view.setVisibility(8);
            RecyclerView recyclerView2 = this.commentRecycleView;
            if (recyclerView2 != null) {
                recyclerView = recyclerView2;
            }
            recyclerView.setVisibility(4);
            return;
        }
        CommentListAdapter commentListAdapter2 = this.commentListAdapter;
        boolean z11 = true;
        if ((commentListAdapter2 != null ? commentListAdapter2.getItemCount() : 0) > 0) {
            View view2 = this.commentEmptyView;
            if (view2 == null) {
                view2 = null;
            }
            if (!(view2.getVisibility() == 8)) {
                View view3 = this.commentEmptyView;
                if (view3 == null) {
                    view3 = null;
                }
                view3.setVisibility(8);
                RecyclerView recyclerView3 = this.commentRecycleView;
                if (recyclerView3 != null) {
                    recyclerView = recyclerView3;
                }
                recyclerView.setVisibility(0);
                return;
            }
        }
        CommentListAdapter commentListAdapter3 = this.commentListAdapter;
        if ((commentListAdapter3 != null ? commentListAdapter3.getItemCount() : 0) == 0) {
            View view4 = this.commentEmptyView;
            if (view4 == null) {
                view4 = null;
            }
            if (view4.getVisibility() != 8) {
                z11 = false;
            }
            if (z11) {
                View view5 = this.commentEmptyView;
                if (view5 == null) {
                    view5 = null;
                }
                view5.setVisibility(0);
                RecyclerView recyclerView4 = this.commentRecycleView;
                if (recyclerView4 != null) {
                    recyclerView = recyclerView4;
                }
                recyclerView.setVisibility(8);
            }
        }
    }

    public final void initData(Context context, String str, List<CommentItemBean> list, int i11) {
        this.mid = str;
        if (list == null || !(!list.isEmpty())) {
            this.hasNextPageData = true;
            getCommentList(context, -1L, str, -1);
            return;
        }
        CommentListAdapter commentListAdapter2 = this.commentListAdapter;
        boolean z11 = false;
        if (commentListAdapter2 != null) {
            commentListAdapter2.addDatas(list, this.commentStartIndex <= 0);
        }
        this.commentStartIndex = i11;
        if ((i11 != -1) && list.size() >= this.commentListPageSize) {
            z11 = true;
        }
        this.hasNextPageData = z11;
        handlerCommentEmpty();
        ComSmartRefreshFooter comSmartRefreshFooter2 = this.comSmartRefreshFooter;
        if (comSmartRefreshFooter2 != null) {
            comSmartRefreshFooter2.setNoMoreData(!this.hasNextPageData);
        }
    }

    public final void notifyThemeChanged() {
        CommunityThemeColor communityThemeColor2 = CommunityManager.Companion.getInstance().getCommunityThemeColor();
        this.communityThemeColor = communityThemeColor2;
        ImageView imageView = this.ivErrorDefIcon;
        if (imageView != null) {
            imageView.setImageResource(communityThemeColor2.getErrorDefIconMomentCommentEmpty());
        }
        TextView textView = this.tvEmptyDesc;
        if (textView != null) {
            textView.setTextColor(this.communityThemeColor.getErrorDefTipsMomentEmptyTextColor());
        }
        CommentListAdapter commentListAdapter2 = this.commentListAdapter;
        if (commentListAdapter2 != null) {
            commentListAdapter2.notifyThemeChanged();
        }
        ComSmartRefreshFooter comSmartRefreshFooter2 = this.comSmartRefreshFooter;
        if (comSmartRefreshFooter2 != null) {
            comSmartRefreshFooter2.setFooterDividerColor(this.communityThemeColor.getListDividingLineColor());
        }
        ComSmartRefreshFooter comSmartRefreshFooter3 = this.comSmartRefreshFooter;
        if (comSmartRefreshFooter3 != null) {
            comSmartRefreshFooter3.setAccentColor(this.communityThemeColor.getCommunityMomentListNoMoreDataTipsTextColor());
        }
    }

    public final void removeCommentItem(CommentItemBean commentItemBean) {
        CommentListAdapter commentListAdapter2 = this.commentListAdapter;
        if (commentListAdapter2 != null) {
            commentListAdapter2.removeData(commentItemBean);
        }
    }

    public final void scrollToCommentPosition(int i11) {
        RecyclerView recyclerView = this.commentRecycleView;
        if (recyclerView == null) {
            recyclerView = null;
        }
        recyclerView.scrollToPosition(i11);
    }

    public final void setCommentListVisible(boolean z11) {
        this.isShowCommentList = z11;
        handlerCommentEmpty();
    }

    public final void setOnCommentItemClick(OnCommentClickListener onCommentClickListener2) {
        this.onCommentClickListener = onCommentClickListener2;
        CommentListAdapter commentListAdapter2 = this.commentListAdapter;
        if (commentListAdapter2 != null) {
            commentListAdapter2.setOnCommentLongClick(onCommentClickListener2);
        }
    }

    public final List<CommentItemBean> getCommentList() {
        CommentListAdapter commentListAdapter2 = this.commentListAdapter;
        if (commentListAdapter2 != null) {
            return commentListAdapter2.getList();
        }
        return null;
    }

    public MomentCommentListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public MomentCommentListView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(context);
    }
}
