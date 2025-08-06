package com.tencent.qcloud.tuikit.tuichat.presenter;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.qcloud.tuikit.timcommon.bean.MessageFeature;
import com.tencent.qcloud.tuikit.timcommon.bean.MessageReceiptInfo;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.message.MessageTypingBean;
import com.tencent.qcloud.tuikit.tuichat.interfaces.C2CChatEventListener;
import com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class C2CChatPresenter extends ChatPresenter {
    /* access modifiers changed from: private */
    public static final String TAG = "C2CChatPresenter";
    private C2CChatEventListener chatEventListener;
    /* access modifiers changed from: private */
    public ChatInfo chatInfo;
    private ChatPresenter.TypingListener typingListener;

    public C2CChatPresenter() {
        TUIChatLog.i(TAG, "C2CChatPresenter Init");
    }

    /* access modifiers changed from: private */
    public void parseTypingMessage(MessageTypingBean messageTypingBean) {
        ChatPresenter.TypingListener typingListener2 = this.typingListener;
        if (typingListener2 == null) {
            TUIChatLog.e(TAG, "parseTypingMessage typingListener is null");
        } else {
            typingListener2.onTyping(messageTypingBean.getTypingStatus());
        }
    }

    public void getChatFaceUrl(String str, final IUIKitCallback<List<Object>> iUIKitCallback) {
        if (!TextUtils.isEmpty(str)) {
            this.provider.getChatFaceUrl(str, false, new IUIKitCallback<String>() {
                public void onError(String str, int i11, String str2) {
                    TUIChatUtils.callbackOnError(iUIKitCallback, i11, str2);
                }

                public void onSuccess(String str) {
                    TUIChatUtils.callbackOnSuccess(iUIKitCallback, Collections.singletonList(str));
                }
            });
        }
    }

    public ChatInfo getChatInfo() {
        return this.chatInfo;
    }

    public void getChatName(final String str, final IUIKitCallback<String> iUIKitCallback) {
        if (!TextUtils.isEmpty(str)) {
            this.provider.getChatName(str, false, new IUIKitCallback<String>() {
                public void onError(String str, int i11, String str2) {
                    TUIChatUtils.callbackOnSuccess(iUIKitCallback, str);
                }

                public void onSuccess(String str) {
                    TUIChatUtils.callbackOnSuccess(iUIKitCallback, str);
                }
            });
        }
    }

    public void initListener() {
        this.chatEventListener = new C2CChatEventListener() {
            public void addMessage(TUIMessageBean tUIMessageBean, String str) {
                if (TextUtils.equals(str, C2CChatPresenter.this.chatInfo.getId())) {
                    C2CChatPresenter.this.addMessageInfo(tUIMessageBean);
                }
            }

            public void clearC2CMessage(String str) {
                if (TextUtils.equals(str, C2CChatPresenter.this.chatInfo.getId())) {
                    C2CChatPresenter.this.clearMessage();
                }
            }

            public void exitC2CChat(String str) {
                C2CChatPresenter.this.onExitChat(str);
            }

            public void handleRevoke(String str) {
                C2CChatPresenter.this.handleRevoke(str);
            }

            public void onFriendFaceUrlChanged(String str, String str2) {
                C2CChatPresenter.this.onFriendFaceUrlChanged(str, str2);
            }

            public void onFriendNameChanged(String str, String str2) {
                if (C2CChatPresenter.this.chatInfo != null && TextUtils.equals(str, C2CChatPresenter.this.chatInfo.getId())) {
                    C2CChatPresenter.this.onFriendInfoChanged();
                }
            }

            public void onMessageChanged(TUIMessageBean tUIMessageBean, int i11) {
                C2CChatPresenter.this.updateMessageInfo(tUIMessageBean, i11);
            }

            public void onReadReport(List<MessageReceiptInfo> list) {
                C2CChatPresenter.this.onReadReport(list);
            }

            public void onRecvMessageModified(TUIMessageBean tUIMessageBean) {
                if (C2CChatPresenter.this.chatInfo != null && TextUtils.equals(tUIMessageBean.getUserId(), C2CChatPresenter.this.chatInfo.getId())) {
                    C2CChatPresenter.this.onRecvMessageModified(tUIMessageBean);
                }
            }

            public void onRecvNewMessage(TUIMessageBean tUIMessageBean) {
                if (C2CChatPresenter.this.chatInfo == null || !TextUtils.equals(tUIMessageBean.getUserId(), C2CChatPresenter.this.chatInfo.getId())) {
                    TUIChatLog.i(C2CChatPresenter.TAG, "receive a new message , not belong to current chat.");
                } else if (tUIMessageBean instanceof MessageTypingBean) {
                    C2CChatPresenter.this.parseTypingMessage((MessageTypingBean) tUIMessageBean);
                } else {
                    C2CChatPresenter.this.onRecvNewMessage(tUIMessageBean);
                }
            }
        };
        TUIChatService.getInstance().addC2CChatEventListener(this.chatEventListener);
        initMessageSender();
    }

    public boolean isSupportTyping(long j11) {
        List<TUIMessageBean> list = this.loadedMessageInfoList;
        if (list != null && list.size() != 0) {
            int size = this.loadedMessageInfoList.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                TUIMessageBean tUIMessageBean = this.loadedMessageInfoList.get(size);
                if (!tUIMessageBean.isSelf()) {
                    MessageFeature isSupportTyping = tUIMessageBean.isSupportTyping();
                    if (isSupportTyping == null || isSupportTyping.getNeedTyping() != 1 || ((int) (j11 - tUIMessageBean.getMessageTime())) >= 30) {
                        return false;
                    }
                    return true;
                }
                size--;
            }
        }
        return false;
    }

    public void loadMessage(final int i11, final TUIMessageBean tUIMessageBean, final IUIKitCallback<List<TUIMessageBean>> iUIKitCallback) {
        ChatInfo chatInfo2 = this.chatInfo;
        if (chatInfo2 != null && !this.isLoading) {
            this.isLoading = true;
            String id2 = chatInfo2.getId();
            if (i11 == 0) {
                this.provider.loadC2CMessage(id2, 20, tUIMessageBean, new IUIKitCallback<List<TUIMessageBean>>() {
                    public void onError(String str, int i11, String str2) {
                        String access$100 = C2CChatPresenter.TAG;
                        TUIChatLog.e(access$100, "load c2c message failed " + i11 + "  " + str2);
                        TUIChatUtils.callbackOnError(iUIKitCallback, i11, str2);
                    }

                    public void onSuccess(List<TUIMessageBean> list) {
                        String access$100 = C2CChatPresenter.TAG;
                        TUIChatLog.i(access$100, "load c2c message success " + list.size());
                        if (tUIMessageBean == null) {
                            C2CChatPresenter.this.isHaveMoreNewMessage = false;
                        }
                        if (list.size() < 20) {
                            C2CChatPresenter.this.isHaveMoreOldMessage = false;
                        }
                        TUIChatUtils.callbackOnSuccess(iUIKitCallback, list);
                        C2CChatPresenter.this.onMessageLoadCompleted(list, i11);
                    }
                });
            } else {
                loadHistoryMessageList(id2, false, i11, 20, tUIMessageBean, iUIKitCallback);
            }
        }
    }

    public void onFriendFaceUrlChanged(String str, String str2) {
        WeakReference<ChatPresenter.ChatNotifyHandler> weakReference;
        if (TextUtils.equals(str, this.chatInfo.getId()) && (weakReference = this.chatNotifyHandler) != null && weakReference.get() != null) {
            ((ChatPresenter.ChatNotifyHandler) this.chatNotifyHandler.get()).onFriendFaceUrlChanged(str2);
        }
    }

    public void onFriendInfoChanged() {
        this.provider.getFriendName(this.chatInfo.getId(), new IUIKitCallback<String[]>() {
            public void onError(String str, int i11, String str2) {
            }

            public void onSuccess(String[] strArr) {
                String id2 = C2CChatPresenter.this.chatInfo.getId();
                if (!TextUtils.isEmpty(strArr[0])) {
                    id2 = strArr[0];
                } else if (!TextUtils.isEmpty(strArr[1])) {
                    id2 = strArr[1];
                }
                C2CChatPresenter.this.onFriendNameChanged(id2);
            }
        });
    }

    public void onFriendNameChanged(String str) {
        WeakReference<ChatPresenter.ChatNotifyHandler> weakReference = this.chatNotifyHandler;
        if (weakReference != null && weakReference.get() != null) {
            ((ChatPresenter.ChatNotifyHandler) this.chatNotifyHandler.get()).onFriendNameChanged(str);
        }
    }

    public void onMessageLoadCompleted(List<TUIMessageBean> list, int i11) {
        c2cReadReport(this.chatInfo.getId());
        getMessageReadReceipt(list, i11);
    }

    public void onReadReport(List<MessageReceiptInfo> list) {
        if (this.chatInfo != null) {
            ArrayList arrayList = new ArrayList();
            for (MessageReceiptInfo next : list) {
                if (TextUtils.equals(next.getUserID(), this.chatInfo.getId())) {
                    arrayList.add(next);
                }
            }
            onMessageReadReceiptUpdated(this.loadedMessageInfoList, arrayList);
        }
    }

    public void sendTypingStatusMessage(final TUIMessageBean tUIMessageBean, String str, final IUIKitCallback<TUIMessageBean> iUIKitCallback) {
        if (!safetyCall()) {
            TUIChatLog.e(TAG, "sendTypingStatusMessage unSafetyCall");
        } else if (tUIMessageBean == null || tUIMessageBean.getStatus() == 1) {
            TUIChatLog.e(TAG, "message is null");
        } else {
            String sendTypingStatusMessage = this.provider.sendTypingStatusMessage(tUIMessageBean, str, new IUIKitCallback<TUIMessageBean>() {
                public void onError(String str, int i11, String str2) {
                    String access$100 = C2CChatPresenter.TAG;
                    TUIChatLog.v(access$100, "sendTypingStatusMessage fail:" + i11 + ContainerUtils.KEY_VALUE_DELIMITER + str2);
                    if (!C2CChatPresenter.this.safetyCall()) {
                        TUIChatLog.w(C2CChatPresenter.TAG, "sendTypingStatusMessage unSafetyCall");
                        return;
                    }
                    TUIChatUtils.callbackOnError(iUIKitCallback, C2CChatPresenter.TAG, i11, str2);
                    tUIMessageBean.setStatus(3);
                }

                public void onProgress(Object obj) {
                    TUIChatUtils.callbackOnProgress(iUIKitCallback, obj);
                }

                public void onSuccess(TUIMessageBean tUIMessageBean) {
                    String access$100 = C2CChatPresenter.TAG;
                    TUIChatLog.v(access$100, "sendTypingStatusMessage onSuccess:" + tUIMessageBean.getId());
                    if (!C2CChatPresenter.this.safetyCall()) {
                        TUIChatLog.w(C2CChatPresenter.TAG, "sendTypingStatusMessage unSafetyCall");
                        return;
                    }
                    tUIMessageBean.setStatus(2);
                    TUIChatUtils.callbackOnSuccess(iUIKitCallback, tUIMessageBean);
                }
            });
            String str2 = TAG;
            TUIChatLog.i(str2, "sendTypingStatusMessage msgID:" + sendTypingStatusMessage);
            tUIMessageBean.setId(sendTypingStatusMessage);
            tUIMessageBean.setStatus(1);
        }
    }

    public void setChatInfo(ChatInfo chatInfo2) {
        this.chatInfo = chatInfo2;
    }

    public void setTypingListener(ChatPresenter.TypingListener typingListener2) {
        this.typingListener = typingListener2;
    }
}
