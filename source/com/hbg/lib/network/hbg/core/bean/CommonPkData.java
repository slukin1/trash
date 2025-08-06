package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;
import java.util.List;

public class CommonPkData implements Serializable {
    public List<CommonPkChoiceData> choiceList;
    public String content;
    public long duration;
    public long expireTime;
    public String topicId;
    public int topicType;
    public List<CommonPkChoiceUserInfoData> userInfo;
    public long voteId;
    public long voteNums;
    public int voteType;
}
