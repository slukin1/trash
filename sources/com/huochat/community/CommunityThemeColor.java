package com.huochat.community;

import android.content.Context;
import androidx.core.content.ContextCompat;
import java.io.Serializable;
import kotlin.jvm.internal.r;

public class CommunityThemeColor implements Serializable {
    public static final Companion Companion = new Companion((r) null);
    private int authMarkBgDrawable;
    private int authMarkTextColor;
    private int commentIconTextColor;
    private int communityFromBgDrawable;
    private int communityFromIconTextColor;
    private int communityMomentCommentDialogInputBgColor;
    private int communityMomentContentCopyBgColor;
    private int communityMomentListNoMoreDataTipsTextColor;
    private int communityMomentMainPageBgColor;
    private int communityMomentMainPageTitleColor;
    private int communityMomentMainPageTopLineColor;
    private int communityMomentMoreListTitleColorNormal;
    private int communityMomentMoreListTitleColorSelected;
    private int contentExpandTextColor;
    private int contentFromHuobiChatContainerBgColor;
    private int contentFromHuobiChatTextColor;
    private int contentTextColor;
    private int errorDefIconMomentCommentEmpty;
    private int errorDefIconMomentEmpty;
    private int errorDefIconMomentForwordEmpty;
    private int errorDefIconMomentPariseEmpty;
    private int errorDefIconNoNetworkResId;
    private int errorDefTipsMomentEmptyTextColor;
    private int listDividingLineColor;
    private int momentDetailMoreListItemContentColor;
    private int momentDetailMoreListItemLineColor;
    private int momentDetailMoreListItemTitleColor;
    private int openHuobiChatButtonBgDrawable;
    private int opratePanelVerticalDividingLineColor;
    private int postTimeTextColor;
    private int postTypeTextColor;
    private int praiseIconTextColor;
    private int rootBgDrawable;
    private int shareContentBgDrawable;
    private int shareContentSubTitleTextColor;
    private int shareContentTitleTextColor;
    private int shareIconTextColor;
    private int usernameTextColor;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        private final int getColorRes(Context context, int i11) {
            if (context != null) {
                return ContextCompat.getColor(context, i11);
            }
            return 0;
        }

        public final CommunityThemeColor getDefLightColor(Context context) {
            Context context2 = context;
            int i11 = R.color.color_ffffff;
            int colorRes = getColorRes(context2, i11);
            int colorRes2 = getColorRes(context2, R.color.color_F4F7FD);
            int i12 = R.color.color_0066ED;
            int colorRes3 = getColorRes(context2, i12);
            int i13 = R.drawable.shape_roundrect_border_0066ed_r3;
            int i14 = R.color.color_14181F;
            int colorRes4 = getColorRes(context2, i14);
            int i15 = R.color.color_8C9FAD;
            int colorRes5 = getColorRes(context2, i15);
            int i16 = R.drawable.bg_fffbf5_b_e7cb9f_r_2px;
            int colorRes6 = getColorRes(context2, i14);
            int colorRes7 = getColorRes(context2, R.color.color_2483FF);
            int i17 = i15;
            int colorRes8 = getColorRes(context2, i15);
            int i18 = colorRes;
            int i19 = i14;
            int colorRes9 = getColorRes(context2, i17);
            int i21 = colorRes2;
            int i22 = i12;
            int colorRes10 = getColorRes(context2, i19);
            int i23 = colorRes3;
            int i24 = i11;
            int colorRes11 = getColorRes(context2, i19);
            int colorRes12 = getColorRes(context2, i19);
            int i25 = R.drawable.bg_ligray_with_radius_5px;
            int colorRes13 = getColorRes(context2, i19);
            int colorRes14 = getColorRes(context2, i17);
            int colorRes15 = getColorRes(context2, i19);
            int i26 = R.drawable.bg_color_f2f3f5_r_20px;
            int i27 = i13;
            int i28 = R.color.color_E7EBEE;
            int colorRes16 = getColorRes(context2, i28);
            int colorRes17 = getColorRes(context2, i24);
            int colorRes18 = getColorRes(context2, i19);
            int colorRes19 = getColorRes(context2, i28);
            int i29 = R.color.color_F7F7FB;
            int colorRes20 = getColorRes(context2, i29);
            int colorRes21 = getColorRes(context2, i29);
            int i30 = R.color.color_C5CFD5;
            int colorRes22 = getColorRes(context2, i30);
            int colorRes23 = getColorRes(context2, i17);
            int colorRes24 = getColorRes(context2, i22);
            int colorRes25 = getColorRes(context2, i19);
            int colorRes26 = getColorRes(context2, i19);
            int colorRes27 = getColorRes(context2, i28);
            int colorRes28 = getColorRes(context2, i30);
            int i31 = R.drawable.community_ic_default_empty;
            int i32 = R.drawable.community_no_network_icon;
            int colorRes29 = getColorRes(context2, i28);
            return new CommunityThemeColor(i18, i21, i23, i27, colorRes4, colorRes5, i16, colorRes6, colorRes7, colorRes8, colorRes9, colorRes10, colorRes11, colorRes12, i25, colorRes13, colorRes14, colorRes15, i26, colorRes16, colorRes17, colorRes18, colorRes19, colorRes20, colorRes21, colorRes22, colorRes23, colorRes24, colorRes25, colorRes26, colorRes27, colorRes28, i31, i31, i31, i31, i32, colorRes29);
        }

