package com.huobi.invite.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class InviteReturnRank implements Serializable {
    private static final long serialVersionUID = 5695408196672910575L;
    @SerializedName("latest-date")
    private Long latestDate;
    @SerializedName("rank-list")
    private List<InviteReturnDetail> rankList;

    public Long getLatestDate() {
        return this.latestDate;
    }

    public List<InviteReturnDetail> getRankList() {
        return this.rankList;
    }

    public void setLatestDate(Long l11) {
        this.latestDate = l11;
    }

    public void setRankList(List<InviteReturnDetail> list) {
        this.rankList = list;
    }
}
