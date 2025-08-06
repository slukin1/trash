package com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.reply;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIReplyQuoteBean;
import com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.TUIReplyQuoteView;
import com.tencent.qcloud.tuikit.timcommon.component.face.FaceManager;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.MergeMessageBean;
import java.util.List;

public class MergeReplyQuoteView extends TUIReplyQuoteView {
    private TextView mergeMsgContent = ((TextView) findViewById(R.id.merge_msg_content));
    private View mergeMsgLayout = findViewById(R.id.merge_msg_layout);
    private TextView mergeMsgTitle = ((TextView) findViewById(R.id.merge_msg_title));

    public MergeReplyQuoteView(Context context) {
        super(context);
    }

    public int getLayoutResourceId() {
        return R.layout.chat_reply_quote_merge_layout;
    }

    public void onDrawReplyQuote(TUIReplyQuoteBean tUIReplyQuoteBean) {
        MergeMessageBean mergeMessageBean = (MergeMessageBean) tUIReplyQuoteBean.getMessageBean();
        int i11 = 0;
        this.mergeMsgLayout.setVisibility(0);
        String title = mergeMessageBean.getTitle();
        List<String> abstractList = mergeMessageBean.getAbstractList();
        this.mergeMsgTitle.setText(title);
        String str = "";
        while (i11 < abstractList.size() && i11 < 2) {
            if (i11 != 0) {
                str = str + "\n";
            }
            str = str + abstractList.get(i11);
            i11++;
        }
        this.mergeMsgContent.setText(FaceManager.emojiJudge(str));
    }

    public void setSelf(boolean z11) {
        if (!z11) {
            TextView textView = this.mergeMsgContent;
            Resources resources = textView.getResources();
            Context context = this.mergeMsgContent.getContext();
            int i11 = R.attr.chat_other_reply_quote_text_color;
            textView.setTextColor(resources.getColor(TUIThemeManager.getAttrResId(context, i11)));
            TextView textView2 = this.mergeMsgTitle;
            textView2.setTextColor(textView2.getResources().getColor(TUIThemeManager.getAttrResId(this.mergeMsgTitle.getContext(), i11)));
            return;
        }
        TextView textView3 = this.mergeMsgContent;
        Resources resources2 = textView3.getResources();
        Context context2 = this.mergeMsgContent.getContext();
        int i12 = R.attr.chat_self_reply_quote_text_color;
        textView3.setTextColor(resources2.getColor(TUIThemeManager.getAttrResId(context2, i12)));
        TextView textView4 = this.mergeMsgTitle;
        textView4.setTextColor(textView4.getResources().getColor(TUIThemeManager.getAttrResId(this.mergeMsgTitle.getContext(), i12)));
    }
}
