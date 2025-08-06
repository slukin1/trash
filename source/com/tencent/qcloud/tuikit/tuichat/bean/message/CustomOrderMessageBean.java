package com.tencent.qcloud.tuikit.tuichat.bean.message;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.CustomOrderMessageReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import java.io.Serializable;

public class CustomOrderMessageBean extends TUIMessageBean {
    private CustomOrderMessage orderMessage;

    public class CustomOrderMessage implements Serializable {
        public String businessID = TUIChatConstants.BUSINESS_ID_CUSTOM_ORDER;
        public String description = "";
        public String imageUrl = "";
        public String link = "";
        public String price = "";
        public String title = "";
        public int version = 0;

        public CustomOrderMessage() {
        }
    }

    public String getDescription() {
        CustomOrderMessage customOrderMessage = this.orderMessage;
        return customOrderMessage != null ? customOrderMessage.description : "";
    }

    public String getImageUrl() {
        CustomOrderMessage customOrderMessage = this.orderMessage;
        return customOrderMessage != null ? customOrderMessage.imageUrl : "";
    }

    public String getLink() {
        CustomOrderMessage customOrderMessage = this.orderMessage;
        return customOrderMessage != null ? customOrderMessage.link : "";
    }

    public String getPrice() {
        CustomOrderMessage customOrderMessage = this.orderMessage;
        return customOrderMessage != null ? customOrderMessage.price : "";
    }

    public Class<? extends TUIReplyQuoteBean> getReplyQuoteBeanClass() {
        return CustomOrderMessageReplyQuoteBean.class;
    }

    public String getTitle() {
        CustomOrderMessage customOrderMessage = this.orderMessage;
        return customOrderMessage != null ? customOrderMessage.title : "";
    }

    public String onGetDisplayString() {
        return getExtra();
    }

    public void onProcessMessage(V2TIMMessage v2TIMMessage) {
        String str = new String(v2TIMMessage.getCustomElem().getData());
        TUIChatLog.d("CustomOrderMessageBean", "data = " + str);
        if (!TextUtils.isEmpty(str)) {
            try {
                this.orderMessage = (CustomOrderMessage) new Gson().fromJson(str, CustomOrderMessage.class);
            } catch (Exception e11) {
                TUIChatLog.e("CustomOrderMessageBean", "exception e = " + e11);
            }
        }
        if (this.orderMessage != null) {
            setExtra(ServiceInitializer.getAppContext().getString(R.string.custom_msg));
        } else {
            setExtra(ServiceInitializer.getAppContext().getString(R.string.no_support_msg));
        }
    }
}
