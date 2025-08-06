package com.huobi.otc.bean;

import com.huobi.otc.bean.OtcChatContentList;
import com.huobi.otc.handler.OtcChatContentHandler;
import java.util.Objects;
import s9.a;

public class OtcChatContent implements a {
    private long firstSendTime;
    private boolean isCurrentUser;
    private boolean isEnoughInterval;
    private boolean isLocal;
    private ChatType localChatContentType;
    private String localFileName;
    private String localFilePath;
    private String localInput;
    private String localStatusTip;
    private OtcChatContentList.OtcChatDetailContent otcChatContent;
    private OtcOrderDetailInfo otcDetailData;
    private int progress;
    private ChatImageSendSendStatus sendStatus;
    private String uri;

    public enum ChatImageSendSendStatus {
        Sending("Sending"),
        SendFail("SendFail"),
        SendSuccess("SendSuccess");
        
        public final String value;

        private ChatImageSendSendStatus(String str) {
            this.value = str;
        }
    }

    public enum ChatType {
        Text("Text"),
        Image("Image"),
        Video("Video"),
        Pdf("Pdf");
        
        public final String value;

        private ChatType(String str) {
            this.value = str;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        OtcChatContent otcChatContent2 = (OtcChatContent) obj;
        if (!this.isLocal || !otcChatContent2.isLocal) {
            OtcChatContentList.OtcChatDetailContent otcChatContent3 = getOtcChatContent();
            OtcChatContentList.OtcChatDetailContent otcChatContent4 = otcChatContent2.getOtcChatContent();
            if (otcChatContent3 == null || otcChatContent4 == null || otcChatContent3.getId() != otcChatContent4.getId()) {
                return false;
            }
            return true;
        } else if (this.firstSendTime == otcChatContent2.firstSendTime) {
            return true;
        } else {
            return false;
        }
    }

    public long getFirstSendTime() {
        return this.firstSendTime;
    }

    public ChatType getLocalChatContentType() {
        return this.localChatContentType;
    }

    public String getLocalFileName() {
        return this.localFileName;
    }

    public String getLocalFilePath() {
        return this.localFilePath;
    }

    public String getLocalInput() {
        return this.localInput;
    }

    public String getLocalStatusTip() {
        return this.localStatusTip;
    }

    public OtcChatContentList.OtcChatDetailContent getOtcChatContent() {
        return this.otcChatContent;
    }

    public OtcOrderDetailInfo getOtcDetailData() {
        return this.otcDetailData;
    }

    public int getProgress() {
        return this.progress;
    }

    public ChatImageSendSendStatus getSendStatus() {
        return this.sendStatus;
    }

    public String getUri() {
        return this.uri;
    }

    public String getViewHandlerName() {
        return OtcChatContentHandler.class.getName();
    }

    public int hashCode() {
        if (!this.isLocal) {
            return super.hashCode();
        }
        return Objects.hash(new Object[]{Long.valueOf(this.firstSendTime)});
    }

    public boolean isCurrentUser() {
        return this.isCurrentUser;
    }

    public boolean isEnoughInterval() {
        return this.isEnoughInterval;
    }

    public boolean isLocal() {
        return this.isLocal;
    }

    public void setCurrentUser(boolean z11) {
        this.isCurrentUser = z11;
    }

    public void setEnoughInterval(boolean z11) {
        this.isEnoughInterval = z11;
    }

    public void setFirstSendTime(long j11) {
        this.firstSendTime = j11;
    }

    public void setLocal(boolean z11) {
        this.isLocal = z11;
    }

    public void setLocalChatContentType(ChatType chatType) {
        this.localChatContentType = chatType;
    }

    public void setLocalFileName(String str) {
        this.localFileName = str;
    }

    public void setLocalFilePath(String str) {
        this.localFilePath = str;
    }

    public void setLocalInput(String str) {
        this.localInput = str;
    }

    public void setLocalStatusTip(String str) {
        this.localStatusTip = str;
    }

    public void setOtcChatContent(OtcChatContentList.OtcChatDetailContent otcChatDetailContent) {
        this.otcChatContent = otcChatDetailContent;
    }

    public void setOtcDetailData(OtcOrderDetailInfo otcOrderDetailInfo) {
        this.otcDetailData = otcOrderDetailInfo;
    }

    public void setProgress(int i11) {
        this.progress = i11;
    }

    public void setSendStatus(ChatImageSendSendStatus chatImageSendSendStatus) {
        this.sendStatus = chatImageSendSendStatus;
    }

    public void setUri(String str) {
        this.uri = str;
    }

    public String toString() {
        return "OtcChatContent(otcChatContent=" + getOtcChatContent() + ", localInput=" + getLocalInput() + ", uri=" + getUri() + ", isCurrentUser=" + isCurrentUser() + ", isLocal=" + isLocal() + ", localStatusTip=" + getLocalStatusTip() + ", isEnoughInterval=" + isEnoughInterval() + ", localFilePath=" + getLocalFilePath() + ", localFileName=" + getLocalFileName() + ", progress=" + getProgress() + ", sendStatus=" + getSendStatus() + ", otcDetailData=" + getOtcDetailData() + ", localChatContentType=" + getLocalChatContentType() + ", firstSendTime=" + getFirstSendTime() + ")";
    }
}
