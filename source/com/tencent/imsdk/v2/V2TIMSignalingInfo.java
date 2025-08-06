package com.tencent.imsdk.v2;

import com.tencent.imsdk.signaling.SignalingInfo;
import java.io.Serializable;
import java.util.List;

public class V2TIMSignalingInfo implements Serializable {
    public static final int SIGNALING_ACTION_TYPE_ACCEPT_INVITE = 3;
    public static final int SIGNALING_ACTION_TYPE_CANCEL_INVITE = 2;
    public static final int SIGNALING_ACTION_TYPE_INVITE = 1;
    public static final int SIGNALING_ACTION_TYPE_INVITE_TIMEOUT = 5;
    public static final int SIGNALING_ACTION_TYPE_REJECT_INVITE = 4;
    public static final int SIGNALING_ACTION_TYPE_UNKNOWN = 0;
    private SignalingInfo signalingInfo = new SignalingInfo();

    public int getActionType() {
        return this.signalingInfo.getActionType();
    }

    public String getData() {
        return this.signalingInfo.getData();
    }

    public String getGroupID() {
        return this.signalingInfo.getGroupID();
    }

    public String getInviteID() {
        return this.signalingInfo.getInviteID();
    }

    public List<String> getInviteeList() {
        return this.signalingInfo.getInviteeList();
    }

    public String getInviter() {
        return this.signalingInfo.getInviter();
    }

    public SignalingInfo getSignalingInfo() {
        return this.signalingInfo;
    }

    public int getTimeout() {
        return this.signalingInfo.getTimeout();
    }

    public void setActionType(int i11) {
        this.signalingInfo.setActionType(i11);
    }

    public void setData(String str) {
        this.signalingInfo.setData(str);
    }

    public void setGroupID(String str) {
        this.signalingInfo.setGroupID(str);
    }

    public void setInviteID(String str) {
        this.signalingInfo.setInviteID(str);
    }

    public void setInviteeList(List<String> list) {
        this.signalingInfo.setInviteeList(list);
    }

    public void setInviter(String str) {
        this.signalingInfo.setInviter(str);
    }

    public void setSignalingInfo(SignalingInfo signalingInfo2) {
        if (signalingInfo2 != null) {
            this.signalingInfo = signalingInfo2;
        }
    }

    public void setTimeout(int i11) {
        this.signalingInfo.setTimeout(i11);
    }
}