        public final CommunityThemeColor getDefNightColor(Context context) {
            Context context2 = context;
            int i11 = R.color.color_131f30;
            int colorRes = getColorRes(context2, i11);
            int colorRes2 = getColorRes(context2, R.color.color_12253A);
            int i12 = R.color.color_2483FF;
            int colorRes3 = getColorRes(context2, i12);
            int i13 = R.drawable.shape_roundrect_border_2483ff_r3;
            int i14 = R.color.color_CFD3E9;
            int colorRes4 = getColorRes(context2, i14);
            int i15 = R.color.color_6D87A8;
            int colorRes5 = getColorRes(context2, i15);
            int i16 = R.drawable.bg_color_0dffffff_r_2px;
            int colorRes6 = getColorRes(context2, i14);
            int colorRes7 = getColorRes(context2, i12);
            int i17 = i15;
            int colorRes8 = getColorRes(context2, i15);
            int i18 = colorRes;
            int i19 = i14;
            int colorRes9 = getColorRes(context2, i17);
            int i21 = colorRes2;
            int i22 = i12;
            int colorRes10 = getColorRes(context2, i19);
            int i23 = colorRes3;
            int i24 = i11;
            int colorRes11 = getColorRes(context2, i19);
            int colorRes12 = getColorRes(context2, i19);
            int i25 = R.drawable.community_bg_roundrect_081724_r5;
            int colorRes13 = getColorRes(context2, i19);
            int colorRes14 = getColorRes(context2, i17);
            int colorRes15 = getColorRes(context2, i19);
            int i26 = R.drawable.bg_1afffbf5_b_e7cb9f_r_20px;
            int i27 = i13;
            int i28 = R.color.color_263347;
            int colorRes16 = getColorRes(context2, i28);
            int colorRes17 = getColorRes(context2, i24);
            int colorRes18 = getColorRes(context2, i19);
            int colorRes19 = getColorRes(context2, i28);
            int i29 = R.color.color_081724;
            int colorRes20 = getColorRes(context2, i29);
            int colorRes21 = getColorRes(context2, i29);
            int i30 = R.color.color_3E536C;
            int colorRes22 = getColorRes(context2, i30);
            int colorRes23 = getColorRes(context2, i17);
            int colorRes24 = getColorRes(context2, i22);
            int colorRes25 = getColorRes(context2, i19);
            int colorRes26 = getColorRes(context2, i19);
            int colorRes27 = getColorRes(context2, i28);
            int colorRes28 = getColorRes(context2, i30);
            int i31 = R.drawable.community_ic_default_empty_dark;
            int i32 = R.drawable.community_no_network_icon_dark;
            int colorRes29 = getColorRes(context2, i30);
            return new CommunityThemeColor(i18, i21, i23, i27, colorRes4, colorRes5, i16, colorRes6, colorRes7, colorRes8, colorRes9, colorRes10, colorRes11, colorRes12, i25, colorRes13, colorRes14, colorRes15, i26, colorRes16, colorRes17, colorRes18, colorRes19, colorRes20, colorRes21, colorRes22, colorRes23, colorRes24, colorRes25, colorRes26, colorRes27, colorRes28, i31, i31, i31, i31, i32, colorRes29);
        }
    }

    public CommunityThemeColor() {
    }

    public final int getAuthMarkBgDrawable() {
        return this.authMarkBgDrawable;
    }

    public final int getAuthMarkTextColor() {
        return this.authMarkTextColor;
    }

    public final int getCommentIconTextColor() {
        return this.commentIconTextColor;
    }

    public final int getCommunityFromBgDrawable() {
        return this.communityFromBgDrawable;
    }

    public final int getCommunityFromIconTextColor() {
        return this.communityFromIconTextColor;
    }

    public final int getCommunityMomentCommentDialogInputBgColor() {
        return this.communityMomentCommentDialogInputBgColor;
    }

    public final int getCommunityMomentContentCopyBgColor() {
        return this.communityMomentContentCopyBgColor;
    }

    public final int getCommunityMomentListNoMoreDataTipsTextColor() {
        return this.communityMomentListNoMoreDataTipsTextColor;
    }

    public final int getCommunityMomentMainPageBgColor() {
        return this.communityMomentMainPageBgColor;
    }

    public final int getCommunityMomentMainPageTitleColor() {
        return this.communityMomentMainPageTitleColor;
    }

    public final int getCommunityMomentMainPageTopLineColor() {
        return this.communityMomentMainPageTopLineColor;
    }

    public final int getCommunityMomentMoreListTitleColorNormal() {
        return this.communityMomentMoreListTitleColorNormal;
    }

    public final int getCommunityMomentMoreListTitleColorSelected() {
        return this.communityMomentMoreListTitleColorSelected;
    }

    public final int getContentExpandTextColor() {
        return this.contentExpandTextColor;
    }

    public final int getContentFromHuobiChatContainerBgColor() {
        return this.contentFromHuobiChatContainerBgColor;
    }

    public final int getContentFromHuobiChatTextColor() {
        return this.contentFromHuobiChatTextColor;
    }

    public final int getContentTextColor() {
        return this.contentTextColor;
    }

    public final int getErrorDefIconMomentCommentEmpty() {
        return this.errorDefIconMomentCommentEmpty;
    }

    public final int getErrorDefIconMomentEmpty() {
        return this.errorDefIconMomentEmpty;
    }

    public final int getErrorDefIconMomentForwordEmpty() {
        return this.errorDefIconMomentForwordEmpty;
    }

    public final int getErrorDefIconMomentPariseEmpty() {
        return this.errorDefIconMomentPariseEmpty;
    }

    public final int getErrorDefIconNoNetworkResId() {
        return this.errorDefIconNoNetworkResId;
    }

    public final int getErrorDefTipsMomentEmptyTextColor() {
        return this.errorDefTipsMomentEmptyTextColor;
    }

    public final int getListDividingLineColor() {
        return this.listDividingLineColor;
    }

    public final int getMomentDetailMoreListItemContentColor() {
        return this.momentDetailMoreListItemContentColor;
    }

    public final int getMomentDetailMoreListItemLineColor() {
        return this.momentDetailMoreListItemLineColor;
    }

    public final int getMomentDetailMoreListItemTitleColor() {
        return this.momentDetailMoreListItemTitleColor;
    }

    public final int getOpenHuobiChatButtonBgDrawable() {
        return this.openHuobiChatButtonBgDrawable;
    }

    public final int getOpratePanelVerticalDividingLineColor() {
        return this.opratePanelVerticalDividingLineColor;
    }

    public final int getPostTimeTextColor() {
        return this.postTimeTextColor;
    }

    public final int getPostTypeTextColor() {
        return this.postTypeTextColor;
    }

    public final int getPraiseIconTextColor() {
        return this.praiseIconTextColor;
    }

    public final int getRootBgDrawable() {
        return this.rootBgDrawable;
    }

    public final int getShareContentBgDrawable() {
        return this.shareContentBgDrawable;
    }

    public final int getShareContentSubTitleTextColor() {
        return this.shareContentSubTitleTextColor;
    }

    public final int getShareContentTitleTextColor() {
        return this.shareContentTitleTextColor;
    }

    public final int getShareIconTextColor() {
        return this.shareIconTextColor;
    }

    public final int getUsernameTextColor() {
        return this.usernameTextColor;
    }

    public final void setAuthMarkBgDrawable(int i11) {
        this.authMarkBgDrawable = i11;
    }

    public final void setAuthMarkTextColor(int i11) {
        this.authMarkTextColor = i11;
    }

    public final void setCommentIconTextColor(int i11) {
        this.commentIconTextColor = i11;
    }

    public final void setCommunityFromBgDrawable(int i11) {
        this.communityFromBgDrawable = i11;
    }

    public final void setCommunityFromIconTextColor(int i11) {
        this.communityFromIconTextColor = i11;
    }

    public final void setCommunityMomentCommentDialogInputBgColor(int i11) {
        this.communityMomentCommentDialogInputBgColor = i11;
    }

    public final void setCommunityMomentContentCopyBgColor(int i11) {
        this.communityMomentContentCopyBgColor = i11;
    }

    public final void setCommunityMomentListNoMoreDataTipsTextColor(int i11) {
        this.communityMomentListNoMoreDataTipsTextColor = i11;
    }

    public final void setCommunityMomentMainPageBgColor(int i11) {
        this.communityMomentMainPageBgColor = i11;
    }

    public final void setCommunityMomentMainPageTitleColor(int i11) {
        this.communityMomentMainPageTitleColor = i11;
    }

    public final void setCommunityMomentMainPageTopLineColor(int i11) {
        this.communityMomentMainPageTopLineColor = i11;
    }

    public final void setCommunityMomentMoreListTitleColorNormal(int i11) {
        this.communityMomentMoreListTitleColorNormal = i11;
    }

    public final void setCommunityMomentMoreListTitleColorSelected(int i11) {
        this.communityMomentMoreListTitleColorSelected = i11;
    }

    public final void setContentExpandTextColor(int i11) {
        this.contentExpandTextColor = i11;
    }

    public final void setContentFromHuobiChatContainerBgColor(int i11) {
        this.contentFromHuobiChatContainerBgColor = i11;
    }

    public final void setContentFromHuobiChatTextColor(int i11) {
        this.contentFromHuobiChatTextColor = i11;
    }

    public final void setContentTextColor(int i11) {
        this.contentTextColor = i11;
    }

    public final void setErrorDefIconMomentCommentEmpty(int i11) {
        this.errorDefIconMomentCommentEmpty = i11;
    }

    public final void setErrorDefIconMomentEmpty(int i11) {
        this.errorDefIconMomentEmpty = i11;
    }

    public final void setErrorDefIconMomentForwordEmpty(int i11) {
        this.errorDefIconMomentForwordEmpty = i11;
    }

    public final void setErrorDefIconMomentPariseEmpty(int i11) {
        this.errorDefIconMomentPariseEmpty = i11;
    }

    public final void setErrorDefIconNoNetworkResId(int i11) {
        this.errorDefIconNoNetworkResId = i11;
    }

    public final void setErrorDefTipsMomentEmptyTextColor(int i11) {
        this.errorDefTipsMomentEmptyTextColor = i11;
    }

    public final void setListDividingLineColor(int i11) {
        this.listDividingLineColor = i11;
    }

    public final void setMomentDetailMoreListItemContentColor(int i11) {
        this.momentDetailMoreListItemContentColor = i11;
    }

    public final void setMomentDetailMoreListItemLineColor(int i11) {
        this.momentDetailMoreListItemLineColor = i11;
    }

    public final void setMomentDetailMoreListItemTitleColor(int i11) {
        this.momentDetailMoreListItemTitleColor = i11;
    }

    public final void setOpenHuobiChatButtonBgDrawable(int i11) {
        this.openHuobiChatButtonBgDrawable = i11;
    }

    public final void setOpratePanelVerticalDividingLineColor(int i11) {
        this.opratePanelVerticalDividingLineColor = i11;
    }

    public final void setPostTimeTextColor(int i11) {
        this.postTimeTextColor = i11;
    }

    public final void setPostTypeTextColor(int i11) {
        this.postTypeTextColor = i11;
    }

    public final void setPraiseIconTextColor(int i11) {
        this.praiseIconTextColor = i11;
    }

    public final void setRootBgDrawable(int i11) {
        this.rootBgDrawable = i11;
    }

    public final void setShareContentBgDrawable(int i11) {
        this.shareContentBgDrawable = i11;
    }

    public final void setShareContentSubTitleTextColor(int i11) {
        this.shareContentSubTitleTextColor = i11;
    }

    public final void setShareContentTitleTextColor(int i11) {
        this.shareContentTitleTextColor = i11;
    }

    public final void setShareIconTextColor(int i11) {
        this.shareIconTextColor = i11;
    }

    public final void setUsernameTextColor(int i11) {
        this.usernameTextColor = i11;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CommunityThemeColor(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i21, int i22, int i23, int i24, int i25, int i26, int i27, int i28, int i29, int i30, int i31, int i32, int i33, int i34, int i35, int i36, int i37, int i38, int i39, int i40, int i41, int i42, int i43, int i44, int i45, int i46, int i47, int i48, int i49) {
        this();
        this.rootBgDrawable = i11;
        this.contentFromHuobiChatContainerBgColor = i12;
        this.contentFromHuobiChatTextColor = i13;
        this.openHuobiChatButtonBgDrawable = i14;
        this.usernameTextColor = i15;
        this.authMarkTextColor = i16;
        this.authMarkBgDrawable = i17;
        this.contentTextColor = i18;
        this.contentExpandTextColor = i19;
        this.postTimeTextColor = i21;
        this.postTypeTextColor = i22;
        this.shareIconTextColor = i23;
        this.praiseIconTextColor = i24;
        this.commentIconTextColor = i25;
        this.shareContentBgDrawable = i26;
        this.shareContentTitleTextColor = i27;
        this.shareContentSubTitleTextColor = i28;
        this.communityFromIconTextColor = i29;
        this.communityFromBgDrawable = i30;
        this.listDividingLineColor = i31;
        this.communityMomentMainPageBgColor = i32;
        this.communityMomentMainPageTitleColor = i33;
        this.communityMomentMainPageTopLineColor = i34;
        this.communityMomentCommentDialogInputBgColor = i35;
        this.communityMomentContentCopyBgColor = i36;
        this.communityMomentListNoMoreDataTipsTextColor = i37;
        this.communityMomentMoreListTitleColorNormal = i38;
        this.communityMomentMoreListTitleColorSelected = i39;
        this.momentDetailMoreListItemTitleColor = i40;
        this.momentDetailMoreListItemContentColor = i41;
        this.momentDetailMoreListItemLineColor = i42;
        this.errorDefTipsMomentEmptyTextColor = i43;
        this.errorDefIconMomentEmpty = i44;
        this.errorDefIconMomentPariseEmpty = i45;
        this.errorDefIconMomentCommentEmpty = i46;
        this.errorDefIconMomentForwordEmpty = i47;
        this.errorDefIconNoNetworkResId = i48;
        this.opratePanelVerticalDividingLineColor = i49;
    }
}
