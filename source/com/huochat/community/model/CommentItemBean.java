package com.huochat.community.model;

import java.io.Serializable;
import kotlin.jvm.internal.x;

public class CommentItemBean implements Serializable {
    private int authType;
    private String content = "";
    private int crownType;
    private int flag;
    private String headImage = "";
    private String mcid = "";
    private String mid = "";
    private Long postTime = 0L;
    private String replyId = "";
    private String replyToUid = "";
    private String replyToUserName = "";
    private int replyType;
    private String uid = "";
    private String username = "";
    private int vFlag;
    private String vTag;
    private int vipFlag;

    public boolean equals(Object obj) {
        if (!(obj instanceof CommentItemBean)) {
            return false;
        }
        return x.b(((CommentItemBean) obj).mcid, this.mcid);
    }

    public final int getAuthType() {
        return this.authType;
    }

    public final String getContent() {
        return this.content;
    }

    public final int getCrownType() {
        return this.crownType;
    }

    public final int getFlag() {
        return this.flag;
    }

    public final String getHeadImage() {
        return this.headImage;
    }

    public final String getMcid() {
        return this.mcid;
    }

    public final String getMid() {
        return this.mid;
    }

    public final Long getPostTime() {
        return this.postTime;
    }

    public final String getReplyId() {
        return this.replyId;
    }

    public final String getReplyToUid() {
        return this.replyToUid;
    }

    public final String getReplyToUserName() {
        return this.replyToUserName;
    }

    public final int getReplyType() {
        return this.replyType;
    }

    public final String getUid() {
        return this.uid;
    }

    public final String getUsername() {
        return this.username;
    }

    public final int getVFlag() {
        return this.vFlag;
    }

    public final String getVTag() {
        return this.vTag;
    }

    public final int getVipFlag() {
        return this.vipFlag;
    }

    public int hashCode() {
        return String.valueOf(this.mcid).hashCode();
    }

    public final void setAuthType(int i11) {
        this.authType = i11;
    }

    public final void setContent(String str) {
        this.content = str;
    }

    public final void setCrownType(int i11) {
        this.crownType = i11;
    }

    public final void setFlag(int i11) {
        this.flag = i11;
    }

    public final void setHeadImage(String str) {
        this.headImage = str;
    }

    public final void setMcid(String str) {
        this.mcid = str;
    }

    public final void setMid(String str) {
        this.mid = str;
    }

    public final void setPostTime(Long l11) {
        this.postTime = l11;
    }

    public final void setReplyId(String str) {
        this.replyId = str;
    }

    public final void setReplyToUid(String str) {
        this.replyToUid = str;
    }

    public final void setReplyToUserName(String str) {
        this.replyToUserName = str;
    }

    public final void setReplyType(int i11) {
        this.replyType = i11;
    }

    public final void setUid(String str) {
        this.uid = str;
    }

    public final void setUsername(String str) {
        this.username = str;
    }

    public final void setVFlag(int i11) {
        this.vFlag = i11;
    }

    public final void setVTag(String str) {
        this.vTag = str;
    }

    public final void setVipFlag(int i11) {
        this.vipFlag = i11;
    }

    public String toString() {
        return "CommentItemBean(mcid=" + this.mcid + ", mid=" + this.mid + ", uid=" + this.uid + ", postTime=" + this.postTime + ", content=" + this.content + ", flag=" + this.flag + ", username=" + this.username + ", headImage=" + this.headImage + ", vFlag=" + this.vFlag + ", vTag=" + this.vTag + ", authType=" + this.authType + ", crownType=" + this.crownType + ", vipFlag=" + this.vipFlag + ", replyId=" + this.replyId + ", replyToUid=" + this.replyToUid + ", replyToUserName=" + this.replyToUserName + ", replyType=" + this.replyType + ')';
    }
}
