package com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder;

import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.MessageBaseHolder;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TipsMessageBean;

public class TipsMessageHolder extends MessageBaseHolder {
    public TextView mChatTipsTv;
    public TextView mReEditText;

    public TipsMessageHolder(View view) {
        super(view);
        this.mChatTipsTv = (TextView) view.findViewById(R.id.chat_tips_tv);
        this.mReEditText = (TextView) view.findViewById(R.id.re_edit);
    }

    public int getVariableLayout() {
        return R.layout.message_adapter_content_tips;
    }

    public void layoutViews(final TUIMessageBean tUIMessageBean, final int i11) {
        String str;
        super.layoutViews(tUIMessageBean, i11);
        if (this.properties.getTipsMessageBubble() != null) {
            this.mChatTipsTv.setBackground(this.properties.getTipsMessageBubble());
        }
        if (this.properties.getTipsMessageFontColor() != 0) {
            this.mChatTipsTv.setTextColor(this.properties.getTipsMessageFontColor());
        }
        if (this.properties.getTipsMessageFontSize() != 0) {
            this.mChatTipsTv.setTextSize((float) this.properties.getTipsMessageFontSize());
        }
        if (tUIMessageBean.getStatus() == 275) {
            String string = this.itemView.getResources().getString(R.string.revoke_tips_other);
            if (tUIMessageBean.isSelf()) {
                if (tUIMessageBean.getMsgType() == 1) {
                    if (((int) (V2TIMManager.getInstance().getServerTime() - tUIMessageBean.getMessageTime())) < 120) {
                        this.mReEditText.setVisibility(0);
                        this.mReEditText.setOnClickListener(new View.OnClickListener() {
                            @SensorsDataInstrumented
                            public void onClick(View view) {
                                TipsMessageHolder.this.onItemClickListener.onReEditRevokeMessage(view, i11, tUIMessageBean);
                                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                            }
                        });
                    } else {
                        this.mReEditText.setVisibility(8);
                    }
                }
                string = this.itemView.getResources().getString(R.string.n_group_message_revoked_owner);
            } else if (tUIMessageBean.isGroup()) {
                if (TextUtils.isEmpty(tUIMessageBean.getNameCard())) {
                    str = tUIMessageBean.getSender();
                } else {
                    str = tUIMessageBean.getNameCard();
                }
                String covert2HTMLString = TUIChatConstants.covert2HTMLString(str);
                string = this.itemView.getResources().getString(R.string.n_group_message_revoked_others, new Object[]{covert2HTMLString});
            }
            this.mChatTipsTv.setText(Html.fromHtml(string));
        }
        if (tUIMessageBean instanceof TipsMessageBean) {
            this.mChatTipsTv.setText(Html.fromHtml(((TipsMessageBean) tUIMessageBean).getText()));
        }
    }
}
