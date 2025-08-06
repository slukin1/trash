package com.hbg.lib.network.hbg.core.bean;

import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.lib.network.hbg.core.bean.PersonalCenterInfo;
import java.io.Serializable;
import java.util.List;

public class DynamicDetailInfo implements Serializable {
    public List<NewFlashInformationCoinTags> coinTags;
    private int commentNum;
    private String content;
    private String contentText;
    private long createdTime;
    public String extend;
    private int focusStatus;

    /* renamed from: id  reason: collision with root package name */
    private String f70236id;
    private List<CommunityFeedInfo.imgListBean> imgList;
    private int isAlive;
    private int isSelf;
    private int isShowEventTag;
    private boolean isTrans;
    private int jumpType;
    private PersonalCenterInfo.LiveRoleInfo liveRoleInfo;
    private String oldContent;
    private String oldTitle;
    private DynamicDetailInfo parentDynamic;
    private int praiseNum;
    private int praiseStatus;
    private String richText;
    private String shareFrom;
    private String shareFromAvatar;
    private String shareFromLink;
    private String shareImage;
    private String shareLink;
    private String shareLinkTitle;
    private int shareType;
    private int shared;
    private int showTag;
    private int showTrans = 0;
    private int textType;
    private String title;
    private List<CommunityFeedInfo.Topic> topic;
    private int type;
    private PersonalCenterInfo.UcExtInfo ucExtInfo;
    private String uidUnique;
    private String userAvatar;
    private String userNickname;
    private int version;
    private String videoImage;
    private int visit;
    private CommonPkData vote;

    public int getCommentNum() {
        return this.commentNum;
    }

    public String getContent() {
        return this.content;
    }

    public String getContentText() {
        return this.contentText;
    }

    public long getCreatedTime() {
        return this.createdTime;
    }

    public String getExtend() {
        return this.extend;
    }

    public int getFocusStatus() {
        return this.focusStatus;
    }

    public String getId() {
        return this.f70236id;
    }

    public List<CommunityFeedInfo.imgListBean> getImgList() {
        return this.imgList;
    }

    public int getIsAlive() {
        return this.isAlive;
    }

    public int getIsSelf() {
        return this.isSelf;
    }

    public int getIsShowEventTag() {
        return this.isShowEventTag;
    }

    public int getJumpType() {
        return this.jumpType;
    }

    public PersonalCenterInfo.LiveRoleInfo getLiveRoleInfo() {
        return this.liveRoleInfo;
    }

    public String getOldContent() {
        return this.oldContent;
    }

    public String getOldTitle() {
        return this.oldTitle;
    }

    public DynamicDetailInfo getParentDynamic() {
        return this.parentDynamic;
    }

    public int getPraiseNum() {
        return this.praiseNum;
    }

    public int getPraiseStatus() {
        return this.praiseStatus;
    }

    public String getRichText() {
        return this.richText;
    }

    public String getShareFrom() {
        return this.shareFrom;
    }

    public String getShareFromAvatar() {
        return this.shareFromAvatar;
    }

    public String getShareFromLink() {
        return this.shareFromLink;
    }

    public String getShareImage() {
        return this.shareImage;
    }

    public String getShareLink() {
        return this.shareLink;
    }

    public String getShareLinkTitle() {
        return this.shareLinkTitle;
    }

    public int getShareType() {
        return this.shareType;
    }

    public int getShared() {
        return this.shared;
    }

    public int getShowTag() {
        return this.showTag;
    }

    public int getShowTrans() {
        return this.showTrans;
    }

    public int getTextType() {
        return this.textType;
    }

    public String getTitle() {
        return this.title;
    }

    public List<CommunityFeedInfo.Topic> getTopic() {
        return this.topic;
    }

    public int getType() {
        return this.type;
    }

    public PersonalCenterInfo.UcExtInfo getUcExtInfo() {
        return this.ucExtInfo;
    }

