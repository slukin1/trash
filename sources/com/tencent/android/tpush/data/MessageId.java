package com.tencent.android.tpush.data;

import java.io.Serializable;

public class MessageId implements Serializable {
    public static final short FLAG_ACK = 1;
    public static final short FLAG_UNACK = 0;
    private static final long serialVersionUID = 8708157897391765794L;
    public long accessId;
    public byte apn;
    public long busiMsgId = 0;
    public long channelId = -1;
    public String date = "";
    public String groupId = "";
    public long host;

    /* renamed from: id  reason: collision with root package name */
    public long f69316id;
    public short isAck;
    public byte isp;
    public long msgType = -1;
    public long multiPkg = 0;
    public String nGroupId = "";
    public byte pact;
    public String pkgName;
    public int port;
    public int pushChannel;
    public long pushTime;
    public long receivedTime;
    public int revokeId = 0;
    public long serverTime;
    public String serviceHost;
    public String statTag = "";
    public long timestamp = 0;
    public long ttl;

    public boolean isMsgAcked() {
        return this.isAck == 1;
    }

    public String toString() {
        return "MessageId [id=" + this.f69316id + ", isAck=" + this.isAck + ", isp=" + this.isp + ", apn=" + this.apn + ", accessId=" + this.accessId + ", receivedTime=" + this.receivedTime + ", pact=" + this.pact + ", host=" + this.host + ", port=" + this.port + ", serviceHost=" + this.serviceHost + ", pkgName=" + this.pkgName + ", busiMsgId=" + this.busiMsgId + ", timestamp=" + this.timestamp + ", msgType=" + this.msgType + ", multiPkg=" + this.multiPkg + ", date=" + this.date + ", serverTime=" + this.serverTime + ", ttl=" + this.ttl + "]" + ", revokeId=" + this.revokeId;
    }
}
