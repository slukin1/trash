package com.tencent.qcloud.tuikit.tuichat.interfaces;

import com.tencent.qcloud.tuikit.timcommon.bean.MessageRepliesBean;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import java.util.Map;

public interface IReplyMessageHandler {
    void onRepliesMessageFound(Map<MessageRepliesBean.ReplyBean, TUIMessageBean> map);

    void updateData(TUIMessageBean tUIMessageBean);
}
