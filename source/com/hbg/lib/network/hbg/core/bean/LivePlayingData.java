package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LivePlayingData extends LiveSquareBaseData {
    private int appointed;
    private int appointedNum;
    private String coverImageUrl;
    private long currentTime;
    private LiveStream downStreamAddr;
    private long finishTime;
    private String groupChatInteractive;
    private String groupChatLive;

    /* renamed from: id  reason: collision with root package name */
    private int f70253id;
    private String introduction;
    private ArrayList<FloatMsg> msgList;
    private int needShare;
    private int onlineNum;
    private List<LiveHotTalkItemData> speakerList;
    private long startTime;
    private int status;
    private String title;
    private int type;

    public static class FloatMsg implements Serializable {
        public String avatar;
        public String fromAccount;
        public int msgSeq;
        public String msgType;
        public String nickname;
        public String text;
    }

    public int getAppointed() {
        return this.appointed;
    }

    public int getAppointedNum() {
        return this.appointedNum;
    }

    public String getCoverImageUrl() {
        return this.coverImageUrl;
    }

    public long getCurrentTime() {
        return this.currentTime;
    }

    public LiveStream getDownStreamAddr() {
        return this.downStreamAddr;
    }

    public long getFinishTime() {
        return this.finishTime;
    }

    public String getGroupChatInteractive() {
        return this.groupChatInteractive;
    }

    public String getGroupChatLive() {
        return this.groupChatLive;
    }

    public int getId() {
        return this.f70253id;
    }

    public String getIntroduction() {
        return this.introduction;
    }

    public ArrayList<FloatMsg> getMsgList() {
        return this.msgList;
    }

    public int getNeedShare() {
        return this.needShare;
    }

    public int getOnlineNum() {
        return this.onlineNum;
    }

    public List<LiveHotTalkItemData> getSpeakerList() {
        return this.speakerList;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public int getStatus() {
        return this.status;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public void setAppointed(int i11) {
        this.appointed = i11;
    }

    public void setAppointedNum(int i11) {
        this.appointedNum = i11;
    }

    public void setCoverImageUrl(String str) {
        this.coverImageUrl = str;
    }

    public void setCurrentTime(long j11) {
        this.currentTime = j11;
    }

    public void setDownStreamAddr(LiveStream liveStream) {
        this.downStreamAddr = liveStream;
    }

    public void setFinishTime(long j11) {
        this.finishTime = j11;
    }

    public void setGroupChatInteractive(String str) {
        this.groupChatInteractive = str;
    }

    public void setGroupChatLive(String str) {
        this.groupChatLive = str;
    }

    public void setId(int i11) {
        this.f70253id = i11;
    }

    public void setIntroduction(String str) {
        this.introduction = str;
    }

    public void setMsgList(ArrayList<FloatMsg> arrayList) {
        this.msgList = arrayList;
    }

    public void setNeedShare(int i11) {
        this.needShare = i11;
    }

    public void setOnlineNum(int i11) {
        this.onlineNum = i11;
    }

    public void setSpeakerList(List<LiveHotTalkItemData> list) {
        this.speakerList = list;
    }

    public void setStartTime(long j11) {
        this.startTime = j11;
    }

    public void setStatus(int i11) {
        this.status = i11;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setType(int i11) {
        this.type = i11;
    }
}
