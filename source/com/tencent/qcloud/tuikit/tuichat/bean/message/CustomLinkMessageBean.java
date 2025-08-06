package com.tencent.qcloud.tuikit.tuichat.bean.message;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.CustomHelloMessage;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.CustomLinkReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;

public class CustomLinkMessageBean extends TUIMessageBean {
    private CustomHelloMessage customHelloMessage;

    public String getLink() {
        CustomHelloMessage customHelloMessage2 = this.customHelloMessage;
        return customHelloMessage2 != null ? customHelloMessage2.link : "";
    }

    public Class<? extends TUIReplyQuoteBean> getReplyQuoteBeanClass() {
        return CustomLinkReplyQuoteBean.class;
    }

    public String getText() {
        CustomHelloMessage customHelloMessage2 = this.customHelloMessage;
        if (customHelloMessage2 != null) {
            return customHelloMessage2.text;
        }
        return getExtra();
    }

    public String onGetDisplayString() {
        return getText();
    }

    public void onProcessMessage(V2TIMMessage v2TIMMessage) {
        String str = new String(v2TIMMessage.getCustomElem().getData());
        if (!TextUtils.isEmpty(str)) {
            try {
                this.customHelloMessage = (CustomHelloMessage) new Gson().fromJson(str, CustomHelloMessage.class);
            } catch (Exception e11) {
                TUIChatLog.e("CustomLinkMessageBean", "exception e = " + e11);
            }
        }
        CustomHelloMessage customHelloMessage2 = this.customHelloMessage;
        if (customHelloMessage2 != null) {
            setExtra(customHelloMessage2.text);
        } else {
            setExtra(ServiceInitializer.getAppContext().getString(R.string.no_support_msg));
        }
    }
}
