package com.hbg.lib.network.hbg.core.bean;

import java.util.List;

public class LiveHotTalkData extends LiveSquareBaseData {
    private List<LiveSpeaker> groupList;

    public List<LiveSpeaker> getGroupList() {
        return this.groupList;
    }

    public void setGroupList(List<LiveSpeaker> list) {
        this.groupList = list;
    }
}
