package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;
import java.util.List;

public class PersonalCenterInfo implements Serializable {
    private static final long serialVersionUID = 1244856022070727452L;
    private int accessChat;
    private String account;
    private String avatar;
    private int dynamicNum;
    private int fansNum;
    private int focusNum;
    private int focusStatus;
    private String intro;
    private int isAlive;
    private int isSelf;
    private LiveRoleInfo liveRoleInfo;
    private String nickname;
    private int praiseForMe;
    private List<Integer> roles;
    private List<TabInfo> tabList;
    private String tag;
    private UcExtInfo ucExtInfo;
    private String uidUnique;

    public static class LiveRoleInfo implements Serializable {
        public String groupId;
        public int hasGroup;
        public int hasJion;
        public int isForbidden;
        public int liveRole;
    }

    public static class TabInfo implements Serializable {
        private static final long serialVersionUID = -149138284778869782L;

        /* renamed from: id  reason: collision with root package name */
        private int f70263id;
        private String title;

        public TabInfo(int i11, String str) {
            this.f70263id = i11;
            this.title = str;
        }

        public int getId() {
            return this.f70263id;
        }

        public String getTitle() {
            return this.title;
        }

        public void setId(int i11) {
            this.f70263id = i11;
        }

        public void setTitle(String str) {
            this.title = str;
        }
    }

    public static class UcExtInfo implements Serializable {
        public String frameUrl;
        public String headImage;
        public String headImageType;
        public String nftRarity;
        public String nickname;
        public String showExtBusinessTag;
    }

    public int getAccessChat() {
        return this.accessChat;
    }

    public String getAccount() {
        return this.account;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int getDynamicNum() {
        return this.dynamicNum;
    }

    public int getFansNum() {
        return this.fansNum;
    }

    public int getFocusNum() {
        return this.focusNum;
    }

    public int getFocusStatus() {
        return this.focusStatus;
    }

    public String getIntro() {
        return this.intro;
    }

    public int getIsAlive() {
        return this.isAlive;
    }

    public int getIsSelf() {
        return this.isSelf;
    }

    public LiveRoleInfo getLiveRoleInfo() {
        return this.liveRoleInfo;
    }

    public String getNickname() {
        return this.nickname;
    }

    public int getPraiseForMe() {
        return this.praiseForMe;
    }

    public List<Integer> getRoles() {
        return this.roles;
    }

    public List<TabInfo> getTabList() {
        return this.tabList;
    }

    public String getTag() {
        return this.tag;
    }

    public UcExtInfo getUcExtInfo() {
        return this.ucExtInfo;
    }

    public String getUidUnique() {
        return this.uidUnique;
    }

    public void setAccessChat(int i11) {
        this.accessChat = i11;
    }

    public void setAccount(String str) {
        this.account = str;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setDynamicNum(int i11) {
        this.dynamicNum = i11;
    }

    public void setFansNum(int i11) {
        this.fansNum = i11;
    }

    public void setFocusNum(int i11) {
        this.focusNum = i11;
    }

    public void setFocusStatus(int i11) {
        this.focusStatus = i11;
    }

    public void setIntro(String str) {
        this.intro = str;
    }

    public void setIsAlive(int i11) {
        this.isAlive = i11;
    }

    public void setIsSelf(int i11) {
        this.isSelf = i11;
    }

    public void setLiveRoleInfo(LiveRoleInfo liveRoleInfo2) {
        this.liveRoleInfo = liveRoleInfo2;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public void setPraiseForMe(int i11) {
        this.praiseForMe = i11;
    }

    public void setRoles(List<Integer> list) {
        this.roles = list;
    }

    public void setTabList(List<TabInfo> list) {
        this.tabList = list;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public void setUcExtInfo(UcExtInfo ucExtInfo2) {
        this.ucExtInfo = ucExtInfo2;
    }

    public void setUidUnique(String str) {
        this.uidUnique = str;
    }
}
