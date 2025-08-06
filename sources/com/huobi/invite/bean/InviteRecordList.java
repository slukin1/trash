package com.huobi.invite.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class InviteRecordList implements Serializable {
    private static final long serialVersionUID = -1014032127428830098L;
    @SerializedName("record")
    private List<InviteRecordListItem> record;

    public List<InviteRecordListItem> getRecord() {
        return this.record;
    }

    public void setRecord(List<InviteRecordListItem> list) {
        this.record = list;
    }
}
