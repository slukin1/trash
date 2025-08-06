package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;
import java.util.List;

public class NoticeManageResp implements Serializable {
    private static final long serialVersionUID = 3168991814779041261L;
    private String explain;

    /* renamed from: id  reason: collision with root package name */
    private long f70262id;
    private String labelName;
    private String messageType;
    private long parentId;
    private long sortNo;
    private List<NoticeManageResp> subList;
    private String subState;
    private String title;

    public String getExplain() {
        return this.explain;
    }

    public int getId() {
        return (int) this.f70262id;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public String getMessageType() {
        return this.messageType;
    }

    public long getParentId() {
        return this.parentId;
    }

    public long getSortNo() {
        return this.sortNo;
    }

    public List<NoticeManageResp> getSubList() {
        return this.subList;
    }

    public String getSubState() {
        return this.subState;
    }

    public String getTitle() {
        return this.title;
    }

    public void setExplain(String str) {
        this.explain = str;
    }

    public void setId(long j11) {
        this.f70262id = j11;
    }

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public void setMessageType(String str) {
        this.messageType = str;
    }

    public void setParentId(long j11) {
        this.parentId = j11;
    }

    public void setSortNo(long j11) {
        this.sortNo = j11;
    }

    public void setSubList(List<NoticeManageResp> list) {
        this.subList = list;
    }

    public void setSubState(String str) {
        this.subState = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
