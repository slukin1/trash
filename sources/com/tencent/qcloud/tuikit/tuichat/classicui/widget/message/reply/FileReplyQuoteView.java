package com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.reply;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIReplyQuoteBean;
import com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.TUIReplyQuoteView;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.FileReplyQuoteBean;

public class FileReplyQuoteView extends TUIReplyQuoteView {
    private ImageView fileMsgIcon = ((ImageView) findViewById(R.id.file_msg_icon_iv));
    private View fileMsgLayout = findViewById(R.id.file_msg_layout);
    private TextView fileMsgTv = ((TextView) findViewById(R.id.file_msg_name_tv));

    public FileReplyQuoteView(Context context) {
        super(context);
    }

    public int getLayoutResourceId() {
        return R.layout.chat_reply_quote_file_layout;
    }

    public void onDrawReplyQuote(TUIReplyQuoteBean tUIReplyQuoteBean) {
        this.fileMsgLayout.setVisibility(0);
        if (tUIReplyQuoteBean instanceof FileReplyQuoteBean) {
            this.fileMsgTv.setText(((FileReplyQuoteBean) tUIReplyQuoteBean).getFileName());
        }
    }

    public void setSelf(boolean z11) {
        if (!z11) {
            TextView textView = this.fileMsgTv;
            textView.setTextColor(textView.getResources().getColor(TUIThemeManager.getAttrResId(this.fileMsgTv.getContext(), R.attr.chat_other_reply_quote_text_color)));
            return;
        }
        TextView textView2 = this.fileMsgTv;
        textView2.setTextColor(textView2.getResources().getColor(TUIThemeManager.getAttrResId(this.fileMsgTv.getContext(), R.attr.chat_self_reply_quote_text_color)));
    }
}
