package com.tencent.qcloud.tuikit.tuichat.presenter;

import android.text.TextUtils;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuikit.timcommon.bean.MessageReactBean;
import com.tencent.qcloud.tuikit.timcommon.bean.MessageRepliesBean;
import com.tencent.qcloud.tuikit.timcommon.bean.ReactUserBean;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ReplyMessageBean;
import com.tencent.qcloud.tuikit.tuichat.interfaces.C2CChatEventListener;
import com.tencent.qcloud.tuikit.tuichat.interfaces.GroupChatEventListener;
import com.tencent.qcloud.tuikit.tuichat.interfaces.IReplyMessageHandler;
import com.tencent.qcloud.tuikit.tuichat.model.ChatProvider;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

public class ReplyPresenter {
    private C2CChatEventListener c2CChatEventListener;
    /* access modifiers changed from: private */
    public ChatInfo chatInfo;
    /* access modifiers changed from: private */
    public ChatPresenter chatPresenter;
    private GroupChatEventListener groupChatEventListener;
    /* access modifiers changed from: private */
    public String messageId;
    private ChatProvider provider = ChatProvider.getInstance();
    /* access modifiers changed from: private */
    public IReplyMessageHandler replyHandler;

    /* access modifiers changed from: private */
    public void onMessageModified(TUIMessageBean tUIMessageBean) {
        IReplyMessageHandler iReplyMessageHandler = this.replyHandler;
        if (iReplyMessageHandler != null) {
            iReplyMessageHandler.updateData(tUIMessageBean);
        }
    }

    /* access modifiers changed from: private */
    public void processReplyBeanList(final Map<MessageRepliesBean.ReplyBean, TUIMessageBean> map) {
        HashSet hashSet = new HashSet();
        for (Map.Entry next : map.entrySet()) {
            if (next.getValue() == null) {
                hashSet.add(((MessageRepliesBean.ReplyBean) next.getKey()).getMessageSender());
            }
        }
        if (hashSet.isEmpty()) {
            IReplyMessageHandler iReplyMessageHandler = this.replyHandler;
            if (iReplyMessageHandler != null) {
                iReplyMessageHandler.onRepliesMessageFound(map);
                return;
            }
            return;
        }
        this.chatPresenter.getReactUserBean(hashSet, new IUIKitCallback<Map<String, ReactUserBean>>() {
            public void onError(String str, int i11, String str2) {
                if (ReplyPresenter.this.replyHandler != null) {
                    ReplyPresenter.this.replyHandler.onRepliesMessageFound(map);
                }
            }

            public void onSuccess(Map<String, ReactUserBean> map) {
                for (Map.Entry next : map.entrySet()) {
                    if (next.getValue() != null) {
                        String str = (String) next.getKey();
                        ReactUserBean reactUserBean = (ReactUserBean) next.getValue();
                        for (Map.Entry entry : map.entrySet()) {
                            if (TextUtils.equals(((MessageRepliesBean.ReplyBean) entry.getKey()).getMessageSender(), str)) {
                                ((MessageRepliesBean.ReplyBean) entry.getKey()).setSenderShowName(reactUserBean.getDisplayString());
                                ((MessageRepliesBean.ReplyBean) entry.getKey()).setSenderFaceUrl(reactUserBean.getFaceUrl());
                            }
                        }
                    }
                }
                if (ReplyPresenter.this.replyHandler != null) {
                    ReplyPresenter.this.replyHandler.onRepliesMessageFound(map);
                }
            }
        });
    }

    public void findReplyMessages(MessageRepliesBean messageRepliesBean) {
        if (messageRepliesBean != null && messageRepliesBean.getRepliesSize() != 0) {
            final List<MessageRepliesBean.ReplyBean> replies = messageRepliesBean.getReplies();
            ArrayList arrayList = new ArrayList(replies.size());
            for (MessageRepliesBean.ReplyBean messageID : replies) {
                arrayList.add(messageID.getMessageID());
            }
            final LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (MessageRepliesBean.ReplyBean put : replies) {
                linkedHashMap.put(put, (Object) null);
            }
            this.chatPresenter.findMessage((List<String>) arrayList, (IUIKitCallback<List<TUIMessageBean>>) new IUIKitCallback<List<TUIMessageBean>>() {
                public void onError(String str, int i11, String str2) {
                    ReplyPresenter.this.processReplyBeanList(linkedHashMap);
                }

                public void onSuccess(List<TUIMessageBean> list) {
                    for (MessageRepliesBean.ReplyBean replyBean : replies) {
                        ListIterator<TUIMessageBean> listIterator = list.listIterator();
                        while (true) {
                            if (!listIterator.hasNext()) {
                                break;
                            }
                            TUIMessageBean next = listIterator.next();
                            if (TextUtils.equals(next.getId(), replyBean.getMessageID())) {
                                linkedHashMap.put(replyBean, next);
                                listIterator.remove();
                                break;
                            }
                        }
                    }
                    ReplyPresenter.this.processReplyBeanList(linkedHashMap);
                }
            });
        }
    }

