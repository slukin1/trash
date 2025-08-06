package com.huochat.community.viewholder;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.sharesdk.framework.InnerShareParams;
import com.alibaba.fastjson.JSONObject;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.m;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.core.util.IntentSafeUtils;
import com.hbg.lib.router.HbgRouter;
import com.huochat.community.CommunityManager;
import com.huochat.community.CommunityModuleCallback;
import com.huochat.community.CommunityModuleConfig;
import com.huochat.community.CommunityThemeColor;
import com.huochat.community.R;
import com.huochat.community.activity.PicturePreviewActivity;
import com.huochat.community.adapter.CommentListAdapter;
import com.huochat.community.adapter.CommunityFromListAdapter;
import com.huochat.community.base.CommunityConstants;
import com.huochat.community.base.CommunityRouterConfig;
import com.huochat.community.base.CommunitySensorsEvent;
import com.huochat.community.enums.MomentTagType;
import com.huochat.community.enums.SymbolParamType;
import com.huochat.community.listener.OnCommentClickListener;
import com.huochat.community.listener.OnCommunityDataChangedListener;
import com.huochat.community.listener.OnCommunityOperationClickListener;
import com.huochat.community.model.CommentItemBean;
import com.huochat.community.model.CommunityItemBean;
import com.huochat.community.model.CommunitySymbolBean;
import com.huochat.community.model.MomentType;
import com.huochat.community.util.ClickTool;
import com.huochat.community.util.CollectorsTool;
import com.huochat.community.util.ContextTool;
import com.huochat.community.util.DataPosterTool;
import com.huochat.community.util.DisplayTool;
import com.huochat.community.util.ImageLoadedrManager;
import com.huochat.community.util.JsonTool;
import com.huochat.community.util.KeyboardListener;
import com.huochat.community.util.MomentUtils;
import com.huochat.community.util.NumberTool;
import com.huochat.community.util.ScreemTool;
import com.huochat.community.util.glideformation.LongImageFitStart;
import com.huochat.community.widget.UserLogoView;
import com.huochat.community.widget.divider.Api21ItemDivider;
import com.huochat.community.widget.expandable.ExpandableTextView;
import com.huochat.community.widget.expandable.FixLinkMovementTouchListener;
import com.huochat.community.widget.expandable.LinkType;
import com.huochat.community.widget.expandable.StatusType;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.x;
import n3.c;
import n3.g;
import tv.b;
import tv.d;
import tv.e;
import tv.f;
import tv.h;
import tv.i;
import tv.j;
import tv.k;
import tv.l;
import tv.n;
import tv.o;
import tv.p;
import tv.q;
import tv.r;
import tv.s;

public final class CommunityHolder extends RecyclerView.ViewHolder {
    private CommentListAdapter commentListAdapter;
    private CommunityFromListAdapter communityFromListAdapter;
    private String communitySymbol;
    private CommunityThemeColor communityThemeColor;
    private ExpandableTextView expandTextViewMomentText;
    private ViewGroup flIdentyLinkImagesContainer;
    private final int imageRadius;
    private ImageView imageViewCircleHot;
    private ImageView imageViewCircleShareThumbnail;
    private ImageView imageViewCircleVip;
    private View itemCommunityListDetailView;
    private View itemCommunityListTopView;
    private ImageView ivCircleCommentImg;
    private ImageView ivCircleLikeImg;
    private ImageView ivCircleMoreOprate;
    private ImageView ivCircleRedPacket;
    private ImageView ivCircleShareImg;
    private ImageView ivContentTranslateArrow;
    private LinearLayout linearLayoutItemRoot;
    private View llBrowseLocation;
    private View llCommentPanel;
    private LinearLayout llContentTranslateHint;
    private LinearLayout llImagesBoxContainer;
    private View llRedPacketMarkContainer;
    private Activity mActivity;
    private CommunityItemBean mCommunityItemBean;
    private int mDefExpandableTextWidth;
    private final float mImageMaxHeight;
    private int mImageMaxWidth;
    private final float mImageMinHeight;
    private boolean mIsContentExpandable;
    private boolean mIsListItemView;
    private boolean mIsShowBottomOpratePanel;
    private boolean mIsShowCommentListPanel;
    private boolean mIsShowCommunityFromPanel;
    private boolean mIsShowContentFromTag;
    private boolean mIsShowDynamicTitle;
    private boolean mIsShowTranslationContext;
    private View mItemView;
    private final float mLargeImageWidth;
    private CommunityItemBean mOldCommunityItemBean;
    private OnHolderTouchListener mOnHolderTouchListener;
    private List<ImageView> nineGridImageViews;
    private OnCommentClickListener onCommentClickListener;
    private OnCommunityDataChangedListener onCommunityDataChangedListener;
    private OnCommunityOperationClickListener operationClickListener;
    private View relativeLayoutShareContent;
    private View rlCircleCommentClk;
    private View rlCircleLikeClk;
    private View rlCircleShareClk;
    private View rlSharelikercommentContainer;
    private RecyclerView rlvCommentList;
    private RecyclerView rlvCommunityFromList;
    private String sSymbol;
    private int screemWidth;
    private SymbolParamType symbolParamType;
    private TextView textViewCircleShareContent;
    private TextView textViewCircleShareDesc;
    private TextView textViewCircleShareDescMore;
    private TextView textViewCircleShareTitle;
    private TextView textViewCircleUserTag;
    private TextView tvCircleComment;
    private TextView tvCircleLike;
    private TextView tvCircleMsgDate;
    private TextView tvCircleMsgDelete;
    private TextView tvCircleMsgFrom;
    private TextView tvCircleMsgType;
    private TextView tvCircleShare;
    private TextView tvCircleUsername;
    private TextView tvCommentMoreTips;
    private TextView tvCommunityMomentTag;
    private TextView tvContentTranslate;
    private TextView tvContentTranslateHint;
    private TextView tvRedPacketStatus;
    private UserLogoView userLogoViewCircleAvatar;
    private View vLine1;
    private View vLine2;
    private View vListDividingLine;
    private View vTranslateDivider;
    private View viewBottomLine;
    private View viewPartMomentListBottom;

