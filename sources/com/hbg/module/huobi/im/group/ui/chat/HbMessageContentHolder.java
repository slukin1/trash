package com.hbg.module.huobi.im.group.ui.chat;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.hbg.module.huobi.im.R$id;
import com.hbg.module.huobi.im.utils.HbGroupUserManager;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.MessageContentHolder;

public abstract class HbMessageContentHolder extends MessageContentHolder {
    private boolean isGroup = true;
    public ImageView ivSpeakerTag;
    public RelativeLayout rlLeftUserIcon;

    public HbMessageContentHolder(View view) {
        super(view);
    }

    public final ImageView getIvSpeakerTag() {
        ImageView imageView = this.ivSpeakerTag;
        if (imageView != null) {
            return imageView;
        }
        return null;
    }

    public final RelativeLayout getRlLeftUserIcon() {
        RelativeLayout relativeLayout = this.rlLeftUserIcon;
        if (relativeLayout != null) {
            return relativeLayout;
        }
        return null;
    }

    public final boolean isGroup() {
        return this.isGroup;
    }

    public void layoutViews(TUIMessageBean tUIMessageBean, int i11) {
        if (tUIMessageBean != null) {
            setIvSpeakerTag((ImageView) this.itemView.findViewById(R$id.iv_speaker_tag));
            setRlLeftUserIcon((RelativeLayout) this.itemView.findViewById(R$id.rl_left_user_icon_view));
            ((RelativeLayout) this.itemView.findViewById(R$id.rl_share)).setVisibility(8);
            ((TextView) this.itemView.findViewById(R$id.tv_share_text)).setVisibility(8);
            this.chatTimeText.setVisibility(0);
            this.rightGroupLayout.setVisibility(0);
            super.layoutViews(tUIMessageBean, i11);
            this.msgContentLinear.setVisibility(0);
            if (this.isForwardMode) {
                getRlLeftUserIcon().setVisibility(0);
            } else if (tUIMessageBean.isSelf()) {
                getRlLeftUserIcon().setVisibility(8);
            } else {
                getRlLeftUserIcon().setVisibility(0);
            }
            if (!HbGroupUserManager.c().e(tUIMessageBean.getSender()) || tUIMessageBean.isSelf() || !this.isGroup) {
                getIvSpeakerTag().setVisibility(8);
            } else {
                getIvSpeakerTag().setVisibility(0);
            }
        }
    }

    public final void setGroup(boolean z11) {
        this.isGroup = z11;
    }

    public final void setIsGroup(boolean z11) {
        this.isGroup = z11;
    }

    public final void setIvSpeakerTag(ImageView imageView) {
        this.ivSpeakerTag = imageView;
    }

    public final void setRlLeftUserIcon(RelativeLayout relativeLayout) {
        this.rlLeftUserIcon = relativeLayout;
    }
}