    public ChatPresenter getChatPresenter() {
        return this.chatPresenter;
    }

    public void getReactUserBean(TUIMessageBean tUIMessageBean, final IUIKitCallback<Void> iUIKitCallback) {
        final ArrayList arrayList = new ArrayList();
        arrayList.add(tUIMessageBean);
        Set<String> reactUserNames = this.chatPresenter.getReactUserNames(arrayList);
        if (reactUserNames.isEmpty()) {
            TUIChatUtils.callbackOnSuccess(iUIKitCallback, null);
        } else {
            this.chatPresenter.getReactUserBean(reactUserNames, new IUIKitCallback<Map<String, ReactUserBean>>() {
                public void onError(String str, int i11, String str2) {
                    TUIChatUtils.callbackOnError(iUIKitCallback, i11, str2);
                }

                public void onSuccess(Map<String, ReactUserBean> map) {
                    for (TUIMessageBean messageReactBean : arrayList) {
                        MessageReactBean messageReactBean2 = messageReactBean.getMessageReactBean();
                        if (messageReactBean2 != null) {
                            messageReactBean2.setReactUserBeanMap(map);
                        }
                    }
                    TUIChatUtils.callbackOnSuccess(iUIKitCallback, null);
                }
            });
        }
    }

    public void sendReplyMessage(TUIMessageBean tUIMessageBean, final IUIKitCallback<TUIMessageBean> iUIKitCallback) {
        this.chatPresenter.sendMessage(tUIMessageBean, false, (IUIKitCallback<TUIMessageBean>) new IUIKitCallback<TUIMessageBean>() {
            public void onError(String str, int i11, String str2) {
                TUIChatUtils.callbackOnError(iUIKitCallback, i11, str2);
            }

            public void onSuccess(TUIMessageBean tUIMessageBean) {
                HashMap hashMap = new HashMap();
                hashMap.put("chatId", ReplyPresenter.this.chatInfo.getId());
                hashMap.put("messageBean", tUIMessageBean);
                hashMap.put(TUIConstants.TUIChat.IS_GROUP_CHAT, Boolean.valueOf(ReplyPresenter.this.chatInfo.getType() == 2));
                TUICore.callService("TUIChatService", TUIConstants.TUIChat.METHOD_ADD_MESSAGE_TO_CHAT, hashMap);
                ReplyPresenter.this.chatPresenter.modifyRootMessageToAddReplyInfo((ReplyMessageBean) tUIMessageBean, (IUIKitCallback<Void>) new IUIKitCallback<Void>() {
                    public void onError(String str, int i11, String str2) {
                        TUIChatUtils.callbackOnError(iUIKitCallback, i11, str2);
                    }
                });
            }
        });
    }

    public void setChatEventListener() {
        if (this.chatPresenter instanceof C2CChatPresenter) {
            this.c2CChatEventListener = new C2CChatEventListener() {
                public void onRecvMessageModified(TUIMessageBean tUIMessageBean) {
                    if (TextUtils.equals(tUIMessageBean.getId(), ReplyPresenter.this.messageId)) {
                        ReplyPresenter.this.onMessageModified(tUIMessageBean);
                    }
                }
            };
            TUIChatService.getInstance().addC2CChatEventListener(this.c2CChatEventListener);
            return;
        }
        this.groupChatEventListener = new GroupChatEventListener() {
            public void onRecvMessageModified(TUIMessageBean tUIMessageBean) {
                if (TextUtils.equals(tUIMessageBean.getId(), ReplyPresenter.this.messageId)) {
                    ReplyPresenter.this.onMessageModified(tUIMessageBean);
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

    public void setReplyHandler(IReplyMessageHandler iReplyMessageHandler) {
        this.replyHandler = iReplyMessageHandler;
    }
}
