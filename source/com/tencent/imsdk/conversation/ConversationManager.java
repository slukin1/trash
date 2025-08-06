package com.tencent.imsdk.conversation;

import com.tencent.imsdk.BaseConstants;
import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.common.IMContext;
import com.tencent.imsdk.manager.BaseManager;
import com.tencent.imsdk.message.DraftMessage;
import java.util.List;

public class ConversationManager {
    private static final String TAG = "ConversationManager";
    /* access modifiers changed from: private */
    public ConversationListener mConversationListener;
    private ConversationListener mInternalConversationListener;

    public static class ConversationManagerHolder {
        /* access modifiers changed from: private */
        public static final ConversationManager conversationManager = new ConversationManager();

        private ConversationManagerHolder() {
        }
    }

    public static ConversationManager getInstance() {
        return ConversationManagerHolder.conversationManager;
    }

    private void initInternalConversationListener() {
        if (this.mInternalConversationListener == null) {
            this.mInternalConversationListener = new ConversationListener() {
                public void onConversationChanged(final List<Conversation> list) {
                    IMContext.getInstance().runOnMainThread(new Runnable() {
                        public void run() {
                            if (ConversationManager.this.mConversationListener != null) {
                                ConversationManager.this.mConversationListener.onConversationChanged(list);
                            }
                        }
                    });
                }

                public void onConversationDeleted(final List<String> list) {
                    IMContext.getInstance().runOnMainThread(new Runnable() {
                        public void run() {
                            if (ConversationManager.this.mConversationListener != null) {
                                ConversationManager.this.mConversationListener.onConversationDeleted(list);
                            }
                        }
                    });
                }

                public void onConversationGroupCreated(final String str, final List<Conversation> list) {
                    IMContext.getInstance().runOnMainThread(new Runnable() {
                        public void run() {
                            if (ConversationManager.this.mConversationListener != null) {
                                ConversationManager.this.mConversationListener.onConversationGroupCreated(str, list);
                            }
                        }
                    });
                }

                public void onConversationGroupDeleted(final String str) {
                    IMContext.getInstance().runOnMainThread(new Runnable() {
                        public void run() {
                            if (ConversationManager.this.mConversationListener != null) {
                                ConversationManager.this.mConversationListener.onConversationGroupDeleted(str);
                            }
                        }
                    });
                }

                public void onConversationGroupNameChanged(final String str, final String str2) {
                    IMContext.getInstance().runOnMainThread(new Runnable() {
                        public void run() {
                            if (ConversationManager.this.mConversationListener != null) {
                                ConversationManager.this.mConversationListener.onConversationGroupNameChanged(str, str2);
                            }
                        }
                    });
                }

                public void onConversationsAddedToGroup(final String str, final List<Conversation> list) {
                    IMContext.getInstance().runOnMainThread(new Runnable() {
                        public void run() {
                            if (ConversationManager.this.mConversationListener != null) {
                                ConversationManager.this.mConversationListener.onConversationsAddedToGroup(str, list);
                            }
                        }
                    });
                }

                public void onConversationsDeletedFromGroup(final String str, final List<Conversation> list) {
                    IMContext.getInstance().runOnMainThread(new Runnable() {
                        public void run() {
                            if (ConversationManager.this.mConversationListener != null) {
                                ConversationManager.this.mConversationListener.onConversationsDeletedFromGroup(str, list);
                            }
                        }
                    });
                }

                public void onNewConversation(final List<Conversation> list) {
                    IMContext.getInstance().runOnMainThread(new Runnable() {
                        public void run() {
                            if (ConversationManager.this.mConversationListener != null) {
                                ConversationManager.this.mConversationListener.onNewConversation(list);
                            }
                        }
                    });
                }

                public void onSyncServerFailed() {
                    IMContext.getInstance().runOnMainThread(new Runnable() {
                        public void run() {
                            if (ConversationManager.this.mConversationListener != null) {
                                ConversationManager.this.mConversationListener.onSyncServerFailed();
                            }
                        }
                    });
                }

                public void onSyncServerFinish() {
                    IMContext.getInstance().runOnMainThread(new Runnable() {
                        public void run() {
                            if (ConversationManager.this.mConversationListener != null) {
                                ConversationManager.this.mConversationListener.onSyncServerFinish();
                            }
                        }
                    });
                }

                public void onSyncServerStart() {
                    IMContext.getInstance().runOnMainThread(new Runnable() {
                        public void run() {
                            if (ConversationManager.this.mConversationListener != null) {
                                ConversationManager.this.mConversationListener.onSyncServerStart();
                            }
                        }
                    });
                }

                public void onUnreadMessageCountChanged(final UnreadMessageCountResult unreadMessageCountResult) {
                    IMContext.getInstance().runOnMainThread(new Runnable() {
                        public void run() {
                            if (ConversationManager.this.mConversationListener != null) {
                                ConversationManager.this.mConversationListener.onUnreadMessageCountChanged(unreadMessageCountResult);
                            }
                        }
                    });
                }
            };
        }
        nativeSetConversationListener(this.mInternalConversationListener);
    }

