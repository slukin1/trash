package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;
import java.util.List;

public class GroupUserListData implements Serializable {
    private int forbidAll;
    private List<GroupUserItemData> listData;
    private int pageAll;
    private int pageNum;
    private int pageSize;
    private int total;

    public int getForbidAll() {
        return this.forbidAll;
    }

    public List<GroupUserItemData> getListData() {
        return this.listData;
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

    public void setForbidAll(int i11) {
        this.forbidAll = i11;
    }

    public void setListData(List<GroupUserItemData> list) {
        this.listData = list;
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
