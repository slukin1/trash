package com.tencent.imsdk.v2;

import android.text.TextUtils;
import com.tencent.imsdk.BaseConstants;
import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.common.IMContext;
import com.tencent.imsdk.conversation.Conversation;
import com.tencent.imsdk.conversation.ConversationKey;
import com.tencent.imsdk.conversation.ConversationListFilter;
import com.tencent.imsdk.conversation.ConversationListener;
import com.tencent.imsdk.conversation.ConversationManager;
import com.tencent.imsdk.conversation.ConversationOperationResult;
import com.tencent.imsdk.conversation.ConversationResult;
import com.tencent.imsdk.conversation.UnreadMessageCountResult;
import com.tencent.imsdk.manager.BaseManager;
import com.tencent.imsdk.message.DraftMessage;
import com.tencent.imsdk.message.MessageCenter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class V2TIMConversationManagerImpl extends V2TIMConversationManager {
    private ConversationListener mConversationListener;
    /* access modifiers changed from: private */
    public V2TIMConversationListener mV2TIMConversationListener;
    /* access modifiers changed from: private */
    public final List<V2TIMConversationListener> mV2TIMConversationListenerList;

    public static class V2TIMConversationManagerImplHolder {
        /* access modifiers changed from: private */
        public static final V2TIMConversationManagerImpl v2TIMConversationManagerImpl = new V2TIMConversationManagerImpl();

        private V2TIMConversationManagerImplHolder() {
        }
    }

    public static V2TIMConversationManagerImpl getInstance() {
        return V2TIMConversationManagerImplHolder.v2TIMConversationManagerImpl;
    }

    private void initListener() {
        if (this.mConversationListener == null) {
            this.mConversationListener = new ConversationListener() {
                public void onConversationChanged(List<Conversation> list) {
                    ArrayList arrayList = new ArrayList();
                    for (Conversation conversation : list) {
                        V2TIMConversation v2TIMConversation = new V2TIMConversation();
                        v2TIMConversation.setConversation(conversation);
                        arrayList.add(v2TIMConversation);
                    }
                    List unmodifiableList = Collections.unmodifiableList(arrayList);
                    for (V2TIMConversationListener onConversationChanged : V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList) {
                        onConversationChanged.onConversationChanged(unmodifiableList);
                    }
                }

                public void onConversationDeleted(List<String> list) {
                    List<T> unmodifiableList = Collections.unmodifiableList(list);
                    for (V2TIMConversationListener onConversationDeleted : V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList) {
                        onConversationDeleted.onConversationDeleted(unmodifiableList);
                    }
                }

                public void onConversationGroupCreated(String str, List<Conversation> list) {
                    ArrayList arrayList = new ArrayList();
                    for (Conversation conversation : list) {
                        V2TIMConversation v2TIMConversation = new V2TIMConversation();
                        v2TIMConversation.setConversation(conversation);
                        arrayList.add(v2TIMConversation);
                    }
                    List unmodifiableList = Collections.unmodifiableList(arrayList);
                    for (V2TIMConversationListener onConversationGroupCreated : V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList) {
                        onConversationGroupCreated.onConversationGroupCreated(str, unmodifiableList);
                    }
                }

                public void onConversationGroupDeleted(String str) {
                    for (V2TIMConversationListener onConversationGroupDeleted : V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList) {
                        onConversationGroupDeleted.onConversationGroupDeleted(str);
                    }
                }

                public void onConversationGroupNameChanged(String str, String str2) {
                    for (V2TIMConversationListener onConversationGroupNameChanged : V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList) {
                        onConversationGroupNameChanged.onConversationGroupNameChanged(str, str2);
                    }
                }

                public void onConversationsAddedToGroup(String str, List<Conversation> list) {
                    ArrayList arrayList = new ArrayList();
                    for (Conversation conversation : list) {
                        V2TIMConversation v2TIMConversation = new V2TIMConversation();
                        v2TIMConversation.setConversation(conversation);
                        arrayList.add(v2TIMConversation);
                    }
                    List unmodifiableList = Collections.unmodifiableList(arrayList);
                    for (V2TIMConversationListener onConversationsAddedToGroup : V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList) {
                        onConversationsAddedToGroup.onConversationsAddedToGroup(str, unmodifiableList);
                    }
                }

                public void onConversationsDeletedFromGroup(String str, List<Conversation> list) {
                    ArrayList arrayList = new ArrayList();
                    for (Conversation conversation : list) {
                        V2TIMConversation v2TIMConversation = new V2TIMConversation();
                        v2TIMConversation.setConversation(conversation);
                        arrayList.add(v2TIMConversation);
                    }
                    List unmodifiableList = Collections.unmodifiableList(arrayList);
                    for (V2TIMConversationListener onConversationsDeletedFromGroup : V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList) {
                        onConversationsDeletedFromGroup.onConversationsDeletedFromGroup(str, unmodifiableList);
                    }
                }

                public void onNewConversation(List<Conversation> list) {
                    ArrayList arrayList = new ArrayList();
                    for (Conversation conversation : list) {
                        V2TIMConversation v2TIMConversation = new V2TIMConversation();
                        v2TIMConversation.setConversation(conversation);
                        arrayList.add(v2TIMConversation);
                    }
                    List unmodifiableList = Collections.unmodifiableList(arrayList);
                    for (V2TIMConversationListener onNewConversation : V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList) {
                        onNewConversation.onNewConversation(unmodifiableList);
                    }
                }

                public void onSyncServerFailed() {
                    for (V2TIMConversationListener onSyncServerFailed : V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList) {
                        onSyncServerFailed.onSyncServerFailed();
                    }
                }

                public void onSyncServerFinish() {
                    for (V2TIMConversationListener onSyncServerFinish : V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList) {
                        onSyncServerFinish.onSyncServerFinish();
                    }
                }

                public void onSyncServerStart() {
                    for (V2TIMConversationListener onSyncServerStart : V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList) {
                        onSyncServerStart.onSyncServerStart();
                    }
                }

                public void onUnreadMessageCountChanged(UnreadMessageCountResult unreadMessageCountResult) {
                    for (V2TIMConversationListener v2TIMConversationListener : V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList) {
                        ConversationListFilter filter = unreadMessageCountResult.getFilter();
                        if (filter == null || filter.isNull()) {
                            v2TIMConversationListener.onTotalUnreadMessageCountChanged(unreadMessageCountResult.getTotalUnreadCount());
                        } else {
                            V2TIMConversationListFilter v2TIMConversationListFilter = new V2TIMConversationListFilter();
                            v2TIMConversationListFilter.setConversationFilter(filter);
                            v2TIMConversationListener.onUnreadMessageCountChangedByFilter(v2TIMConversationListFilter, unreadMessageCountResult.getTotalUnreadCount());
                        }
                    }
                }
            };
        }
        ConversationManager.getInstance().setConversationListener(this.mConversationListener);
    }

    public void addConversationListener(final V2TIMConversationListener v2TIMConversationListener) {
        if (v2TIMConversationListener != null) {
            IMContext.getInstance().runOnMainThread(new Runnable() {
                public void run() {
                    if (!V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList.contains(v2TIMConversationListener)) {
                        V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList.add(v2TIMConversationListener);
                    }
                }
            });
        }
    }

    public void addConversationsToGroup(String str, List<String> list, final V2TIMValueCallback<List<V2TIMConversationOperationResult>> v2TIMValueCallback) {
        if (TextUtils.isEmpty(str)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupName is empty");
            }
        } else if (list != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList();
            for (String conversationKey : list) {
                arrayList.add(getConversationKey(conversationKey));
            }
            ConversationManager.getInstance().addConversationsToGroup(str, arrayList, new IMCallback(new V2TIMValueCallback<List<ConversationOperationResult>>() {
                public void onError(int i11, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i11, str);
                    }
                }

                public void onSuccess(List<ConversationOperationResult> list) {
                    ArrayList arrayList = new ArrayList();
                    for (ConversationOperationResult conversationOperationResult : list) {
                        V2TIMConversationOperationResult v2TIMConversationOperationResult = new V2TIMConversationOperationResult();
                        v2TIMConversationOperationResult.setConversationOperationResult(conversationOperationResult);
                        arrayList.add(v2TIMConversationOperationResult);
                    }
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "conversationIDList is empty");
        }
    }

    public void cleanConversationUnreadMessageCount(String str, long j11, long j12, V2TIMCallback v2TIMCallback) {
        AnonymousClass23 r02 = new IMCallback(v2TIMCallback) {
            public void fail(int i11, String str) {
                super.fail(i11, str);
            }

            public void success(Object obj) {
                super.success(obj);
            }
        };
        if (str == null || str.length() == 0) {
            ConversationManager.getInstance().clearUnreadMessage(true, true, r02);
            return;
        }
        ConversationKey conversationKey = getConversationKey(str);
        if (1 == conversationKey.getConversationType()) {
            if (conversationKey.getConversationID().isEmpty()) {
                ConversationManager.getInstance().clearUnreadMessage(true, false, r02);
            } else {
                MessageCenter.getInstance().setC2CMessageRead(conversationKey.getConversationID(), j11, r02);
            }
        } else if (2 == conversationKey.getConversationType()) {
            if (conversationKey.getConversationID().isEmpty()) {
                ConversationManager.getInstance().clearUnreadMessage(false, true, r02);
            } else {
                MessageCenter.getInstance().setGroupMessageRead(conversationKey.getConversationID(), j12, r02);
            }
        } else if (v2TIMCallback != null) {
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "conversationID is invalid");
        }
    }

    public void createConversationGroup(String str, List<String> list, final V2TIMValueCallback<List<V2TIMConversationOperationResult>> v2TIMValueCallback) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            for (String conversationKey : list) {
                arrayList.add(getConversationKey(conversationKey));
            }
            ConversationManager.getInstance().createConversationGroup(str, arrayList, new IMCallback(new V2TIMValueCallback<List<ConversationOperationResult>>() {
                public void onError(int i11, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i11, str);
                    }
                }

                public void onSuccess(List<ConversationOperationResult> list) {
                    ArrayList arrayList = new ArrayList();
                    for (ConversationOperationResult conversationOperationResult : list) {
                        V2TIMConversationOperationResult v2TIMConversationOperationResult = new V2TIMConversationOperationResult();
                        v2TIMConversationOperationResult.setConversationOperationResult(conversationOperationResult);
                        arrayList.add(v2TIMConversationOperationResult);
                    }
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "group name is empty");
        }
    }

    public void deleteConversation(String str, final V2TIMCallback v2TIMCallback) {
        if (!TextUtils.isEmpty(str)) {
            ConversationKey conversationKey = getConversationKey(str);
            ArrayList arrayList = new ArrayList();
            arrayList.add(conversationKey);
            ConversationManager.getInstance().deleteConversationList(arrayList, true, new IMCallback(new V2TIMValueCallback<List<ConversationOperationResult>>() {
                public void onError(int i11, String str) {
                    V2TIMCallback v2TIMCallback = v2TIMCallback;
                    if (v2TIMCallback != null) {
                        v2TIMCallback.onError(i11, str);
                    }
                }

                public void onSuccess(List<ConversationOperationResult> list) {
                    if (v2TIMCallback == null) {
                        return;
                    }
                    if (list.isEmpty() || list.get(0).getResultCode() == 0) {
                        v2TIMCallback.onSuccess();
                    } else {
                        v2TIMCallback.onError(list.get(0).getResultCode(), list.get(0).getResultInfo());
                    }
                }
            }) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else if (v2TIMCallback != null) {
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "conversationID is empty");
        }
    }

    public void deleteConversationGroup(String str, V2TIMCallback v2TIMCallback) {
        if (!TextUtils.isEmpty(str)) {
            ConversationManager.getInstance().deleteConversationGroup(str, new IMCallback(v2TIMCallback) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else if (v2TIMCallback != null) {
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "group name is empty");
        }
    }

    public void deleteConversationList(List<String> list, boolean z11, final V2TIMValueCallback<List<V2TIMConversationOperationResult>> v2TIMValueCallback) {
        if (list != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList();
            for (String conversationKey : list) {
                arrayList.add(getConversationKey(conversationKey));
            }
            ConversationManager.getInstance().deleteConversationList(arrayList, z11, new IMCallback(new V2TIMValueCallback<List<ConversationOperationResult>>() {
                public void onError(int i11, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i11, str);
                    }
                }

                public void onSuccess(List<ConversationOperationResult> list) {
                    ArrayList arrayList = new ArrayList();
                    for (ConversationOperationResult conversationOperationResult : list) {
                        V2TIMConversationOperationResult v2TIMConversationOperationResult = new V2TIMConversationOperationResult();
                        v2TIMConversationOperationResult.setConversationOperationResult(conversationOperationResult);
                        arrayList.add(v2TIMConversationOperationResult);
                    }
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "conversationIDList is empty");
        }
    }

    public void deleteConversationsFromGroup(String str, List<String> list, final V2TIMValueCallback<List<V2TIMConversationOperationResult>> v2TIMValueCallback) {
        if (TextUtils.isEmpty(str)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupName is empty");
            }
        } else if (list != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList();
            for (String conversationKey : list) {
                arrayList.add(getConversationKey(conversationKey));
            }
            ConversationManager.getInstance().deleteConversationsFromGroup(str, arrayList, new IMCallback(new V2TIMValueCallback<List<ConversationOperationResult>>() {
                public void onError(int i11, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i11, str);
                    }
                }

                public void onSuccess(List<ConversationOperationResult> list) {
                    ArrayList arrayList = new ArrayList();
                    for (ConversationOperationResult conversationOperationResult : list) {
                        V2TIMConversationOperationResult v2TIMConversationOperationResult = new V2TIMConversationOperationResult();
                        v2TIMConversationOperationResult.setConversationOperationResult(conversationOperationResult);
                        arrayList.add(v2TIMConversationOperationResult);
                    }
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "conversationIDList is empty");
        }
    }

    public void getConversation(String str, final V2TIMValueCallback<V2TIMConversation> v2TIMValueCallback) {
        if (!TextUtils.isEmpty(str)) {
            ConversationManager.getInstance().getConversationInfo(getConversationKey(str), new IMCallback<Conversation>(new V2TIMValueCallback<Conversation>() {
                public void onError(int i11, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i11, str);
                    }
                }

                public void onSuccess(Conversation conversation) {
                    if (v2TIMValueCallback != null) {
                        V2TIMConversation v2TIMConversation = new V2TIMConversation();
                        v2TIMConversation.setConversation(conversation);
                        v2TIMValueCallback.onSuccess(v2TIMConversation);
                    }
                }
            }) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(Conversation conversation) {
                    super.success(conversation);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "conversationID is empty");
        }
    }

    public void getConversationGroupList(V2TIMValueCallback<List<String>> v2TIMValueCallback) {
        ConversationManager.getInstance().getConversationGroupList(new IMCallback(v2TIMValueCallback) {
            public void fail(int i11, String str) {
                super.fail(i11, str);
            }

            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    public ConversationKey getConversationKey(String str) {
        ConversationKey conversationKey = new ConversationKey();
        if (TextUtils.isEmpty(str)) {
            return conversationKey;
        }
        if (str.indexOf("c2c_") == 0) {
            String substring = str.substring(4);
            conversationKey.setConversationType(1);
            conversationKey.setConversationID(substring);
        } else if (str.indexOf("group_") == 0) {
            String substring2 = str.substring(6);
            conversationKey.setConversationType(2);
            conversationKey.setConversationID(substring2);
        } else if (str.equals(V2TIMConversation.CONVERSATION_C2C_TYPE)) {
            conversationKey.setConversationType(1);
            conversationKey.setConversationID("");
        } else if (str.equals(V2TIMConversation.CONVERSATION_GROUP_TYPE)) {
            conversationKey.setConversationType(2);
            conversationKey.setConversationID("");
        } else if (str.length() == 0) {
            conversationKey.setConversationType(3);
            conversationKey.setConversationID("");
        } else {
            conversationKey.setConversationType(0);
            conversationKey.setConversationID("");
        }
        return conversationKey;
    }

    public void getConversationList(long j11, int i11, final V2TIMValueCallback<V2TIMConversationResult> v2TIMValueCallback) {
        if (i11 > 0) {
            ConversationManager.getInstance().getConversationList(j11, i11, new IMCallback<ConversationResult>(new V2TIMValueCallback<ConversationResult>() {
                public void onError(int i11, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i11, str);
                    }
                }

                public void onSuccess(ConversationResult conversationResult) {
                    if (v2TIMValueCallback != null) {
                        V2TIMConversationResult v2TIMConversationResult = new V2TIMConversationResult();
                        v2TIMConversationResult.setConversationResult(conversationResult);
                        v2TIMValueCallback.onSuccess(v2TIMConversationResult);
                    }
                }
            }) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(ConversationResult conversationResult) {
                    super.success(conversationResult);
                }
            });
            BaseManager.getInstance().checkTUIComponent(2);
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "count is invalid");
        }
    }

    public void getConversationListByFilter(V2TIMConversationListFilter v2TIMConversationListFilter, long j11, int i11, final V2TIMValueCallback<V2TIMConversationResult> v2TIMValueCallback) {
        if (v2TIMConversationListFilter == null) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "filter is null");
            }
        } else if (i11 > 0) {
            long j12 = j11;
            int i12 = i11;
            ConversationManager.getInstance().getConversationListByFilter(v2TIMConversationListFilter.getConversationFilter(), j12, i12, new IMCallback<ConversationResult>(new V2TIMValueCallback<ConversationResult>() {
                public void onError(int i11, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i11, str);
                    }
                }

                public void onSuccess(ConversationResult conversationResult) {
                    if (v2TIMValueCallback != null) {
                        V2TIMConversationResult v2TIMConversationResult = new V2TIMConversationResult();
                        v2TIMConversationResult.setConversationResult(conversationResult);
                        v2TIMValueCallback.onSuccess(v2TIMConversationResult);
                    }
                }
            }) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(ConversationResult conversationResult) {
                    super.success(conversationResult);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "count is invalid");
        }
    }

    public void getTotalUnreadMessageCount(final V2TIMValueCallback<Long> v2TIMValueCallback) {
        ConversationManager.getInstance().getTotalUnreadMessageCount(new ConversationListFilter(), new IMCallback<UnreadMessageCountResult>(new V2TIMValueCallback<UnreadMessageCountResult>() {
            public void onError(int i11, String str) {
                V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onError(i11, str);
                }
            }

            public void onSuccess(UnreadMessageCountResult unreadMessageCountResult) {
                V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onSuccess(Long.valueOf(unreadMessageCountResult.getTotalUnreadCount()));
                }
            }
        }) {
            public void fail(int i11, String str) {
                super.fail(i11, str);
            }

            public void success(UnreadMessageCountResult unreadMessageCountResult) {
                super.success(unreadMessageCountResult);
            }
        });
    }

    public void getUnreadMessageCountByFilter(V2TIMConversationListFilter v2TIMConversationListFilter, final V2TIMValueCallback<Long> v2TIMValueCallback) {
        if (v2TIMConversationListFilter != null) {
            ConversationListFilter conversationFilter = v2TIMConversationListFilter.getConversationFilter();
            if (conversationFilter.isNull()) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "one of type, conversationGroup and markType fields of the filter must be set");
                return;
            }
            ConversationManager.getInstance().getTotalUnreadMessageCount(conversationFilter, new IMCallback<UnreadMessageCountResult>(new V2TIMValueCallback<UnreadMessageCountResult>() {
                public void onError(int i11, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i11, str);
                    }
                }

                public void onSuccess(UnreadMessageCountResult unreadMessageCountResult) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onSuccess(Long.valueOf(unreadMessageCountResult.getTotalUnreadCount()));
                    }
                }
            }) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(UnreadMessageCountResult unreadMessageCountResult) {
                    super.success(unreadMessageCountResult);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "filter must not be null");
        }
    }

    public void markConversation(List<String> list, long j11, boolean z11, final V2TIMValueCallback<List<V2TIMConversationOperationResult>> v2TIMValueCallback) {
        if (list == null || list.size() == 0) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "conversationIDList is empty");
            }
        } else if (j11 != 0) {
            ArrayList arrayList = new ArrayList();
            for (String conversationKey : list) {
                arrayList.add(getConversationKey(conversationKey));
            }
            long j12 = j11;
            boolean z12 = z11;
            ConversationManager.getInstance().markConversation(arrayList, j12, z12, new IMCallback(new V2TIMValueCallback<List<ConversationOperationResult>>() {
                public void onError(int i11, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i11, str);
                    }
                }

                public void onSuccess(List<ConversationOperationResult> list) {
                    ArrayList arrayList = new ArrayList();
                    for (ConversationOperationResult conversationOperationResult : list) {
                        V2TIMConversationOperationResult v2TIMConversationOperationResult = new V2TIMConversationOperationResult();
                        v2TIMConversationOperationResult.setConversationOperationResult(conversationOperationResult);
                        arrayList.add(v2TIMConversationOperationResult);
                    }
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "markType is invalid");
        }
    }

    public void pinConversation(String str, boolean z11, V2TIMCallback v2TIMCallback) {
        if (!TextUtils.isEmpty(str)) {
            ConversationManager.getInstance().pinConversation(getConversationKey(str), z11, new IMCallback(v2TIMCallback) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else if (v2TIMCallback != null) {
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "conversationID is empty");
        }
    }

    public void removeConversationListener(final V2TIMConversationListener v2TIMConversationListener) {
        if (v2TIMConversationListener != null) {
            IMContext.getInstance().runOnMainThread(new Runnable() {
                public void run() {
                    V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList.remove(v2TIMConversationListener);
                }
            });
        }
    }

    public void renameConversationGroup(String str, String str2, V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "oldName is empty");
            }
        } else if (!TextUtils.isEmpty(str2)) {
            ConversationManager.getInstance().renameConversationGroup(str, str2, new IMCallback(v2TIMCallback) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else if (v2TIMCallback != null) {
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "newName is empty");
        }
    }

    public void setConversationCustomData(List<String> list, String str, final V2TIMValueCallback<List<V2TIMConversationOperationResult>> v2TIMValueCallback) {
        if (list != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList();
            for (String conversationKey : list) {
                arrayList.add(getConversationKey(conversationKey));
            }
            ConversationManager.getInstance().setConversationCustomData(arrayList, str, new IMCallback(new V2TIMValueCallback<List<ConversationOperationResult>>() {
                public void onError(int i11, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i11, str);
                    }
                }

                public void onSuccess(List<ConversationOperationResult> list) {
                    ArrayList arrayList = new ArrayList();
                    for (ConversationOperationResult conversationOperationResult : list) {
                        V2TIMConversationOperationResult v2TIMConversationOperationResult = new V2TIMConversationOperationResult();
                        v2TIMConversationOperationResult.setConversationOperationResult(conversationOperationResult);
                        arrayList.add(v2TIMConversationOperationResult);
                    }
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "conversationIDList is empty");
        }
    }

    public void setConversationDraft(String str, String str2, V2TIMCallback v2TIMCallback) {
        if (!TextUtils.isEmpty(str)) {
            ConversationKey conversationKey = getConversationKey(str);
            DraftMessage draftMessage = new DraftMessage();
            if (str2 != null) {
                draftMessage.setUserDefinedData(str2.getBytes());
            }
            ConversationManager.getInstance().setConversationDraft(conversationKey, draftMessage, new IMCallback(v2TIMCallback) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else if (v2TIMCallback != null) {
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "conversationID is empty");
        }
    }

    public void setConversationListener(final V2TIMConversationListener v2TIMConversationListener) {
        IMContext.getInstance().runOnMainThread(new Runnable() {
            public void run() {
                if (V2TIMConversationManagerImpl.this.mV2TIMConversationListener != null) {
                    V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList.remove(V2TIMConversationManagerImpl.this.mV2TIMConversationListener);
                }
                if (v2TIMConversationListener != null) {
                    V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList.add(v2TIMConversationListener);
                }
                V2TIMConversationListener unused = V2TIMConversationManagerImpl.this.mV2TIMConversationListener = v2TIMConversationListener;
            }
        });
    }

    public void subscribeUnreadMessageCountByFilter(V2TIMConversationListFilter v2TIMConversationListFilter) {
        if (v2TIMConversationListFilter != null) {
            ConversationListFilter conversationFilter = v2TIMConversationListFilter.getConversationFilter();
            if (!conversationFilter.isNull()) {
                ConversationManager.getInstance().subscribeUnreadMessageCountByFilter(conversationFilter);
            }
        }
    }

    public void unsubscribeUnreadMessageCountByFilter(V2TIMConversationListFilter v2TIMConversationListFilter) {
        if (v2TIMConversationListFilter != null) {
            ConversationListFilter conversationFilter = v2TIMConversationListFilter.getConversationFilter();
            if (!conversationFilter.isNull()) {
                ConversationManager.getInstance().unsubscribeUnreadMessageCountByFilter(conversationFilter);
            }
        }
    }

    private V2TIMConversationManagerImpl() {
        this.mV2TIMConversationListenerList = new ArrayList();
        initListener();
    }

    public void getConversationList(List<String> list, final V2TIMValueCallback<List<V2TIMConversation>> v2TIMValueCallback) {
        if (list != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList();
            for (String conversationKey : list) {
                arrayList.add(getConversationKey(conversationKey));
            }
            ConversationManager.getInstance().getConversationList(arrayList, new IMCallback<List<Conversation>>(new V2TIMValueCallback<List<Conversation>>() {
                public void onError(int i11, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i11, str);
                    }
                }

                public void onSuccess(List<Conversation> list) {
                    ArrayList arrayList = new ArrayList();
                    for (Conversation conversation : list) {
                        V2TIMConversation v2TIMConversation = new V2TIMConversation();
                        v2TIMConversation.setConversation(conversation);
                        arrayList.add(v2TIMConversation);
                    }
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(List<Conversation> list) {
                    super.success(list);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "conversationIDList cannot be empty");
        }
    }
}