    public interface OnHolderTouchListener {
        void onTouch(CommunityHolder communityHolder);
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|27) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0050 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.huochat.community.model.MomentType[] r0 = com.huochat.community.model.MomentType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.huochat.community.model.MomentType r1 = com.huochat.community.model.MomentType.MOMENT_TEXT     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.huochat.community.model.MomentType r1 = com.huochat.community.model.MomentType.MOMENT_IMAGE_0     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.huochat.community.model.MomentType r1 = com.huochat.community.model.MomentType.MOMENT_NONE     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.huochat.community.model.MomentType r1 = com.huochat.community.model.MomentType.MOMENT_VEDIO     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.huochat.community.model.MomentType r1 = com.huochat.community.model.MomentType.MOMENT_EXCHANGE     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.huochat.community.model.MomentType r1 = com.huochat.community.model.MomentType.MOMENT_CLUB     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                com.huochat.community.model.MomentType r1 = com.huochat.community.model.MomentType.MOMENT_NEWS     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                com.huochat.community.model.MomentType r1 = com.huochat.community.model.MomentType.MOMENT_SCHOOL     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                com.huochat.community.model.MomentType r1 = com.huochat.community.model.MomentType.MOMENT_PROJECT     // Catch:{ NoSuchFieldError -> 0x005a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                com.huochat.community.model.MomentType r1 = com.huochat.community.model.MomentType.MOMENT_OUT_SHARE_IMAGE     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                com.huochat.community.model.MomentType r1 = com.huochat.community.model.MomentType.MOMENT_OUT_SHARE_LINK     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                com.huochat.community.model.MomentType r1 = com.huochat.community.model.MomentType.MOMENT_CONTENT_LINK     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huochat.community.viewholder.CommunityHolder.WhenMappings.<clinit>():void");
        }
    }

    public CommunityHolder(Activity activity, View view, boolean z11, boolean z12) {
        super(view);
        this.mIsShowBottomOpratePanel = true;
        this.mIsShowCommunityFromPanel = true;
        this.imageRadius = DisplayTool.dp2px(activity, 4.0f);
        this.mImageMaxHeight = 180.0f;
        this.mImageMinHeight = 115.0f;
        this.mLargeImageWidth = 140.0f;
        this.communityThemeColor = CommunityManager.Companion.getInstance().getCommunityThemeColor();
        this.mActivity = activity;
        this.mItemView = view;
        this.mIsListItemView = z11;
        this.mIsShowCommunityFromPanel = z12;
        initView(activity);
        this.symbolParamType = SymbolParamType.SYMBOL;
    }

    /* access modifiers changed from: private */
    public static final boolean bindData$lambda$12$lambda$10(TextView textView, CommunityHolder communityHolder, Activity activity, Ref$ObjectRef ref$ObjectRef, View view) {
        textView.setBackgroundColor(communityHolder.communityThemeColor.getCommunityMomentContentCopyBgColor());
        MomentUtils.Companion.showPopupWindow(activity, communityHolder.tvContentTranslate, (String) ref$ObjectRef.element, (AtomicReference<MotionEvent>) null);
        return true;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static final void bindData$lambda$12$lambda$11(CommunityItemBean communityItemBean, CommunityHolder communityHolder, View view) {
        String str = null;
        if (communityItemBean.isTranslateExpanded()) {
            communityItemBean.setTranslateExpanded(false);
            ImageView ivContentTranslateArrow2 = communityHolder.getIvContentTranslateArrow();
            if (ivContentTranslateArrow2 != null) {
                ivContentTranslateArrow2.setRotation(180.0f);
            }
            View vTranslateDivider2 = communityHolder.getVTranslateDivider();
            if (vTranslateDivider2 != null) {
                vTranslateDivider2.setVisibility(8);
            }
            TextView tvContentTranslate2 = communityHolder.getTvContentTranslate();
            if (tvContentTranslate2 != null) {
                tvContentTranslate2.setVisibility(8);
            }
            TextView tvContentTranslateHint2 = communityHolder.getTvContentTranslateHint();
            if (tvContentTranslateHint2 != null) {
                Activity mActivity2 = communityHolder.getMActivity();
                if (mActivity2 != null) {
                    str = mActivity2.getString(R.string.community_content_translate_unfold_hint);
                }
                tvContentTranslateHint2.setText(str);
            }
        } else {
            communityItemBean.setTranslateExpanded(true);
            ImageView ivContentTranslateArrow3 = communityHolder.getIvContentTranslateArrow();
            if (ivContentTranslateArrow3 != null) {
                ivContentTranslateArrow3.setRotation(0.0f);
            }
            View vTranslateDivider3 = communityHolder.getVTranslateDivider();
            if (vTranslateDivider3 != null) {
                vTranslateDivider3.setVisibility(0);
            }
            TextView tvContentTranslate3 = communityHolder.getTvContentTranslate();
            if (tvContentTranslate3 != null) {
                tvContentTranslate3.setVisibility(0);
            }
            TextView tvContentTranslateHint3 = communityHolder.getTvContentTranslateHint();
            if (tvContentTranslateHint3 != null) {
                Activity mActivity3 = communityHolder.getMActivity();
                if (mActivity3 != null) {
                    str = mActivity3.getString(R.string.community_content_translate_fold_hint);
                }
                tvContentTranslateHint3.setText(str);
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static final void bindData$lambda$12$lambda$9(CommunityHolder communityHolder, View view) {
        if (!ClickTool.isRealClick()) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        communityHolder.gotoDynamicDetail();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static final void bindData$lambda$13(CommunityHolder communityHolder, View view) {
        if (!ClickTool.isRealClick()) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        communityHolder.gotoDynamicDetail();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static final void bindData$lambda$14(CommunityHolder communityHolder, CommunityItemBean communityItemBean, View view) {
        OnCommunityOperationClickListener onCommunityOperationClickListener = communityHolder.operationClickListener;
        if (onCommunityOperationClickListener != null) {
            onCommunityOperationClickListener.onMoreBtnClick(communityHolder, communityItemBean);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static final void bindData$lambda$15(CommunityHolder communityHolder, CommunityItemBean communityItemBean, View view) {
        View view2 = communityHolder.llBrowseLocation;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        OnCommunityOperationClickListener onCommunityOperationClickListener = communityHolder.operationClickListener;
        if (onCommunityOperationClickListener != null) {
            onCommunityOperationClickListener.onBrowerLocationClick(communityHolder, communityItemBean);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static final void bindData$lambda$16(View view) {
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static final void bindData$lambda$17(View view) {
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static final void bindData$lambda$18(CommunityHolder communityHolder, View view) {
        communityHolder.openWebView();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static final void bindData$lambda$19(View view) {
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static final void bindData$lambda$22(CommunityHolder communityHolder, CommunityItemBean communityItemBean, View view) {
        communityHolder.openWebView(communityHolder.mActivity, communityItemBean.getSharelink(), communityItemBean.getShareTitle(), (String) null, false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static final void bindData$lambda$23(CommunityHolder communityHolder, Ref$ObjectRef ref$ObjectRef, CommunityItemBean communityItemBean, View view) {
        communityHolder.openWebView(communityHolder.mActivity, (String) ref$ObjectRef.element, communityItemBean.getShareTitle(), (String) null, false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public static final void bindData$lambda$8$lambda$3(CommunityHolder communityHolder, StatusType statusType) {
        communityHolder.gotoDynamicDetail();
    }

    /* access modifiers changed from: private */
    public static final boolean bindData$lambda$8$lambda$4(Ref$BooleanRef ref$BooleanRef, ExpandableTextView expandableTextView, CommunityHolder communityHolder, Activity activity, CommunityItemBean communityItemBean, View view) {
        if (!ref$BooleanRef.element) {
            expandableTextView.setBackgroundColor(communityHolder.communityThemeColor.getCommunityMomentContentCopyBgColor());
            MomentUtils.Companion.showPopupWindow(activity, expandableTextView, communityItemBean.getText(), (AtomicReference<MotionEvent>) null);
        }
        ref$BooleanRef.element = false;
        return true;
    }

    /* access modifiers changed from: private */
    public static final void bindData$lambda$8$lambda$6(Ref$BooleanRef ref$BooleanRef, CommunityHolder communityHolder, String str, LinkType linkType, String str2, String str3) {
        if (ClickTool.isRealClick()) {
            ref$BooleanRef.element = true;
            if (linkType == LinkType.MENTION_TYPE && !TextUtils.isEmpty(str2)) {
                String G = StringsKt__StringsJVMKt.G(StringsKt__StringsJVMKt.G(str2, "#", "", false, 4, (Object) null), "\u0002", "", false, 4, (Object) null);
                Bundle bundle = new Bundle();
                bundle.putString(CommunityConstants.TOPIC_NAME, G);
                HbgRouter.i(communityHolder.mActivity, CommunityRouterConfig.ACTIVITY_COMMUNITY_TOPIC_SEARCH_TEMPLATE, bundle);
                CommunityModuleCallback moduleCallback = CommunityModuleConfig.Companion.getModuleCallback();
                if (moduleCallback != null) {
                    String communityClickTopicContent = CommunitySensorsEvent.Companion.getCommunityClickTopicContent();
                    HashMap hashMap = new HashMap();
                    String str4 = str;
                    hashMap.put("symbol", str);
                    Unit unit = Unit.f56620a;
                    moduleCallback.track(communityClickTopicContent, hashMap);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static final void bindData$lambda$8$lambda$7(CommunityHolder communityHolder, View view) {
        if (!ClickTool.isRealClick()) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        communityHolder.gotoDynamicDetail();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private final void displayImage(Activity activity, String str, int i11, int i12, ImageView imageView) {
        ImageView imageView2 = imageView;
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.element = getImageDefResource();
        switch (i11) {
            case 1:
                if (imageView.getScaleType() == ImageView.ScaleType.FIT_START) {
                    imageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    ImageLoadedrManager.getInstance().displayWithTransform(activity, str, ref$IntRef.element, imageView, new LongImageFitStart(this.imageRadius, this.mImageMaxHeight / this.mLargeImageWidth), new CommunityHolder$displayImage$1(imageView2));
                    return;
                }
                ImageLoadedrManager.getInstance().displayWithTransform(activity, str, ref$IntRef.element, imageView, new c((g<T>[]) new g[]{new CenterCrop(), new m(this.imageRadius)}));
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                if (imageView.getWidth() != 0 && imageView.getWidth() == imageView.getHeight()) {
                    ImageLoadedrManager.getInstance().displayWithTransform(activity, str, ref$IntRef.element, imageView, new c((g<T>[]) new g[]{new CenterCrop(), new m(this.imageRadius)}));
                    return;
                } else if (this.mIsListItemView) {
                    imageView2.postDelayed(new j(this, imageView, activity, str, ref$IntRef), 25);
                    return;
                } else {
                    ImageLoadedrManager.getInstance().displayWithTransform(activity, str, ref$IntRef.element, imageView, new c((g<T>[]) new g[]{new CenterCrop(), new m(this.imageRadius)}));
                    return;
                }
            default:
                ImageLoadedrManager instance = ImageLoadedrManager.getInstance();
                int i13 = ref$IntRef.element;
                instance.display((Context) activity, str, imageView, i13, i13);
                return;
        }
    }

    /* access modifiers changed from: private */
    public static final void displayImage$lambda$37(CommunityHolder communityHolder, ImageView imageView, Activity activity, String str, Ref$IntRef ref$IntRef) {
        communityHolder.resetPicLayoutHeight(imageView, imageView.getWidth());
        Activity activity2 = activity;
        String str2 = str;
        ImageView imageView2 = imageView;
        ImageLoadedrManager.getInstance().displayWithTransform(activity2, str2, ref$IntRef.element, imageView2, new c((g<T>[]) new g[]{new CenterCrop(), new m(communityHolder.imageRadius)}));
    }

    private final void fillProjectData(CommunityHolder communityHolder, MomentType momentType) {
        JSONObject parseObject;
        String str;
        CommunityItemBean communityItemBean = this.mCommunityItemBean;
        this.textViewCircleShareTitle.setText(communityItemBean.getShareTitle());
        if (!TextUtils.isEmpty(communityItemBean.getDetailTitle()) && (parseObject = JsonTool.parseObject(communityItemBean.getDetailTitle())) != null) {
            if (this.textViewCircleShareContent != null) {
                this.textViewCircleShareDesc.setVisibility(0);
                this.textViewCircleShareDesc.setText(BaseApplication.c(R.string.im_v_a_other_xj));
            }
            ImageLoadedrManager.getInstance().display((Context) BaseApplication.b(), parseObject.getString(InnerShareParams.IMAGE_URL), this.imageViewCircleShareThumbnail);
            String string = parseObject.getString("increasePercent");
            if (!TextUtils.isEmpty(string)) {
                try {
                    BigDecimal bigDecimal = new BigDecimal(string);
                    BigDecimal scale = bigDecimal.setScale(2, 5);
                    if (bigDecimal.doubleValue() > 0.0d) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append('+');
                        sb2.append(scale);
                        sb2.append('%');
                        str = sb2.toString();
                        this.textViewCircleShareDescMore.setTextColor(BaseApplication.b().getResources().getColor(R.color.color_03C087));
                    } else {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(scale);
                        sb3.append('%');
                        str = sb3.toString();
                        this.textViewCircleShareDescMore.setTextColor(BaseApplication.b().getResources().getColor(R.color.color_e76e43));
                    }
                    string = str;
                } catch (Exception unused) {
                }
            } else {
                string = "";
            }
            this.textViewCircleShareDescMore.setVisibility(0);
            TextView textView = this.textViewCircleShareDescMore;
            textView.setText(parseObject.getString("currentPrice") + "  " + string);
        }
    }

    private final int getImageDefResource() {
        if (CommunityManager.Companion.getInstance().isNightModel()) {
            return R.drawable.ic_def_huobi_icon_night;
        }
        return R.drawable.ic_def_huobi_icon_light;
    }

    private final View getNineGridImageViewLayout(Activity activity, int i11) {
        if (!ContextTool.checkActivity(activity) || i11 <= 0) {
            return null;
        }
        switch (i11) {
            case 1:
                return LayoutInflater.from(activity).inflate(R.layout.template_view_picture_1, (ViewGroup) null, false);
            case 2:
                return LayoutInflater.from(activity).inflate(R.layout.template_view_picture_2, (ViewGroup) null, false);
            case 3:
                return LayoutInflater.from(activity).inflate(R.layout.template_view_picture_3, (ViewGroup) null, false);
            case 4:
                return LayoutInflater.from(activity).inflate(R.layout.template_view_picture_4, (ViewGroup) null, false);
            case 5:
                return LayoutInflater.from(activity).inflate(R.layout.template_view_picture_5, (ViewGroup) null, false);
            case 6:
                return LayoutInflater.from(activity).inflate(R.layout.template_view_picture_6, (ViewGroup) null, false);
            case 7:
                return LayoutInflater.from(activity).inflate(R.layout.template_view_picture_7, (ViewGroup) null, false);
            case 8:
                return LayoutInflater.from(activity).inflate(R.layout.template_view_picture_8, (ViewGroup) null, false);
            case 9:
                return LayoutInflater.from(activity).inflate(R.layout.template_view_picture_9, (ViewGroup) null, false);
            default:
                return null;
        }
    }

    private final void gotoDynamicDetail() {
        removeFullExpandableTextViewLongClickEvent();
        if (ContextTool.checkActivity(this.mActivity)) {
            CommunityModuleCallback moduleCallback = CommunityModuleConfig.Companion.getModuleCallback();
            String str = null;
            if (moduleCallback != null) {
                String communityDetail = CommunitySensorsEvent.Companion.getCommunityDetail();
                HashMap hashMap = new HashMap();
                CommunityItemBean communityItemBean = this.mCommunityItemBean;
                hashMap.put("detailId", communityItemBean != null ? communityItemBean.getMid() : null);
                hashMap.put("symbol", this.sSymbol);
                Unit unit = Unit.f56620a;
                moduleCallback.track(communityDetail, hashMap);
            }
            DataPosterTool.getInstance().putData(CommunityConstants.KEY_CIRCLE_DETAIL, this.mCommunityItemBean);
            Bundle bundle = new Bundle();
            CommunityItemBean communityItemBean2 = this.mCommunityItemBean;
            if (communityItemBean2 != null) {
                str = communityItemBean2.getMid();
            }
            bundle.putString(CommunityConstants.REQUEST_KEY_MID, str);
            bundle.putString(CommunityConstants.COMMUNITY_SYMBOL, this.communitySymbol);
            bundle.putString("sensorSymbol", this.sSymbol);
            bundle.putInt(CommunityConstants.SYMBOL_TYPE, this.symbolParamType.getType());
            HbgRouter.i(this.mActivity, CommunityRouterConfig.ACTIVITY_COMMUNITY_DYNAMIC_DETAIL, bundle);
        }
    }

    private final void initNineGridImageViews(View view) {
        this.llImagesBoxContainer = (LinearLayout) view.findViewById(R.id.linear_layout_image_box);
        ArrayList arrayList = new ArrayList();
        this.nineGridImageViews = arrayList;
        ArrayList arrayList2 = arrayList;
        arrayList.add(view.findViewById(R.id.iv_community_pic_1));
        ((ArrayList) this.nineGridImageViews).add(view.findViewById(R.id.iv_community_pic_2));
        ((ArrayList) this.nineGridImageViews).add(view.findViewById(R.id.iv_community_pic_3));
        ((ArrayList) this.nineGridImageViews).add(view.findViewById(R.id.iv_community_pic_4));
        ((ArrayList) this.nineGridImageViews).add(view.findViewById(R.id.iv_community_pic_5));
        ((ArrayList) this.nineGridImageViews).add(view.findViewById(R.id.iv_community_pic_6));
        ((ArrayList) this.nineGridImageViews).add(view.findViewById(R.id.iv_community_pic_7));
        ((ArrayList) this.nineGridImageViews).add(view.findViewById(R.id.iv_community_pic_8));
        int i11 = R.id.iv_community_pic_9;
        ((ArrayList) this.nineGridImageViews).add(view.findViewById(i11));
        ((ArrayList) this.nineGridImageViews).add(view.findViewById(i11));
    }

    private final void initThemeColor() {
        CommentListAdapter commentListAdapter2 = this.commentListAdapter;
        if (commentListAdapter2 != null) {
            commentListAdapter2.notifyThemeChanged();
        }
        if (!this.mIsListItemView) {
            LinearLayout linearLayout = this.linearLayoutItemRoot;
            if (linearLayout != null) {
                linearLayout.setBackgroundColor(this.communityThemeColor.getCommunityMomentMainPageBgColor());
            }
        } else if (CommunityManager.Companion.getInstance().isNightModel()) {
            LinearLayout linearLayout2 = this.linearLayoutItemRoot;
            if (linearLayout2 != null) {
                linearLayout2.setBackgroundResource(R.drawable.shape_community_list_item_bg_night);
            }
        } else {
            LinearLayout linearLayout3 = this.linearLayoutItemRoot;
            if (linearLayout3 != null) {
                linearLayout3.setBackgroundResource(R.drawable.shape_community_list_item_bg_light);
            }
        }
        TextView textView = this.tvCircleUsername;
        if (textView != null) {
            textView.setTextColor(this.communityThemeColor.getUsernameTextColor());
        }
        TextView textView2 = this.textViewCircleUserTag;
        if (textView2 != null) {
            textView2.setTextColor(this.communityThemeColor.getAuthMarkTextColor());
        }
        ExpandableTextView expandableTextView = this.expandTextViewMomentText;
        if (expandableTextView != null) {
            expandableTextView.setTextColor(this.communityThemeColor.getContentTextColor());
            expandableTextView.setEndExpandTextColor(this.communityThemeColor.getContentTextColor());
            expandableTextView.setExpandTextColor(this.communityThemeColor.getContentExpandTextColor());
        }
        TextView textView3 = this.tvCircleMsgDate;
        if (textView3 != null) {
            textView3.setTextColor(this.communityThemeColor.getPostTimeTextColor());
        }
        TextView textView4 = this.tvCircleMsgType;
        if (textView4 != null) {
            textView4.setTextColor(this.communityThemeColor.getPostTypeTextColor());
        }
        TextView textView5 = this.tvCircleMsgFrom;
        if (textView5 != null) {
            textView5.setTextColor(this.communityThemeColor.getPostTimeTextColor());
        }
        ImageView imageView = this.ivCircleShareImg;
        if (imageView != null) {
            imageView.setColorFilter(this.communityThemeColor.getShareIconTextColor());
        }
        TextView textView6 = this.tvCircleShare;
        if (textView6 != null) {
            textView6.setTextColor(this.communityThemeColor.getShareIconTextColor());
        }
        ImageView imageView2 = this.ivCircleLikeImg;
        if (imageView2 != null) {
            imageView2.setColorFilter(this.communityThemeColor.getPraiseIconTextColor());
        }
        TextView textView7 = this.tvCircleLike;
        if (textView7 != null) {
            textView7.setTextColor(this.communityThemeColor.getPraiseIconTextColor());
        }
        ImageView imageView3 = this.ivCircleCommentImg;
        if (imageView3 != null) {
            imageView3.setColorFilter(this.communityThemeColor.getCommentIconTextColor());
        }
        TextView textView8 = this.tvCircleComment;
        if (textView8 != null) {
            textView8.setTextColor(this.communityThemeColor.getCommentIconTextColor());
        }
        CommunityFromListAdapter communityFromListAdapter2 = this.communityFromListAdapter;
        if (communityFromListAdapter2 != null) {
            communityFromListAdapter2.setColorTheme(this.communityThemeColor);
        }
        View view = this.vListDividingLine;
        if (view != null) {
            view.setBackgroundColor(this.communityThemeColor.getListDividingLineColor());
        }
        View view2 = this.relativeLayoutShareContent;
        if (view2 != null) {
            view2.setBackgroundResource(this.communityThemeColor.getShareContentBgDrawable());
        }
        TextView textView9 = this.textViewCircleShareTitle;
        if (textView9 != null) {
            textView9.setTextColor(this.communityThemeColor.getShareContentTitleTextColor());
        }
        TextView textView10 = this.textViewCircleShareDesc;
        if (textView10 != null) {
            textView10.setTextColor(this.communityThemeColor.getShareContentSubTitleTextColor());
        }
        TextView textView11 = this.textViewCircleShareDescMore;
        if (textView11 != null) {
            textView11.setTextColor(this.communityThemeColor.getShareContentSubTitleTextColor());
        }
        TextView textView12 = this.textViewCircleShareContent;
        if (textView12 != null) {
            textView12.setTextColor(this.communityThemeColor.getShareContentSubTitleTextColor());
        }
        View view3 = this.vLine1;
        if (view3 != null) {
            view3.setBackgroundColor(this.communityThemeColor.getOpratePanelVerticalDividingLineColor());
        }
        View view4 = this.vLine2;
        if (view4 != null) {
            view4.setBackgroundColor(this.communityThemeColor.getOpratePanelVerticalDividingLineColor());
        }
        if (CommunityManager.Companion.getInstance().isNightModel()) {
            ExpandableTextView expandableTextView2 = this.expandTextViewMomentText;
            if (expandableTextView2 != null) {
                expandableTextView2.setTitleTextColor(Color.parseColor("#FFFFFF"));
                return;
            }
            return;
        }
        ExpandableTextView expandableTextView3 = this.expandTextViewMomentText;
        if (expandableTextView3 != null) {
            expandableTextView3.setTitleTextColor(Color.parseColor("#333333"));
        }
    }

    private final void initView(Activity activity) {
        this.screemWidth = ScreemTool.getScreenWidth(activity.getApplicationContext());
        DisplayTool.dp2px(activity, 15.0f);
        int i11 = 0;
        if (this.mIsListItemView) {
            this.mIsContentExpandable = true;
            this.mIsShowCommentListPanel = false;
        } else {
            this.mIsContentExpandable = false;
            this.mIsShowCommentListPanel = false;
        }
        this.linearLayoutItemRoot = (LinearLayout) this.itemView.findViewById(R.id.linear_layout_item_root);
        UserLogoView userLogoView = (UserLogoView) this.itemView.findViewById(R.id.user_logo_view_circle_avatar);
        this.userLogoViewCircleAvatar = userLogoView;
        if (userLogoView != null) {
            userLogoView.setAvatarBackgroundResource(CommunityManager.Companion.getInstance().getAvatarBackgroundResId());
        }
        this.tvCircleUsername = (TextView) this.itemView.findViewById(R.id.tvCircleUsername);
        this.textViewCircleUserTag = (TextView) this.itemView.findViewById(R.id.text_view_circle_user_tag);
        this.tvCommunityMomentTag = (TextView) this.itemView.findViewById(R.id.tv_community_moment_tag);
        this.imageViewCircleVip = (ImageView) this.itemView.findViewById(R.id.image_view_circle_vip);
        this.imageViewCircleHot = (ImageView) this.itemView.findViewById(R.id.image_view_circle_hot);
        this.expandTextViewMomentText = (ExpandableTextView) this.itemView.findViewById(R.id.expendable_text_view);
        this.llContentTranslateHint = (LinearLayout) this.itemView.findViewById(R.id.ll_content_translate_hint);
        this.tvContentTranslateHint = (TextView) this.itemView.findViewById(R.id.tv_content_translate_hint);
        this.ivContentTranslateArrow = (ImageView) this.itemView.findViewById(R.id.iv_content_translate_arrow);
        this.vTranslateDivider = this.itemView.findViewById(R.id.v_content_translate_divider);
        this.tvContentTranslate = (TextView) this.itemView.findViewById(R.id.tv_content_translate);
        this.ivCircleMoreOprate = (ImageView) this.itemView.findViewById(R.id.ivCircleMoreOprate);
        this.llRedPacketMarkContainer = this.itemView.findViewById(R.id.llRedPacketMarkContainer);
        this.ivCircleRedPacket = (ImageView) this.itemView.findViewById(R.id.ivCircleRedPacket);
        this.tvRedPacketStatus = (TextView) this.itemView.findViewById(R.id.tvRedPacketStatus);
        this.llBrowseLocation = this.itemView.findViewById(R.id.ll_browse_location);
        this.tvCircleMsgDate = (TextView) this.itemView.findViewById(R.id.tv_circle_msg_date);
        this.tvCircleMsgType = (TextView) this.itemView.findViewById(R.id.tv_circle_msg_type);
        this.tvCircleMsgFrom = (TextView) this.itemView.findViewById(R.id.tv_circle_msg_from);
        View findViewById = this.itemView.findViewById(R.id.rl_sharelikercomment_container);
        this.rlSharelikercommentContainer = findViewById;
        if (findViewById != null) {
            findViewById.setVisibility(this.mIsListItemView ? 8 : 0);
        }
        this.rlCircleShareClk = this.itemView.findViewById(R.id.rl_circle_share_clk);
        this.ivCircleShareImg = (ImageView) this.itemView.findViewById(R.id.iv_circle_share_image);
        this.tvCircleShare = (TextView) this.itemView.findViewById(R.id.tv_circle_share);
        this.rlCircleLikeClk = this.itemView.findViewById(R.id.rl_circle_like_clk);
        this.ivCircleLikeImg = (ImageView) this.itemView.findViewById(R.id.iv_circle_like_image);
        this.tvCircleLike = (TextView) this.itemView.findViewById(R.id.tv_circle_like);
        this.rlCircleCommentClk = this.itemView.findViewById(R.id.rl_circle_comment_clk);
        this.ivCircleCommentImg = (ImageView) this.itemView.findViewById(R.id.iv_circle_comment_image);
        this.tvCircleComment = (TextView) this.itemView.findViewById(R.id.tv_circle_comment);
        this.communityFromListAdapter = new CommunityFromListAdapter(activity, (List<CommunitySymbolBean>) null);
        RecyclerView recyclerView = (RecyclerView) this.itemView.findViewById(R.id.rlvCommunityFromList);
        this.rlvCommunityFromList = recyclerView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(activity, 0, false));
        }
        RecyclerView recyclerView2 = this.rlvCommunityFromList;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.communityFromListAdapter);
        }
        RecyclerView recyclerView3 = this.rlvCommunityFromList;
        if (recyclerView3 != null) {
            recyclerView3.addItemDecoration(new Api21ItemDivider(0, DisplayTool.dp2px(7.0f), 0));
        }
        RecyclerView recyclerView4 = this.rlvCommunityFromList;
        if (recyclerView4 != null) {
            recyclerView4.setVisibility(this.mIsShowCommunityFromPanel ? 0 : 8);
        }
        View findViewById2 = this.itemView.findViewById(R.id.ll_comment_panel);
        this.llCommentPanel = findViewById2;
        if (findViewById2 != null) {
            if (findViewById2 != null) {
                findViewById2.setVisibility(this.mIsShowCommentListPanel ? 0 : 8);
            }
            this.commentListAdapter = new CommentListAdapter(this.mActivity, CommentListAdapter.CommentType.LIST_SUB);
            RecyclerView recyclerView5 = (RecyclerView) this.itemView.findViewById(R.id.rlv_comment_list);
            this.rlvCommentList = recyclerView5;
            if (recyclerView5 != null) {
                recyclerView5.setLayoutManager(new LinearLayoutManager(activity, 1, false));
            }
            RecyclerView recyclerView6 = this.rlvCommentList;
            if (recyclerView6 != null) {
                recyclerView6.setAdapter(this.commentListAdapter);
            }
            this.tvCommentMoreTips = (TextView) this.itemView.findViewById(R.id.tv_more_comment_tips);
            CommentListAdapter commentListAdapter2 = this.commentListAdapter;
            if (commentListAdapter2 != null) {
                OnCommentClickListener onCommentClickListener2 = this.onCommentClickListener;
                if (onCommentClickListener2 == null) {
                    onCommentClickListener2 = new CommunityHolder$initView$1();
                }
                commentListAdapter2.setOnCommentLongClick(onCommentClickListener2);
            }
        }
        this.vLine1 = this.itemView.findViewById(R.id.v_line_1);
        this.vLine2 = this.itemView.findViewById(R.id.v_line_2);
        View findViewById3 = this.itemView.findViewById(R.id.v_list_dividing_line);
        this.vListDividingLine = findViewById3;
        if (findViewById3 != null) {
            findViewById3.setVisibility(this.mIsListItemView ? 0 : 8);
        }
        View findViewById4 = this.itemView.findViewById(R.id.view_bottom_line);
        this.viewBottomLine = findViewById4;
        if (findViewById4 != null) {
            findViewById4.setBackgroundColor(-1);
        }
        View view = this.viewBottomLine;
        if (view != null) {
            view.setVisibility(8);
        }
        this.flIdentyLinkImagesContainer = (ViewGroup) this.itemView.findViewById(R.id.fl_images_container);
        initNineGridImageViews(this.itemView);
        View findViewById5 = this.itemView.findViewById(R.id.part_moment_list_bottom);
        this.viewPartMomentListBottom = findViewById5;
        if (findViewById5 != null) {
            if (!this.mIsShowBottomOpratePanel) {
                i11 = 8;
            }
            findViewById5.setVisibility(i11);
        }
        this.tvCircleMsgDelete = (TextView) this.itemView.findViewById(R.id.tv_circle_msg_delete);
        this.imageViewCircleShareThumbnail = (ImageView) this.itemView.findViewById(R.id.iv_circle_share_thumbnail);
        this.textViewCircleShareTitle = (TextView) this.itemView.findViewById(R.id.tv_circle_share_title);
        this.textViewCircleShareDesc = (TextView) this.itemView.findViewById(R.id.tv_circle_share_desc);
        this.textViewCircleShareDescMore = (TextView) this.itemView.findViewById(R.id.tv_circle_share_desc_more);
        this.textViewCircleShareContent = (TextView) this.itemView.findViewById(R.id.tv_circle_share_content);
        this.relativeLayoutShareContent = this.itemView.findViewById(R.id.rl_share_content_rootview);
        KeyboardListener.setListener(activity, new CommunityHolder$initView$2());
        initThemeColor();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static final void loadNineGridImages$lambda$36$lambda$35(Activity activity, androidx.core.util.c[] cVarArr, ArrayList arrayList, int i11, View view) {
        PicturePreviewActivity.Companion.startActivity(activity, cVarArr, arrayList, i11);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private final void refreshCommentList() {
        String str;
        if (this.mCommunityItemBean != null) {
            TextView textView = this.tvCircleComment;
            if (textView != null) {
                if (this.mCommunityItemBean.getCommentCount() <= 0) {
                    str = BaseApplication.c(R.string.text_comment);
                } else {
                    str = NumberTool.getSimpleShorthandNumber(this.mCommunityItemBean.getCommentCount());
                }
                textView.setText(str);
            }
            TextView textView2 = this.tvCommentMoreTips;
            if (textView2 != null) {
                textView2.setOnClickListener(new p(this));
            }
            refreshCommentPanelInfo(this.mCommunityItemBean.getCommentList(), this.mCommunityItemBean.getCommentCount() > 4);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static final void refreshCommentList$lambda$31(CommunityHolder communityHolder, View view) {
        communityHolder.gotoDynamicDetail();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private final void resetPicLayoutHeight(ImageView imageView, int i11) {
        if (i11 != 0) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            layoutParams.height = i11;
            imageView.setLayoutParams(layoutParams);
        }
    }

    @SuppressLint({"SetTextI18n"})
    public final void bindData(CommunityItemBean communityItemBean, Activity activity, String str) {
        boolean z11;
        int i11;
        TextView textView;
        TextView textView2;
        CommunityItemBean communityItemBean2 = communityItemBean;
        Activity activity2 = activity;
        String str2 = str;
        this.mOldCommunityItemBean = communityItemBean2;
        this.mCommunityItemBean = communityItemBean2;
        this.sSymbol = str2;
        if (communityItemBean2 == null) {
            View view = this.rlCircleShareClk;
            if (view != null) {
                view.setVisibility(8);
                return;
            }
            return;
        }
        View view2 = this.rlCircleShareClk;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        List<String> images = communityItemBean.getImages();
        int size = images != null ? images.size() : 0;
        MomentType type = MomentType.getType((communityItemBean.getType() * 10) + size);
        if (MomentType.MOMENT_NONE != type) {
            UserLogoView userLogoView = this.userLogoViewCircleAvatar;
            if (userLogoView != null) {
                userLogoView.setData(communityItemBean.getHeadImage(), communityItemBean.getVFlag(), communityItemBean.getCrownType(), communityItemBean.getAuthType());
            }
            ImageView imageView = this.imageViewCircleVip;
            if (imageView != null) {
                imageView.setVisibility(communityItemBean.getVipFlag() == 1 ? 0 : 8);
            }
            ImageView imageView2 = this.imageViewCircleHot;
            if (imageView2 != null) {
                imageView2.setVisibility((communityItemBean.getRecommand() == 1 && communityItemBean.isSelf() == 1) ? 0 : 8);
            }
            TextView textView3 = this.tvCircleUsername;
            String str3 = "";
            if (textView3 != null) {
                textView3.setText(TextUtils.isEmpty(str3) ? communityItemBean.getUsername() : str3);
            }
            if (this.tvCircleMsgType != null) {
                String str4 = type.label;
                if (TextUtils.isEmpty(str4)) {
                    TextView textView4 = this.tvCircleMsgType;
                    if (textView4 != null) {
                        textView4.setVisibility(8);
                    }
                } else {
                    TextView textView5 = this.tvCircleMsgType;
                    if (textView5 != null) {
                        textView5.setVisibility(0);
                    }
                    TextView textView6 = this.tvCircleMsgType;
                    if (textView6 != null) {
                        textView6.setText(str4);
                    }
                }
            }
            TextView textView7 = this.tvCircleMsgDate;
            if (textView7 != null) {
                textView7.setText(MomentUtils.Companion.formatMomentDate(communityItemBean.getPostTime()));
            }
            if (this.mIsShowContentFromTag && (textView2 = this.tvCircleMsgFrom) != null) {
                String momentSource = communityItemBean.getMomentSource();
                if (momentSource == null || momentSource.length() == 0) {
                    textView2.setText(str3);
                    textView2.setVisibility(8);
                } else {
                    textView2.setText(communityItemBean.getMomentSource());
                    textView2.setVisibility(0);
                }
            }
            if (!TextUtils.isEmpty(communityItemBean.getUserCommunityLabel())) {
                TextView textView8 = this.textViewCircleUserTag;
                if (textView8 != null) {
                    textView8.setText(communityItemBean.getUserCommunityLabel());
                }
                TextView textView9 = this.textViewCircleUserTag;
                if (textView9 != null) {
                    textView9.setVisibility(0);
                }
            } else {
                TextView textView10 = this.textViewCircleUserTag;
                if (textView10 != null) {
                    textView10.setText(str3);
                }
                TextView textView11 = this.textViewCircleUserTag;
                if (textView11 != null) {
                    textView11.setVisibility(8);
                }
            }
            ExpandableTextView expandableTextView = this.expandTextViewMomentText;
            if (expandableTextView != null) {
                MomentTagType.Companion companion = MomentTagType.Companion;
                expandableTextView.setPrefixLabelArgs((companion.getType(communityItemBean.getMomentTagType()) == MomentTagType.TOP || companion.getType(communityItemBean.getMomentTagType()) == MomentTagType.FEATURED || companion.getType(communityItemBean.getMomentTagType()) == MomentTagType.RECOMMEND) && !TextUtils.isEmpty(communityItemBean.getMomentTag()), communityItemBean.getMomentTag(), (float) DisplayTool.dp2px(10.0f), expandableTextView.getResources().getColor(R.color.color_FF9100), R.drawable.ic_community_hot_label_icon, DisplayTool.dp2px(8.0f), DisplayTool.dp2px(10.0f), expandableTextView.getResources().getColor(R.color.color_1AFF9B00), DisplayTool.dp2px(5.0f));
                expandableTextView.initDefTextLines(communityItemBean.getTitle(), communityItemBean.getText(), this.mDefExpandableTextWidth);
                ViewGroup.LayoutParams layoutParams = expandableTextView.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new FrameLayout.LayoutParams(-1, 0);
                }
                expandableTextView.setNeedExpend(this.mIsContentExpandable);
                expandableTextView.setExpandOrContractClickListener(new h(this), false);
                if (TextUtils.isEmpty(communityItemBean.getText())) {
                    layoutParams.height = 0;
                    expandableTextView.setContent((CharSequence) str3, (StatusType) null);
                } else {
                    layoutParams.height = -2;
                    ViewParent parent = expandableTextView.getParent();
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    }
                    String title = communityItemBean.getTitle();
                    if (!(title == null || title.length() == 0) && this.mIsShowDynamicTitle) {
                        str3 = communityItemBean.getTitle() + "  ";
                    }
                    String text = communityItemBean.getText();
                    this.expandTextViewMomentText.setTitle(str3).setTitleBold(true).setNeedTitle(this.mIsShowDynamicTitle).setContent((CharSequence) text == null || text.length() == 0 ? " " : String.valueOf(communityItemBean.getText()), (StatusType) null);
                }
                Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
                expandableTextView.setLayoutParams(layoutParams);
                tv.g gVar = r0;
                z11 = true;
                ExpandableTextView expandableTextView2 = expandableTextView;
                tv.g gVar2 = new tv.g(ref$BooleanRef, expandableTextView, this, activity, communityItemBean);
                expandableTextView2.setOnLongClickListener(gVar);
                expandableTextView2.setLinkClickListener(new i(ref$BooleanRef, this, str2));
                if (this.mIsListItemView) {
                    expandableTextView2.setOnClickListener(new o(this));
                }
            } else {
                z11 = true;
            }
            if (this.mIsShowTranslationContext && (textView = this.tvContentTranslate) != null) {
                Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                T textTranslation = communityItemBean.getTextTranslation();
                ref$ObjectRef.element = textTranslation;
                int i12 = Integer.MAX_VALUE;
                if (TextUtils.isEmpty((CharSequence) textTranslation)) {
                    LinearLayout linearLayout = this.llContentTranslateHint;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(8);
                    }
                    View view3 = this.vTranslateDivider;
                    if (view3 != null) {
                        view3.setVisibility(8);
                    }
                    textView.setVisibility(8);
                    textView.setMaxLines(Integer.MAX_VALUE);
                    textView.setEllipsize((TextUtils.TruncateAt) null);
                } else {
                    LinearLayout linearLayout2 = this.llContentTranslateHint;
                    if (linearLayout2 != null) {
                        linearLayout2.setVisibility(0);
                    }
                    View view4 = this.vTranslateDivider;
                    if (view4 != null) {
                        view4.setVisibility(0);
                    }
                    textView.setVisibility(0);
                    if (this.mIsContentExpandable) {
                        i12 = 5;
                    }
                    textView.setMaxLines(i12);
                    textView.setEllipsize(TextUtils.TruncateAt.END);
                    textView.setText((CharSequence) ref$ObjectRef.element);
                    textView.setOnTouchListener(new FixLinkMovementTouchListener());
                    if (this.mIsListItemView) {
                        textView.setOnClickListener(new tv.m(this));
                    }
                    textView.setOnLongClickListener(new f(textView, this, activity2, ref$ObjectRef));
                    if (communityItemBean.isTranslateExpanded()) {
                        ImageView ivContentTranslateArrow2 = getIvContentTranslateArrow();
                        if (ivContentTranslateArrow2 != null) {
                            ivContentTranslateArrow2.setRotation(0.0f);
                        }
                        View vTranslateDivider2 = getVTranslateDivider();
                        if (vTranslateDivider2 != null) {
                            vTranslateDivider2.setVisibility(0);
                        }
                        TextView tvContentTranslate2 = getTvContentTranslate();
                        if (tvContentTranslate2 != null) {
                            tvContentTranslate2.setVisibility(0);
                        }
                        TextView tvContentTranslateHint2 = getTvContentTranslateHint();
                        if (tvContentTranslateHint2 != null) {
                            Activity mActivity2 = getMActivity();
                            tvContentTranslateHint2.setText(mActivity2 != null ? mActivity2.getString(R.string.community_content_translate_fold_hint) : null);
                        }
                    } else {
                        ImageView ivContentTranslateArrow3 = getIvContentTranslateArrow();
                        if (ivContentTranslateArrow3 != null) {
                            ivContentTranslateArrow3.setRotation(180.0f);
                        }
                        View vTranslateDivider3 = getVTranslateDivider();
                        if (vTranslateDivider3 != null) {
                            vTranslateDivider3.setVisibility(8);
                        }
                        TextView tvContentTranslate3 = getTvContentTranslate();
                        if (tvContentTranslate3 != null) {
                            tvContentTranslate3.setVisibility(8);
                        }
                        TextView tvContentTranslateHint3 = getTvContentTranslateHint();
                        if (tvContentTranslateHint3 != null) {
                            Activity mActivity3 = getMActivity();
                            tvContentTranslateHint3.setText(mActivity3 != null ? mActivity3.getString(R.string.community_content_translate_unfold_hint) : null);
                        }
                    }
                    LinearLayout linearLayout3 = this.llContentTranslateHint;
                    if (linearLayout3 != null) {
                        linearLayout3.setOnClickListener(new k(communityItemBean2, this));
                    }
                }
            }
            View view5 = this.mItemView;
            if (view5 != null) {
                view5.setOnClickListener(new n(this));
            }
            ImageView imageView3 = this.ivCircleMoreOprate;
            if (imageView3 != null) {
                imageView3.setVisibility(8);
            }
            ImageView imageView4 = this.ivCircleMoreOprate;
            if (imageView4 != null) {
                imageView4.setOnClickListener(new s(this, communityItemBean2));
            }
            CommunityFromListAdapter communityFromListAdapter2 = this.communityFromListAdapter;
            if (communityFromListAdapter2 != null) {
                communityFromListAdapter2.resetData(communityItemBean.getCommunityInfoList());
            }
            View view6 = this.llBrowseLocation;
            if (view6 != null) {
                view6.setOnClickListener(new q(this, communityItemBean2));
            }
            refreshOperaterStateData(this.mCommunityItemBean);
        } else {
            z11 = true;
        }
        if (type == null) {
            i11 = -1;
        } else {
            i11 = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        }
        switch (i11) {
            case 1:
            case 2:
                this.itemView.setVisibility(0);
                break;
            case 3:
                this.itemView.setVisibility(8);
                break;
            case 4:
                break;
            case 5:
                fillShareData(this, type);
                View view7 = this.relativeLayoutShareContent;
                if (view7 != null) {
                    view7.setOnClickListener(tv.c.f60481b);
                    break;
                }
                break;
            case 6:
                fillShareData(this, type);
                View view8 = this.relativeLayoutShareContent;
                if (view8 != null) {
                    view8.setOnClickListener(e.f60483b);
                    break;
                }
                break;
            case 7:
            case 8:
                fillShareData(this, type);
                View view9 = this.relativeLayoutShareContent;
                if (view9 != null) {
                    view9.setOnClickListener(new l(this));
                    break;
                }
                break;
            case 9:
                fillProjectData(this, type);
                View view10 = this.relativeLayoutShareContent;
                if (view10 != null) {
                    view10.setOnClickListener(d.f60482b);
                    break;
                }
                break;
            case 10:
                if (!(activity2 == null || images == null)) {
                    loadNineGridImages(activity2, images, size);
                }
                TextView textView12 = this.tvCircleMsgType;
                if (textView12 != null) {
                    textView12.setVisibility(0);
                }
                TextView textView13 = this.tvCircleMsgType;
                if (textView13 != null) {
                    textView13.setText(activity.getResources().getString(R.string.text_from) + communityItemBean.getShareSource());
                    break;
                }
                break;
            case 11:
                TextView textView14 = this.tvCircleMsgType;
                if (textView14 != null) {
                    textView14.setVisibility(0);
                }
                TextView textView15 = this.tvCircleMsgType;
                if (textView15 != null) {
                    textView15.setText(activity.getResources().getString(R.string.text_from) + communityItemBean.getShareSource());
                }
                TextView textView16 = this.textViewCircleShareTitle;
                if (textView16 != null) {
                    textView16.setText(communityItemBean.getShareTitle());
                }
                ImageLoadedrManager.getInstance().display((Context) BaseApplication.b(), communityItemBean.getShareThumb(), this.imageViewCircleShareThumbnail);
                View view11 = this.relativeLayoutShareContent;
                if (view11 != null) {
                    view11.setOnClickListener(new r(this, communityItemBean2));
                    break;
                }
                break;
            case 12:
                Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
                String sharelink = communityItemBean.getSharelink();
                ref$ObjectRef2.element = (sharelink == null || sharelink.length() == 0) ? z11 : false ? communityItemBean.getParseLink() : communityItemBean.getSharelink();
                if (x.b(communityItemBean.isNewPublished(), Boolean.TRUE)) {
                    TextView textView17 = this.textViewCircleShareTitle;
                    if (textView17 != null) {
                        textView17.setText("链接识别中...");
                    }
                } else {
                    TextView textView18 = this.textViewCircleShareTitle;
                    if (textView18 != null) {
                        String shareTitle = communityItemBean.getShareTitle();
                        textView18.setText((shareTitle == null || shareTitle.length() == 0) ? z11 : false ? (CharSequence) ref$ObjectRef2.element : communityItemBean.getShareTitle());
                    }
                    TextView textView19 = this.textViewCircleShareDesc;
                    if (textView19 != null) {
                        textView19.setText(communityItemBean.getDetailTitle());
                    }
                }
                TextView textView20 = this.textViewCircleShareDesc;
                if (textView20 != null) {
                    String detailTitle = communityItemBean.getDetailTitle();
                    textView20.setVisibility((detailTitle == null || detailTitle.length() == 0) ? z11 : false ? 8 : 0);
                }
                TextView textView21 = this.textViewCircleShareContent;
                if (textView21 != null) {
                    textView21.setVisibility(8);
                }
                TextView textView22 = this.textViewCircleShareDescMore;
                if (textView22 != null) {
                    textView22.setVisibility(8);
                }
                ImageLoadedrManager instance = ImageLoadedrManager.getInstance();
                Application b11 = BaseApplication.b();
                String shareThumb = communityItemBean.getShareThumb();
                ImageView imageView5 = this.imageViewCircleShareThumbnail;
                int i13 = R.drawable.ic_community_item_link_def;
                instance.display((Context) b11, shareThumb, imageView5, i13, i13);
                View view12 = this.relativeLayoutShareContent;
                if (view12 != null) {
                    view12.setOnClickListener(new b(this, ref$ObjectRef2, communityItemBean2));
                }
                ViewGroup viewGroup = this.flIdentyLinkImagesContainer;
                if (viewGroup != null) {
                    viewGroup.removeAllViews();
                    viewGroup.removeAllViewsInLayout();
                    if (!(activity2 == null || images == null)) {
                        View nineGridImageViewLayout = getNineGridImageViewLayout(activity2, images.size());
                        if (nineGridImageViewLayout == null) {
                            viewGroup.setVisibility(8);
                            break;
                        } else {
                            viewGroup.setVisibility(0);
                            viewGroup.addView(nineGridImageViewLayout, new FrameLayout.LayoutParams(-1, -2));
                            initNineGridImageViews(viewGroup);
                            loadNineGridImages(activity2, images, size);
                            break;
                        }
                    }
                }
                break;
            default:
                if (!(activity2 == null || images == null)) {
                    loadNineGridImages(activity2, images, size);
                    break;
                }
        }
        refreshCommentList();
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003d A[Catch:{ Exception -> 0x007c }] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003f A[Catch:{ Exception -> 0x007c }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004f A[Catch:{ Exception -> 0x007c }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0055 A[Catch:{ Exception -> 0x007c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void fillShareData(com.huochat.community.viewholder.CommunityHolder r3, com.huochat.community.model.MomentType r4) {
        /*
            r2 = this;
            android.widget.TextView r0 = r3.tvCircleMsgType     // Catch:{ Exception -> 0x007c }
            java.lang.String r1 = r4.label     // Catch:{ Exception -> 0x007c }
            r0.setText(r1)     // Catch:{ Exception -> 0x007c }
            android.widget.ImageView r0 = r3.imageViewCircleShareThumbnail     // Catch:{ Exception -> 0x007c }
            int r4 = r4.resouceId     // Catch:{ Exception -> 0x007c }
            r0.setImageResource(r4)     // Catch:{ Exception -> 0x007c }
            android.widget.TextView r4 = r3.textViewCircleShareTitle     // Catch:{ Exception -> 0x007c }
            com.huochat.community.model.CommunityItemBean r0 = r2.mCommunityItemBean     // Catch:{ Exception -> 0x007c }
            java.lang.String r0 = r0.getShareTitle()     // Catch:{ Exception -> 0x007c }
            r4.setText(r0)     // Catch:{ Exception -> 0x007c }
            android.widget.TextView r4 = r3.textViewCircleShareDesc     // Catch:{ Exception -> 0x007c }
            com.huochat.community.model.CommunityItemBean r0 = r2.mCommunityItemBean     // Catch:{ Exception -> 0x007c }
            java.lang.String r0 = r0.getDetailTitle()     // Catch:{ Exception -> 0x007c }
            r4.setText(r0)     // Catch:{ Exception -> 0x007c }
            android.widget.TextView r3 = r3.textViewCircleShareDesc     // Catch:{ Exception -> 0x007c }
            com.huochat.community.model.CommunityItemBean r4 = r2.mCommunityItemBean     // Catch:{ Exception -> 0x007c }
            java.lang.String r4 = r4.getDetailTitle()     // Catch:{ Exception -> 0x007c }
            r0 = 0
            if (r4 == 0) goto L_0x0038
            int r4 = r4.length()     // Catch:{ Exception -> 0x007c }
            if (r4 != 0) goto L_0x0036
            goto L_0x0038
        L_0x0036:
            r4 = r0
            goto L_0x0039
        L_0x0038:
            r4 = 1
        L_0x0039:
            r1 = 8
            if (r4 == 0) goto L_0x003f
            r4 = r1
            goto L_0x0040
        L_0x003f:
            r4 = r0
        L_0x0040:
            r3.setVisibility(r4)     // Catch:{ Exception -> 0x007c }
            com.huochat.community.model.CommunityItemBean r3 = r2.mCommunityItemBean     // Catch:{ Exception -> 0x007c }
            java.lang.String r3 = r3.getShowPrice()     // Catch:{ Exception -> 0x007c }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x007c }
            if (r3 == 0) goto L_0x0055
            android.widget.TextView r3 = r2.textViewCircleShareContent     // Catch:{ Exception -> 0x007c }
            r3.setVisibility(r1)     // Catch:{ Exception -> 0x007c }
            goto L_0x0076
        L_0x0055:
            android.widget.TextView r3 = r2.textViewCircleShareContent     // Catch:{ Exception -> 0x007c }
            r3.setVisibility(r0)     // Catch:{ Exception -> 0x007c }
            android.widget.TextView r3 = r2.textViewCircleShareContent     // Catch:{ Exception -> 0x007c }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007c }
            r4.<init>()     // Catch:{ Exception -> 0x007c }
            java.lang.String r0 = "HCT积分单价: "
            r4.append(r0)     // Catch:{ Exception -> 0x007c }
            com.huochat.community.model.CommunityItemBean r0 = r2.mCommunityItemBean     // Catch:{ Exception -> 0x007c }
            java.lang.String r0 = r0.getShowPrice()     // Catch:{ Exception -> 0x007c }
            r4.append(r0)     // Catch:{ Exception -> 0x007c }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x007c }
            r3.setText(r4)     // Catch:{ Exception -> 0x007c }
        L_0x0076:
            android.widget.TextView r3 = r2.textViewCircleShareDescMore     // Catch:{ Exception -> 0x007c }
            r3.setVisibility(r1)     // Catch:{ Exception -> 0x007c }
            goto L_0x0080
        L_0x007c:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0080:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huochat.community.viewholder.CommunityHolder.fillShareData(com.huochat.community.viewholder.CommunityHolder, com.huochat.community.model.MomentType):void");
    }

    public final void foldOrExpandTranslate(boolean z11) {
        String str = null;
        if (z11) {
            ImageView ivContentTranslateArrow2 = getIvContentTranslateArrow();
            if (ivContentTranslateArrow2 != null) {
                ivContentTranslateArrow2.setRotation(0.0f);
            }
            View vTranslateDivider2 = getVTranslateDivider();
            if (vTranslateDivider2 != null) {
                vTranslateDivider2.setVisibility(0);
            }
            TextView tvContentTranslate2 = getTvContentTranslate();
            if (tvContentTranslate2 != null) {
                tvContentTranslate2.setVisibility(0);
            }
            TextView tvContentTranslateHint2 = getTvContentTranslateHint();
            if (tvContentTranslateHint2 != null) {
                Activity mActivity2 = getMActivity();
                if (mActivity2 != null) {
                    str = mActivity2.getString(R.string.community_content_translate_fold_hint);
                }
                tvContentTranslateHint2.setText(str);
                return;
            }
            return;
        }
        ImageView ivContentTranslateArrow3 = getIvContentTranslateArrow();
        if (ivContentTranslateArrow3 != null) {
            ivContentTranslateArrow3.setRotation(180.0f);
        }
        View vTranslateDivider3 = getVTranslateDivider();
        if (vTranslateDivider3 != null) {
            vTranslateDivider3.setVisibility(8);
        }
        TextView tvContentTranslate3 = getTvContentTranslate();
        if (tvContentTranslate3 != null) {
            tvContentTranslate3.setVisibility(8);
        }
        TextView tvContentTranslateHint3 = getTvContentTranslateHint();
        if (tvContentTranslateHint3 != null) {
            Activity mActivity3 = getMActivity();
            if (mActivity3 != null) {
                str = mActivity3.getString(R.string.community_content_translate_unfold_hint);
            }
            tvContentTranslateHint3.setText(str);
        }
    }

    public final CommentListAdapter getCommentListAdapter() {
        return this.commentListAdapter;
    }

    public final CommunityFromListAdapter getCommunityFromListAdapter() {
        return this.communityFromListAdapter;
    }

    public final ExpandableTextView getExpandTextViewMomentText() {
        return this.expandTextViewMomentText;
    }

    public final ViewGroup getFlIdentyLinkImagesContainer() {
        return this.flIdentyLinkImagesContainer;
    }

    public final int getImageRadius() {
        return this.imageRadius;
    }

    public final ImageView getImageViewCircleHot() {
        return this.imageViewCircleHot;
    }

    public final ImageView getImageViewCircleShareThumbnail() {
        return this.imageViewCircleShareThumbnail;
    }

    public final ImageView getImageViewCircleVip() {
        return this.imageViewCircleVip;
    }

    public final View getItemCommunityListDetailView() {
        return this.itemCommunityListDetailView;
    }

    public final View getItemCommunityListTopView() {
        return this.itemCommunityListTopView;
    }

    public final ImageView getIvCircleCommentImg() {
        return this.ivCircleCommentImg;
    }

    public final ImageView getIvCircleLikeImg() {
        return this.ivCircleLikeImg;
    }

    public final ImageView getIvCircleMoreOprate() {
        return this.ivCircleMoreOprate;
    }

    public final ImageView getIvCircleRedPacket() {
        return this.ivCircleRedPacket;
    }

    public final ImageView getIvCircleShareImg() {
        return this.ivCircleShareImg;
    }

    public final ImageView getIvContentTranslateArrow() {
        return this.ivContentTranslateArrow;
    }

    public final String getLargeImageDisplayUrl(String str) {
        if (TextUtils.isEmpty(str) || !StringsKt__StringsJVMKt.M(str, "http", false, 2, (Object) null)) {
            return str;
        }
        return str + "?style=st5";
    }

    public final LinearLayout getLinearLayoutItemRoot() {
        return this.linearLayoutItemRoot;
    }

    public final View getLlBrowseLocation() {
        return this.llBrowseLocation;
    }

    public final View getLlCommentPanel() {
        return this.llCommentPanel;
    }

    public final LinearLayout getLlContentTranslateHint() {
        return this.llContentTranslateHint;
    }

    public final LinearLayout getLlImagesBoxContainer() {
        return this.llImagesBoxContainer;
    }

    public final View getLlRedPacketMarkContainer() {
        return this.llRedPacketMarkContainer;
    }

    public final Activity getMActivity() {
        return this.mActivity;
    }

    public final CommunityItemBean getMCommunityItemBean() {
        return this.mCommunityItemBean;
    }

    public final int getMImageMaxWidth() {
        return this.mImageMaxWidth;
    }

    public final boolean getMIsContentExpandable() {
        return this.mIsContentExpandable;
    }

    public final boolean getMIsListItemView() {
        return this.mIsListItemView;
    }

    public final boolean getMIsShowBottomOpratePanel() {
        return this.mIsShowBottomOpratePanel;
    }

    public final boolean getMIsShowCommentListPanel() {
        return this.mIsShowCommentListPanel;
    }

    public final boolean getMIsShowCommunityFromPanel() {
        return this.mIsShowCommunityFromPanel;
    }

    public final boolean getMIsShowContentFromTag() {
        return this.mIsShowContentFromTag;
    }

    public final boolean getMIsShowDynamicTitle() {
        return this.mIsShowDynamicTitle;
    }

    public final boolean getMIsShowTranslationContext() {
        return this.mIsShowTranslationContext;
    }

    public final View getMItemView() {
        return this.mItemView;
    }

    public final CommunityItemBean getMOldCommunityItemBean() {
        return this.mOldCommunityItemBean;
    }

    public final OnHolderTouchListener getMOnHolderTouchListener() {
        return this.mOnHolderTouchListener;
    }

    public final List<ImageView> getNineGridImageViews() {
        return this.nineGridImageViews;
    }

    public final View getRelativeLayoutShareContent() {
        return this.relativeLayoutShareContent;
    }

    public final View getRlCircleCommentClk() {
        return this.rlCircleCommentClk;
    }

    public final View getRlCircleLikeClk() {
        return this.rlCircleLikeClk;
    }

    public final View getRlCircleShareClk() {
        return this.rlCircleShareClk;
    }

    public final View getRlSharelikercommentContainer() {
        return this.rlSharelikercommentContainer;
    }

    public final RecyclerView getRlvCommentList() {
        return this.rlvCommentList;
    }

    public final RecyclerView getRlvCommunityFromList() {
        return this.rlvCommunityFromList;
    }

    public final String getSSymbol() {
        return this.sSymbol;
    }

    public final int getScreemWidth() {
        return this.screemWidth;
    }

    public final TextView getTextViewCircleShareContent() {
        return this.textViewCircleShareContent;
    }

    public final TextView getTextViewCircleShareDesc() {
        return this.textViewCircleShareDesc;
    }

    public final TextView getTextViewCircleShareDescMore() {
        return this.textViewCircleShareDescMore;
    }

    public final TextView getTextViewCircleShareTitle() {
        return this.textViewCircleShareTitle;
    }

    public final TextView getTextViewCircleUserTag() {
        return this.textViewCircleUserTag;
    }

    public final TextView getTvCircleComment() {
        return this.tvCircleComment;
    }

    public final TextView getTvCircleLike() {
        return this.tvCircleLike;
    }

    public final TextView getTvCircleMsgDate() {
        return this.tvCircleMsgDate;
    }

    public final TextView getTvCircleMsgDelete() {
        return this.tvCircleMsgDelete;
    }

    public final TextView getTvCircleMsgFrom() {
        return this.tvCircleMsgFrom;
    }

    public final TextView getTvCircleMsgType() {
        return this.tvCircleMsgType;
    }

    public final TextView getTvCircleShare() {
        return this.tvCircleShare;
    }

    public final TextView getTvCircleUsername() {
        return this.tvCircleUsername;
    }

    public final TextView getTvCommentMoreTips() {
        return this.tvCommentMoreTips;
    }

    public final TextView getTvCommunityMomentTag() {
        return this.tvCommunityMomentTag;
    }

    public final TextView getTvContentTranslate() {
        return this.tvContentTranslate;
    }

    public final TextView getTvContentTranslateHint() {
        return this.tvContentTranslateHint;
    }

    public final TextView getTvRedPacketStatus() {
        return this.tvRedPacketStatus;
    }

    public final UserLogoView getUserLogoViewCircleAvatar() {
        return this.userLogoViewCircleAvatar;
    }

    public final View getVLine1() {
        return this.vLine1;
    }

    public final View getVLine2() {
        return this.vLine2;
    }

    public final View getVListDividingLine() {
        return this.vListDividingLine;
    }

    public final View getVTranslateDivider() {
        return this.vTranslateDivider;
    }

    public final View getViewBottomLine() {
        return this.viewBottomLine;
    }

    public final View getViewPartMomentListBottom() {
        return this.viewPartMomentListBottom;
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00e8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void loadNineGridImages(android.app.Activity r19, java.util.List<java.lang.String> r20, int r21) {
        /*
            r18 = this;
            r6 = r18
            r7 = r19
            r8 = r21
            com.huochat.community.model.CommunityItemBean r9 = r6.mCommunityItemBean
            android.widget.LinearLayout r0 = r6.llImagesBoxContainer
            if (r0 == 0) goto L_0x0015
            int r1 = com.huochat.community.R.id.tvLongImage
            android.view.View r0 = r0.findViewById(r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            goto L_0x0016
        L_0x0015:
            r0 = 0
        L_0x0016:
            if (r0 != 0) goto L_0x0019
            goto L_0x001e
        L_0x0019:
            r1 = 8
            r0.setVisibility(r1)
        L_0x001e:
            r11 = 1075838976(0x40200000, float:2.5)
            r12 = 1
            r0 = 0
            if (r8 != r12) goto L_0x00f6
            java.util.List r1 = r9.getSizes()
            if (r1 == 0) goto L_0x00f6
            java.util.List r1 = r9.getSizes()
            int r1 = r1.size()
            if (r1 != r12) goto L_0x00f6
            java.util.List r1 = r9.getSizes()
            java.lang.Object r1 = r1.get(r0)
            com.huochat.community.model.Size r1 = (com.huochat.community.model.Size) r1
            int r2 = r1.getWidth()
            int r1 = r1.getHeight()
            int r3 = r6.mImageMaxWidth
            if (r3 >= r12) goto L_0x0075
            android.widget.LinearLayout r3 = r6.llImagesBoxContainer
            if (r3 == 0) goto L_0x0053
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            goto L_0x0054
        L_0x0053:
            r3 = 0
        L_0x0054:
            if (r3 != 0) goto L_0x0057
            goto L_0x005a
        L_0x0057:
            r4 = -1
            r3.width = r4
        L_0x005a:
            android.widget.LinearLayout r4 = r6.llImagesBoxContainer
            if (r4 != 0) goto L_0x005f
            goto L_0x0062
        L_0x005f:
            r4.setLayoutParams(r3)
        L_0x0062:
            android.widget.LinearLayout r3 = r6.llImagesBoxContainer
            if (r3 == 0) goto L_0x0069
            r3.measure(r0, r0)
        L_0x0069:
            android.widget.LinearLayout r3 = r6.llImagesBoxContainer
            if (r3 == 0) goto L_0x0072
            int r3 = r3.getMeasuredWidth()
            goto L_0x0073
        L_0x0072:
            r3 = r0
        L_0x0073:
            r6.mImageMaxWidth = r3
        L_0x0075:
            float r3 = r6.mImageMaxHeight
            int r3 = com.huochat.community.util.DisplayTool.dp2px(r3)
            float r4 = r6.mImageMinHeight
            int r4 = com.huochat.community.util.DisplayTool.dp2px(r4)
            float r5 = r6.mLargeImageWidth
            int r5 = com.huochat.community.util.DisplayTool.dp2px(r5)
            java.util.List<android.widget.ImageView> r13 = r6.nineGridImageViews
            if (r13 == 0) goto L_0x0092
            java.lang.Object r13 = r13.get(r0)
            android.widget.ImageView r13 = (android.widget.ImageView) r13
            goto L_0x0093
        L_0x0092:
            r13 = 0
        L_0x0093:
            float r14 = (float) r1
            float r15 = (float) r2
            float r16 = r15 * r11
            int r16 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r16 < 0) goto L_0x00c1
            if (r13 == 0) goto L_0x00aa
            android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_START
            r13.setScaleType(r1)
            android.view.ViewGroup$LayoutParams r1 = r13.getLayoutParams()
            r1.width = r5
            r1.height = r3
        L_0x00aa:
            android.widget.LinearLayout r1 = r6.llImagesBoxContainer
            if (r1 == 0) goto L_0x00b7
            int r2 = com.huochat.community.R.id.tvLongImage
            android.view.View r1 = r1.findViewById(r2)
            android.widget.TextView r1 = (android.widget.TextView) r1
            goto L_0x00b8
        L_0x00b7:
            r1 = 0
        L_0x00b8:
            if (r1 != 0) goto L_0x00bc
            goto L_0x012f
        L_0x00bc:
            r1.setVisibility(r0)
            goto L_0x012f
        L_0x00c1:
            float r5 = r15 / r14
            float r10 = (float) r4
            float r11 = (float) r3
            float r17 = r10 / r11
            int r5 = (r5 > r17 ? 1 : (r5 == r17 ? 0 : -1))
            if (r5 > 0) goto L_0x00ce
            r1 = r3
        L_0x00cc:
            r2 = r4
            goto L_0x00da
        L_0x00ce:
            if (r2 >= r4) goto L_0x00d4
            float r14 = r14 * r10
            float r14 = r14 / r15
            int r1 = (int) r14
            goto L_0x00cc
        L_0x00d4:
            if (r1 <= r3) goto L_0x00da
            float r15 = r15 * r11
            float r15 = r15 / r14
            int r2 = (int) r15
            r1 = r3
        L_0x00da:
            int r3 = r6.screemWidth
            if (r12 > r3) goto L_0x00e2
            if (r3 >= r2) goto L_0x00e2
            r4 = r12
            goto L_0x00e3
        L_0x00e2:
            r4 = r0
        L_0x00e3:
            if (r4 == 0) goto L_0x00e6
            r2 = r3
        L_0x00e6:
            if (r13 == 0) goto L_0x012f
            android.widget.ImageView$ScaleType r3 = android.widget.ImageView.ScaleType.CENTER_CROP
            r13.setScaleType(r3)
            android.view.ViewGroup$LayoutParams r3 = r13.getLayoutParams()
            r3.width = r2
            r3.height = r1
            goto L_0x012f
        L_0x00f6:
            if (r8 != r12) goto L_0x012f
            java.util.List r1 = r9.getSizes()
            if (r1 == 0) goto L_0x0107
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0105
            goto L_0x0107
        L_0x0105:
            r1 = r0
            goto L_0x0108
        L_0x0107:
            r1 = r12
        L_0x0108:
            if (r1 == 0) goto L_0x012f
            java.util.List<android.widget.ImageView> r1 = r6.nineGridImageViews
            if (r1 == 0) goto L_0x0115
            java.lang.Object r1 = r1.get(r0)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            goto L_0x0116
        L_0x0115:
            r1 = 0
        L_0x0116:
            if (r1 == 0) goto L_0x012f
            android.view.ViewGroup$LayoutParams r2 = r1.getLayoutParams()
            r3 = -2
            r2.width = r3
            r3 = 1130233856(0x435e0000, float:222.0)
            int r3 = com.huochat.community.util.DisplayTool.dp2px(r3)
            r2.height = r3
            r1.setLayoutParams(r2)
            android.widget.ImageView$ScaleType r2 = android.widget.ImageView.ScaleType.CENTER_CROP
            r1.setScaleType(r2)
        L_0x012f:
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            androidx.core.util.c[] r11 = new androidx.core.util.c[r8]
            r13 = r0
        L_0x0137:
            if (r13 >= r8) goto L_0x01e4
            java.util.List<android.widget.ImageView> r0 = r6.nineGridImageViews
            if (r0 == 0) goto L_0x0145
            java.lang.Object r0 = r0.get(r13)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r5 = r0
            goto L_0x0146
        L_0x0145:
            r5 = 0
        L_0x0146:
            if (r5 == 0) goto L_0x01dc
            com.huochat.community.CommunityManager$Companion r0 = com.huochat.community.CommunityManager.Companion
            com.huochat.community.CommunityManager r0 = r0.getInstance()
            boolean r0 = r0.isNightModel()
            if (r0 == 0) goto L_0x015a
            int r0 = com.huochat.community.R.drawable.bg_image_load_def_night
            r5.setBackgroundResource(r0)
            goto L_0x015f
        L_0x015a:
            int r0 = com.huochat.community.R.drawable.bg_image_load_def_light
            r5.setBackgroundResource(r0)
        L_0x015f:
            r14 = r20
            java.lang.Object r0 = r14.get(r13)
            r2 = r0
            java.lang.String r2 = (java.lang.String) r2
            com.huochat.community.model.MediaBean r0 = new com.huochat.community.model.MediaBean
            r0.<init>()
            r0.type = r12
            r0.imageUrl = r2
            if (r9 == 0) goto L_0x0178
            java.util.List r1 = r9.getSizes()
            goto L_0x0179
        L_0x0178:
            r1 = 0
        L_0x0179:
            if (r1 == 0) goto L_0x01a7
            java.util.List r1 = r9.getSizes()
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x01a7
            java.util.List r1 = r9.getSizes()
            int r1 = r1.size()
            if (r13 >= r1) goto L_0x01a7
            java.util.List r1 = r9.getSizes()
            java.lang.Object r1 = r1.get(r13)
            com.huochat.community.model.Size r1 = (com.huochat.community.model.Size) r1
            if (r1 == 0) goto L_0x01a7
            int r3 = r1.getWidth()
            r0.width = r3
            int r1 = r1.getHeight()
            r0.height = r1
        L_0x01a7:
            r10.add(r0)
            int r1 = r0.height
            float r1 = (float) r1
            int r0 = r0.width
            float r0 = (float) r0
            r15 = 1075838976(0x40200000, float:2.5)
            float r0 = r0 * r15
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 < 0) goto L_0x01c2
            com.huochat.community.util.ImageLoadedrManager r0 = com.huochat.community.util.ImageLoadedrManager.getInstance()
            java.lang.String r1 = r6.getLargeImageDisplayUrl(r2)
            r0.preloadFile(r7, r1)
        L_0x01c2:
            androidx.core.util.c r0 = new androidx.core.util.c
            r0.<init>(r5, r2)
            r11[r13] = r0
            tv.a r0 = new tv.a
            r0.<init>(r7, r11, r10, r13)
            r5.setOnClickListener(r0)
            r0 = r18
            r1 = r19
            r3 = r21
            r4 = r13
            r0.displayImage(r1, r2, r3, r4, r5)
            goto L_0x01e0
        L_0x01dc:
            r14 = r20
            r15 = 1075838976(0x40200000, float:2.5)
        L_0x01e0:
            int r13 = r13 + 1
            goto L_0x0137
        L_0x01e4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huochat.community.viewholder.CommunityHolder.loadNineGridImages(android.app.Activity, java.util.List, int):void");
    }

    public final void notifyThemeChanged() {
        this.communityThemeColor = CommunityManager.Companion.getInstance().getCommunityThemeColor();
        initThemeColor();
    }

    public final void openWebView() {
        removeFullExpandableTextViewLongClickEvent();
        String shareTitle = this.mCommunityItemBean.getShareTitle();
        openWebView(this.mActivity, this.mCommunityItemBean.getSharelink(), shareTitle, (String) null, false);
    }

    public final void refershCircleItemInfo(CommunityItemBean communityItemBean) {
        if (communityItemBean != null) {
            CommunityItemBean communityItemBean2 = this.mCommunityItemBean;
            if (communityItemBean2 == null || x.b(communityItemBean2.getMid(), communityItemBean.getMid())) {
                this.mOldCommunityItemBean = communityItemBean;
                this.mCommunityItemBean = communityItemBean;
            }
        }
    }

    public final void refreshCommentPanelInfo(List<CommentItemBean> list, boolean z11) {
        if (this.llCommentPanel != null) {
            int i11 = 8;
            if (list == null || list.isEmpty()) {
                CommentListAdapter commentListAdapter2 = this.commentListAdapter;
                if (commentListAdapter2 != null) {
                    commentListAdapter2.resetData(CollectionsKt__CollectionsKt.k());
                }
                this.llCommentPanel.setVisibility(8);
            } else if (!this.mIsShowCommentListPanel) {
                this.llCommentPanel.setVisibility(8);
            } else {
                this.llCommentPanel.setVisibility(0);
                TextView textView = this.tvCommentMoreTips;
                if (textView != null) {
                    if (z11) {
                        i11 = 0;
                    }
                    textView.setVisibility(i11);
                }
                CommentListAdapter commentListAdapter3 = this.commentListAdapter;
                if (commentListAdapter3 != null) {
                    int size = list.size();
                    List<T> list2 = list;
                    if (size > 4) {
                        list2 = CollectorsTool.subList(list, 0, 4);
                    }
                    commentListAdapter3.resetData(list2);
                }
            }
        }
    }

    public final void refreshOperaterStateData(CommunityItemBean communityItemBean) {
        String str;
        String str2;
        String str3;
        if (communityItemBean != null) {
            TextView textView = this.tvCircleShare;
            if (textView != null) {
                if (communityItemBean.getForwardCount() <= 0) {
                    str3 = BaseApplication.b().getResources().getString(R.string.text_shared);
                } else {
                    str3 = NumberTool.getSimpleShorthandNumber(communityItemBean.getForwardCount());
                }
                textView.setText(str3);
            }
            TextView textView2 = this.tvCircleComment;
            if (textView2 != null) {
                if (communityItemBean.getCommentCount() <= 0) {
                    str2 = BaseApplication.b().getResources().getString(R.string.text_comment);
                } else {
                    str2 = NumberTool.getSimpleShorthandNumber(communityItemBean.getCommentCount());
                }
                textView2.setText(str2);
            }
            if (this.tvCircleLike != null && this.ivCircleLikeImg != null) {
                if (communityItemBean.getSelfLike() == 1) {
                    this.tvCircleLike.setTextColor(Color.parseColor("#FFBE00"));
                    ImageView imageView = this.ivCircleLikeImg;
                    if (imageView != null) {
                        imageView.setColorFilter(Color.parseColor("#FFBE00"));
                    }
                    this.ivCircleLikeImg.setImageResource(R.drawable.ic_community_holder_like_pressed);
                } else {
                    this.tvCircleLike.setTextColor(this.communityThemeColor.getPraiseIconTextColor());
                    ImageView imageView2 = this.ivCircleLikeImg;
                    if (imageView2 != null) {
                        imageView2.setColorFilter(this.communityThemeColor.getPraiseIconTextColor());
                    }
                    this.ivCircleLikeImg.setImageResource(R.drawable.ic_community_holder_like_normal);
                }
                TextView textView3 = this.tvCircleLike;
                if (communityItemBean.getLikeCount() <= 0) {
                    str = BaseApplication.b().getResources().getString(R.string.text_praise);
                } else {
                    str = NumberTool.getSimpleShorthandNumber(communityItemBean.getLikeCount());
                }
                textView3.setText(str);
            }
        }
    }

    public final void removeFullExpandableTextViewLongClickEvent() {
        ExpandableTextView expandableTextView = this.expandTextViewMomentText;
        if (expandableTextView != null && expandableTextView.getHandler() != null) {
            this.expandTextViewMomentText.getHandler().removeCallbacksAndMessages((Object) null);
        }
    }

    public final void setBottomLineVisibility(boolean z11) {
        if (z11) {
            View view = this.viewBottomLine;
            if (view != null) {
                view.setBackgroundColor(this.communityThemeColor.getListDividingLineColor());
                return;
            }
            return;
        }
        View view2 = this.viewBottomLine;
        if (view2 != null) {
            view2.setBackgroundColor(0);
        }
    }

    public final void setCommentListAdapter(CommentListAdapter commentListAdapter2) {
        this.commentListAdapter = commentListAdapter2;
    }

    public final void setCommunityFromListAdapter(CommunityFromListAdapter communityFromListAdapter2) {
        this.communityFromListAdapter = communityFromListAdapter2;
    }

    public final void setDefExpandableTextWidth(int i11) {
        this.mDefExpandableTextWidth = i11;
    }

    public final void setExpandTextViewMomentText(ExpandableTextView expandableTextView) {
        this.expandTextViewMomentText = expandableTextView;
    }

    public final void setFlIdentyLinkImagesContainer(ViewGroup viewGroup) {
        this.flIdentyLinkImagesContainer = viewGroup;
    }

    public final void setImageViewCircleHot(ImageView imageView) {
        this.imageViewCircleHot = imageView;
    }

    public final void setImageViewCircleShareThumbnail(ImageView imageView) {
        this.imageViewCircleShareThumbnail = imageView;
    }

    public final void setImageViewCircleVip(ImageView imageView) {
        this.imageViewCircleVip = imageView;
    }

    public final void setItemCommunityListDetailView(View view) {
        this.itemCommunityListDetailView = view;
    }

    public final void setItemCommunityListTopView(View view) {
        this.itemCommunityListTopView = view;
    }

    public final void setIvCircleCommentImg(ImageView imageView) {
        this.ivCircleCommentImg = imageView;
    }

    public final void setIvCircleLikeImg(ImageView imageView) {
        this.ivCircleLikeImg = imageView;
    }

    public final void setIvCircleMoreOprate(ImageView imageView) {
        this.ivCircleMoreOprate = imageView;
    }

    public final void setIvCircleRedPacket(ImageView imageView) {
        this.ivCircleRedPacket = imageView;
    }

    public final void setIvCircleShareImg(ImageView imageView) {
        this.ivCircleShareImg = imageView;
    }

    public final void setIvContentTranslateArrow(ImageView imageView) {
        this.ivContentTranslateArrow = imageView;
    }

    public final void setLinearLayoutItemRoot(LinearLayout linearLayout) {
        this.linearLayoutItemRoot = linearLayout;
    }

    public final void setLlBrowseLocation(View view) {
        this.llBrowseLocation = view;
    }

    public final void setLlCommentPanel(View view) {
        this.llCommentPanel = view;
    }

    public final void setLlContentTranslateHint(LinearLayout linearLayout) {
        this.llContentTranslateHint = linearLayout;
    }

    public final void setLlImagesBoxContainer(LinearLayout linearLayout) {
        this.llImagesBoxContainer = linearLayout;
    }

    public final void setLlRedPacketMarkContainer(View view) {
        this.llRedPacketMarkContainer = view;
    }

    public final void setMActivity(Activity activity) {
        this.mActivity = activity;
    }

    public final void setMCommunityItemBean(CommunityItemBean communityItemBean) {
        this.mCommunityItemBean = communityItemBean;
    }

    public final void setMImageMaxWidth(int i11) {
        this.mImageMaxWidth = i11;
    }

    public final void setMIsContentExpandable(boolean z11) {
        this.mIsContentExpandable = z11;
    }

    public final void setMIsListItemView(boolean z11) {
        this.mIsListItemView = z11;
    }

    public final void setMIsShowBottomOpratePanel(boolean z11) {
        this.mIsShowBottomOpratePanel = z11;
    }

    public final void setMIsShowCommentListPanel(boolean z11) {
        this.mIsShowCommentListPanel = z11;
    }

    public final void setMIsShowCommunityFromPanel(boolean z11) {
        this.mIsShowCommunityFromPanel = z11;
    }

    public final void setMIsShowContentFromTag(boolean z11) {
        this.mIsShowContentFromTag = z11;
    }

    public final void setMIsShowDynamicTitle(boolean z11) {
        this.mIsShowDynamicTitle = z11;
    }

    public final void setMIsShowTranslationContext(boolean z11) {
        this.mIsShowTranslationContext = z11;
    }

    public final void setMItemView(View view) {
        this.mItemView = view;
    }

    public final void setMOldCommunityItemBean(CommunityItemBean communityItemBean) {
        this.mOldCommunityItemBean = communityItemBean;
    }

    public final void setMOnHolderTouchListener(OnHolderTouchListener onHolderTouchListener) {
        this.mOnHolderTouchListener = onHolderTouchListener;
    }

    public final void setNineGridImageViews(List<ImageView> list) {
        this.nineGridImageViews = list;
    }

    public final void setOnCommentClick(OnCommentClickListener onCommentClickListener2) {
        this.onCommentClickListener = onCommentClickListener2;
    }

    public final void setOnCommunityDataChangedListener(OnCommunityDataChangedListener onCommunityDataChangedListener2) {
        this.onCommunityDataChangedListener = onCommunityDataChangedListener2;
    }

    public final void setOnHolderTouchListener(OnHolderTouchListener onHolderTouchListener) {
        this.mOnHolderTouchListener = onHolderTouchListener;
    }

    public final void setOperationClick(OnCommunityOperationClickListener onCommunityOperationClickListener) {
        this.operationClickListener = onCommunityOperationClickListener;
    }

    public final void setRelativeLayoutShareContent(View view) {
        this.relativeLayoutShareContent = view;
    }

    public final void setRlCircleCommentClk(View view) {
        this.rlCircleCommentClk = view;
    }

    public final void setRlCircleLikeClk(View view) {
        this.rlCircleLikeClk = view;
    }

    public final void setRlCircleShareClk(View view) {
        this.rlCircleShareClk = view;
    }

    public final void setRlSharelikercommentContainer(View view) {
        this.rlSharelikercommentContainer = view;
    }

    public final void setRlvCommentList(RecyclerView recyclerView) {
        this.rlvCommentList = recyclerView;
    }

    public final void setRlvCommunityFromList(RecyclerView recyclerView) {
        this.rlvCommunityFromList = recyclerView;
    }

    public final void setSSymbol(String str) {
        this.sSymbol = str;
    }

    public final void setScreemWidth(int i11) {
        this.screemWidth = i11;
    }

    public final void setShowBottomOpratePanel(boolean z11) {
        this.mIsShowBottomOpratePanel = z11;
        View view = this.viewPartMomentListBottom;
        if (view != null) {
            view.setVisibility(z11 ? 0 : 8);
        }
    }

    public final void setShowBrowerLocationView(boolean z11) {
        View view = this.llBrowseLocation;
        if (view != null) {
            view.setVisibility(z11 ? 0 : 8);
        }
    }

    public final void setSymbolParams(String str, SymbolParamType symbolParamType2) {
        this.communitySymbol = str;
        this.symbolParamType = symbolParamType2;
    }

    public final void setTextViewCircleShareContent(TextView textView) {
        this.textViewCircleShareContent = textView;
    }

    public final void setTextViewCircleShareDesc(TextView textView) {
        this.textViewCircleShareDesc = textView;
    }

    public final void setTextViewCircleShareDescMore(TextView textView) {
        this.textViewCircleShareDescMore = textView;
    }

    public final void setTextViewCircleShareTitle(TextView textView) {
        this.textViewCircleShareTitle = textView;
    }

    public final void setTextViewCircleUserTag(TextView textView) {
        this.textViewCircleUserTag = textView;
    }

    public final void setTvCircleComment(TextView textView) {
        this.tvCircleComment = textView;
    }

    public final void setTvCircleLike(TextView textView) {
        this.tvCircleLike = textView;
    }

    public final void setTvCircleMsgDate(TextView textView) {
        this.tvCircleMsgDate = textView;
    }

    public final void setTvCircleMsgDelete(TextView textView) {
        this.tvCircleMsgDelete = textView;
    }

    public final void setTvCircleMsgFrom(TextView textView) {
        this.tvCircleMsgFrom = textView;
    }

    public final void setTvCircleMsgType(TextView textView) {
        this.tvCircleMsgType = textView;
    }

    public final void setTvCircleShare(TextView textView) {
        this.tvCircleShare = textView;
    }

    public final void setTvCircleUsername(TextView textView) {
        this.tvCircleUsername = textView;
    }

    public final void setTvCommentMoreTips(TextView textView) {
        this.tvCommentMoreTips = textView;
    }

    public final void setTvCommunityMomentTag(TextView textView) {
        this.tvCommunityMomentTag = textView;
    }

    public final void setTvContentTranslate(TextView textView) {
        this.tvContentTranslate = textView;
    }

    public final void setTvContentTranslateHint(TextView textView) {
        this.tvContentTranslateHint = textView;
    }

    public final void setTvRedPacketStatus(TextView textView) {
        this.tvRedPacketStatus = textView;
    }

    public final void setUserLogoViewCircleAvatar(UserLogoView userLogoView) {
        this.userLogoViewCircleAvatar = userLogoView;
    }

    public final void setVLine1(View view) {
        this.vLine1 = view;
    }

    public final void setVLine2(View view) {
        this.vLine2 = view;
    }

    public final void setVListDividingLine(View view) {
        this.vListDividingLine = view;
    }

    public final void setVTranslateDivider(View view) {
        this.vTranslateDivider = view;
    }

    public final void setViewBottomLine(View view) {
        this.viewBottomLine = view;
    }

    public final void setViewPartMomentListBottom(View view) {
        this.viewPartMomentListBottom = view;
    }

    public final void openWebView(Activity activity, String str, String str2, String str3, boolean z11) {
        try {
            IntentSafeUtils.b(activity, str);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public CommunityHolder(Activity activity, View view) {
        this(activity, view, false);
        this.mIsListItemView = false;
        this.mIsShowCommunityFromPanel = false;
    }

    public CommunityHolder(Activity activity, View view, boolean z11) {
        this(activity, view, z11, false);
        this.mIsListItemView = z11;
        this.mIsShowCommunityFromPanel = false;
    }
}
