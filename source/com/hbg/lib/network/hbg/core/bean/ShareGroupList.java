package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;
import java.util.List;

public class ShareGroupList implements Serializable {
    private List<ShareGroup> shared;

    public static class ShareGroup implements Serializable {
        public String avatar;
        public String groupId;
        public int isShared;
        public String title;
        public String userCount;
    }

    public List<ShareGroup> getShared() {
        return this.shared;
    }

    public void setShared(List<ShareGroup> list) {
        this.shared = list;
    }
}
