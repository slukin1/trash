package com.tencent.qcloud.tuikit.tuicallkit.base;

import java.util.Objects;

public class CallingUserModel {
    public boolean isAudioAvailable;
    public boolean isEnter;
    public boolean isVideoAvailable;
    public String userAvatar;
    public String userId;
    public String userName;
    public int volume;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.userId, ((CallingUserModel) obj).userId);
    }

    public String toString() {
        return "CallingUserModel{userId='" + this.userId + ", userAvatar='" + this.userAvatar + ", userName='" + this.userName + ", isEnter=" + this.isEnter + ", isAudioAvailable=" + this.isAudioAvailable + ", isVideoAvailable=" + this.isVideoAvailable + ", volume=" + this.volume + '}';
    }
}
