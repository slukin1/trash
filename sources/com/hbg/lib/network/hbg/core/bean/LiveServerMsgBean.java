package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class LiveServerMsgBean implements Serializable {
    private String avatar;
    private String fromAccount;
    private MsgImg image;
    private int isSelf;
    private long msgSeq;
    private long msgTimestamp;
    private String msgType;
    private String nickname;
    private int second;
    private String text;
    private String url;

    public static class MsgImg implements Serializable {
        public int height;
        public int size;
        public int type;
        public String url;
        public int width;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getFromAccount() {
        return this.fromAccount;
    }

    public MsgImg getImage() {
        return this.image;
    }

    public int getIsSelf() {
        return this.isSelf;
    }

    public long getMsgSeq() {
        return this.msgSeq;
    }

    public long getMsgTimestamp() {
        return this.msgTimestamp;
    }

    public String getMsgType() {
        return this.msgType;
    }

    public String getNickname() {
        return this.nickname;
    }

    public int getSecond() {
        return this.second;
    }

    public String getText() {
        return this.text;
    }

    public String getUrl() {
        return this.url;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setFromAccount(String str) {
        this.fromAccount = str;
    }

    public void setImage(MsgImg msgImg) {
        this.image = msgImg;
    }

    public void setIsSelf(int i11) {
        this.isSelf = i11;
    }

    public void setMsgSeq(int i11) {
        this.msgSeq = (long) i11;
    }

    public void setMsgTimestamp(long j11) {
        this.msgTimestamp = j11;
    }

    public void setMsgType(String str) {
        this.msgType = str;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public void setSecond(int i11) {
        this.second = i11;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
