package com.tencent.qcloud.tuikit.tuichat.bean.message;

import cn.sharesdk.framework.InnerShareParams;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TextReplyQuoteBean;
import org.json.JSONException;
import org.json.JSONObject;

public class TextMessageBean extends TUIMessageBean {
    private String text;

    public Class<? extends TUIReplyQuoteBean> getReplyQuoteBeanClass() {
        return TextReplyQuoteBean.class;
    }

    public String getText() {
        return this.text;
    }

    public String onGetDisplayString() {
        return this.text;
    }

    public void onProcessMessage(V2TIMMessage v2TIMMessage) {
        if (this instanceof HbNoticeMessageBean) {
            try {
                JSONObject jSONObject = new JSONObject(new String(v2TIMMessage.getCustomElem().getData())).getJSONObject("data").getJSONObject(InnerShareParams.EXT_INFO);
                String string = jSONObject.getString(RemoteMessageConst.NOTIFICATION);
                String string2 = jSONObject.getString("groupId");
                ((HbNoticeMessageBean) this).setNoticeMsg(string);
                ((HbNoticeMessageBean) this).setGroupId(string2);
            } catch (JSONException e11) {
                throw new RuntimeException(e11);
            }
        } else {
            if (v2TIMMessage.getTextElem() != null) {
                this.text = v2TIMMessage.getTextElem().getText();
            }
            setExtra(this.text);
        }
    }

    public void setText(String str) {
        this.text = str;
    }
}
