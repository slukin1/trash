package com.hbg.lib.network.hbg.core.bean;

import com.hbg.lib.network.hbg.core.bean.PersonalCenterInfo;
import java.io.Serializable;
import java.util.List;

public class CommentInfo implements Serializable {
    public List<CommentInfo> children;
    public String content;
    public long createTime;
    public String fromAvatar;
    public String fromNickname;
    public PersonalCenterInfo.UcExtInfo fromUcExtInfo;
    public String fromUniqueUid;
    public int hasImg;

    /* renamed from: id  reason: collision with root package name */
    public String f70229id;
    public List<CommentImageInfo> imgList;
    public int isAuthor;
    public int isMore;
    public boolean isTrans;
    public String oldContent;
    public String parentComment;
    public String parentId;
    public int parseNums;
    public int parseStatus;
    public int replyNum;
    public int selfComment;
    public String sortOrderScore;
    public String toNickname;
    public String toUid;
}
