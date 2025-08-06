package com.huobi.invite.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class InviteReturnRecordList implements Serializable {
    private static final long serialVersionUID = 3488724683660290349L;
    @SerializedName("record")
    private List<InviteReturnRecordListItem> record;

    public List<InviteReturnRecordListItem> getRecord() {
        return this.record;
    }

    public void setRecord(List<InviteReturnRecordListItem> list) {
        this.record = list;
    }
}
