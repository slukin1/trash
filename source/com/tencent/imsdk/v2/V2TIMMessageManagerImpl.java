package com.tencent.imsdk.v2;

import android.text.TextUtils;
import com.tencent.imsdk.BaseConstants;
import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.common.IMContext;
import com.tencent.imsdk.common.IMLog;
import com.tencent.imsdk.conversation.ConversationManager;
import com.tencent.imsdk.group.GroupManager;
import com.tencent.imsdk.group.GroupMemberInfo;
import com.tencent.imsdk.manager.BaseManager;
import com.tencent.imsdk.message.C2CMessageReceipt;
import com.tencent.imsdk.message.CustomElement;
import com.tencent.imsdk.message.FaceElement;
import com.tencent.imsdk.message.FileElement;
import com.tencent.imsdk.message.GroupMessageReadMembers;
import com.tencent.imsdk.message.GroupMessageReceipt;
import com.tencent.imsdk.message.ImageElement;
import com.tencent.imsdk.message.LocationElement;
import com.tencent.imsdk.message.MergerElement;
import com.tencent.imsdk.message.Message;
import com.tencent.imsdk.message.MessageCenter;
import com.tencent.imsdk.message.MessageExtension;
import com.tencent.imsdk.message.MessageExtensionResult;
import com.tencent.imsdk.message.MessageKey;
import com.tencent.imsdk.message.MessageListGetOption;
import com.tencent.imsdk.message.MessageListener;
import com.tencent.imsdk.message.MessageSearchResult;
import com.tencent.imsdk.message.MessageUploadProgressCallback;
import com.tencent.imsdk.message.SoundElement;
import com.tencent.imsdk.message.TextElement;
import com.tencent.imsdk.message.VideoElement;
import com.tencent.imsdk.relationship.ReceiveMessageOptInfo;
import com.tencent.imsdk.relationship.RelationshipManager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class V2TIMMessageManagerImpl extends V2TIMMessageManager {
    private final int MAX_ABSTRACT_COUNT;
    private final int MAX_ABSTRACT_LENGTH;
    private final int MAX_FORWARD_COUNT;
    private final String TAG;
    /* access modifiers changed from: private */
    public Object mLockObject;
    private MessageListener mMessageListener;
    /* access modifiers changed from: private */
    public List<V2TIMAdvancedMsgListener> mV2TIMMsgListenerList;

    public static class V2TIMMessageManagerImplHolder {
        /* access modifiers changed from: private */
        public static final V2TIMMessageManagerImpl v2TIMMessageManagerImpl = new V2TIMMessageManagerImpl();

        private V2TIMMessageManagerImplHolder() {
        }
    }

    private void getC2CMessageReadReceipts(List<V2TIMMessage> list, final V2TIMValueCallback<List<V2TIMMessageReceipt>> v2TIMValueCallback) {
        ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        for (V2TIMMessage next : list) {
            if (next != null && next.getUserID() != null && !next.getUserID().isEmpty() && next.isSelf() && 2 == next.getStatus() && next.isNeedReadReceipt()) {
                arrayList.add(next.getMsgID());
            }
        }
        if (arrayList.size() != 0) {
            findMessages(arrayList, new V2TIMValueCallback<List<V2TIMMessage>>() {
                public void onError(int i11, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i11, str);
                    }
                }

                public void onSuccess(List<V2TIMMessage> list) {
                    for (V2TIMMessage message : list) {
                        Message message2 = message.getMessage();
                        C2CMessageReceipt c2CMessageReceipt = new C2CMessageReceipt();
                        c2CMessageReceipt.setUserID(message2.getReceiverUserID());
                        c2CMessageReceipt.setMessageID(message2.getMsgID());
                        c2CMessageReceipt.setPeerRead(message2.isReceiptPeerRead());
                        V2TIMMessageReceipt v2TIMMessageReceipt = new V2TIMMessageReceipt();
                        v2TIMMessageReceipt.setC2CMessageReceipt(c2CMessageReceipt);
                        arrayList2.add(v2TIMMessageReceipt);
                    }
                    if (arrayList2.size() > 0) {
                        V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                        if (v2TIMValueCallback != null) {
                            v2TIMValueCallback.onSuccess(arrayList2);
                            return;
                        }
                        return;
                    }
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid message list");
                    }
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid message list");
        }
    }

    private void getGroupMessageReadReceipts(List<V2TIMMessage> list, final V2TIMValueCallback<List<V2TIMMessageReceipt>> v2TIMValueCallback) {
        ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        for (V2TIMMessage next : list) {
            if (next != null && next.getGroupID() != null && next.getGroupID().length() != 0 && next.isSelf() && 2 == next.getStatus() && next.isNeedReadReceipt()) {
                Message message = next.getMessage();
                if (message.getReceiptUnreadCount() == 0) {
                    GroupMessageReceipt groupMessageReceipt = new GroupMessageReceipt();
                    groupMessageReceipt.setGroupID(message.getGroupID());
                    groupMessageReceipt.setMsgID(message.getMsgID());
                    groupMessageReceipt.setReadCount((long) message.getReceiptReadCount());
                    groupMessageReceipt.setUnreadCount((long) message.getReceiptUnreadCount());
                    V2TIMMessageReceipt v2TIMMessageReceipt = new V2TIMMessageReceipt();
                    v2TIMMessageReceipt.setGroupMessageReceipt(groupMessageReceipt);
                    arrayList2.add(v2TIMMessageReceipt);
                } else {
                    arrayList.add(message.getMessageKey());
                }
            }
        }
        if (arrayList.size() != 0) {
            MessageCenter.getInstance().getGroupMessageReceipts(arrayList, new IMCallback<List<GroupMessageReceipt>>(new V2TIMValueCallback<List<GroupMessageReceipt>>() {
                public void onError(int i11, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i11, str);
                    }
                }

                public void onSuccess(List<GroupMessageReceipt> list) {
                    for (GroupMessageReceipt next : list) {
                        V2TIMMessageReceipt v2TIMMessageReceipt = new V2TIMMessageReceipt();
                        GroupMessageReceipt groupMessageReceipt = new GroupMessageReceipt();
                        groupMessageReceipt.setGroupID(next.getGroupID());
                        groupMessageReceipt.setMsgID(next.getMsgID());
                        groupMessageReceipt.setReadCount(next.getReadCount());
                        groupMessageReceipt.setUnreadCount(next.getUnreadCount());
                        v2TIMMessageReceipt.setGroupMessageReceipt(groupMessageReceipt);
                        arrayList2.add(v2TIMMessageReceipt);
                    }
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onSuccess(arrayList2);
                    }
                }
            }) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(List<GroupMessageReceipt> list) {
                    super.success(list);
                }
            });
        } else if (arrayList2.size() > 0) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onSuccess(arrayList2);
            }
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid messages");
        }
    }

    public static V2TIMMessageManagerImpl getInstance() {
        return V2TIMMessageManagerImplHolder.v2TIMMessageManagerImpl;
    }

    public void addAdvancedMsgListener(V2TIMAdvancedMsgListener v2TIMAdvancedMsgListener) {
        if (v2TIMAdvancedMsgListener != null) {
            synchronized (this.mLockObject) {
                if (!this.mV2TIMMsgListenerList.contains(v2TIMAdvancedMsgListener)) {
                    this.mV2TIMMsgListenerList.add(v2TIMAdvancedMsgListener);
                }
            }
        }
    }

    public void clearC2CHistoryMessage(String str, V2TIMCallback v2TIMCallback) {
        if (!TextUtils.isEmpty(str)) {
            MessageCenter.getInstance().clearC2CHistoryMessage(str, new IMCallback(v2TIMCallback) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else if (v2TIMCallback != null) {
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "userID is empty");
        }
    }

    public void clearGroupHistoryMessage(String str, V2TIMCallback v2TIMCallback) {
        if (!TextUtils.isEmpty(str)) {
            MessageCenter.getInstance().clearGroupHistoryMessage(str, new IMCallback(v2TIMCallback) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else if (v2TIMCallback != null) {
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID is empty");
        }
    }

    public V2TIMMessage createAtSignedGroupMessage(V2TIMMessage v2TIMMessage, List<String> list) {
        if (v2TIMMessage == null) {
            IMLog.e("V2TIMMessageManagerImpl", "createAtSignedGroupMessage, message cannot be null");
            return null;
        } else if (list == null || list.isEmpty()) {
            IMLog.e("V2TIMMessageManagerImpl", "atUserList cannot be empty");
            return null;
        } else {
            v2TIMMessage.setGroupAtUserList(list);
            return v2TIMMessage;
        }
    }

    public V2TIMMessage createCustomMessage(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            IMLog.e("V2TIMMessageManagerImpl", "data cannot be empty");
            return null;
        }
        V2TIMMessage v2TIMMessage = new V2TIMMessage();
        Message message = v2TIMMessage.getMessage();
        CustomElement customElement = new CustomElement();
        customElement.setData(bArr);
        message.addElement(customElement);
        return v2TIMMessage;
    }

    public V2TIMMessage createFaceMessage(int i11, byte[] bArr) {
        V2TIMMessage v2TIMMessage = new V2TIMMessage();
        Message message = v2TIMMessage.getMessage();
        FaceElement faceElement = new FaceElement();
        faceElement.setFaceData(bArr);
        faceElement.setFaceIndex(i11);
        message.addElement(faceElement);
        return v2TIMMessage;
    }

    public V2TIMMessage createFileMessage(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            IMLog.e("V2TIMMessageManagerImpl", "filePath cannot be empty");
            return null;
        } else if (!new File(str).exists()) {
            return null;
        } else {
            if (TextUtils.isEmpty(str2)) {
                IMLog.e("V2TIMMessageManagerImpl", "fileName cannot be empty");
                return null;
            }
            V2TIMMessage v2TIMMessage = new V2TIMMessage();
            Message message = v2TIMMessage.getMessage();
            FileElement fileElement = new FileElement();
            fileElement.setFilePath(str);
            fileElement.setFileName(str2);
            message.addElement(fileElement);
            return v2TIMMessage;
        }
    }

    public V2TIMMessage createForwardMessage(V2TIMMessage v2TIMMessage) {
        if (v2TIMMessage == null) {
            IMLog.e("V2TIMMessageManagerImpl", "createForwardMessage, message cannot be null");
            return null;
        } else if (2 != v2TIMMessage.getStatus()) {
            IMLog.e("V2TIMMessageManagerImpl", "message status must be V2TIM_MSG_STATUS_SEND_SUCC");
            return null;
        } else if (9 == v2TIMMessage.getElemType()) {
            IMLog.e("V2TIMMessageManagerImpl", "group tips message is not support");
            return null;
        } else {
            V2TIMMessage v2TIMMessage2 = new V2TIMMessage();
            Message message = v2TIMMessage2.getMessage();
            message.setMessageBaseElements(v2TIMMessage.getMessage().getMessageBaseElements());
            message.setForward(true);
            return v2TIMMessage2;
        }
    }

    public V2TIMMessage createImageMessage(String str) {
        if (TextUtils.isEmpty(str)) {
            IMLog.e("V2TIMMessageManagerImpl", "imagePath cannot be empty");
            return null;
        } else if (!new File(str).exists()) {
            IMLog.e("V2TIMMessageManagerImpl", "file not exist");
            return null;
        } else {
            V2TIMMessage v2TIMMessage = new V2TIMMessage();
            Message message = v2TIMMessage.getMessage();
            ImageElement imageElement = new ImageElement();
            imageElement.setOriginImageFilePath(str);
            message.addElement(imageElement);
            return v2TIMMessage;
        }
    }

    public V2TIMMessage createLocationMessage(String str, double d11, double d12) {
        V2TIMMessage v2TIMMessage = new V2TIMMessage();
        Message message = v2TIMMessage.getMessage();
        LocationElement locationElement = new LocationElement();
        locationElement.setLongitude(d11);
        locationElement.setLatitude(d12);
        locationElement.setDescription(str);
        message.addElement(locationElement);
        return v2TIMMessage;
    }

    public V2TIMMessage createMergerMessage(List<V2TIMMessage> list, String str, List<String> list2, String str2) {
        if (list == null || list.size() == 0 || list.size() > 300) {
            IMLog.e("V2TIMMessageManagerImpl", "messageList invalid, the number of messageList must be between 1 and 300");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (list2 != null) {
            int size = list2.size();
            if (size >= 5) {
                size = 5;
            }
            for (int i11 = 0; i11 < size; i11++) {
                String str3 = list2.get(i11);
                if (str3 != null) {
                    if (str3.length() > 100) {
                        str3 = str3.substring(0, 100);
                    }
                    arrayList.add(str3);
                }
            }
        }
        for (V2TIMMessage next : list) {
            if (2 != next.getStatus()) {
                IMLog.e("V2TIMMessageManagerImpl", "message status must be V2TIM_MSG_STATUS_SEND_SUCC");
                return null;
            } else if (9 == next.getElemType()) {
                IMLog.e("V2TIMMessageManagerImpl", "group tips message is not support");
                return null;
            }
        }
        if (str2 == null) {
            IMLog.e("V2TIMMessageManagerImpl", "compatibleText invalid, compatibleText cannot be null");
            return null;
        }
        MergerElement mergerElement = new MergerElement();
        mergerElement.setTitle(str);
        mergerElement.setAbstractList(arrayList);
        mergerElement.setCompatibleText(str2);
        ArrayList arrayList2 = new ArrayList();
        for (V2TIMMessage message : list) {
            arrayList2.add(message.getMessage());
        }
        mergerElement.setMessageList(arrayList2);
        V2TIMMessage v2TIMMessage = new V2TIMMessage();
        Message message2 = v2TIMMessage.getMessage();
        message2.addElement(mergerElement);
        message2.setForward(true);
        return v2TIMMessage;
    }

    public V2TIMMessage createSoundMessage(String str, int i11) {
        if (TextUtils.isEmpty(str)) {
            IMLog.e("V2TIMMessageManagerImpl", "soundPath cannot be empty");
            return null;
        } else if (!new File(str).exists()) {
            IMLog.e("V2TIMMessageManagerImpl", "file not exist");
            return null;
        } else {
            V2TIMMessage v2TIMMessage = new V2TIMMessage();
            Message message = v2TIMMessage.getMessage();
            SoundElement soundElement = new SoundElement();
            if (i11 < 0) {
                i11 = 0;
            }
            soundElement.setSoundDuration(i11);
            soundElement.setSoundFilePath(str);
            message.addElement(soundElement);
            return v2TIMMessage;
        }
    }

    public V2TIMMessage createTargetedGroupMessage(V2TIMMessage v2TIMMessage, List<String> list) {
        if (v2TIMMessage == null) {
            IMLog.e("V2TIMMessageManagerImpl", "createTargetedGroupMessage, message cannot be null");
            return null;
        } else if (list == null || list.isEmpty()) {
            IMLog.e("V2TIMMessageManagerImpl", "receiverList cannot be empty");
            return null;
        } else {
            List<String> groupAtUserList = v2TIMMessage.getGroupAtUserList();
            if (groupAtUserList == null || groupAtUserList.isEmpty()) {
                v2TIMMessage.getMessage().setTargetGroupMemberList(list);
                return v2TIMMessage;
            }
            IMLog.e("V2TIMMessageManagerImpl", "targeted group message does not support at message");
            return null;
        }
    }

    public V2TIMMessage createTextAtMessage(String str, List<String> list) {
        if (TextUtils.isEmpty(str)) {
            IMLog.e("V2TIMMessageManagerImpl", "text cannot be empty");
            return null;
        } else if (list == null || list.isEmpty()) {
            IMLog.e("V2TIMMessageManagerImpl", "atUserList cannot be empty");
            return null;
        } else {
            V2TIMMessage v2TIMMessage = new V2TIMMessage();
            Message message = v2TIMMessage.getMessage();
            TextElement textElement = new TextElement();
            textElement.setTextContent(str);
            message.addElement(textElement);
            v2TIMMessage.setGroupAtUserList(list);
            return v2TIMMessage;
        }
    }

    public V2TIMMessage createTextMessage(String str) {
        if (TextUtils.isEmpty(str)) {
            IMLog.e("V2TIMMessageManagerImpl", "text cannot be empty");
            return null;
        }
        V2TIMMessage v2TIMMessage = new V2TIMMessage();
        Message message = v2TIMMessage.getMessage();
        TextElement textElement = new TextElement();
        textElement.setTextContent(str);
        message.addElement(textElement);
        return v2TIMMessage;
    }

    public V2TIMMessage createVideoMessage(String str, String str2, int i11, String str3) {
        if (TextUtils.isEmpty(str)) {
            IMLog.e("V2TIMMessageManagerImpl", "videoFilePath cannot be empty");
            return null;
        } else if (!new File(str).exists()) {
            IMLog.e("V2TIMMessageManagerImpl", "video file not exist");
            return null;
        } else if (TextUtils.isEmpty(str3)) {
            IMLog.e("V2TIMMessageManagerImpl", "snapshotPath cannot be empty");
            return null;
        } else if (!new File(str3).exists()) {
            IMLog.e("V2TIMMessageManagerImpl", "snapshot file not exist");
            return null;
        } else {
            V2TIMMessage v2TIMMessage = new V2TIMMessage();
            Message message = v2TIMMessage.getMessage();
            VideoElement videoElement = new VideoElement();
            videoElement.setVideoFilePath(str);
            videoElement.setSnapshotFilePath(str3);
            if (i11 < 0) {
                i11 = 0;
            }
            videoElement.setVideoDuration(i11);
            videoElement.setVideoType(str2);
            message.addElement(videoElement);
            return v2TIMMessage;
        }
    }

    public void deleteMessageExtensions(V2TIMMessage v2TIMMessage, List<String> list, final V2TIMValueCallback<List<V2TIMMessageExtensionResult>> v2TIMValueCallback) {
        if (v2TIMMessage != null) {
            MessageCenter.getInstance().deleteMessageExtensions(v2TIMMessage.getMessage(), list, new IMCallback(new V2TIMValueCallback<List<MessageExtensionResult>>() {
                public void onError(int i11, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i11, str);
                    }
                }

                public void onSuccess(List<MessageExtensionResult> list) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (MessageExtensionResult messageExtensionResult : list) {
                            V2TIMMessageExtensionResult v2TIMMessageExtensionResult = new V2TIMMessageExtensionResult();
                            v2TIMMessageExtensionResult.setMessageExtensionResult(messageExtensionResult);
                            arrayList.add(v2TIMMessageExtensionResult);
                        }
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
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid message");
        }
    }

    public void deleteMessageFromLocalStorage(V2TIMMessage v2TIMMessage, V2TIMCallback v2TIMCallback) {
        if (v2TIMMessage != null) {
            MessageCenter.getInstance().deleteLocalMessage(v2TIMMessage.getMessage().getMessageKey(), new IMCallback(v2TIMCallback) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else if (v2TIMCallback != null) {
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "message is null");
        }
    }

    public void deleteMessages(List<V2TIMMessage> list, V2TIMCallback v2TIMCallback) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (V2TIMMessage message : list) {
                arrayList.add(message.getMessage().getMessageKey());
            }
            MessageCenter.getInstance().deleteCloudMessageList(arrayList, new IMCallback(v2TIMCallback) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else if (v2TIMCallback != null) {
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "messages is invalid");
        }
    }

    public void findMessages(List<String> list, final V2TIMValueCallback<List<V2TIMMessage>> v2TIMValueCallback) {
        if (list != null && !list.isEmpty()) {
            MessageCenter.getInstance().findMessageByMessageId(list, new IMCallback<List<Message>>(new V2TIMValueCallback<List<Message>>() {
                public void onError(int i11, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i11, str);
                    }
                }

                public void onSuccess(List<Message> list) {
                    ArrayList arrayList = new ArrayList();
                    for (Message message : list) {
                        V2TIMMessage v2TIMMessage = new V2TIMMessage();
                        v2TIMMessage.setMessage(message);
                        arrayList.add(v2TIMMessage);
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

                public void success(List<Message> list) {
                    super.success(list);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "messages is empty");
        }
    }

    public void getC2CHistoryMessageList(String str, int i11, V2TIMMessage v2TIMMessage, final V2TIMValueCallback<List<V2TIMMessage>> v2TIMValueCallback) {
        if (!TextUtils.isEmpty(str) && i11 != 0) {
            AnonymousClass9 r02 = new V2TIMValueCallback<List<Message>>() {
                public void onError(int i11, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i11, str);
                    }
                }

                public void onSuccess(List<Message> list) {
                    ArrayList arrayList = new ArrayList();
                    for (Message message : list) {
                        V2TIMMessage v2TIMMessage = new V2TIMMessage();
                        v2TIMMessage.setMessage(message);
                        arrayList.add(v2TIMMessage);
                    }
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            };
            MessageKey messageKey = null;
            if (v2TIMMessage != null) {
                messageKey = v2TIMMessage.getMessage().getMessageKey();
            }
            MessageListGetOption messageListGetOption = new MessageListGetOption();
            messageListGetOption.setCount(i11);
            messageListGetOption.setToOlderMessage(true);
            messageListGetOption.setGetCloudMessage(true);
            messageListGetOption.setMessageKey(messageKey);
            MessageCenter.getInstance().getC2CHistoryMessageList(str, messageListGetOption, new IMCallback<List<Message>>(r02) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(List<Message> list) {
                    super.success(list);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "userID is empty or count is 0");
        }
    }

    public void getC2CReceiveMessageOpt(List<String> list, final V2TIMValueCallback<List<V2TIMReceiveMessageOptInfo>> v2TIMValueCallback) {
        if (list != null && list.size() != 0) {
            RelationshipManager.getInstance().getC2CReceiveMessageOpt(list, new IMCallback<List<ReceiveMessageOptInfo>>(new V2TIMValueCallback<List<ReceiveMessageOptInfo>>() {
                public void onError(int i11, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i11, str);
                    }
                }

                public void onSuccess(List<ReceiveMessageOptInfo> list) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (ReceiveMessageOptInfo next : list) {
                            V2TIMReceiveMessageOptInfo v2TIMReceiveMessageOptInfo = new V2TIMReceiveMessageOptInfo();
                            v2TIMReceiveMessageOptInfo.setUserID(next.getUserID());
                            v2TIMReceiveMessageOptInfo.setC2CReceiveMessageOpt(next.getC2CReceiveMessageOpt());
                            arrayList.add(v2TIMReceiveMessageOptInfo);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(List<ReceiveMessageOptInfo> list) {
                    super.success(list);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid userIDList");
        }
    }

    public void getGroupHistoryMessageList(String str, int i11, V2TIMMessage v2TIMMessage, final V2TIMValueCallback<List<V2TIMMessage>> v2TIMValueCallback) {
        if (!TextUtils.isEmpty(str) && i11 > 0) {
            AnonymousClass11 r02 = new V2TIMValueCallback<List<Message>>() {
                public void onError(int i11, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i11, str);
                    }
                }

                public void onSuccess(List<Message> list) {
                    ArrayList arrayList = new ArrayList();
                    for (Message message : list) {
                        V2TIMMessage v2TIMMessage = new V2TIMMessage();
                        v2TIMMessage.setMessage(message);
                        arrayList.add(v2TIMMessage);
                    }
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            };
            MessageKey messageKey = null;
            if (v2TIMMessage != null) {
                messageKey = v2TIMMessage.getMessage().getMessageKey();
            }
            MessageListGetOption messageListGetOption = new MessageListGetOption();
            messageListGetOption.setCount(i11);
            messageListGetOption.setToOlderMessage(true);
            messageListGetOption.setGetCloudMessage(true);
            messageListGetOption.setMessageKey(messageKey);
            MessageCenter.getInstance().getGroupHistoryMessageList(str, messageListGetOption, new IMCallback<List<Message>>(r02) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(List<Message> list) {
                    super.success(list);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID is empty or count is 0");
        }
    }

    public void getGroupMessageReadMemberList(V2TIMMessage v2TIMMessage, final int i11, long j11, int i12, final V2TIMValueCallback<V2TIMGroupMessageReadMemberList> v2TIMValueCallback) {
        if (v2TIMMessage == null || v2TIMMessage.getGroupID() == null || v2TIMMessage.getGroupID().length() == 0 || !v2TIMMessage.isSelf() || 2 != v2TIMMessage.getStatus() || !v2TIMMessage.isNeedReadReceipt()) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid message");
            }
        } else if (i12 <= 100) {
            int i13 = i11;
            long j12 = j11;
            int i14 = i12;
            MessageCenter.getInstance().getGroupMessageReadMembers(v2TIMMessage.getMessage(), i13, j12, i14, new IMCallback<GroupMessageReadMembers>(new V2TIMValueCallback<GroupMessageReadMembers>() {
                public void onError(int i11, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i11, str);
                    }
                }

                public void onSuccess(GroupMessageReadMembers groupMessageReadMembers) {
                    if (v2TIMValueCallback != null) {
                        V2TIMGroupMessageReadMemberList v2TIMGroupMessageReadMemberList = new V2TIMGroupMessageReadMemberList();
                        v2TIMGroupMessageReadMemberList.setMessageReadMembers(groupMessageReadMembers, i11);
                        v2TIMValueCallback.onSuccess(v2TIMGroupMessageReadMemberList);
                    }
                }
            }) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(GroupMessageReadMembers groupMessageReadMembers) {
                    super.success(groupMessageReadMembers);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid count, maximum support 100");
        }
    }

    public void getHistoryMessageList(V2TIMMessageListGetOption v2TIMMessageListGetOption, final V2TIMValueCallback<List<V2TIMMessage>> v2TIMValueCallback) {
        if (v2TIMMessageListGetOption == null) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "option is null");
            }
        } else if (!TextUtils.isEmpty(v2TIMMessageListGetOption.getUserID()) || !TextUtils.isEmpty(v2TIMMessageListGetOption.getGroupID())) {
            if (TextUtils.isEmpty(v2TIMMessageListGetOption.getUserID()) || TextUtils.isEmpty(v2TIMMessageListGetOption.getGroupID())) {
                MessageListGetOption messageListGetOption = new MessageListGetOption();
                messageListGetOption.setCount(v2TIMMessageListGetOption.getCount());
                messageListGetOption.setGetTimeBegin(v2TIMMessageListGetOption.getGetTimeBegin());
                messageListGetOption.setGetTimePeriod(v2TIMMessageListGetOption.getGetTimePeriod());
                int getType = v2TIMMessageListGetOption.getGetType();
                if (getType == 1) {
                    messageListGetOption.setToOlderMessage(true);
                    messageListGetOption.setGetCloudMessage(true);
                } else if (getType == 2) {
                    messageListGetOption.setToOlderMessage(false);
                    messageListGetOption.setGetCloudMessage(true);
                } else if (getType == 3) {
                    messageListGetOption.setToOlderMessage(true);
                    messageListGetOption.setGetCloudMessage(false);
                    messageListGetOption.setMessageTypeList(v2TIMMessageListGetOption.getMessageTypeList());
                } else if (getType == 4) {
                    messageListGetOption.setToOlderMessage(false);
                    messageListGetOption.setGetCloudMessage(false);
                    messageListGetOption.setMessageTypeList(v2TIMMessageListGetOption.getMessageTypeList());
                } else if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "getType is invalid");
                    return;
                } else {
                    return;
                }
                if (v2TIMMessageListGetOption.getLastMsg() != null) {
                    messageListGetOption.setMessageKey(v2TIMMessageListGetOption.getLastMsg().getMessage().getMessageKey());
                } else if (!TextUtils.isEmpty(v2TIMMessageListGetOption.getGroupID()) && v2TIMMessageListGetOption.getLastMsgSeq() > 0) {
                    MessageKey messageKey = new MessageKey();
                    messageKey.setSeq(v2TIMMessageListGetOption.getLastMsgSeq());
                    messageListGetOption.setMessageKey(messageKey);
                }
                messageListGetOption.setMessageSequenceList(v2TIMMessageListGetOption.getMessageSeqList());
                AnonymousClass13 r02 = new V2TIMValueCallback<List<Message>>() {
                    public void onError(int i11, String str) {
                        V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                        if (v2TIMValueCallback != null) {
                            v2TIMValueCallback.onError(i11, str);
                        }
                    }

                    public void onSuccess(List<Message> list) {
                        ArrayList arrayList = new ArrayList();
                        for (Message message : list) {
                            V2TIMMessage v2TIMMessage = new V2TIMMessage();
                            v2TIMMessage.setMessage(message);
                            arrayList.add(v2TIMMessage);
                        }
                        V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                        if (v2TIMValueCallback != null) {
                            v2TIMValueCallback.onSuccess(arrayList);
                        }
                    }
                };
                if (!TextUtils.isEmpty(v2TIMMessageListGetOption.getUserID())) {
                    MessageCenter.getInstance().getC2CHistoryMessageList(v2TIMMessageListGetOption.getUserID(), messageListGetOption, new IMCallback<List<Message>>(r02) {
                        public void fail(int i11, String str) {
                            super.fail(i11, str);
                        }

                        public void success(List<Message> list) {
                            super.success(list);
                        }
                    });
                } else {
                    MessageCenter.getInstance().getGroupHistoryMessageList(v2TIMMessageListGetOption.getGroupID(), messageListGetOption, new IMCallback<List<Message>>(r02) {
                        public void fail(int i11, String str) {
                            super.fail(i11, str);
                        }

                        public void success(List<Message> list) {
                            super.success(list);
                        }
                    });
                }
            } else if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID and userID cannot set at the same time");
            }
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID and userID cannot be null at the same time");
        }
    }

    public void getMessageExtensions(V2TIMMessage v2TIMMessage, final V2TIMValueCallback<List<V2TIMMessageExtension>> v2TIMValueCallback) {
        if (v2TIMMessage != null) {
            MessageCenter.getInstance().getMessageExtensions(v2TIMMessage.getMessage(), new IMCallback<List<MessageExtension>>(new V2TIMValueCallback<List<MessageExtension>>() {
                public void onError(int i11, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i11, str);
                    }
                }

                public void onSuccess(List<MessageExtension> list) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (MessageExtension messageExtension : list) {
                            V2TIMMessageExtension v2TIMMessageExtension = new V2TIMMessageExtension();
                            v2TIMMessageExtension.setMessageExtension(messageExtension);
                            arrayList.add(v2TIMMessageExtension);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(List<MessageExtension> list) {
                    super.success(list);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid message");
        }
    }

    public void getMessageReadReceipts(List<V2TIMMessage> list, V2TIMValueCallback<List<V2TIMMessageReceipt>> v2TIMValueCallback) {
        if (list != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(list);
            V2TIMMessage v2TIMMessage = (V2TIMMessage) arrayList.get(0);
            if (v2TIMMessage.getUserID() == null || v2TIMMessage.getUserID().isEmpty()) {
                getGroupMessageReadReceipts(arrayList, v2TIMValueCallback);
            } else {
                getC2CMessageReadReceipts(arrayList, v2TIMValueCallback);
            }
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid message list");
        }
    }

    public void initListener() {
        this.mMessageListener = new MessageListener() {
            public void onReceiveC2CMessageReceipt(List<C2CMessageReceipt> list) {
                ArrayList arrayList = new ArrayList();
                boolean z11 = false;
                for (int i11 = 0; i11 < list.size(); i11++) {
                    C2CMessageReceipt c2CMessageReceipt = list.get(i11);
                    V2TIMMessageReceipt v2TIMMessageReceipt = new V2TIMMessageReceipt();
                    v2TIMMessageReceipt.setC2CMessageReceipt(c2CMessageReceipt);
                    arrayList.add(v2TIMMessageReceipt);
                    if (i11 == 0) {
                        z11 = !TextUtils.isEmpty(c2CMessageReceipt.getMessageID());
                    }
                }
                synchronized (V2TIMMessageManagerImpl.this.mLockObject) {
                    for (V2TIMAdvancedMsgListener v2TIMAdvancedMsgListener : V2TIMMessageManagerImpl.this.mV2TIMMsgListenerList) {
                        if (z11) {
                            v2TIMAdvancedMsgListener.onRecvMessageReadReceipts(arrayList);
                        } else {
                            v2TIMAdvancedMsgListener.onRecvC2CReadReceipt(arrayList);
                        }
                    }
                }
            }

            public void onReceiveGroupMessageReceipt(List<GroupMessageReceipt> list) {
                ArrayList arrayList = new ArrayList();
                for (GroupMessageReceipt groupMessageReceipt : list) {
                    V2TIMMessageReceipt v2TIMMessageReceipt = new V2TIMMessageReceipt();
                    v2TIMMessageReceipt.setGroupMessageReceipt(groupMessageReceipt);
                    arrayList.add(v2TIMMessageReceipt);
                }
                synchronized (V2TIMMessageManagerImpl.this.mLockObject) {
                    for (V2TIMAdvancedMsgListener onRecvMessageReadReceipts : V2TIMMessageManagerImpl.this.mV2TIMMsgListenerList) {
                        onRecvMessageReadReceipts.onRecvMessageReadReceipts(arrayList);
                    }
                }
            }

            public void onReceiveMessageExtensionsChanged(MessageKey messageKey, List<MessageExtension> list) {
                String str = "";
                if (messageKey != null) {
                    str = messageKey.getMessageID();
                }
                ArrayList arrayList = new ArrayList();
                for (MessageExtension messageExtension : list) {
                    V2TIMMessageExtension v2TIMMessageExtension = new V2TIMMessageExtension();
                    v2TIMMessageExtension.setMessageExtension(messageExtension);
                    arrayList.add(v2TIMMessageExtension);
                }
                synchronized (V2TIMMessageManagerImpl.this.mLockObject) {
                    for (V2TIMAdvancedMsgListener onRecvMessageExtensionsChanged : V2TIMMessageManagerImpl.this.mV2TIMMsgListenerList) {
                        onRecvMessageExtensionsChanged.onRecvMessageExtensionsChanged(str, arrayList);
                    }
                }
            }

            public void onReceiveMessageExtensionsDeleted(MessageKey messageKey, List<MessageExtension> list) {
                String str = "";
                if (messageKey != null) {
                    str = messageKey.getMessageID();
                }
                ArrayList arrayList = new ArrayList();
                for (MessageExtension extensionKey : list) {
                    arrayList.add(extensionKey.getExtensionKey());
                }
                synchronized (V2TIMMessageManagerImpl.this.mLockObject) {
                    for (V2TIMAdvancedMsgListener onRecvMessageExtensionsDeleted : V2TIMMessageManagerImpl.this.mV2TIMMsgListenerList) {
                        onRecvMessageExtensionsDeleted.onRecvMessageExtensionsDeleted(str, arrayList);
                    }
                }
            }

            public void onReceiveMessageModified(List<Message> list) {
                for (Message message : list) {
                    V2TIMMessage v2TIMMessage = new V2TIMMessage();
                    v2TIMMessage.setMessage(message);
                    synchronized (V2TIMMessageManagerImpl.this.mLockObject) {
                        for (V2TIMAdvancedMsgListener onRecvMessageModified : V2TIMMessageManagerImpl.this.mV2TIMMsgListenerList) {
                            onRecvMessageModified.onRecvMessageModified(v2TIMMessage);
                        }
                    }
                }
            }

            public void onReceiveMessageRevoked(List<MessageKey> list) {
                if (list != null && !list.isEmpty()) {
                    for (MessageKey next : list) {
                        synchronized (V2TIMMessageManagerImpl.this.mLockObject) {
                            for (V2TIMAdvancedMsgListener onRecvMessageRevoked : V2TIMMessageManagerImpl.this.mV2TIMMsgListenerList) {
                                onRecvMessageRevoked.onRecvMessageRevoked(next.getMessageID());
                            }
                        }
                    }
                }
            }

            public void onReceiveNewMessage(List<Message> list) {
                if (list != null && !list.isEmpty()) {
                    for (Message message : list) {
                        V2TIMMessage v2TIMMessage = new V2TIMMessage();
                        v2TIMMessage.setMessage(message);
                        V2TIMMessageManagerImpl.this.onRecvNewMessage(v2TIMMessage);
                    }
                }
            }
        };
        MessageCenter.getInstance().addMessageListener(this.mMessageListener);
    }

    public String insertC2CMessageToLocalStorage(final V2TIMMessage v2TIMMessage, String str, String str2, final V2TIMValueCallback<V2TIMMessage> v2TIMValueCallback) {
        if (v2TIMMessage == null) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "message is null!");
            }
            return "";
        } else if (TextUtils.isEmpty(str)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "userID is empty");
            }
            return "";
        } else if (TextUtils.isEmpty(str2)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "sender is empty");
            }
            return "";
        } else {
            Message message = v2TIMMessage.getMessage();
            message.setMessageType(Message.MESSAGE_TYPE_C2C);
            message.setSenderUserID(str2);
            message.setReceiverUserID(str);
            return MessageCenter.getInstance().insertLocalMessage(message, new IMCallback(new V2TIMValueCallback<Message>() {
                public void onError(int i11, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i11, str);
                    }
                }

                public void onSuccess(Message message) {
                    if (v2TIMValueCallback != null) {
                        v2TIMMessage.setMessage(message);
                        v2TIMValueCallback.onSuccess(v2TIMMessage);
                    }
                }
            }) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(Object obj) {
                    v2TIMMessage.getMessage().update((Message) obj);
                    super.success(obj);
                }
            });
        }
    }

    public String insertGroupMessageToLocalStorage(final V2TIMMessage v2TIMMessage, String str, String str2, final V2TIMValueCallback<V2TIMMessage> v2TIMValueCallback) {
        if (v2TIMMessage == null) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "message is null!");
            }
            return "";
        } else if (TextUtils.isEmpty(str)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID is empty");
            }
            return "";
        } else if (TextUtils.isEmpty(str2)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "sender is empty");
            }
            return "";
        } else {
            Message message = v2TIMMessage.getMessage();
            message.setMessageType(Message.MESSAGE_TYPE_GROUP);
            message.setSenderUserID(str2);
            message.setGroupID(str);
            return MessageCenter.getInstance().insertLocalMessage(message, new IMCallback(new V2TIMValueCallback<Message>() {
                public void onError(int i11, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i11, str);
                    }
                }

                public void onSuccess(Message message) {
                    if (v2TIMValueCallback != null) {
                        v2TIMMessage.setMessage(message);
                        v2TIMValueCallback.onSuccess(v2TIMMessage);
                    }
                }
            }) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(Object obj) {
                    v2TIMMessage.getMessage().update((Message) obj);
                    super.success(obj);
                }
            });
        }
    }

    public void markAllMessageAsRead(V2TIMCallback v2TIMCallback) {
        ConversationManager.getInstance().clearUnreadMessage(true, true, new IMCallback(v2TIMCallback) {
            public void fail(int i11, String str) {
                super.fail(i11, str);
            }

            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    public void markC2CMessageAsRead(String str, V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            ConversationManager.getInstance().clearUnreadMessage(true, false, new IMCallback(v2TIMCallback) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else {
            MessageCenter.getInstance().setC2CMessageRead(str, 0, new IMCallback(v2TIMCallback) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        }
    }

    public void markGroupMessageAsRead(String str, V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            ConversationManager.getInstance().clearUnreadMessage(false, true, new IMCallback(v2TIMCallback) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else {
            MessageCenter.getInstance().setGroupMessageRead(str, 0, new IMCallback(v2TIMCallback) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        }
    }

    public void modifyMessage(V2TIMMessage v2TIMMessage, final V2TIMCompleteCallback<V2TIMMessage> v2TIMCompleteCallback) {
        if (v2TIMMessage != null) {
            MessageCenter.getInstance().modifyMessage(v2TIMMessage.getMessage(), new IMCallback(new V2TIMCompleteCallback<Message>() {
                public void onComplete(int i11, String str, Message message) {
                    V2TIMMessage v2TIMMessage;
                    if (message != null) {
                        v2TIMMessage = new V2TIMMessage();
                        v2TIMMessage.setMessage(message);
                    } else {
                        v2TIMMessage = null;
                    }
                    V2TIMCompleteCallback v2TIMCompleteCallback = v2TIMCompleteCallback;
                    if (v2TIMCompleteCallback != null) {
                        v2TIMCompleteCallback.onComplete(i11, str, v2TIMMessage);
                    }
                }
            }) {
                public void fail(int i11, String str, Object obj) {
                    super.fail(i11, str, obj);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else if (v2TIMCompleteCallback != null) {
            v2TIMCompleteCallback.onComplete(BaseConstants.ERR_INVALID_PARAMETERS, "msg is null", null);
        }
    }

    public void onRecvNewMessage(V2TIMMessage v2TIMMessage) {
        synchronized (this.mLockObject) {
            for (V2TIMAdvancedMsgListener onRecvNewMessage : this.mV2TIMMsgListenerList) {
                onRecvNewMessage.onRecvNewMessage(v2TIMMessage);
            }
        }
    }

    public void removeAdvancedMsgListener(V2TIMAdvancedMsgListener v2TIMAdvancedMsgListener) {
        if (v2TIMAdvancedMsgListener != null) {
            synchronized (this.mLockObject) {
                this.mV2TIMMsgListenerList.remove(v2TIMAdvancedMsgListener);
            }
        }
    }

    public void revokeMessage(V2TIMMessage v2TIMMessage, V2TIMCallback v2TIMCallback) {
        if (v2TIMMessage == null) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "msg is null");
            }
        } else if (v2TIMMessage.getStatus() == 2) {
            MessageCenter.getInstance().revokeMessage(v2TIMMessage.getMessage().getMessageKey(), new IMCallback(v2TIMCallback) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else if (v2TIMCallback != null) {
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "msg status must be V2TIM_MSG_STATUS_SEND_SUCC");
        }
    }

    public void searchLocalMessages(V2TIMMessageSearchParam v2TIMMessageSearchParam, final V2TIMValueCallback<V2TIMMessageSearchResult> v2TIMValueCallback) {
        if (v2TIMMessageSearchParam.getSearchTimePosition() < 0 || v2TIMMessageSearchParam.getSearchTimePeriod() < 0) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "time < 0");
            }
        } else if (v2TIMMessageSearchParam.getPageIndex() >= 0 && v2TIMMessageSearchParam.getPageSize() >= 0) {
            MessageCenter.getInstance().findMessageBySearchKey(v2TIMMessageSearchParam.getMessageSearchParam(), new IMCallback<MessageSearchResult>(new V2TIMValueCallback<MessageSearchResult>() {
                public void onError(int i11, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i11, str);
                    }
                }

                public void onSuccess(MessageSearchResult messageSearchResult) {
                    V2TIMMessageSearchResult v2TIMMessageSearchResult = new V2TIMMessageSearchResult();
                    v2TIMMessageSearchResult.setMessageSearchResult(messageSearchResult);
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onSuccess(v2TIMMessageSearchResult);
                    }
                }
            }) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(MessageSearchResult messageSearchResult) {
                    super.success(messageSearchResult);
                }
            });
            BaseManager.getInstance().checkTUIComponent(6);
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "pageIndex or pageSize is invalid");
        }
    }

    public String sendMessage(final V2TIMMessage v2TIMMessage, String str, String str2, int i11, boolean z11, V2TIMOfflinePushInfo v2TIMOfflinePushInfo, final V2TIMSendCallback<V2TIMMessage> v2TIMSendCallback) {
        if (v2TIMMessage == null) {
            if (v2TIMSendCallback != null) {
                v2TIMSendCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "message is null");
            }
            return null;
        } else if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
            Message message = v2TIMMessage.getMessage();
            if (!TextUtils.isEmpty(str2)) {
                message.setMessageType(Message.MESSAGE_TYPE_GROUP);
                message.setGroupID(str2);
                List<String> targetGroupMemberList = message.getTargetGroupMemberList();
                if (!TextUtils.isEmpty(str) && (targetGroupMemberList == null || message.getTargetGroupMemberList().isEmpty())) {
                    List<String> groupAtUserList = v2TIMMessage.getGroupAtUserList();
                    if (groupAtUserList == null || groupAtUserList.isEmpty()) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(str);
                        message.setTargetGroupMemberList(arrayList);
                    } else {
                        if (v2TIMSendCallback != null) {
                            v2TIMSendCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "targeted group message does not support group @ message");
                        }
                        return null;
                    }
                }
            } else {
                message.setMessageType(Message.MESSAGE_TYPE_C2C);
                message.setReceiverUserID(str);
            }
            message.setPriority(i11);
            if (z11) {
                message.setLifeTime(0);
            }
            if (v2TIMOfflinePushInfo != null) {
                message.setOfflinePushInfo(v2TIMOfflinePushInfo.getMessageOfflinePushInfo());
            }
            message.setPlatform(Message.PLATFORM_ANDROID);
            String sendMessage = MessageCenter.getInstance().sendMessage(message, new MessageUploadProgressCallback() {
                public void onUploadProgress(int i11, final int i12, final int i13) {
                    IMContext.getInstance().runOnMainThread(new Runnable() {
                        public void run() {
                            V2TIMSendCallback v2TIMSendCallback = v2TIMSendCallback;
                            if (v2TIMSendCallback != null) {
                                int i11 = 0;
                                int i12 = i13;
                                if (i12 > 0) {
                                    i11 = (int) ((((float) i12) / ((float) i12)) * 100.0f);
                                }
                                v2TIMSendCallback.onProgress(i11);
                            }
                        }
                    });
                }
            }, new IMCallback(new V2TIMValueCallback<Message>() {
                public void onError(int i11, String str) {
                    V2TIMSendCallback v2TIMSendCallback = v2TIMSendCallback;
                    if (v2TIMSendCallback != null) {
                        v2TIMSendCallback.onError(i11, str);
                    }
                }

                public void onSuccess(Message message) {
                    if (v2TIMSendCallback != null) {
                        v2TIMMessage.setMessage(message);
                        v2TIMSendCallback.onSuccess(v2TIMMessage);
                    }
                }
            }) {
                public void fail(int i11, String str, Object obj) {
                    v2TIMMessage.getMessage().update((Message) obj);
                    super.fail(i11, str, obj);
                }

                public void success(Object obj) {
                    v2TIMMessage.getMessage().update((Message) obj);
                    super.success(obj);
                }
            });
            BaseManager.getInstance().checkTUIComponent(3);
            return sendMessage;
        } else {
            if (v2TIMSendCallback != null) {
                v2TIMSendCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "receiver and groupID cannot be empty at the same time!");
            }
            return null;
        }
    }

    public void sendMessageReadReceipts(List<V2TIMMessage> list, final V2TIMCallback v2TIMCallback) {
        if (list != null && list.size() != 0) {
            final ArrayList<V2TIMMessage> arrayList = new ArrayList<>();
            arrayList.addAll(list);
            ArrayList arrayList2 = new ArrayList();
            for (V2TIMMessage v2TIMMessage : arrayList) {
                if (!(v2TIMMessage == null || true == v2TIMMessage.isSelf() || !v2TIMMessage.isNeedReadReceipt())) {
                    Message message = v2TIMMessage.getMessage();
                    if (!message.isHasSentReceipt()) {
                        arrayList2.add(message.getMessageKey());
                    }
                }
            }
            if (arrayList2.size() != 0) {
                MessageCenter.getInstance().sendMessageReceipts(arrayList2, new IMCallback(new V2TIMCallback() {
                    public void onError(int i11, String str) {
                        V2TIMCallback v2TIMCallback = v2TIMCallback;
                        if (v2TIMCallback != null) {
                            v2TIMCallback.onError(i11, str);
                        }
                    }

                    public void onSuccess() {
                        V2TIMCallback v2TIMCallback = v2TIMCallback;
                        if (v2TIMCallback != null) {
                            v2TIMCallback.onSuccess();
                        }
                    }
                }) {
                    public void fail(int i11, String str) {
                        super.fail(i11, str);
                    }

                    public void success(Object obj) {
                        for (V2TIMMessage message : arrayList) {
                            message.getMessage().setHasSentReceipt(true);
                        }
                        super.success(obj);
                    }
                });
            } else if (v2TIMCallback != null) {
                v2TIMCallback.onSuccess();
            }
        } else if (v2TIMCallback != null) {
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid messageList");
        }
    }

    public void setC2CReceiveMessageOpt(List<String> list, int i11, V2TIMCallback v2TIMCallback) {
        if (list != null && list.size() != 0) {
            int i12 = 2;
            if (i11 == 0) {
                i12 = 1;
            } else if (i11 != 1) {
                if (i11 == 2) {
                    i12 = 3;
                } else {
                    IMLog.e("V2TIMMessageManagerImpl", "setC2CReceiveMessageOpt error opt = " + i11);
                    if (v2TIMCallback != null) {
                        v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "opt is error");
                        return;
                    }
                    return;
                }
            }
            RelationshipManager.getInstance().setC2CReceiveMessageOpt(list, i12, new IMCallback(v2TIMCallback) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else if (v2TIMCallback != null) {
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid userIDList");
        }
    }

    public void setGroupReceiveMessageOpt(String str, int i11, V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            IMLog.e("V2TIMMessageManagerImpl", "setReceiveMessageOpt err, groupID is empty");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID is empty");
                return;
            }
            return;
        }
        int i12 = GroupMemberInfo.MESSAGE_RECEIVE_OPTION_AUTO_RECEIVE;
        if (i11 != 0) {
            if (i11 == 1) {
                i12 = GroupMemberInfo.MESSAGE_RECEIVE_OPTION_NOT_RECEIVE;
            } else if (i11 == 2) {
                i12 = GroupMemberInfo.MESSAGE_RECEIVE_OPTION_RECEIVE_WITH_NO_OFFLINE_PUSH;
            } else {
                IMLog.e("V2TIMMessageManagerImpl", "setReceiveMessageOpt error opt = " + i11);
                if (v2TIMCallback != null) {
                    v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "opt is error");
                    return;
                }
                return;
            }
        }
        GroupManager.getInstance().setGroupReceiveMessageOpt(str, i12, new IMCallback(v2TIMCallback) {
            public void fail(int i11, String str) {
                super.fail(i11, str);
            }

            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    public void setMessageExtensions(V2TIMMessage v2TIMMessage, List<V2TIMMessageExtension> list, final V2TIMValueCallback<List<V2TIMMessageExtensionResult>> v2TIMValueCallback) {
        if (v2TIMMessage == null) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid message");
            }
        } else if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (V2TIMMessageExtension next : list) {
                if (!TextUtils.isEmpty(next.getExtensionKey())) {
                    MessageExtension messageExtension = new MessageExtension();
                    messageExtension.setExtensionKey(next.getExtensionKey());
                    messageExtension.setExtensionValue(next.getExtensionValue());
                    arrayList.add(messageExtension);
                } else if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "empty extensionKey");
                    return;
                } else {
                    return;
                }
            }
            MessageCenter.getInstance().setMessageExtensions(v2TIMMessage.getMessage(), arrayList, new IMCallback<List<MessageExtensionResult>>(new V2TIMValueCallback<List<MessageExtensionResult>>() {
                public void onError(int i11, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i11, str);
                    }
                }

                public void onSuccess(List<MessageExtensionResult> list) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (MessageExtensionResult messageExtensionResult : list) {
                            V2TIMMessageExtensionResult v2TIMMessageExtensionResult = new V2TIMMessageExtensionResult();
                            v2TIMMessageExtensionResult.setMessageExtensionResult(messageExtensionResult);
                            arrayList.add(v2TIMMessageExtensionResult);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(List<MessageExtensionResult> list) {
                    super.success(list);
                }
            });
            BaseManager.getInstance().checkTUIComponent(9);
            BaseManager.getInstance().checkTUIComponent(10);
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "extensions cannot be null");
        }
    }

    public void translateText(List<String> list, String str, String str2, V2TIMValueCallback<HashMap<String, String>> v2TIMValueCallback) {
        if (list == null || list.isEmpty()) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "sourceTextList is empty");
            }
        } else if (!TextUtils.isEmpty(str2)) {
            MessageCenter.getInstance().translateText(list, str, str2, new IMCallback(v2TIMValueCallback) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "targetLanguage is empty");
        }
    }

    private V2TIMMessageManagerImpl() {
        this.TAG = "V2TIMMessageManagerImpl";
        this.MAX_FORWARD_COUNT = 300;
        this.MAX_ABSTRACT_COUNT = 5;
        this.MAX_ABSTRACT_LENGTH = 100;
        this.mLockObject = new Object();
        this.mV2TIMMsgListenerList = new CopyOnWriteArrayList();
    }

    public V2TIMMessage createCustomMessage(byte[] bArr, String str, byte[] bArr2) {
        if (bArr == null || bArr.length == 0) {
            IMLog.e("V2TIMMessageManagerImpl", "data cannot be empty");
            return null;
        }
        V2TIMMessage v2TIMMessage = new V2TIMMessage();
        Message message = v2TIMMessage.getMessage();
        CustomElement customElement = new CustomElement();
        customElement.setData(bArr);
        customElement.setDescription(str);
        customElement.setExtension(bArr2);
        message.addElement(customElement);
        return v2TIMMessage;
    }
}
