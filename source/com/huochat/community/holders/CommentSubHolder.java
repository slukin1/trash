package com.huochat.community.holders;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.huochat.community.CommunityManager;
import com.huochat.community.R;
import com.huochat.community.listener.OnCommentClickListener;
import com.huochat.community.model.CommentItemBean;
import com.huochat.community.util.ContextTool;
import com.huochat.community.widget.UserLogoView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import sv.c;
import sv.d;
import sv.e;

public final class CommentSubHolder extends RecyclerView.ViewHolder {
    private Context mContext;
    private TextView textViewComment;
    private UserLogoView userLogoViewCommentAvatar;

    public CommentSubHolder(Context context, View view) {
        super(view);
        this.mContext = context;
        this.userLogoViewCommentAvatar = (UserLogoView) view.findViewById(R.id.ulv_comment_item_avatar);
        this.textViewComment = (TextView) view.findViewById(R.id.text_view_comment);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static final void bindData$lambda$0(View view) {
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static final void bindData$lambda$1(OnCommentClickListener onCommentClickListener, CommentItemBean commentItemBean, CommentSubHolder commentSubHolder, View view) {
        if (onCommentClickListener != null) {
            onCommentClickListener.onCommentClick(commentItemBean, commentSubHolder.itemView);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public static final boolean bindData$lambda$2(OnCommentClickListener onCommentClickListener, CommentItemBean commentItemBean, CommentSubHolder commentSubHolder, View view) {
        if (onCommentClickListener == null) {
            return true;
        }
        onCommentClickListener.onCommentLongClick(commentItemBean, commentSubHolder.itemView);
        return true;
    }

    public final void bindData(CommentItemBean commentItemBean, OnCommentClickListener onCommentClickListener) {
        if (commentItemBean != null) {
            this.userLogoViewCommentAvatar.setOnClickListener(d.f29267b);
            if (!ContextTool.checkContext(this.mContext) || TextUtils.isEmpty(commentItemBean.getHeadImage())) {
                this.userLogoViewCommentAvatar.setUserIcon(CommunityManager.Companion.getInstance().getDefaultAvatarResId());
            } else {
                this.userLogoViewCommentAvatar.setData(commentItemBean.getHeadImage(), -1, -1, -1);
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            String str = "";
            if (TextUtils.isEmpty(str)) {
                str = commentItemBean.getUsername();
            }
            SpannableString spannableString = new SpannableString(str + 65306);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#222222")), 0, spannableString.length(), 17);
            String content = commentItemBean.getContent();
            spannableStringBuilder.append(spannableString);
            spannableStringBuilder.append(content);
            this.textViewComment.setText(spannableStringBuilder);
            this.itemView.setOnClickListener(new c(onCommentClickListener, commentItemBean, this));
            this.itemView.setOnLongClickListener(new e(onCommentClickListener, commentItemBean, this));
        }
    }
}
