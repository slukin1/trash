package com.tencent.imsdk.message;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class Message implements Serializable {
    public static int MESSAGE_TYPE_C2C = 1;
    public static int MESSAGE_TYPE_GROUP = 2;
    public static int MESSAGE_TYPE_MULTI_SYNC = 3;
    public static int MESSAGE_TYPE_UNKNOWN = 0;
    public static int PLATFORM_ANDROID = 2;
    public static int PLATFORM_IOS = 3;
    public static int PLATFORM_MAC = 4;
    public static int PLATFORM_OTHER = 0;
    public static int PLATFORM_SIMULATOR = 5;
    public static int PLATFORM_WINDOWS = 1;
    public static final int V2TIM_MSG_STATUS_DELETED = 4;
    public static final int V2TIM_MSG_STATUS_LOCAL_IMPORTED = 5;
    public static final int V2TIM_MSG_STATUS_REVOKED = 6;
    public static final int V2TIM_MSG_STATUS_SENDING = 1;
    public static final int V2TIM_MSG_STATUS_SEND_FAILED = 3;
    public static final int V2TIM_MSG_STATUS_SUCCESS = 2;
    private long clientTime;
    private byte[] cloudCustomBytes;
    private boolean excludedFromContentModeration = false;
    private boolean excludedFromLastMessage = false;
    private boolean excludedFromUnreadCount = false;
    private String faceUrl;
    private String friendRemark;
    private String groupID;
    private boolean hasSentReceipt = false;
    private boolean isBroadcastMessage = false;
    private boolean isForward;
    private boolean isMessageSender = true;
    private boolean isPeerRead;
    private boolean isSelfRead;
    private int lifeTime = -1;
    private int localCustomNumber;
    private String localCustomString;
    private List<MessageBaseElement> messageBaseElements = new ArrayList();
    private List<MessageAtInfo> messageGroupAtInfoList = new ArrayList();
    private int messageStatus;
    private int messageType;
    private long messageVersion;
    private String msgID = "";
    private String nameCard;
    private boolean needReadReceipt = false;
    private String nickName;
    private MessageOfflinePushInfo offlinePushInfo;
    private int platform;
    private int priority;
    private long random;
    private boolean receiptPeerRead;
    private int receiptReadCount = 0;
    private int receiptUnreadCount = -1;
    private long receiverTinyID;
    private String receiverUserID;
    private long revokerTinyID;
    private String revokerUserID;
    private long senderTinyID;
    private String senderUserID;
    private long seq;
    private long serverTime;
    private boolean supportMessageExtension = false;
    private List<String> targetGroupMemberList = new ArrayList();

    public void addElement(MessageBaseElement messageBaseElement) {
        if (messageBaseElement != null) {
            this.messageBaseElements.add(messageBaseElement);
        }
    }

    public void addMessageGroupAtInfo(MessageAtInfo messageAtInfo) {
        this.messageGroupAtInfoList.add(messageAtInfo);
    }

    public long getClientTime() {
        return this.clientTime;
    }

    public String getCloudCustomString() {
        byte[] bArr = this.cloudCustomBytes;
        if (bArr != null && bArr.length > 0) {
            try {
                return new String(bArr, "UTF-8");
            } catch (UnsupportedEncodingException e11) {
                e11.printStackTrace();
            }
        }
        return "";
    }

    public String getFaceUrl() {
        return this.faceUrl;
    }

    public String getFriendRemark() {
        return this.friendRemark;
    }

    public String getGroupID() {
        return this.groupID;
    }

    public int getLifeTime() {
        return this.lifeTime;
    }

    public int getLocalCustomNumber() {
        return this.localCustomNumber;
    }

    public String getLocalCustomString() {
        return this.localCustomString;
    }

    public List<MessageBaseElement> getMessageBaseElements() {
        return this.messageBaseElements;
    }

    public List<MessageAtInfo> getMessageGroupAtInfoList() {
        return this.messageGroupAtInfoList;
    }

    public MessageKey getMessageKey() {
        MessageKey messageKey = new MessageKey();
        messageKey.setMessageID(this.msgID);
        messageKey.setMessageType(this.messageType);
        messageKey.setIsMessageSender(this.isMessageSender);
        messageKey.setSenderUserID(this.senderUserID);
        messageKey.setSenderTinyID(this.senderTinyID);
        messageKey.setReceiverUserID(this.receiverUserID);
        messageKey.setReceiverTinyID(this.receiverTinyID);
        messageKey.setGroupID(this.groupID);
        messageKey.setClientTime(this.clientTime);
        messageKey.setServerTime(this.serverTime);
        messageKey.setSeq(this.seq);
        messageKey.setRandom(this.random);
        return messageKey;
    }

    public int getMessageStatus() {
        return this.messageStatus;
    }

    public int getMessageType() {
        return this.messageType;
    }

    public String getMsgID() {
        return this.msgID;
    }

    public String getNameCard() {
        return this.nameCard;
    }

    public String getNickName() {
        return this.nickName;
    }

    public MessageOfflinePushInfo getOfflinePushInfo() {
        return this.offlinePushInfo;
    }

    public int getPlatform() {
        return this.platform;
    }

    public int getPriority() {
        return this.priority;
    }

    public long getRandom() {
        return this.random;
    }

    public int getReceiptReadCount() {
        return this.receiptReadCount;
    }

    public int getReceiptUnreadCount() {
        return this.receiptUnreadCount;
    }

    public String getReceiverUserID() {
        return this.receiverUserID;
    }

    public String getRevokerUserID() {
        return this.revokerUserID;
    }

    public String getSenderUserID() {
        return this.senderUserID;
    }

    public long getSeq() {
        return this.seq;
    }

    public List<String> getTargetGroupMemberList() {
        return this.targetGroupMemberList;
    }

    public long getTimestamp() {
        long j11 = this.serverTime;
        if (j11 > 0) {
            return j11;
        }
        return this.clientTime;
    }

    public boolean isBroadcastMessage() {
        return this.isBroadcastMessage;
    }

    public boolean isExcludedFromContentModeration() {
        return this.excludedFromContentModeration;
    }

    public boolean isExcludedFromLastMessage() {
        return this.excludedFromLastMessage;
    }

    public boolean isExcludedFromUnreadCount() {
        return this.excludedFromUnreadCount;
    }

    public boolean isForward() {
        return this.isForward;
    }

    public boolean isHasSentReceipt() {
        return this.hasSentReceipt;
    }

    public boolean isMessageSender() {
        return this.isMessageSender;
    }

    public boolean isNeedReadReceipt() {
        return this.needReadReceipt;
    }

    public boolean isPeerRead() {
        if (this.isPeerRead) {
            return true;
        }
        boolean isMessagePeerRead = MessageCenter.getInstance().isMessagePeerRead(getMessageKey());
        this.isPeerRead = isMessagePeerRead;
        return isMessagePeerRead;
    }

    public boolean isReceiptPeerRead() {
        return this.receiptPeerRead;
    }

    public boolean isSelfRead() {
        if (this.isSelfRead) {
            return true;
        }
        boolean isMessageSelfRead = MessageCenter.getInstance().isMessageSelfRead(getMessageKey());
        this.isSelfRead = isMessageSelfRead;
        return isMessageSelfRead;
    }

    public boolean isSupportMessageExtension() {
        return this.supportMessageExtension;
    }

    public void setClientTime(long j11) {
        this.clientTime = j11;
    }

    public void setCloudCustomString(String str) {
        if (str == null) {
            str = "";
        }
        try {
            this.cloudCustomBytes = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e11) {
            e11.printStackTrace();
        }
    }

    public void setExcludedFromContentModeration(boolean z11) {
        this.excludedFromContentModeration = z11;
    }

    public void setExcludedFromLastMessage(boolean z11) {
        this.excludedFromLastMessage = z11;
    }

    public void setExcludedFromUnreadCount(boolean z11) {
        this.excludedFromUnreadCount = z11;
    }

    public void setForward(boolean z11) {
        this.isForward = z11;
    }

    public void setGroupID(String str) {
        this.groupID = str;
    }

    public void setHasSentReceipt(boolean z11) {
        this.hasSentReceipt = z11;
    }

    public void setIsMessageSender(boolean z11) {
        this.isMessageSender = z11;
    }

    public void setLifeTime(int i11) {
        this.lifeTime = i11;
    }

    public void setLocalCustomNumber(int i11) {
        this.localCustomNumber = i11;
        MessageCenter.getInstance().setLocalCustomNumber(this, i11);
    }

    public void setLocalCustomString(String str) {
        this.localCustomString = str;
        MessageCenter.getInstance().setLocalCustomString(this, str);
    }

    public void setMessageBaseElements(List<MessageBaseElement> list) {
        this.messageBaseElements = list;
    }

    public void setMessageGroupAtInfoList(List<MessageAtInfo> list) {
        this.messageGroupAtInfoList = list;
    }

    public void setMessageStatus(int i11) {
        this.messageStatus = i11;
    }

    public void setMessageType(int i11) {
        this.messageType = i11;
    }

    public void setNeedReadReceipt(boolean z11) {
        this.needReadReceipt = z11;
    }

    public void setOfflinePushInfo(MessageOfflinePushInfo messageOfflinePushInfo) {
        this.offlinePushInfo = messageOfflinePushInfo;
    }

    public void setPlatform(int i11) {
        this.platform = i11;
    }

    public void setPriority(int i11) {
        this.priority = i11;
    }

    public void setReceiptReadCount(int i11) {
        this.receiptReadCount = i11;
    }

    public void setReceiptUnreadCount(int i11) {
        this.receiptUnreadCount = i11;
    }

    public void setReceiverUserID(String str) {
        this.receiverUserID = str;
    }

    public void setSenderUserID(String str) {
        this.senderUserID = str;
    }

    public void setSeq(long j11) {
        this.seq = j11;
    }

    public void setSupportMessageExtension(boolean z11) {
        this.supportMessageExtension = z11;
    }

    public void setTargetGroupMemberList(List<String> list) {
        this.targetGroupMemberList = list;
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x004c A[LOOP:1: B:4:0x004c->B:7:0x005c, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void update(com.tencent.imsdk.message.Message r5) {
        /*
            r4 = this;
            java.lang.String r0 = r5.msgID
            r4.msgID = r0
            int r0 = r5.messageType
            r4.messageType = r0
            boolean r0 = r5.isMessageSender
            r4.isMessageSender = r0
            java.lang.String r0 = r5.senderUserID
            r4.senderUserID = r0
            long r0 = r5.senderTinyID
            r4.senderTinyID = r0
            java.lang.String r0 = r5.receiverUserID
            r4.receiverUserID = r0
            long r0 = r5.receiverTinyID
            r4.receiverTinyID = r0
            java.lang.String r0 = r5.groupID
            r4.groupID = r0
            long r0 = r5.clientTime
            r4.clientTime = r0
            long r0 = r5.serverTime
            r4.serverTime = r0
            long r0 = r5.seq
            r4.seq = r0
            long r0 = r5.random
            r4.random = r0
            int r0 = r5.messageStatus
            r4.messageStatus = r0
            java.util.List<com.tencent.imsdk.message.MessageBaseElement> r0 = r4.messageBaseElements
            java.util.Iterator r0 = r0.iterator()
        L_0x003a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x005f
            java.lang.Object r1 = r0.next()
            com.tencent.imsdk.message.MessageBaseElement r1 = (com.tencent.imsdk.message.MessageBaseElement) r1
            java.util.List<com.tencent.imsdk.message.MessageBaseElement> r2 = r5.messageBaseElements
            java.util.Iterator r2 = r2.iterator()
        L_0x004c:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x003a
            java.lang.Object r3 = r2.next()
            com.tencent.imsdk.message.MessageBaseElement r3 = (com.tencent.imsdk.message.MessageBaseElement) r3
            boolean r3 = r1.update(r3)
            if (r3 == 0) goto L_0x004c
            goto L_0x003a
        L_0x005f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.imsdk.message.Message.update(com.tencent.imsdk.message.Message):void");
    }
}
