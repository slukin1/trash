package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;
import java.util.List;

public class GroupMemberListInfo implements Serializable {
    private static final long serialVersionUID = 2936666304189952994L;
    private List<GroupMemberInfo> listData;
    private int managerAll;
    private int pageAll;
    private int pageNum;
    private int pageSize;
    private int total;

    public class GroupMemberInfo implements Serializable {
        private static final long serialVersionUID = -5882020791158098602L;
        private String account;
        private String avatar;
        private int isForbid;
        private String nickname;
        private int role;

        public GroupMemberInfo() {
        }

        public String getAccount() {
            return this.account;
        }

        public String getAvatar() {
            return this.avatar;
        }

        public int getIsForbid() {
            return this.isForbid;
        }

        public String getNickname() {
            return this.nickname;
        }

        public int getRole() {
            return this.role;
        }

        public void setAccount(String str) {
            this.account = str;
        }

        public void setAvatar(String str) {
            this.avatar = str;
        }

        public void setIsForbid(int i11) {
            this.isForbid = i11;
        }

        public void setNickname(String str) {
            this.nickname = str;
        }

        public void setRole(int i11) {
            this.role = i11;
        }
    }

    public List<GroupMemberInfo> getListData() {
        return this.listData;
    }

    public int getManagerAll() {
        return this.managerAll;
    }

    public int getPageAll() {
        return this.pageAll;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public int getTotal() {
        return this.total;
    }

    public void setListData(List<GroupMemberInfo> list) {
        this.listData = list;
    }

    public void setManagerAll(int i11) {
        this.managerAll = i11;
    }

    public void setPageAll(int i11) {
        this.pageAll = i11;
    }

    public void setPageNum(int i11) {
        this.pageNum = i11;
    }

    public void setPageSize(int i11) {
        this.pageSize = i11;
    }

    public void setTotal(int i11) {
        this.total = i11;
    }
}
