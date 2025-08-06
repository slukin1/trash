package com.huochat.community.widget.shareview;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huochat.community.CommunityThemeHelper;
import com.huochat.community.R;
import com.huochat.community.adapter.CommunityShareImageAdapter;
import com.huochat.community.model.CommunityItemBean;
import com.huochat.community.model.MomentType;
import com.huochat.community.model.Size;
import com.huochat.community.util.CollectionTool;
import com.huochat.community.util.DisplayTool;
import com.huochat.community.util.ImageLoadedrManager;
import com.huochat.community.widget.UserLogoView;
import com.huochat.community.widget.divider.Api21ItemDivider;
import java.util.ArrayList;
import java.util.List;

public final class CommunityDynamicShareView extends FrameLayout {
    private FrameLayout ffCommunityMoreContainer;
    private ImageView ivCommunityVipMark;
    private Context mContext;
    private boolean mHasLinkMessage;
    private CommunityShareImageAdapter mImageListAdapter;
    private List<Size> mImageSizeList;
    private List<String> mImageUrlList;
    private int mLayoutHeight;
    private int mLayoutWidth;
    private int mMaxHeight;
    private int mMaxWidth = DisplayTool.dp2px(320.0f);
    /* access modifiers changed from: private */
    public OnAfterInitCallback mOnAfterInitCallback;
    private final float mWHScale;
    private RelativeLayout rlBaseInfoContainer;
    private RelativeLayout rlContentContainer;
    private RelativeLayout rlShareRootContainer;
    private RecyclerView rlvImageContainerList;
    private TextView tvCommunityDynamicContent;
    private TextView tvCommunityShareAuth;
    private TextView tvCommunityShareHuochatId;
    private TextView tvCommunityShareNickname;
    private TextView tvWelcomeTips;
    private UserLogoView ulvCommunityShareAvatar;
    private View vGradientWhite;

