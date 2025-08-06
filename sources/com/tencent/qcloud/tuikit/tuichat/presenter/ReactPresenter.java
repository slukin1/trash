package com.tencent.qcloud.tuikit.tuichat.presenter;

import android.text.TextUtils;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupInfo;
import com.tencent.qcloud.tuikit.tuichat.interfaces.C2CChatEventListener;
import com.tencent.qcloud.tuikit.tuichat.interfaces.GroupChatEventListener;
import com.tencent.qcloud.tuikit.tuichat.model.ChatProvider;
import java.util.Collections;
import java.util.List;

public class ReactPresenter {
    private C2CChatEventListener c2CChatEventListener;
    private ChatInfo chatInfo;
    private ChatPresenter chatPresenter;
    private GroupChatEventListener groupChatEventListener;
    /* access modifiers changed from: private */
    public String messageId;
    /* access modifiers changed from: private */
    public OnMessageChangedListener onMessageChangedListener;
    private ChatProvider provider = ChatProvider.getInstance();

    public interface OnMessageChangedListener {
        void onMessageChanged(TUIMessageBean tUIMessageBean);
    }

    /* access modifiers changed from: private */
    public void onMessageChanged(final TUIMessageBean tUIMessageBean) {
        this.chatPresenter.preProcessMessage((List<TUIMessageBean>) Collections.singletonList(tUIMessageBean), (IUIKitCallback<List<TUIMessageBean>>) new IUIKitCallback<List<TUIMessageBean>>() {
            public void onError(String str, int i11, String str2) {
                if (ReactPresenter.this.onMessageChangedListener != null) {
                    ReactPresenter.this.onMessageChangedListener.onMessageChanged(tUIMessageBean);
                }
            }

            public void onSuccess(List<TUIMessageBean> list) {
                if (ReactPresenter.this.onMessageChangedListener != null) {
                    ReactPresenter.this.onMessageChangedListener.onMessageChanged(list.get(0));
                }
            }
        });
    }

    public void setChatEventListener() {
        if (this.chatPresenter instanceof C2CChatPresenter) {
            this.c2CChatEventListener = new C2CChatEventListener() {
                public void onRecvMessageModified(TUIMessageBean tUIMessageBean) {
                    if (TextUtils.equals(tUIMessageBean.getId(), ReactPresenter.this.messageId)) {
                        ReactPresenter.this.onMessageChanged(tUIMessageBean);
                    }
                }
            };
            TUIChatService.getInstance().addC2CChatEventListener(this.c2CChatEventListener);
            return;
        }
        this.groupChatEventListener = new GroupChatEventListener() {
            public void onRecvMessageModified(TUIMessageBean tUIMessageBean) {
                if (TextUtils.equals(tUIMessageBean.getId(), ReactPresenter.this.messageId)) {
                    ReactPresenter.this.onMessageChanged(tUIMessageBean);
                }
            }
        };
        TUIChatService.getInstance().addGroupChatEventListener(this.groupChatEventListener);
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

    public void setMessageId(String str) {
        this.messageId = str;
    }

    public void setMessageListener(OnMessageChangedListener onMessageChangedListener2) {
        this.onMessageChangedListener = onMessageChangedListener2;
    }
}
