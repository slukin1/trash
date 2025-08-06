package com.tencent.imsdk.message;

import java.io.Serializable;

public class MessageKey implements Serializable {
    private long clientTime;
    private String groupID;
    private boolean isMessageSender;
    private String messageID;
    private int messageType;
    private long random;
    private long receiverTinyID;
    private String receiverUserID;
    private long senderTinyID;
    private String senderUserID;
    private long seq;
    private long serverTime;

    public long getClientTime() {
        return this.clientTime;
    }

    public String getGroupID() {
        return this.groupID;
    }

    public String getMessageID() {
        return this.messageID;
    }

    public int getMessageType() {
        return this.messageType;
    }

    public long getRandom() {
        return this.random;
    }

    public long getReceiverTinyID() {
        return this.receiverTinyID;
    }

    public String getReceiverUserID() {
        return this.receiverUserID;
    }

    public long getSenderTinyID() {
        return this.senderTinyID;
    }

    public String getSenderUserID() {
        return this.senderUserID;
    }

    public long getSeq() {
        return this.seq;
    }

    public long getServerTime() {
        return this.serverTime;
    }

    public boolean isMessageSender() {
        return this.isMessageSender;
    }

    public void setClientTime(long j11) {
        this.clientTime = j11;
    }

    public void setGroupID(String str) {
        this.groupID = str;
    }

    public void setIsMessageSender(boolean z11) {
        this.isMessageSender = z11;
    }

    public void setMessageID(String str) {
        this.messageID = str;
    }

    public void setMessageType(int i11) {
        this.messageType = i11;
    }

    public void setRandom(long j11) {
        this.random = j11;
    }

    public void setReceiverTinyID(long j11) {
        this.receiverTinyID = j11;
    }

    public void setReceiverUserID(String str) {
        this.receiverUserID = str;
    }

    public void setSenderTinyID(long j11) {
        this.senderTinyID = j11;
    }

    public void setSenderUserID(String str) {
        this.senderUserID = str;
    }

    public void setSeq(long j11) {
        this.seq = j11;
    }

    public void setServerTime(long j11) {
        this.serverTime = j11;
    }

    public String toString() {
        return "MessageKey--->" + "messageID:" + this.messageID + ", messageType:" + this.messageType + ", isMessageSender:" + this.isMessageSender + ", senderUserID:" + this.senderUserID + ", receiverUserID:" + this.receiverUserID + ", groupID:" + this.groupID + ", clientTime:" + this.clientTime + ", serverTime:" + this.serverTime + ", seq:" + this.seq + ", random:" + this.random;
    }
}
