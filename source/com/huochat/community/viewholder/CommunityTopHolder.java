package com.huochat.community.viewholder;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.huochat.community.CommunityThemeHelper;
import com.huochat.community.R;
import com.huochat.community.enums.CommunityMenuItems;
import com.huochat.community.listener.OnCommunitySortClickListener;
import com.huochat.community.model.TopicBean;
import com.huochat.community.util.DisplayTool;
import com.huochat.community.widget.HotTopicTagFlowView;
import com.nineoldandroids.animation.ValueAnimator;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.List;
import tv.u;
import tv.v;

public final class CommunityTopHolder extends RecyclerView.ViewHolder {
    private Activity activity;
    private AppBarLayout appBarLayout;
    private CommunityMenuItems communityListSort = CommunityMenuItems.DEFAULT;
    private HotTopicTagFlowView hotTopicTagFlowView;
    private int screenHeight;
    private OnCommunitySortClickListener sortClickListener;
    private TextView tvNewDynamicCount;
    private TextView tvNewDynamicSort;
    private View vSortBottomLine;

    public CommunityTopHolder(Activity activity2, View view) {
        super(view);
        this.activity = activity2;
        this.hotTopicTagFlowView = (HotTopicTagFlowView) view.findViewById(R.id.hot_topic_tag_flow_view);
        this.tvNewDynamicCount = (TextView) view.findViewById(R.id.tv_new_dynamic_count);
        this.vSortBottomLine = view.findViewById(R.id.v_sort_bottom_line);
        TextView textView = (TextView) view.findViewById(R.id.tv_new_dynamic_sort);
        this.tvNewDynamicSort = textView;
        textView.setOnClickListener(new u(this));
        this.screenHeight = DisplayTool.getScreenWH(this.activity)[1];
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static final void _init_$lambda$0(CommunityTopHolder communityTopHolder, View view) {
        communityTopHolder.openSortMenuDialog();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private final void getAppBarLayout(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
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

    /* access modifiers changed from: private */
    public final void openMenu() {
        OnCommunitySortClickListener onCommunitySortClickListener = this.sortClickListener;
        if (onCommunitySortClickListener != null) {
            onCommunitySortClickListener.onClick(this.tvNewDynamicSort, this.vSortBottomLine, this.communityListSort);
        }
    }

    private final void openSortMenuDialog() {
        int[] iArr = new int[2];
        this.tvNewDynamicSort.getLocationOnScreen(iArr);
        int dp2px = (this.screenHeight - iArr[1]) - DisplayTool.dp2px(180.0f);
        if (dp2px >= 0) {
            openMenu();
        } else {
            scrollAppBarLayout(dp2px);
        }
    }

    private final void scrollAppBarLayout(int i11) {
        AppBarLayout.Behavior behavior;
        if (this.appBarLayout == null) {
            try {
                OnCommunitySortClickListener onCommunitySortClickListener = this.sortClickListener;
                FragmentActivity parentActivity = onCommunitySortClickListener != null ? onCommunitySortClickListener.getParentActivity() : null;
                if (parentActivity != null && !parentActivity.isFinishing()) {
                    getAppBarLayout((ViewGroup) ((ViewGroup) parentActivity.getWindow().getDecorView().findViewById(16908290)).getChildAt(0));
                }
            } catch (Exception e11) {
                e11.printStackTrace();
                openMenu();
            }
        }
        AppBarLayout appBarLayout2 = this.appBarLayout;
        if (appBarLayout2 != null && (behavior = (AppBarLayout.Behavior) ((CoordinatorLayout.LayoutParams) appBarLayout2.getLayoutParams()).f()) != null) {
            int topAndBottomOffset = behavior.getTopAndBottomOffset();
            ValueAnimator A = ValueAnimator.y(0, i11).A(5);
            A.p(new v(behavior, topAndBottomOffset));
            A.b(new CommunityTopHolder$scrollAppBarLayout$2(this));
            A.E();
        }
    }

    /* access modifiers changed from: private */
    public static final void scrollAppBarLayout$lambda$3(AppBarLayout.Behavior behavior, int i11, ValueAnimator valueAnimator) {
        behavior.setTopAndBottomOffset(i11 + ((Integer) valueAnimator.v()).intValue());
    }

    public final void bindData(String str, boolean z11) {
        int i11 = 0;
        if (!(str == null || str.length() == 0)) {
            this.tvNewDynamicCount.setText(str);
        }
        TextView textView = this.tvNewDynamicSort;
        if (!z11) {
            i11 = 8;
        }
        textView.setVisibility(i11);
    }

    public final void bindHotTopicData(List<TopicBean> list, HotTopicTagFlowView.OnItemClickListener onItemClickListener) {
        int i11 = 0;
        if (list == null || list.isEmpty()) {
            i11 = 8;
        }
        this.hotTopicTagFlowView.setVisibility(i11);
        this.hotTopicTagFlowView.setData(list, onItemClickListener);
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final void resetSortBtnStatus(CommunityMenuItems communityMenuItems) {
        setSortBtnType(communityMenuItems);
    }

    public final void setActivity(Activity activity2) {
        this.activity = activity2;
    }

    public final void setOnSortClickListener(OnCommunitySortClickListener onCommunitySortClickListener) {
        this.sortClickListener = onCommunitySortClickListener;
    }

    public final void setSortBtnType(CommunityMenuItems communityMenuItems) {
        TextView textView;
        String str;
        int i11;
        this.communityListSort = communityMenuItems;
        Activity activity2 = this.activity;
        if (activity2 != null && !activity2.isFinishing() && (textView = this.tvNewDynamicSort) != null) {
            if (communityMenuItems == CommunityMenuItems.LAST_TIME) {
                str = this.activity.getResources().getString(R.string.community_sort_menu_time);
                i11 = CommunityThemeHelper.Companion.getDrawableRes(textView.getContext(), R.attr.communityListTopTimeSortBtnIcon);
            } else {
                str = this.activity.getResources().getString(R.string.community_sort_menu_normal);
                i11 = CommunityThemeHelper.Companion.getDrawableRes(textView.getContext(), R.attr.communityListTopDefaultSortBtnIcon);
            }
            textView.setText(str);
            textView.setCompoundDrawablesWithIntrinsicBounds(i11, 0, 0, 0);
        }
    }
}
