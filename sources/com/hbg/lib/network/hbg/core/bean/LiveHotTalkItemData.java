package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;
import java.util.List;

public class LiveHotTalkItemData extends LiveSquareBaseData {
    private static final long serialVersionUID = -8296047263829696103L;
    private String avatar;
    private String groupId;
    private String nickname;
    private String recommend;
    private String showId;
    private String title;
    private int userCount;
    private List<UserInfo> userList;

    public static class UserInfo implements Serializable {
        private static final long serialVersionUID = 7156647792405703824L;
        private String avatar;
        private String nickname;

        public String getAvatar() {
            return this.avatar;
        }

        public String getNickname() {
            return this.nickname;
        }

        public void setAvatar(String str) {
            this.avatar = str;
        }

        public void setNickname(String str) {
            this.nickname = str;
        }
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getRecommend() {
        return this.recommend;
    }

    public String getShowId() {
        return this.showId;
    }

    public String getTitle() {
        return this.title;
    }

    public int getUserCount() {
        return this.userCount;
    }

    public List<UserInfo> getUserList() {
        return this.userList;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public void setRecommend(String str) {
        this.recommend = str;
    }

    public void setShowId(String str) {
        this.showId = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUserCount(int i11) {
        this.userCount = i11;
    }

    public void setUserList(List<UserInfo> list) {
        this.userList = list;
    }
}
