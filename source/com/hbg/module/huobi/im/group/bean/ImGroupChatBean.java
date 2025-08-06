package com.hbg.module.huobi.im.group.bean;

import java.io.Serializable;
import java.util.List;

public final class ImGroupChatBean implements Serializable {
    private List<ImGroupChatItemBean> listData;
    private int pageAll;
    private int pageNum;
    private int pageSize;
    private int total;

    public final List<ImGroupChatItemBean> getListData() {
        return this.listData;
    }

    public final int getPageAll() {
        return this.pageAll;
    }

    public final int getPageNum() {
        return this.pageNum;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    public final int getTotal() {
        return this.total;
    }

    public final void setListData(List<ImGroupChatItemBean> list) {
        this.listData = list;
    }

    public final void setPageAll(int i11) {
        this.pageAll = i11;
    }

    public final void setPageNum(int i11) {
        this.pageNum = i11;
    }

    public final void setPageSize(int i11) {
        this.pageSize = i11;
    }

    public final void setTotal(int i11) {
        this.total = i11;
    }
}
