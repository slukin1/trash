package com.tencent.qcloud.tuikit.tuichat.bean.message;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.CustomEvaluationMessageReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import java.io.Serializable;

public class CustomEvaluationMessageBean extends TUIMessageBean {
    private CustomEvaluationMessage customEvaluationMessage;

    public class CustomEvaluationMessage implements Serializable {
        public String businessID = TUIChatConstants.BUSINESS_ID_CUSTOM_EVALUATION;
        public String comment = "";
        public int score = 0;
        public int version = 0;

        public CustomEvaluationMessage() {
        }
    }

    public String getContent() {
        CustomEvaluationMessage customEvaluationMessage2 = this.customEvaluationMessage;
        return customEvaluationMessage2 != null ? customEvaluationMessage2.comment : "";
    }

    public Class<? extends TUIReplyQuoteBean> getReplyQuoteBeanClass() {
        return CustomEvaluationMessageReplyQuoteBean.class;
    }

    public int getScore() {
        CustomEvaluationMessage customEvaluationMessage2 = this.customEvaluationMessage;
        if (customEvaluationMessage2 != null) {
            return customEvaluationMessage2.score;
        }
        return 0;
    }

    public String onGetDisplayString() {
        return getExtra();
    }

    public void onProcessMessage(V2TIMMessage v2TIMMessage) {
        String str = new String(v2TIMMessage.getCustomElem().getData());
        TUIChatLog.d("CustomEvaluationMessageBean", "data = " + str);
        if (!TextUtils.isEmpty(str)) {
            try {
                this.customEvaluationMessage = (CustomEvaluationMessage) new Gson().fromJson(str, CustomEvaluationMessage.class);
            } catch (Exception e11) {
                TUIChatLog.e("CustomEvaluationMessage", "exception e = " + e11);
            }
        }
        if (this.customEvaluationMessage != null) {
            setExtra(ServiceInitializer.getAppContext().getString(R.string.custom_msg));
        } else {
            setExtra(ServiceInitializer.getAppContext().getString(R.string.no_support_msg));
        }
    }
}
