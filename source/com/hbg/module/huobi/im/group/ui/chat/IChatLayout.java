package com.hbg.module.huobi.im.group.ui.chat;

import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.component.interfaces.ILayout;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.noticelayout.NoticeLayout;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView;

public interface IChatLayout extends ILayout {
    void exitChat();

    ChatInfo getChatInfo();

    InputView getInputLayout();

    MessageRecyclerView getMessageLayout();

    NoticeLayout getNoticeLayout();

    void initDefault();

    void loadMessages(int i11);

    void sendMessage(TUIMessageBean tUIMessageBean, boolean z11);

    void setChatInfo(ChatInfo chatInfo);
}
