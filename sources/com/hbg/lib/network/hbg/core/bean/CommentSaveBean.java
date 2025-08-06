package com.hbg.lib.network.hbg.core.bean;

import com.hbg.lib.network.hbg.core.bean.PersonalCenterInfo;
import java.io.Serializable;
import java.util.List;

public class CommentSaveBean implements Serializable {
    public int commentNum;
    public String content;
    public long createTime;
    public String fromAvatar;
    public String fromNickname;
    public String fromUid;
    public String fromUniqueUid;
    public int hasImg;

    /* renamed from: id  reason: collision with root package name */
    public String f70230id;
    public List<CommentImageInfo> imgList;
    public int isAuthor;
    public PersonalCenterInfo.UcExtInfo ucExtInfo;
}
