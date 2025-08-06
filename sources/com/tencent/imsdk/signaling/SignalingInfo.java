package com.tencent.imsdk.signaling;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SignalingInfo implements Serializable {
    private int actionType = 0;
    private String data;
    private String groupID;
    private String inviteID;
    private List<String> inviteeList = new ArrayList();
    private String inviter;
    private int timeout;

    public void addInvitee(String str) {
        this.inviteeList.add(str);
    }

    public int getActionType() {
        return this.actionType;
    }

    public String getData() {
        return this.data;
    }

    public String getGroupID() {
        return this.groupID;
    }

    public String getInviteID() {
        return this.inviteID;
    }

    public List<String> getInviteeList() {
        return this.inviteeList;
    }

    public String getInviter() {
        return this.inviter;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public void setActionType(int i11) {
        this.actionType = i11;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setGroupID(String str) {
        this.groupID = str;
    }

    public void setInviteID(String str) {
        this.inviteID = str;
    }

    public void setInviteeList(List<String> list) {
        this.inviteeList = list;
    }

    public void setInviter(String str) {
        this.inviter = str;
    }

    public void setTimeout(int i11) {
        this.timeout = i11;
    }
}
