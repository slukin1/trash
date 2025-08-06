package com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.reply;

import android.content.Context;
import android.widget.TextView;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIReplyQuoteBean;
import com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.TUIReplyQuoteView;
import com.tencent.qcloud.tuikit.timcommon.component.face.FaceManager;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TextReplyQuoteBean;

public class TextReplyQuoteView extends TUIReplyQuoteView {
    public TextView textView = ((TextView) findViewById(R.id.text_quote_tv));

    public TextReplyQuoteView(Context context) {
        super(context);
    }

    public int getLayoutResourceId() {
        return R.layout.chat_reply_quote_text_layout;
    }

    public void onDrawReplyQuote(TUIReplyQuoteBean tUIReplyQuoteBean) {
        if (tUIReplyQuoteBean instanceof TextReplyQuoteBean) {
            FaceManager.handlerEmojiText(this.textView, ((TextReplyQuoteBean) tUIReplyQuoteBean).getText(), false);
        }
    }

    public void setSelf(boolean z11) {
        if (!z11) {
            TextView textView2 = this.textView;
            textView2.setTextColor(textView2.getResources().getColor(TUIThemeManager.getAttrResId(this.textView.getContext(), R.attr.chat_other_reply_quote_text_color)));
            return;
        }
        TextView textView3 = this.textView;
        textView3.setTextColor(textView3.getResources().getColor(TUIThemeManager.getAttrResId(this.textView.getContext(), R.attr.chat_self_reply_quote_text_color)));
    }
}
