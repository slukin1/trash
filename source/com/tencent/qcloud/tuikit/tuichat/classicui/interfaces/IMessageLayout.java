package com.tencent.qcloud.tuikit.tuichat.classicui.interfaces;

import com.tencent.qcloud.tuikit.timcommon.interfaces.IMessageProperties;
import com.tencent.qcloud.tuikit.timcommon.interfaces.OnItemClickListener;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageAdapter;
import java.util.List;

public interface IMessageLayout extends IMessageProperties {
    void addPopAction(ChatPopMenuAction chatPopMenuAction);

    OnItemClickListener getOnItemClickListener();

    List<ChatPopMenuAction> getPopActions();

    void setAdapter(MessageAdapter messageAdapter);

    void setOnItemClickListener(OnItemClickListener onItemClickListener);
}
