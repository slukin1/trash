package com.tencent.qcloud.tuikit.tuichat.presenter;

import com.tencent.qcloud.tuikit.timcommon.bean.MessageReceiptInfo;
import com.tencent.qcloud.tuikit.timcommon.bean.ReactUserBean;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.message.GroupMessageReadMembersInfo;
import com.tencent.qcloud.tuikit.tuichat.model.ChatProvider;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class MessageReceiptPresenter {
    public static final int GET_MEMBERS_COUNT = 100;
    private ChatInfo chatInfo;
    /* access modifiers changed from: private */
    public ChatPresenter chatPresenter;
    private final ChatProvider provider = ChatProvider.getInstance();

    public void getGroupMessageReadMembers(TUIMessageBean tUIMessageBean, boolean z11, long j11, IUIKitCallback<GroupMessageReadMembersInfo> iUIKitCallback) {
        this.provider.getGroupMessageReadMembers(tUIMessageBean, z11, 100, j11, iUIKitCallback);
    }

    public void getGroupMessageReadReceipt(TUIMessageBean tUIMessageBean, IUIKitCallback<List<MessageReceiptInfo>> iUIKitCallback) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(tUIMessageBean);
        this.provider.getMessageReadReceipt(arrayList, iUIKitCallback);
    }

    public void setChatInfo(ChatInfo chatInfo2) {
        this.chatInfo = chatInfo2;
        if (chatInfo2.getType() == 1) {
            C2CChatPresenter c2CChatPresenter = new C2CChatPresenter();
            this.chatPresenter = c2CChatPresenter;
            c2CChatPresenter.setChatInfo(chatInfo2);
            return;
        }
        GroupChatPresenter groupChatPresenter = new GroupChatPresenter();
        this.chatPresenter = groupChatPresenter;
        groupChatPresenter.setGroupInfo((GroupInfo) chatInfo2);
    }

    public void setMessageReplyBean(final TUIMessageBean tUIMessageBean, final IUIKitCallback<Void> iUIKitCallback) {
        if (tUIMessageBean == null || tUIMessageBean.getMessageRepliesBean() == null) {
            TUIChatUtils.callbackOnSuccess(iUIKitCallback, null);
            return;
        }
        this.chatPresenter.getReactUserBean(new HashSet(this.chatPresenter.getReplyUserNames(Collections.singletonList(tUIMessageBean))), new IUIKitCallback<Map<String, ReactUserBean>>() {
            public void onError(String str, int i11, String str2) {
                TUIChatUtils.callbackOnError(iUIKitCallback, i11, str2);
            }

            public void onSuccess(Map<String, ReactUserBean> map) {
                MessageReceiptPresenter.this.chatPresenter.setMessageReplyBean(tUIMessageBean.getMessageRepliesBean(), map);
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, null);
            }
        });
    }
}
