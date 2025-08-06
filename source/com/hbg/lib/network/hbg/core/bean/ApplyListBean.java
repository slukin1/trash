package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;
import java.util.ArrayList;

public class ApplyListBean implements Serializable {
    public ArrayList<ApplyUser> listData;

    public static class ApplyUser implements Serializable {
        public String avatar;
        public String countryName;
        public long createTime;
        public String groupName;

        /* renamed from: id  reason: collision with root package name */
        public String f70223id;
        public String nickname;
        public String reason;
        public int status;
        public String uid;
    }
}
