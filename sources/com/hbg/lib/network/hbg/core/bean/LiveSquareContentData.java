package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;
import java.util.List;

public class LiveSquareContentData implements Serializable {
    private List<LiveDetailBean> broadcast;
    private int broadcastTotal;
    private List<LiveDetailBean> endOfBroadcast;
    private int endOfBroadcastTotal;
    private List<LiveSpeaker> groupList;
    private List<LiveDetailBean> prepare;
    private int prepareTotal;

    public List<LiveDetailBean> getBroadcast() {
        return this.broadcast;
    }

    public int getBroadcastTotal() {
        return this.broadcastTotal;
    }

    public List<LiveDetailBean> getEndOfBroadcast() {
        return this.endOfBroadcast;
    }

    public int getEndOfBroadcastTotal() {
        return this.endOfBroadcastTotal;
    }

    public List<LiveSpeaker> getGroupList() {
        return this.groupList;
    }

    public List<LiveDetailBean> getPrepare() {
        return this.prepare;
    }

    public int getPrepareTotal() {
        return this.prepareTotal;
    }

    public void setBroadcast(List<LiveDetailBean> list) {
        this.broadcast = list;
    }

    public void setBroadcastTotal(int i11) {
        this.broadcastTotal = i11;
    }

    public void setEndOfBroadcast(List<LiveDetailBean> list) {
        this.endOfBroadcast = list;
    }

    public void setEndOfBroadcastTotal(int i11) {
        this.endOfBroadcastTotal = i11;
    }

    public void setGroupList(List<LiveSpeaker> list) {
        this.groupList = list;
    }

    public void setPrepare(List<LiveDetailBean> list) {
        this.prepare = list;
    }

    public void setPrepareTotal(int i11) {
        this.prepareTotal = i11;
    }
}
