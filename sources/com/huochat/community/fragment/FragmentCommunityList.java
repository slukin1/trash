package com.huochat.community.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hbg.lib.common.network.NetworkStatus;
import com.huochat.community.CommunityManager;
import com.huochat.community.CommunityThemeColor;
import com.huochat.community.R;
import com.huochat.community.adapter.CommunityAdapter;
import com.huochat.community.base.BaseChildFragment;
import com.huochat.community.enums.CommunityMenuItems;
import com.huochat.community.enums.SymbolParamType;
import com.huochat.community.eventbus.EventCode;
import com.huochat.community.eventbus.EventMessage;
import com.huochat.community.listener.OnDisclaimerVisibleChangedListener;
import com.huochat.community.model.CommunityItemBean;
import com.huochat.community.model.CommunityMenuListItem;
import com.huochat.community.model.CommunityResultBean;
import com.huochat.community.util.NetTool;
import com.huochat.community.widget.refresh.ComSmartRefreshFooter;
import com.huochat.community.widget.skeleton.CommunityListSkeletonView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.List;
import k20.h;
import kotlin.i;
import kotlin.jvm.internal.r;
import ky.j;
import org.greenrobot.eventbus.ThreadMode;

@Route(path = "/hbc_community/fragmentcommunitylist")
public final class FragmentCommunityList extends BaseChildFragment {
    public static final String COMMUNITY_COMMENT_SWITCH = "communityCommentSwitch";
    public static final String COMMUNITY_SYMBOL = "community_symbol";
    public static final String COMMUNITY_SYMBOL_ID = "community_symbol_id";
    public static final Companion Companion = new Companion((r) null);
    public static final String SYMBOL_PARAM_TYPE = "symbolParamType";
    private static final String TAG = FragmentCommunityList.class.getSimpleName();
    private CommunityListSkeletonView clv_list_skeleton;
    /* access modifiers changed from: private */
    public CommunityAdapter communityAdapter;
    private String communitySymbol;
    private CommunityThemeColor communityThemeColor;
    private final i finishSkeletonRunnable$delegate = LazyKt__LazyJVMKt.a(new FragmentCommunityList$finishSkeletonRunnable$2(this));
    private FrameLayout fl_list_container;
    private boolean hasNextPageData = true;
    private Long mCircleLastPostTime = -1L;
    /* access modifiers changed from: private */
    public CommunityListMenuDialog mCommunityMenuDialog;
    /* access modifiers changed from: private */
    public CommunityMenuListItem mCommunityMenuPopwindowItem;
    private boolean mIsCommentListShow;
    /* access modifiers changed from: private */
    public boolean mIsListScrollToUp = true;
    private boolean mIsLoadDataing;
    /* access modifiers changed from: private */
    public int mListSortType = CommunityMenuItems.DEFAULT.getType();
    private final CommunityMenuListItem.Callback mMenuListItemCallback = new FragmentCommunityList$mMenuListItemCallback$1(this);
    private final FragmentCommunityList$mOnCommunitySortClickListener$1 mOnCommunitySortClickListener = new FragmentCommunityList$mOnCommunitySortClickListener$1(this);
    private final FragmentCommunityList$mOnHotTopicItemClickListener$1 mOnHotTopicItemClickListener = new FragmentCommunityList$mOnHotTopicItemClickListener$1(this);
    private List<CommunityMenuListItem> mSortMenuItemList;
    private int mStartIndex = -1;
    /* access modifiers changed from: private */
    public String mSymbolId;
    private NestedScrollView nsv_empty_container;
    /* access modifiers changed from: private */
    public OnDisclaimerVisibleChangedListener onDisclaimerVisibleChangedListener;
    private final FragmentCommunityList$onDynamicListScrollListener$1 onDynamicListScrollListener = new FragmentCommunityList$onDynamicListScrollListener$1(this);
    private RecyclerView rcvDynamicList;
    /* access modifiers changed from: private */
    public RequestCallback reRequestCallback;
    private ComSmartRefreshFooter smartRefreshFooter;
    private SmartRefreshLayout srlRefreshLayout;
    private SymbolParamType symbolParamType = SymbolParamType.SYMBOL;
    private View view_empty_container;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }
    }

    public interface RequestCallback {
        void complate();

        void pre();
    }

    /* access modifiers changed from: private */
    public final void finishSkeleton() {
        NestedScrollView nestedScrollView = this.nsv_empty_container;
        if (nestedScrollView != null) {
            nestedScrollView.setVisibility(8);
        }
        CommunityListSkeletonView communityListSkeletonView = this.clv_list_skeleton;
        if (communityListSkeletonView != null) {
            communityListSkeletonView.dismissSkeleton();
        }
    }

    private final Runnable getFinishSkeletonRunnable() {
        return (Runnable) this.finishSkeletonRunnable$delegate.getValue();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static final void handleEmpty$lambda$6$lambda$5(FragmentCommunityList fragmentCommunityList, View view) {
        fragmentCommunityList.hasNextPageData = true;
        CommunityListSkeletonView communityListSkeletonView = fragmentCommunityList.clv_list_skeleton;
        if (communityListSkeletonView != null) {
            communityListSkeletonView.setHasLoadData(false);
        }
        fragmentCommunityList.refreshData(true, (RequestCallback) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public final boolean hasCommunityListData() {
        CommunityAdapter communityAdapter2 = this.communityAdapter;
        if ((communityAdapter2 != null ? communityAdapter2.hasListData() : false) || !this.mIsLoadDataing) {
            return true;
        }
        return false;
    }

    private final void initSortMenuDialog() {
        ArrayList arrayList = new ArrayList();
        this.mSortMenuItemList = arrayList;
        arrayList.add(new CommunityMenuListItem(CommunityMenuItems.DEFAULT.getType(), getString(R.string.community_sort_menu_normal), this.mMenuListItemCallback));
        this.mSortMenuItemList.add(new CommunityMenuListItem(CommunityMenuItems.LAST_TIME.getType(), getString(R.string.community_sort_menu_time), this.mMenuListItemCallback));
        CommunityListMenuDialog communityListMenuDialog = new CommunityListMenuDialog();
        this.mCommunityMenuDialog = communityListMenuDialog;
        communityListMenuDialog.setData(this.mSortMenuItemList);
        this.mCommunityMenuDialog.setFollowViewWidth(true);
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$2$lambda$1(FragmentCommunityList fragmentCommunityList, j jVar) {
        SmartRefreshLayout smartRefreshLayout = fragmentCommunityList.srlRefreshLayout;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.b(10000);
        }
        CommunityAdapter communityAdapter2 = fragmentCommunityList.communityAdapter;
        if (communityAdapter2 != null) {
            communityAdapter2.removeFullExpandableTextViewLongClickEvent();
        }
        fragmentCommunityList.loadMoreData();
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$3(FragmentCommunityList fragmentCommunityList) {
        fragmentCommunityList.showSkeleton();
    }

    /* access modifiers changed from: private */
    public final void showSkeleton() {
        CommunityListSkeletonView communityListSkeletonView = this.clv_list_skeleton;
        if (communityListSkeletonView != null && !communityListSkeletonView.showing()) {
            NestedScrollView nestedScrollView = this.nsv_empty_container;
            if (nestedScrollView != null) {
                nestedScrollView.setVisibility(0);
            }
            View view = this.view_empty_container;
            if (view != null) {
                view.setVisibility(8);
            }
            communityListSkeletonView.showSkeleton();
            i6.i.b().g(getFinishSkeletonRunnable(), 8000);
        }
    }

    public final void finishRefreshOrLoadMore(boolean z11, int i11) {
        finishSkeleton();
        SmartRefreshLayout smartRefreshLayout = this.srlRefreshLayout;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.finishRefresh();
        }
        SmartRefreshLayout smartRefreshLayout2 = this.srlRefreshLayout;
        if (smartRefreshLayout2 != null) {
            smartRefreshLayout2.b(i11);
        }
        handleEmpty(z11);
    }

    public final CommunityListSkeletonView getClv_list_skeleton() {
        return this.clv_list_skeleton;
    }

    public final FrameLayout getFl_list_container() {
        return this.fl_list_container;
    }

    public int getLayoutId() {
        return R.layout.fragment_community_list;
    }

    public final NestedScrollView getNsv_empty_container() {
        return this.nsv_empty_container;
    }

    public final RecyclerView getRcvDynamicList() {
        return this.rcvDynamicList;
    }

    public final SmartRefreshLayout getSrlRefreshLayout() {
        return this.srlRefreshLayout;
    }

    public final View getView_empty_container() {
        return this.view_empty_container;
    }

    public final void handleEmpty(boolean z11) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        CommunityAdapter communityAdapter2 = this.communityAdapter;
        boolean z12 = false;
        boolean hasListData = communityAdapter2 != null ? communityAdapter2.hasListData() : false;
        CommunityAdapter communityAdapter3 = this.communityAdapter;
        boolean hasTopicListData = communityAdapter3 != null ? communityAdapter3.hasTopicListData() : false;
        boolean z13 = true;
        CommunityThemeColor communityThemeColor2 = null;
        if (!NetTool.isNetworkAvailable() || !NetworkStatus.c(getContext()) || !z11) {
            View view = this.view_empty_container;
            if (view != null) {
                ImageView imageView = (ImageView) view.findViewById(R.id.iv_empty_icon);
                if (imageView != null) {
                    CommunityThemeColor communityThemeColor3 = this.communityThemeColor;
                    if (communityThemeColor3 == null) {
                        communityThemeColor3 = null;
                    }
                    imageView.setImageResource(communityThemeColor3.getErrorDefIconNoNetworkResId());
                }
                TextView textView = (TextView) view.findViewById(R.id.tv_empty_hint);
                TextView textView2 = (TextView) view.findViewById(R.id.tv_retry);
                textView.setText(getResources().getString(R.string.common_no_internet_access));
                textView2.setVisibility(0);
                textView2.setOnClickListener(new a(this));
                int i11 = R.color.color_0066ED;
                int i12 = R.drawable.shape_common_middle_btn_light;
                if (CommunityManager.Companion.getInstance().isNightModel()) {
                    i11 = R.color.color_2483FF;
                    i12 = R.drawable.shape_common_middle_btn_night;
                }
                if (getContext() != null) {
                    textView2.setTextColor(getContext().getResources().getColor(i11));
                    textView2.setBackgroundResource(i12);
                }
                CommunityThemeColor communityThemeColor4 = this.communityThemeColor;
                if (communityThemeColor4 != null) {
                    communityThemeColor2 = communityThemeColor4;
                }
                textView.setTextColor(communityThemeColor2.getErrorDefTipsMomentEmptyTextColor());
                NestedScrollView nestedScrollView = this.nsv_empty_container;
                if (nestedScrollView != null) {
                    nestedScrollView.setVisibility(0);
                }
                view.setVisibility(0);
                RecyclerView recyclerView4 = this.rcvDynamicList;
                if (recyclerView4 != null && recyclerView4.getVisibility() == 0) {
                    z12 = true;
                }
                if (z12 && (recyclerView = this.rcvDynamicList) != null) {
                    recyclerView.setVisibility(8);
                }
            }
        } else if (hasListData || hasTopicListData) {
            RecyclerView recyclerView5 = this.rcvDynamicList;
            if (recyclerView5 == null || recyclerView5.getVisibility() != 0) {
                z13 = false;
            }
            if (!z13 && (recyclerView2 = this.rcvDynamicList) != null) {
                recyclerView2.setVisibility(0);
            }
            NestedScrollView nestedScrollView2 = this.nsv_empty_container;
            if (nestedScrollView2 != null) {
                nestedScrollView2.setVisibility(8);
            }
            View view2 = this.view_empty_container;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        } else {
            View view3 = this.view_empty_container;
            if (view3 != null) {
                ImageView imageView2 = (ImageView) view3.findViewById(R.id.iv_empty_icon);
                if (imageView2 != null) {
                    CommunityThemeColor communityThemeColor5 = this.communityThemeColor;
                    if (communityThemeColor5 == null) {
                        communityThemeColor5 = null;
                    }
                    imageView2.setImageResource(communityThemeColor5.getErrorDefIconMomentEmpty());
                }
                TextView textView3 = (TextView) view3.findViewById(R.id.tv_empty_hint);
                textView3.setText(getResources().getString(R.string.community_empty_no_content_hint));
                ((TextView) view3.findViewById(R.id.tv_retry)).setVisibility(8);
                CommunityThemeColor communityThemeColor6 = this.communityThemeColor;
                if (communityThemeColor6 != null) {
                    communityThemeColor2 = communityThemeColor6;
                }
                textView3.setTextColor(communityThemeColor2.getErrorDefTipsMomentEmptyTextColor());
                NestedScrollView nestedScrollView3 = this.nsv_empty_container;
                if (nestedScrollView3 != null) {
                    nestedScrollView3.setVisibility(0);
                }
                view3.setVisibility(0);
                RecyclerView recyclerView6 = this.rcvDynamicList;
                if (recyclerView6 != null && recyclerView6.getVisibility() == 0) {
                    z12 = true;
                }
                if (z12 && (recyclerView3 = this.rcvDynamicList) != null) {
                    recyclerView3.setVisibility(8);
                }
            }
        }
    }

    public void initData(Bundle bundle) {
        loadData(true);
    }

    public void initView(View view) {
        this.communityThemeColor = CommunityManager.Companion.getInstance().getCommunityThemeColor();
        Bundle arguments = getArguments();
        CommunityThemeColor communityThemeColor2 = null;
        this.communitySymbol = arguments != null ? arguments.getString(COMMUNITY_SYMBOL) : null;
        this.mSymbolId = arguments != null ? arguments.getString(COMMUNITY_SYMBOL_ID) : null;
        this.symbolParamType = SymbolParamType.Companion.getType(arguments != null ? arguments.getInt(SYMBOL_PARAM_TYPE) : 0);
        this.mIsCommentListShow = arguments != null ? arguments.getBoolean(COMMUNITY_COMMENT_SWITCH, false) : false;
        this.fl_list_container = view != null ? (FrameLayout) view.findViewById(R.id.fl_list_container) : null;
        this.nsv_empty_container = view != null ? (NestedScrollView) view.findViewById(R.id.nsv_empty_container) : null;
        this.rcvDynamicList = view != null ? (RecyclerView) view.findViewById(R.id.rcvDynamicList) : null;
        this.srlRefreshLayout = view != null ? (SmartRefreshLayout) view.findViewById(R.id.srlRefreshLayout) : null;
        this.clv_list_skeleton = view != null ? (CommunityListSkeletonView) view.findViewById(R.id.clv_list_skeleton) : null;
        this.view_empty_container = view != null ? view.findViewById(R.id.view_empty_container) : null;
        FrameLayout frameLayout = this.fl_list_container;
        if (frameLayout != null) {
            CommunityThemeColor communityThemeColor3 = this.communityThemeColor;
            if (communityThemeColor3 == null) {
                communityThemeColor3 = null;
            }
            frameLayout.setBackgroundColor(communityThemeColor3.getRootBgDrawable());
        }
        NestedScrollView nestedScrollView = this.nsv_empty_container;
        if (nestedScrollView != null) {
            CommunityThemeColor communityThemeColor4 = this.communityThemeColor;
            if (communityThemeColor4 == null) {
                communityThemeColor4 = null;
            }
            nestedScrollView.setBackgroundColor(communityThemeColor4.getRootBgDrawable());
        }
        RecyclerView recyclerView = this.rcvDynamicList;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        CommunityAdapter communityAdapter2 = new CommunityAdapter(getActivity(), true, false);
        this.communityAdapter = communityAdapter2;
        communityAdapter2.setSymbolParams(this.communitySymbol, this.symbolParamType);
        CommunityAdapter communityAdapter3 = this.communityAdapter;
        if (communityAdapter3 != null) {
            communityAdapter3.setSymbolId(this.mSymbolId);
        }
        RecyclerView recyclerView2 = this.rcvDynamicList;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.communityAdapter);
        }
        RecyclerView recyclerView3 = this.rcvDynamicList;
        if (recyclerView3 != null) {
            recyclerView3.addOnScrollListener(this.onDynamicListScrollListener);
        }
        this.communityAdapter.setOnCommunitySortClickListener(this.mOnCommunitySortClickListener);
        this.communityAdapter.setOnHotTopicItemClickListener(this.mOnHotTopicItemClickListener);
        SmartRefreshLayout smartRefreshLayout = this.srlRefreshLayout;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.i(false);
        }
        SmartRefreshLayout smartRefreshLayout2 = this.srlRefreshLayout;
        if (smartRefreshLayout2 != null) {
            smartRefreshLayout2.g(true);
        }
        ComSmartRefreshFooter comSmartRefreshFooter = new ComSmartRefreshFooter(getContext());
        this.smartRefreshFooter = comSmartRefreshFooter;
        CommunityThemeColor communityThemeColor5 = this.communityThemeColor;
        if (communityThemeColor5 == null) {
            communityThemeColor5 = null;
        }
        comSmartRefreshFooter.setFooterDividerColor(communityThemeColor5.getListDividingLineColor());
        ComSmartRefreshFooter comSmartRefreshFooter2 = this.smartRefreshFooter;
        CommunityThemeColor communityThemeColor6 = this.communityThemeColor;
        if (communityThemeColor6 != null) {
            communityThemeColor2 = communityThemeColor6;
        }
        comSmartRefreshFooter2.setAccentColor(communityThemeColor2.getCommunityMomentListNoMoreDataTipsTextColor());
        SmartRefreshLayout smartRefreshLayout3 = this.srlRefreshLayout;
        if (smartRefreshLayout3 != null) {
            smartRefreshLayout3.h0(this.smartRefreshFooter);
            smartRefreshLayout3.b0(new c(this));
        }
        CommunityListSkeletonView communityListSkeletonView = this.clv_list_skeleton;
        if (communityListSkeletonView != null) {
            communityListSkeletonView.postDelayed(new b(this), 50);
        }
        initSortMenuDialog();
    }

    public boolean isRegisteredEventBus() {
        return true;
    }

    public final void loadData(boolean z11) {
        this.mStartIndex = -1;
        this.mCircleLastPostTime = -1L;
        this.hasNextPageData = true;
        CommunityListSkeletonView communityListSkeletonView = this.clv_list_skeleton;
        if (communityListSkeletonView != null) {
            communityListSkeletonView.setHasLoadData(false);
        }
        loadData(this.mStartIndex, this.mCircleLastPostTime, z11);
    }

    public final void loadMoreData() {
        long j11;
        CommunityAdapter communityAdapter2 = this.communityAdapter;
        if (communityAdapter2 == null || (j11 = communityAdapter2.getLastPostTime()) == null) {
            j11 = -1L;
        }
        this.mCircleLastPostTime = j11;
        loadData(this.mStartIndex, j11, false);
    }

    public void onDestroy() {
        i6.i.b().h(getFinishSkeletonRunnable());
        super.onDestroy();
    }

    @h(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EventMessage<Object> eventMessage) {
        CommunityAdapter communityAdapter2;
        int eventCode = eventMessage.getEventCode();
        if (eventCode == EventCode.REFRESH_COMMUNITY_LIST) {
            refreshData();
        } else if (eventCode == EventCode.SWITCH_THEME && (communityAdapter2 = this.communityAdapter) != null) {
            communityAdapter2.notifyThemeChanged();
        }
    }

    public final void refreshData() {
        refreshData(false, (RequestCallback) null);
    }

    public final void setClv_list_skeleton(CommunityListSkeletonView communityListSkeletonView) {
        this.clv_list_skeleton = communityListSkeletonView;
    }

    public final void setFl_list_container(FrameLayout frameLayout) {
        this.fl_list_container = frameLayout;
    }

    public final void setNsv_empty_container(NestedScrollView nestedScrollView) {
        this.nsv_empty_container = nestedScrollView;
    }

    public final void setOnDisclaimerVisibleChangedListener(OnDisclaimerVisibleChangedListener onDisclaimerVisibleChangedListener2) {
        this.onDisclaimerVisibleChangedListener = onDisclaimerVisibleChangedListener2;
    }

    public final void setRcvDynamicList(RecyclerView recyclerView) {
        this.rcvDynamicList = recyclerView;
    }

    public final void setSrlRefreshLayout(SmartRefreshLayout smartRefreshLayout) {
        this.srlRefreshLayout = smartRefreshLayout;
    }

    public final void setView_empty_container(View view) {
        this.view_empty_container = view;
    }

    public final void updateOrRefreshUI(CommunityResultBean communityResultBean) {
        RecyclerView recyclerView;
        CommunityListSkeletonView communityListSkeletonView;
        if (communityResultBean != null) {
            List<CommunityItemBean> list = communityResultBean.getList();
            boolean z11 = communityResultBean.getNextIndex() != -1;
            boolean z12 = -1 == this.mStartIndex;
            CommunityAdapter communityAdapter2 = this.communityAdapter;
            if (communityAdapter2 != null) {
                if (z12) {
                    communityAdapter2.notifyComunityBaseInfo(communityResultBean);
                    communityAdapter2.refreshTopHotTopicList(communityResultBean.getTopicList());
                    SmartRefreshLayout smartRefreshLayout = this.srlRefreshLayout;
                    if (smartRefreshLayout != null) {
                        smartRefreshLayout.g(!(list == null || list.isEmpty()));
                    }
                }
                communityAdapter2.addDatas(list, z12, z11);
                long lastPostTime = communityAdapter2.getLastPostTime();
                if (lastPostTime == null) {
                    lastPostTime = -1L;
                }
                this.mCircleLastPostTime = lastPostTime;
            }
            if (!(list == null || list.isEmpty()) && (communityListSkeletonView = this.clv_list_skeleton) != null) {
                communityListSkeletonView.setHasLoadData(true);
            }
            this.mStartIndex = communityResultBean.getNextIndex();
            this.hasNextPageData = z11;
            ComSmartRefreshFooter comSmartRefreshFooter = this.smartRefreshFooter;
            if (comSmartRefreshFooter != null) {
                comSmartRefreshFooter.setNoMoreData(!z11);
            }
            if (z12 && (recyclerView = this.rcvDynamicList) != null) {
                recyclerView.scrollToPosition(0);
            }
        }
    }

    public final void refreshData(boolean z11, RequestCallback requestCallback) {
        this.reRequestCallback = requestCallback;
        loadData(z11);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003f, code lost:
        r8 = r8.getResources();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void loadData(int r8, java.lang.Long r9, boolean r10) {
        /*
            r7 = this;
            r0 = 1
            r7.mIsLoadDataing = r0
            boolean r1 = com.huochat.community.util.NetTool.isNetworkAvailable()
            if (r1 == 0) goto L_0x0039
            android.content.Context r1 = r7.getContext()
            boolean r1 = com.hbg.lib.common.network.NetworkStatus.c(r1)
            if (r1 != 0) goto L_0x0014
            goto L_0x0039
        L_0x0014:
            boolean r1 = r7.hasNextPageData
            if (r1 != 0) goto L_0x001e
            r8 = 500(0x1f4, float:7.0E-43)
            r7.finishRefreshOrLoadMore(r0, r8)
            return
        L_0x001e:
            com.huochat.community.network.CommunityApiManager$Companion r0 = com.huochat.community.network.CommunityApiManager.Companion
            com.huochat.community.network.CommunityApiManager r1 = r0.getInstance()
            java.lang.String r2 = r7.communitySymbol
            com.huochat.community.enums.SymbolParamType r3 = r7.symbolParamType
            int r6 = r7.mListSortType
            r4 = r8
            r5 = r9
            d9.a r8 = r1.getCommunityListbySymbol(r2, r3, r4, r5, r6)
            com.huochat.community.fragment.FragmentCommunityList$loadData$1 r9 = new com.huochat.community.fragment.FragmentCommunityList$loadData$1
            r9.<init>(r10, r7)
            r8.d(r9)
            return
        L_0x0039:
            android.content.Context r8 = r7.getContext()
            if (r8 == 0) goto L_0x004c
            android.content.res.Resources r8 = r8.getResources()
            if (r8 == 0) goto L_0x004c
            int r9 = com.huochat.community.R.string.server_error
            java.lang.String r8 = r8.getString(r9)
            goto L_0x004d
        L_0x004c:
            r8 = 0
        L_0x004d:
            com.hbg.lib.widgets.utils.HuobiToastUtil.m(r8)
            com.huochat.community.fragment.FragmentCommunityList$RequestCallback r8 = r7.reRequestCallback
            if (r8 == 0) goto L_0x0057
            r8.complate()
        L_0x0057:
            r8 = 0
            r7.finishRefreshOrLoadMore(r8, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huochat.community.fragment.FragmentCommunityList.loadData(int, java.lang.Long, boolean):void");
    }
}
