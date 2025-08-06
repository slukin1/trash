package com.hbg.module.huobi.im.group.bean;

import java.util.List;

public final class GroupNoticeListEntity {
    private List<GroupNoticeItemEntity> listData;

    public final List<GroupNoticeItemEntity> getListData() {
        return this.listData;
    }

    public final void setListData(List<GroupNoticeItemEntity> list) {
        this.listData = list;
    }
}
