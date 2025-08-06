package com.hbg.lib.network.hbg.core.bean;

import com.hbg.lib.network.hbg.core.bean.LiveGroupUserListData;
import java.io.Serializable;
import java.util.List;

public class SearchLiveGroupUserList implements Serializable {
    private List<LiveGroupUserListData.GroupUser> listData;

    public List<LiveGroupUserListData.GroupUser> getListData() {
        return this.listData;
    }

    public void setListData(List<LiveGroupUserListData.GroupUser> list) {
        this.listData = list;
    }
}
