package com.huochat.community.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.android.material.appbar.AppBarLayout;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.widgets.AutoSizeTextView;
import com.huochat.community.CommunityManager;
import com.huochat.community.CommunityThemeHelper;
import com.huochat.community.R;
import com.huochat.community.adapter.CommunityAdapter;
import com.huochat.community.base.BaseActivity;
import com.huochat.community.base.CommunityConstants;
import com.huochat.community.model.CommunityItemBean;
import com.huochat.community.model.TopicDetailBean;
import com.huochat.community.network.CommunityApiManager;
import com.huochat.community.util.NBStatusBarUtils;
import com.huochat.community.util.NetTool;
import com.huochat.community.widget.CommonToolbar;
import com.huochat.community.widget.TopicDetailRecyclerViewRadius;
import com.huochat.community.widget.expandable.ExpandableTextView;
import com.huochat.community.widget.expandable.OnExpandableContractChangedListener;
import com.huochat.community.widget.expandable.StatusType;
import com.huochat.community.widget.refresh.ComSmartRefreshFooter;
import com.huochat.community.widget.skeleton.CommunityListSkeletonView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.i;
import java.util.List;
import ky.j;
import pv.n;
import pv.p;
import pv.q;
import pv.r;
import pv.s;
import pv.t;
import pv.u;
import pv.v;

@Route(path = "/hbc_community/topicSearchTemplate")
public final class TopicSearchTemplateActivity extends BaseActivity {
    /* access modifiers changed from: private */
    public CommunityAdapter circleAdapter;
    private FrameLayout flEmptyContainer;
    private boolean hasNextPageData = true;
    private ImageView ivPerson;
    private ImageView iv_empty_icon;
    private LinearLayout llContractBtnPanel;
    private final OnExpandableContractChangedListener mContractChangedListener = new t(this);
    private final View.OnLayoutChangeListener mOnLayoutChangeListener = new r(this);
    private final AppBarLayout.OnOffsetChangedListener mOnOffsetChangedListener = new s(this);
    private Long markTime;
    private RecyclerView rvDiscussion;
    private ComSmartRefreshFooter smartRefreshFooter;
    private SmartRefreshLayout srlRefreshLayout;
    /* access modifiers changed from: private */
    public int startIndex = -1;
    private Toolbar tlPageToolbar;
    private AppBarLayout topicDetailAppBar;
    private TopicDetailBean topicDetailBean;
    private View topicDetailEmpty;
    private CommunityListSkeletonView topicDetailSkeleton;
    private CommonToolbar topicDetailctbToolbar;
    private View topicDetailctbToolbarLine;
    private String topicId;
    private String topicName;
    private String topicNameForSearch;
    private TextView tvContractHint;
    private ImageView tvContractIcon;
    private ExpandableTextView tvIntroduction;
    private AutoSizeTextView tvTopicName;
    private TextView tv_empty_hint;
    private TextView tv_retry;

    private final void getRealDiscussList() {
        this.hasNextPageData = true;
        if (!NetTool.isNetworkAvailable() || !NetworkStatus.c(this)) {
            handleEmptyView(false);
        } else {
            CommunityApiManager.Companion.getInstance().getMomentListByTopic(this.topicName, this.topicNameForSearch, this.startIndex, this.markTime).d(new TopicSearchTemplateActivity$getRealDiscussList$1(this));
        }
    }

