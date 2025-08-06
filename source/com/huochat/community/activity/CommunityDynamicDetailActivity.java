package com.huochat.community.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import cn.sharesdk.framework.InnerShareParams;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.android.material.appbar.AppBarLayout;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.widgets.MyNestedScrollView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huochat.community.CommunityManager;
import com.huochat.community.CommunityModuleCallback;
import com.huochat.community.CommunityModuleConfig;
import com.huochat.community.CommunityThemeColor;
import com.huochat.community.CommunityThemeHelper;
import com.huochat.community.R;
import com.huochat.community.base.BaseActivity;
import com.huochat.community.base.CommunityConstants;
import com.huochat.community.base.CommunitySensorsEvent;
import com.huochat.community.enums.SymbolParamType;
import com.huochat.community.listener.ICommunityShareUI;
import com.huochat.community.model.CommentItemBean;
import com.huochat.community.model.CommunityItemBean;
import com.huochat.community.model.MomentType;
import com.huochat.community.network.CommunityApiManager;
import com.huochat.community.util.ClickTool;
import com.huochat.community.util.CommunityDialogUtil;
import com.huochat.community.util.DataPosterTool;
import com.huochat.community.util.KeyboardListener;
import com.huochat.community.util.NBStatusBarUtils;
import com.huochat.community.util.NetTool;
import com.huochat.community.util.ScreemTool;
import com.huochat.community.viewholder.CommunityHolder;
import com.huochat.community.widget.CommonToolbar;
import com.huochat.community.widget.expandable.ExpandableTextView;
import com.huochat.community.widget.momentdetail.MomentCommentListView;
import com.huochat.community.widget.shareview.CommunityDynamicShareView;
import com.huochat.community.widget.skeleton.CommunityDetailSkeletonView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;
import org.json.JSONObject;
import pv.a;
import pv.b;
import pv.c;
import pv.d;
import pv.e;
import pv.f;
import pv.g;
import pv.h;
import pv.i;
import pv.j;
import pv.k;
import pv.l;

