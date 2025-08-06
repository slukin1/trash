package com.huobi.otc.bean;

import com.huobi.otc.bean.OtcChatContent;
import java.io.Serializable;
import java.util.List;

public class OtcChatContentList implements Serializable {
    private List<OtcChatDetailContent> list;
    private long timestamp;

    public static class OtcChatDetailContent {
        private String chatContent;
        private OtcChatContent.ChatType chatContentType;
        private int chatType;
        private long gmtCreate;

        /* renamed from: id  reason: collision with root package name */
        private long f78265id;
        private long orderId;
        private int readState;
        private long receiveUid;
        private String sendUid;
        private String sendUserName;

        public boolean canEqual(Object obj) {
            return obj instanceof OtcChatDetailContent;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof OtcChatDetailContent)) {
                return false;
            }
            OtcChatDetailContent otcChatDetailContent = (OtcChatDetailContent) obj;
            if (!otcChatDetailContent.canEqual(this)) {
                return false;
            }
            String chatContent2 = getChatContent();
            String chatContent3 = otcChatDetailContent.getChatContent();
            if (chatContent2 != null ? !chatContent2.equals(chatContent3) : chatContent3 != null) {
                return false;
            }
            OtcChatContent.ChatType chatContentType2 = getChatContentType();
            OtcChatContent.ChatType chatContentType3 = otcChatDetailContent.getChatContentType();
            if (chatContentType2 != null ? !chatContentType2.equals(chatContentType3) : chatContentType3 != null) {
                return false;
            }
            if (getChatType() != otcChatDetailContent.getChatType() || getGmtCreate() != otcChatDetailContent.getGmtCreate() || getId() != otcChatDetailContent.getId() || getOrderId() != otcChatDetailContent.getOrderId() || getReceiveUid() != otcChatDetailContent.getReceiveUid() || getReadState() != otcChatDetailContent.getReadState()) {
                return false;
            }
            String sendUid2 = getSendUid();
            String sendUid3 = otcChatDetailContent.getSendUid();
            if (sendUid2 != null ? !sendUid2.equals(sendUid3) : sendUid3 != null) {
                return false;
            }
            String sendUserName2 = getSendUserName();
            String sendUserName3 = otcChatDetailContent.getSendUserName();
            return sendUserName2 != null ? sendUserName2.equals(sendUserName3) : sendUserName3 == null;
        }

        public String getChatContent() {
            return this.chatContent;
        }

        public OtcChatContent.ChatType getChatContentType() {
            return this.chatContentType;
        }

        public int getChatType() {
            return this.chatType;
        }

        public long getGmtCreate() {
            return this.gmtCreate;
        }

        public long getId() {
            return this.f78265id;
        }

        public long getOrderId() {
            return this.orderId;
        }

        public int getReadState() {
            return this.readState;
        }

        public long getReceiveUid() {
            return this.receiveUid;
        }

        public String getSendUid() {
            return this.sendUid;
        }

        public String getSendUserName() {
            return this.sendUserName;
        }

        public int hashCode() {
            String chatContent2 = getChatContent();
            int i11 = 43;
            int hashCode = chatContent2 == null ? 43 : chatContent2.hashCode();
            OtcChatContent.ChatType chatContentType2 = getChatContentType();
            int hashCode2 = ((((hashCode + 59) * 59) + (chatContentType2 == null ? 43 : chatContentType2.hashCode())) * 59) + getChatType();
            long gmtCreate2 = getGmtCreate();
            int i12 = (hashCode2 * 59) + ((int) (gmtCreate2 ^ (gmtCreate2 >>> 32)));
            long id2 = getId();
            int i13 = (i12 * 59) + ((int) (id2 ^ (id2 >>> 32)));
            long orderId2 = getOrderId();
            int i14 = (i13 * 59) + ((int) (orderId2 ^ (orderId2 >>> 32)));
            long receiveUid2 = getReceiveUid();
            int readState2 = (((i14 * 59) + ((int) (receiveUid2 ^ (receiveUid2 >>> 32)))) * 59) + getReadState();
            String sendUid2 = getSendUid();
            int hashCode3 = (readState2 * 59) + (sendUid2 == null ? 43 : sendUid2.hashCode());
            String sendUserName2 = getSendUserName();
            int i15 = hashCode3 * 59;
            if (sendUserName2 != null) {
                i11 = sendUserName2.hashCode();
            }
            return i15 + i11;
        }

        public void setChatContent(String str) {
            this.chatContent = str;
        }

        public void setChatContentType(OtcChatContent.ChatType chatType2) {
            this.chatContentType = chatType2;
        }

        public void setChatType(int i11) {
            this.chatType = i11;
        }

        public void setGmtCreate(long j11) {
            this.gmtCreate = j11;
        }

        public void setId(long j11) {
            this.f78265id = j11;
        }

        public void setOrderId(long j11) {
            this.orderId = j11;
        }

        public void setReadState(int i11) {
            this.readState = i11;
        }

        public void setReceiveUid(long j11) {
            this.receiveUid = j11;
        }

        public void setSendUid(String str) {
            this.sendUid = str;
        }

        public void setSendUserName(String str) {
            this.sendUserName = str;
        }

        public String toString() {
            return "OtcChatContentList.OtcChatDetailContent(chatContent=" + getChatContent() + ", chatContentType=" + getChatContentType() + ", chatType=" + getChatType() + ", gmtCreate=" + getGmtCreate() + ", id=" + getId() + ", orderId=" + getOrderId() + ", receiveUid=" + getReceiveUid() + ", readState=" + getReadState() + ", sendUid=" + getSendUid() + ", sendUserName=" + getSendUserName() + ")";
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof OtcChatContentList;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcChatContentList)) {
            return false;
        }
        OtcChatContentList otcChatContentList = (OtcChatContentList) obj;
        if (!otcChatContentList.canEqual(this)) {
            return false;
        }
        List<OtcChatDetailContent> list2 = getList();
        List<OtcChatDetailContent> list3 = otcChatContentList.getList();
        if (list2 != null ? list2.equals(list3) : list3 == null) {
            return getTimestamp() == otcChatContentList.getTimestamp();
        }
        return false;
    }

    public List<OtcChatDetailContent> getList() {
        return this.list;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        List<OtcChatDetailContent> list2 = getList();
        int hashCode = list2 == null ? 43 : list2.hashCode();
        long timestamp2 = getTimestamp();
        return ((hashCode + 59) * 59) + ((int) ((timestamp2 >>> 32) ^ timestamp2));
    }

    public void setList(List<OtcChatDetailContent> list2) {
        this.list = list2;
    }

    public void setTimestamp(long j11) {
        this.timestamp = j11;
    }

    public String toString() {
        return "OtcChatContentList(list=" + getList() + ", timestamp=" + getTimestamp() + ")";
    }
}
