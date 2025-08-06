package com.tencent.qcloud.tuikit.tuichat.interfaces;

import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;

public interface IBaseMessageSender {
    String sendMessage(TUIMessageBean tUIMessageBean, String str, boolean z11);
}