@Route(path = "/hbc_community/CommunityDynamicDetailActivity")
public final class CommunityDynamicDetailActivity extends BaseActivity implements ICommunityShareUI {
    private final int PAGE_COMMENT;
    private AppBarLayout appBarLayout;
    private CommunityDetailSkeletonView cdsvDetailSkeleton;
    /* access modifiers changed from: private */
    public Dialog commentDialog;
    private ColorTransitionPagerTitleView commentTitleTextView;
    private String communitySymbol = "";
    private CommunityThemeColor communityThemeColor = CommunityManager.Companion.getInstance().getCommunityThemeColor();
    private CoordinatorLayout coordinatorLayout;
    private CommonToolbar ctbToolBar;
    private View detailEmptyContainer;
    private FrameLayout ffMomentTypeContainer;
    private final Runnable finishSkeletonRunnable = new CommunityDynamicDetailActivity$finishSkeletonRunnable$1(this);
    private FrameLayout flErrorContainer;
    private boolean isDetailHasData;
    private View llCommunityBaseInfoContainer;
    private View llEditOpratePanel;
    private LinearLayout llRootView;
    private LinearLayout llTopFloatContainer;
    private LinearLayout ll_edit_oprate_panel;
    /* access modifiers changed from: private */
    public CommunityItemBean mCommunityItemBean;
    private int mCurrentOpratePage = this.PAGE_COMMENT;
    private CommunityHolder mHolder;
    private final BaseDialogFragment mImageShareFragment;
    private boolean mIsAutoOpenCommentDialog;
    private LayoutInflater mLayoutInflater;
    private MagicIndicator magicIndicatator;
    private MomentCommentListView mclv_comment_list_view;
    private String mid = "";
    private float moveDistanceX;
    private float moveDistanceY;
    private MyNestedScrollView msv_moment_detail_scrollview;
    private final CommunityDynamicDetailActivity$onCommentClickListener$1 onCommentClickListener = new CommunityDynamicDetailActivity$onCommentClickListener$1();
    private String sensorSymbol;
    private SymbolParamType symbolParamType = SymbolParamType.SYMBOL;
    private TextView tvDisclaimer;
    private TextView tvMomentDetailCommentInput;
    private View vDividerContent;
    private View vMagicLine;
    private View vMomentDtailTopLine;
    private final List<View> vpItemPageViewList = new ArrayList();
    /* access modifiers changed from: private */
    public final List<ColorTransitionPagerTitleView> vpTitleViewList = new ArrayList();

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(45:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|45) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0050 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0082 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x008c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0096 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00a0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00aa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00be */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00c8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.huochat.community.model.MomentType[] r0 = com.huochat.community.model.MomentType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.huochat.community.model.MomentType r1 = com.huochat.community.model.MomentType.MOMENT_OUT_SHARE_IMAGE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.huochat.community.model.MomentType r1 = com.huochat.community.model.MomentType.MOMENT_OUT_SHARE_LINK     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.huochat.community.model.MomentType r1 = com.huochat.community.model.MomentType.MOMENT_IMAGE_0     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.huochat.community.model.MomentType r1 = com.huochat.community.model.MomentType.MOMENT_TEXT     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.huochat.community.model.MomentType r1 = com.huochat.community.model.MomentType.MOMENT_FLASH     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.huochat.community.model.MomentType r1 = com.huochat.community.model.MomentType.MOMENT_IMAGE_1     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                com.huochat.community.model.MomentType r1 = com.huochat.community.model.MomentType.MOMENT_IMAGE_2     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                com.huochat.community.model.MomentType r1 = com.huochat.community.model.MomentType.MOMENT_IMAGE_3     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                com.huochat.community.model.MomentType r1 = com.huochat.community.model.MomentType.MOMENT_IMAGE_4     // Catch:{ NoSuchFieldError -> 0x005a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                com.huochat.community.model.MomentType r1 = com.huochat.community.model.MomentType.MOMENT_IMAGE_5     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                com.huochat.community.model.MomentType r1 = com.huochat.community.model.MomentType.MOMENT_IMAGE_6     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                com.huochat.community.model.MomentType r1 = com.huochat.community.model.MomentType.MOMENT_IMAGE_7     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                com.huochat.community.model.MomentType r1 = com.huochat.community.model.MomentType.MOMENT_IMAGE_8     // Catch:{ NoSuchFieldError -> 0x0082 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0082 }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0082 }
            L_0x0082:
                com.huochat.community.model.MomentType r1 = com.huochat.community.model.MomentType.MOMENT_IMAGE_9     // Catch:{ NoSuchFieldError -> 0x008c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008c }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x008c }
            L_0x008c:
                com.huochat.community.model.MomentType r1 = com.huochat.community.model.MomentType.MOMENT_VEDIO     // Catch:{ NoSuchFieldError -> 0x0096 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0096 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0096 }
            L_0x0096:
                com.huochat.community.model.MomentType r1 = com.huochat.community.model.MomentType.MOMENT_NEWS     // Catch:{ NoSuchFieldError -> 0x00a0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a0 }
            L_0x00a0:
                com.huochat.community.model.MomentType r1 = com.huochat.community.model.MomentType.MOMENT_SCHOOL     // Catch:{ NoSuchFieldError -> 0x00aa }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00aa }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00aa }
            L_0x00aa:
                com.huochat.community.model.MomentType r1 = com.huochat.community.model.MomentType.MOMENT_CLUB     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                com.huochat.community.model.MomentType r1 = com.huochat.community.model.MomentType.MOMENT_EXCHANGE     // Catch:{ NoSuchFieldError -> 0x00be }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00be }
                r2 = 19
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00be }
            L_0x00be:
                com.huochat.community.model.MomentType r1 = com.huochat.community.model.MomentType.MOMENT_PROJECT     // Catch:{ NoSuchFieldError -> 0x00c8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c8 }
                r2 = 20
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c8 }
            L_0x00c8:
                com.huochat.community.model.MomentType r1 = com.huochat.community.model.MomentType.MOMENT_CONTENT_LINK     // Catch:{ NoSuchFieldError -> 0x00d2 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d2 }
                r2 = 21
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d2 }
            L_0x00d2:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huochat.community.activity.CommunityDynamicDetailActivity.WhenMappings.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public final void finishSkeleton() {
        CommunityDetailSkeletonView communityDetailSkeletonView = this.cdsvDetailSkeleton;
        CommunityDetailSkeletonView communityDetailSkeletonView2 = null;
        if (communityDetailSkeletonView == null) {
            communityDetailSkeletonView = null;
        }
        communityDetailSkeletonView.setHasLoadData(this.isDetailHasData);
        CommunityDetailSkeletonView communityDetailSkeletonView3 = this.cdsvDetailSkeleton;
        if (communityDetailSkeletonView3 != null) {
            communityDetailSkeletonView2 = communityDetailSkeletonView3;
        }
        communityDetailSkeletonView2.dismissSkeleton();
    }

    private final void getMomentDetailInfo(String str) {
        if (!NetTool.isNetworkAvailable() || !NetworkStatus.c(this)) {
            HuobiToastUtil.m(getResources().getString(R.string.server_error));
            this.isDetailHasData = false;
            handleEmpty(false);
            return;
        }
        CommunityApiManager.Companion.getInstance().getCommunityDynamicDetail(this.communitySymbol, this.symbolParamType, str).d(new CommunityDynamicDetailActivity$getMomentDetailInfo$1(this));
    }

    private final ColorTransitionPagerTitleView getPageTitleView(String str, View.OnClickListener onClickListener) {
        ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(this);
        colorTransitionPagerTitleView.setText(str);
        colorTransitionPagerTitleView.setTextSize(16.0f);
        colorTransitionPagerTitleView.setHeight(UIUtil.a(this, 45.0d));
        colorTransitionPagerTitleView.setPadding(UIUtil.a(this, 15.0d), UIUtil.a(this, 5.0d), UIUtil.a(this, 15.0d), UIUtil.a(this, 5.0d));
        colorTransitionPagerTitleView.setNormalColor(this.communityThemeColor.getCommunityMomentMoreListTitleColorNormal());
        colorTransitionPagerTitleView.setSelectedColor(this.communityThemeColor.getCommunityMomentMoreListTitleColorSelected());
        colorTransitionPagerTitleView.setOnClickListener(onClickListener);
        return colorTransitionPagerTitleView;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static final void handleEmpty$lambda$9(CommunityDynamicDetailActivity communityDynamicDetailActivity, View view) {
        communityDynamicDetailActivity.isDetailHasData = false;
        communityDynamicDetailActivity.getMomentDetailInfo(communityDynamicDetailActivity.mid);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static final void initData$lambda$8(CommunityDynamicDetailActivity communityDynamicDetailActivity, View view) {
        communityDynamicDetailActivity.finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private final void initDisclaimerHint() {
        TextView textView = this.tvDisclaimer;
        TextView textView2 = null;
        if (textView == null) {
            textView = null;
        }
        CommunityThemeHelper.Companion companion = CommunityThemeHelper.Companion;
        textView.setBackgroundColor(companion.getColor(this, R.attr.communityDetailDisclaimerBgColor));
        TextView textView3 = this.tvDisclaimer;
        if (textView3 == null) {
            textView3 = null;
        }
        textView3.setTextColor(companion.getColor(this, R.attr.communityDetailDisclaimerTextColor));
        String string = getResources().getString(R.string.community_disclaimer_hint);
        String string2 = getResources().getString(R.string.community_disclaimer);
        SpannableString spannableString = new SpannableString(string + string2 + ' ');
        int length = spannableString.length();
        spannableString.setSpan(new CommunityDynamicDetailActivity$initDisclaimerHint$1(this), (length - string2.length()) + -1, length + -1, 33);
        TextView textView4 = this.tvDisclaimer;
        if (textView4 == null) {
            textView4 = null;
        }
        textView4.setText(spannableString);
        TextView textView5 = this.tvDisclaimer;
        if (textView5 == null) {
            textView5 = null;
        }
        textView5.setMovementMethod(LinkMovementMethod.getInstance());
        TextView textView6 = this.tvDisclaimer;
        if (textView6 != null) {
            textView2 = textView6;
        }
        textView2.setHighlightColor(0);
    }

    private final void initInflater() {
        this.mLayoutInflater = LayoutInflater.from(this).cloneInContext(CommunityThemeHelper.Companion.getThemeContext(this));
    }

    private final void initMagicIndicator() {
        this.vpTitleViewList.clear();
        ColorTransitionPagerTitleView pageTitleView = getPageTitleView("评论", new h(this));
        this.commentTitleTextView = pageTitleView;
        this.vpTitleViewList.add(pageTitleView);
        CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setAdjustMode(false);
        commonNavigator.setScrollPivotX(0.8f);
        commonNavigator.setAdapter(new CommunityDynamicDetailActivity$initMagicIndicator$2(this));
        MagicIndicator magicIndicator = this.magicIndicatator;
        MagicIndicator magicIndicator2 = null;
        if (magicIndicator == null) {
            magicIndicator = null;
        }
        magicIndicator.setNavigator(commonNavigator);
        MagicIndicator magicIndicator3 = this.magicIndicatator;
        if (magicIndicator3 == null) {
            magicIndicator3 = null;
        }
        magicIndicator3.c(0);
        MagicIndicator magicIndicator4 = this.magicIndicatator;
        if (magicIndicator4 != null) {
            magicIndicator2 = magicIndicator4;
        }
        magicIndicator2.b(0, 0.0f, 0);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static final void initMagicIndicator$lambda$10(CommunityDynamicDetailActivity communityDynamicDetailActivity, View view) {
        communityDynamicDetailActivity.mCurrentOpratePage = communityDynamicDetailActivity.PAGE_COMMENT;
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private final void initMomentHolderData(CommunityHolder communityHolder, CommunityItemBean communityItemBean) {
        ExpandableTextView expandTextViewMomentText;
        View view;
        if (communityItemBean != null) {
            if (communityHolder != null) {
                communityHolder.bindData(communityItemBean, this, this.communitySymbol);
            }
            if (communityHolder != null) {
                communityHolder.setOnCommentClick(this.onCommentClickListener);
            }
            if (!(communityHolder == null || (view = communityHolder.itemView) == null)) {
                view.setOnClickListener((View.OnClickListener) null);
            }
            if (!(communityHolder == null || (expandTextViewMomentText = communityHolder.getExpandTextViewMomentText()) == null)) {
                expandTextViewMomentText.showFull();
            }
            if (communityHolder != null) {
                communityHolder.refreshOperaterStateData(communityItemBean);
            }
            View findViewById = findViewById(R.id.v_menu_share_click);
            if (findViewById != null) {
                findViewById.setOnClickListener(new i(this));
            }
            View findViewById2 = findViewById(R.id.v_menu_like_click);
            if (findViewById2 != null) {
                findViewById2.setOnClickListener(new a(this));
            }
            View findViewById3 = findViewById(R.id.v_menu_comment_click);
            if (findViewById3 != null) {
                findViewById3.setOnClickListener(new d(this));
            }
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static final void initMomentHolderData$lambda$13(CommunityDynamicDetailActivity communityDynamicDetailActivity, View view) {
        if (!ClickTool.isRealClick()) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        communityDynamicDetailActivity.showOpenHuoChatDialog("share");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static final void initMomentHolderData$lambda$14(CommunityDynamicDetailActivity communityDynamicDetailActivity, View view) {
        if (!ClickTool.isRealClick()) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        communityDynamicDetailActivity.showOpenHuoChatDialog("thumbs-up");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static final void initMomentHolderData$lambda$15(CommunityDynamicDetailActivity communityDynamicDetailActivity, View view) {
        if (!ClickTool.isRealClick()) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        communityDynamicDetailActivity.showOpenHuoChatDialog(InnerShareParams.COMMENT);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private final void initShareView(CommunityItemBean communityItemBean, CommunityDynamicShareView.OnAfterInitCallback onAfterInitCallback) {
        new CommunityDynamicShareView(this).setViewWH(ScreemTool.getScreenWidth(this), -2).setData(communityItemBean, onAfterInitCallback).onReMeasure();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static final void initView$lambda$0(CommunityDynamicDetailActivity communityDynamicDetailActivity, View view) {
        communityDynamicDetailActivity.showOpenHuoChatDialog(InnerShareParams.COMMENT);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$1(CommunityDynamicDetailActivity communityDynamicDetailActivity, AppBarLayout appBarLayout2, int i11) {
        CommunityHolder communityHolder = communityDynamicDetailActivity.mHolder;
        if (communityHolder != null) {
            communityHolder.removeFullExpandableTextViewLongClickEvent();
        }
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$2(CommunityDynamicDetailActivity communityDynamicDetailActivity) {
        communityDynamicDetailActivity.showSkeleton();
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$3(CommunityDynamicDetailActivity communityDynamicDetailActivity, NestedScrollView nestedScrollView, int i11, int i12, int i13, int i14) {
        CommunityHolder communityHolder = communityDynamicDetailActivity.mHolder;
        if (communityHolder != null) {
            communityHolder.removeFullExpandableTextViewLongClickEvent();
        }
    }

    private final void initViewPager() {
        initMagicIndicator();
    }

    private final void refreshCommentVisible(boolean z11) {
        MyNestedScrollView myNestedScrollView = null;
        if (z11) {
            View view = this.vDividerContent;
            if (view == null) {
                view = null;
            }
            view.setBackgroundColor(this.communityThemeColor.getCommunityMomentContentCopyBgColor());
            MagicIndicator magicIndicator = this.magicIndicatator;
            if (magicIndicator == null) {
                magicIndicator = null;
            }
            magicIndicator.setVisibility(0);
            View view2 = this.vMagicLine;
            if (view2 == null) {
                view2 = null;
            }
            view2.setBackgroundColor(this.communityThemeColor.getCommunityMomentMainPageTopLineColor());
            LinearLayout linearLayout = this.ll_edit_oprate_panel;
            if (linearLayout == null) {
                linearLayout = null;
            }
            linearLayout.setVisibility(0);
        } else {
            View view3 = this.vDividerContent;
            if (view3 == null) {
                view3 = null;
            }
            view3.setBackgroundColor(this.communityThemeColor.getCommunityMomentMainPageBgColor());
            MagicIndicator magicIndicator2 = this.magicIndicatator;
            if (magicIndicator2 == null) {
                magicIndicator2 = null;
            }
            magicIndicator2.setVisibility(4);
            View view4 = this.vMagicLine;
            if (view4 == null) {
                view4 = null;
            }
            view4.setBackgroundColor(this.communityThemeColor.getCommunityMomentMainPageBgColor());
            LinearLayout linearLayout2 = this.ll_edit_oprate_panel;
            if (linearLayout2 == null) {
                linearLayout2 = null;
            }
            linearLayout2.setVisibility(8);
        }
        MomentCommentListView momentCommentListView = this.mclv_comment_list_view;
        if (momentCommentListView != null) {
            momentCommentListView.setCommentListVisible(z11);
        }
        if (!z11) {
            AppBarLayout appBarLayout2 = this.appBarLayout;
            if (appBarLayout2 == null) {
                appBarLayout2 = null;
            }
            ((AppBarLayout.Behavior) ((CoordinatorLayout.LayoutParams) appBarLayout2.getLayoutParams()).f()).setDragCallback(new CommunityDynamicDetailActivity$refreshCommentVisible$1());
            MyNestedScrollView myNestedScrollView2 = this.msv_moment_detail_scrollview;
            if (myNestedScrollView2 != null) {
                myNestedScrollView = myNestedScrollView2;
            }
            myNestedScrollView.setScrollingEnabled(true);
            return;
        }
        MyNestedScrollView myNestedScrollView3 = this.msv_moment_detail_scrollview;
        if (myNestedScrollView3 != null) {
            myNestedScrollView = myNestedScrollView3;
        }
        myNestedScrollView.setScrollingEnabled(false);
    }

    /* access modifiers changed from: private */
    public final void refreshMomentInfoView() {
        View view;
        MomentCommentListView momentCommentListView;
        CommunityItemBean communityItemBean = this.mCommunityItemBean;
        boolean z11 = true;
        if (communityItemBean != null) {
            this.isDetailHasData = true;
        }
        if (this.mHolder == null) {
            FrameLayout frameLayout = null;
            if (communityItemBean != null) {
                List<String> images = communityItemBean.getImages();
                MomentType type = MomentType.getType((this.mCommunityItemBean.getType() * 10) + (images != null ? images.size() : 0));
                switch (type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
                    case 1:
                        LayoutInflater layoutInflater = this.mLayoutInflater;
                        if (layoutInflater == null) {
                            layoutInflater = null;
                        }
                        view = layoutInflater.inflate(R.layout.item_community_image_1, (ViewGroup) null, false);
                        break;
                    case 2:
                        LayoutInflater layoutInflater2 = this.mLayoutInflater;
                        if (layoutInflater2 == null) {
                            layoutInflater2 = null;
                        }
                        view = layoutInflater2.inflate(R.layout.item_community_out_share_url, (ViewGroup) null, false);
                        break;
                    case 3:
                    case 4:
                        LayoutInflater layoutInflater3 = this.mLayoutInflater;
                        if (layoutInflater3 == null) {
                            layoutInflater3 = null;
                        }
                        view = layoutInflater3.inflate(R.layout.item_community_text, (ViewGroup) null, false);
                        break;
                    case 5:
                    case 6:
                        LayoutInflater layoutInflater4 = this.mLayoutInflater;
                        if (layoutInflater4 == null) {
                            layoutInflater4 = null;
                        }
                        view = layoutInflater4.inflate(R.layout.item_community_image_1, (ViewGroup) null, false);
                        break;
                    case 7:
                        LayoutInflater layoutInflater5 = this.mLayoutInflater;
                        if (layoutInflater5 == null) {
                            layoutInflater5 = null;
                        }
                        view = layoutInflater5.inflate(R.layout.item_community_image_2, (ViewGroup) null, false);
                        break;
                    case 8:
                        LayoutInflater layoutInflater6 = this.mLayoutInflater;
                        if (layoutInflater6 == null) {
                            layoutInflater6 = null;
                        }
                        view = layoutInflater6.inflate(R.layout.item_community_image_3, (ViewGroup) null, false);
                        break;
                    case 9:
                        LayoutInflater layoutInflater7 = this.mLayoutInflater;
                        if (layoutInflater7 == null) {
                            layoutInflater7 = null;
                        }
                        view = layoutInflater7.inflate(R.layout.item_community_image_4, (ViewGroup) null, false);
                        break;
                    case 10:
                        LayoutInflater layoutInflater8 = this.mLayoutInflater;
                        if (layoutInflater8 == null) {
                            layoutInflater8 = null;
                        }
                        view = layoutInflater8.inflate(R.layout.item_community_image_5, (ViewGroup) null, false);
                        break;
                    case 11:
                        LayoutInflater layoutInflater9 = this.mLayoutInflater;
                        if (layoutInflater9 == null) {
                            layoutInflater9 = null;
                        }
                        view = layoutInflater9.inflate(R.layout.item_community_image_6, (ViewGroup) null, false);
                        break;
                    case 12:
                        LayoutInflater layoutInflater10 = this.mLayoutInflater;
                        if (layoutInflater10 == null) {
                            layoutInflater10 = null;
                        }
                        view = layoutInflater10.inflate(R.layout.item_community_image_7, (ViewGroup) null, false);
                        break;
                    case 13:
                        LayoutInflater layoutInflater11 = this.mLayoutInflater;
                        if (layoutInflater11 == null) {
                            layoutInflater11 = null;
                        }
                        view = layoutInflater11.inflate(R.layout.item_community_image_8, (ViewGroup) null, false);
                        break;
                    case 14:
                        LayoutInflater layoutInflater12 = this.mLayoutInflater;
                        if (layoutInflater12 == null) {
                            layoutInflater12 = null;
                        }
                        view = layoutInflater12.inflate(R.layout.item_community_image_9, (ViewGroup) null, false);
                        break;
                    case 15:
                        view = null;
                        break;
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                        LayoutInflater layoutInflater13 = this.mLayoutInflater;
                        if (layoutInflater13 == null) {
                            layoutInflater13 = null;
                        }
                        view = layoutInflater13.inflate(R.layout.item_community_share_url, (ViewGroup) null, false);
                        break;
                    case 21:
                        LayoutInflater layoutInflater14 = this.mLayoutInflater;
                        if (layoutInflater14 == null) {
                            layoutInflater14 = null;
                        }
                        view = layoutInflater14.inflate(R.layout.item_community_content_identify_link, (ViewGroup) null, false);
                        break;
                    default:
                        LayoutInflater layoutInflater15 = this.mLayoutInflater;
                        if (layoutInflater15 == null) {
                            layoutInflater15 = null;
                        }
                        view = layoutInflater15.inflate(R.layout.item_community_text, (ViewGroup) null, false);
                        break;
                }
                List<CommentItemBean> commentList = this.mCommunityItemBean.getCommentList();
                if (!(commentList == null || (momentCommentListView = this.mclv_comment_list_view) == null)) {
                    if (momentCommentListView.getStartIndex() > 0) {
                        z11 = false;
                    }
                    momentCommentListView.addCommentDatas(commentList, z11);
                }
                MomentCommentListView momentCommentListView2 = this.mclv_comment_list_view;
                if (momentCommentListView2 != null) {
                    momentCommentListView2.handlerCommentEmpty();
                }
            } else {
                LayoutInflater layoutInflater16 = this.mLayoutInflater;
                if (layoutInflater16 == null) {
                    layoutInflater16 = null;
                }
                view = layoutInflater16.inflate(R.layout.item_community_text, (ViewGroup) null, false);
            }
            this.mHolder = view != null ? new CommunityHolder(this, view, false, false) : null;
            FrameLayout frameLayout2 = this.ffMomentTypeContainer;
            if (frameLayout2 != null) {
                frameLayout = frameLayout2;
            }
            frameLayout.addView(view);
        }
        initMomentHolderData(this.mHolder, this.mCommunityItemBean);
        KeyboardListener.setListener(this, new CommunityDynamicDetailActivity$refreshMomentInfoView$3(this));
    }

    /* access modifiers changed from: private */
    public final void refreshMoreDataInfo() {
        MomentCommentListView momentCommentListView;
        boolean z11 = false;
        if (this.mCommunityItemBean == null) {
            this.isDetailHasData = false;
            return;
        }
        this.isDetailHasData = true;
        CommunityManager.Companion companion = CommunityManager.Companion;
        if (companion.getInstance().isCommentListShow() && this.mCommunityItemBean.getCommentList() != null) {
            List<CommentItemBean> commentList = this.mCommunityItemBean.getCommentList();
            if (commentList != null && (!commentList.isEmpty())) {
                z11 = true;
            }
            if (z11 && (momentCommentListView = this.mclv_comment_list_view) != null) {
                String mid2 = this.mCommunityItemBean.getMid();
                List<CommentItemBean> commentList2 = this.mCommunityItemBean.getCommentList();
                Integer commentNextIndex = this.mCommunityItemBean.getCommentNextIndex();
                momentCommentListView.initData(this, mid2, commentList2, commentNextIndex != null ? commentNextIndex.intValue() : -1);
            }
        }
        refreshCommentVisible(companion.getInstance().isCommentListShow());
    }

    private final void refreshPageThemeColor() {
        Drawable background;
        NBStatusBarUtils.translucent((Activity) this);
        if (CommunityManager.Companion.getInstance().isNightModel()) {
            NBStatusBarUtils.setStatusBarDarkMode(this);
        } else {
            NBStatusBarUtils.setStatusBarLightMode(this);
        }
        LinearLayout linearLayout = this.llRootView;
        View view = null;
        if (linearLayout == null) {
            linearLayout = null;
        }
        linearLayout.setBackgroundColor(this.communityThemeColor.getCommunityMomentMainPageBgColor());
        View view2 = this.llCommunityBaseInfoContainer;
        if (view2 == null) {
            view2 = null;
        }
        view2.setBackgroundColor(this.communityThemeColor.getCommunityMomentMainPageBgColor());
        CommunityDetailSkeletonView communityDetailSkeletonView = this.cdsvDetailSkeleton;
        if (communityDetailSkeletonView == null) {
            communityDetailSkeletonView = null;
        }
        communityDetailSkeletonView.setBackgroundColor(this.communityThemeColor.getCommunityMomentMainPageBgColor());
        FrameLayout frameLayout = this.flErrorContainer;
        if (frameLayout != null) {
            frameLayout.setBackgroundColor(this.communityThemeColor.getCommunityMomentMainPageBgColor());
        }
        CommonToolbar commonToolbar = this.ctbToolBar;
        if (commonToolbar == null) {
            commonToolbar = null;
        }
        commonToolbar.getIvLeftIcon().setColorFilter(this.communityThemeColor.getCommunityMomentMainPageTitleColor());
        CommonToolbar commonToolbar2 = this.ctbToolBar;
        if (commonToolbar2 == null) {
            commonToolbar2 = null;
        }
        commonToolbar2.getTvTitle().setTextColor(this.communityThemeColor.getCommunityMomentMainPageTitleColor());
        View view3 = this.vMomentDtailTopLine;
        if (view3 != null) {
            view3.setBackgroundColor(this.communityThemeColor.getCommunityMomentMainPageTopLineColor());
        }
        View view4 = this.vDividerContent;
        if (view4 == null) {
            view4 = null;
        }
        view4.setBackgroundColor(this.communityThemeColor.getCommunityMomentContentCopyBgColor());
        View view5 = this.vMagicLine;
        if (view5 != null) {
            view = view5;
        }
        view.setBackgroundColor(this.communityThemeColor.getCommunityMomentMainPageTopLineColor());
        TextView textView = this.tvMomentDetailCommentInput;
        if (textView != null) {
            textView.setTextColor(this.communityThemeColor.getErrorDefTipsMomentEmptyTextColor());
        }
        TextView textView2 = this.tvMomentDetailCommentInput;
        if (!(textView2 == null || (background = textView2.getBackground()) == null)) {
            background.setColorFilter(this.communityThemeColor.getCommunityMomentCommentDialogInputBgColor(), PorterDuff.Mode.MULTIPLY);
        }
        MomentCommentListView momentCommentListView = this.mclv_comment_list_view;
        if (momentCommentListView != null) {
            momentCommentListView.notifyThemeChanged();
        }
        initMagicIndicator();
    }

    private final void refreshThemeColor() {
        this.communityThemeColor = CommunityManager.Companion.getInstance().getCommunityThemeColor();
    }

    private final void showOpenHuoChatDialog(String str) {
        CommunityDialogUtil communityDialogUtil = CommunityDialogUtil.INSTANCE;
        boolean isNightModel = CommunityManager.Companion.getInstance().isNightModel();
        communityDialogUtil.showDialog(this, isNightModel ? 1 : 0, getString(R.string.community_click_open_huobichat_app_hint), "", "", getString(R.string.n_cancel), getString(R.string.community_allow_open_huobichat_btn_hint), new b(str, this), new l(this, str));
    }

    /* access modifiers changed from: private */
    public static final void showOpenHuoChatDialog$lambda$5(String str, CommunityDynamicDetailActivity communityDynamicDetailActivity, HBDialogFragment hBDialogFragment) {
        CommunityModuleCallback moduleCallback = CommunityModuleConfig.Companion.getModuleCallback();
        if (moduleCallback != null) {
            String openHuoxinAlert = CommunitySensorsEvent.Companion.getOpenHuoxinAlert();
            HashMap hashMap = new HashMap();
            hashMap.put("action_key", "no");
            hashMap.put("type", str);
            hashMap.put("Page_name", "detail");
            hashMap.put("symbol", communityDynamicDetailActivity.sensorSymbol);
            Unit unit = Unit.f56620a;
            moduleCallback.track(openHuoxinAlert, hashMap);
        }
        if (hBDialogFragment != null) {
            hBDialogFragment.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public static final void showOpenHuoChatDialog$lambda$7(CommunityDynamicDetailActivity communityDynamicDetailActivity, String str, HBDialogFragment hBDialogFragment) {
        CommunityModuleCallback moduleCallback = CommunityModuleConfig.Companion.getModuleCallback();
        if (moduleCallback != null) {
            String openHuoxinAlert = CommunitySensorsEvent.Companion.getOpenHuoxinAlert();
            HashMap hashMap = new HashMap();
            hashMap.put("action_key", "yes");
            hashMap.put("type", str);
            hashMap.put("Page_name", "detail");
            hashMap.put("symbol", communityDynamicDetailActivity.sensorSymbol);
            Unit unit = Unit.f56620a;
            moduleCallback.track(openHuoxinAlert, hashMap);
        }
        if (hBDialogFragment != null) {
            hBDialogFragment.dismiss();
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(CommunityConstants.REQUEST_KEY_MID, communityDynamicDetailActivity.mid);
        CommunityManager.Companion.getInstance().openHuobiChat(communityDynamicDetailActivity, "communityDetail", jSONObject.toString());
    }

    /* access modifiers changed from: private */
    public final void showSkeleton() {
        FrameLayout frameLayout = this.flErrorContainer;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
        View view = this.detailEmptyContainer;
        if (view != null) {
            view.setVisibility(8);
        }
        CommunityDetailSkeletonView communityDetailSkeletonView = this.cdsvDetailSkeleton;
        CommunityDetailSkeletonView communityDetailSkeletonView2 = null;
        if (communityDetailSkeletonView == null) {
            communityDetailSkeletonView = null;
        }
        if (!communityDetailSkeletonView.showing()) {
            CommunityDetailSkeletonView communityDetailSkeletonView3 = this.cdsvDetailSkeleton;
            if (communityDetailSkeletonView3 != null) {
                communityDetailSkeletonView2 = communityDetailSkeletonView3;
            }
            communityDetailSkeletonView2.showSkeleton();
            i6.i.b().g(this.finishSkeletonRunnable, 8000);
        }
    }

    public Activity getActivity() {
        return this;
    }

    public int getLayoutId() {
        return R.layout.activity_community_dynamic_detail;
    }

    public final void handleEmpty(boolean z11) {
        ImageView imageView;
        ImageView imageView2;
        boolean z12 = this.mCommunityItemBean != null;
        View view = this.detailEmptyContainer;
        CommunityDetailSkeletonView communityDetailSkeletonView = null;
        TextView textView = view != null ? (TextView) view.findViewById(R.id.tv_empty_hint) : null;
        View view2 = this.detailEmptyContainer;
        TextView textView2 = view2 != null ? (TextView) view2.findViewById(R.id.tv_retry) : null;
        if (!NetTool.isNetworkAvailable() || !NetworkStatus.c(this) || !z11) {
            View view3 = this.detailEmptyContainer;
            if (!(view3 == null || (imageView = (ImageView) view3.findViewById(R.id.iv_empty_icon)) == null)) {
                imageView.setImageResource(this.communityThemeColor.getErrorDefIconNoNetworkResId());
            }
            if (textView != null) {
                textView.setText(getResources().getString(R.string.common_no_internet_access));
            }
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            if (textView2 != null) {
                textView2.setOnClickListener(new g(this));
            }
            int i11 = R.color.color_0066ED;
            int i12 = R.drawable.shape_common_middle_btn_light;
            if (CommunityManager.Companion.getInstance().isNightModel()) {
                i11 = R.color.color_2483FF;
                i12 = R.drawable.shape_common_middle_btn_night;
            }
            if (textView2 != null) {
                textView2.setTextColor(getResources().getColor(i11));
            }
            if (textView2 != null) {
                textView2.setBackgroundResource(i12);
            }
            if (textView != null) {
                textView.setTextColor(this.communityThemeColor.getErrorDefTipsMomentEmptyTextColor());
            }
            FrameLayout frameLayout = this.flErrorContainer;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            View view4 = this.detailEmptyContainer;
            if (view4 != null) {
                view4.setVisibility(0);
            }
        } else if (!z12) {
            View view5 = this.detailEmptyContainer;
            if (!(view5 == null || (imageView2 = (ImageView) view5.findViewById(R.id.iv_empty_icon)) == null)) {
                imageView2.setImageResource(this.communityThemeColor.getErrorDefIconMomentEmpty());
            }
            if (textView != null) {
                textView.setText(getResources().getString(R.string.community_empty_no_content_hint));
            }
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            if (textView != null) {
                textView.setTextColor(this.communityThemeColor.getErrorDefTipsMomentEmptyTextColor());
            }
            FrameLayout frameLayout2 = this.flErrorContainer;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(0);
            }
            View view6 = this.detailEmptyContainer;
            if (view6 != null) {
                view6.setVisibility(0);
            }
        } else {
            FrameLayout frameLayout3 = this.flErrorContainer;
            if (frameLayout3 != null) {
                frameLayout3.setVisibility(8);
            }
            View view7 = this.detailEmptyContainer;
            if (view7 != null) {
                view7.setVisibility(8);
            }
            CommunityDetailSkeletonView communityDetailSkeletonView2 = this.cdsvDetailSkeleton;
            if (communityDetailSkeletonView2 != null) {
                communityDetailSkeletonView = communityDetailSkeletonView2;
            }
            communityDetailSkeletonView.setVisibility(8);
        }
    }

    public void initData(Bundle bundle) {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            CommonToolbar commonToolbar = this.ctbToolBar;
            if (commonToolbar == null) {
                commonToolbar = null;
            }
            commonToolbar.setLeftClick(new e(this));
            refreshPageThemeColor();
            this.mIsAutoOpenCommentDialog = extras.getBoolean(CommunityConstants.IS_OPEN_COMMENT_DIALOG, false);
            CommunityItemBean communityItemBean = (CommunityItemBean) DataPosterTool.getInstance().getData(CommunityConstants.KEY_CIRCLE_DETAIL);
            DataPosterTool.getInstance().clearData(CommunityConstants.KEY_CIRCLE_DETAIL);
            if (communityItemBean != null) {
                this.mCommunityItemBean = communityItemBean;
                refreshMomentInfoView();
                refreshMoreDataInfo();
            }
            this.communitySymbol = extras.getString(CommunityConstants.COMMUNITY_SYMBOL, "");
            this.sensorSymbol = extras.getString("sensorSymbol", "");
            this.symbolParamType = SymbolParamType.Companion.getType(extras.getInt(CommunityConstants.SYMBOL_TYPE));
            String string = extras.getString(CommunityConstants.REQUEST_KEY_MID);
            this.mid = string;
            getMomentDetailInfo(string);
            return;
        }
        finish();
    }

    public void initView(View view) {
        initInflater();
        this.ctbToolBar = (CommonToolbar) findViewById(R.id.common_tool_bar_circle_detail);
        this.coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator_layout);
        this.appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        this.llCommunityBaseInfoContainer = findViewById(R.id.ll_community_base_info_container);
        this.ffMomentTypeContainer = (FrameLayout) findViewById(R.id.ff_moment_type_container);
        this.vDividerContent = findViewById(R.id.v_divider_content);
        this.tvDisclaimer = (TextView) findViewById(R.id.tv_disclaimer);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll_root_view);
        this.llRootView = linearLayout;
        MyNestedScrollView myNestedScrollView = null;
        if (linearLayout == null) {
            linearLayout = null;
        }
        linearLayout.setBackgroundColor(this.communityThemeColor.getCommunityMomentMainPageBgColor());
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.llTopFloatContainer);
        this.llTopFloatContainer = linearLayout2;
        if (linearLayout2 == null) {
            linearLayout2 = null;
        }
        linearLayout2.setBackgroundColor(this.communityThemeColor.getCommunityMomentMainPageBgColor());
        CommunityDetailSkeletonView communityDetailSkeletonView = (CommunityDetailSkeletonView) findViewById(R.id.cdsvDetailSkeleton);
        this.cdsvDetailSkeleton = communityDetailSkeletonView;
        if (communityDetailSkeletonView == null) {
            communityDetailSkeletonView = null;
        }
        communityDetailSkeletonView.setBackgroundColor(this.communityThemeColor.getCommunityMomentMainPageBgColor());
        this.llEditOpratePanel = findViewById(R.id.ll_edit_oprate_panel);
        this.detailEmptyContainer = findViewById(R.id.detailEmptyContainer);
        this.flErrorContainer = (FrameLayout) findViewById(R.id.flErrorContainer);
        this.mclv_comment_list_view = (MomentCommentListView) findViewById(R.id.mclv_comment_list_view);
        this.vMomentDtailTopLine = findViewById(R.id.vMomentDtailTopLine);
        this.tvMomentDetailCommentInput = (TextView) findViewById(R.id.tvMomentDetailCommentInput);
        this.magicIndicatator = (MagicIndicator) findViewById(R.id.magic_indicatator);
        this.vMagicLine = findViewById(R.id.vMagicLine);
        this.vpItemPageViewList.clear();
        View view2 = this.llEditOpratePanel;
        if (view2 == null) {
            view2 = null;
        }
        view2.setOnClickListener(new f(this));
        AppBarLayout appBarLayout2 = this.appBarLayout;
        if (appBarLayout2 == null) {
            appBarLayout2 = null;
        }
        appBarLayout2.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new j(this));
        initViewPager();
        CommunityDetailSkeletonView communityDetailSkeletonView2 = this.cdsvDetailSkeleton;
        if (communityDetailSkeletonView2 == null) {
            communityDetailSkeletonView2 = null;
        }
        communityDetailSkeletonView2.postDelayed(new c(this), 50);
        refreshCommentVisible(CommunityManager.Companion.getInstance().isCommentListShow());
        MyNestedScrollView myNestedScrollView2 = (MyNestedScrollView) findViewById(R.id.msv_moment_detail_scrollview);
        this.msv_moment_detail_scrollview = myNestedScrollView2;
        if (myNestedScrollView2 != null) {
            myNestedScrollView = myNestedScrollView2;
        }
        myNestedScrollView.setOnScrollChangedListener(new k(this));
        initDisclaimerHint();
    }

    public void onDestroy() {
        i6.i.b().h(this.finishSkeletonRunnable);
        super.onDestroy();
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        initData((Bundle) null);
    }

    public void onResume() {
        super.onResume();
        refreshThemeColor();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.moveDistanceX = motionEvent.getX();
            this.moveDistanceY = motionEvent.getY();
        } else if (action == 1) {
            this.moveDistanceX = 0.0f;
            this.moveDistanceY = 0.0f;
            CommunityHolder communityHolder = this.mHolder;
            if (communityHolder != null) {
                communityHolder.removeFullExpandableTextViewLongClickEvent();
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void shareCommunity() {
    }
}
