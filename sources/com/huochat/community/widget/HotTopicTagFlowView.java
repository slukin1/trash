package com.huochat.community.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.huochat.community.CommunityManager;
import com.huochat.community.CommunityThemeHelper;
import com.huochat.community.R;
import com.huochat.community.model.TopicBean;
import com.huochat.community.util.CollectionTool;
import com.huochat.community.util.DisplayTool;
import com.huochat.community.widget.divider.GridSpacingItemDecoration;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.nineoldandroids.animation.ValueAnimator;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.i;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class HotTopicTagFlowView extends RelativeLayout {
    /* access modifiers changed from: private */
    public HotTopicAdapter adapter;
    private AppBarLayout appBarLayout;
    /* access modifiers changed from: private */
    public OnItemClickListener clickListener;
    private int closeHeight = 0;
    /* access modifiers changed from: private */
    public final List<TopicBean> datas = new ArrayList();
    private RecyclerView flowLayout;
    private AtomicBoolean isInit = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public ImageView ivToggle;
    /* access modifiers changed from: private */
    public Context mContext;
    private AccelerateDecelerateInterpolator mInterpolator = new AccelerateDecelerateInterpolator();
    /* access modifiers changed from: private */
    public LayoutInflater mLocalInflater;
    private int openHeight = 0;
    private int perItemHeight = 0;
    private RelativeLayout rlToggleContainer;
    private int screenHeight = 0;
    /* access modifiers changed from: private */
    public final List<TopicBean> tempDatas = new ArrayList();
    private boolean toggle = false;

    public class HotTopicAdapter extends RecyclerView.Adapter<HotTopicViewHolder> {
        public HotTopicAdapter() {
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void lambda$onBindViewHolder$0(TopicBean topicBean, View view) {
            if (HotTopicTagFlowView.this.clickListener != null) {
                HotTopicTagFlowView.this.clickListener.onItemClick(topicBean);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public int getItemCount() {
            return HotTopicTagFlowView.this.tempDatas.size();
        }

        public void onBindViewHolder(HotTopicViewHolder hotTopicViewHolder, int i11) {
            TopicBean topicBean = (TopicBean) HotTopicTagFlowView.this.tempDatas.get(i11);
            if (topicBean != null) {
                hotTopicViewHolder.tvTopicName.setText(topicBean.getShowTopicName());
                hotTopicViewHolder.tvTopicName.setTextColor(CommunityThemeHelper.Companion.getColor(HotTopicTagFlowView.this.mContext, R.attr.hotTopicTagFlowNameTextColor));
                hotTopicViewHolder.itemView.setOnClickListener(new j(this, topicBean));
            }
        }

        public HotTopicViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
            return new HotTopicViewHolder(HotTopicTagFlowView.this.mLocalInflater.inflate(R.layout.community_item_hot_topic_tagflow, (ViewGroup) null));
        }
    }

    public static class HotTopicViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public final TextView tvTopicName;

        public HotTopicViewHolder(View view) {
            super(view);
            this.tvTopicName = (TextView) view.findViewById(R.id.tv_topic_name);
        }
    }

    public interface OnItemClickListener {
        FragmentActivity getParentActivity();

        void onItemClick(TopicBean topicBean);
    }

    public HotTopicTagFlowView(Context context) {
        super(context);
        initView(context, (AttributeSet) null);
    }

    private void close() {
        ValueAnimator A = createAnimator(this, this.openHeight, this.closeHeight).A(200);
        A.C(this.mInterpolator);
        A.b(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                HotTopicTagFlowView.this.tempDatas.clear();
                HotTopicTagFlowView.this.tempDatas.addAll(CollectionTool.Companion.subList(HotTopicTagFlowView.this.datas, 0, 2));
                HotTopicTagFlowView.this.adapter.notifyDataSetChanged();
                if (CommunityManager.Companion.getInstance().isNightModel()) {
                    HotTopicTagFlowView.this.ivToggle.setImageResource(R.drawable.community_ic_hot_topic_list_night_unfold);
                } else {
                    HotTopicTagFlowView.this.ivToggle.setImageResource(R.drawable.community_ic_hot_topic_list_light_unfold);
                }
            }
        });
        A.E();
    }

    private ValueAnimator createAnimator(View view, int i11, int i12) {
        ValueAnimator y11 = ValueAnimator.y(i11, i12);
        y11.p(new g(view));
        return y11;
    }

    private void getAppBarLayout(ViewGroup viewGroup) {
        for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
            View childAt = viewGroup.getChildAt(i11);
            if (childAt instanceof ViewGroup) {
                if (childAt instanceof AppBarLayout) {
                    this.appBarLayout = (AppBarLayout) childAt;
                    return;
                }
                getAppBarLayout((ViewGroup) childAt);
            }
        }
    }

    private LayoutInflater initInflater(Context context) {
        return LayoutInflater.from(context).cloneInContext(CommunityThemeHelper.Companion.getThemeContext(context));
    }

    private void initView(Context context, AttributeSet attributeSet) {
        this.mContext = context;
        LayoutInflater initInflater = initInflater(context);
        this.mLocalInflater = initInflater;
        View inflate = initInflater.inflate(R.layout.community_view_hot_topic_tagflow, this);
        View findViewById = inflate.findViewById(R.id.llTopicListContainer);
        CommunityThemeHelper.Companion companion = CommunityThemeHelper.Companion;
        findViewById.setBackgroundResource(companion.getDrawableRes(context, R.attr.communityHotTopicTagflowListBg));
        ImageView imageView = (ImageView) inflate.findViewById(R.id.ivToggle);
        this.ivToggle = imageView;
        imageView.setImageResource(companion.getDrawableRes(context, R.attr.hotTopicTagIvToggleSrc));
        this.rlToggleContainer = (RelativeLayout) inflate.findViewById(R.id.rlToggleContainer);
        this.flowLayout = (RecyclerView) inflate.findViewById(R.id.flowlayout);
        this.adapter = new HotTopicAdapter();
        this.flowLayout.setNestedScrollingEnabled(false);
        this.flowLayout.setLayoutManager(new GridLayoutManager(context, 2));
        this.flowLayout.addItemDecoration(new GridSpacingItemDecoration(2, DisplayTool.dp2px(13.0f), false));
        this.flowLayout.setAdapter(this.adapter);
        this.rlToggleContainer.setOnClickListener(new f(this));
        this.screenHeight = DisplayTool.getScreenWH(context)[1];
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$createAnimator$1(View view, ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.v()).intValue();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = intValue;
        view.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initView$0(View view) {
        toggle(this.toggle);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public void open() {
        ValueAnimator A = createAnimator(this, this.closeHeight, this.openHeight).A(200);
        A.C(this.mInterpolator);
        A.b(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (CommunityManager.Companion.getInstance().isNightModel()) {
                    HotTopicTagFlowView.this.ivToggle.setImageResource(R.drawable.community_ic_hot_topic_list_night_fold);
                } else {
                    HotTopicTagFlowView.this.ivToggle.setImageResource(R.drawable.community_ic_hot_topic_list_light_fold);
                }
            }

            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                HotTopicTagFlowView.this.adapter.notifyDataSetChanged();
            }
        });
        A.E();
    }

    private void scrollAppBarLayout(int i11) {
        AppBarLayout.Behavior behavior;
        if (this.appBarLayout == null) {
            try {
                OnItemClickListener onItemClickListener = this.clickListener;
                if (!(onItemClickListener == null || onItemClickListener.getParentActivity() == null)) {
                    getAppBarLayout((ViewGroup) ((ViewGroup) this.clickListener.getParentActivity().getWindow().getDecorView().findViewById(16908290)).getChildAt(0));
                }
            } catch (Exception e11) {
                e11.printStackTrace();
                open();
            }
        }
        AppBarLayout appBarLayout2 = this.appBarLayout;
        if (appBarLayout2 != null && (behavior = (AppBarLayout.Behavior) ((CoordinatorLayout.LayoutParams) appBarLayout2.getLayoutParams()).f()) != null) {
            int topAndBottomOffset = behavior.getTopAndBottomOffset();
            ValueAnimator A = ValueAnimator.y(0, i11).A(5);
            A.p(new h(behavior, topAndBottomOffset));
            A.b(new AnimatorListenerAdapter() {
                /* access modifiers changed from: private */
                public /* synthetic */ void lambda$onAnimationEnd$0() {
                    HotTopicTagFlowView.this.open();
                }

                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    i.b().g(new i(this), 50);
                }
            });
            A.E();
        }
    }

    private void toggle(boolean z11) {
        if (!z11) {
            this.toggle = true;
            this.tempDatas.clear();
            this.tempDatas.addAll(this.datas);
            if (this.closeHeight == 0) {
                this.closeHeight = getHeight();
            }
            if (this.perItemHeight == 0) {
                this.perItemHeight = this.flowLayout.getMeasuredHeight();
            }
            if (this.openHeight == 0) {
                this.openHeight = this.closeHeight + ((this.perItemHeight + DisplayTool.dp2px(13.0f)) * (((this.datas.size() / 2) + (this.datas.size() % 2)) - 1));
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            int i11 = (this.screenHeight - iArr[1]) - 750;
            if (i11 >= 0) {
                open();
            } else {
                scrollAppBarLayout(i11);
            }
        } else {
            this.toggle = false;
            this.openHeight = getHeight();
            close();
        }
    }

    public void setData(List<TopicBean> list, OnItemClickListener onItemClickListener) {
        if (!this.isInit.get()) {
            this.isInit.set(true);
            if (list == null || list.isEmpty()) {
                setVisibility(8);
                return;
            }
            this.clickListener = onItemClickListener;
            this.datas.clear();
            this.datas.addAll(list);
            if (this.datas.size() > 2) {
                this.tempDatas.clear();
                this.tempDatas.addAll(this.datas.subList(0, 2));
                this.ivToggle.setVisibility(0);
            } else {
                this.tempDatas.addAll(this.datas);
                this.ivToggle.setVisibility(8);
            }
            setVisibility(0);
            this.adapter.notifyDataSetChanged();
        }
    }

    public HotTopicTagFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context, attributeSet);
    }

    public HotTopicTagFlowView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        initView(context, attributeSet);
    }

    public HotTopicTagFlowView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        initView(context, attributeSet);
    }
}
