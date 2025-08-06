package com.tencent.qcloud.tuikit.tuichat.bean.message;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.MessageTyping;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;

public class MessageTypingBean extends TUIMessageBean {
    private MessageTyping messageTyping;

    public int getTypingStatus() {
        MessageTyping messageTyping2 = this.messageTyping;
        if (messageTyping2 != null) {
            return messageTyping2.typingStatus;
        }
        return 0;
    }

    public String onGetDisplayString() {
        return null;
    }

    public void onProcessMessage(V2TIMMessage v2TIMMessage) {
        String str = new String(v2TIMMessage.getCustomElem().getData());
        TUIChatLog.d("messageTypingBean", "data = " + str);
        if (!TextUtils.isEmpty(str)) {
            try {
                this.messageTyping = (MessageTyping) new Gson().fromJson(str, MessageTyping.class);
            } catch (Exception e11) {
                TUIChatLog.e("messageTyping", "exception e = " + e11);
            }
        }
        if (this.messageTyping == null) {
            TUIChatLog.e("messageTypingBean", "messageTyping is null");
        }
    }
}