    /* access modifiers changed from: private */
    public final void handleCallback(TopicDetailBean topicDetailBean2) {
        boolean z11 = false;
        boolean z12 = -1 == this.startIndex;
        if (topicDetailBean2 == null) {
            handleEmptyView(true);
            return;
        }
        CommunityAdapter communityAdapter = this.circleAdapter;
        SmartRefreshLayout smartRefreshLayout = null;
        if (communityAdapter != null) {
            RecyclerView recyclerView = this.rvDiscussion;
            if (recyclerView == null) {
                recyclerView = null;
            }
            communityAdapter.setDefItemWidth(recyclerView.getWidth());
        }
        this.topicDetailBean = topicDetailBean2;
        List<CommunityItemBean> list = topicDetailBean2.getList();
        if (!(list == null || list.isEmpty())) {
            CommunityAdapter communityAdapter2 = this.circleAdapter;
            if (communityAdapter2 != null) {
                communityAdapter2.addDatas(topicDetailBean2.getList(), this.startIndex == -1);
            }
            this.markTime = ((CommunityItemBean) CollectionsKt___CollectionsKt.m0(topicDetailBean2.getList())).getMarkTime();
        }
        if (z12) {
            AutoSizeTextView autoSizeTextView = this.tvTopicName;
            if (autoSizeTextView == null) {
                autoSizeTextView = null;
            }
            autoSizeTextView.setText(topicDetailBean2.getTopicName());
            String topicIntroduction = topicDetailBean2.getTopicIntroduction();
            int i11 = topicIntroduction == null || topicIntroduction.length() == 0 ? 2 : 1;
            ExpandableTextView expandableTextView = this.tvIntroduction;
            if (expandableTextView == null) {
                expandableTextView = null;
            }
            expandableTextView.setMinLines(i11);
            ExpandableTextView expandableTextView2 = this.tvIntroduction;
            if (expandableTextView2 == null) {
                expandableTextView2 = null;
            }
            expandableTextView2.setContent((CharSequence) topicDetailBean2.getTopicIntroduction(), (StatusType) null);
        }
        this.startIndex = topicDetailBean2.getNextIndex();
        SmartRefreshLayout smartRefreshLayout2 = this.srlRefreshLayout;
        if (smartRefreshLayout2 != null) {
            smartRefreshLayout = smartRefreshLayout2;
        }
        if (topicDetailBean2.getNextIndex() == -1) {
            z11 = true;
        }
        smartRefreshLayout.setNoMoreData(z11);
        handleEmptyView(true);
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [android.widget.TextView] */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v3, types: [android.widget.FrameLayout] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v5, types: [android.widget.TextView] */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void handleEmptyView(boolean r5) {
        /*
            r4 = this;
            com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = r4.srlRefreshLayout
            r1 = 0
            if (r0 != 0) goto L_0x0006
            r0 = r1
        L_0x0006:
            r0.w()
            r0 = 0
            r4.shouLoading(r0)
            boolean r2 = com.huochat.community.util.NetTool.isNetworkAvailable()
            r3 = 8
            if (r2 == 0) goto L_0x009c
            boolean r2 = com.hbg.lib.common.network.NetworkStatus.c(r4)
            if (r2 == 0) goto L_0x009c
            if (r5 != 0) goto L_0x001f
            goto L_0x009c
        L_0x001f:
            com.huochat.community.adapter.CommunityAdapter r5 = r4.circleAdapter
            if (r5 == 0) goto L_0x002b
            boolean r5 = r5.hasListData()
            if (r5 != 0) goto L_0x002b
            r5 = 1
            goto L_0x002c
        L_0x002b:
            r5 = r0
        L_0x002c:
            if (r5 == 0) goto L_0x0089
            androidx.recyclerview.widget.RecyclerView r5 = r4.rvDiscussion
            if (r5 != 0) goto L_0x0033
            r5 = r1
        L_0x0033:
            r5.setVisibility(r3)
            android.widget.FrameLayout r5 = r4.flEmptyContainer
            if (r5 != 0) goto L_0x003b
            r5 = r1
        L_0x003b:
            r5.setVisibility(r0)
            android.view.View r5 = r4.topicDetailEmpty
            if (r5 != 0) goto L_0x0043
            r5 = r1
        L_0x0043:
            r5.setVisibility(r0)
            android.widget.TextView r5 = r4.tv_empty_hint
            if (r5 != 0) goto L_0x004b
            r5 = r1
        L_0x004b:
            r5.setVisibility(r0)
            android.widget.TextView r5 = r4.tv_empty_hint
            if (r5 != 0) goto L_0x0053
            r5 = r1
        L_0x0053:
            android.content.res.Resources r0 = r4.getResources()
            int r2 = com.huochat.community.R.string.community_empty_no_content_hint
            java.lang.String r0 = r0.getString(r2)
            r5.setText(r0)
            android.widget.TextView r5 = r4.tv_empty_hint
            if (r5 != 0) goto L_0x0065
            r5 = r1
        L_0x0065:
            com.huochat.community.CommunityThemeHelper$Companion r0 = com.huochat.community.CommunityThemeHelper.Companion
            int r2 = com.huochat.community.R.attr.communityEmptyHintTextColor
            int r2 = r0.getColor(r4, r2)
            r5.setTextColor(r2)
            android.widget.ImageView r5 = r4.iv_empty_icon
            if (r5 != 0) goto L_0x0075
            r5 = r1
        L_0x0075:
            int r2 = com.huochat.community.R.attr.communityEmptyIcon
            int r0 = r0.getDrawableRes(r4, r2)
            r5.setImageResource(r0)
            android.widget.TextView r5 = r4.tv_retry
            if (r5 != 0) goto L_0x0083
            goto L_0x0084
        L_0x0083:
            r1 = r5
        L_0x0084:
            r1.setVisibility(r3)
            goto L_0x0116
        L_0x0089:
            androidx.recyclerview.widget.RecyclerView r5 = r4.rvDiscussion
            if (r5 != 0) goto L_0x008e
            r5 = r1
        L_0x008e:
            r5.setVisibility(r0)
            android.widget.FrameLayout r5 = r4.flEmptyContainer
            if (r5 != 0) goto L_0x0096
            goto L_0x0097
        L_0x0096:
            r1 = r5
        L_0x0097:
            r1.setVisibility(r3)
            goto L_0x0116
        L_0x009c:
            androidx.recyclerview.widget.RecyclerView r5 = r4.rvDiscussion
            if (r5 != 0) goto L_0x00a1
            r5 = r1
        L_0x00a1:
            r5.setVisibility(r3)
            android.widget.FrameLayout r5 = r4.flEmptyContainer
            if (r5 != 0) goto L_0x00a9
            r5 = r1
        L_0x00a9:
            r5.setVisibility(r0)
            android.view.View r5 = r4.topicDetailEmpty
            if (r5 != 0) goto L_0x00b1
            r5 = r1
        L_0x00b1:
            r5.setVisibility(r0)
            android.widget.TextView r5 = r4.tv_empty_hint
            if (r5 != 0) goto L_0x00b9
            r5 = r1
        L_0x00b9:
            android.content.res.Resources r2 = r4.getResources()
            int r3 = com.huochat.community.R.string.common_no_internet_access
            java.lang.String r2 = r2.getString(r3)
            r5.setText(r2)
            android.widget.TextView r5 = r4.tv_empty_hint
            if (r5 != 0) goto L_0x00cb
            r5 = r1
        L_0x00cb:
            com.huochat.community.CommunityThemeHelper$Companion r2 = com.huochat.community.CommunityThemeHelper.Companion
            int r3 = com.huochat.community.R.attr.communityEmptyHintTextColor
            int r3 = r2.getColor(r4, r3)
            r5.setTextColor(r3)
            android.widget.ImageView r5 = r4.iv_empty_icon
            if (r5 != 0) goto L_0x00db
            r5 = r1
        L_0x00db:
            int r3 = com.huochat.community.R.attr.communityNetUnableIcon
            int r3 = r2.getDrawableRes(r4, r3)
            r5.setImageResource(r3)
            android.widget.TextView r5 = r4.tv_retry
            if (r5 != 0) goto L_0x00e9
            r5 = r1
        L_0x00e9:
            r5.setVisibility(r0)
            android.widget.TextView r5 = r4.tv_retry
            if (r5 != 0) goto L_0x00f1
            r5 = r1
        L_0x00f1:
            int r0 = com.huochat.community.R.attr.communityNetUnableRetryTextColor
            int r0 = r2.getColor(r4, r0)
            r5.setTextColor(r0)
            android.widget.TextView r5 = r4.tv_retry
            if (r5 != 0) goto L_0x00ff
            r5 = r1
        L_0x00ff:
            int r0 = com.huochat.community.R.attr.communityNetUnableRetryBackground
            int r0 = r2.getDrawableRes(r4, r0)
            r5.setBackgroundResource(r0)
            android.widget.TextView r5 = r4.tv_retry
            if (r5 != 0) goto L_0x010d
            goto L_0x010e
        L_0x010d:
            r1 = r5
        L_0x010e:
            pv.o r5 = new pv.o
            r5.<init>(r4)
            r1.setOnClickListener(r5)
        L_0x0116:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huochat.community.activity.TopicSearchTemplateActivity.handleEmptyView(boolean):void");
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static final void handleEmptyView$lambda$5(TopicSearchTemplateActivity topicSearchTemplateActivity, View view) {
        topicSearchTemplateActivity.getRealDiscussList();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static final void initView$lambda$0(TopicSearchTemplateActivity topicSearchTemplateActivity, View view) {
        topicSearchTemplateActivity.finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$1(TopicSearchTemplateActivity topicSearchTemplateActivity, j jVar) {
        topicSearchTemplateActivity.getRealDiscussList();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static final void initView$lambda$2(TopicSearchTemplateActivity topicSearchTemplateActivity, View view) {
        topicSearchTemplateActivity.finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static final void initView$lambda$3(TopicSearchTemplateActivity topicSearchTemplateActivity, View view) {
        ExpandableTextView expandableTextView = topicSearchTemplateActivity.tvIntroduction;
        if (expandableTextView == null) {
            expandableTextView = null;
        }
        expandableTextView.setCurrStatus(StatusType.STATUS_EXPAND);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public static final void mContractChangedListener$lambda$9(TopicSearchTemplateActivity topicSearchTemplateActivity, boolean z11, StatusType statusType) {
        LinearLayout linearLayout = topicSearchTemplateActivity.llContractBtnPanel;
        ImageView imageView = null;
        if (linearLayout == null) {
            linearLayout = null;
        }
        linearLayout.setVisibility(z11 ? 0 : 8);
        if (!z11) {
            return;
        }
        if (statusType == StatusType.STATUS_EXPAND) {
            TextView textView = topicSearchTemplateActivity.tvContractHint;
            if (textView == null) {
                textView = null;
            }
            textView.setText(topicSearchTemplateActivity.getResources().getString(R.string.community_expandable_expand_hint));
            ImageView imageView2 = topicSearchTemplateActivity.tvContractIcon;
            if (imageView2 != null) {
                imageView = imageView2;
            }
            imageView.setImageResource(R.drawable.ic_community_expandable_expand_arrow_down);
            return;
        }
        TextView textView2 = topicSearchTemplateActivity.tvContractHint;
        if (textView2 == null) {
            textView2 = null;
        }
        textView2.setText(topicSearchTemplateActivity.getResources().getString(R.string.community_expandable_contract_hint));
        ImageView imageView3 = topicSearchTemplateActivity.tvContractIcon;
        if (imageView3 != null) {
            imageView = imageView3;
        }
        imageView.setImageResource(R.drawable.ic_community_expandable_contract_arrow_up);
    }

    /* access modifiers changed from: private */
    public static final void mOnLayoutChangeListener$lambda$7(TopicSearchTemplateActivity topicSearchTemplateActivity, View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        if (i14 - i12 != i18 - i16) {
            topicSearchTemplateActivity.resetPersonImageSize();
        }
    }

    /* access modifiers changed from: private */
    public static final void mOnOffsetChangedListener$lambda$8(TopicSearchTemplateActivity topicSearchTemplateActivity, AppBarLayout appBarLayout, int i11) {
        CommonToolbar commonToolbar = null;
        if (i11 == 0) {
            Toolbar toolbar = topicSearchTemplateActivity.tlPageToolbar;
            if (toolbar == null) {
                toolbar = null;
            }
            toolbar.getBackground().setAlpha(0);
        }
        int abs = Math.abs(i11) > 200 ? 200 : Math.abs(i11);
        float f11 = ((float) 255) * (((float) abs) / 200.0f);
        Toolbar toolbar2 = topicSearchTemplateActivity.tlPageToolbar;
        if (toolbar2 == null) {
            toolbar2 = null;
        }
        toolbar2.getBackground().setAlpha((int) f11);
        if (abs >= 200) {
            CommonToolbar commonToolbar2 = topicSearchTemplateActivity.topicDetailctbToolbar;
            if (commonToolbar2 == null) {
                commonToolbar2 = null;
            }
            commonToolbar2.setTitle(topicSearchTemplateActivity.topicName);
            View view = topicSearchTemplateActivity.topicDetailctbToolbarLine;
            if (view == null) {
                view = null;
            }
            view.setVisibility(0);
            if (CommunityManager.Companion.getInstance().isNightModel()) {
                NBStatusBarUtils.setStatusBarDarkMode(topicSearchTemplateActivity);
                CommonToolbar commonToolbar3 = topicSearchTemplateActivity.topicDetailctbToolbar;
                if (commonToolbar3 != null) {
                    commonToolbar = commonToolbar3;
                }
                commonToolbar.getIvLeftIcon().setColorFilter(topicSearchTemplateActivity.getResources().getColor(R.color.color_CFD3E9));
                return;
            }
            return;
        }
        CommonToolbar commonToolbar4 = topicSearchTemplateActivity.topicDetailctbToolbar;
        if (commonToolbar4 == null) {
            commonToolbar4 = null;
        }
        commonToolbar4.setTitle("");
        View view2 = topicSearchTemplateActivity.topicDetailctbToolbarLine;
        if (view2 == null) {
            view2 = null;
        }
        view2.setVisibility(8);
        CommonToolbar commonToolbar5 = topicSearchTemplateActivity.topicDetailctbToolbar;
        if (commonToolbar5 != null) {
            commonToolbar = commonToolbar5;
        }
        commonToolbar.getIvLeftIcon().setColorFilter(topicSearchTemplateActivity.getResources().getColor(R.color.color_14181F));
    }

    private final void resetInitData() {
        setPageToTopOffset();
        CommunityAdapter communityAdapter = this.circleAdapter;
        if (communityAdapter != null) {
            communityAdapter.resetAll();
        }
        this.topicId = "";
        this.topicName = "";
        this.topicNameForSearch = "";
        this.markTime = null;
        this.startIndex = -1;
        this.topicDetailBean = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0054  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void resetPersonImageSize() {
        /*
            r6 = this;
            r0 = 2
            int[] r0 = new int[r0]
            com.huochat.community.widget.expandable.ExpandableTextView r1 = r6.tvIntroduction
            r2 = 0
            if (r1 != 0) goto L_0x0009
            r1 = r2
        L_0x0009:
            r1.getLocationOnScreen(r0)
            r1 = 1
            r3 = r0[r1]
            android.widget.ImageView r4 = r6.ivPerson
            if (r4 != 0) goto L_0x0014
            r4 = r2
        L_0x0014:
            r4.getLocationOnScreen(r0)
            r0 = r0[r1]
            com.huochat.community.widget.expandable.ExpandableTextView r1 = r6.tvIntroduction
            if (r1 != 0) goto L_0x001e
            r1 = r2
        L_0x001e:
            int r1 = r1.getHeight()
            android.widget.ImageView r4 = r6.ivPerson
            if (r4 != 0) goto L_0x0027
            r4 = r2
        L_0x0027:
            int r4 = r4.getHeight()
            int r3 = r3 + r1
            int r0 = r0 + r4
            android.widget.ImageView r1 = r6.ivPerson
            if (r1 != 0) goto L_0x0032
            r1 = r2
        L_0x0032:
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            r5 = 1106247680(0x41f00000, float:30.0)
            if (r3 >= r0) goto L_0x0042
            int r0 = r0 - r3
            int r4 = r4 - r0
            int r0 = com.huochat.community.util.DisplayTool.dp2px(r5)
        L_0x0040:
            int r4 = r4 + r0
            goto L_0x004d
        L_0x0042:
            if (r3 <= r0) goto L_0x004b
            int r3 = r3 - r0
            int r4 = r4 + r3
            int r0 = com.huochat.community.util.DisplayTool.dp2px(r5)
            goto L_0x0040
        L_0x004b:
            int r4 = r1.height
        L_0x004d:
            r1.height = r4
            android.widget.ImageView r0 = r6.ivPerson
            if (r0 != 0) goto L_0x0054
            goto L_0x0055
        L_0x0054:
            r2 = r0
        L_0x0055:
            r2.setLayoutParams(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huochat.community.activity.TopicSearchTemplateActivity.resetPersonImageSize():void");
    }

    private final void setPageToTopOffset() {
        AppBarLayout appBarLayout = this.topicDetailAppBar;
        if (appBarLayout == null) {
            appBarLayout = null;
        }
        CoordinatorLayout.Behavior f11 = ((CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams()).f();
        if (f11 instanceof AppBarLayout.Behavior) {
            AppBarLayout.Behavior behavior = (AppBarLayout.Behavior) f11;
            if (behavior.getTopAndBottomOffset() != 0) {
                behavior.setTopAndBottomOffset(0);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void shouLoading(boolean z11) {
        CommunityListSkeletonView communityListSkeletonView = null;
        if (z11) {
            CommunityListSkeletonView communityListSkeletonView2 = this.topicDetailSkeleton;
            if (communityListSkeletonView2 == null) {
                communityListSkeletonView2 = null;
            }
            communityListSkeletonView2.setVisibility(0);
            FrameLayout frameLayout = this.flEmptyContainer;
            if (frameLayout == null) {
                frameLayout = null;
            }
            frameLayout.setVisibility(0);
            View view = this.topicDetailEmpty;
            if (view == null) {
                view = null;
            }
            view.setVisibility(8);
            CommunityListSkeletonView communityListSkeletonView3 = this.topicDetailSkeleton;
            if (communityListSkeletonView3 == null) {
                communityListSkeletonView3 = null;
            }
            if (!communityListSkeletonView3.showing()) {
                CommunityListSkeletonView communityListSkeletonView4 = this.topicDetailSkeleton;
                if (communityListSkeletonView4 != null) {
                    communityListSkeletonView = communityListSkeletonView4;
                }
                communityListSkeletonView.showSkeleton();
                return;
            }
            return;
        }
        CommunityListSkeletonView communityListSkeletonView5 = this.topicDetailSkeleton;
        if (communityListSkeletonView5 != null) {
            communityListSkeletonView = communityListSkeletonView5;
        }
        communityListSkeletonView.setVisibility(8);
        i.b().g(new u(this), 240);
    }

    /* access modifiers changed from: private */
    public static final void shouLoading$lambda$6(TopicSearchTemplateActivity topicSearchTemplateActivity) {
        CommunityListSkeletonView communityListSkeletonView = topicSearchTemplateActivity.topicDetailSkeleton;
        if (communityListSkeletonView == null) {
            communityListSkeletonView = null;
        }
        communityListSkeletonView.dismissSkeleton();
    }

    public int getLayoutId() {
        return R.layout.community_topic_search_template;
    }

    public void initData(Bundle bundle) {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.topicId = extras.getString(CommunityConstants.TOPIC_ID);
            this.topicName = extras.getString(CommunityConstants.TOPIC_NAME);
        }
        String str = this.topicName;
        this.topicName = str != null ? StringsKt__StringsJVMKt.E(str, "\u0002", "", false) : null;
        this.topicNameForSearch = "#\u0002" + this.topicName + "\u0002#";
        getRealDiscussList();
    }

    public void initView(View view) {
        this.topicDetailctbToolbar = (CommonToolbar) findViewById(R.id.topicDetailctbToolbar);
        this.srlRefreshLayout = (SmartRefreshLayout) findViewById(R.id.srlRefreshLayout);
        this.tlPageToolbar = (Toolbar) findViewById(R.id.tlPageToolbar);
        this.topicDetailAppBar = (AppBarLayout) findViewById(R.id.topicDetailAppBar);
        this.tvIntroduction = (ExpandableTextView) findViewById(R.id.tvIntroduction);
        this.rvDiscussion = (RecyclerView) findViewById(R.id.rvDiscussion);
        this.ivPerson = (ImageView) findViewById(R.id.ivPerson);
        this.tvTopicName = (AutoSizeTextView) findViewById(R.id.tvTopicName);
        this.flEmptyContainer = (FrameLayout) findViewById(R.id.flEmptyContainer);
        this.topicDetailEmpty = findViewById(R.id.topicDetailEmpty);
        this.tv_empty_hint = (TextView) findViewById(R.id.tv_empty_hint);
        this.tv_retry = (TextView) findViewById(R.id.tv_retry);
        this.iv_empty_icon = (ImageView) findViewById(R.id.iv_empty_icon);
        this.topicDetailSkeleton = (CommunityListSkeletonView) findViewById(R.id.topicDetailSkeleton);
        this.topicDetailctbToolbarLine = findViewById(R.id.topicDetailctbToolbarLine);
        int i11 = R.id.llContractBtnPanel;
        this.llContractBtnPanel = (LinearLayout) findViewById(i11);
        this.tvContractHint = (TextView) findViewById(i11);
        this.tvContractIcon = (ImageView) findViewById(i11);
        CommonToolbar commonToolbar = this.topicDetailctbToolbar;
        RecyclerView recyclerView = null;
        if (commonToolbar == null) {
            commonToolbar = null;
        }
        commonToolbar.setLeftClick(new q(this));
        SmartRefreshLayout smartRefreshLayout = this.srlRefreshLayout;
        if (smartRefreshLayout == null) {
            smartRefreshLayout = null;
        }
        smartRefreshLayout.i(false);
        SmartRefreshLayout smartRefreshLayout2 = this.srlRefreshLayout;
        if (smartRefreshLayout2 == null) {
            smartRefreshLayout2 = null;
        }
        smartRefreshLayout2.g(true);
        Toolbar toolbar = this.tlPageToolbar;
        if (toolbar == null) {
            toolbar = null;
        }
        CommunityThemeHelper.Companion companion = CommunityThemeHelper.Companion;
        toolbar.setBackgroundColor(companion.getColor(this, R.attr.topicDetailCtlLayoutContentScrim));
        ComSmartRefreshFooter comSmartRefreshFooter = new ComSmartRefreshFooter(this);
        this.smartRefreshFooter = comSmartRefreshFooter;
        comSmartRefreshFooter.setFooterDividerColor(companion.getColor(this, R.attr.topicDetailSmartRefreshFooterDividerColor));
        this.smartRefreshFooter.setAccentColor(companion.getColor(this, R.attr.topicDetailSmartRefreshFooterAccentColor));
        SmartRefreshLayout smartRefreshLayout3 = this.srlRefreshLayout;
        if (smartRefreshLayout3 == null) {
            smartRefreshLayout3 = null;
        }
        smartRefreshLayout3.h0(this.smartRefreshFooter);
        SmartRefreshLayout smartRefreshLayout4 = this.srlRefreshLayout;
        if (smartRefreshLayout4 == null) {
            smartRefreshLayout4 = null;
        }
        smartRefreshLayout4.b0(new v(this));
        NBStatusBarUtils.translucent((Activity) this);
        NBStatusBarUtils.setStatusBarLightMode(this);
        CommonToolbar commonToolbar2 = this.topicDetailctbToolbar;
        if (commonToolbar2 == null) {
            commonToolbar2 = null;
        }
        commonToolbar2.setLeftClick(new p(this));
        AppBarLayout appBarLayout = this.topicDetailAppBar;
        if (appBarLayout == null) {
            appBarLayout = null;
        }
        appBarLayout.addOnOffsetChangedListener(this.mOnOffsetChangedListener);
        ExpandableTextView expandableTextView = this.tvIntroduction;
        if (expandableTextView == null) {
            expandableTextView = null;
        }
        expandableTextView.addOnLayoutChangeListener(this.mOnLayoutChangeListener);
        ExpandableTextView expandableTextView2 = this.tvIntroduction;
        if (expandableTextView2 == null) {
            expandableTextView2 = null;
        }
        expandableTextView2.setOnExpandableContractChangedListener(this.mContractChangedListener);
        ExpandableTextView expandableTextView3 = this.tvIntroduction;
        if (expandableTextView3 == null) {
            expandableTextView3 = null;
        }
        expandableTextView3.setOnClickListener(new n(this));
        this.circleAdapter = new CommunityAdapter(this, false);
        RecyclerView recyclerView2 = this.rvDiscussion;
        if (recyclerView2 == null) {
            recyclerView2 = null;
        }
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView recyclerView3 = this.rvDiscussion;
        if (recyclerView3 == null) {
            recyclerView3 = null;
        }
        recyclerView3.addItemDecoration(new TopicDetailRecyclerViewRadius());
        RecyclerView recyclerView4 = this.rvDiscussion;
        if (recyclerView4 != null) {
            recyclerView = recyclerView4;
        }
        recyclerView.setAdapter(this.circleAdapter);
    }

    public void onDestroy() {
        super.onDestroy();
        AppBarLayout appBarLayout = this.topicDetailAppBar;
        ExpandableTextView expandableTextView = null;
        if (appBarLayout == null) {
            appBarLayout = null;
        }
        appBarLayout.removeOnOffsetChangedListener(this.mOnOffsetChangedListener);
        ExpandableTextView expandableTextView2 = this.tvIntroduction;
        if (expandableTextView2 != null) {
            expandableTextView = expandableTextView2;
        }
        expandableTextView.removeOnLayoutChangeListener(this.mOnLayoutChangeListener);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        resetInitData();
        setIntent(intent);
        initView((View) null);
        initData((Bundle) null);
    }
}
