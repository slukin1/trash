package com.tencent.imsdk.v2;

import java.util.List;

public abstract class V2TIMConversationManager {
    public static V2TIMConversationManager getInstance() {
        return V2TIMConversationManagerImpl.getInstance();
    }

    public abstract void addConversationListener(V2TIMConversationListener v2TIMConversationListener);

    public abstract void addConversationsToGroup(String str, List<String> list, V2TIMValueCallback<List<V2TIMConversationOperationResult>> v2TIMValueCallback);

    public abstract void cleanConversationUnreadMessageCount(String str, long j11, long j12, V2TIMCallback v2TIMCallback);

    public abstract void createConversationGroup(String str, List<String> list, V2TIMValueCallback<List<V2TIMConversationOperationResult>> v2TIMValueCallback);

    public abstract void deleteConversation(String str, V2TIMCallback v2TIMCallback);

    public abstract void deleteConversationGroup(String str, V2TIMCallback v2TIMCallback);

    public abstract void deleteConversationList(List<String> list, boolean z11, V2TIMValueCallback<List<V2TIMConversationOperationResult>> v2TIMValueCallback);

    public abstract void deleteConversationsFromGroup(String str, List<String> list, V2TIMValueCallback<List<V2TIMConversationOperationResult>> v2TIMValueCallback);

    public abstract void getConversation(String str, V2TIMValueCallback<V2TIMConversation> v2TIMValueCallback);

    public abstract void getConversationGroupList(V2TIMValueCallback<List<String>> v2TIMValueCallback);

    public abstract void getConversationList(long j11, int i11, V2TIMValueCallback<V2TIMConversationResult> v2TIMValueCallback);

    public abstract void getConversationList(List<String> list, V2TIMValueCallback<List<V2TIMConversation>> v2TIMValueCallback);

    public abstract void getConversationListByFilter(V2TIMConversationListFilter v2TIMConversationListFilter, long j11, int i11, V2TIMValueCallback<V2TIMConversationResult> v2TIMValueCallback);

    public abstract void getTotalUnreadMessageCount(V2TIMValueCallback<Long> v2TIMValueCallback);

    public abstract void getUnreadMessageCountByFilter(V2TIMConversationListFilter v2TIMConversationListFilter, V2TIMValueCallback<Long> v2TIMValueCallback);

    public abstract void markConversation(List<String> list, long j11, boolean z11, V2TIMValueCallback<List<V2TIMConversationOperationResult>> v2TIMValueCallback);

    public abstract void pinConversation(String str, boolean z11, V2TIMCallback v2TIMCallback);

    public abstract void removeConversationListener(V2TIMConversationListener v2TIMConversationListener);

    public abstract void renameConversationGroup(String str, String str2, V2TIMCallback v2TIMCallback);

    public abstract void setConversationCustomData(List<String> list, String str, V2TIMValueCallback<List<V2TIMConversationOperationResult>> v2TIMValueCallback);

    public abstract void setConversationDraft(String str, String str2, V2TIMCallback v2TIMCallback);

    @Deprecated
    public abstract void setConversationListener(V2TIMConversationListener v2TIMConversationListener);

    public abstract void subscribeUnreadMessageCountByFilter(V2TIMConversationListFilter v2TIMConversationListFilter);

    public abstract void unsubscribeUnreadMessageCountByFilter(V2TIMConversationListFilter v2TIMConversationListFilter);
}
