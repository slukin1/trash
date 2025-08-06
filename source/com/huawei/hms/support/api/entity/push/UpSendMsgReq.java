package com.huawei.hms.support.api.entity.push;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

public class UpSendMsgReq implements IMessageEntity {
    @Packed
    private String collapseKey;
    @Packed
    private String data;
    @Packed
    private String msgId;
    @Packed
    private String msgType;
    @Packed
    private String packageName;
    @Packed
    private int receiptMode;
    @Packed
    private int sendMode;
    @Packed

    /* renamed from: to  reason: collision with root package name */
    private String f38491to;
    @Packed
    private String token;
    @Packed
    private int ttl;

    public String getCollapseKey() {
        return this.collapseKey;
    }

    public String getData() {
        return this.data;
    }

    public String getMessageId() {
        return this.msgId;
    }

    public String getMessageType() {
        return this.msgType;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public int getReceiptMode() {
        return this.receiptMode;
    }

    public int getSendMode() {
        return this.sendMode;
    }

    public String getTo() {
        return this.f38491to;
    }

    public String getToken() {
        return this.token;
    }

    public int getTtl() {
        return this.ttl;
    }

    public void setCollapseKey(String str) {
        this.collapseKey = str;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setMessageId(String str) {
        this.msgId = str;
    }

    public void setMessageType(String str) {
        this.msgType = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setReceiptMode(int i11) {
        this.receiptMode = i11;
    }

    public void setSendMode(int i11) {
        this.sendMode = i11;
    }

    public void setTo(String str) {
        this.f38491to = str;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setTtl(int i11) {
        this.ttl = i11;
    }
}