    public void addConversationsToGroup(String str, List<ConversationKey> list, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeAddConversationsToGroup(str, list, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void clearUnreadMessage(boolean z11, boolean z12, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeClearUnreadMessage(z11, z12, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void createConversationGroup(String str, List<ConversationKey> list, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeCreateConversationGroup(str, list, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void deleteConversationGroup(String str, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeDeleteConversationGroup(str, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void deleteConversationList(List<ConversationKey> list, boolean z11, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeDeleteConversationList(list, z11, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void deleteConversationsFromGroup(String str, List<ConversationKey> list, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeDeleteConversationsFromGroup(str, list, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void getConversationGroupList(IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeGetConversationGroupList(iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void getConversationInfo(ConversationKey conversationKey, IMCallback<Conversation> iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeGetConversationInfo(conversationKey, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void getConversationList(long j11, int i11, IMCallback<ConversationResult> iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeGetConversationList(j11, i11, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void getConversationListByFilter(ConversationListFilter conversationListFilter, long j11, int i11, IMCallback<ConversationResult> iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeGetConversationListByFilter(conversationListFilter, j11, i11, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void getTotalUnreadMessageCount(ConversationListFilter conversationListFilter, IMCallback<UnreadMessageCountResult> iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeGetTotalUnreadMessageCount(conversationListFilter, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void init() {
        initInternalConversationListener();
    }

    public void markConversation(List<ConversationKey> list, long j11, boolean z11, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeMarkConversation(list, j11, z11, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public native void nativeAddConversationsToGroup(String str, List<ConversationKey> list, IMCallback iMCallback);

    public native void nativeClearUnreadMessage(boolean z11, boolean z12, IMCallback iMCallback);

    public native void nativeCreateConversationGroup(String str, List<ConversationKey> list, IMCallback iMCallback);

    public native void nativeDeleteConversationGroup(String str, IMCallback iMCallback);

    public native void nativeDeleteConversationList(List<ConversationKey> list, boolean z11, IMCallback iMCallback);

    public native void nativeDeleteConversationsFromGroup(String str, List<ConversationKey> list, IMCallback iMCallback);

    public native void nativeGetConversationGroupList(IMCallback iMCallback);

    public native void nativeGetConversationInfo(ConversationKey conversationKey, IMCallback iMCallback);

    public native void nativeGetConversationList(long j11, int i11, IMCallback iMCallback);

    public native void nativeGetConversationListByFilter(ConversationListFilter conversationListFilter, long j11, int i11, IMCallback iMCallback);

    public native void nativeGetConversations(List<ConversationKey> list, IMCallback iMCallback);

    public native void nativeGetTotalUnreadMessageCount(ConversationListFilter conversationListFilter, IMCallback iMCallback);

    public native void nativeMarkConversation(List<ConversationKey> list, long j11, boolean z11, IMCallback iMCallback);

    public native void nativePinConversation(ConversationKey conversationKey, boolean z11, IMCallback iMCallback);

    public native void nativeRenameConversationGroup(String str, String str2, IMCallback iMCallback);

    public native void nativeSetConversationCustomData(List<ConversationKey> list, String str, IMCallback iMCallback);

    public native void nativeSetConversationDraft(ConversationKey conversationKey, DraftMessage draftMessage, IMCallback iMCallback);

    public native void nativeSetConversationListener(ConversationListener conversationListener);

    public native void nativeSetCosSaveRegionForConversation(ConversationKey conversationKey, String str, IMCallback iMCallback);

    public native void nativeSubscribeUnreadMessageCountByFilter(ConversationListFilter conversationListFilter);

    public native void nativeUnsubscribeUnreadMessageCountByFilter(ConversationListFilter conversationListFilter);

    public void pinConversation(ConversationKey conversationKey, boolean z11, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativePinConversation(conversationKey, z11, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void renameConversationGroup(String str, String str2, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeRenameConversationGroup(str, str2, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void setConversationCustomData(List<ConversationKey> list, String str, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeSetConversationCustomData(list, str, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void setConversationDraft(ConversationKey conversationKey, DraftMessage draftMessage, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeSetConversationDraft(conversationKey, draftMessage, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void setConversationListener(ConversationListener conversationListener) {
        this.mConversationListener = conversationListener;
    }

    public void setCosSaveRegionForConversation(ConversationKey conversationKey, String str, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeSetCosSaveRegionForConversation(conversationKey, str, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void subscribeUnreadMessageCountByFilter(ConversationListFilter conversationListFilter) {
        if (BaseManager.getInstance().isInited()) {
            nativeSubscribeUnreadMessageCountByFilter(conversationListFilter);
        }
    }

    public void unsubscribeUnreadMessageCountByFilter(ConversationListFilter conversationListFilter) {
        if (BaseManager.getInstance().isInited()) {
            nativeUnsubscribeUnreadMessageCountByFilter(conversationListFilter);
        }
    }

    public void getConversationList(List<ConversationKey> list, IMCallback<List<Conversation>> iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeGetConversations(list, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }
}
