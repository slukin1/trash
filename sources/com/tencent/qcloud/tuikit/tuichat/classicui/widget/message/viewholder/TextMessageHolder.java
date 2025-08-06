package com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.MessageContentHolder;
import com.tencent.qcloud.tuikit.timcommon.component.face.FaceManager;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TextMessageBean;

public class TextMessageHolder extends MessageContentHolder {
    public TextView msgBodyText;

    public TextMessageHolder(View view) {
        super(view);
        this.msgBodyText = (TextView) view.findViewById(R.id.msg_body_tv);
    }

    public int getVariableLayout() {
        return R.layout.message_adapter_content_text;
    }

    public void layoutVariableViews(TUIMessageBean tUIMessageBean, int i11) {
        boolean z11;
        if (tUIMessageBean instanceof TextMessageBean) {
            TextMessageBean textMessageBean = (TextMessageBean) tUIMessageBean;
            if (this.isForwardMode || this.isReplyDetailMode || !textMessageBean.isSelf()) {
                this.msgBodyText.setTextColor(this.msgBodyText.getResources().getColor(TUIThemeManager.getAttrResId(this.msgBodyText.getContext(), R.attr.chat_other_msg_text_color)));
            } else {
                this.msgBodyText.setTextColor(this.msgBodyText.getResources().getColor(TUIThemeManager.getAttrResId(this.msgBodyText.getContext(), R.attr.chat_self_msg_text_color)));
            }
            this.msgBodyText.setVisibility(0);
            if (this.properties.getChatContextFontSize() != 0) {
                this.msgBodyText.setTextSize((float) this.properties.getChatContextFontSize());
            }
            if (textMessageBean.isSelf()) {
                if (this.properties.getRightChatContentFontColor() != 0) {
                    this.msgBodyText.setTextColor(this.properties.getRightChatContentFontColor());
                }
            } else if (this.properties.getLeftChatContentFontColor() != 0) {
                this.msgBodyText.setTextColor(this.properties.getLeftChatContentFontColor());
            }
            this.msgArea.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    TextMessageHolder.this.selectableTextHelper.selectAll();
                    return true;
                }
            });
            if (textMessageBean.getText() != null) {
                z11 = FaceManager.handlerEmojiText(this.msgBodyText, textMessageBean.getText(), false);
            } else if (!TextUtils.isEmpty(textMessageBean.getExtra())) {
                z11 = FaceManager.handlerEmojiText(this.msgBodyText, textMessageBean.getExtra(), false);
            } else {
                z11 = FaceManager.handlerEmojiText(this.msgBodyText, ServiceInitializer.getAppContext().getString(R.string.no_support_msg), false);
            }
            if (!this.isForwardMode && !this.isReplyDetailMode) {
                setSelectableTextHelper(tUIMessageBean, this.msgBodyText, i11, z11);
            }
        }
    }
}
