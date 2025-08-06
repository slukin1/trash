package com.tencent.imsdk.message;

import com.tencent.imsdk.BaseConstants;
import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.common.IMContext;
import com.tencent.imsdk.common.IMLog;
import com.tencent.imsdk.conversation.ConversationKey;
import com.tencent.imsdk.manager.BaseManager;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MessageCenter {
    private static final String TAG = "MessageCenter";
    /* access modifiers changed from: private */
    public Object mLockObject = new Object();
    private MessageListener mMessageListener;
    /* access modifiers changed from: private */
    public CopyOnWriteArrayList<MessageListener> mMessageProxyListenerList = new CopyOnWriteArrayList<>();

    public static class MessageCenterHolder {
        /* access modifiers changed from: private */
        public static final MessageCenter messageCenter = new MessageCenter();

        private MessageCenterHolder() {
        }
    }

    public static MessageCenter getInstance() {
        return MessageCenterHolder.messageCenter;
    }

    private void initMessageListener() {
        AnonymousClass1 r02 = new MessageListener() {
            public void onReceiveC2CMessageReceipt(final List<C2CMessageReceipt> list) {
                IMContext.getInstance().runOnMainThread(new Runnable() {
                    public void run() {
                        synchronized (MessageCenter.this.mLockObject) {
                            Iterator it2 = MessageCenter.this.mMessageProxyListenerList.iterator();
                            while (it2.hasNext()) {
                                ((MessageListener) it2.next()).onReceiveC2CMessageReceipt(list);
                            }
                        }
                    }
                });
            }

            public void onReceiveGroupMessageReceipt(final List<GroupMessageReceipt> list) {
                IMContext.getInstance().runOnMainThread(new Runnable() {
                    public void run() {
                        Iterator it2 = MessageCenter.this.mMessageProxyListenerList.iterator();
                        while (it2.hasNext()) {
                            ((MessageListener) it2.next()).onReceiveGroupMessageReceipt(list);
                        }
                    }
                });
            }

            public void onReceiveMessageExtensionsChanged(final MessageKey messageKey, final List<MessageExtension> list) {
                IMContext.getInstance().runOnMainThread(new Runnable() {
                    public void run() {
                        synchronized (MessageCenter.this.mLockObject) {
                            Iterator it2 = MessageCenter.this.mMessageProxyListenerList.iterator();
                            while (it2.hasNext()) {
                                ((MessageListener) it2.next()).onReceiveMessageExtensionsChanged(messageKey, list);
                            }
                        }
                    }
                });
            }

            public void onReceiveMessageExtensionsDeleted(final MessageKey messageKey, final List<MessageExtension> list) {
                IMContext.getInstance().runOnMainThread(new Runnable() {
                    public void run() {
                        synchronized (MessageCenter.this.mLockObject) {
                            Iterator it2 = MessageCenter.this.mMessageProxyListenerList.iterator();
                            while (it2.hasNext()) {
                                ((MessageListener) it2.next()).onReceiveMessageExtensionsDeleted(messageKey, list);
                            }
                        }
                    }
                });
            }

            public void onReceiveMessageModified(final List<Message> list) {
                IMContext.getInstance().runOnMainThread(new Runnable() {
                    public void run() {
                        synchronized (MessageCenter.this.mLockObject) {
                            Iterator it2 = MessageCenter.this.mMessageProxyListenerList.iterator();
                            while (it2.hasNext()) {
                                ((MessageListener) it2.next()).onReceiveMessageModified(list);
                            }
                        }
                    }
                });
            }

            public void onReceiveMessageRevoked(final List<MessageKey> list) {
                IMContext.getInstance().runOnMainThread(new Runnable() {
                    public void run() {
                        synchronized (MessageCenter.this.mLockObject) {
                            Iterator it2 = MessageCenter.this.mMessageProxyListenerList.iterator();
                            while (it2.hasNext()) {
                                ((MessageListener) it2.next()).onReceiveMessageRevoked(list);
                            }
                        }
                    }
                });
            }

            public void onReceiveNewMessage(final List<Message> list) {
                IMContext.getInstance().runOnMainThread(new Runnable() {
                    public void run() {
                        synchronized (MessageCenter.this.mLockObject) {
                            Iterator it2 = MessageCenter.this.mMessageProxyListenerList.iterator();
                            while (it2.hasNext()) {
                                ((MessageListener) it2.next()).onReceiveNewMessage(list);
                            }
                        }
                    }
                });
            }
        };
        this.mMessageListener = r02;
        nativeSetMessageListener(r02);
    }

    public void addMessageListener(MessageListener messageListener) {
        synchronized (this.mLockObject) {
            this.mMessageProxyListenerList.add(messageListener);
        }
    }

    public void clearC2CHistoryMessage(String str, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeClearC2CHistoryMessage(str, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void clearGroupHistoryMessage(String str, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeClearGroupHistoryMessage(str, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void clearLocalHistoryMessage(ConversationKey conversationKey, long j11, long j12, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeClearLocalHistoryMessage(conversationKey, j11, j12, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void deleteCloudMessageList(List<MessageKey> list, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeDeleteCloudMessageList(list, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void deleteLocalMessage(MessageKey messageKey, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeDeleteLocalMessage(messageKey, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void deleteMessageExtensions(Message message, List<String> list, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeDeleteMessageExtensions(message, list, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void downloadMessageElement(DownloadParam downloadParam, IMCallback<DownloadProgressInfo> iMCallback, IMCallback iMCallback2) {
        if (BaseManager.getInstance().isInited()) {
            nativeDownloadMessageElement(downloadParam, iMCallback, iMCallback2);
        } else if (iMCallback2 != null) {
            iMCallback2.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void downloadRelayMessageList(Message message, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeDownloadRelayMessageList(message, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void findMessageByMessageId(List<String> list, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeFindMessageByMessageID(list, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void findMessageBySearchKey(MessageSearchParam messageSearchParam, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeFindMessageBySearchKey(messageSearchParam, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void getC2CHistoryMessageList(String str, MessageListGetOption messageListGetOption, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeGetC2CHistoryMessageList(str, messageListGetOption, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void getGroupHistoryMessageList(String str, MessageListGetOption messageListGetOption, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeGetGroupHistoryMessageList(str, messageListGetOption, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void getGroupMessageReadMembers(Message message, int i11, long j11, int i12, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeGetGroupMessageReadMembers(message, i11, j11, i12, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void getGroupMessageReceipts(List<MessageKey> list, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeGetGroupMessageReceipts(list, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void getMessageExtensions(Message message, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeGetMessageExtensions(message, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void init() {
        initMessageListener();
    }

    public String insertLocalMessage(Message message, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            return nativeInsertLocalMessage(message, iMCallback);
        }
        if (iMCallback == null) {
            return null;
        }
        iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        return null;
    }

    public boolean isMessagePeerRead(MessageKey messageKey) {
        if (BaseManager.getInstance().isInited()) {
            return nativeIsMessagePeerRead(messageKey);
        }
        IMLog.e(TAG, "sdk not ini");
        return false;
    }

    public boolean isMessageSelfRead(MessageKey messageKey) {
        if (BaseManager.getInstance().isInited()) {
            return nativeIsMessageSelfRead(messageKey);
        }
        IMLog.e(TAG, "sdk not ini");
        return false;
    }

    public void modifyMessage(Message message, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeModifyMessage(message, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public native void nativeClearC2CHistoryMessage(String str, IMCallback iMCallback);

    public native void nativeClearGroupHistoryMessage(String str, IMCallback iMCallback);

    public native void nativeClearLocalHistoryMessage(ConversationKey conversationKey, long j11, long j12, IMCallback iMCallback);

    public native void nativeDeleteCloudMessageList(List<MessageKey> list, IMCallback iMCallback);

    public native void nativeDeleteLocalMessage(MessageKey messageKey, IMCallback iMCallback);

    public native void nativeDeleteMessageExtensions(Message message, List<String> list, IMCallback iMCallback);

    public native void nativeDownloadMessageElement(DownloadParam downloadParam, IMCallback iMCallback, IMCallback iMCallback2);

    public native void nativeDownloadRelayMessageList(Message message, IMCallback iMCallback);

    public native void nativeFindMessageByMessageID(List<String> list, IMCallback iMCallback);

    public native void nativeFindMessageBySearchKey(MessageSearchParam messageSearchParam, IMCallback iMCallback);

    public native void nativeGetC2CHistoryMessageList(String str, MessageListGetOption messageListGetOption, IMCallback iMCallback);

    public native void nativeGetGroupHistoryMessageList(String str, MessageListGetOption messageListGetOption, IMCallback iMCallback);

    public native void nativeGetGroupMessageReadMembers(Message message, int i11, long j11, int i12, IMCallback iMCallback);

    public native void nativeGetGroupMessageReceipts(List<MessageKey> list, IMCallback iMCallback);

    public native void nativeGetMessageExtensions(Message message, IMCallback iMCallback);

    public native String nativeInsertLocalMessage(Message message, IMCallback iMCallback);

    public native boolean nativeIsMessagePeerRead(MessageKey messageKey);

    public native boolean nativeIsMessageSelfRead(MessageKey messageKey);

    public native void nativeModifyMessage(Message message, IMCallback iMCallback);

    public native void nativeRevokeMessage(MessageKey messageKey, IMCallback iMCallback);

    public native String nativeSendMessage(Message message, MessageUploadProgressCallback messageUploadProgressCallback, IMCallback iMCallback);

    public native void nativeSendMessageReceipts(List<MessageKey> list, IMCallback iMCallback);

    public native void nativeSetC2CMessageRead(String str, long j11, IMCallback iMCallback);

    public native void nativeSetGroupMessageRead(String str, long j11, IMCallback iMCallback);

    public native void nativeSetLocalCustomNumber(Message message, int i11);

    public native void nativeSetLocalCustomString(Message message, String str);

    public native void nativeSetMessageExtensions(Message message, List<MessageExtension> list, IMCallback iMCallback);

    public native void nativeSetMessageListener(MessageListener messageListener);

    public native void nativeTranslateText(List<String> list, String str, String str2, IMCallback iMCallback);

    public void revokeMessage(MessageKey messageKey, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeRevokeMessage(messageKey, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public String sendMessage(Message message, MessageUploadProgressCallback messageUploadProgressCallback, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            return nativeSendMessage(message, messageUploadProgressCallback, iMCallback);
        }
        if (iMCallback == null) {
            return null;
        }
        iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        return null;
    }

    public void sendMessageReceipts(List<MessageKey> list, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeSendMessageReceipts(list, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void setC2CMessageRead(String str, long j11, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeSetC2CMessageRead(str, j11, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void setGroupMessageRead(String str, long j11, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeSetGroupMessageRead(str, j11, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void setLocalCustomNumber(Message message, int i11) {
        nativeSetLocalCustomNumber(message, i11);
    }

    public void setLocalCustomString(Message message, String str) {
        nativeSetLocalCustomString(message, str);
    }

    public void setMessageExtensions(Message message, List<MessageExtension> list, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeSetMessageExtensions(message, list, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void translateText(List<String> list, String str, String str2, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeTranslateText(list, str, str2, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }
}
