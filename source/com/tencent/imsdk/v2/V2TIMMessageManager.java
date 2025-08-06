package com.tencent.imsdk.v2;

import java.util.HashMap;
import java.util.List;

public abstract class V2TIMMessageManager {
    public static V2TIMMessageManager getInstance() {
        return V2TIMMessageManagerImpl.getInstance();
    }

    public abstract void addAdvancedMsgListener(V2TIMAdvancedMsgListener v2TIMAdvancedMsgListener);

    public abstract void clearC2CHistoryMessage(String str, V2TIMCallback v2TIMCallback);

    public abstract void clearGroupHistoryMessage(String str, V2TIMCallback v2TIMCallback);

    public abstract V2TIMMessage createAtSignedGroupMessage(V2TIMMessage v2TIMMessage, List<String> list);

    public abstract V2TIMMessage createCustomMessage(byte[] bArr);

    public abstract V2TIMMessage createCustomMessage(byte[] bArr, String str, byte[] bArr2);

    public abstract V2TIMMessage createFaceMessage(int i11, byte[] bArr);

    public abstract V2TIMMessage createFileMessage(String str, String str2);

    public abstract V2TIMMessage createForwardMessage(V2TIMMessage v2TIMMessage);

    public abstract V2TIMMessage createImageMessage(String str);

    public abstract V2TIMMessage createLocationMessage(String str, double d11, double d12);

    public abstract V2TIMMessage createMergerMessage(List<V2TIMMessage> list, String str, List<String> list2, String str2);

    public abstract V2TIMMessage createSoundMessage(String str, int i11);

    public abstract V2TIMMessage createTargetedGroupMessage(V2TIMMessage v2TIMMessage, List<String> list);

    @Deprecated
    public abstract V2TIMMessage createTextAtMessage(String str, List<String> list);

    public abstract V2TIMMessage createTextMessage(String str);

    public abstract V2TIMMessage createVideoMessage(String str, String str2, int i11, String str3);

    public abstract void deleteMessageExtensions(V2TIMMessage v2TIMMessage, List<String> list, V2TIMValueCallback<List<V2TIMMessageExtensionResult>> v2TIMValueCallback);

    public abstract void deleteMessageFromLocalStorage(V2TIMMessage v2TIMMessage, V2TIMCallback v2TIMCallback);

    public abstract void deleteMessages(List<V2TIMMessage> list, V2TIMCallback v2TIMCallback);

    public abstract void findMessages(List<String> list, V2TIMValueCallback<List<V2TIMMessage>> v2TIMValueCallback);

    public abstract void getC2CHistoryMessageList(String str, int i11, V2TIMMessage v2TIMMessage, V2TIMValueCallback<List<V2TIMMessage>> v2TIMValueCallback);

    public abstract void getC2CReceiveMessageOpt(List<String> list, V2TIMValueCallback<List<V2TIMReceiveMessageOptInfo>> v2TIMValueCallback);

    public abstract void getGroupHistoryMessageList(String str, int i11, V2TIMMessage v2TIMMessage, V2TIMValueCallback<List<V2TIMMessage>> v2TIMValueCallback);

    public abstract void getGroupMessageReadMemberList(V2TIMMessage v2TIMMessage, int i11, long j11, int i12, V2TIMValueCallback<V2TIMGroupMessageReadMemberList> v2TIMValueCallback);

    public abstract void getHistoryMessageList(V2TIMMessageListGetOption v2TIMMessageListGetOption, V2TIMValueCallback<List<V2TIMMessage>> v2TIMValueCallback);

    public abstract void getMessageExtensions(V2TIMMessage v2TIMMessage, V2TIMValueCallback<List<V2TIMMessageExtension>> v2TIMValueCallback);

    public abstract void getMessageReadReceipts(List<V2TIMMessage> list, V2TIMValueCallback<List<V2TIMMessageReceipt>> v2TIMValueCallback);

    public abstract String insertC2CMessageToLocalStorage(V2TIMMessage v2TIMMessage, String str, String str2, V2TIMValueCallback<V2TIMMessage> v2TIMValueCallback);

    public abstract String insertGroupMessageToLocalStorage(V2TIMMessage v2TIMMessage, String str, String str2, V2TIMValueCallback<V2TIMMessage> v2TIMValueCallback);

    @Deprecated
    public abstract void markAllMessageAsRead(V2TIMCallback v2TIMCallback);

    @Deprecated
    public abstract void markC2CMessageAsRead(String str, V2TIMCallback v2TIMCallback);

    @Deprecated
    public abstract void markGroupMessageAsRead(String str, V2TIMCallback v2TIMCallback);

    public abstract void modifyMessage(V2TIMMessage v2TIMMessage, V2TIMCompleteCallback<V2TIMMessage> v2TIMCompleteCallback);

    public abstract void removeAdvancedMsgListener(V2TIMAdvancedMsgListener v2TIMAdvancedMsgListener);

    public abstract void revokeMessage(V2TIMMessage v2TIMMessage, V2TIMCallback v2TIMCallback);

    public abstract void searchLocalMessages(V2TIMMessageSearchParam v2TIMMessageSearchParam, V2TIMValueCallback<V2TIMMessageSearchResult> v2TIMValueCallback);

    public abstract String sendMessage(V2TIMMessage v2TIMMessage, String str, String str2, int i11, boolean z11, V2TIMOfflinePushInfo v2TIMOfflinePushInfo, V2TIMSendCallback<V2TIMMessage> v2TIMSendCallback);

    public abstract void sendMessageReadReceipts(List<V2TIMMessage> list, V2TIMCallback v2TIMCallback);

    public abstract void setC2CReceiveMessageOpt(List<String> list, int i11, V2TIMCallback v2TIMCallback);

    public abstract void setGroupReceiveMessageOpt(String str, int i11, V2TIMCallback v2TIMCallback);

    public abstract void setMessageExtensions(V2TIMMessage v2TIMMessage, List<V2TIMMessageExtension> list, V2TIMValueCallback<List<V2TIMMessageExtensionResult>> v2TIMValueCallback);

    public abstract void translateText(List<String> list, String str, String str2, V2TIMValueCallback<HashMap<String, String>> v2TIMValueCallback);
}
