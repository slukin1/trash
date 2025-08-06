package com.tencent.qcloud.tuikit.tuicallengine.signaling;

import java.util.List;

public class SignalingData {
    private String businessID;
    private int call_action;
    private int call_end;
    private int call_type;
    private DataInfo data;
    private String line_busy;
    private String platform;
    private int room_id;
    private String switch_to_audio_call;
    private String user;
    private String userData;
    private int version;

    public static class DataInfo {
        private String cmd;
        private String cmdInfo;
        private boolean consumed;
        private boolean excludeFromHistoryMessage;
        private List<String> inCallUserIDs;
        private String initialCallId;
        private long inviteTime;
        private String inviter;
        private String message;
        private int room_id;
        private String str_room_id;
        private List<String> userIDs;

        public String getCmd() {
            return this.cmd;
        }

        public String getCmdInfo() {
            return this.cmdInfo;
        }

        public boolean getConsumed() {
            return this.consumed;
        }

        public List<String> getInCallUserIDs() {
            return this.inCallUserIDs;
        }

        public String getInitialCallId() {
            return this.initialCallId;
        }

        public long getInviteTime() {
            return this.inviteTime;
        }

        public String getInviter() {
            return this.inviter;
        }

        public String getMessage() {
            return this.message;
        }

        public int getRoomID() {
            return this.room_id;
        }

        public String getStrRoomId() {
            return this.str_room_id;
        }

        public List<String> getUserIDs() {
            return this.userIDs;
        }

        public boolean isExcludeFromHistoryMessage() {
            return this.excludeFromHistoryMessage;
        }

        public void setCmd(String str) {
            this.cmd = str;
        }

        public void setCmdInfo(String str) {
            this.cmdInfo = str;
        }

        public void setConsumed(Boolean bool) {
            this.consumed = bool.booleanValue();
        }

        public void setExcludeFromHistoryMessage(boolean z11) {
            this.excludeFromHistoryMessage = z11;
        }

        public void setInCallUserIDs(List<String> list) {
            this.inCallUserIDs = list;
        }

        public void setInitialCallId(String str) {
            this.initialCallId = str;
        }

        public void setInviteTime(long j11) {
            this.inviteTime = j11;
        }

        public void setInviter(String str) {
            this.inviter = str;
        }

        public void setMessage(String str) {
            this.message = str;
        }

        public void setRoomID(int i11) {
            this.room_id = i11;
        }

        public void setStrRoomId(String str) {
            this.str_room_id = str;
        }

        public void setUserIDs(List<String> list) {
            this.userIDs = list;
        }

        public String toString() {
            return "DataInfo{room_id=" + this.room_id + ", str_room_id=" + this.str_room_id + ", cmd=" + this.cmd + ", cmdInfo=" + this.cmdInfo + ", message=" + this.message + ", userIDs=" + this.userIDs + ", inviteTime=" + this.inviteTime + ", inCallUserIDs=" + this.inCallUserIDs + ", consumed=" + this.consumed + ", inviter=" + this.inviter + ", excludeFromHistoryMessage=" + this.excludeFromHistoryMessage + ", initialCallId=" + this.initialCallId + '}';
        }
    }

    public String getBusinessID() {
        return this.businessID;
    }

    public int getCallAction() {
        return this.call_action;
    }

    public int getCallEnd() {
        return this.call_end;
    }

    public int getCallType() {
        return this.call_type;
    }

    public DataInfo getData() {
        return this.data;
    }

    public String getLineBusy() {
        return this.line_busy;
    }

    public String getPlatform() {
        return this.platform;
    }

    public int getRoomId() {
        return this.room_id;
    }

    public String getSwitchToAudioCall() {
        return this.switch_to_audio_call;
    }

    public String getUser() {
        return this.user;
    }

    public String getUserData() {
        return this.userData;
    }

    public int getVersion() {
        return this.version;
    }

    public void setBusinessID(String str) {
        this.businessID = str;
    }

    public void setCallAction(int i11) {
        this.call_action = i11;
    }

    public void setCallEnd(int i11) {
        this.call_end = i11;
    }

    public void setCallType(int i11) {
        this.call_type = i11;
    }

    public void setData(DataInfo dataInfo) {
        this.data = dataInfo;
    }

    public void setLineBusy(String str) {
        this.line_busy = str;
    }

    public void setPlatform(String str) {
        this.platform = str;
    }

    public void setRoomId(int i11) {
        this.room_id = i11;
    }

    public void setSwitchToAudioCall(String str) {
        this.switch_to_audio_call = str;
    }

    public void setUser(String str) {
        this.user = str;
    }

    public void setUserData(String str) {
        this.userData = str;
    }

    public void setVersion(int i11) {
        this.version = i11;
    }

    public String toString() {
        return "SignalingData{version=" + this.version + ", businessID=" + this.businessID + ", platform=" + this.platform + ", userData=" + this.userData + ", data=" + this.data + ", call_action=" + this.call_action + ", user=" + this.user + ", call_type=" + this.call_type + ", room_id=" + this.room_id + ", call_end=" + this.call_end + ", switch_to_audio_call=" + this.switch_to_audio_call + ", line_busy=" + this.line_busy + '}';
    }
}