    public String getUidUnique() {
        return this.uidUnique;
    }

    public String getUserAvatar() {
        return this.userAvatar;
    }

    public String getUserNickname() {
        return this.userNickname;
    }

    public int getVersion() {
        return this.version;
    }

    public String getVideoImage() {
        return this.videoImage;
    }

    public int getVisit() {
        return this.visit;
    }

    public CommonPkData getVote() {
        return this.vote;
    }

    public boolean isShowTrans() {
        return 1 == this.showTrans;
    }

    public boolean isTrans() {
        return this.isTrans;
    }

    public void setCommentNum(int i11) {
        this.commentNum = i11;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setContentText(String str) {
        this.contentText = str;
    }

    public void setCreatedTime(long j11) {
        this.createdTime = j11;
    }

    public void setExtend(String str) {
        this.extend = str;
    }

    public void setFocusStatus(int i11) {
        this.focusStatus = i11;
    }

    public void setId(String str) {
        this.f70236id = str;
    }

    public void setImgList(List<CommunityFeedInfo.imgListBean> list) {
        this.imgList = list;
    }

    public void setIsAlive(int i11) {
        this.isAlive = i11;
    }

    public void setIsSelf(int i11) {
        this.isSelf = i11;
    }

    public void setIsShowEventTag(int i11) {
        this.isShowEventTag = i11;
    }

    public void setJumpType(int i11) {
        this.jumpType = i11;
    }

    public void setLiveRoleInfo(PersonalCenterInfo.LiveRoleInfo liveRoleInfo2) {
        this.liveRoleInfo = liveRoleInfo2;
    }

    public void setOldContent(String str) {
        this.oldContent = str;
    }

    public void setOldTitle(String str) {
        this.oldTitle = str;
    }

    public void setParentDynamic(DynamicDetailInfo dynamicDetailInfo) {
        this.parentDynamic = dynamicDetailInfo;
    }

    public void setPraiseNum(int i11) {
        this.praiseNum = i11;
    }

    public void setPraiseStatus(int i11) {
        this.praiseStatus = i11;
    }

    public void setRichText(String str) {
        this.richText = str;
    }

    public void setShareFrom(String str) {
        this.shareFrom = str;
    }

    public void setShareFromAvatar(String str) {
        this.shareFromAvatar = str;
    }

    public void setShareFromLink(String str) {
        this.shareFromLink = str;
    }

    public void setShareImage(String str) {
        this.shareImage = str;
    }

    public void setShareLink(String str) {
        this.shareLink = str;
    }

    public void setShareLinkTitle(String str) {
        this.shareLinkTitle = str;
    }

    public void setShareType(int i11) {
        this.shareType = i11;
    }

    public void setShared(int i11) {
        this.shared = i11;
    }

    public void setShowTag(int i11) {
        this.showTag = i11;
    }

    public void setShowTrans(int i11) {
        this.showTrans = i11;
    }

    public void setTextType(int i11) {
        this.textType = i11;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTopic(List<CommunityFeedInfo.Topic> list) {
        this.topic = list;
    }

    public void setTrans(boolean z11) {
        this.isTrans = z11;
    }

    public void setType(int i11) {
        this.type = i11;
    }

    public void setUcExtInfo(PersonalCenterInfo.UcExtInfo ucExtInfo2) {
        this.ucExtInfo = ucExtInfo2;
    }

    public void setUidUnique(String str) {
        this.uidUnique = str;
    }

    public void setUserAvatar(String str) {
        this.userAvatar = str;
    }

    public void setUserNickname(String str) {
        this.userNickname = str;
    }

    public void setVersion(int i11) {
        this.version = i11;
    }

    public void setVideoImage(String str) {
        this.videoImage = str;
    }

    public void setVisit(int i11) {
        this.visit = i11;
    }

    public void setVote(CommonPkData commonPkData) {
        this.vote = commonPkData;
    }
}
