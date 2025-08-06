package com.huochat.community.holders;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.common.BaseApplication;
import com.huochat.community.CommunityManager;
import com.huochat.community.CommunityThemeColor;
import com.huochat.community.R;
import com.huochat.community.listener.OnCommentClickListener;
import com.huochat.community.model.CommentItemBean;
import com.huochat.community.util.MomentUtils;
import com.huochat.community.widget.UserLogoView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import kotlin.jvm.internal.x;
import sv.a;
import sv.b;

public final class CommentFullHolder extends RecyclerView.ViewHolder {
    private CommunityThemeColor communityThemeColor = CommunityManager.Companion.getInstance().getCommunityThemeColor();
    private ImageView ivCommentItemVip;
    private TextView textViewComment;
    private TextView textViewCommentName;
    private TextView tvCommentDate;
    private UserLogoView userLogoViewCommentAvatar;
    private View vCommentBottomLine;

    public CommentFullHolder(Context context, View view) {
        super(view);
        this.userLogoViewCommentAvatar = (UserLogoView) view.findViewById(R.id.ulv_comment_item_avatar);
        this.textViewCommentName = (TextView) view.findViewById(R.id.text_view_comment_name);
        this.ivCommentItemVip = (ImageView) view.findViewById(R.id.iv_comment_item_vip);
        this.textViewComment = (TextView) view.findViewById(R.id.text_view_comment);
        this.tvCommentDate = (TextView) view.findViewById(R.id.tv_comment_date);
        this.vCommentBottomLine = view.findViewById(R.id.v_comment_bottom_line);
        notifyThemeChanged();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static final void bindData$lambda$0(OnCommentClickListener onCommentClickListener, CommentItemBean commentItemBean, CommentFullHolder commentFullHolder, View view) {
        if (onCommentClickListener != null) {
            onCommentClickListener.onCommentClick(commentItemBean, commentFullHolder.itemView);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public static final boolean bindData$lambda$1(OnCommentClickListener onCommentClickListener, CommentItemBean commentItemBean, CommentFullHolder commentFullHolder, View view) {
        if (onCommentClickListener == null) {
            return true;
        }
        onCommentClickListener.onCommentLongClick(commentItemBean, commentFullHolder.itemView);
        return true;
    }

    private final void notifyThemeChanged() {
        TextView textView = this.textViewCommentName;
        if (textView != null) {
            textView.setTextColor(this.communityThemeColor.getMomentDetailMoreListItemTitleColor());
        }
        TextView textView2 = this.textViewComment;
        if (textView2 != null) {
            textView2.setTextColor(this.communityThemeColor.getMomentDetailMoreListItemContentColor());
        }
        View view = this.vCommentBottomLine;
        if (view != null) {
            view.setBackgroundColor(this.communityThemeColor.getMomentDetailMoreListItemLineColor());
        }
        TextView textView3 = this.tvCommentDate;
        if (textView3 != null) {
            textView3.setTextColor(this.communityThemeColor.getErrorDefTipsMomentEmptyTextColor());
        }
    }

    public final void bindData(CommentItemBean commentItemBean, OnCommentClickListener onCommentClickListener) {
        if (commentItemBean != null) {
            UserLogoView userLogoView = this.userLogoViewCommentAvatar;
            if (userLogoView != null) {
                userLogoView.setData(commentItemBean.getHeadImage(), commentItemBean.getVFlag(), commentItemBean.getCrownType(), commentItemBean.getAuthType());
            }
            TextView textView = this.textViewCommentName;
            String str = "";
            if (textView != null) {
                textView.setText(TextUtils.isEmpty(str) ? commentItemBean.getUsername() : str);
            }
            TextView textView2 = this.tvCommentDate;
            if (textView2 != null) {
                textView2.setText(MomentUtils.Companion.formatMomentDate(commentItemBean.getPostTime().longValue()));
            }
            ImageView imageView = this.ivCommentItemVip;
            boolean z11 = true;
            if (imageView != null) {
                imageView.setVisibility(commentItemBean.getVipFlag() == 1 ? 0 : 8);
            }
            String replyToUid = commentItemBean.getReplyToUid();
            if ((replyToUid == null || replyToUid.length() == 0) || x.b(commentItemBean.getReplyToUid(), "0")) {
                String replyToUserName = commentItemBean.getReplyToUserName();
                if (!(replyToUserName == null || replyToUserName.length() == 0)) {
                    z11 = false;
                }
                if (z11) {
                    TextView textView3 = this.textViewComment;
                    if (textView3 != null) {
                        textView3.setText(commentItemBean.getContent());
                    }
                    this.itemView.setOnClickListener(new a(onCommentClickListener, commentItemBean, this));
                    this.itemView.setOnLongClickListener(new b(onCommentClickListener, commentItemBean, this));
                }
            }
            if (TextUtils.isEmpty(str)) {
                str = commentItemBean.getReplyToUserName();
            }
            String str2 = "回复: " + ' ' + str + l.f34627b;
            SpannableString spannableString = new SpannableString(str2 + commentItemBean.getContent());
            Resources resources = BaseApplication.b().getResources();
            int i11 = R.color.color_8C9FAD;
            spannableString.setSpan(new ForegroundColorSpan(resources.getColor(i11)), 0, 4, 17);
            spannableString.setSpan(new ForegroundColorSpan(BaseApplication.b().getResources().getColor(i11)), 4, str2.length(), 17);
            TextView textView4 = this.textViewComment;
            if (textView4 != null) {
                textView4.setText(spannableString);
            }
            this.itemView.setOnClickListener(new a(onCommentClickListener, commentItemBean, this));
            this.itemView.setOnLongClickListener(new b(onCommentClickListener, commentItemBean, this));
        }
    }

    public final void setBottomLineVisibility(int i11) {
        View view = this.vCommentBottomLine;
        if (view != null) {
            view.setVisibility(i11);
        }
    }
}
