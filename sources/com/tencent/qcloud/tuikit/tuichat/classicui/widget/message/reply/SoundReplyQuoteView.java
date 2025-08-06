package com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.reply;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIReplyQuoteBean;
import com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.TUIReplyQuoteView;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.SoundReplyQuoteBean;

public class SoundReplyQuoteView extends TUIReplyQuoteView {
    private ImageView soundMsgIcon = ((ImageView) findViewById(R.id.sound_msg_icon_iv));
    private View soundMsgLayout = findViewById(R.id.sound_msg_layout);
    private TextView soundMsgTv = ((TextView) findViewById(R.id.sound_msg_time_tv));

    public SoundReplyQuoteView(Context context) {
        super(context);
    }

    public int getLayoutResourceId() {
        return R.layout.chat_reply_quote_sound_layout;
    }

    public void onDrawReplyQuote(TUIReplyQuoteBean tUIReplyQuoteBean) {
        this.soundMsgLayout.setVisibility(0);
        if (tUIReplyQuoteBean instanceof SoundReplyQuoteBean) {
            TextView textView = this.soundMsgTv;
            textView.setText(((SoundReplyQuoteBean) tUIReplyQuoteBean).getDuring() + "''");
        }
    }

    public void setSelf(boolean z11) {
        if (!z11) {
            TextView textView = this.soundMsgTv;
            textView.setTextColor(textView.getResources().getColor(TUIThemeManager.getAttrResId(this.soundMsgTv.getContext(), R.attr.chat_other_reply_quote_text_color)));
            return;
        }
        TextView textView2 = this.soundMsgTv;
        textView2.setTextColor(textView2.getResources().getColor(TUIThemeManager.getAttrResId(this.soundMsgTv.getContext(), R.attr.chat_self_reply_quote_text_color)));
    }
}
