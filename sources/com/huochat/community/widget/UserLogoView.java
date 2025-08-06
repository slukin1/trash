package com.huochat.community.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.huochat.community.CommunityManager;
import com.huochat.community.R;
import com.huochat.community.util.BadgeConfig;
import com.huochat.community.util.DisplayTool;
import com.huochat.community.util.ImageLoadedrManager;

public class UserLogoView extends FrameLayout {
    private int badgeGravity;
    private int badgeLogo;
    private int badgeLogoHeight;
    private int badgeLogoMargin;
    private int badgeLogoWidth;
    private int decorVisiable;
    private float decoraScale;
    private int decoraSrc;
    private int defaultLogo;
    private int defaultLogoWidth = DisplayTool.dp2px(45.0f);
    public ImageView ivUserIcon;
    public ImageView ivUserLevel;
    public ImageView ivUserTitle;
    private LayoutLisenter layoutLisenter;
    private int layoutWidth;
    private int logoBackground;
    private int logoHeight;
    private int logoPadding;
    private int logoWidth;
    private int nodeTypeRes;

    /* renamed from: com.huochat.community.widget.UserLogoView$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$huochat$community$widget$UserLogoView$LogoType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.huochat.community.widget.UserLogoView$LogoType[] r0 = com.huochat.community.widget.UserLogoView.LogoType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$huochat$community$widget$UserLogoView$LogoType = r0
                com.huochat.community.widget.UserLogoView$LogoType r1 = com.huochat.community.widget.UserLogoView.LogoType.PERSONAL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$huochat$community$widget$UserLogoView$LogoType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huochat.community.widget.UserLogoView$LogoType r1 = com.huochat.community.widget.UserLogoView.LogoType.GROUP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huochat.community.widget.UserLogoView.AnonymousClass1.<clinit>():void");
        }
    }

    public interface LayoutLisenter {
        void layout(int i11, int i12, int i13, int i14);
    }

    public enum LogoType {
        PERSONAL,
        GROUP
    }

    public UserLogoView(Context context) {
        super(context);
        initView(context, (AttributeSet) null);
    }

    private void initView(Context context, AttributeSet attributeSet) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_community_userlogo, this);
        this.ivUserIcon = (ImageView) inflate.findViewById(R.id.iv_user_icon);
        this.ivUserLevel = (ImageView) inflate.findViewById(R.id.iv_user_level);
        this.ivUserTitle = (ImageView) inflate.findViewById(R.id.iv_user_title);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.UserLogoView);
        if (obtainStyledAttributes != null) {
            this.layoutWidth = obtainStyledAttributes.getLayoutDimension(R.styleable.UserLogoView_android_layout_width, -2);
            this.logoWidth = (int) obtainStyledAttributes.getDimension(R.styleable.UserLogoView_logoWidth, (float) this.defaultLogoWidth);
            this.logoHeight = (int) obtainStyledAttributes.getDimension(R.styleable.UserLogoView_logoHeight, (float) this.defaultLogoWidth);
            this.logoPadding = (int) obtainStyledAttributes.getDimension(R.styleable.UserLogoView_logoPadding, (float) DisplayTool.dp2px(0.0f));
            this.defaultLogo = obtainStyledAttributes.getResourceId(R.styleable.UserLogoView_defaultLogo, 0);
            this.logoBackground = obtainStyledAttributes.getResourceId(R.styleable.UserLogoView_logoBackground, 0);
            this.decoraSrc = obtainStyledAttributes.getResourceId(R.styleable.UserLogoView_decoraSrc, 0);
            this.decorVisiable = obtainStyledAttributes.getInt(R.styleable.UserLogoView_decoraVisiable, 4);
            this.decoraScale = obtainStyledAttributes.getFloat(R.styleable.UserLogoView_decoraScale, 1.525f);
            this.badgeLogo = obtainStyledAttributes.getResourceId(R.styleable.UserLogoView_badgeLogo, 0);
            this.badgeLogoWidth = (int) obtainStyledAttributes.getDimension(R.styleable.UserLogoView_badgeLogoWidth, (float) DisplayTool.dp2px(14.0f));
            this.badgeLogoHeight = (int) obtainStyledAttributes.getDimension(R.styleable.UserLogoView_badgeLogoHeight, (float) DisplayTool.dp2px(14.0f));
            this.badgeLogoMargin = (int) obtainStyledAttributes.getDimension(R.styleable.UserLogoView_badgeLogoMargin, (float) DisplayTool.dp2px(6.0f));
            this.badgeGravity = obtainStyledAttributes.getInt(R.styleable.UserLogoView_badgeAlign, 85);
            obtainStyledAttributes.recycle();
        }
        this.ivUserLevel.setVisibility(this.decorVisiable);
        int i11 = this.layoutWidth;
        if (i11 > 0) {
            this.logoWidth = Math.round(((float) i11) / this.decoraScale);
            this.logoHeight = Math.round(((float) this.layoutWidth) / this.decoraScale);
        } else {
            this.layoutWidth = 8 != this.decorVisiable ? Math.round(this.decoraScale * ((float) this.logoWidth)) : this.logoWidth;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ivUserIcon.getLayoutParams();
        int i12 = this.logoPadding;
        if (i12 > 0) {
            this.logoWidth += i12 * 2;
            this.logoHeight += i12 * 2;
        }
        layoutParams.width = this.logoWidth;
        layoutParams.height = this.logoHeight;
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.ivUserLevel.getLayoutParams();
        int i13 = this.layoutWidth;
        layoutParams2.width = i13;
        layoutParams2.height = i13;
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.ivUserTitle.getLayoutParams();
        int i14 = this.badgeLogoMargin;
        layoutParams3.setMargins(i14, i14, i14, i14);
        layoutParams3.width = this.badgeLogoWidth;
        layoutParams3.height = this.badgeLogoHeight;
        layoutParams3.gravity = this.badgeGravity;
        int i15 = this.decoraSrc;
        if (i15 != 0) {
            this.ivUserLevel.setImageResource(i15);
        }
        ImageView imageView = this.ivUserIcon;
        int i16 = this.logoPadding;
        imageView.setPadding(i16, i16, i16, i16);
        int i17 = this.defaultLogo;
        if (i17 != 0) {
            this.ivUserIcon.setImageResource(i17);
        }
        int i18 = this.logoBackground;
        if (i18 != 0) {
            this.ivUserIcon.setBackgroundResource(i18);
        }
        int i19 = this.badgeLogo;
        if (i19 != 0) {
            this.ivUserTitle.setImageResource(i19);
        }
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        LayoutLisenter layoutLisenter2 = this.layoutLisenter;
        if (layoutLisenter2 != null) {
            layoutLisenter2.layout(i11, i12, i13, i14);
        }
    }

    public void setAvatarBackgroundResource(int i11) {
        this.logoBackground = i11;
        this.ivUserIcon.setBackgroundResource(i11);
    }

    public void setBadgeLogo(int i11) {
        if (i11 != 0) {
            this.ivUserTitle.setImageResource(i11);
            this.ivUserTitle.setVisibility(0);
        }
    }

    public void setData(String str, int i11, int i12) {
        setData(str, LogoType.GROUP, i11, i12, 0);
    }

    public void setDecoraSrc(int i11) {
        if (i11 != 0) {
            this.ivUserLevel.setImageResource(i11);
            this.ivUserLevel.setVisibility(0);
        }
    }

    public void setLayoutLisenter(LayoutLisenter layoutLisenter2) {
        this.layoutLisenter = layoutLisenter2;
    }

    public void setLogoWH(int i11, int i12) {
        ViewGroup.LayoutParams layoutParams = this.ivUserIcon.getLayoutParams();
        layoutParams.width = i11;
        layoutParams.height = i12;
        this.ivUserIcon.setLayoutParams(layoutParams);
    }

    public void setUserIcon(int i11) {
        if (i11 != 0) {
            ImageLoadedrManager.getInstance().clearImageError(getContext(), this.ivUserIcon);
            this.ivUserIcon.setImageResource(i11);
            this.ivUserTitle.setVisibility(4);
            this.ivUserLevel.setVisibility(4);
        }
    }

    public void setData(String str, int i11, int i12, int i13) {
        setData(str, LogoType.PERSONAL, i11, i12, i13);
    }

    public void setData(String str, LogoType logoType, int i11, int i12, int i13) {
        this.ivUserLevel.setVisibility(4);
        this.ivUserTitle.setVisibility(4);
        int defaultAvatarResId = CommunityManager.Companion.getInstance().getDefaultAvatarResId();
        if (!TextUtils.isEmpty(str)) {
            ImageLoadedrManager.getInstance().displayRound(getContext(), str, defaultAvatarResId, defaultAvatarResId, defaultAvatarResId, this.ivUserIcon);
        } else {
            ImageView imageView = this.ivUserIcon;
            LogoType logoType2 = LogoType.PERSONAL;
            imageView.setImageResource(defaultAvatarResId);
        }
        this.decoraSrc = BadgeConfig.getUserCrownLogo(i12);
        this.badgeLogo = BadgeConfig.getUserAuthBadgeLogo(i13);
        int i14 = AnonymousClass1.$SwitchMap$com$huochat$community$widget$UserLogoView$LogoType[logoType.ordinal()];
        if (i14 == 1) {
            switch (i11) {
                case 1:
                    this.ivUserLevel.setVisibility(0);
                    break;
                case 2:
                    this.ivUserTitle.setVisibility(0);
                    break;
                case 3:
                    this.ivUserTitle.setVisibility(0);
                    this.ivUserLevel.setVisibility(0);
                    break;
                case 4:
                    this.ivUserTitle.setVisibility(0);
                    this.badgeLogo = R.drawable.ic_hb_yellow;
                    break;
                case 5:
                    this.ivUserTitle.setVisibility(0);
                    this.ivUserLevel.setVisibility(0);
                    this.badgeLogo = R.drawable.ic_hb_yellow;
                    break;
                case 6:
                    this.ivUserTitle.setVisibility(0);
                    this.badgeLogo = R.drawable.ic_hb_yellow;
                    break;
                case 7:
                    this.ivUserTitle.setVisibility(0);
                    this.ivUserLevel.setVisibility(0);
                    this.badgeLogo = R.drawable.ic_hb_yellow;
                    break;
            }
            int i15 = this.decoraSrc;
            if (i15 != 0) {
                this.ivUserLevel.setImageResource(i15);
            } else {
                this.ivUserLevel.setVisibility(4);
            }
            int i16 = this.badgeLogo;
            if (i16 != 0) {
                this.ivUserTitle.setImageResource(i16);
            } else {
                this.ivUserTitle.setVisibility(4);
            }
        } else if (i14 == 2) {
            this.ivUserLevel.setVisibility(4);
            this.ivUserTitle.setVisibility(0);
            int groupCertBadgeLogo = BadgeConfig.getGroupCertBadgeLogo(i11);
            this.badgeLogo = groupCertBadgeLogo;
            if (groupCertBadgeLogo != -1) {
                this.ivUserTitle.setImageResource(groupCertBadgeLogo);
            } else {
                this.ivUserTitle.setVisibility(4);
            }
        }
    }

    public UserLogoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context, attributeSet);
    }

    public UserLogoView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        initView(context, attributeSet);
    }
}