    public interface OnAfterInitCallback {
        void callback(CommunityDynamicShareView communityDynamicShareView, boolean z11);
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(19:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|19) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.huochat.community.model.MomentType[] r0 = com.huochat.community.model.MomentType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.huochat.community.model.MomentType r1 = com.huochat.community.model.MomentType.MOMENT_OUT_SHARE_LINK     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.huochat.community.model.MomentType r1 = com.huochat.community.model.MomentType.MOMENT_EXCHANGE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.huochat.community.model.MomentType r1 = com.huochat.community.model.MomentType.MOMENT_PROJECT     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.huochat.community.model.MomentType r1 = com.huochat.community.model.MomentType.MOMENT_SCHOOL     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.huochat.community.model.MomentType r1 = com.huochat.community.model.MomentType.MOMENT_NEWS     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.huochat.community.model.MomentType r1 = com.huochat.community.model.MomentType.MOMENT_CLUB     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                com.huochat.community.model.MomentType r1 = com.huochat.community.model.MomentType.MOMENT_TEXT     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                com.huochat.community.model.MomentType r1 = com.huochat.community.model.MomentType.MOMENT_OUT_SHARE_IMAGE     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huochat.community.widget.shareview.CommunityDynamicShareView.WhenMappings.<clinit>():void");
        }
    }

    public CommunityDynamicShareView(Context context) {
        super(context);
        int dp2px = DisplayTool.dp2px(567.0f);
        this.mMaxHeight = dp2px;
        this.mWHScale = ((float) this.mMaxWidth) / ((float) dp2px);
        this.mLayoutWidth = -1;
        this.mLayoutHeight = -1;
        initView(context);
    }

    private final void initImageGridView(List<String> list, List<Size> list2) {
        RecyclerView.LayoutManager layoutManager;
        if (list == null || list.isEmpty()) {
            this.rlvImageContainerList.setVisibility(8);
            OnAfterInitCallback onAfterInitCallback = this.mOnAfterInitCallback;
            if (onAfterInitCallback != null) {
                onAfterInitCallback.callback(this, true);
                return;
            }
            return;
        }
        RecyclerView recyclerView = this.rlvImageContainerList;
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
            int size = list.size();
            Api21ItemDivider api21ItemDivider = new Api21ItemDivider(0, DisplayTool.dp2px(10.0f), 0);
            if (size > 1) {
                layoutManager = new GridLayoutManager(getContext(), this.mImageUrlList.size(), 1, false);
            } else {
                layoutManager = new LinearLayoutManager(getContext(), 0, false);
            }
            CommunityShareImageAdapter communityShareImageAdapter = new CommunityShareImageAdapter(this.mContext, this.mLayoutWidth);
            this.mImageListAdapter = communityShareImageAdapter;
            recyclerView.setAdapter(communityShareImageAdapter);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.addItemDecoration(api21ItemDivider);
            this.mImageListAdapter.setData(list, list2, this.mHasLinkMessage, new CommunityDynamicShareView$initImageGridView$1$1(this));
        }
    }

    private final LayoutInflater initInFlater() {
        return LayoutInflater.from(getContext()).cloneInContext(CommunityThemeHelper.Companion.getThemeContext(getContext()));
    }

    private final void initShareView(MomentType momentType, CommunityItemBean communityItemBean) {
        String str;
        boolean z11 = true;
        switch (WhenMappings.$EnumSwitchMapping$0[momentType.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                if (communityItemBean != null) {
                    if (!TextUtils.isEmpty(communityItemBean.getShareThumb()) || !TextUtils.isEmpty(communityItemBean.getShareTitle()) || !TextUtils.isEmpty(communityItemBean.getDetailTitle()) || !TextUtils.isEmpty(communityItemBean.getShowPrice())) {
                        this.mHasLinkMessage = true;
                        FrameLayout frameLayout = this.ffCommunityMoreContainer;
                        if (frameLayout != null) {
                            frameLayout.setVisibility(0);
                        }
                        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.view_share_community_content, (ViewGroup) null, false);
                        ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_circle_share_thumbnail);
                        TextView textView = (TextView) inflate.findViewById(R.id.tv_circle_share_title);
                        TextView textView2 = (TextView) inflate.findViewById(R.id.tv_circle_share_desc);
                        TextView textView3 = (TextView) inflate.findViewById(R.id.tv_circle_share_content);
                        int i11 = momentType.resouceId;
                        if (i11 == 0) {
                            ImageLoadedrManager.getInstance().display(getContext(), communityItemBean.getShareThumb(), imageView);
                        } else {
                            imageView.setImageResource(i11);
                        }
                        textView.setText(communityItemBean.getShareTitle());
                        textView2.setText(communityItemBean.getDetailTitle());
                        String detailTitle = communityItemBean.getDetailTitle();
                        textView2.setVisibility(detailTitle == null || detailTitle.length() == 0 ? 8 : 0);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams.gravity = 1;
                        if (TextUtils.isEmpty(communityItemBean.getShowPrice())) {
                            textView3.setVisibility(8);
                        } else {
                            textView3.setVisibility(0);
                            textView3.setText("HCT积分单价: " + communityItemBean.getShowPrice());
                        }
                        this.ffCommunityMoreContainer.addView(inflate, layoutParams);
                    } else {
                        this.mHasLinkMessage = false;
                        FrameLayout frameLayout2 = this.ffCommunityMoreContainer;
                        if (frameLayout2 != null) {
                            frameLayout2.setVisibility(8);
                        }
                        OnAfterInitCallback onAfterInitCallback = this.mOnAfterInitCallback;
                        if (onAfterInitCallback != null) {
                            onAfterInitCallback.callback(this, true);
                            return;
                        }
                        return;
                    }
                }
                OnAfterInitCallback onAfterInitCallback2 = this.mOnAfterInitCallback;
                if (onAfterInitCallback2 != null) {
                    onAfterInitCallback2.callback(this, true);
                    return;
                }
                return;
            case 8:
                initImageGridView(this.mImageUrlList, this.mImageSizeList);
                return;
            default:
                if (momentType == MomentType.MOMENT_CONTENT_LINK && communityItemBean != null) {
                    if (!TextUtils.isEmpty(communityItemBean.getShareThumb()) || !TextUtils.isEmpty(communityItemBean.getShareTitle()) || !TextUtils.isEmpty(communityItemBean.getDetailTitle()) || !TextUtils.isEmpty(communityItemBean.getShowPrice()) || !TextUtils.isEmpty(communityItemBean.getParseLink())) {
                        this.mHasLinkMessage = true;
                        FrameLayout frameLayout3 = this.ffCommunityMoreContainer;
                        if (frameLayout3 != null) {
                            frameLayout3.setVisibility(0);
                        }
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
                        layoutParams2.gravity = 1;
                        View inflate2 = LayoutInflater.from(getContext()).inflate(R.layout.view_moment_out_share_content, (ViewGroup) null, false);
                        FrameLayout frameLayout4 = this.ffCommunityMoreContainer;
                        if (frameLayout4 != null) {
                            frameLayout4.addView(inflate2, layoutParams2);
                        }
                        ImageView imageView2 = (ImageView) inflate2.findViewById(R.id.iv_circle_share_thumbnail);
                        TextView textView4 = (TextView) inflate2.findViewById(R.id.tv_circle_share_title);
                        int i12 = momentType.resouceId;
                        if (i12 == 0) {
                            ImageLoadedrManager.getInstance().display(getContext(), communityItemBean.getShareThumb(), imageView2);
                        } else {
                            imageView2.setImageResource(i12);
                        }
                        if (textView4 != null) {
                            String shareTitle = communityItemBean.getShareTitle();
                            if (!(shareTitle == null || shareTitle.length() == 0)) {
                                z11 = false;
                            }
                            if (z11) {
                                str = communityItemBean.getParseLink();
                            } else {
                                str = communityItemBean.getShareTitle();
                            }
                            textView4.setText(str);
                        }
                    } else {
                        this.mHasLinkMessage = false;
                        FrameLayout frameLayout5 = this.ffCommunityMoreContainer;
                        if (frameLayout5 != null) {
                            frameLayout5.setVisibility(8);
                        }
                        OnAfterInitCallback onAfterInitCallback3 = this.mOnAfterInitCallback;
                        if (onAfterInitCallback3 != null) {
                            onAfterInitCallback3.callback(this, true);
                            return;
                        }
                        return;
                    }
                }
                initImageGridView(this.mImageUrlList, this.mImageSizeList);
                return;
        }
    }

    private final void initView(Context context) {
        this.mContext = context;
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        View inflate = initInFlater().inflate(R.layout.layout_community_dynamic_share_view, this);
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.rl_share_root_container);
        this.rlShareRootContainer = relativeLayout;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) relativeLayout.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -2;
        this.rlShareRootContainer.setLayoutParams(layoutParams);
        this.rlBaseInfoContainer = (RelativeLayout) inflate.findViewById(R.id.rl_base_info_container);
        this.rlContentContainer = (RelativeLayout) inflate.findViewById(R.id.rl_content_container);
        this.ulvCommunityShareAvatar = (UserLogoView) inflate.findViewById(R.id.ulv_community_share_avatar);
        this.ivCommunityVipMark = (ImageView) inflate.findViewById(R.id.iv_community_vip_mark);
        this.tvCommunityShareNickname = (TextView) inflate.findViewById(R.id.tv_community_share_nickname);
        this.tvCommunityShareHuochatId = (TextView) inflate.findViewById(R.id.tv_community_share_huochat_id);
        this.tvCommunityShareAuth = (TextView) inflate.findViewById(R.id.tv_community_share_auth);
        this.tvCommunityDynamicContent = (TextView) inflate.findViewById(R.id.tv_community_dynamic_content);
        this.vGradientWhite = inflate.findViewById(R.id.v_gradient_white);
        this.rlvImageContainerList = (RecyclerView) inflate.findViewById(R.id.rlv_image_container_list);
        this.tvWelcomeTips = (TextView) inflate.findViewById(R.id.tv_welcome_tips);
        this.ffCommunityMoreContainer = (FrameLayout) inflate.findViewById(R.id.ff_community_more_container);
    }

    private final CommunityDynamicShareView setOnAfterInitCallback(OnAfterInitCallback onAfterInitCallback) {
        this.mOnAfterInitCallback = onAfterInitCallback;
        return this;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0094  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void adjustViewLayout() {
        /*
            r10 = this;
            android.widget.RelativeLayout r0 = r10.rlContentContainer
            int r0 = r0.getHeight()
            android.widget.RelativeLayout r1 = r10.rlBaseInfoContainer
            int r1 = r1.getHeight()
            r2 = 1093140480(0x41280000, float:10.5)
            int r2 = com.huochat.community.util.DisplayTool.dp2px(r2)
            int r1 = r1 + r2
            android.widget.TextView r2 = r10.tvWelcomeTips
            int r2 = r2.getHeight()
            r3 = 1056964608(0x3f000000, float:0.5)
            int r3 = com.huochat.community.util.DisplayTool.dp2px(r3)
            int r2 = r2 + r3
            boolean r3 = r10.mHasLinkMessage
            r4 = 0
            if (r3 == 0) goto L_0x002c
            android.widget.FrameLayout r3 = r10.ffCommunityMoreContainer
            int r3 = r3.getHeight()
            goto L_0x002d
        L_0x002c:
            r3 = r4
        L_0x002d:
            r5 = 1101004800(0x41a00000, float:20.0)
            int r6 = com.huochat.community.util.DisplayTool.dp2px(r5)
            java.util.List<java.lang.String> r7 = r10.mImageUrlList
            if (r7 == 0) goto L_0x007a
            boolean r8 = r7.isEmpty()
            r9 = 1
            r8 = r8 ^ r9
            if (r8 == 0) goto L_0x0046
            androidx.recyclerview.widget.RecyclerView r8 = r10.rlvImageContainerList
            int r8 = r8.getHeight()
            goto L_0x0047
        L_0x0046:
            r8 = r4
        L_0x0047:
            int r7 = r7.size()
            if (r7 == r9) goto L_0x0070
            r8 = 2
            if (r7 == r8) goto L_0x0061
            r8 = 3
            if (r7 == r8) goto L_0x0054
            goto L_0x007a
        L_0x0054:
            int r7 = r10.getMeasuredWidth()
            r9 = 1112014848(0x42480000, float:50.0)
            int r9 = com.huochat.community.util.DisplayTool.dp2px(r9)
            int r7 = r7 - r9
            int r7 = r7 / r8
            goto L_0x006d
        L_0x0061:
            int r7 = r10.getMeasuredWidth()
            r9 = 1109393408(0x42200000, float:40.0)
            int r9 = com.huochat.community.util.DisplayTool.dp2px(r9)
            int r7 = r7 - r9
            int r7 = r7 / r8
        L_0x006d:
            int r8 = r7 + r6
            goto L_0x007b
        L_0x0070:
            r6 = 1128792064(0x43480000, float:200.0)
            int r6 = com.huochat.community.util.DisplayTool.dp2px(r6)
            if (r8 <= r6) goto L_0x007b
            r8 = r6
            goto L_0x007b
        L_0x007a:
            r8 = r4
        L_0x007b:
            int r6 = r1 + r2
            int r6 = r6 + r3
            int r6 = r6 + r0
            int r6 = r6 + r8
            int r0 = r10.mMaxHeight
            r7 = -2
            if (r6 < r0) goto L_0x0091
            int r1 = r0 - r1
            int r1 = r1 - r2
            int r1 = r1 - r3
            int r1 = r1 - r8
            int r2 = com.huochat.community.util.DisplayTool.dp2px(r5)
            int r7 = r1 - r2
            goto L_0x0092
        L_0x0091:
            r0 = r7
        L_0x0092:
            if (r7 <= 0) goto L_0x00a7
            android.widget.TextView r1 = r10.tvCommunityDynamicContent
            int r1 = r1.getLineHeight()
            if (r1 <= 0) goto L_0x009d
            goto L_0x00a1
        L_0x009d:
            int r1 = com.huochat.community.util.DisplayTool.dp2px(r5)
        L_0x00a1:
            int r7 = r7 / r1
            android.widget.TextView r1 = r10.tvCommunityDynamicContent
            r1.setMaxLines(r7)
        L_0x00a7:
            androidx.recyclerview.widget.RecyclerView r1 = r10.rlvImageContainerList
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            r1.height = r8
            androidx.recyclerview.widget.RecyclerView r2 = r10.rlvImageContainerList
            r2.setLayoutParams(r1)
            android.view.ViewGroup$LayoutParams r1 = r10.getLayoutParams()
            r1.height = r0
            r10.setLayoutParams(r1)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r4)
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r4)
            r10.measure(r1, r2)
            int r1 = r10.getMeasuredWidth()
            r10.layout(r4, r4, r1, r0)
            int r1 = r10.getMeasuredWidth()
            r10.mLayoutWidth = r1
            r10.mLayoutHeight = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huochat.community.widget.shareview.CommunityDynamicShareView.adjustViewLayout():void");
    }

    public final int getMLayoutHeight() {
        return this.mLayoutHeight;
    }

    public final int getMLayoutWidth() {
        return this.mLayoutWidth;
    }

    public final float getMWHScale() {
        return this.mWHScale;
    }

    public final void onReMeasure() {
        measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
        this.mLayoutWidth = getMeasuredWidth();
        this.mLayoutHeight = getMeasuredHeight();
    }

    public final CommunityDynamicShareView setData(CommunityItemBean communityItemBean, OnAfterInitCallback onAfterInitCallback) {
        TextView textView;
        this.mOnAfterInitCallback = onAfterInitCallback;
        if (communityItemBean == null) {
            return this;
        }
        List<String> images = communityItemBean.getImages();
        int i11 = 0;
        int size = images != null ? images.size() : 0;
        List<T> list = null;
        List<T> subList = images != null ? CollectionTool.Companion.subList(images, 0, 3) : null;
        if (subList != null) {
            ArrayList arrayList = new ArrayList();
            this.mImageUrlList = arrayList;
            arrayList.addAll(subList);
            subList.clear();
        }
        List<Size> sizes = communityItemBean.getSizes();
        if (sizes != null) {
            list = CollectionTool.Companion.subList(sizes, 0, 3);
        }
        if (list != null) {
            ArrayList arrayList2 = new ArrayList();
            this.mImageSizeList = arrayList2;
            arrayList2.addAll(list);
            list.clear();
        }
        MomentType type = MomentType.getType((communityItemBean.getType() * 10) + size);
        if (MomentType.MOMENT_NONE != type) {
            UserLogoView userLogoView = this.ulvCommunityShareAvatar;
            if (userLogoView != null) {
                userLogoView.setData(communityItemBean.getHeadImage(), communityItemBean.getVFlag(), communityItemBean.getCrownType(), communityItemBean.getAuthType());
            }
            TextView textView2 = this.tvCommunityShareNickname;
            if (textView2 != null) {
                textView2.setText(communityItemBean.getUsername());
            }
            TextView textView3 = this.tvCommunityShareAuth;
            if (textView3 != null) {
                if (!TextUtils.isEmpty(communityItemBean.getUserCommunityLabel())) {
                    textView3.setText(communityItemBean.getUserCommunityLabel());
                    textView3.setVisibility(0);
                } else {
                    textView3.setText("");
                    textView3.setVisibility(8);
                }
            }
            String text = communityItemBean.getText();
            if (!(text == null || (textView = this.tvCommunityDynamicContent) == null)) {
                textView.setText(text);
            }
            RelativeLayout relativeLayout = this.rlContentContainer;
            String text2 = communityItemBean.getText();
            if (text2 == null || text2.length() == 0) {
                i11 = 8;
            }
            relativeLayout.setVisibility(i11);
        }
        initShareView(type, communityItemBean);
        return this;
    }

    public final void setMLayoutHeight(int i11) {
        this.mLayoutHeight = i11;
    }

    public final void setMLayoutWidth(int i11) {
        this.mLayoutWidth = i11;
    }

    public final CommunityDynamicShareView setMaxHeight(int i11) {
        if (i11 != 0) {
            this.mMaxHeight = i11;
            return this;
        }
        throw new Exception("Maximum height cannot be 0");
    }

    public final CommunityDynamicShareView setMaxWidth(int i11) {
        if (i11 != 0) {
            this.mMaxWidth = i11;
            return this;
        }
        throw new Exception("Maximum width cannot be 0");
    }

    public final CommunityDynamicShareView setViewWH(int i11, int i12) {
        this.mLayoutWidth = i11;
        this.mLayoutHeight = i12;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(i11, i12);
        } else {
            layoutParams.width = i11;
            layoutParams.height = i12;
        }
        this.rlShareRootContainer.setLayoutParams(layoutParams);
        return this;
    }

    public CommunityDynamicShareView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int dp2px = DisplayTool.dp2px(567.0f);
        this.mMaxHeight = dp2px;
        this.mWHScale = ((float) this.mMaxWidth) / ((float) dp2px);
        this.mLayoutWidth = -1;
        this.mLayoutHeight = -1;
        initView(context);
    }

    public CommunityDynamicShareView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        int dp2px = DisplayTool.dp2px(567.0f);
        this.mMaxHeight = dp2px;
        this.mWHScale = ((float) this.mMaxWidth) / ((float) dp2px);
        this.mLayoutWidth = -1;
        this.mLayoutHeight = -1;
        initView(context);
    }
}
