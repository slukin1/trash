package com.tencent.qcloud.tuikit.tuichat.bean.message.reply;

import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.CustomEvaluationMessageBean;

public class CustomEvaluationMessageReplyQuoteBean extends TextReplyQuoteBean {
    public void onProcessReplyQuoteBean(TUIMessageBean tUIMessageBean) {
        if (tUIMessageBean instanceof CustomEvaluationMessageBean) {
            setText(((CustomEvaluationMessageBean) tUIMessageBean).getContent());
        }
    }
}
