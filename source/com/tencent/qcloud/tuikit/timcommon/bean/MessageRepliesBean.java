package com.tencent.qcloud.tuikit.timcommon.bean;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MessageRepliesBean implements Serializable {
    public static final int VERSION = 1;
    private List<ReplyBean> replies;
    private int version = 1;

    public static class ReplyBean implements Serializable {
        /* access modifiers changed from: private */
        public String messageAbstract;
        /* access modifiers changed from: private */
        public String messageID;
        /* access modifiers changed from: private */
        public String messageSender;
        private transient String senderFaceUrl;
        private transient String senderShowName;

        public String getMessageAbstract() {
            return this.messageAbstract;
        }

        public String getMessageID() {
            return this.messageID;
        }

        public String getMessageSender() {
            return this.messageSender;
        }

        public String getSenderFaceUrl() {
            return this.senderFaceUrl;
        }

        public String getSenderShowName() {
            if (TextUtils.isEmpty(this.senderShowName)) {
                return this.messageSender;
            }
            return this.senderShowName;
        }

        public void setMessageAbstract(String str) {
            this.messageAbstract = str;
        }

        public void setMessageID(String str) {
            this.messageID = str;
        }

        public void setMessageSender(String str) {
            this.messageSender = str;
        }

        public void setSenderFaceUrl(String str) {
            this.senderFaceUrl = str;
        }

        public void setSenderShowName(String str) {
            this.senderShowName = str;
        }
    }

    public void addReplyMessage(String str, String str2, String str3) {
        if (this.replies == null) {
            this.replies = new ArrayList();
        }
        for (ReplyBean access$000 : this.replies) {
            if (TextUtils.equals(access$000.messageID, str)) {
                return;
            }
        }
        ReplyBean replyBean = new ReplyBean();
        String unused = replyBean.messageID = str;
        String unused2 = replyBean.messageAbstract = str2;
        String unused3 = replyBean.messageSender = str3;
        this.replies.add(replyBean);
    }

    public List<ReplyBean> getReplies() {
        return this.replies;
    }

    public int getRepliesSize() {
        List<ReplyBean> list = this.replies;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public int getVersion() {
        return this.version;
    }

    public void removeReplyMessage(String str) {
        List<ReplyBean> list = this.replies;
        if (list != null) {
            for (ReplyBean next : list) {
                if (TextUtils.equals(next.messageID, str)) {
                    this.replies.remove(next);
                    return;
                }
            }
        }
    }

    public void setReplies(List<ReplyBean> list) {
        this.replies = list;
    }

    public void setVersion(int i11) {
        this.version = i11;
    }
}
